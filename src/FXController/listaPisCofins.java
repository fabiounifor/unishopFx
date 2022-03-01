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
import model.ModelPisCofins;
import controller.ControllerModeloPisCofins;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaPisCofins extends Application implements Initializable{
    
    @FXML TextField pesquisaModeloPisCofins;
    @FXML Button btPesquisarModeloPisCofins;
    @FXML Button btDuplicarModeloPisCofins;
    @FXML Button btEditarModeloPisCofins;
    @FXML Button btNovoModeloIPisCofins;
    @FXML private Button btSair;
    @FXML TableView <ModelPisCofins> tabelaListaModeloPisCofins = new TableView();;
    @FXML TableColumn<ModelPisCofins, String> listaPisCofins;
    ArrayList<ModelPisCofins> listaResultadoPisCofins  = new ArrayList<>();
    ArrayList<ModelPisCofins> listaTabelaPisCofins ;
    ArrayList<ModelPisCofins> listaModelPisCofins = new ArrayList<>();
    ObservableList<ModelPisCofins> listadePisCofins;
    
    ControllerModeloPisCofins controllerModeloPisCofins = new ControllerModeloPisCofins();
    
    int origem;
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqModeloPisCofins.fxml")); 
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
           
            listaTodosPisCofins();
            listaPisCofins.setCellValueFactory(new PropertyValueFactory<>("descricao"));        
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodosPisCofins(){
      listaResultadoPisCofins  = new ArrayList<>();
      listaModelPisCofins = controllerModeloPisCofins.getListaPiscofinsController();
            for (int i = 0; i < listaModelPisCofins.size(); i++) {
            listaResultadoPisCofins.add(listaModelPisCofins.get(i));
              
             }
       listadePisCofins = FXCollections.observableArrayList(listaResultadoPisCofins);
       tabelaListaModeloPisCofins.getItems().addAll(listadePisCofins);
       
        
    }
    
    public void pesquisaTributacoes(){
        listaResultadoPisCofins.clear();
        int tamanho = listaResultadoPisCofins.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadePisCofins.get(i).getDescricao().contains(pesquisaModeloPisCofins.getText().toUpperCase())){
            listaResultadoPisCofins.add(listaModelPisCofins.get(i)); 
        }
        }
        tabelaListaModeloPisCofins.getItems().clear();
        tabelaListaModeloPisCofins.getItems().addAll(listaResultadoPisCofins);
      
        }
    
    public void novoModeloPisCofins(){
        modeloPisCofins mPisCofins = new modeloPisCofins();
        try {
            mPisCofins.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
 
     public void fecharLista(){
          Stage estagiosaida = (Stage) btPesquisarModeloPisCofins.getScene().getWindow();
          estagiosaida.close();
        
                }
  
        
    }
    
    

