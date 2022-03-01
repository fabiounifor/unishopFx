package controller;

import DAO.DAOContaPagar;
import java.sql.Date;
import java.util.ArrayList;
import model.ModelContaPagar;
import relatorios.DAORelatorios;

/**
*
* @author contato@blsoft.com.br
*/
public class ControllerContaPagar {

    private DAOContaPagar daoContaPagar = new DAOContaPagar();
    private DAORelatorios daoRelatorios = new DAORelatorios();

    /**
    * grava ContaPagar
    * @param pModelContaPagar
    * return int
    */
    public int salvarContaPagarController(ModelContaPagar pModelContaPagar){
        return this.daoContaPagar.salvarContaPagarDAO(pModelContaPagar);
    }
/**
    * grava ContaPagar
    * @param pModelContaPagar
    * return int
    */
    public boolean salvarContasPagarController(ModelContaPagar pModelContaPagar){
        return this.daoContaPagar.salvarContasPagarDAO(pModelContaPagar);
    }

    /**
    * recupera ContaPagar
    * @param pCodigo
    * return ModelConta
    */
    public ModelContaPagar getContaPagarController(int pCodigo){
        return this.daoContaPagar.getContaPagarDAO(pCodigo);
    }

    /**
    * recupera uma lista deContaPagar
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaPagar> getListaContaPagarController(){
        return this.daoContaPagar.getListaContaPagarDAO();
    }
    
    /**
    * recupera uma lista deContaPagar
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaPagar> getListaContaPagarController(int pStatus){
        return this.daoContaPagar.getListaContaPagarDAO(pStatus);
    }
    
    /**
    * recupera uma lista de todas as Contas 
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaPagar> getListaContasController(int pStatus){
        return this.daoContaPagar.getListaContasDAO(pStatus);
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelContaPagar
    * return boolean
    */
    public boolean atualizarContaPagarController(ModelContaPagar pModelContaPagar){
        return this.daoContaPagar.atualizarContaPagarDAO(pModelContaPagar);
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelConta
    * return boolean
    */
    public boolean pagarContaPagarController(ModelContaPagar pModelConta){
        return this.daoContaPagar.pagarContaPagarDAO(pModelConta);
    }
    
    /**
    * exclui ContaPagar
    * @param pCodigo
    * return boolean
    */
    public boolean excluirContaPagarController(int pCodigo){
        return this.daoContaPagar.excluirContaPagarDAO(pCodigo);
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaPagar(pCodigo);
    }

    public ArrayList<ModelContaPagar> getListaContasController(ModelContaPagar pModelContaPagar) {
        return this.daoContaPagar.getListaContasDAO(pModelContaPagar);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    public boolean gerarRelatorioContasPagarFornecedor(int pCodigoFornecedor, int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarFornecedor(pCodigoFornecedor, pStatus, pDataInicial, pDataFinal);
    }

    public boolean gerarRelatorioContasPagarTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarTODAS(pStatus, pDataInicial, pDataFinal);
    }
    
}