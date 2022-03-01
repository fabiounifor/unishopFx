package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
import controller.ControllerProdutos;
import model.ModelProdutos;

public class ModelVendasProdutos {

    
    private int codigo;
    private int Codigo_produto;
    private int Codigo_venda;
    private float quantidade;
    private int ordem;
    private double valorUnitario;
    private int tipo;
    private double subTribut;
    private String icmsCst;
    private double icmsRed;
    private String ipiCst;
    private String pisCst;
    private String cofinsCst;
    private String pesquisa;
    private String pesquisaCupom;
    private String cfop;
    private String nomeProduto;
    private String unidade;
    private float percIcms;
    private float desconto;
    private float valorTotal;
    private String codProdutoAnp;
    private String descricaoAnp;
    private int percGlp;
    private int percGnn;
    private int percGni;
    private Double valorProdutoGlp;
    private String estadoConsumidor;
    private String observacao;
    private String opcoesEscolhidas;
    private String ncm;
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelProdutos modelProdutos = new ModelProdutos();
    
  

    /**
    * Construtor
    */
    public ModelVendasProdutos(){}

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }
    
    

    public String getPesquisaCupom() {
        String nome = (controllerProdutos.getProdutosController(codigo).getNome());
        double valorTotal = quantidade * valorUnitario;
        return Codigo_produto + " " + nome + " " + valorTotal;
    }

    public void setPesquisaCupom(String pesquisaCupom) {
        this.pesquisaCupom = pesquisaCupom;
    }

    
    public String getPesquisa() {
        return (Codigo_produto +" -- ");
                
    }

    public void setPesquisaHistorico(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    

    public float getPercIcms() {
        return percIcms;
    }

    public void setPercIcms(float percIcms) {
        this.percIcms = percIcms;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_produto() {
        return Codigo_produto;
    }

    public void setCodigo_produto(int CodigoProduto) {
        this.Codigo_produto = CodigoProduto;
    }

    public int getCodigo_venda() {
        return Codigo_venda;
    }

    public void setCodigo_venda(int CodigoVenda) {
        this.Codigo_venda = CodigoVenda;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getSubTribut() {
        return subTribut;
    }

    public void setSubTribut(double subTribut) {
        this.subTribut = subTribut;
    }

    public String getIcmsCst() {
        return icmsCst;
    }

    public void setIcmsCst(String icmsCst) {
        this.icmsCst = icmsCst;
    }

    public double getIcmsRed() {
        return icmsRed;
    }

    public void setIcmsRed(double icmsRed) {
        this.icmsRed = icmsRed;
    }

    public String getIpiCst() {
        return ipiCst;
    }

    public void setIpiCst(String ipiCst) {
        this.ipiCst = ipiCst;
    }

    public String getPisCst() {
        return pisCst;
    }

    public void setPisCst(String pisCst) {
        this.pisCst = pisCst;
    }

    public String getCofinsCst() {
        return cofinsCst;
    }

    public void setCofinsCst(String cofinsCst) {
        this.cofinsCst = cofinsCst;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
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
    

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getOpcoesEscolhidas() {
        return opcoesEscolhidas;
    }

    public void setOpcoesEscolhidas(String opcoesEscolhidas) {
        this.opcoesEscolhidas = opcoesEscolhidas;
    }

    @Override
    public String toString() {
        return "ModelVendasProdutos{" + "codigo=" + codigo + ", Codigo_produto=" + Codigo_produto + ", Codigo_venda=" + Codigo_venda + ", quantidade=" + quantidade + ", ordem=" + ordem + ", valorUnitario=" + valorUnitario + ", tipo=" + tipo + ", subTribut=" + subTribut + ", icmsCst=" + icmsCst + ", icmsRed=" + icmsRed + ", ipiCst=" + ipiCst + ", pisCst=" + pisCst + ", cofinsCst=" + cofinsCst + ", pesquisa=" + pesquisa + ", pesquisaCupom=" + pesquisaCupom + ", cfop=" + cfop + ", nomeProduto=" + nomeProduto + ", unidade=" + unidade + ", percIcms=" + percIcms + ", desconto=" + desconto + ", valorTotal=" + valorTotal + ", codProdutoAnp=" + codProdutoAnp + ", descricaoAnp=" + descricaoAnp + ", percGlp=" + percGlp + ", percGnn=" + percGnn + ", percGni=" + percGni + ", valorProdutoGlp=" + valorProdutoGlp + ", estadoConsumidor=" + estadoConsumidor + ", observacao=" + observacao + ", opcoesEscolhidas=" + opcoesEscolhidas + '}';
    }
    
    

   

    
}