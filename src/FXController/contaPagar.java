/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerCliente;
import controller.ControllerContaPagar;
import controller.ControllerFormaPagamento; 
import controller.ControllerFornecedor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
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
import model.ModelFornecedor;
import model.ModelContaPagar;
import model.ModelFormaPagamento;
import org.controlsfx.control.textfield.TextFields;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class contaPagar extends Application implements Initializable{
    
    @FXML TextField tfFornecedor;
    @FXML TextField tfDocumento;
    @FXML TextField tfDescricao;
    @FXML TextField tfValor;
    @FXML TextField tfVencimento;
    @FXML TextField tfIntervalo;
    @FXML TextField tfFormaPagamento;
    @FXML ChoiceBox cbQuantidade;
    @FXML TableView<ModelContaPagar> tbParcelamento;
    @FXML TableColumn<ModelContaPagar, String> tcDescricao;
    @FXML TableColumn<ModelContaPagar, Float> tcValor;
    @FXML TableColumn<ModelContaPagar, Date> tcVencimento;
    @FXML private Button btSair;
    
    
    int codigoConta;
    String codigoFornecedor;
    
 
    
    ModelContaPagar modelContaPagar = new ModelContaPagar();
    ControllerCliente controllerCliente = new ControllerCliente();
    ArrayList<ModelContaPagar> listaModelConta = new ArrayList<>();
    ModelContaPagar mcp = new ModelContaPagar();
    ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ArrayList<ModelFornecedor> listaModelFornecedores = new ArrayList<>();
    ArrayList<String> listaFornecedor = new ArrayList<>();
    ArrayList<String> listaFormaPagamento = new ArrayList<>();
    ArrayList<ModelContaPagar> listaResultado = new ArrayList<>();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    ObservableList<ModelContaPagar> listadeContasPagarInserir;
    ArrayList<TextField> campos = new ArrayList<>();
    String tipoCadastro;
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage contaPagar) throws IOException {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/contaPagar.fxml")); 
        Parent raiz = loader.load();   
        contaPagar.setScene(new Scene(raiz));
        contaPagar.setTitle("CONTA PAGAR");
        contaPagar.initStyle(StageStyle.UNDECORATED);                        
        contaPagar.initModality(Modality.APPLICATION_MODAL);
        contaPagar.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       limparCampos(); 
       iniciaParcelas();
       criarlistaPagamentos();
       criarlistarFornecedores();
       TextFields.bindAutoCompletion(tfFornecedor,listaFornecedor );
       TextFields.bindAutoCompletion(tfFormaPagamento,listaFormaPagamento );
       listaEnter();
       setNextFocus(tfFornecedor, tfDocumento, tfDescricao, tfValor,  tfVencimento, tfIntervalo, tfFormaPagamento );
       tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));        
       tcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));        
       tcVencimento.setCellValueFactory(new PropertyValueFactory<>("vencimento"));        
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    
    public void setNextFocus(TextField tfFornecedor, TextField tfDocumento, TextField tfDescricao, TextField tfValor, TextField tfVencimento, TextField tfParcelas, TextField tfFormaPagamento) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    } 
    public void listaEnter(){
        
        campos.add(tfFornecedor);
        campos.add(tfDocumento);
        campos.add(tfDescricao);
        campos.add(tfValor);
        campos.add(tfVencimento);
        campos.add(tfIntervalo);
        campos.add(tfFormaPagamento);
    }
    
    public boolean novaContaPagar(){
          
        // SALVAR CONTA
        if (tbParcelamento.getItems().size() > 0 ){
            salvarConta();
        }else{
        modelContaPagar.setTipoConta("PAGAR");
        modelContaPagar.setCodigoPessoa(Integer.parseInt(tfFornecedor.getText().substring(0,3)));
        modelContaPagar.setDescricao(tfDescricao.getText());
        
        try {
            modelContaPagar.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            
            modelContaPagar.setVencimento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            
            modelContaPagar.setPagamento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            modelContaPagar.setSituacao(0);
            modelContaPagar.setValor(bLMascaras.converterVirgulaParaPontoReturnFloat(tfValor.getText()));
            
            modelContaPagar.setTipoPagamento(Integer.parseInt(tfFormaPagamento.getText().substring(0,1)));
            modelContaPagar.setObservacao(tfDocumento.getText());
            //salvar 
           
            
            
            controllerContaPagar.salvarContaPagarController(modelContaPagar);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("venda OK");
                    alert.setContentText("Registro gravado com sucesso!");
                    alert.show();
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
    
    private void gerarCodigoFornecedor(int codigoConta){
           
      if((controllerContaPagar.getContaPagarController(codigoConta).getCodigoPessoa() < 10)){
        codigoFornecedor = ("00"+ (controllerContaPagar.getContaPagarController(codigoConta).getCodigoPessoa()));
      }else if(((controllerContaPagar.getContaPagarController(codigoConta).getCodigoPessoa()) == 10) || ((controllerContaPagar.getContaPagarController(codigoConta).getCodigoPessoa()) < 100) ) {
        codigoFornecedor = ("0"+ (controllerContaPagar.getContaPagarController(codigoConta).getCodigoPessoa()));  
      }
    }
    
    public void salvarAlterar(){
        if (codigoConta > 0){
                alterar(codigoConta);
        }else{
            novaContaPagar();
        }
        
    }
    private boolean alterar(int codigoConta) {
        modelContaPagar.setTipoConta("PAGAR");
        modelContaPagar.setCodigoPessoa(Integer.parseInt(tfFornecedor.getText().substring(0,3)));
        modelContaPagar.setDescricao(tfDescricao.getText());
        modelContaPagar.setCodigo(codigoConta);
        try {
            modelContaPagar.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelContaPagar.setVencimento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            modelContaPagar.setPagamento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
            modelContaPagar.setSituacao(0);
            modelContaPagar.setValor(bLMascaras.converterVirgulaParaPontoReturnFloat(tfValor.getText()));
            modelContaPagar.setTipoPagamento(Integer.parseInt(tfFormaPagamento.getText().substring(0, 1)));
            modelContaPagar.setObservacao(tfDocumento.getText());

            //salvar 
            if (controllerContaPagar.atualizarContaPagarController(modelContaPagar)) {
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
                    alert.setContentText("Preencha todas as datas do formulário!" + ex);
                    alert.show();
            
            return false;
        }
    }
    
    private void criarlistarFornecedores() {
        listaModelFornecedores = controllerFornecedor.getListaFornecedorController();
        for (int i = 0; i < listaModelFornecedores.size(); i++) {
            if (listaModelFornecedores.get(i).getCodigo() < 10){
            listaFornecedor.add("00" + listaModelFornecedores.get(i).getCodigo()+ "-" +listaModelFornecedores.get(i).getNome());
        }else if((listaModelFornecedores.get(i).getCodigo() >= 10) && (listaModelFornecedores.get(i).getCodigo() < 100) ){
            listaFornecedor.add("0" + listaModelFornecedores.get(i).getCodigo()+ "-" +listaModelFornecedores.get(i).getNome());        
            }else{
            listaFornecedor.add(listaModelFornecedores.get(i).getCodigo()+ "-" +listaModelFornecedores.get(i).getNome());        
        }
        }
    }
    private void criarlistaPagamentos() {
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();
        
        for (int i = 0; i < listaModelTipoPagamentos.size(); i++) {
            listaFormaPagamento.add(listaModelTipoPagamentos.get(i).getCodigo()+"-" + listaModelTipoPagamentos.get(i).getDescricao());
            }
    }
    
    


     public void limparCampos(){
         
         tfDescricao.setText("");
         tfDocumento.setText("");
         tfFormaPagamento.setText("");
         tfFornecedor.setText("");
         tfIntervalo.setText("");
         tfValor.setText("");
         tfVencimento.setText("");
         tbParcelamento.setVisible(false);
         
     }   
     
     public boolean recuperarConta(int pCodigoConta) {
        modelContaPagar = new ModelContaPagar();
        modelContaPagar = controllerContaPagar.getContaPagarController(pCodigoConta);
        codigoConta = pCodigoConta;
        gerarCodigoFornecedor(codigoConta);
        tfFornecedor.setText(((codigoFornecedor))+"-"+(controllerFornecedor.getFornecedorController(modelContaPagar.getCodigoPessoa()).getNome()));
        tfDocumento.setText(modelContaPagar.getObservacao());
        tfDescricao.setText(modelContaPagar.getDescricao());
        tfFormaPagamento.setText((controllerTipoPagamento.getFormaPagamentoController(modelContaPagar.getTipoPagamento()).getCodigo())+"-"+(controllerTipoPagamento.getFormaPagamentoController(modelContaPagar.getTipoPagamento()).getDescricao()));
        tfVencimento.setText(bLMascaras.converteDateEmData(modelContaPagar.getVencimento()));
        tfValor.setText(String.valueOf(modelContaPagar.getValor()));
        return true;
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
             ModelContaPagar mcp = new ModelContaPagar();
             c.setTime(novaData);
             
             mcp.setCodigoPessoa(Integer.parseInt(tfFornecedor.getText().substring(0,3)));
             mcp.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
             mcp.setDescricao(tfDescricao.getText());
             mcp.setObservacao(tfDocumento.getText());
             mcp.setPagamento(bLMascaras.converterDataStringParaDate(tfVencimento.getText()));
             mcp.setTipoPagamento(Integer.parseInt(tfFormaPagamento.getText().substring(0, 1)));
             mcp.setVencimento(bLMascaras.converterDataParaDateUS(c.getTime()));
             mcp.setValor(bLMascaras.converterVirgulaParaPontoReturnFloat(tfValor.getText()));
            
             listaResultado.add(mcp);
            c.add(Calendar.DATE, +(Integer.parseInt(tfIntervalo.getText())));
            novaData = c.getTime();
         }
         listadeContasPagarInserir = FXCollections.observableArrayList(listaResultado);
         
         tbParcelamento.getItems().addAll(listadeContasPagarInserir);
         mcp.setListaContaPagar(listaResultado);
               
            
        }      
     

     
     public void iniciaParcelas(){
       cbQuantidade.getItems().addAll("1", "2","3", "4","5", "6", "7", "8","9", "10","11", "12");
    }
     
     public boolean salvarConta(){
      System.out.println(mcp);
         if (controllerContaPagar.salvarContasPagarController(mcp)  == true ) {
        
                limparCampos();                
                return true;
            } else {
                
                return false;
            }
     }
    
     
}
