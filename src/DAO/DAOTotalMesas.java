package DAO;

import model.ModelTotalMesas;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft
*/
public class DAOTotalMesas extends ConexaoMySql {

    /**
    * grava TotalMesas
    * @param pModelTotalMesas
    * return int
    */
    public int salvarTotalMesasDAO(ModelTotalMesas pModelTotalMesas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO total_mesas ("
                    + "pk_codigo,"
                    + "quantidade"
                + ") VALUES ("
                    + "'" + pModelTotalMesas.getCodigo() + "',"
                    + "'" + pModelTotalMesas.getQuantidade() + "'"
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
    * recupera TotalMesas
    * @param pCodigo
    * return ModelTotalMesas
    */
    public ModelTotalMesas getTotalMesasDAO(int pCodigo){
        ModelTotalMesas modelTotalMesas = new ModelTotalMesas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "quantidade"
                 + " FROM"
                     + " total_mesas"
                 + " WHERE"
                     + " pk_codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTotalMesas.setCodigo(this.getResultSet().getInt(1));
                modelTotalMesas.setQuantidade(this.getResultSet().getInt(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTotalMesas;
    }

    /**
    * recupera uma lista de TotalMesas
        * return ArrayList
    */
    public ArrayList<ModelTotalMesas> getListaTotalMesasDAO(){
        ArrayList<ModelTotalMesas> listamodelTotalMesas = new ArrayList();
        ModelTotalMesas modelTotalMesas = new ModelTotalMesas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "quantidade"
                 + " FROM"
                     + " total_mesas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTotalMesas = new ModelTotalMesas();
                modelTotalMesas.setCodigo(this.getResultSet().getInt(1));
                modelTotalMesas.setQuantidade(this.getResultSet().getInt(2));
                listamodelTotalMesas.add(modelTotalMesas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelTotalMesas;
    }

    /**
    * atualiza TotalMesas
    * @param pModelTotalMesas
    * return boolean
    */
    public boolean atualizarTotalMesasDAO(ModelTotalMesas pModelTotalMesas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE total_mesas SET "
                    + "pk_codigo = '" + pModelTotalMesas.getCodigo() + "',"
                    + "quantidade = '" + pModelTotalMesas.getQuantidade() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelTotalMesas.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui TotalMesas
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTotalMesasDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM total_mesas "
                + " WHERE "
                    + "pk_codigo = '" + pCodigo + "'"
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