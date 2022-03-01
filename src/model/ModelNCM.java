package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelNCM {

    private int codigo;
    private String ncm;
    private String descricao;
    private String pesquisaNcm;
    

    /**
    * Construtor
    */
    public ModelNCM(){}

    public String getPesquisaNcm() {
        return ncm + "        " + descricao;
    }

    public void setPesquisaNcm(String pesquisaNcm) {
        this.pesquisaNcm = pesquisaNcm;
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
     * @return 
    */
    public int getCodigo(){
        return this.codigo;
    }
       /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * return descricao
     * @return 
    */
    public String getDescricao(){
        return this.descricao;
    }
/**
    * return NCM
     * @return 
    */
    public String getNcm() {
        return ncm;
    }
   /**
    * seta o valor de descricao
     * @param ncm
    */
    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    
    public String toString(){
        return "ModelNCM {" + "::codigo = " + this.codigo + "::descricao = "+ this.ncm + "::NCM = " + this.descricao +  "}";
    }
}