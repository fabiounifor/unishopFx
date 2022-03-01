/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unishop;

import FXController.novoPrincipal;
import blserial.BLCriptografiaReversivel;
import blserial.ConfigXML;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerBanco;
import controller.ControllerEmpresa;
import controller.ControllerUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelConfig;
import model.ModelEmpresa;
import model.ModelSessaoUsuario;
import model.ModelUsuario;
import util.ManipularXML;
import com.acbr.nfe.demo.FrmMain;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import util.AguardeGerandoRelatorio;
import util.Backup;
import util.BackupMySQL;
import conexoes.ConexaoMySql;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

/**
 *
 * @author Fabio
 */
public class Unishop extends Application implements Initializable {

    @FXML
    private VBox configBox;
    @FXML
    private TextField empresa;
    @FXML
    public TextField usuario;
    @FXML
    public TextField caminho;
    @FXML
    public PasswordField senha;
    @FXML
    private Button btAutenticar;
    @FXML
    private Button config;
    @FXML
    private Button cancelar;
    @FXML
    private Button salvar;
    @FXML
    private ComboBox comboEmpresa;
    @FXML
    private ProgressBar progresso;
    @FXML
    private Label titulo;
    int codUsuario = 0;
    int codEmpresa = 0;
    String empre;
    ArrayList<TextField> campos = new ArrayList<>(2);

    ModelConfig modelConfig = new ModelConfig();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    BLCriptografiaReversivel criptografiaReversivel = new BLCriptografiaReversivel();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ArrayList<ModelEmpresa> listaModelEmpresas = new ArrayList<>();

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        //    Native.setProtected(true);
        carregarDadosDoBanco();
        passarcomEnter();
        setNextFocus(usuario, senha);
        retornarEmpresa();

        btAutenticar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    autenticar();
                } catch (IOException ex) {
                    Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        senha.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    autenticar();
                } catch (IOException ex) {
                    Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        usuario.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.F12) {
                abrirConfig();
            }
        });

    }

    public void abrirConfig() {
        FrmMain configuracao = new FrmMain();
        try {
            configuracao.setVisible(true);
            configuracao.setSize(1000, 800);
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    public void passarcomEnter() {
        campos.add(usuario);
        campos.add(senha);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/login.fxml"));

        Parent raiz = loader.load();
        carregarDadosDoBanco();
        setNextFocus(usuario, senha);

        Scene scene = new Scene(raiz);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public void setNextFocus(TextField usuario, TextField senha) {

        for (TextField txt : campos) {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase) {
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }

            });

        }
    }

    private void carregarDadosDoBanco() {
        modelConfig = new ModelConfig();
        modelConfig = ManipularXML.lerXmlConfig();
        ModelSessaoUsuario.ipServidor = modelConfig.getIp();
        ModelSessaoUsuario.nomeDoBanco = modelConfig.getNomeBanco();
        ModelSessaoUsuario.usuarioBanco = modelConfig.getUsuario();
        ModelSessaoUsuario.senhaBanco = modelConfig.getSenha();
        ModelSessaoUsuario.caminhoMySQL = modelConfig.getCaminhoMySQL();
        ModelSessaoUsuario.quantidadeMesas = modelConfig.getQuantidadeMesas();

    }

    private void retornarEmpresa() {

        try {
            listaModelEmpresas = controllerEmpresa.getListaEmpresaController();
            for (int i = 0; i < listaModelEmpresas.size(); i++) {
                empresa.setText(listaModelEmpresas.get(i).getRazaoSocial());
                codEmpresa = listaModelEmpresas.get(i).getCodigo();

            }
        } catch (Exception e) {
            System.out.println("ERRO. -> Empresa não cadastrada!");
        }

    }

    private void autenticar() throws IOException {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();

        modelUsuario.setLogin(this.usuario.getText());
        modelUsuario.setSenha(this.senha.getText());

        try {
            if (controllerUsuario.getUsuarioController(modelUsuario)) {

                modelUsuario = controllerUsuario.getUsuarioController(modelUsuario.getLogin());
                ModelSessaoUsuario.nome = modelUsuario.getNome();
                ModelSessaoUsuario.codigo = modelUsuario.getCodigo();
                ModelSessaoUsuario.login = modelUsuario.getLogin();
                codUsuario = modelUsuario.getCodigo();
                principal();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("LOGIN");
                alert.setContentText("USUARIO OU SENHA INVÁLIDA");
                alert.show();
            }
        } catch (Exception e) {
            try {
                ControllerBanco controllerBanco = new ControllerBanco();
                if (controllerBanco.criarBancoCtrl()) {
                    criarEstruturaBanco();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("NOVO BANCO DE DADOS");
                    alert.setContentText("NÃO FOI POSSIVEL CRIAR BANCO");
                    alert.show();
                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("NOVO BANCO DE DADOS");
                alert.setContentText("NÃO FOI POSSIVEL CRIAR BANCO");
                alert.show();
            }
        }

    }

    private void criarEstruturaBanco() {
        String caminho = "C:\\UniShop\\dbblvendas.sql";
        BackupMySQL backupMySQL = new BackupMySQL();
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
        ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
        dialogoExe.setContentText("CRIAR ESTRUTURA DO BANCO DE DADOS?");
        dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
        dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
        dialogoExe.showAndWait().ifPresent(b -> {
            if (b == btnSim) {
                final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
                carregando.setVisible(true);
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            backupMySQL.Restoredbfromsql(caminho);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        carregando.dispose();
                    }
                };
                t.start();
            }
        });
    }

    private void abrirListaBackup() {
        Backup bk = new Backup();
        try {
            bk.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarcampos() throws IOException {

        autenticar();
    }

    public void configuracao() throws IOException {

        //caminho.setVisible(true);
        //empresa.setVisible(true);
        //salvar.setVisible(true);
        try {
            listaModelEmpresas = controllerEmpresa.getListaEmpresaController();
            for (int i = 0; i < listaModelEmpresas.size(); i++) {
                empresa.setText(listaModelEmpresas.get(i).getRazaoSocial());
            }
            caminho.setText(ModelSessaoUsuario.ipServidor);

        } catch (Exception e) {
            System.err.println("ERRO. -> Empresa não cadastrada!");
        }

    }

    private void principal() throws IOException, Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/principal.fxml"));
        Parent raiz = loader.load();
        novoPrincipal nPrincipal = loader.getController();
        nPrincipal.iniciarBotoes(codUsuario, codEmpresa);
        Stage listaStage = new Stage();
        listaStage.setScene(new Scene(raiz));
        listaStage.setMaximized(true);
        listaStage.initStyle(StageStyle.TRANSPARENT);
        listaStage.show();

        fecha();
    }

    public void fecha() {
        Stage estagio = (Stage) cancelar.getScene().getWindow();
        estagio.close();
        
    }

    public void salvarConfiguracao() {
        try {

            modelConfig.setNomeBanco("dbblvendas");
            modelConfig.setUsuario("root");
            modelConfig.setSenha("");
            modelConfig.setIp("localhost");
            modelConfig.setCaminhoMySQL("C:\\xampp\\mysql\\data\\dbblvendas");
            modelConfig.setQuantidadeMesas(40);
            modelConfig.setImpressoraPDV("");
            modelConfig.setImpressoraCozinha("");
            modelConfig.setImpressoraDelivery("");
            modelConfig.setModeloImprimir(1);
            modelConfig.setQuantidadeImprimir(2);

            modelConfig.setVisualizarNfce(modelConfig.getVisualizarNfce());
            modelConfig.setQuantidadeMesas(modelConfig.getQuantidadeMesas());
            modelConfig.setModeloImprimir(modelConfig.getModeloImprimir());
            modelConfig.setQuantidadeImprimir(modelConfig.getQuantidadeImprimir());

            ManipularXML.gravaXML(modelConfig);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Registro salvo com sucesso!");
            alert.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        caminho.setVisible(false);
        empresa.setVisible(false);
        salvar.setVisible(false);

    }
}
