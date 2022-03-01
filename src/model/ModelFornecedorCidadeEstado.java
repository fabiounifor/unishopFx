package model;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelFornecedorCidadeEstado {

    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelFornecedor modelFornecedor;

    /**
    * Construtor
    */
    public ModelFornecedorCidadeEstado(){}

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
     * @return the modelCliente
     */
    public  ModelFornecedor getModelFornecedor() {
        return modelFornecedor;
    }

    /**
     * @param modelFornecedor the modelCliente to set
     */
    public void setModelFornecedor(ModelFornecedor modelFornecedor) {
        this.modelFornecedor = modelFornecedor;
    }
}