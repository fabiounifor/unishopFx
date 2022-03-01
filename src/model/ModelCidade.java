package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelCidade {

    private int codigo;
    private String nome;
    private int fk_cod_estado;
    private int codigoIBGE;

    /**
    * Construtor
    */
    public ModelCidade(){}

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
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de fk_cod_estado
    * @param pFk_cod_estado
    */
    public void setFk_cod_estado(int pFk_cod_estado){
        this.fk_cod_estado = pFk_cod_estado;
    }
    /**
    * return fk_cod_estado
    */
    public int getFk_cod_estado(){
        return this.fk_cod_estado;
    }

    @Override
    public String toString(){
        return "ModelCidade {" + "::codigo = " + this.codigo + "::nome = " + this.nome + "::fk_cod_estado = " + this.fk_cod_estado +  "}";
    }

    /**
     * @return the codigoIBGE
     */
    public int getCodigoIBGE() {
        return codigoIBGE;
    }

    /**
     * @param codigoIBGE the codigoIBGE to set
     */
    public void setCodigoIBGE(int codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }
}