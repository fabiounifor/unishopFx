/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import controller.ControllerCaixa;
import controller.ControllerConfiguracao;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerGarcom;
import controller.ControllerItensPedidoMesa;
import controller.ControllerProdutos;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import controller.ControllerTributacaoEstadual;
import controller.ControllerTributacaoFederal;
import controller.ControllerCstPiscofins;
import controller.ControllerCsosn;
import controller.ControllerCsosnFederal;
import controller.ControllerCFOP;
import java.awt.Font;
import java.awt.font.TextAttribute;
import model.ModelCaixa;
import model.ModelClienteCidadeEstado;
import model.ModelConfig;
import model.ModelEmpresaCidadeEstado;
import model.ModelGarcom;
import model.ModelItensPedidoMesa;
import model.ModelItensPedidoMesaAtivo;
import model.ModelMesas;
import model.ModelProdutos;
import model.ModelSessaoUsuario;
import model.ModelVendas;
import model.ModelVendasProdutos;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;
import util.GerarCupom;
import util.Impressora;
import util.ManipularXML;
import java.io.IOException;
import java.net.URL;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import model.ModelCliente;
import model.ModelPagamento;
import model.ModelVendasProdutosTabela;
import org.controlsfx.control.textfield.TextFields;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */


public class lancaMesa extends Application implements Initializable{
    
    @FXML TableView TabelaMesas;
    @FXML TableColumn<RadioButton, RadioButton> mesa;
    @FXML TableView <ModelItensPedidoMesaAtivo> TabelaProdutosMesa;
    @FXML TableColumn<ModelItensPedidoMesaAtivo, String> produtoTabela;
    @FXML TableColumn<ModelItensPedidoMesaAtivo, String> quantTabela;
    @FXML TableColumn<ModelItensPedidoMesaAtivo, String> precoTabela;
    @FXML TextField tfGarcon;
    @FXML TextField tfDatahora;
    @FXML TextField tfMesaselecionada;
    @FXML TextField tfProduto;
    @FXML TextField tfQuantproduto;
    @FXML TextField tfValproduto;
    @FXML TextField tfTotalmesa;
    @FXML Button btImprimir;
    @FXML Button btFechamesa;
    @FXML Button btTransferirMesa;
    @FXML FlowPane painelMesasFlow;
    @FXML Button mesaBotao;
    double valorUnitario = 0;
    int codigoProduto;
    int quantidadeMesas = 0;
    int Caixa;
    int quantidadeImprimir;
    int modeloImprimir;
    int modeloImprimirMesa;
    String impressoraPDV;
    ArrayList<ModelProdutos> listaTabela; 
    ArrayList<TextField> campos = new ArrayList<>();
       
    ControllerTributacaoEstadual controllerTributacaoEstadual = new ControllerTributacaoEstadual();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerCstPiscofins controllerCstPiscofins = new ControllerCstPiscofins();
    ControllerConfiguracao controllerConfiguracao = new ControllerConfiguracao();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerCsosn controllerCsosn = new ControllerCsosn();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ObservableList<ModelItensPedidoMesa> listadeTabelaprodutos;
    ObservableList<ModelItensPedidoMesaAtivo> listadeTabelaprodutosativos;
    ObservableList<RadioButton> listadeTabelabotoes;
    ArrayList<ModelProdutos> listaProdutoses = new ArrayList<>();
    ArrayList<ModelItensPedidoMesaAtivo> listaProdutosativos = new ArrayList<>();
    ArrayList<String> listaProdutos = new ArrayList<>();
    ArrayList<String> listaGarcons = new ArrayList<>();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelPagamento modelPagamento = new ModelPagamento();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelItensPedidoMesa modelItensPedidoMesa = new ModelItensPedidoMesa();
    ControllerGarcom controllerGarcon = new ControllerGarcom();
    ControllerItensPedidoMesa controllerItensPedidoMesa = new ControllerItensPedidoMesa();
    ArrayList<ModelItensPedidoMesa> listaModelItensPedidoMesas = new ArrayList<>();
    ArrayList<ModelMesas> listaModelMesases = new ArrayList<>();
    ModelMesas modelMesas = new ModelMesas();
    ModelGarcom modelGarcom = new ModelGarcom();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ArrayList<ModelItensPedidoMesa> listaItemTransferir = new ArrayList<>();
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ModelVendas modelVendas = new ModelVendas();
    ControllerFormaPagamento controllerFormaPagamento = new ControllerFormaPagamento();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    public int codigoVenda;
    ArrayList<Button> listadeBotoes = new ArrayList<>();
    int mesaParaImprimir;
    String nomeImpressora;
    BLMascaras bLMascaras = new BLMascaras();
    ArrayList<Integer> listaMesasOcupadas = new ArrayList<>();
    ModelConfig modelConfig = new ModelConfig();
    ManipularXML manipularXML = new ManipularXML();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ArrayList<ModelVendasProdutos> listaModelVendasProdutoses = new ArrayList<>();
    ModelEmpresaCidadeEstado modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ArrayList<ModelGarcom> listaModelGarcoms = new ArrayList<>();
    ControllerGarcom controllerGarcom = new ControllerGarcom();
    final ImageView imageOcupado = new ImageView(new Image("imagens/icons 30/mesa-de-restaurante-30.png"));
    final ImageView imageLivre = new ImageView(new Image("imagens/icons 30/mesa-30.png"));
    
    int codigoGarcom;
    int numeroCaixa = 1;
    
    @Override
    public void start(Stage mesaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/mesasLancamento.fxml"));        
        Parent raiz = loader.load();   
        mesaStage.setScene(new Scene(raiz));
        mesaStage.initModality(Modality.APPLICATION_MODAL);
        mesaStage.show();
              
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
            }
    
    public void recuperarVenda(int codigoVenda){
        ModelVendas mvRecupera = new ModelVendas();
        ModelCliente mcRecupera = new ModelCliente();
        ArrayList<ModelVendasProdutos> mpRecupera = new ArrayList<>();
        mvRecupera = controllerVendas.getVendasClienteController(codigoVenda);
        mpRecupera = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
        //nomeCliente.setText(mcRecupera.getNome());
        tfTotalmesa.setText(mvRecupera.getValorTotal().toString());
        //retornarClientePeloNome();
        //TabelaProdutosMesa.getItems().addAll(recuperarTabela(mpRecupera));
        
    }
    
    private ModelVendasProdutosTabela recuperarTabela(ArrayList<ModelVendasProdutos> produtosVendas){
        ModelVendasProdutosTabela mvptRecupera = new ModelVendasProdutosTabela();
        for(int i=0; i<produtosVendas.size(); i++){
            mvptRecupera.setProduto(produtosVendas.get(i).getNomeProduto());
            mvptRecupera.setOrdem(produtosVendas.get(i).getOrdem());
            mvptRecupera.setQuantidade(produtosVendas.get(i).getQuantidade());
            mvptRecupera.setValorUnitario(produtosVendas.get(i).getValorUnitario());
            mvptRecupera.setValorTotal(produtosVendas.get(i).getValorTotal());
        }
       return mvptRecupera; 
    }
    public void listaEnter(){
        
        campos.add(tfProduto);
        campos.add(tfQuantproduto);
        campos.add(tfValproduto);
           
       }
    
    private void habilitarCampos() {
        tfProduto.setFocusTraversable(true);
        tfQuantproduto.setFocusTraversable(true);
        tfValproduto.setFocusTraversable(true);
        tfDatahora.setFocusTraversable(false);
        painelMesasFlow.setFocusTraversable(false);
        btTransferirMesa.setFocusTraversable(false);
        tfGarcon.setFocusTraversable(false);
        tfTotalmesa.setFocusTraversable(false);
        tfTotalmesa.setText("0.0");
        TabelaProdutosMesa.setFocusTraversable(false);
        btFechamesa.setFocusTraversable(false);
        btImprimir.setFocusTraversable(false);
        TabelaProdutosMesa.getItems().clear();
    
    }
    private void limpaTelaNovoProduto() {
        tfProduto.setText("");
        tfQuantproduto.setText("1");
        tfValproduto.setText("0,00");
        
          
    }
       
   
    public void setNextFocus(TextField tfProduto, TextField tfQuantproduto, TextField tfValproduto) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    }
    private boolean cadastrarVendaMesa() {
        try {
            int numeroMesa = Integer.parseInt(tfMesaselecionada.getText());
           if (TabelaProdutosMesa.getItems().size()<1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("Você deve adicionar ao menos um produto para salvar!");
                alert.show();
                return false;
            } else {
                listaModelItensPedidoMesas = new ArrayList<>();
                 
             //   for (int i = 0; i < TabelaProdutosMesa.getItems().size(); i++) {
                    modelItensPedidoMesa = new ModelItensPedidoMesa();
                    modelItensPedidoMesa.setCodigoMesa(numeroMesa);
                    modelItensPedidoMesa.setCodigoProduto(Integer.parseInt(tfProduto.getText().substring(0, 3)));
                    modelItensPedidoMesa.setQuantidade(Float.parseFloat(tfQuantproduto.getText()));
                    modelItensPedidoMesa.setObservacao("1");
                    modelItensPedidoMesa.setOpcoesEscolhidas("");
                    modelItensPedidoMesa.setHora(bLMascaras.retornarHora());
                    modelItensPedidoMesa.setCodigoGarcom(Integer.parseInt(tfGarcon.getText(0, 2)));
                    modelItensPedidoMesa.setStatusPedido("Em aberto");
                    listaModelItensPedidoMesas.add(modelItensPedidoMesa);
                     
              //  }
                
                
                modelProdutos.setListaModelProdutoses(listaProdutoses);

                //exclui registros anteriores se ouver
               // controllerItensPedidoMesa.excluirItensPedidoMesaController(modelItensPedidoMesa.getCodigoMesa());
                //salvar
                controllerItensPedidoMesa.salvarItensPedidoMesaController(listaModelItensPedidoMesas);
                return true;
            }
        } catch (Exception e) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("Você deve adicionar ao menos um produto para salvar!");
        }       
       return true;
    }

    private boolean preenchertabelaprodutos(){
         
        try {
            int numeroMesa = Integer.parseInt(this.tfMesaselecionada.getText());

            //exlui dados anteriores
            controllerItensPedidoMesa.excluirItensPedidoMesaController(numeroMesa);
            if (numeroMesa < 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Nenhuma mesa foi selecionada");
                
            } else {
                listaModelItensPedidoMesas = new ArrayList<>();

                for (int i = 0; i < listaModelItensPedidoMesas.size(); i++) {
                    modelItensPedidoMesa = new ModelItensPedidoMesa();
                    modelItensPedidoMesa.setCodigoMesa(numeroMesa);
                    modelItensPedidoMesa.setCodigoProduto(listaModelItensPedidoMesas.get(i).getCodigo());
                    modelItensPedidoMesa.setQuantidade(listaModelItensPedidoMesas.get(i).getQuantidade());
                    modelItensPedidoMesa.setObservacao(listaModelItensPedidoMesas.get(i).getObservacao());
                    modelItensPedidoMesa.setOpcoesEscolhidas(listaModelItensPedidoMesas.get(i).getOpcoesEscolhidas());
                    modelItensPedidoMesa.setHora(bLMascaras.retornarHora());
                    modelItensPedidoMesa.setCodigoGarcom(Integer.parseInt(tfGarcon.getText(0,2)));
                    modelItensPedidoMesa.setStatusPedido("Em aberto");
                    
                    listaModelItensPedidoMesas.add(modelItensPedidoMesa);
                }
                

                modelProdutos.setListaModelProdutoses(listaProdutoses);
//                TabelaProdutosMesa.getItems().addAll(listaModelItensPedidoMesas);

                //exclui registros anteriores se houver
                controllerItensPedidoMesa.excluirItensPedidoMesaController(modelItensPedidoMesa.getCodigoMesa());
                //salvar
                controllerItensPedidoMesa.salvarItensPedidoMesaController(listaModelItensPedidoMesas);
                return true;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Você deve adicionar ao menos um produto para salvar!");
            return false;
        }
        return true;
    }
    private void carregarProdutosnaTabela() {
        
        ModelItensPedidoMesaAtivo modelatualizaTabela = new ModelItensPedidoMesaAtivo();
               listaProdutoses = controllerProdutos.getListaProdutosController();
        for (int i = 0; i < listaProdutoses.size(); i++) {
            if((Integer.parseInt(tfProduto.getText().substring(0,3))) == (listaProdutoses.get(i).getCodigo())){ 
                modelatualizaTabela.setCodigoProduto(Integer.parseInt(tfProduto.getText().substring(0,3)));
                modelatualizaTabela.setNomeProduto((tfProduto.getText().substring(4)));
                modelatualizaTabela.setValor(Float.parseFloat(tfValproduto.getText()));
                modelatualizaTabela.setQuantidade(Integer.parseInt(tfQuantproduto.getText()));
                 
            }    
            
        }
        TabelaProdutosMesa.getItems().addAll(modelatualizaTabela);
        

    }
    private void carregarProdutosList() {
        ModelItensPedidoMesaAtivo modelatualiza = new ModelItensPedidoMesaAtivo();
        listaProdutoses.clear();
        listaProdutoses = controllerProdutos.getListaProdutosController();
        for (int i = 0; i < listaProdutoses.size(); i++) {
            if((Integer.parseInt(tfProduto.getText().substring(0,3))) == (listaProdutoses.get(i).getCodigo())){ 
                modelatualiza.setCodigoProduto(Integer.parseInt(tfProduto.getText().substring(0,3)));
                modelatualiza.setNomeProduto((tfProduto.getText().substring(4)));
                modelatualiza.setValor(Float.parseFloat(tfValproduto.getText()));
                modelatualiza.setQuantidade(Integer.parseInt(tfQuantproduto.getText()));
                modelatualiza.setCodigoGarcom(Integer.parseInt(tfGarcon.getText(0,2)));
                modelatualiza.setStatusPedido("Em aberto");
                modelatualiza.setCodigoMesa(Integer.parseInt(tfMesaselecionada.getText()));
            }
        }
     
        

    }
    private void listaGarcom() {
        listaModelGarcoms = controllerGarcom.getListaGarcomController();
        String cod;
        for (int i = 0; i < listaModelGarcoms.size(); i++) {
            if (listaModelGarcoms.get(i).getCodigo()>9 && listaModelGarcoms.get(i).getCodigo()<100){
                cod = (""+listaModelGarcoms.get(i).getCodigo());
            }else{ 
                cod = ("0"+listaModelGarcoms.get(i).getCodigo());
            }
            listaGarcons.add(cod + "-" + listaModelGarcoms.get(i).getNome());
            
            
            listaModelGarcoms.get(i).getNome();
        }
    }
    
     private void criarlistaProdutos() {
        listaProdutoses = controllerProdutos.getListaProdutosAtivosController();
        String cod ;
        for (int i = 0; i < listaProdutoses.size(); i++) {
            if (listaProdutoses.get(i).getCodigo()< 10){
                cod = ("00"+listaProdutoses.get(i).getCodigo());
            }else if (listaProdutoses.get(i).getCodigo()>9 && listaProdutoses.get(i).getCodigo()<100){
                cod = ("0"+listaProdutoses.get(i).getCodigo());
            }else{ 
                cod = (""+listaProdutoses.get(i).getCodigo());
            }
            listaProdutos.add(cod + "-" + listaProdutoses.get(i).getNome());
        }
    }
     
     private void valorProduto(){
          float soma = (Float.parseFloat(tfTotalmesa.getText()));
        tfValproduto.setText(String.valueOf((Float.parseFloat(tfQuantproduto.getText())) * (valorUnitario)));
        tfTotalmesa.setText(String.valueOf(soma + (Float.parseFloat(tfValproduto.getText()))));
        tfValproduto.requestFocus();
    }

     private int retornarcodigoprodutoPeloNome(String nome) {
        //INICIO recupera o nome
       int codigo;
        modelProdutos = controllerProdutos.getProdutosController((tfProduto.getText().substring(4)));
        valorUnitario = modelProdutos.getValor();
        this.tfQuantproduto.setText("1");
        //FIM recupera o nome
       tfTotalmesa.setText(String.valueOf((Double.parseDouble(tfQuantproduto.getText())) * valorUnitario)) ;
       codigoProduto = (modelProdutos.getCodigo());
       tfValproduto.setText(String.valueOf(valorUnitario));
       codigo = codigoProduto;
              return codigo;
    }

     
     private void retornarprodutoPeloNome() {
        //INICIO recupera o nome
       
        modelProdutos = controllerProdutos.getProdutosController((tfProduto.getText().substring(4)));
        valorUnitario = modelProdutos.getValor();
        this.tfQuantproduto.setText("1");
        //FIM recupera o nome
       codigoProduto = (modelProdutos.getCodigo());
       tfValproduto.setText(String.valueOf(valorUnitario));
              
    }

     
     
    
    private void retornarGarcom() {
      codigoGarcom = (Integer.parseInt(tfGarcon.getText().substring(0, 2)));
    }
    
    public boolean salvarVenda(float ValorTotal, String mesaselecionada, int codGarcon) {
        
        tfMesaselecionada.setText(mesaselecionada);
        
        recarregarMesa(Integer.parseInt(mesaselecionada));
         
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar hora = Calendar.getInstance();
        listaModelVendas = new ArrayList<>();
        listaProdutoses = new ArrayList<>();
        int codigoProduto;
        float quantidade = 0;
        for(int i = 0; i < listaProdutosativos.size() ;i++){
            
            modelVendas = new ModelVendas();
            modelProdutos = new ModelProdutos();
            modelVendas.setClientesCodigo(1);
            modelVendas.setDesconto(0.0f);
            modelVendas.setTaxaEntrega(0f);
            modelVendas.setValorTotal(ValorTotal);
            modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
            modelVendas.setTipo(1);
            modelVendas.setCaixa(Caixa);
            modelVendas.setMesa(Integer.parseInt(tfMesaselecionada.getText()));
            modelVendas.setGarcon(codGarcon);
            try {
                modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                modelVendas.setHoraVenda(dateFormat.format(hora.getTime()));
            } catch (Exception ex) {
                
            }
            int mesaLocal = (listaModelItensPedidoMesas.get(i).getCodigoMesa());
            codigoProduto = (listaModelItensPedidoMesas.get(i).getCodigoProduto());
            
            modelVendas.setProdutosCodigo(codigoProduto);
            modelVendas.setQuantidade(listaModelItensPedidoMesas.get(i).getQuantidade());
            modelVendas.setTipoPagamento(1);
            modelVendas.setValor(listaProdutosativos.get(i).getValor());
            modelProdutos.setCodigo(codigoProduto);
            quantidade = (Float.parseFloat(String.valueOf(listaProdutosativos.get(i).getValor())));
            modelProdutos.setEstoque(quantidade);
            modelProdutos.setValor(listaProdutosativos.get(i).getValor());
            modelVendas.setIcmsCst(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaProdutosativos.get(i).getCodigo()).getTribEst()).getIdcsosn()).getNumero()));
            modelVendas.setIpiCst(String.valueOf(controllerCsosnFederal.getCsosnFederalController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaProdutosativos.get(i).getCodigo()).getTribFed()).getIdIpi()).getNumero()));
            modelVendas.setPisCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaProdutosativos.get(i).getCodigo()).getTribFed()).getIdPisCofins()).getNumero()));
            modelVendas.setCofinsCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaProdutosativos.get(i).getCodigo()).getTribFed()).getIdPisCofins()).getNumero()));
            modelVendas.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaProdutosativos.get(i).getCodigo()).getTribEst()).getIdcfop()).getCfop()));
            listaModelVendas.add(modelVendas);
            listaProdutoses.add(modelProdutos);
            
            controllerItensPedidoMesa.excluirItensPedidoMesaController(mesaLocal);
            
        }
        modelVendas.setListamModelVendases(listaModelVendas);
        modelProdutos.setListaModelProdutoses(listaProdutoses);
        TabelaProdutosMesa.getItems();
        

        //salvar venda
        
        codigoVenda = controllerVendas.salvarVendasController(modelVendas);
        if (codigoVenda > 0) {
            modelVendas.setCodigo(codigoVenda);
            //da baixa no estoque
            for (int i = 0; i < modelProdutos.getListaModelProdutoses().size(); i++) {
                codigoProduto = modelProdutos.getListaModelProdutoses().get(i).getCodigo();
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - modelProdutos.getListaModelProdutoses().get(i).getEstoque();
                controllerProdutos.atualizarProdutosQuantidadeUmController(codigoProduto, quantidade);
            
            }

            //salvar lista de produtos
            controllerVendas.salvarVendasProdutosController(modelVendas);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("REGISTRO OK");
            alert.setContentText("Registro gravado com sucesso!");
            popularTabela(quantidadeMesas);
            

            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setContentText("Erro ao gravar os dados!");
            return false;
        }
    }

       /**
     * Imprimir cupom
     */
    private void imprimirCupomPDV(int pCodigo) {
        try {
            int mesa = Integer.parseInt(tfMesaselecionada.getText());
            int garcon = Integer.parseInt(tfGarcon.getText(0,2));
            float total = (Float.parseFloat(tfTotalmesa.getText()));
            //definir impressora
            String nomeImpressora = impressoraPDV;
            //gerar dados e imprimir
            String textoImprimir = new GerarCupom().gerarCupomPDV(mesa,garcon ,total);
            //formatar texto
            AttributedString string = new AttributedString(textoImprimir);
            string.addAttribute(TextAttribute.FONT, new Font("FreeMono", Font.ITALIC, 17));
            
            //enviar para impressora
            Impressora.imprimir(nomeImpressora, textoImprimir);
            marcarComoImpresso(mesa);
        } catch (IOException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void imprimirCupomPDF(){
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // vizualizar vendas;
                synchronized(this){
                    if (Integer.parseInt(tfGarcon.getText(0,2)) == 1){
                    controllerVendas.vizualizarMesaControllerSemTaxa(Integer.parseInt(tfMesaselecionada.getText()));
                    int mesaLocal = Integer.parseInt(tfMesaselecionada.getText());
                    marcarComoImpresso(mesaLocal);
                }else{
                    controllerVendas.vizualizarMesaController(Integer.parseInt(tfMesaselecionada.getText()));
                    int mesaLocal = Integer.parseInt(tfMesaselecionada.getText());
                    marcarComoImpresso(mesaLocal);
                }
                carregando.dispose();
                }
                
            }
        };
        t.start();
    }
    
    private void marcarComoImpresso(int mesaImpressa){
    ModelItensPedidoMesa mipm = new ModelItensPedidoMesa();
        ArrayList<ModelItensPedidoMesa> itensMesa = controllerItensPedidoMesa.getListaItensPedidoMesaController(mesaImpressa);
    for (int i = 0 ; i < itensMesa.size(); i++){
        mipm.setCodigo(itensMesa.get(i).getCodigo());
        mipm.setCodigoGarcom(itensMesa.get(i).getCodigoGarcom());
        mipm.setCodigoMesa(itensMesa.get(i).getCodigoMesa());
        mipm.setCodigoProduto(itensMesa.get(i).getCodigoProduto());
        mipm.setHora(itensMesa.get(i).getHora());
        mipm.setObservacao(itensMesa.get(i).getObservacao());
        mipm.setStatusPedido(itensMesa.get(i).getStatusPedido());
        mipm.setStatusNotificacao(1);
        controllerItensPedidoMesa.atualizarStatusImpressoController(mipm);
    }
        
    }

    //adicionar valor ao caixa
    
    private void adicionarValorCaixa() {
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        
        
        if (modelVendas.getTipoPagamento() == 1) {
            valorDinheiro = modelVendas.getValorTotal();
            modelCaixa.setDinheiro(modelCaixa.getDinheiro() + valorDinheiro);
        } else if (modelVendas.getTipoPagamento() == 2) {
            valorCartao = modelVendas.getValorTotal();
            modelCaixa.setCartao(modelCaixa.getCartao() + valorCartao);
        } else if (modelVendas.getTipoPagamento() == 3) {
            valorCheque = modelVendas.getValorTotal();
            modelCaixa.setCheque(modelCaixa.getCheque() + valorCheque);
        } else if (modelVendas.getTipoPagamento() == 4) {
            valorVale = modelVendas.getValorTotal();
            modelCaixa.setConvenio(modelCaixa.getConvenio() + valorVale);
        }
        controllerCaixa.atualizarCaixaController(modelCaixa);
    }

    //zerar o caixa
    private void zerarValoresCaixa() {
        valorCartao = 0;
        valorCheque = 0;
        valorDinheiro = 0;
        valorVale = 0;
    }

    //soma valor total da conta do cliente e seta no campo total
    private double somaValorTotal(float pQuantidade, double pValor) {
        return (pQuantidade * pValor);
    }

    private void excluirProduto(){
    
    int linhaExcluir = TabelaProdutosMesa.getSelectionModel().getFocusedIndex();
    int codigoExcluir  = TabelaProdutosMesa.getItems().get(linhaExcluir).getCodigoProduto();
    int mesaExcluir = TabelaProdutosMesa.getItems().get(linhaExcluir).getCodigoMesa();
    
    controllerItensPedidoMesa.excluirItemUnicoPedidoMesaController(codigoExcluir, mesaExcluir);
    TabelaProdutosMesa.getItems().remove(linhaExcluir);
    
    //listaProdutoses.remove(linhaExcluir);
      
    saidaTabela();
    carregarProdutosList();
    carregarProdutosnaTabela();
    irPraMesa();
}

private void saidaTabela() {
        tfQuantproduto.setText("1");
        tfTotalmesa.setText("0.0");
        TabelaProdutosMesa.setFocusTraversable(false);
        tfProduto.requestFocus();
              
    }

private void escolherLinha()  {
        TabelaProdutosMesa.setFocusTraversable(true);
        TabelaProdutosMesa.requestFocus();
}

private void cincoseg(){
final Timeline timeline = new Timeline();
 
 timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),ev -> {
        popularTabela(quantidadeMesas);
    }));
 timeline.setCycleCount(Animation.INDEFINITE);
 timeline.setAutoReverse(true);
 timeline.play();      
}  


/*private void cincoseg555(){
       Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
        popularTabela();
    }));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
} */ 
    
    private void irPraMesa() {
        // TODO add your handling code here:  
        String codGarconLocal;
        limpaTelaNovoProduto();
        int mesa = 0;
        String mesaString;
        for (int i = 0; i < listadeBotoes.size(); i++) {
            if (listadeBotoes.get(i).isFocused()) {
                mesaString = listadeBotoes.get(i).getText();
                mesaString = mesaString.trim();
                mesa = Integer.parseInt(mesaString);
            }
        }
        if (mesa == 0) {
                 
        } else {
            
         if (controllerItensPedidoMesa.getItensPedidoMesaMesaController(mesa).getCodigoGarcom() > 0){
             int codGarcon = controllerItensPedidoMesa.getItensPedidoMesaMesaController(mesa).getCodigoGarcom();
             if (codGarcon < 10){
                 codGarconLocal = ("0"+codGarcon+"");
             }else{
                 codGarconLocal = (String.valueOf(codGarcon));
             }
             tfGarcon.setText( codGarconLocal + "-" + controllerGarcom.getGarcomController(codGarcon).getNome());
             tfGarcon.requestFocus();
         }else{
            tfGarcon.requestFocus();
         }
            TabelaProdutosMesa.getItems().clear();
            listaProdutosativos.clear();
            tfTotalmesa.setText("0.0");
            
            this.tfMesaselecionada.setText(mesa + "");
            //retornar todos os produtos do pedido da mesa
            listaModelItensPedidoMesas = controllerItensPedidoMesa.getListaItensPedidoMesaController(mesa);
          //ModelItensPedidoMesaAtivo modelItensPedidoMesaAtivo = new ModelItensPedidoMesaAtivo();

            //preencher a tabela com os itens retornados
            
            //CARREGA OS DADOS DA LISTA NA TABELA
            int cont = listaModelItensPedidoMesas.size();
                     
            if (listaModelItensPedidoMesas.size() > 0 ){
            for (int i = 0; i < cont; i++){
                    ModelItensPedidoMesaAtivo modelItensPedidoMesaAtivo = new ModelItensPedidoMesaAtivo();
                    modelProdutos = controllerProdutos.getProdutosController(listaModelItensPedidoMesas.get(i).getCodigoProduto());
                    modelItensPedidoMesaAtivo.setCodigo(listaModelItensPedidoMesas.get(i).getCodigo());    
                    modelItensPedidoMesaAtivo.setCodigoMesa(listaModelItensPedidoMesas.get(i).getCodigoMesa());
                    modelItensPedidoMesaAtivo.setCodigoProduto(listaModelItensPedidoMesas.get(i).getCodigoProduto());
                    modelItensPedidoMesaAtivo.setNomeProduto(controllerProdutos.getProdutosController(listaModelItensPedidoMesas.get(i).getCodigoProduto()).getNome());
                    modelItensPedidoMesaAtivo.setQuantidade(listaModelItensPedidoMesas.get(i).getQuantidade());
                    modelItensPedidoMesaAtivo.setValor(controllerProdutos.getProdutosController(listaModelItensPedidoMesas.get(i).getCodigoProduto()).getValor());
                    modelItensPedidoMesaAtivo.setStatusPedido(listaModelItensPedidoMesas.get(i).getStatusPedido());
                    modelItensPedidoMesaAtivo.setObservacao(listaModelItensPedidoMesas.get(i).getObservacao());
                                                                           
                      listaProdutosativos.add(modelItensPedidoMesaAtivo);
                                     
                }
                
             TabelaProdutosMesa.getItems().addAll(listaProdutosativos);
             
               //SOMA VALOR TOTAL 
            somaEAtualizaValorTotal();
            tfProduto.requestFocus();
                
            }
           
        }
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("Você deve escolher uma mesa!");
        }
    
    private void recarregarMesa(int mesaatual){
                listaModelItensPedidoMesas = controllerItensPedidoMesa.getListaItensPedidoMesaController(mesaatual);
            ModelItensPedidoMesaAtivo modelItensPedidoMesaAtivo = new ModelItensPedidoMesaAtivo();

            //preencher a tabela com os itens retornados
            
            //CARREGA OS DADOS DA LISTA NA TABELA
            int cont = listaModelItensPedidoMesas.size();
            
            if (listaModelItensPedidoMesas.size() > 0 ){
            for (int i = 0; i < cont; i++) {
                modelProdutos = controllerProdutos.getProdutosController(listaModelItensPedidoMesas.get(i).getCodigoProduto());
                   listaModelItensPedidoMesas.get(i).getCodigoProduto();
                    modelItensPedidoMesaAtivo.setNomeProduto(modelProdutos.getNome());
                    modelItensPedidoMesaAtivo.setQuantidade(listaModelItensPedidoMesas.get(i).getQuantidade());
                    modelItensPedidoMesaAtivo.setValor(modelProdutos.getValor());
                    listaModelItensPedidoMesas.get(i).getStatusPedido();
                    listaModelItensPedidoMesas.get(i).getObservacao();
                    
                    listaProdutosativos.add(modelItensPedidoMesaAtivo);
                    
                }
            TabelaProdutosMesa.getItems().addAll(listaProdutosativos);
            
            }
        
            //SOMA VALOR TOTAL 
            tfTotalmesa.setText(String.valueOf(somaEAtualizaValorTotal()));
            tfProduto.requestFocus();
        }
        
      
    
    private float somaEAtualizaValorTotal() {
        float soma = 0, valor , descontoAjuste = 0;
        int linhas = TabelaProdutosMesa.getItems().size();
        for (int i=0; i<linhas ; i++){
            valor = (Float.parseFloat(String.valueOf(TabelaProdutosMesa.getItems().get(i).getValor() * TabelaProdutosMesa.getItems().get(i).getQuantidade())));
            soma = (Float.parseFloat(tfTotalmesa.getText()));
            soma = valor + soma;
             tfTotalmesa.setText(String.valueOf(soma));
            
        }
                   
        
        soma = soma - descontoAjuste;
        
        return bLMascaras.arredondamentoComPontoDuasCasas(soma);
        
 }    
    private void limpartabela(){
            TabelaProdutosMesa.getItems().clear();
        }
    private void popularTabela(int quantidadeMesas) {
        painelMesasFlow.getChildren().clear();
        
        listaMesasOcupadas = controllerItensPedidoMesa.getListaMesasOcupadasController();
                
        for (int i = 1; i <= quantidadeMesas; i++) {
           
            int espacoh = 50;
            int espacov = 50;
            
            mesaBotao = new Button();
            mesaBotao.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           tfProduto.setText("");
           tfValproduto.setText("");
           tfQuantproduto.setText("");
           tfProduto.requestFocus();
       }
       if(e.getCode()== KeyCode.F7){
           imprimir();
       }
       if(e.getCode()== KeyCode.F4){
           ActionEvent event = null;
           try {
               pagamentos(event);
           } catch (IOException ex) {
               Logger.getLogger(lancaMesa.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(e.getCode()== KeyCode.F5){
       try {
           transferencias();
           } catch (IOException ex) {
               Logger.getLogger(lancaMesa.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    });
            mesaBotao.setFont(javafx.scene.text.Font.font(30));
            
            mesaBotao.setMinWidth(espacoh);
            mesaBotao.setMinHeight(espacov);
            mesaBotao.setStyle("-fx-base: #A9A9A9");
            mesaBotao.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    irPraMesa();
                }
                
            });
            
        // pinta de verde
            for (int j = 0; j < listaMesasOcupadas.size(); j++) {
                if (i == listaMesasOcupadas.get(j)) {
                    mesaBotao.setStyle("-fx-base: #008000");
                    
                    if(controllerItensPedidoMesa.getItensPedidoMesaMesaController(i).getStatusNotificacao() == 1){
                        mesaBotao.setStyle("-fx-base: #00008B");
                    }
                    break;
                }
                listadeBotoes.add(mesaBotao);
            }
            if (i < 10) {
                mesaBotao.setText("0" + i);
            } else {
                mesaBotao.setText("" + i);
            }
            listadeBotoes.add(mesaBotao);
        painelMesasFlow.getChildren().addAll(mesaBotao);    
        }
}  
    
    public void fecharSaida(){
          Stage estagiosaida = (Stage) btFechamesa.getScene().getWindow();

        
                }
    
    public void pagamentos(ActionEvent event) throws IOException{
            
         
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pagamentosPDV.fxml"));
        Parent raizPagamentos = (Parent) loader.load();
        pagamentosPDV pagam = loader.getController();
        pagam.valorVenda(Float.parseFloat(tfTotalmesa.getText())); 
        pagam.mesaselecionada(tfMesaselecionada.getText());
        pagam.codGarcon(Integer.parseInt(tfGarcon.getText(0,2)));
        pagam.origem("mesa");
        pagam.definirComissao();
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizPagamentos));
        pagStage.initStyle(StageStyle.UNDECORATED);
        pagStage.initModality(Modality.APPLICATION_MODAL);
        fecharSaida();
        
        pagStage.show();
        
    }   
     
    public void transferencias() throws IOException{
            
         
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/dialogoTransferirMesa.fxml"));
        Parent raizTransferencias = (Parent) loader.load();
        Stage transferirStage = new Stage();
        transferirStage.setScene(new Scene(raizTransferencias));
        transferirStage.show();
        
    }   
   private boolean verificarCaixa()    {
    
    ModelCaixa modelCaixa = new ModelCaixa();
         modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
         if (modelCaixa.getCaixaNumero() == 1 && modelCaixa.getStatus() == 1){
             return true;
}
         return false;
}
   
   public int getNumeroCaixa() {
        return numeroCaixa;
    }
   
   public void verificarGarcon(){
        if (!(listaGarcons.contains(tfGarcon.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("VOCE PRECISA ESCOLHER UM GARÇON");    
                alert.show();
                tfGarcon.requestFocus();
       }else{
            tfProduto.requestFocus();
        }
   }
   

    /**
     * @param numeroCaixa the numeroCaixa to set
     */
    private void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }
    
    public void fecharLancamentoMesas(){
             Stage estagioLancamentoMesas = (Stage) btFechamesa.getScene().getWindow();
             estagioLancamentoMesas.close();
    }
    
    public void imprimir(){
        if(modeloImprimirMesa == 1){
                imprimirCupomPDF();
        }else if(modeloImprimirMesa == 2){
                imprimirCupomPDV(codigoVenda);
        }        
    }
        
    private void carregarConfiguracoes(){
       quantidadeImprimir = controllerConfiguracao.getConfiguracaoController(1).getQuantidadeImpressao();
       modeloImprimir = controllerConfiguracao.getConfiguracaoController(1).getModeloImpresssao();
       modeloImprimirMesa = controllerConfiguracao.getConfiguracaoController(1).getModeloCupomMesa(); 
       quantidadeMesas = controllerConfiguracao.getConfiguracaoController(1).getNumeroMesas();
   }
    
    public void transferirMesa(int mesaOrigem, int mesaDestino){
        int tamanho;
        ModelItensPedidoMesa mipm = new ModelItensPedidoMesa();
        listaItemTransferir.addAll(controllerItensPedidoMesa.getListaItensPedidoMesaController());
        tamanho = listaItemTransferir.size();
               for (int i=0; i<tamanho; i++){
                if(controllerItensPedidoMesa.getListaItensPedidoMesaController().get(i).getCodigoMesa() == mesaOrigem){
               mipm.setCodigo(listaItemTransferir.get(i).getCodigo());
               mipm.setCodigoGarcom(listaItemTransferir.get(i).getCodigoGarcom());
               mipm.setCodigoMesa(mesaDestino);
               mipm.setCodigoProduto(listaItemTransferir.get(i).getCodigoProduto());
               mipm.setHora(listaItemTransferir.get(i).getHora());
               mipm.setObservacao(listaItemTransferir.get(i).getObservacao());
               mipm.setQuantidade(listaItemTransferir.get(i).getQuantidade());
               mipm.setStatusPedido(listaItemTransferir.get(i).getStatusPedido());
               mipm.setOpcoesEscolhidas(listaItemTransferir.get(i).getOpcoesEscolhidas());
               controllerItensPedidoMesa.atualizarItensPedidoMesaController(mipm);
                }
            }
    }
        

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (verificarCaixa() == true){
        carregarConfiguracoes();
        habilitarCampos();
        popularTabela(quantidadeMesas);
        listaEnter();
        setNextFocus(tfProduto, tfQuantproduto, tfValproduto);
        criarlistaProdutos();
        limpartabela();
        cincoseg();
        listaGarcom();
        TextFields.bindAutoCompletion(tfProduto,listaProdutos );
        TextFields.bindAutoCompletion(tfGarcon,listaGarcons );
        produtoTabela.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        quantTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        precoTabela.setCellValueFactory(new PropertyValueFactory<>("valor"));
    
        
        tfProduto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           if (tfProduto.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("VOCE PRECISA ESCOLHER UM PRODUTO");    
                alert.show();
                tfQuantproduto.setFocusTraversable(false);
                tfValproduto.setFocusTraversable(false);
           }else{
               tfQuantproduto.setFocusTraversable(true);
                tfValproduto.setFocusTraversable(true);
           retornarprodutoPeloNome();
           }
       }
       if(e.getCode()== KeyCode.DOWN){
           escolherLinha();
       }
       
       if(e.getCode()== KeyCode.F7){
           imprimir();
       }
       if(e.getCode()== KeyCode.F4){
           ActionEvent event = null;
           try {
               pagamentos(event);
           } catch (IOException ex) {
               Logger.getLogger(lancaMesa.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(e.getCode()== KeyCode.F5){
       try {
           transferencias();
           } catch (IOException ex) {
               Logger.getLogger(lancaMesa.class.getName()).log(Level.SEVERE, null, ex);
           }
       }    
       
    });
        
        tfQuantproduto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           valorProduto();
       }
    });
       tfGarcon.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           verificarGarcon();
          }
    });
        tfValproduto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           carregarProdutosnaTabela();
           carregarProdutosList();
           cadastrarVendaMesa();
           }
            
    });
      
              btImprimir.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    imprimir();
                }
                
            });
        TabelaProdutosMesa.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.DELETE){
           Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("EXCLUIR PRODUTO?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE EXCLUIR O PRODUTO?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        excluirProduto();
                    }
                    });
             }
       
   
       if(e.getCode()== KeyCode.ENTER){
           
           irPraMesa();
       }
    });
        
    
    }else{
        
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("CAIXA FECHADO");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("O CAIXA AINDA NÃO FOI ABERTO, DESEJA ABRIR O CAIXA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        controleCaixa cx = new controleCaixa();
                    try {
                        cx.start(new Stage());
                    } catch (Exception ex) {
                        Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    fecharLancamentoMesas();
                                }
                    if (b == btnNao) { 
                        fecharLancamentoMesas();
                    }
                    
                     });
     
    }
    }  
}

