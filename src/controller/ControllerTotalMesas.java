package controller;

import model.ModelTotalMesas;
import DAO.DAOTotalMesas;
import java.util.ArrayList;

/**
*
* @author BLSoft
*/
public class ControllerTotalMesas {

    private DAOTotalMesas daoTotalMesas = new DAOTotalMesas();

    /**
    * grava TotalMesas
    * @param pModelTotalMesas
    * return int
    */
    public int salvarTotalMesasController(ModelTotalMesas pModelTotalMesas){
        return this.daoTotalMesas.salvarTotalMesasDAO(pModelTotalMesas);
    }

    /**
    * recupera TotalMesas
    * @param pCodigo
    * return ModelTotalMesas
    */
    public ModelTotalMesas getTotalMesasController(int pCodigo){
        return this.daoTotalMesas.getTotalMesasDAO(pCodigo);
    }

    /**
    * recupera uma lista deTotalMesas
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelTotalMesas> getListaTotalMesasController(){
        return this.daoTotalMesas.getListaTotalMesasDAO();
    }

    /**
    * atualiza TotalMesas
    * @param pModelTotalMesas
    * return boolean
    */
    public boolean atualizarTotalMesasController(ModelTotalMesas pModelTotalMesas){
        return this.daoTotalMesas.atualizarTotalMesasDAO(pModelTotalMesas);
    }

    /**
    * exclui TotalMesas
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTotalMesasController(int pCodigo){
        return this.daoTotalMesas.excluirTotalMesasDAO(pCodigo);
    }
}