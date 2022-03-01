package controller;

import model.ModelCidadeEstado;
import DAO.DAOCidadeEstado;
import java.util.ArrayList;
import model.ModelCidade;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerCidadeEstado {

    private DAOCidadeEstado daoCidadeEstado = new DAOCidadeEstado();

    /**
    * recupera uma lista deCidadeEstado
    * @param pModelCidade
    * return ArrayList
    */
    public ArrayList<ModelCidadeEstado> getListaCidadeEstadoController(){
        return this.daoCidadeEstado.getListaCidadeEstadoDAO();
    }
}