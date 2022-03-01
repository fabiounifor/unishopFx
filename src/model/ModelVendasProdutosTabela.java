/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import util.BLMascaras;

/**
 *
 * @author Fabio
 */
public class ModelVendasProdutosTabela {
    int ordem;
    String produto;
    float quantidade;
    double valorUnitario;
    double valorTotal;
    String dataVenda;
    String pesquisaVendido;
    String ncm;
    String observacao;
          
    BLMascaras blMascaras = new BLMascaras();

    public String getPesquisaVendido() {
        return (produto + "\n" + quantidade + "      R$"  + valorUnitario+ "    " +dataVenda);
    }

    public void setPesquisaVendido(String pesquisaVendido) {
        this.pesquisaVendido = pesquisaVendido;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return blMascaras.truncamentoComPontoDuasCasasDouble(valorUnitario);
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = blMascaras.truncamentoComPontoDuasCasasDouble(valorUnitario);
    }

    public double getValorTotal() {
        return blMascaras.truncamentoComPontoDuasCasasDouble(valorTotal);
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = blMascaras.truncamentoComPontoDuasCasasDouble(valorTotal);
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    @Override
    public String toString() {
        return "ModelVendasProdutosTabela{" + "ordem=" + ordem + ", produto=" + produto + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", observação= "+ observacao +'}';
    }
    
    
    
}
