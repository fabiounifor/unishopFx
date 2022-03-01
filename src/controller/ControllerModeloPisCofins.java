package controller;

import model.ModelPisCofins;
import DAO.DAOPisCofins;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerModeloPisCofins {

    private DAOPisCofins daoPisCofins = new DAOPisCofins();

    /**
    * grava Piscofins
    * @param pModelPiscofins
    * return int
    */
    public int salvarPiscofinsController(ModelPisCofins pModelPiscofins){
        return this.daoPisCofins.salvarPisCofinsDAO(pModelPiscofins);
    }

    /**
    * recupera Piscofins
    * @param pCodigo
    * return ModelPiscofins
    */
    public ModelPisCofins getPiscofinsController(int pCodigo){
        return this.daoPisCofins.getPisCofinsDAO(pCodigo);
    }

    /**
    * recupera uma lista dePiscofins
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelPisCofins> getListaPiscofinsController(){
        return this.daoPisCofins.getListaPisCofinsDAO();
    }

    /**
    * atualiza Piscofins
    * @param pModelPiscofins
    * return boolean
    */
    public boolean atualizarPiscofinsController(ModelPisCofins pModelPiscofins){
        return this.daoPisCofins.atualizarPisCofinsDAO(pModelPiscofins);
    }

    /**
    * exclui Piscofins
    * @param pCodigo
    * return boolean
    */
    public boolean excluirPiscofinsController(int pCodigo){
        return this.daoPisCofins.excluirPisCofinsDAO(pCodigo);
    }
}