package controller;

import model.ModelFator;
import DAO.DAOfator;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerFator {

    private final DAOfator daoFator = new DAOfator();

    /**
    * grava GRUPO
     * @param pModelFator
     * @return 
    */
    public int salvarFatorController(ModelFator pModelFator){
        return this.daoFator.salvarfatorDAO(pModelFator);
    }

    /**
    * recupera GRUPO
    * @param pCodigo
    * return ModelGRUPO
     * @return 
    */
    public ModelFator getFatorController(int pCodigo){
        return this.daoFator.getFatorDAO(pCodigo);
    }
    
    /**
    * recupera FATOR
    * @param pDescricao
    * return ModelFATOR
     * @return 
    */
    public ModelFator getFatorDescricaoController(String pDescricao){
        return this.daoFator.getFatorDescricaoDAO(pDescricao);
    }

    /**
    * recupera uma lista deGRUPO
     * @return 
    */
    public ArrayList<ModelFator> getListaFatorController(){
        return this.daoFator.getListaFatorDAO();
    }

    /**
    * atualiza GRUPO
     * @param pModelFator
     * @return 
    */
    public boolean atualizarFatorController(ModelFator pModelFator){
        return this.daoFator.atualizarFatorDAO(pModelFator);
    }

    /**
    * exclui GRUPO
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirFatorController(int pCodigo){
        return this.daoFator.excluirFatorDAO(pCodigo);
    }
}