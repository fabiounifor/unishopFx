package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelFator {

    private int codigo;
    private Float fator;
    private String descricao;
    private String operando;
    private String pesquisaFator;

    /**
    * Construtor
    */
    public ModelFator(){}

    public String getPesquisaFator() {
        return (codigo + "      " + descricao);
    }

    public void setPesquisaFator(String pesquisaFator) {
        this.pesquisaFator = pesquisaFator;
    }
    
    

    public Float getFator() {
        return fator;
    }

    public void setFator(Float fator) {
        this.fator = fator;
    }

    public String getOperando() {
        return operando;
    }

    public void setOperando(String operando) {
        this.operando = operando;
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

    @Override
    public String toString() {
        return "ModelFator{" + "codigo=" + codigo + ", fator=" + fator + ", descricao=" + descricao + ", operando=" + operando + '}';
    }

  
}