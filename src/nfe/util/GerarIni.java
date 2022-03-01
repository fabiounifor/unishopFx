/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe.util;

import util.*;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerEmpresaCidadeEstado;
import controller.ControllerProdutos;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import controller.ControllerCaixa;
import controller.ControllerGarcom;
import controller.ControllerItensPedidoMesa;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelClienteCidadeEstado;
import model.ModelEmpresaCidadeEstado;
import model.ModelVendas;
import model.ModelVendasProdutos;
import model.ModelGarcom;
import model.ModelCaixa;
import model.ModelSessaoUsuario;
import model.ModelItensPedidoMesa;
import nfe.model.ModelNFCe;
import nfe.model.ModelXmlNfe;


/**
 *
 * @author leand
 */
public class GerarIni {

    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerGarcom controllerGarcom = new ControllerGarcom();
    ControllerItensPedidoMesa controllerItensPedidoMesa = new ControllerItensPedidoMesa();
    ControllerEmpresaCidadeEstado controllerEmpresaCidadeEstado = new ControllerEmpresaCidadeEstado();
    ArrayList<ModelVendasProdutos> listaModelVendasProdutoses = new ArrayList<>();
    ArrayList<ModelItensPedidoMesa> listaModelItensPedidoMesa = new ArrayList<>();
    ArrayList<ModelCaixa> listaModelCaixa = new ArrayList<>();
    ModelVendas modelVendas = new ModelVendas();
    ModelCaixa modelCaixa = new ModelCaixa();
    ModelGarcom modelGarcom = new ModelGarcom();
    ModelSessaoUsuario modelSessaoUsuario = new ModelSessaoUsuario();
    ModelEmpresaCidadeEstado modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
    BLMascaras bLMascaras = new BLMascaras();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();

    public String geraArquivoIni(int pCodigo) throws IOException {
        String textoParaImprimir = "";
        try {

            modelVendas = controllerVendas.getVendasController(pCodigo);
            listaModelVendasProdutoses = controllerVendasProdutos.getListaVendasProdutosController(pCodigo);
            modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);

            //data e hora do sistema
            String data = "dd/MM/yyyy";
            String hora = "h:mm - a";
            String data1, hora1;
            java.util.Date agora = new java.util.Date();
            SimpleDateFormat formata = new SimpleDateFormat(data);
            data1 = formata.format(agora);
            formata = new SimpleDateFormat(hora);
            hora1 = formata.format(agora);
            //fim data e hora do sistema

            String conteudoFor = "";
            for (int i = 0; i < listaModelVendasProdutoses.size(); i++) {
                conteudoFor += listaModelVendasProdutoses.get(i).getQuantidade() + " x " + controllerProdutos.getProdutosController(listaModelVendasProdutoses.get(i).getCodigo_produto()).getNome() + " - " + listaModelVendasProdutoses.get(i).getCodigo_venda() + "\n\r";
            }
            //armazenar em uma string o texto(cupom) para imprimir
            textoParaImprimir = (modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "\n\r"
                    + "Data venda: " + modelVendas.getDataVenda() + "\n\r" + "Impressao:" + data1 + "-" + hora1 + "\n\r"
                    + "--------------------------------\n\r"
                    + "        CUPOM COZINHA        \n\r"
                    + "--------------------------------\n\r"
                    + "QT   DESCRICAO   OBS.\n\r"
                    + conteudoFor + ""
                    + "--------------------------------\n\r"
                    + "Valor bruto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal()) + "\n\r"
                    + "   Desconto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getDesconto()) + "\n\r"
                    + "Valor total: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal() - modelVendas.getDesconto()) + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f");
            //chamar metodo para imprimir
            // /n/r para novas linhas e /f para fim da pagina  
        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }
    
    public String geraCupomCaixa(int numeroCaixa) throws IOException {
        String textoParaImprimir = "";
        try {
            modelCaixa = controllerCaixa.retorarCaixaControler(numeroCaixa);
            modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);

            //data e hora do sistema
            String data = "dd/MM/yyyy";
            String hora = "h:mm - a";
            String data1, hora1;
            java.util.Date agora = new java.util.Date();
            SimpleDateFormat formata = new SimpleDateFormat(data);
            data1 = formata.format(agora);
            formata = new SimpleDateFormat(hora);
            hora1 = formata.format(agora);
            //fim data e hora do sistema

            //String conteudoFor = "";
            
            String conteudoFor = modelCaixa.getCaixaNumero() + "--" + modelCaixa.getCartao() + "--" + modelCaixa.getDinheiro() + " \n\r";
            
            //armazenar em uma string o texto(cupom) para imprimir
            textoParaImprimir = "======="+(modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia() + "=====" +"\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "\n\r"
                    + "Data Fechamento do caixa: " + modelCaixa.getDataFechamento() + "\n\r" 
                    + "Impressao:" + data1 + "-" + hora1 + "\n\r"
                    + "--------------------------------\n\r"
                    + "        FECHAMENTO DE CAIXA        \n\r"
                    + "--------------------------------\n\r"
                    + "CAIXA   CARTÃO   DINHEIRO\n\r"
                    + conteudoFor + ""
                    + "TOTAL DO CAIXA = " + ((bLMascaras.arredondamentoComPontoDuasCasas((float) modelCaixa.getCartao()))+ (bLMascaras.arredondamentoComPontoDuasCasas((float) modelCaixa.getDinheiro())))  + "\n\r"
                    + "--------------------------------\n\r"
                    + "\n\r\n\r\n\r\n\r") ;
            //chamar metodo para imprimir
            // /n/r para novas linhas e /f para fim da pagina  
        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }

    public String geraCupomCaixaEmail(int numeroCaixa) throws IOException {
        String textoParaEnviar = "";
        try {
            modelCaixa = controllerCaixa.retorarCaixaControler(numeroCaixa);
            modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);
            

            //data e hora do sistema
            String data = "dd/MM/yyyy";
            String hora = "h:mm - a";
            String data1, hora1;
            java.util.Date agora = new java.util.Date();
            SimpleDateFormat formata = new SimpleDateFormat(data);
            data1 = formata.format(agora);
            formata = new SimpleDateFormat(hora);
            hora1 = formata.format(agora);
            //fim data e hora do sistema

            //String conteudoFor = "";
            
            String conteudoFor = "<html>" + "---   "+ modelCaixa.getCaixaNumero() + "-----   " + modelCaixa.getCartao() + "-------   " + modelCaixa.getDinheiro() + "<br>" ;
            String usuario = modelSessaoUsuario.nome;
            //armazenar em uma string o texto(cupom) para imprimir
            textoParaEnviar = (modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia() + "<br>"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "<br>"
                    + modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "<br>"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "<br>"
                    + "OPERADOR: " + usuario + "<br>"
                    + "Data Fechamento do caixa: " + data1 + "<br>" 
                    + "Hora Fechamento do caixa: " + hora1 + "<br>"
                    + "--------------------------------<br>"
                    + "        FECHAMENTO DE CAIXA        <br>"
                    + "--------------------------------<br>"
                    + "CAIXA      CARTÃO      DINHEIRO <br>"
                    + conteudoFor + ""
                    + "TOTAL DO CAIXA = " + ((bLMascaras.arredondamentoComPontoDuasCasas((float) modelCaixa.getCartao()))+ (bLMascaras.arredondamentoComPontoDuasCasas((float) modelCaixa.getDinheiro())))  + "<br>"
                    + "--------------------------------<br>"
                    + "</html>") ;
            //chamar metodo para imprimir
            // /n/r para novas linhas e /f para fim da pagina  
        } catch (Exception e) {
            textoParaEnviar = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaEnviar;

    }
    public String geraCupomDelivery(int pCodigo) throws IOException {
        String textoParaImprimir = "";
        modelVendas = controllerVendas.getVendasController(pCodigo);
        listaModelVendasProdutoses = controllerVendasProdutos.getListaVendasProdutosController(pCodigo);
        modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(modelVendas.getClientesCodigo());

        //data e hora do sistema
        String data = "dd/MM/yyyy";
        String hora = "h:mm - a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        //fim data e hora do sistema

        try {

            String conteudoFor = "";
            for (int i = 0; i < listaModelVendasProdutoses.size(); i++) {
                conteudoFor += listaModelVendasProdutoses.get(i).getQuantidade() + " x " + controllerProdutos.getProdutosController(listaModelVendasProdutoses.get(i).getCodigo_produto()).getNome() + " - " + listaModelVendasProdutoses.get(i).getCodigo_venda() + "\n\r";
            }
            //armazenar em uma string o texto(cupom) para imprimir
            textoParaImprimir = (modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "\n\r"
                    + "Data venda: " + modelVendas.getDataVenda() + "\n\r" + "Impressao:" + data1 + "-" + hora1 + "\n\r"
                    + "--------------------------------\n\r"
                    + "         CUPOM DELIVERY         \n\r"
                    + "--------------------------------\n\r"
                    + "             CLIENTE            \n\r"
                    + "--------------------------------\n\r"
                    + modelClienteCidadeEstado.getModelCliente().getNome() + "\n\r"
                    + modelClienteCidadeEstado.getModelCliente().getTelefone() + "\n\r"
                    + modelClienteCidadeEstado.getModelCliente().getEndereco() + "\n\r"
                    + modelClienteCidadeEstado.getModelCliente().getBairro() + "\n\r"
                    + "--------------------------------\n\r"
                    + "QT   DESCRICAO   OBS.\n\r"
                    + conteudoFor + ""
                    + "--------------------------------\n\r"
                    + "Valor bruto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal()) + "\n\r"
                    + "   Desconto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getDesconto()) + "\n\r"
                    + "Valor total: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal() - modelVendas.getDesconto()) + "\n\r"
                    + "OBS: " + modelVendas.getObservacao() + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f");
            //chamar metodo para imprimir
            // /n/r para novas linhas e /f para fim da pagina  
        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }

    public String gerarCupomPDV(int pMesa, int pGarcon, float pValorTotal) throws IOException {
        //modelVendas = controllerVendas.getVendasController(pCodigo);
        listaModelItensPedidoMesa = controllerItensPedidoMesa.getListaItensPedidoMesaController(pMesa);
        modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);
        controllerProdutos = new ControllerProdutos();
                  
        String textoParaImprimir = "";
        //data e hora do sistema
        String data = "dd/MM/yyyy";
        String hora = "h:mm - a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        String linha1 = modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia();
        String linha2 = "TELEFONE:" + modelEmpresaCidadeEstado.getModelEmpresa().getTelefone();
        String linha3 = "Data venda: " + data1 + "-" + hora1;
        //fim data e hora do sistema
        try {
            float valortotalcomtx;
            float valortx;
            String conteudoFor = "";
            if(pGarcon == 1){
                valortotalcomtx = (pValorTotal);
                valortx = 0.0f;
            }else{
            valortotalcomtx = (pValorTotal * 1.1f);
            valortx = (pValorTotal * 0.1f);
            }  
            for (int i = 0; i < listaModelItensPedidoMesa.size(); i++) {
                  int tDescricao = 28;
                  int tCodigo = 3;
                  int tQuantidade = 4;
                  int tLinha = 48;
                  
                  
                  String nomeProduto = (controllerProdutos.getProdutosController(listaModelItensPedidoMesa.get(i).getCodigoProduto()).getNome()+"");
                  String codigoProduto = (String.valueOf(listaModelItensPedidoMesa.get(i).getCodigoProduto()));
                  String quantidadeProduto = (String.valueOf(listaModelItensPedidoMesa.get(i).getQuantidade()));
             
                  int tamanhoLinha1 = linha1.length();
                  int tamanhoLinha2 = linha2.length();
                  int tamanhoLinha3 = linha3.length();
                  int tamanhoCodigo = codigoProduto.length();
                  int tamanhoQuantidade = quantidadeProduto.length();
                  int tamanhoNomeProduto = nomeProduto.length(); 
                  
                   
                  if (tamanhoLinha1 < tLinha){
                  int difLinha1 = tLinha - tamanhoLinha1;
                  int l1 = 0;    
                  while (l1< difLinha1){
                          linha1 = linha1 +" ";
                          linha1 = " " + linha1;
                          l1 = l1+2;
                      }
                  }
                  if (tamanhoLinha2 < tLinha){
                      int difLinha2 = tLinha - tamanhoLinha2;
                      for (int l2 = 0; l2< difLinha2; l2++){
                          linha2 = linha2 +" ";
                          linha2 = " " + linha2;
                          l2 = l2+1;
                      }
                  }
                  if (tamanhoLinha3 < tLinha){
                      int difLinha3 = tLinha - tamanhoLinha3;
                      for (int l3 = 0; l3< difLinha3; l3++){
                          linha3 = linha3 +" ";
                          linha3 = " " + linha3;
                          l3 = l3+1;
                      }
                  }
                  
                    if(tamanhoNomeProduto < tDescricao ){
                    int difNome = tDescricao - tamanhoNomeProduto;
                    for (int t=0; t < difNome; t++){
                    nomeProduto = nomeProduto + " ";
                    }
                                       
                    }else{
                            
                    nomeProduto = nomeProduto.substring(0, tDescricao);
                    }
                    if (tamanhoCodigo < tCodigo ) {
                    int difCodigo = tCodigo - tamanhoCodigo;
                        for (int c=0;c<difCodigo;c++){
                            codigoProduto = codigoProduto + " ";
                        }
                    }else{
                     codigoProduto = codigoProduto.substring(0, tCodigo);
                    }
                    if (tamanhoQuantidade < tQuantidade ) {
                    int difQuantidade = tQuantidade - tamanhoQuantidade;
                     for (int c=0;c<difQuantidade;c++){
                   
                      quantidadeProduto =  " " +quantidadeProduto;
                      }
                    }else{
                   
                     quantidadeProduto = quantidadeProduto.substring(0, tQuantidade);
                    }
                    
                conteudoFor += codigoProduto + " "+ nomeProduto + "   "+quantidadeProduto+ "   " + bLMascaras.arredondamentoDoubleComPontoDuasCasasString(controllerProdutos.getProdutosController(listaModelItensPedidoMesa.get(i).getCodigoProduto()).getValor()) + "\n\n\r";
            }
                textoParaImprimir = (linha1 +"\n\r"
                    + "------------------------------------------------\n\r"
                    + linha2 + "\n\r"
                    + "------------------------------------------------\n\r"
                    //+ modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "\n\r"
                    //+ modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "\n\r"
                    //+ modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "\n\r"
                    + linha3 + "\n\n\r"
                    + "------------------------------------------------\n\r"
                    + "                 CUPOM NAO FISCAL               \n\r"
                    + "------------------------------------------------\n\r"
                    + "COD DESCRICAO                      QUANT PRECO  \n\r"
                    + "------------------------------------------------\n\r"
                    + conteudoFor + ""
                    + "------------------------------------------------\n\r"
                    + ".........................Garcon:" + (controllerGarcom.getGarcomController(pGarcon).getNome()) + "\n\r"
                    + "------------------------------------------------\n\r"
                    + "......................Sub Total:" + bLMascaras.arredondamentoComPontoDuasCasasString(pValorTotal) + "\n\r"
                    + "------------------------------------------------\n\r"
                    + "...............Taxa de Servico :" + bLMascaras.arredondamentoComPontoDuasCasasString(valortx) + "\n\r"
                    + "------------------------------------------------\n\r"
                    + ".................VALOR A PAGAR :" + bLMascaras.arredondamentoComPontoDuasCasasString(valortotalcomtx) + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f"
                    + "\n\r\n\r\n\r\n\r\f" 
                    + "\n\r\n\r\n\r\n\r\f" );
            
                    

        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }
    
    
    public String gerarCupomcxPDV(int pCodigo) throws IOException {
        modelVendas = controllerVendas.getVendasController(pCodigo);
        listaModelVendasProdutoses = controllerVendasProdutos.getListaVendasProdutosController(pCodigo);
        modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);

        String textoParaImprimir = "";
        //data e hora do sistema
        String data = "dd/MM/yyyy";
        String hora = "h:mm - a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        //fim data e hora do sistema

        try {
            String conteudoFor = "";
            
            float valortotal = (modelVendas.getValorTotal());
            
            
            
            for (int i = 0; i < listaModelVendasProdutoses.size(); i++) {
                int tamanhoNomeProduto = (controllerProdutos.getProdutosController(listaModelVendasProdutoses.get(i).getCodigo_produto()).getNome()).length();
                String nomeProduto = (controllerProdutos.getProdutosController(listaModelVendasProdutoses.get(i).getCodigo_produto()).getNome());
                
                if(tamanhoNomeProduto < 22 ){
                    int diferenca = 22 - tamanhoNomeProduto;
                    for (int t=0; t < diferenca; t++){
                        nomeProduto = nomeProduto + " ";
                    }
                                       
                }else{
                            
                    nomeProduto = nomeProduto.substring(0, 22);
                    }
                
                conteudoFor += nomeProduto+" "+ listaModelVendasProdutoses.get(i).getCodigo_produto() + " " + listaModelVendasProdutoses.get(i).getQuantidade() + "     " + bLMascaras.arredondamentoDoubleComPontoDuasCasasString(controllerProdutos.getProdutosController(listaModelVendasProdutoses.get(i).getCodigo_produto()).getValor()) + "    "  + "\n\r";
            }
            textoParaImprimir = (modelEmpresaCidadeEstado.getModelEmpresa().getNomeFantasia() + "- TELEFONE:" + modelEmpresaCidadeEstado.getModelEmpresa().getTelefone() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelCidade().getNome() + "-" + modelEmpresaCidadeEstado.getModelEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getModelEmpresa().getCnpj() + "\n\r"
                    + " PEDIDO NUMERO:  " + modelVendas.getCodigo() + "\n\r"
                    + "Data venda: " + data1 + "-" + hora1 + "\n\r"
                    + "------------------------------------------------\n\r"
                    + "                 CUPOM NAO FISCAL               \n\r"
                    + "------------------------------------------------\n\r"
                    + "COD DESCRICAO                 QUANT      PRECO  \n\r"
                    + conteudoFor + ""
                    + "------------------------------------------------\n\r"
                    + ".................VALOR APAGAR :" + bLMascaras.arredondamentoComPontoDuasCasasString(valortotal) + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f"
                    + "\n\r\n\r\n\r\n\r\f" 
                    + "\n\r\n\r\n\r\n\r\f" );
            
                    

        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }

}
