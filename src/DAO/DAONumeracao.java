package DAO;

import conexoes.ConexaoMySql;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import util.BLMascaras;
import java.util.ArrayList;
import model.ModelNumeracao;

/**
 *
 * @author Leandro
 */
public class DAONumeracao extends ConexaoMySql {
BLMascaras bLMascaras = new BLMascaras();
/**
    * grava Numeracao
    * @param pModelNumeracao 
    * return int
    */
    public int salvarNumeracaoDAO(ModelNumeracao pModelNumeracao){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO numeracao ("
                    + "codigo,"
                    + "numero_nfe,"
                    + "numero_nfce,"
                    + "serie_nfe,"
                    + "serie_nfce,"
                    + "ultimo_nsu, "
                    + "ultima_consulta "
                + ") VALUES ("
                    + "'" + pModelNumeracao.getCodigo() + "',"
                    + "'" + pModelNumeracao.getNumeroNfe()+ "',"
                    + "'" + pModelNumeracao.getNumeroNfce()+ "',"
                    + "'" + pModelNumeracao.getSerieNfe()+ "',"
                    + "'" + pModelNumeracao.getSerieNfce()+ "',"
                    + "'" + pModelNumeracao.getUltimoNsu()+ "',"
                    + "'" + pModelNumeracao.getUltimaConsulta()+ "'"
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
    * recupera Numeracao
    * @param pCodigo
    * @return ModelNumeracao
    */
    public ModelNumeracao getNumeracaoDAO(int pCodigo){
        ModelNumeracao modelNumeracao = new ModelNumeracao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero_nfe,"
                    + "numero_nfce,"
                    + "serie_nfe,"
                    + "serie_nfce,"
                    + "ultimo_nsu, "
                    + "ultima_consulta "
                 + " FROM"
                     + " numeracao"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNumeracao.setCodigo(this.getResultSet().getInt(1));
                modelNumeracao.setNumeroNfe(this.getResultSet().getInt(2));
                modelNumeracao.setNumeroNfce(this.getResultSet().getInt(3));
                modelNumeracao.setSerieNfe(this.getResultSet().getInt(4));
                modelNumeracao.setSerieNfce(this.getResultSet().getInt(5));
                modelNumeracao.setUltimoNsu(this.getResultSet().getString(6));
                modelNumeracao.setUltimaConsulta(this.getResultSet().getString(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelNumeracao;
    }
    /**
    * recupera Numeracao
    * @param pNumero
    * @return ModelNumeracao
    */
    public ModelNumeracao getNumeracaoNfceDAO(int pNumero){
        ModelNumeracao modelNumeracao = new ModelNumeracao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero_nfe,"
                    + "numero_nfce,"
                    + "serie_nfe,"
                    + "serie_nfce,"
                    + "ultimo_nsu,"
                    + "ultima_consulta"
                 + " FROM"
                     + " numeracao"
                 + " WHERE"
                     + " numero_nfce = '" + pNumero + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNumeracao.setCodigo(this.getResultSet().getInt(1));
                modelNumeracao.setNumeroNfe(this.getResultSet().getInt(2));
                modelNumeracao.setNumeroNfce(this.getResultSet().getInt(3));
                modelNumeracao.setSerieNfe(this.getResultSet().getInt(4));
                modelNumeracao.setSerieNfce(this.getResultSet().getInt(5));
                modelNumeracao.setUltimoNsu(this.getResultSet().getString(6));
                modelNumeracao.setUltimaConsulta(this.getResultSet().getString(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelNumeracao;
    }
    
    /**
    * recupera uma lista de Numeracao
        * return ArrayList
    */
    public ArrayList<ModelNumeracao> getListaNumeracaoDAO(){
        ArrayList<ModelNumeracao> listamodelNumeracao = new ArrayList();
        ModelNumeracao modelNumeracao = new ModelNumeracao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero_nfe,"
                    + "numero_nfce,"
                    + "serie_nfe,"
                    + "serie_nfce,"
                    + "ultimo_nsu,"
                    + "ultima_consulta"
                    + " FROM"
                     + " numeracao"
                + ";"
            );

            while(this.getResultSet().next()){
                modelNumeracao = new ModelNumeracao();
                modelNumeracao.setCodigo(this.getResultSet().getInt(1));
                modelNumeracao.setNumeroNfe(this.getResultSet().getInt(2));
                modelNumeracao.setNumeroNfce(this.getResultSet().getInt(3));
                modelNumeracao.setSerieNfe(this.getResultSet().getInt(4));
                modelNumeracao.setSerieNfce(this.getResultSet().getInt(5));
                modelNumeracao.setUltimoNsu(this.getResultSet().getString(6));
                modelNumeracao.setUltimaConsulta(this.getResultSet().getString(7));
                listamodelNumeracao.add(modelNumeracao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelNumeracao;
    }

    /**
    * atualiza Numeracao
    * @param pNumero 
    * return boolean
    */
    public boolean atualizarNumeracaoNfeDAO(ModelNumeracao pModelNumeracao){
        try {
            this.conectar();
            String sql = 
                "UPDATE numeracao SET "
                    + "numero_nfe = '" + (pModelNumeracao.getNumeroNfe())+ "',"
                    + "numero_nfce = '" + (pModelNumeracao.getNumeroNfce())+ "',"
                    + "serie_nfe = '" + (pModelNumeracao.getSerieNfe())+ "',"
                    + "numero_nfce = '" + (pModelNumeracao.getSerieNfce())+ "',"
                    + "ultimo_nsu = '" + (pModelNumeracao.getUltimoNsu())+ "',"
                    + "ultima_consulta = '" + (pModelNumeracao.getUltimaConsulta())+ "'"
                    + " WHERE "
                    + "codigo = '" + pModelNumeracao.getCodigo() + "'"
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
    * atualiza Numeracao
    * @param pNumero 
    * return boolean
    */
    public boolean atualizarNumeracaoNfeDAO(int pNumero){
        try {
            this.conectar();
            String sql = 
                "UPDATE numeracao SET "
                    + "numero_nfe = '" + (pNumero + 1)+ "'"
                    + " WHERE "
                    + "numero_nfe = '" + pNumero + "'"
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
    * atualiza Numeracao
    * @param pNumero 
    * return boolean
    */
    public boolean atualizarNumeracaoNsuDAO(String pNumero, int pCodigo){
        System.out.println("atualizou nsu pra  " + pNumero);
        try {
            this.conectar();
            String sql = 
                "UPDATE numeracao SET "
                    + "ultimo_nsu = '" + pNumero+ "'"
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";";
            return this.executarUpdateDeleteSQL(sql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    public boolean atualizarConsultaDAO(String pDataHora, int pCodigo){
        try {
            this.conectar();
            String sql = 
                "UPDATE numeracao SET "
                    + "ultima_consulta = '" + pDataHora+ "'"
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";";
            return this.executarUpdateDeleteSQL(sql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    
    public boolean atualizarNumeracaoNfceDAO(int pNumero){
        try {
            this.conectar();
            String sql = 
                "UPDATE numeracao SET "
                    + "numero_nfce = '" + (pNumero + 1)+ "'"
                    + " WHERE "
                    + "numero_nfce = '" + pNumero + "'"
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
    * exclui Numeracao
    * @param pCodigo
    * return boolean
    */
    public boolean excluirNumeracaoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM numeracao "
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
