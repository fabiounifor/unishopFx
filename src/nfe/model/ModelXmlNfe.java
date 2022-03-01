/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe.model;

/**
 *
 * @author leand
 */
public class ModelXmlNfe {
    
    //  labels para panel
    private String cobr;//financeiro
    private String transp;//Transportadora
    private String ide;//Identificação
    private String emit;//Emitente
    private String dest;//Destinatário
    private String total;//totais
    private String infProt;//protocolo
    //    campos com valores
    private String Id;//Chave da NFe
    private String cUF;//Cod.UF
    private String cNF;//Cod.Nota Fiscal
    private String natOp;//Natureza de Operacao
    private String indPag;//Indice Pagto
    private String mod;//Modelo da NFe
    private String serie;//Serie da NFe
    private String nNF;//Numero da NFe
    private String dEmi;//Data de Emissao
    private String dSaiEnt;//Data da Saida/Entrada
    private String tpNF;//Tipo de Nota Fiscal
    private String cMunFG;//Codigo do Município
    private String tpImp;//Tipo de Impressão
    private String tpEmis;//Tipo de Emissão
    private String cDV;//Código Verificador
    private String tpAmb;//Ambiente(1-Produção/2-Homologação)
    private String finNFe;//Finalidade da NFe
    private String procEmi;//Tipo de Emissão
    private String verProc;//Versão do Sistema Emissor
    private String xNome;//Nome
    private String xFant;//Fantasia
    private String IE;//Insc.Estadual
    private String xLgr;//Logradouro
    private String nro;//Numero
    private String xBairro;//Bairro
    private String cMun;//Cod.Municipio
    private String xMun;//Nome Municipio
    private String cPais;//Cod.Pais
    private String fone;//Telefone
    private String xPais;//Nome Pais
    private String cProd;//Cod.Produto
    private String xProd;//Descr.Produto
    private String CFOP;//Cod.Fiscal de Operacao
    private String cEAN;//EAN
    private String uCom;//Unid.Comercial
    private String qCom;//Qtde Comercial
    private String vUnCom;//Vlr Unit.Comercial
    private String vProd;//Valor do Produto
    private String cEANTrib;//Cod.EAN Tributável
    private String uTrib;//Unidade Tributável
    private String qTrib;//Qtde Tributável
    private String vUnTrib;//Vlr Unit.Tributável
    private String orig;//Origem
    private String CST;//Cod.Sit.Tributária
    private String modBC;//Tipo de Base de Cálculo
    private String pRedBC;//% Redução Base Cálculo
    private String pICMS;//% Redução ICMS
    private String pPIS;//% Redução PIS
    private String pCOFINS;//% Redução COFINS
    private String infCpl;//Informações Adicionais
    private String infAdic;//Informações Adicionais
    private String modFrete;//Tipo de Frete
    private String xEnder;//Endereço
    private String qVol;//Qtde de Volumes
    private String pesoL;//Peso Líquido
    private String pesoB;//Peso Bruto
    private String vBC;//Base de Calculo
    private String vICMS;//Valor ICMS
    private String vBCST;//Base Calc.Subst.Tributária
    private String vST;//Valor Sit.Tributária
    private String vFrete;//Valor do Frete
    private String vSeg;//Valor do Seguro
    private String vDesc;//Valor do Desconto
    private String vIPI;//Valor do IPI
    private String vPIS;//Valor do PIS
    private String vCOFINS;//Valor do COFINS
    private String vOutro;//Valor de Outros
    private String vNF;//Valor da Nota Fiscal
    private String verAplic;//Versão da Aplicação
    private String chNFe;//Chave da NFe
    private String dhRecbto;//Data e Hora do Recebimento
    private String nProt;//Número do Protocolo
    private String digVal;//Texto de Validação
    private String cStat;//Status da NFe
    private String xMotivo;//Situação da NFe

    
    
    /**
     * @return the cobr
     */
    public String getCobr() {
        return cobr;
    }

    /**
     * @param cobr the cobr to set
     */
    public void setCobr(String cobr) {
        this.cobr = cobr;
    }

    /**
     * @return the transp
     */
    public String getTransp() {
        return transp;
    }

    /**
     * @param transp the transp to set
     */
    public void setTransp(String transp) {
        this.transp = transp;
    }

    /**
     * @return the ide
     */
    public String getIde() {
        return ide;
    }

    /**
     * @param ide the ide to set
     */
    public void setIde(String ide) {
        this.ide = ide;
    }

    /**
     * @return the emit
     */
    public String getEmit() {
        return emit;
    }

    /**
     * @param emit the emit to set
     */
    public void setEmit(String emit) {
        this.emit = emit;
    }

    /**
     * @return the dest
     */
    public String getDest() {
        return dest;
    }

    /**
     * @param dest the dest to set
     */
    public void setDest(String dest) {
        this.dest = dest;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the infProt
     */
    public String getInfProt() {
        return infProt;
    }

    /**
     * @param infProt the infProt to set
     */
    public void setInfProt(String infProt) {
        this.infProt = infProt;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the cUF
     */
    public String getcUF() {
        return cUF;
    }

    /**
     * @param cUF the cUF to set
     */
    public void setcUF(String cUF) {
        this.cUF = cUF;
    }

    /**
     * @return the cNF
     */
    public String getcNF() {
        return cNF;
    }

    /**
     * @param cNF the cNF to set
     */
    public void setcNF(String cNF) {
        this.cNF = cNF;
    }

    /**
     * @return the natOp
     */
    public String getNatOp() {
        return natOp;
    }

    /**
     * @param natOp the natOp to set
     */
    public void setNatOp(String natOp) {
        this.natOp = natOp;
    }

    /**
     * @return the indPag
     */
    public String getIndPag() {
        return indPag;
    }

    /**
     * @param indPag the indPag to set
     */
    public void setIndPag(String indPag) {
        this.indPag = indPag;
    }

    /**
     * @return the mod
     */
    public String getMod() {
        return mod;
    }

    /**
     * @param mod the mod to set
     */
    public void setMod(String mod) {
        this.mod = mod;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the nNF
     */
    public String getnNF() {
        return nNF;
    }

    /**
     * @param nNF the nNF to set
     */
    public void setnNF(String nNF) {
        this.nNF = nNF;
    }

    /**
     * @return the dEmi
     */
    public String getdEmi() {
        return dEmi;
    }

    /**
     * @param dEmi the dEmi to set
     */
    public void setdEmi(String dEmi) {
        this.dEmi = dEmi;
    }

    /**
     * @return the dSaiEnt
     */
    public String getdSaiEnt() {
        return dSaiEnt;
    }

    /**
     * @param dSaiEnt the dSaiEnt to set
     */
    public void setdSaiEnt(String dSaiEnt) {
        this.dSaiEnt = dSaiEnt;
    }

    /**
     * @return the tpNF
     */
    public String getTpNF() {
        return tpNF;
    }

    /**
     * @param tpNF the tpNF to set
     */
    public void setTpNF(String tpNF) {
        this.tpNF = tpNF;
    }

    /**
     * @return the cMunFG
     */
    public String getcMunFG() {
        return cMunFG;
    }

    /**
     * @param cMunFG the cMunFG to set
     */
    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    /**
     * @return the tpImp
     */
    public String getTpImp() {
        return tpImp;
    }

    /**
     * @param tpImp the tpImp to set
     */
    public void setTpImp(String tpImp) {
        this.tpImp = tpImp;
    }

    /**
     * @return the tpEmis
     */
    public String getTpEmis() {
        return tpEmis;
    }

    /**
     * @param tpEmis the tpEmis to set
     */
    public void setTpEmis(String tpEmis) {
        this.tpEmis = tpEmis;
    }

    /**
     * @return the cDV
     */
    public String getcDV() {
        return cDV;
    }

    /**
     * @param cDV the cDV to set
     */
    public void setcDV(String cDV) {
        this.cDV = cDV;
    }

    /**
     * @return the tpAmb
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * @param tpAmb the tpAmb to set
     */
    public void setTpAmb(String tpAmb) {
        this.tpAmb = tpAmb;
    }

    /**
     * @return the finNFe
     */
    public String getFinNFe() {
        return finNFe;
    }

    /**
     * @param finNFe the finNFe to set
     */
    public void setFinNFe(String finNFe) {
        this.finNFe = finNFe;
    }

    /**
     * @return the procEmi
     */
    public String getProcEmi() {
        return procEmi;
    }

    /**
     * @param procEmi the procEmi to set
     */
    public void setProcEmi(String procEmi) {
        this.procEmi = procEmi;
    }

    /**
     * @return the verProc
     */
    public String getVerProc() {
        return verProc;
    }

    /**
     * @param verProc the verProc to set
     */
    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    /**
     * @return the xNome
     */
    public String getxNome() {
        return xNome;
    }

    /**
     * @param xNome the xNome to set
     */
    public void setxNome(String xNome) {
        this.xNome = xNome;
    }

    /**
     * @return the xFant
     */
    public String getxFant() {
        return xFant;
    }

    /**
     * @param xFant the xFant to set
     */
    public void setxFant(String xFant) {
        this.xFant = xFant;
    }

    /**
     * @return the IE
     */
    public String getIE() {
        return IE;
    }

    /**
     * @param IE the IE to set
     */
    public void setIE(String IE) {
        this.IE = IE;
    }

    /**
     * @return the xLgr
     */
    public String getxLgr() {
        return xLgr;
    }

    /**
     * @param xLgr the xLgr to set
     */
    public void setxLgr(String xLgr) {
        this.xLgr = xLgr;
    }

    /**
     * @return the nro
     */
    public String getNro() {
        return nro;
    }

    /**
     * @param nro the nro to set
     */
    public void setNro(String nro) {
        this.nro = nro;
    }

    /**
     * @return the xBairro
     */
    public String getxBairro() {
        return xBairro;
    }

    /**
     * @param xBairro the xBairro to set
     */
    public void setxBairro(String xBairro) {
        this.xBairro = xBairro;
    }

    /**
     * @return the cMun
     */
    public String getcMun() {
        return cMun;
    }

    /**
     * @param cMun the cMun to set
     */
    public void setcMun(String cMun) {
        this.cMun = cMun;
    }

    /**
     * @return the xMun
     */
    public String getxMun() {
        return xMun;
    }

    /**
     * @param xMun the xMun to set
     */
    public void setxMun(String xMun) {
        this.xMun = xMun;
    }

    /**
     * @return the cPais
     */
    public String getcPais() {
        return cPais;
    }

    /**
     * @param cPais the cPais to set
     */
    public void setcPais(String cPais) {
        this.cPais = cPais;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the xPais
     */
    public String getxPais() {
        return xPais;
    }

    /**
     * @param xPais the xPais to set
     */
    public void setxPais(String xPais) {
        this.xPais = xPais;
    }

    /**
     * @return the cProd
     */
    public String getcProd() {
        return cProd;
    }

    /**
     * @param cProd the cProd to set
     */
    public void setcProd(String cProd) {
        this.cProd = cProd;
    }

    /**
     * @return the xProd
     */
    public String getxProd() {
        return xProd;
    }

    /**
     * @param xProd the xProd to set
     */
    public void setxProd(String xProd) {
        this.xProd = xProd;
    }

    /**
     * @return the CFOP
     */
    public String getCFOP() {
        return CFOP;
    }

    /**
     * @param CFOP the CFOP to set
     */
    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    /**
     * @return the cEAN
     */
    public String getcEAN() {
        return cEAN;
    }

    /**
     * @param cEAN the cEAN to set
     */
    public void setcEAN(String cEAN) {
        this.cEAN = cEAN;
    }

    /**
     * @return the uCom
     */
    public String getuCom() {
        return uCom;
    }

    /**
     * @param uCom the uCom to set
     */
    public void setuCom(String uCom) {
        this.uCom = uCom;
    }

    /**
     * @return the qCom
     */
    public String getqCom() {
        return qCom;
    }

    /**
     * @param qCom the qCom to set
     */
    public void setqCom(String qCom) {
        this.qCom = qCom;
    }

    /**
     * @return the vUnCom
     */
    public String getvUnCom() {
        return vUnCom;
    }

    /**
     * @param vUnCom the vUnCom to set
     */
    public void setvUnCom(String vUnCom) {
        this.vUnCom = vUnCom;
    }

    /**
     * @return the vProd
     */
    public String getvProd() {
        return vProd;
    }

    /**
     * @param vProd the vProd to set
     */
    public void setvProd(String vProd) {
        this.vProd = vProd;
    }

    /**
     * @return the cEANTrib
     */
    public String getcEANTrib() {
        return cEANTrib;
    }

    /**
     * @param cEANTrib the cEANTrib to set
     */
    public void setcEANTrib(String cEANTrib) {
        this.cEANTrib = cEANTrib;
    }

    /**
     * @return the uTrib
     */
    public String getuTrib() {
        return uTrib;
    }

    /**
     * @param uTrib the uTrib to set
     */
    public void setuTrib(String uTrib) {
        this.uTrib = uTrib;
    }

    /**
     * @return the qTrib
     */
    public String getqTrib() {
        return qTrib;
    }

    /**
     * @param qTrib the qTrib to set
     */
    public void setqTrib(String qTrib) {
        this.qTrib = qTrib;
    }

    /**
     * @return the vUnTrib
     */
    public String getvUnTrib() {
        return vUnTrib;
    }

    /**
     * @param vUnTrib the vUnTrib to set
     */
    public void setvUnTrib(String vUnTrib) {
        this.vUnTrib = vUnTrib;
    }

    /**
     * @return the orig
     */
    public String getOrig() {
        return orig;
    }

    /**
     * @param orig the orig to set
     */
    public void setOrig(String orig) {
        this.orig = orig;
    }

    /**
     * @return the CST
     */
    public String getCST() {
        return CST;
    }

    /**
     * @param CST the CST to set
     */
    public void setCST(String CST) {
        this.CST = CST;
    }

    /**
     * @return the modBC
     */
    public String getModBC() {
        return modBC;
    }

    /**
     * @param modBC the modBC to set
     */
    public void setModBC(String modBC) {
        this.modBC = modBC;
    }

    /**
     * @return the pRedBC
     */
    public String getpRedBC() {
        return pRedBC;
    }

    /**
     * @param pRedBC the pRedBC to set
     */
    public void setpRedBC(String pRedBC) {
        this.pRedBC = pRedBC;
    }

    /**
     * @return the pICMS
     */
    public String getpICMS() {
        return pICMS;
    }

    /**
     * @param pICMS the pICMS to set
     */
    public void setpICMS(String pICMS) {
        this.pICMS = pICMS;
    }

    /**
     * @return the pPIS
     */
    public String getpPIS() {
        return pPIS;
    }

    /**
     * @param pPIS the pPIS to set
     */
    public void setpPIS(String pPIS) {
        this.pPIS = pPIS;
    }

    /**
     * @return the pCOFINS
     */
    public String getpCOFINS() {
        return pCOFINS;
    }

    /**
     * @param pCOFINS the pCOFINS to set
     */
    public void setpCOFINS(String pCOFINS) {
        this.pCOFINS = pCOFINS;
    }

    /**
     * @return the infCpl
     */
    public String getInfCpl() {
        return infCpl;
    }

    /**
     * @param infCpl the infCpl to set
     */
    public void setInfCpl(String infCpl) {
        this.infCpl = infCpl;
    }

    /**
     * @return the infAdic
     */
    public String getInfAdic() {
        return infAdic;
    }

    /**
     * @param infAdic the infAdic to set
     */
    public void setInfAdic(String infAdic) {
        this.infAdic = infAdic;
    }

    /**
     * @return the modFrete
     */
    public String getModFrete() {
        return modFrete;
    }

    /**
     * @param modFrete the modFrete to set
     */
    public void setModFrete(String modFrete) {
        this.modFrete = modFrete;
    }

    /**
     * @return the xEnder
     */
    public String getxEnder() {
        return xEnder;
    }

    /**
     * @param xEnder the xEnder to set
     */
    public void setxEnder(String xEnder) {
        this.xEnder = xEnder;
    }

    /**
     * @return the qVol
     */
    public String getqVol() {
        return qVol;
    }

    /**
     * @param qVol the qVol to set
     */
    public void setqVol(String qVol) {
        this.qVol = qVol;
    }

    /**
     * @return the pesoL
     */
    public String getPesoL() {
        return pesoL;
    }

    /**
     * @param pesoL the pesoL to set
     */
    public void setPesoL(String pesoL) {
        this.pesoL = pesoL;
    }

    /**
     * @return the pesoB
     */
    public String getPesoB() {
        return pesoB;
    }

    /**
     * @param pesoB the pesoB to set
     */
    public void setPesoB(String pesoB) {
        this.pesoB = pesoB;
    }

    /**
     * @return the vBC
     */
    public String getvBC() {
        return vBC;
    }

    /**
     * @param vBC the vBC to set
     */
    public void setvBC(String vBC) {
        this.vBC = vBC;
    }

    /**
     * @return the vICMS
     */
    public String getvICMS() {
        return vICMS;
    }

    /**
     * @param vICMS the vICMS to set
     */
    public void setvICMS(String vICMS) {
        this.vICMS = vICMS;
    }

    /**
     * @return the vBCST
     */
    public String getvBCST() {
        return vBCST;
    }

    /**
     * @param vBCST the vBCST to set
     */
    public void setvBCST(String vBCST) {
        this.vBCST = vBCST;
    }

    /**
     * @return the vST
     */
    public String getvST() {
        return vST;
    }

    /**
     * @param vST the vST to set
     */
    public void setvST(String vST) {
        this.vST = vST;
    }

    /**
     * @return the vFrete
     */
    public String getvFrete() {
        return vFrete;
    }

    /**
     * @param vFrete the vFrete to set
     */
    public void setvFrete(String vFrete) {
        this.vFrete = vFrete;
    }

    /**
     * @return the vSeg
     */
    public String getvSeg() {
        return vSeg;
    }

    /**
     * @param vSeg the vSeg to set
     */
    public void setvSeg(String vSeg) {
        this.vSeg = vSeg;
    }

    /**
     * @return the vDesc
     */
    public String getvDesc() {
        return vDesc;
    }

    /**
     * @param vDesc the vDesc to set
     */
    public void setvDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    /**
     * @return the vIPI
     */
    public String getvIPI() {
        return vIPI;
    }

    /**
     * @param vIPI the vIPI to set
     */
    public void setvIPI(String vIPI) {
        this.vIPI = vIPI;
    }

    /**
     * @return the vPIS
     */
    public String getvPIS() {
        return vPIS;
    }

    /**
     * @param vPIS the vPIS to set
     */
    public void setvPIS(String vPIS) {
        this.vPIS = vPIS;
    }

    /**
     * @return the vCOFINS
     */
    public String getvCOFINS() {
        return vCOFINS;
    }

    /**
     * @param vCOFINS the vCOFINS to set
     */
    public void setvCOFINS(String vCOFINS) {
        this.vCOFINS = vCOFINS;
    }

    /**
     * @return the vOutro
     */
    public String getvOutro() {
        return vOutro;
    }

    /**
     * @param vOutro the vOutro to set
     */
    public void setvOutro(String vOutro) {
        this.vOutro = vOutro;
    }

    /**
     * @return the vNF
     */
    public String getvNF() {
        return vNF;
    }

    /**
     * @param vNF the vNF to set
     */
    public void setvNF(String vNF) {
        this.vNF = vNF;
    }

    /**
     * @return the verAplic
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * @param verAplic the verAplic to set
     */
    public void setVerAplic(String verAplic) {
        this.verAplic = verAplic;
    }

    /**
     * @return the chNFe
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * @param chNFe the chNFe to set
     */
    public void setChNFe(String chNFe) {
        this.chNFe = chNFe;
    }

    /**
     * @return the dhRecbto
     */
    public String getDhRecbto() {
        return dhRecbto;
    }

    /**
     * @param dhRecbto the dhRecbto to set
     */
    public void setDhRecbto(String dhRecbto) {
        this.dhRecbto = dhRecbto;
    }

    /**
     * @return the nProt
     */
    public String getnProt() {
        return nProt;
    }

    /**
     * @param nProt the nProt to set
     */
    public void setnProt(String nProt) {
        this.nProt = nProt;
    }

    /**
     * @return the digVal
     */
    public String getDigVal() {
        return digVal;
    }

    /**
     * @param digVal the digVal to set
     */
    public void setDigVal(String digVal) {
        this.digVal = digVal;
    }

    /**
     * @return the cStat
     */
    public String getcStat() {
        return cStat;
    }

    /**
     * @param cStat the cStat to set
     */
    public void setcStat(String cStat) {
        this.cStat = cStat;
    }

    /**
     * @return the xMotivo
     */
    public String getxMotivo() {
        return xMotivo;
    }

    /**
     * @param xMotivo the xMotivo to set
     */
    public void setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
    }

}
