package controller;

import DAO.DAOConfiguracao;
import java.util.ArrayList;
import model.ModelConfiguracao;

/**
*
* @author Leandro Nazareth
*/
public class ControllerConfiguracao {

    private DAOConfiguracao daoConfiguracao = new DAOConfiguracao();

        
/**
    * grava Configuracao
    * @param pModelConfiguracao
    * @return int
    */
    public int salvarConfiguracaoController(ModelConfiguracao pModelConfiguracao){
        return this.daoConfiguracao.salvarConfiguracaoDAO(pModelConfiguracao);
    }

    /**
    * recupera Configuracao
    * @param pCodigo
    * @return ModelConfiguracao
    */
    public ModelConfiguracao getConfiguracaoController(int pCodigo){
        return this.daoConfiguracao.getConfiguracaoDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deConfiguracao
    * @return ArrayList
    */
    public ArrayList<ModelConfiguracao> getListaConfiguracaoController(){
        return this.daoConfiguracao.getListaConfiguracaoDAO();
    }

    /**
    * atualiza Configuracao
    * @param pModelConfiguracao
    * @return boolean
    */
    public boolean atualizarConfiguracaoController(ModelConfiguracao pModelConfiguracao){
        return this.daoConfiguracao.atualizarConfiguracaoDAO(pModelConfiguracao);
    }
    /**
    * atualiza Configuracao
    * @param pModelConfiguracao
    * @return boolean
    */
    public boolean atualizarConfiguracaoVisualizarNfceController(int pCodigo, int pConfiguracao){
        return this.daoConfiguracao.atualizarConfiguracaoVisualizarNfceDAO(pCodigo, pConfiguracao);
    }

    /**
    * exclui Configuracao
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirConfiguracaoController(int pCodigo){
        return this.daoConfiguracao.excluirConfiguracaoDAO(pCodigo);
    }
    
}