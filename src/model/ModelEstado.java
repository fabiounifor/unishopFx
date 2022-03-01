package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelEstado {

    private int codigo;
    private String uf;
    private String nome;
    

    /**
    * Construtor
    */
    public ModelEstado(){}

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
    * seta o valor de uf
    * @param pUf
    */
    public void setUf(String pUf){
        this.uf = pUf;
    }
    /**
    * return uf
    */
    public String getUf(){
        return this.uf;
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

    @Override
    public String toString(){
        return "ModelEstado {" + "::codigo = " + this.codigo + "::uf = " + this.uf + "::nome = " + this.nome +  "}";
    }
}