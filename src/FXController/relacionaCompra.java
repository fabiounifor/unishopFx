/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCFOP;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import model.ModelCompras;
import model.ModelComprasProdutos;
import model.ModelFornecedor;
import nfe.model.ModelNF;
import controller.ControllerFornecedor;
import controller.ControllerCompras;
import controller.ControllerComprasProdutos;
import controller.ControllerFator;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import interfaces.classeInterfaces;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import nfe.util.ViewLeitorNotaXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import model.ModelCFOP;
import model.ModelContaPagar;
import model.ModelFator;
import model.ModelProdutos;
import util.BLMascaras;
import unishop.Unishop;





/**
 *
 * @author Fabio
 */
public class relacionaCompra extends Application implements Initializable {
    
    @FXML  private TableColumn<ModelComprasProdutos, String> barrasForn;
    @FXML  private TableColumn<ModelComprasProdutos, String> descProdutoForn;
    @FXML  private TableColumn<ModelComprasProdutos, String> descProdutoEstoque;
    @FXML  private TableColumn<ModelComprasProdutos, String> cfopForn;
    @FXML  private TableColumn<ModelComprasProdutos, String>fatConversao;
    @FXML  private TableColumn<ModelComprasProdutos, String> cfopEstoque;
    @FXML  private TableColumn<ModelComprasProdutos, Button> btnProcuraProduto;
    @FXML  private TableColumn<ModelComprasProdutos, Button> btnAdcionaProduto;
    @FXML  private TableColumn<ModelComprasProdutos, Button> btnFator;
    @FXML  private TableColumn<ModelComprasProdutos, Button> btnCfop;
    @FXML  private TableView<ModelComprasProdutos> tabelaProdutoCompra;

 
    @FXML  public Button btGravar;
    @FXML  private Button btProcuraProduto;
    @FXML  private Button btAdcionaProduto;
    @FXML  private Button btFator;
    @FXML  private Button btCfop;
    
    @FXML  public Label lbAvisoSefaz;
    
    private Button BtProcurar;
    ArrayList<ModelComprasProdutos> listaProdutoCompra; 
    String caminho_escolha ;
    String fileName = "", nomeArqXml = "";
    int codigoFornecedor;
    int tamanho = 0;
    ArrayList<ModelComprasProdutos> listaGeralProdutos = new ArrayList<>();
    ArrayList<Button> listaBtproProduto = new ArrayList<>();
    ArrayList<Button> listaBtAdcProduto = new ArrayList<>();
    ArrayList<Button> listaBtProFator = new ArrayList<>();
    ArrayList<Button> listaBtProCfop = new ArrayList<>();
    int controle = 0;
    
    novoProduto np = new novoProduto();
    listaCfop lf = new listaCfop();
    listaProduto lp = new listaProduto();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelCompras modelCompras = new ModelCompras();
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ModelNF modelNF = new ModelNF();
    ModelContaPagar modelContaPagar = new ModelContaPagar();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    ModelCFOP modelCFOP = new ModelCFOP();
    ModelFator modelFator = new ModelFator();
    ArrayList<ModelProdutos> listaProdutoses = new ArrayList<>();
    ArrayList<String> listaProdutos = new ArrayList<>();
    ArrayList<ModelFator> listamodelFator = new ArrayList<>();
    ArrayList<String> listaFator = new ArrayList<>();
    ArrayList<ModelCFOP> listaModelCfop = new ArrayList<>();
    ArrayList<String> listaCfop = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerCompras controllerCompras = new ControllerCompras();
    ControllerFator controllerFator = new ControllerFator();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ViewLeitorNotaXML vlnXML = new ViewLeitorNotaXML();
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage relaciona) throws IOException {
        Button btn = new Button();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/relacioEntrada.fxml"));        
        Parent raiz = loader.load();   
        relaciona.setScene(new Scene(raiz));
        relaciona.initStyle(StageStyle.UNDECORATED);
        relaciona.show();
    }
    
    public void atualizaTabela(ArrayList produtos, String valorNovo, TableView tabela, TableColumn coluna, int indice){
        int tamanhoLista = produtos.size();
        
        
        for (int i = 0; i<tamanhoLista; i++ ){
            
            if (!(valorNovo.equals(""))){
//                produtos.set(indice, coluna);
            }
            
        }
                
        
    }
    
    public void adicionaBotoes(ArrayList<ModelComprasProdutos> produtos){
     ArrayList<ModelComprasProdutos> produtoTabelaBotoes = new ArrayList<>();
        for(int i = 0; i<produtos.size();i++){
            ModelComprasProdutos produtosCompras = new ModelComprasProdutos();
            iniciaBotoes();
            produtosCompras.setBarras(produtos.get(i).getBarras());
            produtosCompras.setCfop(produtos.get(i).getCfop());
            produtosCompras.setCfopEstoque(produtos.get(i).getCfopEstoque());
            produtosCompras.setOrdem(i+1);
            produtosCompras.setNcm(produtos.get(i).getNcm());
            produtosCompras.setCst(produtos.get(i).getCst());
            if (!(produtos.get(i).getFatorConversao() == null)){
                if (controllerFator.getFatorDescricaoController(produtos.get(i).getFatorConversao()).getOperando().equals("*")){
                produtosCompras.setQuantidade((produtos.get(i).getQuantidade()) * (controllerFator.getFatorDescricaoController(produtos.get(i).getFatorConversao()).getFator()));
                produtosCompras.setValorCusto(produtos.get(i).getValorCusto() / (controllerFator.getFatorDescricaoController(produtos.get(i).getFatorConversao()).getFator()));
                } else{
                    produtosCompras.setQuantidade((produtos.get(i).getQuantidade()) / (controllerFator.getFatorDescricaoController(produtos.get(i).getFatorConversao()).getFator()));
                    produtosCompras.setValorCusto(produtos.get(i).getValorCusto() * (controllerFator.getFatorDescricaoController(produtos.get(i).getFatorConversao()).getFator()));
                }
            }else{
                produtosCompras.setQuantidade(produtos.get(i).getQuantidade());
                produtosCompras.setValorCusto(produtos.get(i).getValorCusto());
                 }
            produtosCompras.setValorTotal(produtos.get(i).getValorTotal());
            produtosCompras.setNomeProdutoEstoque(produtos.get(i).getNomeProdutoEstoque());
            produtosCompras.setNomeProduto(produtos.get(i).getNomeProduto());
            produtosCompras.setPercCreditoSn(produtos.get(i).getPercCreditoSn());
            produtosCompras.setValorCreditoSn(produtos.get(i).getValorCreditoSn());
            produtosCompras.setValorIpi(produtos.get(i).getValorIpi());
            produtosCompras.setPercIpi(produtos.get(i).getPercIpi());
            produtosCompras.setCodProdutoFornecedor(produtos.get(i).getCodProdutoFornecedor());
            produtosCompras.setCodFornecedor(produtos.get(i).getCodFornecedor());
            produtosCompras.setUnidade(String.valueOf(controllerUnidadeMedia.getUnidadeMediaController(produtos.get(i).getUnidade())));
            produtosCompras.setFatorConversao(produtos.get(i).getFatorConversao());
            produtosCompras.setCest(produtos.get(i).getCest());
            produtosCompras.setBaseCalculoSub(produtos.get(i).getBaseCalculoSub());
            produtosCompras.setBaseCalculoicms(produtos.get(i).getBaseCalculoicms());
            produtosCompras.setProcurarProduto(btProcuraProduto);
            produtosCompras.setProcurarCfop(btCfop);
            produtosCompras.setProcurarFator(btFator);
            produtosCompras.setAdcionarProduto(btAdcionaProduto);
            produtoTabelaBotoes.add(produtosCompras);
            iniciaBotoes();
        }
            preencheTabela(produtoTabelaBotoes);        
    }
    
    public void selecionarlinha(){
        
    }
    
    public void preencheTabela(ArrayList produtos){
        if (!(produtos.isEmpty())){
        tamanho = tamanho + 1;
        tabelaProdutoCompra.setPrefHeight((tamanho * 55)+ 55);
        }
        if (tabelaProdutoCompra.getPrefHeight() > 550){
            tabelaProdutoCompra.setPrefHeight(550);
        }
        tabelaProdutoCompra.getItems().addAll(produtos);
        tabelaProdutoCompra.accessibleTextProperty();

        }
    
    public void preencheListaProdutos(TableView<ModelComprasProdutos> tabelaProduto){
       
        for(int i=0; i<tabelaProduto.getItems().size(); i++){
            ModelComprasProdutos produtosCompras = new ModelComprasProdutos();
            produtosCompras.setBarras(tabelaProduto.getItems().get(i).getBarras());
            produtosCompras.setCfop(tabelaProduto.getItems().get(i).getCfop());
            produtosCompras.setCfopEstoque(tabelaProduto.getItems().get(i).getCfopEstoque());
            produtosCompras.setOrdem(i+1);
            produtosCompras.setNcm(tabelaProduto.getItems().get(i).getNcm());
            produtosCompras.setCst(tabelaProduto.getItems().get(i).getCst());
            if (!(tabelaProdutoCompra.getItems().get(i).getFatorConversao() == null)){
                if (controllerFator.getFatorDescricaoController(tabelaProdutoCompra.getItems().get(i).getFatorConversao()).getOperando().equals("*")){
                produtosCompras.setQuantidade((tabelaProduto.getItems().get(i).getQuantidade()) * (controllerFator.getFatorDescricaoController(tabelaProdutoCompra.getItems().get(i).getFatorConversao()).getFator()));
                produtosCompras.setValorCusto(tabelaProduto.getItems().get(i).getValorCusto() / (controllerFator.getFatorDescricaoController(tabelaProdutoCompra.getItems().get(i).getFatorConversao()).getFator()));
                } else{
                    produtosCompras.setQuantidade((tabelaProduto.getItems().get(i).getQuantidade()) / (controllerFator.getFatorDescricaoController(tabelaProdutoCompra.getItems().get(i).getFatorConversao()).getFator()));
                    produtosCompras.setValorCusto(tabelaProduto.getItems().get(i).getValorCusto() * (controllerFator.getFatorDescricaoController(tabelaProdutoCompra.getItems().get(i).getFatorConversao()).getFator()));
                }
            }else{
                produtosCompras.setQuantidade(tabelaProduto.getItems().get(i).getQuantidade());
                produtosCompras.setValorCusto(tabelaProduto.getItems().get(i).getValorCusto());
                 }
            produtosCompras.setValorTotal(tabelaProduto.getItems().get(i).getValorTotal());
            produtosCompras.setNomeProdutoEstoque(tabelaProduto.getItems().get(i).getNomeProdutoEstoque());
            produtosCompras.setNomeProduto(tabelaProduto.getItems().get(i).getNomeProduto());
            produtosCompras.setPercCreditoSn(tabelaProduto.getItems().get(i).getPercCreditoSn());
            produtosCompras.setValorCreditoSn(tabelaProduto.getItems().get(i).getValorCreditoSn());
            produtosCompras.setValorIpi(tabelaProduto.getItems().get(i).getValorIpi());
            produtosCompras.setPercIpi(tabelaProduto.getItems().get(i).getPercIpi());
            produtosCompras.setCodProdutoFornecedor(tabelaProduto.getItems().get(i).getCodProdutoFornecedor());
            produtosCompras.setCodFornecedor(tabelaProduto.getItems().get(i).getCodFornecedor());
            produtosCompras.setUnidade(String.valueOf(controllerUnidadeMedia.getUnidadeMediaController(tabelaProduto.getItems().get(i).getUnidade())));
            produtosCompras.setFatorConversao(tabelaProduto.getItems().get(i).getFatorConversao());
            produtosCompras.setCest(tabelaProduto.getItems().get(i).getCest());
            produtosCompras.setBaseCalculoSub(tabelaProduto.getItems().get(i).getBaseCalculoSub());
            produtosCompras.setBaseCalculoicms(tabelaProduto.getItems().get(i).getBaseCalculoicms());
            
            listaGeralProdutos.add(produtosCompras);
        }
       
     }
    
    private void iniciaBotoes(){
        
        btProcuraProduto = new Button();
        btCfop = new Button();
        btFator = new Button();
        btAdcionaProduto = new Button();
        btAdcionaProduto.setAlignment(Pos.CENTER);
        
                
        btCfop.setOnMouseClicked((MouseEvent e)->{
            int linha = tabelaProdutoCompra.focusModelProperty().get().focusedCellProperty().getValue().getRow();
            tabelaProdutoCompra.getSelectionModel().select(linha);
            String cfop = tabelaProdutoCompra.getItems().get(linha).getCfopEstoque();
            modelComprasProdutos = tabelaProdutoCompra.getItems().get(linha);                        
            ActionEvent evento = null;
                try {
                    procuraCfop(cfop);
                    classeInterfaces.addaoMudarTelaOuvinteCfopEntrada((String novaTela,String CfopEntrada)-> {
                    modelComprasProdutos.setCfopEstoque(CfopEntrada);
                    tabelaProdutoCompra.getSelectionModel().getTableView().refresh();
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             });
                
        btFator.setOnMouseClicked((MouseEvent e)->{
            modelComprasProdutos = new ModelComprasProdutos();
            int linha = tabelaProdutoCompra.focusModelProperty().get().focusedCellProperty().getValue().getRow();
            tabelaProdutoCompra.getSelectionModel().select(linha);
            String fator = tabelaProdutoCompra.getItems().get(linha).getFatorConversao();
            modelComprasProdutos = tabelaProdutoCompra.getItems().get(linha);
            if (fator == null){
                fator = "";
            }
            ActionEvent evento = null;
                try {
                    procuraFator(fator);
                    classeInterfaces.addaoMudarTelaOuvinteFatorEntrada((String novaTela,String FatorEntrada)-> {
                    modelComprasProdutos.setFatorConversao(FatorEntrada);
                    tabelaProdutoCompra.getSelectionModel().getTableView().refresh();
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                            });
        btProcuraProduto.setOnMouseClicked((MouseEvent e)->{
            modelComprasProdutos = new ModelComprasProdutos();
            int linha = tabelaProdutoCompra.focusModelProperty().get().focusedCellProperty().getValue().getRow();
            tabelaProdutoCompra.getSelectionModel().select(linha);
            String produto = tabelaProdutoCompra.getItems().get(linha).getNomeProdutoEstoque();
            if (produto == null){
                produto = tabelaProdutoCompra.getItems().get(linha).getNomeProduto();
            }
            modelComprasProdutos = tabelaProdutoCompra.getItems().get(linha);
            ActionEvent evento = null;
                try {
                    procuraProduto(produto);
                    classeInterfaces.addaoMudarTelaOuvinteProdutoEntrada((String novaTela,String ProdutoEntrada)-> {
                    modelComprasProdutos.setNomeProdutoEstoque(ProdutoEntrada);
                    tabelaProdutoCompra.getSelectionModel().getTableView().refresh();
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
             });
        btAdcionaProduto.setOnMouseClicked((MouseEvent e)->{
            modelComprasProdutos = new ModelComprasProdutos();
            int linha = tabelaProdutoCompra.focusModelProperty().get().focusedCellProperty().get().getRow();
            int produto = tabelaProdutoCompra.getItems().get(linha).getCodigo();
            tabelaProdutoCompra.getSelectionModel().select(linha);
            modelComprasProdutos = tabelaProdutoCompra.getItems().get(linha);
                      ActionEvent evento = null;
                try {
                    novoProduto(modelComprasProdutos);
                    classeInterfaces.addaoMudarTelaOuvinteProdutoEntrada((String novaTela,String ProdutoEntrada)-> {
                    modelComprasProdutos.setNomeProdutoEstoque(ProdutoEntrada);
                    tabelaProdutoCompra.getSelectionModel().getTableView().refresh();
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
             });
        
        
    }
    
    public void novoProduto(ModelComprasProdutos mcp) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroProduto.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        novoProduto nProduto = loader.getController();
        nProduto.produtoEntrada(mcp);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(novaRaiz));
        stage.show();    
        
    }
    public void escolheProduto(){
             listaProduto produto = new listaProduto();
        try {
            produto.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public String escolheArq() {
   FileChooser fileChooser = new FileChooser ();
   fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Arquivo XML", "*.xml"));
   File selectedFile = fileChooser.showOpenDialog (null);
        
if (selectedFile != null) {

   return selectedFile.getPath();
  
}
else {
    return null;
}

}
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            iniciaBotoes();
             classeInterfaces.addaoMudarTelaCaminho((String novaTela,String caminho)-> {
                System.out.println("CAMINHO RELACIONA");
                recuperaXml(caminho);
            });            
                    classeInterfaces.addaoMudarTelaOuvinteProdutos((String novaTela,  ArrayList produtos, ArrayList nfe,ArrayList fornecedor,ArrayList contasPagar) -> {
                    adicionaBotoes(produtos);
                    cadastraFornecedor(fornecedor);
                    try {
                        nfe(nfe, fornecedor);
                    } catch (Exception ex) {
                        Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    contasPagar(contasPagar);
                                     
                    });
        
               
        tabelaProdutoCompra.setEditable(true);

        cfopEstoque.setCellValueFactory(new PropertyValueFactory<>("cfopEstoque"));
        cfopEstoque.setCellFactory(TextFieldTableCell.forTableColumn());
        cfopEstoque.setOnEditCommit(new EventHandler<CellEditEvent<ModelComprasProdutos, String>>(){
            @Override
            public void handle(CellEditEvent<ModelComprasProdutos, String> event) {
                ModelComprasProdutos mcpLinha = event.getRowValue();
                mcpLinha.setCfopEstoque(event.getNewValue());
            if(!(event.getNewValue().equals(""))){
                 try {
                    procuraCfop(event.getNewValue());
                    classeInterfaces.addaoMudarTelaOuvinteCfopEntrada((String novaTela,String CfopEntrada)-> {
                    mcpLinha.setCfopEstoque(CfopEntrada);
                    
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                 tabelaProdutoCompra.getEditingCell().getTableView().refresh();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("AVISO");
                alert.setContentText("DIGITE UMA VALOR PRA PROCURAR");
                alert.show();
            }
            }

        });
        
        
        barrasForn.setCellValueFactory(new PropertyValueFactory<>("barras"));
        descProdutoForn.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        cfopForn.setCellValueFactory(new PropertyValueFactory<>("cfop"));
        btnProcuraProduto.setCellValueFactory(new PropertyValueFactory<>("procurarProduto"));
        btnAdcionaProduto.setCellValueFactory(new PropertyValueFactory<>("adcionarProduto"));
        btnFator.setCellValueFactory(new PropertyValueFactory<>("procurarFator"));
        btnCfop.setCellValueFactory(new PropertyValueFactory<>("procurarCfop"));
        
        fatConversao.setCellValueFactory(new PropertyValueFactory<>("fatorConversao"));
        fatConversao.setCellFactory(TextFieldTableCell.forTableColumn());
        fatConversao.setOnEditCommit((CellEditEvent<ModelComprasProdutos, String> event) -> {
            ModelComprasProdutos mcpLinha = event.getRowValue();
            mcpLinha.setFatorConversao(event.getNewValue());
            if(!(event.getNewValue().equals(""))){
                try {
                    procuraFator(mcpLinha.getFatorConversao());
                    classeInterfaces.addaoMudarTelaOuvinteFatorEntrada((String novaTela,String fatorEntrada)-> {
                        mcpLinha.setFatorConversao(fatorEntrada);
                
                        });
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                tabelaProdutoCompra.getEditingCell().getTableView().refresh();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("AVISO");
                alert.setContentText("DIGITE UMA VALOR PRA PROCURAR");
                alert.show();
            }
            
            });
        descProdutoEstoque.setCellValueFactory(new PropertyValueFactory<>("nomeProdutoEstoque"));
        descProdutoEstoque.setCellFactory(TextFieldTableCell.forTableColumn());
        descProdutoEstoque.setOnEditCommit((CellEditEvent<ModelComprasProdutos, String> event) -> {
            ModelComprasProdutos mcpLinha = event.getRowValue();
            if(event.getNewValue().equals("")){
                   try {
                            novoProduto(mcpLinha);
                    classeInterfaces.addaoMudarTelaOuvinteProdutoEntrada((String novaTela,String ProdutoEntrada)-> {
                    mcpLinha.setNomeProdutoEstoque(ProdutoEntrada);
                        
                        });
                    
                        } catch (IOException ex) {
                            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   tabelaProdutoCompra.getEditingCell().getTableView().refresh();
            } else if(!(event.getNewValue().equals(""))){
                             
              if (!(retornarprodutoPeloNome(event.getNewValue()) == null)){
                  mcpLinha.setNomeProdutoEstoque(retornarprodutoPeloNome(event.getNewValue()));
              }
              else if (!(retornarprodutoPeloCodBarras(event.getNewValue())== null)){
              mcpLinha.setNomeProdutoEstoque(retornarprodutoPeloCodBarras(event.getNewValue()));
            }
// TESTA SE VALOR É NUMERICO
              else if (event.getNewValue().matches("-?\\d+")){
                  if (!(retornarprodutoPeloCodigo(Integer.parseInt(event.getNewValue())) == null)){
              mcpLinha.setNomeProdutoEstoque(retornarprodutoPeloCodigo(Integer.parseInt(event.getNewValue())));
              }
            }else{
               try {
                    procuraProduto(event.getNewValue());
                    classeInterfaces.addaoMudarTelaOuvinteProdutoEntrada((String novaTela,String ProdutoEntrada)-> {
                    mcpLinha.setNomeProdutoEstoque(ProdutoEntrada);
                    
                        });
                    tabelaProdutoCompra.getEditingCell().getTableView().refresh();
                } catch (Exception ex) {
                    Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
              tabelaProdutoCompra.getEditingCell().getTableView().refresh();
            }
            }
            
            });
        
    }
    
    
    public void recuperaXml(String caminho){
        caminho_escolha = caminho;
            if (caminho_escolha == null){
                caminho_escolha="0";
            }
            try {
            if (caminho_escolha == "0"){
                vlnXML.lerarqCompra(escolheArq());
            }else{
                vlnXML.lerarqCompra(caminho_escolha);
                }
            
            } catch (Exception ex) {
            Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    public void cadastraFornecedor (ArrayList<ModelFornecedor> Listafornecedor){
        for (int i = 0; i < Listafornecedor.size(); i++){
            if (Listafornecedor.get(i) != null){
            modelFornecedor.setBairro(Listafornecedor.get(i).getBairro());        
            modelFornecedor.setCnpj(Listafornecedor.get(i).getCnpj());        
            modelFornecedor.setInscEstadual(Listafornecedor.get(i).getInscEstadual());        
            modelFornecedor.setNome(Listafornecedor.get(i).getNome());        
            modelFornecedor.setTelefone(Listafornecedor.get(i).getTelefone());        
            modelFornecedor.setNumero(Listafornecedor.get(i).getNumero());        
            modelFornecedor.setEndereco(Listafornecedor.get(i).getEndereco());        
            modelFornecedor.setCep(Listafornecedor.get(i).getCep());        
            modelFornecedor.setCodCidade(Listafornecedor.get(i).getCodCidade());        
            modelFornecedor.setCodEstado(Listafornecedor.get(i).getCodEstado());
            
        }
            codigoFornecedor = controllerFornecedor.getFornecedorController(Listafornecedor.get(i).getNome()).getCodigo();
        i = Listafornecedor.size();
    }
     
    }
    
      
    private String retornarprodutoPeloNome(String nome) {
        //INICIO recupera o nome
        String nomeRetorno;
        modelProdutos = controllerProdutos.getProdutosController(nome);
      nomeRetorno = modelProdutos.getDescricaoProduto();
      return nomeRetorno;
    }
         
    private String retornarprodutoPeloCodBarras(String barras) {
        //INICIO recupera o codigo de barras
        String nomeRetorno;
        modelProdutos = controllerProdutos.getProdutosCodigoBarrasController(barras);
        nomeRetorno = modelProdutos.getDescricaoProduto();
        return nomeRetorno;
    }
    private String retornarprodutoPeloCodigo(int Codigo) {
        //INICIO recupera o codigo de barras
        String nomeRetorno;
        modelProdutos = controllerProdutos.getProdutosController(Codigo);
        nomeRetorno = modelProdutos.getDescricaoProduto();
        return nomeRetorno;
    }
         
         
        
     
    public void nfe (ArrayList<ModelNF> nfe, ArrayList<ModelFornecedor> fornecedorLista) throws Exception{
        for (int i = 0; i < nfe.size(); i++){
            System.out.println("VALOR TOTAL RELACIONA:  " +nfe.get(i).getValorTotal());
            if (nfe.get(i) != null ){
            modelNF.setEmpresa(nfe.get(i).getEmpresa());        
            modelNF.setChaveNfe(nfe.get(i).getChaveNfe());        
            modelNF.setCofinsBc(nfe.get(i).getCofinsBc());        
            modelNF.setCofinsVlr(nfe.get(i).getCofinsVlr());        
            modelNF.setDadosAdicionais(nfe.get(i).getDadosAdicionais());        
            if (nfe.get(i).getDataDigitacao() == (null)){
                modelNF.setDataDigitacao(nfe.get(i).getDataEmissao());        
            }else{
                modelNF.setDataDigitacao(nfe.get(i).getDataDigitacao());        
            }
            modelNF.setDataEmissao(nfe.get(i).getDataEmissao());        
            modelNF.setNumeroNfe(nfe.get(i).getNumeroNfe());        
            modelNF.setFinNfe(nfe.get(i).getFinNfe());        
            modelNF.setIcmsBc(nfe.get(i).getIcmsBc());        
            modelNF.setIcmsVlr(nfe.get(i).getIcmsVlr());        
            modelNF.setIpiBc(nfe.get(i).getIpiBc());        
            modelNF.setIpiVlr(nfe.get(i).getIpiVlr());        
            modelNF.setPisBc(nfe.get(i).getPisBc());        
            modelNF.setPisVlr(nfe.get(i).getPisVlr());        
            modelNF.setBCSubst(nfe.get(i).getBCSubst());        
            modelNF.setICMSSubst(nfe.get(i).getICMSSubst());        
            modelNF.setOutros(nfe.get(i).getOutros());        
            modelNF.setValorDescontos(nfe.get(i).getValorDescontos());        
            modelNF.setValorProdutos(nfe.get(i).getValorProdutos());        
            modelNF.setValorTotal(nfe.get(i).getValorTotal());        
            modelNF.setCodTipoDoc(nfe.get(i).getCodTipoDoc());
            modelNF.setUfPlaca("ES");
            modelNF.setModelonfe(nfe.get(i).getModelonfe());
            modelNF.setSerieNfe(nfe.get(i).getSerieNfe());
            modelNF.setTpamb(nfe.get(i).getTpamb());
            modelNF.setTpemis(nfe.get(i).getTpemis());
            modelNF.setDataCancelamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelNF.setDataDevolucao(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelNF.setCodCliente(codigoFornecedor);
            modelNF.setDocCliente(controllerFornecedor.getFornecedorController(codigoFornecedor).getCnpj());
            }
        i = nfe.size();
    }
    
    }
    
    public void contasPagar (ArrayList<ModelContaPagar> contaPagar){
        for (int i = 0; i < contaPagar.size(); i++){
            if (contaPagar.get(i) != null){
            modelContaPagar.setData(contaPagar.get(i).getData());
            modelContaPagar.setDescricao(contaPagar.get(i).getDescricao());
            modelContaPagar.setSituacao(0);
            modelContaPagar.setTipoConta(contaPagar.get(i).getTipoConta());
            modelContaPagar.setValor(contaPagar.get(i).getValor());
            modelContaPagar.setVencimento(contaPagar.get(i).getVencimento());
            modelContaPagar.setTipoPagamento(contaPagar.get(i).getTipoPagamento());
            modelContaPagar.setPagamento(contaPagar.get(i).getPagamento());
            modelContaPagar.setDocOrigem(contaPagar.get(i).getDocOrigem());
            modelContaPagar.setCodigoPessoa(codigoFornecedor);
            }
        }
        
    }
        
    public void salvaFornecedor(ModelFornecedor fornecedor) throws Exception{
        if ((controllerFornecedor.getFornecedorController(fornecedor.getNome()).getCnpj()) == null){
            controllerFornecedor.salvarFornecedorController(fornecedor);
        }else {
        controllerFornecedor.atualizarFornecedorController(fornecedor);
    }
      codigoFornecedor = controllerFornecedor.getFornecedorController(fornecedor.getNome()).getCodigo();
    }
    
    
    
    public void finaliza() throws Exception{
       try {
          salvaFornecedor(modelFornecedor);
           preencheListaProdutos(tabelaProdutoCompra);
           cadastrarNfeEntrada(modelNF, modelFornecedor, modelContaPagar);
                    } catch (IOException ex) {
                        Logger.getLogger(relacionaCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }  
    }
   
    public void cadastrarNfeEntrada(ModelNF nfe, ModelFornecedor fornecedor, ModelContaPagar contasPagar) throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/nfeEntrada.fxml"));
        Parent entradaRaiz = (Parent) loader.load();
        nfeEntrada nEntrada = loader.getController();
        nEntrada.preencherEntradas(listaGeralProdutos, nfe, fornecedor, contasPagar);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaRaiz));
        stage.show();
        sair();
        
    }
    
    public void procuraProduto(String produto) throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqProduto.fxml"));
        Parent entradaProduto = (Parent) loader.load();
        listaProduto novoProduto = loader.getController();
        novoProduto.pesquisaProdutoEntrada(produto);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaProduto));
        stage.show();
   
        
    }
        
    public void procuraFator(String fator) throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqFator.fxml"));
        Parent entradaProduto = (Parent) loader.load();
        listaFator localizaFator = loader.getController();
        localizaFator.pesquisaFatorEntrada(fator);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaProduto));
        stage.show();
   
        
    }
    public void procuraCfop(String cfop) throws IOException, Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqCfop.fxml"));
        Parent entradaProduto = (Parent) loader.load();
        listaCfop localizaCfop = loader.getController();
        localizaCfop.pesquisaCfopEntrada(cfop);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(entradaProduto));
        stage.show();
   
        
    }
    
    public void sair(){
        Stage relaciona = (Stage) btGravar.getScene().getWindow();
        classeInterfaces.avisaOuvintesProgresso("novatela", Boolean.FALSE);
        relaciona.close();
        
    }
        
    
    
    
}
