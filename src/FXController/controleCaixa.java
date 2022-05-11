/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCaixa;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelCaixa;
import model.ModelConfig;
import model.ModelSessaoUsuario;
import relatorios.DAORelatorios;
import util.BLMascaras;
import util.GerarCupom;
import util.JavaMailApp;

/**
 *
 * @author Fabio
 */
public class controleCaixa extends Application implements Initializable {
    
    @FXML TextField tfCaixa;
    @FXML TextField tfDinheiro;
    @FXML TextField tfCartao;
    @FXML TextField tfCheque;
    @FXML TextField tfVale;
    @FXML TextField tfTotal;
    @FXML TextField tfFundo;
    @FXML Button btCaixa;
    @FXML Label lbCaixa;
    @FXML Label lbUsuario;
    @FXML Label lbData;
    @FXML Label lbHora;
    private int numeroCaixa = 1;
    private int codigoCaixa = 1;
    
     ControllerCaixa controllerCaixa = new ControllerCaixa();
    ModelCaixa modelCaixa = new ModelCaixa();
    ModelConfig modelConfig = new ModelConfig();
    BLMascaras bLMascaras = new BLMascaras();
    DAORelatorios dAORelatorios = new DAORelatorios();
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/caixa.fxml"));
        Parent raizCaixa = (Parent) loader.load();
        controleCaixa cx = loader.getController();
        Stage cxStage = new Stage();
        cxStage.setScene(new Scene(raizCaixa));
        cxStage.initStyle(StageStyle.UNDECORATED);
        cxStage.initModality(Modality.APPLICATION_MODAL);

        cxStage.show();
        
    }   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                
    carregarConfiguracoes();
    habilitarCampos(false);
    carregarCaixa();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void carregarConfiguracoes() {
        lbUsuario.setText(ModelSessaoUsuario.nome);
        setNumeroCaixa(numeroCaixa);
        
    }
    
      private void imprimeFechamentoCaixa(int codigo) {
    new Thread() {
        @Override
  
        public void run() {
            JavaMailApp ee = new JavaMailApp(); //Esse é o nome da minha classe onde tá o "Envio Simples"
            GerarCupom gerarCupom = new GerarCupom();
            System.out.println(codigo + "codigocaixa");
            controllerCaixa.imprimirFechamentoCaixa(codigo);
        }
    }.start();
}
     

     private void enviaEmail(String texto) {
    new Thread() {
        @Override
  
        public void run() {
            JavaMailApp javaMail = new JavaMailApp(); //Esse é o nome da minha classe onde tá o "Envio Simples"
            GerarCupom gerarCupom = new GerarCupom();
            try {
                javaMail.envioSimples("fabio.braga.suporte@gmail.com", "caixa do dia", texto, "fabio.braga.suporte@gmail.com");
                gerarCupom.geraCupomCaixaEmail(numeroCaixa);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }.start();
}
       
      public void sair(){
         Stage estagiosaida = (Stage) btCaixa.getScene().getWindow();
          estagiosaida.close();
     }
      
      public void abrirFechar() throws IOException{
                  if (numeroCaixa == 0) {
              
            //selecione um caixa   
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText("Você deve escolher o caixa!");
                alert.show();
        } else {
                  btCaixa.setText("FECHAR");
       
                  tfCaixa.setText(String.valueOf(numeroCaixa));
                 
                  lbCaixa.setText("ABERTO");
                
                  
            modelCaixa = new ModelCaixa();
            //Abrir ou fechar um caixa
            modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());

            if (modelCaixa.getStatus() == 0) {
                //não tem caixa aberto - abrir caixa
                modelCaixa.setCaixaNumero(getNumeroCaixa());
                modelCaixa.setDinheiro(bLMascaras.converterVirgulaParaPontoReturnDouble(tfFundo.getText()));
                modelCaixa.setFundoUsuario(bLMascaras.converterVirgulaParaPontoReturnDouble(tfFundo.getText()));
                modelCaixa.setCartao(bLMascaras.converterVirgulaParaPontoReturnDouble(tfCartao.getText()));
                modelCaixa.setCheque(bLMascaras.converterVirgulaParaPontoReturnDouble(tfCheque.getText()));
                modelCaixa.setConvenio(bLMascaras.converterVirgulaParaPontoReturnDouble(tfVale.getText()));
                modelCaixa.setCodigoUsuario(ModelSessaoUsuario.codigo);
                modelCaixa.setStatus(1);
                try {
                    
                    modelCaixa.setDataAbertura(lbData.getText());
                } catch (Exception ex) {
                    Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
                // salvar novo caixa
                if (modelCaixa.getCodigo() == 0) {
                    if (controllerCaixa.salvarCaixaController(modelCaixa) > 0) {
                         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                         alert.setTitle("CAIXA ABERTO");
                         alert.setContentText("O CAIXA: " + numeroCaixa +" FOI ABERTO COM SUCESSO");
                         alert.show();
                         sair();
                        
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                         alert.setTitle("ERRO");
                         alert.setContentText("ERRO AO ABRIR O CAIXA");
                         alert.show();
                    }
                } else {
                    //reabrir o caixa
                    if (controllerCaixa.atualizarCaixaController(modelCaixa)) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                         alert.setTitle("CAIXA ABERTO");
                         alert.setContentText("O CAIXA: " + numeroCaixa +" FOI ABERTO COM SUCESSO");
                         alert.show();
                         sair();
                    } else {
                         Alert alert = new Alert(Alert.AlertType.ERROR);
                         alert.setTitle("ERRO");
                         alert.setContentText("ERRO AO ABRIR O CAIXA");
                         alert.show();
                    }
                }
            } else {  
                modelCaixa.setCaixaNumero(Integer.parseInt(getNumeroCaixa() + modelCaixa.getCodigo() + ""));
                modelCaixa.setDinheiroUsuario(bLMascaras.converterVirgulaParaPontoReturnDouble(tfDinheiro.getText()));
                modelCaixa.setDinheiro(modelCaixa.getDinheiro() - modelCaixa.getSangria());
                modelCaixa.setFundoUsuario(bLMascaras.converterVirgulaParaPontoReturnDouble(tfFundo.getText()));
                modelCaixa.setCartaoUsuario(bLMascaras.converterVirgulaParaPontoReturnDouble(tfCartao.getText()));
                modelCaixa.setCartao(modelCaixa.getCartao());
                modelCaixa.setChequeUsuario(bLMascaras.converterVirgulaParaPontoReturnDouble(tfCheque.getText()));
                modelCaixa.setCheque(modelCaixa.getCheque());
                modelCaixa.setConvenioUsuario(bLMascaras.converterVirgulaParaPontoReturnDouble(tfVale.getText()));
                modelCaixa.setConvenio(modelCaixa.getConvenio());
                modelCaixa.setDiferencaUsuario((modelCaixa.getCartao()+modelCaixa.getCheque()+modelCaixa.getConvenio()+
                modelCaixa.getDinheiro())-(modelCaixa.getCartaoUsuario()+modelCaixa.getChequeUsuario()+modelCaixa.getConvenioUsuario()+modelCaixa.getDinheiroUsuario()));
                modelCaixa.setCodigoUsuario(ModelSessaoUsuario.codigo);
                tfCaixa.setText(String.valueOf(numeroCaixa));
                lbCaixa.setText("ABERTO");
                btCaixa.setText("FECHAR");
                        //quero fechar o caixa
                        modelCaixa.setStatus(0);
                        try {
                           
                            modelCaixa.setDataAbertura(lbData.getText().substring(0, 19));
                            modelCaixa.setDataFechamento(bLMascaras.retornarDataHoraSegundos().substring(0, 19));
                            
                        } catch (Exception ex) {
                            Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
                        }   // salvar novo caixa
                        
                        if(tfTotal.equals("0.00")){
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("ERRO AO FECHAR CAIXA");
                            alert.setContentText("DIGITE OS VALORES DO SEU CAIXA");
                            alert.show();
                        }else{
                        if (controllerCaixa.atualizarCaixaController(modelCaixa)) {
                            codigoCaixa =  modelCaixa.getCodigo();
                            imprimeFechamentoCaixa(codigoCaixa);
                            int numeroCaixa = Integer.parseInt(modelCaixa.getCaixaNumero() + (modelCaixa.getCodigo()) + "");
                            
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("CAIXA FECHADO");
                            alert.setContentText("CAIXA FECHADO COM SUCESSO");
                            alert.show();
                            sair();
                            
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERRO AO ATUALIZAR O CAIXA");
                            alert.setContentText("ERRO AO ATUALIZAR O CAIXA");
                            alert.show();
                        }
                        }
                        }
                  }
      }
      
      private void carregarCaixa() {
        // TODO add your handling code here:
        modelCaixa = new ModelCaixa();
        tfCaixa.setText(String.valueOf(numeroCaixa));
        setNumeroCaixa(Integer.parseInt(tfCaixa.getText()));
        //verifica se o caixa ta aberto se tiver retorna os dados
        modelCaixa = controllerCaixa.verificarRetorarCaixaControler(getNumeroCaixa());
        if (modelCaixa.getStatus() == 0) {
            // não tem caixa aberto
            //cadastrar novo caixa
            habilitarCampos(true);
            try {
                lbData.setText(bLMascaras.formatarDataHora(new java.util.Date(System.currentTimeMillis())));            } catch (Exception ex) {
                Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
            tfDinheiro.setText("0");
            tfCartao.setText("0");
            tfCheque.setText("0");
            tfVale.setText("0");
            lbCaixa.setText("FECHADO");
            btCaixa.setText("ABRIR");
            try {
                lbHora.setText(bLMascaras.retornarDataHoraSegundos());
            } catch (ParseException ex) {
                Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //tem caixa aberto
            //alterar caixa
            habilitarCampos(false);
            try {
                lbData.setText(String.valueOf(modelCaixa.getDataAbertura()));
                lbHora.setText(bLMascaras.retornarDataHoraSegundos());
                } catch (Exception ex) {
                Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
            tfDinheiro.setText("0.00");
            tfCartao.setText("0.00");
            tfCheque.setText("0.00");
            tfVale.setText("0.00");
            tfFundo.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(modelCaixa.getFundoUsuario()));
            somarValorTotal();
            lbCaixa.setText("ABERTO");
            btCaixa.setText("FECHAR");
        }
    }

    public void somarValorTotal() {
        double dinheiro = 0, cartao = 0, cheque = 0, convenio = 0;
        try {
            dinheiro = Double.parseDouble(bLMascaras.converterVirgulaParaPonto(tfDinheiro.getText()));
        } catch (Exception e) {
            dinheiro = 0;
        }
        try {
            cartao = Double.parseDouble(bLMascaras.converterVirgulaParaPonto(tfCartao.getText()));
        } catch (Exception e) {
            cartao = 0;
        }
        try {
            cheque = Double.parseDouble(bLMascaras.converterVirgulaParaPonto(tfCheque.getText()));
        } catch (Exception e) {
            cheque = 0;
        }
                
        tfTotal.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(dinheiro + cartao + cheque ));

    }
    
    public void sangria(double Sangria){
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(numeroCaixa);
        
        modelCaixa.setDinheiro(modelCaixa.getDinheiro() - Sangria);
        modelCaixa.setCartao(modelCaixa.getCartao());
        modelCaixa.setCheque(modelCaixa.getCheque());
        modelCaixa.setConvenio(modelCaixa.getConvenio());
        modelCaixa.setCodigoUsuario(modelCaixa.getCodigoUsuario());
        modelCaixa.setDataAbertura(modelCaixa.getDataAbertura());
        modelCaixa.setStatus(modelCaixa.getStatus());

        controllerCaixa.atualizarCaixaController(modelCaixa);
    }
        public void reforco(double Reforco){
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(numeroCaixa);
        
        modelCaixa.setDinheiro(modelCaixa.getDinheiro() + Reforco);
        modelCaixa.setCartao(modelCaixa.getCartao());
        modelCaixa.setCheque(modelCaixa.getCheque());
        modelCaixa.setConvenio(modelCaixa.getConvenio());
        modelCaixa.setCodigoUsuario(modelCaixa.getCodigoUsuario());
        modelCaixa.setDataAbertura(modelCaixa.getDataAbertura());
        modelCaixa.setStatus(modelCaixa.getStatus());

        controllerCaixa.atualizarCaixaController(modelCaixa);
    }
    
    private void habilitarCampos(boolean status) {
        tfDinheiro.setDisable(status);
        tfDinheiro.setText("0.0");
        tfCartao.setDisable(status);
        tfCartao.setText("0.0");
        tfCheque.setDisable(status);
        tfCheque.setText("0.0");
        tfVale.setDisable(status);
        tfVale.setText("0.0");
        tfTotal.setDisable(status);
        tfTotal.setText("0.0");
        tfFundo.setDisable(!(status));
        tfFundo.setText("0.0");
        try {
            lbHora.setText(bLMascaras.retornarDataHoraSegundos());
        } catch (ParseException ex) {
            Logger.getLogger(controleCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tfCaixa.setDisable(true);
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
}
    

