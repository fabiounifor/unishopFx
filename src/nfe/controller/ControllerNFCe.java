package nfe.controller;

import nfe.model.ModelNF;
import java.util.ArrayList;
import nf.DAO.DAONF;

/**
*
* @author Nazareth
*/
public class ControllerNFCe {

    private DAONF daoNF = new DAONF();

    /**
    * grava NF
    * @param pModelNF
    * return int
    */
    public int salvarNFController(ModelNF pModelNF){
        return this.daoNF.salvarNFDAO(pModelNF);
    }

    /**
    * recupera NF
    * @param pEmpresa
    * return ModelNF
    */
    public ModelNF getNFController(int pEmpresa){
        return this.daoNF.getNFDAO(pEmpresa);
    }

    /**
    * recupera uma lista deNF
    * @param pEmpresa
    * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFController(){
        return this.daoNF.getListaNFDAO();
    }

    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFController(ModelNF pModelNF){
        return this.daoNF.atualizarNFDAO(pModelNF);
    }

    /**
    * exclui NF
    * @param pEmpresa
    * return boolean
    */
    public boolean excluirNFController(int pEmpresa){
        return this.daoNF.excluirNFDAO(pEmpresa);
    }
}