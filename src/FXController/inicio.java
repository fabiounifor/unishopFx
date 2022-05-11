/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package FXController;

import interfaces.classeInterfaces;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author Fabio
 */
public class inicio extends Preloader implements Initializable{
    
    @FXML public ProgressIndicator bar;
    @FXML public Stage stage;
    boolean fecharJanela = false;
    private Scene createPreloaderScene() {
        bar = new ProgressIndicator();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p);        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/inicio.fxml")); 
        Parent root = loader.load(); 
        inicio ini = loader.getController();
        this.stage = stage;
        this.stage.setScene(new Scene(root));
        this.stage.setMaximized(true);
        this.stage.initStyle(StageStyle.TRANSPARENT);        
        this.stage.show();
    }
    
    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        
 if (scn.getType() == StateChangeNotification.Type.BEFORE_INIT) {
     fechar();
    }
    }
    public void fechar(){
    
    if (fecharJanela  == true){
    final Timeline timeline = new Timeline();
    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5),ev -> {
        Stage stagio = (Stage)bar.getScene().getWindow();
        stagio.close();
    }));
        timeline.setCycleCount(Animation.INDEFINITE);
    timeline.setAutoReverse(true);
    timeline.play();           
    }
    }
    
    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        
    }    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        classeInterfaces.addaoMudarTelaOuvinteProgresso((String novaTela, Boolean ativo) -> {
            fecharJanela = true;
            fechar();
        });
    }
    
}
