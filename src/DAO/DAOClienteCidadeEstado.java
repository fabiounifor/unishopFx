package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCidade;
import model.ModelCliente;
import model.ModelClienteCidadeEstado;
import model.ModelEstado;

/**
 *
 * @author BLSoft Desenvolvimento de Sistemas
 */
public class DAOClienteCidadeEstado extends ConexaoMySql {

    /**
     * recupera uma lista de CidadeEstado return ArrayList
     */
    public ArrayList<ModelClienteCidadeEstado> getListaClienteCidadeEstadoDAO() {
        ArrayList<ModelClienteCidadeEstado> listaModelClienteCidadeEstados = new ArrayList();
        ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
        ModelCliente modelCliente = new ModelCliente();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelCliente = new ModelCliente();
                modelClienteCidadeEstado = new ModelClienteCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(15));
                modelCliente.setObservacao(this.getResultSet().getString(16));
                modelCliente.setAtivo(this.getResultSet().getInt(17));
                modelCliente.setTipoPessoa(this.getResultSet().getString(18));
                modelCliente.setNomeFantasia(this.getResultSet().getString(19));

                modelClienteCidadeEstado.setModelCidade(modelCidade);
                modelClienteCidadeEstado.setModelEstado(modelEstado);
                modelClienteCidadeEstado.setModelCliente(modelCliente);

                listaModelClienteCidadeEstados.add(modelClienteCidadeEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelClienteCidadeEstados;
    }

    public ModelClienteCidadeEstado getClienteCidadeEstadoDAO(String pNome) {
        ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
        ModelCliente modelCliente = new ModelCliente();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.celular, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.referencia, "
                    + "clientes.inscricao, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelCliente = new ModelCliente();
                modelClienteCidadeEstado = new ModelClienteCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCelular(this.getResultSet().getString(15));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(16));
                modelCliente.setObservacao(this.getResultSet().getString(17));
                modelCliente.setAtivo(this.getResultSet().getInt(18));
                modelCliente.setTipoPessoa(this.getResultSet().getString(19));
                modelCliente.setReferencia(this.getResultSet().getString(20));
                modelCliente.setInscricao(this.getResultSet().getString(21));
                modelCliente.setNomeFantasia(this.getResultSet().getString(22));

                modelClienteCidadeEstado.setModelCidade(modelCidade);
                modelClienteCidadeEstado.setModelEstado(modelEstado);
                modelClienteCidadeEstado.setModelCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }

    public ModelClienteCidadeEstado getClienteCidadeEstadoDAO(int pCodigo) {
        ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
        ModelCliente modelCliente = new ModelCliente();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();

            String sql = "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.celular, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.referencia, "
                    + "clientes.inscricao, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.codigo = '" + pCodigo + "'"
                    + ";";

            this.executarSQL(
                    sql
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelCliente = new ModelCliente();
                modelClienteCidadeEstado = new ModelClienteCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCelular(this.getResultSet().getString(15));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(16));
                modelCliente.setObservacao(this.getResultSet().getString(17));
                modelCliente.setAtivo(this.getResultSet().getInt(18));
                modelCliente.setTipoPessoa(this.getResultSet().getString(19));
                modelCliente.setReferencia(this.getResultSet().getString(20));
                modelCliente.setInscricao(this.getResultSet().getString(21));
                modelCliente.setNomeFantasia(this.getResultSet().getString(22));

                modelClienteCidadeEstado.setModelCidade(modelCidade);
                modelClienteCidadeEstado.setModelEstado(modelEstado);
                modelClienteCidadeEstado.setModelCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }
    
        public ModelClienteCidadeEstado getClienteCidadeEstadoTelefoneDAO(String pTelefone) {
        ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
        ModelCliente modelCliente = new ModelCliente();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();

            String sql = "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.celular, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.referencia, "
                    + "clientes.inscricao, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.celular = '" + pTelefone + "'"
                    + ";";

            this.executarSQL(
                    sql
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelCliente = new ModelCliente();
                modelClienteCidadeEstado = new ModelClienteCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCelular(this.getResultSet().getString(15));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(16));
                modelCliente.setObservacao(this.getResultSet().getString(17));
                modelCliente.setAtivo(this.getResultSet().getInt(18));
                modelCliente.setTipoPessoa(this.getResultSet().getString(19));
                modelCliente.setReferencia(this.getResultSet().getString(20));
                modelCliente.setInscricao(this.getResultSet().getString(21));
                modelCliente.setNomeFantasia(this.getResultSet().getString(22));

                modelClienteCidadeEstado.setModelCidade(modelCidade);
                modelClienteCidadeEstado.setModelEstado(modelEstado);
                modelClienteCidadeEstado.setModelCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }

    public ModelClienteCidadeEstado getClienteCidadeEstadoPorTelefoneDAO(String pTelefone) {
        ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
        ModelCliente modelCliente = new ModelCliente();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.celular, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.referencia, "
                    + "clientes.inscricao, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.celular = '" + pTelefone + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelCliente = new ModelCliente();
                modelClienteCidadeEstado = new ModelClienteCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCelular(this.getResultSet().getString(15));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(16));
                modelCliente.setObservacao(this.getResultSet().getString(17));
                modelCliente.setAtivo(this.getResultSet().getInt(18));
                modelCliente.setTipoPessoa(this.getResultSet().getString(19));
                modelCliente.setReferencia(this.getResultSet().getString(20));
                modelCliente.setInscricao(this.getResultSet().getString(21));
                modelCliente.setNomeFantasia(this.getResultSet().getString(22));

                modelClienteCidadeEstado.setModelCidade(modelCidade);
                modelClienteCidadeEstado.setModelEstado(modelEstado);
                modelClienteCidadeEstado.setModelCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }

}
