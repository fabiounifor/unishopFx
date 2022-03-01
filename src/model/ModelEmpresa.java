package model;
/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelEmpresa {

    private int codigo;
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String bairro;
    private int codCidade;
    private int codEstado;
    private int codPais;
    private String cep;
    private String telefone;
    private String cnpj;
    private String inscEstad;
    private String crt;
    private String logomarca;

    /**
    * Construtor
    */
    public ModelEmpresa(){}

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
    * seta o valor de razaoSocial
    * @param pRazaoSocial
    */
    public void setRazaoSocial(String pRazaoSocial){
        this.razaoSocial = pRazaoSocial;
    }
    /**
    * return razaoSocial
    */
    public String getRazaoSocial(){
        return this.razaoSocial;
    }

    /**
    * seta o valor de nomeFantasia
    * @param pNomeFantasia
    */
    public void setNomeFantasia(String pNomeFantasia){
        this.nomeFantasia = pNomeFantasia;
    }
    /**
    * return nomeFantasia
    */
    public String getNomeFantasia(){
        return this.nomeFantasia;
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
    * @param pCodCidade
    */
    public void setCodCidade(int pCodCidade){
        this.codCidade = pCodCidade;
    }
    /**
    * return codCidade
    */
    public int getCodCidade(){
        return this.codCidade;
    }

    /**
    * seta o valor de codEstado
    * @param pCodEstado
    */
    public void setCodEstado(int pCodEstado){
        this.codEstado = pCodEstado;
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

    @Override
    public String toString(){
        return "ModelEmpresa {" + "::codigo = " + this.codigo + "::razaoSocial = " + this.razaoSocial + "::nomeFantasia = " + this.nomeFantasia + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::codCidade = " + this.codCidade + "::codEstado = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone +  "}";
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the enderecoNumero
     */
    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    /**
     * @param enderecoNumero the enderecoNumero to set
     */
    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    /**
     * @return the enderecoComplemento
     */
    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    /**
     * @param enderecoComplemento the enderecoComplemento to set
     */
    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    /**
     * @return the codPais
     */
    public int getCodPais() {
        return codPais;
    }

    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    /**
     * @return the inscEstad
     */
    public String getInscEstad() {
        return inscEstad;
    }

    /**
     * @param inscEstad the inscEstad to set
     */
    public void setInscEstad(String inscEstad) {
        this.inscEstad = inscEstad;
    }

    /**
     * @return the crt
     */
    public String getCrt() {
        return crt;
    }

    /**
     * @param crt the crt to set
     */
    public void setCrt(String crt) {
        this.crt = crt;
    }

    public String getLogomarca() {
        return logomarca;
    }

    public void setLogomarca(String logomarca) {
        this.logomarca = logomarca;
    }
    
}