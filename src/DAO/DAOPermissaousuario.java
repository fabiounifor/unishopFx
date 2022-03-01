package DAO;

import model.ModelPermissaousuario;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author BLSoft Desenvolvimento de Sistemas
 */
public class DAOPermissaousuario extends ConexaoMySql {

    /**
     * grava Permissaousuario
     *
     * @param pModelPermissaousuario return int
     */
    public int salvarPermissaousuarioDAO(ModelPermissaousuario pModelPermissaousuario) {
        try {
            this.conectar();
            int sizeLista = pModelPermissaousuario.getListaModelPermissaousuarios().size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "INSERT INTO usuario_permissao ("
                        + "fk_codigo_usuario, "
                        + " permissao "
                        + ") VALUES ("
                        + "'" + pModelPermissaousuario.getListaModelPermissaousuarios().get(i).getCodigo_usuario() + "',"
                        + "'" + pModelPermissaousuario.getListaModelPermissaousuarios().get(i).getPermissao() + "'"
                        + ");"
                );
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Permissaousuario
     *
     * @param pCodigo return ModelPermissaousuario
     */
    public ModelPermissaousuario getPermissaousuarioDAO(int pCodigo) {
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + " WHERE"
                    + " pk_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }

    /**
     * verifica permissão de compras
     *
     * @param pCodigoUsuario return ModelPermissaousuario
     */
    public ModelPermissaousuario getPermissaousuarioCodUsuDAO(int pCodigoUsuario) {
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + " WHERE"
                    + " fk_codigo_usuario = '" + pCodigoUsuario + "' and permissao = 'compras'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }
    /**
     * verifica permissão de compras
     *
     * @param pCodigoUsuario return ModelPermissaousuario
     */
    public ModelPermissaousuario getVerificaPermissaoNFeDAO(int pCodigoUsuario) {
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + " WHERE"
                    + " fk_codigo_usuario = '" + pCodigoUsuario + "' and permissao = 'nfe'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }

    /**
     * recupera uma lista de Permissaousuario return ArrayList
     */
    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioDAO() {
        ArrayList<ModelPermissaousuario> listamodelPermissaousuario = new ArrayList();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario = new ModelPermissaousuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }

    /**
     * atualiza Permissaousuario
     *
     * @param pModelPermissaousuario return boolean
     */
    public boolean atualizarPermissaousuarioDAO(ModelPermissaousuario pModelPermissaousuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE usuario_permissao SET "
                    + "pk_codigo = '" + pModelPermissaousuario.getCodigo() + "',"
                    + "fk_codigo_usuario = '" + pModelPermissaousuario.getCodigo_usuario() + "',"
                    + "permissao = '" + pModelPermissaousuario.getPermissao() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pModelPermissaousuario.getCodigo() + "'"
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
     * exclui Permissaousuario
     *
     * @param pCodigo return boolean
     */
    public boolean excluirPermissaousuarioDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM usuario_permissao "
                    + " WHERE "
                    + "fk_codigo_usuario = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioDAO(int pCodigo) {
        ArrayList<ModelPermissaousuario> listamodelPermissaousuario = new ArrayList();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao WHERE fk_codigo_usuario = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario = new ModelPermissaousuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }
}
