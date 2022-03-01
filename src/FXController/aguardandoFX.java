/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Fabio
 */
public class aguardandoFX extends Application {
    
    @FXML ProgressBar progresso;
    @FXML Label aguarde;
    
    @Override
    public void start(Stage aguardeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/aguardeGerando.fxml")); 
        Parent raiz = loader.load(); 
        Scene scene = new Scene(raiz, 600, 300);
        
        scene.setFill(null);
        aguardeStage.setScene(scene);
        aguardeStage.initStyle(StageStyle.TRANSPARENT);
        aguardeStage.initModality(Modality.APPLICATION_MODAL);
        aguardeStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void fechar(){
        Stage estagioAguardando = (Stage) aguarde.getScene().getWindow();
        estagioAguardando.close();
    }
    
}
