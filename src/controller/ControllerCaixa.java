package controller;

import model.ModelCaixa;
import DAO.DAOCaixa;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
*
* @author contato@blsoft.com.br
*/
public class ControllerCaixa {

    private DAOCaixa daoCaixa = new DAOCaixa();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
    * grava Caixa
    * @param pModelCaixa
    * return int
    */
    public int salvarCaixaController(ModelCaixa pModelCaixa){
        return this.daoCaixa.salvarCaixaDAO(pModelCaixa);
    }

    /**
    * recupera Caixa
    * @param pCodigo
    * return ModelCaixa
    */
    public ModelCaixa getCaixaController(int pCodigo){
        return this.daoCaixa.getCaixaDAO(pCodigo);
    }

    /**
    * recupera uma lista deCaixa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelCaixa> getListaCaixaController(){
        return this.daoCaixa.getListaCaixaDAO();
    }

    /**
    * atualiza Caixa
    * @param pModelCaixa
    * return boolean
    */
    public boolean atualizarCaixaController(ModelCaixa pModelCaixa){
        return this.daoCaixa.atualizarCaixaDAO(pModelCaixa);
    }
    /**
    * atualiza Sangria Caixa
    * @param pModelCaixa
    * return boolean
    */
    public boolean atualizarSangriaCaixaController(ModelCaixa pModelCaixa){
        return this.daoCaixa.atualizarSangriaCaixaPDVDAO(pModelCaixa);
    }

    /**
    * exclui Caixa
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCaixaController(int pCodigo){
        return this.daoCaixa.excluirCaixaDAO(pCodigo);
    }

    public ModelCaixa verificarRetorarCaixaControler(int numeroCaixa) {
        return this.daoCaixa.verificarRetorarCaixaDAO(numeroCaixa);
    }

    public boolean atualizarCaixaPDVController(ModelCaixa pModelCaixa) {
        return this.daoCaixa.atualizarCaixaPDVDAO(pModelCaixa);
    }

    public ModelCaixa retorarCaixaControler(int numeroCaixa) {
        return this.daoCaixa.retorarCaixaDAO(numeroCaixa);
    }
    public Boolean imprimirFechamentoCaixa(int codigoCaixa) {
        return this.dAORelatorios.gerarRelatorioCaixa(codigoCaixa);
    }
}