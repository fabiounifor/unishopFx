package controller;

import DAO.DAOBanco;
import java.util.ArrayList;
import model.ModelBanco;

/**
*
* @author Leandro Nazareth
*/
public class ControllerBanco {

    private DAOBanco daoBanco = new DAOBanco();

    public boolean criarBancoCtrl (){
        return this.daoBanco.criarBancoDAO();
    }
    
/**
    * grava Banco
    * @param pModelBanco
    * @return int
    */
    public int salvarBancoController(ModelBanco pModelBanco){
        return this.daoBanco.salvarBancoDAO(pModelBanco);
    }

    /**
    * recupera Banco
    * @param pCodigo
    * @return ModelBanco
    */
    public ModelBanco getBancoController(int pCodigo){
        return this.daoBanco.getBancoDAO(pCodigo);
    }
    
    /**
    * recupera Banco
    * @param pNome
    * @return ModelBanco
    */
    public ModelBanco getBancoController(String pNome){
        return this.daoBanco.getBancoDAO(pNome);
    }

    /**
    * recupera uma lista deBanco
    * @return ArrayList
    */
    public ArrayList<ModelBanco> getListaBancoController(){
        return this.daoBanco.getListaBancoDAO();
    }

    /**
    * atualiza Banco
    * @param pModelBanco
    * @return boolean
    */
    public boolean atualizarBancoController(ModelBanco pModelBanco){
        return this.daoBanco.atualizarBancoDAO(pModelBanco);
    }

    /**
    * exclui Banco
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirBancoController(int pCodigo){
        return this.daoBanco.excluirBancoDAO(pCodigo);
    }
    
}