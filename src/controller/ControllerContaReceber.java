package controller;

import DAO.DAOContaReceber;
import java.sql.Date;
import java.util.ArrayList;
import model.ModelContaReceber;
import relatorios.DAORelatorios;

/**
*
* @author contato@blsoft.com.br
*/
public class ControllerContaReceber {

    private DAOContaReceber daoContaReceber = new DAOContaReceber();
    private DAORelatorios daoRelatorios = new DAORelatorios();

    /**
    * grava ContaPagar
    * @param pModelContaCorrente
    * return int
    */
    public int salvarContaReceberController(ModelContaReceber pModelContaCorrente){
        return this.daoContaReceber.salvarContaReceberDAO(pModelContaCorrente);
    }
    /*
    * grava ContaReceber
    * @param pModelContaReceber
    * return int
    */
    public boolean salvarContasReceberController(ModelContaReceber pModelContaReceber){
        return this.daoContaReceber.salvarContasReceberDAO(pModelContaReceber);
    }

    /**
    * recupera ContaPagar
    * @param pCodigo
    * return ModelConta
    */
    public ModelContaReceber getContaReceberController(int pCodigo){
        return this.daoContaReceber.getContaPagarDAO(pCodigo);
    }

    /**
    * recupera uma lista deContaPagar
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaReceber> getListaContaPagarController(){
        return this.daoContaReceber.getListaContaPagarDAO();
    }
    
    /**
    * recupera uma lista deContaPagar
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaReceber> getListaContaPagarController(int pStatus){
        return this.daoContaReceber.getListaContaPagarDAO(pStatus);
    }
    
    /**
    * recupera uma lista deContaReceber
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaReceber> getListaContaReceberController(int pStatus){
        return this.daoContaReceber.getListaContaReceberDAO(pStatus);
    }

    /**
    * recupera uma lista de todas as Contas 
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelContaReceber> getListaContasController(int pStatus){
        return this.daoContaReceber.getListaContasDAO(pStatus);
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelContaReceber
    * return boolean
    */
    public boolean atualizarContaReceberController(ModelContaReceber pModelContaReceber){
        return this.daoContaReceber.atualizarContaReceberDAO(pModelContaReceber);
    }
    
    /**
    * exclui ContaPagar
    * @param pCodigo
    * return boolean
    */
    public boolean excluirContaReceberController(int pCodigo){
        return this.daoContaReceber.excluirContaReceberDAO(pCodigo);
    }

    /**
    * atualiza ContaReceber
    * @param pModelConta
    * return boolean
    */
    public boolean receberContaReceberController(ModelContaReceber pModelConta){
        return this.daoContaReceber.receberContaReceberDAO(pModelConta);
    }

    public boolean gerarRelatorioContaReceber(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaReceber(pCodigo);
    }

    public ArrayList<ModelContaReceber> getListaContasController(ModelContaReceber pModelConta) {
        return this.daoContaReceber.getListaContasDAO(pModelConta);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    /**
     * Gerar relatorio contas a pagar e a receber
     * @param modelConta
     * @return 
     */
    public boolean gerarRelatorioContasReceberCliente(int pCodigoCliente, int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasReceberCliente(pCodigoCliente, pStatus, pDataInicial, pDataFinal);
    }

    public boolean gerarRelatorioContasReceberTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasReceberTODAS(pStatus, pDataInicial, pDataFinal);
    }
    
}