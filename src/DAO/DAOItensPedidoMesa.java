package DAO;

import model.ModelItensPedidoMesa;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author BLSoft
 */
public class DAOItensPedidoMesa extends ConexaoMySql {
    
    /**
     * exclui ItensPedidoMesa
     *
     * @param pCodigo return boolean
     * @param pMesa return boolean
     * @return 
     */
    public boolean excluirItemUnicoPedidoMesaDAO(int pCodigo, int pMesa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM itens_pedido_mesa "
                    + " WHERE "
                    + "codigo_produto = '" + pCodigo + "'" + "&&" + "codigo_mesa = '" + pMesa + "'"
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
     * grava ItensPedidoMesa
     *
     * @param pModelItensPedidoMesa return int
     */
    public int salvarItensPedidoMesaDAO(ModelItensPedidoMesa pModelItensPedidoMesa) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO itens_pedido_mesa ("
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "codigo_garcom,"
                    + "status_pedido,"
                    + "status_notificacao,"
                    + "observacao,"
                    + "opcoes_escolhidas,"
                    + "horario,"
                    + "quantidade "
                    + ") VALUES ("
                    + "'" + pModelItensPedidoMesa.getCodigo() + "',"
                    + "'" + pModelItensPedidoMesa.getCodigoMesa() + "',"
                    + "'" + pModelItensPedidoMesa.getCodigoProduto() + "',"
                    + "'" + pModelItensPedidoMesa.getCodigoGarcom() + "',"
                    + "'" + pModelItensPedidoMesa.getStatusPedido() + "',"
                    + "'" + pModelItensPedidoMesa.getStatusNotificacao()+ "',"
                    + "'" + pModelItensPedidoMesa.getObservacao() + "',"
                    + "'" + pModelItensPedidoMesa.getOpcoesEscolhidas() + "',"
                    + "'" + pModelItensPedidoMesa.getHora() + "',"
                    + "'" + pModelItensPedidoMesa.getQuantidade() + "'"
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
     * recupera ItensPedidoMesa
     *
     * @param pCodigo return ModelItensPedidoMesa
     */
    public ModelItensPedidoMesa getItensPedidoMesaDAO(int pCodigo) {
        ModelItensPedidoMesa modelItensPedidoMesa = new ModelItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "codigo_garcom,"        
                    + "status_pedido,"
                    + "status_notificacao,"
                    + "observacao,"
                    + "opcoes_escolhidas,"
                    + "horario,"
                    + "quantidade"
                    + " FROM"
                    + " itens_pedido_mesa"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setCodigoGarcom(this.getResultSet().getInt(4));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(5));
                modelItensPedidoMesa.setStatusNotificacao(this.getResultSet().getInt(6));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(7));
                modelItensPedidoMesa.setOpcoesEscolhidas(this.getResultSet().getString(8));
                modelItensPedidoMesa.setHora(this.getResultSet().getString(9));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelItensPedidoMesa;
    }
    /**
     * recupera ItensPedidoMesa
     *
     * @param pMesa return ModelItensPedidoMesa
     */
    public ModelItensPedidoMesa getItensPedidoMesaMesaDAO(int pMesa) {
        ModelItensPedidoMesa modelItensPedidoMesa = new ModelItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "codigo_garcom,"        
                    + "status_pedido,"
                    + "status_notificacao,"
                    + "observacao,"
                    + "opcoes_escolhidas,"
                    + "horario,"
                    + "quantidade"
                    + " FROM"
                    + " itens_pedido_mesa"
                    + " WHERE"
                    + " codigo_mesa = '" + pMesa + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setCodigoGarcom(this.getResultSet().getInt(4));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(5));
                modelItensPedidoMesa.setStatusNotificacao(this.getResultSet().getInt(6));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(7));
                modelItensPedidoMesa.setOpcoesEscolhidas(this.getResultSet().getString(8));
                modelItensPedidoMesa.setHora(this.getResultSet().getString(9));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelItensPedidoMesa;
    }
    /**
     * recupera uma lista de ItensPedidoMesa return ArrayList
     */
    public ArrayList<ModelItensPedidoMesa> getListaItensPedidoMesaDAO() {
        ArrayList<ModelItensPedidoMesa> listamodelItensPedidoMesa = new ArrayList();
        ModelItensPedidoMesa modelItensPedidoMesa = new ModelItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "codigo_garcom,"
                    + "status_pedido,"
                    + "status_notificacao,"
                    + "observacao,"
                    + "opcoes_escolhidas,"
                    + "horario,"
                    + "quantidade "
                    + " FROM"
                    + " itens_pedido_mesa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa = new ModelItensPedidoMesa();
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setCodigoGarcom(this.getResultSet().getInt(4));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(5));
                modelItensPedidoMesa.setStatusNotificacao(this.getResultSet().getInt(6));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(7));
                modelItensPedidoMesa.setOpcoesEscolhidas(this.getResultSet().getString(8));
                modelItensPedidoMesa.setHora(this.getResultSet().getString(9));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(10));
                listamodelItensPedidoMesa.add(modelItensPedidoMesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelItensPedidoMesa;
    }

    /**
     * retorna uma lista de mesas ocupadas sem repetir
     */
    public ArrayList<Integer> getListaMesasOcupadasDAO() {
        ArrayList<Integer> listaNumeroMesas = new ArrayList<>();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "codigo_mesa "
                    + " FROM"
                    + " itens_pedido_mesa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                listaNumeroMesas.add(this.getResultSet().getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaNumeroMesas;
    }
    
    /**
     * retorna uma lista de mesas impressas sem repetir
     */
    public ArrayList<Integer> getListaMesasImpressasDAO() {
        ArrayList<Integer> listaNumeroMesas = new ArrayList<>();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "codigo_mesa "
                    + " FROM"
                    + " itens_pedido_mesa"
                    + "WHERE status_notificacao = '1'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                listaNumeroMesas.add(this.getResultSet().getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaNumeroMesas;
    }


    /**
     * recupera uma lista de ItensPedidoMesa return ArrayList
     */
    public ArrayList<ModelItensPedidoMesa> getListaItensPedidoMesaCozinhaDAO() {
        ArrayList<ModelItensPedidoMesa> listamodelItensPedidoMesa = new ArrayList();
        ModelItensPedidoMesa modelItensPedidoMesa = new ModelItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "codigo_garcom,"
                    + "status_pedido,"
                    + "status_notificacao,"
                    + "observacao,"
                    + "opcoes_escolhidas,"
                    + "horario,"
                    + "quantidade "
                    + " FROM"
                    + " itens_pedido_mesa "
                    + "WHERE status_pedido != 'Entregue'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa = new ModelItensPedidoMesa();
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setCodigoGarcom(this.getResultSet().getInt(4));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(5));
                modelItensPedidoMesa.setStatusNotificacao(this.getResultSet().getInt(6));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(7));
                modelItensPedidoMesa.setOpcoesEscolhidas(this.getResultSet().getString(8));
                modelItensPedidoMesa.setHora(this.getResultSet().getString(9));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(10));
                listamodelItensPedidoMesa.add(modelItensPedidoMesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelItensPedidoMesa;
    }

    /**
     * recupera uma lista de ItensPedidoMesa return ArrayList
     */
    public ArrayList<ModelItensPedidoMesa> getListaItensPedidoMesaDAO(int pCodigo) {
        ArrayList<ModelItensPedidoMesa> listamodelItensPedidoMesa = new ArrayList();
        ModelItensPedidoMesa modelItensPedidoMesa = new ModelItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT itens_pedido_mesa.codigo, "
                    + "codigo_mesa, "
                    + "codigo_produto, "
                    + "codigo_garcom, "
                    + "status_pedido, "
                    + "status_notificacao, "
                    + "observacao, "
                    + "opcoes_escolhidas, "
                    + "horario, "
                    + "quantidade "
                    + "FROM itens_pedido_mesa "
                    + "where codigo_mesa = '" + pCodigo + "'"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa = new ModelItensPedidoMesa();
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setCodigoGarcom(this.getResultSet().getInt(4));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(5));
                modelItensPedidoMesa.setStatusNotificacao(this.getResultSet().getInt(6));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(7));
                modelItensPedidoMesa.setOpcoesEscolhidas(this.getResultSet().getString(8));
                modelItensPedidoMesa.setHora(this.getResultSet().getString(9));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(10));
                listamodelItensPedidoMesa.add(modelItensPedidoMesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelItensPedidoMesa;
    }

    /**
     * atualiza ItensPedidoMesa
     *
     * @param pModelItensPedidoMesa return boolean
     */
    public boolean atualizarItensPedidoMesaDAO(ModelItensPedidoMesa pModelItensPedidoMesa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE itens_pedido_mesa SET "
                    + "codigo = '" + pModelItensPedidoMesa.getCodigo() + "',"
                    + "codigo_mesa = '" + pModelItensPedidoMesa.getCodigoMesa() + "',"
                    + "codigo_produto = '" + pModelItensPedidoMesa.getCodigoProduto() + "',"
                    + "codigo_garcom = '" + pModelItensPedidoMesa.getCodigoGarcom() + "',"
                    + "status_pedido = '" + pModelItensPedidoMesa.getStatusPedido() + "',"
                    + "status_notificacao = '" + pModelItensPedidoMesa.getStatusNotificacao() + "',"
                    + "observacao = '" + pModelItensPedidoMesa.getObservacao() + "',"
                    + "opcoes_escolhidas = '" + pModelItensPedidoMesa.getOpcoesEscolhidas()+ "',"
                    + "quantidade = '" + pModelItensPedidoMesa.getQuantidade() + "', "
                    + "horario = '" + pModelItensPedidoMesa.getHora()+ "'"
                    + " WHERE "
                    + "codigo = '" + pModelItensPedidoMesa.getCodigo() + "'"
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
     * atualiza status itens
     *
     * @param pModelItensPedidoMesa return boolean
     */
    public boolean atualizarStatusItemDAO(ModelItensPedidoMesa pModelItensPedidoMesa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE itens_pedido_mesa SET "
                    + "status_pedido = '" + pModelItensPedidoMesa.getStatusPedido() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelItensPedidoMesa.getCodigo() + "'"
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
     * atualiza status itens
     *
     * @param pModelItensPedidoMesa return boolean
     */
    public boolean atualizarStatusImpressoItemDAO(ModelItensPedidoMesa pModelItensPedidoMesa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE itens_pedido_mesa SET "
                    + "status_notificacao = '" + pModelItensPedidoMesa.getStatusNotificacao()+ "'"
                    + " WHERE "
                    + "codigo = '" + pModelItensPedidoMesa.getCodigo() + "'"
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
     * exclui ItensPedidoMesa
     *
     * @param pCodigo return boolean
     */
    public boolean excluirItensPedidoMesaDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM itens_pedido_mesa "
                    + " WHERE "
                    + "codigo_mesa = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean salvarItensPedidoMesaDAO(ArrayList<ModelItensPedidoMesa> pListaModelItensPedidoMesas) {
        try {
            this.conectar();
            int sizeLista = pListaModelItensPedidoMesas.size();
            for (int i = 0; i < sizeLista; i++) {
              
                this.insertSQL(
                        "INSERT INTO itens_pedido_mesa ("
                        + "codigo_mesa,"
                        + "codigo_produto,"
                        + "quantidade, "
                        + "observacao, "
                        + "opcoes_escolhidas,"
                        + "codigo_garcom, "
                        + "status_notificacao, "
                        + "horario, "
                        + "status_pedido "
                        + ") VALUES ("
                        + "'" + pListaModelItensPedidoMesas.get(i).getCodigoMesa() + "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getCodigoProduto() + "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getQuantidade() + "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getObservacao() + "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getOpcoesEscolhidas()+ "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getCodigoGarcom() + "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getStatusNotificacao()+ "',"
                        + "'" + pListaModelItensPedidoMesas.get(i).getHora()+ "', "
                        + "'" + pListaModelItensPedidoMesas.get(i).getStatusPedido()+ "'"
                        + ");"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
