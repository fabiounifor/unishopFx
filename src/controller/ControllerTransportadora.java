package controller;

import model.ModelTransportadora;
import DAO.DAOTransportadora;
import java.util.ArrayList;

/**
*
* @author Leandro
*/
public class ControllerTransportadora {

    private DAOTransportadora daoTransportadora = new DAOTransportadora();

    /**
    * grava Transportadora
    * @param pModelTransportadora
    * return int
    */
    public int salvarTransportadoraController(ModelTransportadora pModelTransportadora){
        return this.daoTransportadora.salvarTransportadoraDAO(pModelTransportadora);
    }

    /**
    * recupera Transportadora
    * @param pCodigo
    * return ModelTransportadora
    */
    public ModelTransportadora getTransportadoraController(int pCodigo){
        return this.daoTransportadora.getTransportadoraDAO(pCodigo);
    }

    /**
    * recupera uma lista deTransportadora
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelTransportadora> getListaTransportadoraController(){
        return this.daoTransportadora.getListaTransportadoraDAO();
    }

    /**
    * atualiza Transportadora
    * @param pModelTransportadora
    * return boolean
    */
    public boolean atualizarTransportadoraController(ModelTransportadora pModelTransportadora){
        return this.daoTransportadora.atualizarTransportadoraDAO(pModelTransportadora);
    }

    /**
    * exclui Transportadora
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTransportadoraController(int pCodigo){
        return this.daoTransportadora.excluirTransportadoraDAO(pCodigo);
    }
}