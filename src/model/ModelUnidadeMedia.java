package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelUnidadeMedia {

    private int codigo;
    private String abreviacao;
    private String descricao;
    private String pesquisaUnidade;

    /**
    * Construtor
    */
    public ModelUnidadeMedia(){}

    public String getPesquisaUnidade() {
        return (codigo + "    " + abreviacao + "       " +descricao);
    }

    public void setPesquisaUnidade(String pesquisaUnidade) {
        this.pesquisaUnidade = pesquisaUnidade;
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
    * seta o valor de abreviacao
    * @param pAbreviacao
    */
    public void setAbreviacao(String pAbreviacao){
        this.abreviacao = pAbreviacao;
    }
    /**
    * return abreviacao
    */
    public String getAbreviacao(){
        return this.abreviacao;
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

    @Override
    public String toString(){
        return "ModelUnidadeMedia {" + "::codigo = " + this.codigo + "::abreviacao = " + this.abreviacao + "::descricao = " + this.descricao +  "}";
    }
}