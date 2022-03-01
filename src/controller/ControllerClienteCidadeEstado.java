package controller;

import DAO.DAOClienteCidadeEstado;
import java.util.ArrayList;
import model.ModelClienteCidadeEstado;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerClienteCidadeEstado {

    private DAOClienteCidadeEstado dAOClienteCidadeEstado = new DAOClienteCidadeEstado();

    /**
    * recupera uma lista deCidadeEstado
    * @param pModelCidade
    * return ArrayList
    */
    public ArrayList<ModelClienteCidadeEstado> getListaClienteCidadeEstadoController(){
        return this.dAOClienteCidadeEstado.getListaClienteCidadeEstadoDAO();
    }

    public ModelClienteCidadeEstado getClienteCidadeEstadoController(String pNome) {
        return this.dAOClienteCidadeEstado.getClienteCidadeEstadoDAO(pNome);
    }
    
    public ModelClienteCidadeEstado getClienteCidadeEstadoController(int pCodigo) {
        return this.dAOClienteCidadeEstado.getClienteCidadeEstadoDAO(pCodigo);
    }

    public ModelClienteCidadeEstado getClienteCidadeEstadoPorTelefoneController(String pTelefone) {
        return this.dAOClienteCidadeEstado.getClienteCidadeEstadoPorTelefoneDAO(pTelefone);
    }
}