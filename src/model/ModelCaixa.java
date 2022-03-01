package model;

import java.sql.Date;
import util.BLMascaras;

/**
*
* @author contato@blsoft.com.br
*/
public class ModelCaixa {

    private int codigo;
    private double dinheiro;
    private double dinheiroUsuario;
    private double cheque;
    private double chequeUsuario;
    private double cartao;
    private double cartaoUsuario;
    private double convenio;
    private double convenioUsuario;
    private double fundoUsuario;
    private double diferencaUsuario;
    private double sangria;
    private int caixaNumero;
    private int codigoUsuario;
    private int status;
    private String dataAbertura;
    private String dataFechamento;
    
  
    /**
    * Construtor
    */
    public ModelCaixa(){}
BLMascaras bLMascaras = new BLMascaras();
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
    * seta o valor de dinheiro
    * @param pDinheiro
    */
    public void setDinheiro(double pDinheiro){
        this.dinheiro = bLMascaras.arredondamentoComPontoDuasCasasDouble(pDinheiro);
    }
    /**
    * return dinheiro
    */
    public double getDinheiro(){
        return this.dinheiro;
    }

    public double getDinheiroUsuario() {
        return dinheiroUsuario;
    }

    public void setDinheiroUsuario(double dinheiroUsuario) {
        this.dinheiroUsuario = bLMascaras.arredondamentoComPontoDuasCasasDouble(dinheiroUsuario);
    }

    
    /**
    * seta o valor de cheque
    * @param pCheque
    */
    public void setCheque(double pCheque){
        this.cheque = bLMascaras.arredondamentoComPontoDuasCasasDouble(pCheque);
    }
    /**
    * return cheque
    */
    public double getCheque(){
        return this.cheque;
    }

    public double getChequeUsuario() {
        return chequeUsuario;
    }

    public void setChequeUsuario(double chequeUsuario) {
        this.chequeUsuario = bLMascaras.arredondamentoComPontoDuasCasasDouble(chequeUsuario);
    }

    /**
    * seta o valor de cartao
    * @param pCartao
    */
    public void setCartao(double pCartao){
        this.cartao = bLMascaras.arredondamentoComPontoDuasCasasDouble(pCartao);
    }
    /**
    * return cartao
    */
    public double getCartao(){
        return this.cartao;
    }

    public double getCartaoUsuario() {
        return cartaoUsuario;
    }

    public void setCartaoUsuario(double cartaoUsuario) {
        this.cartaoUsuario = bLMascaras.arredondamentoComPontoDuasCasasDouble(cartaoUsuario);
    }

    /**
    * seta o valor de convenio
    * @param pVale
    */
    public void setConvenio(double pVale){
        this.convenio = bLMascaras.arredondamentoComPontoDuasCasasDouble(pVale);
    }
    /**
    * return convenio
    */
    public double getConvenio(){
        return this.convenio;
    }

    public double getConvenioUsuario() {
        return convenioUsuario;
    }

    public void setConvenioUsuario(double convenioUsuario) {
        this.convenioUsuario = bLMascaras.arredondamentoComPontoDuasCasasDouble(convenioUsuario);
    }

    public double getFundoUsuario() {
        return fundoUsuario;
    }

    public void setFundoUsuario(double fundoUsuario) {
        this.fundoUsuario = bLMascaras.arredondamentoComPontoDuasCasasDouble(fundoUsuario);
    }

    public double getDiferencaUsuario() {
        return diferencaUsuario;
    }

    public void setDiferencaUsuario(double diferencaUsuario) {
        this.diferencaUsuario = bLMascaras.arredondamentoComPontoDuasCasasDouble(diferencaUsuario);
    }
    
    

       /**
     * @return the caixaNumero
     */
    public int getCaixaNumero() {
        return caixaNumero;
    }

    /**
     * @param caixaNumero the caixaNumero to set
     */
    public void setCaixaNumero(int caixaNumero) {
        this.caixaNumero = caixaNumero;
    }

    /**
     * @return the codigoUsuario
     */
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the dataAbertura
     */
    public String getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getSangria() {
        return sangria;
    }

    public void setSangria(double sangria) {
        this.sangria = sangria;
    }

    @Override
    public String toString() {
        return "ModelCaixa{" + "codigo=" + codigo + ", dinheiro=" + dinheiro + ", dinheiroUsuario=" + dinheiroUsuario + ", cheque=" + cheque + ", chequeUsuario=" + chequeUsuario + ", cartao=" + cartao + ", cartaoUsuario=" + cartaoUsuario + ", convenio=" + convenio + ", convenioUsuario=" + convenioUsuario + ", fundoUsuario=" + fundoUsuario + ", diferencaUsuario=" + diferencaUsuario + ", sangria=" + sangria + ", caixaNumero=" + caixaNumero + ", codigoUsuario=" + codigoUsuario + ", status=" + status + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", bLMascaras=" + bLMascaras + '}';
    }
    
    

    
    
 
    
}