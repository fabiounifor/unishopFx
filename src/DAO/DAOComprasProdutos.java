package DAO;

import util.BLMascaras;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelComprasProdutos;

/**
 *
 * @author BLSoft
 */
public class DAOComprasProdutos extends ConexaoMySql {
    BLMascaras blMascaras = new BLMascaras();

    /**
     * grava compras_produtos
     *
     * @param pModelcompras_produtos return int
     */
    public int salvarcompras_produtosDAO(ModelComprasProdutos pModelcompras_produtos) {
        try {
            System.out.println(pModelcompras_produtos + "salvar compras dao");
            this.conectar();
            int sizeLista = pModelcompras_produtos.getListaModelComprasProdutos().size();
            
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "INSERT INTO compras_produtos ("
                        + "cod_compras,"
                        + "cod_produto,"
                        + "codProdutoFornecedor,"
                        + "nomeProduto,"
                        + "nomeProdutoEstoque,"
                        + "barras,"
                        + "ncm,"
                        + "cst,"
                        + "cfop,"
                        + "cest,"
                        + "perc_credito_sn,"
                        + "valor_credito_sn,"
                        + "base_calc_sub,"
                        + "base_calc_icms,"
                        + "perc_ipi,"
                        + "valor_ipi,"
                        + "cfopestoque,"
                        + "fatorConversao,"
                        + "codFornecedor,"
                        + "valor_custo,"
                        + "valor_total,"
                        + "ordem,"
                        + "quantidade"
                        + ") VALUES ("
                        + "'" + pModelcompras_produtos.getCodCompras() + "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCodProduto()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCodProdutoFornecedor()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getNomeProduto()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getNomeProdutoEstoque()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getBarras()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getNcm()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCst()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCfop()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCest()+ "',"
                        + "'" + (blMascaras.converterVirgulaParaPonto(pModelcompras_produtos.getListaModelComprasProdutos().get(i).getPercCreditoSn()))+ "',"
                        + "'" + (blMascaras.converterVirgulaParaPonto(pModelcompras_produtos.getListaModelComprasProdutos().get(i).getValorCreditoSn()))+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getBaseCalculoSub()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getBaseCalculoicms()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getPercIpi()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getValorIpi()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCfopEstoque()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getFatorConversao()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getCodFornecedor()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getValorCusto()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getValorTotal()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getOrdem()+ "',"
                        + "'" + pModelcompras_produtos.getListaModelComprasProdutos().get(i).getQuantidade()+ "'"
                        + ");"
                );
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
    
    /**
     * grava compras_produtos
     *
     * @param pModelcompras_produtos return int
     */
    public int salvarcompra_produtoDAO(ModelComprasProdutos pModelcompras_produtos) {
        try {
            System.out.println(pModelcompras_produtos + "salvarcompra dao");
            this.conectar();
            
                this.insertSQL(
                        "INSERT INTO compras_produtos ("
                        + "cod_compras,"
                        + "cod_produto,"
                        + "codProdutoFornecedor,"
                        + "nomeProduto,"
                        + "nomeProdutoEstoque,"
                        + "barras,"
                        + "ncm,"
                        + "cst,"
                        + "cfop,"
                        + "cest,"
                        + "perc_credito_sn,"
                        + "valor_credito_sn,"
                        + "base_calc_sub,"
                        + "base_calc_icms,"
                        + "perc_ipi,"
                        + "valor_ipi,"
                        + "cfopestoque,"
                        + "fatorConversao,"
                        + "codFornecedor,"
                        + "valor_custo,"
                        + "valor_total,"
                        + "ordem,"
                        + "quantidade"
                        + ") VALUES ("
                        + "'" + pModelcompras_produtos.getCodCompras() + "',"
                        + "'" + pModelcompras_produtos.getCodProduto()+ "',"
                        + "'" + pModelcompras_produtos.getCodProdutoFornecedor()+ "',"
                        + "'" + pModelcompras_produtos.getNomeProduto()+ "',"
                        + "'" + pModelcompras_produtos.getNomeProdutoEstoque()+ "',"
                        + "'" + pModelcompras_produtos.getBarras()+ "',"
                        + "'" + pModelcompras_produtos.getNcm()+ "',"
                        + "'" + pModelcompras_produtos.getCst()+ "',"
                        + "'" + pModelcompras_produtos.getCfop()+ "',"
                        + "'" + pModelcompras_produtos.getCest()+ "',"
                        + "'" + (blMascaras.converterVirgulaParaPonto(pModelcompras_produtos.getPercCreditoSn()))+ "',"
                        + "'" + (blMascaras.converterVirgulaParaPonto(pModelcompras_produtos.getValorCreditoSn()))+ "',"
                        + "'" + pModelcompras_produtos.getBaseCalculoSub()+ "',"
                        + "'" + pModelcompras_produtos.getBaseCalculoicms()+ "',"
                        + "'" + pModelcompras_produtos.getPercIpi()+ "',"
                        + "'" + pModelcompras_produtos.getValorIpi()+ "',"
                        + "'" + pModelcompras_produtos.getCfopEstoque()+ "',"
                        + "'" + pModelcompras_produtos.getFatorConversao()+ "',"
                        + "'" + pModelcompras_produtos.getCodFornecedor()+ "',"
                        + "'" + pModelcompras_produtos.getValorCusto()+ "',"
                        + "'" + pModelcompras_produtos.getValorTotal()+ "',"
                        + "'" + pModelcompras_produtos.getOrdem()+ "',"
                        + "'" + pModelcompras_produtos.getQuantidade()+ "'"
                        + ");"
                );
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera compras_produtos
     *
     * @param pCodigo return Modelcompras_produtos
     */
    public ModelComprasProdutos getcompras_produtosDAO(int pCodigo) {
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"        
                    + "base_calc_icms,"        
                    + "valor_ipi,"
                    + "perc_ipi,"
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelcompras_produtos;
    }
    /**
     * recupera compras_produtos
     *
     * @param pCodigo return Modelcompras_produtos
     */
    public ModelComprasProdutos getcompras_produtos_codigoCompraDAO(int pCodigo) {
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"        
                    + "base_calc_icms,"        
                    + "valor_ipi,"
                    + "perc_ipi,"
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + " WHERE"
                    + " cod_compras = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelcompras_produtos;
    }
    
    /**
     * recupera compras_produtos
     *
     * @param pCodigo return Modelcompras_produtos
     * @param pCodigoFornecedor return Modelcompras_produtos
     * @return 
     */
    public ModelComprasProdutos getcompras_produtosDAOCodFor(String pCodigo, String pCodigoFornecedor) {
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"        
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"        
                    + "base_calc_icms,"        
                    + "valor_ipi,"
                    + "perc_ipi,"
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + " WHERE"
                    + " codProdutoFornecedor = '" + pCodigo + "'"
                    + "AND" 
                    + " codFornecedor = '" + pCodigoFornecedor + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelcompras_produtos;
    }

    /**
     * recupera uma lista de compras_produtos return ArrayList
     */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosDAO() {
        ArrayList<ModelComprasProdutos> listamodelcompras_produtos = new ArrayList();
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"        
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"                
                    + "base_calc_icms,"                
                    + "valor_ipi,"
                    + "perc_ipi,"
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos = new ModelComprasProdutos();
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
                listamodelcompras_produtos.add(modelcompras_produtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelcompras_produtos;
    }

    /**
     * recupera uma lista de compras_produtos return ArrayList
     */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosDAO(int pCodigo) {
        ArrayList<ModelComprasProdutos> listamodelcompras_produtos = new ArrayList();
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"                
                    + "base_calc_icms,"                
                    + "valor_ipi,"
                    + "perc_ipi,"                
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos where cod_compras = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos = new ModelComprasProdutos();
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
                listamodelcompras_produtos.add(modelcompras_produtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelcompras_produtos;
    }
    
    /**
     * recupera uma lista de compras_produtos por cfop return ArrayList
     */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosCFOPDAO(String pCfop, int pCodigo) {
        ArrayList<ModelComprasProdutos> listamodelcompras_produtos = new ArrayList();
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"                
                    + "base_calc_icms,"                
                    + "valor_ipi,"
                    + "perc_ipi,"                
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + " WHERE "
                 //   + " codProdutoFornecedor = '" + pCodigo + "'"
                 //   + "AND" 
                 //   + " codFornecedor = '" + pCodigoFornecedor + "'"        
                    +" cfopestoque = '" + pCfop + "'"
                    +"AND"
                    + " cod_compras = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos = new ModelComprasProdutos();
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
                listamodelcompras_produtos.add(modelcompras_produtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelcompras_produtos;
    }
    
    /**
     * recupera uma lista de compras_produtos por cfop return ArrayList
     */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosCSTDAO(String pAliquota, String pCfop, int pCodigo) {
        ArrayList<ModelComprasProdutos> listamodelcompras_produtos = new ArrayList();
        ModelComprasProdutos modelcompras_produtos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "codProdutoFornecedor,"
                    + "nomeProduto," 
                    + "nomeProdutoEstoque,"        
                    + "barras,"
                    + "ncm,"
                    + "cst,"
                    + "cfop,"
                    + "cest,"
                    + "perc_credito_sn,"
                    + "valor_credito_sn,"
                    + "base_calc_sub,"                
                    + "base_calc_icms,"                
                    + "valor_ipi,"
                    + "perc_ipi,"                
                    + "cfopestoque,"        
                    + "fatorConversao,"
                    + "codFornecedor,"
                    + "valor_custo,"
                    + "valor_total,"
                    + "ordem,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"        
                    + " WHERE "
                    +" cfopestoque = '" + pCfop + "'"
                    +"AND "
                    + " cod_compras = '" + pCodigo + "'"
                    +"AND "
                    + " perc_credito_sn = '" + pAliquota + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos = new ModelComprasProdutos();
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setCodProdutoFornecedor(this.getResultSet().getString(4));
                modelcompras_produtos.setNomeProduto(this.getResultSet().getString(5));
                modelcompras_produtos.setNomeProdutoEstoque(this.getResultSet().getString(6));
                modelcompras_produtos.setBarras(this.getResultSet().getString(7));
                modelcompras_produtos.setNcm(this.getResultSet().getString(8));
                modelcompras_produtos.setCst(this.getResultSet().getString(9));
                modelcompras_produtos.setCfop(this.getResultSet().getString(10));
                modelcompras_produtos.setCest(this.getResultSet().getString(11));
                modelcompras_produtos.setPercCreditoSn(this.getResultSet().getString(12));
                modelcompras_produtos.setValorCreditoSn(this.getResultSet().getString(13));
                modelcompras_produtos.setBaseCalculoSub(this.getResultSet().getString(14));
                modelcompras_produtos.setBaseCalculoicms(this.getResultSet().getString(15));
                modelcompras_produtos.setValorIpi(this.getResultSet().getString(16));
                modelcompras_produtos.setPercIpi(this.getResultSet().getString(17));
                modelcompras_produtos.setCfopEstoque(this.getResultSet().getString(18));
                modelcompras_produtos.setFatorConversao(this.getResultSet().getString(19));
                modelcompras_produtos.setCodFornecedor(this.getResultSet().getString(20));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(21));
                modelcompras_produtos.setValorTotal(this.getResultSet().getDouble(22));
                modelcompras_produtos.setOrdem(this.getResultSet().getInt(23));
                modelcompras_produtos.setQuantidade(this.getResultSet().getFloat(24));
                listamodelcompras_produtos.add(modelcompras_produtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelcompras_produtos;
    }

    /**
     * atualiza compras_produtos
     *
     * @param pModelcompras_produtos return boolean
     * @return 
     */
    public boolean atualizarcompras_produtosDAO(ModelComprasProdutos pModelcompras_produtos) {
        try {
           conectar();
           executarUpdateDeleteSQL(
                    "UPDATE compras_produtos SET "
                    + "codigo = '" + pModelcompras_produtos.getCodigo() + "',"
                    + "cod_compras = '" + pModelcompras_produtos.getCodCompras() + "',"
                    + "cod_produto = '" + pModelcompras_produtos.getCodProduto() + "',"
                    + "codProdutoFornecedor = '" + pModelcompras_produtos.getCodProdutoFornecedor()+ "',"
                    + "nomeProduto = '" + pModelcompras_produtos.getNomeProduto() + "',"
                    + "nomeProdutoEstoque = '" + pModelcompras_produtos.getNomeProdutoEstoque()+ "',"
                    + "barras = '" + pModelcompras_produtos.getBarras() + "',"
                    + "ncm = '" + pModelcompras_produtos.getNcm() + "',"
                    + "cst = '" + pModelcompras_produtos.getCst() + "',"
                    + "cfop = '" + pModelcompras_produtos.getCfop() + "',"
                    + "cest = '" + pModelcompras_produtos.getCest() + "',"
                    + "perc_credito_sn = '" + pModelcompras_produtos.getPercCreditoSn() + "',"
                    + "valor_credito_sn = '" + pModelcompras_produtos.getValorCreditoSn() + "',"
                    + "base_calc_sub = ,"         + pModelcompras_produtos.getBaseCalculoSub() + "',"
                    + "base_calc_icms = ,"         + pModelcompras_produtos.getBaseCalculoicms()+ "',"
                    + "valor_ipi = '" + pModelcompras_produtos.getValorIpi() + "',"
                    + "perc_ipi = '" + pModelcompras_produtos.getPercIpi() + "',"
                    + "cfopestoque = '" + pModelcompras_produtos.getCfopEstoque()+ "',"
                    + "fatorConversao = '" + pModelcompras_produtos.getFatorConversao() + "',"
                    + "codFornecedor = '" + pModelcompras_produtos.getCodFornecedor() + "',"
                    + "valor_custo = '" + pModelcompras_produtos.getValorCusto() + "',"
                    + "valor_total = '" + pModelcompras_produtos.getValorTotal()+ "',"
                    + "ordem = '" + pModelcompras_produtos.getOrdem()+ "',"
                    + "quantidade = '" + pModelcompras_produtos.getQuantidade() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelcompras_produtos.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
    /**
     * atualiza compras_produtos
     *
     * @param pModelcompras_produtos return boolean
     * @return 
     */
    public boolean atualizarcompras_produtosCfopDAO(ModelComprasProdutos pModelcompras_produtos) {
        try {
           conectar();
           executarUpdateDeleteSQL(
                    "UPDATE compras_produtos SET "
                    + "cst = '" + pModelcompras_produtos.getCst() + "',"
                    + "cfopestoque = '" + pModelcompras_produtos.getCfopEstoque()+ "',"
                    + "fatorConversao = '" + pModelcompras_produtos.getFatorConversao() + "',"
                    + "valor_custo = '" + pModelcompras_produtos.getValorCusto() + "',"
                    + "valor_total = '" + pModelcompras_produtos.getValorTotal()+ "',"
                    + "ordem = '" + pModelcompras_produtos.getOrdem()+ "',"
                    + "quantidade = '" + pModelcompras_produtos.getQuantidade() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelcompras_produtos.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui compras_produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluircompras_produtosDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM compras_produtos "
                    + " WHERE "
                    + "cod_compras = '" + pCodigo + "'"
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
