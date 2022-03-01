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
import model.ModelProdutos;
import controller.ControllerProdutos;
import interfaces.classeInterfaces;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class listaProduto extends Application implements Initializable{
    
    @FXML TextField pesquisaProduto;
    @FXML Button btPesquisar;
    @FXML Button btDuplicar;
    @FXML Button btEditar;
    @FXML Button btAdcionar;
    @FXML Button btSelecionar;
    @FXML private Button btSair;
    @FXML TableView <ModelProdutos> tabelaListaProdutos = new TableView();;
    @FXML TableColumn<ModelProdutos, String> listaProdutos;
    @FXML TableColumn<ModelProdutos,Hyperlink> linkTabelaEditar;
    @FXML TableColumn<ModelProdutos,Hyperlink> linkTabelaDuplicar;
    ArrayList<ModelProdutos> listaResultado  = new ArrayList<>();
    public ArrayList<ModelProdutos> listaTabelaProdutos ;
    ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
    ObservableList<ModelProdutos> listadeProdutos;
    Stage raiz;
    Hyperlink linkEditar = new Hyperlink("Editar F6");
    Hyperlink linkDuplicar = new Hyperlink("Duplicar F3");
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelProdutos modelProdutos = new ModelProdutos();
    @Override
    public void start(Stage listaStage) throws IOException {
        raiz  = listaStage;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqProduto.fxml")); 
        Parent raiz = loader.load();   
        listaStage.setScene(new Scene(raiz));
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
            listaProdutos.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));   
            linkTabelaEditar.setCellValueFactory(new PropertyValueFactory<>("linkModelEditar"));  
            linkTabelaDuplicar.setCellValueFactory(new PropertyValueFactory<>("linkModelDuplicar"));  
            tabelaListaProdutos.setOnKeyPressed((KeyEvent e)->{
                if(e.getCode() == KeyCode.ESCAPE){
                    sair();
                }
                if(e.getCode() == KeyCode.ENTER){
                    selecionarProduto();
                }
                if(e.getCode() == KeyCode.F3){
                    ActionEvent event = null;
                    try {
                        duplicaProduto(event);
                    } catch (IOException ex) {
                        Logger.getLogger(listaProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(e.getCode() == KeyCode.F6){
                    ActionEvent event = null;
                    try {
                        alteraProduto(event);
                    } catch (IOException ex) {
                        Logger.getLogger(listaProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            pesquisaProduto.setOnKeyPressed((KeyEvent e)->{
                if(e.getCode()== KeyCode.DOWN){
                   irPraTabela();
               }
            });
            btPesquisar.setOnKeyPressed((KeyEvent e)->{
                if(e.getCode() == KeyCode.ESCAPE){
                    sair();
                }
                if(e.getCode() == KeyCode.ENTER){
                    pesquisaProduto();
                }
            });
            btSelecionar.setOnKeyPressed((KeyEvent e)->{
                if(e.getCode() == KeyCode.ENTER){
                    selecionarProduto();
                }
            });
            
    linkEditar.setOnMouseClicked((MouseEvent e)->{
                    ActionEvent evento = null;
                    try {
                    alteraProduto(evento);
                    } catch (IOException ex) {
                       Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
             });
    linkDuplicar.setOnMouseClicked((MouseEvent e)->{
                    ActionEvent evento = null;
                    try {
                        duplicaProduto(evento);
                    } catch (IOException ex) {
                       Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                    }
             });
            listaTodos();
    }
    
    public void irPraTabela()  {
        tabelaListaProdutos.setFocusTraversable(true);
        tabelaListaProdutos.requestFocus();
        tabelaListaProdutos.getSelectionModel().select(0);
    }
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void insereLinks(){
        
        // buscar codigo do item
        int linha = (tabelaListaProdutos.getSelectionModel().getSelectedIndex());
        int codigo = tabelaListaProdutos.getItems().get(linha).getCodigo();
        
        // colocar link no cadastro selecionado
        modelProdutos = controllerProdutos.getProdutosController(codigo);
        modelProdutos.setLinkModelEditar(linkEditar);
        modelProdutos.setLinkModelDuplicar(linkDuplicar);

        // colocar cadastro alterado na linha escolhida
        tabelaListaProdutos.getItems().remove(linha);
        tabelaListaProdutos.getItems().add(linha, modelProdutos);
        tabelaListaProdutos.getSelectionModel().select(linha);
        
        //limpar links linha anterior
        if (linha > 0){
        int linhaLimparAntes = (tabelaListaProdutos.getSelectionModel().getSelectedIndex()-1);
        int codigoLimparAntes = tabelaListaProdutos.getItems().get(linhaLimparAntes).getCodigo();
        modelProdutos = controllerProdutos.getProdutosController(codigoLimparAntes);
        tabelaListaProdutos.getItems().remove(linhaLimparAntes);
        tabelaListaProdutos.getItems().add(linhaLimparAntes, modelProdutos);
        }
        
        //limpar links linha posterior
        if (linha < (tabelaListaProdutos.getItems().size())){
            if ((linha + 1) != (tabelaListaProdutos.getItems().size())){
        int linhaLimparDepois = (tabelaListaProdutos.getSelectionModel().getSelectedIndex()+1);
        int codigoLimparDepois = tabelaListaProdutos.getItems().get(linhaLimparDepois).getCodigo();
        modelProdutos = controllerProdutos.getProdutosController(codigoLimparDepois);
        tabelaListaProdutos.getItems().remove(linhaLimparDepois);
        tabelaListaProdutos.getItems().add(linhaLimparDepois, modelProdutos);
        }
        }
    }
    
    
    public void listaTodos(){
      tabelaListaProdutos.getItems().clear();
      listaResultado.clear();
      listaResultado  = new ArrayList<>();
      listaModelProdutos = controllerProdutos.getListaProdutosController();
       for (int i = 0; i < listaModelProdutos.size(); i++) {
           listaResultado.add(listaModelProdutos.get(i)); 
           }
       listadeProdutos = FXCollections.observableArrayList(listaResultado);
       tabelaListaProdutos.getItems().addAll(listadeProdutos);
        
    }
    
    public void selecionarProduto(){
        String produto = (controllerProdutos.getProdutosController(tabelaListaProdutos.getSelectionModel().getSelectedItem().getCodigo()).getDescricaoProduto());
        int codigo = tabelaListaProdutos.getSelectionModel().getSelectedItem().getCodigo();
        classeInterfaces.avisaOuvintesProdutoEntrada("entrada", produto);
        classeInterfaces.avisaOuvintesProdutoCodigo("entrada", codigo);
        sair();
    }
    
    public void pesquisaProduto(){
        listaResultado.clear();
        int tamanho = listadeProdutos.size();
        for(int i = 0 ; i< tamanho; i++){
        if((listadeProdutos.get(i).getPesquisa().contains(pesquisaProduto.getText().toUpperCase()))||
                (listadeProdutos.get(i).getCodigoBarrasEan().equals(pesquisaProduto.getText().toUpperCase()))){
            listaResultado.add(listaModelProdutos.get(i)); 
        }
        }
        tabelaListaProdutos.getItems().clear();
        tabelaListaProdutos.getItems().addAll(listaResultado);
       
        }
    
    public void pesquisaProdutoEntrada(String produtoEntrada){
        habilitaBotalSelecionar();
        pesquisaProduto.setText(produtoEntrada);
        listaResultado.clear();
        int tamanho = listadeProdutos.size();
        for(int i = 0 ; i< tamanho; i++){
        if(listadeProdutos.get(i).getPesquisa().contains(produtoEntrada.toUpperCase())){
            listaResultado.add(listaModelProdutos.get(i)); 
           
        }
        }
        tabelaListaProdutos.getItems().clear();
       
        tabelaListaProdutos.getItems().addAll(listaResultado);
       
        }
    public void habilitaBotalSelecionar(){
        btSelecionar.setVisible(true);
    }
    
    public void novoProduto(){
        novoProduto nProduto = new novoProduto();
        try {
            nProduto.start(new Stage());
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sair();
    }
    
    public void relatorioProdutos(){
        
        controllerProdutos.gerarRelatorioProdutos();
        
    }
    
    public void alteraProduto(ActionEvent event) throws IOException{
        
        int cod = (controllerProdutos.getProdutosController(tabelaListaProdutos.getSelectionModel().getSelectedItem().getCodigo()).getCodigo());
        int origem = 1;
               
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroProduto.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        novoProduto nProduto = loader.getController();
        nProduto.AlterarProduto(cod, origem);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(novaRaiz));
        stage.show();
         sair();
    }
    
    public void duplicaProduto(ActionEvent event) throws IOException{
        
        int cod = (controllerProdutos.getProdutosController(tabelaListaProdutos.getSelectionModel().getSelectedItem().getCodigo()).getCodigo());
         int origem = 2;
                 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroProduto.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        novoProduto nProduto = loader.getController();
        nProduto.DuplicarProduto(cod, origem);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(novaRaiz));
        stage.show();
         sair();
    }
        
    }
    
    

