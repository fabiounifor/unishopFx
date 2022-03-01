package DAO;

import model.ModelEstado;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAOEstado extends ConexaoMySql {

    /**
    * grava Estado
    * @param pModelEstado
    * return int
    */
    public int salvarEstadoDAO(ModelEstado pModelEstado){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO estado ("
                    + "codigo,"
                    + "uf,"
                    + "nome"
                + ") VALUES ("
                    + "'" + pModelEstado.getCodigo() + "',"
                    + "'" + pModelEstado.getUf() + "',"
                    + "'" + pModelEstado.getNome() + "'"
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
    * recupera Estado
    * @param pCodigo
    * return ModelEstado
    */
    public ModelEstado getEstadoDAOCod(int pCodigo){
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEstado;
    }
    /**
    * recupera Estado
    * @param pNome
    * return ModelEstado
    */
    public ModelEstado getEstadoDAO(String pNome){
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado"
                 + " WHERE"
                     + " nome = '" + pNome + "';"
            );
            while(this.getResultSet().next()){
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEstado;
    }
    /**
    * recupera Estado
    * @param pNome
    * return ModelEstado
    */
    public ModelEstado getEstadoUFDAO(String pNome){
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado"
                 + " WHERE"
                     + " uf = '" + pNome + "';"
            );
            while(this.getResultSet().next()){
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEstado;
    }

    /**
    * recupera uma lista de Estado
        * return ArrayList
    */
    public ArrayList<ModelEstado> getListaEstadoDAO(){
        ArrayList<ModelEstado> listamodelEstado = new ArrayList();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado ORDER BY uf"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEstado = new ModelEstado();
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
                listamodelEstado.add(modelEstado);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEstado;
    }

    /**
    * atualiza Estado
    * @param pModelEstado
    * return boolean
    */
    public boolean atualizarEstadoDAO(ModelEstado pModelEstado){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE estado SET "
                    + "codigo = '" + pModelEstado.getCodigo() + "',"
                    + "uf = '" + pModelEstado.getUf() + "',"
                    + "nome = '" + pModelEstado.getNome() + "'"
                + " WHERE "
                    + "codigo = '" + pModelEstado.getCodigo() + "'"
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
    * exclui Estado
    * @param pCodigo
    * return boolean
    */
    public boolean excluirEstadoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM estado "
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