/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.acbr.nfe.demo.FrmMain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class auxiliares extends Application{
    @FXML private FlowPane auxiliaresPainel;

    @FXML  private Button btConfiguracoes;

    @FXML  private ImageView btRelatorios;

    @FXML  private Button btFiscais;

    @FXML  private Button fechar2;

    @FXML private Button btBackup;

    @Override
    public void start(Stage cadastroStage) throws Exception {
                
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastros.fxml")); 
                 
        Parent raiz = loader.load(); 
                      
        Scene scene = new Scene(raiz, 800, 600);
        scene.setFill(null);
        cadastroStage.setScene(scene);
        cadastroStage.initStyle(StageStyle.TRANSPARENT);
        cadastroStage.initModality(Modality.APPLICATION_MODAL);
        cadastroStage.show();
   
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void relatorios() throws Exception{
        Relatorios rel = new Relatorios();
        try {
            rel.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharAuxiliares();
    }
    
    
    public void configuracoes(){
            FrmMain configuracao = new FrmMain();
        try {
            configuracao.setVisible(true);
            configuracao.setSize(1000, 800);
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecharAuxiliares(){
    auxiliaresPainel.setVisible(false);
                }
}
