package DAO;

import model.ModelBairro;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAOBairro extends ConexaoMySql {

    /**
    * grava Bairro
    * @param pModelBairro
    * return int
    */
    public int salvarBairroDAO(ModelBairro pModelBairro){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO bairro ("
                    + "rota,"
                    + "fk_cod_cidade,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelBairro.getRota()+ "',"
                    + "'" + pModelBairro.getCidade()+ "',"
                    + "'" + pModelBairro.getDescricao()+ "'"
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
    * recupera Bairro
    * @param pCodigo
    * return ModelBairro
    */
    public ModelBairro getBairroDAO(int pCodigo){
        ModelBairro modelBairro = new ModelBairro();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "rota,"
                    + "fk_cod_cidade,"
                    + "descricao"
                 + " FROM"
                     + " bairro"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBairro.setCodigo(this.getResultSet().getInt(1));
                modelBairro.setRota(this.getResultSet().getInt(2));
                modelBairro.setCidade(this.getResultSet().getInt(3));
                modelBairro.setDescricao(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBairro;
    }
    
    /**
    * recupera Bairro
    * @param pCodigo
    * return ModelBairro
    */
    public ModelBairro getBairroNomeDAO(String pNome){
        ModelBairro modelBairro = new ModelBairro();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "rota,"
                    + "fk_cod_cidade,"
                    + "descricao"
                     + " FROM"
                     + " bairro"
                 + " WHERE"
                     + " descricao = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBairro.setCodigo(this.getResultSet().getInt(1));
                modelBairro.setRota(this.getResultSet().getInt(2));
                modelBairro.setCidade(this.getResultSet().getInt(3));
                modelBairro.setDescricao(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBairro;
    }

    /**
    * recupera uma lista de Bairro
        * return ArrayList
    */
    public ArrayList<ModelBairro> getListaBairroDAO(){
        ArrayList<ModelBairro> listamodelBairro = new ArrayList();
        ModelBairro modelBairro = new ModelBairro();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "fk_cod_cidade,"
                    + "descricao,"
                    + "rota"
                     + " FROM"
                     + " bairro"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBairro = new ModelBairro();
                modelBairro.setCodigo(this.getResultSet().getInt(1));
                modelBairro.setCidade(this.getResultSet().getInt(2));
                modelBairro.setDescricao(this.getResultSet().getString(3));
                modelBairro.setRota(this.getResultSet().getInt(4));
                listamodelBairro.add(modelBairro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelBairro;
    }

    /**
    * atualiza Bairro
    * @param pModelBairro
    * return boolean
    */
    public boolean atualizarBairroDAO(ModelBairro pModelBairro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE bairro SET "
                    + "codigo = '" + pModelBairro.getCodigo() + "',"
                    + "fk_cod_cidade = '" + pModelBairro.getCidade() + "',"
                    + "rota = '" + pModelBairro.getRota() + "',"
                    + "descricao = '" + pModelBairro.getDescricao() + "'"
                + " WHERE "
                    + "codigo = '" + pModelBairro.getCodigo() + "'"
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
    * exclui Bairro
    * @param pCodigo
    * return boolean
    */
    public boolean excluirBairroDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM bairro "
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