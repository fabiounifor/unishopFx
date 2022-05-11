/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerCaixa;
import controller.ControllerCidade;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerComprasProdutos;
import controller.ControllerEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerVendasProdutos;
import controller.ControllerCstPiscofins;
import controller.ControllerCFOP;
import controller.ControllerCsosn;
import controller.ControllerCsosnFederal;
import controller.ControllerTributacaoEstadual;
import controller.ControllerTributacaoFederal;
import controller.ControllerCst;
import controller.ControllerEnquadramentoIpi;
import controller.ControllerNCM;
import controller.ControllerFator;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ModelCaixa;
import model.ModelCidade;
import model.ModelClienteCidadeEstado;
import model.ModelComprasProdutos;
import model.ModelFormaPagamento;
import model.ModelFornecedor;
import model.ModelProdutos;
import model.ModelUnidadeMedia;
import model.ModelVendasProdutosTabela;
import model.ModelTributacaoEstadual;
import model.ModelTributacaoFederal;
import nfe.model.ModelNFCe;
import blserial.ConfigXML;
import org.controlsfx.control.textfield.TextFields;
import util.BLMascaras;
import util.ManipularXML;
import view.ViewVerificarPermissao;
import nfe.model.ModelXmlNfe;
import nfe.controller.ControllerNF;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import com.acbr.nfe.ACBrNFe;
import controller.ControllerCompras;
import controller.ControllerContaPagar;
import controller.ControllerDfe;
import controller.ControllerModeloIpi;
import interfaces.classeInterfaces;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelCompras;
import model.ModelContaPagar;
import model.ModelDfe;
import model.ModelVendasProdutosTabelaNfe;
import nfe.model.ModelNF;
import nfe.util.LerArqXML;

/**
 *
 * @author Fabio
 */
public class nfeEntrada extends Application implements Initializable{
    
    @FXML public TextField tfPisProdutos;
    @FXML public TableColumn<ModelComprasProdutos, String> totalTabela;
    @FXML public ChoiceBox cbFormaPag;
    @FXML public ChoiceBox cbNatOperacao;
    @FXML public DatePicker dpDigitacao;
    @FXML public TableColumn<ModelContaPagar, String> vencimentoParcela;
    @FXML public TextField preco;
    @FXML public TableColumn<ModelComprasProdutos, String> prodTabela;
    @FXML public TextField tfValorSubst;
    @FXML public ChoiceBox cbFinalidade;
    @FXML public TableColumn<ModelComprasProdutos, String> valuniTabela;
    @FXML public TextField tfCnpj;
    @FXML public TextField quantidade;
    @FXML public TableColumn<ModelComprasProdutos, String> valorIpi;
    @FXML public TableColumn<ModelComprasProdutos, String> csosn;
    @FXML public TableColumn<ModelComprasProdutos, String> cfop;
    @FXML public Button btHistorico;
    @FXML public TextField totalgeralProdutos;
    @FXML public Button btGravar;
    @FXML public TextField tfTotalGeral;
    @FXML public TextField tfSeguro;
    @FXML public TextField tfClassFiscal;
    @FXML public TextField tfInscricao;
    @FXML public TableColumn<ModelComprasProdutos, String> percIcms;
    @FXML public TableColumn<ModelComprasProdutos, String> percIpi;
    @FXML public TextField telefoneFornecedor;
    @FXML public TableView<ModelContaPagar> tabelaPagamentos;
    @FXML public TextField tfOutrasDespesas;
    @FXML public TextField nomeFornecedor;
    @FXML public TextField tfDescontos;
    @FXML public TextField tfBcSubst;
    @FXML public TextField TfBcIpi;
    @FXML public TextField tfCofinsProdutos;
    @FXML public TextField tfBcIcms;
    @FXML public TextField bairroFornecedor;
    @FXML public TableView<ModelComprasProdutos> tabelaProdutos;
    @FXML public TextField total;
    @FXML public TextField tfPedido;
    @FXML public TextField tfValorIpi;
    @FXML public TableColumn<ModelComprasProdutos, String> ordemTabela;
    @FXML public TextField enderecoFornecedor;
    @FXML public TableColumn<ModelComprasProdutos, String> quantTabela;
    @FXML public DatePicker dpEmissao;
    @FXML public TableColumn<ModelContaPagar, String> valorParcela;
    @FXML public TextField tfChave;
    @FXML public TableColumn<ModelComprasProdutos, String> valorIcms;
    @FXML public TextField tfValorIcms;
    @FXML public TextField tfTotalPag;
    @FXML private Button btSair;
       
    
    
    public ArrayList<ModelVendasProdutosTabelaNfe> listavendidos ;
    public ArrayList<ModelComprasProdutos> listacomprados ;
    int codigoProduto;
    int ordem = 1;
    int codigoFornecedor;
    float totalgeralfracao;
    double diminuir;
    String pagamento;
    int codPagamento;
    int indiceTabela;
    int numeroCaixa = 1;
    String chaveCriada;
    ModelComprasProdutos produtoexcluir;
     ArrayList produtoexcluirmodel;
    Double valorUnitario;
   int pond = 2;
   int soma = 0;
   int resto;
   int dv;
   String produtoNFe = "";
   String arquivoINI = "";
   String mesAnoEmissao;
   float totalBaseCalculoIcms = 0.0f;
   float totalValorIcms = 0.0f;
   int controle = 0;
    
    
    ModelXmlNfe modelXmlNfe = new ModelXmlNfe();
    ControllerNF controllerNF = new ControllerNF();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    ManipularXML manipularXml = new ManipularXML();
    ControllerCompras controllerCompras = new ControllerCompras();
    ModelCompras modelCompras = new ModelCompras();
    ModelNFCe modelNFCe = new ModelNFCe();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelFornecedor modelfornecedor = new ModelFornecedor();
    ModelContaPagar modelContaPagar = new ModelContaPagar();
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerCsosn controllerCsosn = new ControllerCsosn();
    ControllerDfe controllerDfe = new ControllerDfe();
    ObservableList<ModelVendasProdutosTabela> listadeTabela;
    ObservableList<ModelComprasProdutos> listadeProdutos;
    ArrayList<ModelCidade> modelCidade = new ArrayList<>();
    ArrayList<ModelFornecedor> modelFornecedors = new ArrayList<>();
    ArrayList<ModelUnidadeMedia> modelUnidadeMedia = new ArrayList<>();
    ArrayList<ModelCompras> listaModelCompras = new ArrayList<>();
    ArrayList<ModelCompras> listaModelComprasAlterar = new ArrayList<>();
    ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
    ArrayList<ModelProdutos> listaProdutoses = new ArrayList<>();
    ArrayList<ModelFornecedor> listaModelFornecedores = new ArrayList<>();
    ArrayList<TextField> campos = new ArrayList<>();
    ArrayList<String> listaFornecedores = new ArrayList<>();
    ArrayList<String> listaProdutos = new ArrayList<>();
    ArrayList<String> listaTelefones = new ArrayList<>();
    ArrayList<String> listaPagamentos = new ArrayList<>();
    ArrayList<ModelComprasProdutos> listaComprados = new ArrayList<>();
    ArrayList<ModelComprasProdutos> listamodel = new ArrayList<>();
    ArrayList<ModelContaPagar> listamodelcontas = new ArrayList<>();
    ModelTributacaoEstadual modelTributacaoEstadual = new ModelTributacaoEstadual();
    ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelCaixa modelCaixa = new ModelCaixa();
    ModelNF modelNf = new ModelNF();
    ControllerTributacaoEstadual controllerTributacaoEstadual = new ControllerTributacaoEstadual();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ControllerCstPiscofins controllerCstPiscofins = new ControllerCstPiscofins();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ControllerCst controllerCst = new ControllerCst();
    ControllerModeloIpi controllerModeloIpi = new ControllerModeloIpi();
    ControllerEnquadramentoIpi controllerEnquadramentoIpi = new ControllerEnquadramentoIpi();
    ControllerNCM controllerNCM = new ControllerNCM();
    ControllerFator controllerFator = new ControllerFator();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
    BLMascaras bLMascaras = new BLMascaras();
    LerArqXML lerArqxml = new LerArqXML();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    public int codigoVenda;
    int contVendaMenor;
    String origem;
    Date dataAtual = new Date();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    private ViewVerificarPermissao viewVerificarPermissao;
    
    //nfce
    
    private ACBrNFe acbrNFe;
   
    
    
    @Override
    public void start(Stage vendaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/nfeEntrada.fxml")); 
        Parent raiz = loader.load();   
        vendaStage.setScene(new Scene(raiz));
        vendaStage.setTitle("NFE ENTRADA");
        vendaStage.initModality(Modality.APPLICATION_MODAL);
        vendaStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaFinalidade();
        iniciaNatOperacao();
        iniciaFormaPag();
        limparCamposCompra();
        listaEnter();
        setNextFocus(nomeFornecedor, telefoneFornecedor);
        criarlistaProdutos();
        criarlistaPagamentos();
        TextFields.bindAutoCompletion(nomeFornecedor,listaFornecedores ).setMinWidth(300);
        TextFields.bindAutoCompletion(tfChave,listaProdutos ).setMinWidth(300);
          
        ordemTabela.setCellValueFactory(new PropertyValueFactory<>("ordem"));
        prodTabela.setCellValueFactory(new PropertyValueFactory<>("nomeProdutoEstoque"));
        quantTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        
        valuniTabela.setCellValueFactory(new PropertyValueFactory<>("valorCusto"));
        totalTabela.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        percIcms.setCellValueFactory(new PropertyValueFactory<>("percCreditoSn"));
        valorIcms.setCellValueFactory(new PropertyValueFactory<>("valorCreditoSn"));
        percIpi.setCellValueFactory(new PropertyValueFactory<>("percIpi"));
        valorIpi.setCellValueFactory(new PropertyValueFactory<>("valorIpi"));
        csosn.setCellValueFactory(new PropertyValueFactory<>("cst"));
        cfop.setCellValueFactory(new PropertyValueFactory<>("cfopEstoque"));
        cfop.setCellFactory(TextFieldTableCell.forTableColumn());
        cfop.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ModelComprasProdutos, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<ModelComprasProdutos, String> event) {
                ModelComprasProdutos mcpLinha = event.getRowValue();
                mcpLinha.setCfopEstoque(event.getNewValue());
            if(!(event.getNewValue().equals(""))){
                 try {
                           procuraCfop(event.getNewValue());
                    classeInterfaces.addaoMudarTelaOuvinteCfopEntrada((String novaTela,String CfopEntrada)-> {
                    mcpLinha.setCfopEstoque(CfopEntrada);
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("AVISO");
                alert.setContentText("DIGITE UMA VALOR PRA PROCURAR");
                alert.show();
            }
            }

        });
        vencimentoParcela.setCellValueFactory(new PropertyValueFactory<>("vencimento"));
        valorParcela.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }
    public void procuraCfop(String cfop) throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqCfop.fxml"));
        Parent entradaProduto = (Parent) loader.load();
        listaCfop localizaCfop = loader.getController();
        localizaCfop.pesquisaCfopEntrada(cfop);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaProduto));
        stage.show();
   
        
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void iniciaFinalidade(){
       cbFinalidade.getItems().addAll("Nfe - Normal", "Nfe - Complementar");
    }
    public void iniciaNatOperacao(){
       cbNatOperacao.getItems().addAll("COMPRA");
       
    }
    public void iniciaFormaPag(){
       cbFormaPag.getItems().addAll("DINHEIRO", "CARTÃO","PRAZO", "BOLETO");
       
    }


    
    public void fecharNfe(){
             Stage estagioPedidoVenda = (Stage) btGravar.getScene().getWindow();
             estagioPedidoVenda.close();
    }
    
    
     public void atualizarTabela(){
        
        tabelaProdutos.getItems().addAll(listacomprados);
    
     }
    
    public void listaEnter(){
        campos.add(nomeFornecedor);
        campos.add(telefoneFornecedor);
        campos.add(tfChave);
        
                  
       }
    public void setNextFocus(TextField produto, TextField quantidade) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    } 
    private void criarlistaProdutos() {
        listaModelProdutos = controllerProdutos.getListaProdutosAtivosController();
        
        for (int i = 0; i < listaModelProdutos.size(); i++) {
            listaProdutos.add(listaModelProdutos.get(i).getNome());
        }
    }
    private void criarlistaPagamentos() {
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();
        
        for (int i = 0; i < listaModelTipoPagamentos.size(); i++) {
            listaPagamentos.add(+listaModelTipoPagamentos.get(i).getCodigo()+"-" + listaModelTipoPagamentos.get(i).getDescricao());
            }
    }
       
    public void limparCamposCompra(){
        tfChave.clear();
        totalgeralfracao = 0.f;
        tabelaProdutos.getItems().clear();
        tfPedido.setText("NOVO");
        dpDigitacao.setValue(LocalDate.now());
        dpEmissao.setValue(LocalDate.now());
        cbNatOperacao.setValue("Compra");
        tfBcIcms.setText("0.0");
        tfBcSubst.setText("0.0");
        TfBcIpi.setText("0.0");
        tfDescontos.setText("0.0");
        tfOutrasDespesas.setText("0.0");
        tfPisProdutos.setText("0.0");
        tfSeguro.setText("0.0");
        tfTotalPag.setText("0.0");
        tfValorIcms.setText("0.0");
        tfValorIpi.setText("0.0");
        cbFinalidade.setValue("Nfe - Normal");
        cbNatOperacao.setValue("COMPRA");
    }
   
    
    public void fecharNfeEntrada(){
          Stage estagioEntrada = (Stage) btGravar.getScene().getWindow();
          estagioEntrada.close();
        
                }
    public void cadastrarContaPagar(){
     
        ModelContaPagar mcpg = new ModelContaPagar();
        mcpg.setCodigoPessoa(controllerFornecedor.getFornecedorController(modelfornecedor.getNome()).getCodigo());
        mcpg.setData(modelContaPagar.getData());
        mcpg.setDescricao(modelContaPagar.getDescricao());
        mcpg.setObservacao(modelContaPagar.getObservacao());
        mcpg.setPagamento(modelContaPagar.getPagamento());
        mcpg.setTipoConta(modelContaPagar.getTipoConta());
        mcpg.setTipoPagamento(modelContaPagar.getTipoPagamento());
        mcpg.setValor(modelContaPagar.getValor());
        mcpg.setVencimento(modelContaPagar.getVencimento());
        mcpg.setDocOrigem(modelContaPagar.getDocOrigem());
     
              controllerContaPagar.salvarContasPagarController(mcpg);
     
    }
    public void atualizarContaPagar(){
     
        ModelContaPagar mcpg = new ModelContaPagar();
        mcpg.setCodigoPessoa(controllerFornecedor.getFornecedorController(modelfornecedor.getNome()).getCodigo());
        mcpg.setData(modelContaPagar.getData());
        mcpg.setDescricao(modelContaPagar.getDescricao());
        mcpg.setObservacao(modelContaPagar.getObservacao());
        mcpg.setPagamento(modelContaPagar.getPagamento());
        mcpg.setTipoConta(modelContaPagar.getTipoConta());
        mcpg.setTipoPagamento(modelContaPagar.getTipoPagamento());
        mcpg.setValor(modelContaPagar.getValor());
        mcpg.setVencimento(modelContaPagar.getVencimento());
        mcpg.setDocOrigem(modelContaPagar.getDocOrigem());
     
        controllerContaPagar.atualizarContaPagarController(mcpg);
             
    }
    
    public void cadastrarProdutosComprados(){
    for (int i = 0; i < listaComprados.size() ; i++){
          ModelComprasProdutos mcp = new ModelComprasProdutos();
          mcp.setCodigo(listaComprados.get(i).getCodigo());
          mcp.setBarras(listaComprados.get(i).getBarras());
          mcp.setCest(listaComprados.get(i).getCest());
          mcp.setCfop(tabelaProdutos.getItems().get(i).getCfop());
          mcp.setCfopEstoque(tabelaProdutos.getItems().get(i).getCfopEstoque());
          mcp.setCodCompras(Integer.parseInt(tfPedido.getText()));
          mcp.setCodFornecedor(listaComprados.get(i).getCodFornecedor());
          mcp.setCodProduto(controllerProdutos.getProdutosController(listaComprados.get(i).getNomeProdutoEstoque()).getCodigo());
          mcp.setCodProdutoFornecedor(listaComprados.get(i).getCodProdutoFornecedor());
          mcp.setCst(listaComprados.get(i).getCst());
          mcp.setFatorConversao(String.valueOf(controllerFator.getFatorDescricaoController(tabelaProdutos.getItems().get(i).getFatorConversao()).getCodigo()));
          mcp.setNcm(listaComprados.get(i).getNcm());
          mcp.setNomeProduto(listaComprados.get(i).getNomeProduto());
          mcp.setNomeProdutoEstoque(listaComprados.get(i).getNomeProdutoEstoque());
          mcp.setPercCreditoSn(listaComprados.get(i).getPercCreditoSn());
          mcp.setValorCreditoSn(listaComprados.get(i).getValorCreditoSn());
          mcp.setValorIpi(listaComprados.get(i).getValorIpi());
          mcp.setQuantidade(tabelaProdutos.getItems().get(i).getQuantidade());
          mcp.setUnidade(tabelaProdutos.getItems().get(i).getUnidade());
          mcp.setValorCusto(bLMascaras.arredondamentoComPontoDuasCasasDouble(listaComprados.get(i).getValorCusto()));
          mcp.setValorTotal(bLMascaras.arredondamentoComPontoDuasCasasDouble(listaComprados.get(i).getValorTotal()));
          mcp.setOrdem(listaComprados.get(i).getOrdem());
          mcp.setUnidade(listaComprados.get(i).getUnidade());
          mcp.setBaseCalculoSub(bLMascaras.arredondamentoComPontoDuasCasasString(Float.parseFloat(bLMascaras.converterVirgulaParaPonto(listaComprados.get(i).getBaseCalculoSub()))));
          mcp.setBaseCalculoicms(bLMascaras.arredondamentoComPontoDuasCasasString(Float.parseFloat(bLMascaras.converterVirgulaParaPonto(listaComprados.get(i).getBaseCalculoicms()))));
          
          //if (controle != 3){
          controllerProdutos.atualizarProdutosQuantidadeUmController(controllerProdutos.getProdutosController(listaComprados.get(i).getNomeProdutoEstoque()).getCodigo(), (listaComprados.get(i).getQuantidade() + controllerProdutos.getProdutosController(listaComprados.get(i).getNomeProdutoEstoque()).getEstoque()));
         // }
          listamodel.add(mcp);
      }
              for (int j=0; j<listamodel.size();j++){
                  modelComprasProdutos = listamodel.get(j);
                  if (controle != 3){
                  controllerComprasProdutos.salvarcompra_produtoController(modelComprasProdutos);
                  }else{
                       controllerComprasProdutos.atualizarcompras_produtoscFOPController(modelComprasProdutos);
                       }
                }
              
         }
    
    
    
    public void cadastrarCompra(){
    if (controle == 0){
    for (int i=0; i< controllerNF.getListaNFCOMPRAController().size(); i++){
        if (controllerNF.getListaNFCOMPRAController().get(i).getNumeroNfe().equals(modelNf.getNumeroNfe())){
        controle = 1;
    }
        
    }
    }
        if (controle == 1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("NFE JÁ CADASTRADA");
                alert.show();
        

    }
        if (controle == 3){
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                dialogoExe.setTitle("ATUALIZAR COMPRA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA REALMENTE ATUALIZAR A COMPRA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                       // atualizarContaPagar(); 
                        cadastrarProdutosComprados();
                        try {
                            controllerNF.atualizarNFCOMPRAController(atualizarNfeEntrada(modelNf));
                        } catch (Exception ex) {
                            Logger.getLogger(nfeEntrada.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        atualizarListaDfe();
                        fecharNfeEntrada(); 
                    }
                    });
        

    }else{
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                                
                dialogoExe.setTitle("SALVAR COMPRA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA REALMENTE SALVAR A COMPRA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        
                        //cadastrarContaPagar(); 
                        cadastrarProdutosComprados();
                        try {
                            controllerNF.salvarNFCOMPRAController(atualizarNfeEntrada(modelNf));
                        } catch (Exception ex) {
                            Logger.getLogger(nfeEntrada.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        atualizarListaDfe();
                        classeInterfaces.avisaOuvintesNotificacao("principal", "atualiza");
                        fecharNfeEntrada(); 
                    }
                    });
       
    }
    }
    
    public void preencherEntradas(ArrayList<ModelComprasProdutos> produtoEntrada, ModelNF nfeDados, ModelFornecedor fornecedor, ModelContaPagar contasaPagar) throws Exception{
        nomeFornecedor.setText(fornecedor.getNome());
        telefoneFornecedor.setText(fornecedor.getTelefone());
        bairroFornecedor.setText(fornecedor.getBairro());
        tfCnpj.setText(fornecedor.getCnpj());
        tfInscricao.setText(fornecedor.getInscEstadual());
        enderecoFornecedor.setText(fornecedor.getEndereco());
        totalgeralProdutos.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getValorProdutos()));
        tabelaProdutos.getItems().addAll(produtoEntrada);
        tabelaPagamentos.getItems().addAll(contasaPagar);
        tfPedido.setText(nfeDados.getNumeroNfe());
        dpDigitacao.setValue(bLMascaras.converterDataStringDataHifen(nfeDados.getDataEmissao().toString()).toLocalDate());    
        dpEmissao.setValue(bLMascaras.converterDataStringDataHifen(nfeDados.getDataEmissao().toString()).toLocalDate());
        tfChave.setText(nfeDados.getChaveNfe());
        tfBcIcms.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getIcmsBc()));
        tfBcSubst.setText(nfeDados.getBCSubst());
        tfValorSubst.setText(nfeDados.getICMSSubst());
        tfOutrasDespesas.setText(nfeDados.getOutros());
        TfBcIpi.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getIpiVlr()));
        tfDescontos.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getValorDescontos()));
        tfPisProdutos.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getPisVlr()));
        tfTotalPag.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getValorTotal()));
        tfValorIcms.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getIcmsVlr()));
        tfValorIpi.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getIpiVlr()));
        tfTotalGeral.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(nfeDados.getValorTotal()));
        modelContaPagar  = contasaPagar;
        modelfornecedor = fornecedor;
        listaComprados = produtoEntrada;
        modelNf = nfeDados;
        System.out.println(fornecedor.getCnpj() +" fornecedor");
     }
    
    private void atualizarListaDfe(){
        ModelDfe modelDfe = new ModelDfe();
        ArrayList<ModelDfe> listaModelDfe = new ArrayList<>();
        listaModelDfe = controllerDfe.getListaDfeController();
        for (int i=0; i<listaModelDfe.size(); i++){
            if(listaModelDfe.get(i).getChavenfe().equals(tfChave.getText())){
                modelDfe = listaModelDfe.get(i);
            }
        }
        listaDfe ld = new listaDfe();
        ld.atualizarDfe(modelDfe.getCodigo(), 4, "imagens/lupa.png");
        
    }
    
    public ModelNF atualizarNfeEntrada(ModelNF nfeDados) throws Exception{
        
        nfeDados.setValorProdutos(nfeDados.getValorProdutos());
        nfeDados.setNumeroNfe(nfeDados.getNumeroNfe());
        nfeDados.setDataEmissao(bLMascaras.converterDataStringDataHifen(dpEmissao.getValue().toString()));    
        nfeDados.setDataDigitacao(bLMascaras.converterDataStringDataHifen(dpDigitacao.getValue().toString()));    
        nfeDados.setChaveNfe(nfeDados.getChaveNfe());
        nfeDados.setIcmsBc(nfeDados.getIcmsBc());
        nfeDados.setBCSubst(nfeDados.getBCSubst());
        nfeDados.setICMSSubst(nfeDados.getICMSSubst());
        nfeDados.setOutros(nfeDados.getOutros());
        nfeDados.setIpiVlr(nfeDados.getIpiVlr());
        nfeDados.setValorDescontos(nfeDados.getValorDescontos());
        nfeDados.setPisVlr(nfeDados.getPisVlr());
        nfeDados.setValorTotal(nfeDados.getValorTotal());
        nfeDados.setIcmsVlr(nfeDados.getIcmsVlr());
        nfeDados.setIpiVlr(nfeDados.getIpiVlr());
        nfeDados.setValorTotal(nfeDados.getValorTotal());
        nfeDados.setEmpresa(1);
        return nfeDados;        
        
    }
    
}
    


