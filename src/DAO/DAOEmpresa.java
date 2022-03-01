package DAO;

import model.ModelEmpresa;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCidade;
import model.ModelEmpresaCidadeEstado;
import model.ModelEstado;

/**
 *
 * @author BLSoft Desenvolvimento de Sistemas
 */
public class DAOEmpresa extends ConexaoMySql {

    /**
     * grava Empresa
     *
     * @param pModelEmpresa return int
     */
    public int salvarEmpresaDAO(ModelEmpresa pModelEmpresa) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO empresa ("
                    + "codigo,"
                    + "razao_social,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "endereco_numero,"
                    + "complemento,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_estado,"
                    + "cod_pais,"
                    + "cep,"
                    + "telefone, "
                    + "isnc_estad, "
                    + "cnpj, "
                    + "logomarca, "
                    + "crt "
                    + ") VALUES ("
                    + "'" + pModelEmpresa.getCodigo() + "',"
                    + "'" + pModelEmpresa.getRazaoSocial() + "',"
                    + "'" + pModelEmpresa.getNomeFantasia() + "',"
                    + "'" + pModelEmpresa.getEndereco() + "',"
                    + "'" + pModelEmpresa.getEnderecoNumero() + "',"
                    + "'" + pModelEmpresa.getEnderecoComplemento() + "',"
                    + "'" + pModelEmpresa.getBairro() + "',"
                    + "'" + pModelEmpresa.getCodCidade() + "',"
                    + "'" + pModelEmpresa.getCodEstado() + "',"
                    + "'" + pModelEmpresa.getCodPais() + "',"
                    + "'" + pModelEmpresa.getCep() + "',"
                    + "'" + pModelEmpresa.getTelefone() + "',"
                    + "'" + pModelEmpresa.getInscEstad() + "',"
                    + "'" + pModelEmpresa.getCnpj() + "'"
                    + "'" + pModelEmpresa.getLogomarca() + "'"
                    + "'" + pModelEmpresa.getCrt() + "'"
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
     * recupera Empresa
     *
     * @param pCodigo return ModelEmpresa
     */
    public ModelEmpresaCidadeEstado getEmpresaDAO(int pCodigo) {
        ModelEmpresaCidadeEstado modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "     empresa.codigo AS empresa_codigo, "
                    + "     empresa.razao_social AS empresa_razao_social, "
                    + "     empresa.nome_fantasia AS empresa_nome_fantasia, "
                    + "     empresa.endereco AS empresa_endereco, "
                    + "     empresa.endereco_numero AS empresa_endereco_numero, "
                    + "     empresa.complemento AS empresa_complemento, "
                    + "     empresa.bairro AS empresa_bairro, "
                    + "     empresa.cod_pais AS empresa_cod_pais, "
                    + "     empresa.cep AS empresa_cep, "
                    + "     empresa.telefone AS empresa_telefone, "
                    + "     empresa.insc_estad AS empresa_isnc_estad, "
                    + "     empresa.cnpj AS empresa_cnpj, "
                    + "     empresa.crt AS empresa_crt, "
                    + "     empresa.logomarca AS empresa_logomarca, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + "FROM "
                    + "     cidade cidade INNER JOIN empresa empresa ON cidade.codigo = empresa.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + " WHERE "
                    + " empresa.codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelEmpresa = new ModelEmpresa();
                modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setEnderecoNumero(this.getResultSet().getString(5));
                modelEmpresa.setEnderecoComplemento(this.getResultSet().getString(6));
                modelEmpresa.setBairro(this.getResultSet().getString(7));
                modelEmpresa.setCodPais(this.getResultSet().getInt(8));
                modelEmpresa.setCep(this.getResultSet().getString(9));
                modelEmpresa.setTelefone(this.getResultSet().getString(10));
                modelEmpresa.setInscEstad(this.getResultSet().getString(11));
                modelEmpresa.setCnpj(this.getResultSet().getString(12));
                modelEmpresa.setCrt(this.getResultSet().getString(13));
                modelEmpresa.setLogomarca(this.getResultSet().getString(14));
                modelCidade.setNome(this.getResultSet().getString(15));
                modelEstado.setUf(this.getResultSet().getString(16));
                modelEmpresaCidadeEstado.setModelCidade(modelCidade);
                modelEmpresaCidadeEstado.setModelEstado(modelEstado);
                modelEmpresaCidadeEstado.setModelEmpresa(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEmpresaCidadeEstado;
    }
    
    /**
     * recupera Empresa
     * @param pNome
     * @return ModelEmpresaCidadeEstado
     */
    public ModelEmpresaCidadeEstado getEmpresaDAO(String pNome) {
        ModelEmpresaCidadeEstado modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
        ModelCidade modelCidade = new ModelCidade();
        ModelEstado modelEstado = new ModelEstado();
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "     empresa.codigo AS empresa_codigo, "
                    + "     empresa.razao_social AS empresa_razao_social, "
                    + "     empresa.nome_fantasia AS empresa_nome_fantasia, "
                    + "     empresa.endereco AS empresa_endereco, "
                    + "     empresa.endereco_numero AS empresa_endereco_numero, "
                    + "     empresa.complemento AS empresa_complemento, "
                    + "     empresa.bairro AS empresa_bairro, "
                    + "     empresa.cod_pais AS empresa_cod_pais, "
                    + "     empresa.cep AS empresa_cep, "
                    + "     empresa.telefone AS empresa_telefone, "
                    + "     empresa.insc_estad AS empresa_isnc_estad, "
                    + "     empresa.cnpj AS empresa_cnpj, "
                    + "     empresa.crt AS empresa_crt, "
                    + "     empresa.logomarca AS empresa_logomarca, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + "FROM "
                    + "     cidade cidade INNER JOIN empresa empresa ON cidade.codigo = empresa.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + " WHERE "
                    + " empresa.razao_social = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelEmpresa = new ModelEmpresa();
                modelEmpresaCidadeEstado = new ModelEmpresaCidadeEstado();
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setEnderecoNumero(this.getResultSet().getString(5));
                modelEmpresa.setEnderecoComplemento(this.getResultSet().getString(6));
                modelEmpresa.setBairro(this.getResultSet().getString(7));
                modelEmpresa.setCodPais(this.getResultSet().getInt(8));
                modelEmpresa.setCep(this.getResultSet().getString(9));
                modelEmpresa.setTelefone(this.getResultSet().getString(10));
                modelEmpresa.setInscEstad(this.getResultSet().getString(11));
                modelEmpresa.setCnpj(this.getResultSet().getString(12));
                modelEmpresa.setCrt(this.getResultSet().getString(13));
                modelEmpresa.setLogomarca(this.getResultSet().getString(14));
                modelCidade.setNome(this.getResultSet().getString(15));
                modelEstado.setUf(this.getResultSet().getString(16));
                modelEmpresaCidadeEstado.setModelCidade(modelCidade);
                modelEmpresaCidadeEstado.setModelEstado(modelEstado);
                modelEmpresaCidadeEstado.setModelEmpresa(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEmpresaCidadeEstado;
    }

    /**
     * recupera uma lista de Empresa return ArrayList
     */
    public ArrayList<ModelEmpresa> getListaEmpresaDAO() {
        ArrayList<ModelEmpresa> listamodelEmpresa = new ArrayList();
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "razao_social,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "endereco_numero,"
                    + "complemento,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_pais,"
                    + "cep,"
                    + "telefone, "
                    + "insc_estad, "
                    + "cnpj, "
                    + "logomarca, "
                    + "crt "
                    + " FROM"
                    + " empresa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEmpresa = new ModelEmpresa();
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setEnderecoNumero(this.getResultSet().getString(5));
                modelEmpresa.setEnderecoComplemento(this.getResultSet().getString(6));
                modelEmpresa.setBairro(this.getResultSet().getString(7));
                modelEmpresa.setCodCidade(this.getResultSet().getInt(8));
                modelEmpresa.setCodPais(this.getResultSet().getInt(9));
                modelEmpresa.setCep(this.getResultSet().getString(10));
                modelEmpresa.setTelefone(this.getResultSet().getString(11));
                modelEmpresa.setInscEstad(this.getResultSet().getString(12));
                modelEmpresa.setCnpj(this.getResultSet().getString(13));
                modelEmpresa.setLogomarca(this.getResultSet().getString(14));
                modelEmpresa.setCrt(this.getResultSet().getString(15));
                listamodelEmpresa.add(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelEmpresa;
    }

    /**
     * atualiza Empresa
     *
     * @param pModelEmpresa return boolean
     */
    public boolean atualizarEmpresaDAO(ModelEmpresa pModelEmpresa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE empresa SET "
                    + "razao_social = '" + pModelEmpresa.getRazaoSocial() + "',"
                    + "nome_fantasia = '" + pModelEmpresa.getNomeFantasia() + "',"
                    + "endereco = '" + pModelEmpresa.getEndereco() + "',"
                    + "endereco_numero = '" + pModelEmpresa.getEnderecoNumero() + "',"
                    + "complemento = '" + pModelEmpresa.getEnderecoComplemento() + "',"
                    + "bairro = '" + pModelEmpresa.getBairro() + "',"
                    + "cod_cidade = '" + pModelEmpresa.getCodCidade() + "',"
                    + "cod_pais = '" + pModelEmpresa.getCodPais() + "',"
                    + "cep = '" + pModelEmpresa.getCep() + "',"
                    + "telefone = '" + pModelEmpresa.getTelefone() + "',"
                    + "cnpj = '" + pModelEmpresa.getCnpj() + "',"
                    + "insc_estad = '" + pModelEmpresa.getInscEstad() + "',"
                    + "logomarca = '" + pModelEmpresa.getLogomarca() + "',"
                    + "crt = '" + pModelEmpresa.getCrt() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelEmpresa.getCodigo() + "'"
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
     * exclui Empresa
     *
     * @param pCodigo return boolean
     */
    public boolean excluirEmpresaDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM empresa "
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
