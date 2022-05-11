package controller;

import DAO.DAONumeracao;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.ModelNumeracao;
import util.BLMascaras;

/**
*
* @author Leandro Nazareth
*/
public class ControllerNumeracao {

    private DAONumeracao daoNumeracao = new DAONumeracao();
    private BLMascaras bLMascaras = new BLMascaras();

        
/**
    * grava Numeracao
    * @param pModelNumeracao
    * @return int
    */
    public int salvarNumeracaoController(ModelNumeracao pModelNumeracao){
        return this.daoNumeracao.salvarNumeracaoDAO(pModelNumeracao);
    }

    /**
    * recupera Numeracao
    * @param pCodigo
    * @return ModelNumeracao
    */
    public ModelNumeracao getNumeracaoController(int pCodigo){
        return this.daoNumeracao.getNumeracaoDAO(pCodigo);
    }
   
    /**
    * recupera uma lista deNumeracao
    * @return ArrayList
    */
    public ArrayList<ModelNumeracao> getListaNumeracaoController(){
        return this.daoNumeracao.getListaNumeracaoDAO();
    }

    /**
    * atualiza Numeracao
    * @param pModelNumeracao
    * @return boolean
    */
    public boolean atualizarNumeracaoNfeController(int pNumeracao){
        return this.daoNumeracao.atualizarNumeracaoNfeDAO(pNumeracao);
    }
    /**
    * atualiza Numeracao
    * @param pCodigo
    * @param pNumero
    * @return boolean
    */
    public boolean atualizarNumeracaoNsuController(String pNumeracao, int pCodigo){
        return this.daoNumeracao.atualizarNumeracaoNsuDAO(pNumeracao, pCodigo);
    }
    /**
    * atualiza Numeracao
    * @param pCodigo
    * @param pNumero
    * @return boolean
    */
    public boolean atualizarConsultaController(int pNumeracao, String pDataHora) throws Exception{
        return this.daoNumeracao.atualizarConsultaDAO(pDataHora, pNumeracao);
    }
    /**
    * atualiza Numeracao
    * @param pModelNumeracao
    * @return boolean
    */
    public boolean atualizarNumeracaoNfceController(int pNumeracao){
        return this.daoNumeracao.atualizarNumeracaoNfceDAO(pNumeracao);
    }

    /**
    * exclui Numeracao
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirNumeracaoController(int pCodigo){
        return this.daoNumeracao.excluirNumeracaoDAO(pCodigo);
    }
    
}