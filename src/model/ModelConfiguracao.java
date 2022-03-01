package model;
/**
*
* @author Leandro
*/
public class ModelConfiguracao {

    private int codigo;
    private int ModeloImpresssao;
    private int ModeloCupomMesa;
    private int QuantidadeImpressao;
    private int VisualizarNfce;
    private int MetodoEnvioNfce;
    private int MetodoEnvioNfe;
    private int MetodoEnvioNfse;
    private int classificacaoFiscal;
    private int numeroMesas;
    private String impressoraPdv;
    private String impressoraCozinha;
    private String impressoraDelivery;
    
    

    /**
    * Construtor
    */
    public ModelConfiguracao(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getModeloImpresssao() {
        return ModeloImpresssao;
    }

    public void setModeloImpresssao(int ModeloImpresssao) {
        this.ModeloImpresssao = ModeloImpresssao;
    }

    public int getModeloCupomMesa() {
        return ModeloCupomMesa;
    }

    public void setModeloCupomMesa(int ModeloCupomMesa) {
        this.ModeloCupomMesa = ModeloCupomMesa;
    }

    public int getQuantidadeImpressao() {
        return QuantidadeImpressao;
    }

    public void setQuantidadeImpressao(int QuantidadeImpressao) {
        this.QuantidadeImpressao = QuantidadeImpressao;
    }

    public int getVisualizarNfce() {
        return VisualizarNfce;
    }

    public void setVisualizarNfce(int VisualizarNfce) {
        this.VisualizarNfce = VisualizarNfce;
    }

    public int getMetodoEnvioNfce() {
        return MetodoEnvioNfce;
    }

    public void setMetodoEnvioNfce(int MetodoEnvioNfce) {
        this.MetodoEnvioNfce = MetodoEnvioNfce;
    }

    public int getMetodoEnvioNfe() {
        return MetodoEnvioNfe;
    }

    public void setMetodoEnvioNfe(int MetodoEnvioNfe) {
        this.MetodoEnvioNfe = MetodoEnvioNfe;
    }

    public int getMetodoEnvioNfse() {
        return MetodoEnvioNfse;
    }

    public void setMetodoEnvioNfse(int MetodoEnvioNfse) {
        this.MetodoEnvioNfse = MetodoEnvioNfse;
    }

    public int getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(int classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public int getNumeroMesas() {
        return numeroMesas;
    }

    public void setNumeroMesas(int numeroMesas) {
        this.numeroMesas = numeroMesas;
    }

    public String getImpressoraPdv() {
        return impressoraPdv;
    }

    public void setImpressoraPdv(String impressoraPdv) {
        this.impressoraPdv = impressoraPdv;
    }

    public String getImpressoraCozinha() {
        return impressoraCozinha;
    }

    public void setImpressoraCozinha(String impressoraCozinha) {
        this.impressoraCozinha = impressoraCozinha;
    }

    public String getImpressoraDelivery() {
        return impressoraDelivery;
    }

    public void setImpressoraDelivery(String impressoraDelivery) {
        this.impressoraDelivery = impressoraDelivery;
    }

    @Override
    public String toString() {
        return "ModelConfiguracao{" + "codigo=" + codigo + ", ModeloImpresssao=" + ModeloImpresssao + ", ModeloCupomMesa=" + ModeloCupomMesa + ", QuantidadeImpressao=" + QuantidadeImpressao + ", VisualizarNfce=" + VisualizarNfce + ", MetodoEnvioNfce=" + MetodoEnvioNfce + ", MetodoEnvioNfe=" + MetodoEnvioNfe + ", MetodoEnvioNfse=" + MetodoEnvioNfse + ", classificacaoFiscal=" + classificacaoFiscal + ", numeroMesas=" + numeroMesas + ", impressoraPdv=" + impressoraPdv + ", impressoraCozinha=" + impressoraCozinha + ", impressoraDelivery=" + impressoraDelivery + '}';
    }


    
}