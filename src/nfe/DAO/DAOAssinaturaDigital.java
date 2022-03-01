package nfe.DAO;

import nfe.model.ModelAssinaturaDigital;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro
*/
public class DAOAssinaturaDigital extends ConexaoMySql {

    /**
    * grava AssinaturaDigital
    * @param pModelAssinaturaDigital
    * return int
    */
    public int salvarAssinaturaDigitalDAO(ModelAssinaturaDigital pModelAssinaturaDigital){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO pardigital ("
                    + "codigo,"
                    + "empresa,"
                    + "senha_truststore,"
                    + "senha_token,"
                    + "senha_keystore,"
                    + "serie55,"
                    + "serie65,"
                    + "verproc,"
                    + "idtoken,"
                    + "csc,"
                    + "csc_prod"
                + ") VALUES ("
                    + "'" + pModelAssinaturaDigital.getCodigo() + "',"
                    + "'" + pModelAssinaturaDigital.getEmpresa() + "',"
                    + "'" + pModelAssinaturaDigital.getSenhaTruststore() + "',"
                    + "'" + pModelAssinaturaDigital.getSenhaToken() + "',"
                    + "'" + pModelAssinaturaDigital.getSenhaKeystore() + "',"
                    + "'" + pModelAssinaturaDigital.getSerie55() + "',"
                    + "'" + pModelAssinaturaDigital.getSerie65() + "',"
                    + "'" + pModelAssinaturaDigital.getVerproc() + "',"
                    + "'" + pModelAssinaturaDigital.getIdtoken() + "',"
                    + "'" + pModelAssinaturaDigital.getCsc() + "',"
                    + "'" + pModelAssinaturaDigital.getCscProd() + "'"
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
    * recupera AssinaturaDigital
    * @param pCodigo
    * return ModelAssinaturaDigital
    */
    public ModelAssinaturaDigital getAssinaturaDigitalDAO(int pCodigo){
        ModelAssinaturaDigital modelAssinaturaDigital = new ModelAssinaturaDigital();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "empresa,"
                    + "senha_truststore,"
                    + "senha_token,"
                    + "senha_keystore,"
                    + "serie55,"
                    + "serie65,"
                    + "verproc,"
                    + "idtoken,"
                    + "csc,"
                    + "csc_prod"
                 + " FROM"
                     + " pardigital"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAssinaturaDigital.setCodigo(this.getResultSet().getInt(1));
                modelAssinaturaDigital.setEmpresa(this.getResultSet().getInt(2));
                modelAssinaturaDigital.setSenhaTruststore(this.getResultSet().getString(3));
                modelAssinaturaDigital.setSenhaToken(this.getResultSet().getString(4));
                modelAssinaturaDigital.setSenhaKeystore(this.getResultSet().getString(5));
                modelAssinaturaDigital.setSerie55(this.getResultSet().getString(6));
                modelAssinaturaDigital.setSerie65(this.getResultSet().getString(7));
                modelAssinaturaDigital.setVerproc(this.getResultSet().getString(8));
                modelAssinaturaDigital.setIdtoken(this.getResultSet().getString(9));
                modelAssinaturaDigital.setCsc(this.getResultSet().getString(10));
                modelAssinaturaDigital.setCscProd(this.getResultSet().getString(11));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAssinaturaDigital;
    }

    /**
    * recupera uma lista de AssinaturaDigital
        * return ArrayList
    */
    public ArrayList<ModelAssinaturaDigital> getListaAssinaturaDigitalDAO(){
        ArrayList<ModelAssinaturaDigital> listamodelAssinaturaDigital = new ArrayList();
        ModelAssinaturaDigital modelAssinaturaDigital = new ModelAssinaturaDigital();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "empresa,"
                    + "senha_truststore,"
                    + "senha_token,"
                    + "senha_keystore,"
                    + "serie55,"
                    + "serie65,"
                    + "verproc,"
                    + "idtoken,"
                    + "csc,"
                    + "csc_prod"
                 + " FROM"
                     + " pardigital"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAssinaturaDigital = new ModelAssinaturaDigital();
                modelAssinaturaDigital.setCodigo(this.getResultSet().getInt(1));
                modelAssinaturaDigital.setEmpresa(this.getResultSet().getInt(2));
                modelAssinaturaDigital.setSenhaTruststore(this.getResultSet().getString(3));
                modelAssinaturaDigital.setSenhaToken(this.getResultSet().getString(4));
                modelAssinaturaDigital.setSenhaKeystore(this.getResultSet().getString(5));
                modelAssinaturaDigital.setSerie55(this.getResultSet().getString(6));
                modelAssinaturaDigital.setSerie65(this.getResultSet().getString(7));
                modelAssinaturaDigital.setVerproc(this.getResultSet().getString(8));
                modelAssinaturaDigital.setIdtoken(this.getResultSet().getString(9));
                modelAssinaturaDigital.setCsc(this.getResultSet().getString(10));
                modelAssinaturaDigital.setCscProd(this.getResultSet().getString(11));
                listamodelAssinaturaDigital.add(modelAssinaturaDigital);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAssinaturaDigital;
    }

    /**
    * atualiza AssinaturaDigital
    * @param pModelAssinaturaDigital
    * return boolean
    */
    public boolean atualizarAssinaturaDigitalDAO(ModelAssinaturaDigital pModelAssinaturaDigital){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE pardigital SET "
                    + "codigo = '" + pModelAssinaturaDigital.getCodigo() + "',"
                    + "empresa = '" + pModelAssinaturaDigital.getEmpresa() + "',"
                    + "senha_truststore = '" + pModelAssinaturaDigital.getSenhaTruststore() + "',"
                    + "senha_token = '" + pModelAssinaturaDigital.getSenhaToken() + "',"
                    + "senha_keystore = '" + pModelAssinaturaDigital.getSenhaKeystore() + "',"
                    + "serie55 = '" + pModelAssinaturaDigital.getSerie55() + "',"
                    + "serie65 = '" + pModelAssinaturaDigital.getSerie65() + "',"
                    + "verproc = '" + pModelAssinaturaDigital.getVerproc() + "',"
                    + "idtoken = '" + pModelAssinaturaDigital.getIdtoken() + "',"
                    + "csc = '" + pModelAssinaturaDigital.getCsc() + "',"
                    + "csc_prod = '" + pModelAssinaturaDigital.getCscProd() + "'"
                + " WHERE "
                    + "codigo = '" + pModelAssinaturaDigital.getCodigo() + "'"
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
    * exclui AssinaturaDigital
    * @param pCodigo
    * return boolean
    */
    public boolean excluirAssinaturaDigitalDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM pardigital "
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