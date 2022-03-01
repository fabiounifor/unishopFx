package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelRota {

    private int codigo;
    private String descricao;
    private int taxa;
    private String pesquisaRota;

    /**
    * Construtor
    */
    public ModelRota(){}
    
    public String getPesquisarota() {
        return (codigo + "    " + descricao + "       " +taxa);
    }

    public void setPesquisaRota(String pesquisaRota) {
        this.pesquisaRota = pesquisaRota;
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

    public int getTaxa() {
        return taxa;
    }

    public void setTaxa(int taxa) {
        this.taxa = taxa;
    }

    
    @Override
    public String toString() {
        return "ModelBairro{" + "codigo=" + codigo + ", descricao=" + descricao + ", taxa=" + taxa + '}';
    }

    
}