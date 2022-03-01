/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe.util;

/**
 *
 * @author leand
 */
public class TraduzirXmlNfe {

    public String traduzir(String pNome) {
        String pNomeTradu = "";

        if (pNome.equals("cobr")) {
            pNomeTradu = "Financeiro";
        } else if (pNome.equals("transp")) {
            pNomeTradu = "Transportadora";
        }else if (pNome.equals("ide")) {
            pNomeTradu = "Identificação";
        }else if (pNome.equals("emit")) {
            pNomeTradu = "Emitente";
        }else if (pNome.equals("dest")) {
            pNomeTradu = "Destinatário";
        }else if (pNome.equals("total")) {
            pNomeTradu = "Totais";
        }else if (pNome.equals("infProt")) {
            pNomeTradu = "Protocolo";
        }else if (pNome.equals("Id")) {
            pNomeTradu = "Chave da NFe";
        }else if (pNome.equals("cUF")) {
            pNomeTradu = "Cod.UF";
        }else if (pNome.equals("cNF")) {
            pNomeTradu = "Cod.Nota Fiscal";
        }else if (pNome.equals("natOp")) {
            pNomeTradu = "Natureza de Operacao";
        }else if (pNome.equals("indPag")) {
            pNomeTradu = "Indice Pagto";
        }else if (pNome.equals("mod")) {
            pNomeTradu = "Modelo da NFe";
        }else if (pNome.equals("serie")) {
            pNomeTradu = "Serie da NFe";
        }else if (pNome.equals("nNF")) {
            pNomeTradu = "Numero da NFe";
        }else if (pNome.equals("dEmi")) {
            pNomeTradu = "Data de Emissao";
        }else if (pNome.equals("dSaiEnt")) {
            pNomeTradu = "Data da Saida/Entrada";
        }else if (pNome.equals("tpNF")) {
            pNomeTradu = "Tipo de Nota Fiscal";
        }else if (pNome.equals("cMunFG")) {
            pNomeTradu = "Codigo do Município";
        }else if (pNome.equals("tpImp")) {
            pNomeTradu = "Tipo de Impressão";
        }else if (pNome.equals("tpEmis")) {
            pNomeTradu = "Tipo de Emissão";
        }else if (pNome.equals("cDV")) {
            pNomeTradu = "Código Verificador";
        }else if (pNome.equals("tpAmb")) {
            pNomeTradu = "Ambiente(1-Produção/2-Homologação)";
        }else if (pNome.equals("finNFe")) {
            pNomeTradu = "Finalidade da NFe";
        }else if (pNome.equals("procEmi")) {
            pNomeTradu = "Tipo de Emissão";
        }else if (pNome.equals("verProc")) {
            pNomeTradu = "Versão do Sistema Emissor";
        }else if (pNome.equals("xNome")) {
            pNomeTradu = "Nome";
        }else if (pNome.equals("xFant")) {
            pNomeTradu = "Fantasia";
        }else if (pNome.equals("xLgr")) {
            pNomeTradu = "Logradouro";
        }else if (pNome.equals("IE")) {
            pNomeTradu = "Insc.Estadual";
        }else if (pNome.equals("nro")) {
            pNomeTradu = "Numero";
        }else if (pNome.equals("xBairro")) {
            pNomeTradu = "Bairro";
        }else if (pNome.equals("cMun")) {
            pNomeTradu = "Cod.Municipio";
        }else if (pNome.equals("xMun")) {
            pNomeTradu = "Nome Municipio";
        }else if (pNome.equals("cPais")) {
            pNomeTradu = "Cod.Pais";
        }else if (pNome.equals("fone")) {
            pNomeTradu = "Telefone";
        }else if (pNome.equals("xPais")) {
            pNomeTradu = "Nome Pais";
        }else if (pNome.equals("cProd")) {
            pNomeTradu = "Cod.Produto";
        }else if (pNome.equals("xProd")) {
            pNomeTradu = "Descr.Produto";
        }else if (pNome.equals("CFOP")) {
            pNomeTradu = "Cod.Fiscal de Operacao";
        }else if (pNome.equals("cEAN")) {
            pNomeTradu = "EAN";
        }else if (pNome.equals("uCom")) {
            pNomeTradu = "Unid.Comercial";
        }else if (pNome.equals("qCom")) {
            pNomeTradu = "Qtde Comercial";
        }else if (pNome.equals("vUnCom")) {
            pNomeTradu = "Vlr Unit.Comercial";
        }else if (pNome.equals("vProd")) {
            pNomeTradu = "Valor do Produto";
        }else if (pNome.equals("cEANTrib")) {
            pNomeTradu = "Cod.EAN Tributável";
        }else if (pNome.equals("uTrib")) {
            pNomeTradu = "Unidade Tributável";
        }else if (pNome.equals("qTrib")) {
            pNomeTradu = "Qtde Tributável";
        }else if (pNome.equals("vUnTrib")) {
            pNomeTradu = "Vlr Unit.Tributável";
        }else if (pNome.equals("orig")) {
            pNomeTradu = "Origem";
        }else if (pNome.equals("CST")) {
            pNomeTradu = "Cod.Sit.Tributária";
        }else if (pNome.equals("modBC")) {
            pNomeTradu = "Tipo de Base de Cálculo";
        }else if (pNome.equals("pRedBC")) {
            pNomeTradu = "% Redução Base Cálculo";
        }else if (pNome.equals("pICMS")) {
            pNomeTradu = "Redução ICMS";
        }else if (pNome.equals("pPIS")) {
            pNomeTradu = "% Redução PIS";
        }else if (pNome.equals("pCOFINS")) {
            pNomeTradu = "% Redução COFINS";
        }else if (pNome.equals("infCpl")) {
            pNomeTradu = "Informações Adicionais";
        }else if (pNome.equals("infAdic")) {
            pNomeTradu = "Informações Adicionais";
        }else if (pNome.equals("modFrete")) {
            pNomeTradu = "Tipo de Frete";
        }else if (pNome.equals("xEnder")) {
            pNomeTradu = "Endereço";
        }else if (pNome.equals("qVol")) {
            pNomeTradu = "Qtde de Volumes";
        }else if (pNome.equals("pesoL")) {
            pNomeTradu = "Peso Líquido";
        }else if (pNome.equals("pesoB")) {
            pNomeTradu = "Peso Bruto";
        }else if (pNome.equals("vBC")) {
            pNomeTradu = "Base de Calculo";
        }else if (pNome.equals("vICMS")) {
            pNomeTradu = "Valor ICMS";
        }else if (pNome.equals("vBCST")) {
            pNomeTradu = "Base Calc.Subst.Tributária";
        }else if (pNome.equals("vST")) {
            pNomeTradu = "Valor Sit.Tributária";
        }else if (pNome.equals("vFrete")) {
            pNomeTradu = "Valor do Frete";
        }else if (pNome.equals("vSeg")) {
            pNomeTradu = "Valor do Seguro";
        }else if (pNome.equals("vDesc")) {
            pNomeTradu = "Valor do Desconto";
        }else if (pNome.equals("vIPI")) {
            pNomeTradu = "Valor do IPI";
        }else if (pNome.equals("vPIS")) {
            pNomeTradu = "Valor do PIS";
        }else if (pNome.equals("vCOFINS")) {
            pNomeTradu = "Valor do COFINS";
        }else if (pNome.equals("vOutro")) {
            pNomeTradu = "Valor de Outros";
        }else if (pNome.equals("vNF")) {
            pNomeTradu = "Valor da Nota Fiscal";
        }else if (pNome.equals("verAplic")) {
            pNomeTradu = "Versão da Aplicação";
        }else if (pNome.equals("chNFe")) {
            pNomeTradu = "Chave da NFe";
        }else if (pNome.equals("dhRecbto")) {
            pNomeTradu = "Data e Hora do Recebimento";
        }else if (pNome.equals("nProt")) {
            pNomeTradu = "Número do Protocolo";
        }else if (pNome.equals("digVal")) {
            pNomeTradu = "Texto de Validação";
        }else if (pNome.equals("cStat")) {
            pNomeTradu = "Status da NFe";
        }else if (pNome.equals("xMotivo")) {
            pNomeTradu = "Situação da NFe";
        }

        return pNomeTradu;
    }

}
