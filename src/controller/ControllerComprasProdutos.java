package controller;

import model.ModelComprasProdutos;
import DAO.DAOComprasProdutos;
import java.util.ArrayList;

/**
*
* @author BLSoft
*/
public class ControllerComprasProdutos {

    private DAOComprasProdutos daocompras_produtos = new DAOComprasProdutos();

    /**
    * grava compras_produtos
    * @param pModelcompras_produtos
    * return int
    */
    public int salvarcompras_produtosController(ModelComprasProdutos pModelcompras_produtos){
        return this.daocompras_produtos.salvarcompras_produtosDAO(pModelcompras_produtos);
    }
    
    /**
    * grava compra_produto
    * @param pModelcompra_produto
    * return int
    */
    public int salvarcompra_produtoController(ModelComprasProdutos pModelcompra_produto){
        return this.daocompras_produtos.salvarcompra_produtoDAO(pModelcompra_produto);
    }

    /**
    * recupera compras_produtos
    * @param pCodigo
    * return Modelcompras_produtos
    */
    public ModelComprasProdutos getcompras_produtosController(int pCodigo){
        return this.daocompras_produtos.getcompras_produtosDAO(pCodigo);
    }
    
     /**
    * recupera compras_produtos
    * @param pCodigo
    * return Modelcompras_produtos
    */
    public ModelComprasProdutos getcompras_produtosCodigoCompraController(int pCodigo){
        return this.daocompras_produtos.getcompras_produtos_codigoCompraDAO(pCodigo);
    }

    /**
    * recupera compras_produtos
     * @param pCodigoFornecedor
    * @param pCodigo
    * return Modelcompras_produtos
     * @return 
    */
    public ModelComprasProdutos getcompras_produtosControllerCodForn(String pCodigoFornecedor, String pCodigo){
        return this.daocompras_produtos.getcompras_produtosDAOCodFor(pCodigoFornecedor, pCodigo);
    }
    
    /**
    * recupera uma lista decompras_produtos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosController(){
        return this.daocompras_produtos.getListacompras_produtosDAO();
    }
    
    /**
    * recupera uma lista decompras_produtos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosController(int pCodigo){
        return this.daocompras_produtos.getListacompras_produtosDAO(pCodigo);
    }
    
    /**
    * recupera uma lista decompras_produtos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosCFOPController(String pCfop,int pCodigo){
        return this.daocompras_produtos.getListacompras_produtosCFOPDAO(pCfop, pCodigo);
    }
    
    /**
    * recupera uma lista decompras_produtos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelComprasProdutos> getListacompras_produtosCSTController(String pAliquota, String pCfop,int pCodigo){
        return this.daocompras_produtos.getListacompras_produtosCSTDAO(pAliquota, pCfop, pCodigo);
    }

    /**
    * atualiza compras_produtos
    * @param pModelcompras_produtos
    * return boolean
    */
    public boolean atualizarcompras_produtosController(ModelComprasProdutos pModelcompras_produtos){
        return this.daocompras_produtos.atualizarcompras_produtosDAO(pModelcompras_produtos);
    }
    /**
    * atualiza CFOP compras_produtos
    * @param pModelcompras_produtos
    * return boolean
    */
    public boolean atualizarcompras_produtoscFOPController(ModelComprasProdutos pModelcompras_produtos){
        return this.daocompras_produtos.atualizarcompras_produtosCfopDAO(pModelcompras_produtos);
    }

    /**
    * exclui compras_produtos
    * @param pCodigo
    * return boolean
    */
    public boolean excluircompras_produtosController(int pCodigo){
        return this.daocompras_produtos.excluircompras_produtosDAO(pCodigo);
    }
}