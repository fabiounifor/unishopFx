/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

/**
 *
 * @author Fabio
 */
public class transferirMesa extends Application implements Initializable {
    
    @FXML TextField tfOrigem;
    @FXML TextField tfDestino;
    @FXML Button btTranferir;
    @FXML Button btSair;
  
    ArrayList<TextField> campos = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/dialogoTransferirMesa.fxml"));
        Parent raizTransferir = (Parent) loader.load();
        transferirMesa tm = loader.getController();
        Stage tmStage = new Stage();
        tmStage.setScene(new Scene(raizTransferir));
        tmStage.initStyle(StageStyle.UNDECORATED);
        tmStage.initModality(Modality.APPLICATION_MODAL);
        tmStage.show();
        
    }   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       listaEnter();
       setNextFocus(tfOrigem, tfDestino);     
    }
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void listaEnter(){
        
        campos.add(tfOrigem);
        campos.add(tfDestino);
        
    
                  
       }
    public void setNextFocus(TextField tfOrigem, TextField tfDestino) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    }
    public void voltarPraVenda(ActionEvent event) throws IOException{
       int origem = Integer.parseInt(tfOrigem.getText());
       int destino = Integer.parseInt(tfDestino.getText());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/mesasLancamento.fxml"));
        Parent raizMesas = (Parent) loader.load();
        lancaMesa mesas = loader.getController();
        Stage mesasStage = new Stage();
        mesasStage.setScene(new Scene(raizMesas));
        mesas.transferirMesa(origem, destino);
        fecharTransferir();
    }
    public void fecharTransferir(){
          Stage estagioTransferir = (Stage) tfOrigem.getScene().getWindow();
          estagioTransferir.close();
          
          }
    
    
}
    

