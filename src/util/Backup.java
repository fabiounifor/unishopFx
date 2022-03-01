/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.ControllerVendas;
import interfaces.classeInterfaces;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.ModelCliente;

/**
 *
 * @author Fabio
 */
public class Backup extends Application implements Initializable{
    @FXML
    private Button btPesquisarBackup;

    @FXML
    private TextField pesquisaBackup;

    @FXML
    private TableView<String> tabelaListaBackup;

    @FXML
    private TableColumn<String, String> listaBackupCelula;

    @FXML
    private Button btAdcionarBackup;

    @FXML
    private Button btSelecionaBackup;

    @FXML
    private Button btSair;

    ObservableList<String> listadeBackups;
    BackupMySQL backupMySQL = new BackupMySQL();
    BLMascaras bLMascaras = new BLMascaras();
    
    @Override
    public void start(Stage stageBackup) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXView/pesqBackup.fxml"));        
        Parent raiz = loader.load();   
        stageBackup.setScene(new Scene(raiz));
        stageBackup.initStyle(StageStyle.UNDECORATED);
        stageBackup.show();
    }
    private static final long MEGABYTE = 1024L;
    
    public static long bytesToMeg(long bytes) {
        return bytes / MEGABYTE;
    }
    private void gerarBackup(){
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // fazer backup
                if (backupMySQL.Backupdbtosql()) {
                    JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!");
                    try {
                        listarDiretorio();
                    } catch (Exception ex) {
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar o backup!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                carregando.dispose();
            }
        };
        t.start();
    }
    
    public void listarDiretorio() throws Exception {
        long dataLong;
        String dataString;
        ArrayList<String> linhas = new ArrayList<>();
        //Configura a tabela
        
        File diretorio = new File("C:\\unishop\\backup\\");
        if (!diretorio.exists()) {
            diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
        }
        File[] arquivos = diretorio.listFiles();
        
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File file = arquivos[i];

                if (file.isFile()) {
                    //pegar somente a data do arquivo
                    try {
                        dataLong = Long.parseLong(file.getName().substring(7, 20));
                    } catch (Exception e) {
                        dataLong = 0;
                    }
                    try {
                        dataString = bLMascaras.converteTimeEmDataHora(dataLong);
                    } catch (Exception e) {
                        dataString = null;
                    }
                        
                    String linhaCompleta  = file.getName() +"   "+ String.valueOf(file.getAbsolutePath())+ "  "  
                    + String.valueOf(dataString)  +"" + String.valueOf(bytesToMeg(file.length())) + "kb";
                    linhas.add(linhaCompleta);
                } else if (file.isDirectory()) {
                }
            }
           listadeBackups = FXCollections.observableArrayList(linhas);
           tabelaListaBackup.getItems().addAll(listadeBackups);
        }
    }
    
    public void restaurarBackup(){
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // restaurar backup
                int linha = tabelaListaBackup.getSelectionModel().getSelectedIndex();
                String nome = (String) tabelaListaBackup.getItems().get(linha);
                //pegunta se realmente deseja excluir
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE );
                ButtonType btnNao = new ButtonType("não", ButtonBar.ButtonData.CANCEL_CLOSE);
                dialogoExe.setHeaderText("A T E N Ç Ã O !!!");
                dialogoExe.setContentText("DESEJA RESTAURAR O BACKUP SELECIONADO?");
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.getDialogPane().getStylesheets().add("/FXView/alert.css");
                dialogoExe.showAndWait().ifPresent(b -> {
                    if (b == btnSim) { 
                        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                try{
                    ActionEvent evento = null;
                    backupMySQL.Restoredbfromsql(nome);
                }catch(Exception e)
                        { System.out.println(e);
                    
                }
                
                carregando.dispose();
            }
       };
        t.start();
            }
            });
            }
        };
        t.start();
    }
        public void sair(){
        Stage Backup = (Stage) btSair.getScene().getWindow();
            Backup.close();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listarDiretorio();
        } catch (Exception ex) {
            
        }
    }
    
}
