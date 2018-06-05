/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoFilial;
import Dao.DaoPessoa;
import Model.Filial;
import Model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "BuscarFuncionarioServlet", urlPatterns = {"/buscar-funcionario"})
public class BuscarFuncionarioServlet extends HttpServlet {

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

        String idcarro = request.getParameter("idfuncionario");
        
        idcarro = idcarro.replace("\"", "");
        
        int id = Integer.parseInt(idcarro);

        DaoPessoa con = new DaoPessoa();
        Pessoa pessoa = new Pessoa();

        DaoFilial conn = new DaoFilial();
        List<Filial> lista = new ArrayList<Filial>();

        try {

            pessoa = con.selectFuncionario(id);
            lista = conn.listar();
            
        } catch (Exception e) {

        }

        request.setAttribute("FuncionarioAtualizada", pessoa);
        request.setAttribute("filial", lista);

        request.getRequestDispatcher("WEB-INF/Funcionario/form-funcionario-atualizar.jsp").forward(request, response);

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
