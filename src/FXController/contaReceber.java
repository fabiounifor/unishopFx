/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCliente;
import controller.ControllerContaReceber;
import controller.ControllerFormaPagamento;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelCliente;
import model.ModelContaPagar;
import model.ModelContaReceber;
import model.ModelFormaPagamento;
import org.controlsfx.control.textfield.TextFields;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class contaReceber extends Application implements Initializable{
    
    @FXML TextField tfCliente;
    @FXML TextField tfDocumento;
    @FXML TextField tfDescricao;
    @FXML TextField tfValor;
    @FXML TextField tfVencimento;
    @FXML TextField tfIntervalo;
    @FXML TextField tfFormaPagamento;
    @FXML ChoiceBox cbQuantidade;
    @FXML TableView<ModelContaReceber> tbParcelamento = new TableView<>();
    @FXML TableColumn<ModelContaReceber, String> tcDescricao;
    @FXML TableColumn<ModelContaReceber, Float> tcValor;
    @FXML TableColumn<ModelContaReceber, Date> tcVencimento;
    @FXML private Button btSair;
    int codigoConta;
    String codigoCliente;
 
    
    ModelContaReceber modelContaReceber = new ModelContaReceber();
    ModelContaReceber mcr = new ModelContaReceber();
    ControllerCliente controllerCliente = new ControllerCliente();
    ArrayList<ModelContaReceber> listaModelConta = new ArrayList<>();
    ControllerContaReceber controllerContaReceber = new ControllerContaReceber();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
    ArrayList<ModelContaReceber> listaResultado = new ArrayList<>();
    ArrayList<String> listaCliente = new ArrayList<>();
    ArrayList<String> listaFormaPagamento = new ArrayList<>();
    ObservableList<ModelContaReceber> listadeContasReceberInserir;
    ModelCliente modelCliente = new ModelCliente();
    String tipoCadastro;
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage contaReceber) throws IOException {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/contaReceber.fxml")); 
        Parent raiz = loader.load();   
        contaReceber.setScene(new Scene(raiz));
        contaReceber.setTitle("CONTA RECEBER");
        contaReceber.initStyle(StageStyle.UNDECORATED);
        contaReceber.initModality(Modality.APPLICATION_MODAL);
        contaReceber.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       criarlistarClientes();
       criarlistaPagamentos();
       TextFields.bindAutoCompletion(tfCliente,listaCliente );
       TextFields.bindAutoCompletion(tfFormaPagamento,listaFormaPagamento );
       iniciaParcelas();
       tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));        
       tcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));        
       tcVencimento.setCellValueFactory(new PropertyValueFactory<>("vencimento"));        
    }
        public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    public boolean novaContaReceber(){
          
        // SALVAR CONTA
        
        if (tbParcelamento.getItems().size() > 0 ){
            salvarConta();
        }else{
        modelContaReceber.setCodigoPessoa(Integer.parseInt(tfCliente.getText().substring(1,3)));
        modelContaReceber.setDescricao(tfDescricao.getText());
        
        try {
            modelContaReceber.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            
            modelContaReceber.setVencimento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            
            modelContaReceber.setPagamento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            modelContaReceber.setSituacao(0);
            modelContaReceber.setValor(Float.parseFloat(tfValor.getText()));
            
            modelContaReceber.setTipoPagamento(Integer.parseInt(tfFormaPagamento.getText().substring(0,1)));
                       modelContaReceber.setObservacao(tfDescricao.getText());
            //salvar 
            controllerContaReceber.salvarContaReceberController(modelContaReceber);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("venda OK");
                    alert.setContentText("Registro gravado com sucesso!");
                    alert.show();
                     
               voltarPraVenda(); 
               limparCampos();
               
               
                return true;
             } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERRO");
                    alert.setContentText("Erro ao alterar os dados!");
                    alert.show();
                return false;
            
        }
    }
    return true;
    }
    private boolean alterar(int codigoConta) {
        modelContaReceber.setCodigoPessoa(Integer.parseInt(tfCliente.getText().substring(1,3)));
        modelContaReceber.setDescricao(tfDescricao.getText());
        modelContaReceber.setCodigo(codigoConta);
        try {
            modelContaReceber.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelContaReceber.setVencimento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            modelContaReceber.setPagamento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            modelContaReceber.setSituacao(0);
            modelContaReceber.setValor(Float.parseFloat(tfValor.getText()));
            modelContaReceber.setTipoPagamento(Integer.parseInt(tfFormaPagamento.getText().substring(1, 1)));
            modelContaReceber.setObservacao(tfDescricao.getText());

            //salvar 
            if (controllerContaReceber.atualizarContaReceberController(modelContaReceber)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("venda OK");
                    alert.setContentText("Registro gravado com sucesso!");
                    alert.show();
                limparCampos();                
                
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERRO");
                    alert.setContentText("Erro ao alterar os dados!");
                    alert.show();
            
                return false;
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERRO");
                    alert.setContentText("Preencha todas as datas do formulário!");
                    alert.show();
            
            return false;
        }
    }
    
    public void limparCampos(){
         
         tfDescricao.setText("");
         tfDocumento.setText("");
         tfFormaPagamento.setText("");
         tfCliente.setText("");
         tfIntervalo.setText("");
         tfValor.setText("");
         tfVencimento.setText("");
         tbParcelamento.getItems().clear();
         
     }   
    
    private void criarlistarClientes() {
        listaModelClientes= controllerCliente.getListaClienteAtivoController();
        for (int i = 0; i < listaModelClientes.size(); i++) {
            if (listaModelClientes.get(i).getCodigo() < 10){
            listaCliente.add("00" + listaModelClientes.get(i).getCodigo()+ "-" +listaModelClientes.get(i).getNome());
        }else if((listaModelClientes.get(i).getCodigo() > 10) && (listaModelClientes.get(i).getCodigo() > 100) ){
            listaCliente.add("0" + listaModelClientes.get(i).getCodigo()+ "-" +listaModelClientes.get(i).getNome());        
            }else{
            listaCliente.add(listaModelClientes.get(i).getCodigo()+ "-" +listaModelClientes.get(i).getNome());        
        }
        }
    }
    private void criarlistaPagamentos() {
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();
        
        for (int i = 0; i < listaModelTipoPagamentos.size(); i++) {
            listaFormaPagamento.add(listaModelTipoPagamentos.get(i).getCodigo()+"-" + listaModelTipoPagamentos.get(i).getDescricao());
            }
    }
    
    public boolean recuperarConta(int pCodigoConta) {
        modelContaReceber = new ModelContaReceber();
        modelContaReceber = controllerContaReceber.getContaReceberController(pCodigoConta);
        codigoConta = pCodigoConta;
        gerarCodigoCliente(codigoConta);
        tfCliente.setText((codigoCliente)+"-"+(controllerCliente.getClienteControllerCod(modelContaReceber.getCodigoPessoa()).getNome()));
        tfDocumento.setText(modelContaReceber.getObservacao());
        tfDescricao.setText(modelContaReceber.getDescricao());
        tfFormaPagamento.setText((controllerTipoPagamento.getFormaPagamentoController(modelContaReceber.getTipoPagamento()).getCodigo())+"-"+(controllerTipoPagamento.getFormaPagamentoController(modelContaReceber.getTipoPagamento()).getDescricao()));
        tfVencimento.setText(bLMascaras.converteDateEmData(modelContaReceber.getVencimento()));
        tfValor.setText(String.valueOf(modelContaReceber.getValor()));
        return true;
    }
    private void gerarCodigoCliente(int codigoConta){
           
      if((controllerContaReceber.getContaReceberController(codigoConta).getCodigoPessoa() < 10)){
        codigoCliente = ("00"+ (controllerContaReceber.getContaReceberController(codigoConta).getCodigoPessoa()));
      }else if(((controllerContaReceber.getContaReceberController(codigoConta).getCodigoPessoa()) == 10) || ((controllerContaReceber.getContaReceberController(codigoConta).getCodigoPessoa()) < 100) ) {
        codigoCliente = ("0"+ (controllerContaReceber.getContaReceberController(codigoConta).getCodigoPessoa()));  
      }
    }
   
   
    public void contaDeVenda(int codCliente,float valor,int codVenda, Date vencimento, Date lancamento ){
        if (codCliente < 10){
            codigoCliente = ("00" + codCliente);
        }else if(codCliente < 100 ){
            codigoCliente = ("0" + codCliente);
        }
        
        tfCliente.setText((codigoCliente)+"-"+(controllerCliente.getClienteControllerCod(codCliente).getNome()));
        tfDescricao.setText("REFERENTE A VENDA: " + codVenda);
        tfValor.setText(String.valueOf(valor));
        try {
            tfVencimento.setText(String.valueOf(bLMascaras.formatarData(new java.util.Date(System.currentTimeMillis()))));
        } catch (Exception ex) {
            Logger.getLogger(contaReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfFormaPagamento.setText("1-A VISTA");
        
        
        
    }
    
    public void voltarPraVenda(){
        fecharSaida();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pedidoVenda.fxml"));
        /*try {
           Parent raizPedido = (Parent) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(contaReceber.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        pedidoVenda pedido = loader.getController();
        
        
        pedido.codigoVenda = (Integer.parseInt(tfDocumento.getText()));
        pedido.finalizarVenda();
        try {
            pedido.lancamento();
        } catch (Exception ex) {
            Logger.getLogger(contaReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecharSaida(){
          Stage estagiosaida = (Stage) tfCliente.getScene().getWindow();
          estagiosaida.close();
          
          }
    public void replicarParcelas() throws Exception{
         tbParcelamento.setVisible(true);
         int quant = (cbQuantidade.getSelectionModel().getSelectedIndex() + 1);
         listaResultado = new ArrayList<>();
         listaResultado.clear();
         tbParcelamento.getItems().clear();
         Date novaData;
         novaData = (bLMascaras.converterDataStringParaDateBR(tfVencimento.getText()));
         Calendar c = Calendar.getInstance();
         
             System.out.println(quant);
         for (int i=0; i<quant; i++){
             ModelContaReceber mcr = new ModelContaReceber();
             c.setTime(novaData);
             
             mcr.setCodigoPessoa(Integer.parseInt(tfCliente.getText().substring(0,3)));
             mcr.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
             mcr.setDescricao(tfDescricao.getText());
             mcr.setObservacao(tfDocumento.getText());
             mcr.setPagamento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
             mcr.setTipoPagamento(Integer.parseInt(tfFormaPagamento.getText().substring(0, 1)));
             mcr.setVencimento(bLMascaras.converterDataParaDateUS(c.getTime()));
             mcr.setValor(bLMascaras.truncamentoComPontoDuasCasasFloat((Float.parseFloat(tfValor.getText())) / quant));
            
             listaResultado.add(mcr);
            c.add(Calendar.DATE, +(Integer.parseInt(tfIntervalo.getText())));
            novaData = c.getTime();
         }
         listadeContasReceberInserir = FXCollections.observableArrayList(listaResultado);
         
         tbParcelamento.getItems().addAll(listadeContasReceberInserir);
         mcr.setListaContaReceber(listaResultado);
               
            
        }      
     

     
     public void iniciaParcelas(){
       cbQuantidade.getItems().addAll("1", "2","3", "4","5", "6", "7", "8","9", "10","11", "12");
    }
     
     public boolean salvarConta(){
      System.out.println(mcr);
         controllerContaReceber.salvarContasReceberController(mcr);
         
         limparCampos();                
         return true;
         
     }
    
    
}
