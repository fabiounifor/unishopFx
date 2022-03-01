package controller;

import model.ModelEmpresaCidadeEstado;
import DAO.DAOEmpresaCidadeEstado;
import java.util.ArrayList;
import model.ModelCidade;

/**
*
* @author BLSoft Desenvolvimento de Sistema
*/
public class ControllerEmpresaCidadeEstado {

    private DAOEmpresaCidadeEstado daoEmpresaCidadeEstado = new DAOEmpresaCidadeEstado();

    /**
    * recupera EmpresaCidadeEstado
    * @param pModelCidade
    * return ModelEmpresaCidadeEstado
    */
    public ModelEmpresaCidadeEstado getEmpresaCidadeEstadoController(int pCodigo){
        return this.daoEmpresaCidadeEstado.getEmpresaCidadeEstadoDAO(pCodigo);
    }

    /**
    * recupera uma lista deEmpresaCidadeEstado
    * @param pModelCidade
    * return ArrayList
    */
    public ArrayList<ModelEmpresaCidadeEstado> getListaEmpresaCidadeEstadoController(){
        return this.daoEmpresaCidadeEstado.getListaEmpresaCidadeEstadoDAO();
    }
}