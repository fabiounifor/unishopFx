package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelBanco;
import model.ModelSessaoUsuario;

/**
 *
 * @author Leandro
 */
public class DAOBanco extends ConexaoMySql {

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
    * @param pModelBanco
    * return int
    */
    public int salvarBancoDAO(ModelBanco pModelBanco){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO banco ("
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                + ") VALUES ("
                    + "'" + pModelBanco.getBanco() + "',"
                    + "'" + pModelBanco.getDescricao() + "',"
                    + "'" + pModelBanco.getNomeReduzido() + "',"
                    + "'" + pModelBanco.getEmiteBoleto() + "'"
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
    * recupera Banco
    * @param pCodigo
    * @return ModelBanco
    */
    public ModelBanco getBancoDAO(int pCodigo){
        ModelBanco modelBanco = new ModelBanco();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                 + " FROM"
                     + " banco"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBanco.setCodigo(this.getResultSet().getInt(1));
                modelBanco.setBanco(this.getResultSet().getString(2));
                modelBanco.setDescricao(this.getResultSet().getString(3));
                modelBanco.setNomeReduzido(this.getResultSet().getString(4));
                modelBanco.setEmiteBoleto(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBanco;
    }
    /**
    * recupera Banco
    * @param pNome
    * @return ModelBanco
    */
    public ModelBanco getBancoDAO(String pNome){
        ModelBanco modelBanco = new ModelBanco();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                 + " FROM"
                     + " banco"
                 + " WHERE"
                     + " nome_reduzido = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBanco.setCodigo(this.getResultSet().getInt(1));
                modelBanco.setBanco(this.getResultSet().getString(2));
                modelBanco.setDescricao(this.getResultSet().getString(3));
                modelBanco.setNomeReduzido(this.getResultSet().getString(4));
                modelBanco.setEmiteBoleto(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBanco;
    }

    /**
    * recupera uma lista de Banco
        * return ArrayList
    */
    public ArrayList<ModelBanco> getListaBancoDAO(){
        ArrayList<ModelBanco> listamodelBanco = new ArrayList();
        ModelBanco modelBanco = new ModelBanco();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                 + " FROM"
                     + " banco"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBanco = new ModelBanco();
                modelBanco.setCodigo(this.getResultSet().getInt(1));
                modelBanco.setBanco(this.getResultSet().getString(2));
                modelBanco.setDescricao(this.getResultSet().getString(3));
                modelBanco.setNomeReduzido(this.getResultSet().getString(4));
                modelBanco.setEmiteBoleto(this.getResultSet().getString(5));
                listamodelBanco.add(modelBanco);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelBanco;
    }

    /**
    * atualiza Banco
    * @param pModelBanco
    * return boolean
    */
    public boolean atualizarBancoDAO(ModelBanco pModelBanco){
        try {
            this.conectar();
            String sql = 
                "UPDATE banco SET "
                    + "codigo = '" + pModelBanco.getCodigo() + "',"
                    + "banco = '" + pModelBanco.getBanco() + "',"
                    + "descricao = '" + pModelBanco.getDescricao() + "',"
                    + "nome_reduzido = '" + pModelBanco.getNomeReduzido() + "',"
                    + "emite_boleto = '" + pModelBanco.getEmiteBoleto() + "'"
                + " WHERE "
                    + "codigo = '" + pModelBanco.getCodigo() + "'"
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
    * exclui Banco
    * @param pCodigo
    * return boolean
    */
    public boolean excluirBancoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM banco "
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
