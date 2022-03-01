/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class cadastro extends Application{
    @FXML private Button btPessoas;
    @FXML private Button btProdutos;
    @FXML private Button btServicos;
    @FXML private Button btTriEstadual;
    @FXML private Button btTriMunicipal;
    @FXML private Button btTriFederal;
    @FXML private Button btConversao;
    @FXML private Button btUnidades;
    @FXML private Button btGarcon;
    @FXML private Button fechar;

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
    
    public void pessoas(){
        listaCliente cliente = new listaCliente();
        try {
            cliente.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void produtos(){
        listaProduto produto = new listaProduto();
        try {
            produto.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    public void unidades(){
        listaUnidade unidade = new listaUnidade();
        try {
            unidade.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void fatores(){
        listaCfop fator = new listaCfop();
        try {
            fator.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    public void opcionais(){
        listaOpcionais opcao = new listaOpcionais();
        try {
            opcao.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void tributacaoEstadual(){
        listaTributacaoEstadual tribest = new listaTributacaoEstadual();
        try {
            tribest.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
     public void tributacaoFederal(){
        listaTributacaoFederal trifed = new listaTributacaoFederal();
        try {
            trifed.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    public void garcon(){
        listaGarcon lGarcon = new listaGarcon();
        try {
            lGarcon.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void fecharCadastro(){
          Stage estagiosaida = (Stage) fechar.getScene().getWindow();
          estagiosaida.close();
        
                }
    
}
