/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import util.BLMascaras;
import util.TextFieldFormatter;

/**
 *
 * @author Fabio
 */
public class consultaCnpj extends Application implements Initializable{
     @FXML
    private Button btFecharRetorno;

    @FXML
    private Button btPesquisarCnpj;

    @FXML
    private TextField pesquisaCnpj;

    @FXML
    private Button btConfirmaCnpj;

    @FXML
    private Button btSair;

    @FXML
    private TextArea tfStatus;

    @FXML
    private Label lbCnpj;

    @FXML
    private Label lbRazaoSocial;

    @FXML
    private Label lbRua;
    @FXML
    private Label lbNumero;

    @FXML
    private Label lbBairro;

    @FXML
    private Label lbCidade;

    @FXML
    private Label lbEstado;

    @FXML
    private Label lbCep;
    @FXML
    private Label lbEmail;
    @FXML
    private Label lbTelefone;
    @FXML
    private Label lbFantasia;
    
    String tipo;    
    
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage cnpjStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqCnpj.fxml")); 
        Parent raiz = loader.load();   
        cnpjStage.setScene(new Scene(raiz));
        cnpjStage.initStyle(StageStyle.UNDECORATED);
        cnpjStage.initModality(Modality.APPLICATION_MODAL);
        cnpjStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

public void habilitaBotao(){
    formataCnpj();
    if (bLMascaras.isCNPJ(bLMascaras.removerFormatacao(pesquisaCnpj.getText())) == true){
        btPesquisarCnpj.setDisable(false);
    }else{
        btPesquisarCnpj.setDisable(true);
        btPesquisarCnpj.setDisable(true);
    }
}
public void formataCnpj(){
    TextFieldFormatter tff = new TextFieldFormatter();
     
         tff.setMask("##.###.###/####-##");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(pesquisaCnpj);
         tff.formatter();
}
    public String consultarCnpj(String cnpj) {
            String json;
            try {
                URL url = new URL("https://www.receitaws.com.br/v1/cnpj/"+cnpj);
                URLConnection urlConnection = ((URL) url).openConnection();

                InputStream is = urlConnection.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder jsonSb = new StringBuilder();

                br.lines().forEach(l -> jsonSb.append(l.trim()));
                json = jsonSb.toString();
                JSONObject meuObjeto = new JSONObject(json);
                // JOptionPane.showMessageDialog(null, json);
                
                String cep = meuObjeto.getString("cep");
                String nome = meuObjeto.getString("nome");
                String logradouro = meuObjeto.getString("logradouro");
                String bairro = meuObjeto.getString("bairro");
                String cidade = meuObjeto.getString("municipio");
                String uf = meuObjeto.getString("uf");
                String numero = meuObjeto.getString("numero");
                String email = meuObjeto.getString("email");
                String fantasia = meuObjeto.getString("fantasia");
                String telefone = meuObjeto.getString("telefone");
                preencherCampos(bairro, cep,logradouro, cidade, nome, uf, numero, fantasia, telefone, email);
            } catch (Exception e) {
                throw new RuntimeException(e);
        }
           btConfirmaCnpj.setDisable(false);
           return cnpj;
        }
    
    public void preencherCampos(String rBairro, String rCep, String rLogradouro, String rCidade, 
        String rNome, String rEstado, String rNumero, String rFantasia, String rTelefone, String rEmail){
        lbBairro.setText(rBairro);
        lbCep.setText(rCep);
        lbRua.setText(rLogradouro);
        lbCidade.setText(rCidade);
        lbRazaoSocial.setText(rNome);
        lbNumero.setText(rNumero);
        lbTelefone.setText(rTelefone);
        lbEmail.setText(rEmail);
        lbFantasia.setText(rFantasia);
        lbEstado.setText(rEstado);
        lbCnpj.setText(bLMascaras.removerFormatacao(pesquisaCnpj.getText()));
    }
    
    public void iniciaCadastro(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/cadastroPJuridica.fxml"));
        Parent novaRaiz = (Parent) loader.load();
        FXViewCliente nCliente = loader.getController();
        nCliente.iniciaComCnpj(lbBairro.getText(), lbCep.getText(), lbRua.getText(), lbCidade.getText(), lbRazaoSocial.getText(), 
                lbEstado.getText(), lbNumero.getText(), 
                lbFantasia.getText(), lbTelefone.getText(), lbEmail.getText(), lbCnpj.getText(), tipo);
        Stage stage = new Stage();
        stage.setScene(new Scene(novaRaiz));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        sair();
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btPesquisarCnpj.setDisable(true);
        btConfirmaCnpj.setDisable(true);
        pesquisaCnpj.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode()== KeyCode.ENTER){
                   if (!(btPesquisarCnpj.isDisabled())){
                       consultarCnpj(bLMascaras.removerFormatacao(pesquisaCnpj.getText()));
                   }
           }
       });
        btPesquisarCnpj.setOnMouseClicked((MouseEvent e)->{
        consultarCnpj(bLMascaras.removerFormatacao(pesquisaCnpj.getText()));
        });
        
        btConfirmaCnpj.setOnMouseClicked((MouseEvent e)->{
        ActionEvent evento = null;
            try {
                iniciaCadastro(evento);
            } catch (IOException ex) {
                Logger.getLogger(consultaCnpj.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
}
