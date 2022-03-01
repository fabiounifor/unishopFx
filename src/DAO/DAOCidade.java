package DAO;

import model.ModelCidade;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author BLSoft Desenvolvimento de Sistemas
 */
public class DAOCidade extends ConexaoMySql {

    /**
     * grava Cidade
     *
     * @param pModelCidade return int
     */
    public int salvarCidadeDAO(ModelCidade pModelCidade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cidade ("
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + ") VALUES ("
                    + "'" + pModelCidade.getCodigoIBGE() + "',"
                    + "'" + pModelCidade.getNome() + "',"
                    + "'" + pModelCidade.getFk_cod_estado() + "'"
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
     * recupera Cidade
     *
     * @param pCodigo return ModelCidade
     */
    public ModelCidade getCidadeDAO(int pCodigo) {
        ModelCidade modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "fk_cod_estado,"
                    + "codigo_ibge"
                    + " FROM"
                    + " cidade"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCidade;
    }

    /**
     * recupera Cidade
     *
     * @param pNome return ModelCidade
     */
    public ModelCidade getCidadeDAO(String pNome) {
        ModelCidade modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + " FROM"
                    + " cidade"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCidade;
    }

    /**
     * recupera uma lista de Cidade return ArrayList
     */
    public ArrayList<ModelCidade> getListaCidadeDAO() {
        ArrayList<ModelCidade> listamodelCidade = new ArrayList();
        ModelCidade modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + " FROM"
                    + " cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
                listamodelCidade.add(modelCidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCidade;
    }

    /**
     * recupera uma lista de Cidade return ArrayList
     */
    public ArrayList<ModelCidade> getListaCidadePorEstadoDAO(int pCodigoEstado) {
        ArrayList<ModelCidade> listamodelCidade = new ArrayList();
        ModelCidade modelCidade = new ModelCidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + " FROM"
                    + " cidade"
                    + " where fk_cod_estado = '" + pCodigoEstado + "' ORDER BY nome;"
            );

            while (this.getResultSet().next()) {
                modelCidade = new ModelCidade();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
                listamodelCidade.add(modelCidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCidade;
    }

    /**
     * atualiza Cidade
     *
     * @param pModelCidade return boolean
     */
    public boolean atualizarCidadeDAO(ModelCidade pModelCidade) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cidade SET "
                    + "codigo_ibge = '" + pModelCidade.getCodigoIBGE() + "',"
                    + "nome = '" + pModelCidade.getNome() + "',"
                    + "fk_cod_estado = '" + pModelCidade.getFk_cod_estado() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelCidade.getCodigo() + "'"
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
     * exclui Cidade
     *
     * @param pCodigo return boolean
     */
    public boolean excluirCidadeDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cidade "
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
