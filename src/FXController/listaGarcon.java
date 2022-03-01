/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ModelGarcom;
import relatorios.DAORelatorios;
import controller.ControllerVendas;
import controller.ControllerGarcom;
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;
import util.ManipularXML;

/**
 *
 * @author Fabio
 */
public class listaGarcon extends Application implements Initializable{
    
    @FXML TextField pesquisaGarcon;
    @FXML Button pesquisarGarcon;
    @FXML Button btDuplicarGarcon;
    @FXML Button btEditarGarcon;
    @FXML Button btNovoGarcon;
    @FXML Button btComissao;
    @FXML private Button btSair;
    
    @FXML TableView <ModelGarcom> tabelaListaGarcon = new TableView();;
    @FXML TableColumn<ModelGarcom, String> listaGarcon;
    
     ArrayList<ModelGarcom> listaResultadoGarcon  = new ArrayList<>();
    public ArrayList<ModelGarcom> listaTabelaGarcon ;
    ArrayList<ModelGarcom> listaModelGarcon = new ArrayList<>();
    ObservableList<ModelGarcom> listadeGarcon;
    
    
    
    ControllerGarcom controllerGarcom = new ControllerGarcom();
    ControllerVendas controllerVendas = new ControllerVendas();
    DAORelatorios daoRelatorios = new DAORelatorios();
    BLMascaras bLMascaras = new BLMascaras();
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqGarcon.fxml")); 
        Parent raiz = loader.load();   
        listaUnidadeStage.setScene(new Scene(raiz));
        listaUnidadeStage.initStyle(StageStyle.UNDECORATED);
        listaUnidadeStage.initModality(Modality.APPLICATION_MODAL);
        listaUnidadeStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
            listaTodosGarcons();
            listaGarcon.setCellValueFactory(new PropertyValueFactory<>("pesquisaGarcon"));        
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodosGarcons(){
      listaResultadoGarcon  = new ArrayList<>();
      
      listaModelGarcon = controllerGarcom.getListaGarcomController();
        for (int i = 0; i < listaModelGarcon.size(); i++) {
            listaResultadoGarcon.add(listaModelGarcon.get(i));
             }
       listadeGarcon = FXCollections.observableArrayList(listaResultadoGarcon);
       tabelaListaGarcon.getItems().addAll(listadeGarcon);
      
    }
    
    public void pesquisaGarcon(){
        
        listaResultadoGarcon.clear();
        int tamanho = listadeGarcon.size();
        for(int i = 0 ; i< tamanho; i++){
            ModelGarcom mg = new ModelGarcom();
        if(listadeGarcon.get(i).getNome().contains(pesquisaGarcon.getText().toUpperCase())){
            mg.setNome(listadeGarcon.get(i).getPesquisaGarcon());
           listaResultadoGarcon.add(mg);
        }
        }
        tabelaListaGarcon.getItems().clear();
       
        tabelaListaGarcon.getItems().addAll(listaResultadoGarcon);
        
       
        }
    
     public void novoGarcon(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroGarcon.fxml"));
        Parent novaGarcon = (Parent) loader.load();
        cadastroGarcon nGarcon = loader.getController();
        nGarcon.novoGarcon();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(novaGarcon));
        stage.show();
        
    }
     public void duplicarGarcon(ActionEvent event) throws IOException{
        int codigo;
        codigo  = tabelaListaGarcon.getSelectionModel().getSelectedItem().getCodigo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroGarcon.fxml"));
        Parent novoGarcon = (Parent) loader.load();
        cadastroGarcon nGarcon = loader.getController();
        nGarcon.DuplicarGarcon(codigo);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(novoGarcon));
        stage.show();
        
    }
     
     public void alterarGarcon(ActionEvent event) throws IOException{
        int codigo;
        codigo  = tabelaListaGarcon.getSelectionModel().getSelectedItem().getCodigo();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroGarcon.fxml"));
        Parent novoGarcon = (Parent) loader.load();
        cadastroGarcon nGarcon = loader.getController();
        nGarcon.AlterarGarcon(codigo);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(novoGarcon));
        stage.show();
        
    }
     
     public void excluirGarcon(){
         int codigo;
         codigo  = tabelaListaGarcon.getSelectionModel().getSelectedItem().getCodigo();
         String nome = controllerGarcom.getGarcomController(codigo).getNome();
         Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("EXCLUIR GARCON?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA REALMENTE EXCLUIR O CADASTRO " + nome+" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                    if (controllerGarcom.excluirGarcomController(codigo) == true){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Informação");
                                alert.setContentText("O CADASTRO " + nome + " FOI EXCUIDO COM SUCESSO");
                                alert.show(); 
                         
                    }else{
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Informação");
                                alert.setContentText("O CADASTRO " + controllerGarcom.getGarcomController(codigo).getNome() + " NÃO PODE SER EXCLUIDO");
                                alert.show(); 
                    }
                    }
                           });
         
     }
     
     public void comissaoGarcon() throws Exception{
         int codigo  = tabelaListaGarcon.getSelectionModel().getSelectedItem().getCodigo();
         String nome = controllerGarcom.getGarcomController(codigo).getNome();
         Date dataLimite = (new java.sql.Date(System.currentTimeMillis()));
         
         
         final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                try{
                // imprimir vendas
                System.out.println(dataLimite);
                System.out.println(codigo);
                daoRelatorios.gerarRelatorioVendaTodosClienteGarcon(dataLimite,dataLimite,codigo);
                //daoRelatorios.gerarRelatorioVendaTodosCliente(dataLimite, dataLimite2);
                }catch(Exception e)
                        { System.out.println(e);
                    
                }
                
                carregando.dispose();
            }
       };
        t.start();
                }
       
            
    }
    
    

