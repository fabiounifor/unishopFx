/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCsosnFederal;
import controller.ControllerTributacaoFederal;
import controller.ControllerModeloIpi;
import controller.ControllerEnquadramentoIpi;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelTributacaoFederal;
import model.ModelCsosnFederal;
import model.ModelIpi;
import model.ModelPisCofins;
import model.ModelEnquadramentoIpi;

import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class modeloIpi extends Application implements Initializable{
   
    @FXML TextField tfDescricaoIpi;
    @FXML ChoiceBox cbCstEntrada;
    @FXML ChoiceBox cbCstSaida;
    @FXML ChoiceBox cbEnquadramento;
    @FXML Button btGravarIpi;
    @FXML private Button btSair;
    int codigoIpi = 0;
    int status;
    
    
    ArrayList<TextField> campos = new ArrayList<>();
    ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
    ModelCsosnFederal modelCsosnFederal = new ModelCsosnFederal();
    ModelIpi modelIpi = new ModelIpi();
    ModelPisCofins modelPisCofins = new ModelPisCofins();
    ModelEnquadramentoIpi modelEnquadramentoIpi = new ModelEnquadramentoIpi();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerModeloIpi controllerModeloIpi = new ControllerModeloIpi();
    ControllerEnquadramentoIpi controllerEnquadramentoIpi = new ControllerEnquadramentoIpi();
    
    ArrayList<String> listaEnquadraMentoIpi = new ArrayList<>();
    ArrayList<String> listaEntradaIpi = new ArrayList<>();
    ArrayList<String> listaSaidaIpi = new ArrayList<>();
    
    ArrayList<ModelEnquadramentoIpi> listaModelEnquadraMentoIpi = new ArrayList<>();
   
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroIpi.fxml")); 
        Parent raiz = loader.load();   
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(new Scene(raiz));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      criarlistaIpiEntrada();
      criarlistaIpisSaida();
      criarlistaEnquadramento();
            
      novaTributacao();
      
    }
    
   public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
        
    @FXML
    public boolean salvarIpi() throws IOException {
              
        modelIpi.setDescricao(tfDescricaoIpi.getText().toUpperCase());
        modelIpi.setCstEntrada(Integer.parseInt(cbCstEntrada.getSelectionModel().getSelectedItem().toString().substring(0, 3)));
        modelIpi.setCstSaida(Integer.parseInt(cbCstSaida.getSelectionModel().getSelectedItem().toString().substring(0, 3)));
        modelIpi.setEnquadramento(Integer.parseInt(cbEnquadramento.getSelectionModel().getSelectedItem().toString().substring(0,3)));
        
                
//salvar 

if (codigoIpi > 0){
    modelIpi.setCodigo(codigoIpi);
    controllerModeloIpi.atualizarIPIController(modelIpi);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO ALTERADO?");
            alert.setContentText("TRIBUTO ALTERADO COM SUCESSO");
            if (status == 2){
      
                sair();
        //        atualizarLista();
            } else if (status == 1){
            
                sair();
        //        atualizarLista();
            }else if (status == 0){
            novaTributacao();
            }
            return true;
}else  if (controllerModeloIpi.salvarIPIController(modelIpi) > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("NOVA TRIBUTAÇÃO GRAVADA COM SUCESSO");
             if (status == 2){
            
            sair();
           //atualizarLista();
            } else if (status == 1){
            
            sair();
          //  atualizarLista();
            }else if (status == 0){
            
            sair();
          //  atualizarLista();
            }
             sair();
             return true;
            
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("ERRO AO SALVAR TRIBUTAÇÃO");
            return false;
        }

    }
       
    public void novaTributacao() {
        tfDescricaoIpi.setText("");
        cbCstEntrada.getItems().addAll(listaEntradaIpi);
        cbCstSaida.getItems().addAll(listaSaidaIpi);
        cbEnquadramento.getItems().addAll(listaEnquadraMentoIpi);
                       
    }
    
     private void criarlistaIpiEntrada() {
        listaModelEnquadraMentoIpi = controllerEnquadramentoIpi.getListaEnquadramentoIpiController();
        
        for (int i = 0; i < listaModelEnquadraMentoIpi.size(); i++) {
            String codigoIPIEN = String.valueOf(listaModelEnquadraMentoIpi.get(i).getCodigo());
            if (codigoIPIEN.length() < 2 ){
                codigoIPIEN = "00"+codigoIPIEN;
            }
            if (codigoIPIEN.length() == 2){
                codigoIPIEN = "0"+codigoIPIEN;
            }
            listaEntradaIpi.add(codigoIPIEN+"-"+listaModelEnquadraMentoIpi.get(i).getEntradaCst() + "-" + listaModelEnquadraMentoIpi.get(i).getGrupoCst());
            }
    }
     private void criarlistaIpisSaida() {
        listaModelEnquadraMentoIpi = controllerEnquadramentoIpi.getListaEnquadramentoIpiController();
        
        for (int i = 0; i < listaModelEnquadraMentoIpi.size(); i++) {
            String codigoIPIS = String.valueOf(listaModelEnquadraMentoIpi.get(i).getCodigo());
            if (codigoIPIS.length() < 2 ){
                codigoIPIS = "00"+codigoIPIS;
            }
            if (codigoIPIS.length() == 2){
                codigoIPIS = "0"+codigoIPIS;
            }
            
            listaSaidaIpi.add(codigoIPIS+"-"+listaModelEnquadraMentoIpi.get(i).getSaidaCst() + "-" + listaModelEnquadraMentoIpi.get(i).getGrupoCst());
            }
    }
     
    private void criarlistaEnquadramento() {
        listaModelEnquadraMentoIpi = controllerEnquadramentoIpi.getListaEnquadramentoIpiController();
        
        for (int i = 0; i < listaModelEnquadraMentoIpi.size(); i++) {
            String numero = String.valueOf(listaModelEnquadraMentoIpi.get(i).getNumero());
            String codigoIPIE = String.valueOf(listaModelEnquadraMentoIpi.get(i).getCodigo());
            if (numero.length() < 2 ){
                numero = "00"+numero;
            }
            if (numero.length() == 2){
                numero = "0"+numero;
            }
            if (codigoIPIE.length() < 2 ){
                codigoIPIE = "00"+codigoIPIE;
            }
            if (codigoIPIE.length() == 2){
                codigoIPIE = "0"+codigoIPIE;
            }
            String descricaoIpi = (listaModelEnquadraMentoIpi.get(i).getDescricao());
            if (descricaoIpi.length() > 80){
                descricaoIpi = descricaoIpi.substring(0, 80);
            }
            listaEnquadraMentoIpi.add(codigoIPIE+"-"+numero+"-"+descricaoIpi);
            }
    } 
       
}
