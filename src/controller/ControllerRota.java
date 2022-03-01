package controller;

import model.ModelRota;
import DAO.DAORota;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerRota {

    private final DAORota daoRota = new DAORota();

    /**
    * grava ROTA
     * @param pModelRota
     * @return 
    */
    public int salvarRotaController(ModelRota pModelRota){
        return this.daoRota.salvarRotaDAO(pModelRota);
    }

    /**
    * recupera ROTA
    * @param pCodigo
    * return ModelROTA
     * @return 
    */
    public ModelRota getRotaController(int pCodigo){
        return this.daoRota.getRotaDAO(pCodigo);
    }
    
    /**
    * recupera ROTA
    * @param pDescricao
    * return ModelROTA
     * @return 
    */
    public ModelRota getRotaDescricaoController(String pDescricao){
        return this.daoRota.getRotaNomeDAO(pDescricao);
    }

    /**
    * recupera uma lista de ROTA
     * @return 
    */
    public ArrayList<ModelRota> getListaRotaController(){
        return this.daoRota.getListaRotaDAO();
    }

    /**
    * atualiza ROTA
     * @param pModelRota
     * @return 
    */
    public boolean atualizarRotaController(ModelRota pModelRota){
        return this.daoRota.atualizarRotaDAO(pModelRota);
    }

    /**
    * exclui ROTA
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirRotaController(int pCodigo){
        return this.daoRota.excluirRotaDAO(pCodigo);
    }
}