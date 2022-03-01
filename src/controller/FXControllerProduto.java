/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.ModelProdutos;

/**
 *
 * @author FABIO
 */
public class FXControllerProduto extends Application {
    
    @FXML
    private Button btPesquisa;
    private TextField tfPesquisa;
    private Button btEditar;
    private Button btAdcionar;
    private Button btDuplicar;
    private TableColumn tbProdutos;
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public void listarprodutos(){
        ModelProdutos modelprodutos = new ModelProdutos();
        ControllerProdutos controllerprodutos = new ControllerProdutos();
        
        
        
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @FXML
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
