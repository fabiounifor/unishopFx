package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCsosn;

/**
 *
 * @author Leandro
 */
public class DAOCsosn extends ConexaoMySql {

/**
    * grava Csosn
    * @param pModelCsosn
    * return int
    */
    public int salvarCsosnDAO(ModelCsosn pModelCsosn){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO csosn ("
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCsosn.getCodigo() + "',"
                    + "'" + pModelCsosn.getNumero()+ "',"
                    + "'" + pModelCsosn.getDescricao()+ "'"
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
    * recupera Csosn
    * @param pCodigo
    * @return ModelCsosn
    */
    public ModelCsosn getCsosnDAO(int pCodigo){
        ModelCsosn modelCsosn = new ModelCsosn();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                 + " FROM"
                     + " csosn"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCsosn.setCodigo(this.getResultSet().getInt(1));
                modelCsosn.setNumero(this.getResultSet().getInt(2));
                modelCsosn.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCsosn;
    }
    
    /**
    * recupera uma lista de Csosn
        * return ArrayList
    */
    public ArrayList<ModelCsosn> getListaCsosnDAO(){
        ArrayList<ModelCsosn> listamodelCsosn = new ArrayList();
        ModelCsosn modelCsosn = new ModelCsosn();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                    + " FROM"
                     + " csosn"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCsosn = new ModelCsosn();
                modelCsosn.setCodigo(this.getResultSet().getInt(1));
                modelCsosn.setNumero(this.getResultSet().getInt(2));
                modelCsosn.setDescricao(this.getResultSet().getString(3));
                
                listamodelCsosn.add(modelCsosn);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCsosn;
    }

    /**
    * atualiza Csosn
    * @param pModelCsosn
    * return boolean
    */
    public boolean atualizarCsosnDAO(ModelCsosn pModelCsosn){
        try {
            this.conectar();
            String sql = 
                "UPDATE csosn SET "
                    + "codigo = '" + pModelCsosn.getCodigo() + "',"
                    + "numero = '" + pModelCsosn.getNumero()+ "',"
                    + "descricao = '" + pModelCsosn.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelCsosn.getCodigo() + "'"
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
    * exclui Csosn
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCsosnDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM csosn "
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
