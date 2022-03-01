package controller;

import model.ModelGarcom;
import DAO.DAOGarcom;
import java.util.ArrayList;

/**
*
* @author BLSoft
*/
public class ControllerGarcom {

    private DAOGarcom daoGarcom = new DAOGarcom();

    /**
    * grava Garcom
    * @param pModelGarcom
    * return int
    */
    public int salvarGarcomController(ModelGarcom pModelGarcom){
        return this.daoGarcom.salvarGarcomDAO(pModelGarcom);
    }

    /**
    * recupera Garcom
    * @param pCodigo
    * return ModelGarcom
    */
    public ModelGarcom getGarcomController(int pCodigo){
        return this.daoGarcom.getGarcomDAO(pCodigo);
    }
    
    /**
    * recupera Garcom
    * @param pCodigo
    * return ModelGarcom
    */
    public ModelGarcom getGarcomController(String pNome){
        return this.daoGarcom.getGarcomDAO(pNome);
    }

    /**
    * recupera uma lista deGarcom
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelGarcom> getListaGarcomController(){
        return this.daoGarcom.getListaGarcomDAO();
    }

    /**
    * atualiza Garcom
    * @param pModelGarcom
    * return boolean
    */
    public boolean atualizarGarcomController(ModelGarcom pModelGarcom){
        return this.daoGarcom.atualizarGarcomDAO(pModelGarcom);
    }

    /**
    * exclui Garcom
    * @param pCodigo
    * return boolean
    */
    public boolean excluirGarcomController(int pCodigo){
        return this.daoGarcom.excluirGarcomDAO(pCodigo);
    }
}