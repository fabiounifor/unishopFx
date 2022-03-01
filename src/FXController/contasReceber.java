/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCaixa;
import controller.ControllerCliente;
import controller.ControllerContaReceber;
import controller.ControllerFormaPagamento;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import org.controlsfx.control.textfield.TextFields;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelCaixa;
import model.ModelCliente;
import model.ModelContaReceber;
import model.ModelFormaPagamento;
import model.ModelSessaoUsuario;
import unishop.Unishop;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class contasReceber extends Application implements Initializable{
    @FXML TextField pesquisaContasReceber;  
    @FXML TableView <ModelContaReceber> tabelaListaContasReceber;  
    @FXML TableColumn<ModelContaReceber, String> contaReceber;
    @FXML Button btPesquisarContReceber;  
    @FXML ChoiceBox chEscolha;
    @FXML DatePicker dtInicio;
    @FXML DatePicker dtFim;
    @FXML private Button btSair;
    ObservableList<ModelContaReceber> listadeContasReceber;
    int codCliente = 0;
    int numeroCaixa = 1;
    double retira = 0;
    double atual = 0;
    int codigo = 0; 
    
    
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ModelContaReceber modelContaReceber = new ModelContaReceber();
    ControllerCliente controllerCliente = new ControllerCliente();
    ArrayList<ModelContaReceber> listaModelConta = new ArrayList<>();
    ArrayList<ModelContaReceber> listaModelContaReceber = new ArrayList<>();
    ControllerContaReceber controllerContaReceber = new ControllerContaReceber();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
    ArrayList<String> listaClientes = new ArrayList<>();
    ArrayList<ModelContaReceber> listaResultado = new ArrayList<>();
    ModelCliente modelCliente = new ModelCliente();
    String tipoCadastro;
    BLMascaras bLMascaras = new BLMascaras();      
    int status = 0;
    
    
    @Override
    public void start(Stage listaContasReceber) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqContasReceber.fxml")); 
        Parent raiz = loader.load();   
        listaContasReceber.setScene(new Scene(raiz));
        listaContasReceber.initStyle(StageStyle.UNDECORATED);
        listaContasReceber.initModality(Modality.APPLICATION_MODAL);
        listaContasReceber.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     criarListaClientes();
     iniciaEscolha();
     contaReceber.setCellValueFactory(new PropertyValueFactory<>("pesquisaReceber")); 
     TextFields.bindAutoCompletion(pesquisaContasReceber,listaClientes );
     
            
    
    }
    public void criarListaClientes(){
        listaModelClientes = controllerCliente.getListaClienteController();
        
        for (int i = 0; i < listaModelClientes.size(); i++) {
            listaClientes.add(listaModelClientes.get(i).getNome());
        }
    }
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void listaContasGeralReceber() throws Exception{
        status = chEscolha.getSelectionModel().getSelectedIndex();
        SimpleDateFormat formato; 
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        if (dtInicio == null){
            dtInicio.setValue(LocalDate.MIN);
        }
        if (dtFim == null){
            dtFim.setValue(LocalDate.MAX);
        }
        tabelaListaContasReceber.getItems().clear();
        listaModelConta.clear();
        listaResultado  = new ArrayList<>();
        listaModelConta = controllerContaReceber.getListaContaReceberController(status);
        codCliente = controllerCliente.getClienteController(pesquisaContasReceber.getText()).getCodigo();
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelConta.size();
        
       
         
        for (int i = 0; i < cont; i++) {
            if (codCliente != 0){
            if((listaModelConta.get(i).getCodigoPessoa()) == codCliente){
                
                ModelContaReceber mcr = new ModelContaReceber();            
                mcr.setCodigo(listaModelConta.get(i).getCodigo());
                mcr.setDescricao(listaModelConta.get(i).getDescricao());
                mcr.setCodigoPessoa(listaModelConta.get(i).getCodigoPessoa());
                mcr.setValor(listaModelConta.get(i).getValor());
                mcr.setVencimento(listaModelConta.get(i).getVencimento());
                //mcr.setSituacao(listaModelConta.get(i).getSituacao());
                listaResultado.add(mcr);
                
                if (dtFim.getValue() != null && dtInicio.getValue() != null){
                int contj = listaResultado.size();
                for (int j = 0 ; j < contj; j++ ){
                              if((listaResultado.get(j).getVencimento()).before(bLMascaras.converterDataStringDataHifen(dtInicio.getValue().format(DateTimeFormatter.ISO_DATE))) 
                              || (listaResultado.get(j).getVencimento()).after(bLMascaras.converterDataStringDataHifen(dtFim.getValue().format(DateTimeFormatter.ISO_DATE)))){
                                                               
                                    ModelContaReceber mcrj = new ModelContaReceber();            
                                    mcrj.setCodigo(listaResultado.get(j).getCodigo());
                                    mcrj.setDescricao(listaResultado.get(j).getDescricao());
                                    mcrj.setCodigoPessoa(listaResultado.get(j).getCodigoPessoa());
                                    mcrj.setValor(listaResultado.get(j).getValor());
                                    mcrj.setVencimento(listaResultado.get(j).getVencimento());
                                    listaResultado.remove(j);
                                    }
                                    }
                        }
                 
                }
                
                }else{
                    ModelContaReceber mcr = new ModelContaReceber(); 
                    mcr.setCodigo(listaModelConta.get(i).getCodigo());
                    mcr.setDescricao(listaModelConta.get(i).getDescricao());
                    mcr.setCodigoPessoa(listaModelConta.get(i).getCodigoPessoa());
                    mcr.setValor(listaModelConta.get(i).getValor());
                    mcr.setVencimento(listaModelConta.get(i).getVencimento());
                    listaResultado.add(mcr);
                        if (dtFim.getValue() != null && dtInicio.getValue() != null){

                        int contj = listaResultado.size();
                        
                            for (int j = 0 ; j < contj; j++ ){
                               
                              if((listaResultado.get(j).getVencimento()).before(bLMascaras.converterDataStringDataHifen(dtInicio.getValue().format(DateTimeFormatter.ISO_DATE)))  
                              || (listaResultado.get(j).getVencimento()).after(bLMascaras.converterDataStringDataHifen(dtFim.getValue().format(DateTimeFormatter.ISO_DATE)))) { 
                                  
                                  ModelContaReceber mcrj = new ModelContaReceber();            
                                    mcrj.setCodigo(listaResultado.get(j).getCodigo());
                                    mcrj.setDescricao(listaResultado.get(j).getDescricao());
                                    mcrj.setCodigoPessoa(listaResultado.get(j).getCodigoPessoa());
                                    mcrj.setValor(listaResultado.get(j).getValor());
                                    mcrj.setVencimento(listaResultado.get(j).getVencimento());
                                    listaResultado.remove(j);
                                    
                                    }
                                    }
                }
                }
                }

       listadeContasReceber = FXCollections.observableArrayList(listaResultado);
       tabelaListaContasReceber.getItems().addAll(listadeContasReceber);
       
        }
    
    public void listaContasfiltroReceber(){
        status = chEscolha.getSelectionModel().getSelectedIndex();
        listaModelContaReceber.clear();
    if ((codCliente > 0) ){
       codCliente = controllerCliente.getClienteController(pesquisaContasReceber.getText()).getCodigo();
            
    if((dtFim.getValue() != null) && (dtInicio.getValue() != null)) {
                
}
}
}
    
    public void novaContaReceber() throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/contaReceber.fxml"));
        Parent raizcontaReceber = (Parent) loader.load();
        contaReceber cr = loader.getController();
        Stage crStage = new Stage();
        crStage.setScene(new Scene(raizcontaReceber));
        crStage.show();
        
    }
    public void receberConta() throws Exception{
         ModelCaixa modelCaixa = new ModelCaixa();
         modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
         if (modelCaixa.getCaixaNumero() == 1 && modelCaixa.getStatus() == 1){
        final int codigoConta = tabelaListaContasReceber.getSelectionModel().getSelectedItem().getCodigo();;
        int codigo = 0; 
        codigo = tabelaListaContasReceber.getSelectionModel().getSelectedItem().getCodigo();
        
        if (codigo  == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("É NECESSÁRIO SELECIONAR UMA CONTA");
                                alert.show(); 
            
        }else{
             modelContaReceber = new ModelContaReceber();
        try {
            codigo = tabelaListaContasReceber.getSelectionModel().getSelectedItem().getCodigo();
            
            modelContaReceber.setCodigo(codigo);
            modelContaReceber.setSituacao(1);
            modelContaReceber.setPagamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            //pegunta
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("RECEBER CONTA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE RECEBER ESSA CONTA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                         if (controllerContaReceber.receberContaReceberController(modelContaReceber)) {
                             ModelCaixa mc = new ModelCaixa();
                             mc = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
                             float valorRecebido = (controllerContaReceber.getContaReceberController(codigoConta).getValor());
                             mc.setDinheiro(valorRecebido);
                             mc.setCaixaNumero(getNumeroCaixa());
                             mc.setCartao(Double.parseDouble("0.00"));
                             mc.setCheque(Double.parseDouble("0.00"));
                             mc.setConvenio(Double.parseDouble("0.00"));
                             mc.setCodigoUsuario(ModelSessaoUsuario.codigo);
                             mc.setStatus(1);
                            controllerCaixa.atualizarCaixaController(mc);
                             
                             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Informação");
                                alert.setContentText("CONTA RECEBIDA, ESSE VALOR SERÁ ADICIONADO AO CAIXA DE HOJE");
                                alert.show(); 
                             try {
                                 listaContasGeralReceber();
                             } catch (Exception ex) {
                                 Logger.getLogger(contasReceber.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                    }
                                });

           
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("A ACONTA NÃO FOI CONTA PAGA!!");
                                alert.show(); 
                                 listaContasGeralReceber();
        }
        }}else{
             Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("CAIXA FECHADO");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("O CAIXA AINDA NÃO FOI ABERTO, DESEJA ABRIR O CAIXA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        fecharContasReceber();
                        controleCaixa cx = new controleCaixa();
                    try {
                        cx.start(new Stage());
                    } catch (Exception ex) {
                        Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (b == btnNao) { 
                        fecharContasReceber();
                    }
                                }
                    
                     });
         
         }  
        }
    
    public void abrirContaReceber() throws IOException{
        int codigo = 0; 
        codigo = tabelaListaContasReceber.getSelectionModel().getSelectedItem().getCodigo();
        if (codigo  == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("É NECESSÁRIO SELECIONAR UMA CONTA");
                                alert.show(); 
            
        }else{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/contaReceber.fxml"));
        Parent raizcontaPagar = (Parent) loader.load();
        contaReceber crEditar = loader.getController();
        Stage crEditarStage = new Stage();
        crEditar.recuperarConta(codigo);
        crEditarStage.setScene(new Scene(raizcontaPagar));
        crEditarStage.show();
        }
        }
    public void iniciaEscolha(){
       chEscolha.getItems().addAll("NÃO PAGO", "PAGO");
    }
    
    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    /**
     * @param numeroCaixa the numeroCaixa to set
     */
    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }
    public void fecharContasReceber(){
          Stage estagioContasPagar = (Stage) btPesquisarContReceber.getScene().getWindow();
          estagioContasPagar.close();
        
                }
    public void imprimirEstaConta(){
        int codigoConta = tabelaListaContasReceber.getSelectionModel().getSelectedItem().getCodigo();
        if (codigoConta == 0){
        Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("NENHUMA CONTA SELECIONADA");
                                alert.show(); 
                 try {
                     listaContasGeralReceber();
                 } catch (Exception ex) {
                     Logger.getLogger(contasPagar.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
       }else{
        
       controllerContaReceber.gerarRelatorioContaReceber(codigoConta);
        
    }
    }
    
    public void gerarRelatorioContasReceber(){
       
        Date inicioRelatorio = null, fimRelatorio = null;
        try {
            inicioRelatorio = (bLMascaras.converterDataStringDataHifen(dtInicio.getValue().format(DateTimeFormatter.ISO_DATE)));
            fimRelatorio = (bLMascaras.converterDataStringDataHifen(dtFim.getValue().format(DateTimeFormatter.ISO_DATE)));
          
                    } catch (Exception ex) {
            Logger.getLogger(contasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }

       if (inicioRelatorio == null || fimRelatorio == null){
              Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("NÃO FORAM PREENCHIDAS AS DATAS");
                                alert.show(); 
       }else if(codCliente == 0){
              Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("NÃO FOI SELECIONADO CLIENTE");
                                alert.show(); 
       }else{
           controllerContaReceber.gerarRelatorioContasReceberCliente(codCliente, status, inicioRelatorio, fimRelatorio);
       }
       
       
   }
    
    }

        
        
    
    

