package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCidade;
import model.ModelEstado;
import model.ModelTransportadora;
import model.ModelTransportadoraCidEst;
/**
*
* @author Leandro
*/
public class DAOTransportadoraCidEst extends ConexaoMySql {

    public ArrayList<ModelTransportadoraCidEst> getListaTransportadoraCidadeEstadoDAO() {
        ArrayList<ModelTransportadoraCidEst> listaFornecedorCidadeEstado = new ArrayList();
        ModelTransportadoraCidEst modelTransportadoraCidadeEstado = new ModelTransportadoraCidEst();
        ModelTransportadora modelTransportadora = new ModelTransportadora();
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
                    + "transportadora.codigo, "
                    + "transportadora.nome, "
                    + "transportadora.endereco, "
                    + "transportadora.bairro, "
                    + "transportadora.cod_cidade, "
                    + "transportadora.cep, "
                    + "transportadora.telefone,"
                    + "transportadora.nome_fantasia,"
                    + "transportadora.cnpj,"
                    + "transportadora.insc_estad "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join transportadora on cidade.codigo = transportadora.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelEstado = new ModelEstado();
                modelTransportadora = new ModelTransportadora();
                modelTransportadoraCidadeEstado = new ModelTransportadoraCidEst();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelTransportadora.setCodigo(this.getResultSet().getInt(7));
                modelTransportadora.setNome(this.getResultSet().getString(8));
                modelTransportadora.setEndereco(this.getResultSet().getString(9));
                modelTransportadora.setBairro(this.getResultSet().getString(10));
                modelTransportadora.setCodCidade(this.getResultSet().getInt(11));
                modelTransportadora.setCep(this.getResultSet().getString(12));
                modelTransportadora.setTelefone(this.getResultSet().getString(13));
                modelTransportadora.setNomeFantasia(this.getResultSet().getString(14));
                modelTransportadora.setCnpj(this.getResultSet().getString(15));
                modelTransportadora.setInscEstad(this.getResultSet().getString(16));

                modelTransportadoraCidadeEstado.setModelCidade(modelCidade);
                modelTransportadoraCidadeEstado.setModelEstado(modelEstado);
                modelTransportadoraCidadeEstado.setModelTransportadora(modelTransportadora);

                listaFornecedorCidadeEstado.add(modelTransportadoraCidadeEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaFornecedorCidadeEstado;
    }
}