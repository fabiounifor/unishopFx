package controller;

import DAO.DAOCst;
import java.util.ArrayList;
import model.ModelCst;

/**
*
* @author Leandro Nazareth
*/
public class ControllerCst {

    private DAOCst daoCst = new DAOCst();

        
/**
    * grava Cst
    * @param pModelCst
    * @return int
    */
    public int salvarCstController(ModelCst pModelCst){
        return this.daoCst.salvarCstDAO(pModelCst);
    }

    /**
    * recupera Cst
    * @param pCodigo
    * @return ModelCst
    */
    public ModelCst getCstController(int pCodigo){
        return this.daoCst.getCstDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deCst
    * @return ArrayList
    */
    public ArrayList<ModelCst> getListaCstController(){
        return this.daoCst.getListaCstDAO();
    }

    /**
    * atualiza Cst
    * @param pModelCst
    * @return boolean
    */
    public boolean atualizarCstController(ModelCst pModelCst){
        return this.daoCst.atualizarCstDAO(pModelCst);
    }

    /**
    * exclui Cst
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirCstController(int pCodigo){
        return this.daoCst.excluirCstDAO(pCodigo);
    }
    
}