package controller;

import model.ModelItensPedidoMesa;
import DAO.DAOItensPedidoMesa;
import java.util.ArrayList;

/**
*
* @author BLSoft
*/
public class ControllerItensPedidoMesa {

    private DAOItensPedidoMesa daoItensPedidoMesa = new DAOItensPedidoMesa();

    /**
    * grava ItensPedidoMesa
    * @param pModelItensPedidoMesa
    * return int
    */
    public int salvarItensPedidoMesaController(ModelItensPedidoMesa pModelItensPedidoMesa){
        return this.daoItensPedidoMesa.salvarItensPedidoMesaDAO(pModelItensPedidoMesa);
    }
    
        /**
    * grava ItensPedidoMesa
    * @param pModelItensPedidoMesa
    * return int
    */
    public boolean salvarItensPedidoMesaController(ArrayList<ModelItensPedidoMesa> pListaModelItensPedidoMesas){
        return this.daoItensPedidoMesa.salvarItensPedidoMesaDAO(pListaModelItensPedidoMesas);
    }

    /**
    * recupera ItensPedidoMesa
    * @param pCodigo
    * return ModelItensPedidoMesa
    */
    public ModelItensPedidoMesa getItensPedidoMesaController(int pCodigo){
        return this.daoItensPedidoMesa.getItensPedidoMesaDAO(pCodigo);
    }
    
    /**
    * recupera ItensPedidoMesa
    * @param pMesa
    * return ModelItensPedidoMesa
    */
    public ModelItensPedidoMesa getItensPedidoMesaMesaController(int pMesa){
        return this.daoItensPedidoMesa.getItensPedidoMesaMesaDAO(pMesa);
    }

    /**
    * recupera uma lista deItensPedidoMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelItensPedidoMesa> getListaItensPedidoMesaController(){
        return this.daoItensPedidoMesa.getListaItensPedidoMesaDAO();
    }
    /**
    /**
    * recupera uma lista deItensPedidoMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelItensPedidoMesa> getListaItensPedidoMesaCozinhaController(){
        return this.daoItensPedidoMesa.getListaItensPedidoMesaCozinhaDAO();
    }
    /**
    * recupera uma lista deItensPedidoMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelItensPedidoMesa> getListaItensPedidoMesaController(int pCodigoMesa){
        return this.daoItensPedidoMesa.getListaItensPedidoMesaDAO(pCodigoMesa);
    }

    /**
    * atualiza ItensPedidoMesa
    * @param pModelItensPedidoMesa
    * return boolean
    */
    public boolean atualizarItensPedidoMesaController(ModelItensPedidoMesa pModelItensPedidoMesa){
        return this.daoItensPedidoMesa.atualizarItensPedidoMesaDAO(pModelItensPedidoMesa);
    }
    /**
    * atualiza status item
    * @param pModelItensPedidoMesa
    * return boolean
    */
    public boolean atualizarStatusItemController(ModelItensPedidoMesa pModelItensPedidoMesa){
        return this.daoItensPedidoMesa.atualizarStatusItemDAO(pModelItensPedidoMesa);
    }
    
    /**
    * atualiza status impresso item
    * @param pModelItensPedidoMesa
    * return boolean
    */
    public boolean atualizarStatusImpressoController(ModelItensPedidoMesa pModelItensPedidoMesa){
        return this.daoItensPedidoMesa.atualizarStatusImpressoItemDAO(pModelItensPedidoMesa);
    }

    /**
    * exclui ItensPedidoMesa
    * @param pCodigo
    * @param pMesa
    * return boolean
    */
    public boolean excluirItensPedidoMesaController(int pCodigo){
        return this.daoItensPedidoMesa.excluirItensPedidoMesaDAO(pCodigo);
    }
    
    public boolean excluirItemUnicoPedidoMesaController(int pCodigo, int pMesa){
        return this.daoItensPedidoMesa.excluirItemUnicoPedidoMesaDAO(pCodigo, pMesa);
    }

    public ArrayList<Integer> getListaMesasOcupadasController() {
        return this.daoItensPedidoMesa.getListaMesasOcupadasDAO();
    }
    public ArrayList<Integer> getListaMesasImpressasController() {
        return this.daoItensPedidoMesa.getListaMesasImpressasDAO();
    }
}