package DAO;

import model.ModelMotorista;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class DAOMotorista extends ConexaoMySql {

    /**
    * grava Motorista
    * @param pModelMotorista
    * return int
    */
    public int salvarMotoristaDAO(ModelMotorista pModelMotorista){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO motorista ("
                    + "nome,"
                    + "telefone,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "cod_cidade"
                + ") VALUES ("
                    + "'" + pModelMotorista.getNome() + "',"
                    + "'" + pModelMotorista.getTelefone()+ "',"
                    + "'" + pModelMotorista.getEndereco()+ "',"
                    + "'" + pModelMotorista.getBairro()+ "',"
                    + "'" + pModelMotorista.getCep()+ "',"
                    + "'" + pModelMotorista.getCod_cidade()+ "'"
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
    * recupera Motorista
    * @param pCodigo
    * return ModelMotorista
    */
    public ModelMotorista getMotoristaDAO(int pCodigo){
        ModelMotorista modelMotorista = new ModelMotorista();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "telefone,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "cod_cidade"
                 + " FROM"
                     + " motorista"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotorista.setCodigo(this.getResultSet().getInt(1));
                modelMotorista.setNome(this.getResultSet().getString(2));
                modelMotorista.setTelefone(this.getResultSet().getString(3));
                modelMotorista.setEndereco(this.getResultSet().getString(4));
                modelMotorista.setBairro(this.getResultSet().getString(5));
                modelMotorista.setCep(this.getResultSet().getString(6));
                modelMotorista.setCod_cidade(this.getResultSet().getInt(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelMotorista;
    }
    
    /**
    * recupera Motorista
    * @param pCodigo
    * return ModelMotorista
    */
    public ModelMotorista getMotoristaDAO(String pNome){
        ModelMotorista modelMotorista = new ModelMotorista();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "telefone,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "cod_cidade"
                 + " FROM"
                     + " motorista"
                 + " WHERE"
                     + " nome = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotorista.setCodigo(this.getResultSet().getInt(1));
                modelMotorista.setNome(this.getResultSet().getString(2));
                modelMotorista.setTelefone(this.getResultSet().getString(3));
                modelMotorista.setEndereco(this.getResultSet().getString(4));
                modelMotorista.setBairro(this.getResultSet().getString(5));
                modelMotorista.setCep(this.getResultSet().getString(6));
                modelMotorista.setCod_cidade(this.getResultSet().getInt(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelMotorista;
    }

    /**
    * recupera uma lista de Motorista
        * return ArrayList
    */
    public ArrayList<ModelMotorista> getListaMotoristaDAO(){
        ArrayList<ModelMotorista> listamodelMotorista = new ArrayList();
        ModelMotorista modelMotorista = new ModelMotorista();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "telefone,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "cod_cidade"
                 + " FROM"
                     + " unidade_medida"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotorista = new ModelMotorista();
                modelMotorista.setCodigo(this.getResultSet().getInt(1));
                modelMotorista.setNome(this.getResultSet().getString(2));
                modelMotorista.setTelefone(this.getResultSet().getString(3));
                modelMotorista.setEndereco(this.getResultSet().getString(4));
                modelMotorista.setBairro(this.getResultSet().getString(5));
                modelMotorista.setCep(this.getResultSet().getString(6));
                modelMotorista.setCod_cidade(this.getResultSet().getInt(7));
                listamodelMotorista.add(modelMotorista);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelMotorista;
    }

    /**
    * atualiza Motorista
    * @param pModelMotorista
    * return boolean
    */
    public boolean atualizarMotoristaDAO(ModelMotorista pModelMotorista){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE unidade_medida SET "
                    + "codigo = '" + pModelMotorista.getCodigo() + "',"
                    + "nome = '" + pModelMotorista.getNome()+ "',"
                    + "telefone = '" + pModelMotorista.getTelefone()+ "',"
                    + "endereco = '" + pModelMotorista.getEndereco()+ "',"
                    + "bairro = '" + pModelMotorista.getBairro()+ "',"
                    + "cep = '" + pModelMotorista.getCep()+ "',"
                    + "cod_cidade = '" + pModelMotorista.getCod_cidade()+ "'"
                + " WHERE "
                    + "codigo = '" + pModelMotorista.getCodigo() + "'"
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
    * exclui Motorista
    * @param pCodigo
    * return boolean
    */
    public boolean excluirMotoristaDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM motorista "
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