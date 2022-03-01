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
import model.ModelTributacaoEstadual;
import controller.ControllerTributacaoEstadual;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaTributacaoEstadual extends Application implements Initializable{
    
    @FXML TextField pesquisaTributacao;
    @FXML Button btPesquisarTributacao;
    @FXML Button btDuplicarTributacao;
    @FXML Button btEditarTributacao;
    @FXML Button btNovoTributacao;
    @FXML Button btSelecionarTributacao;
    @FXML private Button btSair;
    @FXML TableView <ModelTributacaoEstadual> tabelaListaTributacao = new TableView();;
    @FXML TableColumn<ModelTributacaoEstadual, String> listaTributacaoCelula;
    ArrayList<ModelTributacaoEstadual> listaResultadoTributacao  = new ArrayList<>();
    ArrayList<ModelTributacaoEstadual> listaTabelaTributacao ;
    ArrayList<ModelTributacaoEstadual> listaModelTributacao = new ArrayList<>();
    ObservableList<ModelTributacaoEstadual> listadetributacao;
    
    ControllerTributacaoEstadual controllerTributacao = new ControllerTributacaoEstadual();
    
    int origem;
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqTribEstaduais.fxml")); 
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
           
            listaTodasTributacoes();
            listaTributacaoCelula.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));        
    }
    
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodasTributacoes(){
      listaResultadoTributacao  = new ArrayList<>();
      listaModelTributacao = controllerTributacao.getListaTributacaoEstadualController();
            for (int i = 0; i < listaModelTributacao.size(); i++) {
            listaResultadoTributacao.add(listaModelTributacao.get(i));
              
             }
       listadetributacao = FXCollections.observableArrayList(listaResultadoTributacao);
       tabelaListaTributacao.getItems().addAll(listadetributacao);
       
        
    }
    
    public void pesquisaTributacoes(){
        listaResultadoTributacao.clear();
        int tamanho = listaResultadoTributacao.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadetributacao.get(i).getDescricao().contains(pesquisaTributacao.getText().toUpperCase())){
            listaResultadoTributacao.add(listaModelTributacao.get(i)); 
        }
        }
        tabelaListaTributacao.getItems().clear();
        tabelaListaTributacao.getItems().addAll(listaResultadoTributacao);
      
        }
    
    public void novaTributacaoEstadual(){
        tributacaoEstadual tEstadual = new tributacaoEstadual();
        try {
            tEstadual.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
 
     public void fecharLista(){
          Stage estagiosaida = (Stage) btPesquisarTributacao.getScene().getWindow();
          estagiosaida.close();
        
                }
   
    }
    
    

