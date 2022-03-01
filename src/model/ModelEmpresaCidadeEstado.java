package model;
/**
*
* @author BLSoft Desenvolvimento de Sistema
*/
public class ModelEmpresaCidadeEstado {

    private ModelCidade modelCidade;
    private ModelEstado modelEstado;
    private ModelEmpresa modelEmpresa;

    /**
    * Construtor
    */
    public ModelEmpresaCidadeEstado(){}

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
    * seta o valor de modelEmpresa
    * @param pModelEmpresa
    */
    public void setModelEmpresa(ModelEmpresa pModelEmpresa){
        this.modelEmpresa = pModelEmpresa;
    }
    /**
    * return modelEmpresa
    */
    public ModelEmpresa getModelEmpresa(){
        return this.modelEmpresa;
    }

    @Override
    public String toString(){
        return "ModelEmpresaCidadeEstado {" + "::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado + "::modelEmpresa = " + this.modelEmpresa +  "}";
    }
}