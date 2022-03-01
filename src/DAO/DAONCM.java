package DAO;

import model.ModelNCM;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAONCM extends ConexaoMySql {

    /**
    * grava NCM
    * @param pModelNCM
    * return int
     * @return 
    */
    public int salvarNCMDAO(ModelNCM pModelNCM){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO ncm ("
                    + "codigo,"
                    + "ncm,"
                    + "descricao"
                    + ") VALUES ("
                    + "'" + pModelNCM.getCodigo()+ "',"
                    + "'" + pModelNCM.getNcm()+ "',"
                    + "'" + pModelNCM.getDescricao()+ "'"
                    + ");"
            );
        }catch(Exception e){
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera ncm
    * @param pCodigo
    * return ModelNCM
     * @return 
    */
    public ModelNCM getNCMDAO(int pCodigo){
        ModelNCM modelNCM = new ModelNCM();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "ncm,"
                    + "descricao"
                    + " FROM"
                     + " ncm"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNCM.setCodigo(this.getResultSet().getInt(1));
                modelNCM.setNcm(this.getResultSet().getString(2));
                modelNCM.setDescricao(this.getResultSet().getString(3));
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        return modelNCM;
    }

    /**
    * recupera uma lista de NCM
        * return ArrayList
     * @return 
    */
    public ArrayList<ModelNCM> getListaNCMDAO(){
        ArrayList<ModelNCM> listamodelNCM = new ArrayList();
        ModelNCM modelNCM = new ModelNCM();
       
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "ncm,"
                    + "descricao"
                    + " FROM"
                     + " ncm"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNCM = new ModelNCM();
                modelNCM.setCodigo(this.getResultSet().getInt(1));
                modelNCM.setNcm(this.getResultSet().getString(2));
                modelNCM.setDescricao(this.getResultSet().getString(3));
                listamodelNCM.add(modelNCM);
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        System.out.println(listamodelNCM.size());
        
        return listamodelNCM;
    }

    /**
    * atualiza NCM
    * @param pModelNCM
    * return boolean
     * @return 
    */
    public boolean atualizarNCMDAO(ModelNCM pModelNCM){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE ncm SET "
                    + "codigo = '" + pModelNCM.getCodigo() + "',"
                    + "ncm = '" + pModelNCM.getNcm() + "',"
                    + "descricao = '" + pModelNCM.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelNCM.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui NCM
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirNCMDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM ncm "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}