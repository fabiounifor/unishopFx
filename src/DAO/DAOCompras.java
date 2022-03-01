package DAO;

import model.ModelCompras;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft
*/
public class DAOCompras extends ConexaoMySql {

    /**
    * grava Compras
    * @param pModelCompras
    * return int
    */
    public int salvarComprasDAO(ModelCompras pModelCompras){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO compras ("
                    + "valor_total,"
                        + "data "
                + ") VALUES ("
                    + "'" + pModelCompras.getValorTotal() + "',"
                    + "'" + pModelCompras.getData()+ "'"
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
    * recupera Compras
    * @param pCodigo
    * return ModelCompras
    */
    public ModelCompras getComprasDAO(int pCodigo){
        ModelCompras modelCompras = new ModelCompras();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "valor_total"
                 + " FROM"
                     + " compras"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCompras.setCodigo(this.getResultSet().getInt(1));
                modelCompras.setValorTotal(this.getResultSet().getDouble(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCompras;
    }

    /**
    * recupera uma lista de Compras
        * return ArrayList
    */
    public ArrayList<ModelCompras> getListaComprasDAO(){
        ArrayList<ModelCompras> listamodelCompras = new ArrayList();
        ModelCompras modelCompras = new ModelCompras();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "data"
                 + " FROM"
                     + " compras"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCompras = new ModelCompras();
                modelCompras.setCodigo(this.getResultSet().getInt(1));
                modelCompras.setValorTotal(this.getResultSet().getDouble(2));
                modelCompras.setData(this.getResultSet().getDate(3));
                listamodelCompras.add(modelCompras);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCompras;
    }

    /**
    * atualiza Compras
    * @param pModelCompras
    * return boolean
    */
    public boolean atualizarComprasDAO(ModelCompras pModelCompras){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE compras SET "
                    + "codigo = '" + pModelCompras.getCodigo() + "',"
                    + "valor_total = '" + pModelCompras.getValorTotal() + "'"
                + " WHERE "
                    + "codigo = '" + pModelCompras.getCodigo() + "'"
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
    * exclui Compras
    * @param pCodigo
    * return boolean
    */
    public boolean excluirComprasDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM compras "
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