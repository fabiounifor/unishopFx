package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCsosnFederal;

/**
 *
 * @author Leandro
 */
public class DAOCsosnFederal extends ConexaoMySql {

/**
    * grava CsosnFederal
    * @param pModelCsosnFederal 
    * return int
    */
    public int salvarCsosnFederalDAO(ModelCsosnFederal pModelCsosnFederal){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO csosn_federal ("
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCsosnFederal.getCodigo() + "',"
                    + "'" + pModelCsosnFederal.getNumero()+ "',"
                    + "'" + pModelCsosnFederal.getDescricao()+ "'"
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
    * recupera CsosnFederal
    * @param pCodigo
    * @return ModelCsosnFederal
    */
    public ModelCsosnFederal getCsosnFederalDAO(int pCodigo){
        ModelCsosnFederal modelCsosnFederal = new ModelCsosnFederal();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                 + " FROM"
                     + " csosn_federal"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCsosnFederal.setCodigo(this.getResultSet().getInt(1));
                modelCsosnFederal.setNumero(this.getResultSet().getInt(2));
                modelCsosnFederal.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCsosnFederal;
    }
    
    /**
    * recupera uma lista de Csosn
        * return ArrayList
    */
    public ArrayList<ModelCsosnFederal> getListaCsosnFederalDAO(){
        ArrayList<ModelCsosnFederal> listamodelCsosnFederal = new ArrayList();
        ModelCsosnFederal modelCsosnFederal = new ModelCsosnFederal();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "numero,"
                    + "descricao"
                    + " FROM"
                     + " csosn_federal"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCsosnFederal = new ModelCsosnFederal();
                modelCsosnFederal.setCodigo(this.getResultSet().getInt(1));
                modelCsosnFederal.setNumero(this.getResultSet().getInt(2));
                modelCsosnFederal.setDescricao(this.getResultSet().getString(3));
                
                listamodelCsosnFederal.add(modelCsosnFederal);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCsosnFederal;
    }

    /**
    * atualiza Csosn
    * @param pModelCsosn
    * return boolean
    */
    public boolean atualizarCsosnFederalDAO(ModelCsosnFederal pModelCsosnFederal){
        try {
            this.conectar();
            String sql = 
                "UPDATE csosn_federal SET "
                    + "codigo = '" + pModelCsosnFederal.getCodigo() + "',"
                    + "numero = '" + pModelCsosnFederal.getNumero()+ "',"
                    + "descricao = '" + pModelCsosnFederal.getDescricao() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelCsosnFederal.getCodigo() + "'"
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
    * exclui Csosn
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCsosnFederalDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM csosn_federal "
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
