package model;

import controller.ControllerComprasProdutos;
import controller.ControllerProdutos;
import java.util.ArrayList;
import controller.ControllerFator;
import controller.ControllerCFOP;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
*
* @author BLSoft
*/
public class ModelComprasProdutos {

    private int ordem;
    private int codigo;
    private int codCompras;
    private String codProdutoFornecedor;
    private int codProduto;
    private String nomeProduto;
    private String nomeProdutoEstoque;
    private String barras;
    private String ncm;
    private String cest;
    private String cst;
    private String cfop;
    private String unidade;
    private String cfopEstoque;
    private String fatorConversao;
    private String percCreditoSn;
    private String valorCreditoSn;
    private String baseCalculoSub;
    private String baseCalculoicms;
    private String valorIpi;
    private String percIpi;
    private String codFornecedor;
    private double valorCusto;
    private double valorTotal;
    private Float quantidade;
    private Button procurarProduto;
    private Button adcionarProduto;
    private Button procurarFator;
    private Button procurarCfop;
    private int controle = 0;
    private ModelProdutos modelProdutos;
    private ArrayList<ModelComprasProdutos> listaModelComprasProdutos;

    ControllerComprasProdutos cp = new ControllerComprasProdutos();
    ControllerProdutos cpc = new ControllerProdutos();
    ControllerFator cf = new ControllerFator();
    ControllerCFOP controllerCfop = new ControllerCFOP();
   
    public ModelComprasProdutos() {
    }
    
    public String getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(String valorIpi) {
        this.valorIpi = valorIpi;
    }

    public String getPercIpi() {
        return percIpi;
    }

    public void setPercIpi(String percIpi) {
        this.percIpi = percIpi;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getBaseCalculoSub() {
        return baseCalculoSub;
    }

    public void setBaseCalculoSub(String baseCalculoSub) {
        this.baseCalculoSub = baseCalculoSub;
    }

    public String getBaseCalculoicms() {
        return baseCalculoicms;
    }

    public void setBaseCalculoicms(String baseCalculoicms) {
        this.baseCalculoicms = baseCalculoicms;
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

    public String getCodProdutoFornecedor() {
        return codProdutoFornecedor;
    }

    public void setCodProdutoFornecedor(String codProdutoFornecedor) {
        this.codProdutoFornecedor = codProdutoFornecedor;
    }

    public String getNomeProduto() {
     
        return nomeProduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getPercCreditoSn() {
        return percCreditoSn;
    }

    public void setPercCreditoSn(String percCreditoSn) {
        this.percCreditoSn = percCreditoSn;
    }

    public String getValorCreditoSn() {
        return valorCreditoSn;
    }

    public void setValorCreditoSn(String valorCreditoSn) {
        this.valorCreditoSn = valorCreditoSn;
    }
    
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProdutoEstoque() {
        if(cp.getcompras_produtosControllerCodForn(codProdutoFornecedor, codFornecedor).getNomeProduto()!= null){
        nomeProdutoEstoque = cp.getcompras_produtosControllerCodForn(codProdutoFornecedor, codFornecedor).getNomeProduto();
         }else if((!(barras.contains("GTIN"))) && cpc.getProdutosCodigoBarrasController(barras).getDescricaoProduto() != null ){
        nomeProdutoEstoque = cpc.getProdutosCodigoBarrasController(barras).getDescricaoProduto();     
         }else if(cpc.getProdutosController(nomeProduto).getDescricaoProduto() != null ){
        nomeProdutoEstoque = cpc.getProdutosController(nomeProduto).getDescricaoProduto();     
         }
        return nomeProdutoEstoque;
    }

    public void setNomeProdutoEstoque(String nomeProdutoEstoque) {
        this.nomeProdutoEstoque = nomeProdutoEstoque;
    }

    public String getFatorConversao() {
       if((cpc.getProdutosCodigoBarrasController(nomeProdutoEstoque).getConversao()) != 0){
            fatorConversao = cf.getFatorController(cpc.getProdutosCodigoBarrasController(nomeProdutoEstoque).getConversao()).getDescricao();
       }
        return fatorConversao;
    }

    public void setFatorConversao(String fatorConversao) {
        this.fatorConversao = fatorConversao;
    }
    
    /**
    * seta o valor de codCompras
    * @param pCodCompras
    */
    public void setCodCompras(int pCodCompras){
        this.codCompras = pCodCompras;
    }
    /**
    * return codCompras
    */
    public int getCodCompras(){
        return this.codCompras;
    }

    /**
    * seta o valor de codProduto
    * @param pCodProduto
    */
    public void setCodProduto(int pCodProduto){
        this.codProduto = pCodProduto;
    }
    /**
    * return codProduto
    */
    public int getCodProduto(){
        return this.codProduto;
    }

    /**
    * seta o valor de valorCusto
    * @param pValorCusto
    */
    public void setValorCusto(double pValorCusto){
        this.valorCusto = pValorCusto;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }
    
    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCfopEstoque() {
        
        if (cp.getcompras_produtosControllerCodForn(codProdutoFornecedor, codFornecedor).getNomeProduto()!= null && cfopEstoque == null){
        cfopEstoque = cp.getcompras_produtosControllerCodForn(codProdutoFornecedor, codFornecedor).getCfopEstoque();
        }
        
          return cfopEstoque;
    }

    public void setCfopEstoque(String cfopEstoque) {
        this.cfopEstoque = cfopEstoque;
    }

    public String getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(String codFornecedor) {
        this.codFornecedor = codFornecedor;
    }
    
    
    /**
    * return valorCusto
    */
    public double getValorCusto(){
        return this.valorCusto;
    }

    /**
    * seta o valor de valorVenda
    * @param pValorVenda
    */
    public void setValorTotal(double pValorTotal){
        this.valorTotal = pValorTotal;
    }
    /**
    * return valorVenda
    */
    public double getValorTotal(){
        return this.valorTotal;
    }

    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(Float pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
     * @return 
    */
    public Float getQuantidade(){
        return this.quantidade;
    }

    public Button getProcurarProduto() {
        return procurarProduto;
    }

    public void setProcurarProduto(Button procurarProduto) {
        Node nd;
        Image imgem = new Image("imagens/icones 40 collor/icons8-pesquisar-40.png");
        ImageView img = new ImageView(imgem);
        img.setFitHeight(20.00);
        img.setFitWidth(20.00);
        nd = img;
        procurarProduto.setGraphic(nd);
        this.procurarProduto = procurarProduto;
    }

    public Button getAdcionarProduto() {
        return adcionarProduto;
    }

    public void setAdcionarProduto(Button adcionarProduto) {
        Node nd;
        Image imgem = new Image("imagens/icones 40 collor/icons8-mais-40.png");
        ImageView img = new ImageView(imgem);
        img.setFitHeight(20.00);
        img.setFitWidth(20.00);
        nd = img;
        adcionarProduto.setGraphic(nd);
        this.adcionarProduto = adcionarProduto;
    }

    public Button getProcurarFator() {
        return procurarFator;
    }

    public void setProcurarFator(Button procurarFator) {
        Node nd;
        Image imgem = new Image("imagens/icones 40 collor/icons8-pesquisar-40.png");
        ImageView img = new ImageView(imgem);
        img.setFitHeight(20.00);
        img.setFitWidth(20.00);
        nd = img;
        procurarFator.setGraphic(nd);
        this.procurarFator = procurarFator;
    }

    public Button getProcurarCfop() {
        return procurarCfop;
    }

    public void setProcurarCfop(Button procurarCfop) {
        Node nd;
        Image imgem = new Image("imagens/icones 40 collor/icons8-pesquisar-40.png");
        ImageView img = new ImageView(imgem);
        img.setFitHeight(20.00);
        img.setFitWidth(20.00);
        nd = img;
        procurarCfop.setGraphic(nd);
        this.procurarCfop = procurarCfop;
    }
    
    

    
    /**
     * @return the listaModelComprasProdutos
     */
    public ArrayList<ModelComprasProdutos> getListaModelComprasProdutos() {
        return listaModelComprasProdutos;
    }

    /**
     * @param listaModelComprasProdutos the listaModelComprasProdutos to set
     */
    public void setListaModelComprasProdutos(ArrayList<ModelComprasProdutos> listaModelComprasProdutos) {
        this.listaModelComprasProdutos = listaModelComprasProdutos;
    }

    /**
     * @return the modelProdutos
     */
    public ModelProdutos getModelProdutos() {
        return modelProdutos;
    }

    /**
     * @param modelProdutos the modelProdutos to set
     */
    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    @Override
    public String toString() {
        return "ModelComprasProdutos{" + "CST=" + cst + "base de calculo=" + baseCalculoicms + "BaseSubst=" + baseCalculoSub + ", ordem=" + ordem + ", codigo=" + codigo + ", codCompras=" + codCompras + ", codProdutoFornecedor=" + codProdutoFornecedor + ", codProduto=" + codProduto + ", nomeProduto=" + nomeProduto + ", nomeProdutoEstoque=" + nomeProdutoEstoque + ", barras=" + barras + ", ncm=" + ncm + ", cest=" + cest + ", cfop=" + cfop + ", unidade=" + unidade + ", cfopEstoque=" + cfopEstoque + ", fatorConversao=" + fatorConversao + ", percCreditoSn=" + percCreditoSn + ", valorCreditoSn=" + valorCreditoSn + ", codFornecedor=" + codFornecedor + ", valorCusto=" + valorCusto + ", valorTotal=" + valorTotal + ", quantidade=" + quantidade + ", cp=" + cp + ", cf=" + cf + '}';
    }

    
    
}