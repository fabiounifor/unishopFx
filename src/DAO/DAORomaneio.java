package DAO;

import model.ModelRomaneio;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAORomaneio extends ConexaoMySql {

    /**
    * grava Romaneio
    * @param pModelRomaneio
    * return int
    */
    public int salvarRomaneioDAO(ModelRomaneio pModelRomaneio){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO romaneio ("
                    + "data_hora,"
                    + "carro,"
                    + "motorista"
                + ") VALUES ("
                    + "'" + pModelRomaneio.getData_hora()+ "',"
                    + "'" + pModelRomaneio.getCarro()+ "',"
                    + "'" + pModelRomaneio.getMotorista()+ "'"
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
    * recupera Romaneio
    * @param pCodigo
    * return ModelRomaneio
    */
    public ModelRomaneio getRomaneioDAO(int pCodigo){
        ModelRomaneio modelRomaneio = new ModelRomaneio();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "data_hora,"
                    + "carro,"
                    + "motorista"
                 + " FROM"
                     + " romaneio"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelRomaneio.setCodigo(this.getResultSet().getInt(1));
                modelRomaneio.setData_hora(this.getResultSet().getDate(2));
                modelRomaneio.setCarro(this.getResultSet().getInt(3));
                modelRomaneio.setMotorista(this.getResultSet().getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelRomaneio;
    }
    
    /**
    * recupera Romaneio
    * @param pCodigo
    * return ModelRomaneio
    */
    public ModelRomaneio getRomaneioNomeDAO(String pNome){
        ModelRomaneio modelRomaneio = new ModelRomaneio();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "data_hora,"
                    + "carro,"
                    + "motorista"
                     + " FROM"
                     + " romaneio"
                 + " WHERE"
                     + " descricao = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelRomaneio.setCodigo(this.getResultSet().getInt(1));
                modelRomaneio.setData_hora(this.getResultSet().getDate(2));
                modelRomaneio.setCarro(this.getResultSet().getInt(3));
                modelRomaneio.setMotorista(this.getResultSet().getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelRomaneio;
    }

    /**
    * recupera uma lista de Romaneio
        * return ArrayList
    */
    public ArrayList<ModelRomaneio> getListaRomaneioDAO(){
        ArrayList<ModelRomaneio> listamodelRomaneio = new ArrayList();
        ModelRomaneio modelRomaneio = new ModelRomaneio();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "data_hora,"
                    + "carro,"
                    + "motorista"
                     + " FROM"
                     + " romaneio"
                + ";"
            );

            while(this.getResultSet().next()){
                modelRomaneio = new ModelRomaneio();
                modelRomaneio.setCodigo(this.getResultSet().getInt(1));
                modelRomaneio.setData_hora(this.getResultSet().getDate(2));
                modelRomaneio.setCarro(this.getResultSet().getInt(3));
                modelRomaneio.setMotorista(this.getResultSet().getInt(4));
                listamodelRomaneio.add(modelRomaneio);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelRomaneio;
    }

    /**
    * atualiza Romaneio
    * @param pModelRomaneio
    * return boolean
    */
    public boolean atualizarRomaneioDAO(ModelRomaneio pModelRomaneio){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE romaneio SET "
                    + "codigo = '" + pModelRomaneio.getCodigo() + "',"
                    + "data_hora = '" + pModelRomaneio.getCarro()+ "',"
                    + "carro = '" + pModelRomaneio.getCarro()+ "',"
                    + "motorista = '" + pModelRomaneio.getMotorista()+ "'"
                + " WHERE "
                    + "codigo = '" + pModelRomaneio.getCodigo() + "'"
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
    * exclui Romaneio
    * @param pCodigo
    * return boolean
    */
    public boolean excluirRomaneioDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM romaneio "
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