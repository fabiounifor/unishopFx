package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelConfiguracao;

/**
 *
 * @author Leandro
 */
public class DAOConfiguracao extends ConexaoMySql {

/**
    * grava Configuracao
    * @param pModelConfiguracao 
    * return int
    */
    public int salvarConfiguracaoDAO(ModelConfiguracao pModelConfiguracao){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO configuracao ("
                    + "codigo,"
                    + "modelo_impressao,"
                    + "modelo_cupom_mesa,"
                    + "quantidade_impressao,"
                    + "visualizar_nfce,"
                    + "metodo_envio_nfce,"
                    + "metodo_envio_nfe,"
                    + "metodo_envio_nfse,"
                    + "classificacao_fiscal,"
                    + "impressora_pdv,"
                    + "impressora_cozinha,"
                    + "impressora_delivery,"
                    + "numero_mesas"
                + ") VALUES ("
                    + "'" + pModelConfiguracao.getCodigo() + "',"
                    + "'" + pModelConfiguracao.getModeloImpresssao()+ "',"
                    + "'" + pModelConfiguracao.getModeloCupomMesa()+ "',"
                    + "'" + pModelConfiguracao.getQuantidadeImpressao()+ "',"
                    + "'" + pModelConfiguracao.getVisualizarNfce()+ "',"
                    + "'" + pModelConfiguracao.getMetodoEnvioNfce()+ "',"
                    + "'" + pModelConfiguracao.getMetodoEnvioNfe()+ "',"
                    + "'" + pModelConfiguracao.getMetodoEnvioNfse()+ "',"
                    + "'" + pModelConfiguracao.getClassificacaoFiscal()+ "',"
                    + "'" + pModelConfiguracao.getImpressoraPdv()+ "',"
                    + "'" + pModelConfiguracao.getImpressoraCozinha()+ "',"
                    + "'" + pModelConfiguracao.getImpressoraDelivery()+ "',"
                    + "'" + pModelConfiguracao.getNumeroMesas()+ "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Configuracao
    * @param pCodigo
    * @return ModelConfiguracao
    */
    public ModelConfiguracao getConfiguracaoDAO(int pCodigo){
        ModelConfiguracao modelConfiguracao = new ModelConfiguracao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "modelo_impressao,"
                    + "modelo_cupom_mesa,"
                    + "quantidade_impressao,"
                    + "visualizar_nfce,"
                    + "metodo_envio_nfce,"
                    + "metodo_envio_nfe,"
                    + "metodo_envio_nfse,"
                    + "classificacao_fiscal,"
                    + "impressora_pdv,"
                    + "impressora_cozinha,"
                    + "impressora_delivery,"
                    + "numero_mesas"
                 + " FROM"
                     + " configuracao"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConfiguracao.setCodigo(this.getResultSet().getInt(1));
                modelConfiguracao.setModeloImpresssao(this.getResultSet().getInt(2));
                modelConfiguracao.setModeloCupomMesa(this.getResultSet().getInt(3));
                modelConfiguracao.setQuantidadeImpressao(this.getResultSet().getInt(4));
                modelConfiguracao.setVisualizarNfce(this.getResultSet().getInt(5));
                modelConfiguracao.setMetodoEnvioNfce(this.getResultSet().getInt(6));
                modelConfiguracao.setMetodoEnvioNfe(this.getResultSet().getInt(7));
                modelConfiguracao.setMetodoEnvioNfse(this.getResultSet().getInt(8));
                modelConfiguracao.setClassificacaoFiscal(this.getResultSet().getInt(9));
                modelConfiguracao.setImpressoraPdv(this.getResultSet().getString(10));
                modelConfiguracao.setImpressoraCozinha(this.getResultSet().getString(11));
                modelConfiguracao.setImpressoraDelivery(this.getResultSet().getString(12));
                modelConfiguracao.setNumeroMesas(this.getResultSet().getInt(13));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelConfiguracao;
    }
    /**
    * recupera uma lista de Configuracao
        * return ArrayList
    */
    public ArrayList<ModelConfiguracao> getListaConfiguracaoDAO(){
        ArrayList<ModelConfiguracao> listamodelConfiguracao = new ArrayList();
        ModelConfiguracao modelConfiguracao = new ModelConfiguracao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "modelo_impressao,"
                    + "modelo_cupom_mesa,"
                    + "quantidade_impressao,"
                    + "visualizar_nfce,"
                    + "metodo_envio_nfce,"
                    + "metodo_envio_nfe,"
                    + "metodo_envio_nfse,"
                    + "classificacao_fiscal,"
                    + "impressora_pdv,"
                    + "impressora_cozinha,"
                    + "impressora_delivery,"
                    + "numero_mesas"
                    + " FROM"
                     + " configuracao"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConfiguracao = new ModelConfiguracao();
                modelConfiguracao.setCodigo(this.getResultSet().getInt(1));
                modelConfiguracao.setModeloImpresssao(this.getResultSet().getInt(2));
                modelConfiguracao.setModeloCupomMesa(this.getResultSet().getInt(3));
                modelConfiguracao.setQuantidadeImpressao(this.getResultSet().getInt(4));
                modelConfiguracao.setVisualizarNfce(this.getResultSet().getInt(5));
                modelConfiguracao.setMetodoEnvioNfce(this.getResultSet().getInt(6));
                modelConfiguracao.setMetodoEnvioNfe(this.getResultSet().getInt(7));
                modelConfiguracao.setMetodoEnvioNfse(this.getResultSet().getInt(8));
                modelConfiguracao.setClassificacaoFiscal(this.getResultSet().getInt(9));
                modelConfiguracao.setImpressoraPdv(this.getResultSet().getString(10));
                modelConfiguracao.setImpressoraCozinha(this.getResultSet().getString(11));
                modelConfiguracao.setImpressoraDelivery(this.getResultSet().getString(12));
                modelConfiguracao.setNumeroMesas(this.getResultSet().getInt(13));
                listamodelConfiguracao.add(modelConfiguracao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelConfiguracao;
    }

    /**
    * atualiza Configuracao
    * @param pNumero 
    * return boolean
    */
    public boolean atualizarConfiguracaoDAO(ModelConfiguracao pModelConfiguracao){
        try {
            this.conectar();
            String sql = 
                "UPDATE configuracao SET "
                    + "modelo_impressao = '" + (pModelConfiguracao.getModeloImpresssao())+ "',"
                    + "modelo_cupom_mesa = '" + (pModelConfiguracao.getModeloCupomMesa())+ "',"
                    + "quantidade_impressao = '" + (pModelConfiguracao.getQuantidadeImpressao())+ "',"
                    + "visualizar_nfce = '" + (pModelConfiguracao.getVisualizarNfce())+ "',"
                    + "metodo_envio_nfce = '" + (pModelConfiguracao.getMetodoEnvioNfce())+ "'"
                    + "metodo_envio_nfe = '" + (pModelConfiguracao.getMetodoEnvioNfe())+ "'"
                    + "metodo_envio_nfse = '" + (pModelConfiguracao.getMetodoEnvioNfse())+ "'"
                    + "classificacao_fiscal = '" + (pModelConfiguracao.getClassificacaoFiscal())+ "'"
                    + "impressora_pdv = '" + (pModelConfiguracao.getImpressoraPdv())+ "'"
                    + "impressora_cozinha = '" + (pModelConfiguracao.getImpressoraCozinha())+ "'"
                    + "impressora_delivery = '" + (pModelConfiguracao.getImpressoraDelivery())+ "'"
                    + "numero_mesas = '" + (pModelConfiguracao.getNumeroMesas())+ "'"
                    + " WHERE "
                    + "codigo = '" + pModelConfiguracao.getCodigo() + "'"
                + ";";
            return this.executarUpdateDeleteSQL(sql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    /**
    * atualiza Configuracao
    * @param pNumero 
    * return boolean
    */
    public boolean atualizarConfiguracaoVisualizarNfceDAO(int pCodigo, int pNumero){
        try {
            this.conectar();
            String sql = 
                "UPDATE configuracao SET "
                    + "visualizar_nfce = '" + (pNumero)+ "'"
                    + " WHERE "
                    + "numero_nfe = '" + pCodigo + "'"
                + ";";
            return this.executarUpdateDeleteSQL(sql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
    * exclui Configuracao
    * @param pCodigo
    * return boolean
    */
    public boolean excluirConfiguracaoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM configuracao "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
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
