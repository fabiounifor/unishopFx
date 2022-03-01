/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.ModelConfig;
import nfe.model.ModelNFCe;
import nfe.model.ModelXmlNfe;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelDfe;
import nfe.model.ModelXmlDfe;

/**
 *
 * @author MacMini
 */
public class ManipularXML {

    ModelXmlNfe modelXmlNFCe = new ModelXmlNfe();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();

    /**
     * gera o arquivo config.xml
     *
     * @param pModelConfig
     * @return boolean
     * @throws IOException
     */
    public static void gravaXML(ModelConfig pModelConfig) {
        //Cria uma instância da classe XStream
        XStream xStream = new XStream(new DomDriver());
        //Escolher um nome para o xml
        xStream.alias("config", ModelConfig.class);
        //Grava no diretório padrão do projeto, fica na própria pasta do projeto.
        File arquivo = new File("C:\\UniShop\\config\\config.xml");
        FileOutputStream gravar;

        try {
            //grava o arquivo
            gravar = new FileOutputStream(arquivo);
            //insere os bytes no XML
            gravar.write(xStream.toXML(pModelConfig).getBytes());
            gravar.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * gera o arquivo chave.xml
     *
     * @param pModelXmlNFCe
     * @param pChave
     * @return boolean
     * @throws IOException
     */
    public static void gravaXMLNfce(ModelXmlNfe pModelXmlNFCe, String pChave) {
        //Cria uma instância da classe XStream
        XStream xStream = new XStream(new DomDriver());
        //Escolher um nome para o xml
        xStream.alias("config", ModelConfig.class);
        //Grava no diretório padrão do projeto, fica na própria pasta do projeto.
        File arquivo = new File("C:\\UniShop\\dfe\\nfce\\" + pChave + ".xml");
        FileOutputStream gravar;

        try {
            //grava o arquivo
            gravar = new FileOutputStream(arquivo);
            //insere os bytes no XML
            gravar.write(xStream.toXML(pModelXmlNFCe).getBytes());
            gravar.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * gera o arquivo chave.xml
     *
     * @param pModelXmlNFCe
     * @param pChave
     * @return boolean
     * @throws IOException
     */
    public static void gravaXMLRetorno(String arquivoRetorno, String nomeArquivo) {
        FileWriter arquivo = null;
        try {
            arquivo = new FileWriter("C:\\UniShop\\retorno\\" + nomeArquivo + ".xml");
        } catch (IOException ex) {
            Logger.getLogger(ManipularXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter gravar = new PrintWriter(arquivo);

        //grava o arquivo
        gravar.print(arquivoRetorno);
        gravar.close();
    }

    public static void apagarXMLRetorno() {
        File folder = new File("C:\\UniShop\\retorno\\");
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }

    /**
     * gera o arquivo chave.xml
     *
     * @param pModelXmlNFCe
     * @param pChave
     * @return boolean
     * @throws IOException
     */
    public static void gravaININfce(String arquivoIni, String pChave) throws IOException {
        FileWriter arquivo = new FileWriter("C:\\UniShop\\" + pChave + ".ini");
        PrintWriter gravar = new PrintWriter(arquivo);

        //grava o arquivo
        gravar.print(arquivoIni);
        gravar.close();
    }

    /**
     * gera o arquivo chave.xml
     *
     * @param pModelXmlNFCe
     * @param pChave
     * @return boolean
     * @throws IOException
     */
    public static void gravaSintegra(String arquivoSintegra, String datas) throws IOException {
        //Cria uma instância da classe XStream
        //XStream xStream = new XStream(new DomDriver());
        //Escolher um nome para o xml
        //xStream.alias("config", ModelConfig.class);
        //Grava no diretório padrão do projeto, fica na própria pasta do projeto.
        //File arquivo = new File("C:\\UniShop\\dfe\\nfce\\"+ pChave +".ini");
        //FileOutputStream gravar;
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
        FileWriter arquivo = new FileWriter("C:\\UniShop\\dfe\\" + controllerEmpresa.getEmpresaController(1).getModelEmpresa().getCnpj() + "\\sintegra\\" + datas + ".txt");
        PrintWriter gravar = new PrintWriter(arquivo);

        //grava o arquivo
        gravar.println(arquivoSintegra);
        gravar.close();
    }

    public static ModelConfig lerXmlConfig() {
        FileReader reader = null;
        try {
            //carrega o arquivo XML para um objeto reader
            reader = new FileReader("C:\\UniShop\\config\\config.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Cria o objeto xstream
        XStream xStream = new XStream(new DomDriver());
        //informamos as tags que serao lidas
        //como foi feito no metodo gerarXml002
        xStream.alias("config", ModelConfig.class);
        //cria um objeto Contato,
        //contendo os dados do xml
        ModelConfig model = (ModelConfig) xStream.fromXML(reader);
        //retornar arquivo
        return model;
    }

    public static ModelXmlNfe lerXmlNFe(String pNomeArquivo, String pCaminho) {
        FileReader reader = null;
        try {
            //carrega o arquivo XML para um objeto reader
            reader = new FileReader(pCaminho + "\\" + pNomeArquivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Cria o objeto xstream
        XStream xStream = new XStream(new DomDriver());
        //informamos as tags que serao lidas
        //como foi feito no metodo gerarXml002
        xStream.alias(pNomeArquivo, ManipularXML.class);
        //cria um objeto Contato,
        //contendo os dados do xml
        ModelXmlNfe model = (ModelXmlNfe) xStream.fromXML(reader);
        //retornar arquivo
        return model;
    }

    public static ModelXmlDfe lerXmlRetorno(String pNomeArquivo, String pCaminho) {
        FileReader reader = null;
        try {
            //carrega o arquivo XML para um objeto reader
            reader = new FileReader(pCaminho + "\\" + pNomeArquivo);
        } catch (FileNotFoundException e) {
            System.out.println("ARQUIVO NÃO ENCONTRADO");
            e.printStackTrace();
        }
        //Cria o objeto xstream
        XStream xStream = new XStream(new DomDriver());
        //informamos as tags que serao lidas
        //como foi feito no metodo gerarXml002
        xStream.alias("resNFe", ModelXmlDfe.class);
        //cria um objeto Contato,
        //contendo os dados do xml
        ModelXmlDfe model = (ModelXmlDfe) xStream.fromXML(reader);
        //retornar arquivo
        return model;
    }
}
