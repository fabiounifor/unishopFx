package DAO;

import model.ModelGarcom;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author BLSoft
 */
public class DAOGarcom extends ConexaoMySql {

    /**
     * grava Garcom
     *
     * @param pModelGarcom return int
     */
    public int salvarGarcomDAO(ModelGarcom pModelGarcom) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO garcon ("
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "comissao,"
                    + "senha"
                    + ") VALUES ("
                    + "'" + pModelGarcom.getCodigo() + "',"
                    + "'" + pModelGarcom.getNome() + "',"
                    + "'" + pModelGarcom.getEndereco() + "',"
                    + "'" + pModelGarcom.getBairro() + "',"
                    + "'" + pModelGarcom.getCodCidade() + "',"
                    + "'" + pModelGarcom.getCep() + "',"
                    + "'" + pModelGarcom.getTelefone() + "',"
                    + "'" + pModelGarcom.getComissao() + "',"
                    + "'" + pModelGarcom.getSenha() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Garcom
     *
     * @param pCodigo return ModelGarcom
     */
    public ModelGarcom getGarcomDAO(int pCodigo) {
        ModelGarcom modelGarcom = new ModelGarcom();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "garcon.codigo,"
                    + "garcon.nome,"
                    + "garcon.endereco,"
                    + "garcon.bairro,"
                    + "garcon.cod_cidade,"
                    + "cidade.fk_cod_estado,"
                    + "garcon.cep,"
                    + "garcon.telefone,"
                    + "garcon.comissao,"
                    + "garcon.senha"
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join garcon on cidade.codigo = garcon.cod_cidade"
                    + " WHERE"
                    + " garcon.codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGarcom.setCodigo(this.getResultSet().getInt(1));
                modelGarcom.setNome(this.getResultSet().getString(2));
                modelGarcom.setEndereco(this.getResultSet().getString(3));
                modelGarcom.setBairro(this.getResultSet().getString(4));
                modelGarcom.setCodCidade(this.getResultSet().getInt(5));
                modelGarcom.setCodEstado(this.getResultSet().getInt(6));
                modelGarcom.setCep(this.getResultSet().getString(7));
                modelGarcom.setTelefone(this.getResultSet().getString(8));
                modelGarcom.setComissao(this.getResultSet().getFloat(9));
                modelGarcom.setSenha(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGarcom;
    }
    /**
     * recupera Garcom
     *
     * @param pCodigo return ModelGarcom
     */
    public ModelGarcom getGarcomDAO(String pNome) {
        ModelGarcom modelGarcom = new ModelGarcom();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "garcon.codigo,"
                    + "garcon.nome,"
                    + "garcon.endereco,"
                    + "garcon.bairro,"
                    + "garcon.cod_cidade,"
                    + "cidade.fk_cod_estado,"
                    + "garcon.cep,"
                    + "garcon.telefone,"
                    + "garcon.comissao,"
                    + "garcon.senha"
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join garcon on cidade.codigo = garcon.cod_cidade"
                    + " WHERE"
                    + " garcon.nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGarcom.setCodigo(this.getResultSet().getInt(1));
                modelGarcom.setNome(this.getResultSet().getString(2));
                modelGarcom.setEndereco(this.getResultSet().getString(3));
                modelGarcom.setBairro(this.getResultSet().getString(4));
                modelGarcom.setCodCidade(this.getResultSet().getInt(5));
                modelGarcom.setCodEstado(this.getResultSet().getInt(6));
                modelGarcom.setCep(this.getResultSet().getString(7));
                modelGarcom.setTelefone(this.getResultSet().getString(8));
                modelGarcom.setComissao(this.getResultSet().getFloat(9));
                modelGarcom.setSenha(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGarcom;
    }

    /**
     * recupera uma lista de Garcom return ArrayList
     */
    public ArrayList<ModelGarcom> getListaGarcomDAO() {
        ArrayList<ModelGarcom> listamodelGarcom = new ArrayList();
        ModelGarcom modelGarcom = new ModelGarcom();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "garcon.codigo,"
                    + "garcon.nome,"
                    + "garcon.endereco,"
                    + "garcon.bairro,"
                    + "garcon.cod_cidade,"
                    + "cidade.fk_cod_estado,"
                    + "garcon.cep,"
                    + "garcon.telefone,"
                    + "garcon.comissao,"
                    + "garcon.senha"
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join garcon on cidade.codigo = garcon.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGarcom = new ModelGarcom();
                modelGarcom.setCodigo(this.getResultSet().getInt(1));
                modelGarcom.setNome(this.getResultSet().getString(2));
                modelGarcom.setEndereco(this.getResultSet().getString(3));
                modelGarcom.setBairro(this.getResultSet().getString(4));
                modelGarcom.setCodCidade(this.getResultSet().getInt(5));
                modelGarcom.setCodEstado(this.getResultSet().getInt(6));
                modelGarcom.setCep(this.getResultSet().getString(7));
                modelGarcom.setTelefone(this.getResultSet().getString(8));
                modelGarcom.setComissao(this.getResultSet().getFloat(9));
                modelGarcom.setSenha(this.getResultSet().getString(10));
                listamodelGarcom.add(modelGarcom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelGarcom;
    }

    /**
     * atualiza Garcom
     *
     * @param pModelGarcom return boolean
     */
    public boolean atualizarGarcomDAO(ModelGarcom pModelGarcom) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE garcon SET "
                    + "codigo = '" + pModelGarcom.getCodigo() + "',"
                    + "nome = '" + pModelGarcom.getNome() + "',"
                    + "endereco = '" + pModelGarcom.getEndereco() + "',"
                    + "bairro = '" + pModelGarcom.getBairro() + "',"
                    + "cod_cidade = '" + pModelGarcom.getCodCidade() + "',"
                    + "cep = '" + pModelGarcom.getCep() + "',"
                    + "telefone = '" + pModelGarcom.getTelefone() + "',"
                    + "comissao = '" + pModelGarcom.getComissao() + "',"
                    + "senha = '" + pModelGarcom.getSenha() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelGarcom.getCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Garcom
     *
     * @param pCodigo return boolean
     */
    public boolean excluirGarcomDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM garcon "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
