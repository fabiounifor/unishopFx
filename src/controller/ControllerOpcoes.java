package controller;

import DAO.DAOOpcionais;
import model.ModelOpcionais;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerOpcoes {

    private final DAOOpcionais dAOOpcionais = new DAOOpcionais();

    /**
    * grava GRUPO
     * @param pModelOpcionais
     * @return 
    */
    public int salvarOpcoesController(ModelOpcionais pModelOpcionais){
        return this.dAOOpcionais.salvarOpcoesDAO(pModelOpcionais);
    }

    /**
    * recupera GRUPO
    * @param pCodigo
    * return ModelGRUPO
     * @return 
    */
    public ModelOpcionais getOpcoesController(int pCodigo){
        return this.dAOOpcionais.getOpcoesDAO(pCodigo);
    }
    
    
    /**
    * recupera uma lista deGRUPO
     * @return 
    */
    public ArrayList<ModelOpcionais> getListaOpcoesController(){
        return this.dAOOpcionais.getListaOpcoesDAO();
    }
    /**
    * recupera uma lista deGRUPO
     * @return 
    */
    public ArrayList<ModelOpcionais> getListaOpcoesTipoController(int pTipo){
        return this.dAOOpcionais.getListaOpcoesTipoDAO(pTipo);
    }

    /**
    * atualiza GRUPO
     * @param pModelOpcionais
     * @return 
    */
    public boolean atualizarOpcoesController(ModelOpcionais pModelOpcionais){
        return this.dAOOpcionais.atualizarOpcoesDAO(pModelOpcionais);
    }

    /**
    * exclui GRUPO
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirOpcoesController(int pCodigo){
        return this.dAOOpcionais.excluirOpcoesDAO(pCodigo);
    }
}