package controller;

import DAO.DAOCsosnFederal;
import java.util.ArrayList;
import model.ModelCsosnFederal;

/**
*
* @author Leandro Nazareth
*/
public class ControllerCsosnFederal {

    private DAOCsosnFederal daoCsosnFederal = new DAOCsosnFederal();

        
/**
    * grava CsosnFederal
    * @param pModelCsosnFederal
    * @return int
    */
    public int salvarCsosnFederalController(ModelCsosnFederal pModelCsosnFederal){
        return this.daoCsosnFederal.salvarCsosnFederalDAO(pModelCsosnFederal);
    }

    /**
    * recupera CsosnFederal
    * @param pCodigo
    * @return ModelCsosnFederal
    */
    public ModelCsosnFederal getCsosnFederalController(int pCodigo){
        return this.daoCsosnFederal.getCsosnFederalDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deCsosnFederal
    * @return ArrayList
    */
    public ArrayList<ModelCsosnFederal> getListaCsosnFederalController(){
        return this.daoCsosnFederal.getListaCsosnFederalDAO();    
                }

    /**
    * atualiza CsosnFederal
    * @param pModelCsosnFederal
    * @return boolean
    */
    public boolean atualizarCsosnFederalController(ModelCsosnFederal pModelCsosnFederal){
        return this.daoCsosnFederal.atualizarCsosnFederalDAO(pModelCsosnFederal);
    }

    /**
    * exclui CsosnFederal
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirCsosnFederalController(int pCodigo){
        return this.daoCsosnFederal.excluirCsosnFederalDAO(pCodigo);
    }
    
}