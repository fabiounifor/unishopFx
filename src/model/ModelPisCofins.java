package model;
/**
*
* @author Leandro Nazareth
*/
public class ModelPisCofins {

    private int codigo;
    private String descricao;
    private int pisEntrada;
    private int pisSaida;
    private int cofinsEntrada;
    private int cofinsSaida;

    /**
    * Construtor
    */
    public ModelPisCofins(){}

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

    public int getPisEntrada() {
        return pisEntrada;
    }

    public void setPisEntrada(int pisEntrada) {
        this.pisEntrada = pisEntrada;
    }

    public int getPisSaida() {
        return pisSaida;
    }

    public void setPisSaida(int pisSaida) {
        this.pisSaida = pisSaida;
    }

    public int getCofinsEntrada() {
        return cofinsEntrada;
    }

    public void setCofinsEntrada(int cofinsEntrada) {
        this.cofinsEntrada = cofinsEntrada;
    }

    public int getCofinsSaida() {
        return cofinsSaida;
    }

    public void setCofinsSaida(int cofinsSaida) {
        this.cofinsSaida = cofinsSaida;
    }

    @Override
    public String toString() {
        return "ModelPisCofins{" + "codigo=" + codigo + ", descricao=" + descricao + ", pisEntrada=" + pisEntrada + ", pisSaida=" + pisSaida + ", cofinsEntrada=" + cofinsEntrada + ", cofinsSaida=" + cofinsSaida + '}';
    }

    

    
  
}