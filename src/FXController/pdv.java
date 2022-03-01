/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerCaixa;
import controller.ControllerConfiguracao;
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
import controller.ControllerUsuario;
import controller.ControllerNumeracao;
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
import model.ModelConfiguracao;
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
import model.ModelNumeracao;
import nfe.model.ModelNF;
import nfe.model.ModelNFCe;
import blserial.ConfigXML;
import unishop.Unishop;
import util.BLMascaras;
import util.ManipularXML;
import view.ViewVerificarPermissao;
import nfe.model.ModelXmlNfe;
import nfe.controller.ControllerNF;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import java.text.ParseException;
import com.acbr.nfe.demo.FrmMain;
import com.acbr.nfe.ACBrNFe;
import controller.ControllerIbpt;
import interfaces.classeInterfaces;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.AttributedString;
import java.time.LocalDate;
import java.util.Collections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.swing.JOptionPane;
import nfe.util.LerArqXML;
import nfe.util.ViewLeitorNotaXML;
import util.GerarCupom;
import util.Impressora;
import util.TextFieldFormatter;
import util.logutil;

/**
 *
 * @author Fabio
 */
public class pdv extends Application implements Initializable {

    @FXML
    TextField tfDescricaoPdv;
    @FXML
    TextField tfQuantidadePdv;
    @FXML
    TextField tfValorUnitarioPdv;
    @FXML
    TextField tfValorTotalPdv;
    @FXML
    TextField tfSubTotalPdv;
    @FXML
    TextField tfUltimoVendido;
    @FXML
    TextField tfNota;
    @FXML
    TextField rtbRespostas;
    @FXML
    Button btFechar;
    @FXML
    Button btFecharJanela;
    @FXML
    Button btMinimizarJanela;
    @FXML
    Button btFecharRetorno;
    @FXML
    Button btImportarNfce;
    @FXML
    Button btBuscarCliente;
    @FXML
    Label lbTotal;
    @FXML
    TextArea tfStatus;
    @FXML
    ImageView ivLogo;
    @FXML
    Label lbConsumidor;
    @FXML
    Label Consumidor;
    @FXML
    Label cpfCnpj;
    @FXML
    Label lbCpfCnpj;
    @FXML
    Label lbCnpjCpfAvulso;
    @FXML
    Label lbCnpjCpfAvulsoTipo;
    @FXML
    Label lbCnpjCpfAvulsoCliente;
    @FXML
    Label lbStatus;
    @FXML
    TextField tfCpfCnpjAvulso;
    @FXML
    TextField tfClienteAvulso;
    @FXML
    ChoiceBox<String> cbFisicaJuridica;
    @FXML
    Button btCpfCnpjOk;
    @FXML
    Button btCpfCnpjSair;
    @FXML
    Pane pnCnpjCpfAvulso;
    @FXML
    Pane pnSangria;
    @FXML
    Pane pnStatus;
    @FXML
    TextField tfValorSangria;
    @FXML
    Button btConfirmaSangria;
    @FXML
    Button btCancelaSangria;
    @FXML
    TableView<ModelVendasProdutosTabela> tabelaCupom = new TableView();
    @FXML
    TableColumn<ModelVendasProdutosTabela, String> item;
    @FXML
    TableColumn<ModelVendasProdutosTabela, String> descProduto;
    @FXML
    TableColumn<ModelVendasProdutosTabela, String> quant;
    @FXML
    TableColumn<ModelVendasProdutosTabela, String> valUnitario;
    @FXML
    TableColumn<ModelVendasProdutosTabela, String> valTotal;
    @FXML
    TableView<ModelProdutos> tbConsultaProduto;
    @FXML
    TableColumn<ModelProdutos, String> tcProduto;
    @FXML
    TableColumn<ModelProdutos, String> tcPreco;
    @FXML
    TableColumn<ModelProdutos, String> tcEstoque;
    @FXML
    private ProgressIndicator piProcesso;

    public ArrayList<ModelVendasProdutosTabela> listavendidos;
    String modeloNfce = "65";
    int codigoProduto;
    int ordem = 1;
    int codigoCliente = 1;
    int codigoUsuario;
    float totalgeralfracao;
    double diminuir;
    String pagamento;
    int codPagamento;
    int indiceTabela;
    int numeroCaixa = 1;
    String chaveCriada;
    ModelVendasProdutosTabela produtoexcluir;
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
    Scene aguarde;
    int visualizarNfce;
    int metodoEnvioNfce;
    int classificacaoFiscal;
    int quantidadeImprimir;
    int modeloImprimir;
    String impressoraPDV;

    String tipoPorta = "COM2";
    SerialPort portaSerial;
    InputStream portaEntrada;
    Thread thread;
    OutputStream saida;
    int comando;
    String tmp;
    String st;

    ModelXmlNfe modelXmlNfe = new ModelXmlNfe();
    ControllerNF controllerNF = new ControllerNF();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    ManipularXML manipularXml = new ManipularXML();
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ModelNFCe modelNFCe = new ModelNFCe();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelConfiguracao modelConfiguracao = new ModelConfiguracao();
    ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerCsosn controllerCsosn = new ControllerCsosn();
    ControllerConfiguracao controllerCconfiguracao = new ControllerConfiguracao();
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
    ArrayList<ModelVendasProdutos> listaVendidos = new ArrayList<>();
    ArrayList<ModelVendasProdutos> listamodel = new ArrayList<>();
    ObservableList<ModelVendasProdutos> listadeProdutos;
    ObservableList<ModelProdutos> listaConsultaProdutos;
    ArrayList<ModelProdutos> listaLocalizaProdutos;
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ModelNumeracao modelNumeracao = new ModelNumeracao();
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
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ControllerCstPiscofins controllerCstPiscofins = new ControllerCstPiscofins();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ControllerCst controllerCst = new ControllerCst();
    ControllerNumeracao controllerNumeracao = new ControllerNumeracao();
    ControllerEnquadramentoIpi controllerEnquadramentoIpi = new ControllerEnquadramentoIpi();
    ControllerNCM controllerNCM = new ControllerNCM();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    BLMascaras bLMascaras = new BLMascaras();
    LerArqXML lerArqxml = new LerArqXML();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    public int codigoVenda = 0;
    int contVendaMenor;
    Date dataAtual = new Date();
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    private ViewVerificarPermissao viewVerificarPermissao;

    //nfce
    private ACBrNFe acbrNFe;

    @Override
    public void start(Stage vendaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pdv.fxml"));
        Parent raiz = loader.load();
        vendaStage.setScene(new Scene(raiz));
        vendaStage.setMaximized(true);
        vendaStage.initModality(Modality.APPLICATION_MODAL);
        vendaStage.initStyle(StageStyle.TRANSPARENT);
        vendaStage.setTitle("PONTO DE VENDA");
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
        carregarConfiguracoes();
        classeInterfaces.addaoMudarTelaCodigoVenda((String novaTela, int codigoVendaLocal) -> {
            recuperarVenda(codigoVendaLocal);
        });
        classeInterfaces.addaoMudarTelaRejeicao((String novaTela, String retorno) -> {
            pnSangria.setMaxHeight(1);
            tfStatus.setVisible(true);
            tfStatus.setFocusTraversable(true);
            btFecharRetorno.setVisible(true);
            tfStatus.setText(retorno);
        });
        classeInterfaces.addaoMudarTelaOuvinteProgresso((String novaTela, Boolean ativo) -> {
            piProcesso.setVisible(ativo);
            lbStatus.setVisible(ativo);
            pnCnpjCpfAvulso.setVisible(ativo);
            btCpfCnpjOk.setVisible(!ativo);
            btCpfCnpjSair.setVisible(!ativo);
            lbCnpjCpfAvulsoTipo.setVisible(!ativo);
            lbCnpjCpfAvulso.setVisible(!ativo);
            lbCnpjCpfAvulsoCliente.setVisible(!ativo);
            tfCpfCnpjAvulso.setVisible(!ativo);
            tfClienteAvulso.setVisible(!ativo);
            cbFisicaJuridica.setVisible(!ativo);
            tfDescricaoPdv.setDisable(ativo);
            tfQuantidadePdv.setDisable(ativo);
            tfSubTotalPdv.setDisable(ativo);
            tfUltimoVendido.setDisable(ativo);
            tfValorUnitarioPdv.setDisable(ativo);
            tfValorTotalPdv.setDisable(ativo);
        });
        classeInterfaces.addaoMudarTelaOuvinte(new classeInterfaces.aoMudarTela() {
            @Override
            public void telaModificada(String novaTela, String cliente) {
                Consumidor.setVisible(true);
                lbConsumidor.setVisible(true);
                cpfCnpj.setVisible(true);
                lbCpfCnpj.setVisible(true);
                piProcesso.setVisible(false);
                pnStatus.setVisible(false);
                Consumidor.setText(cliente);
                cpfCnpj.setText(controllerCliente.getClienteController(cliente).getCpfCNPJ());
            }
        });
        if (verificarCaixa() == true) {
            limparCamposVenda();
            habilitarCampos();
            definirDatas();
            verificarCliente();
            verificarProduto();
            listaEnter();
            setNextFocus(tfDescricaoPdv, tfQuantidadePdv);
            criarListaClientes();
            criarListaTelefones();
            criarlistaProdutos();
            criarlistaPagamentos();
            iniciaCpfCnpjAvulso();
            recuperarVenda(0);

            //zerarValoresCaixa();
            cbFisicaJuridica.setOnAction((event) -> {
                formatarDocumentoAvulso();
            });
            tfStatus.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.F2) {
                    fecharRetorno();
                }
            });
            tfCpfCnpjAvulso.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.ENTER) {
                    definirCpfCnpjAvulso();
                }
            });
            btCpfCnpjOk.setOnMouseClicked((MouseEvent e) -> {
                definirCpfCnpjAvulso();
            });
            btCpfCnpjSair.setOnMouseClicked((MouseEvent e) -> {
                pnCnpjCpfAvulso.setVisible(false);
            });
            btFechar.setOnMouseClicked((MouseEvent e) -> {
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA FINALIZAR A VENDA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) {
                        ActionEvent evento = null;
                        try {
                            pagamentos(evento);
                        } catch (IOException ex) {
                            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            });

            tfDescricaoPdv.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.ENTER) {
                    if (tfDescricaoPdv.getText().equalsIgnoreCase("")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("== A L E R T A ==");
                        alert.setContentText("NECESSÁRIO INFORMAR O PRODUTO A SER VENDIDO");
                        alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
                        alert.show();
                        tfQuantidadePdv.setFocusTraversable(false);
                        tfDescricaoPdv.requestFocus();

                    } else {
                        tfQuantidadePdv.setFocusTraversable(true);
                        if (((tfDescricaoPdv.getText().substring(0, 1))).equalsIgnoreCase("2") && ((tfDescricaoPdv.getText().length()) > 10)) {
                            retornarprodutoPeloCodBarrasPeso();
                            tfQuantidadePdv.setFocusTraversable(false);

                        } else if (((tfDescricaoPdv.getText().substring(0, 1))).equalsIgnoreCase("7") && (tfDescricaoPdv.getText().length()) > 6) {
                            retornarprodutoPeloCodBarras();
                            tfQuantidadePdv.setFocusTraversable(false);
                        } else if ((tfDescricaoPdv.getText().matches("-?\\d+")) && ((tfDescricaoPdv.getText().length()) <= 6)) {
                            retornarprodutoPeloCodigo();
                            tfQuantidadePdv.setFocusTraversable(true);
                        } else if (controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getCodigo() == 0) {
                            tfDescricaoPdv.setText(tbConsultaProduto.getItems().get(0).getDescricaoProduto());
                            retornarprodutoPeloNome();
                            tfQuantidadePdv.setFocusTraversable(true);
                            tbConsultaProduto.setVisible(false);
                            tabelaCupom.setVisible(true);
                        } else {
                            retornarprodutoPeloNome();
                            tfQuantidadePdv.setFocusTraversable(true);
                            tbConsultaProduto.setVisible(false);
                            tabelaCupom.setVisible(true);
                        }
                        tfValorTotalPdv.setText(String.valueOf(calcularValorproduto(tfValorUnitarioPdv.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(tfQuantidadePdv.getText()))))));
                        //tfValorTotalPdv.setText(String.valueOf(bLMascaras.truncamentoComPontoDuasCasasDouble(calcularValorproduto(tfValorUnitarioPdv.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnFloat(tfQuantidadePdv.getText())))))));

                    }
                }
                if (e.getCode() == KeyCode.DOWN) {
                    irPraTabelaPesquisa();
                }
                if (e.getCode() == KeyCode.F3) {
                    habilitarSangria();
                }
                if (e.getCode() == KeyCode.F10) {
                    lerportaserial();
                }
                if (e.getCode() == KeyCode.F11) {
                    irPraTabela();
                }
                if (e.getCode() == KeyCode.F5) {
                    Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
                    ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                    dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                    dialogoExe.setContentText("DESEJA FINALIZAR A VENDA?");
                    dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                    dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
                    dialogoExe.showAndWait().ifPresent(b -> {
                        if (b == btnSim) {
                            ActionEvent evento = null;
                            try {
                                pagamentos(evento);
                            } catch (IOException ex) {
                                Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }
                if (e.getCode() == KeyCode.F6) {
                    cancelaVendaAtual();
                }
                if (e.getCode() == KeyCode.F8) {
                    try {
                        importarPreVenda();
                    } catch (IOException ex) {
                        Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getCode() == KeyCode.F10) {
                    try {
                        importarMesas();
                    } catch (IOException ex) {
                        Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getCode() == KeyCode.F7) {
                    try {
                        abreConsultaEmitidas();
                    } catch (IOException ex) {
                        Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getCode() == KeyCode.F12) {
                    importarNfceSaida();

                }
                if (e.getCode() == KeyCode.F9) {
                    listaConsumidor();
                }

            });

            tfQuantidadePdv.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.ENTER) {

                    //tfValorTotalPdv.setText(String.valueOf(calcularValorproduto(tfValorUnitarioPdv.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnFloat(tfQuantidadePdv.getText()))))));
                    calcularValor();
                    //tfValorTotalPdv.setText(String.valueOf(calcularValorproduto(tfValorUnitarioPdv.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(tfQuantidadePdv.getText()))))));
                    preencherTabela();
                }
            });
            tfValorTotalPdv.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.ENTER) {

                }
            });

            tbConsultaProduto.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.ENTER) {
                    escolherProduto();
                    tfDescricaoPdv.requestFocus();
                }
                if (e.getCode() == KeyCode.ESCAPE) {
                    tbConsultaProduto.setVisible(false);
                    tabelaCupom.setVisible(true);
                }
            });
            tabelaCupom.setOnKeyPressed((KeyEvent e) -> {
                if (e.getCode() == KeyCode.DELETE) {
                    Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
                    ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);

                    dialogoExe.setTitle("EXCLUIR PRODUTO?");
                    dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                    dialogoExe.setContentText("DESEJA RELAMENTE EXCLUIR O PRODUTO?");
                    dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                    dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
                    dialogoExe.showAndWait().ifPresent(b -> {
                        if (b == btnSim) {
                            excluirProduto();
                        }
                    });
                }

                if (e.getCode() == KeyCode.ENTER) {

                    saidaTabela();
                }
            });

            //TABELA CUPOM
            item.setCellValueFactory(new PropertyValueFactory<>("ordem"));
            descProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
            quant.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
            valUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
            valTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

            //TABELA CONSULTA PRODUTOS
            tcProduto.setCellValueFactory(new PropertyValueFactory<>("descricaoProduto"));
            tcPreco.setCellValueFactory(new PropertyValueFactory<>("valor"));
            tcEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));

        } else {
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);

            dialogoExe.setTitle("CAIXA FECHADO");
            dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
            dialogoExe.setContentText("O CAIXA AINDA NÃO FOI ABERTO, DESEJA ABRIR O CAIXA?");
            dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
            dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
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

    public void calcularValor() {
        if (tfQuantidadePdv.getText() != " " && tfValorUnitarioPdv.getText() != " ") {
            tfValorTotalPdv.setText(String.valueOf(calcularValorproduto(tfQuantidadePdv.getText(), (String.valueOf(bLMascaras.converterVirgulaParaPontoReturnDouble(tfValorUnitarioPdv.getText()))))));
        }
    }

    public void fechar() {
        Stage estagioSaida = (Stage) btFecharJanela.getScene().getWindow();
        estagioSaida.close();
    }

    public void minimizar() {
        Stage estagioSaida = (Stage) btMinimizarJanela.getScene().getWindow();
        estagioSaida.setIconified(true);
    }

    public void fecharRetorno() {
        tfStatus.setText("");
        tfStatus.setVisible(false);
        tfStatus.setFocusTraversable(false);
        btFecharRetorno.setVisible(false);
    }

    public void mostraProdutos() {
        listaLocalizaProdutos = new ArrayList<ModelProdutos>();
        ArrayList<ModelProdutos> listaModelProdutosLocal = new ArrayList<ModelProdutos>();
        listaModelProdutosLocal = controllerProdutos.getListaProdutosAtivosController();
        if (tfDescricaoPdv.getText().length() > 2 && !(tfDescricaoPdv.getText(0, 2).matches("-?\\d+"))) {
            tbConsultaProduto.setVisible(true);
            tabelaCupom.setVisible(false);
            int tamanho = listaModelProdutosLocal.size();
            for (int i = 0; i < tamanho; i++) {
                if (listaModelProdutosLocal.get(i).getDescricaoProduto().contains(tfDescricaoPdv.getText().toUpperCase())) {
                    listaLocalizaProdutos.add(listaModelProdutosLocal.get(i));
                }
            }
            tbConsultaProduto.getItems().clear();
            tbConsultaProduto.getItems().addAll(listaLocalizaProdutos);
            tbConsultaProduto.setFocusTraversable(true);
            tbConsultaProduto.getSelectionModel().select(0);
        } else {
        }

    }

    public void fecharPedidoVenda() {
        Stage estagioPedidoVenda = (Stage) tfDescricaoPdv.getScene().getWindow();
        estagioPedidoVenda.close();
    }

    public void atualizarmodel() {

        /*ModelVendasProdutos mvp = new ModelVendasProdutos(); 
                        
        mvp.setCodigo(codigoVenda);
        mvp.setCodigo_produto(codigoProduto);
        mvp.setCodigo_venda(codigoVenda);
        mvp.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(tfQuantidadePdv.getText()));
        mvp.setValorUnitario(bLMascaras.truncamentoComPontoDuasCasasFloat(Float.parseFloat(tfValorUnitarioPdv.getText())));
        mvp.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(codigoProduto).getTribEst()).getIdcfop()).getCfop()));
        mvp.setIcmsCst(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(codigoProduto).getTribEst()).getIdcsosn()).getNumero()));
        mvp.setIpiCst(String.valueOf(controllerCsosnFederal.getCsosnFederalController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdIpi()).getNumero()));
        mvp.setPisCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdPisCofins()).getNumero()));
        mvp.setCofinsCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigoProduto).getTribFed()).getIdPisCofins()).getNumero()));
         */
        listamodel.addAll(controllerVendasProdutos.getListaVendasProdutosController(0));
        Collections.reverse(listamodel);
        listadeProdutos = FXCollections.observableArrayList(listamodel);

    }

    public void cancelaVendaAtual() {
        int numeroNfceCancelar;
        int pedidoNfceCancelar;
        String chave;
        String cnpj;
        String motivo = "cliente desistiu da compra devido a questoes financeiras";
        ArrayList<ModelVendasProdutos> listaModelProdutosCancelar = new ArrayList();
        ArrayList<ModelNF> listaModelCancelar = new ArrayList();
        listaModelCancelar = controllerNF.getListaNFModeloController(modeloNfce);
        numeroNfceCancelar = Integer.parseInt(listaModelCancelar.get(listaModelCancelar.size() - 1).getNumeroNfe());
        pedidoNfceCancelar = listaModelCancelar.get(listaModelCancelar.size() - 1).getPedido();
        listaModelProdutosCancelar = controllerVendasProdutos.getListaVendasProdutosController(numeroNfceCancelar);
        chave = controllerNF.getNFVendaController(pedidoNfceCancelar).getChaveNfe();
        cnpj = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();

        if (tabelaCupom.getItems().size() > 0) {
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);

            dialogoExe.setTitle("CANCELAR VENDA");
            dialogoExe.setContentText("DESEJA CANCELAR A VENDA ATUAL?");
            dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
            dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
            dialogoExe.showAndWait().ifPresent(b -> {
                if (b == btnSim) {
                    controllerVendasProdutos.excluirVendasProdutosCodVendaController(codigoVenda);
                    tfSubTotalPdv.setText("0,00");
                    tfValorTotalPdv.setText("0,00");
                    tfValorUnitarioPdv.setText("0,00");
                    listamodel.clear();
                    listaModelVendas.clear();
                    listaVendidos.clear();
                    totalgeralfracao = 0.0f;
                    recuperarVenda(codigoVenda);

                } else {

                }
            });
        } else {

            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);

            dialogoExe.setTitle("CANCELAR VENDA");
            dialogoExe.setContentText("DESEJA CANCELAR A VENDA: " + numeroNfceCancelar + "DA VENDA:" + pedidoNfceCancelar + " ?");
            dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
            dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
            dialogoExe.showAndWait().ifPresent(b -> {
                if (b == btnSim) {
                    try {
                        acbrNFe = new ACBrNFe();
                        String ret = acbrNFe.cancelar(chave, motivo, cnpj);
                        atualizarNFCECancelada(pedidoNfceCancelar);
                        controllerVendasProdutos.excluirVendasProdutosCodVendaController(pedidoNfceCancelar);

                    } catch (Exception ex) {
                        Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("CONFIRMAÇÃO");
                    alert.setContentText("A NOTA FISCAL NUMERO: " + numeroNfceCancelar + " FOI CANCELADA COM SUCESSO");
                    alert.show();
                } else {
                }
            });
            retornarProdutoAoEstoqueVendaCancelada(listaModelProdutosCancelar);
        }
    }

    public void atualizarNFCECancelada(int codigoVenda) {
        int codigoCancelamento = 101;
        controllerNF.atualizarNFCanceladaController("CANCELADA", String.valueOf(this.codigoVenda), codigoCancelamento);
    }

    private ArrayList inverterLista(ArrayList<ModelVendasProdutosTabela> lista) {
        ArrayList<ModelVendasProdutosTabela> inverso = new ArrayList();

        for (int i = lista.size(); i >= 0; i--) {
            inverso.add(lista.get(i));
        }

        return inverso;
    }

    private void atualizarTabela() {
        ArrayList<ModelVendasProdutos> listaLocal = new ArrayList();
        ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
        listaLocal = controllerVendasProdutos.getListaVendasProdutosController(0);

        for (int f = 0; f < listaLocal.size(); f++) {
            mvpt.setOrdem(listaLocal.get(f).getOrdem());
            mvpt.setProduto(listaLocal.get(f).getNomeProduto());
            mvpt.setQuantidade(listaLocal.get(f).getQuantidade());
            mvpt.setValorUnitario(listaLocal.get(f).getValorUnitario());
            mvpt.setValorTotal(listaLocal.get(f).getValorTotal());
            mvpt.setNcm(listaLocal.get(f).getNcm());

        }
        listavendidos.add(mvpt);
        tabelaCupom.getItems().addAll(listavendidos);
        atualizarmodel();
    }

    @FXML
    private void adcionar() {
        ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
        ModelVendasProdutos mvp = new ModelVendasProdutos();
        listavendidos = new ArrayList<>();
        mvp.setOrdem(ordem);
        mvp.setNomeProduto(tfDescricaoPdv.getText());
        mvp.setCodigo_produto(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getCodigo());
        mvp.setCfop(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getTribEst()).getIdcfop()).getCfop()));
        mvp.setIcmsCst(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getTribEst()).getIdcsosn()).getNumero()));
        mvp.setQuantidade(bLMascaras.converterVirgulaParaPontoReturnFloat(tfQuantidadePdv.getText()));
        mvp.setValorUnitario(valorUnitario);
        mvp.setValorTotal(Float.parseFloat(tfValorTotalPdv.getText()));
        mvp.setNcm(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getNcm());
        mvp.setIpiCst(String.valueOf(controllerEnquadramentoIpi.getEnquadramentoIpiController(Integer.parseInt(controllerProdutos.getProdutosController(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getCodigo()).getIpi())).getNumero()));
        mvp.setCofinsCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(Integer.parseInt(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getCofins())).getNumero()));
        mvp.setPisCst(String.valueOf(controllerCstPiscofins.getCstPiscofinsController(Integer.parseInt(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getPis())).getNumero()));

        if ((controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getTipo()) == 1) {
            mvp.setTipo(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getTipo());
            mvp.setValorProdutoGlp(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getValorProdutoGlp());
            mvp.setPercGlp(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getPercGlp());
            mvp.setPercGni(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getPercGni());
            mvp.setPercGnn(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getPercGnn());
            mvp.setEstadoConsumidor(controllerClienteCidadeEstado.getClienteCidadeEstadoController(codigoCliente).getModelEstado().getUf());
            mvp.setCodProdutoAnp(controllerProdutos.getProdutosController(tfDescricaoPdv.getText()).getCodProdutoAnp());
        } else {
            mvp.setTipo(1);
            mvp.setValorProdutoGlp(0.0);
            mvp.setPercGlp(0);
            mvp.setPercGni(0);
            mvp.setPercGnn(0);
            mvp.setEstadoConsumidor("ES");
            mvp.setCodProdutoAnp("210203001");
        }

        controllerVendasProdutos.salvarVendasProdutosController(mvp);

        ordem++;

        atualizarTabela();

        totalgeralfracao = ((Float.parseFloat(tfValorTotalPdv.getText())) + (totalgeralfracao));
        tfSubTotalPdv.setText(bLMascaras.arredondamentoComPontoDuasCasasFloatString(totalgeralfracao));
        tfValorUnitarioPdv.setText(String.valueOf(mvpt.getValorUnitario()));
        tfUltimoVendido.setText(mvpt.getProduto());
        limpaTelaNovoProduto();

    }

    public void lerportaserial() {
        int timeout = 1000;
        String portas = "COM1";
        int portadisponivel = CommPortIdentifier.PORT_SERIAL;

    }

    public void listaEnter() {
        campos.add(tfDescricaoPdv);
        campos.add(tfQuantidadePdv);

    }

    public void setNextFocus(TextField tfDescricaoPdv, TextField tfQuantidadePdv) {

        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase) {
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    }

    private void criarlistaProdutos() {
        listaModelProdutos = controllerProdutos.getListaProdutosAtivosController();

        for (int i = 0; i < listaModelProdutos.size(); i++) {
            listaProdutos.add(listaModelProdutos.get(i).getDescricaoProduto());
        }
    }

    private void criarlistaPagamentos() {
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();

        for (int i = 0; i < listaModelTipoPagamentos.size(); i++) {
            listaPagamentos.add(+listaModelTipoPagamentos.get(i).getCodigo() + "-" + listaModelTipoPagamentos.get(i).getDescricao());
        }
    }

    public void criarListaClientes() {
        listaModelClientes = controllerCliente.getListaClienteAtivoController();

        for (int i = 0; i < listaModelClientes.size(); i++) {
            listaClientes.add(listaModelClientes.get(i).getNome());
        }
    }

    public void criarListaTelefones() {
        listaModelClientes = controllerCliente.getListaClienteController();

        for (int i = 0; i < listaModelClientes.size(); i++) {
            listaTelefones.add(listaModelClientes.get(i).getTelefone());
        }
    }

    private void retornarprodutoPeloNome() {
        //INICIO recupera o nome
        modelProdutos = controllerProdutos.getProdutosController(tfDescricaoPdv.getText());

        if (modelProdutos.getDescricaoProduto().equals(null)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setContentText("PRODUTO ESCOLHIDO É INVÁLIDO!");
            alert.show();

        } else {
            this.tfValorUnitarioPdv.setText(String.valueOf((modelProdutos.getValor())));
            this.tfQuantidadePdv.setText("1");
            //FIM recupera o nome
            tfValorTotalPdv.setText(calcularValorproduto(this.tfQuantidadePdv.getText(), this.tfValorUnitarioPdv.getText()) + "");
            codigoProduto = (modelProdutos.getCodigo());
        }
    }

    private void retornarprodutoPeloCodigo() {
        //INICIO recupera o nome
        modelProdutos = controllerProdutos.getProdutosControllerCodigo(Integer.parseInt(tfDescricaoPdv.getText()));
        if (modelProdutos.getCodigo() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setContentText("CODIGO INEXISTENTE");
            alert.show();
        } else {
            tfDescricaoPdv.setText(modelProdutos.getNome());
            tfValorUnitarioPdv.setText(String.valueOf(modelProdutos.getValor()));
            tfQuantidadePdv.setText("1");
            //FIM recupera o nome
            tfValorTotalPdv.setText(calcularValorproduto(this.tfQuantidadePdv.getText(), this.tfValorUnitarioPdv.getText()) + "");
            codigoProduto = (modelProdutos.getCodigo());
            tfDescricaoPdv.requestFocus();
        }
    }

    private void retornarprodutoPeloCodBarrasPeso() {
        //INICIO recupera o codigo de barras
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(String.valueOf(Integer.parseInt(tfDescricaoPdv.getText().substring(2, 5))));

        double totalBarras = ((Double.parseDouble(this.tfDescricaoPdv.getText().substring(7, 12))) * 0.01);
        double pesoBarras = (bLMascaras.truncamentoComPontoTresCasasDouble(totalBarras / (modelProdutos.getValor())));

        this.tfValorUnitarioPdv.setText(String.valueOf(modelProdutos.getValor()));
        this.tfQuantidadePdv.setText(String.valueOf(pesoBarras));
        //FIM recupera o nome
        tfValorTotalPdv.setText(calcularValorproduto(this.tfQuantidadePdv.getText(), this.tfValorUnitarioPdv.getText()) + "");
        tfDescricaoPdv.setText(modelProdutos.getNome());
        codigoProduto = (modelProdutos.getCodigo());
        tfDescricaoPdv.requestFocus();

    }

    private void retornarprodutoPeloCodBarras() {
        //INICIO recupera o codigo de barras
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(tfDescricaoPdv.getText());
        tfDescricaoPdv.setText(modelProdutos.getNome());
        tfValorUnitarioPdv.setText(String.valueOf(modelProdutos.getValor()));
        tfQuantidadePdv.setText("1");
        //FIM recupera o nome
        tfValorTotalPdv.setText(calcularValorproduto(this.tfQuantidadePdv.getText(), this.tfValorUnitarioPdv.getText()) + "");
        codigoProduto = (modelProdutos.getCodigo());
        preencherTabela();
        tfDescricaoPdv.requestFocus();
    }

    private double calcularValorproduto(String pValorUnitario, String pQuantidade) {
        double valorTotal = 0, valorUnitario = 0, quantidade = 0.0;
        try {
            quantidade = bLMascaras.converterVirgulaParaPontoReturnDouble(pQuantidade);
        } catch (NumberFormatException e) {
            quantidade = 0.0;
        }
        try {
            valorUnitario = (bLMascaras.truncamentoComPontoTresCasasDouble(bLMascaras.converterVirgulaParaPontoReturnDouble(pValorUnitario)));
        } catch (Exception e) {
            valorUnitario = 0.0;
        }
        try {
            valorTotal = (valorUnitario * quantidade);
        } catch (Exception e) {

            valorTotal = 0.0;
        }
        return valorTotal;
    }

    private void verificarCliente() {
        if (listaClientes.size() < 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setContentText("Cadastre primeiro um cliente!");

        }
    }

    private void verificarProduto() {
        if (listaProdutos.size() < 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.setContentText("Cadastre primeiro um Produto!");
        }

    }

    private void preencherTabela() {
        String nomeproduto = (tfDescricaoPdv.getText());
        valorUnitario = (bLMascaras.truncamentoComPontoDuasCasasDouble(bLMascaras.converterVirgulaParaPontoReturnDouble(tfValorUnitarioPdv.getText())));
        modelProdutos = controllerProdutos.getProdutosController(nomeproduto);
        if (tfDescricaoPdv.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Você deve informar o produto para adicionar!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
        }
        if (tfQuantidadePdv.getText().equals("") || tfQuantidadePdv.getText().equals("0")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("Você deve informar a quantidade para adicionar!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
        } else {
            //verifica a quantidade em estoque

            if ((modelProdutos.getEstoque()) < (bLMascaras.converterVirgulaParaPontoReturnDouble(tfQuantidadePdv.getText()))) {
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);

                dialogoExe.setTitle("Erro de estoque");
                dialogoExe.setHeaderText("Quantidade Acima do permitido");
                dialogoExe.setContentText("Você não tem essa quantidade de produto em estoque!\n"
                        + "Quantidade atual de " + modelProdutos.getNome() + " é " + modelProdutos.getEstoque() + "\n"
                        + "Deseja efeuar a venda do produto mesmo assim?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
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

    public String gerarDv(String chaveCompleta) {
        String chave = "";
        pond = 2;
        soma = 0;

        for (int i = 42; i > 0; i--) {
            int dig = (Integer.parseInt(chaveCompleta.substring(i, i + 1)) * pond);
            if (pond < 9) {
                pond = pond + 1;

            } else {
                pond = 2;
            }
            soma = soma + dig;
        }
        resto = (soma % 11);
        if (resto == 0) {
            dv = 0;

        } else {
            dv = 11 - resto;
        }
        chave = chaveCompleta + (String.valueOf(dv));

        return chave;
    }

    public void chaveAcesso() {
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
        String chavePre = "";
        String codUf = (String.valueOf(controllerClienteCidadeEstado.getClienteCidadeEstadoController(controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCodigo()).getModelEstado().getCodigo()));
        mesAnoEmissao = ((bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5)) + (bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(8, 10)));
        String cnpjEmit = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
        String modelo = "65";
        String serie = "001";
        String numero = "009152311";
        String tipoEmissao = "1";
        String codigoAcesso = "88725117";

        chavePre = (codUf + mesAnoEmissao + cnpjEmit + modelo + serie + numero + tipoEmissao + codigoAcesso);
        chaveCriada = gerarDv(chavePre);

    }

    public String formaPagamento(int codigoVendaretorno, float total, ArrayList<String> listaFpagamento) {
        modelXmlNfe = new ModelXmlNfe();
        modelNFCe = new ModelNFCe();
        String pagamentosLocal = "";

        for (int i = 0; i < listaFpagamento.size(); i++) {
            pagamentosLocal = pagamentosLocal + "[pag00" + (i + 1) + "]\n"
                    + "tPag=" + listaFpagamento.get(i).substring(0, 2) + "\n"
                    + "vPag=" + bLMascaras.converterPontoPraVirgula(listaFpagamento.get(i).substring(4)) + "\n"
                    + "\n";

        }
        return pagamentosLocal;
    }

    public String retornarIbpt(int codigoVendaretorno) {
        ControllerIbpt controllerIbpt = new ControllerIbpt();
        controllerNCM = new ControllerNCM();
        ArrayList<ModelVendasProdutos> produtosIbpt = controllerVendasProdutos.getListaVendasProdutosController(codigoVendaretorno);
        String ibptNota = "";
        double estadual = 0.0, municipal = 0.0, federal = 0.0;
        for (int i = 0; i < produtosIbpt.size(); i++) {
            int ncmibpt = Integer.parseInt(controllerProdutos.getProdutosController(produtosIbpt.get(i).getCodigo_produto()).getNcm());
            double valoribpt = produtosIbpt.get(i).getValorTotal();
            estadual += ((controllerIbpt.getIBPTController(ncmibpt).getEstadual() / 100) * valoribpt);
            federal += ((controllerIbpt.getIBPTController(ncmibpt).getImportadosfederal() / 100) * valoribpt);
            municipal += ((controllerIbpt.getIBPTController(ncmibpt).getMunicipal() / 100) * valoribpt);
        }
        ibptNota = "Tributos incidentes aproximados =  ESTADUAL: " + bLMascaras.truncamentoComPontoDuasCasasDouble(estadual)
                + " FEDERAL: " + bLMascaras.truncamentoComPontoDuasCasasDouble(federal)
                + " MUNICIPAL: " + bLMascaras.truncamentoComPontoDuasCasasDouble(municipal);
        return ibptNota;
    }

    private String destinatárioNfe(int codigoVendaretorno, String documentoAvulso, String clienteAvulso) {
        String destinatario = "";

        if (controllerVendas.getVendasController(codigoVendaretorno).getClientesCodigo() == 0) {
            destinatario = "[Destinatario]\n"
                    + "indIEDest=" + 9 + " \n"
                    + "CNPJ=" + documentoAvulso + " \n"
                    + "NomeRazao=" + clienteAvulso + " \n";

        } else {
            destinatario = "[Destinatario]\n"
                    + "indIEDest=" + 9 + " \n"
                    + "CNPJ=" + controllerCliente.getClienteControllerCod(controllerVendas.getVendasController(codigoVendaretorno).getClientesCodigo()).getCpfCNPJ() + " \n"
                    + "NomeRazao=" + controllerCliente.getClienteControllerCod(controllerVendas.getVendasController(codigoVendaretorno).getClientesCodigo()).getNome() + " \n";
        }

        return destinatario;
    }

    public boolean gerarProdutosNcfe(int codigoVendaretorno, float valorDesconto, float valorAcrescimo) throws IOException, ParseException {

        String produtoLocal;
        String indiceProduto;

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

        listaModelVendas = new ArrayList<>();
        listaModelProdutos = new ArrayList<>();

        listaVendidos = controllerVendasProdutos.getListaVendasProdutosController(codigoVendaretorno);

        for (int i = 0; i < listaVendidos.size(); i++) {
            modelProdutos = new ModelProdutos();
            modelEmpresa = controllerEmpresa.getEmpresaController(1).getModelEmpresa();
            indiceProduto = "0" + (i + 1);
            if ((i + 1) > 9) {
                indiceProduto = "" + (i + 1);
            }

            produtoLocal = "[Produto0" + (indiceProduto) + "]\n"
                    + "CFOP=" + listaVendidos.get(i).getCfop() + "\n"
                    + "Codigo=" + listaVendidos.get(i).getCodigo_produto() + "\n"
                    + "cEAN=SEM GTIN\n"
                    + "Descricao=" + controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getNome() + " \n"
                    + "NCM=" + controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getNcm() + "\n"
                    + "Unidade=" + controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getUnidadeMedida()).getAbreviacao() + "\n"
                    + "Quantidade=" + bLMascaras.converterPontoPraVirgula(String.valueOf(listaVendidos.get(i).getQuantidade())) + "\n"
                    + "ValorUnitario=" + bLMascaras.converterPontoPraVirgula(String.valueOf(listaVendidos.get(i).getValorUnitario())) + "\n"
                    + "ValorTotal=" + bLMascaras.converterPontoPraVirgula(String.valueOf(listaVendidos.get(i).getValorUnitario() * listaVendidos.get(i).getQuantidade())) + "\n"
                    + "ValorDesconto=" + bLMascaras.converterPontoPraVirgula(String.valueOf(valorDesconto / listaVendidos.size())) + "\n"
                    + "vFrete=0,00\n"
                    + "vSeg=0,00\n"
                    + "vOutro=" + bLMascaras.converterPontoPraVirgula(String.valueOf(valorAcrescimo / listaVendidos.size())) + "\n"
                    + "indEscala=N\n"
                    + "uTrib=" + controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getUniFisco()).getAbreviacao() + "\n"
                    + "cEANTrib=SEM GTIN\n"
                    + "\n"
                    + preencheGlp(i)
                    + "\n"
                    + "[ICMS0" + (indiceProduto) + "]\n"
                    + "CSOSN=" + controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getIdcsosn()).getNumero() + "\n"
                    + "Origem=" + controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getOrigem() + "\n"
                    + "ValorBase=" + bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo())) + "\n"
                    + "Aliquota=" + bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getPercentual())) + "\n"
                    + "Valor=" + bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo())) + "\n"
                    + "pCredSN=" + bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculosub())) + "\n"
                    + "vCredICMSSN=" + bLMascaras.converterPontoPraVirgula(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculosubefetivo())) + "\n"
                    + "ModalidadeST=4\n"
                    + "ValorBaseST=0,00\n"
                    + "AliquotaST=0,00\n"
                    + "ValorST=0,00\n"
                    + "PercentualReducao=0,00\n"
                    + "vBCFCP=0\n"
                    + "pFCP=0\n"
                    + "vFCP=0\n"
                    + "\n"
                    + "[PIS0" + (indiceProduto) + "]\n"
                    + "CST=" + controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribFed()).getIdPisCofins()).getNumero() + "\n"
                    + "ValorBase=0,00\n"
                    + "Aliquota=0,00\n"
                    + "Valor=0,00\n"
                    + "\n"
                    + "[COFINS0" + (indiceProduto) + "]\n"
                    + "CST=" + controllerCstPiscofins.getCstPiscofinsController(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribFed()).getIdPisCofins()).getNumero() + "\n"
                    + "ValorBase=0,00\n"
                    + "Aliquota=0,00\n"
                    + "Valor=0,00\n"
                    + "\n"
                    + "[IPI0" + (indiceProduto) + "]\n"
                    + "CST=" + controllerEnquadramentoIpi.getEnquadramentoIpiController(Integer.parseInt(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getIpi())).getNumero() + "\n"
                    + "ValorBase=0,00\n"
                    + "Aliquota=0,00\n"
                    + "Valor=0,00\n"
                    + "\n";
            totalBaseCalculoIcms = (controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo()) + totalBaseCalculoIcms;
            totalValorIcms = (controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(listaVendidos.get(i).getCodigo_produto()).getTribEst()).getBasedecalculo()) + totalValorIcms;
            produtoNFe = produtoNFe + produtoLocal;
        }
        return true;
    }

    private String preencheGlp(int indice) {
        String glp;
        if (controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getTipo() == 1) {
            glp = "[Combustivel00" + (indice + 1) + "]\n"
                    + "descANP=" + controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getDescricaoAnp() + "\n"
                    + "cProdANP=" + controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getCodProdutoAnp() + "\n"
                    + "pMixGN=1\n"
                    + "UFCons=" + controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getEstadoConsumidor() + "\n"
                    + "pGNn=" + controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getPercGnn() + "\n"
                    + "pGNi=" + controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getPercGni() + "\n"
                    + "pGLP=" + controllerProdutos.getProdutosController(listaVendidos.get(indice).getCodigo_produto()).getPercGlp() + "\n";
        } else {
            glp = "";
        }
        return glp;
    }

    public boolean carregarIniNfce(int codigoVendaretorno, float total, ArrayList<String> fPagamento, float valorDesconto, String documentoAvulso, String clienteAvulso, float valorTroco, float valorAcrescimo) throws IOException, ParseException {

        if (gerarProdutosNcfe(codigoVendaretorno, valorDesconto, valorAcrescimo) == true) {

            LocalDate dataDeInscricao = LocalDate.now();
            String data = dataDeInscricao.toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Calendar hora = Calendar.getInstance();
            String serieNfce = String.valueOf(controllerNumeracao.getNumeracaoController(1).getSerieNfce());
            String numeroNfce = String.valueOf(controllerNumeracao.getNumeracaoController(1).getNumeroNfce());
            total = total;

            chaveAcesso();

            arquivoINI = "[infNFe]\n"
                    + "\n"
                    + "versao=4.0\n"
                    + "\n"
                    + "[Identificacao]\n"
                    + "natOp=Venda de Mercadoria\n"
                    + // "indPag="+fPagamento+"\n" +
                    "indPag=" + "\n"
                    + "mod=65\n"
                    + "serie=" + serieNfce + "\n"
                    + "nNF=" + numeroNfce + "\n"
                    + "dEmi=" + bLMascaras.converteTimeEmDataHoraNF(System.currentTimeMillis()) + "\n"
                    + "tpNF=1\n"
                    + "Finalidade=1\n"
                    + "idDest=1\n"
                    + "indFinal=1\n"
                    + "indPres=1\n"
                    + "tpimp=4\n"
                    + "tpAmb=1\n"
                    + "\n"
                    + "[Emitente]\n"
                    + "CRT=" + modelEmpresa.getCrt() + " \n"
                    + "CNPJ=" + modelEmpresa.getCnpj() + " \n"
                    + "IE=" + modelEmpresa.getInscEstad() + " \n"
                    + "Razao=" + modelEmpresa.getRazaoSocial() + " \n"
                    + "Fantasia=" + modelEmpresa.getNomeFantasia() + " \n"
                    + "Fone=" + modelEmpresa.getTelefone() + " \n"
                    + "CEP=" + modelEmpresa.getCep() + " \n"
                    + "Logradouro=" + modelEmpresa.getEndereco() + " \n"
                    + "Numero=" + modelEmpresa.getEnderecoNumero() + " \n"
                    + "Complemento=" + modelEmpresa.getEnderecoComplemento() + " \n"
                    + "Bairro=" + modelEmpresa.getBairro() + " \n"
                    + "CidadeCod=" + controllerCidade.getCidadeController(controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(modelEmpresa.getCodigo()).getModelCidade().getCodigo()).getCodigoIBGE() + " \n"
                    + "Cidade=" + controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(modelEmpresa.getCodigo()).getModelCidade().getNome() + " \n"
                    + "UF=" + controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(modelEmpresa.getCodigo()).getModelEstado().getUf() + " \n"
                    + "\n"
                    + destinatárioNfe(codigoVendaretorno, documentoAvulso, clienteAvulso)
                    + produtoNFe
                    + "[Total]\n"
                    + "BaseICMS=" + bLMascaras.converterPontoPraVirgula(String.valueOf(totalBaseCalculoIcms)) + "\n"
                    + "ValorICMS=" + bLMascaras.converterPontoPraVirgula(String.valueOf(totalValorIcms)) + "\n"
                    + "vICMSDeson=0,00\n"
                    + "BaseICMSSubstituicao=0,00\n"
                    + "ValorICMSSubstituicao=0,00\n"
                    + "ValorProduto=" + bLMascaras.converterPontoPraVirgula(String.valueOf(total)) + "\n"
                    + "ValorFrete=0,00\n"
                    + "ValorSeguro=0,00\n"
                    + "ValorDesconto=" + bLMascaras.converterPontoPraVirgula(String.valueOf(valorDesconto)) + "\n"
                    + "ValorIPI=0,00\n"
                    + "ValorPIS=0,00\n"
                    + "ValorCOFINS=0,00\n"
                    + "ValorOutrasDespesas=" + bLMascaras.converterPontoPraVirgula(String.valueOf(valorAcrescimo)) + "\n"
                    + "ValorNota=" + bLMascaras.converterPontoPraVirgula(String.valueOf(total - valorDesconto + valorAcrescimo)) + "\n"
                    + "vFCP=0\n"
                    + "\n"
                    + "[DadosAdicionais]\n"
                    + "Complemento= " + retornarIbpt(codigoVendaretorno) + "\n"
                    + "\n"
                    + "[Transportador]\n"
                    + "modFrete=9\n"
                    + "\n"
                    + formaPagamento(codigoVendaretorno, total, fPagamento)
                    + "vTroco=" + bLMascaras.converterPontoPraVirgula(String.valueOf(valorTroco)) + "\n"
                    + "[infRespTec]\n"
                    + "CNPJ=03847419000171\n"
                    + "xContato=Fabio Braga\n"
                    + "email=fabio.braga.suporte@gmail.com\n"
                    + "fone=2730308326";

            
            logutil.info("Chave Acesso: "+  chaveCriada);
            manipularXml.gravaININfce(arquivoINI, chaveCriada);

            return true;
        } else {
            return false;
        }
    }

    public int procuraRetorno(String retorno, String procura) {
        int indice = 0;
        if (retorno.contains(procura)) {
            indice = retorno.indexOf(procura);
        }
        return indice;
    }

    public synchronized String transmitirNfce(int codigoVendaretorno, float valorTotal, ArrayList<String> fPagamento, float valorDesconto, String documentoAvulso, String clienteAvulso, float valorTroco, float valorAcrescimo) throws IOException, ParseException, Exception {
        acbrNFe = new ACBrNFe();
        String ret = "";
        codigoVenda = codigoVendaretorno;
        String status = "cStat=";
        String motivoErro = "XMotivo=";
        String msg = "Msg=";

        logutil.info("Inicia transmissao");
        
        if (carregarIniNfce(codigoVendaretorno, valorTotal, fPagamento, valorDesconto, documentoAvulso, clienteAvulso, valorTroco, valorAcrescimo) == true) {
            carregarConfiguracoes();
            acbrNFe.limparLista();
            acbrNFe.carregarIni(arquivoINI);
            logutil.info("Carregou .INI");
            if (metodoEnvioNfce == 1) {
                try {
                    ret = acbrNFe.enviar(0, false, true, true);
                } catch (Exception e) {
                    logutil.error(e);
                    classeInterfaces.avisaOuvintesRejeicao("pdv", (e.getMessage()));
                }
            } else {
                try {
                    ret = acbrNFe.enviar(0, false, false, true);
                } catch (Exception e) {
                     logutil.error(e);
                    classeInterfaces.avisaOuvintesRejeicao("pdv", (e.getMessage()));
                }
            }
            
             logutil.info("Verificando resultado");

            int inicioStatus = (procuraRetorno(ret, status) + status.length());
            int inicioMotivo = (procuraRetorno(ret, motivoErro) + motivoErro.length());
            if (ret.equals("")) {
                classeInterfaces.avisaOuvintesRejeicao("pdv", "erro na emissão");
            } else {
                if (ret.substring(inicioStatus, inicioStatus + 3).equals("100")) {
                    gravarArquivo(0);
                    int atualizaNumero = controllerNumeracao.getNumeracaoController(1).getNumeroNfce();
                    controllerNumeracao.atualizarNumeracaoNfceController(atualizaNumero);
                } else {
                    gravarArquivo(0);
                    int atualizaNumero = controllerNumeracao.getNumeracaoController(1).getNumeroNfce();
                    controllerNumeracao.atualizarNumeracaoNfceController(atualizaNumero);
                    retornarValorCaixa(fPagamento);
                    retornarProdutoAoEstoqueVendaCancelada(controllerVendasProdutos.getListaVendasProdutosController(codigoVendaretorno));
                    classeInterfaces.avisaOuvintesRejeicao("pdv", (ret.substring(inicioMotivo)));
                }
            }
        }
        return ret;
    }

    public void grava(String retorno, String caminhoSalvar) {
        String chaveDFE = "chDFe=";
        String status = "CStat=";
        int inicioChave = ((procuraRetorno(retorno, chaveDFE)) + chaveDFE.length());
        int inicioStatus = ((procuraRetorno(retorno, status)) + status.length());

        String nomeArquivo = retorno.substring(inicioChave, (inicioChave + 44)) + "-nfe.xml";
        String statusArquivo = retorno.substring(inicioStatus, (inicioStatus + 3));
        try {
            gravaNFceNoBanco(nomeArquivo, caminhoSalvar, statusArquivo);
        } catch (Throwable ex) {
            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* 
   public void grava(String retorno, String caminhoSalvar){
       String chaveDFE  = "chDFe=";
       String status = "CStat=";
       int inicioChave = ((procuraRetorno(retorno,chaveDFE))+chaveDFE.length());
       int inicioStatus = ((procuraRetorno(retorno,status))+status.length());
            
       String nomeArquivo = retorno.substring(inicioChave,(inicioChave + 44) )+"-nfe.xml";
       String statusArquivo = retorno.substring(inicioStatus,(inicioStatus + 3));
        try {
            gravaNFceNoBanco(nomeArquivo,caminhoSalvar, statusArquivo);
        } catch (Exception ex) {
            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
        }
   }*/
    public void imprime(String retorno) throws Exception {
        logutil.info("Inicia a Impressao");
        carregarConfiguracoes();
        String protocolo = "NProt=";
        String status = "CStat=";
        int inicioProtocolo = (procuraRetorno(retorno, protocolo) + protocolo.length());
        int inicioStatus = ((procuraRetorno(retorno, status)) + status.length());
        String protocoloLocal = (retorno.substring(inicioProtocolo, (inicioProtocolo + 15)));
        String statusArquivo = retorno.substring(inicioStatus, (inicioStatus + 3));
        if (statusArquivo.equals("100")) {
            if (visualizarNfce == 0) {
                try {
                    //Tentar porteger contra crash
                    com.sun.jna.Native.setProtected(true);
                    if (!com.sun.jna.Native.isProtected()) {
                        //Sistema operacional não suportar proteção contra crash
                        System.out.println("não protegeu");
                    }
                    acbrNFe.imprimir(impressoraPDV, 1, protocoloLocal, false, true, true, false);
                } catch (Error er1) {
                    //Falha ao imprimir, esperar 2 segundos e tentar novamente
                    Thread.sleep(2000);
                    try {
                        acbrNFe.imprimir(impressoraPDV, 1, protocoloLocal, false, true, true, false);
                    } catch (Error er2) {
                        //Falha ao imprimir, esperar 2 segundos e tentar novamente
                        throw new IOException("Falha ao acionar impressora", er2);
                    }
                }
            } else {

                try {
                    //Tentar porteger contra crash
                    /*com.sun.jna.Native.setProtected(true);
                if(!com.sun.jna.Native.isProtected()){
                    //Sistema operacional não suportar proteção contra crash
                    System.out.println("não protegeu");
                }*/
                    acbrNFe.imprimir(impressoraPDV, 1, protocoloLocal, true, true, true, false);
                } catch (Error er1) {
                    //Falha ao imprimir, esperar 2 segundos e tentar novamente
                    Thread.sleep(2000);
                    try {
                        acbrNFe.imprimir(impressoraPDV, 1, protocoloLocal, true, true, true, false);
                    } catch (Error er2) {
                        //Falha ao imprimir, esperar 2 segundos e tentar novamente
                        throw new IOException("Falha ao acionar impressora", er2);
                    }
                }
            }
            limparCamposCliente();
        } else {

        }

    }

    private String ultimoArquivo(String caminhoBuscar) {
        String nomeArquivo = "";
        File file = new File(caminhoBuscar);
        File afile[] = file.listFiles();
        nomeArquivo = afile[afile.length - 1].getName();
        return nomeArquivo;
    }

    private void carregarConfiguracoes() {
        visualizarNfce = controllerCconfiguracao.getConfiguracaoController(1).getVisualizarNfce();
        metodoEnvioNfce = controllerCconfiguracao.getConfiguracaoController(1).getMetodoEnvioNfce();
        classificacaoFiscal = controllerCconfiguracao.getConfiguracaoController(1).getClassificacaoFiscal();
        quantidadeImprimir = controllerCconfiguracao.getConfiguracaoController(1).getQuantidadeImpressao();
        modeloImprimir = controllerCconfiguracao.getConfiguracaoController(1).getModeloImpresssao();
        impressoraPDV = controllerCconfiguracao.getConfiguracaoController(1).getImpressoraPdv();
    }

    private Boolean gravarArquivo(int index) {
        try {
            acbrNFe.gravarXml(index);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void retornarValorCaixa(ArrayList<String> formaPagamento) {
        ControllerCaixa caixa = new ControllerCaixa();
        modelCaixa = caixa.getCaixaController(getNumeroCaixa());
        for (int r = 0; r < formaPagamento.size(); r++) {
            String x = formaPagamento.get(r).substring(0, 2);
            switch (x) {
                case "01":
                    this.modelCaixa.setDinheiro(this.modelCaixa.getDinheiro() - bLMascaras.converterVirgulaParaPontoReturnFloat(formaPagamento.get(r).substring(4)));
                    break;
                case "02":
                    this.modelCaixa.setCheque(this.modelCaixa.getCheque() - bLMascaras.converterVirgulaParaPontoReturnFloat(formaPagamento.get(r).substring(4)));
                    break;
                case "03":
                    this.modelCaixa.setCartao(this.modelCaixa.getCartao() - bLMascaras.converterVirgulaParaPontoReturnFloat(formaPagamento.get(r).substring(4)));
                    break;
                case "04":
                    this.modelCaixa.setCartao(this.modelCaixa.getCartao() - bLMascaras.converterVirgulaParaPontoReturnFloat(formaPagamento.get(r).substring(4)));
                    break;
                case "05":
                    this.modelCaixa.setConvenio(this.modelCaixa.getConvenio() - bLMascaras.converterVirgulaParaPontoReturnFloat(formaPagamento.get(r).substring(4)));
                    break;
            }

        }
        caixa.atualizarCaixaController(modelCaixa);
        /*
           
           for (int i = 0; i<listaFpagamento.size(); i++){
       pagamentosLocal =  pagamentosLocal + "[pag00"+(i+1)+"]\n" 
               +"tPag="+listaFpagamento.get(i).substring(0, 2)+"\n" 
               + "vPag="+bLMascaras.converterPontoPraVirgula(listaFpagamento.get(i).substring(4))+"\n" +
               "\n";
           
         */
    }

    private void limparCamposCliente() {
        cpfCnpj.setText("");
        Consumidor.setText("");
        tfClienteAvulso.setText("");
        tfCpfCnpjAvulso.setText("");
    }

    public void recuperarVenda(int codigoVenda) {
        ModelVendas mvRecupera = new ModelVendas();
        float valorTotalRecuperado = 0.0f;
        ModelClienteCidadeEstado mcRecupera = new ModelClienteCidadeEstado();
        ArrayList<ModelVendasProdutos> mpRecupera = new ArrayList<>();
        if (codigoVenda != 0) {
            mvRecupera = controllerVendas.getVendasController(codigoVenda);
            mcRecupera = controllerClienteCidadeEstado.getClienteCidadeEstadoController(mvRecupera.getClientesCodigo());
        } else {
            try {
                mvRecupera.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            } catch (Exception ex) {
                Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        mpRecupera = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
        ordem = (mpRecupera.size() + 1);
        for (int r = 0; r < mpRecupera.size(); r++) {
            valorTotalRecuperado += mpRecupera.get(r).getQuantidade() * mpRecupera.get(r).getValorUnitario();
            tfQuantidadePdv.setText(String.valueOf(mpRecupera.get(r).getQuantidade()));
            tfValorUnitarioPdv.setText(String.valueOf(mpRecupera.get(r).getValorUnitario()));
        }
        tfSubTotalPdv.setText(bLMascaras.arredondamentoComPontoDuasCasasFloatString(valorTotalRecuperado));
        totalgeralfracao = valorTotalRecuperado;
        tabelaCupom.getItems().clear();
        tabelaCupom.getItems().addAll(recuperarTabela(mpRecupera, mvRecupera));

    }

    private ObservableList<ModelVendasProdutosTabela> recuperarTabela(ArrayList<ModelVendasProdutos> produtosVendas, ModelVendas vendaRecuperada) {
        ArrayList<ModelVendasProdutosTabela> produtos = new ArrayList<>();
        ObservableList<ModelVendasProdutosTabela> tabelaRecuperada = null;

        for (int i = 0; i < produtosVendas.size(); i++) {
            ModelVendasProdutosTabela mvptRecupera = new ModelVendasProdutosTabela();
            mvptRecupera.setProduto(produtosVendas.get(i).getNomeProduto());
            mvptRecupera.setOrdem(i + 1);
            mvptRecupera.setQuantidade(produtosVendas.get(i).getQuantidade());
            mvptRecupera.setValorUnitario(produtosVendas.get(i).getValorUnitario());
            mvptRecupera.setValorTotal(produtosVendas.get(i).getQuantidade() * produtosVendas.get(i).getValorUnitario());
            mvptRecupera.setDataVenda(String.valueOf(vendaRecuperada.getDataVenda()));
            produtos.add(mvptRecupera);
        }
        tabelaRecuperada = FXCollections.observableArrayList(produtos);
        return tabelaRecuperada;
    }

    /**
     *
     * @param nomeArquivo
     * @param caminho
     */

    public void gravaNFceNoBanco(String nomeArquivo, String caminho, String Status) throws Exception {
        if (!(Status.equals("100"))) {
            nomeArquivo = ultimoArquivo(caminho);
        }
        String caminhoArquivo = caminho + "\\" + nomeArquivo;
        ViewLeitorNotaXML leitorNotaXml = new ViewLeitorNotaXML();
        leitorNotaXml.lerarq(caminhoArquivo, codigoVenda);
    }

    /* public void gravaNFceNoBanco(String nomeArquivo, String caminho, String Status) throws Exception{
       if (!(Status.equals("100"))){
           nomeArquivo = ultimoArquivo(caminho);
       }
       String caminhoArquivo = caminho+ "\\"+nomeArquivo;
       ViewLeitorNotaXML leitorNotaXml = new ViewLeitorNotaXML();
       leitorNotaXml.lerarq(caminhoArquivo, codigoVenda);
   }*/
    public String escolheArq() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Arquivo XML", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            return selectedFile.getPath();

        } else {
            return null;
        }
    }

    public void importarNfceSaida() {
        String caminhoCompleto = escolheArq().toLowerCase();
        codigoVenda += 1;
        String nome = caminhoCompleto.substring(50);
        String caminho = caminhoCompleto.substring(0, 49);
        try {
            String caminhoArquivo = caminho + "\\" + nome;
            ViewLeitorNotaXML leitorNotaXml = new ViewLeitorNotaXML();
            leitorNotaXml.lerarq(caminhoArquivo, codigoVenda);
        } catch (Exception ex) {
            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean cadastrarVenda() {
        controllerCFOP = new ControllerCFOP();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar hora = Calendar.getInstance();

        // atualiza lista de produtos ja lançados
        listamodel.clear();
        listamodel.addAll(controllerVendasProdutos.getListaVendasProdutosController(0));
        Collections.reverse(listamodel);
        listadeProdutos = FXCollections.observableArrayList(listamodel);
        if (tfSubTotalPdv.getText().equals("") || listadeProdutos.size() < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ATENÇÃO");
            alert.setContentText("Você deve preencher todos os campos!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
            return false;

        } else {
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProdutolocal;
            float quantidadelocal;

            for (int i = 0; i < listadeProdutos.size(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(Consumidor.getText()).getCodigo());
                modelVendas.setDesconto(0f);
                modelVendas.setTaxaEntrega(0f);
                //modelVendas.setValorTotal(bLMascaras.arredondamentoComPontoDuasCasas((float) (listadeProdutos.get(i).getValorUnitario() * listadeProdutos.get(i).getQuantidade())));
                modelVendas.setObservacao("");
                modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                    modelVendas.setHoraVenda(dateFormat.format(hora.getTime()));
                } catch (Exception ex) {
                    Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProdutolocal = (listadeProdutos.get(i).getCodigo_produto());
                modelVendas.setProdutosCodigo(codigoProdutolocal);
                modelVendas.setVencimento("");
                modelVendas.setTipo(65);
                modelVendas.setValor(bLMascaras.truncamentoComPontoDuasCasasDouble(listadeProdutos.get(i).getValorUnitario()));
                modelVendas.setValorTotal(Float.parseFloat(tfSubTotalPdv.getText()));
                modelVendas.setQuantidade(listadeProdutos.get(i).getQuantidade());
                modelVendas.setCfop(listadeProdutos.get(i).getCfop());
                modelVendas.setIcmsCst(listadeProdutos.get(i).getIcmsCst());
                modelVendas.setIpiCst(listadeProdutos.get(i).getIpiCst());
                modelVendas.setPisCst(listadeProdutos.get(i).getPisCst());
                modelVendas.setCofinsCst(listadeProdutos.get(i).getCofinsCst());
                modelVendas.setOrdem(listadeProdutos.get(i).getOrdem() - 1);
                modelProdutos.setEstadoConsumidor("ES");
                try {
                    modelVendas.setTipoPagamento(codPagamento);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ATENÇÃO");
                    alert.setContentText("Você deve cadastrar uma forma de pagamento!");
                    alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
                    alert.show();
                }

                modelProdutos.setCodigo(codigoProdutolocal);
                quantidadelocal = controllerProdutos.getProdutosController(codigoProdutolocal).getEstoque() - (listadeProdutos.get(i).getQuantidade());
                modelProdutos.setEstoque(quantidadelocal);
                modelProdutos.setNome(listadeProdutos.get(i).getNomeProduto());
                modelProdutos.setUnidadeMedida(controllerUnidadeMedia.getUnidadeMediaController(listadeProdutos.get(i).getUnidade()).getCodigo());
                if (listadeProdutos.get(i).getTipo() == 1) {
                    modelProdutos.setTipo(listadeProdutos.get(i).getTipo());
                    modelProdutos.setCodProdutoAnp("210203001");
                    modelProdutos.setDescricaoAnp(listadeProdutos.get(i).getDescricaoAnp());
                    modelProdutos.setPercGlp(listadeProdutos.get(i).getPercGlp());
                    modelProdutos.setPercGnn(listadeProdutos.get(i).getPercGnn());
                    modelProdutos.setPercGni(listadeProdutos.get(i).getPercGni());
                    modelProdutos.setValorProdutoGlp(listadeProdutos.get(i).getValorProdutoGlp());
                    modelProdutos.setEstadoConsumidor(controllerClienteCidadeEstado.getClienteCidadeEstadoController(codigoCliente).getModelEstado().getUf());
                }
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }

            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);

            //salvar venda
            if ((!(tfNota.getText().equals("NOVO"))) && (Integer.parseInt(tfNota.getText()) > 0)) {
                modelVendas.setCodigo(Integer.parseInt(tfNota.getText()));
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                //atualizarProdutosVendidos(modelVendas);
                controllerVendas.atualizarVendasController(modelVendas);
                //controllerVendas.salvarVendasProdutosController(modelVendas);
                controllerVendas.atualizarVendasProdutosListaController(modelVendas);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ATUALIZADO");
                alert.setContentText("Venda atualizada com sucesso!");
                alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
                alert.show();
                limparCamposVenda();

            } else if (tfNota.getText().equals("NOVO")) {
                codigoVenda = controllerVendas.salvarVendasController(modelVendas);
                tfNota.setText(String.valueOf(codigoVenda));
                modelVendas.setCodigo(codigoVenda);
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos

                //atualizarProdutosVendidos(modelVendas);
                controllerVendas.atualizarVendasProdutosListaController(modelVendas);

                ordem = 1;
                return true;

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERRO");
                alert.setContentText("Erro ao gravar os dados!");
                alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
                alert.show();

            }

        }
        return false;
    }

    private void atualizarProdutosVendidos(ModelVendas mvpAtualizar) {
        ModelVendas listaAtualizar = new ModelVendas();
        for (int p = 0; p < mvpAtualizar.getListamModelVendases().size(); p++) {
            listaAtualizar.setCodigo(mvpAtualizar.getListamModelVendases().get(p).getCodigo());
            listaAtualizar.setProdutosCodigo(mvpAtualizar.getListamModelVendases().get(p).getProdutosCodigo());
            listaAtualizar.setQuantidade(mvpAtualizar.getListamModelVendases().get(p).getQuantidade());
            listaAtualizar.setQuantidade(mvpAtualizar.getListamModelVendases().get(p).getQuantidade());
            listaAtualizar.setIpiCst(mvpAtualizar.getListamModelVendases().get(p).getIpiCst());
            listaAtualizar.setIcmsCst(mvpAtualizar.getListamModelVendases().get(p).getIcmsCst());
            listaAtualizar.setPisCst(mvpAtualizar.getListamModelVendases().get(p).getPisCst());
            listaAtualizar.setCofinsCst(mvpAtualizar.getListamModelVendases().get(p).getCofinsCst());
            listaAtualizar.setCfop(mvpAtualizar.getListamModelVendases().get(p).getCfop());
            listaAtualizar.setOrdem(mvpAtualizar.getListamModelVendases().get(p).getOrdem());
            listaAtualizar.setObservacao(mvpAtualizar.getListamModelVendases().get(p).getObservacao());
            listaAtualizar.setValor(mvpAtualizar.getListamModelVendases().get(p).getValor());
            listaAtualizar.setValorTotal(mvpAtualizar.getListamModelVendases().get(p).getValorTotal());
            controllerVendas.atualizarVendasProdutosListaController(listaAtualizar);
        }

    }

    public void importarPreVenda() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqVendas.fxml"));
        Parent raizVendas = (Parent) loader.load();
        listaVendas lVendas = loader.getController();
        lVendas.origemOp = 1;
        lVendas.listaFiltroPreVendas();
        Stage stageVendas = new Stage();
        stageVendas.setScene(new Scene(raizVendas));
        stageVendas.show();
    }

    public void importarMesas() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqVendas.fxml"));
        Parent raizVendas = (Parent) loader.load();
        listaVendas lVendas = loader.getController();
        lVendas.origemOp = 1;
        lVendas.listaFiltroMesas();
        Stage stageVendas = new Stage();
        stageVendas.setScene(new Scene(raizVendas));
        stageVendas.show();
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

    private void retornarProdutoAoEstoqueVendaCancelada(ArrayList<ModelVendasProdutos> listaVoltar) {
        float quantRetorno;
        int cont = listaVoltar.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos = new ModelProdutos();
            modelProdutos.setCodigo(listaVoltar.get(i).getCodigo_produto());
            quantRetorno = controllerProdutos.getProdutosController(modelProdutos.getCodigo()).getEstoque() + listaVoltar.get(i).getQuantidade();
            modelProdutos.setEstoque(quantRetorno);
            listaModelProdutos.add(modelProdutos);
        }
        modelProdutos.setListaModelProdutoses(listaModelProdutos);
        controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
    }

    public void finalizarVenda() {

        //narValorCaixa();
        limparCamposVenda();
        //    Limpa lista modelo
        listamodel = new ArrayList<>();

    }

    public boolean verificarCaixa() {

        ModelCaixa modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
        if (modelCaixa.getCaixaNumero() == 1 && modelCaixa.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public void habilitarSangria() {
        pnSangria.setMinHeight(80);
        pnSangria.setVisible(true);
        tfValorSangria.setVisible(true);
        btConfirmaSangria.setVisible(true);
        btCancelaSangria.setVisible(true);
    }

    public void sangriaCaixa() {
        if (tfValorSangria.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setContentText("Não foi digitado um valor para Sangria!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
        } else if (controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa()).getDinheiro() <= bLMascaras.converterVirgulaParaPontoReturnDouble(tfValorSangria.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERRO");
            alert.setContentText("O valor em Dinheiro de caixa é menor que o valor da Sangria Solicitada!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
        } else {
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialogoExe.setHeaderText("SANGRIA DO CAIXA");
            dialogoExe.setContentText("Deseja Confirmar a Retirada?");
            dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
            dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
            dialogoExe.showAndWait().ifPresent(b -> {
                if (b == btnSim) {
                    ModelCaixa modelCaixa = new ModelCaixa();
                    modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
                    modelCaixa.setSangria((bLMascaras.converterVirgulaParaPontoReturnDouble(tfValorSangria.getText())) + modelCaixa.getSangria());
                    modelCaixa.setCodigo(modelCaixa.getCodigo());
                    controllerCaixa.atualizarSangriaCaixaController(modelCaixa);
                    try {
                        imprimirSangria(modelCaixa.getCaixaNumero(), modelCaixa.getCodigoUsuario(), bLMascaras.converterVirgulaParaPontoReturnDouble(tfValorSangria.getText()));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pnSangria.setMaxHeight(1);
                    pnSangria.setVisible(false);
                    tfValorSangria.setVisible(false);
                    btConfirmaSangria.setVisible(false);
                    btCancelaSangria.setVisible(false);
                } else {
                    tfValorSangria.setText("");
                    pnSangria.setMaxHeight(1);
                    pnSangria.setVisible(false);
                    tfValorSangria.setVisible(false);
                    btConfirmaSangria.setVisible(false);
                    btCancelaSangria.setVisible(false);
                }
            });
        }
    }

    /*public void imprimirSangria(int codigoCaixa, int codigoUsuario, Double ValorSangriaAtual){
     try {
            String nomeImpressora = impressoraPDV;
            //gerar dados e imprimir
            String textoImprimir = new GerarCupom().geraCupomSangriaCaixa(codigoCaixa ,codigoUsuario ,ValorSangriaAtual);
            //formatar texto
          
            AttributedString string = new AttributedString(textoImprimir);
            string.addAttribute(TextAttribute.FONT, new Font("FreeMono", Font.ITALIC, 17));
              
            //enviar para impressora
            Impressora.imprimir(nomeImpressora, textoImprimir);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
}*/
    public void imprimirSangria(int codigoCaixa, int codigoUsuario, Double ValorSangriaAtual) throws InterruptedException {
        try {
            String nomeImpressora = impressoraPDV;
            //gerar dados e imprimir
            String textoImprimir = new GerarCupom().geraCupomSangriaCaixa(codigoCaixa, codigoUsuario, ValorSangriaAtual);
            //formatar texto

            AttributedString string = new AttributedString(textoImprimir);
            string.addAttribute(TextAttribute.FONT, new Font("FreeMono", Font.ITALIC, 17));

            //enviar para impressora
            try {
                //Tentar porteger contra crash
                /*   com.sun.jna.Native.setProtected(true);
                if(!com.sun.jna.Native.isProtected()){
                    //Sistema operacional não suportar proteção contra crash
                    System.out.println("não protegeu");
                }*/
                Impressora.imprimir(nomeImpressora, textoImprimir);
            } catch (Error er1) {
                //Falha ao imprimir, esperar 2 segundos e tentar novamente
                Thread.sleep(2000);
                try {
                    Impressora.imprimir(nomeImpressora, textoImprimir);
                } catch (Error er2) {
                    //Falha ao imprimir, esperar 2 segundos e tentar novamente
                    throw new IOException("Falha ao acionar impressora", er2);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fecharSangria() {
        tfValorSangria.setText("");
        pnSangria.setMaxHeight(1);
        pnSangria.setVisible(false);
        tfValorSangria.setVisible(false);
        btConfirmaSangria.setVisible(false);
        btCancelaSangria.setVisible(false);
    }

    private void habilitarCampos() {
        tfDescricaoPdv.setFocusTraversable(true);
        tfQuantidadePdv.setFocusTraversable(true);
        tfValorUnitarioPdv.setFocusTraversable(false);
        tfSubTotalPdv.setFocusTraversable(false);
        lbConsumidor.setVisible(false);
        lbCpfCnpj.setVisible(false);
        lbStatus.setVisible(false);
        Consumidor.setVisible(false);
        cpfCnpj.setVisible(false);
        pnCnpjCpfAvulso.setVisible(false);
        pnStatus.setVisible(true);
        pnSangria.setVisible(false);
        tfValorSangria.setVisible(false);
        btConfirmaSangria.setVisible(false);
        ordem = 1;
        totalgeralfracao = 0;

    }

    public void cpfCnpjAvulso() {
        pnCnpjCpfAvulso.setVisible(true);
        btCpfCnpjOk.setDisable(true);
        formatarDocumentoAvulso();
        if (bLMascaras.isCPF(bLMascaras.removerFormatacao(tfCpfCnpjAvulso.getText())) == true || (bLMascaras.isCNPJ(bLMascaras.removerFormatacao(tfCpfCnpjAvulso.getText()))) == true) {
            btCpfCnpjOk.setDisable(false);
        }
    }

    public void formatarDocumentoAvulso() {
        TextFieldFormatter tff = new TextFieldFormatter();
        if (cbFisicaJuridica.getSelectionModel().getSelectedIndex() == 0) {
            lbCnpjCpfAvulso.setText("CPF");
            tff.setMask("###.###.###-##");
            tff.setCaracteresValidos("1234567890");
            tff.setTf(tfCpfCnpjAvulso);
            tff.formatter();
        } else if (cbFisicaJuridica.getSelectionModel().getSelectedIndex() == 1) {
            lbCnpjCpfAvulso.setText("CNPJ");
            tff.setMask("##.###.###/####-##");
            tff.setCaracteresValidos("1234567890");
            tff.setTf(tfCpfCnpjAvulso);
            tff.formatter();
        }
    }

    public void iniciaCpfCnpjAvulso() {
        cbFisicaJuridica.getItems().addAll("Fisica", "juridica");
    }

    public void definirCpfCnpjAvulso() {
        Consumidor.setVisible(true);
        lbConsumidor.setVisible(true);
        cpfCnpj.setVisible(true);
        lbCpfCnpj.setVisible(true);
        Consumidor.setText(tfClienteAvulso.getText());
        cpfCnpj.setText(tfCpfCnpjAvulso.getText());
        pnCnpjCpfAvulso.setVisible(false);
    }

    public void listaConsumidor() {
        listaCliente lCliente = new listaCliente();
        try {
            lCliente.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limpaTelaNovoProduto() {
        tfQuantidadePdv.setText("1");
        tfDescricaoPdv.setText("");
        contVendaMenor = 0;

    }

    private void saidaTabela() {
        tfQuantidadePdv.setText("1");
        tfDescricaoPdv.setText("");
        contVendaMenor = 0;
        tabelaCupom.setFocusTraversable(false);
        tfDescricaoPdv.requestFocus();

    }

    public void contaReceber() throws Exception {

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
        Modelcontareceber.setObservacao(this.tfNota.getText());

        Controllercontareceber.salvarContaReceberController(Modelcontareceber);

    }

    private void atualizarFormaPagamento(int codigoVendaAtualiza, ArrayList<String> FormaPagamentos) {
        modelVendas = controllerVendas.getVendasController(codigoVendaAtualiza);

        modelVendas.setCodigo(modelVendas.getCodigo());
        if (FormaPagamentos.size() > 1) {
            modelVendas.setTipoPagamento(5);
        } else {
            modelVendas.setTipoPagamento(Integer.parseInt(FormaPagamentos.get(0).substring(0, 2)));
        }
        modelVendas.setCaixa(modelVendas.getCaixa());
        modelVendas.setTaxaEntrega(modelVendas.getTaxaEntrega());
        modelVendas.setTipo(modelVendas.getTipo());
        try {
            modelVendas.setDataVenda(modelVendas.getDataVenda());
        } catch (Exception ex) {
            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelVendas.setHoraVenda(modelVendas.getHoraVenda());
        modelVendas.setValorTotal(modelVendas.getValorTotal());

        controllerVendas.atualizarVendasController(modelVendas);

    }

    public void gerarNfce(int codigo, float valorTotal, ArrayList<String> fPagamento,
            Float valorTroco, Float valorDesconto, String documentoAvulso, String clienteAvulso, Float valorAcrescimo) {
        carregarConfiguracoes();

        if (classificacaoFiscal == 0) {
            imprimirPedido(codigo);
        } else if (classificacaoFiscal == 1) {
            classeInterfaces.avisaOuvintesProgresso("pdv", Boolean.TRUE);
            final ControllerVendas controllerVendas = new ControllerVendas();
            Thread t = new Thread() {
                @Override
                public void run() {
                    String retorno = "";
                    String caminho = "C:\\UniShop\\dfe\\" + controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj() + "\\Enviado\\Nfce\\" + (bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(6, 10)) + ((bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5)));
                    try {
                        retorno = transmitirNfce(codigo, valorTotal, fPagamento, valorDesconto, documentoAvulso, clienteAvulso, valorTroco, valorAcrescimo);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    try {
                        grava(retorno, caminho);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    try {
                        imprime(retorno);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    classeInterfaces.avisaOuvintesProgresso("pdv", Boolean.FALSE);
                }
            };

            t.start();

        } else if (classificacaoFiscal == 2) {
            atualizarFormaPagamento(codigo, fPagamento);
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialogoExe.setHeaderText("GERAR NFCE");
            dialogoExe.setContentText("Deseja Emitir Nfce agora?");
            dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
            dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
            dialogoExe.showAndWait().ifPresent(b -> {
                if (b == btnSim) {
                    classeInterfaces.avisaOuvintesProgresso("pdv", Boolean.TRUE);
                    final ControllerVendas controllerVendas = new ControllerVendas();
                    Thread t = new Thread() {
                        @Override
                        public void run() {
                            String retorno = "";
                            String caminho = "C:\\UniShop\\dfe\\" + controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj() + "\\Enviado\\Nfce\\" + (bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(6, 10)) + ((bLMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5)));
                            try {
                                retorno = transmitirNfce(codigo, valorTotal, fPagamento, valorDesconto, documentoAvulso, clienteAvulso, valorTroco, valorAcrescimo);
                            } catch (Exception e) {
                                retorno = "";
                                logutil.error(e);
                            }
                            if (!(retorno.equals(""))) {
                                try {
                                    grava(retorno, caminho);
                                } catch (Exception e) {
                                    logutil.error(e);
                                }
                                try {                                    
                                    imprime(retorno);
                                } catch (Exception e) {
                                    logutil.log(Level.SEVERE, e.toString());
                                }
                            } else {
                                classeInterfaces.avisaOuvintesRejeicao("pdv", "ERRO NA EMISSÃO DA NOTA");
                            }

                            classeInterfaces.avisaOuvintesProgresso("pdv", Boolean.FALSE);
                        }
                    };

                    t.start();

                } else {
                    imprimirPedido(codigo);
                }
            });
        }
    }

    private void bloqueiaTela() {
        pnCnpjCpfAvulso.setVisible(true);
        lbStatus.setVisible(true);
        tfDescricaoPdv.setDisable(true);
        tfQuantidadePdv.setDisable(true);

    }

    public synchronized void imprimirPedido(int codigoVendaRetorno) {
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
        ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialogoExe.setTitle("IMPRIMIR PEDIDO");
        dialogoExe.setContentText("Deseja imprimir?");
        dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
        dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
        dialogoExe.showAndWait().ifPresent(b -> {
            if (b == btnSim) {
                final ControllerVendas controllerVendas = new ControllerVendas();
                classeInterfaces.avisaOuvintesProgresso("pdv", Boolean.TRUE);
                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        int codigo = codigoVendaRetorno;
                        if (codigo < 1) {
                            codigo = codigoVenda;
                        } else {
                            codigo = (Integer.parseInt(tfNota.getText()));
                        }
                        try {
                            for (int i = 0; i < quantidadeImprimir; i++) {
                                if (modeloImprimir == 1) {
                                    controllerVendas.gerarRelatorioVenda(codigo);
                                } else if (modeloImprimir == 2) {
                                    controllerVendas.gerarRelatorioVendaCupomCaixa(codigo);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);

                        }

                        classeInterfaces.avisaOuvintesProgresso("pdv", Boolean.FALSE);
                    }
                };
                t1.start();

            } else {
            }
        });
    }

    private void definirDatas() {

        // define a data de vencimento pra 7 dias
        dataAtual = (bLMascaras.addDias(7, new java.util.Date(System.currentTimeMillis())));
        try {

            //  vencimento.setText(bLMascaras.formatarData(dataAtual));
        } catch (Exception ex) {

        }

    }

    public void limparCamposVenda() {
        String logo = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getLogomarca();
        Image img = new Image(logo);
        tfDescricaoPdv.clear();
        tfQuantidadePdv.clear();
        tfSubTotalPdv.clear();
        tfValorTotalPdv.clear();
        tfValorUnitarioPdv.clear();
        totalgeralfracao = 0.f;
        tabelaCupom.getItems().clear();
        tfNota.setText("NOVO");
        ordem = 1;

    }

    public void lancamento() throws Exception {
        // cadastrarVenda();
        //imprimirPedido();
        limparCamposVenda();
        tfDescricaoPdv.requestFocus();
    }

    public void irPraTabela() {
        tabelaCupom.setFocusTraversable(true);
        tabelaCupom.edit(ordem, descProduto);
        tabelaCupom.requestFocus();

    }

    public void irPraTabelaPesquisa() {
        tbConsultaProduto.setFocusTraversable(true);
        tbConsultaProduto.requestFocus();
        tbConsultaProduto.getSelectionModel().focus(0);
    }

    public void abrirVenda(int codigoVenda) {
        listamodel.clear();
        tabelaCupom.getItems().clear();
        modelVendas.setCodigo(codigoVenda);
        //recupera os dados do banco
        modelVendas = controllerVendas.getVendasController(codigoVenda);
        listamodel = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
        //seta os dados na interface
        tfNota.setText(String.valueOf(modelVendas.getCodigo()));
        tfSubTotalPdv.setText(bLMascaras.arredondamentoComPontoDuasCasasFloatString(modelVendas.getValorTotal()));
        //recupera os dados do banco
        int cont = listamodel.size();
        for (int i = 0; i < cont; i++) {
            ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
            listavendidos = new ArrayList<>();
            mvpt.setOrdem(i + 1);
            mvpt.setProduto(controllerProdutos.getProdutosController(listamodel.get(i).getCodigo_produto()).getDescricaoProduto());
            mvpt.setQuantidade(listamodel.get(i).getQuantidade());
            mvpt.setValorUnitario(listamodel.get(i).getValorUnitario());
            mvpt.setValorTotal(bLMascaras.truncamentoComPontoDuasCasasDouble(listamodel.get(i).getQuantidade() * listamodel.get(i).getValorUnitario()));

            listavendidos.add(mvpt);
            //carregar lista de produtos da venda

            tabelaCupom.getItems().addAll(listavendidos);
            totalgeralfracao = (Float.parseFloat(tfSubTotalPdv.getText()));
            ordem = cont + 1;
        }

    }

    public void editarVenda() {
        retornarProdutoAoEstoque();
        controllerVendasProdutos.excluirVendasProdutosCodVendaController(Integer.parseInt(tfNota.getText()));

    }

    public void escolherProduto() {
        ModelProdutos produtoEscolher = tbConsultaProduto.getSelectionModel().getSelectedItem();
        int indiceTabelaEscolher = tbConsultaProduto.getSelectionModel().getSelectedIndex();
        if (produtoEscolher == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ATENCÃO");
            alert.setContentText("Você deve selecionar um item na tabela antes de clicar no botão!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();

        } else {
            tfDescricaoPdv.setText(tbConsultaProduto.getItems().get(indiceTabelaEscolher).getDescricaoProduto());
            tbConsultaProduto.setFocusTraversable(false);
        }

    }

    public void excluirProduto() {

        produtoexcluir = tabelaCupom.getSelectionModel().getSelectedItem();
        indiceTabela = tabelaCupom.getSelectionModel().getSelectedIndex();
        int codProdutoLocal = controllerProdutos.getProdutosController(tabelaCupom.getItems().get(indiceTabela).getProduto()).getCodigo();
        // Verificamos se existe realmente alguma linha selecionada
        if (produtoexcluir == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ATENCÃO");
            alert.setContentText("Você deve selecionar um item na tabela antes de clicar no botão!");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
        } else {
            controllerVendasProdutos.excluirVendasProdutosListaController(codProdutoLocal, codigoVenda);
            recuperarVenda(codigoVenda);
            limpaTelaNovoProduto();

        }
    }

    private float somaEAtualizaValorTotal() {
        float soma = 0, valor = 0, descontoAjuste = 0;

        //pegar valor desconto
        try {
            descontoAjuste = (0f);
        } catch (Exception e) {
            descontoAjuste = 0;
        }
        valor = Float.parseFloat(String.valueOf(tfSubTotalPdv.getText()));
        soma = valor + soma;

        soma = soma - descontoAjuste;

        return bLMascaras.truncamentoComPontoDuasCasasFloat(soma);

    }

    public void renumeraItens() {
        ArrayList<ModelVendasProdutos> listaOrdem = controllerVendasProdutos.getListaVendasProdutosController(0);

        for (int o = 0; o < listaOrdem.size(); o++) {
            controllerVendas.atualizarOrdemProdutosListaController(listaOrdem.get(o).getCodigo_produto(), o);
        }

    }

    public void atualizaTotal(double dimiuirpassou) {

        double totalLocal = ((Double.parseDouble(tfSubTotalPdv.getText())) - dimiuirpassou);
        tfSubTotalPdv.setText(String.valueOf(totalLocal));
        totalgeralfracao = ((Float.parseFloat(tfSubTotalPdv.getText())));
    }

    public void abrirHistorico() {
        clienteHistorico chist = new clienteHistorico();
        try {
            chist.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verHistorico(ActionEvent event) throws IOException {

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

    public void verVendas(ActionEvent event) throws IOException {
        fecharPedidoVenda();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqVendas.fxml"));
        Parent raizVendas = (Parent) loader.load();
        listaVendas lVendas = loader.getController();
        Stage stageVendas = new Stage();
        stageVendas.setScene(new Scene(raizVendas));
        stageVendas.show();

    }

    public void listaProdutos() {
        listaProduto lProduto = new listaProduto();
        try {
            lProduto.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void configNfce(ActionEvent event) {

        FrmMain form = new FrmMain();
        form.setVisible(true);

    }

    public void pagamentos(ActionEvent event) throws IOException {
        cadastrarVenda();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pagamentosPDV.fxml"));
        Parent raizPagamentos = (Parent) loader.load();
        pagamentosPDV pagam = loader.getController();
        pagam.cbxComissao.setVisible(false);
        pagam.valorVenda(Float.parseFloat(tfSubTotalPdv.getText()));
        pagam.origem("pdv");
        pagam.codVenda = codigoVenda;
        pagam.codCliente = (String.valueOf(codigoCliente));
        pagam.documentoAvulso = (cpfCnpj.getText());
        pagam.clienteAvulso = (Consumidor.getText());
        pagam.lbtotal.setText(tfSubTotalPdv.getText());
        pagam.pgDinheiro.setText(tfSubTotalPdv.getText());
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizPagamentos));
        pagStage.initStyle(StageStyle.UNDECORATED);
        pagStage.initModality(Modality.APPLICATION_MODAL);
        pagStage.show();
        limparCamposVenda();

        tfDescricaoPdv.requestFocus();
        listamodel = new ArrayList<>();

    }

    public void abreConsultaEmitidas() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/dialogoConsultaNfcesEmitidas.fxml"));
        Parent consultaEmitidas = (Parent) loader.load();
        Stage emitidasStage = new Stage();
        emitidasStage.setScene(new Scene(consultaEmitidas));
        emitidasStage.initStyle(StageStyle.UNDECORATED);
        emitidasStage.initModality(Modality.APPLICATION_MODAL);
        emitidasStage.show();

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
