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
import controller.ControllerMotorista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelMotorista;

/**
 *
 * @author Fabio
 */
public class listaMotorista extends Application implements Initializable{
    
    @FXML TextField pesquisaMotorista;
    @FXML Button btPesquisar;
    @FXML Button btDuplicar;
    @FXML Button btEditar;
    @FXML Button btAdcionar;
    @FXML private Button btSair;
    @FXML TableView <ModelMotorista> tabelaListaMotorista = new TableView();;
    @FXML TableColumn<ModelMotorista, String> listaMotoristaCelula;
    ArrayList<ModelMotorista> listaResultadoMotorista  = new ArrayList<>();
    public ArrayList<ModelMotorista> listaTabelaMotorista ;
    ArrayList<ModelMotorista> listaModelMotoristas = new ArrayList<>();
    ObservableList<ModelMotorista> listadeMotoristas;
    
    ControllerMotorista controllerMotoristas = new ControllerMotorista();
    
    
    @Override
    public void start(Stage listaMotoristaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqMotorista.fxml")); 
        Parent raiz = loader.load();   
        listaMotoristaStage.setScene(new Scene(raiz));
        listaMotoristaStage.initStyle(StageStyle.UNDECORATED);
        listaMotoristaStage.initModality(Modality.APPLICATION_MODAL);
        listaMotoristaStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
            listaTodasMotoristas();
            listaMotoristaCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisaMotorista"));        
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodasMotoristas(){
      listaResultadoMotorista  = new ArrayList<>();
      listaModelMotoristas = controllerMotoristas.getListaMotoristaController();
        for (int i = 0; i < listaModelMotoristas.size(); i++) {
             listaResultadoMotorista.add(listaModelMotoristas.get(i)); 
             }
       listadeMotoristas = FXCollections.observableArrayList(listaResultadoMotorista);
       tabelaListaMotorista.getItems().addAll(listadeMotoristas);
       
        
    }
    
    public void pesquisaMotorista(){
        listaResultadoMotorista.clear();
        int tamanho = listadeMotoristas.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeMotoristas.get(i).getPesquisaMotorista().contains(pesquisaMotorista.getText().toUpperCase())){
            listaResultadoMotorista.add(listaModelMotoristas.get(i)); 
           
        }
        }
        tabelaListaMotorista.getItems().clear();
       
        tabelaListaMotorista.getItems().addAll(listaResultadoMotorista);
        
       
        }
    
    
        
    }
    
    

