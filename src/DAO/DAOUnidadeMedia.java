package DAO;

import model.ModelUnidadeMedia;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAOUnidadeMedia extends ConexaoMySql {

    /**
    * grava UnidadeMedia
    * @param pModelUnidadeMedia
    * return int
    */
    public int salvarUnidadeMediaDAO(ModelUnidadeMedia pModelUnidadeMedia){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO unidade_medida ("
                    + "abreviacao,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelUnidadeMedia.getAbreviacao() + "',"
                    + "'" + pModelUnidadeMedia.getDescricao() + "'"
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
    * recupera UnidadeMedia
    * @param pCodigo
    * return ModelUnidadeMedia
    */
    public ModelUnidadeMedia getUnidadeMediaDAO(int pCodigo){
        ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "abreviacao,"
                    + "descricao"
                 + " FROM"
                     + " unidade_medida"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUnidadeMedia;
    }
    
    /**
    * recupera UnidadeMedia
    * @param pCodigo
    * return ModelUnidadeMedia
    */
    public ModelUnidadeMedia getUnidadeMediaDAO(String pNome){
        ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "abreviacao,"
                    + "descricao"
                 + " FROM"
                     + " unidade_medida"
                 + " WHERE"
                     + " abreviacao = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUnidadeMedia;
    }

    /**
    * recupera uma lista de UnidadeMedia
        * return ArrayList
    */
    public ArrayList<ModelUnidadeMedia> getListaUnidadeMediaDAO(){
        ArrayList<ModelUnidadeMedia> listamodelUnidadeMedia = new ArrayList();
        ModelUnidadeMedia modelUnidadeMedia = new ModelUnidadeMedia();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "abreviacao,"
                    + "descricao"
                 + " FROM"
                     + " unidade_medida"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeMedia = new ModelUnidadeMedia();
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
                listamodelUnidadeMedia.add(modelUnidadeMedia);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUnidadeMedia;
    }

    /**
    * atualiza UnidadeMedia
    * @param pModelUnidadeMedia
    * return boolean
    */
    public boolean atualizarUnidadeMediaDAO(ModelUnidadeMedia pModelUnidadeMedia){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE unidade_medida SET "
                    + "codigo = '" + pModelUnidadeMedia.getCodigo() + "',"
                    + "abreviacao = '" + pModelUnidadeMedia.getAbreviacao() + "',"
                    + "descricao = '" + pModelUnidadeMedia.getDescricao() + "'"
                + " WHERE "
                    + "codigo = '" + pModelUnidadeMedia.getCodigo() + "'"
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
    * exclui UnidadeMedia
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUnidadeMediaDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM unidade_medida "
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