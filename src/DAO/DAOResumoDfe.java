package DAO;

import model.ModelCFOP;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelDfe;
/**
*
* @author Leandro Nazareth
*/
public class DAOResumoDfe extends ConexaoMySql {

    /**
    * grava CFOP
    * @param pModelCFOP
    * return int
    */
    public int salvarDfeDAO(ModelDfe pModelDfe){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO resumo_dfe ("
                    + "cnpjcpf,"
                    + "nsu,"
                    + "chave_nfe,"
                    + "dhemissao,"
                    + "numeroprotocolo,"
                    + "situacao,"
                    + "valor_total,"
                    + "imagem,"
                    + "fornecedornome"
                + ") VALUES ("
                    + "'" + pModelDfe.getCnpjcpf() + "',"
                    + "'" + pModelDfe.getNsu() + "',"
                    + "'" + pModelDfe.getChavenfe() + "',"
                    + "'" + pModelDfe.getDatahoraemisao() + "',"
                    + "'" + pModelDfe.getProtocolo() + "',"
                    + "'" + pModelDfe.getSituacao()+ "',"
                    + "'" + pModelDfe.getValorTotal()+ "',"
                    + "'" + pModelDfe.getImagem()+ "',"
                    + "'" + pModelDfe.getFornecedornome() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Dfe
    * @param pCodigo
    * return ModelDfe
    */
    public ModelDfe getDfeDAO(int pCodigo){
        ModelDfe modelDfe = new ModelDfe();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cnpjcpf,"
                    + "nsu,"
                    + "chave_nfe,"
                    + "dhemissao,"
                    + "numeroprotocolo,"
                    + "situacao,"
                    + "valor_total,"
                    + "imagem,"
                    + "fornecedornome"
                 + " FROM"
                     + " resumo_dfe"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDfe.setCodigo(this.getResultSet().getInt(1));
                modelDfe.setCnpjcpf(this.getResultSet().getString(2));
                modelDfe.setNsu(this.getResultSet().getString(3));
                modelDfe.setChavenfe(this.getResultSet().getString(4));
                modelDfe.setDatahoraemisao(this.getResultSet().getString(5));
                modelDfe.setProtocolo(this.getResultSet().getString(6));
                modelDfe.setSituacao(this.getResultSet().getInt(7));
                modelDfe.setValorTotal(this.getResultSet().getString(8));
                modelDfe.setImagem(this.getResultSet().getString(9));
                modelDfe.setFornecedornome(this.getResultSet().getString(10));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelDfe;
    }
    
    
    /**
    * recupera Dfe
    * @param pCodigo
    * return ModelDfe
    */
    public ModelDfe getDfeChaveDAO(String pChave){
        ModelDfe modelDfe = new ModelDfe();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cnpjcpf,"
                    + "nsu,"
                    + "chave_nfe,"
                    + "dhemissao,"
                    + "numeroprotocolo,"
                    + "situacao,"
                    + "valor_total,"
                    + "imagem,"
                    + "fornecedornome"
                 + " FROM"
                     + " resumo_dfe"
                 + " WHERE"
                     + " chave_nfe = '" + pChave + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDfe.setCodigo(this.getResultSet().getInt(1));
                modelDfe.setCnpjcpf(this.getResultSet().getString(2));
                modelDfe.setNsu(this.getResultSet().getString(3));
                modelDfe.setChavenfe(this.getResultSet().getString(4));
                modelDfe.setDatahoraemisao(this.getResultSet().getString(5));
                modelDfe.setProtocolo(this.getResultSet().getString(6));
                modelDfe.setSituacao(this.getResultSet().getInt(7));
                modelDfe.setValorTotal(this.getResultSet().getString(8));
                modelDfe.setImagem(this.getResultSet().getString(9));
                modelDfe.setFornecedornome(this.getResultSet().getString(10));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelDfe;
    }

    /**
    * recupera uma lista de CFOP
        * return ArrayList
    */
    public ArrayList<ModelDfe> getListaDfeDAO(){
        ArrayList<ModelDfe> listamodelDfe = new ArrayList();
        ModelDfe modelDfe = new ModelDfe();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cnpjcpf,"
                    + "nsu,"
                    + "chave_nfe,"
                    + "dhemissao,"
                    + "numeroprotocolo,"
                    + "situacao,"
                    + "valor_total,"
                    + "imagem,"
                    + "fornecedornome"
                    + " FROM"
                    + " resumo_dfe"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDfe = new ModelDfe();
                modelDfe.setCodigo(this.getResultSet().getInt(1));
                modelDfe.setCnpjcpf(this.getResultSet().getString(2));
                modelDfe.setNsu(this.getResultSet().getString(3));
                modelDfe.setChavenfe(this.getResultSet().getString(4));
                modelDfe.setDatahoraemisao(this.getResultSet().getString(5));
                modelDfe.setProtocolo(this.getResultSet().getString(6));
                modelDfe.setSituacao(this.getResultSet().getInt(7));
                modelDfe.setValorTotal(this.getResultSet().getString(8));
                modelDfe.setImagem(this.getResultSet().getString(9));
                modelDfe.setFornecedornome(this.getResultSet().getString(10));
                listamodelDfe.add(modelDfe);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelDfe;
    }
    
    
    
    /**
    * atualiza DFe
    * @param pModelDfe
    * return boolean
    */
    public boolean atualizarDfeDAO(ModelDfe pModelDfe){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE resumo_dfe SET "
                    + "codigo = '" + pModelDfe.getCodigo() + "',"
                    + "cnpjcpf = '" + pModelDfe.getCnpjcpf()+ "',"
                    + "nsu = '" + pModelDfe.getNsu()+ "',"
                    + "chave_nfe = '" + pModelDfe.getChavenfe()+ "',"
                    + "dhemissao = '" + pModelDfe.getDatahoraemisao()+ "',"
                    + "numeroprotocolo = '" + pModelDfe.getProtocolo()+ "',"
                    + "valor_total = '" + pModelDfe.getValorTotal()+ "',"
                    + "imagem = '" + pModelDfe.getImagem()+ "',"
                    + "situacao = '" + pModelDfe.getSituacao()+ "',"
                    + "fornecedornome = '" + pModelDfe.getFornecedornome()+ "'"
                + " WHERE "
                    + "codigo = '" + pModelDfe.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    
    /**
    * exclui DFE
    * @param pCodigo
    * return boolean
    */
    public boolean excluirDfeDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM resumo_dfe "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}