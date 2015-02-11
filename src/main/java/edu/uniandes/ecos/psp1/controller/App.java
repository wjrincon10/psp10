/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp1.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import java.net.URI;
import java.net.URISyntaxException;

import edu.uniandes.ecos.psp1.view.MainView;
import edu.uniandes.ecos.psp1.model.CalcularDatos;
import java.util.LinkedList;

/**
 *
 * @author Administrador
 */
public class App extends HttpServlet{
    
    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req,resp);
       // MainView.showResults(req,resp,0.0," ",0.0);       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        try {
            MainView.showHome(req,resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void consoleInput(HttpServletRequest req, HttpServletResponse resp) throws Exception {
         try{
             int cant=0;
        //System.out.println("Por favor, ingrese la cantidad de numeros que desea ingresar:");
        //Scanner input = new Scanner(System.in);
        String calcx = req.getParameter("calcx");
        String calcy = req.getParameter("calcy");

        String[] strElementsX = calcx.split(" ");
        String[] strElementsY = calcy.split(" ");
        
        Double nextElementX = 0D;
        Double nextElementY = 0D;
        
        LinkedList<Double> numbersListX = new LinkedList<Double>();
        LinkedList<Double> numbersListY = new LinkedList<Double>();
        
        CalcularDatos calcDatos = new CalcularDatos();
        //StatisticCalculator calculator = new StatisticCalculator();

        for (String strElement : strElementsX) {
            try {
                nextElementX = Double.valueOf(strElement);
                numbersListX.add(nextElementX);
                cant++;
            }catch(NumberFormatException ex){
                MainView.error(req, resp);
            }
        }
        
        for (String strElement : strElementsY) {
            try {
                nextElementY = Double.valueOf(strElement);
                numbersListY.add(nextElementY);
                
            }catch(NumberFormatException ex){
                MainView.error(req, resp);
            }
        }
           
        calcDatos.setInputData(numbersListX, numbersListY);
        calcDatos.InicializarData(cant);
        
        calcDatos.CalcularB1();
        calcDatos.CalcularB0();        
        calcDatos.CalcularRxy();
        calcDatos.CalcularR2();
        calcDatos.CalcularYk();
        
        MainView.showResults(req, resp,  numbersListX.toString(), numbersListY.toString(),calcDatos.B0,calcDatos.B1,calcDatos.Rxy,calcDatos.R2,calcDatos.Yk,calcDatos.Dato1Exp2,calcDatos.Dato1Exp2);
       }catch(Exception ex){
         MainView.error(req, resp);
       }
    }

}
