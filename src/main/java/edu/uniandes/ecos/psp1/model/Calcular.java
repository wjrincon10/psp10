/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp1.model;

import java.util.LinkedList;

/**
 *
 * @author Administrador
 */
public class Calcular {
    public static double CalcularDesviacion(LinkedList<Double> lista, float media)
    {
        int cant =0;
        double acum =0;
        
        for (Double lista1 : lista) {
            acum = acum + Math.pow(lista1 - media,2);
            cant++;
        }
        
        cant--;
        return Math.sqrt((double)acum / cant);
    }
    
     public static double CalcularMedia(LinkedList<Double> lista)
    {
        int cant =0;
        double acum =0;
                
        for (Double lista1 : lista) {
            acum = acum + lista1;
            cant++;
        }
          
        return acum /cant;
    }
     
     public static double CalcularMultDatos(LinkedList<Double> lista1,LinkedList<Double> lista2,int cantidad){
        double acum =0;
          
        for(int i=0; i< cantidad; i++) {
             acum = acum + (lista1.get(i) * lista2.get(i));            
        }
        
        return acum;
     }
     
    public static double CalcularDatoExp2(LinkedList<Double> lista){
        double acum =0;
                
        for (Double lista1 : lista) {
            acum = acum + Math.pow(lista1, 2);
        }
          
        return acum ;
     }
    
    public static double CalcularSumDato(LinkedList<Double> lista){
        double acum =0;
                
        for (Double lista1 : lista) {
            acum = acum + lista1;
        }
          
        return Math.pow(acum, 2) ;
     }
}
