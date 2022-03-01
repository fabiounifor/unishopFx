/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerTributacaoFederal;
import controller.ControllerModeloIpi;
import controller.ControllerModeloPisCofins;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelTributacaoFederal;
import model.ModelCsosn;
import model.ModelIpi;
import model.ModelPisCofins;
import org.controlsfx.control.textfield.TextFields;
import unishop.Unishop;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class tributacaoFederal extends Application implements Initializable{
   
    @FXML TextField tfDescricao;
    @FXML TextField tfidIPI;
    @FXML TextField tfIdPisCofins;
    @FXML Button btGravar;
    @FXML Button btIpi;
    @FXML Button btPisCofins;
    @FXML Button btSair;
    int codigoTributacaoFederal = 0;
    int status;
    
    
    ArrayList<TextField> campos = new ArrayList<>();
    ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
    ModelCsosn modelCsosn = new ModelCsosn();
    ModelPisCofins modelPisCofins = new ModelPisCofins();
    ModelIpi modelIpi = new ModelIpi();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerModeloIpi controllerModeloIpi = new ControllerModeloIpi();
    ControllerModeloPisCofins controllerModeloPisCofins = new ControllerModeloPisCofins();
    ArrayList<String> listaIpi = new ArrayList<>();
    ArrayList<ModelIpi> listaModelIpi = new ArrayList<>();
    ArrayList<String> listaPisCofins = new ArrayList<>();
    ArrayList<ModelPisCofins> listaModelPisCofins = new ArrayList<>();
    
    
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroTribFederal.fxml")); 
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
      
      novaTributacao();
      listaEnter();
      criarlistaIPI();
      criarlistaPisCofins();
      TextFields.bindAutoCompletion(tfIdPisCofins, listaPisCofins);
      TextFields.bindAutoCompletion(tfidIPI, listaIpi);
    }
    
   public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
        
    @FXML
    public boolean salvarTributacaoFederal() throws IOException {
              
        modelTributacaoFederal.setDescricao(tfDescricao.getText().toUpperCase());
        modelTributacaoFederal.setIdIpi(Integer.parseInt(tfidIPI.getText(0,2)));
        modelTributacaoFederal.setIdPisCofins(Integer.parseInt(tfIdPisCofins.getText(0,2)));
        
//salvar 

if (codigoTributacaoFederal > 0){
    modelTributacaoFederal.setCodigo(codigoTributacaoFederal);
    controllerTributacaoFederal.atualizarTributacaoFederalController(modelTributacaoFederal);
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
}else  if (controllerTributacaoFederal.salvarTributacaoFederalController(modelTributacaoFederal) > 0) {
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
        tfDescricao.setText("");
        tfidIPI.setText("");
        tfIdPisCofins.setText("");
               
    }
    public void listaEnter(){
        
        campos.add(tfDescricao);
        campos.add(tfidIPI);
        campos.add(tfIdPisCofins);
                
       }
    public void criarlistaIPI(){
        listaModelIpi = controllerModeloIpi.getListaIPIController();
        for (int i = 0; i < listaModelIpi.size(); i++) {
             String numero = String.valueOf(listaModelIpi.get(i).getCodigo());
                if(numero.length() < 2){
                    numero = "0"+ numero+"";
                    
                }
            listaIpi.add(numero+ "-" +listaModelIpi.get(i).getDescricao());
            }
    
        
    }
    public void criarlistaPisCofins(){
            listaModelPisCofins = controllerModeloPisCofins.getListaPiscofinsController();
        for (int i = 0; i < listaModelPisCofins.size(); i++) {
             String numero = String.valueOf(listaModelPisCofins.get(i).getCodigo());
                if(numero.length() < 2){
                    numero = "0"+ numero+"";
                    
                }
            listaPisCofins.add(numero+ "-" +listaModelPisCofins.get(i).getDescricao());
            }
    
        
        
    }
    
    public void setNextFocus(TextField tfDescricao, TextField tfidIPI,TextField tfIdPisCofins) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    } 
    
    public void AlterarTributacao(int codigo){
        modelTributacaoFederal.setDescricao(controllerTributacaoFederal.getTributacaoFederalController(codigo).getDescricao());
        modelTributacaoFederal.setIdIpi(controllerTributacaoFederal.getTributacaoFederalController(codigo).getIdIpi());
        modelTributacaoFederal.setIdPisCofins(controllerTributacaoFederal.getTributacaoFederalController(codigo).getIdPisCofins());
        
        
    }
   public void novaListaPisCofins(){
        listaPisCofins lPisCofins = new listaPisCofins();
        try {
            lPisCofins.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public void novaListaIpi(){
        listaIPI lIpi = new listaIPI();
        try {
            lIpi.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

}
