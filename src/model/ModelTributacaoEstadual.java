package model;
/**
*
* @author Leandro
*/

import controller.ControllerEstado;


public class ModelTributacaoEstadual {

    private int codigo;
    private String descricao;
    private int idestado;
    private float percentual;
    private int idcfop;
    private int idcsosn;
    private float basedecalculo;
    private int origem;
    private float basedecalculosub;
    private float basedecalculosubefetivo;
    private float basedecalculoicms;
    private float basedecalculoicmsretido;
    public String pesquisa;

    /**
    * Construtor
    */
    ControllerEstado controllerEstado = new ControllerEstado();
        
    public ModelTributacaoEstadual(){}

    public String getPesquisa() {
        String estado = controllerEstado.getEstadoControllerCod(idestado).getUf();
         return (descricao + "  " + estado );
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
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

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }

    public int getIdcfop() {
        return idcfop;
    }

    public void setIdcfop(int idcfop) {
        this.idcfop = idcfop;
    }

    public int getIdcsosn() {
        return idcsosn;
    }

    public void setIdcsosn(int idcsosn) {
        this.idcsosn = idcsosn;
    }

    public float getBasedecalculo() {
        return basedecalculo;
    }

    public void setBasedecalculo(float basedecalculo) {
        this.basedecalculo = basedecalculo;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public float getBasedecalculosub() {
        return basedecalculosub;
    }

    public void setBasedecalculosub(float basedecalculosub) {
        this.basedecalculosub = basedecalculosub;
    }

    public float getBasedecalculosubefetivo() {
        return basedecalculosubefetivo;
    }

    public void setBasedecalculosubefetivo(float basedecalculosubefetivo) {
        this.basedecalculosubefetivo = basedecalculosubefetivo;
    }

    public float getBasedecalculoicms() {
        return basedecalculoicms;
    }

    public void setBasedecalculoicms(float basedecalculoicms) {
        this.basedecalculoicms = basedecalculoicms;
    }

    public float getBasedecalculoicmsretido() {
        return basedecalculoicmsretido;
    }

    public void setBasedecalculoicmsretido(float basedecalculoicmsretido) {
        this.basedecalculoicmsretido = basedecalculoicmsretido;
    }

    @Override
    public String toString() {
        return "ModelTributacaoEstadual{" + "codigo=" + codigo + ", descricao=" + descricao + ", idestado=" + idestado + ", percentual=" + percentual + ", idcfop=" + idcfop + ", idcsosn=" + idcsosn + ", basedecalculo=" + basedecalculo + ", origem=" + origem + ", basedecalculosub=" + basedecalculosub + ", basedecalculosubefetivo=" + basedecalculosubefetivo + ", basedecalculoicms=" + basedecalculoicms + ", basedecalculoicmsretido=" + basedecalculoicmsretido + '}';
    }

    
}