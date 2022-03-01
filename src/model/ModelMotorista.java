package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelMotorista {

    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private String telefone;
    private String pesquisaMotorista;
    private int cod_cidade;

    /**
    * Construtor
    */
    public ModelMotorista(){}

    public String getPesquisaMotorista() {
        return (codigo + "    " + nome + "       " +telefone);
    }

    public void setPesquisaMotorista(String pesquisaMotorista) {
        this.pesquisaMotorista = pesquisaMotorista;
    }
    
    

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCod_cidade() {
        return cod_cidade;
    }

    public void setCod_cidade(int cod_cidade) {
        this.cod_cidade = cod_cidade;
    }

    @Override
    public String toString() {
        return "ModelMotorista{" + "codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cep=" + cep + ", telefone=" + telefone + ", pesquisaMotorista=" + pesquisaMotorista + ", cod_cidade=" + cod_cidade + '}';
    }

    
}