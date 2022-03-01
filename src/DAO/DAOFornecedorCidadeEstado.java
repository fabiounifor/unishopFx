package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCidade;
import model.ModelEstado;
import model.ModelFornecedor;
import model.ModelFornecedorCidadeEstado;

/**
 *
 * @author BLSoft Desenvolvimento de Sistemas
 */
public class DAOFornecedorCidadeEstado extends ConexaoMySql {

    /**
     * recupera uma lista de CidadeEstado return ArrayList
     */
    public ArrayList<ModelFornecedorCidadeEstado> getListaFornecedorCidadeEstadoDAO() {
        ArrayList<ModelFornecedorCidadeEstado> listaFornecedorCidadeEstado = new ArrayList();
        ModelFornecedorCidadeEstado modelFornecedorCidadeEstado = new ModelFornecedorCidadeEstado();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
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
                    + "fornecedores.codigo, "
                    + "fornecedores.nome, "
                    + "fornecedores.endereco, "
                    + "fornecedores.bairro, "
                    + "fornecedores.cod_cidade, "
                    + "estado.codigo, "
                    + "fornecedores.cep, "
                    + "fornecedores.telefone,"
                    + "fornecedores.nome_fantasia,"
                    + "fornecedores.cnpj,"
                    + "fornecedores.insc_estad "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join fornecedores on cidade.codigo = fornecedores.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelFornecedor = new ModelFornecedor();
                modelFornecedorCidadeEstado = new ModelFornecedorCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelFornecedor.setCodigo(this.getResultSet().getInt(7));
                modelFornecedor.setNome(this.getResultSet().getString(8));
                modelFornecedor.setEndereco(this.getResultSet().getString(9));
                modelFornecedor.setBairro(this.getResultSet().getString(10));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(11));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(12));
                modelFornecedor.setCep(this.getResultSet().getString(13));
                modelFornecedor.setTelefone(this.getResultSet().getString(14));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(15));
                modelFornecedor.setCnpj(this.getResultSet().getString(16));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(17));

                modelFornecedorCidadeEstado.setModelCidade(modelCidade);
                modelFornecedorCidadeEstado.setModelEstado(modelEstado);
                modelFornecedorCidadeEstado.setModelFornecedor(modelFornecedor);

                listaFornecedorCidadeEstado.add(modelFornecedorCidadeEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaFornecedorCidadeEstado;
    }

}
