package DAO;

import conexoes.ConexaoMySql;
import java.sql.Date;
import model.ModelVendas;
import java.util.ArrayList;
import util.BLMascaras;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
/**
 *
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class DAOVendas extends ConexaoMySql {
    ControllerProdutos cp = new ControllerProdutos();
    ControllerUnidadeMedia cum = new ControllerUnidadeMedia();

    /**
     * grava Vendas
     *
     * @param pModelVendas return int
     */
    public int salvarVendasDAO(ModelVendas pModelVendas) {
        BLMascaras blMascaras = new BLMascaras();
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO vendas ("
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"                
                    + "valor_total,"
                    + "desconto, "
                    + "tipo, "
                    + "observacao, "
                    + "tipo_pagamento, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa,"
                    + "mesa,"
                    + "garcon,"
                    + "vencimento"
                    + ") VALUES ("
                    + "'" + pModelVendas.getClientesCodigo() + "',"
                    + "'" + pModelVendas.getDataVenda() + "',"
                    + "'" + (pModelVendas.getHoraVenda()) + "',"        
                    + "'" + pModelVendas.getValorTotal() + "',"
                    + "'" + pModelVendas.getDesconto() + "',"
                    + "'" + pModelVendas.getTipo() + "',"
                    + "'" + pModelVendas.getObservacao() + "',"
                    + "'" + pModelVendas.getTipoPagamento() + "',"
                    + "'" + pModelVendas.getCodigoUsuario() + "',"
                    + "'" + pModelVendas.getTaxaEntrega() + "',"
                    + "'" + pModelVendas.getCaixa()+ "',"
                    + "'" + pModelVendas.getMesa()+ "',"
                    + "'" + pModelVendas.getGarcon()+ "',"
                    + "'" + pModelVendas.getVencimento()+ "'"        
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
     * grava Vendas
     *
     * @param pModelVendas return int
     */
    public boolean salvarProdutosVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            int sizeLista = pModelVendas.getListamModelVendases().size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "insert into VENDAS_PRODUTO( "
                        + "CODIGO_PRODUTO,"
                        + "CODIGO_VENDA,"
                        + "QUANTIDADE, "
                        + "icms_cst, "
                        + "ipi_cst, "
                        + "pis_cst, "
                        + "cofins_cst, "
                        + "cfop, "
                        + "nomeProduto, "
                        + "unidade, "
                        + "ordem, "
                        + "observacao, "
                        + "total, "
                        + "VALOR_UNITARIO) "
                        + " VALUES ("
                        + "'" + pModelVendas.getListamModelVendases().get(i).getProdutosCodigo() + "',"
                        + "'" + pModelVendas.getCodigo() + "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getQuantidade() + "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getIcmsCst() + "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getIpiCst()+ "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getPisCst()+ "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getCofinsCst()+ "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getCfop()+ "',"
                        + "'" + cp.getProdutosController(pModelVendas.getListamModelVendases().get(i).getProdutosCodigo()).getDescricaoProduto()+ "',"        
                        + "'" + cum.getUnidadeMediaController(cp.getProdutosController(pModelVendas.getListamModelVendases().get(i).getProdutosCodigo()).getUnidadeMedida()).getAbreviacao() + "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getOrdem()+ "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getObservacao()+ "',"
                        + "'" + (pModelVendas.getListamModelVendases().get(i).getValor()*pModelVendas.getListamModelVendases().get(i).getQuantidade())+ "',"
                        + "'" + pModelVendas.getListamModelVendases().get(i).getValor()+ "'"
                        + ");"
                );
                
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
        /**
     * recupera Vendas
     *
     * @param pCodigo return ModelVendas
     */
    public ModelVendas getVendasDAO(int pCodigo) {
        ModelVendas modelVendas = new ModelVendas();
        BLMascaras blMascaras = new BLMascaras();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"                
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, " 
                    + "mesa,"
                    + "garcon,"        
                    + "vencimento "        
                    + " FROM"
                    + " vendas"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendas;
    }


    /**
     * recupera Vendas
     *
     * @param pCodigo return ModelVendas
     */
    public ModelVendas getVendasClienteDAO(int pCodigo) {
        ModelVendas modelVendas = new ModelVendas();
        BLMascaras blMascaras = new BLMascaras();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"                
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, " 
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento "        
                    + " FROM"
                    + " vendas"
                    + " WHERE"
                    + " clientes_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
     * recupera uma lista de pedidos return ArrayList
     */
    public ArrayList<ModelVendas> getListaPedidosDAO() {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        BLMascaras blMascaras = new BLMascaras();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"                
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, " 
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento "
                    + " FROM"
                    + " vendas "
                    //+ "WHERE tipo = 1"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
                
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }
    
    /**
     * recupera uma lista de pedidos return ArrayList
     */
    public ArrayList<ModelVendas> getListaPedidosEntregaDAO() {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        BLMascaras blMascaras = new BLMascaras();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"                
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, " 
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento "
                    + " FROM"
                    + " vendas "
                    + "WHERE (tipo = 2) or (tipo = 3) or (tipo = 4) "
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
                
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de orcamentos return ArrayList
     */
    public ArrayList<ModelVendas> getListaOrcamentoDAO() {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"        
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao,"
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, "
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento "
                    + " FROM"
                    + " vendas "
                    + "WHERE tipo = 0"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }
    /**
     * recupera uma lista de orcamentos return ArrayList
     * @param inicio
     * @param fim
     * @return 
     */
    public ArrayList<ModelVendas> getListaVendasPdvPorDataDAO(Date inicio, Date fim) {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"        
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao,"
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, "
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento "
                    + " FROM"
                    + " vendas "
                    + "WHERE "
                    + "(data_venda BETWEEN  '" + inicio + "' AND '" + fim + "') "
                    + " AND (tipo = '65');"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasDAO(int pCodigo) {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario "
                    + " FROM "
                    + " vendas_produto WHERE codigo_venda = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas.setCodigo(this.getResultSet().getInt(2));
                modelVendas.setQuantidade(this.getResultSet().getFloat(3));
                modelVendas.setValor(this.getResultSet().getDouble(4));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<ModelVendas> getListaPedidosDAO(ModelVendas pModelVendas) {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        BLMascaras blMascaras = new BLMascaras();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"        
                    + "desconto, "
                    + "tipo_pagamento,"
                    + "tipo,"
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "
                    + "caixa, "
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento"
                    + " FROM "
                    + " vendas "
                    + "WHERE "
                    + "(data_venda BETWEEN  '" + pModelVendas.getDataVenda() + "' AND '" + pModelVendas.getDataPagamento() + "') "
                    + " AND (caixa = '" + pModelVendas.getCaixa()+"')"
                    + " AND (tipo = '1');"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12));
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
                
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<ModelVendas> getListaOrcamentoDAO(ModelVendas pModelVendas) {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "hora_venda,"
                    + "desconto, "
                    + "tipo_pagamento,"
                    + "tipo,"
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega, "        
                    + "caixa, "
                    + "mesa,"
                    + "garcon,"                
                    + "vencimento"        
                    + " FROM"
                    + " vendas"
                    + " WHERE"
                    + " data_venda = '" + pModelVendas.getDataVenda() + "' AND tipo = 0"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getFloat(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setHoraVenda(this.getResultSet().getString(5));
                modelVendas.setDesconto(this.getResultSet().getFloat(6));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(7));
                modelVendas.setTipo(this.getResultSet().getInt(8));
                modelVendas.setObservacao(this.getResultSet().getString(9));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(10));
                modelVendas.setTaxaEntrega(this.getResultSet().getFloat(11));
                modelVendas.setCaixa(this.getResultSet().getInt(12)); 
                modelVendas.setMesa(this.getResultSet().getInt(13));
                modelVendas.setGarcon(this.getResultSet().getInt(14));
                modelVendas.setVencimento(this.getResultSet().getString(15));
                
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * atualiza Vendas
     *
     * @param pModelVendas return boolean
     */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE vendas SET "
                    + "codigo = '" + pModelVendas.getCodigo() + "',"
                    + "valor_total = '" + pModelVendas.getValorTotal() + "',"
                    + "clientes_codigo = '" + pModelVendas.getClientesCodigo() + "',"
                    + "data_venda = '" + pModelVendas.getDataVenda() + "',"
                    + "hora_venda = '" + pModelVendas.getHoraVenda() + "',"        
                    + "desconto = '" + pModelVendas.getDesconto() + "',"
                    + "tipo_pagamento = '" + pModelVendas.getTipoPagamento() + "',"
                    + "tipo = '" + pModelVendas.getTipo() + "',"
                    + "observacao = '" + pModelVendas.getObservacao() + "',"
                    + "codigo_usuario = '" + pModelVendas.getCodigoUsuario() + "',"
                    + "taxa_entrega = '" + pModelVendas.getTaxaEntrega()+ "',"
                    + "caixa = '" + pModelVendas.getCaixa()+ "',"
                    + "mesa = '" + pModelVendas.getMesa()+ "',"
                    + "garcon = '" + pModelVendas.getGarcon()+ "',"
                    + "vencimento = '" + pModelVendas.getVencimento() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelVendas.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    /**
     * atualiza Vendas
     *
     * @param pModelVendas return boolean
     */
    public boolean atualizarVendasProdutosDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE vendas SET "
                    + "codigo = '" + pModelVendas.getCodigo() + "',"
                    + "valor_total = '" + pModelVendas.getValorTotal() + "',"
                    + "clientes_codigo = '" + pModelVendas.getClientesCodigo() + "',"
                    + "data_venda = '" + pModelVendas.getDataVenda() + "',"
                    + "hora_venda = '" + pModelVendas.getHoraVenda() + "',"        
                    + "desconto = '" + pModelVendas.getDesconto() + "',"
                    + "tipo_pagamento = '" + pModelVendas.getTipoPagamento() + "',"
                    + "tipo = '" + pModelVendas.getTipo() + "',"
                    + "observacao = '" + pModelVendas.getObservacao() + "',"
                    + "codigo_usuario = '" + pModelVendas.getCodigoUsuario() + "',"
                    + "taxa_entrega = '" + pModelVendas.getTaxaEntrega()+ "',"
                    + "caixa = '" + pModelVendas.getCaixa()+ "',"
                    + "mesa = '" + pModelVendas.getMesa()+ "',"
                    + "garcon = '" + pModelVendas.getGarcon()+ "',"
                    + "vencimento = '" + pModelVendas.getVencimento() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelVendas.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    public boolean atualizarVendasProdutosListaDAO(ModelVendas pModelVendas) {
        int codigo = pModelVendas.getCodigo();
        try {
            this.conectar();
            int sizeLista = pModelVendas.getListamModelVendases().size();
            for (int i = 0; i < sizeLista; i++) {
                 this.executarUpdateDeleteSQL(
                    "UPDATE vendas_produto SET "
                        + "codigo_venda = '" + codigo + "',"
                        + "codigo_produto = '" + pModelVendas.getListamModelVendases().get(i).getProdutosCodigo() + "',"        
                        + "quantidade = '" + pModelVendas.getListamModelVendases().get(i).getQuantidade() + "',"
                        + "icms_cst = '" + pModelVendas.getListamModelVendases().get(i).getIcmsCst() + "',"
                        + "ipi_cst = '" + pModelVendas.getListamModelVendases().get(i).getIpiCst() + "',"
                        + "pis_cst = '" + pModelVendas.getListamModelVendases().get(i).getPisCst() + "',"
                        + "cofins_cst = '" + pModelVendas.getListamModelVendases().get(i).getCofinsCst() + "',"
                        + "cfop = '" + pModelVendas.getListamModelVendases().get(i).getCfop() + "',"
                        + "nomeProduto = '" + cp.getProdutosController(pModelVendas.getListamModelVendases().get(i).getProdutosCodigo()).getDescricaoProduto() + "',"
                        + "unidade = '" + cum.getUnidadeMediaController(cp.getProdutosController(pModelVendas.getListamModelVendases().get(i).getProdutosCodigo()).getUnidadeMedida()).getAbreviacao() + "',"
                        + "ordem = '" + pModelVendas.getListamModelVendases().get(i).getOrdem() + "',"
                        + "observacao = '" + pModelVendas.getListamModelVendases().get(i).getObservacao() + "',"
                        + "total= '" + pModelVendas.getListamModelVendases().get(i).getValor() + "',"
                        + "valor_unitario = '" + pModelVendas.getListamModelVendases().get(i).getValor() + "'"
                        + " WHERE "
                        + "codigo_venda = 0  AND  "
                        + "codigo_produto = '" + pModelVendas.getListamModelVendases().get(i).getProdutosCodigo() + "'"
                        + ";"
            );
            }                        
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    public boolean atualizarOrdemProdutosListaDAO(int pCodigo, int pOrdem) {
        try{
                 this.executarUpdateDeleteSQL(
                    "UPDATE vendas_produto SET "
                        + "ordem = '" + pOrdem + "',"
                        + " WHERE "
                        + "codigo_venda = 0  AND  "
                        + "codigo_produto = '" + pCodigo + "'"
                        + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * desaprovar Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean desaprovarPedidoDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE vendas SET "
                    + "tipo = 0 "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    public boolean mudarEntregaDAO(int pCodigo, int status) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE vendas SET "
                    + "tipo = "+ status 
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean excluirVendasDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM vendas "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirProdutoVendasDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "DELETE FROM vendas_produto WHERE "
                    + "codigo_venda = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasProdutosDAO(int pCodigo) {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade "
                    + " FROM "
                    + " vendas_produto WHERE codigo_venda = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas.setCodigo(this.getResultSet().getInt(2));
                modelVendas.setQuantidade(this.getResultSet().getFloat(3));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

}
