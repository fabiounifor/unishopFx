package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelMesas {

    private int codigo;
    private int numeroMesa;
    private String situacaoMesa;

    /**
    * Construtor
    */
    public ModelMesas(){}

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
    * seta o valor de numeroMesa
    * @param pNumeroMesa
    */
    public void setNumeroMesa(int pNumeroMesa){
        this.numeroMesa = pNumeroMesa;
    }
    /**
    * return numeroMesa
    */
    public int getNumeroMesa(){
        return this.numeroMesa;
    }

    /**
    * seta o valor de situacaoMesa
    * @param pSituacaoMesa
    */
    public void setSituacaoMesa(String pSituacaoMesa){
        this.situacaoMesa = pSituacaoMesa;
    }
    /**
    * return situacaoMesa
    */
    public String getSituacaoMesa(){
        return this.situacaoMesa;
    }

    @Override
    public String toString(){
        return "ModelMesas {" + "::codigo = " + this.codigo + "::numeroMesa = " + this.numeroMesa + "::situacaoMesa = " + this.situacaoMesa +  "}";
    }

}