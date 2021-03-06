/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe.util;

/**
 *
 * @author leand
 */
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import nfe.model.ModelNF;
import nfe.controller.ControllerNF;
import util.BLMascaras;

/**
 *
 * @author Adelcio C. Porto email: portoinfo@sercomtel.com.br
 */
public class LerArqXML {

    public void lerarq(String caminhoArquivo) throws Exception {
        //Aqui você informa o nome do arquivo XML.  
        File f = new File(caminhoArquivo);

        //Criamos uma classe SAXBuilder que vai processar o XML  
        SAXBuilder sb = new SAXBuilder();

        //Este documento agora possui toda a estrutura do arquivo.  
        Document d;
        try {
            d = sb.build(f);
            //Recuperamos o elemento root  
            Element nfe = d.getRootElement();

            //Recuperamos os atributos filhos (Attributes)  
            List atributes = nfe.getAttributes();
            Iterator i_atr = atributes.iterator();

            //Iteramos com os atributos filhos  
            while (i_atr.hasNext()) {
                Attribute atrib = (Attribute) i_atr.next();
          //      System.out.println("\nattribute de (" + nfe.getName() + "):" + atrib.getName() + " - valor: " + atrib.getValue());
            }
            //Recuperamos os elementos filhos (children)  
            List elements = nfe.getChildren();
            Iterator i = elements.iterator();

            //Iteramos com os elementos filhos, e filhos do dos filhos  
            while (i.hasNext()) {
                Element element = (Element) i.next();
                System.out.println("element:" + element.getName());
                trataElement(element);
            }

        } catch (JDOMException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void trataElement(Element element) throws Exception {
ModelNF modelNF = new ModelNF();
BLMascaras bLmascaras = new BLMascaras();
ControllerNF controllerNF = new ControllerNF();
        //Recuperamos os atributos filhos (Attributes)  
        List atributes = element.getAttributes();
        Iterator i_atr = atributes.iterator();

        //Iteramos com os atributos filhos  
        while (i_atr.hasNext()) {
            Attribute atrib = (Attribute) i_atr.next();
            //System.out.println("\nattribute de (" + element.getName() + "):" + atrib.getName() + " - valor: " + atrib.getValue());
        }
        //Recuperamos os elementos filhos (children)  
        List elements = element.getChildren();
        Iterator it = elements.iterator();

        //Iteramos com os elementos filhos, e filhos do dos filhos  
        while (it.hasNext()) {
            Element el = (Element) it.next();
            //System.out.println("element(" + element.getName() + "):" + el.getName() + " - Valor: " + el.getText());
            //  aqui voce pode escolher qual(is) campo(s) quer manipular  
            if (el.getName().equals("nNF")) {
                //  grava_no_banco de dados(element.getAttributeValue("nNF"));  
                modelNF.setNumeroNfe(el.getText());
                
            }
            if (el.getName().equals("chNFe")) {
                //  grava_no_banco de dados(element.getAttributeValue("nNF"));  
                modelNF.setChaveNfe(el.getText());
                
            }
            
            trataElement(el);
        }
        modelNF.setCodBanco(0);
        modelNF.setCodCliente(1);
        modelNF.setCodFormaPgto(2);
        modelNF.setCodTipoDoc("3");
        modelNF.setCodTransportadora(4);
        modelNF.setEmpresa(5);
        modelNF.setPedido(6);
        modelNF.setCodFormaPgto(7);
        modelNF.setCodFormaPgto(7);
        modelNF.setDataDigitacao(bLmascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        modelNF.setDataDevolucao(bLmascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        modelNF.setDataCancelamento(bLmascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        modelNF.setDataEmissao(bLmascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        modelNF.setUfPlaca("ES");
        modelNF.setModelonfe("65");
        modelNF.setSerieNfe("003");
        modelNF.setFinNfe("0");
        modelNF.setTpemis("1");
        modelNF.setTpamb("1");
        modelNF.setStatusNfe("1");
        
        
        controllerNF.salvarNFController(modelNF);
        
        
    }

    public static void main(String[] args) {
        LerArqXML lexml = new LerArqXML();
        //lexml.lerarq();
    }
}
