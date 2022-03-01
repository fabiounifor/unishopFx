/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class classeInterfaces {
    
   public static ArrayList<aoMudarTela> ouvinte = new ArrayList();
   public static ArrayList<aoMudarTelaProdutos> ouvinteProdutos = new ArrayList();
   public static ArrayList<aoMudarTelaProgresso> ouvinteProgresso = new ArrayList();
   public static ArrayList<aoMudarTelaProdutoEntrada> ouvinteProdutoEntrada = new ArrayList();
   public static ArrayList<aoMudarTelaProdutoCodigo> ouvinteProdutoCodigo = new ArrayList();
   public static ArrayList<aoMudarTelaFatorEntrada> ouvinteFatorEntrada = new ArrayList();
   public static ArrayList<aoMudarTelaCfopEntrada> ouvinteCfopEntrada = new ArrayList();
   public static ArrayList<aoMudarTelaRejeicao> ouvinteRejeicao = new ArrayList();
   public static ArrayList<aoMudarTelaCaminho> ouvinteCaminho = new ArrayList();
   public static ArrayList<aoMudarTelaCodigoVenda> ouvinteCodigoVenda = new ArrayList();
   public static ArrayList<aoMudarTelaOpcionais> ouvinteOpcionais = new ArrayList();
   public static ArrayList<aoMudarTelaNcm> ouvinteNcm = new ArrayList();
   
   
    public static interface aoMudarTela{
        void telaModificada(String novaTela, String cliente);
    }
    public static interface aoMudarTelaNcm{
        void telaModificada(String novaTela, String Ncm);
    }
    public static interface aoMudarTelaOpcionais{
        void telaModificada(String novaTela, String opcionais);
    }
    public static interface aoMudarTelaCaminho{
        void telaModificadaCaminho(String novaTela, String caminho);
    }
    public static interface aoMudarTelaProgresso{
        void telaModificadaProgresso(String novaTela, Boolean ativo);
    }
    public static interface aoMudarTelaProdutos{
        void telaModificadaProdutos(String novaTela,ArrayList Produtos, ArrayList nfe, ArrayList fornecedor, ArrayList contasPagar);
    }
    public static interface aoMudarTelaProdutoEntrada{
        void telaModificadaProdutoEntrada(String novaTela,String ProdutoEntrada);
    }
    public static interface aoMudarTelaProdutoCodigo{
        void telaModificadaProdutoCodigo(String novaTela,int codigo);
    }
    public static interface aoMudarTelaFatorEntrada{
        void telaModificadaFatorEntrada(String novaTela,String FatorEntrada);
    }
    public static interface aoMudarTelaCfopEntrada{
        void telaModificadaCfopEntrada(String novaTela,String CfopEntrada);
    }
    public static interface aoMudarTelaRejeicao{
        void telaModificadaRejeicao(String novaTela,String retornoRejeicao);
    }
    public static interface aoMudarTelaCodigoVenda{
        void telaModificadaCodigoVenda(String novaTela,int codigoVenda);
    }
   public static void addaoMudarTelaOuvinte(aoMudarTela novoMudarTela){
       ouvinte.add(novoMudarTela);
   }
   public static void addaoMudarTelaNcm(aoMudarTelaNcm novoMudarTelaNcm){
       ouvinteNcm.add(novoMudarTelaNcm);
   }
   public static void addaoMudarTelaCaminho(aoMudarTelaCaminho novoMudarTelaCaminho){
       ouvinteCaminho.clear();
       ouvinteCaminho.add(novoMudarTelaCaminho);
   }
     public static void addaoMudarTelaOuvinteProgresso(aoMudarTelaProgresso novoMudarTelaProgresso){
       ouvinteProgresso.add(novoMudarTelaProgresso);
   }
     public static void addaoMudarTelaOuvinteOpcionais(aoMudarTelaOpcionais novoMudarTelaOpcionais){
       ouvinteOpcionais.add(novoMudarTelaOpcionais);
   }
   public static void addaoMudarTelaOuvinteProdutos(aoMudarTelaProdutos novoMudarTelaProdutos){
       ouvinteProdutos.add(novoMudarTelaProdutos);
   }
   public static void addaoMudarTelaOuvinteProdutoEntrada(aoMudarTelaProdutoEntrada novoMudarTelaProdutoEntrada){
       ouvinteProdutoEntrada.add(novoMudarTelaProdutoEntrada);
   }
   public static void addaoMudarTelaOuvinteProdutoCodigo(aoMudarTelaProdutoCodigo novoMudarTelaProdutoCodigo){
       ouvinteProdutoCodigo.add(novoMudarTelaProdutoCodigo);
   }
   
   public static void addaoMudarTelaOuvinteFatorEntrada(aoMudarTelaFatorEntrada novoMudarTelaFatorEntrada){
       ouvinteFatorEntrada.add(novoMudarTelaFatorEntrada);
   }
   public static void addaoMudarTelaOuvinteCfopEntrada(aoMudarTelaCfopEntrada novoMudarTelaCfopEntrada){
       ouvinteCfopEntrada.add(novoMudarTelaCfopEntrada);
   }
   public static void addaoMudarTelaRejeicao(aoMudarTelaRejeicao novoMudarTelaRejeicao){
       ouvinteRejeicao.add(novoMudarTelaRejeicao);
   }
   public static void addaoMudarTelaCodigoVenda(aoMudarTelaCodigoVenda novoMudarTelaCodigoVenda){
       ouvinteCodigoVenda.add(novoMudarTelaCodigoVenda);
   }
   
   public static void avisaOuvintes(String novaTela, String cliente){
       
       for(aoMudarTela l : ouvinte){
           l.telaModificada(novaTela, cliente);
       }
   }
   public static void avisaOuvintesNcm(String novaTela, String Ncm){
       
       for(aoMudarTelaNcm l : ouvinteNcm){
           l.telaModificada(novaTela, Ncm);
       }
   }
   public static void avisaOuvintesOpcionais(String novaTela, String opcionais){
       
       for(aoMudarTelaOpcionais l : ouvinteOpcionais){
           l.telaModificada(novaTela, opcionais);
       }
   }
  
   public static void avisaOuvintesCaminho(String novaTela, String caminho){
       
       for(aoMudarTelaCaminho l : ouvinteCaminho){
           l.telaModificadaCaminho(novaTela, caminho);
       }
   }
   
   public static void avisaOuvintesProgresso(String novaTela, Boolean ativo){
       
       for(aoMudarTelaProgresso l : ouvinteProgresso){
           l.telaModificadaProgresso(novaTela, ativo);
           
       }
       
   }
   public static void avisaOuvintesProdutos(String novaTela, ArrayList Produtos,ArrayList nfe, ArrayList fornecedor , ArrayList contasPagar){
       
       for(aoMudarTelaProdutos l : ouvinteProdutos){
           l.telaModificadaProdutos(novaTela,Produtos, nfe, fornecedor, contasPagar);
           
       }
       
   }
   public static void avisaOuvintesProdutoEntrada(String novaTela,String ProdutoEntrada){
       
       for(aoMudarTelaProdutoEntrada l : ouvinteProdutoEntrada){
           l.telaModificadaProdutoEntrada(novaTela,ProdutoEntrada);
           
       }
   }
   public static void avisaOuvintesProdutoCodigo(String novaTela,int codigo){
       
       for(aoMudarTelaProdutoCodigo l : ouvinteProdutoCodigo){
           l.telaModificadaProdutoCodigo(novaTela,codigo);
           
       }
   }
   public static void avisaOuvintesFatorEntrada(String novaTela, String FatorEntrada){
       
       for(aoMudarTelaFatorEntrada l : ouvinteFatorEntrada){
           l.telaModificadaFatorEntrada(novaTela,FatorEntrada);
           
       }
   }
   public static void avisaOuvintesCfopEntrada(String novaTela, String CfopEntrada){
       
       for(aoMudarTelaCfopEntrada l : ouvinteCfopEntrada){
           l.telaModificadaCfopEntrada(novaTela,CfopEntrada);
           
       }
   }
   public static void avisaOuvintesRejeicao(String novaTela, String Rejeicao){
       
       for(aoMudarTelaRejeicao l : ouvinteRejeicao){
           l.telaModificadaRejeicao(novaTela,Rejeicao);
           
       }
   }
   public static void avisaOuvintesCodigoVenda(String novaTela, int codigoVenda){
       
       for(aoMudarTelaCodigoVenda l : ouvinteCodigoVenda){
           l.telaModificadaCodigoVenda(novaTela,codigoVenda);
           
       }
   }
}
