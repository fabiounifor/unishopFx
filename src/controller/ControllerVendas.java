package controller;

import model.ModelVendas;
import DAO.DAOVendas;
import java.sql.Date;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class ControllerVendas {

    private DAOVendas daoVendas = new DAOVendas();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
     * grava Vendas
     *
     * @param pModelVendas return int
     */
    public int salvarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }

    /**
     * recupera Vendas
     *
     * @param pCodigo return ModelVendas
     */
    public ModelVendas getVendasController(int pCodigo) {
        return this.daoVendas.getVendasDAO(pCodigo);
    }
    /**
     * recupera Vendas
     *
     * @param pCodigo return ModelVendas
     */
    public ModelVendas getVendasClienteController(int pCodigo) {
        return this.daoVendas.getVendasClienteDAO(pCodigo);
    }

    /**
     * recupera uma lista deVendas
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelVendas> getListaPedidosController() {
        return this.daoVendas.getListaPedidosDAO();
    }
    /**
     * recupera uma lista de Entregas
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelVendas> getListaPedidosEntregasController() {
        return this.daoVendas.getListaPedidosEntregaDAO();
    }

    /**
     * recupera uma lista de orçamentos
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelVendas> getListaOrcamentoController() {
        return this.daoVendas.getListaOrcamentoDAO();
    }

    /* recupera uma lista deVendas
    * @param pCodigo
    * return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasController(int pCodigo) {
        return this.daoVendas.getListaVendasDAO(pCodigo);
    }

    /**
     * atualiza Vendas
     *
     * @param pModelVendas return boolean
     */
    public boolean atualizarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    /**
     * exclui Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean excluirVendasController(int pCodigo) {
        return this.daoVendas.excluirVendasDAO(pCodigo);
    }
    
    public boolean salvarVendasProdutosController(ModelVendas modelVendas) {
        return this.daoVendas.salvarProdutosVendasDAO(modelVendas);
    }
    public boolean atualizarVendasProdutosController(ModelVendas modelVendas) {
        return this.daoVendas.atualizarVendasProdutosDAO(modelVendas);
    }
    public boolean atualizarVendasProdutosListaController(ModelVendas modelVendas) {
        return this.daoVendas.atualizarVendasProdutosListaDAO(modelVendas);
    }
    public boolean atualizarOrdemProdutosListaController(int codigoProduto, int ordem) {
        return this.daoVendas.atualizarOrdemProdutosListaDAO(codigoProduto, ordem);
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioVenda(pCodigo);
    }
    
    public boolean gerarRelatorioVendaCupom(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioVendaCupom(pCodigo);
    }
    public boolean gerarRelatorioVendaCupomCaixa(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioVendaCupomCaixa(pCodigo);
    }
    
    public boolean gerarRelatorioOrcamento(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioOrcamento(pCodigo);
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioPDV(pCodigo);
    }

    public boolean gerarRelatorioVendasCliente(Date pDataInicial, Date dataFinal, int codigoCliente) {
        return this.dAORelatorios.gerarRelatorioVendasCliente(pDataInicial, dataFinal, codigoCliente);
    }

    public boolean gerarRelatorioVendaTodosCliente(Date dataInicial, Date dataFinal) {
        return this.dAORelatorios.gerarRelatorioVendaTodosCliente(dataInicial, dataFinal);
    }

    /**
     * Excluir os produtos de uma venda
     *
     * @param pCodigo
     * @return
     */
    public boolean excluirProdutoVendasController(int pCodigo) {
        return this.daoVendas.excluirProdutoVendasDAO(pCodigo);
    }

    public ArrayList<ModelVendas> getListaPedidosController(ModelVendas pMdelVendas) {
        return this.daoVendas.getListaPedidosDAO(pMdelVendas);
    }

    /**
     * desaprovar Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean desaprovarPedidoController(int pCodigo) {
        return this.daoVendas.desaprovarPedidoDAO(pCodigo);
    }
    public boolean mudarStatusEntregaController(int pCodigo, int status) {
        return this.daoVendas.mudarEntregaDAO(pCodigo, status);
    }

    public boolean vizualizarPedidoDaMesa(int pCodigo) {
        return this.dAORelatorios.vizualizarPedidoDaMesa(pCodigo);
    }

    public boolean gerarRelatorioPedidoCozinha(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioPedidoCozinha(pCodigo);
    }

    public boolean vizualizarMesaController(int pCodigo) {
        return this.dAORelatorios.vizualizarMesaDAO(pCodigo);
    }
    public boolean vizualizarMesaControllerSemTaxa(int pCodigo) {
        return this.dAORelatorios.vizualizarMesaDAOSemTaxa(pCodigo);
    }

}
