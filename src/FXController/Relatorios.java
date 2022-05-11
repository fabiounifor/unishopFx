/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package FXController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelGrupo;
import controller.ControllerGRUPO;
import interfaces.classeInterfaces;
import java.sql.Date;
import java.time.LocalDate;
import relatorios.DAORelatorios;

/**
 *
 * @author Fabio
 */
public class Relatorios extends Application implements Initializable{
    
    @FXML  private Button btSair;
    @FXML  private SplitMenuButton SmProdutos;
    @FXML  private MenuItem MiProdutos;
    @FXML  private MenuItem MiProdutosEstoque;
    @FXML  private MenuItem MiProdutosGrupo;
    @FXML  private SplitMenuButton SmPessoas;
    @FXML  private MenuItem MiClientes;
    @FXML  private MenuItem MiClientesRanking;
    @FXML  private SplitMenuButton SmEntradas;
    @FXML  private MenuItem MiEntradas;
    @FXML  private MenuItem MiEntradasFornecedor;
    @FXML  private SplitMenuButton SmSaidas;
    @FXML private Pane pnProdutosGrupo;
    @FXML  private DatePicker dpInicio;
    @FXML  private DatePicker dpFim;
    @FXML  private ChoiceBox<String> cbGrupo;
    @FXML  private Button btGerar;
    
    @Override
    public void start(Stage RelatorioStage) throws IOException {
       FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/relatorios.fxml"));
        Parent raiz = loader.load();
        RelatorioStage.setScene(new Scene(raiz));
        RelatorioStage.initModality(Modality.APPLICATION_MODAL);
        RelatorioStage.initStyle(StageStyle.TRANSPARENT);
        RelatorioStage.show();
    }
    public void sair() {
        Stage estagioSaida = (Stage) btSair.getScene().getWindow();
        estagioSaida.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    public void produtoPorGrupo(){
        pnProdutosGrupo.setVisible(true);
        cbGrupo.getItems().addAll(CriarlistaGrupos());
        
    }
    private ArrayList<String> CriarlistaGrupos(){
       ControllerGRUPO controllerGrupo = new ControllerGRUPO();
       ArrayList<ModelGrupo> grupos = controllerGrupo.getListaGRUPOController();
       ArrayList<String> gruposString = new ArrayList<>();
       grupos.stream()
               .forEach(e -> gruposString.add(e.getGrupo()));
       return gruposString; 
    }
    
    public void gerarRealtorioPorGrupo(){
        Date dataInicial;
        Date dataFinal;
        dataInicial = Date.valueOf(dpInicio.getValue());
        dataFinal = Date.valueOf(dpFim.getValue());
        DAORelatorios relatorios = new DAORelatorios();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
                 
                 @Override
            public void run() {
                // gerar arquivos
                relatorios.gerarRelatorioVendaProdutosPdvTodosCliente(dataInicial, dataFinal, cbGrupo.getSelectionModel().getSelectedIndex());
                classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
            }
        };
        t.start();
        
    }
    
}
