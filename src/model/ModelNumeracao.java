package model;

import java.sql.Date;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
*
* @author Leandro
*/
public class ModelNumeracao {

    private int codigo;
    private int numeroNfe;
    private int numeroNfce;
    private int serieNfe;
    private int serieNfce;
    private String ultimoNsu;
    private String ultimaConsulta;
    
    

    /**
    * Construtor
    */
    public ModelNumeracao(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroNfe() {
        return numeroNfe;
    }

    public void setNumeroNfe(int numeroNfe) {
        this.numeroNfe = numeroNfe;
    }

    public int getNumeroNfce() {
        return numeroNfce;
    }

    public void setNumeroNfce(int numeroNfce) {
        this.numeroNfce = numeroNfce;
    }

    public int getSerieNfe() {
        return serieNfe;
    }

    public void setSerieNfe(int serieNfe) {
        this.serieNfe = serieNfe;
    }

    public int getSerieNfce() {
        return serieNfce;
    }

    public void setSerieNfce(int serieNfce) {
        this.serieNfce = serieNfce;
    }

    public String getUltimoNsu() {
        return ultimoNsu;
    }

    public void setUltimoNsu(String ultimoNsu) {
        this.ultimoNsu = ultimoNsu;
    }

    public String getUltimaConsulta() {
        return ultimaConsulta;
    }

    public void setUltimaConsulta(String ultimaConsulta) {
        this.ultimaConsulta = ultimaConsulta;
    }

    @Override
    public String toString() {
        return "ModelNumeracao{" + "codigo=" + codigo + ", numeroNfe=" + numeroNfe + ", numeroNfce=" + numeroNfce + ", serieNfe=" + serieNfe + ", serieNfce=" + serieNfce + ", ultimoNsu=" + ultimoNsu + ", ultimaConsulta=" + ultimaConsulta + '}';
    }

}