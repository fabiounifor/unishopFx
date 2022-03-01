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
import controller.ControllerBairro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelBairro;

/**
 *
 * @author Fabio
 */
public class listaBairro extends Application implements Initializable{
    
    @FXML TextField pesquisaBairro;
    @FXML Button btPesquisar;
    @FXML Button btDuplicar;
    @FXML Button btEditar;
    @FXML Button btAdcionar;
    @FXML private Button btSair;
    @FXML TableView <ModelBairro> tabelaListaBairro = new TableView();;
    @FXML TableColumn<ModelBairro, String> listaBairroCelula;
    ArrayList<ModelBairro> listaResultadoBairro  = new ArrayList<>();
    public ArrayList<ModelBairro> listaTabelaBairro ;
    ArrayList<ModelBairro> listaModelBairros = new ArrayList<>();
    ObservableList<ModelBairro> listadeBairros;
    
    ControllerBairro controllerBairros = new ControllerBairro();
    
    
    @Override
    public void start(Stage listaBairroStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqBairro.fxml")); 
        Parent raiz = loader.load();   
        listaBairroStage.setScene(new Scene(raiz));
        listaBairroStage.initStyle(StageStyle.UNDECORATED);
        listaBairroStage.initModality(Modality.APPLICATION_MODAL);
        listaBairroStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
            listaTodasBairros();
            listaBairroCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisaBairro"));        
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodasBairros(){
      listaResultadoBairro  = new ArrayList<>();
      listaModelBairros = controllerBairros.getListaBairroController();
        for (int i = 0; i < listaModelBairros.size(); i++) {
             listaResultadoBairro.add(listaModelBairros.get(i)); 
             }
       listadeBairros = FXCollections.observableArrayList(listaResultadoBairro);
       tabelaListaBairro.getItems().addAll(listadeBairros);
       
        
    }
    
    public void pesquisaBairro(){
        listaResultadoBairro.clear();
        int tamanho = listadeBairros.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeBairros.get(i).getPesquisaBairro().contains(pesquisaBairro.getText().toUpperCase())){
            listaResultadoBairro.add(listaModelBairros.get(i)); 
           
        }
        }
        tabelaListaBairro.getItems().clear();
       
        tabelaListaBairro.getItems().addAll(listaResultadoBairro);
        
       
        }
    
    
        
    }
    
    

