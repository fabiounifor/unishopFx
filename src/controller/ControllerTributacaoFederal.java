package controller;

import DAO.DAOTributacaoFederal;
import java.util.ArrayList;
import model.ModelTributacaoFederal;

/**
*
* @author Leandro Nazareth
*/
public class ControllerTributacaoFederal {

    private DAOTributacaoFederal daoTributacaoFederal = new DAOTributacaoFederal();

        
/**
    * grava TributacaoFederal
    * @param pModelTributacaoFederal
    * @return int
    */
    public int salvarTributacaoFederalController(ModelTributacaoFederal pModelTributacaoFederal){
        return this.daoTributacaoFederal.salvarTributacaoFederalDAO(pModelTributacaoFederal);
    }

    /**
    * recupera TributacaoFederal
    * @param pCodigo
    * @return ModelTributacaoFederal
    */
    public ModelTributacaoFederal getTributacaoFederalController(int pCodigo){
        return this.daoTributacaoFederal.getTributacaoFederal(pCodigo);
    }
   
    /**
    * recupera uma lista deTributacaoFederal
    * @return ArrayList
    */
    public ArrayList<ModelTributacaoFederal> getListaTributacaoFederalController(){
        return this.daoTributacaoFederal.getListaTributacaoFederal();
    }

    /**
    * atualiza TributacaoFederal
    * @param pModelTributacaoFederal
    * @return boolean
    */
    public boolean atualizarTributacaoFederalController(ModelTributacaoFederal pModelTributacaoFederal){
        return this.daoTributacaoFederal.atualizarTributacaoFederalDAO(pModelTributacaoFederal);
    }

    /**
    * exclui TributacaoFederal
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirTributacaoFederalController(int pCodigo){
        return this.daoTributacaoFederal.excluirTributacaoFederalDAO(pCodigo);
    }
    
}