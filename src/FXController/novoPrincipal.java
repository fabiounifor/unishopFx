/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import interfaces.classeInterfaces;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import relatorios.DAORelatorios;
import util.BLMascaras;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelProgresso;
import unishop.Unishop;
import util.BackupMySQL;
import FXController.geradorSintegra;
import com.acbr.nfe.ACBrNFe;
import com.acbr.nfe.demo.FrmMain;
import conexoes.ConexaoMySql;
import controller.ControllerEmpresa;
import controller.ControllerUsuario;
import java.io.File;
import java.util.Calendar;
import java.sql.Date;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.JFrame;
import util.BLMascaras;
import util.Backup;

/**
 *
 * @author Fabio
 */
public class novoPrincipal extends Application implements Initializable{
    
    @FXML private Button btFinanceiro;
    @FXML private Button btEntrada;
    @FXML private Button btsaida;
    @FXML private Button btSaida;
    @FXML private Button btMinimizar;
    @FXML private Button btFechar;
    @FXML private ProgressIndicator piProcesso;
    @FXML private FlowPane painel;
    @FXML private Label lbEmpresa;
    @FXML private Label lbCnpj;
    @FXML private Label lbUsuario;
    @FXML private Label lbCertificado;
    @FXML public StackPane painelJanela;
    @FXML public StackPane stkPainel;
    @FXML public ImageView foto;
    @FXML public Pane painelBotoes;
    @FXML private FlowPane cadastrosPainel;
    @FXML private FlowPane entradasPainel;
    @FXML private FlowPane saidasPainel;
    @FXML private FlowPane financeiroPainel;
    @FXML private FlowPane auxiliaresPainel;
    int codigoUsuario;
    public static Stage raizPrincipal;
    private ModelProgresso progresso = new ModelProgresso();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        raizPrincipal = primaryStage;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/principal.fxml")); 
        
        Parent root = loader.load(); 
        primaryStage.setScene(new Scene(root)); 
        primaryStage.setMaximized(true);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
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
        classeInterfaces.addaoMudarTelaOuvinteProgresso((String novaTela, Boolean ativo) -> {
        piProcesso.setVisible(ativo);
        });
        cadastrosPainel.setVisible(false);
        entradasPainel.setVisible(false);
        saidasPainel.setVisible(false);
        financeiroPainel.setVisible(false);
        auxiliaresPainel.setVisible(false);
        bkpFinal();
        arquivosFiscais();
    }
    
    public void mostrarBotoes(){
        painelBotoes.setVisible(true);
    }
    public int procuraBarra(String retorno, String barra ){
        int indice = 0;
        if(retorno.contains(barra)){
            indice  = retorno.indexOf(barra);
        }
        return indice;
    }

    public void iniciarBotoes(int usuario, int empresa) throws Exception{
        ACBrNFe acbr = new ACBrNFe();
        String Barra = "/";
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
        piProcesso.setVisible(false);
        lbEmpresa.setText(controllerEmpresa.getEmpresaController(empresa).getModelEmpresa().getRazaoSocial());
        lbCnpj.setText(controllerEmpresa.getEmpresaController(empresa).getModelEmpresa().getCnpj());
        lbUsuario.setText(controllerUsuario.getUsuarioController(usuario).getNome());
        codigoUsuario = controllerUsuario.getUsuarioController(usuario).getCodigo();
        try {
            String ret = acbr.obterCertificados();
            lbCertificado.setText(ret.substring(procuraBarra(ret, Barra) - 2, procuraBarra(ret, Barra) + 8)+"  ");
        } catch (Exception ex) {
            Logger.getLogger(novoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void saidas() throws IOException{
           saidasPainel.setVisible(true);
           cadastrosPainel.setVisible(false);
           financeiroPainel.setVisible(false);
           entradasPainel.setVisible(false);
    }
    public void cadastros(){
           saidasPainel.setVisible(false);
           cadastrosPainel.setVisible(true);
           financeiroPainel.setVisible(false);
           entradasPainel.setVisible(false);
           auxiliaresPainel.setVisible(false);
    }
    
    public void financeiro(){
           saidasPainel.setVisible(false);
           cadastrosPainel.setVisible(false);
           financeiroPainel.setVisible(true);
           entradasPainel.setVisible(false);
           auxiliaresPainel.setVisible(false);
    }
    
    public void entrada(){
           saidasPainel.setVisible(false);
           cadastrosPainel.setVisible(false);
           financeiroPainel.setVisible(false);
           auxiliaresPainel.setVisible(false);
           entradasPainel.setVisible(true);
                 }
    public void auxiliares(){
           saidasPainel.setVisible(false);
           cadastrosPainel.setVisible(false);
           financeiroPainel.setVisible(false);
           entradasPainel.setVisible(false);
           auxiliaresPainel.setVisible(true);
                 }
    
     public void pessoasCadastro(){
        listaCliente cliente = new listaCliente();
        try {
            cliente.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void produtosCadastro(){
        listaProduto produto = new listaProduto();
        try {
            produto.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
     
     /*public void produtosCadastro() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/pesqProduto.fxml"));
        Parent raizListaProduto = (Parent) loader.load();
        stkPainel.getChildren().add(raizListaProduto);
        stkPainel.setVisible(true);
     }
     public void vazio() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXView/vazio.fxml"));
        Parent raizVazio = (Parent) loader.load();
        stkPainel.getChildren().add(raizVazio);
        stkPainel.setVisible(true);
     }*/
     
    public void unidadesCadastro(){
        listaUnidade unidade = new listaUnidade();
        try {
            unidade.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void fatoresCadastro(){
        listaCfop fator = new listaCfop();
        try {
            fator.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    public void opcionaisCadastro(){
        listaOpcionais opcao = new listaOpcionais();
        try {
            opcao.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void tributacaoEstadualCadastro(){
        listaTributacaoEstadual tribest = new listaTributacaoEstadual();
        try {
            tribest.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
     public void tributacaoFederalCadastro(){
        listaTributacaoFederal trifed = new listaTributacaoFederal();
        try {
            trifed.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    public void garconCadastro(){
        listaGarcon lGarcon = new listaGarcon();
        try {
            lGarcon.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharCadastro();
    }
    
    public void fecharCadastro(){
          cadastrosPainel.setVisible(false);
        
                }
    
     public void listaEntradas(){
        listaCompras lc = new listaCompras();
        try {
            lc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
     public void importarXml(){
        relacionaCompra rCompra = new relacionaCompra();
        try {
            rCompra.start(new Stage());
            classeInterfaces.avisaOuvintesCaminho("novaTela","0");
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
      public void nfeEntrada(){
        qrComprar qrc = new qrComprar();
        try {
            qrc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
      public void consultaSefaz(){
        listaDfe ld = new listaDfe();
        try {
            ld.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharEntrada();
    }
      
      public void fecharEntrada(){
         entradasPainel.setVisible(false);
        
                }
      
      
       public void delivery() throws IOException{
      pedidoVenda venda = new pedidoVenda();
        try {
            venda.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    
    }
     public void mesas(){
        lancaMesa mesas = new lancaMesa();
        try {
            mesas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
     public void entregas(){
        listaEntregas entregas = new listaEntregas();
        try {
            entregas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
      public void qrComprarConectar(){
        geradorSintegra gs = new geradorSintegra();
        try {
            gs.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
      public void listaSaidas(){
        listaVendas lv = new listaVendas();
        try {
            lv.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
       public void abrirPdv(){
        pdv pdvenda = new pdv();
        pdvenda.codigoUsuario = codigoUsuario;
        try {
            pdvenda.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
       public void abrirNfe(){
        nfeSaida nSaida = new nfeSaida();
        try {
            nSaida.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharSaida();
    }
       
       public void fecharSaida(){
    saidasPainel.setVisible(false);
                }
       
        public void caixa(){
        controleCaixa cx = new controleCaixa();
        try {
            cx.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
    
    public void contaReceber(){
        contasReceber cr = new contasReceber();
        try {
            cr.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
    
    public void contaPagar(){
        contasPagar cp = new contasPagar();
        try {
            cp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
    
    public void fecharFinanceiro(){
    financeiroPainel.setVisible(false);
                }
    
    public void backup(){
        Backup bk = new Backup();
        try {
            bk.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharAuxiliares();
    }
    public void relatorios() throws Exception{
    
    }
    public void configuracoes(){
            FrmMain configuracao = new FrmMain();
        try {
            configuracao.setVisible(true);
            configuracao.setSize(1000, 800);
        } catch (Exception ex) {
            Logger.getLogger(Unishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharFinanceiro();
    }
    
    
    public void fecharAuxiliares(){
    auxiliaresPainel.setVisible(false);
                }
    
    public void atualizaProcesso(){
    piProcesso.setVisible(true);
}
    
    public void fechar(){
       Stage estagioSaida = (Stage) btFechar.getScene().getWindow();
                      
       if (bkpFinal() == true){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("BACKUP");
            alert.setContentText("CÓPIA DE SEGURANCA EFETUADA COM SUCESSO");
            alert.getDialogPane().getStylesheets().add("/FXView/alert.css");
            alert.show();
            estagioSaida.close(); 
            desconectaBanco();
            System.exit(0);
       }
       
    }
    public void minimizar(){
       Stage estagioSaida = (Stage) btMinimizar.getScene().getWindow();
          estagioSaida.setIconified(true);
    }
    private boolean bkpFinal(){
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
                 BackupMySQL bkp = new BackupMySQL();
                 @Override
            public void run() {
                // fazer backup
                String caminhoCompleto = "C:\\xampp\\mysql\\bin\\mysqladmin.exe";
                if ((new File(caminhoCompleto).exists())){
                bkp.Backupdbtosql();
                }
                classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
            }
        };
        t.start();
        return true;
    }
    private boolean arquivosFiscais(){
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
        Thread t = new Thread() {
                 
                 @Override
            public void run() {
                // gerar arquivos
                gerarArquivosFiscais();
                classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);       
            }
        };
        t.start();
        return true;
    }
    
    public void gerarArquivosFiscais(){
        DAORelatorios rel = new DAORelatorios();
        geradorSintegra gs = new geradorSintegra();
        BLMascaras blMascaras = new BLMascaras();
        Date datainicial = null;
        Date datafinal = null;
        Date dataAtual = new java.sql.Date(System.currentTimeMillis());
        String dataString = (String.valueOf(dataAtual));
        
        Calendar c = Calendar.getInstance();
        int mes = (Integer.parseInt(dataString.substring(5,7)) -1);
        if (mes < 0){
            mes = 12;
        }
        c.set(Calendar.MONTH, mes-1); //setando o mês para janeiro
        int dias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        if (dataString.substring(8,10).equals("05")){
            try {
                datainicial = blMascaras.converterDataStringParaDate("01/"+mes+"/2022");
                datafinal = blMascaras.converterDataStringParaDate(dias+"/"+mes+"/2022");
            } catch (Exception ex) {
                Logger.getLogger(novoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            rel.gerarRelatorioNfeSaidaPorData(datainicial, datafinal);
            rel.gerarRelatorioNfeEntradaPorData(datainicial, datafinal);
    
        }
        
        
    }
    
    private void desconectaBanco() {
        try {
            ConexaoMySql conn = new ConexaoMySql();
            conn.fecharConexao();
        } catch (Exception e) {
        }
    }


     
}
