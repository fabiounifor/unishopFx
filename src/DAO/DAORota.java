package DAO;

import model.ModelRota;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAORota extends ConexaoMySql {

    /**
    * grava Rota
    * @param pModelRota
    * return int
    */
    public int salvarRotaDAO(ModelRota pModelRota){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO bairro ("
                    + "descricao,"
                    + "taxa"
                + ") VALUES ("
                    + "'" + pModelRota.getDescricao()+ "',"
                    + "'" + pModelRota.getTaxa()+ "'"
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
    * recupera Rota
    * @param pCodigo
    * return ModelRota
    */
    public ModelRota getRotaDAO(int pCodigo){
        ModelRota modelRota = new ModelRota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "taxa"
                 + " FROM"
                     + " rota"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelRota.setCodigo(this.getResultSet().getInt(1));
                modelRota.setDescricao(this.getResultSet().getString(2));
                modelRota.setTaxa(this.getResultSet().getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelRota;
    }
    
    /**
    * recupera Rota
    * @param pCodigo
    * return ModelRota
    */
    public ModelRota getRotaNomeDAO(String pNome){
        ModelRota modelRota = new ModelRota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "taxa"
                     + " FROM"
                     + " rota"
                 + " WHERE"
                     + " descricao = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelRota.setCodigo(this.getResultSet().getInt(1));
                modelRota.setDescricao(this.getResultSet().getString(2));
                modelRota.setTaxa(this.getResultSet().getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelRota;
    }

    /**
    * recupera uma lista de Rota
        * return ArrayList
    */
    public ArrayList<ModelRota> getListaRotaDAO(){
        ArrayList<ModelRota> listamodelRota = new ArrayList();
        ModelRota modelRota = new ModelRota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "taxa"
                     + " FROM"
                     + " rota"
                + ";"
            );

            while(this.getResultSet().next()){
                modelRota = new ModelRota();
                modelRota.setCodigo(this.getResultSet().getInt(1));
                modelRota.setDescricao(this.getResultSet().getString(2));
                modelRota.setTaxa(this.getResultSet().getInt(3));
                listamodelRota.add(modelRota);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelRota;
    }

    /**
    * atualiza UnidadeMedia
    * @param pModelRota
    * return boolean
    */
    public boolean atualizarRotaDAO(ModelRota pModelRota){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE rota SET "
                    + "codigo = '" + pModelRota.getCodigo() + "',"
                    + "descricao = '" + pModelRota.getDescricao()+ "',"
                    + "taxa = '" + pModelRota.getTaxa()+ "'"
                    + " WHERE "
                    + "codigo = '" + pModelRota.getCodigo() + "'"
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
    * exclui Rota
    * @param pCodigo
    * return boolean
    */
    public boolean excluirRotaDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM rota "
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