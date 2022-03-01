package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelBairro {

    private int codigo;
    private String descricao;
    private int rota;
    private int cidade;
    private String pesquisaBairro;

    /**
    * Construtor
    */
    public ModelBairro(){}
    
    public String getPesquisaBairro() {
        return (codigo + "    " + rota + "       " +descricao);
    }

    public void setPesquisaBairro(String pesquisaBairro) {
        this.pesquisaBairro = pesquisaBairro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRota() {
        return rota;
    }

    public void setRota(int rota) {
        this.rota = rota;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "ModelBairro{" + "codigo=" + codigo + ", descricao=" + descricao + ", rota=" + rota + ", cidade=" + cidade + '}';
    }

    
}