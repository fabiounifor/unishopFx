package controller;

import model.ModelTransportadoraCidEst;
import DAO.DAOTransportadoraCidEst;
import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class ControllerTransportadoraCidEst {

    private DAOTransportadoraCidEst daoTransportadoraCidEst = new DAOTransportadoraCidEst();

    /**
     * recupera uma lista deTransportadoraCidEst
     *
     * @param pModelCidade return ArrayList
     */
    public ArrayList<ModelTransportadoraCidEst> getListaTransportadoraCidadeEstadoController() {
        return this.daoTransportadoraCidEst.getListaTransportadoraCidadeEstadoDAO();
    }
}
