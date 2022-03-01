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
import controller.ControllerComprasProdutos;
import controller.ControllerCaixa;
import controller.ControllerProdutos;
import nfe.controller.ControllerNF;
import nfe.controller.ControllerNFCe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.ModelComprasProdutos;
import model.ModelProdutos;
import interfaces.classeInterfaces;
import javafx.stage.StageStyle;
import com.acbr.nfe.ACBrNFe;
import controller.ControllerContaPagar;
import controller.ControllerFornecedor;
import java.util.Collections;
import javafx.stage.Modality;
import model.ModelContaPagar;
import model.ModelFornecedor;
import nfe.model.ModelNF;

/**
 *
 * @author Fabio
 */
public class listaCompras extends Application implements Initializable{
    
    @FXML TextField pesquisaCompras;
    @FXML Button btPesquisarCompras;
    @FXML Button btEditarCompra;
    @FXML Button btExcluirCompra;
    @FXML Button btImprimirCompra;
    @FXML Button btDevolucaoCompras;
    @FXML private Button btSair;
    @FXML TableView <ModelNF> tabelaListaCompras = new TableView();;
    @FXML TableColumn<ModelNF, String> linhaCompras;
    ArrayList<ModelNF> listaResultado  = new ArrayList<>();
    public ArrayList<ModelNF> listaTabelaCompras ;
    public ArrayList<ModelComprasProdutos> listaProdutoRetornar ;
    ArrayList<ModelNF> listaModelNF = new ArrayList<>();
    ObservableList<ModelNF> listadeCompras;
    private ControllerNF controllerNF = new ControllerNF();
    private ControllerNFCe controllerNFCe = new ControllerNFCe();
    private ACBrNFe acbrNFe;
    double valorAtualizar = 0;
    int codigoExcluir;
    
   
    
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    
    @Override
    public void start(Stage listaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqCompras.fxml")); 
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
           
            
            linhaCompras.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));  
            
            pesquisaCompras.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode()== KeyCode.ENTER){
            if((pesquisaCompras.getText().equals(""))){
                listaTodos();
            }else{
               listaFiltro();
            }
       }
       });
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void lista(){
        if((pesquisaCompras.getText().equals(""))){
                listaTodos();
            }else{
               listaFiltro();
            }
    }
    private void listaTodos(){
      listaResultado.clear();
      tabelaListaCompras.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelNF = controllerNF.getListaNFCOMPRAController();
        final novoPrincipal principal = new novoPrincipal();
    classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);         
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 0; i < listaModelNF.size(); i++) {
            listaResultado.add(listaModelNF.get(i)); 
        }
       listadeCompras = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeCompras);
       tabelaListaCompras.getItems().addAll(listadeCompras);
      classeInterfaces.avisaOuvintesProgresso("principal", Boolean.FALSE);         
     }
      
       };
        t.start();
        }
    private void listaFiltro(){
      listaResultado.clear();
      tabelaListaCompras.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelNF = controllerNF.getListaNFCOMPRAController();
        final novoPrincipal principal = new novoPrincipal();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 1; i < listaModelNF.size(); i++) {
            if (listaModelNF.get(i).getPesquisa().contains(pesquisaCompras.getText().toUpperCase())){
             listaResultado.add(listaModelNF.get(i)); 
            }
        } 
       listadeCompras = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeCompras);
       tabelaListaCompras.getItems().addAll(listadeCompras);
       classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
        }
       };
        t.start();
        
    }
    
    public void reimprimirNFe(){
       int nfeEscolhida = tabelaListaCompras.getSelectionModel().getFocusedIndex();
       int compra  = tabelaListaCompras.getItems().get(nfeEscolhida).getPedido();
       String chave = controllerNF.getNFCOMPRAController(compra).getChaveNfe();
              
   }
    
    public void excluirCompra(){
        int posicaoExcluir = tabelaListaCompras.getSelectionModel().getFocusedIndex();
        codigoExcluir = tabelaListaCompras.getItems().get(posicaoExcluir).getPedido();
        double valorAtual = controllerCaixa.retorarCaixaControler(1).getDinheiro();
        double valorCompra = controllerNF.getNFCOMPRAController(codigoExcluir).getValorTotal();
        valorAtualizar = valorAtual - valorCompra;
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("EXCLUIR VENDA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE EXCLUIR A VENDA "+ codigoExcluir +" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
       // retirarCompradoCaixa();
       // retonarProdutoEstoque(codigoExcluir);
               
        controllerNF.excluirNFCOMPRAController(codigoExcluir);
        tabelaListaCompras.getItems().remove(posicaoExcluir);
        controllerNF.excluirNFCOMPRAController(codigoExcluir);
        controllerComprasProdutos.excluircompras_produtosController(codigoExcluir);
                    }
                    });
        
    }
    
    public void devolucaoNfe() throws IOException{
        int posicaoDevolver;
        int pedidoNfeDevolver;
        posicaoDevolver = tabelaListaCompras.getSelectionModel().getFocusedIndex();
        pedidoNfeDevolver = tabelaListaCompras.getItems().get(posicaoDevolver).getPedido();
         
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/nfeSaida.fxml")); 
        Parent raiz = loader.load();
        nfeSaida nfe = loader.getController();
        nfe.devolucaoNfe(pedidoNfeDevolver);
        Stage nfeStage = new Stage();
        nfeStage.setScene(new Scene(raiz));
        nfeStage.initStyle(StageStyle.UNDECORATED);
        nfeStage.initModality(Modality.APPLICATION_MODAL);
        nfeStage.show();
         
     }
    
    
    /*
    public void relatorioEntradas(){
        Date datainicial = Date.valueOf(LocalDate.MIN);
        Date datafinal = Date.valueOf(LocalDate.MIN);;
       DAORelatorios dr = new DAORelatorios();
       BLMascaras blMascaras = new BLMascaras();
        try {
            datainicial = blMascaras.converterDataStringParaDate("01/07/2021");
            datafinal = blMascaras.converterDataStringParaDate("31/07/2021");
        } catch (Exception ex) {
            Logger.getLogger(listaCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
       dr.gerarRelatorioCompraDAO(datainicial, datafinal);
        
    }
    */
    
        
    public void retirarProdutoEstoque(int codigoCompra){
        ModelComprasProdutos mvpr = new ModelComprasProdutos();
        controllerComprasProdutos = new ControllerComprasProdutos();
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        listaProdutoRetornar = controllerComprasProdutos.getListacompras_produtosController(codigoCompra);
        for (int i=0; i< listaProdutoRetornar.size(); i++){
            ModelProdutos modelProdutos = new ModelProdutos();
            modelProdutos.setAddEstoque((controllerProdutos.getProdutosController(listaProdutoRetornar.get(i).getCodigo()).getEstoque() + listaProdutoRetornar.get(i).getQuantidade())* -1);
            controllerProdutos.atualizarProdutosEstoqueController(modelProdutos);
        }
    }
   
    
    public void selecionarCompra() throws IOException, Exception{
        int seleciona = 0;
        int posicaoAbrir = tabelaListaCompras.getSelectionModel().getFocusedIndex();
        int codigoAbrir = tabelaListaCompras.getItems().get(posicaoAbrir).getPedido();
        ArrayList<ModelComprasProdutos> modelComprasProdutos = new ArrayList<>();
        ModelNF modelNF = new ModelNF();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        ModelContaPagar modelContaPagar = new ModelContaPagar();
        
        modelComprasProdutos = controllerComprasProdutos.getListacompras_produtosController(codigoAbrir);
        modelNF = controllerNF.getNFCompraCodigoController(codigoAbrir);
        modelFornecedor = controllerFornecedor.getFornecedorController(modelNF.getCodCliente());
        modelContaPagar = controllerContaPagar.getContaPagarController(codigoAbrir);
        FXMLLoader loaderNfe = new FXMLLoader(getClass().getResource("/FXView/nfeEntrada.fxml"));
        Parent raizNfe = (Parent) loaderNfe.load();
        nfeEntrada nfe = loaderNfe.getController();
        Stage compraStage = new Stage();
        nfe.controle = 3;
        nfe.preencherEntradas(modelComprasProdutos, modelNF, modelFornecedor, modelContaPagar);
        compraStage.setScene(new Scene(raizNfe));
        compraStage.show();
        fecharSaida();
  
    }
    public void fecharSaida(){
          Stage estagioListaCompras = (Stage) btEditarCompra.getScene().getWindow();
          estagioListaCompras.close();
          }
    

}
    

