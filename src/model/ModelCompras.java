package model;

import java.sql.Date;

/**
*
* @author BLSoft
*/
public class ModelCompras {

    private int codigo;
    private double valorTotal;
    private Date data;

    /**
    * Construtor
    */
    public ModelCompras(){}

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
    * seta o valor de valorTotal
    * @param pValorTotal
    */
    public void setValorTotal(double pValorTotal){
        this.valorTotal = pValorTotal;
    }
    /**
    * return valorTotal
    */
    public double getValorTotal(){
        return this.valorTotal;
    }

    @Override
    public String toString(){
        return "ModelCompras {" + "::codigo = " + this.codigo + "::valorTotal = " + this.valorTotal +  "}";
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
}