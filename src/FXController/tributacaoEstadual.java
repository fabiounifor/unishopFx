/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerCFOP;
import controller.ControllerCidadeEstado;
import controller.ControllerCsosn;
import controller.ControllerCst;
import controller.ControllerTributacaoEstadual;
import controller.ControllerNCM;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelCidadeEstado;
import model.ModelTributacaoEstadual;
import model.ModelCFOP;
import model.ModelCsosn;
import model.ModelCst;
import org.controlsfx.control.textfield.TextFields;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class tributacaoEstadual extends Application implements Initializable{
    
    @FXML TextField tfDescricao;
    @FXML TextField tfEstado;
    @FXML ChoiceBox cbOrigem;
    @FXML TextField tfCSOSN;
    @FXML TextField tfCFOP;
    @FXML TextField tfPercentual;
    @FXML TextField tfBasedeCalculo;
    @FXML TextField tfBasedeCalculoSub;
    @FXML TextField tfBasedeCalculoSubEfetivo;
    @FXML TextField tfBasedeCalculoICMS;
    @FXML TextField tfBasedeCalculoICMSRetido;
    @FXML Button btGravar;
    @FXML Button btSair;
    
    int codigoTributacaoEstadual = 0;
    int status;
    
    
    ArrayList<TextField> campos = new ArrayList<>();
    ModelTributacaoEstadual modelTributacaoEstadual = new ModelTributacaoEstadual();
    ModelCFOP modelCFOP = new ModelCFOP();
    ModelCsosn modelCsosn = new ModelCsosn();
    ModelCst modelCst = new ModelCst();
    ModelCidadeEstado modelCidadeEstado = new ModelCidadeEstado();
    ControllerCFOP controllerCFOP = new ControllerCFOP();
    ControllerCsosn controllerCsosn = new ControllerCsosn();
    ControllerCst controllerCst = new ControllerCst();
    ControllerNCM controllerNCM = new ControllerNCM();
    ControllerCidadeEstado controllerCidadeEstado = new ControllerCidadeEstado();
    ControllerTributacaoEstadual controllerTributacaoEstadual = new ControllerTributacaoEstadual();
    ArrayList<String> listaOrigem = new ArrayList<>();
    ArrayList<String> listaCfop = new ArrayList<>();
    ArrayList<ModelCFOP> listaModelCfop = new ArrayList<>();
    ArrayList<String> listaEstado = new ArrayList<>();
    ArrayList<ModelCidadeEstado> listaModelEstado = new ArrayList<>();
    ArrayList<String> listaCsosn = new ArrayList<>();
    ArrayList<ModelCsosn> listaModelCsosn = new ArrayList<>();
   
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroTribEstadual.fxml")); 
        Parent raiz = loader.load();   
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(new Scene(raiz));
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
      
      novaTributacao();
      listaOrigem();
      listaEnter();
      criarListaCfop();
      criarListacsosn();
      criarListaEstado();
      TextFields.bindAutoCompletion(tfCFOP,listaCfop );
      TextFields.bindAutoCompletion(tfCSOSN,listaCsosn );
      TextFields.bindAutoCompletion(tfEstado,listaEstado );
      setNextFocus(tfDescricao, tfEstado, tfCSOSN, tfCFOP, tfPercentual, tfBasedeCalculo, tfBasedeCalculoSub, tfBasedeCalculoSubEfetivo, tfBasedeCalculoICMS, tfBasedeCalculoICMSRetido);

    }
    
    public void criarListaCfop(){
        listaModelCfop = controllerCFOP.getListaCFOPController();
        
        for (int i = 0; i < listaModelCfop.size(); i++) {
            if (listaModelCfop.get(i).getCodigo() < 10 ){
             listaCfop.add((listaModelCfop.get(i).getCfop() +"   " + listaModelCfop.get(i).getDescricao()));   
            }else{
                listaCfop.add( listaModelCfop.get(i).getCfop() +"  " + listaModelCfop.get(i).getCodigo() +" " + listaModelCfop.get(i).getDescricao());
            }
            
        }
        
    }
        
    public void criarListacsosn(){
        listaModelCsosn = controllerCsosn.getListaCsosnController();
        
        for (int i = 0; i < listaModelCsosn.size(); i++) {
            listaCsosn.add(listaModelCsosn.get(i).getCodigo()+ "-" +listaModelCsosn.get(i).getNumero()+ "(" + listaModelCsosn.get(i).getDescricao() +")");
        }
    }
    public void criarListaEstado(){
        listaModelEstado = controllerCidadeEstado.getListaCidadeEstadoController();
        for (int i = 0; i < listaModelEstado.size(); i++) {
            listaEstado.add(listaModelEstado.get(i).getModelEstado().getCodigo() + "-" +listaModelEstado.get(i).getModelEstado().getUf());
        }
    }
    public void listaOrigem(){
        cbOrigem.getItems().addAll("0 - Nacional, exceto as indicadas nos códigos 3 a 5", 
                                    "1 - Estrangeira - Importação direta, exceto a indicada no código 6", 
                                    "2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7",
                                    "3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40%",
                                    "4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67 e as Leis nºs 8.248/91,\n" +
"8.387/91, 10.176/01 e 11.484/07",
                                    "5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%",
                                    "6 - Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX",
                                    "7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX");
    }
    
    
    @FXML
    public boolean salvarTributacao() throws IOException {
              
        modelTributacaoEstadual.setDescricao(tfDescricao.getText().toUpperCase());
        modelTributacaoEstadual.setOrigem(cbOrigem.getSelectionModel().getSelectedIndex());
        modelTributacaoEstadual.setIdcsosn(Integer.parseInt(tfCSOSN.getText().substring(0,2)));
        modelTributacaoEstadual.setIdcfop(Integer.parseInt(tfCFOP.getText().substring(6,8)));
        modelTributacaoEstadual.setIdestado(Integer.parseInt(tfEstado.getText().substring(0,2)));
        modelTributacaoEstadual.setBasedecalculo(100.0f);
        modelTributacaoEstadual.setBasedecalculoicms(0.0f);
        modelTributacaoEstadual.setBasedecalculoicmsretido(0.0f);
        modelTributacaoEstadual.setBasedecalculosub(0.0f);
        modelTributacaoEstadual.setBasedecalculosubefetivo(0.0f);
        modelTributacaoEstadual.setPercentual(0.0f);
        
//salvar 

if (codigoTributacaoEstadual > 0){
    modelTributacaoEstadual.setCodigo(codigoTributacaoEstadual);
    controllerTributacaoEstadual.atualizarTributacaoEstadualController(modelTributacaoEstadual);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PRODUTO ALTERADO?");
            alert.setContentText("PRODUTO ALTERADO COM SUCESSO");
            if (status == 2){
      
                sair();
        //        atualizarLista();
            } else if (status == 1){
            
                sair();
        //        atualizarLista();
            }else if (status == 0){
            novaTributacao();
            }
            return true;
}else  if (controllerTributacaoEstadual.salvarTributacaoEstadualController(modelTributacaoEstadual) > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("NOVA TRIBUTAÇÃO GRAVADA COM SUCESSO");
             if (status == 2){
            
            sair();
           //atualizarLista();
            } else if (status == 1){
            
            sair();
          //  atualizarLista();
            }else if (status == 0){
            
            sair();
          //  atualizarLista();
            }
             sair();
             return true;
            
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("ERRO AO SALVAR PRODUTO");
            return false;
        }

    }
    public void sair(){
    Stage estagiosaida = (Stage) btGravar.getScene().getWindow();
          estagiosaida.close();
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
    
    public void novaTributacao() {
        tfDescricao.setText("");
        tfEstado.setText("");
        tfPercentual.setText("0.00");
        tfBasedeCalculo.setText("100.0");
        tfBasedeCalculoSub.setText("0.0");
        tfBasedeCalculoSubEfetivo.setText("0.00");
        tfBasedeCalculoICMS.setText("0.00");
        tfBasedeCalculoICMSRetido.setText("0.00");
       
    }
    public void listaEnter(){
        
        campos.add(tfDescricao);
        campos.add(tfEstado);
        campos.add(tfPercentual);
        campos.add(tfCFOP);
        campos.add(tfCSOSN);
        campos.add(tfBasedeCalculo);
        campos.add(tfBasedeCalculoSub);
        campos.add(tfBasedeCalculoSubEfetivo);
        campos.add(tfBasedeCalculoICMS);
        campos.add(tfBasedeCalculoICMSRetido);
        
       }
    public void setNextFocus(TextField tfDescricao, TextField tfEstado,TextField tfCFOP,TextField tfCSOSN, TextField tfPercentual, 
            TextField tfBasedeCalculo, TextField tfBasedeCalculoSub, TextField tfBasedeCalculoSubEfetivo, 
            TextField tfBasedeCalculoICMS, TextField tfBasedeCalculoICMSRetido) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    } 
    
    public void AlterarTributacao(int codigo){
        modelTributacaoEstadual.setDescricao(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getDescricao());
        modelTributacaoEstadual.setOrigem(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getOrigem());
        modelTributacaoEstadual.setIdcsosn(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getCodigo()).getNumero());
        modelTributacaoEstadual.setIdcfop(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getCodigo()).getCodigo());
        modelTributacaoEstadual.setIdestado(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getIdestado());
        modelTributacaoEstadual.setBasedecalculo(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getBasedecalculo());
        modelTributacaoEstadual.setBasedecalculoicms(0.0f);
        modelTributacaoEstadual.setBasedecalculoicmsretido(0.0f);
        modelTributacaoEstadual.setBasedecalculosub(0.0f);
        modelTributacaoEstadual.setBasedecalculosubefetivo(0.0f);
        modelTributacaoEstadual.setPercentual(100.0f);
        
    }
    public void DuplicarTributacao(int codigo){
        
        tfDescricao.setText(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getDescricao());
        cbOrigem.setValue(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getOrigem());
        tfCSOSN.setText(String.valueOf(controllerCsosn.getCsosnController(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getCodigo()).getNumero()));
        tfCFOP.setText(String.valueOf(controllerCFOP.getCFOPController(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getCodigo()).getCodigo()));
        tfEstado.setText(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getIdestado()));
        tfBasedeCalculo.setText(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(codigo).getBasedecalculo()));
        tfBasedeCalculoICMS.setText("0.00");
        tfBasedeCalculoICMS.setText("0.00");
        tfBasedeCalculoICMSRetido.setText("0.0");
        tfBasedeCalculoSub.setText("0.00");
        tfBasedeCalculoSubEfetivo.setText("100");
    }
    
    

}
