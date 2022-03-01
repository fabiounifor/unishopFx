package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
*
* @author Leandro Nazareth
*/
public class ModelDfe {

    private int codigo;
    private String cnpjcpf;
    private String nsu;
    private String chavenfe;
    private String datahoraemisao;
    private String protocolo;
    private String fornecedornome;
    private int situacao;
    private String valorTotal;
    private String imagem;
    private String pesquisa;

    /**
    * Construtor
    */
    public ModelDfe(){}

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    

    public String getPesquisa() {
        String Status = "";
        if (situacao == 0){
            Status = "AGUARDANDO";
            } else if(situacao == 1){
            Status = "CIENCIA";
            }else if(situacao == 2){
            Status = "CONFIRMAÇÃO";
            }else if(situacao == 3){
            Status = "NFE CADASTRADA";
            }
        return (chavenfe + "            " + datahoraemisao+ "            "+Status+ "                    "+ valorTotal +"\n" + fornecedornome+"\n" );
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCnpjcpf() {
        return cnpjcpf;
    }

    public void setCnpjcpf(String cnpjcpf) {
        this.cnpjcpf = cnpjcpf;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getChavenfe() {
        return chavenfe;
    }

    public void setChavenfe(String chavenfe) {
        this.chavenfe = chavenfe;
    }

    public String getDatahoraemisao() {
        return datahoraemisao;
    }

    public void setDatahoraemisao(String datahoraemisao) {
        this.datahoraemisao = datahoraemisao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getFornecedornome() {
        return fornecedornome;
    }

    public void setFornecedornome(String fornecedornome) {
        this.fornecedornome = fornecedornome;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "ModelDfe{" + "codigo=" + codigo + ", cnpjcpf=" + cnpjcpf + ", nsu=" + nsu + ", chavenfe=" + chavenfe + ", datahoraemisao=" + datahoraemisao + ", protocolo=" + protocolo + ", fornecedornome=" + fornecedornome + ", situacao=" + situacao + ", valorTotal=" + valorTotal + '}';
    }

    
    

    
    
}
    