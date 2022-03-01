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
import model.ModelTributacaoFederal;
import controller.ControllerTributacaoFederal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaTributacaoFederal extends Application implements Initializable{
    
    @FXML TextField pesquisaTribFederal;
    @FXML Button btPesquisarTribFederal;
    @FXML Button btDuplicarTribFederal;
    @FXML Button btEditarTribFederal;
    @FXML Button btNovoTribFederal;
    @FXML Button btSelecionarTributacao;
    @FXML private Button btSair;
    @FXML TableView <ModelTributacaoFederal> tabelaListaTribFederal = new TableView();;
    @FXML TableColumn<ModelTributacaoFederal, String> listaTributos;
    ArrayList<ModelTributacaoFederal> listaResultadoTributacao  = new ArrayList<>();
    ArrayList<ModelTributacaoFederal> listaTabelaTributacao ;
    ArrayList<ModelTributacaoFederal> listaModelTributacao = new ArrayList<>();
    ObservableList<ModelTributacaoFederal> listadetributacao;
    
    ControllerTributacaoFederal controllerTributacao = new ControllerTributacaoFederal();
    
    int origem;
    
    
    @Override
    public void start(Stage listaTributacaoFederal) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqTribFederal.fxml")); 
        Parent raiz = loader.load();   
        listaTributacaoFederal.setScene(new Scene(raiz));
        listaTributacaoFederal.initStyle(StageStyle.UNDECORATED);
        listaTributacaoFederal.initModality(Modality.APPLICATION_MODAL);
        listaTributacaoFederal.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
            listaTodasTributacoes();
            listaTributos.setCellValueFactory(new PropertyValueFactory<>("descricao"));        
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodasTributacoes(){
      listaResultadoTributacao  = new ArrayList<>();
      listaModelTributacao = controllerTributacao.getListaTributacaoFederalController();
      System.out.println(listaModelTributacao.size()+ "    tamanho da lista");
      for (int i = 0; i < listaModelTributacao.size(); i++) {
            listaResultadoTributacao.add(listaModelTributacao.get(i));
              
             }
       listadetributacao = FXCollections.observableArrayList(listaResultadoTributacao);
       tabelaListaTribFederal.getItems().addAll(listadetributacao);
       
        
    }
    
    public void pesquisaTributacoes(){
        listaResultadoTributacao.clear();
        int tamanho = listaResultadoTributacao.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadetributacao.get(i).getDescricao().contains(pesquisaTribFederal.getText().toUpperCase())){
            listaResultadoTributacao.add(listaModelTributacao.get(i)); 
           
        }
        }
        tabelaListaTribFederal.getItems().clear();
        tabelaListaTribFederal.getItems().addAll(listaResultadoTributacao);
        
       
        }
    
    public void novaTributacaoFederal(){
        tributacaoFederal tFederal = new tributacaoFederal();
        try {
            tFederal.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

     public void fecharLista(){
          Stage estagiosaida = (Stage) btPesquisarTribFederal.getScene().getWindow();
          estagiosaida.close();
        
                }
    
    
        
    }
    
    

