package model;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelClienteCidadeEstado {

    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelCliente modelCliente;

    /**
    * Construtor
    */
    public ModelClienteCidadeEstado(){}

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
    public String toString() {
        return "ModelClienteCidadeEstado{" + "modelCidade=" + modelCidade+ ", modelEstado=" + modelEstado + ", modelCliente=" + modelCliente + '}';
    }
    
    /**
     * @return the modelCliente
     */
    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    /**
     * @param modelCliente the modelCliente to set
     */
    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }
}