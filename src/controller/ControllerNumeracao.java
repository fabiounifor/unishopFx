package controller;

import DAO.DAONumeracao;
import java.util.ArrayList;
import model.ModelNumeracao;

/**
*
* @author Leandro Nazareth
*/
public class ControllerNumeracao {

    private DAONumeracao daoNumeracao = new DAONumeracao();

        
/**
    * grava Numeracao
    * @param pModelNumeracao
    * @return int
    */
    public int salvarNumeracaoController(ModelNumeracao pModelNumeracao){
        return this.daoNumeracao.salvarNumeracaoDAO(pModelNumeracao);
    }

    /**
    * recupera Numeracao
    * @param pCodigo
    * @return ModelNumeracao
    */
    public ModelNumeracao getNumeracaoController(int pCodigo){
        return this.daoNumeracao.getNumeracaoDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deNumeracao
    * @return ArrayList
    */
    public ArrayList<ModelNumeracao> getListaNumeracaoController(){
        return this.daoNumeracao.getListaNumeracaoDAO();
    }

    /**
    * atualiza Numeracao
    * @param pModelNumeracao
    * @return boolean
    */
    public boolean atualizarNumeracaoNfeController(int pNumeracao){
        return this.daoNumeracao.atualizarNumeracaoNfeDAO(pNumeracao);
    }
    /**
    * atualiza Numeracao
    * @param pCodigo
    * @param pNumero
    * @return boolean
    */
    public boolean atualizarNumeracaoNsuController(String pNumeracao, int pCodigo){
        return this.daoNumeracao.atualizarNumeracaoNsuDAO(pNumeracao, pCodigo);
    }
    /**
    * atualiza Numeracao
    * @param pModelNumeracao
    * @return boolean
    */
    public boolean atualizarNumeracaoNfceController(int pNumeracao){
        return this.daoNumeracao.atualizarNumeracaoNfceDAO(pNumeracao);
    }

    /**
    * exclui Numeracao
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirNumeracaoController(int pCodigo){
        return this.daoNumeracao.excluirNumeracaoDAO(pCodigo);
    }
    
}