package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelContaReceber;

/**
 *
 * @author contato@blsoft.com.br
 */
public class DAOContaReceber extends ConexaoMySql {

    /**
     * grava ContaPagar
     *
     * @param pModelContaRecber return int
     */
    public int salvarContaReceberDAO(ModelContaReceber pModelContaRecber) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO contas_receber ("
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + ") VALUES ("
                    + "'" + pModelContaRecber.getCodigoPessoa() + "',"
                    + "'" + pModelContaRecber.getDescricao() + "',"
                    + "'" + pModelContaRecber.getData() + "',"
                    + "'" + pModelContaRecber.getVencimento() + "',"
                    + "'" + pModelContaRecber.getPagamento() + "',"
                    + "'" + pModelContaRecber.getTipoPagamento() + "',"
                    + "'" + pModelContaRecber.getObservacao() + "',"
                    + "'" + pModelContaRecber.isSituacao() + "',"
                    + "'" + pModelContaRecber.getValor() + "'"
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
     * grava ContaPagar
     *
     * @param pModelContaReceber return int
     * @return 
     */
    public boolean salvarContasReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            int sizeLista = pModelContaReceber.getListaContaReceber().size();
            for (int i = 0; i < sizeLista; i++) {
            this.insertSQL(
                    "INSERT INTO contas_receber ("
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + ") VALUES ("
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getCodigoPessoa() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getDescricao() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getData() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getVencimento() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getPagamento() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getTipoPagamento() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getObservacao() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).isSituacao() + "',"
                    + "'" + pModelContaReceber.getListaContaReceber().get(i).getValor() + "'"
                    + ");"
            );
            }
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
        return true;
    }
   

    /**
     * recupera ContaPagar
     *
     * @param pCodigo return ModelConta
     */
    public ModelContaReceber getContaPagarDAO(int pCodigo) {
        ModelContaReceber modelConta = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor"
                    + " FROM"
                    + " contas_receber"
                    + " WHERE"
                    + " pk_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelConta;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContaPagarDAO() {
        ArrayList<ModelContaReceber> listamodelConta = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor"
                    + " FROM"
                    + " contas_receber"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelConta.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelConta;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContaPagarDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaPagar = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContaReceberDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaReceber = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaReceber.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContasDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaReceber = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaReceber.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /**
     * recupera uma lista de ContaPagar por data return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContasDAO(ModelContaReceber pModelConta) {
        ArrayList<ModelContaReceber> listamodelContaPagar = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber "
                    + "WHERE "
                    + "(pagamento BETWEEN  '" + pModelConta.getData() + "' AND '" + pModelConta.getPagamento() + "') "
                    + "AND (situacao = '" + pModelConta.isSituacao() + "');"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * atualiza ContaPagar
     *
     * @param pModelContaReceber return boolean
     */
    public boolean atualizarContaReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_receber SET "
                    + "pk_codigo = '" + pModelContaReceber.getCodigo() + "',"
                    + "clientes_codigo = '" + pModelContaReceber.getCodigoPessoa() + "',"
                    + "descricao = '" + pModelContaReceber.getDescricao() + "',"
                    + "data = '" + pModelContaReceber.getData() + "',"
                    + "vencimento = '" + pModelContaReceber.getVencimento() + "',"
                    + "pagamento = '" + pModelContaReceber.getPagamento() + "',"
                    + "fk_tipo_pagamento = '" + pModelContaReceber.getTipoPagamento() + "',"
                    + "observacao = '" + pModelContaReceber.getObservacao() + "',"
                    + "situacao = '" + pModelContaReceber.isSituacao() + "',"
                    + "valor = '" + pModelContaReceber.getValor() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pModelContaReceber.getCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui ContaPagar
     *
     * @param pCodigo return boolean
     */
    public boolean excluirContaReceberDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM contas_receber "
                    + " WHERE "
                    + "pk_codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean receberContaReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_receber SET "
                    + "pagamento = '" + pModelContaReceber.getPagamento() + "',"
                    + "situacao = '" + pModelContaReceber.isSituacao() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pModelContaReceber.getCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

}
