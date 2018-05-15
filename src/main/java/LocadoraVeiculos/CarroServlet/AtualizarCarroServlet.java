/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.CarroServlet;

import LocadoraVeiculos.Carro;
import LocadoraVeiculos.PlanoServlet.*;
import LocadoraVeiculos.FilialServlet.*;
import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.ControllerPlano;
import LocadoraVeiculos.DaoCarro;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Pessoa;
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
@WebServlet(name = "AtualizarCarro", urlPatterns = {"/AtualizarCarro"})
public class AtualizarCarroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtualizarFilial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AtualizarFilial at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }  

        String idcarro = request.getParameter("idcarro");
        String carro = request.getParameter("carro");
        String fabricante = request.getParameter("fabricante");
        String cor = request.getParameter("cor");
        String ano = request.getParameter("ano");
        String valor = request.getParameter("valor");
        String idclassificacao = request.getParameter("class");
        String metodo = request.getParameter("metodo");

        Carro p1 = new Carro(carro, fabricante, cor, Integer.parseInt(ano), Double.parseDouble(valor), Integer.parseInt(idclassificacao));
        p1.setIdcarro(Integer.parseInt(idcarro));

        DaoCarro con = new DaoCarro();

        try {
            if (metodo.equals("atualizar")) {

                con.atualizar(p1);

                request.setAttribute("carroUpdate", p1);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/Carro/resultadoAtualizar.jsp");
                dispatcher.forward(request, response);

            } else if (metodo.equals("deletar")) {
                con.excluir(p1.getIdcarro());

                request.setAttribute("carroUpdate", p1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Carro/resultadoDelete.jsp");
                dispatcher.forward(request, response);

            }

        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }

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
