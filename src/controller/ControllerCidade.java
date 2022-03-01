package controller;

import model.ModelCidade;
import DAO.DAOCidade;
import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerCidade {

    private DAOCidade daoCidade = new DAOCidade();

    /**
    * grava Cidade
    * @param pModelCidade
    * return int
    */
    public int salvarCidadeController(ModelCidade pModelCidade){
        return this.daoCidade.salvarCidadeDAO(pModelCidade);
    }

    /**
    * recupera Cidade
    * @param pCodigo
    * return ModelCidade
    */
    public ModelCidade getCidadeController(int pCodigo){
        return this.daoCidade.getCidadeDAO(pCodigo);
    }
    
    /**
    * recupera Cidade
    * @param pNome
    * return ModelCidade
    */
    public ModelCidade getCidadeController(String pNome){
        return this.daoCidade.getCidadeDAO(pNome);
    }

    /**
    * recupera uma lista deCidade
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelCidade> getListaCidadeController(){
        return this.daoCidade.getListaCidadeDAO();
    }
    /**
    * recupera uma lista deCidade
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelCidade> getListaCidadePorEstadoController(int pCodigoEstado){
        return this.daoCidade.getListaCidadePorEstadoDAO(pCodigoEstado);
    }

    /**
    * atualiza Cidade
    * @param pModelCidade
    * return boolean
    */
    public boolean atualizarCidadeController(ModelCidade pModelCidade){
        return this.daoCidade.atualizarCidadeDAO(pModelCidade);
    }

    /**
    * exclui Cidade
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCidadeController(int pCodigo){
        return this.daoCidade.excluirCidadeDAO(pCodigo);
    }
}