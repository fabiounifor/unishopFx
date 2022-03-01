package model;
/**
*
* @author Leandro
*/
public class ModelEnquadramentoIpi {

    private int codigo;
    private int numero;
    private String grupoCst;
    private String entradaCst;
    private String saidaCst;
    private String descricao;
    

    /**
    * Construtor
    */
    public ModelEnquadramentoIpi(){}

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * return descricao
    */
    public String getDescricao(){
        return this.descricao;
    }

    public String getGrupoCst() {
        return grupoCst;
    }

    public void setGrupoCst(String grupoCst) {
        this.grupoCst = grupoCst;
    }

    public String getEntradaCst() {
        return entradaCst;
    }

    public void setEntradaCst(String entradaCst) {
        this.entradaCst = entradaCst;
    }

    public String getSaidaCst() {
        return saidaCst;
    }

    public void setSaidaCst(String saidaCst) {
        this.saidaCst = saidaCst;
    }

    @Override
    public String toString() {
        return "ModelEnquadramentoIpi{" + "codigo=" + codigo + ", numero=" + numero + ", grupoCst=" + grupoCst + ", entradaCst=" + entradaCst + ", saidaCst=" + saidaCst + ", descricao=" + descricao + '}';
    }
    
    


}