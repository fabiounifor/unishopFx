/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import blserial.ConfigXML;
import java.io.IOException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import controller.ControllerCaixa;
import controller.ControllerNumeracao;
import controller.ControllerEmpresa;
import controller.ControllerDfe;
import controller.ControllerEmpresaCidadeEstado;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import util.ManipularXML;
import com.acbr.nfe.ACBrNFe; 
import interfaces.classeInterfaces;
import java.io.File;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.ModelConfig;
import model.ModelDfe;
import nfe.model.ModelXmlDfe;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.ModelNumeracao;

/**
 *
 * @author Fabio
 */
public class listaDfe extends Application implements Initializable{
    
    @FXML private Button btPesquisarDfe;
    @FXML private TextField pesquisaDfe;
    @FXML private TableView<ModelDfe> tabelaListaDfe;
    @FXML private TableColumn<ModelDfe, String> linhaDfe;
    @FXML private TableColumn<ModelDfe, ImageView> imageDfe;
    @FXML private Button btImportaOp;
    @FXML private Button btConfirmaOp;
    @FXML private Button btCienciaOp;
    @FXML private Button btConsulta;
    @FXML private Button btSair;
    @FXML private ChoiceBox cbStatus;
    
    
    ArrayList<ModelDfe> listaResultado  = new ArrayList<>();
    ArrayList<String> listacpfcnpj  = new ArrayList<>();
    ArrayList<String> listachave  = new ArrayList<>();
    ArrayList<String> listansu  = new ArrayList<>();
    ArrayList<String> listaprotocolo  = new ArrayList<>();
    ArrayList<String> listadatahora  = new ArrayList<>();
    ArrayList<String> listanomeforn  = new ArrayList<>();
    ArrayList<String> listapassou  = new ArrayList<>();
    ArrayList<String> listaRetorno  = new ArrayList<>();
    public ArrayList<ModelDfe> listaTabelaDfe ;
    ArrayList<ModelDfe> listaModelDfe = new ArrayList<>();
    ArrayList<ModelDfe> listaVerificaDfe = new ArrayList<>();
    ObservableList<ModelDfe> listadeDfe;
    
    double valorAtualizar = 0;
    String chaveConfirmar;
    String caminhoComleto;
    
    String cnpj;
    int codUf;
    String nsu ;
    String nsuAtual ;
    String retorno;
    Image img = new Image("imagens/lupa.png");
    ImageView imagem;
    //Image imgAtualizar = new Image("imagens/compra.png");
    
   
    int inicioCpf = 0;
    int inicioNsu = 0;
    int inicioXml = 0;
    int inicioEventoFimXml = 0;
    int inicioEventoFimXmlProcesso = 0;
    int inicioChave = 0;
    int inicioDatahora = 0;
    int inicioProtocolo = 0;
    int inicioFornNome = 0;
    int inicioValorTotal = 0;
    int inicioEventoFim = 0;
    int inicioUltNsu = 0;
    
    
    ModelConfig modelConfig = new ModelConfig(); 
    BLMascaras bLMascaras = new BLMascaras();
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerNumeracao controllerNumeracao = new ControllerNumeracao();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerDfe controllerDfe = new ControllerDfe();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    BLMascaras blMascaras = new BLMascaras();
    ArrayList<String> chavesNovas = new ArrayList<>();
    @Override
    public void start(Stage listaStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqDfe.fxml")); 
        Parent raiz = loader.load();   
        listaStage.setScene(new Scene(raiz));
        listaStage.initStyle(StageStyle.UNDECORATED);
        listaStage.initModality(Modality.APPLICATION_MODAL);
        listaStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            iniciaStatus();
            linhaDfe.setCellValueFactory(new PropertyValueFactory<>("pesquisa"));  
            //imageDfe.setCellValueFactory(new PropertyValueFactory<>("imagem"));  
            listaTodos();
            pesquisaDfe.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode()== KeyCode.ENTER){
            if((pesquisaDfe.getText().equals(""))){
            listaTodos();
            }else{
            listaFiltro();
            }
       }
       });
            btPesquisarDfe.setOnMouseClicked((MouseEvent e)->{
        if(e.getClickCount() == 1){
            if((pesquisaDfe.getText().equals(""))){
            listaTodos();
            }else{
            listaFiltro();
            }
       }
       });
            cbStatus.setOnAction((event) -> {
            listaFiltro();
      });
    
    }
    public void iniciaStatus(){
       cbStatus.getItems().addAll("AGUARDANDO","CIENCIA", "CONFIRMAÇÃO","XML DISPONÍVEL","NFE CADASTRADA");
       
    }
    
    public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
public void chamaConsultaDfe(){
ModelNumeracao modelNumeracao = new ModelNumeracao();
modelNumeracao = controllerNumeracao.getNumeracaoController(1);
DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
LocalDateTime dt1= LocalDateTime.parse(modelNumeracao.getUltimaConsulta(), f);
LocalDateTime dt2= LocalDateTime.parse(bLMascaras.retornarDataHora(), f);
long diferencaMin = Duration.between(dt1, dt2).toMinutes();
        if (diferencaMin < 60){
             Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoExe.setTitle("CONSULTAS REPETIDAS");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("A SUA ÚLTIMA CONSULTA FOI AS: "+ dt1 + " NÃO DEVERÁ CONSULTAR EM MENOS DE UMA HORA");
                dialogoExe.show();
                }else{
    try {
        consultaDfe();
        String dia  = String.valueOf(dt2).substring(8, 10);
        String mes  = String.valueOf(dt2).substring(5, 7);
        String ano  = String.valueOf(dt2).substring(0, 4);
        String hora  = String.valueOf(dt2).substring(11);
        String dataCompleta = (dia + "/" + mes + "/" + ano+ " " + hora);        
        controllerNumeracao.atualizarConsultaController(1,dataCompleta);
    } catch (Exception ex) {
        Logger.getLogger(listaDfe.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
        
        
    }
    public void consultaDfe() throws Exception{
        final String nsu; 
        final String cnpj; 
        final int codUf;
        String caminhoRetorno = "C:\\UniShop\\dfe\\" + controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\xmlsEntrada\\Nfe\\";
        ACBrNFe acbrNFe = new ACBrNFe();
        String ultimoNsu = "ultNSU=";
        if (!(new File(caminhoRetorno).exists())){
            File caminho = new File(caminhoRetorno);
            caminho.mkdir();
        }
        recuperarChaves(caminhoRetorno);
        nsu = controllerNumeracao.getNumeracaoController(1).getUltimoNsu();
        cnpj = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
        codUf = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1).getModelEstado().getCodigo();
        classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
                try{
                    if(chavesNovas.isEmpty()){
                    //String retorno;    
                    retorno = acbrNFe.distribuicaoDFeporUltNSU(codUf, cnpj, nsu);
                    inicioNsu = (procuraRetorno(retorno,ultimoNsu)+ultimoNsu.length());
                    nsuAtual = retorno.substring(inicioNsu,inicioNsu+15);
                        
                    if (Integer.parseInt(nsuAtual) > Integer.parseInt(nsu)){
                        controllerNumeracao.atualizarNumeracaoNsuController(nsuAtual, 1);
                    }
                    recuperarChaves(caminhoRetorno);
                    }
                }catch(Exception e)
                        { System.out.println(e);
                }
                classeInterfaces.avisaOuvintesProgresso("principal", Boolean.FALSE);
            }
       };
        t.start();
     }
    
    
    
    public int procuraRetorno(String retorno, String procura ){
        int indice = 0;
        if(retorno.contains(procura)){
            indice  = retorno.indexOf(procura);
        }
        return indice;
    }
    
    public void recuperarChaves(String caminho) throws IOException {
        ArrayList<String> chaves = new ArrayList<>();
	File file = new File(caminho);
	File afile[] = file.listFiles();
	if (afile.length > 0){
        
        for (int i = 0 ; i < afile.length; i++) {
            File listaDiretorio[] = afile[i].listFiles();
            for (int f = 0 ; f < listaDiretorio.length; f++) {
		File arquivos = listaDiretorio[f];
                if (arquivos.getName().length() >= 44){
                    chaves.add(arquivos.getName() + afile[i]) ;
                }
                
       	}
        }
        processarRetorno(chaves);
        }else{
        }
       
    }       
    
    public void processarRetorno(ArrayList chavesRecuperadas){
        for (int i = 0 ; i< chavesRecuperadas.size(); i++){
            String chave = chavesRecuperadas.get(i).toString();
            if (chave.length() >= 44){
            if ((controllerDfe.getDfeChaveController(chave.substring(0, 44)).getChavenfe() == null) &&(chave.substring(44,55).equalsIgnoreCase("-resNFe.xml"))){
            controllerDfe.salvarDfeController(gravarRetornoBanco(chave.substring(0, 55),chave.substring(55) ));
            chavesNovas.add(chave);
            }
            if ((controllerDfe.getDfeChaveController(chave.substring(0, 44)).getSituacao() != 4) && chave.substring(44,52).equalsIgnoreCase("-nfe.xml")){
            int codigoLocal = controllerDfe.getDfeChaveController(chave.substring(0, 44)).getCodigo();
            atualizarDfe(codigoLocal, 3, "imagens/lupa.png");
            }
            
            }
        }
    }
    
    private ModelDfe gravarRetornoBanco(String chave, String caminhoRetornoBanco){
        //String caminhoRetornoBanco = "C:\\UniShop\\dfe\\" + controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\xmlsEntrada\\Nfe\\" + ((blMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(6, 10))+(blMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5))) ;
        System.out.println("CHAVES " + chave);
        System.out.println("CAMINHO " + caminhoRetornoBanco);
        ModelDfe modelDfeFinal = new ModelDfe();
        ModelXmlDfe modelXmlDfe = new ModelXmlDfe();
        if (new File(caminhoRetornoBanco+"\\"+chave).exists()){
        ModelDfe modelDfe = new ModelDfe();
        modelXmlDfe = ManipularXML.lerXmlRetorno(chave, caminhoRetornoBanco);
        modelDfe.setChavenfe(modelXmlDfe.getChNFe());
        modelDfe.setCnpjcpf(modelXmlDfe.getCNPJ());
            try {
                modelDfe.setDatahoraemisao(modelXmlDfe.getDhEmi().substring(0, 10));
            } catch (Exception ex) {
                Logger.getLogger(listaDfe.class.getName()).log(Level.SEVERE, null, ex);
            }
          modelDfe.setProtocolo(modelXmlDfe.getnProt());
          modelDfe.setValorTotal(modelXmlDfe.getvNF());
          modelDfe.setFornecedornome(modelXmlDfe.getxNome());
          modelDfeFinal =  modelDfe;
        }
        return modelDfeFinal;
    }
    
    
    public void listaTodos(){
      listaResultado.clear();
      tabelaListaDfe.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelDfe = controllerDfe.getListaDfeController();
        listaModelDfe.stream()
              .filter(e-> e.getSituacao() == cbStatus.getSelectionModel().getSelectedIndex())
              .filter(e -> e.getPesquisa().contains(pesquisaDfe.getText()))
              .forEach(e -> listaResultado.add(e))
              ;
       listadeDfe = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeDfe);
       tabelaListaDfe.getItems().addAll(listadeDfe);
       mostrarBotoes();
     }

    
    public void listaFiltro(){
      listaResultado.clear();
      tabelaListaDfe.getItems().clear();
      listaResultado  = new ArrayList<>();
      listaModelDfe = controllerDfe.getListaDfeController();
      
      listaModelDfe.stream()
              .filter(e-> e.getSituacao() == cbStatus.getSelectionModel().getSelectedIndex())
              .filter(e -> e.getPesquisa().contains(pesquisaDfe.getText()))
              .forEach(e -> listaResultado.add(e))
              ;
      
       listadeDfe = FXCollections.observableArrayList(listaResultado);
       Collections.reverse(listadeDfe);
       tabelaListaDfe.getItems().addAll(listadeDfe);
       mostrarBotoes();
              
    }
    
    private void mostrarBotoes(){
        int seleciona = cbStatus.getSelectionModel().getSelectedIndex();
        switch (seleciona){
            case 0:
            btCienciaOp.setVisible(true);
            btConfirmaOp.setVisible(true);
            btConsulta.setVisible(true);
            btImportaOp.setVisible(false);
            break;
            case 1:
            btCienciaOp.setVisible(false);
            btConfirmaOp.setVisible(true);
            btConsulta.setVisible(true);
            btImportaOp.setVisible(false);    
            break;
            case 2:
            btCienciaOp.setVisible(false);
            btConfirmaOp.setVisible(false);
            btConsulta.setVisible(true);
            btImportaOp.setVisible(false);    
            break;
            case 3:
            btCienciaOp.setVisible(false);
            btConfirmaOp.setVisible(false);
            btConsulta.setVisible(true);
            btImportaOp.setVisible(true);    
            break;
            case 4:
            btCienciaOp.setVisible(false);
            btConfirmaOp.setVisible(false);
            btConsulta.setVisible(false);
            btImportaOp.setVisible(true);    
            break;
        }
                ;
        if (cbStatus.getSelectionModel().getSelectedIndex() == 0){
            
        }
    }
    
    public void atualizarDfe(int codigo,int atualizar, String imagemCaminho){
        ModelDfe modelDfe = new ModelDfe();
        modelDfe = controllerDfe.getDfeController(codigo);
        modelDfe.setChavenfe(modelDfe.getChavenfe());
        modelDfe.setCnpjcpf(modelDfe.getCnpjcpf());
        modelDfe.setDatahoraemisao(modelDfe.getDatahoraemisao());
        modelDfe.setFornecedornome(modelDfe.getFornecedornome());
        modelDfe.setNsu(modelDfe.getNsu());
        modelDfe.setProtocolo(modelDfe.getProtocolo());
        modelDfe.setValorTotal(modelDfe.getValorTotal());
        modelDfe.setSituacao(atualizar);
        modelDfe.setImagem(imagemCaminho);
        
        controllerDfe.atualizarDfeController(modelDfe);
        
    }
    
    public void confirmacaoOperacao() throws Exception{
        ACBrNFe acbrNFe = new ACBrNFe();
        modelConfig = ManipularXML.lerXmlConfig();
        cnpj = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
        codUf = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1).getModelEstado().getCodigo();
        int posicaoConfirmar = tabelaListaDfe.getSelectionModel().getFocusedIndex();
        int codigoAtualizar = tabelaListaDfe.getItems().get(posicaoConfirmar).getCodigo();
        chaveConfirmar = tabelaListaDfe.getItems().get(posicaoConfirmar).getChavenfe();
        if((tabelaListaDfe.getItems().get(posicaoConfirmar).getSituacao() == 0)||(tabelaListaDfe.getItems().get(posicaoConfirmar).getSituacao() == 1) ){
        String caminho = "C:\\UniShop\\dfe\\"+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\xmlsEntrada\\Nfe\\" + ((blMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(3, 5))+(blMascaras.converteDateEmData(new java.util.Date(System.currentTimeMillis())).substring(6, 10)));
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("COMFIRMAR COMPRA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE CONFIRMAR A COMPRA "+ chaveConfirmar +" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
        classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
                try{
                            acbrNFe.limparListaEventos();        
                            acbrNFe.carregarEventoINI(eventoConfirmacao(chaveConfirmar));
                            acbrNFe.enviarEvento(1);
                            atualizarDfe(codigoAtualizar, 2,"imagens/lupa.png");
                            listaTodos();
                }catch(Exception e)
                        { System.out.println(e);
                }
                classeInterfaces.avisaOuvintesProgresso("principal", Boolean.FALSE);
                classeInterfaces.avisaOuvintesNotificacao("principal", "atualiza");     
            }
       };
        t.start();
                }else{
    }
    });
        }else{
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoExe.setTitle("E R R O");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText(" A COMPRA:  "+ chaveConfirmar +" JÁ FOI CONFIRMADA");
                dialogoExe.show();
                
        }
    }
    
    
    
    public String eventoConfirmacao(String chave){
   ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
   BLMascaras bLMascaras = new BLMascaras();
   String eventoConfirma;        
   eventoConfirma = "[EVENTO]\n"+
"idLote=1\n"+ 
"[EVENTO001]\n"+
"cOrgao=91\n"+
"CNPJ="+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj() +"\n"+
"chNFe="+chave+"\n"+
"dhEvento="+bLMascaras.converteTimeEmDataHoraNF(System.currentTimeMillis())+"\n"+
"tpEvento=210200\n"+
"nSeqEvento=1\n"+
"versaoEvento=1.00";
        
   return eventoConfirma;
    }
    
    public void cienciaOperacao() throws Exception{
        ACBrNFe acbrNFe = new ACBrNFe();
        modelConfig = ManipularXML.lerXmlConfig();
        cnpj = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
        codUf = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1).getModelEstado().getCodigo();
        int posicaoConfirmar = tabelaListaDfe.getSelectionModel().getFocusedIndex();
        int codigoAtualizar = tabelaListaDfe.getItems().get(posicaoConfirmar).getCodigo();
        chaveConfirmar = tabelaListaDfe.getItems().get(posicaoConfirmar).getChavenfe();
        if((tabelaListaDfe.getItems().get(posicaoConfirmar).getSituacao() == 0)){

                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("CAR CIENCIA?");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RELAMENTE DAR CIENCIA DA COMPRA "+ chaveConfirmar +" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);
        Thread t = new Thread() {
            @Override
            public void run() {
                try{
                            acbrNFe.limparListaEventos();
                            acbrNFe.carregarEventoINI(eventoCiencia(chaveConfirmar));
                            acbrNFe.enviarEvento(1);
                            atualizarDfe(codigoAtualizar, 1, "imagens/lupa.png");
                            listaTodos();
                }catch(Exception e)
                        { System.out.println(e);
                }
                classeInterfaces.avisaOuvintesProgresso("principal", Boolean.FALSE);
                classeInterfaces.avisaOuvintesNotificacao("principal", "atualiza");     
            }
       };
        t.start();
                }else{
    }
    }); 
                }else{
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoExe.setTitle("E R R O");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText(" A COMPRA:  "+ chaveConfirmar +" JÁ TEM CIENCIA");
                dialogoExe.show();
                
        }
    }
    
    
    
    public String eventoCiencia(String chave){
   ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
   BLMascaras bLMascaras = new BLMascaras();
   String eventoConfirma;        
   eventoConfirma = "[EVENTO]\n"+
"idLote=1\n"+ 
"[EVENTO001]\n"+
"cOrgao=91\n"+
"CNPJ="+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj() +"\n"+
"chNFe="+chave+"\n"+
"dhEvento="+bLMascaras.converteTimeEmDataHoraNF(System.currentTimeMillis())+"\n"+
"tpEvento=210210\n"+
"nSeqEvento=1\n"+
"versaoEvento=1.00";
   return eventoConfirma;
    }    
    
        public void baixarXml() throws Exception{
        ACBrNFe acbrNFe = new ACBrNFe();
        modelConfig = ManipularXML.lerXmlConfig();
        cnpj = controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj();
        codUf = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1).getModelEstado().getCodigo();
        int posicaoConfirmar = tabelaListaDfe.getSelectionModel().getFocusedIndex();
        int codigoAtualizar = tabelaListaDfe.getItems().get(posicaoConfirmar).getCodigo();
        String dataNota = tabelaListaDfe.getItems().get(posicaoConfirmar).getDatahoraemisao();
        chaveConfirmar = tabelaListaDfe.getItems().get(posicaoConfirmar).getChavenfe();
        if(tabelaListaDfe.getItems().get(posicaoConfirmar).getSituacao() == 3 || tabelaListaDfe.getItems().get(posicaoConfirmar).getSituacao() == 2 ){
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                
                dialogoExe.setTitle("XML DA COMPRA");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA FAZER A IMPORTAÇÃO DO XML DA COMPRA "+ chaveConfirmar +" ?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
        relacionaCompra rCompra = new relacionaCompra();
        Thread t = new Thread() {
            @Override
public void run() {
                try{                    
                            caminhoComleto = "C:\\UniShop\\dfe\\"+controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj()+"\\xmlsEntrada\\NFe\\"
                            +(dataNota.substring(0, 4))+(dataNota.substring(5, 7))+"\\"+chaveConfirmar+"-nfe.xml";
                            if (!(new File(caminhoComleto).exists())){
                                acbrNFe.distribuicaoDFeporChave(codUf, cnpj, chaveConfirmar);
                            }    
                                Thread.sleep(2000);
                                classeInterfaces.avisaOuvintesCaminho("novaTela",caminhoComleto);
                                listaTodos();
                            
                }catch(Exception e)
                        { System.out.println(e);
                }
                classeInterfaces.avisaOuvintesProgresso("principal", Boolean.FALSE);
            }
       };
                    
        t.start();
            try {
            rCompra.start(new Stage());
            } catch (IOException ex) {
            Logger.getLogger(listaDfe.class.getName()).log(Level.SEVERE, null, ex);
            }
            classeInterfaces.avisaOuvintesProgresso("principal", Boolean.TRUE);
            }else{
                        
    }
    });   
                        }else{
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoExe.setTitle("E R R O");
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText(" A COMPRA:  "+ chaveConfirmar +" AINDA NÃO FOI CONFIRMADA");
                dialogoExe.show();
                
        }
    }
    public void abrirRelacionaCompra(){
try {
        relacionaCompra rCompra = new relacionaCompra();
                rCompra.start(new Stage());
                
                } catch (IOException ex) {
                            Logger.getLogger(listaDfe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }

}
    

