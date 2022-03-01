package controller;

import DAO.DAOTributacaoEstadual;
import java.util.ArrayList;
import model.ModelTributacaoEstadual;

/**
*
* @author Leandro Nazareth
*/
public class ControllerTributacaoEstadual {

    private DAOTributacaoEstadual daoTributacaoEstadual = new DAOTributacaoEstadual();

        
/**
    * grava TributacaoEstadual
    * @param pModelTributacaoEstadual
    * @return int
    */
    public int salvarTributacaoEstadualController(ModelTributacaoEstadual pModelTributacaoEstadual){
        return this.daoTributacaoEstadual.salvarTributacaoEstadualDAO(pModelTributacaoEstadual);
    }

    /**
    * recupera TributacaoEstadual
    * @param pCodigo
    * @return ModelTributacaoEstadual
    */
    public ModelTributacaoEstadual getTributacaoEstadualController(int pCodigo){
        return this.daoTributacaoEstadual.getTributacaoEstadual(pCodigo);
    }
   
    /**
    * recupera uma lista deTributacaoEstadual
    * @return ArrayList
    */
    public ArrayList<ModelTributacaoEstadual> getListaTributacaoEstadualController(){
        return this.daoTributacaoEstadual.getListaTributacaoEstadual();
    }

    /**
    * atualiza TributacaoEstadual
    * @param pModelTributacaoEstadual
    * @return boolean
    */
    public boolean atualizarTributacaoEstadualController(ModelTributacaoEstadual pModelTributacaoEstadual){
        return this.daoTributacaoEstadual.atualizarTributacaoEstadualDAO(pModelTributacaoEstadual);
    }

    /**
    * exclui TributacaoEstadual
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirTributacaoEstadualController(int pCodigo){
        return this.daoTributacaoEstadual.excluirTributacaoEstadualDAO(pCodigo);
    }
    
}