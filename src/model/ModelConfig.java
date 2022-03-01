/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MacMini
 */
public class ModelConfig {

    /**
     * @return the caminhoMySQL
     */
    public String getCaminhoMySQL() {
        return caminhoMySQL;
    }

    /**
     * @param caminhoMySQL the caminhoMySQL to set
     */
    public void setCaminhoMySQL(String caminhoMySQL) {
        this.caminhoMySQL = caminhoMySQL;
    }
    
    private String nomeBanco;
    private String usuario;
    private String senha;
    private String ip;
    private String caminhoMySQL;
    private int quantidadeMesas;
    private int ambiente;
    private int onOfLine;
    private String impressoraPDV;
    private String impressoraCozinha;
    private String impressoraDelivery;
    private int modeloImprimir;
    private int modelocupomMesa;
    private int quantidadeImprimir;
    private int serieNfce;
    private int numeroNfce;
    private int serieNfe;
    private int numeroNfe;
    private String nsu;
    private int classificacaoFiscal;
    private int metodoEnvioNfce;
    private int metodoEnvioNfe;
    private int metodoEnvioNfse;
    private int visualizarNfce;
    /**
     * @return the nomeBanco
     */
    public String getNomeBanco() {
        return nomeBanco;
    }

    /**
     * @param nomeBanco the nomeBanco to set
     */
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the quantidadeMesas
     */
    public int getQuantidadeMesas() {
        return quantidadeMesas;
    }

    /**
     * @param quantidadeMesas the quantidadeMesas to set
     */
    public void setQuantidadeMesas(int quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }

    /**
     * @return the ambiente
     */
    public int getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the onOfLine
     */
    public int getOnOfLine() {
        return onOfLine;
    }

    /**
     * @param onOfLine the onOfLine to set
     */
    public void setOnOfLine(int onOfLine) {
        this.onOfLine = onOfLine;
    }

    /**
     * @return the impressoraPDV
     */
    public String getImpressoraPDV() {
        return impressoraPDV;
    }

    /**
     * @param impressoraPDV the impressoraPDV to set
     */
    public void setImpressoraPDV(String impressoraPDV) {
        this.impressoraPDV = impressoraPDV;
    }

    /**
     * @return the impressoraCozinha
     */
    public String getImpressoraCozinha() {
        return impressoraCozinha;
    }

    /**
     * @param impressoraCozinha the impressoraCozinha to set
     */
    public void setImpressoraCozinha(String impressoraCozinha) {
        this.impressoraCozinha = impressoraCozinha;
    }

    /**
     * @return the impressoraDelivery
     */
    public String getImpressoraDelivery() {
        return impressoraDelivery;
    }

    /**
     * @param impressoraDelivery the impressoraDelivery to set
     */
    public void setImpressoraDelivery(String impressoraDelivery) {
        this.impressoraDelivery = impressoraDelivery;
    }

    public int getModeloImprimir() {
        return modeloImprimir;
    }

    public void setModeloImprimir(int modeloImprimir) {
        this.modeloImprimir = modeloImprimir;
    }

    public int getQuantidadeImprimir() {
        return quantidadeImprimir;
    }

    public void setQuantidadeImprimir(int quantidadeImprimir) {
        this.quantidadeImprimir = quantidadeImprimir;
    }

    public int getModelocupomMesa() {
        return modelocupomMesa;
    }

    public void setModelocupomMesa(int modelocupommesa) {
        this.modelocupomMesa = modelocupomMesa;
    }

    public int getSerieNfce() {
        return serieNfce;
    }

    public void setSerieNfce(int serieNfce) {
        this.serieNfce = serieNfce;
    }

    public int getNumeroNfce() {
        return numeroNfce;
    }

    public void setNumeroNfce(int numeroNfce) {
        this.numeroNfce = numeroNfce;
    }

    public int getSerieNfe() {
        return serieNfe;
    }

    public void setSerieNfe(int serieNfe) {
        this.serieNfe = serieNfe;
    }

    public int getNumeroNfe() {
        return numeroNfe;
    }

    public void setNumeroNfe(int numeroNfe) {
        this.numeroNfe = numeroNfe;
    }

    
    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }
    
    public int getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(int classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public int getMetodoEnvioNfce() {
        return metodoEnvioNfce;
    }

    public void setMetodoEnvioNfce(int metodoEnvioNfce) {
        this.metodoEnvioNfce = metodoEnvioNfce;
    }

    public int getMetodoEnvioNfe() {
        return metodoEnvioNfe;
    }

    public void setMetodoEnvioNfe(int metodoEnvioNfe) {
        this.metodoEnvioNfe = metodoEnvioNfe;
    }

    public int getMetodoEnvioNfse() {
        return metodoEnvioNfse;
    }

    public void setMetodoEnvioNfse(int metodoEnvioNfse) {
        this.metodoEnvioNfse = metodoEnvioNfse;
    }

    public int getVisualizarNfce() {
        return visualizarNfce;
    }

    public void setVisualizarNfce(int visualizarNfce) {
        this.visualizarNfce = visualizarNfce;
    }
    
    
    
}
