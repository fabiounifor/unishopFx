package DAO;

import conexoes.ConexaoMySql;
import model.ModelProdutos;
import java.util.ArrayList;
import javafx.scene.control.Hyperlink;
import model.ModelComprasProdutosTabela;

/**
 *
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class DAOProdutos extends ConexaoMySql {

    /**
     * grava Produtos
     *
     * @param pModelProdutos return int
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO produtos ("
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"        
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"        
                    + "tribEst,"        
                    + "tribFed,"  
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor," 
                    + "observacao," 
                    + "lucro"         
                    + ") VALUES ("
                    + "'" + pModelProdutos.getFornecedoresCodigo() + "',"
                    + "'" + pModelProdutos.getNome() + "',"
                    + "'" + pModelProdutos.getDescricaoProduto() + "',"
                    + "'" + pModelProdutos.getValor() + "',"
                    + "'" + pModelProdutos.getValorCusto() + "',"
                    + "'" + pModelProdutos.getCodigoBarrasEan() + "',"
                    + "'" + pModelProdutos.getEstoque() + "',"
                    + "'" + pModelProdutos.getImagemProduto() + "',"
                    + "'" + pModelProdutos.getAtivo() + "',"
                    + "'" + pModelProdutos.getMarca() + "',"
                    + "'" + pModelProdutos.getDiasGarantia() + "',"
                    + "'" + pModelProdutos.getUnidadeMedida() + "',"
                    + "'" + pModelProdutos.getOrigem() + "',"
                    + "'" + pModelProdutos.getPeso() + "',"
                    + "'" + pModelProdutos.getNcm() + "',"
                    + "'" + pModelProdutos.getCst() + "',"
                    + "'" + pModelProdutos.getTipoNcm() + "',"
                    + "'" + pModelProdutos.getIcms() + "',"
                    + "'" + pModelProdutos.getIpi() + "',"
                    + "'" + pModelProdutos.getValorIpi()+ "',"
                    + "'" + pModelProdutos.getPis() + "',"
                    + "'" + pModelProdutos.getCofins() + "',"
                    + "'" + pModelProdutos.getGrupo() + "',"
                    + "'" + pModelProdutos.getTipo()+ "',"
                    + "'" + pModelProdutos.getCest()+ "',"
                    + "'" + pModelProdutos.getTipoCest()+ "',"
                    + "'" + pModelProdutos.getComposicao()+ "',"
                    + "'" + pModelProdutos.getFracionado()+ "',"
                    + "'" + pModelProdutos.getBalanca()+ "',"
                    + "'" + pModelProdutos.getConversao() + "',"
                    + "'" + pModelProdutos.getUniFisco()+ "',"
                    + "'" + pModelProdutos.getTribEst()+ "',"
                    + "'" + pModelProdutos.getTribFed()+ "',"
                    + "'" + pModelProdutos.getTribStPerc()+ "',"
                    + "'" + pModelProdutos.getCodProdutoAnp()+ "',"
                    + "'" + pModelProdutos.getDescricaoAnp()+ "',"
                    + "'" + pModelProdutos.getPercGlp()+ "',"
                    + "'" + pModelProdutos.getPercGnn()+ "',"
                    + "'" + pModelProdutos.getPercGni()+ "',"
                    + "'" + pModelProdutos.getValorProdutoGlp()+ "',"
                    + "'" + pModelProdutos.getEstadoConsumidor()+ "',"
                    + "'" + pModelProdutos.getObservacao()+ "',"
                    + "'" + pModelProdutos.getLucro() + "'"
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
     * recupera Produtos
     *
     * @param pCodigo return ModelProdutos
     */
    public ModelProdutos getProdutosDAO(int pCodigo) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"        
                    + "tribEst,"        
                    + "tribFed,"        
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor," 
                    + "observacao," 
                    + "lucro"        
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
               modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setCofins(this.getResultSet().getString(23));
                modelProdutos.setGrupo(this.getResultSet().getInt(24));
                modelProdutos.setTipo(this.getResultSet().getInt(25));
                modelProdutos.setCest(this.getResultSet().getString(26));
                modelProdutos.setTipoCest(this.getResultSet().getString(27));
                modelProdutos.setComposicao(this.getResultSet().getInt(28));
                modelProdutos.setFracionado(this.getResultSet().getInt(29));
                modelProdutos.setBalanca(this.getResultSet().getInt(30));
                modelProdutos.setConversao(this.getResultSet().getInt(31));
                modelProdutos.setUniFisco(this.getResultSet().getInt(32));
                modelProdutos.setTribEst(this.getResultSet().getInt(33));
                modelProdutos.setTribFed(this.getResultSet().getInt(34));
                modelProdutos.setTribStPerc(this.getResultSet().getInt(35));
                modelProdutos.setCodProdutoAnp(this.getResultSet().getString(36));
                modelProdutos.setDescricaoAnp(this.getResultSet().getString(37));
                modelProdutos.setPercGlp(this.getResultSet().getInt(38));
                modelProdutos.setPercGnn(this.getResultSet().getInt(39));
                modelProdutos.setPercGni(this.getResultSet().getInt(40));
                modelProdutos.setValorProdutoGlp(this.getResultSet().getDouble(41));
                modelProdutos.setEstadoConsumidor(this.getResultSet().getString(42));
                modelProdutos.setObservacao(this.getResultSet().getString(43));
                modelProdutos.setLucro(this.getResultSet().getInt(44));
                                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    
    
    /**
     * recupera Produtos
     *
     * @param pCodigo return ModelProdutos
     */
    public ModelProdutos getProdutosDAOCodigo(int pCodigo) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"        
                    + "tribEst,"        
                    + "tribFed,"        
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor," 
                    + "observacao," 
                    + "lucro"        
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
               modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setCofins(this.getResultSet().getString(23));
                modelProdutos.setGrupo(this.getResultSet().getInt(24));
                modelProdutos.setTipo(this.getResultSet().getInt(25));
                modelProdutos.setCest(this.getResultSet().getString(26));
                modelProdutos.setTipoCest(this.getResultSet().getString(27));
                modelProdutos.setComposicao(this.getResultSet().getInt(28));
                modelProdutos.setFracionado(this.getResultSet().getInt(29));
                modelProdutos.setBalanca(this.getResultSet().getInt(30));
                modelProdutos.setConversao(this.getResultSet().getInt(31));
                modelProdutos.setUniFisco(this.getResultSet().getInt(32));
                modelProdutos.setTribEst(this.getResultSet().getInt(33));
                modelProdutos.setTribFed(this.getResultSet().getInt(34));
                modelProdutos.setTribStPerc(this.getResultSet().getInt(35));
                modelProdutos.setCodProdutoAnp(this.getResultSet().getString(36));
                modelProdutos.setDescricaoAnp(this.getResultSet().getString(37));
                modelProdutos.setPercGlp(this.getResultSet().getInt(38));
                modelProdutos.setPercGnn(this.getResultSet().getInt(39));
                modelProdutos.setPercGni(this.getResultSet().getInt(40));
                modelProdutos.setValorProdutoGlp(this.getResultSet().getDouble(41));
                modelProdutos.setEstadoConsumidor(this.getResultSet().getString(42));
                modelProdutos.setObservacao(this.getResultSet().getString(43));
                modelProdutos.setLucro(this.getResultSet().getInt(44));
                                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    

    /**
     * recupera Produtos
     *
     * @param pNome return ModelProdutos
     */
    public ModelProdutos getProdutosDAO(String pNome) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"
                    + "tribEst,"        
                    + "tribFed,"         
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"         
                    + "observacao," 
                    + "lucro"                
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setCofins(this.getResultSet().getString(23));
                modelProdutos.setGrupo(this.getResultSet().getInt(24));
                modelProdutos.setTipo(this.getResultSet().getInt(25));
                modelProdutos.setCest(this.getResultSet().getString(26));
                modelProdutos.setTipoCest(this.getResultSet().getString(27));
                modelProdutos.setComposicao(this.getResultSet().getInt(28));
                modelProdutos.setFracionado(this.getResultSet().getInt(29));
                modelProdutos.setBalanca(this.getResultSet().getInt(30));
                modelProdutos.setConversao(this.getResultSet().getInt(31));
                modelProdutos.setUniFisco(this.getResultSet().getInt(32));
                modelProdutos.setTribEst(this.getResultSet().getInt(33));
                modelProdutos.setTribFed(this.getResultSet().getInt(34));
                modelProdutos.setTribStPerc(this.getResultSet().getInt(35));
                modelProdutos.setCodProdutoAnp(this.getResultSet().getString(36));
                modelProdutos.setDescricaoAnp(this.getResultSet().getString(37));
                modelProdutos.setPercGlp(this.getResultSet().getInt(38));
                modelProdutos.setPercGnn(this.getResultSet().getInt(39));
                modelProdutos.setPercGni(this.getResultSet().getInt(40));
                modelProdutos.setValorProdutoGlp(this.getResultSet().getDouble(41));
                modelProdutos.setEstadoConsumidor(this.getResultSet().getString(42));
                modelProdutos.setObservacao(this.getResultSet().getString(43));
                modelProdutos.setLucro(this.getResultSet().getInt(44));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutosDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"        
                    + "tribEst,"        
                    + "tribFed,"        
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"         
                    + "observacao," 
                    + "lucro"                
                    + " FROM"
                    + " produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setCofins(this.getResultSet().getString(23));
                modelProdutos.setGrupo(this.getResultSet().getInt(24));
                modelProdutos.setTipo(this.getResultSet().getInt(25));
                modelProdutos.setCest(this.getResultSet().getString(26));
                modelProdutos.setTipoCest(this.getResultSet().getString(27));
                modelProdutos.setComposicao(this.getResultSet().getInt(28));
                modelProdutos.setFracionado(this.getResultSet().getInt(29));
                modelProdutos.setBalanca(this.getResultSet().getInt(30));
                modelProdutos.setConversao(this.getResultSet().getInt(31));
                modelProdutos.setUniFisco(this.getResultSet().getInt(32));
                modelProdutos.setTribEst(this.getResultSet().getInt(33));
                modelProdutos.setTribFed(this.getResultSet().getInt(34));
                modelProdutos.setTribStPerc(this.getResultSet().getInt(35));
                modelProdutos.setCodProdutoAnp(this.getResultSet().getString(36));
                modelProdutos.setDescricaoAnp(this.getResultSet().getString(37));
                modelProdutos.setPercGlp(this.getResultSet().getInt(38));
                modelProdutos.setPercGnn(this.getResultSet().getInt(39));
                modelProdutos.setPercGni(this.getResultSet().getInt(40));
                modelProdutos.setValorProdutoGlp(this.getResultSet().getDouble(41));
                modelProdutos.setEstadoConsumidor(this.getResultSet().getString(42));
                modelProdutos.setObservacao(this.getResultSet().getString(43));
                modelProdutos.setLucro(this.getResultSet().getInt(44));
                modelProdutos.setLinkModelEditar(new Hyperlink());
                modelProdutos.setLinkModelDuplicar(new Hyperlink());
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutosAtivosDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"        
                    + "tribEst,"        
                    + "tribFed,"        
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"         
                    + "observacao," 
                    + "lucro"               
                    + " FROM"
                    + " produtos "
                    + "WHERE ativo = 1"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setCofins(this.getResultSet().getString(23));
                modelProdutos.setGrupo(this.getResultSet().getInt(24));
                modelProdutos.setTipo(this.getResultSet().getInt(25));
                modelProdutos.setCest(this.getResultSet().getString(26));
                modelProdutos.setTipoCest(this.getResultSet().getString(27));
                modelProdutos.setComposicao(this.getResultSet().getInt(28));
                modelProdutos.setFracionado(this.getResultSet().getInt(29));
                modelProdutos.setBalanca(this.getResultSet().getInt(30));
                modelProdutos.setConversao(this.getResultSet().getInt(31));
                modelProdutos.setUniFisco(this.getResultSet().getInt(32));
                modelProdutos.setTribEst(this.getResultSet().getInt(33));
                modelProdutos.setTribFed(this.getResultSet().getInt(34));
                modelProdutos.setTribStPerc(this.getResultSet().getInt(35));
                modelProdutos.setCodProdutoAnp(this.getResultSet().getString(36));
                modelProdutos.setDescricaoAnp(this.getResultSet().getString(37));
                modelProdutos.setPercGlp(this.getResultSet().getInt(38));
                modelProdutos.setPercGnn(this.getResultSet().getInt(39));
                modelProdutos.setPercGni(this.getResultSet().getInt(40));
                modelProdutos.setValorProdutoGlp(this.getResultSet().getDouble(41));
                modelProdutos.setEstadoConsumidor(this.getResultSet().getString(42));
                modelProdutos.setObservacao(this.getResultSet().getString(43));
                modelProdutos.setLucro(this.getResultSet().getInt(44));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }
    
    public ArrayList<ModelProdutos> getCbListaProdutosAtivosDAo(){
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "observacao,"
                    + "cofins"
                    + " FROM"
                    + " produtos "
               //     + "WHERE ativo = 1"
                    + "ORDER BY nome ASC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setObservacao(this.getResultSet().getString(23));
                modelProdutos.setCofins(this.getResultSet().getString(24));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }
    

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "fornecedores_codigo = '" + pModelProdutos.getFornecedoresCodigo() + "',"
                    + "nome = '" + pModelProdutos.getNome() + "',"
                    + "descricao_produto = '" + pModelProdutos.getDescricaoProduto()+ "',"
                    + "codigo_barras_ean = '" + pModelProdutos.getCodigoBarrasEan() + "',"
                    + "unidade_medida = '" + pModelProdutos.getUnidadeMedida() + "',"
                    + "ativo = '" + pModelProdutos.getAtivo() + "',"
                    + "estoque = '" + pModelProdutos.getEstoque() + "',"
                    + "origem = '" + pModelProdutos.getOrigem() + "',"
                    + "valor = '" + pModelProdutos.getValor() + "',"
                    + "valor_custo = '" + pModelProdutos.getValorCusto()+ "',"
                    + "imagem_produto = '" + pModelProdutos.getImagemProduto() + "',"
                    + "marca = '" + pModelProdutos.getMarca() + "',"
                    + "dias_garantia = '" + pModelProdutos.getDiasGarantia() + "',"
                    + "unidade_medida = '" + pModelProdutos.getUnidadeMedida()+ "',"
                    + "peso = '" + pModelProdutos.getPeso() + "',"
                    + "ncm = '" + pModelProdutos.getNcm()+ "',"
                    + "cst = '" + pModelProdutos.getCst()+ "',"
                    + "tipo_ncm = '"+ pModelProdutos.getTipoNcm()+ "',"
                    + "icms = '" + pModelProdutos.getIcms()+ "',"
                    + "ipi = '"  + pModelProdutos.getIpi()+ "',"
                    + "valor_ipi = '"  + pModelProdutos.getValorIpi()+ "',"
                    + "pis = '"  + pModelProdutos.getPis()+ "',"
                    + "cofins = '"  + pModelProdutos.getCofins()+ "',"
                    + "grupo = '"  + pModelProdutos.getGrupo()+ "',"
                    + "tipo = '"  + pModelProdutos.getTipo()+ "',"
                    + "cest = '"  + pModelProdutos.getCest() + "',"
                    + "tipoCest= '"  + pModelProdutos.getTipoCest()+ "',"
                    + "composicao= '"  + pModelProdutos.getComposicao() + "',"
                    + "fracionado= '"  + pModelProdutos.getComposicao() + "',"
                    + "balanca= '"  + pModelProdutos.getBalanca() + "',"
                    + "conversao= '"  + pModelProdutos.getConversao() + "',"
                    + "uniFisco= '"  + pModelProdutos.getUniFisco() + "',"
                    + "tribEst= '"  + pModelProdutos.getTribEst() + "',"
                    + "tribFed= '"  + pModelProdutos.getTribFed() + "',"
                    + "trib_st_perc= '"  + pModelProdutos.getTribStPerc() + "',"
                    + "cod_produto_anp= '"  + pModelProdutos.getCodProdutoAnp() + "',"
                    + "descricao_anp= '"  + pModelProdutos.getDescricaoAnp() + "',"
                    + "perc_glp= '"  + pModelProdutos.getPercGlp() + "',"
                    + "perc_gnn= '"  + pModelProdutos.getPercGnn() + "',"
                    + "perc_gni= '"  + pModelProdutos.getPercGni() + "',"
                    + "valor_produto_glp= '"  + pModelProdutos.getValorProdutoGlp() + "',"
                    + "estado_consumidor= '"  + pModelProdutos.getEstadoConsumidor() + "',"
                    + "observacao= '"  + pModelProdutos.getObservacao() + "',"
                    + "lucro= '"  + pModelProdutos.getLucro()+ "'"
                            
                    + " WHERE "
                    + "codigo = '" + pModelProdutos.getCodigo() + "'"
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
     * exclui Produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluirProdutosDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM produtos "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Tentativa de violar uma chave");
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            int sizeLista = pModelProdutos.getListaModelProdutoses().size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pModelProdutos.getListaModelProdutoses().get(i).getEstoque() + "'"
                        + " WHERE "
                        + "codigo = '" + pModelProdutos.getListaModelProdutoses().get(i).getCodigo() + "'"
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

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeValorDAO(ArrayList<ModelComprasProdutosTabela> pListaComprasProdutos) {
        try {
            this.conectar();
            int sizeLista = pListaComprasProdutos.size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pListaComprasProdutos.get(i).getModelProdutos().getAddEstoque() + "',"
                        + "valor_custo = '" + pListaComprasProdutos.get(i).getModelProdutos().getValorCusto() + "',"
                        + "valor = '" + pListaComprasProdutos.get(i).getModelProdutos().getValor() + "',"
                        + "ncm = '" + pListaComprasProdutos.get(i).getModelProdutos().getNcm() + "',"
                        + "tipo_ncm = '" + pListaComprasProdutos.get(i).getModelProdutos().getTipoNcm() + "',"
                        + "icms = '" + pListaComprasProdutos.get(i).getModelProdutos().getIcms() + "',"
                        + "ipi = '" + pListaComprasProdutos.get(i).getModelProdutos().getIpi() + "',"
                        + "pis = '" + pListaComprasProdutos.get(i).getModelProdutos().getPis() + "',"
                        + "cofins = '" + pListaComprasProdutos.get(i).getModelProdutos().getCofins() + "'"
                        + " WHERE "
                        + "codigo = '" + pListaComprasProdutos.get(i).getModelProdutos().getCodigo() + "'"
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

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarPrecoEstoqueProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "estoque = '" + pModelProdutos.getEstoque() + "',"
                    + "valor_custo = '" + pModelProdutos.getValorCusto() + "',"
                    + "valor = '" + pModelProdutos.getValor() + "',"
                    + "ncm = '" + pModelProdutos.getNcm() + "',"
                    + "tipo_ncm = '" + pModelProdutos.getTipoNcm() + "',"
                    + "icms = '" + pModelProdutos.getIcms() + "',"
                    + "ipi = '" + pModelProdutos.getIpi() + "',"
                    + "pis = '" + pModelProdutos.getPis() + "',"
                    + "cofins = '" + pModelProdutos.getCofins() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelProdutos.getCodigo() + "'"
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
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosEstoqueDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            int sizeLista = pModelProdutos.getListaModelProdutoses().size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pModelProdutos.getListaModelProdutoses().get(i).getEstoque() + "'"
                        + " WHERE "
                        + "codigo = '" + pModelProdutos.getListaModelProdutoses().get(i).getCodigo() + "'"
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

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeUmDAO(int pCodigo, float pQuantidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "estoque = '" + pQuantidade + "'"
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

    public ModelProdutos getProdutosCodigoBarrasDAO(String pCodigoBarras) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "cst,"
                    + "tipo_ncm,"
                    + "icms,"
                    + "ipi,"
                    + "valor_ipi,"
                    + "pis,"
                    + "cofins,"
                    + "grupo,"
                    + "tipo,"
                    + "cest,"
                    + "tipoCest,"
                    + "composicao,"
                    + "fracionado,"
                    + "balanca,"
                    + "conversao,"
                    + "uniFisco,"        
                    + "tribEst,"        
                    + "tribFed," 
                    + "trib_st_perc," 
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"                 
                    + "observacao," 
                    + "lucro"                
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo_barras_ean = '" + pCodigoBarras + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getDouble(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setCst(this.getResultSet().getString(17));
                modelProdutos.setTipoNcm(this.getResultSet().getString(18));
                modelProdutos.setIcms(this.getResultSet().getString(19));
                modelProdutos.setIpi(this.getResultSet().getString(20));
                modelProdutos.setValorIpi(this.getResultSet().getString(21));
                modelProdutos.setPis(this.getResultSet().getString(22));
                modelProdutos.setCofins(this.getResultSet().getString(23));
                modelProdutos.setGrupo(this.getResultSet().getInt(24));
                modelProdutos.setTipo(this.getResultSet().getInt(25));
                modelProdutos.setCest(this.getResultSet().getString(26));
                modelProdutos.setTipoCest(this.getResultSet().getString(27));
                modelProdutos.setComposicao(this.getResultSet().getInt(28));
                modelProdutos.setFracionado(this.getResultSet().getInt(29));
                modelProdutos.setBalanca(this.getResultSet().getInt(30));
                modelProdutos.setConversao(this.getResultSet().getInt(31));
                modelProdutos.setUniFisco(this.getResultSet().getInt(32));
                modelProdutos.setTribEst(this.getResultSet().getInt(33));
                modelProdutos.setTribFed(this.getResultSet().getInt(34));
                modelProdutos.setTribStPerc(this.getResultSet().getInt(35));
                modelProdutos.setCodProdutoAnp(this.getResultSet().getString(36));
                modelProdutos.setDescricaoAnp(this.getResultSet().getString(37));
                modelProdutos.setPercGlp(this.getResultSet().getInt(38));
                modelProdutos.setPercGnn(this.getResultSet().getInt(39));
                modelProdutos.setPercGni(this.getResultSet().getInt(40));
                modelProdutos.setValorProdutoGlp(this.getResultSet().getDouble(41));
                modelProdutos.setEstadoConsumidor(this.getResultSet().getString(42));
                modelProdutos.setObservacao(this.getResultSet().getString(43));
                modelProdutos.setLucro(this.getResultSet().getInt(44));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
}
