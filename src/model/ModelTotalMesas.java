package model;
/**
*
* @author BLSoft
*/
public class ModelTotalMesas {

    private int codigo;
    private int quantidade;

    /**
    * Construtor
    */
    public ModelTotalMesas(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return pk_codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(int pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
    */
    public int getQuantidade(){
        return this.quantidade;
    }

    @Override
    public String toString(){
        return "ModelTotalMesas {" + "::codigo = " + this.codigo + "::quantidade = " + this.quantidade +  "}";
    }
}