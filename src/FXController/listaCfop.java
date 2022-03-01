/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCFOP;
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
import interfaces.classeInterfaces;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelCFOP;

/**
 *
 * @author Fabio
 */
public class listaCfop extends Application implements Initializable{
    
    @FXML TextField pesquisaCfop;
    @FXML Button btPesquisarCfop;
    @FXML Button btAdcionar;
    @FXML Button btSeleciona;
     @FXML private Button btSair;
    @FXML TableView <ModelCFOP> tabelaListaCfop = new TableView();;
    @FXML TableColumn<ModelCFOP, String> listaCfopCelula;
    ArrayList<ModelCFOP> listaResultadoCfop  = new ArrayList<>();
    public ArrayList<ModelCFOP> listaTabelaCfop ;
    ArrayList<ModelCFOP> listaModelCfop = new ArrayList<>();
    ObservableList<ModelCFOP> listadeCfop;
    
    ControllerCFOP controllerCfop = new ControllerCFOP();
    
    
    @Override
    public void start(Stage listaCfopStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqFator.fxml")); 
        Parent raiz = loader.load();   
        listaCfopStage.setScene(new Scene(raiz));
        listaCfopStage.initStyle(StageStyle.UNDECORATED);
        listaCfopStage.initModality(Modality.APPLICATION_MODAL);
        listaCfopStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
          listaTodosCfop();
          listaCfopCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisaCfop"));       
          tabelaListaCfop.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           seleciona();
       }
          });
    }
    
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodosCfop(){
      listaResultadoCfop  = new ArrayList<>();
      listaModelCfop = controllerCfop.getListaCFOPController();
        for (int i = 0; i < listaModelCfop.size(); i++) {
             listaResultadoCfop.add(listaModelCfop.get(i)); 
            }
       
       listadeCfop = FXCollections.observableArrayList(listaResultadoCfop);
       tabelaListaCfop.getItems().addAll(listadeCfop);
        
    }
    
    public void pesquisaCfop(){
        if (pesquisaCfop.getText().equalsIgnoreCase("")){
            tabelaListaCfop.getItems().clear();
            listaTodosCfop();
        }else{
        listaResultadoCfop.clear();
        int tamanho = listadeCfop.size();
       
        for(int i = 0 ; i< tamanho; i++){
        if(listadeCfop.get(i).getPesquisaCfop().contains(pesquisaCfop.getText().toUpperCase())){
            listaResultadoCfop.add(listaModelCfop.get(i)); 
           
        }
        }
        tabelaListaCfop.getItems().clear();
       
        tabelaListaCfop.getItems().addAll(listaResultadoCfop);
       
        }
    }
    
    public void pesquisaCfopEntrada(String fator){
        btSeleciona.setVisible(true);
        pesquisaCfop.setText(fator);
        listaResultadoCfop.clear();
        int tamanho = listadeCfop.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeCfop.get(i).getPesquisaCfop().contains(pesquisaCfop.getText().toUpperCase())){
            listaResultadoCfop.add(listaModelCfop.get(i)); 
        }
        }
        tabelaListaCfop.getItems().clear();
        tabelaListaCfop.getItems().addAll(listaResultadoCfop);
    }
  
        public void seleciona(){
            String cfop = (String.valueOf(controllerCfop.getCFOPController(tabelaListaCfop.getSelectionModel().getSelectedItem().getCodigo()).getCfop()));
        classeInterfaces.avisaOuvintesCfopEntrada("entrada", cfop);
        
        sairCfop();
        
    }
    public void sairCfop(){
    Stage estagioCfop = (Stage) btPesquisarCfop.getScene().getWindow();
          estagioCfop.close();
    }
        
    }
    
    

