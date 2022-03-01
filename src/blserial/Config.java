/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blserial;

/**
 *
 * @author Bruno
 */

public class Config {
    
    private String software;
    private String dataGeracaoStr;
    private String dataAtualStr;
    private String diasValidadeStr;
    private String nomePC;
    private String dataValidade;

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getDataGeracaoStr() {
        return dataGeracaoStr;
    }

    public void setDataGeracaoStr(String dataGeracaoStr) {
        this.dataGeracaoStr = dataGeracaoStr;
    }

    public String getDataAtualStr() {
        return dataAtualStr;
    }

    public void setDataAtualStr(String dataAtualStr) {
        this.dataAtualStr = dataAtualStr;
    }

    public String getDiasValidadeStr() {
        return diasValidadeStr;
    }

    public void setDiasValidadeStr(String diasValidadeStr) {
        this.diasValidadeStr = diasValidadeStr;
    }

    /**
     * @return the nomePC
     */
    public String getNomePC() {
        return nomePC;
    }

    /**
     * @param nomePC the nomePC to set
     */
    public void setNomePC(String nomePC) {
        this.nomePC = nomePC;
    }

    /**
     * @return the dataValidade
     */
    public String getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    
    
}
