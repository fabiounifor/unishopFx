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
import model.ModelOpcionais;
import controller.ControllerOpcoes;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelGrupo;
import controller.ControllerGRUPO;

/**
 *
 * @author Fabio
 */
public class cadastroOpcionais extends Application implements Initializable{
    
    @FXML private Button btGravar;

    @FXML private ChoiceBox<String> cbTipo;

    @FXML private TextField tfDescricao;
    
    @FXML private ImageView caminhoImagem ;
    
    @FXML private Button btSair;
    
    ControllerOpcoes controllerOpcoes = new ControllerOpcoes();
    
    String origem = "";
    int codigoGeral;
    ControllerGRUPO controllerGrupo = new ControllerGRUPO();
    ArrayList<ModelGrupo> listaModelGrupo = new ArrayList<>();
    ObservableList<String> listaGrupos;
    ArrayList<String> listadeGrupos = new ArrayList<>();
    
    @Override
    public void start(Stage listaUnidadeStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroOpcionais.fxml")); 
        Parent raiz = loader.load();   
        listaUnidadeStage.setScene(new Scene(raiz));
        listaUnidadeStage.setTitle("CADASTRO OPCIONAIS");
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
     criarListaGrupos();
            
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void criarListaGrupos(){
        listaModelGrupo = controllerGrupo.getListaGRUPOController();
        for (int i = 0; i < listaModelGrupo.size(); i++) {
            listadeGrupos.add(listaModelGrupo.get(i).getDescricao());
        }
        listaGrupos = FXCollections.observableArrayList(listadeGrupos);
        cbTipo.setItems(listaGrupos);
    }
    
    public void salvarOpcionais(){
        ModelOpcionais modelOpcionais = new ModelOpcionais();
        modelOpcionais.setDescricao(tfDescricao.getText());
        modelOpcionais.setImagem(String.valueOf(caminhoImagem.getImage()));
        modelOpcionais.setTipo(cbTipo.getSelectionModel().getSelectedIndex());
        modelOpcionais.setCodigo(modelOpcionais.getCodigo());
        if(origem.equalsIgnoreCase("alterar")){
            modelOpcionais = controllerOpcoes.getOpcoesController(codigoGeral);
            modelOpcionais.setDescricao(tfDescricao.getText());
            modelOpcionais.setImagem(String.valueOf(caminhoImagem.getImage()));
            modelOpcionais.setTipo(cbTipo.getSelectionModel().getSelectedIndex());
            modelOpcionais.setCodigo(codigoGeral);
            controllerOpcoes.atualizarOpcoesController(modelOpcionais);
        }else{
            controllerOpcoes.salvarOpcoesController(modelOpcionais);
        }
               
      sair();  
    }
    
    public void alterarOpcional(int codigo){
        ModelOpcionais modelOpcionais = new ModelOpcionais();
        modelOpcionais = controllerOpcoes.getOpcoesController(codigo);
        codigoGeral = codigo;
        cbTipo.getSelectionModel().select(cbTipo.getItems().get(modelOpcionais.getTipo()));
        tfDescricao.setText(modelOpcionais.getDescricao());
    }

   
    }
    
    

