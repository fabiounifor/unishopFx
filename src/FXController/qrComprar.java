/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Fabio
 */
public class qrComprar extends Application implements Initializable {
    
    @FXML WebView qrCpainel;
    
    @Override
    public void start(Stage qrStage) throws IOException {
         FlowPane noRaiz = new FlowPane();
       
       //cena
      Scene minhaCena = new Scene(noRaiz, 800,600);
      
      //adciona WebView
      WebView wv = new WebView();
      
      
      //Adciona WebEngine
      WebEngine engine = wv.getEngine();
       
      //carrega a pagina
      engine.load("file:///C:/gestordepedidos/index.html");
      
      //Adciona o WebView ao Grafo de cena
      
      noRaiz.getChildren().add(wv);
 
      qrStage.setScene(minhaCena);
      qrStage.show();
        
       
    }
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    
}
