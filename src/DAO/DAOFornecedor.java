package DAO;

import conexoes.ConexaoMySql;
import model.ModelFornecedor;
import java.util.ArrayList;

/**
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class DAOFornecedor extends ConexaoMySql {

    /**
     * grava Fornecedor
     *
     * @param pModelFornecedor return int
     */
    public int salvarFornecedorDAO(ModelFornecedor pModelFornecedor) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO fornecedores ("
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_estado,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad,"
                    + "numero,"
                    + "email,"
                    + "referencia"
                    + ") VALUES ("
                    + "'" + pModelFornecedor.getNome() + "',"
                    + "'" + pModelFornecedor.getEndereco() + "',"
                    + "'" + pModelFornecedor.getBairro() + "',"
                    + "'" + pModelFornecedor.getCodCidade() + "',"
                    + "'" + pModelFornecedor.getCodEstado()+ "',"
                    + "'" + pModelFornecedor.getCep() + "',"
                    + "'" + pModelFornecedor.getTelefone() + "',"
                    + "'" + pModelFornecedor.getNomeFantasia() + "',"
                    + "'" + pModelFornecedor.getCnpj() + "',"
                    + "'" + pModelFornecedor.getInscEstadual() + "',"
                    + "'" + pModelFornecedor.getNumero()+ "',"
                    + "'" + pModelFornecedor.getEmail()+ "',"
                    + "'" + pModelFornecedor.getReferencia()+ "'"
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
     * recupera Fornecedor
     *
     * @param pCodigo return ModelFornecedor
     */
    public ModelFornecedor getFornecedorDAO(int pCodigo) {
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_estado,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad,"
                    + "numero,"
                    + "email,"
                    + "referencia"
                    + " FROM"
                    + " fornecedores"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(9));
                modelFornecedor.setCnpj(this.getResultSet().getString(10));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(11));
                modelFornecedor.setNumero(this.getResultSet().getInt(12));
                modelFornecedor.setEmail(this.getResultSet().getString(13));
                modelFornecedor.setReferencia(this.getResultSet().getString(14));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera Fornecedor
     *
     * @param pCodigoProduto return ModelFornecedor
     */
    public ModelFornecedor getFornecedorProdutoDAO(int pCodigoProduto) {
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "fornecedores.codigo, "
                    + "fornecedores.nome, "
                    + "fornecedores.endereco, "
                    + "fornecedores.bairro, "
                    + "fornecedores.cod_cidade, "
                    + "fornecedores.cod_estado, "
                    + "fornecedores.cep, "
                    + "fornecedores.telefone,"
                    + "fornecedores.nome_fantasia,"
                    + "fornecedores.cnpj,"
                    + "fornecedores.insc_estad "
                    + "fornecedores.numero "
                    + "fornecedores.email "
                    + "fornecedores.referencia "
                    + "FROM fornecedores INNER JOIN produtos "
                    + "ON produtos.fornecedores_codigo = fornecedores.codigo "
                    + "WHERE produtos.codigo =  '" + pCodigoProduto + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(9));
                modelFornecedor.setCnpj(this.getResultSet().getString(10));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(11));
                modelFornecedor.setNumero(this.getResultSet().getInt(12));
                modelFornecedor.setEmail(this.getResultSet().getString(13));
                modelFornecedor.setReferencia(this.getResultSet().getString(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera Fornecedor
     *
     * @param pNome return ModelFornecedor
     */
    public ModelFornecedor getFornecedorDAO(String pNome) {
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_estado,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad,"
                    + "numero,"
                    + "email,"
                    + "referencia"
                    + " FROM"
                    + " fornecedores"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(9));
                modelFornecedor.setCnpj(this.getResultSet().getString(10));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(11));
                modelFornecedor.setNumero(this.getResultSet().getInt(12));
                modelFornecedor.setEmail(this.getResultSet().getString(13));
                modelFornecedor.setReferencia(this.getResultSet().getString(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera uma lista de Fornecedor return ArrayList
     */
    public ArrayList<ModelFornecedor> getListaFornecedorDAO() {
        ArrayList<ModelFornecedor> listamodelFornecedor = new ArrayList();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_estado,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad,"
                    + "numero,"
                    + "email,"
                    + "referencia"
                    + " FROM"
                    + " fornecedores"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor = new ModelFornecedor();
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(6));
                modelFornecedor.setCep(this.getResultSet().getString(7));
                modelFornecedor.setTelefone(this.getResultSet().getString(8));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(9));
                modelFornecedor.setCnpj(this.getResultSet().getString(10));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(11));
                modelFornecedor.setNumero(this.getResultSet().getInt(12));
                modelFornecedor.setEmail(this.getResultSet().getString(13));
                modelFornecedor.setReferencia(this.getResultSet().getString(14));
                listamodelFornecedor.add(modelFornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelFornecedor;
    }

    /**
     * atualiza Fornecedor
     *
     * @param pModelFornecedor return boolean
     */
    public boolean atualizarFornecedorDAO(ModelFornecedor pModelFornecedor) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE fornecedores SET "
                    + "codigo = '" + pModelFornecedor.getCodigo() + "',"
                    + "nome = '" + pModelFornecedor.getNome() + "',"
                    + "endereco = '" + pModelFornecedor.getEndereco() + "',"
                    + "bairro = '" + pModelFornecedor.getBairro() + "',"
                    + "cod_cidade = '" + pModelFornecedor.getCodCidade() + "',"
                    + "cod_estado = '" + pModelFornecedor.getCodEstado() + "',"
                    + "cep = '" + pModelFornecedor.getCep() + "',"
                    + "telefone = '" + pModelFornecedor.getTelefone() + "',"
                    + "nome_fantasia = '" + pModelFornecedor.getNomeFantasia()+ "',"
                    + "cnpj = '" + pModelFornecedor.getCnpj()+ "',"
                    + "insc_estad = '" + pModelFornecedor.getInscEstadual()+ "',"
                    + "numero = '" + pModelFornecedor.getNumero()+ "',"
                    + "email = '" + pModelFornecedor.getEmail()+ "',"
                    + "referencia = '" + pModelFornecedor.getReferencia()+ "'"
                            
                    + " WHERE "
                    + "codigo = '" + pModelFornecedor.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Fornecedor
     *
     * @param pCodigo return boolean
     */
    public boolean excluirFornecedorDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM fornecedores "
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
