/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe.util;

import FXController.relacionaCompra;
import interfaces.classeInterfaces;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.ModelComprasProdutos;
import model.ModelFornecedor;
import nfe.model.ModelXmlNfe;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import nfe.model.ModelNF;
import util.BLMascaras;
import nfe.controller.ControllerNF;
import controller.ControllerEstado;
import controller.ControllerCliente;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.ModelContaPagar;
import model.ModelDfe;

/**
 *
 * @author leand
 */
public class ViewLeitorNotaXML extends javax.swing.JFrame {

    String caminho_escolha;
    int tamanhoEmit;
    int tipoPagamento;
    String nome ;
    String fantasia;
    String cnpj;
    String ie;
    String telefone;
    String rua;
    String cep;
    String codCidade;
    String numero;
    String cst;
    String codProdutoFornecedor;
    float quantidade;
    String nomeProduto;
    String barras;
    String valorSN;
    String percSN;
    String valorBCST;
    String valorBCICMS;
    String valorIpi;
    String percIpi;
    String cfop;
    String unidade;
    Float valorUnitarioProduto;
    Float valorTotalProduto;
    int uf;
    String bairro;
    int controle = 0;
    String controlecp = "0";
    String codigoConta  = "0";
    String codigoFornecedor = "0";
    String descricaoConta;
    String dataLancamento;
    String dataVencimento;
    String ncm;
    String cest;
    String numeronfe;
    int pagamento;
    String observacao;
    int situacao;
    float valorFatura;
    ArrayList<Button> listaprocuraProduto = new ArrayList<>();
    Button procuraProduto;
    Button adcionaProduto;
    Button procuraFator;
    Button procuraCfop;
    
    
    String fileName = "", nomeArqXml = "";
    ModelXmlNfe modelXmlNfe = new ModelXmlNfe();
    TraduzirXmlNfe traduzirXmlNfe = new TraduzirXmlNfe();
    ControllerNF controllerNF = new ControllerNF();
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelNF modelNF = new ModelNF();
    public ArrayList<ModelComprasProdutos> listaComprados ;
    public ArrayList<ModelFornecedor> listaFornecedor ;
    public ArrayList<ModelNF> listaNfe = new ArrayList<>();
    public ArrayList<ModelDfe> listaDfe = new ArrayList<>();
    public ArrayList<ModelContaPagar> listaContaPagar = new ArrayList<>();
    
    //instanciando modelo produto nfe
    ModelComprasProdutos mcp = new ModelComprasProdutos();
    /**
     * Creates new form ViewLeitorNotaXML
     */
    public ViewLeitorNotaXML() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
      public void botao(){
          relacionaCompra rc = new relacionaCompra();
          
          procuraProduto = new Button("...");
          adcionaProduto = new Button("+");
          procuraCfop = new Button("...");
          procuraFator = new Button("...");
          procuraProduto.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    
                    try {
                        rc.procuraProduto(nomeProduto);
                    } catch (Exception ex) {
                        Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                
            });
          adcionaProduto.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    
                    try {
                        mcp.setListaModelComprasProdutos(listaComprados);
                        rc.novoProduto(mcp);
                    } catch (Exception ex) {
                        Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                
            });
          procuraCfop.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    
                    try {
                        rc.procuraProduto(nomeProduto);
                    } catch (Exception ex) {
                        Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                
            });
          procuraFator.setOnMouseClicked((MouseEvent e)->{
                if(e.getClickCount()== 1){
                    
                    try {
                        rc.procuraProduto(nomeProduto);
                    } catch (Exception ex) {
                        Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                
            });
          
          
      }
   
    
    
    public String escolheArq() {
        String arquivo = null;
        File[] arquivos = escolhe_arquivo(true, caminho_escolha, JFileChooser.FILES_ONLY, "xml");
        if (arquivos != null) {
            for (int i = 0; i < arquivos.length; i++) {
                arquivo = arquivos[i].getAbsolutePath();
                nomeArqXml = arquivos[i].getName();
            }
        }
        return arquivo;
    }

    public File[] escolhe_arquivo(boolean multiplo, String caminho, int tipo_arq, String ext_arq) {
        SwingUtilities.updateComponentTreeUI(getContentPane());
        JFileChooser fc_escolha = new JFileChooser(caminho);
        fc_escolha.setDialogTitle("Escolha o Arquivo para Leitura");
        fc_escolha.setApproveButtonText("Confirma");
        fc_escolha.setFileSelectionMode(tipo_arq);
        //fc_escolha.setDialogType(JFileChooser.CUSTOM_DIALOG);
        if (ext_arq != null) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos " + ext_arq, ext_arq.toLowerCase(), ext_arq.toUpperCase());
            fc_escolha.setFileFilter(filter);
        }
        fc_escolha.setBounds(10, 30, 300, 350);
        fc_escolha.setAutoscrolls(true);
        fc_escolha.setMultiSelectionEnabled(multiplo);
        int returnVal = fc_escolha.showOpenDialog(getContentPane());
        SwingUtilities.updateComponentTreeUI(getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] f_result = fc_escolha.getSelectedFiles();
            return f_result;
        } else {
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfNfe = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizador de NFe em XML");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        jButton1.setText("Localizarr nota fiscal XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtfNfe.setColumns(20);
        jtfNfe.setRows(5);
        jScrollPane1.setViewportView(jtfNfe);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sair-filled-50.png"))); // NOI18N
        jButton2.setText("Sair do vizualizador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
           // lerarq(escolheArq());
        } catch (Exception ex) {
            Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /*public void lerarq(String pCaminho, int codigo) throws Exception {
        //Aqui você informa o nome do arquivo XML.  
        File f = new File(pCaminho);

        //Criamos uma classe SAXBuilder que vai processar o XML  
        SAXBuilder sb = new SAXBuilder();

        //Este documento agora possui toda a estrutura do arquivo.  
        Document d;
        try {
            d = sb.build(f);
            //Recuperamos o elemento root  
            Element nfe = d.getRootElement();

            //Recuperamos os elementos filhos (children)  
            List elements = nfe.getChildren();
            Iterator i = elements.iterator();

            //Iteramos com os elementos filhos, e filhos do dos filhos  
            while (i.hasNext()) {
                Element element = (Element) i.next();
                trataElement(element, codigo);
            
            }
            System.out.println("model nf" + modelNF);
           controllerNF.salvarNFController(modelNF);

        } catch (JDOMException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/

    public void lerarq(String pCaminho, int codigo) throws Exception {
        //Aqui você informa o nome do arquivo XML.
        File f = new File(pCaminho);

        //Criamos uma classe SAXBuilder que vai processar o XML
        SAXBuilder sb = new SAXBuilder();

        //Este documento agora possui toda a estrutura do arquivo.
        Document d;
        try {
            d = sb.build(f);
            //Recuperamos o elemento root
            Element nfe = d.getRootElement();

            //Recuperamos os elementos filhos (children)
            List elements = nfe.getChildren();
            Iterator i = elements.iterator();

            //Iteramos com os elementos filhos, e filhos do dos filhos
            while (i.hasNext()) {
                Element element = (Element) i.next();
                trataElement(element, codigo);

            }
            System.out.println("model nf" + modelNF);
            controllerNF.salvarNFController(modelNF);

        } catch (JDOMException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lerarqCompra(String pCaminho) throws Exception {
     
        //Aqui você informa o nome do arquivo XML.  
        File f = new File(pCaminho);
        System.out.println(pCaminho + "CAMINHO");

        //Criamos uma classe SAXBuilder que vai processar o XML  
        SAXBuilder sb = new SAXBuilder();

        //Este documento agora possui toda a estrutura do arquivo.  
        Document d;
        try {
            d = sb.build(f);
            //Recuperamos o elemento root  
            Element nfe = d.getRootElement();

            //Recuperamos os elementos filhos (children)  
            List elements = nfe.getChildren();
            Iterator i = elements.iterator();

            //Iteramos com os elementos filhos, e filhos do dos filhos  
            while (i.hasNext()) {
                Element element = (Element) i.next();
                trataElementCompra(element);
                System.out.println(element + "ELEMENTO");
           
            }

        } catch (JDOMException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void trataElement(Element element, int codigo) throws Exception {
       
        //Recuperamos os atributos filhos (Attributes)  
        List atributes = element.getAttributes();
        Iterator i_atr = atributes.iterator();

        //Iteramos com os atributos filhos  
        while (i_atr.hasNext()) {
            Attribute atrib = (Attribute) i_atr.next();
            jtfNfe.setText(jtfNfe.getText() + "\n" + "\n" + traduzirXmlNfe.traduzir(atrib.getName()) + ": " + atrib.getValue());
            
        }
        //Recuperamos os elementos filhos (children)  
        List elements = element.getChildren();
        Iterator it = elements.iterator();
        

        //Iteramos com os elementos filhos, e filhos do dos filhos  
        while (it.hasNext()) {
            
            BLMascaras bLMascaras = new BLMascaras();
            
            Element el = (Element) it.next();
            listaNfe = new ArrayList<>();
            
            jtfNfe.setText(jtfNfe.getText() + "\n" + traduzirXmlNfe.traduzir(el.getName()) + ": " + el.getText());
            trataElement(el, codigo);
            modelNF.setCodBanco(0);
            modelNF.setEmpresa(1);
            modelNF.setCodCliente(1);
            if (el.getName().equals("nNF")){modelNF.setNumeroNfe(el.getValue());System.out.println("nNfe");}
            if (el.getName().equals("pag")){modelNF.setCodTipoDoc((el.getValue()).substring(1,2));System.out.println("pag");}
            if (el.getName().equals("mod")){modelNF.setModelonfe(el.getValue());System.out.println("mod");}
            if (el.getName().equals("serie")){modelNF.setSerieNfe(el.getValue());System.out.println("serie");}
            if (el.getName().equals("transp")){modelNF.setCodTransportadora(Integer.parseInt(el.getValue()));System.out.println("transp");}
            if (el.getName().equals("tPag")){modelNF.setCodFormaPgto(Integer.parseInt(el.getValue()));System.out.println("tPag");}
            if (el.getName().equals("finNFe")){modelNF.setFinNfe(el.getValue());System.out.println("finNfe");}
            if (el.getName().equals("tpEmis")){modelNF.setTpemis(el.getValue());System.out.println("tpEmis");}
            if (el.getName().equals("xNome")){modelNF.setCodCliente(controllerCliente.getClienteController(el.getValue()).getCodigo());System.out.println("xNome");}
            if (el.getName().equals("tpAmb")){modelNF.setTpamb(el.getValue());System.out.println("tbAmb");}
            if (el.getName().equals("vProd")){modelNF.setValorProdutos(Float.parseFloat(el.getValue()));System.out.println("vProd");}
            if (el.getName().equals("vPag")){modelNF.setValorTotal(Float.parseFloat(el.getValue()));System.out.println("vPag");}
            if (el.getName().equals("vDesc")){modelNF.setValorDescontos(Float.parseFloat(el.getValue()));System.out.println("vDesc");}
            if (el.getName().equals("nNFe")){modelNF.setNumeroNfe(el.getValue());System.out.println("nNfe");System.out.println("nNfe");}
            if (el.getName().equals("chNFe")){modelNF.setChaveNfe(el.getValue());System.out.println(el.getValue()+"chNfe");}
            if (el.getName().equals("vBC")){modelNF.setIcmsBc(Float.parseFloat(el.getValue()));System.out.println("vBC");}
            if (el.getName().equals("vICMS")){modelNF.setIcmsVlr(Float.parseFloat(el.getValue()));System.out.println("vICMS");}
            if (el.getName().equals("vIPI")){modelNF.setIpiVlr(Float.parseFloat(el.getValue()));System.out.println("vIPI");}
            if (el.getName().equals("vPIS")){modelNF.setPisVlr(Float.parseFloat(el.getValue()));System.out.println("vPIS");}
            if (el.getName().equals("vCOFINS")){modelNF.setCofinsVlr(Float.parseFloat(el.getValue()));System.out.println("vCOFINS");}
            if (el.getName().equals("vICMS")){modelNF.setVtottrib(Float.parseFloat(el.getValue()));System.out.println("vICMS");}
            if (el.getName().equals("qrCode")){modelNF.setQrcode(el.getValue());System.out.println("vqrCode");}
            if (el.getName().equals("xMotivo")){modelNF.setMotivoNfe(el.getValue());System.out.println("xMotivo");}
            if (el.getName().equals("cStat")){modelNF.setStatusNfe(el.getValue());System.out.println(el.getValue() +"   cStat");}
            if (el.getName().equals("cStat")){modelNF.setStatusNfe(el.getValue());System.out.println(el.getValue() +"   cStat");}
                                    
           
            modelNF.setCodTransportadora(1);
            modelNF.setPedido(codigo);
            modelNF.setPedidoCliente(String.valueOf(codigo));
            modelNF.setDataDigitacao(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelNF.setDataDevolucao(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelNF.setDataCancelamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelNF.setDataEmissao(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelNF.setUfPlaca("ES");
            
             
            listaNfe.add(modelNF);
        }

     
    }
    public void trataElementCompra(Element element) throws Exception {
            //Recuperamos os atributos filhos (Attributes)  
        List atributes = element.getAttributes();
        Iterator i_atr = atributes.iterator();

        //Iteramos com os atributos filhos  
        while (i_atr.hasNext()) {
            Attribute atrib = (Attribute) i_atr.next();
            jtfNfe.setText(jtfNfe.getText() + "\n" + "\n" + traduzirXmlNfe.traduzir(atrib.getName()) + ": " + atrib.getValue());
            
        }
        //Recuperamos os elementos filhos (children)  
        List elements = element.getChildren();
        Iterator it = elements.iterator();
        

        //Iteramos com os elementos filhos, e filhos do dos filhos  
        while (it.hasNext()) {
            
            BLMascaras bLMascaras = new BLMascaras();
        
            Element el = (Element) it.next();
                        
            trataElementCompra(el);
            ModelComprasProdutos mcp = new ModelComprasProdutos();
            ModelFornecedor mf = new ModelFornecedor();
            ControllerEstado ce = new ControllerEstado();
            listaComprados = new ArrayList<>();
            listaFornecedor = new ArrayList<>();
            listaNfe = new ArrayList<>();
            System.out.println("entrou no while next");
            if (el.getName().equals("nNF")){modelNF.setNumeroNfe(el.getValue());}
            if (el.getName().equals("mod")){modelNF.setCodTipoDoc((el.getValue()).substring(1,2));}
            if (el.getName().equals("mod")){modelNF.setModelonfe(el.getValue());}
            if (el.getName().equals("serie")){modelNF.setSerieNfe(el.getValue());}
            if (el.getName().equals("tPag")){
            modelNF.setCodFormaPgto(Integer.parseInt(el.getValue()));
            tipoPagamento = Integer.parseInt(el.getValue());
            }
            
            if (el.getName().equals("finNFe")){modelNF.setFinNfe(el.getValue());}
            if (el.getName().equals("tpEmis")){modelNF.setTpemis(el.getValue());}
            if (el.getName().equals("tpAmb")){modelNF.setTpamb(el.getValue());}
            if (el.getName().equals("vProd")){modelNF.setValorProdutos(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vNF")){modelNF.setValorTotal(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vDesc")){modelNF.setValorDescontos(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("nNFe")){modelNF.setNumeroNfe(el.getValue()); numeronfe = el.getValue();}
            if (el.getName().equals("chNFe")){modelNF.setChaveNfe(el.getValue());}
            if (el.getName().equals("vBC")){modelNF.setIcmsBc(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vICMS")){modelNF.setIcmsVlr(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vIPI")){modelNF.setIpiVlr(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vPIS")){modelNF.setPisVlr(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vCOFINS")){modelNF.setCofinsVlr(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vICMS")){modelNF.setVtottrib(Float.parseFloat(el.getValue()));}
            if (el.getName().equals("vST")){modelNF.setICMSSubst(el.getValue());}
            if (el.getName().equals("vBCST")){modelNF.setBCSubst(el.getValue());}
            if (el.getName().equals("vOutro")){modelNF.setOutros(el.getValue());}
            if (el.getName().equals("qrCode")){modelNF.setQrcode(el.getValue());}
            if (el.getName().equals("xMotivo")){modelNF.setMotivoNfe(el.getValue());}
            if (el.getName().equals("cStat")){modelNF.setStatusNfe(el.getValue());}
            if (el.getName().equals("dhEmi")){modelNF.setDataEmissao(bLMascaras.converterDataStringDataHifen(el.getValue().substring(0,10)));}
            if (el.getName().equals("dhSaiEnt")){modelNF.setDataDigitacao(bLMascaras.converterDataStringDataHifen(el.getValue().substring(0,10)));}
            if (el.getName().equals("dhSaiEnt")){modelNF.setDataDigitacao(bLMascaras.converterDataStringDataHifen(el.getValue().substring(0,10)));}
            
            
            listaNfe.add(modelNF);
            
            if(el.getName().equals("fat")){
                int tamanhofat = el.getContent().size();
                for (int j=0; j < tamanhofat; j++){
                        if (el.getChildren().get(j).getName().equals("nFat")){
                            descricaoConta = ("Lançada automaticamente pela entrada da nfe" + el.getChildren().get(j).getValue());
                            codigoConta = el.getChildren().get(j).getValue();
                        }
                }
            }
            if( el.getName().equals("dup")){               
                    int tamanhodup = el.getContent().size();
                    for (int i=0; i < tamanhodup; i++){
                        
                        if (el.getChildren().get(i).getName().equals("dVenc")){
                            dataVencimento = (el.getChildren().get(i).getValue());
                        }
                        if (el.getChildren().get(i).getName().equals("vDup")){
                            valorFatura = (Float.parseFloat(el.getChildren().get(i).getValue()));
                        }
                        if (el.getChildren().get(i).getName().equals("nDup")){
                           controlecp = codigoConta;
                            
                        }
                       
            }
            }
            
           if (!(controlecp.equals(codigoConta))){
            ModelContaPagar modelContaPagar = new ModelContaPagar();    
            modelContaPagar.setDescricao(descricaoConta);
            modelContaPagar.setSituacao(0);
            modelContaPagar.setTipoConta("PAGAR");
            modelContaPagar.setTipoPagamento(4);
            modelContaPagar.setValor(valorFatura);
            modelContaPagar.setVencimento(bLMascaras.converterDataStringDataHifen(dataVencimento));
            modelContaPagar.setDocOrigem(numeronfe);
            modelContaPagar.setData(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            modelContaPagar.setPagamento(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
           
            listaContaPagar.add(modelContaPagar);
            
           controlecp = codigoConta;
           
           }
           
           if (el.getName().equals("IPITrib")){
            int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("vIPI")){
                valorIpi = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pIPI")){
                percIpi = (el.getChildren().get(i).getValue());
            }
            }
            }
            
            if (el.getName().equals("prod")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
                if (el.getChildren().get(i).getName().equals("cEAN")){
                barras = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("cProd")){
                codProdutoFornecedor = (el.getChildren().get(i).getValue());}
           
            else if (el.getChildren().get(i).getName().equals("xProd")){
                nomeProduto = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("qCom")){
                quantidade = (Float.parseFloat(el.getChildren().get(i).getValue()));}
           
            else if (el.getChildren().get(i).getName().equals("NCM")){
                ncm = (el.getChildren().get(i).getValue());}
            
            else if (el.getChildren().get(i).getName().equals("CEST")){
                cest = (el.getChildren().get(i).getValue());}
            
            else if (el.getChildren().get(i).getName().equals("CFOP")){
                cfop = (el.getChildren().get(i).getValue());
                
            }
            else if (el.getChildren().get(i).getName().equals("uCom")){
                unidade = (el.getChildren().get(i).getValue());
                
            }
            else if (el.getChildren().get(i).getName().equals("vUnCom")){
                valorUnitarioProduto = Float.parseFloat(el.getChildren().get(i).getValue());
                
            }
            else if (el.getChildren().get(i).getName().equals("vProd")){
                valorTotalProduto = Float.parseFloat(el.getChildren().get(i).getValue());
                
            }
            }
            }
            
            else if( el.getName().equals("ICMS")){
            int tamanho = el.getContent().size();
            
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            mcp.setCst("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }
            }
            else if( el.getName().equals("ICMS10")){
            int tamanho = el.getContent().size();
            
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBCST")){
                valorBCST = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }
            }
            
            else if (el.getName().equals("ICMS20")){
            int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
                System.out.println("entro na base");
            }
                        
            }
            }
            else if (el.getName().equals("ICMS30")){
            int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }
            }
            else if (el.getName().equals("ICMS40")){
            int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
                
            }
            else if (el.getName().equals("ICMS50")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
                
            }
            
            else if (el.getName().equals("ICMS60")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBCST")){
                valorBCST = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
                
            }
            
            else if (el.getName().equals("ICMS70")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBCST")){
                valorBCST = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
                System.out.println("entro na base");
            }            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            }    
            }
            if (el.getName().equals("ICMS80")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
            }
            else if (el.getName().equals("ICMS90")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
            }
            else if (el.getName().equals("ICMS00")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CST")){
            cst = ("0"+(el.getChildren().get(i).getValue()));
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
            }
            else if (el.getName().equals("ICMSSN101")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CSOSN")){
            cst = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }    
            }
            else if (el.getName().equals("ICMSSN102")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CSOSN")){
            cst = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());

            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }
            }
            else if (el.getName().equals("ICMSSN500")){
                int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CSOSN")){
            cst = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
            }
            
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vBCST")){
                valorBCST = (el.getChildren().get(i).getValue());
            }
            }
            }
            else if (el.getName().equals("ICMSSN900")){
             int tamanho = el.getContent().size();
            for (int i=0; i < tamanho; i++){
            if (el.getChildren().get(i).getName().equals("CSOSN")){
            cst = (el.getChildren().get(i).getValue());
            }
            else if (el.getChildren().get(i).getName().equals("vICMS")){
                valorSN = (el.getChildren().get(i).getValue());
                
            }
            else if (el.getChildren().get(i).getName().equals("pICMS")){
                percSN = (el.getChildren().get(i).getValue());
                
            }
            else if (el.getChildren().get(i).getName().equals("vBC")){
                valorBCICMS = (el.getChildren().get(i).getValue());
            }
            }
            }
            
            if(el.getName().equals("COFINS")){
                if(percSN == null){
                 percSN = "0,00";
             }
                if(valorSN == null){
                 valorSN = "0,00";
             }   
                if(valorBCST == null){
                 valorBCST = "0,00";
             }   
                if(valorBCICMS == null){
                 valorBCICMS = "0,00";
             }   
                
                
              botao();
                mcp.setNcm(ncm);
                mcp.setCest(cest);
                mcp.setCst(cst);
                mcp.setPercCreditoSn(percSN);
                mcp.setValorCreditoSn(valorSN);
                mcp.setBaseCalculoSub(valorBCST);
                mcp.setBaseCalculoicms(valorBCICMS);
                mcp.setCfop(cfop);
                if(cfop.substring(0,2).equals("54")){
                    mcp.setCfopEstoque("1403");
                }else if(cfop.substring(0,2).equals("64")){
                    mcp.setCfopEstoque("2403");
                }else if (cfop.substring(0, 1).equals("5")){
                    mcp.setCfopEstoque("1102");
                }else if(cfop.substring(0, 1).equals("6")){
                    mcp.setCfopEstoque("2102");
                }
                mcp.setNomeProduto(nomeProduto);
                mcp.setValorIpi(valorIpi);
                mcp.setPercIpi(percIpi);
                mcp.setBarras(barras);
                mcp.setCodProdutoFornecedor(codProdutoFornecedor);
                mcp.setCodFornecedor(cnpj);
                mcp.setQuantidade(quantidade);
                mcp.setUnidade(unidade);
                mcp.setValorCusto(valorUnitarioProduto);
                mcp.setValorTotal(valorTotalProduto);
                mcp.setProcurarProduto(procuraProduto);
                mcp.setProcurarCfop(procuraCfop);
                mcp.setProcurarFator(procuraFator);
                mcp.setAdcionarProduto(adcionaProduto);
                listaComprados.add(mcp);
                
            }
            
            if(el.getName().equals("emit")){
                int tamanhoEmit = el.getContent().size();
            
                }
            
                if(el.getName().equals("enderEmit") || el.getName().equals("emit")){
               
                    int tamanhoTotal = tamanhoEmit + el.getContent().size();
                    for (int j=0; j < tamanhoTotal ; j++){
                    if (el.getChildren().get(j).getName().equals("CNPJ")){
                    cnpj = (el.getChildren().get(j).getValue()); }
                    if (el.getChildren().get(j).getName().equals("IE")){
                    ie = (el.getChildren().get(j).getValue()); }
                    else if (el.getChildren().get(j).getName().equals("xNome")){
                    nome = (el.getChildren().get(j).getValue());}
                    else if (el.getChildren().get(j).getName().equals("xFant")){
                    fantasia = (el.getChildren().get(j).getValue());}            
                    else if (el.getChildren().get(j).getName().equals("xLgr")){
                    rua = (el.getChildren().get(j).getValue());}    
                    //mf.setEndereco(el.getChildren().get(j).getValue());}
                    else if (el.getChildren().get(j).getName().equals("nro")){
                    numero = (el.getChildren().get(j).getValue());}    
                    //mf.setNumero(Integer.parseInt(el.getChildren().get(j).getValue()));}
                    else if (el.getChildren().get(j).getName().equals("xBairro")){
                    bairro = (el.getChildren().get(j).getValue());}
                    //mf.setBairro(el.getChildren().get(j).getValue());}
                    else if (el.getChildren().get(j).getName().equals("cMun")){
                    codCidade = (el.getChildren().get(j).getValue());}    
                    //mf.setCodCidade(Integer.parseInt(el.getChildren().get(j).getValue()));}
                    else if (el.getChildren().get(j).getName().equals("UF")){
                    uf = (ce.getEstadoUFController(el.getChildren().get(j).getValue()).getCodigo());}    
                    //mf.setCodEstado(ce.getEstadoUFController(el.getChildren().get(j).getValue()).getCodigo());}
                    else if (el.getChildren().get(j).getName().equals("CEP")){
                    cep = (el.getChildren().get(j).getValue());}    
                    //mf.setCep(el.getChildren().get(j).getValue());}
                    else if (el.getChildren().get(j).getName().equals("fone")){
                    //mf.setTelefone(el.getChildren().get(j).getValue());
                    telefone = (el.getChildren().get(j).getValue());}
                    }
                    }
             
                
            
            if(ie != null && controle == 0){
                   mf.setNome(nome);
                   mf.setNomeFantasia(fantasia);
                   mf.setCnpj(cnpj);
                   mf.setInscEstadual(ie);
                   mf.setTelefone(telefone);
                   mf.setCodCidade(Integer.parseInt(codCidade));
                   mf.setBairro(bairro);
                   mf.setEndereco(rua);
                   mf.setCep(cep);
                   try{
                       mf.setNumero(Integer.parseInt(numero));
                   }catch(NumberFormatException e) {
                       mf.setNumero(0) ;
                   }
                   
                   mf.setCodEstado(uf);
                   listaFornecedor.add(mf);
            
                   controle = 1;
            
            }
            
            classeInterfaces.avisaOuvintesProdutos("compra",listaComprados,listaNfe, listaFornecedor, listaContaPagar);
          } 
     
    }
        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLeitorNotaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLeitorNotaXML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtfNfe;
    // End of variables declaration//GEN-END:variables
}
