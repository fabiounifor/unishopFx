package DAO;

import model.ModelCFOP;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOCFOP extends ConexaoMySql {

    /**
    * grava CFOP
    * @param pModelCFOP
    * return int
    */
    public int salvarCFOPDAO(ModelCFOP pModelCFOP){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cfop ("
                    + "cfop,"
                    + "descricao,"
                    + "observacao,"
                    + "faturamento,"
                    + "financeiro,"
                    + "seque_cfop,"
                    + "operacao"
                + ") VALUES ("
                    + "'" + pModelCFOP.getCfop() + "',"
                    + "'" + pModelCFOP.getDescricao() + "',"
                    + "'" + pModelCFOP.getObservacao() + "',"
                    + "'" + pModelCFOP.getFaturamento() + "',"
                    + "'" + pModelCFOP.getFinanceiro() + "',"
                    + "'" + pModelCFOP.getSequeCfop() + "',"
                    + "'" + pModelCFOP.getOperacao() + "'"
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
    * recupera CFOP
    * @param pCodigo
    * return ModelCFOP
    */
    public ModelCFOP getCFOPDAO(int pCodigo){
        ModelCFOP modelCFOP = new ModelCFOP();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cfop,"
                    + "descricao,"
                    + "observacao,"
                    + "faturamento,"
                    + "financeiro,"
                    + "seque_cfop,"
                    + "operacao"
                 + " FROM"
                     + " cfop"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCFOP.setCodigo(this.getResultSet().getInt(1));
                modelCFOP.setCfop(this.getResultSet().getInt(2));
                modelCFOP.setDescricao(this.getResultSet().getString(3));
                modelCFOP.setObservacao(this.getResultSet().getString(4));
                modelCFOP.setFaturamento(this.getResultSet().getInt(5));
                modelCFOP.setFinanceiro(this.getResultSet().getInt(6));
                modelCFOP.setSequeCfop(this.getResultSet().getInt(7));
                modelCFOP.setOperacao(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCFOP;
    }

    /**
    * recupera uma lista de CFOP
        * return ArrayList
    */
    public ArrayList<ModelCFOP> getListaCFOPDAO(){
        ArrayList<ModelCFOP> listamodelCFOP = new ArrayList();
        ModelCFOP modelCFOP = new ModelCFOP();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cfop,"
                    + "descricao,"
                    + "observacao,"
                    + "faturamento,"
                    + "financeiro,"
                    + "seque_cfop,"
                    + "operacao"
                 + " FROM"
                     + " cfop"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCFOP = new ModelCFOP();
                modelCFOP.setCodigo(this.getResultSet().getInt(1));
                modelCFOP.setCfop(this.getResultSet().getInt(2));
                modelCFOP.setDescricao(this.getResultSet().getString(3));
                modelCFOP.setObservacao(this.getResultSet().getString(4));
                modelCFOP.setFaturamento(this.getResultSet().getInt(5));
                modelCFOP.setFinanceiro(this.getResultSet().getInt(6));
                modelCFOP.setSequeCfop(this.getResultSet().getInt(7));
                modelCFOP.setOperacao(this.getResultSet().getString(8));
                listamodelCFOP.add(modelCFOP);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCFOP;
    }

    /**
    * atualiza CFOP
    * @param pModelCFOP
    * return boolean
    */
    public boolean atualizarCFOPDAO(ModelCFOP pModelCFOP){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cfop SET "
                    + "codigo = '" + pModelCFOP.getCodigo() + "',"
                    + "cfop = '" + pModelCFOP.getCfop() + "',"
                    + "descricao = '" + pModelCFOP.getDescricao() + "',"
                    + "observacao = '" + pModelCFOP.getObservacao() + "',"
                    + "faturamento = '" + pModelCFOP.getFaturamento() + "',"
                    + "financeiro = '" + pModelCFOP.getFinanceiro() + "',"
                    + "seque_cfop = '" + pModelCFOP.getSequeCfop() + "',"
                    + "operacao = '" + pModelCFOP.getOperacao() + "'"
                + " WHERE "
                    + "codigo = '" + pModelCFOP.getCodigo() + "'"
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
    * exclui CFOP
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCFOPDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cfop "
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