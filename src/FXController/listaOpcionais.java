/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerOpcoes;
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
import model.ModelOpcionais;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaOpcionais extends Application implements Initializable{
    
    @FXML TextField tfpesquisaOpcionais;
    @FXML Button btPesquisar;
    @FXML Button btAdcionar;
    @FXML Button btSeleciona;
    @FXML private Button btSair;
    @FXML TableView <ModelOpcionais> tabelaListaOpcionais = new TableView();;
    @FXML TableColumn<ModelOpcionais, String> listaOpcionaisCelula;
    ArrayList<ModelOpcionais> listaResultadoOpcionais  = new ArrayList<>();
    public ArrayList<ModelOpcionais> listaTabelaOpcionais ;
    ArrayList<ModelOpcionais> listaModelOpcionais = new ArrayList<>();
    ObservableList<ModelOpcionais> listadeOpcionais;
    
    ControllerOpcoes controllerOpcoes = new ControllerOpcoes();
    
    
    @Override
    public void start(Stage listaFatorStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqOpcionais.fxml")); 
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
           
          listaTodosOpcionais();
          listaOpcionaisCelula.setCellValueFactory(new PropertyValueFactory<>("descricao"));       
          tabelaListaOpcionais.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           seleciona();
       }
          });
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodosOpcionais(){
      listaResultadoOpcionais  = new ArrayList<>();
      listaModelOpcionais = controllerOpcoes.getListaOpcoesController();
        for (int i = 0; i < listaModelOpcionais.size(); i++) {
             listaResultadoOpcionais.add(listaModelOpcionais.get(i)); 
            }
       
       listadeOpcionais = FXCollections.observableArrayList(listaResultadoOpcionais);
       tabelaListaOpcionais.getItems().addAll(listadeOpcionais);
        
    }
    
    public void pesquisaOpcionais(){
        if (tfpesquisaOpcionais.getText().equalsIgnoreCase("")){
            tabelaListaOpcionais.getItems().clear();
            listaTodosOpcionais();
        }else{
        listaResultadoOpcionais.clear();
        int tamanho = listadeOpcionais.size();
       
        for(int i = 0 ; i< tamanho; i++){
        if(listadeOpcionais.get(i).getDescricao().contains(tfpesquisaOpcionais.getText().toUpperCase())){
            listaResultadoOpcionais.add(listaModelOpcionais.get(i)); 
           
        }
        }
        tabelaListaOpcionais.getItems().clear();
       
        tabelaListaOpcionais.getItems().addAll(listaResultadoOpcionais);
       
        }
    }
        
    public void novoOpcao(){
        cadastroOpcionais cOpcao = new cadastroOpcionais();
        try {
            cOpcao.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public void editarOpcao() throws IOException{
        int posicao = tabelaListaOpcionais.selectionModelProperty().getValue().getSelectedIndex();
        int codigo = tabelaListaOpcionais.getItems().get(posicao).getCodigo();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroOpcionais.fxml")); 
        Parent raiz = loader.load();   
        cadastroOpcionais cOpcionais = loader.getController();
        cOpcionais.alterarOpcional(codigo);
        cOpcionais.origem = ("alterar");
        Stage opStage = new Stage();
        opStage.setScene(new Scene(raiz));
        opStage.initStyle(StageStyle.UNDECORATED);
        opStage.initModality(Modality.APPLICATION_MODAL);
        opStage.show();
    }
    
        public void seleciona(){
            String opcao = (controllerOpcoes.getOpcoesController(tabelaListaOpcionais.getSelectionModel().getSelectedItem().getCodigo()).getDescricao());
        classeInterfaces.avisaOuvintesFatorEntrada("entrada", opcao);
        sair();
        
    }
   
        
    }
    
    

