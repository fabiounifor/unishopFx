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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import controller.ControllerVendasProdutos;
import controller.ControllerVendas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ModelVendasProdutos;
import model.ModelVendas;
import model.ModelProdutos;
import controller.ControllerProdutos;
import model.ModelVendasProdutosTabela;
import util.BLMascaras;


/**
 *
 * @author Fabio
 */
public class clienteHistorico extends Application implements Initializable{
    
    @FXML TableView <ModelVendasProdutosTabela> tabelaHistorico = new TableView();;
    @FXML TableColumn<ModelVendasProdutosTabela, String> linhaClienteHistorico;
    ArrayList<ModelVendasProdutos> listaResultadoHistorico  = new ArrayList<>();
    public ArrayList<ModelVendasProdutos> listaTabelaHistorico ;
    ArrayList<ModelVendasProdutos> listaModelHistorico = new ArrayList<>();
    ArrayList<ModelVendas> listaModelOrigem = new ArrayList<>();
    ArrayList<ModelProdutos> listaProdutos = new ArrayList<>();
    ObservableList<ModelVendasProdutosTabela> listadeHistorico;
    public ArrayList<ModelVendasProdutosTabela> listavendidos ;
    
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
    BLMascaras bLMascaras = new BLMascaras();

    public clienteHistorico() {
        this.listaProdutos = controllerProdutos.getListaProdutosAtivosController();
    }
    
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/clienteHistorico.fxml")); 
        Parent raiz = loader.load();   
        listaUnidadeStage.setScene(new Scene(raiz));
        listaUnidadeStage.setTitle("HISTORICO CLIENTE");
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
           // listatodos();
            linhaClienteHistorico.setCellValueFactory(new PropertyValueFactory<>("pesquisaVendido"));        
    }
    public void listatodos(){
        
        listavendidos = new ArrayList<>();
        listaResultadoHistorico  = new ArrayList<>();
        listaProdutos = controllerProdutos.getListaProdutosAtivosController();
      listaModelHistorico = controllerVendasProdutos.getListaVendasProdutosController();
      int tamanho = controllerVendasProdutos.getListaVendasProdutosController().size();
         for(int j = 0 ; j < tamanho; j++){
             ModelVendasProdutosTabela mvpt = new ModelVendasProdutosTabela();
            listavendidos = new ArrayList<>();
            listaResultadoHistorico.add(listaModelHistorico.get(j)); 
            mvpt.setProduto(controllerProdutos.getProdutosController(listaModelHistorico.get(j).getCodigo_produto()).getNome());
            mvpt.setQuantidade(listaModelHistorico.get(j).getQuantidade());
            mvpt.setValorUnitario(listaModelHistorico.get(j).getValorUnitario());
            mvpt.setValorTotal(bLMascaras.arredondamentoComPontoDuasCasas(listaModelHistorico.get(j).getQuantidade()) * (listaModelHistorico.get(j).getValorUnitario()));
            listavendidos.add(mvpt);
            listadeHistorico = FXCollections.observableArrayList(listavendidos);        
            tabelaHistorico.getItems().addAll(listadeHistorico);
        }
        
    }
       
    public void listaHistorico(int codigo){
        
      listaResultadoHistorico  = new ArrayList<>();
      listaModelHistorico = controllerVendasProdutos.getListaVendasProdutosController();
        int codigoVenda = 0;
        String data;
        int tamanho = controllerVendasProdutos.getListaVendasProdutosController().size();
        int tamanhoOrigem = controllerVendas.getListaPedidosController().size();
                
        for (int i=0 ; i < tamanhoOrigem; i++){
           if( controllerVendas.getListaPedidosController().get(i).getClientesCodigo() == codigo ){
           codigoVenda = controllerVendas.getListaPedidosController().get(i).getCodigo();
           data = (String.valueOf(bLMascaras.formatarData(controllerVendas.getListaPedidosController().get(i).getDataVenda())));
           
        
        for(int h = 0 ; h < tamanho; h++){
        if(listaModelHistorico.get(h).getCodigo_venda() == codigoVenda){
            ModelVendasProdutosTabela mvpth = new ModelVendasProdutosTabela();
            listavendidos = new ArrayList<>();
            listaResultadoHistorico.add(listaModelHistorico.get(h)); 
            mvpth.setProduto(controllerProdutos.getProdutosController(listaModelHistorico.get(h).getCodigo_produto()).getNome());
            mvpth.setQuantidade(listaModelHistorico.get(h).getQuantidade());
            mvpth.setValorUnitario(listaModelHistorico.get(h).getValorUnitario());
            mvpth.setValorTotal(bLMascaras.arredondamentoComPontoDuasCasas(listaModelHistorico.get(h).getQuantidade()) * (listaModelHistorico.get(h).getValorUnitario()));
            mvpth.setDataVenda(data);
            listavendidos.add(mvpth);
            listadeHistorico = FXCollections.observableArrayList(listavendidos);        
            tabelaHistorico.getItems().addAll(listadeHistorico);
        }
        }
        }
        }
        }
            
    }
    
    

