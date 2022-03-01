/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerCsosnFederal;
import controller.ControllerTributacaoFederal;
import controller.ControllerModeloPisCofins;
import controller.ControllerCstPiscofins;
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
import model.ModelCstPiscofins;
import model.ModelPisCofins;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class modeloPisCofins extends Application implements Initializable{
   
    @FXML TextField tfDescricaoPisCofins;
    @FXML ChoiceBox cbPISEntrada;
    @FXML ChoiceBox cbPISSaida;
    @FXML ChoiceBox cbCofinsEntrada;
    @FXML ChoiceBox cbCofinsSaida;
    @FXML Button btGravarCofins;
    @FXML private Button btSair;
    int codigoPisCofins = 0;
    int status;
    
    
    ArrayList<TextField> campos = new ArrayList<>();
    ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
    ModelCsosnFederal modelCsosnFederal = new ModelCsosnFederal();
    ModelCstPiscofins modelCstPiscofins = new ModelCstPiscofins();
    ModelPisCofins modelPisCofins = new ModelPisCofins();
    ControllerCsosnFederal controllerCsosnFederal = new ControllerCsosnFederal();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerModeloPisCofins controllerModeloPisCofins = new ControllerModeloPisCofins();
    ControllerCstPiscofins controllerCstPiscofins = new ControllerCstPiscofins();
    ArrayList<String> listaCsosnFederal = new ArrayList<>();
    ArrayList<ModelCsosnFederal> listaModelCsosnFederal = new ArrayList<>();
    ArrayList<String> listaCstPisCofins = new ArrayList<>();
    ArrayList<String> listaCstCofins = new ArrayList<>();
    ArrayList<String> listaCstPis = new ArrayList<>();
    ArrayList<ModelCstPiscofins> listaModelCstPiscofins = new ArrayList<>();
   
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroPisCofins.fxml")); 
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
      criarlistaCofinsEntrada();
      criarlistaCofinsSaida();
      criarlistaPisEntrada();
      criarlistaPisSaida();
      
      novaTributacao();
      
    }
    
      public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
        
    @FXML
    public boolean salvarPisCofins() throws IOException {
              
        modelPisCofins.setDescricao(tfDescricaoPisCofins.getText().toUpperCase());
        modelPisCofins.setCofinsEntrada(controllerModeloPisCofins.getPiscofinsController(Integer.parseInt(cbCofinsEntrada.getSelectionModel().getSelectedItem().toString().substring(0,2))).getCofinsEntrada());
        modelPisCofins.setCofinsSaida(controllerModeloPisCofins.getPiscofinsController(Integer.parseInt(cbCofinsSaida.getSelectionModel().getSelectedItem().toString().substring(0,2))).getCofinsSaida());
        modelPisCofins.setPisEntrada(controllerModeloPisCofins.getPiscofinsController(Integer.parseInt(cbPISEntrada.getSelectionModel().getSelectedItem().toString().substring(0,2))).getPisEntrada());
        modelPisCofins.setPisEntrada(controllerModeloPisCofins.getPiscofinsController(Integer.parseInt(cbPISEntrada.getSelectionModel().getSelectedItem().toString().substring(0,2))).getPisSaida());
                
//salvar 

if (codigoPisCofins > 0){
    modelPisCofins.setCodigo(codigoPisCofins);
    controllerModeloPisCofins.atualizarPiscofinsController(modelPisCofins);
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
}else  if (controllerModeloPisCofins.salvarPiscofinsController(modelPisCofins) > 0) {
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
            alert.setContentText("ERRO AO SALVAR PRODUTO");
            return false;
        }

    }
        
       
    public void novaTributacao() {
        tfDescricaoPisCofins.setText("");
        cbCofinsEntrada.getItems().addAll(listaCstCofins);
        cbCofinsSaida.getItems().addAll(listaCsosnFederal);
        cbPISSaida.getItems().addAll(listaCsosnFederal);
        cbPISEntrada.getItems().addAll(listaCstPis);
               
    }
    
     private void criarlistaCofinsEntrada() {
        listaModelCstPiscofins = controllerCstPiscofins.getListaCstPiscofinsController();
        
        for (int i = 0; i < listaModelCstPiscofins.size(); i++) {
           if (listaModelCstPiscofins.get(i).getNumero() < 50){
               String numero = String.valueOf(listaModelCstPiscofins.get(i).getNumero());
                if(numero.length() < 2){
                    numero = "0"+ numero+"";
                    System.out.println(numero + "cofins");
                }
              listaCstCofins.add(numero + "-" + listaModelCstPiscofins.get(i).getDescricao());
            }
            }
    }
     private void criarlistaCofinsSaida() {
       listaModelCsosnFederal = controllerCsosnFederal.getListaCsosnFederalController();
        for (int i = 0; i < listaModelCsosnFederal.size(); i++) {
             String numero = String.valueOf(listaModelCsosnFederal.get(i).getNumero());
                if(numero.length() < 2){
                    numero = "0"+ numero+"";
                    
                }
            listaCsosnFederal.add(numero+ "-" +listaModelCsosnFederal.get(i).getDescricao());
            }
    }
     
    private void criarlistaPisEntrada() {
       listaModelCstPiscofins = controllerCstPiscofins.getListaCstPiscofinsController();
        for (int i = 0; i < listaModelCstPiscofins.size(); i++) {
            if (listaModelCstPiscofins.get(i).getNumero() > 49){
                String numero = String.valueOf(listaModelCstPiscofins.get(i).getNumero());
                if(numero.length() < 2){
                    numero = "0"+ numero+"";
                }
         listaCstPis.add(numero + "-" + listaModelCstPiscofins.get(i).getDescricao());
            }
        }
    } 
    private void criarlistaPisSaida() {
        listaModelCsosnFederal = controllerCsosnFederal.getListaCsosnFederalController();
        for (int i = 0; i < listaModelCsosnFederal.size(); i++) {
              String numero = String.valueOf(listaModelCsosnFederal.get(i).getNumero());
                if(numero.length() < 2){
                    numero = "0"+ numero+"";
                }
            listaCsosnFederal.add(numero + "-" +listaModelCsosnFederal.get(i).getDescricao() );
            }
    }
   
}
