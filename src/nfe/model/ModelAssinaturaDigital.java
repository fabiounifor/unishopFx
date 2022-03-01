package nfe.model;
/**
*
* @author Leandro
*/
public class ModelAssinaturaDigital {

    private int codigo;
    private int empresa;
    private String senhaTruststore;
    private String senhaToken;
    private String senhaKeystore;
    private String serie55;
    private String serie65;
    private String verproc;
    private String idtoken;
    private String csc;
    private String cscProd;

    /**
    * Construtor
    */
    public ModelAssinaturaDigital(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de empresa
    * @param pEmpresa
    */
    public void setEmpresa(int pEmpresa){
        this.empresa = pEmpresa;
    }
    /**
    * return empresa
    */
    public int getEmpresa(){
        return this.empresa;
    }

    /**
    * seta o valor de senhaTruststore
    * @param pSenhaTruststore
    */
    public void setSenhaTruststore(String pSenhaTruststore){
        this.senhaTruststore = pSenhaTruststore;
    }
    /**
    * return senhaTruststore
    */
    public String getSenhaTruststore(){
        return this.senhaTruststore;
    }

    /**
    * seta o valor de senhaToken
    * @param pSenhaToken
    */
    public void setSenhaToken(String pSenhaToken){
        this.senhaToken = pSenhaToken;
    }
    /**
    * return senhaToken
    */
    public String getSenhaToken(){
        return this.senhaToken;
    }

    /**
    * seta o valor de senhaKeystore
    * @param pSenhaKeystore
    */
    public void setSenhaKeystore(String pSenhaKeystore){
        this.senhaKeystore = pSenhaKeystore;
    }
    /**
    * return senhaKeystore
    */
    public String getSenhaKeystore(){
        return this.senhaKeystore;
    }

    /**
    * seta o valor de serie55
    * @param pSerie55
    */
    public void setSerie55(String pSerie55){
        this.serie55 = pSerie55;
    }
    /**
    * return serie55
    */
    public String getSerie55(){
        return this.serie55;
    }

    /**
    * seta o valor de serie65
    * @param pSerie65
    */
    public void setSerie65(String pSerie65){
        this.serie65 = pSerie65;
    }
    /**
    * return serie65
    */
    public String getSerie65(){
        return this.serie65;
    }

    /**
    * seta o valor de verproc
    * @param pVerproc
    */
    public void setVerproc(String pVerproc){
        this.verproc = pVerproc;
    }
    /**
    * return verproc
    */
    public String getVerproc(){
        return this.verproc;
    }

    /**
    * seta o valor de idtoken
    * @param pIdtoken
    */
    public void setIdtoken(String pIdtoken){
        this.idtoken = pIdtoken;
    }
    /**
    * return idtoken
    */
    public String getIdtoken(){
        return this.idtoken;
    }

    /**
    * seta o valor de csc
    * @param pCsc
    */
    public void setCsc(String pCsc){
        this.csc = pCsc;
    }
    /**
    * return csc
    */
    public String getCsc(){
        return this.csc;
    }

    /**
    * seta o valor de cscProd
    * @param pCscProd
    */
    public void setCscProd(String pCscProd){
        this.cscProd = pCscProd;
    }
    /**
    * return cscProd
    */
    public String getCscProd(){
        return this.cscProd;
    }

    @Override
    public String toString(){
        return "ModelAssinaturaDigital {" + "::codigo = " + this.codigo + "::empresa = " + this.empresa + "::senhaTruststore = " + this.senhaTruststore + "::senhaToken = " + this.senhaToken + "::senhaKeystore = " + this.senhaKeystore + "::serie55 = " + this.serie55 + "::serie65 = " + this.serie65 + "::verproc = " + this.verproc + "::idtoken = " + this.idtoken + "::csc = " + this.csc + "::cscProd = " + this.cscProd +  "}";
    }
}