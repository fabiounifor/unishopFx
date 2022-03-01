package controller;

import DAO.DAOFornecedorCidadeEstado;
import java.util.ArrayList;
import model.ModelFornecedorCidadeEstado;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerFornecedorCidadeEstado {

    private DAOFornecedorCidadeEstado dAOFornecedorCidadeEstado = new DAOFornecedorCidadeEstado();

    /**
    * recupera uma lista de fornecedores estado cidade
    * @param
    * return ArrayList
    */
    public ArrayList<ModelFornecedorCidadeEstado> getlistaFornecedorCidadeEstados(){
        return this.dAOFornecedorCidadeEstado.getListaFornecedorCidadeEstadoDAO();
    }
}