package controller;

import model.ModelEstado;
import DAO.DAOEstado;
import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerEstado {

    private DAOEstado daoEstado = new DAOEstado();

    /**
    * grava Estado
    * @param pModelEstado
    * return int
    */
    public int salvarEstadoController(ModelEstado pModelEstado){
        return this.daoEstado.salvarEstadoDAO(pModelEstado);
    }

    /**
    * recupera Estado
    * @param pCodigo
    * return ModelEstado
    */
    public ModelEstado getEstadoControllerCod(int pCodigo){
        return this.daoEstado.getEstadoDAOCod(pCodigo);
    }
    
    
    /**
    * recupera Estado
    * @param pNome
    * return ModelEstado
    */
    public ModelEstado getEstadoController(String pNome){
        return this.daoEstado.getEstadoDAO(pNome);
    }

    /**
    * recupera Estado
    * @param pNome
    * return ModelEstado
    */
    public ModelEstado getEstadoUFController(String pUF){
        return this.daoEstado.getEstadoUFDAO(pUF);
    }
    
    /**
    * recupera uma lista deEstado
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelEstado> getListaEstadoController(){
        return this.daoEstado.getListaEstadoDAO();
    }

    /**
    * atualiza Estado
    * @param pModelEstado
    * return boolean
    */
    public boolean atualizarEstadoController(ModelEstado pModelEstado){
        return this.daoEstado.atualizarEstadoDAO(pModelEstado);
    }

    /**
    * exclui Estado
    * @param pCodigo
    * return boolean
    */
    public boolean excluirEstadoController(int pCodigo){
        return this.daoEstado.excluirEstadoDAO(pCodigo);
    }
}