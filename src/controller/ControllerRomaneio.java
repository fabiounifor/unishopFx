package controller;

import model.ModelRomaneio;
import DAO.DAORomaneio;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerRomaneio {

    private final DAORomaneio daoRomaneio = new DAORomaneio();

    /**
    * grava Romaneio
     * @param pModelRomaneio
     * @return 
    */
    public int salvarRomaneioController(ModelRomaneio pModelRomaneio){
        return this.daoRomaneio.salvarRomaneioDAO(pModelRomaneio);
    }

    /**
    * recupera Romaneio
    * @param pCodigo
    * return ModelRomaneio
     * @return 
    */
    public ModelRomaneio getRomaneioController(int pCodigo){
        return this.daoRomaneio.getRomaneioDAO(pCodigo);
    }
    
    /**
    * recupera FATOR
    * @param pDescricao
    * return ModelFATOR
     * @return 
    */
    public ModelRomaneio getRomaneioDescricaoController(String pDescricao){
        return this.daoRomaneio.getRomaneioNomeDAO(pDescricao);
    }

    /**
    * recupera uma lista deRomaneio
     * @return 
    */
    public ArrayList<ModelRomaneio> getListaRomaneioController(){
        return this.daoRomaneio.getListaRomaneioDAO();
    }

    /**
    * atualiza Romaneio
     * @param pModelRomaneio
     * @return 
    */
    public boolean atualizarRomaneioController(ModelRomaneio pModelRomaneio){
        return this.daoRomaneio.atualizarRomaneioDAO(pModelRomaneio);
    }

    /**
    * exclui Romaneio
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirRomaneioController(int pCodigo){
        return this.daoRomaneio.excluirRomaneioDAO(pCodigo);
    }
}