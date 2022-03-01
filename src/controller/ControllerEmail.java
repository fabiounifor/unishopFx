/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOEmail;
import java.util.ArrayList;
import model.ModelEmail;

/**
 *
 * @author FABIO
 */
    
/**
    * grava Email
    * @param pModelEmail
    * @return int
    */
public class ControllerEmail {

    private DAOEmail daoEmail = new DAOEmail();

    public int salvarEmailController(ModelEmail pModelEmail){
        return this.daoEmail.salvarEmailDAO(pModelEmail);
    }

    /**
    * recupera Email
    * @param pCodigo
    * @return ModelEmail
    */
    public ModelEmail getEmailCodController(int pCodigo){
        return this.daoEmail.getEmailCodDAO(pCodigo);
    }
    
    /**
    * recupera Email
    * @param pNome
    * @return ModelEmail
    */
    public ModelEmail getEmailCnpjController(String pCnpj){
        return this.daoEmail.getEmailCnpjDAO(pCnpj);
    }

    /**
    * recupera uma lista deEmail
    * @return ArrayList
    */
    public ArrayList<ModelEmail> getListaEmailController(){
        return this.daoEmail.getListaEmailDAO();
    }

    /**
    * atualiza Email
    * @param pModelEmail
    * @return boolean
    */
    public boolean atualizarEmailController(ModelEmail pModelEmail){
        return this.daoEmail.atualizarEmailDAO(pModelEmail);
    }

    /**
    * exclui Email
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirEmailController(int pCodigo){
        return this.daoEmail.excluirEmailDAO(pCodigo);
    }
    
}

