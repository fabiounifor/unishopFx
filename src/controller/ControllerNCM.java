package controller;

import model.ModelNCM;
import DAO.DAONCM;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerNCM {

    private DAONCM daoNCM = new DAONCM();

    /**
    * grava NCM
    * @param pModelNCM
    * return int
    */
    public int salvarNCMController(ModelNCM pModelNCM){
        return this.daoNCM.salvarNCMDAO(pModelNCM);
    }

    /**
    * recupera NCM
    * @param pCodigo
    * return ModelNCM
    */
    public ModelNCM getNCMController(int pCodigo){
        return this.daoNCM.getNCMDAO(pCodigo);
    }

    /**
    * recupera uma lista deNCM
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelNCM> getListaNCMController(){
        return this.daoNCM.getListaNCMDAO();
    }

    /**
    * atualiza NCM
    * @param pModelNCM
    * return boolean
    */
    public boolean atualizarNCMController(ModelNCM pModelNCM){
        return this.daoNCM.atualizarNCMDAO(pModelNCM);
    }

    /**
    * exclui NCM
    * @param pCodigo
    * return boolean
    */
    public boolean excluirNCMController(int pCodigo){
        return this.daoNCM.excluirNCMDAO(pCodigo);
    }
}