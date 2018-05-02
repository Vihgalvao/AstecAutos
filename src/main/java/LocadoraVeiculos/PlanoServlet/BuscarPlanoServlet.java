/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PlanoServlet;

import LocadoraVeiculos.FilialServlet.*;
import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.ControllerPlano;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Plano;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.gsgalvao
 */
@WebServlet(name = "BuscarPlanoServlet", urlPatterns = {"/buscar-plano"})
public class BuscarPlanoServlet extends HttpServlet {


    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idfilial = request.getParameter("id_plano");
        int id = Integer.parseInt(idfilial.substring(1,2));
        ControllerPlano con = new ControllerPlano();
        Plano plano = new Plano();
        
        try {
            plano = con.select(id);

        } catch (Exception e) {
            
        }

        request.setAttribute("planoAtualizada", plano);
        request.getRequestDispatcher("Plano/form-plano-resultado.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idfilial = request.getParameter("idfilial");

        ControllerFilial con = new ControllerFilial();

        Filial filial = new Filial();

        try {

            filial = con.select(Integer.parseInt(idfilial));

        } catch (Exception e) {
        }

        request.setAttribute("pessoaAtualizada", filial);

        request.getRequestDispatcher("WEB-INF/Filial/form-filial-resultado.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
