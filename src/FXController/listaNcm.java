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
import controller.ControllerNCM;
import interfaces.classeInterfaces;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelNCM;

/**
 *
 * @author Fabio
 */
public class listaNcm extends Application implements Initializable{
    
    @FXML TextField tfPesquisaNcm;
    @FXML Button btPesquisar;
    @FXML Button btSelecionarNcm;
    @FXML private Button btSair;
    @FXML TableView <ModelNCM> tabelaListaNCM = new TableView();;
    @FXML TableColumn<ModelNCM, String> listaNCMCelula;
    ArrayList<ModelNCM> listaResultadoNCM  = new ArrayList<>();
    public ArrayList<ModelNCM> listaTabelaNCM ;
    ArrayList<ModelNCM> listaModelNCMs = new ArrayList<>();
    ObservableList<ModelNCM> listadeNCMs;
    
    ControllerNCM controllerNCMs = new ControllerNCM();
    
    
    @Override
    public void start(Stage listaNCMStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqNcm.fxml")); 
        Parent Ncmraiz = loader.load();   
        listaNCMStage.setScene(new Scene(Ncmraiz));
        listaNCMStage.initStyle(StageStyle.UNDECORATED);
        listaNCMStage.initModality(Modality.APPLICATION_MODAL);
        listaNCMStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            listaTodasNCMs();
            listaNCMCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisaNcm"));        
            tfPesquisaNcm.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode()== KeyCode.ENTER){
                   listarNcm();
           }
       });
            tabelaListaNCM.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode()== KeyCode.ENTER){
                   selecionarNcm();
           }
       });
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listarNcm(){
        if (tfPesquisaNcm.getText().equalsIgnoreCase("")){
            listaTodasNCMs();
        }else{
            pesquisaNCM();
        }
    }
    
    public void listaTodasNCMs(){
      listaResultadoNCM  = new ArrayList<>();
      listaModelNCMs = controllerNCMs.getListaNCMController();
        for (int i = 0; i < listaModelNCMs.size(); i++) {
             listaResultadoNCM.add(listaModelNCMs.get(i)); 
             }
       listadeNCMs = FXCollections.observableArrayList(listaResultadoNCM);
       tabelaListaNCM.getItems().addAll(listadeNCMs);
       
        
    }
    
    public void pesquisaNCM(){
        listaResultadoNCM.clear();
        int tamanho = listadeNCMs.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeNCMs.get(i).getPesquisaNcm().contains(tfPesquisaNcm.getText().toUpperCase())){
            listaResultadoNCM.add(listaModelNCMs.get(i)); 
        }
        }
        tabelaListaNCM.getItems().clear();
        tabelaListaNCM.getItems().addAll(listaResultadoNCM);
        }
    
    public void selecionarNcm(){
        String Ncm = (controllerNCMs.getNCMController(tabelaListaNCM.getSelectionModel().getSelectedItem().getCodigo()).getNcm());
        classeInterfaces.avisaOuvintesNcm("CadastroProdutos", Ncm);
        sair();
    }
    
        
    }
    
    

