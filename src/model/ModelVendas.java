package model;

import controller.ControllerCliente;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import nfe.controller.ControllerNF;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.BLMascaras;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ModelVendas {

    private int codigo;
    private int ordem;
    private int produtosCodigo;
    private int clientesCodigo;
    private Date dataVenda;
    private String horaVenda;
    private Date dataPagamento;
    private float quantidade;
    private Double valor;
    private Float valorTotal;
    private Float desconto;
    private int tipoPagamento;
    private ArrayList<ModelVendas> listamModelVendases;
    private int tipo;
    private String observacao;
    private int codigoUsuario;
    private Float taxaEntrega; 
    private int caixa;
    private String vencimento;
    public String pesquisa;
    public int mesa;
    public int garcon;
    private double subTribut;
    private String icmsCst;
    private double icmsRed;
    private String ipiCst;
    private String pisCst;
    private String cofinsCst;

    public double getSubTribut() {
        return subTribut;
    }

    public void setSubTribut(double subTribut) {
        this.subTribut = subTribut;
    }

    public String getIcmsCst() {
        return icmsCst;
    }

    public void setIcmsCst(String icmsCst) {
        this.icmsCst = icmsCst;
    }

    public double getIcmsRed() {
        return icmsRed;
    }

    public void setIcmsRed(double icmsRed) {
        this.icmsRed = icmsRed;
    }

    public String getIpiCst() {
        return ipiCst;
    }

    public void setIpiCst(String ipiCst) {
        this.ipiCst = ipiCst;
    }

    public String getPisCst() {
        return pisCst;
    }

    public void setPisCst(String pisCst) {
        this.pisCst = pisCst;
    }

    public String getCofinsCst() {
        return cofinsCst;
    }

    public void setCofinsCst(String cofinsCst) {
        this.cofinsCst = cofinsCst;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }
    private String cfop;

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    /**
    * Construtor
    */
    public ModelVendas(){}
    
    

    public String getPesquisa() {
        ControllerCliente controllerCliente = new ControllerCliente();
        ControllerNF controllerNF = new ControllerNF();
        String nfe = controllerNF.getNFVendaController(codigo).getNumeroNfe();
        String nomeCliente = (controllerCliente.getClienteControllerCod(clientesCodigo).getNome());
        String tipoDocumento  = "";
        String Status = "";
        String Situacao = "";
        if(nomeCliente == null){
            nomeCliente = "";
        }
        if(nfe == null){
            nfe = "";
        }
        if(!((controllerNF.getNFVendaController(codigo).getModelonfe()) == (null))){
             tipoDocumento = controllerNF.getNFVendaController(codigo).getModelonfe();
             Status = controllerNF.getNFVendaController(codigo).getStatusNfe();
        if(tipoDocumento.equals("55")){
            tipoDocumento = "NFE";
        }else if (tipoDocumento.equals("65")){
            tipoDocumento = "NFCE";
        }if (Status.equals("100")){
          Situacao = "CONCLUIDA"  ;
        }else if (Status.equals("101")){
          Situacao = "CANCELADA";
        }else if (Status.equals("null")){
          Situacao = "REJEITADA";
        }
        return  ("Codigo Venda: "+ codigo +"  Documento: "+nfe+"     Tipo: "+tipoDocumento+ " Cliente: "+nomeCliente+"\n"
                +"Data da Venda: "+ dataVenda+"   Total da Venda: "  + valorTotal + "    Situação: " +Situacao+"\n" );
        }
        else if (tipo == 1){
            tipoDocumento = "PRÉ VENDA";
            Situacao = "AGUARDANDO";
        }else if (tipo == 2){
            tipoDocumento = "ENTREGA";
            Situacao = "AGUARDANDO";
        }else if (tipo == 3){
            tipoDocumento = "ENTREGA";
            Situacao = "SAIU PARA ENTREGA";
        }else if (tipo == 4){
            tipoDocumento = "ENTREGA";
            Situacao = "ENTREGA EFETUADA";
        }
        
           return  ("Codigo Venda: "+ codigo +"  Tipo: "+tipoDocumento+ " Cliente: "+nomeCliente+"\n"
                +"Data/hora: "+ dataVenda + " " + horaVenda+"  Total: "  + valorTotal + " Situação: " +Situacao+"\n" );
    }
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getGarcon() {
        return garcon;
    }

    public void setGarcon(int garcon) {
        this.garcon = garcon;
    }
    
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

/* 
    return numero de caixa
    
    */
    public int getCaixa() {
        return this.caixa;
    }
    /**
        
* @param caixa
*/
    public void setCaixa(int caixa) {
        this.caixa = caixa;
    }


    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    /**
    * seta o valor de produtosCodigo
    * @param pProdutosCodigo
    */
    public void setProdutosCodigo(int pProdutosCodigo){
        this.produtosCodigo = pProdutosCodigo;
    }
    /**
    * return produtosCodigo
    */
    public int getProdutosCodigo(){
        return this.produtosCodigo;
    }

    /**
    * seta o valor de clientesCodigo
    * @param pClientesCodigo
    */
    public void setClientesCodigo(int pClientesCodigo){
        this.clientesCodigo = pClientesCodigo;
    }
    /**
    * return clientesCodigo
    */
    public int getClientesCodigo(){
        return this.clientesCodigo;
    }

    /**
    * seta o valor de dataVenda
    * @param pDataVenda
    */
    
    public void setDataVenda(Date pDataVenda) throws Exception{
        BLMascaras  blMascaras = new BLMascaras();
        this.dataVenda = blMascaras.converterDataParaDateHourUS(pDataVenda);
    }
    /**
    * return dataVenda
    */
    public Date getDataVenda(){
        return this.dataVenda;
    }
   
    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(float pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
    */
    public float getQuantidade(){
        return this.quantidade;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::codigo = " + this.codigo + "::produtosCodigo = " + this.produtosCodigo + "::clientesCodigo = " + this.clientesCodigo + "::dataVenda = " + this.dataVenda + "::quantidade = " + this.quantidade +  ":: caixa = " + this.caixa + ":: total = " + this.valorTotal + ":: pagamento = " + this.tipoPagamento + ")";
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the listamModelVendases
     */
    public ArrayList<ModelVendas> getListamModelVendases() {
        return listamModelVendases;
    }

    /**
     * @param listamModelVendases the listamModelVendases to set
     */
    public void setListamModelVendases(ArrayList<ModelVendas> listamModelVendases) {
        this.listamModelVendases = listamModelVendases;
    }

    /**
     * @return the valorTotal
     */
    public Float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the desconto
     */
    public Float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the tipoPagamento
     */
    public int getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @param tipoPagamento the tipoPagamento to set
     */
    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
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
     * @return the taxaEntrega
     */
    public Float getTaxaEntrega() {
        return taxaEntrega;
    }

    /**
     * @param taxaEntrega the taxaEntrega to set
     */
    public void setTaxaEntrega(Float taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    
}