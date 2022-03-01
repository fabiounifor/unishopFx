package DAO;

import com.sun.tools.ws.processor.model.ModelException;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelTributacaoFederal;

/**
 *
 * @author Leandro
 */
public class DAOTributacaoFederal extends ConexaoMySql {

       
/**
    * grava TributacaoFederal
    * @param pModelTributacaoFederal
    * return int
    */
    public int salvarTributacaoFederalDAO(ModelTributacaoFederal pModelTributacaoFederal){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tribfed ("
                    + "descricao_trib,"
                    + "idipi,"
                    + "idpiscofins"
                    + ") VALUES ("
                    + "'" + pModelTributacaoFederal.getDescricao()+ "',"
                    + "'" + pModelTributacaoFederal.getIdIpi()+ "',"
                    + "'" + pModelTributacaoFederal.getIdPisCofins()+ "'"
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
    * recupera TributacaoFederal
    * @param pCodigo
    * @return ModelTributacaoFederal
    */
    public ModelTributacaoFederal getTributacaoFederal(int pCodigo){
        ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao_trib,"
                    + "idipi,"
                    + "idpiscofins"
                    + " FROM"
                     + " tribfed"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTributacaoFederal.setCodigo(this.getResultSet().getInt(1));
                modelTributacaoFederal.setDescricao(this.getResultSet().getString(2));
                modelTributacaoFederal.setIdIpi(this.getResultSet().getInt(3));
                modelTributacaoFederal.setIdPisCofins(this.getResultSet().getInt(4));
                                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTributacaoFederal;
    }
    /**
    * recupera TributacaoFederal
    * @param pNome
    * @return ModelTributacaoFederal
    */
    public ModelTributacaoFederal getTributacaoFederal(String pNome){
        ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao_trib,"
                    + "idipi,"
                    + "idpiscofins"
                    + " FROM"
                     + " tribFed"
                 + " WHERE"
                     + " descricao_trib = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTributacaoFederal.setCodigo(this.getResultSet().getInt(1));
                modelTributacaoFederal.setDescricao(this.getResultSet().getString(2));
                modelTributacaoFederal.setIdIpi(this.getResultSet().getInt(3));
                modelTributacaoFederal.setIdPisCofins(this.getResultSet().getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTributacaoFederal;
    }

    /**
    * recupera uma lista de TributacaoFederal
        * return ArrayList
    */
    public ArrayList<ModelTributacaoFederal> getListaTributacaoFederal(){
        ArrayList<ModelTributacaoFederal> listamodelTributacaoFederal = new ArrayList();
        ModelTributacaoFederal modelTributacaoFederal = new ModelTributacaoFederal();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao_trib,"
                    + "idipi,"
                    + "idpiscofins"
                 + " FROM"
                     + " tribfed"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTributacaoFederal.setCodigo(this.getResultSet().getInt(1));
                modelTributacaoFederal.setDescricao(this.getResultSet().getString(2));
                modelTributacaoFederal.setIdIpi(this.getResultSet().getInt(3));
                modelTributacaoFederal.setIdPisCofins(this.getResultSet().getInt(4));
                listamodelTributacaoFederal.add(modelTributacaoFederal);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelTributacaoFederal;
    }

    /**
    * atualiza TributacaoFederal
    * @param pModelTributacaoFederal 
    * return boolean
    */
    public boolean atualizarTributacaoFederalDAO(ModelTributacaoFederal pModelTributacaoFederal){
        try {
            this.conectar();
            String sql = 
                "UPDATE tribfed SET "
                    + "codigo = '" + pModelTributacaoFederal.getCodigo() + "',"
                    + "descricao_trib = '" + pModelTributacaoFederal.getDescricao() + "',"
                    + "idipi = '" + pModelTributacaoFederal.getIdIpi()+ "',"
                    + "idpiscofins = '" + pModelTributacaoFederal.getIdPisCofins()+ "'"
                    
                + " WHERE "
                    + "codigo = '" + pModelTributacaoFederal.getCodigo() + "'"
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
    * exclui TributacaoFederal
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTributacaoFederalDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tribfed "
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
