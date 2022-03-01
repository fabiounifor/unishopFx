package DAO;

import model.ModelGrupo;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOGRUPO extends ConexaoMySql {

    /**
    * grava GRUPO
    * @param pModelGrupo
    * return int
     * @return 
    */
    public int salvarGRUPODAO(ModelGrupo pModelGrupo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO grupo ("
                    + "codigo,"
                    + "grupo,"
                    + "descricao"
                    + ") VALUES ("
                    + "'" + pModelGrupo.getCodigo()+ "',"
                    + "'" + pModelGrupo.getGrupo()+ "',"
                    + "'" + pModelGrupo.getDescricao()+ "'"
                    + ");"
            );
        }catch(Exception e){
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera grupo
    * @param pCodigo
    * return ModelGRUPO
     * @return 
    */
    public ModelGrupo getGrupoDAO(int pCodigo){
        ModelGrupo modelGrupo = new ModelGrupo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "grupo,"
                    + "descricao"
                    + " FROM"
                     + " grupo"
                 + " WHERE"
                     + " codigo = '" + pCodigo + ""
                + ";"
            );

            while(this.getResultSet().next()){
                modelGrupo.setCodigo(this.getResultSet().getInt(1));
                modelGrupo.setGrupo(this.getResultSet().getString(2));
                modelGrupo.setDescricao(this.getResultSet().getString(3));
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        return modelGrupo;
    }

    /**
    * recupera uma lista de GRUPO
        * return ArrayList
    */
    public ArrayList<ModelGrupo> getListaGRUPODAO(){
        ArrayList<ModelGrupo> listamodelGRUPO = new ArrayList();
        ModelGrupo modelGRUPO = new ModelGrupo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "descricao"
                    + " FROM"
                     + " grupo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelGRUPO = new ModelGrupo();
                modelGRUPO.setCodigo(this.getResultSet().getInt(1));
                modelGRUPO.setGrupo(this.getResultSet().getString(2));
                modelGRUPO.setDescricao(this.getResultSet().getString(3));
                listamodelGRUPO.add(modelGRUPO);
                }
        }catch(Exception e){
        }finally{
            this.fecharConexao();
        }
        return listamodelGRUPO;
    }

    /**
    * atualiza GRUPO
    * @param pModelGRUPO
    * return boolean
     * @return 
    */
    public boolean atualizarGRUPODAO(ModelGrupo pModelGRUPO){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE grupo SET "
                    + "codigo = '" + pModelGRUPO.getCodigo() + "',"
                    + "nome = '" + pModelGRUPO.getGrupo() + "',"
                    + "descricao = '" + pModelGRUPO.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelGRUPO.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui GRUPO
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirGRUPODAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM grupo "
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