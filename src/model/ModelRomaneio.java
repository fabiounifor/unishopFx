package model;

import java.sql.Date;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelRomaneio {

    private int codigo;
    private Date data_hora;
    private int carro;
    private int motorista;
    private String pesquisaRomaneio;

    /**
    * Construtor
    */
    public ModelRomaneio(){}
    
    public String getPesquisaRomaneio() {
        return (codigo + "    " + carro + "       " +motorista + "     "+ data_hora);
    }

    public void setPesquisaRomaneio(String pesquisaBairro) {
        this.pesquisaRomaneio = pesquisaRomaneio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public int getCarro() {
        return carro;
    }

    public void setCarro(int carro) {
        this.carro = carro;
    }

    public int getMotorista() {
        return motorista;
    }

    public void setMotorista(int motorista) {
        this.motorista = motorista;
    }

    @Override
    public String toString() {
        return "ModelRomaneio{" + "codigo=" + codigo + ", data_hora=" + data_hora + ", carro=" + carro + ", motorista=" + motorista + ", pesquisaRomaneio=" + pesquisaRomaneio + '}';
    }

        

    
}