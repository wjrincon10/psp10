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
public class CalcularDatos {
    static final int Xk = 386;
    public double B0;
    public double B1;
    public double Rxy;
    public double R2;
    public double Yk;
    private double MediaDato1;
    private double MediaDato2;
    private double MultiDatos;
    public double Dato1Exp2;
    public double Dato2Exp2;
    private double CantDatos;
    private double SumDato1;
    private double SumDato2;
    
    private LinkedList<Double> inputDataX;
    private LinkedList<Double> inputDataY;
    
    public CalcularDatos(){
        inputDataX = new LinkedList<Double>();
        inputDataY = new LinkedList<Double>();
    }
    
    public void setInputData(LinkedList<Double> inputX, LinkedList<Double> inputY)
    {
        this.inputDataX = inputX;
        this.inputDataY = inputY;
    }
    
    public void InicializarData(int cant){
        this.CantDatos= cant;
        MediaDato1 = Calcular.CalcularMedia(this.inputDataX);
        MediaDato2 = Calcular.CalcularMedia(this.inputDataY);
        MultiDatos = Calcular.CalcularMultDatos(this.inputDataX, this.inputDataY, cant);
        Dato1Exp2 = Calcular.CalcularDatoExp2(this.inputDataX);
        Dato2Exp2 = Calcular.CalcularDatoExp2(this.inputDataY);
        SumDato1 = Calcular.CalcularSumDato(this.inputDataX);
        SumDato2 = Calcular.CalcularSumDato(this.inputDataY);
    }
    
    public void CalcularB0(){
        double decB0=0;
        decB0 = this.MediaDato2 - (this.B1 * this.MediaDato1);
        this.B0 = decB0;
    }
    
    public void CalcularB1(){
        double decB1=0;
        
        decB1 = this.MultiDatos - (CantDatos * this.MediaDato1 * this.MediaDato2);
        decB1 = decB1 / (this.Dato1Exp2 - (this.CantDatos * Math.pow(this.MediaDato1,2)));
        
        this.B1 = decB1;
    }
    
    public void CalcularRxy(){
        double decRxy=0;
        double decDeno1=0;
        double decDeno2 = 0;
        
        decRxy = this.MultiDatos - (this.SumDato1 * this.SumDato2);
        decDeno1 = (this.Dato1Exp2) - Math.pow(this.SumDato1, 2);
        decDeno2 = ( this.Dato2Exp2) - Math.pow(this.SumDato2, 2);
        
        decRxy = decRxy / Math.sqrt(decDeno1 * decDeno2);
        
        this.Rxy = decRxy;
    }
    
    public void CalcularR2(){
        this.R2 = Math.pow(this.Rxy, 2);
    }
    
    public void CalcularYk(){
        this.Yk = this.B0 + (this.B1 * Xk);
    }
}
