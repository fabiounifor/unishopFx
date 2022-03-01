/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.util.ArrayList;
import model.ModelRelatorioProdutos;
import relatorios.DAORelatorios;

/**
 *
 * @author MacMini
 */
public class ControllerRelatorioProdutos {

    private DAORelatorios dAORelatorios = new DAORelatorios();

    public ArrayList<ModelRelatorioProdutos> retornarProdutosCidadeController(int codigoCidade, Date dataInicial, Date dataFinal) {
        return this.dAORelatorios.gerarRelatorioClienteIndividual(codigoCidade, dataInicial, dataFinal);
    }

    public ArrayList<ModelRelatorioProdutos> retornarProdutosTodasCidadeController(int codigoCidade, Date dataInicial, Date dataFinal) {
        return this.dAORelatorios.retornarProdutosTodasCidadeController(codigoCidade, dataInicial, dataFinal);
    }

}
