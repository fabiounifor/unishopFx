/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.ControllerEmpresa;
import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerCidadeEstado;
import controller.ControllerCliente;
import controller.ControllerFornecedor;
import controller.ControllerVendasProdutos;
import controller.ControllerComprasProdutos;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerEstado;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelProdutos;
import model.ModelCidade;
import model.ModelEstado;
import model.ModelEmpresa;
import model.ModelVendasProdutos;
import model.ModelComprasProdutos;
import nfe.controller.ControllerNF;
import nfe.model.ModelNF;

/**
 *
 * @author Fabio
 */
public class gerarSintegra {
    String registro_dez;
    String registro_onze;
    String registro_cinquenta_entrada = "";
    String registro_cinquenta_saida = "";
    String registro_cinquenta_tres = "";
    String registro_cinquenta_quatro_entrada = "";
    String registro_cinquenta_quatro_saida = "";
    String registro_sessenta_um = "";
    String registro_sessenta_um_erre = "";
    String registro_setenta_quatro_inventario = "";
    String registro_setenta_cinco_saida = "";
    String registro_setenta_cinco_entrada = "";
    String registro_setenta_cinco_saida_inventario = "";
    String registro_setenta_cinco_entrada_inventario = "";
    String registro_noventa = "";
    int total_dez,total_onze,total_cinquenta_entrada, total_cinquenta_saida, total_cinquenta_tres, total_cinquenta_quatro_entrada, 
        total_cinquenta_quatro_saida, total_sessenta_um,total_sessenta_um_erre, total_setenta_quatro,total_setenta_cinco,total_setenta_cinco_inventario, total_noventa;
    
    
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidadeEstado controllerCidadeEstado = new ControllerCidadeEstado();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ControllerNF controllerNF = new ControllerNF();
    ControllerCliente controllerCliente = new ControllerCliente();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ModelCidade modelCidade = new ModelCidade();
    ModelEstado modelEstado = new ModelEstado();
    ArrayList <ModelNF> modelNF = new ArrayList<>();
    ArrayList <ModelNF> modelNFEMesmaData = new ArrayList<>();
    ArrayList <ModelNF> modelNFEntrada = new ArrayList<>();
    ArrayList <ModelVendasProdutos> modelVendasProdutos = new ArrayList<>();
    ArrayList <ModelVendasProdutos> modelVendasProdutosCfop = new ArrayList<>();
    ArrayList <ModelComprasProdutos> modelComprasProdutos = new ArrayList<>();
    ArrayList <ModelComprasProdutos> modelComprasProdutosCfop = new ArrayList<>();
    ArrayList <ModelComprasProdutos> modelComprasProdutosAliquota = new ArrayList<>();
    ArrayList<Integer> produtoControle = new ArrayList<>();
    ArrayList<Integer> produtoControleentrada75 = new ArrayList<>();
    ArrayList<Integer> produtoControlesaida75 = new ArrayList<>();
    ArrayList<String> numeroControle = new ArrayList<>();
    ArrayList<Integer> cfopControle = new ArrayList<>();
    ArrayList<Integer> aliquotaControle = new ArrayList<>();
    ModelComprasProdutos mcp = new ModelComprasProdutos();
    BLMascaras bLmascaras = new BLMascaras();

        
    private String ajustarTamanhoNumerico(String campoTamanho, int limite){
        String resultado = campoTamanho;
        String vazio = "";
   
    if (campoTamanho.equals("null")){
     for (int i = 0; i < limite; i++){
         vazio = vazio + "0";
        }
            resultado = vazio;
    }
    if (campoTamanho.matches("-?\\d+")){
            if (campoTamanho.length() < limite){
     for (int i = 0; i < (limite - campoTamanho.length()); i++){
         vazio = vazio + "0";
        }
            resultado = vazio+""+campoTamanho;
    } else if(campoTamanho.length() > limite ){
        
        resultado = campoTamanho.substring(campoTamanho.length() - limite);
    } 
        }
    return resultado;
    }
    private String ajustarTamanhoNumericoInvertido(String campoTamanho, int limite){
        String resultado = campoTamanho;
        String vazio = "";
   
    if (campoTamanho.equals("null")){
     for (int i = 0; i < limite; i++){
         vazio = vazio + "0";
        }
            resultado = vazio;
    }
    if (campoTamanho.matches("-?\\d+")){
            if (campoTamanho.length() < limite){
     for (int i = 0; i < (limite - campoTamanho.length()); i++){
         vazio = vazio + "0";
        }
            resultado = campoTamanho+""+vazio;
    } else if(campoTamanho.length() > limite ){
        
        resultado = campoTamanho.substring(0, limite);
    } 
        }
    return resultado;
    }
    public String ajustarTamanho(String campoTamanho, int limite){
        String resultado = campoTamanho;
        String vazio = "";
        if (campoTamanho.equals("null")){
     for (int i = 0; i < limite; i++){
         vazio = vazio + " ";
        }
            resultado = vazio;
    }   
            
    if (campoTamanho.length() < limite ){
     for (int i = 0; i < (limite - campoTamanho.length()); i++){
         vazio = vazio + " ";
        }
            resultado = campoTamanho + vazio;
    } else if(campoTamanho.length() > limite ){
        
        resultado = campoTamanho.substring(0, limite);
    }
        
        return resultado;
    }
    
    
    public String registroDez(String dataInicial, String dataFinal, String convenio){
    String razao; 
    String municipio; 
    String uf; 
    String ie; 
    String fax; 
    
    modelEmpresa = controllerEmpresa.getEmpresaController(1).getModelEmpresa();
    modelCidade  = controllerEmpresa.getEmpresaController(1).getModelCidade();
    modelEstado  = controllerEmpresa.getEmpresaController(1).getModelEstado();
    
    ie = ajustarTamanho(modelEmpresa.getInscEstad(), 14);
    razao = ajustarTamanho(modelEmpresa.getRazaoSocial(), 35);
    municipio = ajustarTamanho(modelCidade.getNome(), 30);
    uf = modelEstado.getUf();
    fax = ajustarTamanho(modelEmpresa.getTelefone(), 10);
    total_dez += 1;
    registro_dez = ("10"+modelEmpresa.getCnpj()+ie+razao+municipio+uf+fax+dataInicial.substring(0, 4)+dataInicial.substring(5, 7)+dataInicial.substring(8, 10)+dataFinal.substring(0, 4)+dataFinal.substring(5, 7)+dataFinal.substring(8, 10)+convenio+"\r\n");
        System.out.println("REGISTRO 10");
    return registro_dez;
    }
    
    public String registroOnze(){
    String logradouro; 
    String numero; 
    String complemento; 
    String bairro; 
    String contato;    
    String telefone;    
    modelEmpresa = controllerEmpresa.getEmpresaController(1).getModelEmpresa();
    logradouro = ajustarTamanho(modelEmpresa.getEndereco(), 34);
    numero = ajustarTamanhoNumerico(modelEmpresa.getEnderecoNumero(), 5);
    complemento = ajustarTamanho(modelEmpresa.getEnderecoComplemento(), 22);
    bairro = ajustarTamanho(modelEmpresa.getBairro(), 15);
    contato = ajustarTamanho(modelEmpresa.getRazaoSocial(), 28);
    telefone = ajustarTamanhoNumerico(modelEmpresa.getTelefone(), 12);
    total_onze += 1;
    registro_onze = ("11"+logradouro+numero+complemento+bairro+modelEmpresa.getCep()+contato+telefone+"\r\n");
    System.out.println("REGISTRO 11");    
    return registro_onze;    
    }
    
    public String registroCinquentaSaida(Date dataInicial, Date dataFinal, String modelo ){
    String ie; 
    String docCliente; 
    String serie; 
    String numero; 
    String cfop = "";    
    String cfopControleLocal = "";    
    String numeroControleLocal = "";    
    String valorTotal = "0";    
    String baseDeCalculo;    
    String valorIcms;    
    String desconto;    
    String outros;    
    String aliquota;    
    String situacao = "";    
    String data; 
    String estado;
    String cfopAnterior = "";
    int codEstado;
    float valorTotalFloat = 0.0f;
    modelNF = controllerNF.getListaDataNFController(dataInicial,dataFinal, modelo);

    for (int i=0; i<modelNF.size(); i++){
        
        modelVendasProdutos = controllerVendasProdutos.getListaVendasProdutosController(modelNF.get(i).getPedido());
        
        if ((bLmascaras.removerPontos(String.valueOf(modelNF.get(i).getStatusNfe()))).equals("100")){
            situacao = "N";
        }
        if (controllerCliente.getClienteControllerCod(modelNF.get(i).getCodCliente()).getInscricao().equals("")){
            ie = ajustarTamanho("ISENTO", 14);
        }else{
            ie = ajustarTamanho(controllerCliente.getClienteControllerCod(modelNF.get(i).getCodCliente()).getInscricao(), 14);
        }
    codEstado  = controllerCliente.getClienteControllerCod(modelNF.get(i).getCodCliente()).getCodEstado();
    estado = controllerEstado.getEstadoControllerCod(codEstado).getUf();
    docCliente = ajustarTamanhoNumerico(controllerCliente.getClienteControllerCod(modelNF.get(i).getCodCliente()).getCpfCNPJ(), 14);
    serie = ajustarTamanhoNumerico(modelNF.get(i).getSerieNfe(), 3);
    numero = ajustarTamanhoNumerico(modelNF.get(i).getNumeroNfe(), 6);
    
    baseDeCalculo = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(modelNF.get(i).getIcmsBc())), 13);
    valorIcms = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(modelNF.get(i).getVtottrib())), 13);
    desconto = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(modelNF.get(i).getValorDescontos())), 13);
    outros = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(modelNF.get(i).getOutros())), 13);
    data = String.valueOf(modelNF.get(i).getDataEmissao());
    
    
    aliquota = "0000";
    //cfop = controllerVendasProdutos.getVendasCodigoProdutosController(modelNF.get(i).getPedido()).getCfop();
    cfopControleLocal = "";
    for (int j=0 ; j<modelVendasProdutos.size() ; j++){
    modelVendasProdutosCfop = controllerVendasProdutos.getListaVendasProdutosCfopController(modelNF.get(i).getPedido(), Integer.parseInt(modelVendasProdutos.get(j).getCfop()) );
    for (int h=0 ; h<modelVendasProdutosCfop.size() ; h++){
            cfop = modelVendasProdutosCfop.get(h).getCfop();
            valorTotalFloat = bLmascaras.arredondamentoComPontoDuasCasas(valorTotalFloat + (modelVendasProdutosCfop.get(h).getValorTotal()));
            valorTotal = ajustarTamanhoNumerico(bLmascaras.removerPontos(bLmascaras.CompletaZero(String.valueOf(valorTotalFloat))), 13);
            }
            valorTotalFloat = 0.0f;    
            if (!(cfopControleLocal.contains(cfop))){
            registro_cinquenta_saida = registro_cinquenta_saida+("50"+docCliente+ie+data.substring(0, 4)+data.substring(5, 7)+data.substring(8, 10)+estado+modelNF.get(i).getModelonfe()+serie+numero+cfop+"P"
            +valorTotal+baseDeCalculo+valorIcms+desconto+outros+aliquota+situacao+"\r\n");
            total_cinquenta_saida += 1;
            cfopControleLocal = cfop +" "+ cfopControleLocal;
            numeroControleLocal = numero;
            }
    }
    }
    System.out.println("REGISTRO 50 SAI");
    return registro_cinquenta_saida;    
    }
    
    public String registroCinquentaEntrada(Date dataInicial, Date dataFinal, String modelo ){
    String ie; 
    String docFornecedor; 
    String serie; 
    String numero; 
    String cfop = "";
    String cst;    
    String valorTotal = "";    
    String baseDeCalculo = "";    
    String valorIcms = "";    
    String desconto = "";    
    String outros = "";    
    String aliquota = "";    
    String situacao = "N";    
    String data = "";    
    Double valorTotalDouble = 0.00d;
    Double baseDeCalculoDouble = 0.00d;
    Double valorIcmsDouble = 0.00d;
    Double outroDouble = 0.00d;
    int codEstado;
    String estado;
    modelNFEntrada = controllerNF.getListaDataNFCompraController(dataInicial, dataFinal, modelo);
    numeroControle = new ArrayList<>();
    cfopControle = new ArrayList<>();
    for (int i=0; i<modelNFEntrada.size(); i++){
        if ((bLmascaras.removerPontos(String.valueOf(modelNFEntrada.get(i).getStatusNfe()))).equals("100")){
            situacao = "N";
        }    
        if (controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getInscEstadual() == null){
            ie = "0";
        }else{
            ie = ajustarTamanho(controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getInscEstadual(), 14);
        }
    
    
    codEstado = controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getCodEstado();
    estado = controllerEstado.getEstadoControllerCod(codEstado).getUf();
    docFornecedor = ajustarTamanhoNumerico(controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getCnpj(), 14);
    serie = ajustarTamanhoNumerico(modelNFEntrada.get(i).getSerieNfe(), 3);
    numero = ajustarTamanhoNumerico(modelNFEntrada.get(i).getNumeroNfe(), 6);

//   aqui dividir por aliquota e cnpj

    modelComprasProdutos = controllerComprasProdutos.getListacompras_produtosController(modelNFEntrada.get(i).getPedido());
        System.out.println("modelComprasProdutos");
        System.out.println(modelComprasProdutos.size());
    for (int j=0 ; j<modelComprasProdutos.size() ; j++){
        cfop = modelComprasProdutos.get(j).getCfopEstoque();
        aliquota = modelComprasProdutos.get(j).getPercCreditoSn();   
        modelComprasProdutosAliquota = controllerComprasProdutos.getListacompras_produtosCSTController(aliquota,cfop, modelNFEntrada.get(i).getPedido());
        valorTotalDouble = 0.00d;
    baseDeCalculoDouble = 0.00d;
    valorIcmsDouble = 0.00d;                 
          
           for (int l=0 ; l<modelComprasProdutosAliquota.size() ; l++){
                desconto = "0000000000000";
                //desconto = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(modelComprasProdutos.get(j).get)), 13);
                aliquota = ajustarTamanhoNumericoInvertido(bLmascaras.removerPontos(String.valueOf(modelComprasProdutosAliquota.get(l).getPercCreditoSn())), 4);
                data = String.valueOf(modelNFEntrada.get(i).getDataEmissao());
                valorTotalDouble = bLmascaras.truncamentoComPontoDuasCasasDouble(valorTotalDouble + (modelComprasProdutosAliquota.get(l).getValorTotal()));
                valorTotal = ajustarTamanhoNumerico(bLmascaras.removerPontos(bLmascaras.CompletaZero(String.valueOf(valorTotalDouble))), 13);
                baseDeCalculoDouble =  bLmascaras.truncamentoComPontoDuasCasasDouble(baseDeCalculoDouble + Double.parseDouble(modelComprasProdutosAliquota.get(l).getBaseCalculoicms()));
                baseDeCalculo = ajustarTamanhoNumerico(bLmascaras.removerPontos(bLmascaras.CompletaZero(String.valueOf(baseDeCalculoDouble))), 13);
                valorIcmsDouble = bLmascaras.truncamentoComPontoDuasCasasDouble(valorIcmsDouble + Double.parseDouble(modelComprasProdutosAliquota.get(l).getValorCreditoSn()));
                valorIcms = ajustarTamanhoNumerico(bLmascaras.removerPontos(bLmascaras.CompletaZero(String.valueOf(valorIcmsDouble))), 13);
                outroDouble = bLmascaras.truncamentoComPontoDuasCasasDouble(outroDouble + Double.parseDouble(modelNFEntrada.get(i).getOutros()));
                outros = ajustarTamanhoNumerico(bLmascaras.removerPontos(bLmascaras.CompletaZero(String.valueOf(outroDouble))), 13);
           }
        if (!( numeroControle.contains("numero" + modelComprasProdutos.get(j).getCodCompras()+"cfop" + modelComprasProdutos.get(j).getCfopEstoque()+ "aliquota" + modelComprasProdutos.get(j).getPercCreditoSn()))){       
        total_cinquenta_entrada += 1;
            valorTotalDouble = 0.00d;
            baseDeCalculoDouble = 0.00d;
            valorIcmsDouble = 0.00d;      
        registro_cinquenta_entrada = registro_cinquenta_entrada+("50"+docFornecedor+ie+data.substring(0, 4)+data.substring(5, 7)+data.substring(8, 10)+estado+modelNFEntrada.get(i).getModelonfe()+serie+numero+cfop+"T"
        +valorTotal+baseDeCalculo+valorIcms+desconto+outros+aliquota+situacao+"\r\n"); 
        numeroControle.add("numero" + modelComprasProdutos.get(j).getCodCompras()+"cfop" + modelComprasProdutos.get(j).getCfopEstoque()+ "aliquota" + modelComprasProdutos.get(j).getPercCreditoSn());
                }           
            }
    }
    System.out.println("REGISTRO 50 ENT");
    return registro_cinquenta_entrada;    
    }
    
    public String registroCinquentaTres(Date dataInicial, Date dataFinal, String modelo ){
    String ie; 
    String docCliente; 
    String serie; 
    String numero; 
    String cfop;    
    String valorIcms;    
    String valorTotal;    
    String baseDeCalculo;    
    String desconto;    
    String aliquota;    
    String outros;    
    String situacao = "N";    
    String data;    
    String baseSubstString; 
    String branco = ""; 
    float baseSubst = 0.0f;
    
    modelNFEntrada = controllerNF.getListaDataNFCompraController(dataInicial, dataFinal, modelo);
    
    for (int i=0; i<modelNFEntrada.size(); i++){
        int codEstado  = controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getCodEstado();
        String estado = controllerEstado.getEstadoControllerCod(codEstado).getUf();
        if (!(modelNFEntrada.get(i).getBCSubst().equals("0"))){
            if ((bLmascaras.removerPontos(String.valueOf(modelNFEntrada.get(i).getStatusNfe()))).equals("100")){
            situacao = "N";
        }
            
        if (controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getInscEstadual().equalsIgnoreCase("null")){
            ie = ajustarTamanho("ISENTO", 14);
        }else{
            ie = ajustarTamanho(controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getInscEstadual(), 14);
        }    
        baseSubstString = ajustarTamanhoNumerico(bLmascaras.removerPontos(modelNFEntrada.get(i).getBCSubst()), 13);
        docCliente = ajustarTamanhoNumerico(controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getCnpj(), 14);
        serie = ajustarTamanhoNumerico(modelNFEntrada.get(i).getSerieNfe(), 3);
        numero = ajustarTamanhoNumerico(modelNFEntrada.get(i).getNumeroNfe(), 6);
        cfop = controllerComprasProdutos.getcompras_produtosCodigoCompraController(modelNFEntrada.get(i).getPedido()).getCfopEstoque();
        valorTotal = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(modelNFEntrada.get(i).getValorTotal()))), 13);
        baseDeCalculo = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(modelNFEntrada.get(i).getIcmsBc()))), 13);
        valorIcms = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(modelNFEntrada.get(i).getIcmsVlr()))), 13);
        desconto = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(modelNFEntrada.get(i).getValorDescontos()))), 13);
        outros = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(modelNFEntrada.get(i).getOutros())), 13);
        
        //aliquota = "0000";
        aliquota = ajustarTamanhoNumericoInvertido(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(modelNFEntrada.get(i).getIcmsVlr()))), 4);
        data = String.valueOf(modelNFEntrada.get(i).getDataEmissao());
        branco = ajustarTamanho(branco, 30);
        total_cinquenta_tres += 1;
        registro_cinquenta_tres = registro_cinquenta_tres+("53"+docCliente+ie+data.substring(0, 4)+data.substring(5, 7)+data.substring(8, 10)+estado+modelNFEntrada.get(i).getModelonfe()+serie+numero+cfop+"T"
                +baseSubstString+valorIcms+outros+situacao+branco+"\r\n");
    }
    }
    System.out.println("REGISTRO 53");
    return registro_cinquenta_tres;    
    }
    
    public String registroCinquentaQuatroEntrada(Date dataInicial, Date dataFinal, String modelo ){
    String cnpj; 
    String serie; 
    String numero; 
    String cfop;    
    String cst;    
    String ordem;    
    String codigoProduto;    
    String quantidade;    
    String valorTotal;    
    String desconto;    
    String baseDeCalculo;    
    String baseSubstString; 
    String valorIpi;
    String aliquota;    
    String branco = ""; 
        
    modelNFEntrada = controllerNF.getListaDataNFCompraController(dataInicial, dataFinal, modelo);
    
    for (int i=0; i<modelNFEntrada.size(); i++){
        
        cnpj = ajustarTamanhoNumerico(controllerFornecedor.getFornecedorController(modelNFEntrada.get(i).getCodCliente()).getCnpj(), 14);
        serie = ajustarTamanhoNumerico(modelNFEntrada.get(i).getSerieNfe(), 3);
        numero = ajustarTamanhoNumerico(modelNFEntrada.get(i).getNumeroNfe(), 6);
        
        modelComprasProdutos = controllerComprasProdutos.getListacompras_produtosController(Integer.parseInt(modelNFEntrada.get(i).getNumeroNfe()));
        for (int j=0; j<modelComprasProdutos.size();j++){
        cfop = modelComprasProdutos.get(j).getCfopEstoque();
        ordem = ajustarTamanhoNumerico(String.valueOf(modelComprasProdutos.get(j).getOrdem()),3);
        cst = ajustarTamanhoNumerico(modelComprasProdutos.get(j).getCst(),3);
        codigoProduto = ajustarTamanho(String.valueOf(modelComprasProdutos.get(j).getCodProduto()),14);
        quantidade = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoTresCasas(modelComprasProdutos.get(j).getQuantidade()))), 11);
        valorTotal = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(modelComprasProdutos.get(j).getValorTotal()))),12);
        //desconto = ajustarTamanhoNumerico(bLmascaras.removerPontos(controllerComprasProdutos.getcompras_produtosCodigoCompraController(modelNFEntrada.get(i).getPedido()).get), 13);
        desconto = "000000000000";
        baseDeCalculo = ajustarTamanhoNumerico(bLmascaras.removerPontos(modelComprasProdutos.get(j).getBaseCalculoicms()), 12);
        baseSubstString = ajustarTamanhoNumerico(bLmascaras.removerPontos(modelComprasProdutos.get(j).getBaseCalculoSub()), 12);
        valorIpi = ajustarTamanhoNumerico(bLmascaras.removerPontos(modelComprasProdutos.get(j).getValorIpi()), 12);
        aliquota = ajustarTamanhoNumericoInvertido(bLmascaras.removerPontos(modelComprasProdutos.get(j).getPercCreditoSn()), 4);
        
        branco = ajustarTamanho(branco, 30);
        total_cinquenta_quatro_entrada += 1;
        registro_cinquenta_quatro_entrada = registro_cinquenta_quatro_entrada+("54"+cnpj+modelo+serie+numero+cfop+cst+ordem+codigoProduto+quantidade+valorTotal
                +desconto+baseDeCalculo+baseSubstString+valorIpi+aliquota+"\r\n");
        }
        
    }
    System.out.println("REGISTRO 54 ENT");
    return registro_cinquenta_quatro_entrada;    
    }
    
    public String registroCinquentaQuatroSaida(Date dataInicial, Date dataFinal, String modelo ){
    String cnpj; 
    String serie; 
    String numero; 
    String cfop;    
    String cst;    
    String ordem;    
    String codigoProduto;    
    String quantidade;    
    String valorTotal;    
    String desconto;    
    String baseDeCalculo;    
    String baseSubstString; 
    String valorIpi;
    String aliquota;    
    String branco = ""; 
        
    modelNF = controllerNF.getListaDataNFController(dataInicial, dataFinal, modelo);
        
    for (int i=0; i<modelNF.size(); i++){
        
        cnpj = ajustarTamanhoNumerico(controllerCliente.getClienteControllerCod(modelNF.get(i).getCodCliente()).getCpfCNPJ(), 14);
        serie = ajustarTamanhoNumerico(modelNF.get(i).getSerieNfe(), 3);
        numero = ajustarTamanhoNumerico(modelNF.get(i).getNumeroNfe(), 6);
        
        modelVendasProdutos = controllerVendasProdutos.getListaVendasProdutosController(Integer.parseInt(modelNF.get(i).getPedidoCliente()));
        
        for(int j=0;j<modelVendasProdutos.size();j++){
        cfop = modelVendasProdutos.get(j).getCfop();
        ordem = ajustarTamanhoNumerico(String.valueOf(modelVendasProdutos.get(j).getOrdem()),3);
        cst = ajustarTamanhoNumerico(modelVendasProdutos.get(j).getIcmsCst(),3);
        codigoProduto = ajustarTamanho(String.valueOf(modelVendasProdutos.get(j).getCodigo_produto()),14);
        quantidade = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoTresCasas(modelVendasProdutos.get(j).getQuantidade()))), 11);
        valorTotal = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasas(controllerVendasProdutos.getVendasProdutosController(modelNF.get
        (i).getPedido()).getValorTotal()))),12);
        desconto = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasas(modelVendasProdutos.get(j).getDesconto()))),12);
        baseDeCalculo = ("000000000000");
        baseSubstString = ("000000000000");
        valorIpi = ("000000000000");
        aliquota = ("0000");
        branco = ajustarTamanho(branco, 30);
        total_cinquenta_quatro_saida += 1;
        registro_cinquenta_quatro_saida = registro_cinquenta_quatro_saida+("54"+cnpj+modelo+serie+numero+cfop+cst+ordem+codigoProduto+quantidade+valorTotal
                +desconto+baseDeCalculo+baseSubstString+valorIpi+aliquota+"\r\n");
        }
        
        
    }
    System.out.println("REGISTRO 54 SAI");
    return registro_cinquenta_quatro_saida;    
    }
    
    public String registroSessentaUm(Date dataInicial, Date dataFinal, String modelo ){
    String dataString = "";
    Date dataControle; 
    String serie = ""; 
    String subserie = "";    
    String numeroPrimeiro;    
    String numeroUltimo = "";    
    double valorTotal61 = 0;
    String valorTotalNumeros = "";    
    String baseDeCalculoDiaria = "";    
    String valorIcmsDiario = "";    
    String isentoDiario = "";    
    String aliquotaDiario = "";    
    String branco = " "; 
    String cZeroString;
    ArrayList <ModelNF> modelNF61 = new ArrayList<>();    
    modelNF61 = controllerNF.getListaDataNFController(dataInicial, dataFinal, modelo);
    for (int i=0; i<modelNF61.size(); i++){
        dataControle = (Date) modelNF61.get(i).getDataEmissao();
        numeroPrimeiro = ajustarTamanhoNumerico(modelNF61.get(i).getNumeroNfe(),6);
        ArrayList <ModelNF> modelNFEMesmaData61 = new ArrayList<>();
        modelNFEMesmaData61 = controllerNF.getListaDataNFController(dataControle, dataControle, modelo);
            for (int j=0; j<modelNFEMesmaData61.size(); j++){
            branco = ajustarTamanho(branco, 14);
            dataString = String.valueOf(modelNFEMesmaData61.get(j).getDataEmissao());
            serie = ajustarTamanhoNumerico(modelNFEMesmaData61.get(j).getSerieNfe(), 3);
            subserie = "00";
            valorTotal61 = bLmascaras.truncamentoComPontoDuasCasasDouble(valorTotal61 + modelNFEMesmaData61.get(j).getValorTotal());
            baseDeCalculoDiaria = ("0000000000000");
            valorIcmsDiario = ("000000000000");
            isentoDiario = ("0000000000000");
            aliquotaDiario = "0000";
            branco = ajustarTamanho(branco, 14);
            numeroUltimo = ajustarTamanhoNumerico(modelNFEMesmaData61.get(modelNFEMesmaData61.size() -1 ).getNumeroNfe(),6);      
            cZeroString = (bLmascaras.CompletaZero(String.valueOf(valorTotal61)));
            valorTotalNumeros = ajustarTamanhoNumerico(bLmascaras.removerPontos(cZeroString),13);
            i = i+1;
            }
            total_sessenta_um += 1;
            registro_sessenta_um = registro_sessenta_um+("61"+branco+branco+dataString.substring(0, 4)+dataString.substring(5, 7)+dataString.substring(8, 10)+modelo+serie+subserie+numeroPrimeiro+numeroUltimo+valorTotalNumeros
            +baseDeCalculoDiaria+valorIcmsDiario+isentoDiario+valorTotalNumeros+aliquotaDiario+" "+"\r\n");
            valorTotal61 = 0;
            i = i-1;
    }
    System.out.println("REGISTRO 61");
    return registro_sessenta_um;    
    }
    
    public String registroSessentaUmErre(Date dataInicial, Date dataFinal, String modelo ){
    ArrayList<ModelVendasProdutos> vendasProdutos = new ArrayList<>();
    String dataString = "";
    String codigoProduto = "";
    Float quantidadeFloat = 0.0f;
    String quantidade = "";
    double valorTotalDouble = 0;
    String valorTotal = "";
    String bcIcms = "0000000000000000";    
    String aliquota = "0000";    
    String branco = " ";
            
    
    modelNF = controllerNF.getListaDataNFController(dataInicial, dataFinal, modelo);
    modelVendasProdutos = controllerVendasProdutos.getListaVendasProdutosController();
    produtoControle.clear();
        
    for (int i=0; i<modelNF.size(); i++){
        System.out.println("FOR 61R 1");
        for (int j=0; j<modelVendasProdutos.size(); j++){
            System.out.println("FOR 61R 12");
            if (modelNF.get(i).getPedido() == modelVendasProdutos.get(j).getCodigo_venda()) {
                vendasProdutos.add(modelVendasProdutos.get(j));
            }
        }
    }
    for (int h=0; h<vendasProdutos.size();h++){
        System.out.println("FOR 61R 2");
        ArrayList<ModelVendasProdutos> produto = new ArrayList<>();
         produto.addAll(controllerVendasProdutos.getListaVendasProdutosCodigoController(vendasProdutos.get(h).getCodigo_produto()));
             for (int l =0; l<produto.size(); l++){
                 System.out.println("FOR 61R 22");
                        quantidadeFloat += bLmascaras.truncamentoComPontoTresCasasFloat(produto.get(l).getQuantidade());
                        quantidade = ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(quantidadeFloat )), 13);
                        valorTotalDouble += produto.get(l).getValorTotal();
                        valorTotal = ajustarTamanhoNumerico(bLmascaras.removerPontos(bLmascaras.CompletaZero(String.valueOf(bLmascaras.truncamentoComPontoDuasCasasDouble(valorTotalDouble)))), 16);
                }
     dataString = String.valueOf(controllerNF.getNFVendaController(vendasProdutos.get(h).getCodigo_venda()).getDataEmissao());
     codigoProduto = ajustarTamanho(String.valueOf(vendasProdutos.get(h).getCodigo_produto()), 14);    
     branco = ajustarTamanho(branco, 54);
     
     if (!(produtoControle.contains(vendasProdutos.get(h).getCodigo_produto()))){
     total_sessenta_um_erre += 1;
     registro_sessenta_um_erre = registro_sessenta_um_erre+("61R"+dataString.substring(5,7)+dataString.substring(0, 4)+codigoProduto+quantidade+
     valorTotal+bcIcms+aliquota+branco+"\r\n");
     valorTotalDouble = 0;       
     quantidadeFloat = 0.0f;
     produtoControle.add(vendasProdutos.get(h).getCodigo_produto());
     }
     }
    System.out.println("REGISTRO 61R");
     return registro_sessenta_um_erre;    
     }
    
    public String registroSetentaQuatroInventario(Date dataInventario) throws Exception{
        ArrayList<String> codigosProdutosVenda = new ArrayList<>();
        ArrayList<String> codigosProdutosCompra = new ArrayList<>();
        ArrayList<ModelProdutos> produtos = new ArrayList<>();
        ArrayList<ModelVendasProdutos> vendasProdutos = new ArrayList<>();
        ArrayList<ModelComprasProdutos> comprasProdutosVerificada = new ArrayList<>();
        ArrayList<ModelVendasProdutos> vendasProdutosVerificada = new ArrayList<>();
        ArrayList<ModelComprasProdutos> comprasProdutos = new ArrayList<>();
        ArrayList<ModelComprasProdutos> comprasProdutosOrdenada = new ArrayList<>();
        ModelComprasProdutos  mcpInventario = new ModelComprasProdutos();
        ArrayList<ModelComprasProdutos>  inventarioCompras = new ArrayList<>();
        ModelVendasProdutos mvpInventario = new ModelVendasProdutos();
        ArrayList<ModelVendasProdutos> inventarioVendas = new ArrayList<>();
        ArrayList<ModelNF> listaCompras = new ArrayList<>();
        ArrayList<ModelNF> listaVendas55 = new ArrayList<>();
        ArrayList<ModelNF> listaVendas65 = new ArrayList<>();
        ArrayList<ModelNF> listaVendas = new ArrayList<>();
        String dataFinalString = String.valueOf(dataInventario);
        String dataInicialString = String.valueOf("01/01/" +dataFinalString.substring( 0, 4));
        Date dataInicial = bLmascaras.converterDataStringParaDate(dataInicialString);
        String codigoProduto = "";
        String quantidadeProduto = "";
        String valorProduto = "";
        String codigoPosseProduto = "1";
        String branco = " "; 
        String cnpjEmpresa = ajustarTamanhoNumerico(controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj(), 14);
        String ieEmpresa = ajustarTamanhoNumerico(controllerEmpresa.getEmpresaController(1).getModelEmpresa().getInscEstad(), 14);
        String ufEmpresa = controllerEmpresa.getEmpresaController(1).getModelEstado().getUf();
        
        produtos = controllerProdutos.getListaProdutosAtivosController();
        listaCompras = controllerNF.getListaDataNFCompraController(dataInicial, dataInventario, "55");
        listaVendas55 = controllerNF.getListaDataNFController(dataInicial, dataInventario, "55");
        listaVendas65 = controllerNF.getListaDataNFController(dataInicial, dataInventario, "65");
        listaVendas.addAll(listaVendas55);
        listaVendas.addAll(listaVendas65);
        for (int invComp = 0 ; invComp < listaCompras.size(); invComp++){
        comprasProdutos.addAll(controllerComprasProdutos.getListacompras_produtosController
        (listaCompras.get(invComp).getPedido()));
        }
        for (int invVend = 0 ; invVend < listaVendas.size(); invVend++){
        vendasProdutos.addAll(controllerVendasProdutos.getListaVendasProdutosController
        (listaVendas.get(invVend).getPedido()));
        }
        for (int prod = 0 ; prod < produtos.size(); prod++){
            String origem1 = null;
            String origem2 = null;
            float quantidadeLocalCompras = 0, valorLocal;
            float quantidadeLocalVendas = 0;
            int codigoLocal;
            
           for (int comp = 0 ; comp < comprasProdutos.size(); comp ++){
               mcpInventario = new ModelComprasProdutos();
               if (produtos.get(prod).getCodigo() == comprasProdutos.get(comp).getCodProduto()){
               if (codigosProdutosCompra.contains(String.valueOf(comprasProdutos.get(comp).getCodProduto()))){
                   int indiceCompras = codigosProdutosCompra.indexOf(String.valueOf(comprasProdutos.get(comp).getCodProduto()));
                   mcpInventario.setCodProduto(comprasProdutos.get(comp).getCodProduto());
                   mcpInventario.setValorCusto(comprasProdutos.get(comp).getValorCusto());
                   mcpInventario.setQuantidade(comprasProdutos.get(comp).getQuantidade() + comprasProdutos.get(indiceCompras).getQuantidade());
                   inventarioCompras.set(indiceCompras, mcpInventario);
               }else{
                       mcpInventario.setCodProduto(comprasProdutos.get(comp).getCodProduto());
                       mcpInventario.setValorCusto(comprasProdutos.get(comp).getValorCusto());
                       mcpInventario.setQuantidade(comprasProdutos.get(comp).getQuantidade());
                       inventarioCompras.add(mcpInventario);
                       codigosProdutosCompra.add(String.valueOf(comprasProdutos.get(comp).getCodProduto()));
                   }
               }
               
           }
           
           for (int vend = 0 ; vend < vendasProdutos.size(); vend ++){
               mvpInventario = new ModelVendasProdutos();
                   if (produtos.get(prod).getCodigo() == vendasProdutos.get(vend).getCodigo_produto()){
                   if (codigosProdutosVenda.contains(String.valueOf(vendasProdutos.get(vend).getCodigo_produto()))){
                       int indiceVendas = codigosProdutosVenda.indexOf(String.valueOf(vendasProdutos.get(vend).getCodigo_produto()));
                       mvpInventario.setCodigo_produto(vendasProdutos.get(vend).getCodigo_produto());
                       mvpInventario.setQuantidade(vendasProdutos.get(vend).getQuantidade() + vendasProdutos.get(indiceVendas).getQuantidade());
                       inventarioVendas.set(indiceVendas, mvpInventario);
                   }else{
                       mvpInventario.setCodigo_produto(vendasProdutos.get(vend).getCodigo_produto());
                       mvpInventario.setQuantidade(vendasProdutos.get(vend).getQuantidade());
                       inventarioVendas.add(mvpInventario);
                       codigosProdutosVenda.add(String.valueOf(vendasProdutos.get(vend).getCodigo_produto()));
                   }
                   
                }
                   
               } 
        if (!(codigosProdutosVenda.contains(String.valueOf(produtos.get(prod).getCodigo())))){   
        mvpInventario.setCodigo_produto(produtos.get(prod).getCodigo());
        mvpInventario.setQuantidade(produtos.get(prod).getEstoque());
        inventarioVendas.add(mvpInventario);
        }
        if (!(codigosProdutosCompra.contains(String.valueOf(produtos.get(prod).getCodigo())))){   
        mcpInventario.setCodProduto(produtos.get(prod).getCodigo());
        mcpInventario.setQuantidade(produtos.get(prod).getEstoque());
        mcpInventario.setValorCusto(produtos.get(prod).getValorCusto());
        inventarioCompras.add(mcpInventario);
        }
        
        if (((inventarioCompras.get(prod).getQuantidade() - inventarioVendas.get(prod).getQuantidade()) > 0) &&
                  (produtos.get(prod).getEstoque() > 0)){
            total_setenta_quatro += 1;
            registro_setenta_quatro_inventario =  registro_setenta_quatro_inventario + ("74"+bLmascaras.removerFormatacao(dataFinalString)+ajustarTamanho(String.valueOf(inventarioCompras.get(prod).getCodProduto()),14)
                +(ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoTresCasas(inventarioCompras.get(prod).getQuantidade() - inventarioVendas.get(prod).getQuantidade()))), 13 ))
                +(ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(inventarioCompras.get(prod).getValorCusto() * (inventarioCompras.get(prod).getQuantidade() - inventarioVendas.get(prod).getQuantidade())))), 13))
                + codigoPosseProduto + ajustarTamanhoNumerico("00",14) + ajustarTamanho(branco, 14) + ufEmpresa+ ajustarTamanho(branco,45) + "\r\n");
        }
        /*else{
            total_setenta_quatro += 1;
            registro_setenta_quatro_inventario =  registro_setenta_quatro_inventario + ("74"+bLmascaras.removerFormatacao(dataFinalString)+ajustarTamanho(String.valueOf(inventarioCompras.get(prod).getCodProduto()),14)
                +(ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoTresCasas(0))), 13 ))
                +(ajustarTamanhoNumerico(bLmascaras.removerPontos(String.valueOf(bLmascaras.arredondamentoComPontoDuasCasasDouble(inventarioCompras.get(prod).getValorCusto() * (0)))), 13))
                + codigoPosseProduto + ajustarTamanhoNumerico("00",14) + ajustarTamanho(branco, 14) + ufEmpresa+ ajustarTamanho(branco,45) + "\r\n");
        }*/
           
        }
        return registro_setenta_quatro_inventario;
    }
    
    
    public String registroSetentaCincoVendas(Date dataInicial, Date dataFinal, String modelo ){
    ArrayList<ModelVendasProdutos> vendasProdutos = new ArrayList<>();
    String dataInicialString = "";
    String dataFinalString = "";
    String codigoProduto = "";
    String ncm = "";
    String descricaoProduto = "";
    String unidadeMedida = "";
    String aliquotaIpi = "00000";
    String aliquotaIcms = "0000";
    String redBcIcms = "00000";    
    String bcIcmsSub = "0000000000000";    
    String branco = " "; 
    
        
    
    modelNF = controllerNF.getListaDataNFController(dataInicial, dataFinal, modelo);
    modelNF.addAll(controllerNF.getListaDataNFController(dataInicial, dataFinal, "55"));
    modelVendasProdutos = controllerVendasProdutos.getListaVendasProdutosController();
        System.out.println(modelNF.size() + "TAMANHO NOTA FISCAL SAIDA");
    for (int i=0; i<modelNF.size(); i++){
        for (int j=0; j<modelVendasProdutos.size(); j++){
            if (modelNF.get(i).getPedido() == modelVendasProdutos.get(j).getCodigo_venda()) {
                vendasProdutos.add(modelVendasProdutos.get(j));
            }
        }
    }
    System.out.println(modelNF.size() + "PASSOU FOR 1");
    for (int h=0; h<vendasProdutos.size();h++){
     dataInicialString = dataInicial.toString();
     System.out.println(dataInicialString + " DATA INICIAL");
     dataFinalString = dataFinal.toString();
     System.out.println(dataFinalString + " DATA FINAL");
     codigoProduto = ajustarTamanho((String.valueOf(vendasProdutos.get(h).getCodigo_produto())),14);
     System.out.println(codigoProduto + " CODIGO");
     ncm = String.valueOf(controllerProdutos.getProdutosController(vendasProdutos.get(h).getCodigo_produto()).getNcm());
     System.out.println(ncm + " NCM");
     descricaoProduto = ajustarTamanho(controllerProdutos.getProdutosController(vendasProdutos.get(h).getCodigo_produto()).getDescricaoProduto(),53);
     System.out.println(descricaoProduto + " DESCRICAO");
     unidadeMedida = ajustarTamanho(controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(vendasProdutos.get(h).getCodigo_produto()).getUnidadeMedida()).getAbreviacao(), 6);
     System.out.println(unidadeMedida + " UNIDADE");
     branco = ajustarTamanho(branco, 54);
     
     if (!(produtoControlesaida75.contains(vendasProdutos.get(h).getCodigo_produto()))){
        total_setenta_cinco += 1;
        registro_setenta_cinco_saida = registro_setenta_cinco_saida+("75"+dataInicialString.substring(0,4)+dataInicialString.substring(5,7)+dataInicialString.substring(8,10)+
            dataInicialString.substring(0,4)+dataInicialString.substring(5,7)+dataFinalString.substring(8,10)+codigoProduto+ncm+descricaoProduto+unidadeMedida+
            aliquotaIpi+aliquotaIcms+redBcIcms+bcIcmsSub+"\r\n");
        produtoControlesaida75.add(vendasProdutos.get(h).getCodigo_produto());
     }
     }    
    System.out.println("REGISTRO 75 SAI");
     return registro_setenta_cinco_saida;    
     }
    
    public String registroSetentaCincoVendasInventario(Date dataInicial, Date dataFinal, String modelo ){
    ArrayList<ModelVendasProdutos> vendasProdutos = new ArrayList<>();
    String dataInicialString = "";
    String dataFinalString = "";
    String codigoProduto = "";
    String ncm = "";
    String descricaoProduto = "";
    String unidadeMedida = "";
    String aliquotaIpi = "00000";
    String aliquotaIcms = "0000";
    String redBcIcms = "00000";    
    String bcIcmsSub = "0000000000000";    
    String branco = " "; 
    
    dataFinalString = String.valueOf(dataFinal);
    dataInicialString = String.valueOf("01/01/" +dataFinalString.substring( 0, 4));
        try {    
            dataInicial = bLmascaras.converterDataStringParaDate(dataInicialString);
        } catch (Exception ex) {
            Logger.getLogger(gerarSintegra.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    modelNF = controllerNF.getListaDataNFController(dataInicial, dataFinal, modelo);
    modelVendasProdutos = controllerVendasProdutos.getListaVendasProdutosController();
    for (int i=0; i<modelNF.size(); i++){
        for (int j=0; j<modelVendasProdutos.size(); j++){
            if (modelNF.get(i).getPedido() == modelVendasProdutos.get(j).getCodigo_venda()) {
                vendasProdutos.add(modelVendasProdutos.get(j));
            }
        }
    }
    for (int h=0; h<vendasProdutos.size();h++){
     dataInicialString = dataInicial.toString();
     dataFinalString = dataFinal.toString();
     codigoProduto = ajustarTamanho((String.valueOf(vendasProdutos.get(h).getCodigo_produto())),14);
     ncm = String.valueOf(controllerProdutos.getProdutosController(vendasProdutos.get(h).getCodigo_produto()).getNcm());
     descricaoProduto = ajustarTamanho(controllerProdutos.getProdutosController(vendasProdutos.get(h).getCodigo_produto()).getDescricaoProduto(),53);
     unidadeMedida = ajustarTamanho(controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(vendasProdutos.get(h).getCodigo_produto()).getUnidadeMedida()).getAbreviacao(), 6);
     branco = ajustarTamanho(branco, 54);
     
     if (!(produtoControlesaida75.contains(vendasProdutos.get(h).getCodigo_produto()))){
        total_setenta_cinco_inventario += 1;
        registro_setenta_cinco_saida_inventario = registro_setenta_cinco_saida_inventario+("75"+dataInicialString.substring(0,4)+dataInicialString.substring(5,7)+dataInicialString.substring(8,10)+
            dataFinalString.substring(0,4)+dataFinalString.substring(5,7)+dataFinalString.substring(8,10)+codigoProduto+ncm+descricaoProduto+unidadeMedida+
            aliquotaIpi+aliquotaIcms+redBcIcms+bcIcmsSub+"\r\n");
        produtoControlesaida75.add(vendasProdutos.get(h).getCodigo_produto());
     }
     }    
     return registro_setenta_cinco_saida_inventario;    
     }
    
    public String registroSetentaCincoCompras(Date dataInicial, Date dataFinal, String modelo ){
    ArrayList<ModelComprasProdutos> comprasProdutos = new ArrayList<>();
    String dataInicialString = "";
    String dataFinalString = "";
    String codigoProduto = "";
    String ncm = "";
    String descricaoProduto = "";
    String unidadeMedida = "";
    String aliquotaIpi = "00000";
    String aliquotaIcms = "0000";
    String redBcIcms = "00000";    
    String bcIcmsSub = "0000000000000";    
    String branco = " "; 
        
    
    modelNFEntrada = controllerNF.getListaDataNFCompraController(dataInicial, dataFinal, modelo);
    modelComprasProdutos = controllerComprasProdutos.getListacompras_produtosController();
    produtoControleentrada75.clear();
        
    for (int i=0; i<modelNFEntrada.size(); i++){
        for (int j=0; j<modelComprasProdutos.size(); j++){
            if (modelNFEntrada.get(i).getPedido() == modelComprasProdutos.get(j).getCodCompras()) {
                comprasProdutos.add(modelComprasProdutos.get(j));
            }
        }
    }
    for (int h=0; h<comprasProdutos.size();h++){
     dataInicialString = dataInicial.toString();
     dataFinalString = dataFinal.toString();
     codigoProduto = ajustarTamanho((String.valueOf(comprasProdutos.get(h).getCodProduto())),14);
     ncm = comprasProdutos.get(h).getNcm();
     descricaoProduto = ajustarTamanho(comprasProdutos.get(h).getNomeProdutoEstoque(),53);
     if (controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(comprasProdutos.get(h).getCodProduto()).getUnidadeMedida()).getAbreviacao() == null){
     unidadeMedida = "      "    ;
     }else{
     unidadeMedida = ajustarTamanho(controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(comprasProdutos.get(h).getCodProduto()).getUnidadeMedida()).getAbreviacao(), 6);
     }
     branco = ajustarTamanho(branco, 54);
     
     if (!(produtoControleentrada75.contains(comprasProdutos.get(h).getCodProduto()))) {
         if(!(produtoControlesaida75.contains(comprasProdutos.get(h).getCodProduto()))){
        total_setenta_cinco += 1;
        registro_setenta_cinco_entrada = registro_setenta_cinco_entrada+("75"+dataInicialString.substring(0,4)+dataInicialString.substring(5,7)+dataInicialString.substring(8,10)+
            dataInicialString.substring(0,4)+dataInicialString.substring(5,7)+dataFinalString.substring(8,10)+codigoProduto+ncm+descricaoProduto+unidadeMedida+
            aliquotaIpi+aliquotaIcms+redBcIcms+bcIcmsSub+"\r\n");
        produtoControleentrada75.add(comprasProdutos.get(h).getCodProduto());
         }
         }
     }    
    System.out.println("REGISTRO 75 ENT");
     return registro_setenta_cinco_entrada;    
     }
    
    public String registroSetentaCincoCompraInventario(Date dataInicial, Date dataFinal, String modelo ){
    ArrayList<ModelComprasProdutos> comprasProdutos = new ArrayList<>();
    String dataInicialString = "";
    String dataFinalString = "";
    String codigoProduto = "";
    String ncm = "";
    String descricaoProduto = "";
    String unidadeMedida = "";
    String aliquotaIpi = "00000";
    String aliquotaIcms = "0000";
    String redBcIcms = "00000";    
    String bcIcmsSub = "0000000000000";    
    String branco = " "; 
        
    dataFinalString = String.valueOf(dataFinal);
    dataInicialString = String.valueOf("01/01/" +dataFinalString.substring( 0, 4));
        try {    
            dataInicial = bLmascaras.converterDataStringParaDate(dataInicialString);
        } catch (Exception ex) {
            Logger.getLogger(gerarSintegra.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    modelNFEntrada = controllerNF.getListaDataNFCompraController(dataInicial, dataFinal, modelo);
    modelComprasProdutos = controllerComprasProdutos.getListacompras_produtosController();
    produtoControleentrada75.clear();
        
    for (int i=0; i<modelNFEntrada.size(); i++){
        for (int j=0; j<modelComprasProdutos.size(); j++){
            if (modelNFEntrada.get(i).getPedido() == modelComprasProdutos.get(j).getCodCompras()) {
                comprasProdutos.add(modelComprasProdutos.get(j));
            }
        }
    }
    for (int h=0; h<comprasProdutos.size();h++){
     dataInicialString = dataInicial.toString();
     dataFinalString = dataFinal.toString();
     codigoProduto = ajustarTamanho((String.valueOf(comprasProdutos.get(h).getCodProduto())),14);
     ncm = comprasProdutos.get(h).getNcm();
     descricaoProduto = ajustarTamanho(comprasProdutos.get(h).getNomeProdutoEstoque(),53);
     if (controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(comprasProdutos.get(h).getCodProduto()).getUnidadeMedida()).getAbreviacao() == null){
     unidadeMedida = "      "    ;
     }else{
     unidadeMedida = ajustarTamanho(controllerUnidadeMedia.getUnidadeMediaController(controllerProdutos.getProdutosController(comprasProdutos.get(h).getCodProduto()).getUnidadeMedida()).getAbreviacao(), 6);
     }
     branco = ajustarTamanho(branco, 54);
     
     if (!(produtoControleentrada75.contains(comprasProdutos.get(h).getCodProduto()))) {
         if(!(produtoControlesaida75.contains(comprasProdutos.get(h).getCodProduto()))){
        total_setenta_cinco_inventario += 1;
        registro_setenta_cinco_entrada_inventario = registro_setenta_cinco_entrada_inventario+("75"+dataInicialString.substring(0,4)+dataInicialString.substring(5,7)+dataInicialString.substring(8,10)+
            dataFinalString.substring(0,4)+dataFinalString.substring(5,7)+dataFinalString.substring(8,10)+codigoProduto+ncm+descricaoProduto+unidadeMedida+
            aliquotaIpi+aliquotaIcms+redBcIcms+bcIcmsSub+"\r\n");
        produtoControleentrada75.add(comprasProdutos.get(h).getCodProduto());
         }
         }
     }    
     return registro_setenta_cinco_entrada_inventario;    
     }
    
    
    
    public String registroNoventa(Date dataInicial, Date dataFinal, String modelo ){
        modelEmpresa = controllerEmpresa.getEmpresaController(1).getModelEmpresa();
        
        String totalCinquenta;
        String totalCinquentaTres;
        String totalCinquentaquatro;
        String totalSessentaUm;
        String totalSetentaQuatro;
        String totalSetentaCinco;
        String totalNoventa;
        String cnpj;
        String ie;
        String branco = " ";
        
        cnpj = modelEmpresa.getCnpj();
        ie = ajustarTamanho(modelEmpresa.getInscEstad(), 14);
        total_noventa += 1;
        totalCinquenta = "50"+ajustarTamanhoNumerico(String.valueOf(total_cinquenta_entrada + total_cinquenta_saida), 8);
        totalCinquentaTres = "53"+ajustarTamanhoNumerico(String.valueOf(total_cinquenta_tres), 8);
        totalCinquentaquatro = "54"+ajustarTamanhoNumerico(String.valueOf(total_cinquenta_quatro_entrada + total_cinquenta_quatro_saida), 8);
        totalSessentaUm = "61"+ajustarTamanhoNumerico(String.valueOf(total_sessenta_um + total_sessenta_um_erre), 8);
        totalSetentaQuatro = "74"+ajustarTamanhoNumerico(String.valueOf(total_setenta_quatro), 8);
        totalSetentaCinco = "75"+ajustarTamanhoNumerico(String.valueOf(total_setenta_cinco+total_setenta_cinco_inventario), 8);
        totalNoventa = "99"+ajustarTamanhoNumerico(String.valueOf(total_cinquenta_entrada + total_cinquenta_saida +
                total_cinquenta_tres+total_cinquenta_quatro_entrada + total_cinquenta_quatro_saida+total_sessenta_um + 
                total_sessenta_um_erre+total_setenta_quatro+total_setenta_cinco+
                total_setenta_cinco_inventario+total_noventa+total_dez+total_onze), 8);
        branco = ajustarTamanho(branco, 25);
        registro_noventa = "90"+cnpj+ie+totalCinquenta+totalCinquentaTres+totalCinquentaquatro+totalSessentaUm+
                totalSetentaQuatro+totalSetentaCinco+totalNoventa+branco+"1";
        System.out.println("REGISTRO 90 ");
        return registro_noventa;
    }
    
}
