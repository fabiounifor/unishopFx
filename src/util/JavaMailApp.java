/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author FABIO
 */

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.swing.JOptionPane;
import model.ModelEmail;



public class JavaMailApp {
 
    

//    public static void main(String[] args) {

       public void envioSimples (String nomeRemetente, String assunto, String mensagem, String destinatario) throws UnsupportedEncodingException {
          
           try {
            ModelEmail me = new ModelEmail();
            String host = "smtp.gmail.com";
            String usuario = "fabio.braga.suporte@gmail.com";
            String senha = "@unifor123";
            String remetente = "fabio.braga.suporte@gmail.com";
            me.setMensagem(mensagem);
            me.setHost(host);
            me.setUsuario(usuario);
            me.setSenha(senha);
            me.setRemetente(remetente);
            
            boolean sessionDebug = true;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", host);

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(remetente, nomeRemetente));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(assunto);
            msg.setSentDate(new Date());
            msg.setContent(mensagem, "text/html;charset=UTF-8");

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, usuario, senha);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

            System.out.println("Enviado com Sucesso");
        } catch (MessagingException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao enviar email. \nVerifique a sua conexão..." + ex);
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, "Destinatários Inválidos" + ex);
        }
    }
       
    
}
