package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelOpcionais {

    private int codigo;
    private int tipo;
    private String descricao;
    private String imagem;
    private String pesquisa;

    /**
    * Construtor
    */
    public ModelOpcionais(){}

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    @Override
    public String toString() {
        return "ModelOpcionais{" + "codigo=" + codigo + ", tipo=" + tipo + ", descricao=" + descricao + ", imagem=" + imagem + '}';
    }

    

  
}