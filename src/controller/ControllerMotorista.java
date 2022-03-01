package controller;

import model.ModelMotorista;
import DAO.DAOMotorista;
import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerMotorista {

    private DAOMotorista daoMotorista = new DAOMotorista();

    /**
    * grava Motorista
    * @param pModelMotorista
    * return int
    */
    public int salvarMotoristaController(ModelMotorista pModelMotorista){
        return this.daoMotorista.salvarMotoristaDAO(pModelMotorista);
    }

    /**
    * recupera Motorista
    * @param pCodigo
    * return ModelMotorista
    */
    public ModelMotorista getMotoristaController(int pCodigo){
        return this.daoMotorista.getMotoristaDAO(pCodigo);
    }
    
    /**
    * recupera Motorista
    * @param pCodigo
    * return ModelMotorista
    */
    public ModelMotorista getMotoristaController(String pNome){
        return this.daoMotorista.getMotoristaDAO(pNome);
    }

    /**
    * recupera uma lista deMotorista
     * @return 
    */
    public ArrayList<ModelMotorista> getListaMotoristaController(){
        return this.daoMotorista.getListaMotoristaDAO();
    }

    /**
    * atualiza Motorista
    * @param pModelMotorista
    * return boolean
    */
    public boolean atualizarMotoristaController(ModelMotorista pModelMotorista){
        return this.daoMotorista.atualizarMotoristaDAO(pModelMotorista);
    }

    /**
    * exclui Motorista
    * @param pCodigo
    * return boolean
    */
    public boolean excluirMotoristaController(int pCodigo){
        return this.daoMotorista.excluirMotoristaDAO(pCodigo);
    }
}