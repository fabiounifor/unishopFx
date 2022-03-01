/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

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
public class financeiro extends Application implements Initializable{
    @FXML private Button btPdv;
    @FXML private Button btListaSaidas;
    @FXML private Button btQrcomprar;
    @FXML private Button btDelivery;
    @FXML private Button btMesas;
    @FXML private Button fechar;
    
    
    @Override
    public void start(Stage financeiroStage) throws IOException {
      FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/financeiro.fxml")); 
      Parent raiz = loader.load();   
      Scene scene = new Scene(raiz, 800, 600);
        scene.setFill(null);
        financeiroStage.setScene(scene);
        financeiroStage.initStyle(StageStyle.TRANSPARENT);
        financeiroStage.initModality(Modality.APPLICATION_MODAL);
        financeiroStage.show();
    }
    public void fecharFinanceiro(){
          Stage estagiofinanceiro = (Stage) fechar.getScene().getWindow();
          estagiofinanceiro.close();
        
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
                    fecharFinanceiro();
                }
            }
        });
    }
    
    public void caixa(){
        controleCaixa cx = new controleCaixa();
        try {
            cx.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
    
    public void contaReceber(){
        contasReceber cr = new contasReceber();
        try {
            cr.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
    
    public void contaPagar(){
        contasPagar cp = new contasPagar();
        try {
            cp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
     /*public void mesas(){
        lancaMesa mesas = new lancaMesa();
        try {
            mesas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
      public void qrComprarConectar(){
        qrComprar qrc = new qrComprar();
        try {
            qrc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }*/
}
