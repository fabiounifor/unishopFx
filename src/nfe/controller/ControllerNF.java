package nfe.controller;

import java.sql.Date;
import nfe.model.ModelNF;
import java.util.ArrayList;
import nf.DAO.DAONF;

/**
*
* @author Nazareth
*/
public class ControllerNF {

    private DAONF daoNF = new DAONF();

    /**
    * grava NF
    * @param pModelNF
    * return int
    */
    public int salvarNFController(ModelNF pModelNF){
        return this.daoNF.salvarNFDAO(pModelNF);
    }
    
    /**
    * grava NF
    * @param pModelNF
    * return int
    */
    public int salvarNFCOMPRAController(ModelNF pModelNF){
        return this.daoNF.salvarNFCOMPRADAO(pModelNF);
    }

    /**
    * recupera NF
    * @param pEmpresa
    * return ModelNF
    */
    public ModelNF getNFController(int pEmpresa){
        return this.daoNF.getNFDAO(pEmpresa);
    }
    
    /**
    * recupera NF
    * @param pVenda
    * return ModelNF
    */
    public ModelNF getNFVendaController(int pVenda){
        return this.daoNF.getNFVendaDAO(pVenda);
    }
    
    /**
    * recupera NF
    * @param pVenda
    * return ModelNF
    */
    public ModelNF getNFCompraCodigoController(int pCompra){
        return this.daoNF.getNFCompraCodigoDAO(pCompra);
    }

    /**
    * recupera NF
    * @param pEmpresa
    * return ModelNF
    */
    public ModelNF getNFCOMPRAController(int pEmpresa){
        return this.daoNF.getNFCOMPRADAO(pEmpresa);
    }
    
    /**
    * recupera uma lista deNF
    * @param pEmpresa
    * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFController(){
        return this.daoNF.getListaNFDAO();
    }
    /**
    * recupera uma lista deNF
    * @param pModelo
    * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFModeloController(String pModelo){
        return this.daoNF.getListaNFModeloDAO(pModelo);
    }
    /**
    * recupera uma lista deNF
     * @param pDataInicial
     * @param dataFinal
     * @param modelo
     * @return 
    */
    public ArrayList<ModelNF> getListaDataNFController(Date pDataInicial, Date dataFinal, String modelo){
        return this.daoNF.getListaPorDataNFDAO(pDataInicial, dataFinal, modelo);
    }
    
    /**
    * recupera uma lista deNF
     * @param pDataInicial
     * @param dataFinal
     * @param modelo
     * @return 
    */
    public ArrayList<ModelNF> getListaDataNFCompraController(Date pDataInicial, Date dataFinal, String modelo){
        return this.daoNF.getListaPorDataNFCompraDAO(pDataInicial, dataFinal, modelo);
    }
    
    /**
    * recupera uma lista deNF
    * @param pEmpresa
    * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFCOMPRAController(){
        return this.daoNF.getListaNFCOMPRADAO();
    }

    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFController(ModelNF pModelNF){
        return this.daoNF.atualizarNFDAO(pModelNF);
    }
    
    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFCanceladaController(String cancelada, String codigoCancelada, int codigoCancelamento){
        return this.daoNF.atualizarNFCanceladaDAO(cancelada, codigoCancelada, codigoCancelamento);
    }
    
    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFCOMPRAController(ModelNF pModelNF){
        return this.daoNF.atualizarNFCOMPRADAO(pModelNF);
    }

    /**
    * exclui NF
    * @param pEmpresa
    * return boolean
    */
    public boolean excluirNFController(int pEmpresa){
        return this.daoNF.excluirNFDAO(pEmpresa);
    }
    
    /**
    * exclui NF
    * @param pEmpresa
    * return boolean
    */
    public boolean excluirNFCOMPRAController(int pEmpresa){
        return this.daoNF.excluirNFCOMPRADAO(pEmpresa);
    }
}