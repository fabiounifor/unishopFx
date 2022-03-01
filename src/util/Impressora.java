/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;

public class Impressora {

    //listar todas as impressoras instaladas
    public static String[] listaImpressora() {
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        String[] nomes = new String[ps.length];
        for (int i = 0, l = nomes.length; i < l; i++) {
            nomes[i] = ps[i].getName();
        }
        return nomes;
    }

    //selecionar impressora
    private static PrintService selectImpress(String imp) {
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(
                DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        for (PrintService p : ps) {
            if (p.getName().equals(imp)) {
                return p;
            }
        }
        return null;
    }

    //imprimir na impressora selecionada
    
    public static boolean imprimir(String nomeImpressora, String texto) {
        try {
            PrintService impress = selectImpress(nomeImpressora);
            DocPrintJob dpj = impress.createPrintJob();
            InputStream is = new ByteArrayInputStream(texto.getBytes());
            SimpleDoc sd = new SimpleDoc(is, DocFlavor.INPUT_STREAM.AUTOSENSE,
                    null);
            dpj.print(sd, null);
        } catch (Throwable e) {
            logutil.error("falha ao imprimir: " + e.getMessage(), e);
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!" + nomeImpressora, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    

    public void imprimirAntigo(String pTexto) {
        try {
            InputStream prin = new ByteArrayInputStream(pTexto.getBytes());
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentoTexto = new SimpleDoc(prin, docFlavor, null);
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            // pega a //impressora padrao  
            PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
            printerAttributes.add(new JobName("Impressao", null));
            printerAttributes.add(OrientationRequested.PORTRAIT);
            printerAttributes.add(MediaSizeName.ISO_A4);
            // informa o tipo de folha  
            DocPrintJob printJob = impressora.createPrintJob();

            try {
                //tenta imprimir  
                printJob.print(documentoTexto, (PrintRequestAttributeSet) printerAttributes);
            } catch (PrintException e) {
                // mostra //mensagem de erro  
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            prin.close();

        } catch (Exception e) {

        }

    }

}
