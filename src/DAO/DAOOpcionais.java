package DAO;

import model.ModelOpcionais;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author Fabio
*/
public class DAOOpcionais extends ConexaoMySql {
    

    /**
    * grava OPCOES
    * @param pModelOpcionais
    * return int
     * @return 
    */
    public int salvarOpcoesDAO(ModelOpcionais pModelOpcionais){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO opcoes_venda ("
                    + "codigo,"
                    + "codigo_tipo,"
                    + "descricao,"
                    + "imagem"
                    + ") VALUES ("
                    + "'" + pModelOpcionais.getCodigo()+ "',"
                    + "'" + pModelOpcionais.getTipo()+ "',"
                    + "'" + pModelOpcionais.getDescricao()+ "',"
                    + "'" + pModelOpcionais.getImagem()+ "'"
                    + ");"
            );
        }catch(Exception e){
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera opcoes_venda
    * @param pCodigo
    * return ModelOPCOES
     * @return 
    */
    public ModelOpcionais getOpcoesDAO(int pCodigo){
        ModelOpcionais modelGrupo = new ModelOpcionais();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                   + "codigo,"
                    + "codigo_tipo,"
                    + "descricao,"
                    + "imagem"
                    + " FROM"
                     + " opcoes_venda"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelGrupo.setCodigo(this.getResultSet().getInt(1));
                modelGrupo.setTipo(this.getResultSet().getInt(2));
                modelGrupo.setDescricao(this.getResultSet().getString(3));
                modelGrupo.setImagem(this.getResultSet().getString(4));
                }
        }catch(SQLException e){
        }finally{
            this.fecharConexao();
        }
        return modelGrupo;
    }

    /**
    * recupera uma lista de OPCOES
        * return ArrayList
    */
    public ArrayList<ModelOpcionais> getListaOpcoesDAO(){
        ArrayList<ModelOpcionais> listamodelOpcionais = new ArrayList();
        ModelOpcionais modelOpcionais = new ModelOpcionais();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_tipo,"
                    + "descricao,"
                    + "imagem"
                    + " FROM"
                     + " opcoes_venda"
                + ";"
            );

            while(this.getResultSet().next()){
                modelOpcionais = new ModelOpcionais();
                modelOpcionais.setCodigo(this.getResultSet().getInt(1));
                modelOpcionais.setTipo(this.getResultSet().getInt(2));
                modelOpcionais.setDescricao(this.getResultSet().getString(3));
                modelOpcionais.setImagem(this.getResultSet().getString(4));
                listamodelOpcionais.add(modelOpcionais);
                }
        }catch(Exception e){
        }finally{
            this.fecharConexao();
        }
        return listamodelOpcionais;
    }

    /**
    /**
    * recupera uma lista de OPCOES
        * return ArrayList
    */
    public ArrayList<ModelOpcionais> getListaOpcoesTipoDAO(int pTipo){
        ArrayList<ModelOpcionais> listamodelOpcionais = new ArrayList();
        ModelOpcionais modelOpcionais = new ModelOpcionais();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_tipo,"
                    + "descricao,"
                    + "imagem"
                    + " FROM"
                     + " opcoes_venda"
                     + " WHERE "
                     + "codigo_tipo = '" + pTipo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelOpcionais = new ModelOpcionais();
                modelOpcionais.setCodigo(this.getResultSet().getInt(1));
                modelOpcionais.setTipo(this.getResultSet().getInt(2));
                modelOpcionais.setDescricao(this.getResultSet().getString(3));
                modelOpcionais.setImagem(this.getResultSet().getString(4));
                listamodelOpcionais.add(modelOpcionais);
                }
        }catch(Exception e){
        }finally{
            this.fecharConexao();
        }
        return listamodelOpcionais;
    }

    /**
    * atualiza OPCOES
    * @param pModelOpcionais
    * return boolean
     * @return 
    */
    public boolean atualizarOpcoesDAO(ModelOpcionais pModelOpcionais){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE opcoes_venda SET "
                    + "codigo = '" + pModelOpcionais.getCodigo() + "',"
                    + "codigo_tipo = '" + pModelOpcionais.getTipo()+ "',"
                    + "descricao = '" + pModelOpcionais.getDescricao() + "',"
                    + "imagem = '" + pModelOpcionais.getImagem() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelOpcionais.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui OPCOES
    * @param pCodigo
    * return boolean
     * @return 
    */
    public boolean excluirOpcoesDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM opcoes_venda "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}