package controller;

import model.ModelBairro;
import DAO.DAOBairro;
import java.util.ArrayList;

/**
*
* @author Leandro Nazareth
*/
public class ControllerBairro {

    private final DAOBairro daoBairro = new DAOBairro();

    /**
    * grava GRUPO
     * @param pModelBairro
     * @return 
    */
    public int salvarBairroController(ModelBairro pModelBairro){
        return this.daoBairro.salvarBairroDAO(pModelBairro);
    }

    /**
    * recupera GRUPO
    * @param pCodigo
    * return ModelGRUPO
     * @return 
    */
    public ModelBairro getBairroController(int pCodigo){
        return this.daoBairro.getBairroDAO(pCodigo);
    }
    
    /**
    * recupera FATOR
    * @param pDescricao
    * return ModelFATOR
     * @return 
    */
    public ModelBairro getBairroDescricaoController(String pDescricao){
        return this.daoBairro.getBairroNomeDAO(pDescricao);
    }

    /**
    * recupera uma lista deGRUPO
     * @return 
    */
    public ArrayList<ModelBairro> getListaBairroController(){
        return this.daoBairro.getListaBairroDAO();
    }

    /**
    * atualiza GRUPO
     * @param pModelBairro
     * @return 
    */
    public boolean atualizarBairroController(ModelBairro pModelBairro){
        return this.daoBairro.atualizarBairroDAO(pModelBairro);
    }

    /**
    * exclui GRUPO
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirBairroController(int pCodigo){
        return this.daoBairro.excluirBairroDAO(pCodigo);
    }
}