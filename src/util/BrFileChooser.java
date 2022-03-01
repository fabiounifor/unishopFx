/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Br
 */
public class BrFileChooser {

    private JFileChooser fileChooser;
    private String caminhoImagem;
    private File arquivo;

    public BrFileChooser() {
    }

    public File getArquivo(Component pDialogo, String pOptions, String pFiltro) {
        this.fileChooser = new JFileChooser("C:\\UniShop\\imgProdutos");  //Cria uma instância do JFileChooser
        FileNameExtensionFilter filter = new FileNameExtensionFilter(pOptions, pFiltro);  //Cria um filtro
        this.fileChooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
        int returnVal = this.fileChooser.showOpenDialog(pDialogo); //Abre o diálogo JFileChooser
        File file = new File("");
        if (returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
            file = this.fileChooser.getSelectedFile();
            this.caminhoImagem = this.fileChooser.getSelectedFile().getAbsolutePath();
            return file;
        }
        return file;
    }

    public boolean criarArquivo(Component pDialogo, String pOptions, String pFiltro) {
        this.fileChooser = new JFileChooser();  //Cria uma instância do JFileChooser
        FileNameExtensionFilter filter = new FileNameExtensionFilter(pOptions, pFiltro);  //Cria um filtro
        this.fileChooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
        int returnVal = this.fileChooser.showOpenDialog(pDialogo); //Abre o diálogo JFileChooser
        if (returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
            this.arquivo = this.fileChooser.getSelectedFile();
            this.caminhoImagem = this.fileChooser.getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public String getDiretorio(Component pDialogo, String pOptions, String pFiltro) {
        String diretorio = "";
        this.fileChooser = new JFileChooser();  //Cria uma instância do JFileChooser
        int returnVal = this.fileChooser.showOpenDialog(pDialogo); //Abre o diálogo JFileChooser
        File selected = this.fileChooser.getSelectedFile();
        if (selected.isDirectory()) {
            diretorio = selected.getParentFile().toString();
        }
        return diretorio;
//            File file = new File("");
//            if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
//                file = this.fileChooser.getSelectedFile();
//                this.caminhoImagem = this.fileChooser.getSelectedFile().getAbsolutePath();
//                return file;
//            }
//            return file;
    }
    
    
    public String copiarImagem(String pCaminho) {
       String caminhoCompleto="";
        try {
            Date dataDoDia = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("ddMMyyyyHHmmss");
            FileInputStream origem;
            FileOutputStream destino;
            FileChannel fcOrigem;
            FileChannel fcDestino;
            origem = new FileInputStream(pCaminho);//arquivo que você quer copiar
            caminhoCompleto = "C:\\UniShop\\imgProdutos\\produto"+ dt.format(dataDoDia) + ".jpg";
            destino = new FileOutputStream(caminhoCompleto);
//onde irá ficar a copia do aquivo
            fcOrigem = origem.getChannel();
            fcDestino = destino.getChannel();
            fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);//copiando o arquivo e salvando no diretório que você escolheu
            origem.close();
            destino.close();
            return caminhoCompleto;
        } catch (Exception e) {
            return "imagem não encontrada";
        }
    }

    /**
     * @return the fileChooser
     */
    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    /**
     * @param fileChooser the fileChooser to set
     */
    public void setFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    /**
     * @return the caminhoImagem
     */
    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    /**
     * @param caminhoImagem the caminhoImagem to set
     */
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    /**
     * @return the arquivo
     */
    public File getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
}
