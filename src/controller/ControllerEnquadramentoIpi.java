package controller;

import DAO.DAOEnquadramentoIpi;
import java.util.ArrayList;
import model.ModelEnquadramentoIpi;

/**
*
* @author Leandro Nazareth
*/
public class ControllerEnquadramentoIpi {

    private DAOEnquadramentoIpi daoEnquadramentoIpi = new DAOEnquadramentoIpi();

        
/**
    * grava EnquadramentoIpi
    * @param pModelEnquadramentoIpi
    * @return int
    */
    public int salvarEnquadramentoIpiController(ModelEnquadramentoIpi pModelEnquadramentoIpi){
        return this.daoEnquadramentoIpi.salvarEnquadramentoIpiDAO(pModelEnquadramentoIpi);
    }

    /**
    * recupera EnquadramentoIpi
    * @param pCodigo
    * @return ModelEnquadramentoIpi
    */
    public ModelEnquadramentoIpi getEnquadramentoIpiController(int pCodigo){
        return this.daoEnquadramentoIpi.getEnquadramentoIpiDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deEnquadramentoIpi
    * @return ArrayList
    */
    public ArrayList<ModelEnquadramentoIpi> getListaEnquadramentoIpiController(){
        return this.daoEnquadramentoIpi.getListaEnquadramentoIpiDAO();
    }

    /**
    * atualiza EnquadramentoIpi
    * @param pModelEnquadramentoIpi
    * @return boolean
    */
    public boolean atualizarEnquadramentoIpiController(ModelEnquadramentoIpi pModelEnquadramentoIpi){
        return this.daoEnquadramentoIpi.atualizarEnquadramentoIpiDAO(pModelEnquadramentoIpi);
    }

    /**
    * exclui EnquadramentoIpi
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirEnquadramentoIpiController(int pCodigo){
        return this.daoEnquadramentoIpi.excluirEnquadramentoIpiDAO(pCodigo);
    }
    
}