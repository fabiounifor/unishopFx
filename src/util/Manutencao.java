/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Fabio
 */
public class Manutencao {
        private static void imprimirMemoria(){
       Runtime runtime = Runtime.getRuntime(); //singleton 
       final int MB = 1024 * 1024;
       
        System.out.println("MEMORIA UTILIZADA "+((runtime.totalMemory() - runtime.freeMemory())/MB));
       
   }
    
}
