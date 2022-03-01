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
import controller.ControllerUnidadeMedia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelUnidadeMedia;

/**
 *
 * @author Fabio
 */
public class listaRomaneio extends Application implements Initializable{
    
    @FXML TextField pesquisaUnidade;
    @FXML Button btPesquisar;
    @FXML Button btDuplicar;
    @FXML Button btEditar;
    @FXML Button btAdcionar;
    @FXML private Button btSair;
    @FXML TableView <ModelUnidadeMedia> tabelaListaUnidade = new TableView();;
    @FXML TableColumn<ModelUnidadeMedia, String> listaUnidadeCelula;
    ArrayList<ModelUnidadeMedia> listaResultadoUnidade  = new ArrayList<>();
    public ArrayList<ModelUnidadeMedia> listaTabelaUnidade ;
    ArrayList<ModelUnidadeMedia> listaModelUnidadeMedias = new ArrayList<>();
    ObservableList<ModelUnidadeMedia> listadeUnidades;
    
    ControllerUnidadeMedia controllerUnidades = new ControllerUnidadeMedia();
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqUnidade.fxml")); 
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
           
            listaTodasUnidades();
            listaUnidadeCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisaUnidade"));        
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodasUnidades(){
      listaResultadoUnidade  = new ArrayList<>();
      listaModelUnidadeMedias = controllerUnidades.getListaUnidadeMediaController();
        for (int i = 0; i < listaModelUnidadeMedias.size(); i++) {
             listaResultadoUnidade.add(listaModelUnidadeMedias.get(i)); 
             }
       listadeUnidades = FXCollections.observableArrayList(listaResultadoUnidade);
       tabelaListaUnidade.getItems().addAll(listadeUnidades);
       
        
    }
    
    public void pesquisaUnidade(){
        listaResultadoUnidade.clear();
        int tamanho = listadeUnidades.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeUnidades.get(i).getPesquisaUnidade().contains(pesquisaUnidade.getText().toUpperCase())){
            listaResultadoUnidade.add(listaModelUnidadeMedias.get(i)); 
           
        }
        }
        tabelaListaUnidade.getItems().clear();
       
        tabelaListaUnidade.getItems().addAll(listaResultadoUnidade);
        
       
        }
    
    
        
    }
    
    

