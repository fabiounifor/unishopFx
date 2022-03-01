/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fabio
 */
public class ModelVendasProdutosTabelaNfe {
    int ordem;
    String produto;
    float quantidade;
    double valorUnitario;
    double valorTotal;
    String dataVenda;
    String pesquisaVendido;
    double aliqIcms;
    double aliqIpi;
    double valorIcms;
    double valorIpi;
    String cfop;
    String ncm;
    String csosn;

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    
    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    
    
    public double getAliqIcms() {
        return aliqIcms;
    }

    public void setAliqIcms(double aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public double getAliqIpi() {
        return aliqIpi;
    }

    public void setAliqIpi(double aliqIpi) {
        this.aliqIpi = aliqIpi;
    }

    public double getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(double valorcIcms) {
        this.valorIcms = valorcIcms;
    }

    public double getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(double valorIpi) {
        this.valorIpi = valorIpi;
    }
          
    

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
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    @Override
    public String toString() {
        return "ModelVendasProdutosTabela{" + "ordem=" + ordem + ", produto=" + produto + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + '}';
    }
    
    
    
}
