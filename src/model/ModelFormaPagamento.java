package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelFormaPagamento {

    private int codigo;
    private String descricao;
    private float desconto;
    private int quantidadeParcelas;
    private String observacao;
    private boolean situacao;

    /**
    * Construtor
    */
    public ModelFormaPagamento(){}

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
    * seta o valor de desconto
    * @param pDesconto
    */
    public void setDesconto(float pDesconto){
        this.desconto = pDesconto;
    }
    /**
    * return desconto
    */
    public float getDesconto(){
        return this.desconto;
    }

    /**
    * seta o valor de quantidadeParcelas
    * @param pQuantidadeParcelas
    */
    public void setQuantidadeParcelas(int pQuantidadeParcelas){
        this.quantidadeParcelas = pQuantidadeParcelas;
    }
    /**
    * return quantidadeParcelas
    */
    public int getQuantidadeParcelas(){
        return this.quantidadeParcelas;
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
    * seta o valor de situacao
    * @param pSituacao
    */
    public void setSituacao(boolean pSituacao){
        this.situacao = pSituacao;
    }
    /**
    * return situacao
    */
    public boolean isSituacao(){
        return this.situacao;
    }

    @Override
    public String toString(){
        return "ModelFormaPagamento {" + "::codigo = " + this.codigo + "::descricao = " + this.descricao + "::desconto = " + this.desconto + "::quantidadeParcelas = " + this.quantidadeParcelas + "::observacao = " + this.observacao + "::situacao = " + this.situacao +  "}";
    }
}