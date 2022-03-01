/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCaixa;
import controller.ControllerContaPagar;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import model.ModelContaPagar;
import model.ModelFormaPagamento;
import model.ModelFornecedor;
import unishop.Unishop;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class contasPagar extends Application implements Initializable{
    @FXML TextField pesquisaContasPagar;  
    @FXML TableView <ModelContaPagar> tabelaListaContasPagar;  
    @FXML TableColumn<ModelContaPagar, String> contaPagar;
    @FXML Button btPesquisarContPagar;  
    @FXML ChoiceBox chEscolha;
    @FXML DatePicker dtInicio;
    @FXML DatePicker dtFim;
    @FXML private Button btSair;
    
    ObservableList<ModelContaPagar> listadeContasPagar;
    
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ModelContaPagar modelContaPagar = new ModelContaPagar();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerFornecedor controllerFonecedor = new ControllerFornecedor();
    ArrayList<ModelContaPagar> listaModelContaPagar = new ArrayList<>();
    ArrayList<ModelContaPagar> listaResultado = new ArrayList<>();
    ArrayList<ModelContaPagar> listaResultadoEntreDatas = new ArrayList<>();    
    ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ArrayList<ModelFornecedor> listaModelForneceres = new ArrayList<>();
    ArrayList<String> listaFornecedores = new ArrayList<>();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    String tipoCadastro;
    BLMascaras bLMascaras = new BLMascaras();  
    int status = 0;
    int codFornecedor = 0;
    int numeroCaixa = 1;
    double retira = 0;
    double atual = 0;
    int codigo = 0; 
    

   
    
    
    @Override
    public void start(Stage listaContasReceber) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqContasPagar.fxml")); 
        Parent raiz = loader.load();   
        listaContasReceber.setScene(new Scene(raiz));
        listaContasReceber.setTitle("CONTAS PAGAR");
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
     criarListaFornecedor();
     iniciaEscolha();
     contaPagar.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));        
     TextFields.bindAutoCompletion(pesquisaContasPagar,listaFornecedores );       
    
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
     public void criarListaFornecedor(){
        listaModelForneceres = controllerFonecedor.getListaFornecedorController();
        
        for (int i = 0; i < listaModelForneceres.size(); i++) {
            listaFornecedores.add(listaModelForneceres.get(i).getNome());
        }
    }
     
    public void listaContasGeralPagar() throws Exception {
        status = chEscolha.getSelectionModel().getSelectedIndex();
        SimpleDateFormat formato; 
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        if (dtInicio == null){
            dtInicio.setValue(LocalDate.MIN);
        }
        if (dtFim == null){
            dtFim.setValue(LocalDate.MAX);
        }
               
        tabelaListaContasPagar.getItems().clear();
        listaResultado.clear();
        listaResultado  = new ArrayList<>();
        listaModelContaPagar = controllerContaPagar.getListaContaPagarController(status);
        codFornecedor = controllerFonecedor.getFornecedorController(pesquisaContasPagar.getText()).getCodigo();
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelContaPagar.size();
               
                for (int i = 0; i < cont; i++) {
                if (codFornecedor != 0){
                if(((listaModelContaPagar.get(i).getCodigoPessoa()) == codFornecedor) ){                
                
                    ModelContaPagar mcp = new ModelContaPagar(); 
                    mcp.setCodigo(listaModelContaPagar.get(i).getCodigo());
                    mcp.setDescricao(listaModelContaPagar.get(i).getDescricao());
                    mcp.setCodigoPessoa(listaModelContaPagar.get(i).getCodigoPessoa());
                    mcp.setValor(listaModelContaPagar.get(i).getValor());
                    mcp.setVencimento(listaModelContaPagar.get(i).getVencimento());
                    listaResultado.add(mcp);
                    if (dtFim.getValue() != null && dtInicio.getValue() != null){
                    int contj = listaResultado.size();
                    for (int j = 0 ; j < contj; j++ ){
                              if((listaResultado.get(j).getVencimento()).before(bLMascaras.converterDataStringDataHifen(dtInicio.getValue().format(DateTimeFormatter.ISO_DATE))) 
                              || (listaResultado.get(j).getVencimento()).after(bLMascaras.converterDataStringDataHifen(dtFim.getValue().format(DateTimeFormatter.ISO_DATE)))){
                                                               
                                    ModelContaPagar mcpj = new ModelContaPagar();            
                                    mcpj.setCodigo(listaResultado.get(j).getCodigo());
                                    mcpj.setDescricao(listaResultado.get(j).getDescricao());
                                    mcpj.setCodigoPessoa(listaResultado.get(j).getCodigoPessoa());
                                    mcpj.setValor(listaResultado.get(j).getValor());
                                    mcpj.setVencimento(listaResultado.get(j).getVencimento());
                                    listaResultado.remove(j);
                                    }
                                    }
                        }
                 
                }
                
                }else{
                    ModelContaPagar mcp = new ModelContaPagar(); 
                    mcp.setCodigo(listaModelContaPagar.get(i).getCodigo());
                    mcp.setDescricao(listaModelContaPagar.get(i).getDescricao());
                    mcp.setCodigoPessoa(listaModelContaPagar.get(i).getCodigoPessoa());
                    mcp.setValor(listaModelContaPagar.get(i).getValor());
                    mcp.setVencimento(listaModelContaPagar.get(i).getVencimento());
                    listaResultado.add(mcp);
                        if (dtFim.getValue() != null && dtInicio.getValue() != null){

                        int contj = listaResultado.size();
                        
                            for (int j = 0 ; j < contj; j++ ){
                               
                              if((listaResultado.get(j).getVencimento()).before(bLMascaras.converterDataStringDataHifen(dtInicio.getValue().format(DateTimeFormatter.ISO_DATE)))  
                              || (listaResultado.get(j).getVencimento()).after(bLMascaras.converterDataStringDataHifen(dtFim.getValue().format(DateTimeFormatter.ISO_DATE)))) { 
                                  
                                  ModelContaPagar mcpj = new ModelContaPagar();            
                                    mcpj.setCodigo(listaResultado.get(j).getCodigo());
                                    mcpj.setDescricao(listaResultado.get(j).getDescricao());
                                    mcpj.setCodigoPessoa(listaResultado.get(j).getCodigoPessoa());
                                    mcpj.setValor(listaResultado.get(j).getValor());
                                    mcpj.setVencimento(listaResultado.get(j).getVencimento());
                                    listaResultado.remove(j);
                                    
                                    }
                                    }
                }
                }
                }

       listadeContasPagar = FXCollections.observableArrayList(listaResultado);
       tabelaListaContasPagar.getItems().addAll(listadeContasPagar);
       
        }
                
    
    public void listaContasfiltroPagar(){
        status = chEscolha.getSelectionModel().getSelectedIndex();
        listaModelContaPagar.clear();
    if ((codFornecedor > 0) ){
       codFornecedor = controllerFonecedor.getFornecedorController(pesquisaContasPagar.getText()).getCodigo();
            
    if((dtFim.getValue() != null) && (dtInicio.getValue() != null)) {
                
}
}
}
    
    public void novaContaPagar() throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/contaPagar.fxml"));
        Parent raizcontaPagar = (Parent) loader.load();
        contaPagar cp = loader.getController();
        Stage cpStage = new Stage();
        cpStage.setScene(new Scene(raizcontaPagar));
        cpStage.show();
        
    }
    
     public void novoFornecedor(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroPJuridica.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        FXViewCliente nCliente = loader.getController();
        nCliente.iniciarFornecedor();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(novaRaiz));
        stage.show();
        
    }
     public void pagarConta(){
         ModelCaixa modelCaixa = new ModelCaixa();
         modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
         if (modelCaixa.getCaixaNumero() == 1 && modelCaixa.getStatus() == 1){
         
        codigo = tabelaListaContasPagar.getSelectionModel().getSelectedItem().getCodigo();
        if (codigo  == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("É NECESSÁRIO SELECIONAR UMA CONTA");
                                alert.show(); 
            
        }else{
             modelContaPagar = new ModelContaPagar();
        try {
            codigo = tabelaListaContasPagar.getSelectionModel().getSelectedItem().getCodigo();
            
            modelContaPagar.setCodigo(codigo);
            modelContaPagar.setSituacao(1);
            modelContaPagar.setPagamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            //pegunta
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("PAGAR CONTA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE PAGAR ESSA CONTA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                         if (controllerContaPagar.pagarContaPagarController(modelContaPagar)) {
                                atualizarCaixa();
                                                       
                             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Informação");
                                alert.setContentText("CONTA PAGA, ESSE VALOR FOI RETIRADO DO CAIXA DE HOJE");
                                alert.show(); 
                             try {
                                 listaContasGeralPagar();
                             } catch (Exception ex) {
                                 Logger.getLogger(contasPagar.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                    }
                                });
                
           
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("A ACONTA NÃO FOI CONTA PAGA!!");
                                alert.show(); 
                 try {
                     listaContasGeralPagar();
                 } catch (Exception ex) {
                     Logger.getLogger(contasPagar.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
        } 
         }else{
             Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("CAIXA FECHADO");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("O CAIXA AINDA NÃO FOI ABERTO, DESEJA ABRIR O CAIXA?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        fecharContasPagar();
                        controleCaixa cx = new controleCaixa();
                    try {
                        cx.start(new Stage());
                    } catch (Exception ex) {
                        Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (b == btnNao) { 
                        fecharContasPagar();
                    }
                                }
                    
                     });
         
         }
         }
     
     public void atualizarCaixa(){
          modelCaixa = new ModelCaixa();
          modelContaPagar = new ModelContaPagar();
                
          modelCaixa = controllerCaixa.getCaixaController(1);
          modelContaPagar = controllerContaPagar.getContaPagarController(codigo);
          
          double retira = modelContaPagar.getValor();
          double atual = modelCaixa.getDinheiro();
          modelCaixa.setDinheiro(atual - retira);
          controllerCaixa.atualizarCaixaController(modelCaixa);
        
     }
     
     public void fecharContasPagar(){
          Stage estagioContasPagar = (Stage) btPesquisarContPagar.getScene().getWindow();
          estagioContasPagar.close();
        
                }
     public void abrirContaPagar() throws IOException{
        int codigo = 0; 
        codigo = tabelaListaContasPagar.getSelectionModel().getSelectedItem().getCodigo();
        if (codigo  == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("É NECESSÁRIO SELECIONAR UMA CONTA");
                                alert.show(); 
            
        }else{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/contaPagar.fxml"));
        Parent raizcontaPagar = (Parent) loader.load();
        contaPagar cpeditar = loader.getController();
        Stage cpEditarStage = new Stage();
        cpeditar.recuperarConta(codigo);
        cpEditarStage.setScene(new Scene(raizcontaPagar));
        cpEditarStage.show();
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
    public void imprimirEstaConta(){
        int codigoConta = tabelaListaContasPagar.getSelectionModel().getSelectedItem().getCodigo();
        if (codigoConta == 0){
        Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("NENHUMA CONTA SELECIONADA");
                                alert.show(); 
                 try {
                     listaContasGeralPagar();
                 } catch (Exception ex) {
                     Logger.getLogger(contasPagar.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
       }else{
        
       controllerContaPagar.gerarRelatorioContaPagar(codigoConta);
        
    }
    }
    
    public void gerarRelatorioContasPagar(){
       
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
       }else if(codFornecedor == 0){
              Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("ERRO");
                                alert.setContentText("NÃO FOI SELECIONADO O FORNECEDOR");
                                alert.show(); 
       }else{
           controllerContaPagar.gerarRelatorioContasPagarFornecedor(codFornecedor, status, inicioRelatorio, fimRelatorio);
       }
       
       
   }
         
        }


    
    
        
        
    
    

