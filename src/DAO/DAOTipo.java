package DAO;

import model.ModelTipo;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOTipo extends ConexaoMySql {

    /**
    * grava Tipo
    * @param pModelTipo
    * return int
     * @return 
    */
    public int salvarTipoDAO(ModelTipo pModelTipo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tipo ("
                    + "codigo,"
                    + "descricao"
                    + ") VALUES ("
                    + "'" + pModelTipo.getCodigo()+ "',"
                    + "'" + pModelTipo.getDescricao()+ "'"
                    + ");"
            );
        }catch(Exception e){
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera tipo
    * @param pCodigo
    * return ModelTipo
     * @return 
    */
    public ModelTipo getTipoDAO(int pCodigo){
        ModelTipo modelTipo = new ModelTipo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao"
                    + " FROM"
                     + " tipo"
                 + " WHERE"
                     + " codigo = '" + pCodigo + ""
                + ";"
            );

            while(this.getResultSet().next()){
                modelTipo.setCodigo(this.getResultSet().getInt(1));
                modelTipo.setDescricao(this.getResultSet().getString(2));
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        return modelTipo;
    }

    /**
    * recupera uma lista de Tipo
        * return ArrayList
    */
    public ArrayList<ModelTipo> getListaTipoDAO(){
        ArrayList<ModelTipo> listamodelTipo = new ArrayList();
        ModelTipo modelTipo = new ModelTipo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao"
                    + " FROM"
                     + " tipo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTipo = new ModelTipo();
                modelTipo.setCodigo(this.getResultSet().getInt(1));
                modelTipo.setDescricao(this.getResultSet().getString(2));
                listamodelTipo.add(modelTipo);
                }
        }catch(Exception e){
        }finally{
            this.fecharConexao();
        }
        return listamodelTipo;
    }

    /**
    * atualiza Tipo
    * @param pModelTipo
    * return boolean
     * @return 
    */
    public boolean atualizarTipoDAO(ModelTipo pModelTipo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tipo SET "
                    + "codigo = '" + pModelTipo.getCodigo() + "',"
                    + "descricao = '" + pModelTipo.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelTipo.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Tipo
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirTipoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tipo "
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