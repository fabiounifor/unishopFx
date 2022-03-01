package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelEnquadramentoIpi;

/**
 *
 * @author Leandro
 */
public class DAOEnquadramentoIpi extends ConexaoMySql {

/**
    * grava enquadramentoipi
    * @param pModelEnquadramentoIpi 
    * return int
    */
    public int salvarEnquadramentoIpiDAO(ModelEnquadramentoIpi pModelEnquadramentoIpi){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO enquadramento_ipi ("
                    + "codigo,"
                    + "numero,"
                    + "grupo_cst,"
                    + "cst_entrada,"
                    + "cst_saida,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelEnquadramentoIpi.getCodigo() + "',"
                    + "'" + pModelEnquadramentoIpi.getNumero()+ "',"
                    + "'" + pModelEnquadramentoIpi.getGrupoCst()+ "',"
                    + "'" + pModelEnquadramentoIpi.getEntradaCst()+ "',"
                    + "'" + pModelEnquadramentoIpi.getSaidaCst()+ "',"
                    + "'" + pModelEnquadramentoIpi.getDescricao()+ "'"
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
    * recupera enquadramentoipi
    * @param pCodigo
    * @return ModelEnquadramentoIpi
    */
    public ModelEnquadramentoIpi getEnquadramentoIpiDAO(int pCodigo){
        ModelEnquadramentoIpi modelEnquadramentoIpi = new ModelEnquadramentoIpi();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "grupo_cst,"
                    + "cst_entrada,"
                    + "cst_saida,"
                    + "descricao"
                 + " FROM"
                     + " enquadramento_ipi"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEnquadramentoIpi.setCodigo(this.getResultSet().getInt(1));
                modelEnquadramentoIpi.setNumero(this.getResultSet().getInt(2));
                modelEnquadramentoIpi.setGrupoCst(this.getResultSet().getString(3));
                modelEnquadramentoIpi.setEntradaCst(this.getResultSet().getString(4));
                modelEnquadramentoIpi.setSaidaCst(this.getResultSet().getString(5));
                modelEnquadramentoIpi.setDescricao(this.getResultSet().getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEnquadramentoIpi;
    }
    
    /**
    * recupera uma lista de EnquadramentoIpi
        * return ArrayList
     * @return 
    */
    public ArrayList<ModelEnquadramentoIpi> getListaEnquadramentoIpiDAO(){
        ArrayList<ModelEnquadramentoIpi> listamodelEnquadramentoIpi = new ArrayList();
        ModelEnquadramentoIpi modelEnquadramentoIpi = new ModelEnquadramentoIpi();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "grupo_cst,"
                    + "cst_entrada,"
                    + "cst_saida,"    
                    + "descricao"
                    + " FROM"
                     + " enquadramento_ipi"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEnquadramentoIpi = new ModelEnquadramentoIpi();
                modelEnquadramentoIpi.setCodigo(this.getResultSet().getInt(1));
                modelEnquadramentoIpi.setNumero(this.getResultSet().getInt(2));
                modelEnquadramentoIpi.setGrupoCst(this.getResultSet().getString(3));
                modelEnquadramentoIpi.setEntradaCst(this.getResultSet().getString(4));
                modelEnquadramentoIpi.setSaidaCst(this.getResultSet().getString(5));
                modelEnquadramentoIpi.setDescricao(this.getResultSet().getString(6));
                
                listamodelEnquadramentoIpi.add(modelEnquadramentoIpi);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEnquadramentoIpi;
    }

    /**
    * atualiza enquadramentoipi
    * @param pModelCstPiscofins   
    * return boolean
    */
    public boolean atualizarEnquadramentoIpiDAO(ModelEnquadramentoIpi pModelEnquadramentoIpi){
        try {
            this.conectar();
            String sql = 
                "UPDATE enquadramento_ipi SET "
                    + "codigo = '" + pModelEnquadramentoIpi.getCodigo() + "',"
                    + "numero = '" + pModelEnquadramentoIpi.getNumero()+ "',"
                    + "grupo_cst = '" + pModelEnquadramentoIpi.getGrupoCst()+ "',"
                    + "cst_entrada = '" + pModelEnquadramentoIpi.getEntradaCst()+ "',"
                    + "cst_saida = '" + pModelEnquadramentoIpi.getSaidaCst()+ "',"
                    + "descricao = '" + pModelEnquadramentoIpi.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelEnquadramentoIpi.getCodigo() + "'"
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
    * exclui enquadramentoipi
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirEnquadramentoIpiDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM enquadramento_ipi "
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
