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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ModelFator;
import controller.ControllerFator;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 *
 * @author Fabio
 */
public class cadastroFator extends Application implements Initializable{
    
    @FXML private Button btGravar;

    @FXML private TextField tfFator;

    @FXML private ChoiceBox<String> cbOperador;

    @FXML private TextField tfDescricao;
    
    @FXML private Button btSair;
    
    ControllerFator controllerFator = new ControllerFator();
    
    int origem;
    
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroFator.fxml")); 
        Parent raiz = loader.load();   
        listaUnidadeStage.setScene(new Scene(raiz));
        listaUnidadeStage.setTitle("CADASTRO FATOR DE CONVERSÃO");
        listaUnidadeStage.initStyle(StageStyle.UNDECORATED);
        listaUnidadeStage.initModality(Modality.APPLICATION_MODAL);
        listaUnidadeStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     iniciaParcelas();      
            
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    public void iniciaParcelas(){
       cbOperador.getItems().addAll("MULTIPLICA", "DIVIDE");
    }
    
    public void salvarFator(){
        ModelFator modelFator = new ModelFator();
        String operacao = "";
        if (cbOperador.getSelectionModel().getSelectedIndex() == 0){
            operacao = "*";
            
        }else if (cbOperador.getSelectionModel().getSelectedIndex() == 1){
        
            operacao = "/";
    }
        modelFator.setDescricao(tfDescricao.getText());
        modelFator.setOperando(operacao);
        modelFator.setFator(Float.parseFloat(tfFator.getText()));
       System.out.println(modelFator);
        controllerFator.salvarFatorController(modelFator);
        
      sair();  
    }

   
    }
    
    

