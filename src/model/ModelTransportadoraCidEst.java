package model;
/**
*
* @author Leandro
*/
public class ModelTransportadoraCidEst {

    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelTransportadora modelTransportadora;

    /**
    * Construtor
    */
    public ModelTransportadoraCidEst(){}

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

    /**
    * seta o valor de modelTransportadora
    * @param pModelTransportadora
    */
    public void setModelTransportadora(ModelTransportadora pModelTransportadora){
        this.modelTransportadora = pModelTransportadora;
    }
    /**
    * return modelTransportadora
    */
    public ModelTransportadora getModelTransportadora(){
        return this.modelTransportadora;
    }

    @Override
    public String toString(){
        return "ModelTransportadoraCidEst {" + "::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado + "::modelTransportadora = " + this.modelTransportadora +  "}";
    }
}