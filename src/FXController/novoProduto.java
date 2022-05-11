/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import controller.ControllerFornecedor;
import controller.ControllerGRUPO;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerNCM;
import controller.ControllerTributacaoEstadual;
import controller.ControllerTributacaoFederal;
import controller.ControllerModeloIpi;
import controller.ControllerModeloPisCofins;
import controller.ControllerFator;
import controller.ControllerTipo;
import interfaces.classeInterfaces;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelComprasProdutos;
import model.ModelFornecedor;
import model.ModelProdutos;
import model.ModelUnidadeMedia;
import model.ModelGrupo;
import model.ModelNCM;
import model.ModelTributacaoEstadual;
import model.ModelTributacaoFederal;
import model.ModelIpi;
import model.ModelPisCofins;
import model.ModelFator;
import model.ModelTipo;
import org.controlsfx.control.textfield.TextFields;
import unishop.Unishop;
import util.BLMascaras;
import util.MaskFieldUtil;

/**
 *
 * @author Fabio
 */
public class novoProduto extends Application implements Initializable{
    
    @FXML TextField NomeProduto;
    @FXML TextField estoque;
    @FXML TextField reserva;
    @FXML TextField precoVenda;
    @FXML TextField precoCusto;
    @FXML TextField lucro;
    @FXML ImageView foto;
    @FXML ChoiceBox cbGrupo;
    @FXML ChoiceBox cbMarca;
    @FXML TextField unidade;
    @FXML ChoiceBox cbTipo;
    @FXML ChoiceBox cbTribEstadual;
    @FXML ChoiceBox cbTribFederal;
    @FXML TextField cest;
    @FXML TextField ncm;
    @FXML TextField conversao;
    @FXML TextField barras;
    @FXML ToggleButton tgbativo = new ToggleButton();
    @FXML ToggleButton tgbcomposicao = new ToggleButton();
    @FXML ToggleButton tgbfracionado = new ToggleButton();
    @FXML ToggleButton tgbbalanca = new ToggleButton();
    @FXML Button btSalvarProduto;
    @FXML Button btImprimirProduto;
    @FXML Button btUnidades;
    @FXML Button btCests;
    @FXML Button btNcms;
    @FXML Button btMarcas;
    @FXML Button btGrupos;
    @FXML Button btFatores;
    @FXML Button btUniFiscais;
    @FXML Button btTribFederais;
    @FXML Button btTribEstaduais;
    @FXML Button btSair;
    @FXML Pane painelFundo;
    
    @FXML private AnchorPane pnGlp;
    @FXML private TextField tfPercGas;
    @FXML private TextField tfPercGasNacional;
    @FXML private TextField tfPercGasImportado;
   
    
    Image img = new Image("imagens/lupa.png");
    int codigoAltera;
    String nome;
    int codigoProduto = 0;
    int status;
    
    
    
    
    ArrayList<TextField> campos = new ArrayList<>();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelGrupo modelGrupo = new ModelGrupo();
    ModelIpi modelIpi = new ModelIpi();
    ModelPisCofins modelPisCofins = new ModelPisCofins();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ControllerNCM controllerNCM = new ControllerNCM();
    ControllerGRUPO controllerGrupo = new ControllerGRUPO();
    ControllerTipo controllerTipo = new ControllerTipo();
    ControllerModeloIpi controllerModeloIpi = new ControllerModeloIpi();
    ControllerModeloPisCofins controllerModeloPisCofins = new ControllerModeloPisCofins();
    ControllerTributacaoEstadual controllerTributacaoEstadual = new ControllerTributacaoEstadual();
    ControllerTributacaoFederal controllerTributacaoFederal = new ControllerTributacaoFederal();
    ControllerFator controllerFator = new ControllerFator();
    ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
    ArrayList<String> listaUnidades = new ArrayList<>();
    ArrayList<String> listadeGrupos = new ArrayList<>();
    ArrayList<String> listadeTipos = new ArrayList<>();
    ObservableList<String> listaGrupos;
    ObservableList<String> listaTipos;
    ArrayList<String> listaMarcas = new ArrayList<>();
    ArrayList<String> listaTribEstadual = new ArrayList<>();
    ArrayList<String> listaTribFederal = new ArrayList<>();
    ArrayList<String> listaNcm = new ArrayList<>();
    ObservableList<String> listaTributacaoEstadual;
    ObservableList<String> listaTributacaoFederal;
    ArrayList<String> listaFator = new ArrayList<>();
    ArrayList<String> listaCest = new ArrayList<>();
    ArrayList<ModelUnidadeMedia> listaModelUnidadeMedias = new ArrayList<>();
    ArrayList<ModelGrupo> listaModelGrupo = new ArrayList<>();
    ArrayList<ModelTipo> listaModelTipo = new ArrayList<>();
    ArrayList<ModelNCM> listamodelNCM = new ArrayList<>();
    ArrayList<ModelTributacaoEstadual> listamodelTributacaoEstadual = new ArrayList<>();
    ArrayList<ModelTributacaoFederal> listamodelTributacaoFederal = new ArrayList<>();
    ArrayList<ModelFator> listamodelFator = new ArrayList<>();
    ArrayList<ModelGrupo> listaGrupo = new ArrayList<>();
    ArrayList<ModelTipo> listaTipo = new ArrayList<>();
    ArrayList<ModelProdutos> listamModelProdutos = new ArrayList<>();
    ArrayList<ModelFornecedor> listaFornecedor = new ArrayList<>();
    BLMascaras bLMascaras = new BLMascaras();
    String tipoCadastro, codigoDeBarras, nomeImagem, caminhoImagem;
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/cadastroProduto.fxml")); 
        Parent raiz = loader.load();   
        Scene scene = new Scene(raiz);
        primaryStage.setTitle("CADASTRO DE PRODUTO");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
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
     classeInterfaces.addaoMudarTelaNcm((String novaTela,String rNcm)-> {
                    ncm.setText(rNcm);
                        });
      //cadastroRapido();
      status = 0;
      novoProduto();
      listaEnter();
      criarListaUnidades();
      criarListaGrupos();
      criarListaTipos();
      criarListaTribEst();
      criarListaTribFed();
      criarListaFator();
      TextFields.bindAutoCompletion(unidade,listaUnidades );
      TextFields.bindAutoCompletion(ncm,listaNcm );
      TextFields.bindAutoCompletion(conversao,listaFator );
      
      painelFundo.setOnKeyPressed((KeyEvent e)->{
           if(e.getCode()== KeyCode.ENTER){
               try {
                   salvarProduto();
               } catch (IOException ex) {
                   Logger.getLogger(novoProduto.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
      cbTipo.setOnAction((event) -> {
          habilitarGlp();
      });
    }
    
     public void habilitarFiscais(){
    cest.setVisible(true);
    ncm.setVisible(true);
    cbTribFederal.setVisible(true);
    cbTribEstadual.setVisible(true);
    btUniFiscais.setVisible(true);
    btTribEstaduais.setVisible(true);
    btTribFederais.setVisible(true);
    btNcms.setVisible(true);
    btCests.setVisible(true);
    }
    public void habilitarGlp() {
    if (cbTipo.getSelectionModel().getSelectedIndex() == 1){
        pnGlp.setVisible(true);
    }else{
        pnGlp.setVisible(false);
    }
        
    }
    
    public void criarListaUnidades(){
        listaModelUnidadeMedias = controllerUnidadeMedia.getListaUnidadeMediaController();
        
        for (int i = 0; i < listaModelUnidadeMedias.size(); i++) {
            if (listaModelUnidadeMedias.get(i).getCodigo() < 10 ){
             listaUnidades.add( "(0" + listaModelUnidadeMedias.get(i).getCodigo() +")" +listaModelUnidadeMedias.get(i).getAbreviacao());   
            }else{
                listaUnidades.add( "(" + listaModelUnidadeMedias.get(i).getCodigo() +")" +listaModelUnidadeMedias.get(i).getAbreviacao());
            }
            
        }
    }
    
    public void criarListaGrupos(){
        listaModelGrupo = controllerGrupo.getListaGRUPOController();
        for (int i = 0; i < listaModelGrupo.size(); i++) {
            listadeGrupos.add(listaModelGrupo.get(i).getDescricao());
        }
        listaGrupos = FXCollections.observableArrayList(listadeGrupos);
        cbGrupo.setItems(listaGrupos);
    }
    public void criarListaTipos(){
        listaModelTipo = controllerTipo.getListatipoController();
        for (int i = 0; i < listaModelTipo.size(); i++) {
            listadeTipos.add(listaModelTipo.get(i).getDescricao());
        }
        listaTipos = FXCollections.observableArrayList(listadeTipos);
        cbTipo.setItems(listaTipos);
    }
    public void criarListaNcm(){
        listamodelNCM = controllerNCM.getListaNCMController();
        for (int i = 0; i < listamodelNCM.size(); i++) {
            listaNcm.add(listamodelNCM.get(i).getNcm());
        }
    }
    public void criarListaTribEst(){
        listamodelTributacaoEstadual = controllerTributacaoEstadual.getListaTributacaoEstadualController();
        for (int i = 0; i < listamodelTributacaoEstadual.size(); i++) {
            listaTribEstadual.add(listamodelTributacaoEstadual.get(i).getDescricao());
        }
        listaTributacaoEstadual = FXCollections.observableArrayList(listaTribEstadual);
        cbTribEstadual.setItems(listaTributacaoEstadual);
    }
    public void criarListaTribFed(){
        listamodelTributacaoFederal = controllerTributacaoFederal.getListaTributacaoFederalController();
        for (int i = 0; i < listamodelTributacaoFederal.size(); i++) {
            listaTribFederal = new ArrayList<>();
            listaTribFederal.add(listamodelTributacaoFederal.get(i).getDescricao());
        }
        listaTributacaoFederal = FXCollections.observableArrayList(listaTribFederal);
        cbTribFederal.setItems(listaTributacaoFederal);
    }
    
    public void criarListaFator(){
        listamodelFator = controllerFator.getListaFatorController();
        
        for (int i = 0; i < listamodelFator.size(); i++) {
            if (listamodelFator.get(i).getCodigo() < 10){
                listaFator.add("(0"+listamodelFator.get(i).getCodigo()+ ")" + listamodelFator.get(i).getDescricao() );
            }else{
                listaFator.add("("+listamodelFator.get(i).getCodigo()+ ")" + listamodelFator.get(i).getDescricao());
            }
           
    }
    }
   
    
    @FXML
    private boolean salvarProduto() throws IOException {
        modelProdutos.setNome(this.NomeProduto.getText().toUpperCase());
        modelProdutos.setDescricaoProduto(this.NomeProduto.getText().toUpperCase());
        modelProdutos.setNcm(ncm.getText());
        modelProdutos.setTipoNcm("");
        modelProdutos.setValor(bLMascaras.converterVirgulaParaPontoReturnDouble(precoVenda.getText()));
        modelProdutos.setValorCusto(bLMascaras.converterVirgulaParaPontoReturnDouble(precoCusto.getText()));
        modelProdutos.setFornecedoresCodigo(1);
        modelProdutos.setEstoque(Float.parseFloat(estoque.getText()));
        modelProdutos.setReserva(0);
        if (barras.getText().equals("")) {
            modelProdutos.setCodigoBarrasEan("0");
        } else {
            modelProdutos.setCodigoBarrasEan(barras.getText());
        }
        
        modelProdutos.setUnidadeMedida(Integer.parseInt(unidade.getText().substring(2, 3)));
        if (tgbativo.getText().equalsIgnoreCase("SIM")){
        modelProdutos.setAtivo(1);
        }else{
        modelProdutos.setAtivo(0);
        }
        if (tgbcomposicao.getText().equalsIgnoreCase("SIM")){
        modelProdutos.setComposicao(1);
        }else{
        modelProdutos.setComposicao(0);
        }
        modelProdutos.setOrigem(0);
        try {
            modelProdutos.setValor(bLMascaras.converterVirgulaParaPontoReturnDouble(precoVenda.getText()));
        } catch (NumberFormatException e) {
            modelProdutos.setValor(0);
        }
        modelProdutos.setUnidadeMedida(Integer.parseInt(this.unidade.getText().substring(1, 3)));
        modelProdutos.setConversao(Integer.parseInt(this.conversao.getText().substring(1, 3)));
        modelProdutos.setUniFisco(Integer.parseInt(this.unidade.getText().substring(1, 3)));
        modelProdutos.setImagemProduto("imagens/lupa.png");
        modelProdutos.setTribEst(cbTribEstadual.getSelectionModel().getSelectedIndex());
        modelProdutos.setTribFed(cbTribFederal.getSelectionModel().getSelectedIndex());
        modelProdutos.setGrupo(cbGrupo.getSelectionModel().getSelectedIndex());
        modelProdutos.setTipo(cbTipo.getSelectionModel().getSelectedIndex());
        modelProdutos.setIcms(String.valueOf(controllerTributacaoEstadual.getTributacaoEstadualController(cbTribEstadual.getSelectionModel().getSelectedIndex()).getPercentual()));
        modelProdutos.setIpi(String.valueOf(controllerModeloIpi.getIPIController(cbTribFederal.getSelectionModel().getSelectedIndex()).getCodigo()));
        modelProdutos.setPis(String.valueOf(controllerModeloPisCofins.getPiscofinsController(cbTribFederal.getSelectionModel().getSelectedIndex()).getCodigo()));
        modelProdutos.setCofins(String.valueOf(controllerModeloPisCofins.getPiscofinsController(cbTribFederal.getSelectionModel().getSelectedIndex()).getCodigo()));
        modelProdutos.setCodProdutoAnp("210203001");
        modelProdutos.setDescricaoAnp((String) cbTipo.getSelectionModel().getSelectedItem());
        modelProdutos.setPercGlp(Integer.parseInt(tfPercGas.getText()));
        modelProdutos.setPercGnn(Integer.parseInt(tfPercGasNacional.getText()));
        modelProdutos.setPercGni(Integer.parseInt(tfPercGasImportado.getText()));
        modelProdutos.setValorProdutoGlp(bLMascaras.converterVirgulaParaPontoReturnDouble(precoVenda.getText()));
        modelProdutos.setEstadoConsumidor("ES");
//salvar 

if (codigoProduto > 0){
    modelProdutos.setCodigo(codigoProduto);
    controllerProdutos.atualizarProdutosController(modelProdutos);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PRODUTO ALTERADO?");
            alert.setContentText("PRODUTO ALTERADO COM SUCESSO");
            if (status == 2){
      
                sair();
                atualizarLista();
            } else if (status == 1){
            
                sair();
                atualizarLista();
            }else if (status == 0){
            novoProduto();
            }
            return true;
}else  if (controllerProdutos.salvarProdutosController(modelProdutos) > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO SALVO?");
            alert.setContentText("PRODUTO GRAVADO COM SUCESSO");
            switch (status){
                case 0:
                    sair();
                    atualizarLista();   
                break;
                case 1:
                    sair();
                    atualizarLista();
                break;
                case 2:
                    sair();
                    atualizarLista();    
                break;
                case 3:
                   classeInterfaces.avisaOuvintesProdutoEntrada("entrada",NomeProduto.getText());
                    sair();
                break;
            }
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTRO NÃO SALVO?");
            alert.setContentText("ERRO AO SALVAR PRODUTO");
            return false;
        }


    }
    public void sair(){
    Stage estagiosaida = (Stage) btSalvarProduto.getScene().getWindow();
          estagiosaida.close();
    }
    
    public void atualizarLista() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqProduto.fxml"));
        Parent raizListaProduto = (Parent) loader.load();
        listaProduto produto = loader.getController();
        produto.listaTodos();
        Stage pagStage = new Stage();
        pagStage.setScene(new Scene(raizListaProduto));
        pagStage.initStyle(StageStyle.TRANSPARENT);
        pagStage.initModality(Modality.APPLICATION_MODAL);
        pagStage.show();
            
                
    }
    
    public void novoProduto() {
        NomeProduto.setText("");
        estoque.setText("0");
        reserva.setText("0.0");
        precoVenda.setText("0.00");
        precoCusto.setText("0.00");
        lucro.setText("0.0");
        cbTribEstadual.getSelectionModel().select(0);
        cbTribFederal.getSelectionModel().select(0);
        ncm.setText("");
        cest.setText("");
        cbMarca.getSelectionModel().select(0);
        foto.setImage(img);
        cbGrupo.getSelectionModel().select(0);
        cbTipo.getSelectionModel().selectFirst();
        unidade.setText("(59)UNID");
        cbTribEstadual.getSelectionModel().select(0);
        cbTribFederal.getSelectionModel().select(0);
        tipoCadastro = "novo";
        tgbativo.setSelected(true);
        tgbativo.setText("SIM");
        tgbcomposicao.setSelected(false);
        tgbcomposicao.setText("NÃO");
       
        codigoProduto = 0;
        conversao.setText("(03)MULT06");
        
    }
    public void listaEnter(){
        
        campos.add(NomeProduto);
        campos.add(estoque);
        campos.add(reserva);
        campos.add(precoVenda);
        campos.add(precoCusto);
        campos.add(lucro);
        campos.add(unidade);
        campos.add(ncm);
        campos.add(cest);
        campos.add(barras);
        campos.add(conversao);
        
                  
       }
    public void setNextFocus(TextField NomeProduto, TextField estoque, TextField reserva, TextField precoVenda, 
            TextField precoCusto, TextField lucro, TextField unidade, TextField tipo, TextField cbTribEstadual
    , TextField cbTribFederal, TextField ncm, TextField cest, TextField cbMarca, TextField cbGrupo,  TextField barras, 
      TextField conversao) {
        
        campos.forEach((TextField txt) -> {
            txt.setOnAction(event -> {
                if (txt.getSkin() instanceof BehaviorSkinBase){
                    ((BehaviorSkinBase) txt.getSkin()).getBehavior().traverseNext();
                }
            });
        });
    } 
    public void novoUnidades(){
        listaUnidade lUnidade = new listaUnidade();
        try {
            lUnidade.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void novoTribEstadual(){
        listaTributacaoEstadual lTribEstadual = new listaTributacaoEstadual();
        try {
            
            lTribEstadual.start(new Stage());
           
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    
    
    public void novoFator(){
        listaCfop lFator = new listaCfop();
        try {
            lFator.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void novoNcm(){
        listaNcm lNcm = new listaNcm();
        try {
            lNcm.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void AlterarProduto(int codigo, int origem){
        
        String codigoConversaoTexto = "";
        int codigoConversaoNumero = controllerFator.getFatorController(controllerProdutos.getProdutosController(codigo).getConversao()).getCodigo();
        NomeProduto.setText(controllerProdutos.getProdutosController(codigo).getNome());
        estoque.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getEstoque()));
        reserva.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getReserva()));
        precoVenda.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getValor()));
        precoCusto.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getValorCusto()));
        lucro.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getLucro()));
        barras.setText(controllerProdutos.getProdutosController(codigo).getCodigoBarrasEan());
        ncm.setText(controllerProdutos.getProdutosController(codigo).getNcm());
        if (controllerProdutos.getProdutosController(codigo).getCest().equalsIgnoreCase("null")){
            cest.setText("");
        }else{
            cest.setText(controllerProdutos.getProdutosController(codigo).getCest());
        }
        if(controllerProdutos.getProdutosController(codigo).getMarca().equalsIgnoreCase("null")){
            cbMarca.getSelectionModel().select(0);
        }else{
            cbMarca.getSelectionModel().select(0);
        }
        foto.setImage(img);
        if(controllerProdutos.getProdutosController(codigo).getGrupo() == 0){
            cbGrupo.getSelectionModel().select(0);
        }else{
            cbGrupo.getSelectionModel().select(controllerProdutos.getProdutosController(codigo).getGrupo());
        }
        if(controllerProdutos.getProdutosController(codigo).getTipo()== 0){
            cbTipo.getSelectionModel().select(0);
        }else{
            cbTipo.getSelectionModel().select(controllerProdutos.getProdutosController(codigo).getTipo());
        }
        if ((controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getCodigo()) < 10){
            unidade.setText("(0"+ (controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getCodigo())+ ")"+(controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getAbreviacao()));
        }else {
        unidade.setText("("+ (controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getCodigo())+ ")"+(controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getAbreviacao()));
        }
        
        
        if (codigoConversaoNumero < 10){
            codigoConversaoTexto = "0" + codigoConversaoNumero;
        }else{
            codigoConversaoTexto = "" + codigoConversaoNumero;
        }
        conversao.setText("("+ (codigoConversaoTexto)+")"+controllerFator.getFatorController(controllerProdutos.getProdutosController(codigo).getConversao()).getDescricao());
        if (controllerProdutos.getProdutosController(codigo).getAtivo() == 1){
        tgbativo.setSelected(true);
        tgbativo.setText("SIM");
        }else{
            tgbativo.setSelected(false);
        tgbativo.setText("NÃO");
        }
        if (controllerProdutos.getProdutosController(codigo).getComposicao()== 1){
        tgbcomposicao.setSelected(true);
        tgbcomposicao.setText("SIM");
        }else{
            tgbcomposicao.setSelected(false);
        tgbcomposicao.setText("NÃO");
        }
       
        codigoProduto = codigo;
        cbTribEstadual.getSelectionModel().select(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(codigo).getTribEst()).getCodigo());
        cbTribFederal.getSelectionModel().select(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigo).getTribFed()).getCodigo());
        tfPercGas.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getPercGlp()));
        tfPercGasNacional.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getPercGnn()));
        tfPercGasImportado.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getPercGni()));
        status = origem;
        
    }
    public void produtoEntrada(ModelComprasProdutos mcp){
        
        NomeProduto.setText(mcp.getNomeProduto());
        estoque.setText(String.valueOf(mcp.getQuantidade()));
        reserva.setText("0");
        precoVenda.setText("0");
        precoCusto.setText(String.valueOf(mcp.getValorCusto()));
        lucro.setText("0");
        barras.setText(mcp.getBarras());
        ncm.setText(mcp.getNcm());
        cest.setText(mcp.getCest());
        cbMarca.getSelectionModel().select(0);
        foto.setImage(img);
        cbGrupo.getSelectionModel().select(0);
        cbTipo.getSelectionModel().selectFirst();
        unidade.setText("");
        tgbativo.setSelected(true);
        tgbativo.setText("SIM");
        tgbativo.setSelected(false);
        tgbativo.setText("NÃO");
        cbTribEstadual.getSelectionModel().select(0);
        cbTribFederal.getSelectionModel().select(0);
        status = 3;
    }
    
    public void DuplicarProduto(int codigo, int origem){
        
        NomeProduto.setText(controllerProdutos.getProdutosController(codigo).getNome());
        estoque.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getEstoque()));
        reserva.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getReserva()));
        precoVenda.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getValor()));
        precoCusto.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getValorCusto()));
        lucro.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getLucro()));
        barras.setText("");
        ncm.setText(controllerProdutos.getProdutosController(codigo).getNcm());
        if (controllerProdutos.getProdutosController(codigo).getCest().equalsIgnoreCase("null")){
            cest.setText("");
        }else{
            cest.setText(controllerProdutos.getProdutosController(codigo).getCest());
        }
        if(controllerProdutos.getProdutosController(codigo).getMarca().equalsIgnoreCase("null")){
            cbMarca.getSelectionModel().select(0);
        }else{
            cbMarca.getSelectionModel().select(controllerProdutos.getProdutosController(codigo).getMarca());
        }
        foto.setImage(img);
        if(controllerProdutos.getProdutosController(codigo).getGrupo() == 0){
            cbGrupo.getSelectionModel().select(0);
        }else{
            cbGrupo.getSelectionModel().select(String.valueOf(controllerProdutos.getProdutosController(codigo).getGrupo()));
        }
        if(controllerProdutos.getProdutosController(codigo).getTipo()== 0){
            cbTipo.getSelectionModel().select(0);
        }else{
            cbTipo.getSelectionModel().select(String.valueOf(controllerProdutos.getProdutosController(codigo).getTipo()));
        }
        if ((controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getCodigo()) < 10){
            unidade.setText("(0"+ (controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getCodigo())+ ")"+(controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getAbreviacao()));
        }else {
        unidade.setText("("+ (controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getCodigo())+ ")"+(controllerUnidadeMedia.getUnidadeMediaController(
        controllerProdutos.getProdutosController(codigo).getUnidadeMedida()).getAbreviacao()));
        }
        
        if (controllerProdutos.getProdutosController(codigo).getAtivo() == 1){
        tgbativo.setSelected(true);
        tgbativo.setText("SIM");
        }else{
            tgbativo.setSelected(false);
        tgbativo.setText("NÃO");
        }
        if (controllerProdutos.getProdutosController(codigo).getComposicao()== 0){
        tgbcomposicao.setSelected(false);
        tgbcomposicao.setText("NÃO");
        }else{
            tgbativo.setSelected(true);
        tgbativo.setText("SIM");
        }
        
        cbTribEstadual.getSelectionModel().select(controllerTributacaoEstadual.getTributacaoEstadualController(controllerProdutos.getProdutosController(codigo).getTribEst()).getCodigo());
        cbTribFederal.getSelectionModel().select(controllerTributacaoFederal.getTributacaoFederalController(controllerProdutos.getProdutosController(codigo).getTribFed()).getCodigo());
        tfPercGas.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getPercGlp()));
        tfPercGasNacional.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getPercGnn()));
        tfPercGasImportado.setText(String.valueOf(controllerProdutos.getProdutosController(codigo).getPercGni()));
        status = origem;
    }
    
    public void ativarBotao(){
        if (tgbativo.isSelected()){
            tgbativo.setText("SIM");
        }else{
            tgbativo.setText("NÃO");
        }
        if (tgbcomposicao.isSelected()){
            tgbcomposicao.setText("SIM");
        }else{
            tgbcomposicao.setText("NÃO");
        }
    }
    public void cadastroRapido(){
        cbTribEstadual.setVisible(false);
        btTribEstaduais.setVisible(false);
        cbTribFederal.setVisible(false);
        btTribFederais.setVisible(false);
        
    }
    public void Sair(){
          Stage estagioSaida = (Stage) btSair.getScene().getWindow();
          estagioSaida.close();
        
                }

}
