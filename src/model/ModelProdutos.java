package model;

import java.util.ArrayList;
import util.gerarSintegra;
import controller.ControllerProdutos;
import javafx.scene.control.Hyperlink;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ModelProdutos {

    private int codigo;
    private int fornecedoresCodigo;
    private String nome;
    private String descricaoProduto;
    private double valor;
    private double valorCusto;
    private String codigoBarrasEan;
    private float estoque;
    private float addEstoque;
    private ArrayList<ModelProdutos> listaModelProdutoses;
    private ArrayList<ModelProdutos> listaModelProdutosPesquisa;

    public ArrayList<ModelProdutos> getListaModelProdutosPesquisa() {
    return listaModelProdutosPesquisa;
            
    }
ControllerProdutos controllerProdutos = new ControllerProdutos();
    
    
    public void setListaModelProdutosPesquisa(ArrayList<ModelProdutos> listaModelProdutosPesquisa) {
        this.listaModelProdutosPesquisa = listaModelProdutosPesquisa;
    }
    private String imagemProduto;
    private int ativo;
    private String marca;
    private int diasGarantia;
    private int unidadeMedida;
    private int origem;
    private double peso;
    private String ncm;
    private String cst;
    private String tipoNcm;
    private String icms;
    private String ipi;
    private String ValorIpi;
    private String pis;
    private String cofins;
    private ModelProdutos modelProdutos;
    private String pesquisa;
    private String pesquisaProduto;
    private String cest;
    private String tipoCest;
    private int grupo;
    private int tipo;
    private int composicao;
    private int fracionado;
    private int balanca;
    private float reserva;
    private int conversao;
    private int uniFisco;
    private double lucro;
    private int tribEst;
    private int tribFed;
    private int tribStPerc;
    private String codProdutoAnp;
    private String descricaoAnp;
    private int percGlp;
    private int percGnn;
    private int percGni;
    private Double valorProdutoGlp;
    private String estadoConsumidor;
    private String observacao;
    private Hyperlink linkModelEditar;
    private Hyperlink linkModelDuplicar;
    
    gerarSintegra gs = new gerarSintegra();

    public Hyperlink getLinkModelEditar() {
        return linkModelEditar;
    }

    public void setLinkModelEditar(Hyperlink linkModelEditar) {
        this.linkModelEditar = linkModelEditar;
    }

    public Hyperlink getLinkModelDuplicar() {
        return linkModelDuplicar;
    }

    public void setLinkModelDuplicar(Hyperlink linkModelDuplicar) {
        this.linkModelDuplicar = linkModelDuplicar;
    }

    
    public gerarSintegra getGs() {
        return gs;
    }

    public void setGs(gerarSintegra gs) {
        this.gs = gs;
    }
    
    
    
    public int getBalanca() {
        return balanca;
    }

    public void setBalanca(int balanca) {
        this.balanca = balanca;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public int getComposicao() {
        return composicao;
    }

    public void setComposicao(int composicao) {
        this.composicao = composicao;
    }

    public int getConversao() {
        return conversao;
    }

    public void setConversao(int conversao) {
        this.conversao = conversao;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getFracionado() {
        return fracionado;
    }

    public void setFracionado(int fracionado) {
        this.fracionado = fracionado;
    }

    public float getReserva() {
        return reserva;
    }

    public void setReserva(float reserva) {
        this.reserva = reserva;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public String getTipoCest() {
        return tipoCest;
    }

    public void setTipoCest(String tipoCest) {
        this.tipoCest = tipoCest;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getUniFisco() {
        return uniFisco;
    }

    public void setUniFisco(int uniFisco) {
        this.uniFisco = uniFisco;
    }

        
    public String getPesquisa() {
        return codigo + "  " + nome + "   \n\n   " + estoque + "  R$" + valor;
    }
    public String getPesquisaProduto() {
    
        return gs.ajustarTamanho(String.valueOf(codigo), 4) + "  " + gs.ajustarTamanho(nome, 50) + "   Est: " + gs.ajustarTamanho(String.valueOf(estoque), 6) + "  R$" + valor + "\n" + "Barras"+ codigoBarrasEan;
    }
public void setPesquisaProduto(String pesquisaProduto) {
        this.pesquisaProduto = gs.ajustarTamanho(String.valueOf(codigo), 4) + "  " + gs.ajustarTamanho(nome, 50) + "   Est: " + gs.ajustarTamanho(String.valueOf(estoque), 6) + "  R$" + valor + "\n" + "Barras"+ codigoBarrasEan;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = (codigo + "  " + nome + "      " + estoque + "  " + valor);
    }

    /**
    * Construtor
    */
    public ModelProdutos(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de fornecedoresCodigo
    * @param pFornecedores_codigo
    */
    public void setFornecedoresCodigo(int pFornecedores_codigo){
        this.fornecedoresCodigo = pFornecedores_codigo;
    }
    /**
    * return fornecedoresCodigo
    */
    public int getFornecedoresCodigo(){
        return this.fornecedoresCodigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the valorCusto
     */
    public double getValorCusto() {
        return valorCusto;
    }

    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    /**
     * @return the codigoBarrasEan
     */
    public String getCodigoBarrasEan() {
        return codigoBarrasEan;
    }

    /**
     * @param codigoBarrasEan the codigoBarrasEan to set
     */
    public void setCodigoBarrasEan(String codigoBarrasEan) {
        this.codigoBarrasEan = codigoBarrasEan;
    }

    /**
     * @return the estoque
     */
    public float getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the addEstoque
     */
    public float getAddEstoque() {
        return addEstoque;
    }

    /**
     * @param addEstoque the addEstoque to set
     */
    public void setAddEstoque(float addEstoque) {
        this.addEstoque = addEstoque;
    }

    /**
     * @return the listaModelProdutoses
     */
    public ArrayList<ModelProdutos> getListaModelProdutoses() {
        return listaModelProdutoses;
    }

    /**
     * @param listaModelProdutoses the listaModelProdutoses to set
     */
    public void setListaModelProdutoses(ArrayList<ModelProdutos> listaModelProdutoses) {
        this.listaModelProdutoses = listaModelProdutoses;
    }

    /**
     * @return the imagemProduto
     */
    public String getImagemProduto() {
        return imagemProduto;
    }

    /**
     * @param imagemProduto the imagemProduto to set
     */
    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    /**
     * @return the ativo
     */
    public int getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the diasGarantia
     */
    public int getDiasGarantia() {
        return diasGarantia;
    }

    /**
     * @param diasGarantia the diasGarantia to set
     */
    public void setDiasGarantia(int diasGarantia) {
        this.diasGarantia = diasGarantia;
    }

    /**
     * @return the unidadeMedida
     */
    public int getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(int unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /**
     * @return the origem
     */
    public int getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(int origem) {
        this.origem = origem;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    /**
     * @return the ncm
     */
    public String getNcm() {
        return ncm;
    }

    /**
     * @param ncm the ncm to set
     */
    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

        
    
    /**
     * @return the tipoNcm
     */
    public String getTipoNcm() {
        return tipoNcm;
    }

    /**
     * @param tipoNcm the tipoNcm to set
     */
    public void setTipoNcm(String tipoNcm) {
        this.tipoNcm = tipoNcm;
    }

    /**
     * @return the subTribut
     */
   
    /**
     * @return the icms
     */
    public String getIcms() {
        return icms;
    }

    /**
     * @param icms the icms to set
     */
    public void setIcms(String icms) {
        this.icms = icms;
    }

    /**
     * @return the ipi
     */
    public String getIpi() {
        return ipi;
    }

    /**
     * @param ipi the ipi to set
     */
    public void setIpi(String ipi) {
        this.ipi = ipi;
    }

    public String getValorIpi() {
        return ValorIpi;
    }

    public void setValorIpi(String ValorIpi) {
        this.ValorIpi = ValorIpi;
    }


    /**
     * @return the pis
     */
    public String getPis() {
        return pis;
    }

    /**
     * @param pis the pis to set
     */
    public void setPis(String pis) {
        this.pis = pis;
    }

    /**
     * @return the cofins
     */
    public String getCofins() {
        return cofins;
    }

    /**
     * @param cofins the cofins to set
     */
    public void setCofins(String cofins) {
        this.cofins = cofins;
    }

    /**
     * @return the modelProdutos
     */
    public ModelProdutos getModelProdutos() {
        return modelProdutos;
    }

    /**
     * @param modelProdutos the modelProdutos to set
     */
    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public int getTribEst() {
        return tribEst;
    }

    public void setTribEst(int tribEst) {
        this.tribEst = tribEst;
    }

    public int getTribFed() {
        return tribFed;
    }

    public void setTribFed(int tribFed) {
        this.tribFed = tribFed;
    }

    public int getTribStPerc() {
        return tribStPerc;
    }

    public void setTribStPerc(int tribStPerc) {
        this.tribStPerc = tribStPerc;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getCodProdutoAnp() {
        return codProdutoAnp;
    }

    public void setCodProdutoAnp(String codProdutoAnp) {
        this.codProdutoAnp = codProdutoAnp;
    }

    public String getDescricaoAnp() {
        return descricaoAnp;
    }

    public void setDescricaoAnp(String descricaoAnp) {
        this.descricaoAnp = descricaoAnp;
    }

    public int getPercGlp() {
        return percGlp;
    }

    public void setPercGlp(int percGlp) {
        this.percGlp = percGlp;
    }

    public int getPercGnn() {
        return percGnn;
    }

    public void setPercGnn(int percGnn) {
        this.percGnn = percGnn;
    }

    public int getPercGni() {
        return percGni;
    }

    public void setPercGni(int percGni) {
        this.percGni = percGni;
    }

    public Double getValorProdutoGlp() {
        return valorProdutoGlp;
    }

    public void setValorProdutoGlp(Double valorProdutoGlp) {
        this.valorProdutoGlp = valorProdutoGlp;
    }

    public String getEstadoConsumidor() {
        return estadoConsumidor;
    }

    public void setEstadoConsumidor(String estadoConsumidor) {
        this.estadoConsumidor = estadoConsumidor;
    }

    
    
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
     /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public String toString() {
        return "ModelProdutos{" + "codigo=" + codigo + ", fornecedoresCodigo=" + fornecedoresCodigo + ", nome=" + nome + ", descricaoProduto=" + descricaoProduto + ", valor=" + valor + ", valorCusto=" + valorCusto + ", codigoBarrasEan=" + codigoBarrasEan + ", estoque=" + estoque + ", addEstoque=" + addEstoque + ", listaModelProdutoses=" + listaModelProdutoses + ", listaModelProdutosPesquisa=" + listaModelProdutosPesquisa + ", controllerProdutos=" + controllerProdutos + ", imagemProduto=" + imagemProduto + ", ativo=" + ativo + ", marca=" + marca + ", diasGarantia=" + diasGarantia + ", unidadeMedida=" + unidadeMedida + ", origem=" + origem + ", peso=" + peso + ", ncm=" + ncm + ", cst=" + cst + ", tipoNcm=" + tipoNcm + ", icms=" + icms + ", ipi=" + ipi + ", ValorIpi=" + ValorIpi + ", pis=" + pis + ", cofins=" + cofins + ", modelProdutos=" + modelProdutos + ", pesquisa=" + pesquisa + ", cest=" + cest + ", tipoCest=" + tipoCest + ", grupo=" + grupo + ", tipo=" + tipo + ", composicao=" + composicao + ", fracionado=" + fracionado + ", balanca=" + balanca + ", reserva=" + reserva + ", conversao=" + conversao + ", uniFisco=" + uniFisco + ", lucro=" + lucro + ", tribEst=" + tribEst + ", tribFed=" + tribFed + ", tribStPerc=" + tribStPerc + ", codProdutoAnp=" + codProdutoAnp + ", descricaoAnp=" + descricaoAnp + ", percGlp=" + percGlp + ", percGnn=" + percGnn + ", percGni=" + percGni + ", valorProdutoGlp=" + valorProdutoGlp + ", estadoConsumidor=" + estadoConsumidor + ", observacao=" + observacao + ", linkModelEditar=" + linkModelEditar + ", linkModelDuplicar=" + linkModelDuplicar + ", gs=" + gs + '}';
    }

   
}