/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.CarroServlet;

import LocadoraVeiculos.Carro;
import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.DaoCarro;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Pessoa;
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
@WebServlet(name = "BuscarCarroServlet", urlPatterns = {"/buscar-carro"})
public class BuscarCarroServlet extends HttpServlet {

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

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }  

        String idcarro = request.getParameter("idcarro");

        int id = Integer.parseInt(idcarro.substring(1, 2));

        DaoCarro con = new DaoCarro();

        Carro carro = new Carro();

        try {

            carro = con.select(id);

        } catch (Exception e) {

        }

        request.setAttribute("carroAtualizada", carro);

        request.getRequestDispatcher("WEB-INF/Carro/form-carro-resultado.jsp").forward(request, response);

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

        String idcarro = request.getParameter("idcarro");

        DaoCarro con = new DaoCarro();

        Carro carro = new Carro();

        try {

            carro = con.select(Integer.parseInt(idcarro));

        } catch (Exception e) {
        }

        request.setAttribute("pessoaAtualizada", carro);

        request.getRequestDispatcher("WEB-INF/Carro/form-carro-resultado.jsp").forward(request, response);

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
