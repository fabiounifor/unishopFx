/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe.model;

/**
 *
 * @author leand
 */
public class ModelXmlDfe {
    // CAMPO CABEÇALHO
   // private String resNFe;//resumo da NFe
    //    campos com valores
    private String chNFe;//Chave da NFe
    private String CNPJ;//CNPJ EMITENTE
    private String IE;//INCRIÇÃO ESTADUAL EMITENTE
    private String xNome;//NOME DO EMITENTE
    private String dhEmi;//DATA HORA EMISSÃO
    private String dhRecbto;//DATA HORA RECEBIMENTO
    private String cSitNFe;//CODIGO DA SITUAÇÃO
    private String vNF;//VALOR DA NFE
    private String nProt;//PROTOCOLO DA NFE
    private String tpNF;//tipo da NFe
    private String digVal;//VALIDAÇÃO DIGITAL
    private String nfeProc;//INDICATIVO DE NFE COMPLETA

    public ModelXmlDfe() {
    }

    public String getNfeProc() {
        return nfeProc;
    }

    public void setNfeProc(String nfeProc) {
        this.nfeProc = nfeProc;
    }
    

    public String getxNome() {
        return xNome;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getDhRecbto() {
        return dhRecbto;
    }

    public void setDhRecbto(String dhRecbto) {
        this.dhRecbto = dhRecbto;
    }

    public String getcSitNFe() {
        return cSitNFe;
    }

    public void setcSitNFe(String cSitNFe) {
        this.cSitNFe = cSitNFe;
    }

    public String getTpNF() {
        return tpNF;
    }

    public void setTpNF(String tpNF) {
        this.tpNF = tpNF;
    }

    public String getDigVal() {
        return digVal;
    }

    public void setDigVal(String digVal) {
        this.digVal = digVal;
    }
    
    

    public String getChNFe() {
        return chNFe;
    }

    public void setChNFe(String chNFe) {
        this.chNFe = chNFe;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getDhEmi() {
        return dhEmi;
    }

    public void setDhEmi(String dhEmi) {
        this.dhEmi = dhEmi;
    }

    public String getvNF() {
        return vNF;
    }

    public void setvNF(String vNF) {
        this.vNF = vNF;
    }

    public String getnProt() {
        return nProt;
    }

    public void setnProt(String nProt) {
        this.nProt = nProt;
    }

    @Override
    public String toString() {
        return "ModelXmlDfe{" + "chNFe=" + chNFe + ", CNPJ=" + CNPJ + ", IE=" + IE + ", xNome=" + xNome + ", dhEmi=" + dhEmi + ", dhRecbto=" + dhRecbto + ", cSitNFe=" + cSitNFe + ", vNF=" + vNF + ", nProt=" + nProt + ", tpNF=" + tpNF + ", digVal=" + digVal + ", nfeProc=" + nfeProc + '}';
    }

   


}
