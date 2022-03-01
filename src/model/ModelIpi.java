package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelIpi {

    private int codigo;
    private String descricao;
    private int cstEntrada;
    private int cstSaida;
    private int enquadramento;

    /**
    * Construtor
    */
    public ModelIpi(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCstEntrada() {
        return cstEntrada;
    }

    public void setCstEntrada(int cstEntrada) {
        this.cstEntrada = cstEntrada;
    }

    public int getCstSaida() {
        return cstSaida;
    }

    public void setCstSaida(int cstSaida) {
        this.cstSaida = cstSaida;
    }

    public int getEnquadramento() {
        return enquadramento;
    }

    public void setEnquadramento(int enquadramento) {
        this.enquadramento = enquadramento;
    }

    @Override
    public String toString() {
        return "ModelIpi{" + "codigo=" + codigo + ", descricao=" + descricao + ", cstEntrada=" + cstEntrada + ", cstSaida=" + cstSaida + ", enquadramento=" + enquadramento + '}';
    }

    
  
}