package controller;

import model.ModelTipo;
import DAO.DAOTipo;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerTipo {

    private final DAOTipo daotipo = new DAOTipo();

    /**
    * grava tipo
    * @param pModelTipo
    * return int
     * @return 
    */
    public int salvartipoController(ModelTipo pModelTipo){
        return this.daotipo.salvarTipoDAO(pModelTipo);
    }

    /**
    * recupera tipo
    * @param pCodigo
    * return ModelTipo
     * @return 
    */
    public ModelTipo gettipoController(int pCodigo){
        return this.daotipo.getTipoDAO(pCodigo);
    }

    /**
    * recupera uma lista detipo
     * @return 
    */
    public ArrayList<ModelTipo> getListatipoController(){
        return this.daotipo.getListaTipoDAO();
    }

    /**
    * atualiza tipo
    * @param pModelTipo
    * return boolean
     * @return 
    */
    public boolean atualizartipoController(ModelTipo pModelTipo){
        return this.daotipo.atualizarTipoDAO(pModelTipo);
    }

    /**
    * exclui tipo
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirtipoController(int pCodigo){
        return this.daotipo.excluirTipoDAO(pCodigo);
    }
}