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
import controller.ControllerCliente;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerComprasProdutos;
import controller.ControllerContaReceber;
import controller.ControllerEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerVendas;
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
import controller.ControllerIbpt;
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
import model.ModelTributacaoEstadual;
import model.ModelTributacaoFederal;
import model.ModelIbpt;
import nfe.model.ModelNFCe;
import blserial.ConfigXML;
import com.acbr.ACBrLibBase;
import com.acbr.ACBrLibConfigBase;
import com.acbr.ACBrSessao;
import org.controlsfx.control.textfield.TextFields;
import unishop.Unishop;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;
import util.ManipularXML;
import view.ViewVerificarPermissao;
import nfe.model.ModelXmlNfe;
import nfe.controller.ControllerNF;
import nfe.model.ModelNF;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import java.text.ParseException;
import com.acbr.nfe.demo.FrmMain;
import com.acbr.nfe.ACBrNFe;
import controller.ControllerCompras;
import controller.ControllerConfiguracao;
import controller.ControllerNumeracao;
import controller.ControllerModeloIpi;
import interfaces.classeInterfaces;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelCompras;
import model.ModelConfig;
import model.ModelCsosn;
import model.ModelNumeracao;
import model.ModelVendasProdutosTabelaNfe;
import nfe.util.LerArqXML;
import nfe.util.ViewLeitorNotaXML;



/**
 *
 * @author Fabio
 */
public class nfeSaida extends Application implements Initializable{
    
    @FXML public TextField tfPisProdutos;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> totalTabela;
    @FXML public TextField tfFrete;
    @FXML public ChoiceBox cbFormaPag;
    @FXML public ChoiceBox cbNatOperacao;
    @FXML public DatePicker dpDigitacao;
    @FXML public TableColumn<ModelContaReceber, String> vencimentoParcela;
    @FXML public TextField preco;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> prodTabela;
    @FXML public TextField tfValorSubst;
    @FXML public ChoiceBox cbFinalidade;
    @FXML public ChoiceBox cbIntermediador;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> valuniTabela;
    @FXML public ChoiceBox cbIdConsumidor;
    @FXML public ChoiceBox cbTpConsumidor;
    @FXML public TextField tfCnpj;
    @FXML public TextField quantidade;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> valorIpi;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> csosn;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> cfop;
    @FXML public Button btHistorico;
    @FXML public Button btImportar;
    @FXML public TextField totalgeralProdutos;
    @FXML public TextField tfTotalProdutosItens;
    @FXML public Button btGravar;
    @FXML public TextField tfTotalGeral;
    @FXML public Button btCancelar;
    @FXML public TextField tfSeguro;
    @FXML public TextField tfClassFiscal;
    @FXML public TextField tfInscricao;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> percIcms;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> percIpi;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, Button> tbBtEdita;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, Button> tbBtRemove;
    @FXML public TextField telefoneCliente;
    @FXML public TableView<ModelContaReceber> tabelaPagamentos;
    @FXML public TextField tfOutrasDespesas;
    @FXML public TextField tfNfeReferencia;
    @FXML public TextField nomeCliente;
    @FXML public TextField tfDescontos;
    @FXML public TextField tfBcSubst;
    @FXML public TextField TfBcIpi;
    @FXML public TextField tfCofinsProdutos;
    @FXML public TextField tfBcIcms;
    @FXML public TextField bairroCliente;
    @FXML public TableView<ModelVendasProdutosTabelaNfe> tabelaProdutos;
    @FXML public TextField total;
    @FXML public TextField tfPedido;
    @FXML public TextField tfValorIpi;
    @FXML public TextArea taInfFisco;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> ordemTabela;
    @FXML public ChoiceBox cbModeloFrete;
    @FXML public TextField enderecoCliente;
    @FXML public TableColumn<ModelContaReceber, String> quantTabela;
    @FXML public DatePicker dpEmissao;
    @FXML public TableColumn<?, ?> valorParcela;
    @FXML public TextField produto;
    @FXML public TextArea taDadosAdcionais;
    @FXML public TableColumn<ModelVendasProdutosTabelaNfe, String> valorIcms;
    @FXML public TextField tfValorIcms;
    @FXML public TextField tfTotalPag;
    @FXML public Button btClientes;
    @FXML public Button btProdutos;
    @FXML public Button btEditaLocal;
    @FXML public Button btRemoveLocal;
    @FXML Button btFecharRetorno;    
    @FXML TextArea tfStatus;    
    @FXML private Button btSair;
    @FXML private ScrollPane pnAlteraProduto;
    @FXML private AnchorPane apAlteraProduto;
    @FXML private ChoiceBox<String> cbCsosn;
    @FXML private TextField edProduto;
    @FXML private TextField edQuantidade;
    @FXML private TextField edValorunitario;
    @FXML private TextField edDesconto;
    @FXML private TextField edValorTotal;
    @FXML private TextField edValorTotalGeral;
    @FXML private TextField edPercIcms;
    @FXML private TextField edValorIcms;
    @FXML private TextField edPercIpi;
    @FXML private TextField edValorIpi;
    @FXML private TextField edPercSubst;
    @FXML private TextField edValorSubst;
    @FXML private TextField edCfop;
    @FXML private Button btConfirma;
    @FXML private Button btCfop;
    
    public ArrayList<ModelVendasProdutosTabelaNfe> listavendidos ;
    int codigoProduto;
    int ordem = 1;
    int linhaAlterar = 0;
    int codigoCliente;
    Double totalgeralfracao;
    double diminuir;
    String pagamento;
    int codPagamento;
    int indiceTabela;
    int numeroCaixa = 1;
    String chaveCriada;
    ModelVendasProdutosTabelaNfe produtoexcluir;
    ModelVendasProdutosTabelaNfe produtoalterar;
    ArrayList produtoexcluirmodel;
    Double valorUnitario;
    Double valorAntesAlterar;
    int pond = 2;
    int soma = 0;
    int resto;
    int dv;
    String produtoNFe = "";
    String arquivoINI = "";
    String mesAnoEmissao;
    float totalBaseCalculoIcms = 0.0f;
    float totalValorIcms = 0.0f;
    int idDestino = 0;
    String emailDialogo;
    
    
    ModelXmlNfe modelXmlNfe = new ModelXmlNfe();
    ModelNumeracao modelNumeracao = new ModelNumeracao();
    ControllerNF controllerNF = new ControllerNF();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    ManipularXML manipularXml = new ManipularXML();
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerNumeracao controllerNumeracao = new ControllerNumeracao();
    ModelVendas modelVendas = new ModelVendas();
    ModelNFCe modelNFCe = new ModelNFCe();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerCsosn controllerCsosn = new ControllerCsosn();
    ObservableList<ModelVendasProdutosTabela> listadeTabela;
    ArrayList<ModelCidade> modelCidade = new ArrayList<>();
    ArrayList<ModelFornecedor> modelFornecedors = new ArrayList<>();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
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
    ArrayList<ModelVendasProdutos> listaVendidos = new ArrayList<>();
    ArrayList<ModelVendasProdutos> listamodel = new ArrayList<>();
    ObservableList<ModelVendasProdutos> listadeProdutos;
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ModelTributacaoEstadual modelTributacaoEstadual = new ModelTributacaoEstadual();
    ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerTributacaoEstadual controllerTributacaoEstadual = new ControllerTributacaoEstadual();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ControllerCompras controllerCompras = new ControllerCompras();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ControllerCstPiscofins controllerCstPiscofins = new ControllerCstPiscofins();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ControllerCst controllerCst = new ControllerCst();
    ControllerModeloIpi controllerModeloIpi = new ControllerModeloIpi();
    ControllerEnquadramentoIpi controllerEnquadramentoIpi = new ControllerEnquadramentoIpi();
    ControllerNCM controllerNCM = new ControllerNCM();
    ControllerConfiguracao controllerConfiguracao = new ControllerConfiguracao();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    BLMascaras bLMascaras = new BLMascaras();
    LerArqXML lerArqxml = new LerArqXML();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    public int codigoVenda;
    int contVendaMenor;
    Date dataAtual = new Date();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    ModelNF modelNF = new ModelNF();
    private ViewVerificarPermissao viewVerificarPermissao;
    
    //nfce
    
    private ACBrNFe acbrNFe;
   
    
    
    @Override
    public void start(Stage vendaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/nfeSaida.fxml")); 
        Parent raiz = loader.load();   
        vendaStage.setScene(new Scene(raiz));
        vendaStage.setTitle("NFE");
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
        classeInterfaces.addaoMudarTelaOuvinteCfopEntrada((String novaTela,String cfopRetorno)-> {
                    edCfop.setText(cfopRetorno);
                        });
         classeInterfaces.addaoMudarTelaRejeicao((String novaTela, String retorno) -> {
         tfStatus.setVisible(true);
         tfStatus.setFocusTraversable(true);
         btFecharRetorno.setVisible(true);
         tfStatus.setText(retorno);
         });
        classeInterfaces.addaoMudarTelaOuvinte(new classeInterfaces.aoMudarTela() {
            @Override
            public void telaModificada(String novaTela, String cliente) {
                nomeCliente.setText(cliente);
                retornarClientePeloNome();
            }
        });
        classeInterfaces.addaoMudarTelaOuvinteProdutoCodigo((String novaTela,int codigo)-> {
                    retornarprodutoPeloCodigo(codigo);
                    quantidade.requestFocus();
                        });
       btCfop.setOnMouseClicked((MouseEvent e)->{
            ActionEvent evento = null;
             try {
                 procuraCfop(edCfop.getText());
             } catch (Exception ex) {
                 Logger.getLogger(nfeSaida.class.getName()).log(Level.SEVERE, null, ex);
             }
             });
        if (verificarCaixa() == true){
        iniciaFinalidade();
        iniciaIntermediador();
        iniciaNatOperacao();
        iniciaIdConsumidor();
        iniciaModeloFrete();
        iniciaTpConsumidor();
        iniciaFormaPag();
        limparCamposVenda();
        habilitarCampos();
        definirDatas();
        verificarCliente();
        verificarProduto();
        listaEnter();
        iniciaBotoes();
        setNextFocus(produto, quantidade, preco);
        //criarListaClientes();
        //criarListaTelefones();
        //criarlistaProdutos();
        criarlistaPagamentos();
        //TextFields.bindAutoCompletion(nomeCliente,listaClientes ).setMinWidth(300);
        //TextFields.bindAutoCompletion(produto,listaProdutos ).setMinWidth(300);
        
                 
        //zerarValoresCaixa();
        tfStatus.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.F2){
        fecharRetorno();
        }
    });
   nomeCliente.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           listaClientes();
           nomeCliente.setFocusTraversable(false);
           telefoneCliente.setFocusTraversable(false);
      }
      });
        telefoneCliente.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           retornarClientePeloTelefone();
           nomeCliente.setFocusTraversable(false);
           telefoneCliente.setFocusTraversable(false);
       }    
    });
    
    produto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           if ((produto.getText().substring(0, 1)).equalsIgnoreCase("7")){
                retornarprodutoPeloCodBarras();
           }else if (((produto.getText().substring(0, 1)).equalsIgnoreCase("2")) && (produto.getText().length() == 13)){
                retornarprodutoPeloCodBarrasPeso();
           }else{
               try {
                   listaProdutos();
               } catch (Exception ex) {
                   Logger.getLogger(nfeSaida.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           total.setText(String.valueOf(calcularValorproduto(quantidade.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText()))))));
           
           
        }
       if(e.getCode()== KeyCode.DOWN){
           irPraTabela();
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
                        
                    }
                    });
                  }
    });
    
    quantidade.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
calcularValor();
//total.setText(String.valueOf(calcularValorproduto(quantidade.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText()))))));
       }
    });
    
   preco.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
calcularValor();
//total.setText(String.valueOf(calcularValorproduto(quantidade.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText()))))));
         
       }
    });
    total.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
calcularValor();
//tfTotalGeral.setText(String.valueOf(calcularValorproduto(quantidade.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText()))))));
           preencherTabela();
       }
    });
    
    

    tfTotalGeral.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           
           
       }
    });
    
    tfDescontos.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           
           descontoComPonto();
       }
    });
    
    
    
    btConfirma.setOnMouseClicked((MouseEvent e) ->{
           insereProdutoAlterado();
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
          
        ordemTabela.setCellValueFactory(new PropertyValueFactory<>("ordem"));
        prodTabela.setCellValueFactory(new PropertyValueFactory<>("produto"));
        quantTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        valuniTabela.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        totalTabela.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        percIcms.setCellValueFactory(new PropertyValueFactory<>("aliqIcms"));
        valorIcms.setCellValueFactory(new PropertyValueFactory<>("valorIcms"));
        percIpi.setCellValueFactory(new PropertyValueFactory<>("aliqIpi"));
        valorIpi.setCellValueFactory(new PropertyValueFactory<>("valorIpi"));
        csosn.setCellValueFactory(new PropertyValueFactory<>("csosn"));
        cfop.setCellValueFactory(new PropertyValueFactory<>("cfop"));
        tbBtEdita.setCellValueFactory(new PropertyValueFactory<>("btEdita"));
        tbBtRemove.setCellValueFactory(new PropertyValueFactory<>("btRemove"));
       

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
                    fecharNfe();
                                }
                    if (b == btnNao) { 
                        fecharNfe();
                    }
                    
                     });
         
            
        }
                
    }
    
    private void iniciaBotoes(){
        btEditaLocal = new Button();
        btRemoveLocal = new Button();
        btEditaLocal.setAlignment(Pos.CENTER);
        btRemoveLocal.setAlignment(Pos.CENTER);
        btRemoveLocal.setOnMouseClicked((MouseEvent e) ->{
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
             });
    
    btEditaLocal.setOnMouseClicked((MouseEvent e) ->{
           Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("ALTERAR PRODUTO?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE ALTERAR O PRODUTO?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        editarProduto();                    
                    }
                    });
             });
    }
    
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void calcularValor(){
if(quantidade.getText() != " " &&  preco.getText() != " "){
    total.setText(String.valueOf(calcularValorproduto(quantidade.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText()))))));    
    }
    }
    
    public void iniciaFinalidade(){
       cbFinalidade.getItems().addAll("Nfe - Normal", "Nfe - Complementar","Nfe - Ajuste", "Devolução");
    }
    public void iniciaIntermediador(){
       cbIntermediador.getItems().addAll("Sem intermediario", "Site ou Plataforma de Terceiros");
    }
    public void iniciaNatOperacao(){
       cbNatOperacao.getItems().addAll("Venda", "Transferencia","Devolução", "Consignação", "Remessa","Exportação","Suframa","Furto/Roubo","Avaria","Vencimento","Apreensão/Recolhimento",
               "Perda no Processo","Coleta pra controle de qualidade","Perda de exclusão da portaria 344","Desvio de qualidade","Recolhimento do fabricante","Devolução ao Fornecedor/Distribuidora","Retorno");
       
    }
    public void iniciaFormaPag(){
       cbFormaPag.getItems().addAll("DINHEIRO", "CARTÃO","PRAZO");
       
    }
    public void iniciaIdConsumidor(){
       cbIdConsumidor.getItems().addAll("0 - Não se Aplica", "1 - Operação Presencial","2 - Operação não Presencial(Internet)", "3 - Operação não Presencial(teleatendimento)", "5 - Operação Presencial(Fora do Estabelecimento)","9 - Operação não Presencial(Outros)");
       
    }
    public void iniciaModeloFrete(){
       cbModeloFrete.getItems().addAll("Sem Frete", "Contratação do frete por conta do Remetente(CIF)","Contratação do frete por conta do Destinatario(FOB)", "Contratação do frete por conta de Terceiros", "Transporte Próprio por conta do Remetente","Transporte Próprio por conta do destinatário");
       
    }
    public void iniciaTpConsumidor(){
       cbTpConsumidor.getItems().addAll("Normal", "Consumidor Final");
       
    }
   
    public void retornarClientePeloNome() {
        if (nomeCliente.getText() != " "){
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(nomeCliente.getText());
            
        this.enderecoCliente.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.bairroCliente.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.telefoneCliente.setText(modelClienteCidadeEstado.getModelCliente().getTelefone());
        this.codigoCliente = (modelClienteCidadeEstado.getModelCliente().getCodigo());
        this.tfCnpj.setText(modelClienteCidadeEstado.getModelCliente().getCpfCNPJ());
        this.tfInscricao.setText(modelClienteCidadeEstado.getModelCliente().getInscricao());
        }
        
    }
    public void retornarFornecedorPeloNome() {
        if (nomeCliente.getText() != " "){
        modelFornecedor = controllerFornecedor.getFornecedorController(nomeCliente.getText());
            
        this.enderecoCliente.setText(modelFornecedor.getEndereco());
        this.bairroCliente.setText(modelFornecedor.getBairro());
        this.telefoneCliente.setText(modelFornecedor.getTelefone());
        this.codigoCliente = (modelFornecedor.getCodigo());
        this.tfCnpj.setText(modelFornecedor.getCnpj());
        this.tfInscricao.setText(modelFornecedor.getInscEstadual());
        }
        
    }
         
         public void retornarClientePeloTelefone() {
             if (telefoneCliente.getText() != " "){
             
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoPorTelefoneController(telefoneCliente.getText());
            
        this.nomeCliente.setText(String.valueOf(modelClienteCidadeEstado.getModelCliente().getNome()));
        this.enderecoCliente.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.bairroCliente.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.codigoCliente = (modelClienteCidadeEstado.getModelCliente().getCodigo());
        this.tfCnpj.setText(modelClienteCidadeEstado.getModelCliente().getCpfCNPJ());
        this.tfInscricao.setText(modelClienteCidadeEstado.getModelCliente().getInscricao());
            }
         }
    
    public void fecharNfe(){
             Stage estagioPedidoVenda = (Stage) btGravar.getScene().getWindow();
             estagioPedidoVenda.close();
    }
    public void fecharRetorno(){
        tfStatus.setText("");
        tfStatus.setVisible(false);
        tfStatus.setFocusTraversable(false);
        btFecharRetorno.setVisible(false);
    }
    public void atualizarmodel() {
         int me;
         int mc;
         me = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1).getModelEstado().getCodigo();
         mc = controllerCliente.getClienteController(nomeCliente.getText()).getCodEstado();
        
        ModelVendasProdutos mvp = new ModelVendasProdutos(); 
                        
        mvp.setCodigo(codigoVenda);
        mvp.setCodigo_produto(codigoProduto);
        mvp.setCodigo_venda(codigoVenda);
        mvp.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(quantidade.getText()));
        mvp.setValorUnitario(bLMascaras.truncamentoComPontoDuasCasasDouble(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText())));
        if(me == mc && (cbFinalidade.getSelectionModel().getSelectedIndex() == 3)){
         mvp.setCfop("5202");    
         idDestino = 1;    
         }
         else if(me != mc && (cbFinalidade.getSelectionModel().getSelectedIndex() == 3)){
         idDestino = 2;    
         mvp.setCfop("6202");    
         }
         else if(me == mc && (cbFinalidade.getSelectionModel().getSelectedIndex() != (3))){
        mvp.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcfop()).getCfop()));
        idDestino = 1;    
         }
         else if(me != mc && (cbFinalidade.getSelectionModel().getSelectedIndex() != (3))){
        mvp.setCfop("6"+(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcfop()).getCfop())).substring(1,4));
        idDestino = 2;    
         }
        mvp.setIcmsCst(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(codigoProduto).getTribEst()).getIdcsosn()).getNumero()));
        mvp.setIpiCst(String.valueOf(controllerCsosnFederal.getCsosnFederalController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdIpi()).getNumero()));
        mvp.setPisCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdPisCofins()).getNumero()));
        mvp.setCofinsCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdPisCofins()).getNumero()));
        mvp.setOrdem(ordem);
        listamodel.add(mvp);
                
        listadeProdutos = FXCollections.observableArrayList(listamodel);
     }
    
    
     public void atualizarTabela(){
        
        tabelaProdutos.getItems().addAll(listavendidos);
        atualizarmodel();

        
     }
     @FXML
     private void adcionar(){
         int me;
         int mc;
         me = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1).getModelEstado().getCodigo();
         mc = controllerCliente.getClienteController(nomeCliente.getText()).getCodEstado();
         
         
         ModelVendasProdutosTabelaNfe mvptn = new ModelVendasProdutosTabelaNfe();
         listavendidos = new ArrayList<>();
         mvptn.setOrdem(ordem);
         mvptn.setProduto(produto.getText());
         mvptn.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(quantidade.getText()));
         mvptn.setValorUnitario(valorUnitario);
         mvptn.setValorTotal(Float.parseFloat(total.getText()));
         mvptn.setAliqIcms(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getPercentual());
         mvptn.setAliqIcms(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getPercentual());
         mvptn.setNcm(controllerProdutos.getProdutosController(produto.getText()).getNcm());
         mvptn.setAliqIpi(0.0);
         mvptn.setValorIpi(0.0);
         mvptn.setValorIcms((valorUnitario)*(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getPercentual()));
         mvptn.setCsosn(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcsosn()).getNumero()));
         if(me == mc && (cbFinalidade.getSelectionModel().getSelectedIndex() == 3)){
         mvptn.setCfop("5202");    
         }
         else if(me != mc && (cbFinalidade.getSelectionModel().getSelectedIndex() == 3)){
         mvptn.setCfop("6202");    
         }
         else if(me == mc && (cbFinalidade.getSelectionModel().getSelectedIndex() != (3))){
        mvptn.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcfop()).getCfop()));
         }
         else if(me != mc && (cbFinalidade.getSelectionModel().getSelectedIndex() != (3))){
        mvptn.setCfop("6"+(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcfop()).getCfop())).substring(1,4));
         }
         mvptn.setBtEdita(btEditaLocal);
         mvptn.setBtRemove(btRemoveLocal);
        
        listavendidos.add(mvptn);
        iniciaBotoes();
        ordem ++;
        
        atualizarTabela();
        totalgeralfracao = (Double.parseDouble(total.getText()) + totalgeralfracao);
        tfTotalGeral.setText(String.valueOf(totalgeralfracao));
        tfTotalPag.setText(String.valueOf(totalgeralfracao));
        totalgeralProdutos.setText(String.valueOf(totalgeralfracao));
        tfTotalProdutosItens.setText(String.valueOf(totalgeralfracao));
        total.setText(String.valueOf(totalgeralfracao));
        limpaTelaNovoProduto();

        
     }
     public void descontoComPonto(){
     tfDescontos.setText(bLMascaras.converterVirgulaParaPonto(tfDescontos.getText()));
     tfTotalGeral.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(Double.parseDouble(tfTotalGeral.getText()) - Double.parseDouble(tfDescontos.getText())));
     tfTotalPag.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(Double.parseDouble(tfTotalPag.getText()) - Double.parseDouble(tfDescontos.getText())));
     }
     
     
    public void listaEnter(){
        campos.add(nomeCliente);
        campos.add(telefoneCliente);
        campos.add(produto);
        campos.add(quantidade);
        campos.add(preco);
        campos.add(total);
                  
       }
    public void setNextFocus(TextField produto, TextField quantidade, TextField preco) {
        
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
            listaTelefones.add(listaModelClientes.get(i).getTelefone());
        }
         }   
         
        public void procuraProduto() {
            String campoProduto = produto.getText();
            if (campoProduto.matches("-?\\d+")){
            retornarprodutoPeloCodigo(Integer.parseInt(campoProduto));
        }else{
            retornarprodutoPeloNome();
            }
        }
        
        public void retornarprodutoPeloNome() {
        //INICIO recupera o nome
        if(produto.getText() != ""){
        modelProdutos = controllerProdutos.getProdutosController(produto.getText());
        
        this.preco.setText(String.valueOf(bLMascaras.truncamentoComPontoDuasCasasDouble(modelProdutos.getValor())));
        this.quantidade.setText("1");
        //FIM recupera o nome
       total.setText(calcularValorproduto(this.quantidade.getText(), this.preco.getText()) + "");
       valorUnitario = (modelProdutos.getValor());
       codigoProduto = (modelProdutos.getCodigo());
        }
    }
        public void retornarprodutoPeloCodigo(int codigo) {
        //INICIO recupera o nome
        if(produto.getText() != ""){
        modelProdutos = controllerProdutos.getProdutosControllerCodigo(codigo);
        
        this.preco.setText(String.valueOf(bLMascaras.truncamentoComPontoDuasCasasDouble(modelProdutos.getValor())));
        this.quantidade.setText("1");
        //FIM recupera o nome
       total.setText(calcularValorproduto(this.quantidade.getText(), this.preco.getText()) + "");
       valorUnitario = (modelProdutos.getValor());
       codigoProduto = (modelProdutos.getCodigo());
       produto.setText(modelProdutos.getDescricaoProduto());
        }
    }
         
        private void retornarprodutoPeloCodBarrasPeso() {
        //INICIO recupera o codigo de barras
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(String.valueOf(Integer.parseInt(produto.getText().substring(2, 5))));
        
        double totalBarras = ((Double.parseDouble(this.produto.getText().substring(7, 12)))* 0.01);
        double pesoBarras = (bLMascaras.truncamentoComPontoTresCasasDouble(totalBarras / (modelProdutos.getValor())));
        
        this.preco.setText(String.valueOf(modelProdutos.getValor()) );
        this.quantidade.setText(String.valueOf(pesoBarras));
        //FIM recupera o nome
       total.setText(calcularValorproduto(this.quantidade.getText(), this.preco.getText()) + "");
       produto.setText(modelProdutos.getNome());
       codigoProduto = (modelProdutos.getCodigo());
       produto.requestFocus();
       
    }
        private void retornarprodutoPeloCodBarras() {
        //INICIO recupera o codigo de barras
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(produto.getText());
        preco.setText(String.valueOf(modelProdutos.getValor()));
        quantidade.setText("1");
        //FIM recupera o nome
        codigoProduto = (modelProdutos.getCodigo());
        produto.setText(modelProdutos.getNome());
        produto.requestFocus();
    }
        
         
         private double calcularValorproduto(String pValorUnitario, String pQuantidade) {
        double valorTotalLocal = 0.000, valorUnitario = 0.000, quantidade = 0.000;
        try {
            quantidade = bLMascaras.converterVirgulaParaPontoReturnDouble(pQuantidade);
        } catch (NumberFormatException e) {
            quantidade = 0.000;
        }
        try {
            valorUnitario = bLMascaras.converterVirgulaParaPontoReturnDouble(pValorUnitario);
        } catch (Exception e) {
            valorUnitario = 0.000;
        }
        try {
            valorTotalLocal = valorUnitario * quantidade;
        } catch (Exception e) {
            
            valorTotalLocal = 0.000;
        }
        return (bLMascaras.arredondamentoComPontoDuasCasasDouble(valorTotalLocal));
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
    
    public String retornarIbpt(int codigoVendaretorno){
        ControllerIbpt controllerIbpt = new ControllerIbpt();
        controllerNCM = new ControllerNCM();
        ArrayList<ModelVendasProdutos> produtosIbpt = controllerVendasProdutos.getListaVendasProdutosController(codigoVendaretorno);
        String ibptNota = "";
        double estadual = 0.0, municipal = 0.0, federal = 0.0;
        for (int i=0; i < produtosIbpt.size(); i++ ){
            int ncmibpt = Integer.parseInt(controllerProdutos.getProdutosController(produtosIbpt.get(i).getCodigo_produto()).getNcm());
            double valoribpt = produtosIbpt.get(i).getValorTotal();
            estadual +=((controllerIbpt.getIBPTController(ncmibpt).getEstadual()/100)*valoribpt);
            federal += ((controllerIbpt.getIBPTController(ncmibpt).getImportadosfederal()/100)*valoribpt);
            federal +=((controllerIbpt.getIBPTController(ncmibpt).getNacionalfederal()/100)*valoribpt);
            municipal +=((controllerIbpt.getIBPTController(ncmibpt).getMunicipal()/100)*valoribpt);
        }
        ibptNota = "Tributos incidentes aproximados =  ESTADUAL: "+ bLMascaras.truncamentoComPontoDuasCasasDouble(estadual) 
                + " FEDERAL: " +bLMascaras.truncamentoComPontoDuasCasasDouble(federal)
                +" MUNICIPAL: " +bLMascaras.truncamentoComPontoDuasCasasDouble(municipal);
        return ibptNota;
    }
   
   private void preencherTabela(){
        String nomeproduto = (produto.getText());
        valorUnitario = (bLMascaras.truncamentoComPontoDuasCasasDouble(bLMascaras.converterVirgulaParaPontoReturnDouble(preco.getText())));
        modelProdutos = controllerProdutos.getProdutosController(nomeproduto);
        if (quantidade.getText().equals("") || quantidade.getText().equals("0")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Você deve informar a quantidade para adicionar!");
            alert.show();
         } else {
            //verifica a quantidade em estoque
            
            if ((modelProdutos.getEstoque()) < (bLMascaras.converterVirgulaParaPontoReturnDouble(quantidade.getText()))) {
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim");
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("Erro de estoque");
                dialogoExe.setHeaderText("Quantidade Acima do permitido");
                dialogoExe.setContentText("Você não tem essa quantidade de produto em estoque!\n"
                        + "Quantidade atual de " + modelProdutos.getNome() + " é " + modelProdutos.getEstoque() + "\n"
                                + "Deseja efeuar a venda do produto mesmo assim?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        adcionar();
                        } else if (b == btnNao) {
                            
                        }
                });
               
            } else {
                adcionar();
            }
            }
                 }
  
   
   public String gerarDv(String chaveCompleta){
       String chave = "";
       pond = 2;
       soma = 0;
       
       for (int i = 42 ; i>0; i--){
           int dig = (Integer.parseInt(chaveCompleta.substring(i, i+1)) * pond);
           if (pond < 9){
               pond = pond + 1;
               
           }else{
               pond = 2;
           }
           soma = soma + dig;
       }
       resto = (soma % 11);
       if (resto == 0){
           dv = 0;
           
       }else{
           dv = 11 - resto;
       }
       chave = chaveCompleta + (String.valueOf(dv));
       
       return chave;
   }
   
   public void chaveAcesso(){
       ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
       String chavePre = "";
       String codUf = (String.valueOf(controllerClienteCidadeEstado.getClienteCidadeEstadoController(controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCodigo()).getModelEstado().getCodigo()));
       mesAnoEmissao = ((bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5))+(bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(8, 10)));
       String cnpjEmit = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
       String modelo = "55";
       String serie = "001";
       String numero = "009152311";
       String tipoEmissao = "1";
       String codigoAcesso = "88725117";
       
       
       chavePre = (codUf+mesAnoEmissao+cnpjEmit+modelo+serie+numero+tipoEmissao+codigoAcesso);
       chaveCriada = gerarDv(chavePre);
       
       
          
   }
   
  
   
   
   public boolean gerarProdutosNfe(int codigoVendaretorno) throws IOException, ParseException {
                
       String indiceProduto;  
       String produtoLocal;
          
                modelXmlNfe = new ModelXmlNfe();
                modelNFCe = new ModelNFCe();
                modelEmpresa = new ModelEmpresa();
                modelProdutos = new ModelProdutos();
                modelVendas = new ModelVendas();
                modelVendasProdutos = new ModelVendasProdutos();
                modelTributacaoEstadual = new ModelTributacaoEstadual();
                modelTributacaoFederal = new ModelTributacaoFederal();
                controllerProdutos = new ControllerProdutos();
                controllerVendas = new ControllerVendas();
                controllerEmpresa = new ControllerEmpresa();
                controllerCFOP = new ControllerCFOP();
                controllerCsosn = new ControllerCsosn();
                controllerCsosnFederal = new ControllerCsosnFederal();
                controllerCst = new ControllerCst();
                controllerCstPiscofins = new ControllerCstPiscofins();
                controllerNCM = new ControllerNCM();
                controllerTributacaoEstadual = new ControllerTributacaoEstadual();
                controllerTributacaoFederal = new ControllerTributacaoFederal();
                controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
                controllerModeloIpi = new ControllerModeloIpi();
                
                
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
         
         listaVendidos = controllerVendasProdutos.getListaVendasProdutosController(codigoVendaretorno);
            
         
            
          for (int i = 0; i < listaVendidos.size() ; i++) {      
                modelProdutos = new ModelProdutos();
                modelEmpresa = controllerEmpresa.getEmpresaController(1).getModelEmpresa();
                indiceProduto = "0"+(i+1);
                         if ((i+1) > 9){
                    indiceProduto = ""+(i+1);
                }
produtoLocal = "[Produto00"+(i+1)+"]\n" +
"CFOP="+listaVendidos.get(i).getCfop() +"\n" +
"Codigo="+listaVendidos.get(i).getCodigo_produto() +"\n" +
"cEAN=SEM GTIN\n" +
"Descricao="+controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getNome() +" \n" +
"NCM="+controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getNcm()+"\n" +
"Unidade="+controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getUnidadeMedida()).getAbreviacao() +"\n" +
"Quantidade="+bLMascaras.converterPontoPraVirgula(String.valueOf(listaVendidos.get(i).getQuantidade())) +"\n" +
"ValorUnitario="+bLMascaras.converterPontoPraVirgula(String.valueOf(listaVendidos.get(i).getValorUnitario())) +"\n" +
"ValorTotal="+bLMascaras.converterPontoPraVirgula(String.valueOf((listaVendidos.get(i).getQuantidade())*(listaVendidos.get(i).getValorUnitario())))+"\n" +
"ValorDesconto="+bLMascaras.converterPontoPraVirgula(String.valueOf(Float.parseFloat(tfDescontos.getText()) / listaVendidos.size()))+"\n" +
"vFrete=0,00\n" +
"vSeg=0,00\n" +
"vOutro=0,00\n" +
"indEscala=N\n" +
"uTrib="+controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getUniFisco()).getAbreviacao()+"\n" +
"cEANTrib=SEM GTIN\n" +
"\n" +
preencheGlp(i)+
"\n" +       
"[ICMS0"+(indiceProduto)+"]\n" +
"CSOSN=" + controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getIdcsosn()).getNumero() +"\n"+
"Origem="+controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getOrigem()+"\n" +
"ValorBase=" +bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo())) + "\n" +
"Aliquota=" +bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getPercentual()))+"\n" +
"Valor=" +bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo()))+"\n" +
"pCredSN=" +bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculosub()))+"\n" +
"vCredICMSSN=" +bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculosubefetivo()))+"\n" +
"ModalidadeST=4\n" +
"ValorBaseST=0,00\n" +
"AliquotaST=0,00\n" +
"ValorST=0,00\n" +
"PercentualReducao=0,00\n" +
"vBCFCP=0\n" +
"pFCP=0\n" +
"vFCP=0\n" +
"\n" +

"[PIS0"+(indiceProduto)+"]\n" +
"CST="+controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribFed()).getIdPisCofins()).getNumero() +"\n" +
"ValorBase=0,00\n" +
"Aliquota=0,00\n" +
"Valor=0,00\n" +
"\n" +

"[COFINS0"+(indiceProduto)+"]\n" +
"CST=" +controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribFed()).getIdPisCofins()).getNumero()+"\n" +
"ValorBase=0,00\n" +
"Aliquota=0,00\n" +
"Valor=0,00\n" +
"\n" +
"[IPI0"+(indiceProduto)+"]\n" +
"CST="+controllerModeloIpi.getIPIController(Integer.parseInt(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getIpi())).getCstSaida()+"\n" +
"cEnq="+controllerModeloIpi.getIPIController(Integer.parseInt(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getIpi())).getEnquadramento()+"\n" +
"ValorBase=0,00\n" +
"Aliquota=0,00\n" +
"Valor=0,00\n" +
"\n";
totalBaseCalculoIcms = (controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo()) + totalBaseCalculoIcms;
totalValorIcms = (controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo()) + totalValorIcms;
produtoNFe = produtoNFe + produtoLocal;
   }
    return true;    
   }
   
   private String preencheGlp(int indice){
String glp;
       if (controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getTipo() == 1){
glp = "[Combustivel00"+(indice+1)+"]\n" 
+"descANP="+controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getDescricaoAnp() + "\n"
+"cProdANP="+controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getCodProdutoAnp() + "\n"
+"pMixGN=1\n"
+"UFCons="+controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getEstadoConsumidor()+ "\n"
+"pGNn="+controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getPercGnn()+ "\n"
+"pGNi="+controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getPercGni() + "\n"
+"pGLP="+controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getPercGlp() + "\n";
} else{
    glp = "";
}
return glp;
}
   
   public boolean carregarIniNfe(int codigoVendaretorno, float total) throws IOException, ParseException, Exception{
    String tipoCliente;
    String docCliente;
    if(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ().length() > 9 && 
            ((controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 52) 
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 35)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 13)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 29)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 23)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 31)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 50)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 51)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 15)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 54)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 24)  
            ||(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado() == 28))){
        tipoCliente = "9";
        docCliente = "CNPJCPF="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ()+" \n"+
                     "IE="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getInscricao()+" \n";
        
    }else if(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ().length() < 12){
        tipoCliente = "9";
        docCliente = "CNPJCPF="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ()+" \n";
        
    }else if((controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ().length() > 9) && 
            (controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getInscricao().length() > 5) ){
        tipoCliente = "1";
        docCliente = "CNPJCPF="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ()+" \n" +
                     "IE="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getInscricao()+" \n";
    }else{
        tipoCliente = "2";
        docCliente = "CNPJCPF="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCpfCNPJ()+" \n";
    }
            
       if (gerarProdutosNfe(codigoVendaretorno) == true){
        modelVendas = new ModelVendas();
        
        LocalDate dataDeInscricao = LocalDate.now();  
        String data = dataDeInscricao.toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar hora = Calendar.getInstance();
        String serieNfe = String.valueOf(controllerNumeracao.getNumeracaoController(1).getSerieNfe());
        String numeroNfe = String.valueOf(controllerNumeracao.getNumeracaoController(1).getNumeroNfe());
        modelVendas = controllerVendas.getVendasController(codigoVendaretorno);
                
        chaveAcesso();   
        
     
            arquivoINI = "[infNFe]\n" +
                    "\n" +
                    "versao=4.0\n" +
                    "\n" +
                    "[Identificacao]\n" +
                    "natOp="+cbNatOperacao.getValue()+"\n" +
                    "indPag="+cbFormaPag.getSelectionModel().getSelectedIndex()+"\n" +
                    "mod=55\n" +
                    "serie="+serieNfe+"\n" +
                    "nNF=" +numeroNfe+"\n" +
                    "dEmi=" +(dpEmissao.getValue().format(DateTimeFormatter.BASIC_ISO_DATE)).substring(6,8) + "/" 
                            +(dpEmissao.getValue().format(DateTimeFormatter.BASIC_ISO_DATE)).substring(4,6)+"/"
                            +(dpEmissao.getValue().format(DateTimeFormatter.BASIC_ISO_DATE)).substring(0,4)+ " "
                            +(String.valueOf((new java.util.Date(System.currentTimeMillis()))).substring(11 , 19)) +"\n" +
                    "tpNF=1\n" +
                    "Finalidade="+(cbFinalidade.getSelectionModel().getSelectedIndex()+1)+"\n" +
                    "idDest="+(idDestino)+"\n" +
                    "indFinal="+cbTpConsumidor.getSelectionModel().getSelectedIndex()+"\n" +
                    "indPres="+(cbIdConsumidor.getValue().toString().substring(0, 1))+"\n" +
                    "tpimp=1\n" +
                    "tpAmb="+1+"\n" +
                    "\n" +
                    "[Emitente]\n" +
                    "CRT="+modelEmpresa.getCrt()+" \n" +
                    "CNPJ="+modelEmpresa.getCnpj()+" \n" +
                    "IE="+modelEmpresa.getInscEstad()+" \n" +
                    "Razao="+modelEmpresa.getRazaoSocial()+" \n" +
                    "Fantasia="+modelEmpresa.getNomeFantasia()+" \n" +
                    "Fone="+modelEmpresa.getTelefone()+" \n" +
                    "CEP="+modelEmpresa.getCep()+" \n" +
                    "Logradouro="+modelEmpresa.getEndereco()+" \n" +
                    "Numero="+modelEmpresa.getEnderecoNumero()+" \n" +
                    "Complemento="+modelEmpresa.getEnderecoComplemento()+" \n" +
                    "Bairro="+modelEmpresa.getBairro()+" \n" +
                    "CidadeCod="+controllerCidade.getCidadeController(controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(modelEmpresa.getCodigo()).getModelCidade().getCodigo()).getCodigoIBGE()+" \n" +
                    "Cidade="+controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(modelEmpresa.getCodigo()).getModelCidade().getNome()+" \n" +
                    "UF="+controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(modelEmpresa.getCodigo()).getModelEstado().getUf()+" \n" +
                    "\n" +
                    "[Destinatario]\n" +
                    "indIEDest="+tipoCliente+" \n" +
                    docCliente+                   
                    "NomeRazao="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getNome()+" \n" +
                    "Fone="+String.valueOf(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getTelefone())+" \n" +
                    "CEP="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCep()+" \n" +
                    "Logradouro="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getEndereco()+" \n" +
                    "Numero="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getNumero()+" \n" +
                    "Complemento="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getReferencia()+" \n" +
                    "Bairro="+controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getBairro()+" \n" +
                    "CidadeCod="+controllerCidade.getCidadeController(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodCidade()).getCodigoIBGE()+" \n" +
                    "Cidade="+controllerCidade.getCidadeController(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodCidade()).getNome()+" \n" +
                    "UF="+controllerEstado.getEstadoControllerCod(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getCodEstado()).getUf()+" \n" +
                    "\n" +
                    
                    produtoNFe +
                    
                    "[Total]\n" +
                    "BaseICMS=" + bLMascaras.converterPontoPraVirgula(String.valueOf(tfBcIcms.getText()))+"\n" +
                    "ValorICMS="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfValorIcms.getText()))+"\n" +
                    "vICMSDeson="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfValorIcms.getText()))+"\n" +
                    "BaseICMSSubstituicao="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfBcSubst.getText()))+"\n" +
                    "ValorICMSSubstituicao="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfValorSubst.getText()))+"\n" +
                    "ValorProduto="+bLMascaras.converterPontoPraVirgula(String.valueOf(totalgeralProdutos.getText())) +"\n" +
                    "ValorFrete="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfFrete.getText()))+"\n" +
                    "ValorSeguro="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfSeguro.getText()))+"\n" +
                    "ValorDesconto="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfDescontos.getText()))+"\n" +
                    "ValorIPI="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfValorIpi.getText()))+"\n" +
                    "ValorPIS="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfPisProdutos.getText()))+"\n" +
                    "ValorCOFINS="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfCofinsProdutos.getText()))+"\n" +
                    "ValorOutrasDespesas="+ bLMascaras.converterPontoPraVirgula(String.valueOf(tfOutrasDespesas.getText()))+"\n" +
                    "ValorNota="+bLMascaras.converterPontoPraVirgula(String.valueOf(total))+"\n" +
                    "vFCP=0\n" +
                    "\n" +
                    
                    "[DadosAdicionais]\n" +
                    "Complemento="+ taDadosAdcionais.getText()+" Documento emitido por empresa optante pelo Simples nacional, Não gera direito a crédito fiscal " +retornarIbpt(codigoVendaretorno) + " Fonte ibpt "+"\n" +
                    "\n" +
                    
                    "[Transportador]\n" +
                    "modFrete=9\n" +
                    "\n" +
                    
                    "[pag001]\n" +
                    "tPag="+ bLMascaras.converterPontoPraVirgula(String.valueOf(cbFormaPag.getSelectionModel().getSelectedIndex()))+"\n" +
                    "vPag="+bLMascaras.converterPontoPraVirgula(String.valueOf(total))+"\n" +
                    "\n" +
                    
                    "[infRespTec]\n" +
                    "CNPJ=03847419000171\n" +
                    "xContato=Fabio Braga\n" +
                    "email=fabio.braga.suporte@gmail.com\n" +
                    "fone=2730308326";
           
                manipularXml.gravaININfce(arquivoINI, chaveCriada);
    
       return true;
    } else{
        return false;
    }
   }
   public int procuraRetorno(String retorno, String procura ){
        int indice = 0;
        if(retorno.contains(procura)){
            indice  = retorno.indexOf(procura);
        }
        return indice;
    }
   

public String escolheArq() {
   FileChooser fileChooser = new FileChooser ();
   fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Arquivo XML", "*.xml"));
   File selectedFile = fileChooser.showOpenDialog (null);

if (selectedFile != null) {

   return selectedFile.getPath();
   
}
else {
    return null;
}

}
   
   
   public void importarNfeSaida(){
       String caminhoImportar = escolheArq();
       int codigoVenda= 0;
            lerArqxml = new LerArqXML();
       ViewLeitorNotaXML leitorNotaXml = new ViewLeitorNotaXML();
       try {
       leitorNotaXml.lerarq(caminhoImportar, 161);
        } catch (Exception ex) {
            Logger.getLogger(nfeSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void transmitirNfe(int codigoVendaretorno, float valorTotal) throws IOException, ParseException, Exception{
       acbrNFe = new ACBrNFe();
       int metodoNfce = controllerConfiguracao.getConfiguracaoController(1).getMetodoEnvioNfce();
       codigoVenda = codigoVendaretorno;
       String caminho = "C:\\UniShop\\dfe\\"+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\Enviado\\Nfe\\"+(bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(6, 10)) + ((bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5)));
       
       String chaveDFE  = "chDFe=";
       String status = "cStat=";
       String motivoErro = "xMotivo=";
       String ret = "";
       acbrNFe.limparLista(); 
       if(carregarIniNfe(codigoVendaretorno, valorTotal) == true){
            acbrNFe.carregarIni(arquivoINI); 
                ret = acbrNFe.enviar(1);
            int inicioStatus = (procuraRetorno(ret,status)+status.length());
            int inicioMotivo = (procuraRetorno(ret,motivoErro)+motivoErro.length());
            if (ret.substring(inicioStatus, inicioStatus +3).equals("100")){
            int tamanhochaveDFE = chaveDFE.length();
            int inicio = ((procuraRetorno(ret,chaveDFE))+tamanhochaveDFE);
            String nomeArquivo = ret.substring(inicio,(inicio + 44) )+"-nfe.xml";
            acbrNFe.gravarXml(0, nomeArquivo, caminho );
            if (gravaNFeNoBanco(nomeArquivo,caminho) == true){
                enviarEmailNfe(caminho+"\\"+nomeArquivo+"-nfe.xml", codigoVenda);
            }
            int atualizaNumero =  controllerNumeracao.getNumeracaoController(1).getNumeroNfe();
            controllerNumeracao.atualizarNumeracaoNfeController(atualizaNumero);
            acbrNFe.imprimir();
            
            }else{
            classeInterfaces.avisaOuvintesRejeicao("pdv",(ret.substring(inicioMotivo)));    
            }
       }else{
        classeInterfaces.avisaOuvintesRejeicao("pdv",("Arquivo não encontrado"));    
       }
       
   }
   
   
   public void enviarEmailNfe(String chaveDfe, int codigoVendaRetorno) throws Exception{
       ACBrNFe acb = new ACBrNFe();
       modelVendas = controllerVendas.getVendasController(codigoVendaRetorno);
       int codigoCliente = modelVendas.getClientesCodigo();
       String emailCliente = "";
       if (codigoCliente != 0){
        emailCliente = controllerCliente.getClienteControllerCod(codigoCliente).getEmail();
       }

       if (emailCliente.length() > 5){
        try {
            acb.enviarEmail(emailDialogo, chaveDfe, true, "Nota Fiscal Emitida","",chaveDfe,"Qualquer dúvida estamos à Disposição");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setTitle("SUCESSO");
            alert.setContentText("EMAIL ENVIADO COM SUCESSO");
            alert.show();
            
        } catch (Exception ex) {
            Logger.getLogger(nfeSaida.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setTitle("ERRO");
            alert.setContentText("EMAIL NÃO ENVIADO");
            alert.show();
        }
        
        }else{
            TextInputDialog dialogoNome = new TextInputDialog();
            
            dialogoNome.getDialogPane().getStylesheets().add("/FXView/alert.css");
            dialogoNome.setTitle("Enviar email");
            dialogoNome.setHeaderText("Digite o email ==============================>");
            dialogoNome.setContentText("Email:");
            // se o usuário fornecer um valor, assignamos ao nome
            dialogoNome.showAndWait().ifPresent(v -> emailDialogo = v);
            
            try {
            if (emailDialogo != null){
            acb.enviarEmail(emailDialogo, chaveDfe, true, "Nota Fiscal Emitida","fiscalunifor@gmail.com",chaveDfe,"email teste");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setTitle("SUCESSO");
            alert.setContentText("EMAIL ENVIADO COM SUCESSO");
            alert.show();
            }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setTitle("ERRO");
            alert.setContentText("EMAIL NÃO ENVIADO");
            alert.show();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(nfeSaida.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setTitle("ERRO");
            alert.setContentText("EMAIL NÃO ENVIADO");
            alert.show();
        }
            
            
       }
       
   }
   
    /**
     *
     * @param nomeArquivo
     * @param caminho
     */
    public Boolean gravaNFeNoBanco(String nomeArquivo, String caminho) throws Exception{
       String caminhoArquivo = caminho+ "\\"+nomeArquivo;
       ViewLeitorNotaXML leitorNotaXml = new ViewLeitorNotaXML();
       
       lerArqxml = new LerArqXML();
              
       leitorNotaXml.lerarq(caminhoArquivo, codigoVenda);
       return true;
   }
  
   public void nfeFinalizar(){
       if (tfPedido.getText().equals("NOVO")){
           cadastrarVenda();
       }
       Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim");
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                dialogoExe.setTitle("GERAR NFE");
                dialogoExe.setContentText("Deseja Emitir Nfe agora?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) {
       gerarNfe();
       listaSaidas();
    }
    });
   }
   
   public void listaSaidas(){
        listaVendas lv = new listaVendas();
        try {
            lv.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
   
   public void nfeSalvar(){
       cadastrarVenda();
   }
   
    public boolean cadastrarVenda() {
        controllerCFOP = new ControllerCFOP();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar hora = Calendar.getInstance();
        
          if (total.getText().equals("") || listadeProdutos.size() < 1) {
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
                modelVendas.setDesconto(0f);
                modelVendas.setTaxaEntrega(0f);
                modelVendas.setValorTotal(Float.parseFloat(tfTotalGeral.getText()));
                modelVendas.setObservacao(taDadosAdcionais.getText());
                modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataStringDataHifen(dpEmissao.getValue().format(DateTimeFormatter.ISO_DATE)));
                    modelVendas.setHoraVenda(dateFormat.format(hora.getTime()));
                } catch (Exception ex) {
                    Logger.getLogger(nfeSaida.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProdutolocal = (listadeProdutos.get(i).getCodigo_produto());
                modelVendas.setProdutosCodigo(codigoProdutolocal);
                modelVendas.setVencimento("");
                modelVendas.setTipo(55);
                modelVendas.setValor(bLMascaras.truncamentoComPontoDuasCasasDouble(listadeProdutos.get(i).getValorUnitario()));
                modelVendas.setQuantidade(listadeProdutos.get(i).getQuantidade());
                modelVendas.setCfop(listadeProdutos.get(i).getCfop());
                modelVendas.setIcmsCst(listadeProdutos.get(i).getIcmsCst());
                modelVendas.setIpiCst(listadeProdutos.get(i).getIpiCst());
                modelVendas.setPisCst(listadeProdutos.get(i).getPisCst());
                modelVendas.setCofinsCst(listadeProdutos.get(i).getCofinsCst());
                modelVendas.setSubTribut(listadeProdutos.get(i).getSubTribut());
                modelVendas.setOrdem(listadeProdutos.get(i).getOrdem() - 1);
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
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            
        

           //salvar venda
         if (!(tfPedido.getText().equals("NOVO"))){
               modelVendas.setCodigo(Integer.parseInt(tfPedido.getText()));
               
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
                
           }else if (tfPedido.getText().equals("NOVO")) {
               codigoVenda = controllerVendas.salvarVendasController(modelVendas);
               tfPedido.setText(String.valueOf(codigoVenda));
                      
                       
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
        produto.setFocusTraversable(true);
        quantidade.setFocusTraversable(true);
        preco.setFocusTraversable(true);
        total.setFocusTraversable(true);
        pnAlteraProduto.setVisible(false);
        apAlteraProduto.setVisible(false);
        ordem = 1;
        totalgeralfracao = 0.0d;
    
    }
    private void limpaTelaNovoProduto() {
        quantidade.setText("1");
        produto.setText("");
        preco.setText("");
        contVendaMenor = 0;
       
    }
    private void saidaTabela() {
        quantidade.setText("1");
        produto.setText("");
        preco.setText("");
        contVendaMenor = 0;
        tabelaProdutos.setFocusTraversable(false);
        produto.requestFocus();
              
    }
    public void contaReceber() throws Exception{
                   
        ModelContaReceber Modelcontareceber = new ModelContaReceber();
        ControllerContaReceber Controllercontareceber = new ControllerContaReceber();
               
        Modelcontareceber.setCodigoPessoa(codigoCliente);
        //Modelcontareceber.setDescricao(nomeCliente.getText());
        Modelcontareceber.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
       // Modelcontareceber.setVencimento(bLMascaras.converterDataStringData(vencimento.getText()));
        Modelcontareceber.setValor(valorVale);
        Modelcontareceber.setSituacao(0);
        Modelcontareceber.setPagamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        Modelcontareceber.setTipoPagamento(codPagamento);
        Modelcontareceber.setObservacao(this.tfPedido.getText());
        
        Controllercontareceber.salvarContaReceberController(Modelcontareceber);
 
    }  
    public void gerarNfe(){
        int codigo;
        if(tfPedido.equals("")){
            codigo = codigoVenda;
        }else{
            codigo = Integer.parseInt(tfPedido.getText());
        }
        
        float valorTotal = bLMascaras.converterVirgulaParaPontoReturnFloat(tfTotalGeral.getText());
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        classeInterfaces.avisaOuvintesProgresso("pdv",Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
                try{
                    transmitirNfe(codigo, valorTotal);
                }catch(Exception e)
                        { System.out.println(e);
                    
                }
                classeInterfaces.avisaOuvintesProgresso("pdv",Boolean.FALSE);
            }
       };
        t.start();
                }
    
    
   
    private void definirDatas(){
        
        // define a data de vencimento pra 7 dias
        
         dataAtual = (bLMascaras.addDias(7 ,new java.util.Date(System.currentTimeMillis())));
                                try {
                               
              //  vencimento.setText(bLMascaras.formatarData(dataAtual));
                
                } catch (Exception ex) {
                    
                    
                }
        
    }
    
    public void limparCamposVenda(){
        produto.clear();
        quantidade.clear();
        total.clear();
        total.clear();
        preco.clear();
        totalgeralfracao = 0.0d;
        tabelaProdutos.getItems().clear();
        tfPedido.setText("NOVO");
        dpDigitacao.setValue(LocalDate.now());
        dpEmissao.setValue(LocalDate.now());
        cbFinalidade.setValue("Nfe - Normal");
        cbNatOperacao.setValue("Venda");
        cbFormaPag.setValue("DINHEIRO");
        cbIdConsumidor.setValue("0 - Não se Aplica");
        cbTpConsumidor.setValue("Normal");
        cbModeloFrete.setValue("Sem Frete");
        tfBcIcms.setText("0.0");
        tfBcSubst.setText("0.0");
        TfBcIpi.setText("0.0");
        tfDescontos.setText("0.0");
        tfFrete.setText("0.0");
        tfOutrasDespesas.setText("0.0");
        tfPisProdutos.setText("0.0");
        tfSeguro.setText("0.0");
        tfTotalPag.setText("0.0");
        tfValorIcms.setText("0.0");
        tfValorIpi.setText("0.0");
        tfValorSubst.setText("0.0");
        tfCofinsProdutos.setText("0.0");
        
    }
    public void lancamento() throws Exception{
       // cadastrarVenda();
        limparCamposVenda();
        produto.requestFocus();
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
            tfPedido.setText(String.valueOf(modelVendas.getCodigo()));
            totalgeralProdutos.setText(String.valueOf(modelVendas.getValorTotal()));
            tfTotalGeral.setText(String.valueOf(modelVendas.getValorTotal()));
            tfTotalProdutosItens.setText(String.valueOf(modelVendas.getValorTotal()-modelVendas.getDesconto()));
            tfTotalPag.setText(String.valueOf(modelVendas.getValorTotal()));
            total.setText(String.valueOf(modelVendas.getValorTotal()));
            nomeCliente.setText(controllerCliente.getClienteControllerCod(modelVendas.getClientesCodigo()).getNome());
            retornarClientePeloNome();
            //recupera os dados do banco
           int cont = listamodel.size();
            for (int i = 0; i < cont; i++){
                ModelVendasProdutosTabelaNfe mvptn = new ModelVendasProdutosTabelaNfe();
                listavendidos = new ArrayList<>();
                mvptn.setOrdem(i+1);
                mvptn.setProduto(controllerProdutos.getProdutosController(listamodel.get(i).getCodigo_produto()).getDescricaoProduto());
                mvptn.setQuantidade(listamodel.get(i).getQuantidade());
                mvptn.setValorUnitario(listamodel.get(i).getValorUnitario());
                mvptn.setValorTotal(bLMascaras.truncamentoComPontoDuasCasasDouble(listamodel.get(i).getQuantidade() * listamodel.get(i).getValorUnitario()));
                mvptn.setAliqIcms(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getPercentual());
                mvptn.setAliqIpi(0.0);
                mvptn.setAliqSubst(0.0);
                mvptn.setValorIpi(0.0);
                mvptn.setValorSubst(0.0);
                mvptn.setValorIcms((listamodel.get(i).getValorUnitario())*(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getPercentual()));
                mvptn.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcfop()).getCfop()));
                mvptn.setCsosn(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(produto.getText()).getTribEst()).getIdcsosn()).getCodigo()));

            
                 listavendidos.add(mvptn);
                 //carregar lista de produtos da venda
            
            tabelaProdutos.getItems().addAll(listavendidos);
            totalgeralfracao = (Double.parseDouble(total.getText()));
            ordem = cont+1;            
            }
            
       
    }
    
    
    
    public void devolucaoNfe(int codigoDevolucaoVenda){
       //recupera informações 
       ModelCompras modelComprasDevolucao = new ModelCompras();
       modelComprasDevolucao = controllerCompras.getComprasController(codigoDevolucaoVenda);
       modelNF = controllerNF.getNFCompraCodigoController(codigoDevolucaoVenda);
       ArrayList<ModelComprasProdutos> produtosDevolucao = controllerComprasProdutos.getListacompras_produtosController(codigoDevolucaoVenda);
       
       // preenche cabeçalho
       cbNatOperacao.getSelectionModel().select(2);
       cbFinalidade.getSelectionModel().select(3);
       nomeCliente.setText(controllerFornecedor.getFornecedorController(modelNF.getCodCliente()).getNome());
       tfNfeReferencia.setText(modelNF.getChaveNfe());
       taDadosAdcionais.setText("Documento de devolução referente a nota fiscal: "+modelNF.getChaveNfe());
       retornarFornecedorPeloNome();
            
       
       //prenche produtos
       for (int i = 0; i < produtosDevolucao.size(); i++){
        ordem = produtosDevolucao.get(i).getOrdem();
        produto.setText(produtosDevolucao.get(i).getNomeProduto());
        quantidade.setText(String.valueOf(produtosDevolucao.get(i).getQuantidade()));
        preco.setText(String.valueOf(produtosDevolucao.get(i).getValorCusto()));
        valorUnitario = produtosDevolucao.get(i).getValorCusto();
        total.setText(String.valueOf(produtosDevolucao.get(i).getValorTotal()));
        
        adcionar();
    }
       
        
    }
    
    public void editarVenda(){
        retornarProdutoAoEstoque();
        controllerVendasProdutos.excluirVendasProdutosCodVendaController(Integer.parseInt(tfPedido.getText()));
        
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
            descontoAjuste = (0f);
        } catch (Exception e) {
            descontoAjuste = 0;
        }
                    valor = Float.parseFloat(String.valueOf(tfTotalGeral.getText()));
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
            double totalLocal = bLMascaras.truncamentoComPontoDuasCasasDouble((Double.parseDouble(totalgeralProdutos.getText())) - diminuir);
            totalgeralProdutos.setText(String.valueOf(totalLocal));
            tfTotalProdutosItens.setText(String.valueOf(totalLocal));
            totalgeralfracao = (Double.parseDouble(totalgeralProdutos.getText()));
            tfTotalPag.setText(String.valueOf(totalLocal));
            tfTotalGeral.setText(String.valueOf(totalLocal));
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
    public void verVendas(ActionEvent event) throws IOException{
        fecharNfe();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqVendas.fxml"));
        Parent raizVendas = (Parent) loader.load();
        listaVendas lVendas = loader.getController();
        Stage stageVendas = new Stage();
        stageVendas.setScene(new Scene(raizVendas));
        stageVendas.show();
        
    }
        public void listaProdutos() throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqProduto.fxml"));
        Parent entradaProduto = (Parent) loader.load();
        listaProduto novoProduto = loader.getController();
        novoProduto.habilitaBotalSelecionar();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaProduto));
        stage.show();
   
        
    }
        
        public void listaClientes(){
        listaCliente lCliente = new listaCliente();
        try {
            lCliente.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
    private void editarProduto(){
        ModelVendasProdutosTabelaNfe modelAlteraraqui = new ModelVendasProdutosTabelaNfe();
            linhaAlterar = tabelaProdutos.focusModelProperty().get().focusedCellProperty().getValue().getRow();
            tabelaProdutos.getSelectionModel().select(linhaAlterar);
            String produto = tabelaProdutos.getItems().get(linhaAlterar).getProduto();
            modelAlteraraqui = tabelaProdutos.getItems().get(linhaAlterar);
            listaVendidos.addAll(listamodel);
            pnAlteraProduto.setVisible(true);
            apAlteraProduto.setVisible(true);
            recuperaProdutoAlterar(modelAlteraraqui);
            
    }
    
    
    private void inicializacbCsnosn(){
    ArrayList<ModelCsosn> modelCsosn = controllerCsosn.getListaCsosnController();
        ArrayList<String> Csosn = new ArrayList<>();
        modelCsosn.stream()
                .forEach(e-> Csosn.add(String.valueOf(e.getNumero())));
        cbCsosn.getItems().addAll(Csosn);
}
    
    
    private void recuperaProdutoAlterar(ModelVendasProdutosTabelaNfe modelAlterar){
        inicializacbCsnosn();
        edDesconto.setText("0,0");
        edProduto.setText(modelAlterar.getProduto());
        edPercIcms.setText(String.valueOf(modelAlterar.getAliqIcms()));
        edPercIpi.setText(String.valueOf(modelAlterar.getAliqIpi()));
        edPercSubst.setText(String.valueOf(modelAlterar.getAliqSubst()));
        edValorIcms.setText(String.valueOf(modelAlterar.getValorIcms()));
        edValorIpi.setText(String.valueOf(modelAlterar.getValorIpi()));
        edValorSubst.setText(String.valueOf(modelAlterar.getValorSubst()));
        edValorunitario.setText(String.valueOf(modelAlterar.getValorUnitario()));
        edValorTotal.setText(String.valueOf(modelAlterar.getValorTotal()));
        edValorTotalGeral.setText(String.valueOf(modelAlterar.getValorTotal()));
        edQuantidade.setText(String.valueOf(modelAlterar.getQuantidade()));
        edCfop.setText(String.valueOf(modelAlterar.getCfop()));
        cbCsosn.setValue(modelAlterar.getCsosn());
        valorAntesAlterar = modelAlterar.getValorTotal();
    }
    private void insereProdutoAlterado(){
        produtoalterar = new ModelVendasProdutosTabelaNfe();
        inicializacbCsnosn();
        produtoalterar.setDesconto(bLMascaras.converterVirgulaParaPontoReturnFloat(edDesconto.getText()));
        produtoalterar.setProduto(edProduto.getText());
        produtoalterar.setAliqIcms(bLMascaras.converterVirgulaParaPontoReturnFloat(edPercIcms.getText()));
        produtoalterar.setAliqIpi(bLMascaras.converterVirgulaParaPontoReturnFloat(edPercIpi.getText()));
        produtoalterar.setAliqSubst(bLMascaras.converterVirgulaParaPontoReturnFloat(edPercSubst.getText()));
        produtoalterar.setValorIcms(bLMascaras.converterVirgulaParaPontoReturnFloat(edValorIcms.getText()));
        produtoalterar.setValorIpi(bLMascaras.converterVirgulaParaPontoReturnFloat(edValorIpi.getText()));
        produtoalterar.setValorSubst(bLMascaras.converterVirgulaParaPontoReturnFloat(edValorSubst.getText()));
        produtoalterar.setValorUnitario(bLMascaras.converterVirgulaParaPontoReturnFloat(edValorunitario.getText()));
        produtoalterar.setValorTotal(bLMascaras.converterVirgulaParaPontoReturnFloat(edValorTotalGeral.getText()));
        produtoalterar.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(edQuantidade.getText()));
        produtoalterar.setCsosn(cbCsosn.getSelectionModel().getSelectedItem());
        produtoalterar.setCfop(edCfop.getText());
        produtoalterar.setOrdem(linhaAlterar+1);
        produtoalterar.setBtEdita(btEditaLocal);
        produtoalterar.setBtRemove(btRemoveLocal);
               
        iniciaBotoes();
        tabelaProdutos.getItems().set(linhaAlterar, produtoalterar);
        
        tabelaProdutos.refresh();
        
        pnAlteraProduto.setVisible(false);
        apAlteraProduto.setVisible(false);
        
        atualizaGeral(produtoalterar, valorAntesAlterar);
        atualizarmodelAlterado(produtoalterar);
    }
    
    public void atualizaTotalAlterado(){
    edValorTotal.setText(String.valueOf((bLMascaras.converterVirgulaParaPontoReturnFloat(edQuantidade.getText())*bLMascaras.converterVirgulaParaPontoReturnFloat(edValorunitario.getText()))));
    edValorTotalGeral.setText(String.valueOf((bLMascaras.converterVirgulaParaPontoReturnFloat(edQuantidade.getText())*bLMascaras.converterVirgulaParaPontoReturnFloat(edValorunitario.getText())) + Float.parseFloat(edValorSubst.getText())+ Float.parseFloat(edValorIpi.getText())));
}

    private void atualizaGeral(ModelVendasProdutosTabelaNfe modelAlterado, Double valorAntes){
        //atualizarTabela();
        totalgeralfracao = bLMascaras.arredondamentoComPontoDuasCasasDouble(modelAlterado.getValorTotal() + (totalgeralfracao - valorAntes));
        tfTotalGeral.setText(String.valueOf(totalgeralfracao));
        tfTotalPag.setText(String.valueOf(totalgeralfracao));
        totalgeralProdutos.setText(String.valueOf(totalgeralfracao));
        tfTotalProdutosItens.setText(String.valueOf(totalgeralfracao));
        tfValorIcms.setText(String.valueOf(Double.parseDouble(tfValorIcms.getText())+modelAlterado.getValorIcms()));
        tfValorIpi.setText(String.valueOf(Double.parseDouble(tfValorIpi.getText())+modelAlterado.getValorIpi()));
        tfValorSubst.setText(String.valueOf(Double.parseDouble(tfValorSubst.getText())+modelAlterado.getValorSubst()));
        total.setText(String.valueOf(totalgeralfracao));
        
    }
    public void atualizarmodelAlterado(ModelVendasProdutosTabelaNfe modelAlterado) {
         codigoProduto = controllerProdutos.getProdutosController(modelAlterado.getProduto()).getCodigo();
        ModelVendasProdutos mvp = new ModelVendasProdutos(); 
                        
        mvp.setCodigo(codigoVenda);
        mvp.setCodigo_produto(codigoProduto);
        mvp.setCodigo_venda(codigoVenda);
        mvp.setQuantidade(modelAlterado.getQuantidade());
        mvp.setValorUnitario(modelAlterado.getValorUnitario());
        mvp.setCfop(modelAlterado.getCfop());
        mvp.setIcmsCst(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(codigoProduto).getTribEst()).getIdcsosn()).getNumero()));
        mvp.setIpiCst(String.valueOf(controllerCsosnFederal.getCsosnFederalController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdIpi()).getNumero()));
        mvp.setPisCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdPisCofins()).getNumero()));
        mvp.setCofinsCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdPisCofins()).getNumero()));
        mvp.setOrdem(modelAlterado.getOrdem());
        listamodel.remove(modelAlterado.getOrdem() - 1);
        listamodel.add(modelAlterado.getOrdem() - 1,mvp);
        listadeProdutos.remove(modelAlterado.getOrdem() - 1);
        listadeProdutos = FXCollections.observableArrayList(listamodel);
       
     }
    
    private void procuraCfop(String cfop) throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqCfop.fxml"));
        Parent entradaProduto = (Parent) loader.load();
        listaCfop localizaCfop = loader.getController();
        localizaCfop.pesquisaCfopEntrada(cfop);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaProduto));
        stage.show();
   
        
    }
                
}


   
   
    


