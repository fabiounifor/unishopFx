/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import static FXController.novoPrincipal.raizPrincipal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class saida extends Application implements Initializable{
    @FXML private Button btPdv;
    @FXML private Button btListaSaidas;
    @FXML private Button btQrcomprar;
    @FXML private Button btDelivery;
    @FXML private Button btMesas;
    @FXML private Button fechar;
    @FXML private Button nfe;
    
    
    
    @Override
    public void start(Stage saidaStage) throws IOException {
     
      FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/saidas.fxml")); 
      Parent raizSaida = loader.load();   
      Scene scene = new Scene(raizSaida, 800, 600);
      scene.setFill(null);
      saidaStage.setScene(scene);
      saidaStage.initStyle(StageStyle.TRANSPARENT);
      saidaStage.initModality(Modality.APPLICATION_MODAL);
      saidaStage.show();
    }
    
    public void fecharSaida(){
          Stage estagioSaida = (Stage) fechar.getScene().getWindow();
          estagioSaida.close();
        
                }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                
        fechar.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(KeyCode.ESCAPE == e.getCode()){
                 fecharSaida();
                }
            }
        });
    }
    
    public void delivery() throws IOException{
      pedidoVenda venda = new pedidoVenda();
        try {
            venda.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    
    }
     public void mesas(){
        lancaMesa mesas = new lancaMesa();
        try {
            mesas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
     public void entregas(){
        listaEntregas entregas = new listaEntregas();
        try {
            entregas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
      public void qrComprarConectar(){
        geradorSintegra gs = new geradorSintegra();
        try {
            gs.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
      public void listaSaidas(){
        listaVendas lv = new listaVendas();
        try {
            lv.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
       public void abrirPdv(){
        pdv pdvenda = new pdv();
        try {
            pdvenda.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
       public void abrirNfe(){
        nfeSaida nSaida = new nfeSaida();
        try {
            nSaida.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
}
