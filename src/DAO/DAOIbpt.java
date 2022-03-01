package DAO;

import model.ModelIbpt;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro Nazareth
*/
public class DAOIbpt extends ConexaoMySql {

    /**
    * grava IBPT
    * @param pModelCFOP
    * return int
    */
    public int salvarIBPTDAO(ModelIbpt pModelIbpt){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO ibpt ("
                    + "codigoNcm,"
                    + "excecao,"
                    + "tipo,"
                    + "descricao,"
                    + "nacionalfederal,"
                    + "importadosfederal,"
                    + "municipal,"
                    + "estadual,"
                    + "vigenciainicio,"
                    + "vigenciafim,"
                    + "chave,"
                    + "versao,"
                    + "fonte "
                    + ") VALUES ("
                    + "'" + pModelIbpt.getCodigoNcm() + "',"
                    + "'" + pModelIbpt.getExcecao() + "',"
                    + "'" + pModelIbpt.getTipo() + "',"
                    + "'" + pModelIbpt.getDescricao()+ ",'"
                    + "'" + pModelIbpt.getNacionalfederal()+ ",'"
                    + "'" + pModelIbpt.getImportadosfederal()+ ",'"
                    + "'" + pModelIbpt.getMunicipal()+ ",'"
                    + "'" + pModelIbpt.getEstadual()+ ",'"
                    + "'" + pModelIbpt.getVigenciainicio()+ ",'"
                    + "'" + pModelIbpt.getVigenciafim()+ ",'"
                    + "'" + pModelIbpt.getChave()+ ",'"
                    + "'" + pModelIbpt.getVersao()+ ",'"
                    + "'" + pModelIbpt.getFonte()+ "'"
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
    * recupera IBPT
    * @param pCodigo
    * return modelBPT
    */
    public ModelIbpt getIBPTDAO(int pCodigo){
        ModelIbpt modelIbpt = new ModelIbpt();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigoNcm,"
                    + "excecao,"
                    + "tipo,"
                    + "descricao,"
                    + "nacionalfederal,"
                    + "importadosfederal,"
                    + "municipal,"
                    + "estadual,"
                    + "vigenciainicio,"
                    + "vigenciafim,"
                    + "chave,"
                    + "versao,"
                    + "fonte "
                 + " FROM"
                     + " ibpt"
                 + " WHERE"
                     + " codigoNcm = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelIbpt.setCodigoNcm(this.getResultSet().getInt(1));
                modelIbpt.setExcecao(this.getResultSet().getInt(2));
                modelIbpt.setTipo(this.getResultSet().getInt(3));
                modelIbpt.setDescricao(this.getResultSet().getString(4));
                modelIbpt.setNacionalfederal(this.getResultSet().getInt(5));
                modelIbpt.setImportadosfederal(this.getResultSet().getInt(6));
                modelIbpt.setMunicipal(this.getResultSet().getInt(7));
                modelIbpt.setEstadual(this.getResultSet().getInt(8));
                modelIbpt.setVigenciainicio(this.getResultSet().getString(9));
                modelIbpt.setVigenciafim(this.getResultSet().getString(10));
                modelIbpt.setChave(this.getResultSet().getString(11));
                modelIbpt.setVersao(this.getResultSet().getString(12));
                modelIbpt.setFonte(this.getResultSet().getString(13));
                }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelIbpt;
    }

    /**
    * recupera uma lista de IBPT
        * return ArrayList
    */
    public ArrayList<ModelIbpt> getListaIBPTDAO(){
        ArrayList<ModelIbpt> listamodelIBPT = new ArrayList();
        ModelIbpt modelIbpt = new ModelIbpt();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigoNcm,"
                    + "excecao,"
                    + "tipo,"
                    + "descricao,"
                    + "nacionalfederal,"
                    + "importadosfederal,"
                    + "municipal,"
                    + "estadual,"
                    + "vigenciainicio,"
                    + "vigenciafim,"
                    + "chave,"
                    + "versao,"
                    + "fonte "
                 + " FROM"
                     + " ibpt"
                + ";"
            );

            while(this.getResultSet().next()){
                modelIbpt = new ModelIbpt();
                modelIbpt.setCodigoNcm(this.getResultSet().getInt(1));
                modelIbpt.setExcecao(this.getResultSet().getInt(2));
                modelIbpt.setTipo(this.getResultSet().getInt(3));
                modelIbpt.setDescricao(this.getResultSet().getString(4));
                modelIbpt.setNacionalfederal(this.getResultSet().getInt(5));
                modelIbpt.setImportadosfederal(this.getResultSet().getInt(6));
                modelIbpt.setMunicipal(this.getResultSet().getInt(7));
                modelIbpt.setEstadual(this.getResultSet().getInt(8));
                modelIbpt.setVigenciainicio(this.getResultSet().getString(9));
                modelIbpt.setVigenciafim(this.getResultSet().getString(10));
                modelIbpt.setChave(this.getResultSet().getString(11));
                modelIbpt.setVersao(this.getResultSet().getString(12));
                modelIbpt.setFonte(this.getResultSet().getString(13));
                listamodelIBPT.add(modelIbpt);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelIBPT;
    }

    
}