package controller;

import model.ModelIpi;
import DAO.DAOIPI;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerModeloIpi {

    private DAOIPI daoIPI = new DAOIPI();

    /**
    * grava IPI
    * @param pModelIPI
    * return int
    */
    public int salvarIPIController(ModelIpi pModelIPI){
        return this.daoIPI.salvarIPIDAO(pModelIPI);
    }

    /**
    * recupera IPI
    * @param pCodigo
    * return ModelIPI
    */
    public ModelIpi getIPIController(int pCodigo){
        return this.daoIPI.getIPIDAO(pCodigo);
    }

    /**
    * recupera uma lista deIPI
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelIpi> getListaIPIController(){
        return this.daoIPI.getListaIPIDAO();
    }

    /**
    * atualiza IPI
    * @param pModelIPI
    * return boolean
    */
    public boolean atualizarIPIController(ModelIpi pModelIPI){
        return this.daoIPI.atualizarIPIDAO(pModelIPI);
    }

    /**
    * exclui IPI
    * @param pCodigo
    * return boolean
    */
    public boolean excluirIPIController(int pCodigo){
        return this.daoIPI.excluirIPIDAO(pCodigo);
    }
}