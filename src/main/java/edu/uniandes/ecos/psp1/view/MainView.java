package edu.uniandes.ecos.psp1.view;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class MainView {
    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP 1.0 Program!</h1>");
        
        pw.write("<form action=\"calc\" method=\"post\"> \n" +
                "    Ingrese los numeros X: <input type=\"text\" name=\"calcx\">\n" +
                "    Ingrese los numeros Y: <input type=\"text\" name=\"calcy\">\n" +
                "    <input type=\"submit\" value=\"Calc\">\n" +
                "</form> ");
        pw.write("</html>");

    }
    
    public static void showResults(HttpServletRequest req, HttpServletResponse resp,  String valuesX, String valuesY, Double B0, Double B1, Double Rxy, Double R2, Double Yk)
            throws ServletException, IOException {
        resp.getWriter().println("<b>List X:</b> "+valuesX +"<br>");
        resp.getWriter().println("<b>List Y:</b> "+valuesY +"<br>");        
        resp.getWriter().println("<b>B0:</b> "+ B0 + "<br>");
        resp.getWriter().println("<b>B1:</b> "+ B1 + "<br>");
        resp.getWriter().println("<b>Rxy:</b> "+ Rxy + "<br>");
        resp.getWriter().println("<b>R2:</b> "+ R2 + "<br>");
        resp.getWriter().println("<b>Yk:</b> "+ Yk + "<br>");
        //resp.getWriter().println("<b>STD: </b> "+stdDev + "<br>");
    }
    
    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }
}
