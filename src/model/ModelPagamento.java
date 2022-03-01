/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ControllerFormaPagamento;
import java.util.ArrayList;
import view.ViewVerificarPermissao;

/**
 *
 * @author Fabio
 */
public class ModelPagamento {
    private float valorTotal;
    private float desconto;
    private float valorRecebido;
    private float troco;
    private float totalPagar;
    private float valorCusto;
    private float dinheiro;
    private float cartao;
    private float cheque;
    private float convenio;
    private String tipoPagamento;
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    private ViewVerificarPermissao viewVerificarPermissao;

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public float getCartao() {
        return cartao;
    }

    public void setCartao(float cartao) {
        this.cartao = cartao;
    }

    public float getCheque() {
        return cheque;
    }

    public void setCheque(float cheque) {
        this.cheque = cheque;
    }

    public float getConvenio() {
        return convenio;
    }

    public void setConvenio(float convenio) {
        this.convenio = convenio;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public ControllerFormaPagamento getControllerTipoPagamento() {
        return controllerTipoPagamento;
    }

    public void setControllerTipoPagamento(ControllerFormaPagamento controllerTipoPagamento) {
        this.controllerTipoPagamento = controllerTipoPagamento;
    }

    public ArrayList<ModelFormaPagamento> getListaModelTipoPagamentos() {
        return listaModelTipoPagamentos;
    }

    public void setListaModelTipoPagamentos(ArrayList<ModelFormaPagamento> listaModelTipoPagamentos) {
        this.listaModelTipoPagamentos = listaModelTipoPagamentos;
    }

    public ViewVerificarPermissao getViewVerificarPermissao() {
        return viewVerificarPermissao;
    }

    public void setViewVerificarPermissao(ViewVerificarPermissao viewVerificarPermissao) {
        this.viewVerificarPermissao = viewVerificarPermissao;
    }
    
    
    
}
