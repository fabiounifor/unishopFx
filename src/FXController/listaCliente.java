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
import model.ModelCliente;
import controller.ControllerCliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import unishop.Unishop;
import interfaces.classeInterfaces;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 *
 * @author Fabio
 */
public class listaCliente extends Application implements Initializable{
    
    @FXML TextField pesquisaCliente;
    @FXML Button btPesquisarCliente;
    @FXML Button btAdcionarPessoaJuridica;
    @FXML Button btEditarCliente;
    @FXML Button btAdcionarPessoaFisica;
    @FXML TableView <ModelCliente> tabelaListaClientes = new TableView();;
    @FXML TableColumn<ModelCliente, String> linhaClientes;
    @FXML TableColumn<ModelCliente,Hyperlink> linkTabelaEditar;
    @FXML TableColumn<ModelCliente,Hyperlink> linkTabelaSelecionar;
    @FXML private Button btSair;
    ArrayList<ModelCliente> listaResultado  = new ArrayList<>();
    public ArrayList<ModelCliente> listaTabelaClientes ;
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
    ObservableList<ModelCliente> listadeClientes; 
   Hyperlink linkEditar = new Hyperlink("Editar F6");
    Hyperlink linkSelecionar = new Hyperlink("Selecionar ENTER");
    
    ControllerCliente controllerCliente = new ControllerCliente();
    
    @Override
    public void start(Stage listaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqCliente.fxml")); 
        Parent raiz = loader.load();   
        listaStage.setScene(new Scene(raiz));
        listaStage.setTitle("PESQUISA CLIENTES");
        listaStage.setMaximized(false);
        listaStage.initStyle(StageStyle.UNDECORATED);
        listaStage.initModality(Modality.APPLICATION_MODAL);
        listaStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       linhaClientes.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));   
       linkTabelaEditar.setCellValueFactory(new PropertyValueFactory<>("linkModelEditar"));  
       linkTabelaSelecionar.setCellValueFactory(new PropertyValueFactory<>("linkModelSelecionar"));  
       pesquisaCliente.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent e) {
               if(e.getCode()== KeyCode.DOWN){
                   irPraTabela();
               }
               if(e.getCode()== KeyCode.F4){
                   ActionEvent evento = null;
                   try {
                       novoPessoaFisica(evento);
                   } catch (IOException ex) {
                       Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(e.getCode()== KeyCode.F3){
                   ActionEvent evento = null;
                   try {
                       pessoaFornecedor();
                   } catch (IOException ex) {
                       Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
        
               if(e.getCode()== KeyCode.F5){     
                   try {
                       pessoaJuridica();
                   } catch (IOException ex) {
                       Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(e.getCode()== KeyCode.ESCAPE){
           sair();
       }
           }
       });
       tabelaListaClientes.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           seleciona();
       }
       if(e.getCode()== KeyCode.ESCAPE){
           sair();
       }
       if(e.getCode()== KeyCode.F6){
           ActionEvent evento = null;
           try {
               alteraCliente(evento);
           } catch (IOException ex) {
             Logger.getLogger(listaCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       });
              
       btPesquisarCliente.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           listaTodos();
       }
       if(e.getCode()== KeyCode.ESCAPE){
           sair();
       }
       });
       linkEditar.setOnMouseClicked((MouseEvent e)->{
                    ActionEvent evento = null;
                    try {
                    alteraCliente(evento);
                    } catch (IOException ex) {
                       Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
             });
    linkSelecionar.setOnMouseClicked((MouseEvent e)->{
                        seleciona();
             });
       listaTodos();            
    }
    
    public void insereLinks(){
        ModelCliente modelClientes = new ModelCliente();
        // buscar codigo do item
        int linha = (tabelaListaClientes.getSelectionModel().getSelectedIndex());
        int codigo = tabelaListaClientes.getItems().get(linha).getCodigo();
        
        // colocar link no cadastro selecionado
        modelClientes = controllerCliente.getClienteControllerCod(codigo);
        modelClientes.setLinkModelEditar(linkEditar);
        modelClientes.setLinkModelSelecionar(linkSelecionar);

        // colocar cadastro alterado na linha escolhida
        tabelaListaClientes.getItems().remove(linha);
        tabelaListaClientes.getItems().add(linha, modelClientes);
        tabelaListaClientes.getSelectionModel().select(linha);
        
        //limpar links linha anterior
        if (linha > 0){
        int linhaLimparAntes = (tabelaListaClientes.getSelectionModel().getSelectedIndex()-1);
        int codigoLimparAntes = tabelaListaClientes.getItems().get(linhaLimparAntes).getCodigo();
        modelClientes = controllerCliente.getClienteControllerCod(codigoLimparAntes);
        tabelaListaClientes.getItems().remove(linhaLimparAntes);
        tabelaListaClientes.getItems().add(linhaLimparAntes, modelClientes);
        }
        
        //limpar links linha posterior
        if (linha < (tabelaListaClientes.getItems().size())){
            if ((linha + 1) != (tabelaListaClientes.getItems().size())){
        int linhaLimparDepois = (tabelaListaClientes.getSelectionModel().getSelectedIndex()+1);
        int codigoLimparDepois = tabelaListaClientes.getItems().get(linhaLimparDepois).getCodigo();
        modelClientes = controllerCliente.getClienteControllerCod(codigoLimparDepois);
        tabelaListaClientes.getItems().remove(linhaLimparDepois);
        tabelaListaClientes.getItems().add(linhaLimparDepois, modelClientes);
        }
        }
    }
    
    public void irPraTabela()  {
        tabelaListaClientes.setFocusTraversable(true);
        tabelaListaClientes.requestFocus();
        tabelaListaClientes.getSelectionModel().select(0);
    }
    
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaTodos(){
      listaResultado.clear();
      tabelaListaClientes.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelClientes = controllerCliente.getListaClienteAtivoController();
      for (int i = 0; i < listaModelClientes.size(); i++) {
             listaResultado.add(listaModelClientes.get(i)); 
            }
       listadeClientes = FXCollections.observableArrayList(listaResultado);
       tabelaListaClientes.getItems().addAll(listadeClientes);
        
    }
    
    public void pesquisaCliente(){
        listaResultado.clear();
        int tamanho = listadeClientes.size();
       
        for(int i = 0 ; i< tamanho; i++){
        if(listadeClientes.get(i).getPesquisa().contains(pesquisaCliente.getText().toUpperCase())){
            listaResultado.add(listaModelClientes.get(i)); 
           
        }
        }
        tabelaListaClientes.getItems().clear();
       
        tabelaListaClientes.getItems().addAll(listaResultado);
       
        }
    
   
    public void pessoaJuridica() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqCnpj.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        consultaCnpj nConsulta = loader.getController();
        nConsulta.tipo = "j";
        Stage stage = new Stage();
        stage.setScene(new Scene(novaRaiz));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        sair();
    }
    public void pessoaFornecedor() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqCnpj.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        consultaCnpj nConsulta = loader.getController();
        nConsulta.tipo = "for";
        Stage stage = new Stage();
        stage.setScene(new Scene(novaRaiz));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        sair();
        
    }
    
    public void novoPessoaFisica(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroPJuridica.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        FXViewCliente nCliente = loader.getController();
        nCliente.iniciarPessoaFisica();
        Stage stage = new Stage();
        stage.setScene(new Scene(novaRaiz));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        sair();
    }
    
    
    public void alteraCliente(ActionEvent event) throws IOException{
        
        int cod = (controllerCliente.getClienteControllerCod(tabelaListaClientes.getSelectionModel().getSelectedItem().getCodigo()).getCodigo());
               
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroPJuridica.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        FXViewCliente nCliente = loader.getController();
        nCliente.AlterarCliente(cod);
        Stage stage = new Stage();
        stage.setScene(new Scene(novaRaiz));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        sair();
    }
    public void seleciona() {
        String cliente = (controllerCliente.getClienteControllerCod(tabelaListaClientes.getSelectionModel().getSelectedItem().getCodigo()).getNome());
        classeInterfaces.avisaOuvintes("venda", cliente);
        
        sair();
        
    }
    
    
        
    }
    
    

