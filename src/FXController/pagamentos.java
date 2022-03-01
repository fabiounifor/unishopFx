/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ModelCaixa;
import model.ModelVendas;
import model.ModelPagamento;
import model.ModelContaPagar;
import model.ModelContaReceber;
import model.ModelFormaPagamento;
import controller.ControllerCaixa;
import controller.ControllerFormaPagamento;
import controller.ControllerContaPagar;
import controller.ControllerContaReceber;
import interfaces.classeInterfaces;
import controller.ControllerPermissaousuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelSessaoUsuario;
import util.BLMascaras;


/**
 *
 * @author Fabio
 */
public class pagamentos extends Application implements Initializable{
    @FXML TextField pgDinheiro;
    @FXML TextField pgCartao;
    @FXML TextField pgPrazo;
    @FXML TextField pgCheque;
    @FXML TextField pgBoleto;
    @FXML TextField pgDesconto;
    @FXML Button btFinalizar;
    @FXML CheckBox cbxComissao;
    @FXML Label lbtotal;
    @FXML Label lbtroco;
    ArrayList<TextField> campos = new ArrayList<>();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    float valorParcial;
    float valorTotal;
    float pgTtroco;
    String origemOp;
    String mesaselecionada; 
    int codGarcon;
    float valorDinheiro;
    float valorCartao;
    float valorCheque;
    float valorVale;
    float valorsemcomissao;
    float valorcomcomissao;
    float valorRecebido;
    float valorTroco;
    float valorDesconto;
    String codCliente;
    int codVenda;
    String fPagamento;
    Date vencimento;
    Date lancamento;
  
       
    
    ModelVendas modelVendas = new ModelVendas();
    ModelPagamento modelPagamento = new ModelPagamento();
    ModelContaPagar modelContasPagar = new ModelContaPagar();
    ModelContaReceber modelContaReceber = new ModelContaReceber();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerFormaPagamento controllerFormaPagamento = new ControllerFormaPagamento();
    ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
    ControllerContaReceber controllerContaReceber = new ControllerContaReceber();
    BLMascaras blMascaras = new BLMascaras();
    
    
    @Override
    public void start(Stage pagStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pagamentos.fxml"));        
        Parent raiz = loader.load();   
        pagStage.setScene(new Scene(raiz));
        pagStage.initModality(Modality.APPLICATION_MODAL);
        pagStage.initStyle(StageStyle.UNDECORATED);
        pagStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retornarCodigoUsuarioLogado();
        listaEnter();

        setNextFocus( pgDinheiro, pgCartao, pgPrazo, pgBoleto, pgCheque, pgDesconto);
        btFinalizar.setDisable(true);
        
        pgDinheiro.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
          
       }
    });
        pgCartao.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
          
       }
    });
        pgCheque.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
          
       }
    });
        pgDesconto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
       }
    });
        pgBoleto.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
       }
    });
        pgCheque.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
       }
    });
        pgPrazo.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
       }
    });
        pgDinheiro.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           habilitarBtFinalizar();
       }
    });
        btFinalizar.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.ENTER){
           ActionEvent Event = null;
           try {
               fecharPagamento(Event);
           } catch (Exception ex) {
               Logger.getLogger(pagamentos.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    });
       
    }
        
    public void listaEnter(){
        
        campos.add(pgDinheiro);
        campos.add(pgCartao);
        campos.add(pgPrazo);
        campos.add(pgBoleto);
        campos.add(pgCheque);
        campos.add(pgDesconto);
    
                  
       }
    
    public void setNextFocus(TextField pgDinheiro, TextField pgCartao, TextField pgPrazo, TextField pgBoleto, TextField pgCheque, TextField pgTroco) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    }
    
    public void origem(String origemAtual){
        origemOp = origemAtual;
        
    }
    public void definirComissao(){
        valorsemcomissao = (valorParcial);
        valorcomcomissao = (blMascaras.arredondamentoComPontoDuasCasas(valorParcial * 1.10f));
        
        if (cbxComissao.isSelected()){
            valorTotal = valorcomcomissao;
            }else{
            valorTotal = valorsemcomissao ;
            }
                
            lbtotal.setText(String.valueOf(valorTotal));
           
    }
    public void valorVenda(float total){
        valorParcial = total;
        if((cbxComissao.isVisible())){
        definirComissao();
        }else{
            valorTotal = valorParcial;
        }        
        pgDesconto.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        pgTtroco = (total * -1);
        pgDinheiro.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        pgCartao.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        pgBoleto.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        pgPrazo.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        pgCheque.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        lbtotal.setText(String.valueOf(0));
        lbtroco.setText(String.valueOf(0.0));
        
    }
    
    public void fecharPag() throws IOException{
          Stage estagiosaida = (Stage) btFinalizar.getScene().getWindow();
          if (origemOp.equals("delivery") ){
              classeInterfaces.avisaOuvintesCodigoVenda("pedidovenda",(codVenda));
              estagiosaida.close();
          }else if(origemOp.equals("pdv") ){
              classeInterfaces.avisaOuvintesCodigoVenda("pdv",(codVenda));
              estagiosaida.close();
          }else if(origemOp.equals("mesa") ){
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/mesasLancamento.fxml"));
              Parent raizMesa = (Parent) loader.load();
              lancaMesa mesa = loader.getController();
              mesa.recuperarVenda(codVenda);
              estagiosaida.close();
          }
          estagiosaida.close();
          }
    
    public void confirmarPag() throws IOException{
          Stage estagiosaida = (Stage) btFinalizar.getScene().getWindow();
          estagiosaida.close();
          }
    
    public void adicionarValorCaixa() {
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        Double valorDinheiroRecebido = Double.parseDouble(String.valueOf(valorTotal - (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgCartao.getText())))));
        
        if ( (Double.parseDouble(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText()))) > 0 ){
            valorDinheiro = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
            modelCaixa.setDinheiro(valorDinheiroRecebido + modelCaixa.getDinheiro());
            fPagamento = "01";
        } if (Double.parseDouble(blMascaras.converterVirgulaParaPonto(this.pgCartao.getText())) > 0) {
            valorCartao = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgCartao.getText())));
            modelCaixa.setCartao(valorCartao + modelCaixa.getCartao());
            fPagamento = "03";
        } if (Double.parseDouble(blMascaras.converterVirgulaParaPonto(this.pgCheque.getText())) > 0) {
            valorCheque = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgCheque.getText())));
            modelCaixa.setCheque(valorCheque + modelCaixa.getCheque());
        } if (Double.parseDouble(blMascaras.converterVirgulaParaPonto(this.pgPrazo.getText())) > 0) {
            valorVale = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgPrazo.getText())));
            modelCaixa.setConvenio(valorVale + modelCaixa.getConvenio());
        }
       
        controllerCaixa.atualizarCaixaController(modelCaixa);
    }
    
    
    public void fecharPagamento(ActionEvent event) throws IOException, Exception{
        if (origemOp.equals("mesa")){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/mesasLancamento.fxml"));
        Parent raizMesa = (Parent) loader.load();
        lancaMesa mesa = loader.getController();
        if (cbxComissao.isSelected() == false){
            codGarcon = 1;
        }
        mesa.salvarVenda(valorsemcomissao,mesaselecionada,codGarcon);
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizMesa));
        adicionarValorCaixa();
        confirmarPag();
        
        
        
        
        }else if (origemOp.equals("delivery")){
        adicionarValorCaixa();
        if (valorVale > 0){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/contaReceber.fxml"));
        Parent raizConta = (Parent) loader.load();
        contaReceber conta = loader.getController();
        conta.tfValor.setText(String.valueOf(valorVale));
        conta.codigoCliente = codCliente;
        conta.tfVencimento.setText(String.valueOf(vencimento));
        conta.tfDocumento.setText(String.valueOf(codVenda));
        conta.contaDeVenda(Integer.parseInt(codCliente), valorVale,codVenda, vencimento, lancamento);
        Stage contStage = new Stage();
        contStage.setScene(new Scene(raizConta));
        contStage.show();
        confirmarPag();  
        
        
        }else{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pedidoVenda.fxml"));
        Parent raizPedido = (Parent) loader.load();
        pedidoVenda pedido = loader.getController();
        confirmarPag();
        pedido.codigoVenda = (Integer.parseInt(String.valueOf(codVenda)));
        pedido.atualizarVenda(codVenda, fPagamento,valorTroco );
        pedido.finalizarVenda();
        pedido.imprimirPedido();
        }
        
            
        }
        
    }   
    
    
    public boolean retornarCodigoUsuarioLogado() {
        try {
            String permissao = new ControllerPermissaousuario().getPermissaousuarioCodUsuController(new ModelSessaoUsuario().codigo).getPermissao();
            if (permissao.equals("compras")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    private float calcularValorRecebido() {
        float pdinheiro, pcartao, pcheque, pconvenio, pBoleto, pDesconto;
        pdinheiro = Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText()));
        pcartao = Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgCartao.getText()));
        pcheque = Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgCheque.getText()));
        pconvenio = Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgPrazo.getText()));
        pBoleto = Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgBoleto.getText()));
        pDesconto = Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDesconto.getText()));
        valorDesconto = pDesconto;
        return ((pdinheiro + pcartao + pcheque + pconvenio + pBoleto) + pDesconto);
        
    }

    private float calcularDesconto() {
        float  pSubTotal = 0;
        float  pDesconto = 0;
          
            pSubTotal = (valorTotal);
            pDesconto = Float.parseFloat(pgDesconto.getText());
            valorTotal = pSubTotal - pDesconto;
        return valorTotal;
    }

    private float calcularTroco() {
        float pValorRecebid = 0;
        pValorRecebid = 0;
        pValorRecebid = calcularValorRecebido();
        return pValorRecebid - valorTotal;
       
    }
    public void habilitarBtFinalizar(){
        if (valorTotal <= calcularValorRecebido()){
            btFinalizar.setDisable(false);
        } if (valorTotal < calcularValorRecebido()){
            valorTroco = calcularValorRecebido() - valorTotal;
            lbtroco.setText(String.valueOf(valorTroco));
        }
        
    }

    void mesaselecionada(String text) {
        mesaselecionada = text;
        
    }

    void codGarcon(int parseInt) {
     codGarcon = parseInt;  
    }

    

    
    
}
