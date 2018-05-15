/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PedidoServlet;

import LocadoraVeiculos.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.frocha6
 */
@WebServlet(name = "AtualizarPedido", urlPatterns = {"/AtualizarPedido"})
public class AtualizarPedidoServlet extends HttpServlet {

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
            out.println("<title>Servlet Pedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Pedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    
//        String Id = request.getParameter("id_pedido");
//        String IdPessoa = request.getParameter("id_cliente");
//        String IdPlano = request.getParameter("id_plano");
//        String IdCarro = request.getParameter("id_carro");
//        String IdFuncionario = request.getParameter("id_funcionario");
//        String Idfilial = request.getParameter("id_filial");
//        String DataDevolucao = request.getParameter("dtlocacao");
//        String DiasAlugados = request.getParameter("dias_alugados");
//        String Status = request.getParameter("ped_status");
//        String ValorTotal = request.getParameter("vlr_total");
//        
//        System.out.println(ValorTotal + " esse é o valor");
//        
//        Pedido pe = new Pedido (Integer.parseInt(DiasAlugados))
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
