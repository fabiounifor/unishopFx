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
import model.ModelIpi;
import controller.ControllerModeloIpi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaIPI extends Application implements Initializable{
    
    @FXML TextField pesquisaModeloIpi;
    @FXML Button btPesquisarModeloIpi;
    @FXML Button btDuplicarModeloIpi;
    @FXML Button btEditarModeloIpi;
    @FXML Button btNovoModeloIpi;
    @FXML private Button btSair;
    @FXML TableView <ModelIpi> tabelaListaModeloIpi = new TableView();;
    @FXML TableColumn<ModelIpi, String> listaIpi;
    ArrayList<ModelIpi> listaResultadoIpi  = new ArrayList<>();
    ArrayList<ModelIpi> listaTabelaIpi ;
    ArrayList<ModelIpi> listaModelIpi = new ArrayList<>();
    ObservableList<ModelIpi> listadeIpi;
    
    ControllerModeloIpi controllerModeloIpi = new ControllerModeloIpi();
    
    int origem;
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqModeloIpi.fxml")); 
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
           
          listaTodosIpi();
          listaIpi.setCellValueFactory(new PropertyValueFactory<>("descricao"));        
    }
    
         
public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodosIpi(){
      listaResultadoIpi  = new ArrayList<>();
      listaModelIpi = controllerModeloIpi.getListaIPIController();
            for (int i = 0; i < listaModelIpi.size(); i++) {
            listaResultadoIpi.add(listaModelIpi.get(i));
              
             }
       listadeIpi = FXCollections.observableArrayList(listaResultadoIpi);
       tabelaListaModeloIpi.getItems().addAll(listadeIpi);
       
        
    }
    
    public void pesquisaTributacoes(){
        listaResultadoIpi.clear();
        int tamanho = listaResultadoIpi.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeIpi.get(i).getDescricao().contains(pesquisaModeloIpi.getText().toUpperCase())){
            listaResultadoIpi.add(listaModelIpi.get(i)); 
        }
        }
        tabelaListaModeloIpi.getItems().clear();
        tabelaListaModeloIpi.getItems().addAll(listaResultadoIpi);
      
        }
    
    public void novaModeloIpi(){
        modeloIpi mIpi = new modeloIpi();
        try {
            mIpi.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
 
     public void fecharLista(){
          Stage estagiosaida = (Stage) btPesquisarModeloIpi.getScene().getWindow();
          estagiosaida.close();
        
                }
  
        
    }
    
    

