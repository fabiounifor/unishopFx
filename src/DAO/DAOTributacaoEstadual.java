package DAO;

import com.sun.tools.ws.processor.model.ModelException;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelTributacaoEstadual;

/**
 *
 * @author Leandro
 */
public class DAOTributacaoEstadual extends ConexaoMySql {

       
/**
    * grava TributacaoEstadual
    * @param pModelTributacaoEstadual
    * return int
    */
    public int salvarTributacaoEstadualDAO(ModelTributacaoEstadual pModelTributacaoEstadual){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tribest ("
                    + "descricao_trib,"
                    + "idEstado,"
                    + "percentual ,"
                    + "idCFOP,"
                    + "idCSOSN ,"
                    + "base_calculo,"
                    + "origem,"
                    + "base_calc_sub,"
                    + "base_calc_sub_efetivo,"
                    + "base_calc_icms,"
                    + "base_calc_icms_retido"
                    + ") VALUES ("
                    + "'" + pModelTributacaoEstadual.getDescricao()+ "',"
                    + "'" + pModelTributacaoEstadual.getIdestado() + "',"
                    + "'" + pModelTributacaoEstadual.getPercentual()+ "',"
                    + "'" + pModelTributacaoEstadual.getIdcfop()+ "',"
                    + "'" + pModelTributacaoEstadual.getIdcsosn()+ "',"
                    + "'" + pModelTributacaoEstadual.getBasedecalculo()+ "',"
                    + "'" + pModelTributacaoEstadual.getOrigem()+ "',"
                    + "'" + pModelTributacaoEstadual.getBasedecalculosub()+ "',"
                    + "'" + pModelTributacaoEstadual.getBasedecalculosubefetivo()+ "',"
                    + "'" + pModelTributacaoEstadual.getBasedecalculoicms()+ "',"
                    + "'" + pModelTributacaoEstadual.getBasedecalculoicmsretido()+ "'"
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
    * recupera TributacaoEstadual
    * @param pCodigo
    * @return ModelTributacaoEstadual
    */
    public ModelTributacaoEstadual getTributacaoEstadual(int pCodigo){
        ModelTributacaoEstadual modelTributacaoEstadual = new ModelTributacaoEstadual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao_trib,"
                    + "idEstado,"
                    + "percentual ,"
                    + "idCFOP,"
                    + "idCSOSN ,"
                    + "base_calculo,"
                    + "origem,"
                    + "base_calc_sub,"
                    + "base_calc_sub_efetivo,"
                    + "base_calc_icms,"
                    + "base_calc_icms_retido"
                 + " FROM"
                     + " tribest"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTributacaoEstadual.setCodigo(this.getResultSet().getInt(1));
                modelTributacaoEstadual.setDescricao(this.getResultSet().getString(2));
                modelTributacaoEstadual.setIdestado(this.getResultSet().getInt(3));
                modelTributacaoEstadual.setPercentual(this.getResultSet().getFloat(4));
                modelTributacaoEstadual.setIdcfop(this.getResultSet().getInt(5));
                modelTributacaoEstadual.setIdcsosn(this.getResultSet().getInt(6));
                modelTributacaoEstadual.setBasedecalculo(this.getResultSet().getFloat(7));
                modelTributacaoEstadual.setOrigem(this.getResultSet().getInt(8));
                modelTributacaoEstadual.setBasedecalculosub(this.getResultSet().getFloat(9));
                modelTributacaoEstadual.setBasedecalculosubefetivo(this.getResultSet().getFloat(10));
                modelTributacaoEstadual.setBasedecalculoicms(this.getResultSet().getFloat(11));
                modelTributacaoEstadual.setBasedecalculoicmsretido(this.getResultSet().getFloat(12));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTributacaoEstadual;
    }
    /**
    * recupera TributacaoEstadual
    * @param pNome
    * @return ModelTributacaoEstadual
    */
    public ModelTributacaoEstadual getTributacaoEstadual(String pNome){
        ModelTributacaoEstadual modelTributacaoEstadual = new ModelTributacaoEstadual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao_trib,"
                    + "idEstado,"
                    + "percentual ,"
                    + "idCFOP,"
                    + "idCSOSN ,"
                    + "base_calculo,"
                    + "origem,"
                    + "base_calc_sub,"
                    + "base_calc_sub_efetivo,"
                    + "base_calc_icms,"
                    + "base_calc_icms_retido"
                 + " FROM"
                     + " tribest"
                 + " WHERE"
                     + " descricao_trib = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTributacaoEstadual.setCodigo(this.getResultSet().getInt(1));
                modelTributacaoEstadual.setDescricao(this.getResultSet().getString(2));
                modelTributacaoEstadual.setIdestado(this.getResultSet().getInt(3));
                modelTributacaoEstadual.setPercentual(this.getResultSet().getFloat(4));
                modelTributacaoEstadual.setIdcfop(this.getResultSet().getInt(5));
                modelTributacaoEstadual.setIdcsosn(this.getResultSet().getInt(6));
                modelTributacaoEstadual.setBasedecalculo(this.getResultSet().getFloat(7));
                modelTributacaoEstadual.setOrigem(this.getResultSet().getInt(8));
                modelTributacaoEstadual.setBasedecalculosub(this.getResultSet().getFloat(9));
                modelTributacaoEstadual.setBasedecalculosubefetivo(this.getResultSet().getFloat(10));
                modelTributacaoEstadual.setBasedecalculoicms(this.getResultSet().getFloat(11));
                modelTributacaoEstadual.setBasedecalculoicmsretido(this.getResultSet().getFloat(12));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTributacaoEstadual;
    }

    /**
    * recupera uma lista de TributacaoEstadual
        * return ArrayList
    */
    public ArrayList<ModelTributacaoEstadual> getListaTributacaoEstadual(){
        ArrayList<ModelTributacaoEstadual> listamodelTributacaoEstaduals = new ArrayList();
        ModelTributacaoEstadual modelTributacaoEstadual = new ModelTributacaoEstadual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao_trib,"
                    + "idEstado,"
                    + "percentual,"
                    + "idCFOP,"
                    + "idCSOSN,"
                    + "base_calculo,"
                    + "origem,"
                    + "base_calc_sub,"
                    + "base_calc_sub_efetivo,"
                    + "base_calc_icms,"
                    + "base_calc_icms_retido"
                 + " FROM"
                     + " tribest"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTributacaoEstadual = new ModelTributacaoEstadual();
                modelTributacaoEstadual.setCodigo(this.getResultSet().getInt(1));
                modelTributacaoEstadual.setDescricao(this.getResultSet().getString(2));
                modelTributacaoEstadual.setIdestado(this.getResultSet().getInt(3));
                modelTributacaoEstadual.setPercentual(this.getResultSet().getFloat(4));
                modelTributacaoEstadual.setIdcfop(this.getResultSet().getInt(5));
                modelTributacaoEstadual.setIdcsosn(this.getResultSet().getInt(6));
                modelTributacaoEstadual.setBasedecalculo(this.getResultSet().getFloat(7));
                modelTributacaoEstadual.setOrigem(this.getResultSet().getInt(8));
                modelTributacaoEstadual.setBasedecalculosub(this.getResultSet().getFloat(9));
                modelTributacaoEstadual.setBasedecalculosubefetivo(this.getResultSet().getFloat(10));
                modelTributacaoEstadual.setBasedecalculoicms(this.getResultSet().getFloat(11));
                modelTributacaoEstadual.setBasedecalculoicmsretido(this.getResultSet().getFloat(12));
                listamodelTributacaoEstaduals.add(modelTributacaoEstadual);
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
         return listamodelTributacaoEstaduals;
    }

    /**
    * atualiza TributacaoEstadual
    * @param pModelTributacaoEstadual 
    * return boolean
    */
    public boolean atualizarTributacaoEstadualDAO(ModelTributacaoEstadual pModelTributacaoEstadual){
        try {
            this.conectar();
            String sql = 
                "UPDATE tribest SET "
                    + "codigo = '" + pModelTributacaoEstadual.getCodigo() + "',"
                    + "descricao_trib = '" + pModelTributacaoEstadual.getDescricao() + "',"
                    + "idEstado = '" + pModelTributacaoEstadual.getIdestado() + "',"
                    + "percentual = '" + pModelTributacaoEstadual.getPercentual() + "',"
                    + "idCFOP = '" + pModelTributacaoEstadual.getIdcfop() + "',"
                    + "idCSOSN = '" + pModelTributacaoEstadual.getIdcsosn() + "',"
                    + "base_calculo = '" + pModelTributacaoEstadual.getBasedecalculo() + "',"
                    + "origem = '" + pModelTributacaoEstadual.getOrigem() + "',"
                    + "base_calc_sub = '" + pModelTributacaoEstadual.getBasedecalculosub() + "',"
                    + "base_calc_sub_efetivo = '" + pModelTributacaoEstadual.getBasedecalculoicmsretido() + "',"
                    + "base_calc_icms = '" + pModelTributacaoEstadual.getBasedecalculoicms() + "',"
                    + "base_calc_icms_retido = '" + pModelTributacaoEstadual.getBasedecalculoicmsretido() + "'"
                + " WHERE "
                    + "codigo = '" + pModelTributacaoEstadual.getCodigo() + "'"
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
    * exclui TributacaoEstadual
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTributacaoEstadualDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tribest "
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
