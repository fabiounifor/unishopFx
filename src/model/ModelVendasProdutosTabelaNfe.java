/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    float desconto;
    String dataVenda;
    String pesquisaVendido;
    double aliqIcms;
    double aliqIpi;
    double aliqSubst;
    double valorIcms;
    double valorIpi;
    double valorSubst;
    String cfop;
    String ncm;
    String csosn;
    Button btEdita;
    Button btRemove;

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

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
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

    public double getAliqSubst() {
        return aliqSubst;
    }

    public void setAliqSubst(double aliqSubst) {
        this.aliqSubst = aliqSubst;
    }

    public double getValorSubst() {
        return valorSubst;
    }

    public void setValorSubst(double valorSubst) {
        this.valorSubst = valorSubst;
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

    public Button getBtEdita() {
        return btEdita;
    }

    public void setBtEdita(Button btEdita) {
        Node nd;
        Image imgem = new Image("imagens/icons 20/icons8-editar-filled-50.png");
        ImageView img = new ImageView(imgem);
        img.setFitHeight(20.00);
        img.setFitWidth(20.00);
        nd = img;
        btEdita.setGraphic(nd);
        this.btEdita = btEdita;
    }

    public Button getBtRemove() {
        return btRemove;
    }

    public void setBtRemove(Button btRemove) {
        Node nd;
        Image imgem = new Image("imagens/icons 20/icons8-não-perturbe-filled-50.png");
        ImageView img = new ImageView(imgem);
        img.setFitHeight(20.00);
        img.setFitWidth(20.00);
        nd = img;
        btRemove.setGraphic(nd);
        this.btRemove = btRemove;
    }
    
    

    @Override
    public String toString() {
        return "ModelVendasProdutosTabela{" + "ordem=" + ordem + ", produto=" + produto + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + '}';
    }
    
    
    
}
