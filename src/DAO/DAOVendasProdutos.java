package DAO;

import model.ModelVendasProdutos;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAOVendasProdutos extends ConexaoMySql {

    /**
    * grava VendasProdutos
    * @param pModelVendasProdutos
    * return int
    */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos){
         try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO vendas_produto ("
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "tipo, "    
                    + "opcoes_escolhidas, "
                    + "total "
                + ") VALUES ("
                    + "'" + pModelVendasProdutos.getCodigo() + "',"
                    + "'" + pModelVendasProdutos.getCodigo_produto() + "',"
                    + "'" + pModelVendasProdutos.getCodigo_venda() + "',"
                    + "'" + pModelVendasProdutos.getQuantidade() + "',"
                    + "'" + pModelVendasProdutos.getValorUnitario()+ "',"
                    + "'" + pModelVendasProdutos.getCfop()+ "',"
                    + "'" + pModelVendasProdutos.getNcm()+ "',"
                    + "'" + pModelVendasProdutos.getSubTribut()+ "',"
                    + "'" + pModelVendasProdutos.getIcmsCst()+ "',"
                    + "'" + pModelVendasProdutos.getIcmsRed()+ "',"
                    + "'" + pModelVendasProdutos.getIpiCst()+ "',"
                    + "'" + pModelVendasProdutos.getPisCst()+ "',"
                    + "'" + pModelVendasProdutos.getCofinsCst()+ "',"
                    + "'" + pModelVendasProdutos.getNomeProduto()+ "',"
                    + "'" + pModelVendasProdutos.getUnidade()+ "',"
                    + "'" + pModelVendasProdutos.getPercIcms()+ "',"
                    + "'" + pModelVendasProdutos.getDesconto()+ "',"
                    + "'" + pModelVendasProdutos.getOrdem()+ "',"
                    + "'" + pModelVendasProdutos.getCodProdutoAnp()+ "',"
                    + "'" + pModelVendasProdutos.getDescricaoAnp()+ "',"
                    + "'" + pModelVendasProdutos.getPercGlp()+ "',"
                    + "'" + pModelVendasProdutos.getPercGnn()+ "',"
                    + "'" + pModelVendasProdutos.getPercGni()+ "',"
                    + "'" + pModelVendasProdutos.getValorProdutoGlp()+ "',"
                    + "'" + pModelVendasProdutos.getEstadoConsumidor()+ "',"        
                    + "'" + pModelVendasProdutos.getObservacao()+ "',"
                    + "'" + pModelVendasProdutos.getTipo()+ "',"
                    + "'" + pModelVendasProdutos.getOpcoesEscolhidas()+ "',"
                    + "'" + pModelVendasProdutos.getValorTotal()+ "'"
                            
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
    * recupera VendasProdutos
    * @param pCodigo
    * return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasProdutosDAO(int pCodigo){
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "opcoes_escolhidas, "    
                    + "tipo, "        
                    + "total "
                 + " FROM"
                     + " vendas_produto"
                 + " WHERE"
                     + " codigo_venda = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                modelVendasProdutos.setCfop(this.getResultSet().getString(6));
                modelVendasProdutos.setNcm(this.getResultSet().getString(7));
                modelVendasProdutos.setSubTribut(this.getResultSet().getDouble(8));
                modelVendasProdutos.setIcmsCst(this.getResultSet().getString(9));
                modelVendasProdutos.setIcmsRed(this.getResultSet().getDouble(10));
                modelVendasProdutos.setIpiCst(this.getResultSet().getString(11));
                modelVendasProdutos.setPisCst(this.getResultSet().getString(12));
                modelVendasProdutos.setCofinsCst(this.getResultSet().getString(13));
                modelVendasProdutos.setNomeProduto(this.getResultSet().getString(14));
                modelVendasProdutos.setUnidade(this.getResultSet().getString(15));
                modelVendasProdutos.setPercIcms(this.getResultSet().getFloat(16));
                modelVendasProdutos.setDesconto(this.getResultSet().getFloat(17));
                modelVendasProdutos.setOrdem(this.getResultSet().getInt(18));
                modelVendasProdutos.setCodProdutoAnp(this.getResultSet().getString(19));
                modelVendasProdutos.setDescricaoAnp(this.getResultSet().getString(20));
                modelVendasProdutos.setPercGlp(this.getResultSet().getInt(21));
                modelVendasProdutos.setPercGnn(this.getResultSet().getInt(22));
                modelVendasProdutos.setPercGni(this.getResultSet().getInt(23));
                modelVendasProdutos.setValorProdutoGlp(this.getResultSet().getDouble(24));
                modelVendasProdutos.setEstadoConsumidor(this.getResultSet().getString(25));
                modelVendasProdutos.setObservacao(this.getResultSet().getString(26));
                modelVendasProdutos.setOpcoesEscolhidas(this.getResultSet().getString(27));
                modelVendasProdutos.setTipo(this.getResultSet().getInt(28));
                modelVendasProdutos.setValorTotal(this.getResultSet().getFloat(29));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }
    
        /**
    * recupera VendasProdutos
    * @param pCodigo
    * return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasCodigoVendasProdutosDAO(int pCodigo){
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "opcoes_escolhidas, "    
                    + "tipo, "    
                    + "total "
                 + " FROM"
                     + " vendas_produto"
                 + " WHERE"
                     + " codigo_venda = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                modelVendasProdutos.setCfop(this.getResultSet().getString(6));
                modelVendasProdutos.setNcm(this.getResultSet().getString(7));
                modelVendasProdutos.setSubTribut(this.getResultSet().getDouble(8));
                modelVendasProdutos.setIcmsCst(this.getResultSet().getString(9));
                modelVendasProdutos.setIcmsRed(this.getResultSet().getDouble(10));
                modelVendasProdutos.setIpiCst(this.getResultSet().getString(11));
                modelVendasProdutos.setPisCst(this.getResultSet().getString(12));
                modelVendasProdutos.setCofinsCst(this.getResultSet().getString(13));
                modelVendasProdutos.setNomeProduto(this.getResultSet().getString(14));
                modelVendasProdutos.setUnidade(this.getResultSet().getString(15));
                modelVendasProdutos.setPercIcms(this.getResultSet().getFloat(16));
                modelVendasProdutos.setDesconto(this.getResultSet().getFloat(17));
                modelVendasProdutos.setOrdem(this.getResultSet().getInt(18));
                modelVendasProdutos.setCodProdutoAnp(this.getResultSet().getString(19));
                modelVendasProdutos.setDescricaoAnp(this.getResultSet().getString(20));
                modelVendasProdutos.setPercGlp(this.getResultSet().getInt(21));
                modelVendasProdutos.setPercGnn(this.getResultSet().getInt(22));
                modelVendasProdutos.setPercGni(this.getResultSet().getInt(23));
                modelVendasProdutos.setValorProdutoGlp(this.getResultSet().getDouble(24));
                modelVendasProdutos.setEstadoConsumidor(this.getResultSet().getString(25));
                modelVendasProdutos.setObservacao(this.getResultSet().getString(26));
                modelVendasProdutos.setOpcoesEscolhidas(this.getResultSet().getString(27));
                modelVendasProdutos.setTipo(this.getResultSet().getInt(28));
                modelVendasProdutos.setValorTotal(this.getResultSet().getFloat(29));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
    * recupera uma lista de VendasProdutos
        * return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO(){
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "opcoes_escolhidas, "    
                    + "tipo, "    
                    + "total "
                 + " FROM"
                     + " vendas_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                modelVendasProdutos.setCfop(this.getResultSet().getString(6));
                modelVendasProdutos.setNcm(this.getResultSet().getString(7));
                modelVendasProdutos.setSubTribut(this.getResultSet().getDouble(8));
                modelVendasProdutos.setIcmsCst(this.getResultSet().getString(9));
                modelVendasProdutos.setIcmsRed(this.getResultSet().getDouble(10));
                modelVendasProdutos.setIpiCst(this.getResultSet().getString(11));
                modelVendasProdutos.setPisCst(this.getResultSet().getString(12));
                modelVendasProdutos.setCofinsCst(this.getResultSet().getString(13));
                modelVendasProdutos.setNomeProduto(this.getResultSet().getString(14));
                modelVendasProdutos.setUnidade(this.getResultSet().getString(15));
                modelVendasProdutos.setPercIcms(this.getResultSet().getFloat(16));
                modelVendasProdutos.setDesconto(this.getResultSet().getFloat(17));
                modelVendasProdutos.setOrdem(this.getResultSet().getInt(18));
                modelVendasProdutos.setCodProdutoAnp(this.getResultSet().getString(19));
                modelVendasProdutos.setDescricaoAnp(this.getResultSet().getString(20));
                modelVendasProdutos.setPercGlp(this.getResultSet().getInt(21));
                modelVendasProdutos.setPercGnn(this.getResultSet().getInt(22));
                modelVendasProdutos.setPercGni(this.getResultSet().getInt(23));
                modelVendasProdutos.setValorProdutoGlp(this.getResultSet().getDouble(24));
                modelVendasProdutos.setEstadoConsumidor(this.getResultSet().getString(25));
                modelVendasProdutos.setObservacao(this.getResultSet().getString(26));
                modelVendasProdutos.setOpcoesEscolhidas(this.getResultSet().getString(27));
                modelVendasProdutos.setTipo(this.getResultSet().getInt(28));
                modelVendasProdutos.setValorTotal(this.getResultSet().getFloat(29));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }
    
    /**
    * recupera uma lista de VendasProdutos
        * return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasCodigoProdutosDAO(int pCodigoProduto){
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "opcoes_escolhidas, "
                    + "tipo, "
                    + "total "
                 + " FROM"
                     + " vendas_produto WHERE codigo_produto = '"+pCodigoProduto+"'"
                        
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                modelVendasProdutos.setCfop(this.getResultSet().getString(6));
                modelVendasProdutos.setNcm(this.getResultSet().getString(7));
                modelVendasProdutos.setSubTribut(this.getResultSet().getDouble(8));
                modelVendasProdutos.setIcmsCst(this.getResultSet().getString(9));
                modelVendasProdutos.setIcmsRed(this.getResultSet().getDouble(10));
                modelVendasProdutos.setIpiCst(this.getResultSet().getString(11));
                modelVendasProdutos.setPisCst(this.getResultSet().getString(12));
                modelVendasProdutos.setCofinsCst(this.getResultSet().getString(13));
                modelVendasProdutos.setNomeProduto(this.getResultSet().getString(14));
                modelVendasProdutos.setUnidade(this.getResultSet().getString(15));
                modelVendasProdutos.setPercIcms(this.getResultSet().getFloat(16));
                modelVendasProdutos.setDesconto(this.getResultSet().getFloat(17));
                modelVendasProdutos.setOrdem(this.getResultSet().getInt(18));
                modelVendasProdutos.setCodProdutoAnp(this.getResultSet().getString(19));
                modelVendasProdutos.setDescricaoAnp(this.getResultSet().getString(20));
                modelVendasProdutos.setPercGlp(this.getResultSet().getInt(21));
                modelVendasProdutos.setPercGnn(this.getResultSet().getInt(22));
                modelVendasProdutos.setPercGni(this.getResultSet().getInt(23));
                modelVendasProdutos.setValorProdutoGlp(this.getResultSet().getDouble(24));
                modelVendasProdutos.setEstadoConsumidor(this.getResultSet().getString(25));
                modelVendasProdutos.setObservacao(this.getResultSet().getString(26));
                modelVendasProdutos.setOpcoesEscolhidas(this.getResultSet().getString(27));
                modelVendasProdutos.setTipo(this.getResultSet().getInt(28));
                modelVendasProdutos.setValorTotal(this.getResultSet().getFloat(29));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
    * atualiza VendasProdutos
    * @param pModelVendasProdutos
    * return boolean
    */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE vendas_produto SET "
                    + "codigo = '" + pModelVendasProdutos.getCodigo() + "',"
                    + "codigo_produto = '" + pModelVendasProdutos.getCodigo_produto() + "',"
                    + "codigo_venda = '" + pModelVendasProdutos.getCodigo_venda() + "',"
                    + "quantidade = '" + pModelVendasProdutos.getQuantidade() + "',"
                    + "valor_unitario = '" + pModelVendasProdutos.getValorUnitario()+ "',"
                    + "cfop = '" + pModelVendasProdutos.getCfop()+ "',"
                    + "ncm = '" + pModelVendasProdutos.getNcm()+ "',"
                    + "trib_st_perc = '" + pModelVendasProdutos.getSubTribut()+ "',"
                    + "icms_cst = '" + pModelVendasProdutos.getIcmsCst()+ "',"
                    + "icms_red = '" + pModelVendasProdutos.getIcmsRed()+ "',"
                    + "ipi_cst = '" + "'" + pModelVendasProdutos.getIpiCst()+ "',"
                    + "pis_cst = '" + pModelVendasProdutos.getPisCst()+ "',"
                    + "cofins_cst = '" + pModelVendasProdutos.getCofinsCst()+ "',"
                    + "nomeProduto = '" + pModelVendasProdutos.getNomeProduto()+ "',"
                    + "unidade = '" + pModelVendasProdutos.getUnidade()+ "',"
                    + "percIcms = '" + pModelVendasProdutos.getPercIcms()+ "',"
                    + "desconto = '" + pModelVendasProdutos.getDesconto()+ "',"
                    + "ordem = '" + pModelVendasProdutos.getOrdem()+ "',"
                    + "observacao = '" + pModelVendasProdutos.getObservacao()+ "',"
                    + "opcoes_escolhidas = '" + pModelVendasProdutos.getOpcoesEscolhidas()+ "',"
                    + "tipo = '" + pModelVendasProdutos.getTipo()+ "',"
                    + "total = '" + pModelVendasProdutos.getValorTotal()+ "'"
                            
                + " WHERE "
                    + "codigo = '" + pModelVendasProdutos.getCodigo() + "'"
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
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM vendas_produto "
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
    
    
    /**
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosListaDAO(int pCodigo, int pCodigoVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM vendas_produto "
                + " WHERE "
                    + "codigo_venda = '" + pCodigoVenda + "'" + " AND codigo_produto = '" + pCodigo + "'"
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
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirVendasProdutosDAOCodVenda(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM vendas_produto "
                + " WHERE "
                    + "codigo_venda = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO(int pCodigoVenda) {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "opcoes_escolhidas, "
                    + "tipo, "
                    + "total "
                 + " FROM"
                     + " vendas_produto WHERE codigo_venda = '"+pCodigoVenda+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                modelVendasProdutos.setCfop(this.getResultSet().getString(6));
                modelVendasProdutos.setNcm(this.getResultSet().getString(7));
                modelVendasProdutos.setSubTribut(this.getResultSet().getDouble(8));
                modelVendasProdutos.setIcmsCst(this.getResultSet().getString(9));
                modelVendasProdutos.setIcmsRed(this.getResultSet().getDouble(10));
                modelVendasProdutos.setIpiCst(this.getResultSet().getString(11));
                modelVendasProdutos.setPisCst(this.getResultSet().getString(12));
                modelVendasProdutos.setCofinsCst(this.getResultSet().getString(13));
                modelVendasProdutos.setNomeProduto(this.getResultSet().getString(14));
                modelVendasProdutos.setUnidade(this.getResultSet().getString(15));
                modelVendasProdutos.setPercIcms(this.getResultSet().getFloat(16));
                modelVendasProdutos.setDesconto(this.getResultSet().getFloat(17));
                modelVendasProdutos.setOrdem(this.getResultSet().getInt(18));
                modelVendasProdutos.setCodProdutoAnp(this.getResultSet().getString(19));
                modelVendasProdutos.setDescricaoAnp(this.getResultSet().getString(20));
                modelVendasProdutos.setPercGlp(this.getResultSet().getInt(21));
                modelVendasProdutos.setPercGnn(this.getResultSet().getInt(22));
                modelVendasProdutos.setPercGni(this.getResultSet().getInt(23));
                modelVendasProdutos.setValorProdutoGlp(this.getResultSet().getDouble(24));
                modelVendasProdutos.setEstadoConsumidor(this.getResultSet().getString(25));
                modelVendasProdutos.setObservacao(this.getResultSet().getString(26));
                modelVendasProdutos.setOpcoesEscolhidas(this.getResultSet().getString(27));
                modelVendasProdutos.setTipo(this.getResultSet().getInt(28));
                modelVendasProdutos.setValorTotal(this.getResultSet().getFloat(29));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosCfopDAO(int pCodigoVenda, int pCfop) {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario, "
                    + "cfop, "
                    + "ncm, "
                    + "trib_st_perc, "
                    + "icms_cst, "
                    + "icms_red, "
                    + "ipi_cst, "
                    + "pis_cst, "
                    + "cofins_cst, "
                    + "nomeProduto,"
                    + "unidade,"
                    + "percIcms, "
                    + "desconto, "
                    + "ordem, "
                    + "cod_produto_anp," 
                    + "descricao_anp," 
                    + "perc_glp," 
                    + "perc_gnn," 
                    + "perc_gni," 
                    + "valor_produto_glp," 
                    + "estado_consumidor,"     
                    + "observacao, "
                    + "opcoes_escolhidas, "
                    + "tipo, "
                    + "total "
                 + " FROM"
                    + " vendas_produto WHERE codigo_venda = '"+pCodigoVenda+"'"
                    +"AND"
                    +" cfop = '" + pCfop + "'"
                    +" 'ORDER BY"
                    +" cfop'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                modelVendasProdutos.setCfop(this.getResultSet().getString(6));
                modelVendasProdutos.setNcm(this.getResultSet().getString(7));
                modelVendasProdutos.setSubTribut(this.getResultSet().getDouble(8));
                modelVendasProdutos.setIcmsCst(this.getResultSet().getString(9));
                modelVendasProdutos.setIcmsRed(this.getResultSet().getDouble(10));
                modelVendasProdutos.setIpiCst(this.getResultSet().getString(11));
                modelVendasProdutos.setPisCst(this.getResultSet().getString(12));
                modelVendasProdutos.setCofinsCst(this.getResultSet().getString(13));
                modelVendasProdutos.setNomeProduto(this.getResultSet().getString(14));
                modelVendasProdutos.setUnidade(this.getResultSet().getString(15));
                modelVendasProdutos.setPercIcms(this.getResultSet().getFloat(16));
                modelVendasProdutos.setDesconto(this.getResultSet().getFloat(17));
                modelVendasProdutos.setOrdem(this.getResultSet().getInt(18));
                modelVendasProdutos.setCodProdutoAnp(this.getResultSet().getString(19));
                modelVendasProdutos.setDescricaoAnp(this.getResultSet().getString(20));
                modelVendasProdutos.setPercGlp(this.getResultSet().getInt(21));
                modelVendasProdutos.setPercGnn(this.getResultSet().getInt(22));
                modelVendasProdutos.setPercGni(this.getResultSet().getInt(23));
                modelVendasProdutos.setValorProdutoGlp(this.getResultSet().getDouble(24));
                modelVendasProdutos.setEstadoConsumidor(this.getResultSet().getString(25));
                modelVendasProdutos.setObservacao(this.getResultSet().getString(26));
                modelVendasProdutos.setOpcoesEscolhidas(this.getResultSet().getString(27));
                modelVendasProdutos.setTipo(this.getResultSet().getInt(28));
                modelVendasProdutos.setValorTotal(this.getResultSet().getFloat(29));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }
}