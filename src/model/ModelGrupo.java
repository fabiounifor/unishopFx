package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelGrupo {

    private int codigo;
    private String grupo;
    private String descricao;
    

    /**
    * Construtor
    */
    public ModelGrupo(){}

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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    
    public String toString(){
        return "ModelGRUPO {" + "::codigo = " + this.codigo + "::descricao = " + this.descricao +  "}";
    }
}