/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerCidadeEstado;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerEstado;
import controller.ControllerFornecedor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelCidade;
import model.ModelCliente;
import model.ModelClienteCidadeEstado;
import model.ModelCidadeEstado;
import model.ModelEstado;
import model.ModelFornecedor;
import org.controlsfx.control.textfield.TextFields;
import static org.eclipse.persistence.expressions.ExpressionOperator.Log;
import util.BLMascaras;
import util.TextFieldFormatter;


/**
 *
 * @author Fabio
 */
public class FXViewCliente  extends Application implements Initializable{
    
    @FXML private Label titulo;
    @FXML private Label docPrincipal;
    @FXML private Label docSecundario;
    @FXML private Label identPrincipal;
    @FXML private Label identSecundaria;
    @FXML private CheckBox situacao;
    @FXML private TextField cnpj;
    @FXML private TextField razaoSocial;
    @FXML private TextField nomeFantasia;    
    @FXML private TextField inscricaoEstadual;
    @FXML private TextField tfCep;
    @FXML private TextField numero;
    @FXML private TextField rua;
    @FXML private TextField bairro;
    @FXML private TextField uf;
    @FXML private TextField cidade;
    @FXML private TextField pais;
    @FXML private TextField telefone;
    @FXML private TextField celular;
    @FXML private TextField email;
    @FXML private TextField contato;
    @FXML private TextField observacoes;
    @FXML private TextField referencia;
    @FXML private Button btImprimir;
    @FXML private Button btSalvar;
    @FXML private Button btSair;
    @FXML private Pane painelFundo;
    @FXML private AnchorPane ancora;
    
    private int codCidade;
    private int codEstado;
    private int codPaís;
    public int codigoCliente;
    public String tipoPessoa = "J";
        
    ArrayList<String> listaEstados = new ArrayList<>();
    ArrayList<String> listaCidades = new ArrayList<>();
    ArrayList<TextField> campos = new ArrayList<>();
        
    ModelCliente modelCliente = new ModelCliente();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCliente controllerCliente = new ControllerCliente();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ControllerCidadeEstado controllerCidadeEstado = new ControllerCidadeEstado();
    ArrayList<ModelCidade> listaModelCidades = new ArrayList<>();
    ArrayList<ModelEstado> listaModelEstados = new ArrayList<>();
    ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
    ArrayList<ModelClienteCidadeEstado> listaModelClienteCidadeEstados = new ArrayList<>();
    ArrayList<ModelFornecedor> listaModelFornecedor = new ArrayList<>();
    BLMascaras bLMascaras = new BLMascaras();
    ObservableList<ModelCidade> cidades = FXCollections.observableArrayList(listaModelCidades);
    ObservableList<ModelEstado> estados = FXCollections.observableArrayList(listaModelEstados);
    ObservableList<ModelCliente> clientes = FXCollections.observableArrayList(listaModelCliente);
    ObservableList<ModelFornecedor> fornecedores = FXCollections.observableArrayList(listaModelFornecedor);
    
    
    
       public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
               
        criaListarEstados();
        criaListarCidades();
        limparCampos();
        criarLista();
        setNextFocus(cnpj, razaoSocial,inscricaoEstadual, tfCep, numero,
             uf, bairro, referencia,  cidade, pais, telefone, celular, email, contato, observacoes );
        TextFields.bindAutoCompletion(uf, listaEstados);
        TextFields.bindAutoCompletion(cidade, listaCidades);
        
        painelFundo.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode()== KeyCode.ENTER){
               try {
                   salvarCliente();
               } catch (IOException ex) {
                   Logger.getLogger(novoProduto.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
        tfCep.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode()== KeyCode.ENTER){
               buscarCep(bLMascaras.removerFormatacao(tfCep.getText()));
           }
       
       });
    }
           private void criaListarEstados() {
        listaModelEstados = controllerEstado.getListaEstadoController();
        listaEstados.clear();
        for (int i = 0; i < listaModelEstados.size(); i++) {
            listaEstados.add(listaModelEstados.get(i).getCodigo() + " " +listaModelEstados.get(i).getUf());
        }
    }
           private void criaListarCidades() {
        listaModelCidades = controllerCidade.getListaCidadeController();
        listaCidades.clear();
        for (int i = 0; i < listaModelCidades.size(); i++) {
            listaCidades.add(listaModelCidades.get(i).getNome());
        }
    }
           
            @FXML
     private void formataTelefone(){
         TextFieldFormatter tff = new TextFieldFormatter();
         tff.setMask("(##)####-####");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(telefone);
         tff.formatter();
     }
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
     @FXML
     private void formataCelular(){
         TextFieldFormatter tff = new TextFieldFormatter();
         tff.setMask("(##)#####-####");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(celular);
         tff.formatter();
     }
     @FXML
     private void formataCep(){
         TextFieldFormatter tff = new TextFieldFormatter();
         tff.setMask("#####-###");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(tfCep);
         tff.formatter();
     }
     
     
     @FXML
     private void formataCnpjCpf(){
         TextFieldFormatter tff = new TextFieldFormatter();
     
         if (tipoPessoa.equals("J")){
         tff.setMask("##.###.###/####-##");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(cnpj);
         tff.formatter();
         }else if(tipoPessoa.equals("F")){
         tff.setMask("###.###.###-##");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(cnpj);
         tff.formatter();
         }else{
         tff.setMask("##.###.###/####-##");
         tff.setCaracteresValidos("1234567890");
         tff.setTf(cnpj);
         tff.formatter();
         }
     }
       
       public void criarLista(){
        campos.add(cnpj);
        campos.add(razaoSocial);
        campos.add(nomeFantasia);
        campos.add(inscricaoEstadual);
        campos.add(tfCep);
        campos.add(numero);
        campos.add(uf);
        campos.add(rua);
        campos.add(bairro);
        campos.add(cidade);
        campos.add(referencia);
        campos.add(pais);
        campos.add(telefone);
        campos.add(celular);
        campos.add(email);  
        campos.add(contato);
        campos.add(observacoes);
          
       }
           public void buscarCep(String cep)
    {
        String json;
        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = ((URL) url).openConnection();

            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            // JOptionPane.showMessageDialog(null, json);

            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            array = json.split("\n");

            // JOptionPane.showMessageDialog(null, array);

            String logradouro = array[7];
            String bairro = array[15];
            String cidade = array[19];
            String uf = array[23];

            this.rua.setText(logradouro);
            this.bairro.setText(bairro);
            this.cidade.setText(cidade);
            for (int es = 0 ; es < listaEstados.size(); es++){
                if (listaEstados.get(es).contains(uf)){
                    this.uf.setText(listaEstados.get(es));
                }
            }
            

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean salvarCliente() throws IOException {
        
        if(tipoPessoa.equals("For")){
        //modelFornecedor.set(tipoPessoa);
        modelFornecedor.setNomeFantasia(this.nomeFantasia.getText().toUpperCase());
        modelFornecedor.setNome(this.razaoSocial.getText().toUpperCase());
        modelFornecedor.setEndereco(this.rua.getText());
        modelFornecedor.setBairro(this.bairro.getText());
        modelFornecedor.setNumero(Integer.parseInt(numero.getText()));
        modelFornecedor.setEmail(email.getText());
        modelFornecedor.setReferencia(referencia.getText());
        if (this.cidade == null) {
            
              Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("ERRO AO GRAVAR");
            dialogoInfo.setContentText("ESCOLHA UMA CIDADE");
            dialogoInfo.showAndWait();
            return false;
        } else {
            modelFornecedor.setCodCidade((controllerCidade.getCidadeController(cidade.getText())).getCodigo());
            modelFornecedor.setCodEstado(Integer.parseInt(uf.getText(0,2)));
            modelFornecedor.setCep(this.tfCep.getText());
            modelFornecedor.setTelefone(this.telefone.getText());
            modelFornecedor.setTelefone(this.telefone.getText());
            modelFornecedor.setCnpj(this.cnpj.getText());
            modelFornecedor.setInscEstadual(this.inscricaoEstadual.getText());
            //salvar 
            
            if (codigoCliente > 0){
                modelFornecedor.setCodigo(codigoCliente);
                controllerFornecedor.atualizarFornecedorController(modelFornecedor);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("REGISTRO OK");
            dialogoInfo.setContentText("ALTERADO COM SUCESSO");
            dialogoInfo.showAndWait();
            sair();
                return true;
            }else if (controllerFornecedor.salvarFornecedorController(modelFornecedor) > 0) {
         
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("INFORMAÇÃO SALVA");
            dialogoInfo.setContentText("REGISTRO OK");
            dialogoInfo.showAndWait();
             sair();
            this.limparCampos();
                return true;
            } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("ERRO AO GRAVAR");
            dialogoInfo.setContentText("REGISTRO COM FALHAS");
            dialogoInfo.showAndWait();
                return false;
            }
        }    
            
        }else{
        modelCliente.setTipoPessoa(tipoPessoa);
        modelCliente.setNomeFantasia(this.nomeFantasia.getText().toUpperCase());
        modelCliente.setNome(this.razaoSocial.getText().toUpperCase());
        modelCliente.setEndereco(this.rua.getText());
        modelCliente.setBairro(this.bairro.getText());
        modelCliente.setNumero(Integer.parseInt(numero.getText()));
        modelCliente.setEmail(email.getText());
        modelCliente.setReferencia(referencia.getText());
        if (this.cidade == null) {
            
              Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("ERRO AO GRAVAR");
            dialogoInfo.setContentText("ESCOLHA UMA CIDADE");
            dialogoInfo.showAndWait();
            return false;
        } else {
            modelCliente.setCodCidade((controllerCidade.getCidadeController(cidade.getText())).getCodigo());
            modelCliente.setCodEstado(Integer.parseInt(uf.getText(0,2)));
            modelCliente.setCep(this.tfCep.getText());
            modelCliente.setTelefone(this.telefone.getText());
            modelCliente.setCelular(this.celular.getText());
            modelCliente.setCpfCNPJ(this.cnpj.getText());
            modelCliente.setInscricao(this.inscricaoEstadual.getText());
            modelCliente.setObservacao(this.observacoes.getText());
            if (situacao.selectedProperty().getValue() == true){
                modelCliente.setAtivo(1);
            } else {
                modelCliente.setAtivo(0);
                   }
            //salvar 
            
            if (codigoCliente > 0){
                modelCliente.setCodigo(codigoCliente);
                                
                controllerCliente.atualizarClienteController(modelCliente);
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("REGISTRO OK");
            dialogoInfo.setContentText("ALTERADO COM SUCESSO");
            dialogoInfo.showAndWait();
             atualizarLista();
             sair();
                return true;
            }else if (controllerCliente.salvarClienteController(modelCliente) > 0) {
         
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("INFORMAÇÃO SALVA");
            dialogoInfo.setContentText("REGISTRO OK");
            dialogoInfo.showAndWait();
             atualizarLista();
             sair();
            this.limparCampos();
                return true;
            } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("COMFIRMAÇÃO");
            dialogoInfo.setHeaderText("ERRO AO GRAVAR");
            dialogoInfo.setContentText("REGISTRO COM FALHAS");
            dialogoInfo.showAndWait();
                return false;
            }
        }
         
        }
    }
    
    public void atualizarLista() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqCliente.fxml"));
        Parent raizListaCliente = (Parent) loader.load();
        listaCliente cliente = loader.getController();
        cliente.listaTodos();
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizListaCliente));
        pagStage.initStyle(StageStyle.TRANSPARENT);
        pagStage.initModality(Modality.APPLICATION_MODAL);
        pagStage.initStyle(StageStyle.UNDECORATED);
       
        pagStage.show();
                
    }

    private void limparCampos() {
   
        razaoSocial.setText("");
        nomeFantasia.setText("");
        uf.setText("32 ES");
        cidade.setText("Guarapari");
        pais.setText("Brasil");
        rua.setText("");
        bairro.setText("");
        situacao.setSelected(true);   
        tfCep.setText("");
        telefone.setText("");
        celular.setText("");
        cnpj.setText("");
        inscricaoEstadual.setText("");
        observacoes.setText("");
        contato.setText("");
        observacoes.setText("");
        numero.setText("0");
        email.setText("@");
        referencia.setText("");
        
        }

    protected boolean verificarCampos() {
        if (!razaoSocial.getText().trim().equals("")) {
            return true;
        }
        return false;
    
    }
    /** preencher cidades */
    public void situacaoMetodo(){
        ObservableList<String> situacaoatual = FXCollections.observableArrayList("Ativo", "Inativo");
        ComboBox situ = new ComboBox(situacaoatual);
       
    }
                 /**
         /**
     * Preencher combobox cidades
     */
    private void listarCidades() {
        try {
            listaModelCidades = controllerCidade.getListaCidadePorEstadoController(controllerEstado.getEstadoUFController(this.uf.getAccessibleText()).getCodigo());
        } catch (Exception e) {
            e.getMessage();
        //}
       
    }
    }
    public void setNextFocus(TextField cnpj, TextField razaoSocial,TextField inscricaoEstadual,TextField cep, TextField numero,
            TextField uf, TextField bairro,TextField referencia, TextField cidade, TextField pais, TextField telefone, TextField celular, TextField email, TextField contato, TextField observacoes ) {
        
        for (TextField txt : campos) {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        }
    }
        public void AlterarCliente(int codigo) throws IOException{
            codigoCliente = codigo;
            if(controllerCliente.getClienteControllerCod(codigo).getTipoPessoa().equalsIgnoreCase("F")){
                iniciarPessoaFisica();
            }
        
        razaoSocial.setText(controllerCliente.getClienteControllerCod(codigo).getNome());
        nomeFantasia.setText(String.valueOf(controllerCliente.getClienteControllerCod(codigo).getNomeFantasia()));
        cnpj.setText(String.valueOf(controllerCliente.getClienteControllerCod(codigo).getCpfCNPJ()));
        if (controllerCliente.getClienteControllerCod(codigo).getInscricao() != null){
        inscricaoEstadual.setText(controllerCliente.getClienteControllerCod(codigo).getInscricao());
        }
        tfCep.setText(String.valueOf(controllerCliente.getClienteControllerCod(codigo).getCep()));
        numero.setText(String.valueOf(controllerCliente.getClienteControllerCod(codigo).getNumero()));
        rua.setText(controllerCliente.getClienteControllerCod(codigo).getEndereco());
        bairro.setText(controllerCliente.getClienteControllerCod(codigo).getBairro());
        uf.setText(controllerEstado.getEstadoControllerCod(controllerCliente.getClienteControllerCod(codigo).getCodEstado()).getCodigo() + " "+controllerEstado.getEstadoControllerCod(controllerCliente.getClienteControllerCod(codigo).getCodEstado()).getUf());
        cidade.setText(controllerCidade.getCidadeController(controllerCliente.getClienteControllerCod(codigo).getCodCidade()).getNome());
        pais.setText("Brasil");
        telefone.setText(controllerCliente.getClienteControllerCod(codigo).getTelefone());
        celular.setText(controllerCliente.getClienteControllerCod(codigo).getCelular());
        email.setText(controllerCliente.getClienteControllerCod(codigo).getEmail());
        referencia.setText(controllerCliente.getClienteControllerCod(codigo).getReferencia());
        contato.setText(controllerCliente.getClienteControllerCod(codigo).getNome());
        }
        
        public void iniciaComCnpj(String rBairro, String rCep, String rLogradouro, String rCidade, 
        String rNome, String rEstado, String rNumero, String rFantasia, String rTelefone, String rEmail, String rCnpj, String rTipo) throws IOException{
            ArrayList<ModelEstado> listaModelEstado = new ArrayList<>();
        
            if (rTipo.equalsIgnoreCase("For")){
            iniciarFornecedor();
            }
            
        razaoSocial.setText(rNome);
        nomeFantasia.setText(rFantasia);
        cnpj.setText(rCnpj);
        inscricaoEstadual.setText("");
        tfCep.setText(rCep);
        numero.setText(rNumero);
        rua.setText(rLogradouro);
        bairro.setText(rBairro);
        listaModelEstado = controllerEstado.getListaEstadoController();
        for (int e = 0 ; e < listaModelEstado.size(); e++){
            System.out.println("estado lista"+ listaModelEstado.get(e).getUf() + " estado recup "+ rEstado);
            if (listaModelEstado.get(e).getUf().equals(rEstado)){
                uf.setText(listaModelEstado.get(e).getCodigo() + " " + rEstado);
            }
        }
        cidade.setText(rCidade);
        pais.setText("Brasil");
        telefone.setText(rTelefone);
        celular.setText(rTelefone);
        email.setText(rEmail);
        referencia.setText("");
        contato.setText("");
        inscricaoEstadual.setFocusTraversable(true);
        inscricaoEstadual.requestFocus();
        }
        
        public void iniciarPessoaFisica(){
            docPrincipal.setText("CPF");
            docSecundario.setText("Data de Nasc.");
            identPrincipal.setText("Nome Completo");
            identSecundaria.setText("Nome");
            docSecundario.setText("Data de Nasc.");
            tipoPessoa = "F";
            
            titulo.setText("Cadastro de Pessoa Física");
            
            tfCep.requestFocus();
            
            
        }
        public void iniciarFornecedor(){
            docPrincipal.setText("CNPJ");
            docSecundario.setText("IE");
            identPrincipal.setText("Nome Fornecedor");
            identSecundaria.setText("Razão Social Fornecedor");
            tipoPessoa = "For";
            
            titulo.setText("Cadastro de Fornecedor");
            
        }
    
     public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception { 
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroPJuridica.fxml")); 
        Parent root = loader.load(); 
        stage.setScene(new Scene(root)); 
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show(); 

    }  
}

    