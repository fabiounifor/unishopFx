package model;

import javafx.scene.control.Hyperlink;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ModelCliente {

    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private int codCidade;
    private int codEstado;
    private String cep;
    private String telefone;
    private String celular;
    private String cpfCNPJ;
    private String inscricao;
    private String observacao;
    private int ativo;
    private String tipoPessoa;
    private String nomeFantasia;
    private int numero;
    private String email;
    private String referencia;
    private Hyperlink linkModelEditar;
    private Hyperlink linkModelSelecionar;
    String pesquisa;

    /**
    * Construtor
    */
    public ModelCliente(){}

    public Hyperlink getLinkModelEditar() {
        return linkModelEditar;
    }

    public void setLinkModelEditar(Hyperlink linkModelEditar) {
        this.linkModelEditar = linkModelEditar;
    }

    public Hyperlink getLinkModelSelecionar() {
        return linkModelSelecionar;
    }

    public void setLinkModelSelecionar(Hyperlink linkModelSelecionar) {
        this.linkModelSelecionar = linkModelSelecionar;
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
    
    public String getPesquisa() {
        return (nome+"     "+ telefone+"    "+"   "+celular+"     "  + " \n\n "+ cpfCNPJ   + email);
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
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

    /**
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de endereco
    * @param pEndereco
    */
    public void setEndereco(String pEndereco){
        this.endereco = pEndereco;
    }
    /**
    * return endereco
    */
    public String getEndereco(){
        return this.endereco;
    }

    /**
    * seta o valor de bairro
    * @param pBairro
    */
    public void setBairro(String pBairro){
        this.bairro = pBairro;
    }
    /**
    * return bairro
    */
    public String getBairro(){
        return this.bairro;
    }

    /**
    * seta o valor de codCidade
    * @param pCidade
    */
    public void setCodCidade(int pCidade){
        this.codCidade = pCidade;
    }
    /**
    * return codCidade
    */
    public int getCodCidade(){
        return this.codCidade;
    }

    /**
    * seta o valor de codEstado
    * @param pUf
    */
    public void setCodEstado(int pUf){
        this.codEstado = pUf;
    }
    /**
    * return codEstado
    */
    public int getCodEstado(){
        return this.codEstado;
    }

    /**
    * seta o valor de cep
    * @param pCep
    */
    public void setCep(String pCep){
        this.cep = pCep;
    }
    /**
    * return cep
    */
    public String getCep(){
        return this.cep;
    }

    /**
    * seta o valor de telefone
    * @param pTelefone
    */
    public void setTelefone(String pTelefone){
        this.telefone = pTelefone;
    }
    /**
    * return telefone
    */
    public String getTelefone(){
        return this.telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the cpfCNPJ
     */
    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    /**
     * @param cpfCNPJ the cpfCNPJ to set
     */
    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the ativo
     */
    public int getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "ModelCliente{" + "codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", codCidade=" + codCidade + ", codEstado=" + codEstado + ", cep=" + cep + ", telefone=" + telefone + ", celular=" + celular + ", cpfCNPJ=" + cpfCNPJ + ", inscricao=" + inscricao + ", observacao=" + observacao + ", ativo=" + ativo + ", tipoPessoa=" + tipoPessoa + ", nomeFantasia=" + nomeFantasia + ", numero=" + numero + ", email=" + email + ", referencia=" + referencia + ", pesquisa=" + pesquisa + '}';
    }
    
    
}