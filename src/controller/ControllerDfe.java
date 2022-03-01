package controller;

import DAO.DAOResumoDfe;
import java.util.ArrayList;
import model.ModelDfe;

/**
*
* @author Leandro Nazareth
*/
public class ControllerDfe {

    private DAOResumoDfe daoResumoDfe = new DAOResumoDfe();

    /**
    * grava CFOP
    * @param pModelDfe
    * return int
    */
    public int salvarDfeController(ModelDfe pModelDfe){
        return this.daoResumoDfe.salvarDfeDAO(pModelDfe);
    }

    /**
    * recupera Dfe
    * @param pCodigo
    * return ModelDfe
    */
    public ModelDfe getDfeController(int pCodigo){
        return this.daoResumoDfe.getDfeDAO(pCodigo);
    }
    
        /**
    * recupera Dfe
    * @param pCodigo
    * return ModelDfe
    */
    public ModelDfe getDfeChaveController(String pChave){
        return this.daoResumoDfe.getDfeChaveDAO(pChave);
    }

    /**
    * recupera uma lista deDfe
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelDfe> getListaDfeController(){
        return this.daoResumoDfe.getListaDfeDAO();
    }
    
        /**
    * atualiza DFe
    * @param pModelDfe
    * return boolean
    */
    public boolean atualizarDfeController(ModelDfe pModelDfe){
        return this.daoResumoDfe.atualizarDfeDAO(pModelDfe);
    }

    
    
 /**
    * exclui Dfe
    * @param pCodigo
    * return boolean
    */
    public boolean excluirDfeController(int pCodigo){
        return this.daoResumoDfe.excluirDfeDAO(pCodigo);
    }
}