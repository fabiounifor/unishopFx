package model;
/**
*
* @author Leandro
*/
public class ModelTributacaoFederal {

    private int codigo;
    private String descricao;
    private int idIpi;
    private int idPisCofins;
    

    /**
    * Construtor
    */
    public ModelTributacaoFederal(){}

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

    public int getIdIpi() {
        return idIpi;
    }

    public void setIdIpi(int idIpi) {
        this.idIpi = idIpi;
    }

    public int getIdPisCofins() {
        return idPisCofins;
    }

    public void setIdPisCofins(int idPisCofins) {
        this.idPisCofins = idPisCofins;
    }

    @Override
    public String toString() {
        return "ModelTributacaoFederal{" + "codigo=" + codigo + ", descricao=" + descricao + ", idIpi=" + idIpi + ", idPisCofins=" + idPisCofins + '}';
    }

    

    
}