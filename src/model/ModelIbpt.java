package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelIbpt {

private int codigoNcm;
private int excecao;
private int tipo;
private String descricao;
private double nacionalfederal;
private double importadosfederal;
private double municipal;
private double estadual;
private String vigenciainicio;
private String vigenciafim;
private String  chave;
private String versao;
private String fonte;
    

    /**
    * Construtor
    */
    public ModelIbpt(){}

    public int getCodigoNcm() {
        return codigoNcm;
    }

    public void setCodigoNcm(int codigoNcm) {
        this.codigoNcm = codigoNcm;
    }

    public int getExcecao() {
        return excecao;
    }

    public void setExcecao(int excecao) {
        this.excecao = excecao;
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

    public double getNacionalfederal() {
        return nacionalfederal;
    }

    public void setNacionalfederal(double nacionalfederal) {
        this.nacionalfederal = nacionalfederal;
    }

    public double getImportadosfederal() {
        return importadosfederal;
    }

    public void setImportadosfederal(double importadosfederal) {
        this.importadosfederal = importadosfederal;
    }

    public double getMunicipal() {
        return municipal;
    }

    public void setMunicipal(double municipal) {
        this.municipal = municipal;
    }

    public double getEstadual() {
        return estadual;
    }

    public void setEstadual(double estadual) {
        this.estadual = estadual;
    }

    public String getVigenciainicio() {
        return vigenciainicio;
    }

    public void setVigenciainicio(String vigenciainicio) {
        this.vigenciainicio = vigenciainicio;
    }

    public String getVigenciafim() {
        return vigenciafim;
    }

    public void setVigenciafim(String vigenciafim) {
        this.vigenciafim = vigenciafim;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @Override
    public String toString() {
        return "Modelbpt{" + "codigoNcm=" + codigoNcm + ", excecao=" + excecao + ", tipo=" + tipo + ", descricao=" + descricao + ", nacionalfederal=" + nacionalfederal + ", importadosfederal=" + importadosfederal + ", municipal=" + municipal + ", estadual=" + estadual + ", vigenciainicio=" + vigenciainicio + ", vigenciafim=" + vigenciafim + ", chave=" + chave + ", versao=" + versao + ", fonte=" + fonte + '}';
    }

  
}