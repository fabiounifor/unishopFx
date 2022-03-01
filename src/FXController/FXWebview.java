/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Fabio
 */
public class FXWebview extends Application{
 

    @Override
    public void start(Stage primaryStage) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Parent root = loader.load(); 
        
       // layout 
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
 
      primaryStage.setScene(minhaCena);
      primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
   
 }
