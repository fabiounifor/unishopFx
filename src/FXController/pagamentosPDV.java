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
import controller.ControllerOpcoes;
import interfaces.classeInterfaces;
import controller.ControllerPermissaousuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelOpcionais;
import model.ModelSessaoUsuario;
import util.BLMascaras;
import util.TextFieldFormatter;


/**
 *
 * @author Fabio
 */
public class pagamentosPDV extends Application implements Initializable{
    @FXML TextField pgDinheiro;
    @FXML CheckBox cbxComissao;
    @FXML Label lbtotal;
    @FXML Label lbtroco;
    @FXML FlowPane pnBotoes;
    @FXML Button pagBotao;
    @FXML Pane pnDescontoOuAcrescimo;
    @FXML Label descontoOuAcrescimo;
    @FXML Label lbDescontoOuAcrescimo;
    ArrayList<TextField> campos = new ArrayList<>();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    float valorParcial;
    float valorTotal;
    float pgTtroco;
    String origemOp;
    String mesaselecionada; 
    int codGarcon;
    float valorDinheiro;
    float valorDinheiroDefinido;
    float valorCartao;
    float valorCartaoDefinido;
    float valorCheque;
    float valorChequeDefinido;
    float valorVale;
    float valorValeDefinido;
    float valorsemcomissao;
    float valorcomcomissao;
    float valorRecebido;
    float valorTroco;
    float valorDesconto;
    float valorAcrescimo;
    String documentoAvulso;
    String clienteAvulso;
    String codCliente;
    int codVenda;
    String fPagamento;
    ArrayList <String> listafPagamento= new ArrayList<>();
    Date vencimento;
    Date lancamento;
    
    int tipoRecorrente;
   
  
       
    
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
    ArrayList<Button> listadeBotoes = new ArrayList<>();
    ArrayList<ModelFormaPagamento> listaFormaPagamento = new ArrayList<>();

    
    @Override
    public void start(Stage pagStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pagamentosPDV.fxml"));        
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
    pnDescontoTamanho();
    popularTabela();
    pgDinheiro.setFocusTraversable(true);
    pgDinheiro.requestFocus();
    pgDinheiro.selectAll();
    pgDinheiro.setOnKeyPressed((KeyEvent e)->{
       if(e.getCode()== KeyCode.DOWN){
        pagBotao.requestFocus();
       }
    });
    
       
    }
    public void pnDescontoTamanho(){
        if(valorDesconto <= 0){
        pnDescontoOuAcrescimo.setMaxHeight(1);
    }else{
            pnDescontoOuAcrescimo.setMinHeight(60);
          }
        
    }
    public void adcionalDesconto(){
        String adcionalOuDesconto = pgDinheiro.getText();
        int ultimoDigitoPosicao =  (adcionalOuDesconto.length()-1);
        String ultimoDigito =  adcionalOuDesconto.substring(ultimoDigitoPosicao);
        
        if(ultimoDigito.equalsIgnoreCase("-")){
            valorDesconto = blMascaras.converterVirgulaParaPontoReturnFloat(adcionalOuDesconto.substring(0, ultimoDigitoPosicao));
            lbDescontoOuAcrescimo.setText("Desconto");
            descontoOuAcrescimo.setText(String.valueOf(valorDesconto));
            calcularValorRecebido();
            pnDescontoTamanho();
            lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) - valorDesconto));
            pgDinheiro.setText(lbtotal.getText());
             }
        else if(ultimoDigito.equalsIgnoreCase("+")){
            valorAcrescimo = blMascaras.converterVirgulaParaPontoReturnFloat(adcionalOuDesconto.substring(0, ultimoDigitoPosicao));
            lbDescontoOuAcrescimo.setText("Acrescimo");
            descontoOuAcrescimo.setText(String.valueOf(valorDesconto));
            calcularValorRecebido();
            pnDescontoTamanho();
            lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) + valorAcrescimo));
            pgDinheiro.setText(lbtotal.getText());
             }
        else if ((Float.parseFloat(lbtotal.getText())) < (Float.parseFloat(pgDinheiro.getText())) ){
        lbtroco.setText(blMascaras.arredondamentoComPontoDuasCasasString((Float.parseFloat(pgDinheiro.getText())) - (Float.parseFloat(lbtotal.getText()))));
        }
    }
    
   
    public void popularTabela() {
        //pnBotoes.getChildren().clear();
        
        listaFormaPagamento = controllerFormaPagamento.getListaFormaPagamentoController();
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            int espacoh = 360;
            int espacov = 80;
            pagBotao = new Button();
            pagBotao.setText(listaFormaPagamento.get(i).getDescricao());
            pagBotao.setMinWidth(espacoh);
            pagBotao.setMinHeight(espacov);
            pagBotao.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    definirValoresRecebidos(selecionaPagamento());
                    habilitarBtFinalizar();
                }
                               
            });  
            pagBotao.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode()== KeyCode.ENTER){
            definirValoresRecebidos(selecionaPagamento());
            habilitarBtFinalizar();
            }
            });
            listadeBotoes.add(pagBotao);
            pnBotoes.getChildren().addAll(pagBotao);    
            pnBotoes.setFocusTraversable(true);
            
        }
        
    }
    public void acaoBotao(){
                    definirValoresRecebidos(selecionaPagamento());
                    habilitarBtFinalizar();
    }
    private String selecionaPagamento(){
                    String pagString = "";
                    String pagamento = "";
                    for (int j = 0; j < listadeBotoes.size(); j++) {
                    if (listadeBotoes.get(j).isFocused()) {
                    pagString = listadeBotoes.get(j).getText();
                    pagString = pagString.trim();
                    pagamento = pagString;
            }
    }
                    return pagamento;
    }
    public void definirValoresRecebidos(String descricao){
        System.out.println("DESCRICAO   "+descricao);
        switch (descricao){
            case "DINHEIRO":
                valorDinheiroDefinido = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
                listafPagamento.add("01" + "  " + (String.valueOf(valorDinheiroDefinido)));
                lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) - valorDinheiroDefinido));
                pgDinheiro.setText(lbtotal.getText());
                break;
            case "CHEQUE":
                valorChequeDefinido = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
                listafPagamento.add("02" + "  " + (String.valueOf(valorChequeDefinido)));
                lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) - valorChequeDefinido));
                pgDinheiro.setText(lbtotal.getText());
                break;
            case "CARTAO CREDITO":
                valorCartaoDefinido = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
                listafPagamento.add("03" + "  " + (String.valueOf(valorCartaoDefinido)));
                lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) - valorCartaoDefinido));
                pgDinheiro.setText(lbtotal.getText());
                break;    
            case "CARTAO DEBITO":
                valorCartaoDefinido = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
                listafPagamento.add("04" + "  " + (String.valueOf(valorCartaoDefinido)));
                lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) - valorCartaoDefinido));
                pgDinheiro.setText(lbtotal.getText());
                break;        
            case "VALE":
                valorValeDefinido = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
                listafPagamento.add("05" + "  " + (String.valueOf(valorValeDefinido)));
                lbtotal.setText(String.valueOf((Float.parseFloat(lbtotal.getText())) - valorCartaoDefinido));
                pgDinheiro.setText(lbtotal.getText());
                break;
                          }
        System.out.println("lista de pagamentos" + listafPagamento );
                }
    
    public void listaEnter(){
        
        campos.add(pgDinheiro);
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
        pgTtroco = (total * -1);
        pgDinheiro.setText(blMascaras.converterVirgulaParaPonto(String.valueOf(0)));
        lbtotal.setText(String.valueOf(0));
        lbtroco.setText(String.valueOf(0.0));
        
    }
    
    public void fecharPag() throws IOException{
          Stage estagiosaida = (Stage) pnBotoes.getScene().getWindow();
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
          Stage estagiosaida = (Stage) pnBotoes.getScene().getWindow();
          estagiosaida.close();
          }
    
    public void adicionarValorCaixa() {
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        Double valorDinheiroRecebido = Double.parseDouble(String.valueOf(valorTotal - valorCartaoDefinido));
        
        if ( valorDinheiroDefinido > 0 ){
            valorDinheiro = (Float.parseFloat(blMascaras.converterVirgulaParaPonto(this.pgDinheiro.getText())));
            modelCaixa.setDinheiro(valorDinheiroRecebido + modelCaixa.getDinheiro());
            fPagamento = "01";
        } if (valorCartaoDefinido > 0) {
            valorCartao = (valorCartaoDefinido);
            modelCaixa.setCartao(valorCartao + modelCaixa.getCartao());
            fPagamento = "03";
        } if (valorChequeDefinido > 0) {
            valorCheque = (valorCartaoDefinido);
            modelCaixa.setCheque(valorCheque + modelCaixa.getCheque());
        } if (valorValeDefinido > 0) {
            valorVale = (valorValeDefinido);
            modelCaixa.setConvenio(valorVale + modelCaixa.getConvenio());
        }
       
        controllerCaixa.atualizarCaixaController(modelCaixa);
    }
    
    
    public void fecharPagamento(ActionEvent event) throws IOException, Exception{
        if(origemOp.equals("pdv")){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pdv.fxml"));
        Parent raizPdv = (Parent) loader.load();
        pdv pdvJanela = loader.getController();
        adicionarValorCaixa();
        confirmarPag();  
        pdvJanela.finalizarVenda();
        pdvJanela.tfNota.setText(String.valueOf(codVenda));
        pdvJanela.gerarNfce(codVenda, valorTotal,listafPagamento, valorTroco, valorDesconto, documentoAvulso, clienteAvulso, valorAcrescimo );
        }
        else if (origemOp.equals("mesa")){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/mesasLancamento.fxml"));
        Parent raizMesa = (Parent) loader.load();
        lancaMesa mesa = loader.getController();
        if (cbxComissao.isSelected() == false){
            codGarcon = 1;
        }
            System.out.println("valor sem comissão" + valorsemcomissao);
            System.out.println("mesa " + mesaselecionada);
            System.out.println("cod garcon " + codGarcon);
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
        float pdinheiro, pcartao, pcheque, pconvenio, pBoleto, pDesconto, pAcrescimo;
        pdinheiro = valorDinheiroDefinido;
        pcartao = valorCartaoDefinido;
        pcheque = valorChequeDefinido;
        pconvenio = valorValeDefinido;
        pDesconto = valorDesconto;
        valorDesconto = pDesconto;
        pAcrescimo = valorAcrescimo;
        valorAcrescimo = pAcrescimo;
        
        return ((pdinheiro + pcartao + pcheque + pconvenio ) + pDesconto - pAcrescimo);
        
    }

    private float calcularDesconto() {
        float  pSubTotal = 0;
        float  pDesconto = 0;
          
            pSubTotal = (valorTotal);
            pDesconto = Float.parseFloat(pgDinheiro.getText());
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
              if (valorTotal < calcularValorRecebido()){
            valorTroco = calcularValorRecebido() - valorTotal;
            lbtroco.setText(String.valueOf(valorTroco));
            }
             ActionEvent event = null;
            try {
                fecharPagamento(event);
            } catch (Exception ex) {
                Logger.getLogger(pagamentosPDV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void mesaselecionada(String text) {
        mesaselecionada = text;
        
    }

    void codGarcon(int parseInt) {
     codGarcon = parseInt;  
    }

    

    
    
}
