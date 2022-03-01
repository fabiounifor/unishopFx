/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import controller.ControllerOpcoes;
import model.ModelOpcionais;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import interfaces.classeInterfaces;

/**
 *
 * @author Fabio
 */
public class opcionaisPedidos extends Application implements Initializable{
   
    @FXML private Button btGravar;
    @FXML private Label lbTotal;
    @FXML ToggleButton opcaoBotao;
    @FXML FlowPane painelOpcoesFlow;
    
    int tipoRecorrente;
    ArrayList<ToggleButton> listadeBotoes = new ArrayList<>();
    ArrayList<ModelOpcionais> listaOpcionais = new ArrayList<>();
    ControllerOpcoes controllerOpcoes = new ControllerOpcoes();

    @Override
    public void start(Stage cadastroStage) throws Exception {
                
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/opcoesPedidos.fxml")); 
                 
        Parent raiz = loader.load(); 
                      
        Scene scene = new Scene(raiz);
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
    
        public void popularTabela(int tipo) {
        tipoRecorrente = tipo;    
        painelOpcoesFlow.getChildren().clear();
        
        listaOpcionais = controllerOpcoes.getListaOpcoesTipoController(tipo);
        for (int i = 0; i < listaOpcionais.size(); i++) {
            int espacoh = 100;
            int espacov = 50;
            opcaoBotao = new ToggleButton();
            opcaoBotao.setText(listaOpcionais.get(i).getDescricao());
            opcaoBotao.setMinWidth(espacoh);
            opcaoBotao.setMinHeight(espacov);
            opcaoBotao.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    preencherObservacao();
                }
                
            });  
               
            
            listadeBotoes.add(opcaoBotao);
            painelOpcoesFlow.getChildren().addAll(opcaoBotao);    
        }
}
        
        public String preencherObservacao(){
            String observacao = "";
            int total = 0;
            for (int i=0; i<listadeBotoes.size(); i++){
                if (listadeBotoes.get(i).isSelected()){
                    observacao = observacao + listadeBotoes.get(i).getText() + " - ";
                    listadeBotoes.get(i).setStyle("-fx-base: #DDA0DD");
                    total = total + 1;
                }else{
                    listadeBotoes.get(i).setStyle("-fx-base: White");
                }
                lbTotal.setText(String.valueOf(total));
            }
            
            return observacao;
        }
        
        public void retornaObservacao(){
          classeInterfaces.avisaOuvintesOpcionais("pedidoVEnda", preencherObservacao());
         fecharOpcoes();
        }
    
   
    
    public void fecharOpcoes(){
          Stage estagiosaida = (Stage) btGravar.getScene().getWindow();
          estagiosaida.close();
        
                }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      lbTotal.setText("");
    }
    
}
