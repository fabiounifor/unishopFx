/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.InputMismatchException;
/**
 *
 * @author BLsoft
 */
public class BLMascaras {

    /**
     * converte a virgula de uma string para ponto
     *
     * @param pString
     * @return String
     */
    public String converterVirgulaParaPonto(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }

    /**
     * converte a virgula de uma string para ponto
     *
     * @param pString
     * @return String
     */
    public String converterPontoPraVirgula(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == '.') {
                retorno += ',';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }
    
        /**
     * converte a virgula de uma string para ponto
     *
     * @param pString
     * @return String
     */
    public String removerVirgula(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == '.') {
                retorno += "";
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }
    public String removerFormatacao(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if ((pString.charAt(i) == '.') || (pString.charAt(i) == '-')|| (pString.charAt(i) == '/')) {
                retorno += "";
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }

    public float converterPontoPraVirgulaFloat(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == '.') {
                retorno += ',';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Float.parseFloat(retorno);
    }
    /**
     * converte a virgula de uma string para ponto
     *
     * @param pString
     * @return float
     */
    public float converterVirgulaParaPontoReturnFloat(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Float.parseFloat(retorno);
    }
        
        public double converterVirgulaParaPontoReturnDouble(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Double.parseDouble(retorno);
    }
    public String converterVirgulaParaPontoReturnString(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }

    /**
     * retira os pontos do valor
     *
     * @param pString
     * @return
     */
    public String removerPontos(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == '.') {
                retorno += "";
                } else {
                retorno += pString.charAt(i);
            }
        }
        
        return retorno;
    }
    
    /**
     * retira os pontos do valor
     *
     * @param pString
     * @return
     */
    public String CompletaZero(String pString) {
        String novaString= "";
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == '.') {
            if (i+3 > tamanhoString && i+2 == tamanhoString) {
               novaString  = (pString +"0");
            }else if (i+2 > tamanhoString){
                novaString  = (pString + "00");
            } else {
                novaString = pString ;
            }
        }
        }
        return novaString;
    }

    /**
     * adiciona um ponto a string
     *
     * @param pString
     * @return String
     */
    public String addPonto(String pString) {
        int pontoConter = 0;
        for (int i = 0; i < pString.length(); i++) {
            if (pString.charAt(i) == '.') {
                pontoConter++;
            }
        }
        if (pontoConter == 0) {
            pString += ".0";
        }
        return pString;
    }

    /**
     * truca o valor com 3 casas decimais
     *
     * @param pValor
     * @return double
     */
    public double truncar3Casas(double pValor) {

        return Math.round(pValor * 100) / 100d;
    }

    public int converteInteiro(int pString) {
        DecimalFormat df = new DecimalFormat("#.0");
        pString = Integer.parseInt(df.format(pString));
        return pString;
    }

    /**
     * Arredonda com 2 casas decimais.
     */
    public double converteArredondar2Casas(double pDouble) {
        DecimalFormat df = new DecimalFormat("#,00");
        pDouble = Double.parseDouble(df.format(pDouble));
        return pDouble;
    }

    /**
     * arredonda um valor com ponto
     *
     * @param pValor
     * @return
     */
    public float arredondamentoComPontoDuasCasas(float pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(this.converterVirgulaParaPonto(df.format(pValor)));
    }
    /**
     * arredonda um valor com ponto
     *
     * @param pValor
     * @return
     */
    public double arredondamentoComPontoDuasCasasDouble(Double pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(this.converterVirgulaParaPonto(df.format(pValor)));
    }
    
    /**
     * trunca um valor com ponto
     *
     * @param pValor
     * @return
     */
    public double truncamentoComPontoDuasCasasDouble(Double pValor) {
        
        DecimalFormat truncamento = new DecimalFormat();
        truncamento.setMaximumFractionDigits(2);
        String valor = truncamento.format(pValor);
        String valorSemPontos = removerPontos(valor);
        return Double.parseDouble(this.converterVirgulaParaPonto(valorSemPontos));
    }
    
    
    
    /**
     * trunca um valor com ponto
     *
     * @param pValor
     * @return  valorRetorno
     */
    public double truncamentoComPontoDuasCasasBigDouble(Double pValor) {
        System.out.println("entrou no big");
        BigDecimal x = new BigDecimal(pValor,MathContext.DECIMAL32).setScale(2);
        
        double valorRetorno = Double.parseDouble(String.valueOf(x));
        return valorRetorno;
    }
    /**
     * trunca um valor com ponto
     *
     * @param pValor
     * @return
     */
    public double truncamentoComPontoTresCasasDouble(Double pValor) {
        
        DecimalFormat truncamento = new DecimalFormat();
        truncamento.setMaximumFractionDigits(3);
        return Double.parseDouble(this.converterVirgulaParaPonto(truncamento.format(pValor)));
    }
    
    /**
     * trunca um valor com ponto
     *
     * @param pValor
     * @return
     */
    public Float truncamentoComPontoDuasCasasFloat(Float pValor) {
        
        DecimalFormat truncamento = new DecimalFormat();
        truncamento.setMaximumFractionDigits(2);
        return Float.parseFloat(this.converterVirgulaParaPonto(truncamento.format(pValor)));
    }
    
    /**
     * trunca um valor com ponto
     *
     * @param pValor
     * @return
     */
    public Float truncamentoComPontoTresCasasFloat(Float pValor) {
        
        DecimalFormat truncamento = new DecimalFormat();
        truncamento.setMaximumFractionDigits(3);
        return Float.parseFloat(this.converterVirgulaParaPonto(truncamento.format(pValor)));
    }
    
   
    /**
     * arredonda um valor com ponto string formatada
     *
     * @param pValor
     * @return
     */
    public String arredondamentoComPontoDuasCasasString(float pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }
    
    /**
     * arredonda um valor com ponto string formatada
     *
     * @param pValor
     * @return
     */
    public String arredondamentoComPontoDuasCasasFloatString(float pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }

    /**
     * arredonda um valor com ponto
     *
     * @param pValor
     * @return
     */
    public float arredondamentoComPontoTresCasas(float pValor) {
        DecimalFormat df = new DecimalFormat("#.000");
        return Float.parseFloat(this.converterVirgulaParaPonto(df.format(pValor)));
    }

    /**
     * arredonda um valor com ponto
     *
     * @param pValor
     * @return
     */
    public String arredondamentoDoubleComPontoDuasCasasString(Double pValor) {
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }

    public String TiraAcentos(String passa) {
        passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");
        passa = passa.replaceAll("[âãàáä]", "a");
        passa = passa.replaceAll("[ÊÈÉË]", "E");
        passa = passa.replaceAll("[êèéë]", "e");
        passa = passa.replaceAll("ÎÍÌÏ", "I");
        passa = passa.replaceAll("îíìï", "i");
        passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");
        passa = passa.replaceAll("[ôõòóö]", "o");
        passa = passa.replaceAll("[ÛÙÚÜ]", "U");
        passa = passa.replaceAll("[ûúùü]", "u");
        passa = passa.replaceAll("Ç", "C");
        passa = passa.replaceAll("ç", "c");
        passa = passa.replaceAll("[ýÿ]", "y");
        passa = passa.replaceAll("Ý", "Y");
        passa = passa.replaceAll("ñ", "n");
        passa = passa.replaceAll("Ñ", "N");
        passa = passa.replaceAll("['<>\\|/]", "");
        return passa;
    }

    /**
     * retorna uma String quando o parametro recebido é uma string no formato
     * yyyy-MM-dd
     *
     * @param pString
     * @return String
     */
    public String addBarras(String pString) {
        String dataRetorno = new String();
        //substitui o '-' por '\'
        if (pString != null) {
            dataRetorno += pString.charAt(8);
            dataRetorno += pString.charAt(9);
            dataRetorno += '/';
            dataRetorno += pString.charAt(5);
            dataRetorno += pString.charAt(6);
            dataRetorno += '/';
            dataRetorno += pString.charAt(0);
            dataRetorno += pString.charAt(1);
            dataRetorno += pString.charAt(2);
            dataRetorno += pString.charAt(3);
        }
        return dataRetorno;
    }

    public String trocarTracos(String pString) {
        String retorno = new String();
        if (pString != null) {
            for (int i = 0; i < pString.length(); i++) {
                if (pString.charAt(i) == '-') {
                    retorno += '/';
                } else {
                    retorno += pString.charAt(i);
                }
            }
        }
        return retorno;
    }
    
    public String inverteBarra(String pString) {
        String retorno = new String();
        if (pString != null) {
            for (int i = 0; i < pString.length(); i++) {
                if (pString.charAt(i) == '\\') {
                    retorno += '/';
                } else {
                    retorno += pString.charAt(i);
                }
            }
        }
        return retorno;
    }

    /**
     * adiciona uma quantidade de dias a data
     *
     * @param pQteDias
     * @return Date
     */
    public Date addDias(int pQteDias, Date pDate) {
        Calendar c = Calendar.getInstance();

        c.setTime(pDate);
        c.add(Calendar.DATE, pQteDias);

        return c.getTime();
    }

    /**
     * adicionar mês a data
     *
     * @param totalParcelas
     * @return
     */
    public Date adddMes(Date dataAtual, int quantidadeMes) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(Calendar.MONTH, quantidadeMes);
        return c.getTime();
    }

    public int diasEntreDatas(Date pDataInicio, Date pDataFim) {
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        ini.setTime(pDataInicio);
        fim.setTime(pDataFim);
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();
        return (int) (((dt2 - dt1) / 86400000) + 1);
    }

    /**
     *retornar hora tempo real
     * @return 
     */
    public String retornarHora(){
        Date date = new Date(); 
        SimpleDateFormat teste = new SimpleDateFormat("hh:mm:ss");	
        return teste.format(date);
    }	
    /**
     *retornar hora tempo real
     * @return 
     */
    public String retornarData(){
        Date date = new Date(); 
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy");	
        return teste.format(date);
    }	
    
    /**
     * retornar data e hora tempo real
     *
     * @return
     */
    public String retornarDataHora() {
        Date date = new Date();
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
        return teste.format(date);
    }
/**
     * retornar data e hora tempo real
     *
     * @return
     */
    public String retornarDataHoraSegundos() throws ParseException {
        Date date = new Date();
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date dt24 = teste.parse("21/05/2020 15:30:00");
        return teste.format(date);
    }
    
    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public java.sql.Date converterDataStringParaDate(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
     /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public java.sql.Date converterDataStringParaDateBR(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
    public java.sql.Date converterDataStringParaDateTimeBR(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
    public java.sql.Date converterDataStringParaDateTimeBRSegundos(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    

    public String converteTimeEmDataHora(long pDataLong) {
        Date dt = new Date (pDataLong);
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss.SSS");
        df.setTimeZone (TimeZone.getTimeZone ("America/São_Paulo: "));
        return df.format (dt);
    }
    
    public String converteTimeEmDataHoraNF(long pDataLong) {
        Date dt = new Date (pDataLong);
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
        df.setTimeZone (TimeZone.getTimeZone ("GMT-03:00"));
        return df.format (dt);
    }
  /*  public String converteTimeStringEmDataHoraNF(String pDataString) {
        Date dt = new Date (pDataString);
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
        df.setTimeZone (TimeZone.getTimeZone ("GMT-03:00"));
        return df.format (dt);
    }
    public String converteTimeStringEmDataHoraNFHifen(String pDataString) {
        Date dt = new Date (pDataString);
        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone (TimeZone.getTimeZone ("GMT-03:00"));
        return df.format (dt);
    }*/
     
    public String converteDateEmDataHora(Date pDataLong) {
        //Date dt = new Date (pDataLong);
        DateFormat df = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss.SSS");
        df.setTimeZone (TimeZone.getTimeZone("America/São_Paulo: "));
        return df.format (pDataLong);
    }
    public String converteDateEmData(Date pDataLong) {
        //Date dt = new Date (pDataLong);
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setTimeZone (TimeZone.getTimeZone("America/São_Paulo: "));
        return df.format (pDataLong);
    }
        
    public String converteDateEmDataHoraBr(Date pDataLong) {
        //Date dt = new Date (pDataLong);
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss.SSS");
        df.setTimeZone (TimeZone.getTimeZone("America/São_Paulo: "));
        return df.format(pDataLong);
    }

    /**
     * Converte data tipo string para o formato americano yyyy/MM/dd no tipo
     * date String para Date
     *
     * @param data
     * @return
     * @throws Exception
     */
    public java.sql.Date converterDataStringParaDateUS(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    public java.sql.Date converterDataStringData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    public java.sql.Date converterDataStringDataHifen(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
    public java.sql.Date converterDataStringDataHoraHifen(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
    public java.sql.Date converterDataStringDataUS(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    /**
     * Converte data tipo date para o formato americano yyyy/MM/dd também tipo
     * date Date para Date
     *
     * @param pData
     * @return
     * @throws Exception
     */
    public java.sql.Date converterDataParaDateUS(Date pData) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
    public java.sql.Date converterDataemHora(Date pTime) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("HH:mm:ss.SSS");
        String dataString = formatarDate.format(pTime);
        if (pTime == null || pTime.equals("")) {
            return null;
        }

        java.sql.Date time = null;
        try {
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
            time = new java.sql.Date(((java.util.Date) formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return time;
    }
    
    /**
     * Converte data tipo date para o formato americano yyyy/MM/dd também tipo
     * date Date para Date
     *
     * @param pData
     * @return
     * @throws Exception
     */
    public java.sql.Date converterDataParaDateHourUS(Date pData) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    /**
     * Recebe qualquer data em tipo date e retorna a data formatada no tipo
     * string ex. dd/MM/yyyy Date para String
     *
     * @param pData
     * @return String
     */
    public String formatarData(Date pData) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(pData);
    }
    
    /**
     * Recebe qualquer data em tipo date e retorna a data formatada no tipo
     * string ex. yyyy-MM-dd Date para String
     *
     * @param pData
     * @return String
     */
    public String formatarDataHifenUS(Date pData) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        return formatarDate.format(pData);
    }
    
        

    
    
    /**
     * Recebe qualquer data em tipo date e retorna a data formatada no tipo
     * string ex. dd/MM/yyyy HH.MM.ss.SSS Date para String
     *
     * @param pData
     * @return String
     */
    public String formatarDataHora(Date pData) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        return formatarDate.format(pData);
    }
    
         /**
         *
         * @param CPF
         * @return
         */
        public boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
    public boolean isCNPJ(String CNPJ) {
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
       (CNPJ.length() != 14))
       return(false);

    char dig13, dig14;
    int sm, i, r, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
    try {
// Calculo do 1o. Digito Verificador
      sm = 0;
      peso = 2;
      for (i=11; i>=0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
        num = (int)(CNPJ.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig13 = '0';
      else dig13 = (char)((11-r) + 48);

// Calculo do 2o. Digito Verificador
      sm = 0;
      peso = 2;
      for (i=12; i>=0; i--) {
        num = (int)(CNPJ.charAt(i)- 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig14 = '0';
      else dig14 = (char)((11-r) + 48);

// Verifica se os dígitos calculados conferem com os dígitos informados.
      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
         return(true);
      else return(false);
    } catch (InputMismatchException erro) {
        return(false);
    }
  }



}
