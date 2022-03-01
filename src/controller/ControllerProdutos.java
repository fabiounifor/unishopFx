package controller;

import model.ModelProdutos;
import DAO.DAOProdutos;
import java.util.ArrayList;
import model.ModelComprasProdutosTabela;
import relatorios.DAORelatorios;

/**
 * @author  BLSoft
 www.Blsoft.com.br
 Venda de software e código fonte
*/
public class ControllerProdutos {

    private DAOProdutos daoProdutos = new DAOProdutos();
    private DAORelatorios dAORelatorios = new DAORelatorios();
    /**
    * grava Produtos
    * @param pModelProdutos
    * return int
    */
    public int salvarProdutosController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }

    /**
    * recupera Produtos
    * @param pCodigo
    * return ModelProdutos
    */
    public ModelProdutos getProdutosController(int pCodigo){
        return this.daoProdutos.getProdutosDAO(pCodigo);
    }
    
    /**
    * recupera Produtos
    * @param pNome
    * return ModelProdutos
     * @return 
    */
    
    public ModelProdutos getProdutosControllerCodigo(int pCodigo){
        return this.daoProdutos.getProdutosDAOCodigo(pCodigo);
    }
    
    /**
    * recupera Produtos
    * @param pNome
    * return ModelProdutos
     * @return 
    */
    public ModelProdutos getProdutosController(String pNome){
        return this.daoProdutos.getProdutosDAO(pNome);
    }
   
    /**
    * recupera uma lista deProdutos
     * @return 
    */
    public ArrayList<ModelProdutos> getListaProdutosController(){
        return this.daoProdutos.getListaProdutosDAO();
    }

    /**
    * atualiza Produtos
    * @param pModelProdutos
    * return boolean
     * @return 
    */
    public boolean atualizarProdutosController(ModelProdutos pModelProdutos){
        return this.daoProdutos.atualizarProdutosDAO(pModelProdutos);
    }

    /**
    * exclui Produtos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirProdutosController(int pCodigo){
        return this.daoProdutos.excluirProdutosDAO(pCodigo);
    }

    /**
    * atualiza Produtos
    * @param pModelProdutos
    * return boolean
    */
    public boolean atualizarProdutosQuantidadeController(ModelProdutos pModelProdutos){
        return this.daoProdutos.atualizarProdutosQuantidadeDAO(pModelProdutos);
    }
    
    /**
    * atualiza Produtos
    * @param pModelProdutos
    * return boolean
    */
    public boolean atualizarProdutosQuantidadeValorController(ArrayList<ModelComprasProdutosTabela>pListaComprasProdutos){
        return this.daoProdutos.atualizarProdutosQuantidadeValorDAO(pListaComprasProdutos);
    }
    /**
    * atualiza Produtos
    * @param pModelProdutos
    * return boolean
    */
    public boolean atualizarProdutosEstoqueController(ModelProdutos pModelProdutos){
        return this.daoProdutos.atualizarProdutosEstoqueDAO(pModelProdutos);
    }
    
    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeUmController(int pcodigo, float pQuantidade) {
        return this.daoProdutos.atualizarProdutosQuantidadeUmDAO(pcodigo, pQuantidade);
    }
    

    public boolean gerarRelatorioProdutos() {
        return this.dAORelatorios.gerarRelatorioProdutos();
    }

    public ModelProdutos getProdutosCodigoBarrasController(String pCodigoBarras) {
        return this.daoProdutos.getProdutosCodigoBarrasDAO(pCodigoBarras);
    }

    public ArrayList<ModelProdutos> getListaProdutosAtivosController() {
        return this.daoProdutos.getListaProdutosAtivosDAO();
    }
    public ArrayList<ModelProdutos> getCbListaProdutosAtivosController() {
        return this.daoProdutos.getCbListaProdutosAtivosDAo();
    }

    /**
     * Alterar preço e estoque produtos
     * @param pModelProdutos
     * @return 
     */
    public boolean atualizarPrecoEstoqueProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarPrecoEstoqueProdutosDAO(pModelProdutos);
    }
    
}