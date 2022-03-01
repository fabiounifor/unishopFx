package model;
/**
*
* @author Leandro
*/
public class ModelCst {

    private int codigo;
    private int numero;
    private String descricao;
    

    /**
    * Construtor
    */
    public ModelCst(){}

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    */
    public String getDescricao(){
        return this.descricao;
    }

    @Override
    public String toString() {
        return "ModelCsosn{" + "codigo=" + codigo + ", numero=" + numero + ", descricao=" + descricao + '}';
    }


}