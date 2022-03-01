/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerCaixa;
import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerComprasProdutos;
import controller.ControllerContaReceber;
import controller.ControllerEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.ModelCaixa;
import model.ModelCidade;
import model.ModelCliente;
import model.ModelClienteCidadeEstado;
import model.ModelComprasProdutos;
import model.ModelContaReceber;
import model.ModelFormaPagamento;
import model.ModelFornecedor;
import model.ModelProdutos;
import model.ModelSessaoUsuario;
import model.ModelUnidadeMedia;
import model.ModelVendas;
import model.ModelVendasProdutos;
import model.ModelVendasProdutosTabela;
import blserial.ConfigXML;
import controller.ControllerCFOP;
import controller.ControllerCsosn;
import controller.ControllerCsosnFederal;
import controller.ControllerCstPiscofins;
import org.controlsfx.control.textfield.TextFields;
import unishop.Unishop;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;
import util.ManipularXML;
import view.ViewVerificarPermissao;
import nfe.model.ModelXmlNfe;
import nfe.controller.ControllerNF;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import controller.ControllerTributacaoEstadual;
import controller.ControllerTributacaoFederal;
import interfaces.classeInterfaces;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 *
 * @author Fabio
 */
public class pedidoVenda extends Application implements Initializable{
    
    @FXML TextField pedido;
    @FXML TextField nomeCliente;
    @FXML TextField telefoneCliente;
    @FXML TextField enderecoCliente;
    @FXML TextField bairroCliente;
    @FXML TextField referenciaCliente;
    @FXML TextField contatoCliente;
    @FXML TextField produto;
    @FXML TextField quantidade;
    @FXML TextField preco;
    @FXML TextField total;
    @FXML TextField totalgeral;
    @FXML TextField desconto;
    @FXML TextField observacao;
    @FXML TextField vencimento;
    @FXML TextField formadePagamento;
    @FXML TextField cest;
    @FXML TextField ncm;
    @FXML TextField tribFederal;
    @FXML TextField tribEstadual;
    @FXML TextField uniFiscal;
    @FXML private Button btSair;
    @FXML TableView<ModelVendasProdutosTabela> tabelaProdutos = new TableView();
    @FXML TableColumn<ModelVendasProdutosTabela, String> ordemTabela;
    @FXML TableColumn<ModelVendasProdutosTabela, String> prodTabela;
    @FXML TableColumn<ModelVendasProdutosTabela, String> quantTabela;
    @FXML TableColumn<ModelVendasProdutosTabela, String> valuniTabela;
    @FXML TableColumn<ModelVendasProdutosTabela, String> totalTabela;    
    @FXML Button btHistorico;
    @FXML Button btEntregasPedido;
    @FXML Button btImprimirPedido;
    @FXML Button btPagVencPedido;
    @FXML Button btObsPedido;
   
    
    
    public ArrayList<ModelVendasProdutosTabela> listavendidos ;
    int codigoProduto;
    int ordem = 1;
    int codigoCliente;
    float totalgeralfracao;
    double diminuir;
    String pagamento;
    int codPagamento;
    int indiceTabela;
    int numeroCaixa = 1;
    String codigoBarras;
    ModelVendasProdutosTabela produtoexcluir;
    ArrayList produtoexcluirmodel;
    Double valorUnitario;
   
    
    
    
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerCstPiscofins controllerCstPiscofins = new ControllerCstPiscofins();
    ModelVendas modelVendas = new ModelVendas();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelXmlNfe modelXmlNfe = new ModelXmlNfe();
    ControllerNF controllerNF = new ControllerNF();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ObservableList<ModelVendasProdutosTabela> listadeTabela;
    ArrayList<ModelCidade> modelCidade = new ArrayList<>();
    ArrayList<ModelFornecedor> modelFornecedors = new ArrayList<>();
    ArrayList<ModelUnidadeMedia> modelUnidadeMedia = new ArrayList<>();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ArrayList<ModelVendas> listaModelVendasAlterar = new ArrayList<>();
    ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
    ArrayList<ModelProdutos> listaProdutoses = new ArrayList<>();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
    ArrayList<TextField> campos = new ArrayList<>();
    ArrayList<String> listaClientes = new ArrayList<>();
    ArrayList<String> listaProdutos = new ArrayList<>();
    ArrayList<String> listaTelefones = new ArrayList<>();
    ArrayList<String> listaPagamentos = new ArrayList<>();
    ArrayList<ModelVendasProdutos> listamodel = new ArrayList<>();
    ObservableList<ModelVendasProdutos> listadeProdutos;
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerTributacaoEstadual controllerTributacaoEstadual = new ControllerTributacaoEstadual();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerCsosn controllerCsosn = new ControllerCsosn();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    BLMascaras bLMascaras = new BLMascaras();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    public int codigoVenda;
    int contVendaMenor;
    Date dataAtual = new Date();
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    private ViewVerificarPermissao viewVerificarPermissao;
    
    
    @Override
    public void start(Stage vendaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pedidoVenda.fxml")); 
        Parent raiz = loader.load();   
        vendaStage.setScene(new Scene(raiz));
        vendaStage.initStyle(StageStyle.UNDECORATED);
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
        classeInterfaces.addaoMudarTelaCodigoVenda((String novaTela, int codigoVenda) -> {
            recuperarVenda(codigoVenda);
            
         });
        classeInterfaces.addaoMudarTelaOuvinteOpcionais((String novaTela, String opcionais) -> {
            observacao.setText(opcionais);
            
         });
        classeInterfaces.addaoMudarTelaOuvinteProdutoEntrada((String novaTela,String ProdutoEntrada)-> {
            produto.setText(ProdutoEntrada);       
            retornarprodutoPeloNome();
                        
                        });
        classeInterfaces.addaoMudarTelaOuvinte(new classeInterfaces.aoMudarTela() {
            @Override
            public void telaModificada(String novaTela, String cliente) {
                nomeCliente.setText(cliente);
                retornarClientePeloNome();
                produto.requestFocus();
            }
        });
        
        if (verificarCaixa() == true){
        limparCamposVenda();
        habilitarBotoes();
        habilitarCampos();
        definirDatas();
        verificarCliente();
        verificarProduto();
        listaEnter();
        setNextFocus(nomeCliente, telefoneCliente, produto, quantidade,  preco, total);
        criarListaClientes();
        criarListaTelefones();
        criarlistaProdutos();
        criarlistaPagamentos();
        TextFields.bindAutoCompletion(nomeCliente,listaClientes );
        TextFields.bindAutoCompletion(telefoneCliente,listaTelefones );
        TextFields.bindAutoCompletion(produto,listaProdutos); 
        TextFields.bindAutoCompletion(formadePagamento,listaPagamentos);         
        //zerarValoresCaixa();
        desconto.setText("0");
        formadePagamento.setText("1-prazo");
        pagamento = (formadePagamento.getText().substring(0, 1));
        codPagamento = (Integer.parseInt(pagamento));
        pedido.setText("NOVO");
        

    nomeCliente.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode()== KeyCode.ENTER){
           retornarClientePeloNome();
           nomeCliente.setFocusTraversable(false);
           telefoneCliente.setFocusTraversable(false);
       }
      if(e.getCode()== KeyCode.F4){
           listaClientes();
       }
       if(e.getCode()== KeyCode.F3){
            try {
                listaProdutos();
            } catch (IOException ex) {
                Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(e.getCode()== KeyCode.F11){
           ActionEvent clique = new ActionEvent();
            try {
                pagamentos(clique);
            } catch (IOException ex) {
                Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(e.getCode()== KeyCode.F5){
           ActionEvent event = null;
           try {
               verVendas(event);
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(e.getCode()== KeyCode.F6){
           ActionEvent event = null;
           try {
               verEntregas();
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
      
  });
  telefoneCliente.setOnKeyPressed((KeyEvent e)->{
      if(e.getCode()== KeyCode.ENTER){
           retornarClientePeloTelefone();
           nomeCliente.setFocusTraversable(false);
           telefoneCliente.setFocusTraversable(false);
       }
      if(e.getCode()== KeyCode.F4){
           listaClientes();
       }
       if(e.getCode()== KeyCode.F3){
          try {
              listaProdutos();
          } catch (IOException ex) {
              Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
       if(e.getCode()== KeyCode.F5){
           ActionEvent event = null;
           try {
               verVendas(event);
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
      
  });
    
  produto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           
       if (((produto.getText().substring(0, 1))).equalsIgnoreCase("2") ){
                retornarprodutoPeloCodBarras();
                preencherTabela();
                               
                }else{
               codigoBarras = "";
               retornarprodutoPeloNome();
           }
           
        }
       if(e.getCode()== KeyCode.DOWN){
           irPraTabela();
       }
       if(e.getCode()== KeyCode.F4){
           listaClientes();
       }
       if(e.getCode()== KeyCode.F3){
           try {
               listaProdutos();
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(e.getCode()== KeyCode.F5){
              ActionEvent clique = new ActionEvent();
           try {
               verVendas(clique);
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(e.getCode()== KeyCode.F6){
              ActionEvent clique = new ActionEvent();
           try {
               verEntregas();
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(e.getCode()== KeyCode.F11){
           ActionEvent clique = new ActionEvent();
            try {
                pagamentos(clique);
            } catch (IOException ex) {
                Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(e.getCode()== KeyCode.F10){
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                dialogoExe.setTitle("SALVAR VENDA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE SALVAR A VENDA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        cadastrarVenda();
                    }
                    });
                  }
    });
   
    preco.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           total.setText(String.valueOf(calcularValorproduto(preco.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnFloat(quantidade.getText()))))));
       }
    });
    quantidade.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           total.setText(String.valueOf(calcularValorproduto(preco.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnFloat(quantidade.getText()))))));
       }
    });
    total.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           preencherTabela();
          
       }
       if(e.getCode()== KeyCode.F7){
           try {
               inserirOpcionais();
               //inserirObservacao();
           } catch (IOException ex) {
               Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    });
    
    observacao.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           preencherTabela();
           produto.requestFocus();
       }
    });
    
        
    tabelaProdutos.setOnKeyPressed((KeyEvent e)->{
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
           
           saidaTabela();
       }
    });
       
        ordemTabela.setCellValueFactory(new PropertyValueFactory<>("Ordem"));
        prodTabela.setCellValueFactory(new PropertyValueFactory<>("Produto"));
        quantTabela.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
        valuniTabela.setCellValueFactory(new PropertyValueFactory<>("ValorUnitario"));
        totalTabela.setCellValueFactory(new PropertyValueFactory<>("ValorTotal"));

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
                    fecharPedidoVenda();
                                }
                    if (b == btnNao) { 
                        fecharPedidoVenda();
                    }
                    
                     });
         
            
        }
                
    }
    public void recuperarVenda(int codigoVenda){
        ModelVendas mvRecupera = new ModelVendas();
        ModelClienteCidadeEstado mcRecupera = new ModelClienteCidadeEstado();
        ArrayList<ModelVendasProdutos> mpRecupera = new ArrayList<>();
        mvRecupera = controllerVendas.getVendasController(codigoVenda);
        mcRecupera = controllerClienteCidadeEstado.getClienteCidadeEstadoController(mvRecupera.getClientesCodigo());
        mpRecupera = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
        nomeCliente.setText(mcRecupera.getModelCliente().getNome());
        totalgeral.setText(String.valueOf(mvRecupera.getValorTotal()));
        recuperarClientePeloNome(mcRecupera);
        System.out.println(mvRecupera+" VENDA");
        System.out.println(mcRecupera+" CLIENTE");
        
        tabelaProdutos.getItems().addAll(recuperarTabela(mpRecupera, mvRecupera));
        
        
    }
    
    private ObservableList<ModelVendasProdutosTabela> recuperarTabela(ArrayList<ModelVendasProdutos> produtosVendas, ModelVendas vendaRecuperada){
        ArrayList<ModelVendasProdutosTabela> produtos = new ArrayList<>();
        ObservableList<ModelVendasProdutosTabela> tabelaRecuperada = null;
        for(int i=0; i<produtosVendas.size(); i++){
            ModelVendasProdutosTabela mvptRecupera = new ModelVendasProdutosTabela();
            mvptRecupera.setProduto(produtosVendas.get(i).getNomeProduto());
            mvptRecupera.setOrdem(i+1);
            mvptRecupera.setQuantidade(produtosVendas.get(i).getQuantidade());
            mvptRecupera.setValorUnitario(produtosVendas.get(i).getValorUnitario());
            mvptRecupera.setValorTotal(produtosVendas.get(i).getQuantidade() * produtosVendas.get(i).getValorUnitario());
            mvptRecupera.setDataVenda(String.valueOf(vendaRecuperada.getDataVenda()));
            produtos.add(mvptRecupera);
        }
        tabelaRecuperada = FXCollections.observableArrayList(produtos);
        return tabelaRecuperada; 
    }
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    public void habilitarBotoes(){
        btImprimirPedido.setDisable(true);

        
    }
    public void fecharPedidoVenda(){
             Stage estagioPedidoVenda = (Stage) btEntregasPedido.getScene().getWindow();
             estagioPedidoVenda.close();
    }
    public void atualizarmodel() {
   
        ModelVendasProdutos mvp = new ModelVendasProdutos(); 
                        
        mvp.setCodigo(codigoVenda);
        mvp.setCodigo_produto(codigoProduto);
        mvp.setCodigo_venda(codigoVenda);
        mvp.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(quantidade.getText()));
        mvp.setValorUnitario(bLMascaras.truncamentoComPontoDuasCasasFloat(bLMascaras.converterVirgulaParaPontoReturnFloat(preco.getText())));
        mvp.setObservacao(observacao.getText());
        
        listamodel.add(mvp);
                
        listadeProdutos = FXCollections.observableArrayList(listamodel);
             
     }
    
    
     public void atualizarTabela(){
        
        tabelaProdutos.getItems().addAll(listavendidos);
        atualizarmodel();

        
     }
     @FXML
     private void adcionar(){
         
         ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
         listavendidos = new ArrayList<>();
         
         mvpt.setOrdem(ordem);
         if (!(codigoBarras == "")){
         mvpt.setProduto(controllerProdutos.getProdutosCodigoBarrasController(codigoBarras).getNome());
         }else{
         mvpt.setProduto(produto.getText());
         }
         mvpt.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(quantidade.getText()));
         mvpt.setValorUnitario(valorUnitario);
         mvpt.setValorTotal(bLMascaras.converterVirgulaParaPontoReturnDouble(total.getText()));
         mvpt.setObservacao(observacao.getText());
                          
        listavendidos.add(mvpt);
        
        
        ordem ++;
        
        atualizarTabela();
        totalgeralfracao = (Float.parseFloat(total.getText()) + (totalgeralfracao));
        totalgeral.setText(String.valueOf(bLMascaras.truncamentoComPontoDuasCasasFloat(totalgeralfracao)));
        limpaTelaNovoProduto();
        
     }
     
     public void inserirObservacao(){
         observacao.requestFocus();
                 
     }
     public void inserirOpcionais() throws IOException{
         int codigo = controllerProdutos.getProdutosController(produto.getText()).getGrupo();
         
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/opcoesPedidos.fxml"));
        Parent raizPagamentos = (Parent) loader.load();
        opcionaisPedidos oPedidos = loader.getController();
        oPedidos.popularTabela(codigo);
        Stage opStage = new Stage();
        opStage.setScene(new Scene(raizPagamentos));
        opStage.initStyle(StageStyle.UNDECORATED);
        opStage.initModality(Modality.APPLICATION_MODAL);
        opStage.show();
         
     }
     
    public void listaEnter(){
        campos.add(nomeCliente);
        campos.add(telefoneCliente);
        campos.add(produto);
        campos.add(quantidade);
        campos.add(preco);
        campos.add(total);
    
                  
       }
    public void setNextFocus(TextField nomeCliente, TextField telefoneCliente, TextField produto, TextField quantidade, TextField preco, TextField total) {
        
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
    
    public void criarListaClientes(){
        listaModelClientes = controllerCliente.getListaClienteAtivoController();
        
        for (int i = 0; i < listaModelClientes.size(); i++) {
            listaClientes.add(listaModelClientes.get(i).getNome());
        }
    }
            
         public void criarListaTelefones(){
        listaModelClientes = controllerCliente.getListaClienteController();
        
        for (int i = 0; i < listaModelClientes.size(); i++) {
            listaTelefones.add(listaModelClientes.get(i).getCelular());
        }
         }   
         
        public void retornarClientePeloNome() {
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(nomeCliente.getText());
        this.enderecoCliente.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.bairroCliente.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.telefoneCliente.setText(modelClienteCidadeEstado.getModelCliente().getCelular());
        this.contatoCliente.setText(modelClienteCidadeEstado.getModelCliente().getNome());
        this.referenciaCliente.setText(modelClienteCidadeEstado.getModelCliente().getReferencia());
        this.codigoCliente = (modelClienteCidadeEstado.getModelCliente().getCodigo());
        
        
    }
        public void recuperarClientePeloNome(ModelClienteCidadeEstado modelClienteCidadeEstado) {
        this.enderecoCliente.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.bairroCliente.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.telefoneCliente.setText(modelClienteCidadeEstado.getModelCliente().getCelular());
        this.contatoCliente.setText(modelClienteCidadeEstado.getModelCliente().getNome());
        this.referenciaCliente.setText(modelClienteCidadeEstado.getModelCliente().getReferencia());
        this.codigoCliente = (modelClienteCidadeEstado.getModelCliente().getCodigo());
        
        
    }
        public void retornarClientePeloNomeCampo() {
        ModelClienteCidadeEstado mcce = new ModelClienteCidadeEstado();
            mcce = controllerClienteCidadeEstado.getClienteCidadeEstadoController(nomeCliente.getText());
        this.enderecoCliente.setText(mcce.getModelCliente().getEndereco());
        this.bairroCliente.setText(mcce.getModelCliente().getBairro());
        this.telefoneCliente.setText(mcce.getModelCliente().getCelular());
        this.contatoCliente.setText(mcce.getModelCliente().getNome());
        this.referenciaCliente.setText(mcce.getModelCliente().getReferencia());
        this.codigoCliente = (mcce.getModelCliente().getCodigo());
        
        
    }
         
         public void retornarClientePeloTelefone() {
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoPorTelefoneController(telefoneCliente.getText());
            
        this.nomeCliente.setText(String.valueOf(modelClienteCidadeEstado.getModelCliente().getNome()));
        this.enderecoCliente.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.bairroCliente.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.contatoCliente.setText(modelClienteCidadeEstado.getModelCliente().getNome());
        this.referenciaCliente.setText(modelClienteCidadeEstado.getModelCliente().getReferencia());
        this.codigoCliente = (modelClienteCidadeEstado.getModelCliente().getCodigo());
        
    }
         
         
         private void retornarprodutoPeloNome() {
        //INICIO recupera o nome
        modelProdutos = controllerProdutos.getProdutosController(produto.getText());
      
        this.preco.setText(String.valueOf(bLMascaras.truncamentoComPontoDuasCasasDouble(modelProdutos.getValor())));
        this.quantidade.setText("1");
        //FIM recupera o nome
       total.setText(calcularValorproduto(this.quantidade.getText(), this.preco.getText()) + "");
       codigoProduto = (modelProdutos.getCodigo());
       quantidade.setFocusTraversable(true);
       preco.setFocusTraversable(true);
       total.setFocusTraversable(true);
       
    }
         
         private void retornarprodutoPeloCodBarras() {
        //INICIO recupera o codigo de barras
        codigoBarras = String.valueOf(Integer.parseInt(produto.getText(1, 5)));
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(String.valueOf(Integer.parseInt(produto.getText(1, 5))));
        
        double totalBarras = ((Double.parseDouble(this.produto.getText().substring(7, 12)))* 0.001);
        double pesoBarras = (bLMascaras.truncamentoComPontoTresCasasDouble(totalBarras));
        
        this.preco.setText(String.valueOf(modelProdutos.getValor()) );
        this.quantidade.setText(String.valueOf(pesoBarras));
        //FIM recupera o nome
       total.setText(calcularValorproduto(this.preco.getText(), this.quantidade.getText()) + "");
       
       
       //produto.setText(modelProdutos.getNome());
       codigoProduto = (modelProdutos.getCodigo());
       quantidade.setFocusTraversable(false);
       preco.setFocusTraversable(false);
       total.setFocusTraversable(false);
       
       //total.requestFocus();
       
    }
        
         
         private double calcularValorproduto(String pValorUnitario, String pQuantidade) {
        double valorTotal = 0.00, valorUnitario = 0.00, quantidade = 0.00;
        try {
            quantidade = bLMascaras.truncamentoComPontoTresCasasDouble(Double.parseDouble(pQuantidade));
        } catch (NumberFormatException e) {
            quantidade = 0.00;
        }
        try {
            valorUnitario = (bLMascaras.truncamentoComPontoDuasCasasDouble(bLMascaras.converterVirgulaParaPontoReturnDouble(pValorUnitario)));
        } catch (Exception e) {
            valorUnitario = 0.00;
        }
        try {
            
            
            valorTotal = (valorUnitario * quantidade);
        } catch (Exception e) {
            
            valorTotal = 0.00;
        }
        
        return (bLMascaras.arredondamentoComPontoDuasCasasDouble(valorTotal));
    }
          private void verificarCliente() {
        if (listaClientes.size() < 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Cadastre primeiro um cliente!");
            
        }
    }

          
    private void verificarProduto() {
        if(listaProdutos.size() < 1){
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Cadastre primeiro um Produto!");
    }

    }
   
   private void preencherTabela(){
   
        String nomeproduto = (produto.getText());
        valorUnitario = (bLMascaras.truncamentoComPontoDuasCasasDouble(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText())));
        if (!(codigoBarras == "")){
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(codigoBarras);
        }else{
        modelProdutos = controllerProdutos.getProdutosController(nomeproduto);
        }
                      
        if (quantidade.getText().equals("") || quantidade.getText().equals("0")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Você deve informar a quantidade para adicionar!");
            alert.show();
         } else {
            //verifica a quantidade em estoque
            
            if ((modelProdutos.getEstoque()) < (bLMascaras.converterVirgulaParaPontoReturnDouble(quantidade.getText()))) {
                //pegunta se realmente deseja excluir
                
                //  btnExe.setOnAction(e -> {
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("Erro de estoque");
                dialogoExe.setHeaderText("Quantidade Acima do permitido");
                dialogoExe.setContentText("Você não tem essa quantidade de produto em estoque!\n"
                        + "Quantidade atual de " + modelProdutos.getNome() + " é " + modelProdutos.getEstoque() + "\n"
                                + "Deseja efeuar a venda do produto mesmo assim?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        if (modelProdutos.getValorCusto() > valorUnitario){
                            viewVerificarPermissao.setValorCusto(valorUnitario);
                            viewVerificarPermissao.setValorVenda(valorUnitario);
                            viewVerificarPermissao.setVisible(true);
                            if (viewVerificarPermissao.isPermissao()) {
                                adcionar();
                                produto.requestFocus();
                                                                
                            } else {
                                //chama o método de add na tabela
                                adcionar();
                                produto.requestFocus();
                            }
                        }} else if (b == btnNao) {
                            
                        }
                });
                // });
           
                //testa se o valor de venda é menor que o valor de compra
                if (modelProdutos.getValorCusto() > valorUnitario) {
                    viewVerificarPermissao.setValorCusto(valorUnitario);
                    viewVerificarPermissao.setValorVenda(valorUnitario);
                    viewVerificarPermissao.setVisible(true);
                    if (viewVerificarPermissao.isPermissao()) {
                           
                    }
                } else {
                    //chama o método de add na tabela
                    adcionar();
                    produto.requestFocus();
                }
            } else {
            }
             adcionar();
             produto.requestFocus();
                   }
                 }
   
  /* private void zerarValoresCaixa() {
        valorCartao = 0;
        valorCheque = 0;
        valorDinheiro = 0;
        valorVale = 0;
    }*/
   
   
    public boolean cadastrarVenda() {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar hora = Calendar.getInstance();
        
          if (desconto.getText().equals("") || totalgeral.getText().equals("") || listadeProdutos.size() < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ATENÇÃO");
            alert.setContentText("Você deve preencher todos os campos!");
            alert.show();
            return false;
            
        } else {
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProdutolocal;
            float quantidadelocal;

            for (int i = 0; i < listadeProdutos.size() ; i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setClientesCodigo(codigoCliente);
                modelVendas.setDesconto(Float.parseFloat(this.desconto.getText()));
                modelVendas.setTaxaEntrega(0f);
                modelVendas.setValorTotal(Float.parseFloat(totalgeral.getText()));
                modelVendas.setObservacao(listadeProdutos.get(i).getObservacao());
                modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                    modelVendas.setHoraVenda(dateFormat.format(hora.getTime()));
                } catch (Exception ex) {
                    Logger.getLogger(pedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProdutolocal = (listadeProdutos.get(i).getCodigo_produto());
                modelVendas.setProdutosCodigo(codigoProdutolocal);
                modelVendas.setVencimento(vencimento.getText());
                modelVendas.setTipo(2);
                modelVendas.setValor(bLMascaras.truncamentoComPontoDuasCasasDouble(listadeProdutos.get(i).getValorUnitario()));
                modelVendas.setQuantidade(listadeProdutos.get(i).getQuantidade());
                
                // dados fiscais zerados operação não fiscal
                
                modelVendas.setIcmsCst(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listadeProdutos.get(i).getCodigo()).getTribEst()).getIdcsosn()).getNumero()));
                modelVendas.setIpiCst(String.valueOf(controllerCsosnFederal.getCsosnFederalController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listadeProdutos.get(i).getCodigo()).getTribFed()).getIdIpi()).getNumero()));
                modelVendas.setPisCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listadeProdutos.get(i).getCodigo()).getTribFed()).getIdPisCofins()).getNumero()));
                modelVendas.setCofinsCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listadeProdutos.get(i).getCodigo()).getTribFed()).getIdPisCofins()).getNumero()));
                modelVendas.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listadeProdutos.get(i).getCodigo()).getTribEst()).getIdcfop()).getCfop()));
                
                modelVendas.setIcmsRed(0.0);
                               
                try {
                    modelVendas.setTipoPagamento(codPagamento);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ATENÇÃO");
                    alert.setContentText("Você deve cadastrar uma forma de pagamento!");
                    alert.show();
                }   

                modelProdutos.setCodigo(codigoProduto);
                quantidadelocal = controllerProdutos.getProdutosController(codigoProdutolocal).getEstoque() - (listadeProdutos.get(i).getQuantidade());
                modelProdutos.setEstoque(quantidadelocal);
                modelProdutos.setObservacao(listadeProdutos.get(i).getObservacao());
               
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            
        

           //salvar venda
         if ((!(pedido.getText().equals("NOVO")))&&(Integer.parseInt(pedido.getText()) > 0)){
               modelVendas.setCodigo(Integer.parseInt(pedido.getText()));
               
               //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                controllerVendas.atualizarVendasController(modelVendas);
                controllerVendas.salvarVendasProdutosController(modelVendas);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ATUALIZADO");
                    alert.setContentText("Venda atualizada com sucesso!");
                    alert.show();
                limparCamposVenda();
                
           }else if (pedido.getText().equals("NOVO")) {
               codigoVenda = controllerVendas.salvarVendasController(modelVendas);
               pedido.setText(String.valueOf(codigoVenda));
                      
                       
               modelVendas.setCodigo(codigoVenda);
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                controllerVendas.salvarVendasProdutosController(modelVendas);
                
                
                return true;
         }  else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERRO");
                    alert.setContentText("Erro ao gravar os dados!");
                    alert.show();
                 
            }
            
          }
          return false;
    }
    
    private void inativarCampos(){
    pedido.setDisable(true);
    nomeCliente.setDisable(true);
    telefoneCliente.setDisable(true);
    enderecoCliente.setDisable(true);
    bairroCliente.setDisable(true);
    referenciaCliente.setDisable(true);
    contatoCliente.setDisable(true);
    produto.setDisable(true);
    quantidade.setDisable(true);
    preco.setDisable(true);
    total.setDisable(true);
    totalgeral.setDisable(true);
    desconto.setDisable(true);
    observacao.setDisable(true);
    vencimento.setDisable(true);
    formadePagamento.setDisable(true);
    tabelaProdutos.setDisable(true);
    btHistorico.setDisable(true);
    btPagVencPedido.setDisable(true);
//    btObsPedido.setDisable(true);
//    btSalvarPedido.setDisable(true);
        
    }
    
    public void atualizarVenda(int codigovenda, String  pagamento, float troco) throws Exception{
        ModelVendas mv = new ModelVendas();
        mv = controllerVendas.getVendasController(codigovenda);
        String obs;
        if (troco > 0){
            obs = "LEVAR " + bLMascaras.arredondamentoComPontoDuasCasasFloatString(troco)+ " PARA TROCO";
        }else{
            obs = "";
        }        
        mv.setCaixa(mv.getCaixa());
        mv.setClientesCodigo(mv.getClientesCodigo());
        mv.setCodigo(codigovenda);
        mv.setDataVenda(mv.getDataVenda());
        mv.setDesconto(mv.getDesconto());
        mv.setHoraVenda(mv.getHoraVenda());
        mv.setValorTotal(mv.getValorTotal());
        mv.setTipo(mv.getTipo());
        mv.setObservacao(mv.getObservacao());
        mv.setObservacao(obs);
        mv.setTipoPagamento(Integer.parseInt(pagamento));
        mv.setCodigoUsuario(mv.getCodigoUsuario());
        mv.setTaxaEntrega(mv.getTaxaEntrega());
        mv.setVencimento(mv.getVencimento());
        
        controllerVendas.atualizarVendasController(mv);
    }
    
    private void retornarProdutoAoEstoque() {
        float quantRetorno;
        listavendidos = new ArrayList<>();
        int cont = listavendidos.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos = new ModelProdutos();
            modelProdutos.setCodigo(controllerProdutos.getProdutosController(listavendidos.get(i).getProduto()).getCodigo());
            quantRetorno = controllerProdutos.getProdutosController(modelProdutos.getCodigo()).getEstoque() + listavendidos.get(i).getQuantidade();
            modelProdutos.setEstoque(quantRetorno);
            listaModelProdutos.add(modelProdutos);
        }
        modelProdutos.setListaModelProdutoses(listaModelProdutos);
        controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
    }
       
public void finalizarVenda()    {
               
               //narValorCaixa();
               limparCamposVenda();
                habilitarBotoes();
             //    Limpa lista modelo
                listamodel = new ArrayList<>();
                                         
               
          
}
    
public boolean verificarCaixa()    {
    
    ModelCaixa modelCaixa = new ModelCaixa();
         modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
         if (modelCaixa.getCaixaNumero() == 1 && modelCaixa.getStatus() == 1){
             return true;
}
         return false;
}
 
private void habilitarCampos() {
        nomeCliente.setFocusTraversable(true);
        telefoneCliente.setFocusTraversable(true);
        tabelaProdutos.setFocusTraversable(false);
        produto.setFocusTraversable(true);
        quantidade.setFocusTraversable(true);
        preco.setFocusTraversable(true);
        total.setFocusTraversable(true);
        ordem = 1;
        totalgeralfracao = 0;
    
    }
    private void limpaTelaNovoProduto() {
        quantidade.setText("1");
        produto.setText("");
        preco.setText("");
        total.setText("");
        observacao.setText("");
        contVendaMenor = 0;
        
       
    }
    private void saidaTabela() {
        quantidade.setText("1");
        produto.setText("");
        preco.setText("");
        total.setText("");
        contVendaMenor = 0;
        tabelaProdutos.setFocusTraversable(false);
        produto.requestFocus();
              
    }
    public void contaReceber() throws Exception{
                   
        ModelContaReceber Modelcontareceber = new ModelContaReceber();
        ControllerContaReceber Controllercontareceber = new ControllerContaReceber();
               
        Modelcontareceber.setCodigoPessoa(codigoCliente);
        Modelcontareceber.setDescricao(nomeCliente.getText());
        Modelcontareceber.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        Modelcontareceber.setVencimento(bLMascaras.converterDataStringData(vencimento.getText()));
        Modelcontareceber.setValor(valorVale);
        Modelcontareceber.setSituacao(0);
        Modelcontareceber.setPagamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        Modelcontareceber.setTipoPagamento(codPagamento);
        Modelcontareceber.setObservacao(this.pedido.getText());
        
        Controllercontareceber.salvarContaReceberController(Modelcontareceber);
 
    }  
    public void imprimirPedido(){
               
        int print = ManipularXML.lerXmlConfig().getQuantidadeImprimir();
                
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("IMPRIMIR PEDIDO");
                dialogoExe.setContentText("Deseja imprimir?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) {                                       
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int codigo = codigoVenda;
                
                //if (codigo < 1){
                //    codigo = Integer.parseInt(pedido.getText());
                //}
                try{
                    for(int i = 0; i < print;i++){
                if(ManipularXML.lerXmlConfig().getModeloImprimir()== 1){
                    controllerVendas.gerarRelatorioVenda(codigo);
                }else if(ManipularXML.lerXmlConfig().getModeloImprimir() == 2){
                    controllerVendas.gerarRelatorioVendaCupom(codigo);
                }        }
                }catch(Exception e)
                        { System.out.println(e);
                    
                }
                
                carregando.dispose();
            }
       };
        t.start();
                }
        else{
    }
    });   
   }
    private void definirDatas(){
        
        // define a data de vencimento pra 7 dias
        
         dataAtual = (bLMascaras.addDias(7 ,new java.util.Date(System.currentTimeMillis())));
                                try {
                               
                vencimento.setText(bLMascaras.formatarData(dataAtual));
                
                } catch (Exception ex) {
                    
                    
                }
        
    }
    
    public void limparCamposVenda(){
        nomeCliente.clear();
        telefoneCliente.clear();
        enderecoCliente.clear();
        bairroCliente.clear();
        contatoCliente.clear();
        referenciaCliente.clear();
        tabelaProdutos.getItems().clear();
        totalgeral.clear();
        totalgeralfracao = 0.f;
        pedido.setText("NOVO");
        
    }
    public void lancamento() throws Exception{
       // cadastrarVenda();
        imprimirPedido();
        limparCamposVenda();
        nomeCliente.requestFocus();
    }
    public void irPraTabela()  {
        tabelaProdutos.setFocusTraversable(true);
        tabelaProdutos.edit(ordem, prodTabela);
        tabelaProdutos.requestFocus();
        
        
    }
    
    
    public void abrirVenda(int codigoVenda){
        listamodel.clear();
        tabelaProdutos.getItems().clear();
            modelVendas.setCodigo(codigoVenda);
            //recupera os dados do banco
            modelVendas = controllerVendas.getVendasController(codigoVenda);
            listamodel = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
            //seta os dados na interface
            nomeCliente.setText(controllerClienteCidadeEstado.getClienteCidadeEstadoController(modelVendas.getClientesCodigo()).getModelCliente().getNome());
            pedido.setText(String.valueOf(modelVendas.getCodigo()));
            desconto.setText(String.valueOf(modelVendas.getDesconto()));
            totalgeral.setText(String.valueOf(modelVendas.getValorTotal()));
            formadePagamento.setText(controllerTipoPagamento.getFormaPagamentoController(modelVendas.getTipoPagamento()).getDescricao());
            observacao.setText(modelVendas.getObservacao());
            //recupera os dados do banco
           int cont = listamodel.size();
            for (int i = 0; i < cont; i++){
                ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
                listavendidos = new ArrayList<>();
                mvpt.setOrdem(i+1);
                mvpt.setProduto(controllerProdutos.getProdutosController(listamodel.get(i).getCodigo_produto()).getDescricaoProduto());
                mvpt.setQuantidade(listamodel.get(i).getQuantidade());
                mvpt.setValorUnitario(listamodel.get(i).getValorUnitario());
                mvpt.setValorTotal(bLMascaras.truncamentoComPontoDuasCasasDouble(listamodel.get(i).getQuantidade() * listamodel.get(i).getValorUnitario()));
            
                 listavendidos.add(mvpt);
                 //carregar lista de produtos da venda
            
            tabelaProdutos.getItems().addAll(listavendidos);
            totalgeralfracao = (Float.parseFloat(totalgeral.getText()));
            ordem = cont+1;            
            }
            
       inativarCampos();
    }
    
    public void editarVenda(){
        retornarProdutoAoEstoque();
        controllerVendasProdutos.excluirVendasProdutosCodVendaController(Integer.parseInt(pedido.getText()));
        
    }
   
    public void excluirProduto() {
       
        produtoexcluir = tabelaProdutos.getSelectionModel().getSelectedItem();
        indiceTabela = tabelaProdutos.getSelectionModel().getSelectedIndex();
        
        
        // Verificamos se existe realmente alguma linha selecionada
        if (produtoexcluir == null) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ATENCÃO");
        alert.setContentText("Você deve selecionar um item na tabela antes de clicar no botão!");
        alert.show();
               
        } else {
            
            diminuir = tabelaProdutos.getItems().get(indiceTabela).getValorTotal();
           
            listamodel.remove(indiceTabela);
            tabelaProdutos.getItems().remove(indiceTabela);
                                      
        listadeProdutos = FXCollections.observableArrayList(listamodel);
           
        }
        renumeraItens();
        atualizaTotal();
        limpaTelaNovoProduto();
        
        }
      
        private float somaEAtualizaValorTotal() {
        float soma = 0, valor = 0, descontoAjuste = 0;
        
        //pegar valor desconto
        try {
            descontoAjuste = Float.parseFloat(desconto.getText());
        } catch (Exception e) {
            descontoAjuste = 0;
        }
                    valor = Float.parseFloat(String.valueOf(produto.getText()));
                    soma = valor + soma;
        
        soma = soma - descontoAjuste;
        
        return bLMascaras.truncamentoComPontoDuasCasasFloat(soma);
        
 }            
        public void renumeraItens(){
            int tamanho = tabelaProdutos.getItems().size();
        
            
            if(tamanho > (indiceTabela)){
                for (int i = indiceTabela; i < tamanho; i++){
                    tabelaProdutos.getItems().get(i).setOrdem(i+1);
                tamanho = tabelaProdutos.getItems().size();
                ordem = tamanho + 1 ;
        
                }
                
            }
            
        }
        
        public void atualizaTotal(){
                        
            double totalLocal = ((Double.parseDouble(totalgeral.getText())) - diminuir);
            totalgeral.setText(String.valueOf(totalLocal));
            totalgeralfracao = ((Float.parseFloat(totalgeral.getText())));
        }
        
        public void abrirHistorico(){
            clienteHistorico chist = new clienteHistorico();
        try {
            chist.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void verHistorico(ActionEvent event) throws IOException{
                
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/clienteHistorico.fxml"));
        Parent raizHistorico = (Parent) loader.load();
        clienteHistorico cHistorico = loader.getController();
        cHistorico.listaHistorico(codigoCliente);
        Stage stageHistorico = new Stage();
        stageHistorico.setScene(new Scene(raizHistorico));
        stageHistorico.setX(1055);
        stageHistorico.setY(20);
        stageHistorico.show();
        
    }
     
     public void verEntregas() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqEntregas.fxml"));
        Parent raizVendas = (Parent) loader.load();
        listaEntregas lEntregas = loader.getController();
        Stage stageEntregas = new Stage();
        stageEntregas.setScene(new Scene(raizVendas));
        stageEntregas.initStyle(StageStyle.UNDECORATED);
        stageEntregas.show();
        
    }    
        
    public void verVendas(ActionEvent event) throws IOException{
        fecharPedidoVenda();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqVendas.fxml"));
        Parent raizVendas = (Parent) loader.load();
        listaVendas lVendas = loader.getController();
        Stage stageVendas = new Stage();
        stageVendas.setScene(new Scene(raizVendas));
        stageVendas.initStyle(StageStyle.UNDECORATED);
        stageVendas.show();
        
    }
        public void listaProdutos() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqProduto.fxml"));
        Parent raizProduto = (Parent) loader.load();
        listaProduto lProduto = loader.getController();
        Stage stageProduto = new Stage();
        stageProduto.setScene(new Scene(raizProduto));
        stageProduto.initStyle(StageStyle.UNDECORATED);
        stageProduto.show();    
        
        
    }
        
        public void listaClientes(){
        listaCliente lCliente = new listaCliente();
            try {
            lCliente.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
     public void pagamentos(ActionEvent event) throws IOException{
        btImprimirPedido.setDisable(false);
        cadastrarVenda();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pagamentos.fxml"));
        Parent raizPagamentos = (Parent) loader.load();
        pagamentos pagam = loader.getController();
        pagam.cbxComissao.setVisible(false);
        pagam.valorVenda(Float.parseFloat(totalgeral.getText()));
        pagam.origem("delivery");
        pagam.codVenda = Integer.parseInt(pedido.getText());
        pagam.codCliente = (String.valueOf(codigoCliente));
        pagam.lbtotal.setText(totalgeral.getText());
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizPagamentos));
        pagStage.initStyle(StageStyle.UNDECORATED);
        pagStage.initModality(Modality.APPLICATION_MODAL);
        pagStage.show();
        limparCamposVenda();
        listamodel = new ArrayList<>();
      
    }  
     
    
      public int getNumeroCaixa() {
        return numeroCaixa;
    }

    /**
     * @param numeroCaixa the numeroCaixa to set
     */
    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }
         
    
                
}


   
   
    


