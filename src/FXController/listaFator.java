/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerFator;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelFator;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaFator extends Application implements Initializable{
    
    @FXML TextField pesquisaFator;
    @FXML Button btPesquisar;
    @FXML Button btAdcionar;
    @FXML Button btSeleciona;
    @FXML private Button btSair;
    @FXML TableView <ModelFator> tabelaListaFator = new TableView();;
    @FXML TableColumn<ModelFator, String> listaFatorCelula;
    ArrayList<ModelFator> listaResultadoFator  = new ArrayList<>();
    public ArrayList<ModelFator> listaTabelaFator ;
    ArrayList<ModelFator> listaModelFator = new ArrayList<>();
    ObservableList<ModelFator> listadeFator;
    
    ControllerFator controllerFator = new ControllerFator();
    
    
    @Override
    public void start(Stage listaFatorStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqFator.fxml")); 
        Parent raiz = loader.load();   
        listaFatorStage.setScene(new Scene(raiz));
        listaFatorStage.initStyle(StageStyle.UNDECORATED);
        listaFatorStage.initModality(Modality.APPLICATION_MODAL);
        listaFatorStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
          listaTodosFatores();
          listaFatorCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisaFator"));       
            tabelaListaFator.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           seleciona();
       }
          });
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodosFatores(){
      listaResultadoFator  = new ArrayList<>();
      listaModelFator = controllerFator.getListaFatorController();
        for (int i = 0; i < listaModelFator.size(); i++) {
             listaResultadoFator.add(listaModelFator.get(i)); 
            }
       
       listadeFator = FXCollections.observableArrayList(listaResultadoFator);
       tabelaListaFator.getItems().addAll(listadeFator);
        
    }
    
    public void pesquisaFator(){
        if (pesquisaFator.getText().equalsIgnoreCase("")){
            tabelaListaFator.getItems().clear();
            listaTodosFatores();
        }else{
        listaResultadoFator.clear();
        int tamanho = listadeFator.size();
       
        for(int i = 0 ; i< tamanho; i++){
        if(listadeFator.get(i).getPesquisaFator().contains(pesquisaFator.getText().toUpperCase())){
            listaResultadoFator.add(listaModelFator.get(i)); 
           
        }
        }
        tabelaListaFator.getItems().clear();
       
        tabelaListaFator.getItems().addAll(listaResultadoFator);
       
        }
    }
    
    public void pesquisaFatorEntrada(String fator){
        btSeleciona.setVisible(true);
        pesquisaFator.setText(fator);
        listaResultadoFator.clear();
        int tamanho = listadeFator.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeFator.get(i).getPesquisaFator().contains(pesquisaFator.getText().toUpperCase())){
            listaResultadoFator.add(listaModelFator.get(i)); 
        }
        }
        tabelaListaFator.getItems().clear();
        tabelaListaFator.getItems().addAll(listaResultadoFator);
    }
    
    public void novoFator(){
        cadastroFator cFator = new cadastroFator();
        try {
            cFator.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
        public void seleciona(){
            String fator = (controllerFator.getFatorController(tabelaListaFator.getSelectionModel().getSelectedItem().getCodigo()).getDescricao());
        classeInterfaces.avisaOuvintesFatorEntrada("entrada", fator);
        sair();
        
    }
   
        
    }
    
    

