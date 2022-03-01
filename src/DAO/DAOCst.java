package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCst;

/**
 *
 * @author Leandro
 */
public class DAOCst extends ConexaoMySql {

/**
    * grava Csosn
    * @param pModelCst 
    * return int
    */
    public int salvarCstDAO(ModelCst pModelCst){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cst ("
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCst.getCodigo() + "',"
                    + "'" + pModelCst.getNumero()+ "',"
                    + "'" + pModelCst.getDescricao()+ "'"
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
    * recupera Cst
    * @param pCodigo
    * @return ModelCst
    */
    public ModelCst getCstDAO(int pCodigo){
        ModelCst modelCst = new ModelCst();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao,"
                 + " FROM"
                     + " cst"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCst.setCodigo(this.getResultSet().getInt(1));
                modelCst.setNumero(this.getResultSet().getInt(2));
                modelCst.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCst;
    }
    
    /**
    * recupera uma lista de Cst
        * return ArrayList
    */
    public ArrayList<ModelCst> getListaCstDAO(){
        ArrayList<ModelCst> listamodelCst = new ArrayList();
        ModelCst modelCst = new ModelCst();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                    + " FROM"
                     + " cst"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCst = new ModelCst();
                modelCst.setCodigo(this.getResultSet().getInt(1));
                modelCst.setNumero(this.getResultSet().getInt(2));
                modelCst.setDescricao(this.getResultSet().getString(3));
                
                listamodelCst.add(modelCst);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCst;
    }

    /**
    * atualiza Csosn
    * @param pModelCst 
    * return boolean
    */
    public boolean atualizarCstDAO(ModelCst pModelCst){
        try {
            this.conectar();
            String sql = 
                "UPDATE cst SET "
                    + "codigo = '" + pModelCst.getCodigo() + "',"
                    + "numero = '" + pModelCst.getNumero()+ "',"
                    + "descricao = '" + pModelCst.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelCst.getCodigo() + "'"
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
    * exclui Cst
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCstDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cst "
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
