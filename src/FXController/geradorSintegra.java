/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXController;

import interfaces.classeInterfaces;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import util.gerarSintegra;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import relatorios.DAORelatorios;
import util.ManipularXML;

/**
 *
 * @author Fabio
 */
public class geradorSintegra extends Application implements Initializable {
    
     @FXML
    private DatePicker dpInicio;
     @FXML
    private DatePicker dpInventario;

    @FXML
    private CheckBox cb88;

    @FXML
    private CheckBox cb61;

    @FXML
    private CheckBox cbOriginal;

    @FXML
    private CheckBox cbSubstituto;

    @FXML
    private DatePicker dpFim;

    @FXML
    private CheckBox cbInventario;
    
    @FXML private Button btSair;
    
    @FXML private Button btGerarPdf;
    
    @FXML private CheckBox cbInventarioPdf;

    @FXML private TextField tfLivro;

    @FXML private TextField tfFolha;
    
    @FXML private Label lbLivro;

    @FXML private Label lbFolha;
    
    
    @Override
    public void start(Stage sintegraStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/sintegra.fxml")); 
      Parent raiz = loader.load();   
      Scene scene = new Scene(raiz, 800, 600);
        sintegraStage.setScene(scene);
        sintegraStage.initStyle(StageStyle.UNDECORATED);
        sintegraStage.initModality(Modality.APPLICATION_MODAL);
        sintegraStage.show();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     public void sair(){
         Stage estagiosaida = (Stage) btSair.getScene().getWindow();
          estagiosaida.close();
     }
    
    public void sintegra(Date inicio, Date fim, Date Inventario) throws Exception{
    String sintegra, nome;    
    gerarSintegra gs = new gerarSintegra();
    ManipularXML mx = new ManipularXML();
    nome = ("sintegra"+inicio.toString().substring(0,4)+ inicio.toString().substring(5,7)+inicio.toString().substring(8,10)+ fim.toString().substring(0,4)+fim.toString().substring(5,7)+fim.toString().substring(8,10));
    if (cbInventario.isSelected()){
        sintegra = 
    (gs.registroDez(String.valueOf(inicio), String.valueOf(fim), "331"))+
    (gs.registroOnze())+
    ((gs.registroCinquentaSaida(inicio, fim, "55")) +(gs.registroCinquentaEntrada(inicio, fim, "55")) )+
    (gs.registroCinquentaTres(inicio, fim, "55"))+
    ((gs.registroCinquentaQuatroEntrada(inicio, fim, "55"))+(gs.registroCinquentaQuatroSaida(inicio, fim, "55")))+ 
    (gs.registroSessentaUm(inicio, fim, "65"))+
    (gs.registroSessentaUmErre(inicio, fim, "65"))+
    (gs.registroSetentaQuatroInventario(Inventario))+
    (gs.registroSetentaCincoVendasInventario(inicio, fim, "65"))+
    (gs.registroSetentaCincoCompraInventario(inicio, fim, "55"))+
    (gs.registroNoventa(inicio, fim, "65"));
    }else{
    sintegra = 
    (gs.registroDez(String.valueOf(inicio), String.valueOf(fim), "331"))+
    (gs.registroOnze())+
    ((gs.registroCinquentaSaida(inicio, fim, "55")) +(gs.registroCinquentaEntrada(inicio, fim, "55")) )+
    (gs.registroCinquentaTres(inicio, fim, "55"))+
    ((gs.registroCinquentaQuatroEntrada(inicio, fim, "55"))+(gs.registroCinquentaQuatroSaida(inicio, fim, "55")))+ 
    (gs.registroSessentaUm(inicio, fim, "65"))+
    (gs.registroSessentaUmErre(inicio, fim, "65"))+
    (gs.registroSetentaCincoVendas(inicio, fim, "65"))+
    (gs.registroSetentaCincoCompras(inicio, fim, "55"))+
    (gs.registroNoventa(inicio, fim, "65"));
    }
    
            
            
         try {
             mx.gravaSintegra(sintegra, nome);
         } catch (IOException ex) {
             Logger.getLogger(geradorSintegra.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void habilitarInvetarioPdf(){
        if (cbInventarioPdf.isDisable() !=  true){
            tfFolha.setVisible(true);
            tfLivro.setVisible(true);
            tfLivro.setVisible(true);
            lbLivro.setVisible(true);
            lbFolha.setVisible(true);
            btGerarPdf.setVisible(true);
        }else{
            tfFolha.setVisible(false);
            tfLivro.setVisible(false);
            tfLivro.setVisible(false);
            lbLivro.setVisible(false);
            lbFolha.setVisible(false);
            btGerarPdf.setVisible(false);
        }
    }
    
    public void gerarRelatorioInventario() throws Exception{
        DAORelatorios dr = new DAORelatorios();
        Date inicio = Date.valueOf(dpInicio.getValue());
        Date fim = Date.valueOf(dpFim.getValue());
        dr.gerarRelatorioInventario(inicio,fim, tfLivro.getText(), tfFolha.getText());
    }
    
    public void gerarSintegra(){
          classeInterfaces.avisaOuvintesProgresso("principal",Boolean.TRUE);
          DAORelatorios rel = new DAORelatorios();
          Date inicio = Date.valueOf(dpInicio.getValue());
          Date fim = Date.valueOf(dpFim.getValue());
          Date inventario;
          if (cbInventario.isSelected()){
              inventario = Date.valueOf(dpInventario.getValue());
          }else{
              inventario = fim;
          }
          
          Thread t = new Thread() {
            @Override
            public void run() {
                try{
                    System.out.println("inicio sintegra");
                  sintegra(inicio,fim, inventario);
                  rel.gerarRelatorioNfeSaidaPorData(inicio, fim);
                  rel.gerarRelatorioNfeEntradaPorData(inicio, fim);
                  rel.gerarRelatorioCfopSaidaPorData(inicio, fim);
                  rel.gerarRelatorioCfopEntradaPorData(inicio, fim);
                }catch(Exception e)
                        { System.out.println(e);
                }
        classeInterfaces.avisaOuvintesProgresso("principal",Boolean.FALSE);
            }
       };
        t.start();
    }   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            tfFolha.setVisible(false);
            tfLivro.setVisible(false);
            tfLivro.setVisible(false);
            lbLivro.setVisible(false);
            lbFolha.setVisible(false);
            btGerarPdf.setVisible(false);
    }
    
    
}
