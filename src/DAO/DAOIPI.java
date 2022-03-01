package DAO;

import model.ModelIpi;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOIPI extends ConexaoMySql {

    /**
    * grava IPI
    * @param pModelCFOP
    * return int
    */
    public int salvarIPIDAO(ModelIpi pModelIpi){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO ipi_modelo ("
                    + "descricao,"
                    + "cst_entrada,"
                    + "cst_saida,"
                    + "enquadramento"
                + ") VALUES ("
                    + "'" + pModelIpi.getDescricao() + "',"
                    + "'" + pModelIpi.getCstEntrada() + "',"
                    + "'" + pModelIpi.getCstSaida() + "',"
                    + "'" + pModelIpi.getEnquadramento() + "'"
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
    * recupera IPI
    * @param pCodigo
    * return ModelIPI
    */
    public ModelIpi getIPIDAO(int pCodigo){
        ModelIpi modelIpi = new ModelIpi();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "cst_entrada,"
                    + "cst_saida,"
                    + "enquadramento"
                 + " FROM"
                     + " ipi_modelo"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelIpi.setCodigo(this.getResultSet().getInt(1));
                modelIpi.setDescricao(this.getResultSet().getString(2));
                modelIpi.setCstEntrada(this.getResultSet().getInt(3));
                modelIpi.setCstSaida(this.getResultSet().getInt(4));
                modelIpi.setEnquadramento(this.getResultSet().getInt(5));
                }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelIpi;
    }

    /**
    * recupera uma lista de IPI
        * return ArrayList
    */
    public ArrayList<ModelIpi> getListaIPIDAO(){
        ArrayList<ModelIpi> listamodelIPI = new ArrayList();
        ModelIpi modelIpi = new ModelIpi();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "cst_entrada,"
                    + "cst_saida,"
                    + "enquadramento"
                 + " FROM"
                     + " ipi_modelo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelIpi = new ModelIpi();
                modelIpi.setCodigo(this.getResultSet().getInt(1));
                modelIpi.setDescricao(this.getResultSet().getString(2));
                modelIpi.setCstEntrada(this.getResultSet().getInt(3));
                modelIpi.setCstSaida(this.getResultSet().getInt(4));
                modelIpi.setEnquadramento(this.getResultSet().getInt(5));
                listamodelIPI.add(modelIpi);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelIPI;
    }

    /**
    * atualiza IPI
    * @param pModelIPI
    * return boolean
    */
    public boolean atualizarIPIDAO(ModelIpi pModelIpi){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE ipi_modelo SET "
                    + "codigo = '" + pModelIpi.getCodigo() + "',"
                    + "descricao = '" + pModelIpi.getDescricao() + "',"
                    + "cst_entrada = '" + pModelIpi.getCstEntrada() + "',"
                    + "cst_saida = '" + pModelIpi.getCstSaida() + "',"
                    + "enquadramento = '" + pModelIpi.getEnquadramento()+ "'"
                + " WHERE "
                    + "codigo = '" + pModelIpi.getCodigo() + "'"
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
    * exclui IPI
    * @param pCodigo
    * return boolean
    */
    public boolean excluirIPIDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM ipi_modelo "
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