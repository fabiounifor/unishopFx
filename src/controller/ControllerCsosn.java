package controller;

import DAO.DAOCsosn;
import java.util.ArrayList;
import model.ModelCsosn;

/**
*
* @author Leandro Nazareth
*/
public class ControllerCsosn {

    private DAOCsosn daoCsosn = new DAOCsosn();

        
/**
    * grava Csosn
    * @param pModelCsosn
    * @return int
    */
    public int salvarCsosnController(ModelCsosn pModelCsosn){
        return this.daoCsosn.salvarCsosnDAO(pModelCsosn);
    }

    /**
    * recupera Csosn
    * @param pCodigo
    * @return ModelCsosn
    */
    public ModelCsosn getCsosnController(int pCodigo){
        return this.daoCsosn.getCsosnDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deCsosn
    * @return ArrayList
    */
    public ArrayList<ModelCsosn> getListaCsosnController(){
        return this.daoCsosn.getListaCsosnDAO();
    }

    /**
    * atualiza Csosn
    * @param pModelCsosn
    * @return boolean
    */
    public boolean atualizarCsosnController(ModelCsosn pModelCsosn){
        return this.daoCsosn.atualizarCsosnDAO(pModelCsosn);
    }

    /**
    * exclui Csosn
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirCsosnController(int pCodigo){
        return this.daoCsosn.excluirCsosnDAO(pCodigo);
    }
    
}