package controller;

import model.ModelUnidadeMedia;
import DAO.DAOUnidadeMedia;
import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerUnidadeMedia {

    private DAOUnidadeMedia daoUnidadeMedia = new DAOUnidadeMedia();

    /**
    * grava UnidadeMedia
    * @param pModelUnidadeMedia
    * return int
    */
    public int salvarUnidadeMediaController(ModelUnidadeMedia pModelUnidadeMedia){
        return this.daoUnidadeMedia.salvarUnidadeMediaDAO(pModelUnidadeMedia);
    }

    /**
    * recupera UnidadeMedia
    * @param pCodigo
    * return ModelUnidadeMedia
    */
    public ModelUnidadeMedia getUnidadeMediaController(int pCodigo){
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pCodigo);
    }
    
    /**
    * recupera UnidadeMedia
    * @param pCodigo
    * return ModelUnidadeMedia
    */
    public ModelUnidadeMedia getUnidadeMediaController(String pNome){
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pNome);
    }

    /**
    * recupera uma lista deUnidadeMedia
     * @return 
    */
    public ArrayList<ModelUnidadeMedia> getListaUnidadeMediaController(){
        return this.daoUnidadeMedia.getListaUnidadeMediaDAO();
    }

    /**
    * atualiza UnidadeMedia
    * @param pModelUnidadeMedia
    * return boolean
    */
    public boolean atualizarUnidadeMediaController(ModelUnidadeMedia pModelUnidadeMedia){
        return this.daoUnidadeMedia.atualizarUnidadeMediaDAO(pModelUnidadeMedia);
    }

    /**
    * exclui UnidadeMedia
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUnidadeMediaController(int pCodigo){
        return this.daoUnidadeMedia.excluirUnidadeMediaDAO(pCodigo);
    }
}