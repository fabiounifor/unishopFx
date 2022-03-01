package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelEmail;
import model.ModelSessaoUsuario;

/**
 *
 * @author Leandro
 */
public class DAOEmail extends ConexaoMySql {

    public boolean criarBancoDAO() {
        try {
            this.conectarSemBanco();
            
            this.executarUpdateDeleteSQL("CREATE DATABASE " + ModelSessaoUsuario.nomeDoBanco);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
        return true;
    }
    
/**
    * grava Banco
    * @param pModelEmail
    * return int
    */
    public int salvarEmailDAO(ModelEmail pModelEmail){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO email ("
                //    + "codigo,"
                    + "email,"
                    + "senha,"
                    + "smtp,"
                    + "porta,"
                    + "cnpj"
                + ") VALUES ("
              //      + "'" + pModelEmail.getCodigo()+ "',"
                    + "'" + pModelEmail.getUsuario() + "',"
                    + "'" + pModelEmail.getSenha() + "',"
                    + "'" + pModelEmail.getHost() + "',"
                    + "'" + pModelEmail.getPorta() + "',"
                    + "'" + pModelEmail.getCnpj() + "'"        
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Email
    * @param pCodigo
    * @return ModelEmail
    */
    public ModelEmail getEmailCodDAO(int pCodigo){
        ModelEmail modelEmail = new ModelEmail();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"    
                    + "email,"
                    + "senha,"
                    + "smtp,"
                    + "porta,"
                    + "cnpj"
                    + " FROM"
                    + " email" 
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEmail.setCodigo(this.getResultSet().getInt(1));
                modelEmail.setUsuario(this.getResultSet().getString(1));
                modelEmail.setSenha(this.getResultSet().getString(2));
                modelEmail.setHost(this.getResultSet().getString(3));
                modelEmail.setPorta(this.getResultSet().getInt(4));
                modelEmail.setCnpj(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEmail;
    }
    /**
    * recupera Banco
     * @param pCnpj
    * @return ModelEmail
    */
    public ModelEmail getEmailCnpjDAO(String pCnpj){
        ModelEmail modelEmail = new ModelEmail();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"    
                    + "email,"
                    + "senha,"
                    + "smtp,"
                    + "porta,"
                    + "cnpj"
                    + " FROM"
                    + " email" 
                 + " WHERE"
                     + " cnpj = '" + pCnpj + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEmail.setCodigo(this.getResultSet().getInt(1));
                modelEmail.setUsuario(this.getResultSet().getString(2));
                modelEmail.setSenha(this.getResultSet().getString(3));
                modelEmail.setHost(this.getResultSet().getString(4));
                modelEmail.setPorta(this.getResultSet().getInt(5));
                modelEmail.setCnpj(this.getResultSet().getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEmail;
    }

    /**
    * recupera uma lista de Banco
        * return ArrayList
    */
    public ArrayList<ModelEmail> getListaEmailDAO(){
        ArrayList<ModelEmail> listamodelEmail = new ArrayList();
        ModelEmail modelEmail = new ModelEmail();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"    
                    + "email,"
                    + "senha,"
                    + "smtp,"
                    + "porta,"
                    + "cnpj"
                    + " FROM"
                    + " email" 
                    + ";"
            );

            while(this.getResultSet().next()){
                modelEmail = new ModelEmail();
                modelEmail.setCodigo(this.getResultSet().getInt(1));
                modelEmail.setUsuario(this.getResultSet().getString(2));
                modelEmail.setSenha(this.getResultSet().getString(3));
                modelEmail.setHost(this.getResultSet().getString(4));
                modelEmail.setPorta(this.getResultSet().getInt(5));
                modelEmail.setCnpj(this.getResultSet().getString(6));
                listamodelEmail.add(modelEmail);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEmail;
    }

    /**
    * atualiza Email
    * @param pModelEmail
    * return boolean
    */
    public boolean atualizarEmailDAO(ModelEmail pModelEmail){
        try {
            this.conectar();
            String sql = 
                "UPDATE email SET "
                    + "codigo = '" + pModelEmail.getCodigo() + "',"
                    + "email = '" + pModelEmail.getUsuario() + "',"
                    + "senha = '" + pModelEmail.getSenha()+ "',"
                    + "smtp = '" + pModelEmail.getHost() + "',"
                    + "porta = '" + pModelEmail.getPorta() + "',"
                    + "cnpj = '" + pModelEmail.getCnpj() + "'"
                + " WHERE "
                    + "codigo = '" + pModelEmail.getCodigo() + "'"
                + ";";
            return this.executarUpdateDeleteSQL(sql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Email
    * @param pCodigo
    * return boolean
    */
    public boolean excluirEmailDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Email "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

}
