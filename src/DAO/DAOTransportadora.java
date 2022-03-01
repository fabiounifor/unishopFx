package DAO;

import model.ModelTransportadora;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro
*/
public class DAOTransportadora extends ConexaoMySql {

    /**
    * grava Transportadora
    * @param pModelTransportadora
    * return int
    */
    public int salvarTransportadoraDAO(ModelTransportadora pModelTransportadora){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO  transportadora ("
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "telefone,"
                    + "cod_cidade,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                + ") VALUES ("
                    + "'" + pModelTransportadora.getCodigo() + "',"
                    + "'" + pModelTransportadora.getNome() + "',"
                    + "'" + pModelTransportadora.getEndereco() + "',"
                    + "'" + pModelTransportadora.getBairro() + "',"
                    + "'" + pModelTransportadora.getCep() + "',"
                    + "'" + pModelTransportadora.getTelefone() + "',"
                    + "'" + pModelTransportadora.getCodCidade() + "',"
                    + "'" + pModelTransportadora.getNomeFantasia() + "',"
                    + "'" + pModelTransportadora.getCnpj() + "',"
                    + "'" + pModelTransportadora.getInscEstad() + "'"
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
    * recupera Transportadora
    * @param pCodigo
    * return ModelTransportadora
    */
    public ModelTransportadora getTransportadoraDAO(int pCodigo){
        ModelTransportadora modelTransportadora = new ModelTransportadora();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "telefone,"
                    + "cod_cidade,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                 + " FROM"
                     + "  transportadora"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTransportadora.setCodigo(this.getResultSet().getInt(1));
                modelTransportadora.setNome(this.getResultSet().getString(2));
                modelTransportadora.setEndereco(this.getResultSet().getString(3));
                modelTransportadora.setBairro(this.getResultSet().getString(4));
                modelTransportadora.setCep(this.getResultSet().getString(5));
                modelTransportadora.setTelefone(this.getResultSet().getString(6));
                modelTransportadora.setCodCidade(this.getResultSet().getInt(7));
                modelTransportadora.setNomeFantasia(this.getResultSet().getString(8));
                modelTransportadora.setCnpj(this.getResultSet().getString(9));
                modelTransportadora.setInscEstad(this.getResultSet().getString(10));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTransportadora;
    }

    /**
    * recupera uma lista de Transportadora
        * return ArrayList
    */
    public ArrayList<ModelTransportadora> getListaTransportadoraDAO(){
        ArrayList<ModelTransportadora> listamodelTransportadora = new ArrayList();
        ModelTransportadora modelTransportadora = new ModelTransportadora();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "telefone,"
                    + "cod_cidade,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                 + " FROM"
                     + "  transportadora"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTransportadora = new ModelTransportadora();
                modelTransportadora.setCodigo(this.getResultSet().getInt(1));
                modelTransportadora.setNome(this.getResultSet().getString(2));
                modelTransportadora.setEndereco(this.getResultSet().getString(3));
                modelTransportadora.setBairro(this.getResultSet().getString(4));
                modelTransportadora.setCep(this.getResultSet().getString(5));
                modelTransportadora.setTelefone(this.getResultSet().getString(6));
                modelTransportadora.setCodCidade(this.getResultSet().getInt(7));
                modelTransportadora.setNomeFantasia(this.getResultSet().getString(8));
                modelTransportadora.setCnpj(this.getResultSet().getString(9));
                modelTransportadora.setInscEstad(this.getResultSet().getString(10));
                listamodelTransportadora.add(modelTransportadora);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelTransportadora;
    }

    /**
    * atualiza Transportadora
    * @param pModelTransportadora
    * return boolean
    */
    public boolean atualizarTransportadoraDAO(ModelTransportadora pModelTransportadora){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE  transportadora SET "
                    + "codigo = '" + pModelTransportadora.getCodigo() + "',"
                    + "nome = '" + pModelTransportadora.getNome() + "',"
                    + "endereco = '" + pModelTransportadora.getEndereco() + "',"
                    + "bairro = '" + pModelTransportadora.getBairro() + "',"
                    + "cep = '" + pModelTransportadora.getCep() + "',"
                    + "telefone = '" + pModelTransportadora.getTelefone() + "',"
                    + "cod_cidade = '" + pModelTransportadora.getCodCidade() + "',"
                    + "nome_fantasia = '" + pModelTransportadora.getNomeFantasia() + "',"
                    + "cnpj = '" + pModelTransportadora.getCnpj() + "',"
                    + "insc_estad = '" + pModelTransportadora.getInscEstad() + "'"
                + " WHERE "
                    + "codigo = '" + pModelTransportadora.getCodigo() + "'"
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
    * exclui Transportadora
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTransportadoraDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM  transportadora "
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