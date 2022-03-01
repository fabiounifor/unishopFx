package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelCFOP {

    private int codigo;
    private int cfop;
    private String descricao;
    private String observacao;
    private int faturamento;
    private int financeiro;
    private int sequeCfop;
    private String operacao;
     private String pesquisaCfop;

    /**
    * Construtor
    */
    public ModelCFOP(){}
    
    public String getPesquisaCfop() {
        return (cfop + "      " + descricao);
    }

    public void setPesquisaCfop(String pesquisaFator) {
        this.pesquisaCfop = pesquisaFator;
    }

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
    * seta o valor de cfop
    * @param pCfop
    */
    public void setCfop(int pCfop){
        this.cfop = pCfop;
    }
    /**
    * return cfop
    */
    public int getCfop(){
        return this.cfop;
    }

    /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * return descricao
    */
    public String getDescricao(){
        return this.descricao;
    }

    /**
    * seta o valor de observacao
    * @param pObservacao
    */
    public void setObservacao(String pObservacao){
        this.observacao = pObservacao;
    }
    /**
    * return observacao
    */
    public String getObservacao(){
        return this.observacao;
    }

    /**
    * seta o valor de faturamento
    * @param pFaturamento
    */
    public void setFaturamento(int pFaturamento){
        this.faturamento = pFaturamento;
    }
    /**
    * return faturamento
    */
    public int getFaturamento(){
        return this.faturamento;
    }

    /**
    * seta o valor de financeiro
    * @param pFinanceiro
    */
    public void setFinanceiro(int pFinanceiro){
        this.financeiro = pFinanceiro;
    }
    /**
    * return financeiro
    */
    public int getFinanceiro(){
        return this.financeiro;
    }

    /**
    * seta o valor de sequeCfop
    * @param pSequeCfop
    */
    public void setSequeCfop(int pSequeCfop){
        this.sequeCfop = pSequeCfop;
    }
    /**
    * return sequeCfop
    */
    public int getSequeCfop(){
        return this.sequeCfop;
    }

    /**
    * seta o valor de operacao
    * @param pOperacao
    */
    public void setOperacao(String pOperacao){
        this.operacao = pOperacao;
    }
    /**
    * return operacao
    */
    public String getOperacao(){
        return this.operacao;
    }

    @Override
    public String toString(){
        return "ModelCFOP {" + "::codigo = " + this.codigo + "::cfop = " + this.cfop + "::descricao = " + this.descricao + "::observacao = " + this.observacao + "::faturamento = " + this.faturamento + "::financeiro = " + this.financeiro + "::sequeCfop = " + this.sequeCfop + "::operacao = " + this.operacao +  "}";
    }
}