package nf.DAO;

import nfe.model.ModelNF;
import conexoes.ConexaoMySql;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nfe.util.LerArqXML;
/**
*
* @author Nazareth
*/
public class DAONF extends ConexaoMySql {

    /**
    * grava NF
    * @param pModelNF
    * return int
    */
    
        public int salvarNFDAO(ModelNF pModelNF) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO nf ("
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                    + ") VALUES ("
                    + "'" + pModelNF.getEmpresa() + "',"
                    + "'" + pModelNF.getPedido() + "',"
                    + "'" + pModelNF.getCodCliente() + "',"
                    + "'" + pModelNF.getDocCliente() + "',"
                    + "'" + pModelNF.getNomeDocumento() + "',"
                    + "'" + pModelNF.getCodFormaPgto() + "',"
                    + "'" + pModelNF.getCodTipoDoc() + "',"
                    + "'" + pModelNF.getCodBanco() + "',"
                    + "'" + pModelNF.getDataDigitacao() + "',"
                    + "'" + pModelNF.getValorProdutos() + "',"
                    + "'" + pModelNF.getValorDescontos() + "',"
                    + "'" + pModelNF.getValorTotal() + "',"
                    + "'" + pModelNF.getCodTransportadora() + "',"
                    + "'" + pModelNF.getDadosAdicionais() + "',"
                    + "'" + pModelNF.getQtdeVolume() + "',"
                    + "'" + pModelNF.getPesoVolume() + "',"
                    + "'" + pModelNF.getPlacaVeiculo() + "',"
                    + "'" + pModelNF.getUfPlaca() + "',"
                    + "'" + pModelNF.getPedidoCliente() + "',"
                    + "'" + pModelNF.getModelonfe() + "',"
                    + "'" + pModelNF.getNumeroNfe() + "',"
                    + "'" + pModelNF.getSerieNfe() + "',"
                    + "'" + pModelNF.getDataEmissao() + "',"
                    + "'" + pModelNF.getChaveNfe() + "',"
                    + "'" + pModelNF.getIcmsBc() + "',"
                    + "'" + pModelNF.getIcmsVlr() + "',"
                    + "'" + pModelNF.getIpiBc() + "',"
                    + "'" + pModelNF.getIpiVlr() + "',"
                    + "'" + pModelNF.getPisBc() + "',"
                    + "'" + pModelNF.getPisVlr() + "',"
                    + "'" + pModelNF.getCofinsBc() + "',"
                    + "'" + pModelNF.getCofinsVlr() + "',"
                    + "'" + pModelNF.getVtottrib() + "',"
                    + "'" + pModelNF.getNumNfeFat() + "',"
                    + "'" + pModelNF.getFinNfe() + "',"
                    + "'" + pModelNF.getDataCancelamento() + "',"
                    + "'" + pModelNF.getNumNfeDev() + "',"
                    + "'" + pModelNF.getDataDevolucao() + "',"
                    + "'" + pModelNF.getQrcode() + "',"
                    + "'" + pModelNF.getTpemis() + "',"
                    + "'" + pModelNF.getTpamb() + "',"
                    + "'" + pModelNF.getPedidoInterno() + "',"
                    + "'" + pModelNF.getVtotibpt() + "',"
                    + "'" + pModelNF.getRefnfe() + "',"
                    + "'" + pModelNF.getStatusNfe() + "',"
                    + "'" + pModelNF.getMotivoNfe() + "'"
                    + ");"
            );
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                this.fecharConexao();
            } catch (Throwable ex) {
                Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   /* public int salvarNFDAO(ModelNF pModelNF){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO nf ("
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                + ") VALUES ("
                    + "'" + pModelNF.getEmpresa() + "',"
                    + "'" + pModelNF.getPedido() + "',"
                    + "'" + pModelNF.getCodCliente() + "',"
                    + "'" + pModelNF.getDocCliente() + "',"
                    + "'" + pModelNF.getNomeDocumento() + "',"
                    + "'" + pModelNF.getCodFormaPgto() + "',"
                    + "'" + pModelNF.getCodTipoDoc () + "',"
                    + "'" + pModelNF.getCodBanco() + "',"
                    + "'" + pModelNF.getDataDigitacao() + "',"
                    + "'" + pModelNF.getValorProdutos() + "',"
                    + "'" + pModelNF.getValorDescontos() + "',"
                    + "'" + pModelNF.getValorTotal() + "',"
                    + "'" + pModelNF.getCodTransportadora() + "',"
                    + "'" + pModelNF.getDadosAdicionais() + "',"
                    + "'" + pModelNF.getQtdeVolume () + "',"
                    + "'" + pModelNF.getPesoVolume() + "',"
                    + "'" + pModelNF.getPlacaVeiculo() + "',"
                    + "'" + pModelNF.getUfPlaca() + "',"
                    + "'" + pModelNF.getPedidoCliente() + "',"
                    + "'" + pModelNF.getModelonfe() + "',"
                    + "'" + pModelNF.getNumeroNfe() + "',"
                    + "'" + pModelNF.getSerieNfe() + "',"
                    + "'" + pModelNF.getDataEmissao() + "',"
                    + "'" + pModelNF.getChaveNfe() + "',"
                    + "'" + pModelNF.getIcmsBc() + "',"
                    + "'" + pModelNF.getIcmsVlr() + "',"
                    + "'" + pModelNF.getIpiBc() + "',"
                    + "'" + pModelNF.getIpiVlr() + "',"
                    + "'" + pModelNF.getPisBc() + "',"
                    + "'" + pModelNF.getPisVlr() + "',"
                    + "'" + pModelNF.getCofinsBc() + "',"
                    + "'" + pModelNF.getCofinsVlr() + "',"
                    + "'" + pModelNF.getVtottrib() + "',"
                    + "'" + pModelNF.getNumNfeFat() + "',"
                    + "'" + pModelNF.getFinNfe() + "',"
                    + "'" + pModelNF.getDataCancelamento() + "',"
                    + "'" + pModelNF.getNumNfeDev() + "',"
                    + "'" + pModelNF.getDataDevolucao() + "',"
                    + "'" + pModelNF.getQrcode() + "',"
                    + "'" + pModelNF.getTpemis() + "',"
                    + "'" + pModelNF.getTpamb() + "',"
                    + "'" + pModelNF.getPedidoInterno() + "',"
                    + "'" + pModelNF.getVtotibpt() + "',"
                    + "'" + pModelNF.getRefnfe() + "',"
                    + "'" + pModelNF.getStatusNfe() + "',"
                    + "'" + pModelNF.getMotivoNfe() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }*/
    
        /**
    * grava NF
    * @param pModelNF
    * return int
    */
    public int salvarNFCOMPRADAO(ModelNF pModelNF){
        try {
            this.conectar();
            this.insertSQL(
                "INSERT INTO nf_compra ("
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "bcsubst,"
                    + "vsubst,"
                    + "outros,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                + ") VALUES ("
                    + "'" + pModelNF.getEmpresa() + "',"
                    + "'" + pModelNF.getNumeroNfe() + "',"
                    + "'" + pModelNF.getCodCliente() + "',"
                    + "'" + pModelNF.getDocCliente() + "',"
                    + "'" + pModelNF.getNomeDocumento() + "',"
                    + "'" + pModelNF.getCodFormaPgto() + "',"
                    + "'" + pModelNF.getCodTipoDoc () + "',"
                    + "'" + pModelNF.getCodBanco() + "',"
                    + "'" + pModelNF.getDataDigitacao() + "',"
                    + "'" + pModelNF.getValorProdutos() + "',"
                    + "'" + pModelNF.getValorDescontos() + "',"
                    + "'" + pModelNF.getValorTotal() + "',"
                    + "'" + pModelNF.getCodTransportadora() + "',"
                    + "'" + pModelNF.getDadosAdicionais() + "',"
                    + "'" + pModelNF.getQtdeVolume () + "',"
                    + "'" + pModelNF.getPesoVolume() + "',"
                    + "'" + pModelNF.getPlacaVeiculo() + "',"
                    + "'" + pModelNF.getUfPlaca() + "',"
                    + "'" + pModelNF.getPedidoCliente() + "',"
                    + "'" + pModelNF.getModelonfe() + "',"
                    + "'" + pModelNF.getNumeroNfe() + "',"
                    + "'" + pModelNF.getSerieNfe() + "',"
                    + "'" + pModelNF.getDataEmissao() + "',"
                    + "'" + pModelNF.getChaveNfe() + "',"
                    + "'" + pModelNF.getIcmsBc() + "',"
                    + "'" + pModelNF.getIcmsVlr() + "',"
                    + "'" + pModelNF.getIpiBc() + "',"
                    + "'" + pModelNF.getIpiVlr() + "',"
                    + "'" + pModelNF.getPisBc() + "',"
                    + "'" + pModelNF.getPisVlr() + "',"
                    + "'" + pModelNF.getCofinsBc() + "',"
                    + "'" + pModelNF.getCofinsVlr() + "',"
                    + "'" + pModelNF.getVtottrib() + "',"
                    + "'" + pModelNF.getBCSubst() + "',"
                    + "'" + pModelNF.getICMSSubst() + "',"
                    + "'" + pModelNF.getOutros() + "',"
                    + "'" + pModelNF.getNumNfeFat() + "',"
                    + "'" + pModelNF.getFinNfe() + "',"
                    + "'" + pModelNF.getDataCancelamento() + "',"
                    + "'" + pModelNF.getNumNfeDev() + "',"
                    + "'" + pModelNF.getDataDevolucao() + "',"
                    + "'" + pModelNF.getQrcode() + "',"
                    + "'" + pModelNF.getTpemis() + "',"
                    + "'" + pModelNF.getTpamb() + "',"
                    + "'" + pModelNF.getPedidoInterno() + "',"
                    + "'" + pModelNF.getVtotibpt() + "',"
                    + "'" + pModelNF.getRefnfe() + "',"
                    + "'" + pModelNF.getStatusNfe() + "',"
                    + "'" + pModelNF.getMotivoNfe() + "'"
                + ");"
            );
            
            return 0;
        }
        catch(Exception e){
            e.printStackTrace();
            return 1;
        }
        finally{
        this.fecharConexao();
        }
        
     }

    /**
    * recupera NF
    * @param pEmpresa
    * return ModelNF
    */
    public ModelNF getNFDAO(int pEmpresa){
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf"
                 + " WHERE"
                     + " empresa = '" + pEmpresa + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setNumNfeFat(this.getResultSet().getString(34));
                modelNF.setFinNfe(this.getResultSet().getString(35));
                modelNF.setDataCancelamento(this.getResultSet().getDate(36));
                modelNF.setNumNfeDev(this.getResultSet().getString(37));
                modelNF.setDataDevolucao(this.getResultSet().getDate(38));
                modelNF.setQrcode(this.getResultSet().getString(39));
                modelNF.setTpemis(this.getResultSet().getString(40));
                modelNF.setTpamb(this.getResultSet().getString(41));
                modelNF.setPedidoInterno(this.getResultSet().getString(42));
                modelNF.setVtotibpt(this.getResultSet().getDouble(43));
                modelNF.setRefnfe(this.getResultSet().getString(44));
                modelNF.setStatusNfe(this.getResultSet().getString(45));
                modelNF.setMotivoNfe(this.getResultSet().getString(46));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelNF;
    }
    
    /**
    * recupera NF
    * @param pVenda
    * return ModelNF
    */
    public ModelNF getNFVendaDAO(int pVenda){
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "bcsubst,"
                    + "vsubst,"
                    + "outros,"        
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf"
                 + " WHERE"
                     + " pedido = '" + pVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setBCSubst(this.getResultSet().getString(34));
                modelNF.setICMSSubst(this.getResultSet().getString(35));
                modelNF.setOutros(this.getResultSet().getString(36));
                modelNF.setNumNfeFat(this.getResultSet().getString(37));
                modelNF.setFinNfe(this.getResultSet().getString(38));
                modelNF.setDataCancelamento(this.getResultSet().getDate(39));
                modelNF.setNumNfeDev(this.getResultSet().getString(40));
                modelNF.setDataDevolucao(this.getResultSet().getDate(41));
                modelNF.setQrcode(this.getResultSet().getString(42));
                modelNF.setTpemis(this.getResultSet().getString(43));
                modelNF.setTpamb(this.getResultSet().getString(44));
                modelNF.setPedidoInterno(this.getResultSet().getString(45));
                modelNF.setVtotibpt(this.getResultSet().getDouble(46));
                modelNF.setRefnfe(this.getResultSet().getString(47));
                modelNF.setStatusNfe(this.getResultSet().getString(48));
                modelNF.setMotivoNfe(this.getResultSet().getString(49));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelNF;
    }
    
    /**
    * recupera NF
    * @param pVenda
    * return ModelNF
    */
    public ModelNF getNFCompraCodigoDAO(int pVenda){
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "bcsubst,"
                    + "vsubst,"
                    + "outros,"        
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf_compra"
                 + " WHERE"
                     + " pedido = '" + pVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setBCSubst(this.getResultSet().getString(34));
                modelNF.setICMSSubst(this.getResultSet().getString(35));
                modelNF.setOutros(this.getResultSet().getString(36));
                modelNF.setNumNfeFat(this.getResultSet().getString(37));
                modelNF.setFinNfe(this.getResultSet().getString(38));
                modelNF.setDataCancelamento(this.getResultSet().getDate(39));
                modelNF.setNumNfeDev(this.getResultSet().getString(40));
                modelNF.setDataDevolucao(this.getResultSet().getDate(41));
                modelNF.setQrcode(this.getResultSet().getString(42));
                modelNF.setTpemis(this.getResultSet().getString(43));
                modelNF.setTpamb(this.getResultSet().getString(44));
                modelNF.setPedidoInterno(this.getResultSet().getString(45));
                modelNF.setVtotibpt(this.getResultSet().getDouble(46));
                modelNF.setRefnfe(this.getResultSet().getString(47));
                modelNF.setStatusNfe(this.getResultSet().getString(48));
                modelNF.setMotivoNfe(this.getResultSet().getString(49));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelNF;
    }
    
    
        /**
    * recupera NF
    * @param pEmpresa
    * return ModelNF
    */
    public ModelNF getNFCOMPRADAO(int pEmpresa){
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "bcsubst,"
                    + "vsubst,"
                    + "outros,"    
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf_compra"
                 + " WHERE"
                     + " empresa = '" + pEmpresa + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setBCSubst(this.getResultSet().getString(34));
                modelNF.setICMSSubst(this.getResultSet().getString(35));
                modelNF.setOutros(this.getResultSet().getString(36));
                modelNF.setNumNfeFat(this.getResultSet().getString(37));
                modelNF.setFinNfe(this.getResultSet().getString(38));
                modelNF.setDataCancelamento(this.getResultSet().getDate(39));
                modelNF.setNumNfeDev(this.getResultSet().getString(40));
                modelNF.setDataDevolucao(this.getResultSet().getDate(41));
                modelNF.setQrcode(this.getResultSet().getString(42));
                modelNF.setTpemis(this.getResultSet().getString(43));
                modelNF.setTpamb(this.getResultSet().getString(44));
                modelNF.setPedidoInterno(this.getResultSet().getString(45));
                modelNF.setVtotibpt(this.getResultSet().getDouble(46));
                modelNF.setRefnfe(this.getResultSet().getString(47));
                modelNF.setStatusNfe(this.getResultSet().getString(48));
                modelNF.setMotivoNfe(this.getResultSet().getString(49));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelNF;
    }


    /**
    * recupera uma lista de NF
        * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFDAO(){
        ArrayList<ModelNF> listamodelNF = new ArrayList();
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF = new ModelNF();
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setNumNfeFat(this.getResultSet().getString(34));
                modelNF.setFinNfe(this.getResultSet().getString(35));
                modelNF.setDataCancelamento(this.getResultSet().getDate(36));
                modelNF.setNumNfeDev(this.getResultSet().getString(37));
                modelNF.setDataDevolucao(this.getResultSet().getDate(38));
                modelNF.setQrcode(this.getResultSet().getString(39));
                modelNF.setTpemis(this.getResultSet().getString(40));
                modelNF.setTpamb(this.getResultSet().getString(41));
                modelNF.setPedidoInterno(this.getResultSet().getString(42));
                modelNF.setVtotibpt(this.getResultSet().getDouble(43));
                modelNF.setRefnfe(this.getResultSet().getString(44));
                modelNF.setStatusNfe(this.getResultSet().getString(45));
                modelNF.setMotivoNfe(this.getResultSet().getString(46));
                listamodelNF.add(modelNF);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelNF;
    }

    
    
    /**
    * recupera uma lista de NF
        * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFModeloDAO(String pModelo){
        ArrayList<ModelNF> listamodelNF = new ArrayList();
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                    + " FROM"
                     + " nf "
                     + " WHERE "
                     + " modelonfe = '" + pModelo + "'"
                        
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF = new ModelNF();
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setNumNfeFat(this.getResultSet().getString(34));
                modelNF.setFinNfe(this.getResultSet().getString(35));
                modelNF.setDataCancelamento(this.getResultSet().getDate(36));
                modelNF.setNumNfeDev(this.getResultSet().getString(37));
                modelNF.setDataDevolucao(this.getResultSet().getDate(38));
                modelNF.setQrcode(this.getResultSet().getString(39));
                modelNF.setTpemis(this.getResultSet().getString(40));
                modelNF.setTpamb(this.getResultSet().getString(41));
                modelNF.setPedidoInterno(this.getResultSet().getString(42));
                modelNF.setVtotibpt(this.getResultSet().getDouble(43));
                modelNF.setRefnfe(this.getResultSet().getString(44));
                modelNF.setStatusNfe(this.getResultSet().getString(45));
                modelNF.setMotivoNfe(this.getResultSet().getString(46));
                listamodelNF.add(modelNF);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelNF;
    }

    
    
    
    /**
    * recupera uma lista de NF
        * return ArrayList
     * @param pDataInicial
     * @param dataFinal
     * @param modelo
     * @return 
    */
    public ArrayList<ModelNF> getListaPorDataNFDAO(Date pDataInicial, Date dataFinal, String modelo){
        ArrayList<ModelNF> listamodelNF = new ArrayList();
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                    + " FROM"
                    + " nf"
                    + " WHERE "
                    + " status_nfe = '" + "100"
                    + " ' AND "    
                    + "(data_emissao BETWEEN  '" + pDataInicial + "' AND '" + dataFinal 
                    + "' AND "+ " modelonfe = '" + modelo +"')" 
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF = new ModelNF();
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setNumNfeFat(this.getResultSet().getString(34));
                modelNF.setFinNfe(this.getResultSet().getString(35));
                modelNF.setDataCancelamento(this.getResultSet().getDate(36));
                modelNF.setNumNfeDev(this.getResultSet().getString(37));
                modelNF.setDataDevolucao(this.getResultSet().getDate(38));
                modelNF.setQrcode(this.getResultSet().getString(39));
                modelNF.setTpemis(this.getResultSet().getString(40));
                modelNF.setTpamb(this.getResultSet().getString(41));
                modelNF.setPedidoInterno(this.getResultSet().getString(42));
                modelNF.setVtotibpt(this.getResultSet().getDouble(43));
                modelNF.setRefnfe(this.getResultSet().getString(44));
                modelNF.setStatusNfe(this.getResultSet().getString(45));
                modelNF.setMotivoNfe(this.getResultSet().getString(46));
                listamodelNF.add(modelNF);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelNF;
    }

    /**
    * recupera uma lista de NF
        * return ArrayList
     * @param pDataInicial
     * @param dataFinal
     * @param modelo
    */
    public ArrayList<ModelNF> getListaPorDataNFCompraDAO(Date pDataInicial, Date dataFinal, String modelo){
        ArrayList<ModelNF> listamodelNF = new ArrayList();
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "bcsubst,"
                    + "vsubst,"
                    + "outros,"        
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf_compra "
                        + "WHERE "
                    + "(data_emissao BETWEEN  '" + pDataInicial + "' AND '" + dataFinal 
                            + "' AND "+ " modelonfe = '" + modelo +"')" 
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF = new ModelNF();
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setBCSubst(this.getResultSet().getString(34));
                modelNF.setICMSSubst(this.getResultSet().getString(35));
                modelNF.setOutros(this.getResultSet().getString(36));
                modelNF.setNumNfeFat(this.getResultSet().getString(37));
                modelNF.setFinNfe(this.getResultSet().getString(38));
                modelNF.setDataCancelamento(this.getResultSet().getDate(39));
                modelNF.setNumNfeDev(this.getResultSet().getString(40));
                modelNF.setDataDevolucao(this.getResultSet().getDate(41));
                modelNF.setQrcode(this.getResultSet().getString(42));
                modelNF.setTpemis(this.getResultSet().getString(43));
                modelNF.setTpamb(this.getResultSet().getString(44));
                modelNF.setPedidoInterno(this.getResultSet().getString(45));
                modelNF.setVtotibpt(this.getResultSet().getDouble(46));
                modelNF.setRefnfe(this.getResultSet().getString(47));
                modelNF.setStatusNfe(this.getResultSet().getString(48));
                modelNF.setMotivoNfe(this.getResultSet().getString(49));
                listamodelNF.add(modelNF);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelNF;
    }
    
    /**
    * recupera uma lista de NF
        * return ArrayList
    */
    public ArrayList<ModelNF> getListaNFCOMPRADAO(){
        ArrayList<ModelNF> listamodelNF = new ArrayList();
        ModelNF modelNF = new ModelNF();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "pedido,"
                    + "cod_cliente,"
                    + "doc_cliente,"
                    + "nome_documento,"
                    + "cod_forma_pgto,"
                    + "cod_tipo_doc,"
                    + "cod_banco,"
                    + "data_digitacao,"
                    + "valor_produtos,"
                    + "valor_descontos,"
                    + "valor_total,"
                    + "cod_transportador,"
                    + "dados_adicionais,"
                    + "qtde_volume,"
                    + "peso_volume,"
                    + "placa_veiculo,"
                    + "uf_placa,"
                    + "pedido_cliente,"
                    + "modelonfe,"
                    + "numero_nfe,"
                    + "serie_nfe,"
                    + "data_emissao,"
                    + "chave_nfe,"
                    + "icms_bc,"
                    + "icms_vlr,"
                    + "ipi_bc,"
                    + "ipi_vlr,"
                    + "pis_bc,"
                    + "pis_vlr,"
                    + "cofins_bc,"
                    + "cofins_vlr,"
                    + "vtottrib,"
                    + "bcsubst,"
                    + "vsubst,"
                    + "outros,"        
                    + "num_nfe_fat,"
                    + "fin_nfe,"
                    + "data_cancelamento,"
                    + "num_nfe_dev,"
                    + "data_devolucao,"
                    + "qrcode,"
                    + "tpemis,"
                    + "tpamb,"
                    + "pedido_interno,"
                    + "vtotibpt,"
                    + "refnfe,"
                    + "status_nfe,"
                    + "motivo_nfe"
                 + " FROM"
                     + " nf_compra"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNF = new ModelNF();
                modelNF.setEmpresa(this.getResultSet().getInt(1));
                modelNF.setPedido(this.getResultSet().getInt(2));
                modelNF.setCodCliente(this.getResultSet().getInt(3));
                modelNF.setDocCliente(this.getResultSet().getString(4));
                modelNF.setNomeDocumento(this.getResultSet().getString(5));
                modelNF.setCodFormaPgto(this.getResultSet().getInt(6));
                modelNF.setCodTipoDoc (this.getResultSet().getString(7));
                modelNF.setCodBanco(this.getResultSet().getInt(8));
                modelNF.setDataDigitacao(this.getResultSet().getDate(9));
                modelNF.setValorProdutos(this.getResultSet().getDouble(10));
                modelNF.setValorDescontos(this.getResultSet().getDouble(11));
                modelNF.setValorTotal(this.getResultSet().getDouble(12));
                modelNF.setCodTransportadora(this.getResultSet().getInt(13));
                modelNF.setDadosAdicionais(this.getResultSet().getString(14));
                modelNF.setQtdeVolume (this.getResultSet().getInt(15));
                modelNF.setPesoVolume(this.getResultSet().getDouble(16));
                modelNF.setPlacaVeiculo(this.getResultSet().getString(17));
                modelNF.setUfPlaca(this.getResultSet().getString(18));
                modelNF.setPedidoCliente(this.getResultSet().getString(19));
                modelNF.setModelonfe(this.getResultSet().getString(20));
                modelNF.setNumeroNfe(this.getResultSet().getString(21));
                modelNF.setSerieNfe(this.getResultSet().getString(22));
                modelNF.setDataEmissao(this.getResultSet().getDate(23));
                modelNF.setChaveNfe(this.getResultSet().getString(24));
                modelNF.setIcmsBc(this.getResultSet().getDouble(25));
                modelNF.setIcmsVlr(this.getResultSet().getDouble(26));
                modelNF.setIpiBc(this.getResultSet().getDouble(27));
                modelNF.setIpiVlr(this.getResultSet().getDouble(28));
                modelNF.setPisBc(this.getResultSet().getDouble(29));
                modelNF.setPisVlr(this.getResultSet().getDouble(30));
                modelNF.setCofinsBc(this.getResultSet().getDouble(31));
                modelNF.setCofinsVlr(this.getResultSet().getDouble(32));
                modelNF.setVtottrib(this.getResultSet().getDouble(33));
                modelNF.setBCSubst(this.getResultSet().getString(34));
                modelNF.setICMSSubst(this.getResultSet().getString(35));
                modelNF.setOutros(this.getResultSet().getString(36));
                modelNF.setNumNfeFat(this.getResultSet().getString(37));
                modelNF.setFinNfe(this.getResultSet().getString(38));
                modelNF.setDataCancelamento(this.getResultSet().getDate(39));
                modelNF.setNumNfeDev(this.getResultSet().getString(40));
                modelNF.setDataDevolucao(this.getResultSet().getDate(41));
                modelNF.setQrcode(this.getResultSet().getString(42));
                modelNF.setTpemis(this.getResultSet().getString(43));
                modelNF.setTpamb(this.getResultSet().getString(44));
                modelNF.setPedidoInterno(this.getResultSet().getString(45));
                modelNF.setVtotibpt(this.getResultSet().getDouble(46));
                modelNF.setRefnfe(this.getResultSet().getString(47));
                modelNF.setStatusNfe(this.getResultSet().getString(48));
                modelNF.setMotivoNfe(this.getResultSet().getString(49));
                listamodelNF.add(modelNF);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelNF;
    }

    
    
    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFCOMPRADAO(ModelNF pModelNF){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE nf_compra SET "
                    + "empresa = '" + pModelNF.getEmpresa() + "',"
                    + "pedido = '" + pModelNF.getPedido() + "',"
                    + "cod_cliente = '" + pModelNF.getCodCliente() + "',"
                    + "doc_cliente = '" + pModelNF.getDocCliente() + "',"
                    + "nome_documento = '" + pModelNF.getNomeDocumento() + "',"
                    + "cod_forma_pgto = '" + pModelNF.getCodFormaPgto() + "',"
                    + "cod_tipo_doc = '" + pModelNF.getCodTipoDoc () + "',"
                    + "cod_banco = '" + pModelNF.getCodBanco() + "',"
                    + "data_digitacao = '" + pModelNF.getDataDigitacao() + "',"
                    + "valor_produtos = '" + pModelNF.getValorProdutos() + "',"
                    + "valor_descontos = '" + pModelNF.getValorDescontos() + "',"
                    + "valor_total = '" + pModelNF.getValorTotal() + "',"
                    + "dados_adicionais = '" + pModelNF.getDadosAdicionais() + "',"
                    + "qtde_volume = '" + pModelNF.getQtdeVolume () + "',"
                    + "peso_volume = '" + pModelNF.getPesoVolume() + "',"
                    + "placa_veiculo = '" + pModelNF.getPlacaVeiculo() + "',"
                    + "uf_placa = '" + pModelNF.getUfPlaca() + "',"
                    + "pedido_cliente = '" + pModelNF.getPedidoCliente() + "',"
                    + "modelonfe = '" + pModelNF.getModelonfe() + "',"
                    + "numero_nfe = '" + pModelNF.getNumeroNfe() + "',"
                    + "serie_nfe = '" + pModelNF.getSerieNfe() + "',"
                    + "data_emissao = '" + pModelNF.getDataEmissao() + "',"
                    + "chave_nfe = '" + pModelNF.getChaveNfe() + "',"
                    + "icms_bc = '" + pModelNF.getIcmsBc() + "',"
                    + "icms_vlr = '" + pModelNF.getIcmsVlr() + "',"
                    + "ipi_bc = '" + pModelNF.getIpiBc() + "',"
                    + "ipi_vlr = '" + pModelNF.getIpiVlr() + "',"
                    + "pis_bc = '" + pModelNF.getPisBc() + "',"
                    + "pis_vlr = '" + pModelNF.getPisVlr() + "',"
                    + "cofins_bc = '" + pModelNF.getCofinsBc() + "',"
                    + "cofins_vlr = '" + pModelNF.getCofinsVlr() + "',"
                    + "vtottrib = '" + pModelNF.getVtottrib() + "',"
                    + "bcsubst = '" + pModelNF.getBCSubst() + "',"
                    + "vsubst = '" + pModelNF.getICMSSubst() + "',"
                    + "outros = '" + pModelNF.getOutros() + "',"
                    + "num_nfe_fat = '" + pModelNF.getNumNfeFat() + "',"
                    + "fin_nfe = '" + pModelNF.getFinNfe() + "',"
                    + "data_cancelamento = '" + pModelNF.getDataCancelamento() + "',"
                    + "num_nfe_dev = '" + pModelNF.getNumNfeDev() + "',"
                    + "data_devolucao = '" + pModelNF.getDataDevolucao() + "',"
                    + "qrcode = '" + pModelNF.getQrcode() + "',"
                    + "tpemis = '" + pModelNF.getTpemis() + "',"
                    + "tpamb = '" + pModelNF.getTpamb() + "',"
                    + "pedido_interno = '" + pModelNF.getPedidoInterno() + "',"
                    + "vtotibpt = '" + pModelNF.getVtotibpt() + "',"
                    + "refnfe = '" + pModelNF.getRefnfe() + "',"
                    + "status_nfe = '" + pModelNF.getStatusNfe() + "',"
                    + "motivo_nfe = '" + pModelNF.getMotivoNfe() + "'"
                + " WHERE "
                    + "empresa = '" + pModelNF.getEmpresa() + "'"
                            +" AND "
                    + "pedido = '" + pModelNF.getPedido() + "'"        
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    
    
    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFDAO(ModelNF pModelNF){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE nf SET "
                    + "empresa = '" + pModelNF.getEmpresa() + "',"
                    + "pedido = '" + pModelNF.getPedido() + "',"
                    + "cod_cliente = '" + pModelNF.getCodCliente() + "',"
                    + "doc_cliente = '" + pModelNF.getDocCliente() + "',"
                    + "nome_documento = '" + pModelNF.getNomeDocumento() + "',"
                    + "cod_forma_pgto = '" + pModelNF.getCodFormaPgto() + "',"
                    + "cod_tipo_doc = '" + pModelNF.getCodTipoDoc () + "',"
                    + "cod_banco = '" + pModelNF.getCodBanco() + "',"
                    + "data_digitacao = '" + pModelNF.getDataDigitacao() + "',"
                    + "valor_produtos = '" + pModelNF.getValorProdutos() + "',"
                    + "valor_descontos = '" + pModelNF.getValorDescontos() + "',"
                    + "valor_total = '" + pModelNF.getValorTotal() + "',"
                    + "cod_transportadora = '" + pModelNF.getCodTransportadora() + "',"
                    + "dados_adicionais = '" + pModelNF.getDadosAdicionais() + "',"
                    + "qtde_volume = '" + pModelNF.getQtdeVolume () + "',"
                    + "peso_volume = '" + pModelNF.getPesoVolume() + "',"
                    + "placa_veiculo = '" + pModelNF.getPlacaVeiculo() + "',"
                    + "uf_placa = '" + pModelNF.getUfPlaca() + "',"
                    + "pedido_cliente = '" + pModelNF.getPedidoCliente() + "',"
                    + "modelonfe = '" + pModelNF.getModelonfe() + "',"
                    + "numero_nfe = '" + pModelNF.getNumeroNfe() + "',"
                    + "serie_nfe = '" + pModelNF.getSerieNfe() + "',"
                    + "data_emissao = '" + pModelNF.getDataEmissao() + "',"
                    + "chave_nfe = '" + pModelNF.getChaveNfe() + "',"
                    + "icms_bc = '" + pModelNF.getIcmsBc() + "',"
                    + "icms_vlr = '" + pModelNF.getIcmsVlr() + "',"
                    + "ipi_bc = '" + pModelNF.getIpiBc() + "',"
                    + "ipi_vlr = '" + pModelNF.getIpiVlr() + "',"
                    + "pis_bc = '" + pModelNF.getPisBc() + "',"
                    + "pis_vlr = '" + pModelNF.getPisVlr() + "',"
                    + "cofins_bc = '" + pModelNF.getCofinsBc() + "',"
                    + "cofins_vlr = '" + pModelNF.getCofinsVlr() + "',"
                    + "vtottrib = '" + pModelNF.getVtottrib() + "',"
                    + "num_nfe_fat = '" + pModelNF.getNumNfeFat() + "',"
                    + "fin_nfe = '" + pModelNF.getFinNfe() + "',"
                    + "data_cancelamento = '" + pModelNF.getDataCancelamento() + "',"
                    + "num_nfe_dev = '" + pModelNF.getNumNfeDev() + "',"
                    + "data_devolucao = '" + pModelNF.getDataDevolucao() + "',"
                    + "qrcode = '" + pModelNF.getQrcode() + "',"
                    + "tpemis = '" + pModelNF.getTpemis() + "',"
                    + "tpamb = '" + pModelNF.getTpamb() + "',"
                    + "pedido_interno = '" + pModelNF.getPedidoInterno() + "',"
                    + "vtotibpt = '" + pModelNF.getVtotibpt() + "',"
                    + "refnfe = '" + pModelNF.getRefnfe() + "',"
                    + "status_nfe = '" + pModelNF.getStatusNfe() + "',"
                    + "motivo_nfe = '" + pModelNF.getMotivoNfe() + "'"
                + " WHERE "
                    + "empresa = '" + pModelNF.getEmpresa() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    /**
    * atualiza NF
    * @param pModelNF
    * return boolean
    */
    public boolean atualizarNFCanceladaDAO(String cancelada, String codigoCancelada, int codigoCancelamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE nf SET "
                    + "status_nfe = '" + codigoCancelamento + "',"
                    + "motivo_nfe = '" + cancelada + "'"
                    + " WHERE "
                    + "pedido = '" + codigoCancelada + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    /**
    * exclui NF
    * @param pEmpresa
    * return boolean
    */
    public boolean excluirNFDAO(int pEmpresa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM nf "
                + " WHERE "
                    + "empresa = '" + pEmpresa + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    
    /**
    * exclui NF
    * @param pEmpresa
    * return boolean
    */
    public boolean excluirNFCOMPRADAO(int pEmpresa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM nf_compra "
                + " WHERE "
                    + "empresa = '" + pEmpresa + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}