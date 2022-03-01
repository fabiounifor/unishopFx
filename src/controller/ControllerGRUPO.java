package controller;

import model.ModelGrupo;
import DAO.DAOGRUPO;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerGRUPO {

    private final DAOGRUPO daoGRUPO = new DAOGRUPO();

    /**
    * grava GRUPO
    * @param pModelGRUPO
    * return int
     * @return 
    */
    public int salvarGRUPOController(ModelGrupo pModelGRUPO){
        return this.daoGRUPO.salvarGRUPODAO(pModelGRUPO);
    }

    /**
    * recupera GRUPO
    * @param pCodigo
    * return ModelGRUPO
     * @return 
    */
    public ModelGrupo getGRUPOController(int pCodigo){
        return this.daoGRUPO.getGrupoDAO(pCodigo);
    }

    /**
    * recupera uma lista deGRUPO
     * @return 
    */
    public ArrayList<ModelGrupo> getListaGRUPOController(){
        return this.daoGRUPO.getListaGRUPODAO();
    }

    /**
    * atualiza GRUPO
    * @param pModelGRUPO
    * return boolean
     * @return 
    */
    public boolean atualizarGRUPOController(ModelGrupo pModelGRUPO){
        return this.daoGRUPO.atualizarGRUPODAO(pModelGRUPO);
    }

    /**
    * exclui GRUPO
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirGRUPOController(int pCodigo){
        return this.daoGRUPO.excluirGRUPODAO(pCodigo);
    }
}