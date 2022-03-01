/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author FABIO
 */

public class ModelEmail {
    
int codigo;
String Assunto;
String Mensagem;
String remetente;
String destinatario;
String usuario;
String senha;
String host;
int porta;
String cnpj;

    


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String pUsuario) {
        this.usuario = pUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String pSenha) {
        this.senha = pSenha;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String pHost) {
        this.host = pHost;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String pRemetente) {
        this.remetente = pRemetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String pDestinatario) {
        this.destinatario = pDestinatario;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String pAssunto) {
        this.Assunto = pAssunto;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String pMensagem) {
        this.Mensagem = pMensagem;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ModelEmail{" + "codigo=" + codigo + ", Assunto=" + Assunto + ", Mensagem=" + Mensagem + ", remetente=" + remetente + ", destinatario=" + destinatario + ", usuario=" + usuario + ", senha=" + senha + ", host=" + host + ", porta=" + porta + ", cnpj=" + cnpj + '}';
    }

    
}
