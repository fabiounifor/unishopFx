package model;
/**
*
* @author BLSoft
*/
public class ModelItensPedidoMesaAtivo {

    private int codigo;
    private int codigoMesa;
    private int codigoProduto;
    private String statusPedido;
    private String observacao;
    private float quantidade;
    private String hora;
    private int codigoGarcom;
    private double valor;
    private String nomeProduto;

    /**
    * Construtor
    */
    public ModelItensPedidoMesaAtivo(){}

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    
    
    
    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return pk_codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de codigoMesa
    * @param pCodigoMesa
    */
    public void setCodigoMesa(int pCodigoMesa){
        this.codigoMesa = pCodigoMesa;
    }
    /**
    * return fk_codigoMesa
    */
    public int getCodigoMesa(){
        return this.codigoMesa;
    }

    /**
    * seta o valor de codigoProduto
    * @param pCodigoProduto
    */
    public void setCodigoProduto(int pCodigoProduto){
        this.codigoProduto = pCodigoProduto;
    }
    /**
    * return fk_codigoProduto
    */
    public int getCodigoProduto(){
        return this.codigoProduto;
    }

    /**
    * seta o valor de statusPedido
    * @param pStatusPedido
    */
    public void setStatusPedido(String pStatusPedido){
        this.statusPedido = pStatusPedido;
    }
    /**
    * return statusPedido
    */
    public String getStatusPedido(){
        return this.statusPedido;
    }

    /**
    * seta o valor de observacao
    * @param pObservacao
    */
    public void setObservacao(String pObservacao){
        this.observacao = pObservacao;
    }
    /**
    * return observacao
    */
    public String getObservacao(){
        return this.observacao;
    }

    @Override
    public String toString(){
        return "ModelItensPedidoMesa {" + "::codigo = " + this.codigo + "::codigoMesa = " + this.codigoMesa + "::codigoProduto = " + this.codigoProduto + "::statusPedido = " + this.statusPedido + "::observacao = " + this.observacao +  "::Valor = " + this.valor +    "}";
    }

    /**
     * @return the quantidade
     */
    public float getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the codigoGarcom
     */
    public int getCodigoGarcom() {
        return codigoGarcom;
    }

    /**
     * @param codigoGarcom the codigoGarcom to set
     */
    public void setCodigoGarcom(int codigoGarcom) {
        this.codigoGarcom = codigoGarcom;
    }
}