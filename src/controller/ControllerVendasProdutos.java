package controller;

import model.ModelVendasProdutos;
import DAO.DAOVendasProdutos;
import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ControllerVendasProdutos {

    private DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    /**
    * grava VendasProdutos
    * @param pModelVendasProdutos
    * return int
    */
    public int salvarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
    * recupera VendasProdutos
    * @param pCodigo
    * return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasProdutosController(int pCodigo){
        return this.daoVendasProdutos.getVendasProdutosDAO(pCodigo);
    }

        /**
    * recupera VendasProdutos
    * @param pCodigo
    * return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasCodigoProdutosController(int pCodigo){
        return this.daoVendasProdutos.getVendasCodigoVendasProdutosDAO(pCodigo);
    }

    
    /**
    * recupera uma lista deVendasProdutos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController(){
        return this.daoVendasProdutos.getListaVendasProdutosDAO();
    }
    
    /**
    * recupera uma lista deVendasProdutos
    * @param pCodigoProduto
    * return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosCodigoController(int pCodigoProduto){
        return this.daoVendasProdutos.getListaVendasCodigoProdutosDAO(pCodigoProduto);
    }

    /**
    * atualiza VendasProdutos
    * @param pModelVendasProdutos
    * return boolean
    */
    public boolean atualizarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.atualizarVendasProdutosDAO(pModelVendasProdutos);
    }
    
    /**
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosListaController(int pCodigo, int pCodigoVenda){
        return this.daoVendasProdutos.excluirVendasProdutosListaDAO(pCodigo, pCodigoVenda);
    }
    
    /**
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosController(int pCodigo){
        return this.daoVendasProdutos.excluirVendasProdutosDAO(pCodigo);
    }
    
     /**
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosCodVendaController(int pCodigo){
        return this.daoVendasProdutos.excluirVendasProdutosDAOCodVenda(pCodigo);
    }

    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController(int pCodigoVenda) {
        return this.daoVendasProdutos.getListaVendasProdutosDAO(pCodigoVenda);
    }
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosCfopController(int pCodigoVenda, int pCfop) {
        return this.daoVendasProdutos.getListaVendasProdutosCfopDAO(pCodigoVenda, pCfop);
    }
}