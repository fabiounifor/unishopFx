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
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import controller.ControllerCaixa;
import controller.ControllerProdutos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.ModelVendas;
import model.ModelVendasProdutos;
import model.ModelCaixa;
import model.ModelProdutos;
import model.ModelSeleciona;
import util.AguardeGerandoRelatorio;
import interfaces.classeInterfaces;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import util.ManipularXML;
import relatorios.DAORelatorios;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class listaEntregas extends Application implements Initializable{
    
    @FXML TextField pesquisaVendas;
    @FXML Button btPesquisarVendas;
    @FXML Button btEditarVenda;
    @FXML Button btExcluirVenda;
    @FXML Button btImprimirVenda;
    @FXML private Button btSair;
    @FXML TableView <ModelVendas> tabelaListaVendas = new TableView();
    @FXML TableView <ModelSeleciona> tabelaSelecionaVendas = new TableView();
    @FXML TableColumn<ModelVendas, String> linhaVendas;
    @FXML TableColumn<ModelSeleciona, Boolean> linhaSelecionada;
    @FXML ChoiceBox<String> cbFiltro;
    @FXML Button saiuEntrega;
    @FXML Button entregaFeita;
    String data;  
    ArrayList<ModelVendas> listaResultado  = new ArrayList<>();
    ArrayList<ModelSeleciona> listaSeleciona  = new ArrayList<>();
    public ArrayList<ModelVendas> listaTabelaVendas ;
    public ArrayList<ModelVendasProdutos> listaProdutoRetornar ;
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ObservableList<ModelVendas> listadeVendas;
    double valorAtualizar = 0;
    int codigoExcluir;
    boolean valor;
   
    
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ModelSeleciona modelSeleciona = new ModelSeleciona();
    
    @Override
    public void start(Stage listaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqEntregas.fxml")); 
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
            selecaoMultipla();
            iniciaFiltro();
            linhaVendas.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));  
            pesquisaVendas.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode()== KeyCode.ENTER){
            if((pesquisaVendas.getText().equals(""))){
                listaTodos();
            }else{
               listaFiltro();
            }
       }
       });
             cbFiltro.setOnAction((event) -> {
            listaStatus();
      });
    }
    public void iniciaFiltro(){
       cbFiltro.getItems().addAll("AGUARDANDO","SAIU PARA ENTREGA", "ENTREGA EFETUADA");
       
    }
    public void sair(){
       Stage estagiosaida = (Stage) btSair.getScene().getWindow();
       estagiosaida.close();
     }
    
    public void selecionaLinhas(){
        modelSeleciona = new ModelSeleciona();
        int posicao = tabelaSelecionaVendas.getSelectionModel().getFocusedIndex();
        tabelaSelecionaVendas.getItems().get(posicao).setSeleciona(true);
        
         linhaSelecionada.setCellValueFactory(
new Callback<CellDataFeatures<ModelSeleciona,Boolean>,ObservableValue<Boolean>>()
{
    @Override
    public ObservableValue<Boolean> call(CellDataFeatures<ModelSeleciona, Boolean> param)
    {   if (linhaSelecionada.getCellValueFactory().equals(true)){
        return param.getValue().setSeleciona(true);
    }else{
        return param.getValue().setSeleciona(false);
        }
        
    }   
});
        
      }
   
    public void datas(){
        for (int j = 0; j<tabelaSelecionaVendas.getItems().size(); j++){
        System.out.println(tabelaSelecionaVendas.getItems().get(j).getSeleciona() + "conteudo");    
        if (tabelaSelecionaVendas.getItems().get(j).getSeleciona() == false){
        int codigoVenda = (tabelaListaVendas.getItems().get(j).getCodigo());
        ArrayList<ModelVendasProdutos> listaRomaneio = new ArrayList<>();
        listaRomaneio = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
        for (int i=0; i<listaRomaneio.size(); i++){
            ModelVendasProdutos mvp = new ModelVendasProdutos();
            mvp.setCodigo_produto(listaRomaneio.get(i).getCodigo_produto());
            mvp.setNomeProduto(listaRomaneio.get(i).getNomeProduto());
            mvp.setQuantidade(listaRomaneio.get(i).getQuantidade());
                    }
        }
        }
    }
    
    public void lista(){
        if((pesquisaVendas.getText().equals(""))){
                listaTodos();
            }else{
               listaFiltro();
            }
    }
        
    private void listaTodos(){
      ModelSeleciona modelSeleciona = new ModelSeleciona();
      listaResultado.clear();
      tabelaListaVendas.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaSeleciona  = new ArrayList<>();
      listaModelVendas = controllerVendas.getListaPedidosEntregasController();
      classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 0; i < listaModelVendas.size(); i++) {
         listaResultado.add(listaModelVendas.get(i)); 
         tabelaSelecionaVendas.getItems().add(modelSeleciona);
        }
       listadeVendas = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeVendas);
       tabelaListaVendas.getItems().addAll(listadeVendas);
       classeInterfaces.avisaOuvintesProgresso("principal", Boolean.FALSE);         
     }
      
       };
         t.start();
        }
    
    private void listaFiltro(){
      listaResultado.clear();
      tabelaListaVendas.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelVendas = controllerVendas.getListaPedidosEntregasController();
        //final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final novoPrincipal principal = new novoPrincipal();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        //carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 1; i < listaModelVendas.size(); i++) {
            if (listaModelVendas.get(i).getPesquisa().contains(pesquisaVendas.getText().toUpperCase())){
                listaResultado.add(listaModelVendas.get(i)); 
                tabelaSelecionaVendas.getItems().add(modelSeleciona);
            }
        } 
       listadeVendas = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeVendas);
       tabelaListaVendas.getItems().addAll(listadeVendas);
       classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
        }
       };
        t.start();
        
    }
    
    private void listaStatus(){
      listaResultado.clear();
      tabelaListaVendas.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelVendas = controllerVendas.getListaPedidosEntregasController();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 1; i < listaModelVendas.size(); i++) {
            if (listaModelVendas.get(i).getTipo() == ((cbFiltro.getSelectionModel().getSelectedIndex())+2)){
                listaResultado.add(listaModelVendas.get(i)); 
                tabelaSelecionaVendas.getItems().add(modelSeleciona);
            }
        } 
       listadeVendas = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeVendas);
       tabelaListaVendas.getItems().addAll(listadeVendas);
       classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
        }
       };
        t.start();
        
    }
    public void setarStatusSaiuParaEntrega(){
        ArrayList<ModelVendas> entregasSelecionadas = new ArrayList();
        entregasSelecionadas.addAll(tabelaListaVendas.getSelectionModel().getSelectedItems());
        for (int i = 0; i< entregasSelecionadas.size(); i++){
            controllerVendas.mudarStatusEntregaController(entregasSelecionadas.get(i).getCodigo(), 3);
        }
        listaStatus();
    }
    public void setarStatusEntregaEfetuada(){
        ArrayList<ModelVendas> entregasSelecionadas = new ArrayList();
        entregasSelecionadas.addAll(tabelaListaVendas.getSelectionModel().getSelectedItems());
        for (int i = 0; i< entregasSelecionadas.size(); i++){
            controllerVendas.mudarStatusEntregaController(entregasSelecionadas.get(i).getCodigo(), 4);
        }
        listaStatus();
    }
    
    private void selecaoMultipla(){
    tabelaListaVendas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    public void excluirVenda(){
        int posicaoExcluir = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        codigoExcluir = tabelaListaVendas.getItems().get(posicaoExcluir).getCodigo();
        double valorAtual = controllerCaixa.retorarCaixaControler(1).getDinheiro();
        double valorVenda = controllerVendas.getVendasController(codigoExcluir).getValorTotal();
        valorAtualizar = valorAtual - valorVenda;
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("EXCLUIR VENDA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE EXCLUIR A VENDA "+ codigoExcluir +" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
        retirarVendadoCaixa();
        retonarProdutoEstoque(codigoExcluir);
               
        controllerVendas.excluirProdutoVendasController(codigoExcluir);
        tabelaListaVendas.getItems().remove(posicaoExcluir);
        controllerVendas.excluirVendasController(codigoExcluir);
        controllerVendasProdutos.excluirVendasProdutosCodVendaController(codigoExcluir);
                    }
                    });
        
    }
    
    public void relatorioSaidas(){
        Date datainicial = Date.valueOf(LocalDate.MIN);
        Date datafinal = Date.valueOf(LocalDate.MIN);;
       DAORelatorios dr = new DAORelatorios();
       BLMascaras blMascaras = new BLMascaras();
        try {
            datainicial = blMascaras.converterDataStringParaDate("15/01/2021");
            datafinal = blMascaras.converterDataStringParaDate("28/05/2021");
        } catch (Exception ex) {
            Logger.getLogger(listaEntregas.class.getName()).log(Level.SEVERE, null, ex);
        }
       dr.gerarRelatorioNfeSaidaPorData(datainicial, datafinal);
        
    }
    
    public void retirarVendadoCaixa(){
       ModelCaixa modelCaixa = new ModelCaixa();
       modelCaixa = controllerCaixa.verificarRetorarCaixaControler(1);
       
        modelCaixa.setDinheiro(valorAtualizar);
        modelCaixa.setCartao(modelCaixa.getCartao());
        modelCaixa.setCheque(modelCaixa.getCheque());
        modelCaixa.setConvenio(modelCaixa.getConvenio());
        
        controllerCaixa.atualizarCaixaController(modelCaixa);
       
    }
    
    public void retonarProdutoEstoque(int codigoVenda){
        ModelVendasProdutos mvpr = new ModelVendasProdutos();
        controllerVendasProdutos = new ControllerVendasProdutos();
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        listaProdutoRetornar = controllerVendasProdutos.getListaVendasProdutosController(codigoVenda);
        for (int i=0; i< listaProdutoRetornar.size(); i++){
            ModelProdutos modelProdutos = new ModelProdutos();
            modelProdutos.setAddEstoque(controllerProdutos.getProdutosController(listaProdutoRetornar.get(i).getCodigo()).getEstoque() + listaProdutoRetornar.get(i).getQuantidade());
            System.out.println(modelProdutos.getAddEstoque());
            controllerProdutos.atualizarProdutosEstoqueController(modelProdutos);
        }
    }
   
    
    public void reimprimirVenda(){
        int print = ManipularXML.lerXmlConfig().getQuantidadeImprimir();
        int posicaoImprimir = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        int codigoImprimir = tabelaListaVendas.getItems().get(posicaoImprimir).getCodigo();
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("REIMPRIMIR VENDA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE REIMPRIMIR A VENDA " + codigoImprimir+ " ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        
       final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
             
                try{
                    for(int i = 0; i < print;i++){
                if(ManipularXML.lerXmlConfig().getModeloImprimir()== 1){
                    controllerVendas.gerarRelatorioVenda(codigoImprimir);
                }else if(ManipularXML.lerXmlConfig().getModeloImprimir() == 2){
                    controllerVendas.gerarRelatorioVendaCupom(codigoImprimir);
                }        }
                }catch(Exception e)
                        { System.out.println(e);
                    
                }
                
                carregando.dispose();
            }
       };
        t.start();
                }
        else{
    }
    }); 
        
    }
    
    public void selecionarVenda() throws IOException{
        int posicaoAbrir = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        int codigoAbrir = tabelaListaVendas.getItems().get(posicaoAbrir).getCodigo();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pedidoVenda.fxml"));
        Parent raizVenda = (Parent) loader.load();
        pedidoVenda pedido = loader.getController();
        pedido.abrirVenda(codigoAbrir);
        fecharSaida();
        Stage vendaStage = new Stage();
        vendaStage.setScene(new Scene(raizVenda));
        vendaStage.show();
        fecharSaida();
        
        
        
    }
    public void fecharSaida(){
          Stage estagioListaVendas = (Stage) btEditarVenda.getScene().getWindow();
          estagioListaVendas.close();
          }
    

}
    

