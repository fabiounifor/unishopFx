package nfe.controller;

import nfe.model.ModelAssinaturaDigital;
import java.util.ArrayList;
import nfe.DAO.DAOAssinaturaDigital;

/**
*
* @author Leandro
*/
public class ControllerAssinaturaDigital {

    private DAOAssinaturaDigital daoAssinaturaDigital = new DAOAssinaturaDigital();

    /**
    * grava AssinaturaDigital
    * @param pModelAssinaturaDigital
    * return int
    */
    public int salvarAssinaturaDigitalController(ModelAssinaturaDigital pModelAssinaturaDigital){
        return this.daoAssinaturaDigital.salvarAssinaturaDigitalDAO(pModelAssinaturaDigital);
    }

    /**
    * recupera AssinaturaDigital
    * @param pCodigo
    * return ModelAssinaturaDigital
    */
    public ModelAssinaturaDigital getAssinaturaDigitalController(int pCodigo){
        return this.daoAssinaturaDigital.getAssinaturaDigitalDAO(pCodigo);
    }

    /**
    * recupera uma lista deAssinaturaDigital
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelAssinaturaDigital> getListaAssinaturaDigitalController(){
        return this.daoAssinaturaDigital.getListaAssinaturaDigitalDAO();
    }

    /**
    * atualiza AssinaturaDigital
    * @param pModelAssinaturaDigital
    * return boolean
    */
    public boolean atualizarAssinaturaDigitalController(ModelAssinaturaDigital pModelAssinaturaDigital){
        return this.daoAssinaturaDigital.atualizarAssinaturaDigitalDAO(pModelAssinaturaDigital);
    }

    /**
    * exclui AssinaturaDigital
    * @param pCodigo
    * return boolean
    */
    public boolean excluirAssinaturaDigitalController(int pCodigo){
        return this.daoAssinaturaDigital.excluirAssinaturaDigitalDAO(pCodigo);
    }
}