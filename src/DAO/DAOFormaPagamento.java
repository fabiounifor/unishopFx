package DAO;

import model.ModelFormaPagamento;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAOFormaPagamento extends ConexaoMySql {

    /**
     * grava FormaPagamento
     *
     * @param pModelFormaPagamento return int
     */
    public int salvarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento) {
        try {
            this.conectar();
            int situacao = 0;
            if (pModelFormaPagamento.isSituacao()) {
                situacao = 1;
            } else {
                situacao = 0;
            }
            return this.insertSQL(
                    "INSERT INTO forma_pagamento ("
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                    + ") VALUES ("
                    + "'" + pModelFormaPagamento.getDescricao() + "',"
                    + "'" + pModelFormaPagamento.getDesconto() + "',"
                    + "'" + pModelFormaPagamento.getQuantidadeParcelas() + "',"
                    + "'" + pModelFormaPagamento.getObservacao() + "',"
                    + "'" + situacao + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
    * recupera FormaPagamento
    * @param pCodigo
    * return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoDAO(int pCodigo){
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                 + " FROM"
                     + " forma_pagamento"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }
    
    /**
    * recupera FormaPagamento
    * @param pDescricao
    * return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoDAO(String pDescricao){
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                 + " FROM"
                     + " forma_pagamento"
                 + " WHERE"
                     + " descricao = '" + pDescricao + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /**
    * recupera uma lista de FormaPagamento
        * return ArrayList
    */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoDAO(){
        ArrayList<ModelFormaPagamento> listamodelFormaPagamento = new ArrayList();
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                 + " FROM"
                     + " forma_pagamento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento = new ModelFormaPagamento();
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
                listamodelFormaPagamento.add(modelFormaPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFormaPagamento;
    }

    /**
    * atualiza FormaPagamento
    * @param pModelFormaPagamento
    * return boolean
    */
    public boolean atualizarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            int situacao = 0;
            if (pModelFormaPagamento.isSituacao()) {
                situacao = 1;
            } else {
                situacao = 0;
            }
            return this.executarUpdateDeleteSQL(
                "UPDATE forma_pagamento SET "
                    + "codigo = '" + pModelFormaPagamento.getCodigo() + "',"
                    + "descricao = '" + pModelFormaPagamento.getDescricao() + "',"
                    + "desconto = '" + pModelFormaPagamento.getDesconto() + "',"
                    + "quantidade_parcelas = '" + pModelFormaPagamento.getQuantidadeParcelas() + "',"
                    + "observacao = '" + pModelFormaPagamento.getObservacao() + "',"
                    + "situacao = '" + situacao + "'"
                + " WHERE "
                    + "codigo = '" + pModelFormaPagamento.getCodigo() + "'"
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
    * exclui FormaPagamento
    * @param pCodigo
    * return boolean
    */
    public boolean excluirFormaPagamentoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM forma_pagamento "
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