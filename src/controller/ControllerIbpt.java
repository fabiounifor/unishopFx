package controller;

import model.ModelIbpt;
import DAO.DAOIbpt;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerIbpt {

    private DAOIbpt daoIBPT = new DAOIbpt();

    /**
    * grava IBPT
    * @param pModelIBPT
    * return int
    */
    public int salvarIBPTController(ModelIbpt pModelIBPT){
        return this.daoIBPT.salvarIBPTDAO(pModelIBPT);
    }

    /**
    * recupera IBPT
    * @param pCodigo
    * return ModelIBPT
    */
    public ModelIbpt getIBPTController(int pCodigo){
        return this.daoIBPT.getIBPTDAO(pCodigo);
    }

    /**
    * recupera uma lista deIBPT
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelIbpt> getListaIBPTController(){
        return this.daoIBPT.getListaIBPTDAO();
    }

}