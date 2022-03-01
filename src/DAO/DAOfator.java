package DAO;

import model.ModelFator;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOfator extends ConexaoMySql {

    /**
    * grava GRUPO
    * @param pModelGrupo
    * return int
     * @return 
    */
    public int salvarfatorDAO(ModelFator pModelFator){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO fator ("
                    + "codigo,"
                    + "fator,"
                    + "descricao,"
                    + "operando"
                    + ") VALUES ("
                    + "'" + pModelFator.getCodigo()+ "',"
                    + "'" + pModelFator.getFator()+ "',"
                    + "'" + pModelFator.getDescricao()+ "',"
                    + "'" + pModelFator.getOperando()+ "'"        
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
    public ModelFator getFatorDAO(int pCodigo){
        ModelFator modelFator = new ModelFator();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "fator,"
                    + "descricao,"
                    + "operando"    
                    + " FROM"
                     + " fator"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFator.setCodigo(this.getResultSet().getInt(1));
                modelFator.setFator(this.getResultSet().getFloat(2));
                modelFator.setDescricao(this.getResultSet().getString(3));
                modelFator.setOperando(this.getResultSet().getString(4));
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        return modelFator;
    }
    
    
    /**
    * recupera grupo
    * @param pDescricao
    * return ModelGRUPO
     * @return 
    */
    public ModelFator getFatorDescricaoDAO(String pDescricao){
        ModelFator modelFator = new ModelFator();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "fator,"
                    + "descricao,"
                    + "operando"    
                    + " FROM"
                     + " fator"
                 + " WHERE"
                     + " descricao = '" + pDescricao + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFator.setCodigo(this.getResultSet().getInt(1));
                modelFator.setFator(this.getResultSet().getFloat(2));
                modelFator.setDescricao(this.getResultSet().getString(3));
                modelFator.setOperando(this.getResultSet().getString(4));
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        return modelFator;
    }

    /**
    * recupera uma lista de GRUPO
        * return ArrayList
    */
    public ArrayList<ModelFator> getListaFatorDAO(){
        ArrayList<ModelFator> listamodelFator = new ArrayList();
        ModelFator modelFator = new ModelFator();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "fator,"
                    + "descricao,"
                    + "operando"    
                    + " FROM"
                     + " fator"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFator = new ModelFator();
                modelFator.setCodigo(this.getResultSet().getInt(1));
                modelFator.setFator(this.getResultSet().getFloat(2));
                modelFator.setDescricao(this.getResultSet().getString(3));
                modelFator.setOperando(this.getResultSet().getString(4));
                listamodelFator.add(modelFator);
                }
        }catch(Exception e){
        }finally{
            this.fecharConexao();
        }
        return listamodelFator;
    }

    /**
    * atualiza GRUPO
    * @param pModelFator
    * return boolean
     * @return 
    */
    public boolean atualizarFatorDAO(ModelFator pModelFator){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE grupo SET "
                    + "codigo = '" + pModelFator.getCodigo() + "',"
                    + "nome = '" + pModelFator.getFator() + "',"
                    + "descricao = '" + pModelFator.getDescricao() + "',"
                    + "operando = '" + pModelFator.getFator() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelFator.getCodigo() + "'"
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
    public boolean excluirFatorDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM fator "
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