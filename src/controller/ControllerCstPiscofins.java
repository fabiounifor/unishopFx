package controller;

import DAO.DAOCstPiscofins;
import java.util.ArrayList;
import model.ModelCstPiscofins;

/**
*
* @author Leandro Nazareth
*/
public class ControllerCstPiscofins {

    private DAOCstPiscofins daoCstPiscofins = new DAOCstPiscofins();

        
/**
    * grava CstPiscofins
    * @param pModelCstPiscofins
    * @return int
    */
    public int salvarCstPiscofinsController(ModelCstPiscofins pModelCstPiscofins){
        return this.daoCstPiscofins.salvarCstPiscofinsDAO(pModelCstPiscofins);
    }

    /**
    * recupera CstPiscofins
    * @param pCodigo
    * @return ModelCstPiscofins
    */
    public ModelCstPiscofins getCstPiscofinsController(int pCodigo){
        return this.daoCstPiscofins.getCstPisconfinsDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deCstPiscofins
    * @return ArrayList
    */
    public ArrayList<ModelCstPiscofins> getListaCstPiscofinsController(){
        return this.daoCstPiscofins.getListaCstPiscofinsDAO();
    }

    /**
    * atualiza CstPiscofins
    * @param pModelCstPiscofins
    * @return boolean
    */
    public boolean atualizarCstPiscofinsController(ModelCstPiscofins pModelCstPiscofins){
        return this.daoCstPiscofins.atualizarCstPiscofinsDAO(pModelCstPiscofins);
    }

    /**
    * exclui CstPiscofins
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirCstPiscofinsController(int pCodigo){
        return this.daoCstPiscofins.excluirCstPiscofinsDAO(pCodigo);
    }
    
}