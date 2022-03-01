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
import nfe.controller.ControllerNF;
import nfe.controller.ControllerNFCe;
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
import util.AguardeGerandoRelatorio;
import interfaces.classeInterfaces;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.StageStyle;
import util.ManipularXML;
import relatorios.DAORelatorios;
import util.BLMascaras;
import com.acbr.nfe.ACBrNFe;
import controller.ControllerConfiguracao;
import controller.ControllerEmpresa;
import java.util.Collections;
import javafx.stage.Modality;
import model.ModelConfig;
import model.ModelVendasProdutosTabela;
import nfe.model.ModelNF;
import relatorios.DAORelatorios;

/**
 *
 * @author Fabio
 */
public class listaVendas extends Application implements Initializable{
    
    @FXML TextField pesquisaVendas;
    @FXML Button btPesquisarVendas;
    @FXML Button btEditarVenda;
    @FXML Button btExcluirVenda;
    @FXML Button btImprimirVenda;
    @FXML Button btDevolucaoNfe;
    @FXML private Button btSair;
    @FXML TableView <ModelVendas> tabelaListaVendas = new TableView();;
    @FXML TableColumn<ModelVendas, String> linhaVendas;
    ArrayList<ModelVendas> listaResultado  = new ArrayList<>();
    public ArrayList<ModelVendas> listaTabelaVendas ;
    public ArrayList<ModelVendasProdutos> listaProdutoRetornar ;
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ObservableList<ModelVendas> listadeVendas;
    private ControllerNF controllerNF = new ControllerNF();
    private ControllerNFCe controllerNFCe = new ControllerNFCe();
    private ACBrNFe acbrNFe;
    double valorAtualizar = 0;
    int codigoExcluir;
    int origemOp = 0;
    
   
    
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    DAORelatorios dAORelatorios = new DAORelatorios();
    BLMascaras bLMascaras = new BLMascaras();
    
    BLMascaras BlMascaras = new BLMascaras();
    
    @Override
    public void start(Stage listaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqVendas.fxml")); 
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
           
            
            linhaVendas.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));  
            
            pesquisaVendas.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode()== KeyCode.ENTER){
            if((pesquisaVendas.getText().equals(""))){
                listaTodos();
            }else{
               listaFiltro();
            }
       }
        if(e.getCode()== KeyCode.F12){
            try {
                dAORelatorios.gerarRelatorioVendaTodosCliente(bLMascaras.converterDataStringData(bLMascaras.retornarData()), bLMascaras.converterDataStringData(bLMascaras.retornarData()));
            } catch (Exception ex) {
                Logger.getLogger(listaVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       });
            tabelaListaVendas.setOnKeyPressed((KeyEvent e)->{
                if(e.getCode()== KeyCode.ENTER){
                try {
                    selecionarVenda();
                } catch (IOException ex) {
                    Logger.getLogger(listaVendas.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            });
    }
    
  /*  public void gerarNfeTabela(){
        int posicaovenda = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        int codigoVenda = tabelaListaVendas.getItems().get(posicaovenda).getCodigo();
        ArrayList<String> tipoPagamento = new ArrayList<>();
        tipoPagamento.add(String.valueOf(tabelaListaVendas.getItems().get(posicaovenda).getTipoPagamento()));
        Float valorTotal = controllerVendas.getVendasClienteController(codigoVenda).getValorTotal();
        Float valorDesconto = controllerVendas.getVendasClienteController(codigoVenda).getDesconto();
        Float valorTroco = 0.0f;
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // gerar nfe
                try{
                    if(controllerVendas.getVendasController(codigoVenda).getClientesCodigo() == 0){
                        pdv Pdv = new pdv();
                      Pdv.gerarNfce(codigoVenda, valorTotal, tipoPagamento, valorTroco, valorDesconto);
                    }else{
                    nfeSaida nfs = new nfeSaida();
                    nfs.transmitirNfe(codigoVenda, valorTotal);
                    }
                    
                }catch(Exception e)
                        { System.out.println(e);
                    
                }
                
                carregando.dispose();
            }
       };
        t.start();
                }*/
    
    
    
    public void cancelarVendaSelecionada(){
        int posicaoCancelar;
        int numeroNfeCancelar;
        int pedidoNfceCancelar;
        String chave;
        String cnpj;
        String motivo = "documento emitido em desconformidade com a operacao realizada";
        ArrayList<ModelVendasProdutos> listaModelProdutosCancelar = new ArrayList();
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
        posicaoCancelar = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        pedidoNfceCancelar = tabelaListaVendas.getItems().get(posicaoCancelar).getCodigo();
        numeroNfeCancelar = Integer.parseInt(controllerNF.getNFVendaController(pedidoNfceCancelar).getNumeroNfe());
        listaModelProdutosCancelar = controllerVendasProdutos.getListaVendasProdutosController(numeroNfeCancelar);
        chave = controllerNF.getNFVendaController(pedidoNfceCancelar).getChaveNfe();
        cnpj = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
                        
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim");
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("CANCELAR VENDA");
                dialogoExe.setContentText("DESEJA CANCELAR A VENDA: " + numeroNfeCancelar + "DA VENDA:"+pedidoNfceCancelar+" ?");
                dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) {
                        try {
                            acbrNFe = new ACBrNFe();
                            acbrNFe.cancelar(chave, motivo, cnpj);
                            atualizarNFECancelada(pedidoNfceCancelar);
                            controllerVendasProdutos.excluirVendasProdutosCodVendaController(pedidoNfceCancelar);
                            } catch (Exception ex) {
                            Logger.getLogger(pdv.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("CONFIRMAÇÃO");
                        alert.setContentText("A NOTA FISCAL NUMERO: "+numeroNfeCancelar+" FOI CANCELADA COM SUCESSO\n");
                        alert.show();
                }
        else{
    }
        });    
   
    }
    
    
    public void atualizarNFECancelada(int codigoVenda){
        int codigoCancelamento = 101;
        controllerNF.atualizarNFCanceladaController("CANCELADA",String.valueOf(codigoVenda), codigoCancelamento);
    }
    
    public void atualizarNFCECancelada(int codigoVenda){
        int codigoCancelamento = 101;
        controllerNF.atualizarNFCanceladaController("CANCELADA",String.valueOf(codigoVenda), codigoCancelamento);
    }
     private ArrayList inverterLista(ArrayList<ModelVendasProdutosTabela> lista){
         ArrayList<ModelVendasProdutosTabela> inverso = new ArrayList();
         
         for(int i  = lista.size(); i >= 0 ; i-- ){
             inverso.add(lista.get(i));
         }
                 
         return inverso;
     }
     
     public void devolucaoNfe() throws IOException{
        int posicaoDevolver;
        int pedidoNfeDevolver;
         posicaoDevolver = tabelaListaVendas.getSelectionModel().getFocusedIndex();
         pedidoNfeDevolver = tabelaListaVendas.getItems().get(posicaoDevolver).getCodigo();
         
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
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void lista(){
        if((pesquisaVendas.getText().equals(""))){
                listaTodos();
            }else{
               listaFiltro();
            }
    }
    public void listaTodos(){
      listaResultado.clear();
      tabelaListaVendas.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelVendas = controllerVendas.getListaPedidosController();
        final novoPrincipal principal = new novoPrincipal();
    classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);         
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 0; i < listaModelVendas.size(); i++) {
            listaResultado.add(listaModelVendas.get(i)); 
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
      listaModelVendas = controllerVendas.getListaPedidosController();
        final novoPrincipal principal = new novoPrincipal();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 1; i < listaModelVendas.size(); i++) {
            if (listaModelVendas.get(i).getPesquisa().contains(pesquisaVendas.getText().toUpperCase())){
             listaResultado.add(listaModelVendas.get(i)); 
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
    
    public void listaFiltroPreVendas(){
      listaResultado.clear();
      tabelaListaVendas.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelVendas = controllerVendas.getListaPedidosController();
        final novoPrincipal principal = new novoPrincipal();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 1; i < listaModelVendas.size(); i++) {
            if (listaModelVendas.get(i).getTipo() == 2) {
             listaResultado.add(listaModelVendas.get(i)); 
            }
        } 
       listadeVendas = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeVendas);
       tabelaListaVendas.getItems().addAll(listadeVendas);
       tabelaListaVendas.getSelectionModel().select(0);
       classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
        }
       };
        t.start();
        
    }
    
    public void listaFiltroMesas(){
      listaResultado.clear();
      tabelaListaVendas.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelVendas = controllerVendas.getListaPedidosController();
        final novoPrincipal principal = new novoPrincipal();
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
        for (int i = 1; i < listaModelVendas.size(); i++) {
            if (listaModelVendas.get(i).getTipo() == 1) {
             listaResultado.add(listaModelVendas.get(i)); 
            }
        } 
       listadeVendas = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeVendas);
       tabelaListaVendas.getItems().addAll(listadeVendas);
       tabelaListaVendas.getSelectionModel().select(0);
       classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
        }
       };
        t.start();
        
    }
    public int procuraRetorno(String retorno, String procura ){
        int indice = 0;
        if(retorno.contains(procura)){
            indice  = retorno.indexOf(procura);
        }
        return indice;
    }
         
    public void reimprimirNFe() throws Exception{
       ACBrNFe acbrNFe = new ACBrNFe();
       String ret = "";    
       int nfeEscolhida = tabelaListaVendas.getSelectionModel().getFocusedIndex();
       int codigoVendaretorno  = tabelaListaVendas.getItems().get(nfeEscolhida).getCodigo();
       int tipoVenda  = tabelaListaVendas.getItems().get(nfeEscolhida).getTipo();
       String data = String.valueOf(controllerNF.getNFVendaController(codigoVendaretorno).getDataEmissao());
       String chaveNF = controllerNF.getNFVendaController(codigoVendaretorno).getChaveNfe();
       if (tipoVenda == 55){
         
           String caminho = "C:\\UniShop\\dfe\\"+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\Enviado\\Nfe\\"
                   + ((data).substring(0, 4)) + ((data).substring(5, 7))+
                   "\\"+chaveNF + "-nfe.xml";
           System.out.println("caminho " + caminho);  
       acbrNFe.carregarXml(caminho);
       ret = acbrNFe.toString();
       String protocolo = "NProt=";
       int inicioProtocolo = (procuraRetorno(ret,protocolo)+protocolo.length());
       acbrNFe.imprimir("impressora", 1,(ret.substring(inicioProtocolo,(inicioProtocolo + 15))) , true, true, true, false);       
        }
       else if (tipoVenda == 65){
       
       String caminho = "C:\\UniShop\\dfe\\"+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\Enviado\\Nfce\\"
                   +((data).substring(0, 4)) + ((data).substring(5, 7))+
                   "\\"+chaveNF + "-nfe.xml";
       acbrNFe.carregarXml(caminho);
       ret = acbrNFe.toString();
       String protocolo = "NProt=";
       int inicioProtocolo = (procuraRetorno(ret,protocolo)+protocolo.length());
       acbrNFe.imprimir("impressora", 1,(ret.substring(inicioProtocolo,(inicioProtocolo + 15))) , true, true, true, false);       
   }
}
    
    public void excluirVenda( int codigoexcluir){
        int posicaoExcluir = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        codigoExcluir = tabelaListaVendas.getItems().get(posicaoExcluir).getCodigo();
        double valorAtual = controllerCaixa.retorarCaixaControler(1).getDinheiro();
        double valorVenda = controllerVendas.getVendasController(codigoexcluir).getValorTotal();
        valorAtualizar = valorAtual - valorVenda;
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("EXCLUIR VENDA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE EXCLUIR A VENDA "+ codigoexcluir +" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
        retirarVendadoCaixa();
        retonarProdutoEstoque(codigoexcluir);
               
        controllerVendas.excluirProdutoVendasController(codigoexcluir);
        tabelaListaVendas.getItems().remove(posicaoExcluir);
        controllerVendas.excluirVendasController(codigoexcluir);
        controllerVendasProdutos.excluirVendasProdutosCodVendaController(codigoexcluir);
                    }
                    });
        
    }
    
    public void relatorioSaidas(){
        Date datainicial = Date.valueOf(LocalDate.MIN);
        Date datafinal = Date.valueOf(LocalDate.MIN);;
       DAORelatorios dr = new DAORelatorios();
       BLMascaras blMascaras = new BLMascaras();
        try {
            datainicial = blMascaras.converterDataStringParaDate("01/07/2021");
            datafinal = blMascaras.converterDataStringParaDate("31/07/2021");
        } catch (Exception ex) {
            Logger.getLogger(listaVendas.class.getName()).log(Level.SEVERE, null, ex);
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
   
    
    public void reimprimirVenda() throws Exception{
        ControllerConfiguracao controllerConfiguracao = new ControllerConfiguracao();
        int print = controllerConfiguracao.getConfiguracaoController(1).getQuantidadeImpressao();
        int posicaoImprimir = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        int codigoImprimir = tabelaListaVendas.getItems().get(posicaoImprimir).getCodigo();
        if (!((controllerVendas.getVendasController(codigoImprimir).getTipo() == 65)||(controllerVendas.getVendasController(codigoImprimir).getTipo() == 55))){
            if (controllerNF.getNFVendaController(codigoImprimir).getPedido() == 0){
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
                if(controllerConfiguracao.getConfiguracaoController(1).getModeloImpresssao() == 1){
                    controllerVendas.gerarRelatorioVenda(codigoImprimir);
                }else if(controllerConfiguracao.getConfiguracaoController(1).getModeloImpresssao() == 2){
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
                        try {
                            reimprimirNFe();
                        } catch (Exception ex) {
                            Logger.getLogger(listaVendas.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    }); 
            }else{
             
            }    
    }else{
            reimprimirNFe();
        }
    }
    
    public void selecionarVenda() throws IOException{
        int seleciona = 0;
        int posicaoAbrir = tabelaListaVendas.getSelectionModel().getFocusedIndex();
        int codigoAbrir = tabelaListaVendas.getItems().get(posicaoAbrir).getCodigo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pedidoVenda.fxml"));
        Parent raizVenda = (Parent) loader.load();
        FXMLLoader loaderNfe = new FXMLLoader(getClass().getResource("/FXView/nfeSaida.fxml"));
        Parent raizNfe = (Parent) loaderNfe.load();
        System.out.println(origemOp +" ORIGEM OPERACAO");
        if (origemOp == 0){
        if (controllerVendas.getVendasController(codigoAbrir).getTipo() == 55){
            if (controllerNF.getNFVendaController(codigoAbrir).getPedido() == 0){
            seleciona = 1;
            ControllerNF controllerNF = new ControllerNF();
            nfeSaida nfe = loaderNfe.getController();
            nfe.abrirVenda(codigoAbrir);
            }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("NÃO É POSSÍVEL ALTERAR UMA NFE TRANSMITIDA");
            alert.show();
            }
        
        }else if (controllerVendas.getVendasController(codigoAbrir).getTipo() == 65){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setContentText("NÃO É POSSÍVEL ALTERAR UMA NFCE");
            alert.show();
        }else{
        
        }
        if (seleciona == 0){
        Stage vendaStage = new Stage();
        vendaStage.setScene(new Scene(raizVenda));
        vendaStage.show();
        fecharSaida();
        } else if (seleciona == 1){
        Stage vendaStage = new Stage();
        vendaStage.setScene(new Scene(raizNfe));
        vendaStage.show();
        fecharSaida();
        }
        }else{
              classeInterfaces.avisaOuvintesCodigoVenda("pdv",codigoAbrir);
              fecharSaida();
            
        }
  
    }
    public void fecharSaida(){
          Stage estagioListaVendas = (Stage) btEditarVenda.getScene().getWindow();
          estagioListaVendas.close();
          }
    

}
    

