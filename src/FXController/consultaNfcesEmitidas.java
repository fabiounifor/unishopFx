/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerConfiguracao;
import controller.ControllerVendas;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelConfiguracao;
import model.ModelVendas;
import nfe.controller.ControllerNF;
import nfe.model.ModelNF;
import relatorios.DAORelatorios;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class consultaNfcesEmitidas extends Application implements Initializable{
    
    @FXML
    private Button btTransferir;

    @FXML
    private DatePicker dtInicial;

    @FXML
    private DatePicker dtFinal;

    @FXML
    private Label lbDataInicial;

    @FXML
    private Label lbDataFinal;

    @FXML
    private Label lbTitulo;
    @FXML
    private Label lbBarraTitulo;
    
     @FXML
    private TextField tfDinheiro;

    @FXML
    private TextField tfCartaoCredito;

    @FXML
    private TextField tfCartaoDebito;

    @FXML
    private TextField tfTotal;
    
    @FXML private Button btSair;

    Date dataInicial = Date.valueOf(LocalDate.now());
    Date dataFinal = Date.valueOf(LocalDate.now());
    private static final String modeloConstante = "65";

ControllerConfiguracao controllerConfiguracao = new ControllerConfiguracao();
ControllerVendas controllerVendas = new ControllerVendas();
ModelConfiguracao modelConfiguracao = new ModelConfiguracao();
ModelVendas  modelVendas = new ModelVendas();
ControllerNF controllerNF = new ControllerNF();
ModelNF modelNF = new ModelNF();
BLMascaras blMascaras = new BLMascaras();
DAORelatorios daoRelatorios = new DAORelatorios();

    
    @Override
    public void start(Stage vendaEmitidasStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/dialogoConsultaNfcesEmitidas.fxml")); 
        Parent raiz = loader.load();   
        vendaEmitidasStage.setScene(new Scene(raiz));
        raiz.getStylesheets().add("/FXView/entradas.css");
        raiz.getStyleClass().add("background");
        vendaEmitidasStage.initStyle(StageStyle.UNDECORATED);
        vendaEmitidasStage.initModality(Modality.APPLICATION_MODAL);

        vendaEmitidasStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private void definirTitulo(){
        modelConfiguracao = controllerConfiguracao.getConfiguracaoController(1);
        if (modelConfiguracao.getClassificacaoFiscal() == 0){
            lbTitulo.setText("Consulta Vendas");
            lbBarraTitulo.setText("Consulta Vendas Emitidas");
        }else{
            lbTitulo.setText("Consulta Notas Fiscais");
            lbBarraTitulo.setText("Consulta NFCe's Emitidas");
        }
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void consultaNfce(){

        float dinheiro = 0.0f;
        float cartaoCredito = 0.0f;;
        float cartaoDebito= 0.0f;;
        try {
            dataInicial = blMascaras.converterDataStringDataHifen(dtInicial.getValue().toString());
            dataFinal =  blMascaras.converterDataStringDataHifen(dtFinal.getValue().toString());
        } catch (Exception ex) {
            Logger.getLogger(consultaNfcesEmitidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelConfiguracao = controllerConfiguracao.getConfiguracaoController(1);
        
        if (modelConfiguracao.getClassificacaoFiscal() == 0){
            ArrayList<ModelVendas> listaVendasPeriodo = new ArrayList<>();
            listaVendasPeriodo = controllerVendas.getListaVendasPdvPorDataController(dataInicial ,dataFinal);
            System.out.println("tamanho lista" + listaVendasPeriodo.size());
            for (int i=0; i< listaVendasPeriodo.size(); i++){
         if (listaVendasPeriodo.get(i).getTipoPagamento()== 1){
             dinheiro += listaVendasPeriodo.get(i).getValorTotal();
         }
         else if (listaVendasPeriodo.get(i).getTipoPagamento() == 3){
             cartaoCredito += listaVendasPeriodo.get(i).getValorTotal();
         }
         else{
             cartaoDebito += listaVendasPeriodo.get(i).getValorTotal();
         }
         
        }
        }else{
            ArrayList<ModelNF> listaVendasPeriodo = new ArrayList<>();
            listaVendasPeriodo = controllerNF.getListaDataNFController(dataInicial, dataFinal, modeloConstante);
            for (int i=0; i< listaVendasPeriodo.size(); i++){
         if (listaVendasPeriodo.get(i).getCodFormaPgto() == 1){
             dinheiro += listaVendasPeriodo.get(i).getValorTotal();
         }
         else if (listaVendasPeriodo.get(i).getCodFormaPgto() == 3){
             cartaoCredito += listaVendasPeriodo.get(i).getValorTotal();
         }
         else{
             cartaoDebito += listaVendasPeriodo.get(i).getValorTotal();
         }
         
     }
        }
     
     tfDinheiro.setText(String.valueOf(dinheiro));
     tfCartaoCredito.setText(String.valueOf(cartaoCredito));
     tfCartaoDebito.setText(String.valueOf(cartaoDebito));
     tfTotal.setText(String.valueOf((cartaoCredito) + (dinheiro) + (cartaoDebito)));
     
     dialogoRelatorio();
    }
    
    private void dialogoRelatorio(){
        
        try {
            dataInicial = blMascaras.converterDataStringDataHifen(dtInicial.getValue().toString());
            dataFinal =  blMascaras.converterDataStringDataHifen(dtFinal.getValue().toString());
        } catch (Exception ex) {
            Logger.getLogger(consultaNfcesEmitidas.class.getName()).log(Level.SEVERE, null, ex);
        }
                    Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialogoExe.setHeaderText("RELATÓRIO DE VENDAS");
            dialogoExe.setContentText("Deseja Gerar o Relatorio de Vendas agora?");
            dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
            dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
            dialogoExe.showAndWait().ifPresent(b -> {
                if (b == btnSim) {
                    daoRelatorios.gerarRelatorioVendaPdvTodosCliente(dataInicial, dataFinal);
                    }else{
                    
                }
                    });
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        definirTitulo();
    }
    
   
}
