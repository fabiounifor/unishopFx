/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerGarcom;
import controller.ControllerCidadeEstado;
import controller.ControllerCidade;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelCidade;
import model.ModelCidadeEstado;
import model.ModelGarcom;
import org.controlsfx.control.textfield.TextFields;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class cadastroGarcon extends Application implements Initializable{
    
    @FXML TextField tfNome;
    @FXML TextField tfCEP;
    @FXML TextField tfCidade;
    @FXML TextField tfEstado;
    @FXML TextField tfEndereco;
    @FXML TextField tfTelefone;
    @FXML PasswordField pfSenha;
    @FXML PasswordField pfRepeteSenha;
    @FXML TextField tfBairro;
    @FXML TextField tfComissao;
    @FXML Button btGravar;
    @FXML private Button btSair;
    int codigo = 0;
    int status = 0;
    
    ArrayList<TextField> campos = new ArrayList<>();
    ModelGarcom modelGarcom = new ModelGarcom();
    ModelCidadeEstado modelCidadeEstado = new ModelCidadeEstado();
    ModelCidade modelCidade = new ModelCidade();
    ControllerGarcom controllerGarcom = new ControllerGarcom();
    ControllerCidadeEstado controllerCidadeEstado = new ControllerCidadeEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ArrayList<String> listaEstado = new ArrayList<>();
    ArrayList<String> listaCidade = new ArrayList<>();
    ArrayList<ModelCidadeEstado> listaModelEstado = new ArrayList<>();
    ArrayList<ModelCidade> listaModelCidade = new ArrayList<>();
       
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroGarcon.fxml")); 
        Parent raiz = loader.load();   
        primaryStage.setTitle("CADASTRO DE GARCON");
        primaryStage.setScene(new Scene(raiz));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
      novoGarcon();
      listaEnter();
      criarListaEstado();
      criarListaCidade();
      TextFields.bindAutoCompletion(tfEstado,listaEstado );
      TextFields.bindAutoCompletion(tfCidade,listaCidade );
      
      setNextFocus(tfNome, tfEstado, tfCEP, tfCidade, tfEndereco, tfTelefone, tfBairro, tfComissao);

    }
    
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    
    public void criarListaEstado(){
        listaModelEstado = controllerCidadeEstado.getListaCidadeEstadoController();
        for (int i = 0; i < listaModelEstado.size(); i++) {
            listaEstado.add(listaModelEstado.get(i).getModelEstado().getCodigo() + "-" +listaModelEstado.get(i).getModelEstado().getUf());
        }
    }
    public void criarListaCidade(){
        listaModelCidade = controllerCidade.getListaCidadeController();
        for (int i = 0; i < listaModelCidade.size(); i++) {
            listaCidade.add(listaModelCidade.get(i).getCodigo() + "-" +listaModelCidade.get(i).getNome());
        }
    }
        
    
    @FXML
    public boolean salvarGarcon() throws IOException {
        System.out.println(codigo);
        modelGarcom.setNome(tfNome.getText().toUpperCase());
        modelGarcom.setEndereco(tfEndereco.getText());
        modelGarcom.setCep(tfCEP.getText());
        modelGarcom.setCodCidade(Integer.parseInt(tfCidade.getText(0,2)));
        modelGarcom.setCodEstado(Integer.parseInt(tfEstado.getText(0,2)));
        modelGarcom.setTelefone(tfTelefone.getText());
        modelGarcom.setSenha(pfSenha.getText());
        modelGarcom.setComissao(Float.parseFloat(tfComissao.getText()));
        modelGarcom.setBairro(tfBairro.getText());
        
        
//salvar 

if ( codigo > 0){
    modelGarcom.setCodigo(codigo);
    controllerGarcom.atualizarGarcomController(modelGarcom);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("GARÇON ALTERADO?");
            alert.setContentText("GARÇON ALTERADO COM SUCESSO");
            alert.show();
            sair();
            return true;
}else  if (controllerGarcom.salvarGarcomController(modelGarcom) > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("NOVO GARCON GRAVADO COM SUCESSO");
            alert.show();
            sair();
             return true;
            
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("ERRO AO SALVAR GARCON");
            alert.show();
            sair();
            return false;
        }

    }

    
    /*public void atualizarLista() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqTribEstadual.fxml"));
        Parent raizListaProduto = (Parent) loader.load();
        lista produto = loader.getController();
        produto.listaTodos();
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizListaProduto));
        pagStage.show();
                
    }*/
    
    public void novoGarcon() {
        tfNome.setText("");
        tfEstado.setText("32-ES");
        tfCEP.setText("29200-000");
        tfCidade.setText("3125-GUARAPARI");
        tfEndereco.setText("");
        tfTelefone.setText("");
        pfSenha.setText("");
        pfRepeteSenha.setText("");
       
    }
    public void listaEnter(){
        
        campos.add(tfNome);
        campos.add(tfEstado);
        campos.add(tfCEP);
        campos.add(tfCidade);
        campos.add(tfEndereco);
        campos.add(tfTelefone);
        campos.add(pfSenha);
        campos.add(pfRepeteSenha);
        campos.add(tfBairro);
        campos.add(tfComissao);
        
       }
    public void setNextFocus(TextField tfNome, TextField tfEstado,TextField tfCEP,TextField tfCidade, TextField tfEndereco, 
            TextField tfTelefone, TextField tfComissao, TextField tfBairro) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    } 
    
    public void AlterarGarcon(int codigolocal){
        codigo = codigolocal;
        tfNome.setText(controllerGarcom.getGarcomController(codigo).getNome());
        tfBairro.setText(controllerGarcom.getGarcomController(codigo).getBairro());
        tfCEP.setText(controllerGarcom.getGarcomController(codigo).getCep());
        tfCidade.setText(controllerGarcom.getGarcomController(codigo).getCodCidade()+"-" + (controllerCidade.getCidadeController(controllerGarcom.getGarcomController(codigo).getCodCidade()).getNome()));
        tfEstado.setText((controllerGarcom.getGarcomController(codigo).getCodEstado())+"-"+ (controllerCidade.getCidadeController(controllerGarcom.getGarcomController(codigo).getCodEstado())).getNome());
        tfEndereco.setText(controllerGarcom.getGarcomController(codigo).getEndereco());
        tfTelefone.setText(controllerGarcom.getGarcomController(codigo).getTelefone());
        pfSenha.setText(controllerGarcom.getGarcomController(codigo).getSenha());
        pfRepeteSenha.setText(controllerGarcom.getGarcomController(codigo).getSenha());
        tfComissao.setText(String.valueOf(controllerGarcom.getGarcomController(codigo).getComissao()));
                
    }
    public void DuplicarGarcon(int codigo){
        
        tfNome.setText(controllerGarcom.getGarcomController(codigo).getNome());
        tfBairro.setText(controllerGarcom.getGarcomController(codigo).getBairro());
        tfCEP.setText(controllerGarcom.getGarcomController(codigo).getCep());
        tfCidade.setText(controllerGarcom.getGarcomController(codigo).getCodCidade()+"-" + (controllerCidade.getCidadeController(controllerGarcom.getGarcomController(codigo).getCodCidade()).getNome()));
        tfEstado.setText((controllerGarcom.getGarcomController(codigo).getCodEstado())+"-"+ (controllerCidade.getCidadeController(controllerGarcom.getGarcomController(codigo).getCodEstado())).getNome());
        tfEndereco.setText(controllerGarcom.getGarcomController(codigo).getEndereco());
        tfTelefone.setText(controllerGarcom.getGarcomController(codigo).getTelefone());
        pfSenha.setText(controllerGarcom.getGarcomController(codigo).getSenha());
        pfRepeteSenha.setText(controllerGarcom.getGarcomController(codigo).getSenha());
        tfComissao.setText(String.valueOf(controllerGarcom.getGarcomController(codigo).getComissao()));
        
    }
    
    
    

}
