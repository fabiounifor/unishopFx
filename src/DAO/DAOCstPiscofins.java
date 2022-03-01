package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCstPiscofins;

/**
 *
 * @author Leandro
 */
public class DAOCstPiscofins extends ConexaoMySql {

/**
    * grava Csosn
    * @param pModelCstPiscofins
    * return int
    */
    public int salvarCstPiscofinsDAO(ModelCstPiscofins pModelCstPiscofins){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cst_piscofins ("
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCstPiscofins.getCodigo() + "',"
                    + "'" + pModelCstPiscofins.getNumero()+ "',"
                    + "'" + pModelCstPiscofins.getDescricao()+ "'"
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
    * recupera CstPisconfins
    * @param pCodigo
    * @return ModelCstPiscofins
    */
    public ModelCstPiscofins getCstPisconfinsDAO(int pCodigo){
        ModelCstPiscofins modelCstPiscofins = new ModelCstPiscofins();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                 + " FROM"
                     + " cst_piscofins"
                 + " WHERE "
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCstPiscofins.setCodigo(this.getResultSet().getInt(1));
                modelCstPiscofins.setNumero(this.getResultSet().getInt(2));
                modelCstPiscofins.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCstPiscofins;
    }
    
    /**
    * recupera uma lista de CstPiscofins
        * return ArrayList
     * @return 
    */
    public ArrayList<ModelCstPiscofins> getListaCstPiscofinsDAO(){
        ArrayList<ModelCstPiscofins> listamodelCstPiscofins = new ArrayList();
        ModelCstPiscofins modelCstPiscofins = new ModelCstPiscofins();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                    + " FROM"
                     + " cst_piscofins"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCstPiscofins = new ModelCstPiscofins();
                modelCstPiscofins.setCodigo(this.getResultSet().getInt(1));
                modelCstPiscofins.setNumero(this.getResultSet().getInt(2));
                modelCstPiscofins.setDescricao(this.getResultSet().getString(3));
                
                listamodelCstPiscofins.add(modelCstPiscofins);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCstPiscofins;
    }

    /**
    * atualiza CstPisconfins
    * @param pModelCstPiscofins  
    * return boolean
    */
    public boolean atualizarCstPiscofinsDAO(ModelCstPiscofins pModelCstPiscofins){
        try {
            this.conectar();
            String sql = 
                "UPDATE cst_piscofins SET "
                    + "codigo = '" + pModelCstPiscofins.getCodigo() + "',"
                    + "numero = '" + pModelCstPiscofins.getNumero()+ "',"
                    + "descricao = '" + pModelCstPiscofins.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelCstPiscofins.getCodigo() + "'"
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
    * exclui CstPiscofins
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirCstPiscofinsDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cst_piscofins "
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
