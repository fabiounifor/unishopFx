package model;

import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelCidadeEstado {

    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ArrayList<ModelCidadeEstado> listaModelCidadeEstados;

    /**
    * Construtor
    */
    public ModelCidadeEstado(){}

    /**
    * seta o valor de modelCidade
    * @param pModelCidade
    */
    public void setModelCidade(ModelCidade pModelCidade){
        this.modelCidade = pModelCidade;
    }
    /**
    * return modelCidade
    */
    public ModelCidade getModelCidade(){
        return this.modelCidade;
    }

    /**
    * seta o valor de modelEstado
    * @param pModelEstado
    */
    public void setModelEstado(ModelEstado pModelEstado){
        this.modelEstado = pModelEstado;
    }
    /**
    * return modelEstado
    */
    public ModelEstado getModelEstado(){
        return this.modelEstado;
    }

    @Override
    public String toString(){
        return "ModelCidadeEstado {" + "::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado +  "}";
    }

    /**
     * @return the listaModelCidadeEstados
     */
    public ArrayList<ModelCidadeEstado> getListaModelCidadeEstados() {
        return listaModelCidadeEstados;
    }

    /**
     * @param listaModelCidadeEstados the listaModelCidadeEstados to set
     */
    public void setListaModelCidadeEstados(ArrayList<ModelCidadeEstado> listaModelCidadeEstados) {
        this.listaModelCidadeEstados = listaModelCidadeEstados;
    }
}