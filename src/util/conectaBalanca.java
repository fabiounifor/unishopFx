/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.InputStream;
import java.io.OutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import unishop.Unishop;

/**
 *
 * @author Fabio
 */
public class conectaBalanca extends Application implements Runnable, SerialPortEventListener {
    //propriedades
private Unishop uni;
private String Porta;
public String Dadoslidos;
public int nodeBytes;
private int baudrate;
private int timeout;
private CommPortIdentifier cp;
private SerialPort porta;
private OutputStream saida;
private InputStream entrada;
private String informacao;
private Thread threadLeitura;
//indicadores
private boolean IDPortaOK; //true porta EXISTE
private boolean PortaOK;// true porta aberta
private boolean Leitura;
private boolean Escrita;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public conectaBalanca() {
    //pri = new principal();
    Porta = "COM1";
    baudrate = 9600;
    timeout = 1000;
    //System.out.println("Entrei no construtor");
};
//um Objeto ComObj é passado ao construtor
//com detalhes de qual porta abrir
//e informações sobre configurações
public conectaBalanca( String p , int b , int t ){
    this.Porta = p;
    this.baudrate = b;
    this.timeout = t;
};
//habilita escrita de dados
public void HabilitarEscrita(){
    Escrita = true;
    Leitura = false;
}
//habilita leitura de dados
public void HabilitarLeitura(){
    Escrita = false;
    Leitura = true;
}
//Obtém o ID da PORTA
public void ObterIdDaPorta(){
    try {
        cp = CommPortIdentifier.getPortIdentifier(Porta);
        System.out.println(cp + "  " + Porta);
        if ( cp == null ) {
            System.out.println("A " + Porta + " nao existe!" );
            System.out.println("ERRO!Abortando..." );
            IDPortaOK = false;
            System.exit(1);
        }
        IDPortaOK = true;
    } catch (Exception e) {
        System.out.println("Erro durante o procedimento. STATUS: " + e );
        IDPortaOK = false;
        System.exit(1);
    }
}
//Abre a comunicação da porta
public void AbrirPorta(){
    try {
        porta = (SerialPort)cp.open("conectaBalanca",timeout);
        PortaOK = true;
        System.out.println("Porta aberta com sucesso!");
        //configurar parâmetros
        porta.setSerialPortParams(baudrate,
        porta.DATABITS_8,
        porta.STOPBITS_2,
        porta.PARITY_NONE);
    } catch (Exception e) {
        PortaOK = false;
        System.out.println("Erro ao abrir a porta! STATUS: " + e );
        System.exit(1);
    }
}
//função que envie um bit para a porta serial
public void EnviarUmaString(String msg){
    if (Escrita==true) {
        try {
            saida = porta.getOutputStream();
            System.out.println("FLUXO OK!");
        } catch (Exception e) {
            System.out.println("Erro.STATUS: " + e );
        }
        try {
            System.out.println("Enviando um byte para " + Porta );
            System.out.println("Enviando : " + msg );
            saida.write(msg.getBytes());
            Thread.sleep(100);
            saida.flush();
        } catch (Exception e) {
            System.out.println("Houve um erro durante o envio. ");
            System.out.println("STATUS: " + e );
            System.exit(1);
        }
    } else {
        System.exit(1);
    }
}
//leitura de dados na serial
public void LerDados(){
    if (Leitura == true){
        try {
            entrada = porta.getInputStream();
            System.out.println("FLUXO OK!");
        } catch (Exception e) {
            System.out.println("Erro.STATUS: " + e );
            System.exit(1);
        }
        try {
            porta.addEventListener(this);
            System.out.println("SUCESSO. Porta aguardando...");
        } catch (Exception e) {
            System.out.println("Erro ao criar listener: ");
            System.out.println("STATUS: " + e);
            System.exit(1);
        }
        porta.notifyOnDataAvailable(true);
        try {
            threadLeitura = new Thread(this);
            threadLeitura.start();
        } catch (Exception e) {
            System.out.println("Erro ao iniciar leitura: " + e );
        }
    }
}

//método RUN da thread de leitura
public void run(){
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        System.out.println("Erro. Status = " + e );
    }
}
//gerenciador de eventos de leitura na serial
public void serialEvent(SerialPortEvent ev){
    switch (ev.getEventType()) {
        case SerialPortEvent.BI:
        case SerialPortEvent.OE:
        case SerialPortEvent.FE:
        case SerialPortEvent.PE:
        case SerialPortEvent.CD:
        case SerialPortEvent.CTS:
        case SerialPortEvent.DSR:
        case SerialPortEvent.RI:
        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
        break;
        case SerialPortEvent.DATA_AVAILABLE:
        byte[] bufferLeitura = new byte[8];
        try {
            while ( entrada.available() > 0 ) {
                nodeBytes = entrada.read(bufferLeitura);
            }
            String Dadoslidos = new String(bufferLeitura);
            if (bufferLeitura.length == 0) {
                System.out.println("Nada lido!");
            } else if (bufferLeitura.length == 1 ){
                System.out.println("Apenas um byte foi lido!");
            } else {
                System.out.println(Dadoslidos);
                //System.out.println("Rafael " + Dadoslidos.substring(0,2));
                if(Dadoslidos.substring(0,2).equals(new String("00"))){
                    System.out.println("entrei");
                   //uni.atualizaInfo(Dadoslidos.substring(0,2), "velVento");
                    System.out.println("passei");
                }
            }
           
        } catch (Exception e) {
            System.out.println("Erro durante a leitura: " + e );
        }
        
        /*if(Dadoslidos.substring(1,3) == "dir"){
            pri.atualizaInfo(Dadoslidos.substring(4,4), "dirVento");
        }
        
        if(Dadoslidos.substring(1,3) == "ven"){
            pri.atualizaInfo(Dadoslidos.substring(4,5), "velVento");
        }
        
        if(Dadoslidos.substring(1,3) == "vel"){
            //pri.atualizaInfo(Dadoslidos.substring(4,6), "velObjeto");
            System.out.println("Entrei onde naum era pra entrar");
        }*/
        
        
        System.out.println("n.o de bytes lidos : " + nodeBytes );
        break;
    }
}
//função que fecha a conexão
public void FecharCom(){
    try {
        porta.close();
        System.out.println("CONEXAO FECHADA>>FIM..");
    } catch (Exception e) {
        System.out.println("ERRO AO FECHAR. STATUS: " + e );
        System.exit(0);
    }
}
//Acessores
public String obterPorta(){
    return Porta;
}
public int obterBaudrate(){
    return baudrate;
}
    
}
