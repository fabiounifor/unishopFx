package DAO;

import model.ModelPisCofins;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOPisCofins extends ConexaoMySql {

    /**
    * grava Piscofins
    * @param pModelCFOP
    * return int
    */
    public int salvarPisCofinsDAO(ModelPisCofins pModelPisCofins){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO piscofins_modelo ("
                    + "descricao,"
                    + "pis_entrada,"
                    + "pis_saida,"
                    + "cofins_entrada,"
                    + "cofins_saida"
                + ") VALUES ("
                    + "'" + pModelPisCofins.getDescricao() + "',"
                    + "'" + pModelPisCofins.getPisEntrada()+ "',"
                    + "'" + pModelPisCofins.getPisSaida() + "',"
                    + "'" + pModelPisCofins.getCofinsEntrada() + "',"
                    + "'" + pModelPisCofins.getPisSaida() + "'"
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
    * recupera Piscofins
    * @param pCodigo
    * return ModelPiscofins
    */
    public ModelPisCofins getPisCofinsDAO(int pCodigo){
        ModelPisCofins modelPisCofins = new ModelPisCofins();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "pis_entrada,"
                    + "pis_saida,"
                    + "cofins_entrada,"
                    + "cofins_saida"
                 + " FROM"
                     + " piscofins_modelo"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPisCofins.setCodigo(this.getResultSet().getInt(1));
                modelPisCofins.setDescricao(this.getResultSet().getString(2));
                modelPisCofins.setPisEntrada(this.getResultSet().getInt(3));
                modelPisCofins.setPisSaida(this.getResultSet().getInt(4));
                modelPisCofins.setCofinsEntrada(this.getResultSet().getInt(5));
                modelPisCofins.setCofinsSaida(this.getResultSet().getInt(6));
                }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelPisCofins;
    }

    /**
    * recupera uma lista de Piscofins
        * return ArrayList
    */
    public ArrayList<ModelPisCofins> getListaPisCofinsDAO(){
        ArrayList<ModelPisCofins> listamodelModelPisCofins = new ArrayList();
        ModelPisCofins modelPisCofins = new ModelPisCofins();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "pis_entrada,"
                    + "pis_saida,"
                    + "cofins_entrada,"
                    + "cofins_saida"
                 + " FROM"
                     + " piscofins_modelo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPisCofins = new ModelPisCofins();
                modelPisCofins.setCodigo(this.getResultSet().getInt(1));
                modelPisCofins.setDescricao(this.getResultSet().getString(2));
                modelPisCofins.setPisEntrada(this.getResultSet().getInt(3));
                modelPisCofins.setPisSaida(this.getResultSet().getInt(4));
                modelPisCofins.setCofinsEntrada(this.getResultSet().getInt(5));
                modelPisCofins.setCofinsSaida(this.getResultSet().getInt(6));
                listamodelModelPisCofins.add(modelPisCofins);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelModelPisCofins;
    }

    /**
    * atualiza PisCofins
    * @param pModelPisCofins
    * return boolean
    */
    public boolean atualizarPisCofinsDAO(ModelPisCofins pModelPisCofins){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE piscofins_modelo SET "
                    + "codigo = '" + pModelPisCofins.getCodigo() + "',"
                    + "descricao = '" + pModelPisCofins.getDescricao() + "',"
                    + "pis_entrada = '" + pModelPisCofins.getPisEntrada() + "',"
                    + "pis_saida = '" + pModelPisCofins.getPisSaida() + "',"
                    + "cofins_entrada = '" + pModelPisCofins.getCofinsEntrada() + "',"
                    + "cofins_saida = '" + pModelPisCofins.getCofinsSaida() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelPisCofins.getCodigo() + "'"
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
    * exclui PisCofins
    * @param pCodigo
    * return boolean
    */
    public boolean excluirPisCofinsDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM piscofins_modelo "
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