/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import interfaces.classeInterfaces;
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
public class entrada extends Application implements Initializable{
    @FXML private Button btEntradas;
    @FXML private Button btImportar;
    @FXML private Button btNfeEntrada;
    @FXML private Button btConsultaSefaz;
    @FXML private Button fechar;
 
    
    
    @Override
    public void start(Stage entradaStage) throws IOException {
      FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/entradas.fxml")); 
      Parent raiz = loader.load();   
      Scene scene = new Scene(raiz, 800, 600);
        scene.setFill(null);
        entradaStage.setScene(scene);
        entradaStage.initStyle(StageStyle.TRANSPARENT);
        entradaStage.initModality(Modality.APPLICATION_MODAL);
        entradaStage.show();
    }
    public void fecharEntrada(){
          Stage estagioEntrada = (Stage) fechar.getScene().getWindow();
          estagioEntrada.close();
        
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
                    fecharEntrada();
                }
            }
        });
    }
    
    public void listaEntradas(){
        listaCompras lc = new listaCompras();
        try {
            lc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
     public void importarXml(){
        relacionaCompra rCompra = new relacionaCompra();
        try {
            rCompra.start(new Stage());
            classeInterfaces.avisaOuvintesCaminho("novaTela","0");
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
      public void nfeEntrada(){
        qrComprar qrc = new qrComprar();
        try {
            qrc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
      public void consultaSefaz(){
        listaDfe ld = new listaDfe();
        try {
            ld.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
      
}
