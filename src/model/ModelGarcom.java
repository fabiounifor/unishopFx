package model;

import controller.ControllerGarcom;

/**
*
* @author BLSoft
*/
public class ModelGarcom {

    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private int codCidade;
    private int codEstado;
    private String cep;
    private String telefone;
    private float comissao;
    private String senha;
    public String pesquisaGarcon;

    /**
    * Construtor
    */
    public ModelGarcom(){}

    public String getPesquisaGarcon() {
              
        return codigo + "  " + nome + "   " + endereco + "   "+telefone;
    }

    public void setPesquisaGarcon(String pesquisaGarcon) {
        this.pesquisaGarcon = nome + "   " + endereco + "   "+telefone;
    }
    
    

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
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de endereco
    * @param pEndereco
    */
    public void setEndereco(String pEndereco){
        this.endereco = pEndereco;
    }
    /**
    * return endereco
    */
    public String getEndereco(){
        return this.endereco;
    }

    /**
    * seta o valor de bairro
    * @param pBairro
    */
    public void setBairro(String pBairro){
        this.bairro = pBairro;
    }
    /**
    * return bairro
    */
    public String getBairro(){
        return this.bairro;
    }

    /**
    * seta o valor de codCidade
    * @param pCodCidade
    */
    public void setCodCidade(int pCodCidade){
        this.codCidade = pCodCidade;
    }
    /**
    * return codCidade
    */
    public int getCodCidade(){
        return this.codCidade;
    }

    /**
    * seta o valor de codEstado
    * @param pCodEstado
    */
    public void setCodEstado(int pCodEstado){
        this.codEstado = pCodEstado;
    }
    /**
    * return codEstado
    */
    public int getCodEstado(){
        return this.codEstado;
    }

    /**
    * seta o valor de cep
    * @param pCep
    */
    public void setCep(String pCep){
        this.cep = pCep;
    }
    /**
    * return cep
    */
    public String getCep(){
        return this.cep;
    }

    /**
    * seta o valor de telefone
    * @param pTelefone
    */
    public void setTelefone(String pTelefone){
        this.telefone = pTelefone;
    }
    /**
    * return telefone
    */
    public String getTelefone(){
        return this.telefone;
    }

    /**
    * seta o valor de comissao
    * @param pComissao
    */
    public void setComissao(float pComissao){
        this.comissao = pComissao;
    }
    /**
    * return comissao
    */
    public float getComissao(){
        return this.comissao;
    }

    /**
    * seta o valor de senha
    * @param pSenha
    */
    public void setSenha(String pSenha){
        this.senha = pSenha;
    }
    /**
    * return senha
    */
    public String getSenha(){
        return this.senha;
    }

    @Override
    public String toString(){
        return "ModelGarcom {" + "::codigo = " + this.codigo + "::nome = " + this.nome + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::codCidade = " + this.codCidade + "::codEstado = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone + "::comissao = " + this.comissao + "::senha = " + this.senha +  "}";
    }
}