package nfe.model;

import controller.ControllerFornecedor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
*
* @author Nazareth
*/
public class ModelNF {

    private int empresa;
    private int pedido;
    private int codCliente;
    private String docCliente;
    private String nomeDocumento;
    private int codFormaPgto;
    private String codTipoDoc;
    private int codBanco;
    private Date dataDigitacao;
    private double valorProdutos;
    private double valorDescontos;
    private double valorTotal;
    private int codTransportadora;
    private String dadosAdicionais;
    private int qtdeVolume ;
    private double pesoVolume;
    private String placaVeiculo;
    private String ufPlaca;
    private String pedidoCliente;
    private String modelonfe;
    private String numeroNfe;
    private String serieNfe;
    private Date dataEmissao;
    private String chaveNfe;
    private double icmsBc;
    private double icmsVlr;
    private double ipiBc;
    private double ipiVlr;
    private double pisBc;
    private double pisVlr;
    private double cofinsBc;
    private double cofinsVlr;
    private double vtottrib;
    private String numNfeFat;
    private String finNfe;
    private Date dataCancelamento;
    private String numNfeDev;
    private Date dataDevolucao;
    private String qrcode;
    private String tpemis;
    private String tpamb;
    private String pedidoInterno;
    private double vtotibpt;
    private String refnfe;
    private String statusNfe;
    private String motivoNfe;
    private String BCSubst;
    private String ICMSSubst;
    private String outros;
    private String pesquisa;
    private ArrayList<ModelNF> listaNf;

    /**
    * Construtor
    */
    public ModelNF(){}

    public String getPesquisa() {
        controller.ControllerFornecedor cf = new ControllerFornecedor();
        return dataEmissao+ "      "+ cf.getFornecedorController(codCliente).getNome() +"\n" 
              + chaveNfe + "          "+ numeroNfe; 
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    

    public ArrayList<ModelNF> getListaNf() {
        return listaNf;
    }

    public void setListaNf(ArrayList<ModelNF> listaNf) {
        this.listaNf = listaNf;
    }

    public String getBCSubst() {
        return BCSubst;
    }

    public void setBCSubst(String BCSubst) {
        this.BCSubst = BCSubst;
    }

    public String getICMSSubst() {
        return ICMSSubst;
    }

    public void setICMSSubst(String ICMSSubst) {
        this.ICMSSubst = ICMSSubst;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }
    
    

    /**
    * seta o valor de empresa
    * @param pEmpresa
    */
    public void setEmpresa(int pEmpresa){
        this.empresa = pEmpresa;
    }
    /**
    * return empresa
    */
    public int getEmpresa(){
        return this.empresa;
    }

    /**
    * seta o valor de pedido
    * @param pPedido
    */
    public void setPedido(int pPedido){
        this.pedido = pPedido;
    }
    /**
    * return pedido
    */
    public int getPedido(){
        return this.pedido;
    }

    /**
    * seta o valor de codCliente
    * @param pCodCliente
    */
    public void setCodCliente(int pCodCliente){
        this.codCliente = pCodCliente;
    }
    /**
    * return codCliente
    */
    public int getCodCliente(){
        return this.codCliente;
    }

    /**
    * seta o valor de docCliente
    * @param pDocCliente
    */
    public void setDocCliente(String pDocCliente){
        this.docCliente = pDocCliente;
    }
    /**
    * return docCliente
    */
    public String getDocCliente(){
        return this.docCliente;
    }

    /**
    * seta o valor de nomeDocumento
    * @param pNomeDocumento
    */
    public void setNomeDocumento(String pNomeDocumento){
        this.nomeDocumento = pNomeDocumento;
    }
    /**
    * return nomeDocumento
    */
    public String getNomeDocumento(){
        return this.nomeDocumento;
    }

    /**
    * seta o valor de codFormaPgto
    * @param pCodFormaPgto
    */
    public void setCodFormaPgto(int pCodFormaPgto){
        this.codFormaPgto = pCodFormaPgto;
    }
    /**
    * return codFormaPgto
    */
    public int getCodFormaPgto(){
        return this.codFormaPgto;
    }

    /**
    * seta o valor de codTipoDoc 
    * @param pCodTipoDoc 
    */
    public void setCodTipoDoc (String pCodTipoDoc ){
        this.codTipoDoc = pCodTipoDoc;
    }
    /**
    * return codTipoDoc 
    */
    public String getCodTipoDoc (){
        return this.codTipoDoc;
    }

    /**
    * seta o valor de codBanco
    * @param pCodBanco
    */
    public void setCodBanco(int pCodBanco){
        this.codBanco = pCodBanco;
    }
    /**
    * return codBanco
    */
    public int getCodBanco(){
        return this.codBanco;
    }

    /**
    * seta o valor de dataDigitacao
    * @param pDataDigitacao
    */
    public void setDataDigitacao(Date pDataDigitacao){
        this.dataDigitacao = pDataDigitacao;
    }
    /**
    * return dataDigitacao
    */
    public Date getDataDigitacao(){
        return this.dataDigitacao;
    }

    /**
    * seta o valor de valorProdutos
    * @param pValorProdutos
    */
    public void setValorProdutos(double pValorProdutos){
        this.valorProdutos = pValorProdutos;
    }
    /**
    * return valorProdutos
    */
    public double getValorProdutos(){
        return this.valorProdutos;
    }

    /**
    * seta o valor de valorDescontos
    * @param pValorDescontos
    */
    public void setValorDescontos(double pValorDescontos){
        this.valorDescontos = pValorDescontos;
    }
    /**
    * return valorDescontos
    */
    public double getValorDescontos(){
        return this.valorDescontos;
    }

    /**
    * seta o valor de valorTotal
    * @param pValorTotal
    */
    public void setValorTotal(double pValorTotal){
        this.valorTotal = pValorTotal;
    }
    /**
    * return valorTotal
    */
    public double getValorTotal(){
        return this.valorTotal;
    }

    /**
    * seta o valor de codTransportadora
    * @param pCodTransportadora
    */
    public void setCodTransportadora(int pCodTransportadora){
        this.codTransportadora = pCodTransportadora;
    }
    /**
    * return codTransportadora
    */
    public int getCodTransportadora(){
        return this.codTransportadora;
    }

    /**
    * seta o valor de dadosAdicionais
    * @param pDadosAdicionais
    */
    public void setDadosAdicionais(String pDadosAdicionais){
        this.dadosAdicionais = pDadosAdicionais;
    }
    /**
    * return dadosAdicionais
    */
    public String getDadosAdicionais(){
        return this.dadosAdicionais;
    }

    /**
    * seta o valor de qtdeVolume 
    * @param pQtdeVolume 
    */
    public void setQtdeVolume (int pQtdeVolume ){
        this.qtdeVolume  = pQtdeVolume ;
    }
    /**
    * return qtdeVolume 
    */
    public int getQtdeVolume (){
        return this.qtdeVolume ;
    }

    /**
    * seta o valor de pesoVolume
    * @param pPesoVolume
    */
    public void setPesoVolume(double pPesoVolume){
        this.pesoVolume = pPesoVolume;
    }
    /**
    * return pesoVolume
    */
    public double getPesoVolume(){
        return this.pesoVolume;
    }

    /**
    * seta o valor de placaVeiculo
    * @param pPlacaVeiculo
    */
    public void setPlacaVeiculo(String pPlacaVeiculo){
        this.placaVeiculo = pPlacaVeiculo;
    }
    /**
    * return placaVeiculo
    */
    public String getPlacaVeiculo(){
        return this.placaVeiculo;
    }

    /**
    * seta o valor de ufPlaca
    * @param pUfPlaca
    */
    public void setUfPlaca(String pUfPlaca){
        this.ufPlaca = pUfPlaca;
    }
    /**
    * return ufPlaca
    */
    public String getUfPlaca(){
        return this.ufPlaca;
    }

    /**
    * seta o valor de pedidoCliente
    * @param pPedidoCliente
    */
    public void setPedidoCliente(String pPedidoCliente){
        this.pedidoCliente = pPedidoCliente;
    }
    /**
    * return pedidoCliente
    */
    public String getPedidoCliente(){
        return this.pedidoCliente;
    }

    /**
    * seta o valor de modelonfe
    * @param pModelonfe
    */
    public void setModelonfe(String pModelonfe){
        this.modelonfe = pModelonfe;
    }
    /**
    * return modelonfe
    */
    public String getModelonfe(){
        return this.modelonfe;
    }

    /**
    * seta o valor de numeroNfe
    * @param pNumeroNfe
    */
    public void setNumeroNfe(String pNumeroNfe){
        this.numeroNfe = pNumeroNfe;
    }
    /**
    * return numeroNfe
    */
    public String getNumeroNfe(){
        return this.numeroNfe;
    }

    /**
    * seta o valor de serieNfe
    * @param pSerieNfe
    */
    public void setSerieNfe(String pSerieNfe){
        this.serieNfe = pSerieNfe;
    }
    /**
    * return serieNfe
    */
    public String getSerieNfe(){
        return this.serieNfe;
    }

    /**
    * seta o valor de dataEmissao
    * @param pDataEmissao
    */
    public void setDataEmissao(Date pDataEmissao){
        this.dataEmissao = pDataEmissao;
    }
    /**
    * return dataEmissao
    */
    public Date getDataEmissao(){
        return this.dataEmissao;
    }

    /**
    * seta o valor de chaveNfe
    * @param pChaveNfe
    */
    public void setChaveNfe(String pChaveNfe){
        this.chaveNfe = pChaveNfe;
    }
    /**
    * return chaveNfe
    */
    public String getChaveNfe(){
        return this.chaveNfe;
    }

    /**
    * seta o valor de icmsBc
    * @param pIcmsBc
    */
    public void setIcmsBc(double pIcmsBc){
        this.icmsBc = pIcmsBc;
    }
    /**
    * return icmsBc
    */
    public double getIcmsBc(){
        return this.icmsBc;
    }

    /**
    * seta o valor de icmsVlr
    * @param pIcmsVlr
    */
    public void setIcmsVlr(double pIcmsVlr){
        this.icmsVlr = pIcmsVlr;
    }
    /**
    * return icmsVlr
    */
    public double getIcmsVlr(){
        return this.icmsVlr;
    }

    /**
    * seta o valor de ipiBc
    * @param pIpiBc
    */
    public void setIpiBc(double pIpiBc){
        this.ipiBc = pIpiBc;
    }
    /**
    * return ipiBc
    */
    public double getIpiBc(){
        return this.ipiBc;
    }

    /**
    * seta o valor de ipiVlr
    * @param pIpiVlr
    */
    public void setIpiVlr(double pIpiVlr){
        this.ipiVlr = pIpiVlr;
    }
    /**
    * return ipiVlr
    */
    public double getIpiVlr(){
        return this.ipiVlr;
    }

    /**
    * seta o valor de pisBc
    * @param pPisBc
    */
    public void setPisBc(double pPisBc){
        this.pisBc = pPisBc;
    }
    /**
    * return pisBc
    */
    public double getPisBc(){
        return this.pisBc;
    }

    /**
    * seta o valor de pisVlr
    * @param pPisVlr
    */
    public void setPisVlr(double pPisVlr){
        this.pisVlr = pPisVlr;
    }
    /**
    * return pisVlr
    */
    public double getPisVlr(){
        return this.pisVlr;
    }

    /**
    * seta o valor de cofinsBc
    * @param pCofinsBc
    */
    public void setCofinsBc(double pCofinsBc){
        this.cofinsBc = pCofinsBc;
    }
    /**
    * return cofinsBc
    */
    public double getCofinsBc(){
        return this.cofinsBc;
    }

    /**
    * seta o valor de cofinsVlr
    * @param pCofinsVlr
    */
    public void setCofinsVlr(double pCofinsVlr){
        this.cofinsVlr = pCofinsVlr;
    }
    /**
    * return cofinsVlr
    */
    public double getCofinsVlr(){
        return this.cofinsVlr;
    }

    /**
    * seta o valor de vtottrib
    * @param pVtottrib
    */
    public void setVtottrib(double pVtottrib){
        this.vtottrib = pVtottrib;
    }
    /**
    * return vtottrib
    */
    public double getVtottrib(){
        return this.vtottrib;
    }

    /**
    * seta o valor de numNfeFat
    * @param pNumNfeFat
    */
    public void setNumNfeFat(String pNumNfeFat){
        this.numNfeFat = pNumNfeFat;
    }
    /**
    * return numNfeFat
    */
    public String getNumNfeFat(){
        return this.numNfeFat;
    }

    /**
    * seta o valor de finNfe
    * @param pFinNfe
    */
    public void setFinNfe(String pFinNfe){
        this.finNfe = pFinNfe;
    }
    /**
    * return finNfe
    */
    public String getFinNfe(){
        return this.finNfe;
    }

    /**
    * seta o valor de dataCancelamento
    * @param pDataCancelamento
    */
    public void setDataCancelamento(Date pDataCancelamento){
        this.dataCancelamento = pDataCancelamento;
    }
    /**
    * return dataCancelamento
    */
    public Date getDataCancelamento(){
        return this.dataCancelamento;
    }

    /**
    * seta o valor de numNfeDev
    * @param pNumNfeDev
    */
    public void setNumNfeDev(String pNumNfeDev){
        this.numNfeDev = pNumNfeDev;
    }
    /**
    * return numNfeDev
    */
    public String getNumNfeDev(){
        return this.numNfeDev;
    }

    /**
    * seta o valor de dataDevolucao
    * @param pDataDevolucao
    */
    public void setDataDevolucao(Date pDataDevolucao){
        this.dataDevolucao = pDataDevolucao;
    }
    /**
    * return dataDevolucao
    */
    public Date getDataDevolucao(){
        return this.dataDevolucao;
    }

    /**
    * seta o valor de qrcode
    * @param pQrcode
    */
    public void setQrcode(String pQrcode){
        this.qrcode = pQrcode;
    }
    /**
    * return qrcode
    */
    public String getQrcode(){
        return this.qrcode;
    }

    /**
    * seta o valor de tpemis
    * @param pTpemis
    */
    public void setTpemis(String pTpemis){
        this.tpemis = pTpemis;
    }
    /**
    * return tpemis
    */
    public String getTpemis(){
        return this.tpemis;
    }

    /**
    * seta o valor de tpamb
    * @param pTpamb
    */
    public void setTpamb(String pTpamb){
        this.tpamb = pTpamb;
    }
    /**
    * return tpamb
    */
    public String getTpamb(){
        return this.tpamb;
    }

    /**
    * seta o valor de pedidoInterno
    * @param pPedidoInterno
    */
    public void setPedidoInterno(String pPedidoInterno){
        this.pedidoInterno = pPedidoInterno;
    }
    /**
    * return pedidoInterno
    */
    public String getPedidoInterno(){
        return this.pedidoInterno;
    }

    /**
    * seta o valor de vtotibpt
    * @param pVtotibpt
    */
    public void setVtotibpt(double pVtotibpt){
        this.vtotibpt = pVtotibpt;
    }
    /**
    * return vtotibpt
    */
    public double getVtotibpt(){
        return this.vtotibpt;
    }

    /**
    * seta o valor de refnfe
    * @param pRefnfe
    */
    public void setRefnfe(String pRefnfe){
        this.refnfe = pRefnfe;
    }
    /**
    * return refnfe
    */
    public String getRefnfe(){
        return this.refnfe;
    }

    /**
    * seta o valor de statusNfe
    * @param pStatusNfe
    */
    public void setStatusNfe(String pStatusNfe){
        this.statusNfe = pStatusNfe;
    }
    /**
    * return statusNfe
    */
    public String getStatusNfe(){
        return this.statusNfe;
    }

    /**
    * seta o valor de motivoNfe
    * @param pMotivoNfe
    */
    public void setMotivoNfe(String pMotivoNfe){
        this.motivoNfe = pMotivoNfe;
    }
    /**
    * return motivoNfe
    */
    public String getMotivoNfe(){
        return this.motivoNfe;
    }

    @Override
    public String toString(){
        return "ModelNF {" + "::empresa = " + this.empresa + "::pedido = " + this.pedido + "::codCliente = " + this.codCliente + "::docCliente = " + this.docCliente + "::nomeDocumento = " + this.nomeDocumento + "::codFormaPgto = " + this.codFormaPgto + "::codTipoDoc  = " + this.codTipoDoc  + "::codBanco = " + this.codBanco + "::dataDigitacao = " + this.dataDigitacao + "::valorProdutos = " + this.valorProdutos + "::valorDescontos = " + this.valorDescontos + "::valorTotal = " + this.valorTotal + "::codTransportadora = " + this.codTransportadora + "::dadosAdicionais = " + this.dadosAdicionais + "::qtdeVolume  = " + this.qtdeVolume  + "::pesoVolume = " + this.pesoVolume + "::placaVeiculo = " + this.placaVeiculo + "::ufPlaca = " + this.ufPlaca + "::pedidoCliente = " + this.pedidoCliente + "::modelonfe = " + this.modelonfe + "::numeroNfe = " + this.numeroNfe + "::serieNfe = " + this.serieNfe + "::dataEmissao = " + this.dataEmissao + "::chaveNfe = " + this.chaveNfe + "::icmsBc = " + this.icmsBc + "::icmsVlr = " + this.icmsVlr + "::ipiBc = " + this.ipiBc + "::ipiVlr = " + this.ipiVlr + "::pisBc = " + this.pisBc + "::pisVlr = " + this.pisVlr + "::cofinsBc = " + this.cofinsBc + "::cofinsVlr = " + this.cofinsVlr + "::vtottrib = " + this.vtottrib + "::numNfeFat = " + this.numNfeFat + "::finNfe = " + this.finNfe + "::dataCancelamento = " + this.dataCancelamento + "::numNfeDev = " + this.numNfeDev + "::dataDevolucao = " + this.dataDevolucao + "::qrcode = " + this.qrcode + "::tpemis = " + this.tpemis + "::tpamb = " + this.tpamb + "::pedidoInterno = " + this.pedidoInterno + "::vtotibpt = " + this.vtotibpt + "::refnfe = " + this.refnfe + "::statusNfe = " + this.statusNfe + "::motivoNfe = " + this.motivoNfe +  "}";
    }
}