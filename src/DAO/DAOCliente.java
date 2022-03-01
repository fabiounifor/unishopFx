package DAO;

import conexoes.ConexaoMySql;
import model.ModelCliente;
import java.util.ArrayList;

/**
 *
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class DAOCliente extends ConexaoMySql {

    /**
     * grava Cliente
     *
     * @param pModelCliente return int
     */
    public int salvarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO clientes ("
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "celular,"
                    + "cpf_cnpj,"
                    + "inscricao,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa, "
                    + "numero, "
                    + "email, "
                    + "cod_estado, "
                    + "referencia "
                    + ") VALUES ("
                    + "'" + pModelCliente.getNome() + "',"
                    + "'" + pModelCliente.getNomeFantasia() + "',"
                    + "'" + pModelCliente.getEndereco() + "',"
                    + "'" + pModelCliente.getBairro() + "',"
                    + "'" + pModelCliente.getCodCidade() + "',"
                    + "'" + pModelCliente.getCep() + "',"
                    + "'" + pModelCliente.getTelefone() + "',"
                    + "'" + pModelCliente.getCelular() + "',"
                    + "'" + pModelCliente.getCpfCNPJ() + "',"
                    + "'" + pModelCliente.getInscricao()+ "',"
                    + "'" + pModelCliente.getObservacao() + "',"
                    + "'" + pModelCliente.getAtivo() + "',"
                    + "'" + pModelCliente.getTipoPessoa() + "',"
                    + "'" + pModelCliente.getNumero()+ "',"
                    + "'" + pModelCliente.getEmail()+ "',"
                    + "'" + pModelCliente.getCodEstado()+ "',"
                    + "'" + pModelCliente.getReferencia()+ "'"
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
     * recupera Cliente
     *
     * @param pCodigo return ModelCliente
     */
    public ModelCliente getClienteDAO(int pCodigo) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "celular,"
                    + "cpf_cnpj,"
                    + "inscricao,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa, "
                    + "numero, "
                    + "email, "
                    + "cod_estado, "
                    + "referencia "
                    + " FROM"
                    + " clientes"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'" 
                    +  ";"    
                    
            );

            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCelular(this.getResultSet().getString(9));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(10));
                modelCliente.setInscricao(this.getResultSet().getString(11));
                modelCliente.setObservacao(this.getResultSet().getString(12));
                modelCliente.setAtivo(this.getResultSet().getInt(13));
                modelCliente.setTipoPessoa(this.getResultSet().getString(14));
                modelCliente.setNumero(this.getResultSet().getInt(15));
                modelCliente.setEmail(this.getResultSet().getString(16));
                modelCliente.setCodEstado(this.getResultSet().getInt(17));
                modelCliente.setReferencia(this.getResultSet().getString(18));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * recupera Cliente
     *
     * @param pNome return ModelCliente
     */
    public ModelCliente getClienteDAO(String pNome) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "celular,"
                    + "cpf_cnpj,"
                    + "inscricao,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa, "
                    + "numero, "
                    + "email, "
                    + "cod_estado, "
                    + "referencia "
                    + " FROM"
                    + " clientes"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCelular(this.getResultSet().getString(9));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(10));
                modelCliente.setInscricao(this.getResultSet().getString(11));
                modelCliente.setObservacao(this.getResultSet().getString(12));
                modelCliente.setAtivo(this.getResultSet().getInt(13));
                modelCliente.setTipoPessoa(this.getResultSet().getString(14));
                modelCliente.setNumero(this.getResultSet().getInt(15));
                modelCliente.setEmail(this.getResultSet().getString(16));
                modelCliente.setCodEstado(this.getResultSet().getInt(17));
                modelCliente.setReferencia(this.getResultSet().getString(18));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * recupera Cliente
     *
     
     * @param pTelefone return ModelCliente
     */
    public ModelCliente getClienteTelefoneDAO(String pTelefone) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "celular,"
                    + "cpf_cnpj,"
                    + "inscricao,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa, "
                    + "numero, "
                    + "email, "
                    + "cod_estado, "
                    + "referencia "
                    + " FROM"
                    + " clientes"
                    + " WHERE"
                    + " celular = '" + pTelefone + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCelular(this.getResultSet().getString(9));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(10));
                modelCliente.setInscricao(this.getResultSet().getString(11));
                modelCliente.setObservacao(this.getResultSet().getString(12));
                modelCliente.setAtivo(this.getResultSet().getInt(13));
                modelCliente.setTipoPessoa(this.getResultSet().getString(14));
                modelCliente.setNumero(this.getResultSet().getInt(15));
                modelCliente.setEmail(this.getResultSet().getString(16));
                modelCliente.setCodEstado(this.getResultSet().getInt(17));
                modelCliente.setReferencia(this.getResultSet().getString(18));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }
    
    
    /**
     * recupera uma lista de Cliente return ArrayList
     */
    public ArrayList<ModelCliente> getListaClienteDAO() {
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "celular,"
                    + "cpf_cnpj,"
                    + "inscricao,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa, "
                    + "numero, "
                    + "email, "
                    + "cod_estado, "
                    + "referencia "
                    + " FROM"
                    + " clientes"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente();
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCelular(this.getResultSet().getString(9));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(10));
                modelCliente.setInscricao(this.getResultSet().getString(11));
                modelCliente.setObservacao(this.getResultSet().getString(12));
                modelCliente.setAtivo(this.getResultSet().getInt(13));
                modelCliente.setTipoPessoa(this.getResultSet().getString(14));
                modelCliente.setNumero(this.getResultSet().getInt(15));
                modelCliente.setEmail(this.getResultSet().getString(16));
                modelCliente.setCodEstado(this.getResultSet().getInt(17));
                modelCliente.setReferencia(this.getResultSet().getString(18));
                listamodelCliente.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * recupera uma lista de Cliente return ArrayList
     */
    public ArrayList<ModelCliente> getListaClienteAtivoDAO() {
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "celular,"
                    + "cpf_cnpj,"
                    + "inscricao,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa, "
                    + "numero, "
                    + "email, "
                    + "cod_estado, "
                    + "referencia "
                    + " FROM"
                    + " clientes WHERE ativo = 1"
                    + " ORDER BY nome ASC;"
            );

            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente();
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCelular(this.getResultSet().getString(9));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(10));
                modelCliente.setInscricao(this.getResultSet().getString(11));
                modelCliente.setObservacao(this.getResultSet().getString(12));
                modelCliente.setAtivo(this.getResultSet().getInt(13));
                modelCliente.setTipoPessoa(this.getResultSet().getString(14));
                modelCliente.setNumero(this.getResultSet().getInt(15));
                modelCliente.setEmail(this.getResultSet().getString(16));
                modelCliente.setCodEstado(this.getResultSet().getInt(17));
                modelCliente.setReferencia(this.getResultSet().getString(18));
                listamodelCliente.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * atualiza Cliente
     *
     * @param pModelCliente return boolean
     * @return 
     */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE clientes SET "
                    + "nome = '" + pModelCliente.getNome() + "',"
                    + "nome_fantasia = '" + pModelCliente.getNomeFantasia() + "',"
                    + "endereco = '" + pModelCliente.getEndereco() + "',"
                    + "bairro = '" + pModelCliente.getBairro() + "',"
                    + "cod_cidade = '" + pModelCliente.getCodCidade() + "',"
                    + "cep = '" + pModelCliente.getCep() + "',"
                    + "telefone = '" + pModelCliente.getTelefone() + "',"
                    + "celular = '" + pModelCliente.getCelular() + "',"
                    + "cpf_cnpj = '" + pModelCliente.getCpfCNPJ() + "',"
                    + "inscricao = '" + pModelCliente.getInscricao()+ "',"
                    + "observacao = '" + pModelCliente.getObservacao() + "',"
                    + "ativo = '" + pModelCliente.getAtivo() + "',"
                    + "tipo_pessoa = '" + pModelCliente.getTipoPessoa() + "',"
                    + "numero = '" + pModelCliente.getNumero() + "',"
                    + "email = '" + pModelCliente.getEmail()+ "',"        
                    + "cod_estado = '" + pModelCliente.getCodEstado()+ "',"        
                    + "referencia = '" + pModelCliente.getReferencia()+ "'"        
                    + " WHERE "
                    + "codigo = '" + pModelCliente.getCodigo() + "'"
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
     * exclui Cliente
     *
     * @param pCodigo return boolean
     */
    public boolean excluirClienteDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM clientes "
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

    public boolean atualizarEnderecoClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE clientes SET "
                    + "nome = '" + pModelCliente.getNome() + "',"
                    + "endereco = '" + pModelCliente.getEndereco() + "',"
                    + "bairro = '" + pModelCliente.getBairro() + "',"
                    + "cod_cidade = '" + pModelCliente.getCodCidade() + "',"
                    + "cep = '" + pModelCliente.getCep() + "',"
                    + "telefone = '" + pModelCliente.getTelefone() + "',"
                    + "celular = '" + pModelCliente.getCelular() + "',"
                    + "cpf_cnpj = '" + pModelCliente.getCpfCNPJ() + "',"
                    + "inscricao = '" + pModelCliente.getInscricao() + "',"
                    + "observacao = '" + pModelCliente.getObservacao() + "',"
                    + "ativo = '" + pModelCliente.getAtivo() + "',"
                    + "tipo_pessoa = '" + pModelCliente.getTipoPessoa() + "',"
                    + "numero = '" + pModelCliente.getNumero() + "',"
                    + "email = '" + pModelCliente.getEmail()+ "',"        
                    + "cod_estado = '" + pModelCliente.getCodEstado()+ "',"        
                    + "referencia = '" + pModelCliente.getReferencia()+ "'"        
                    + " WHERE "
                    + "codigo = '" + pModelCliente.getCodigo() + "'"
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
}
