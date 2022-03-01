package controller;

import model.ModelCFOP;
import DAO.DAOCFOP;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerCFOP {

    private DAOCFOP daoCFOP = new DAOCFOP();

    /**
    * grava CFOP
    * @param pModelCFOP
    * return int
    */
    public int salvarCFOPController(ModelCFOP pModelCFOP){
        return this.daoCFOP.salvarCFOPDAO(pModelCFOP);
    }

    /**
    * recupera CFOP
    * @param pCodigo
    * return ModelCFOP
    */
    public ModelCFOP getCFOPController(int pCodigo){
        return this.daoCFOP.getCFOPDAO(pCodigo);
    }

    /**
    * recupera uma lista deCFOP
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelCFOP> getListaCFOPController(){
        return this.daoCFOP.getListaCFOPDAO();
    }

    /**
    * atualiza CFOP
    * @param pModelCFOP
    * return boolean
    */
    public boolean atualizarCFOPController(ModelCFOP pModelCFOP){
        return this.daoCFOP.atualizarCFOPDAO(pModelCFOP);
    }

    /**
    * exclui CFOP
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCFOPController(int pCodigo){
        return this.daoCFOP.excluirCFOPDAO(pCodigo);
    }
}