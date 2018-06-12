/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoCarro;
import Dao.DaoPedido;
import Model.Carro;
import Model.Pedido;
import Model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.galvao
 */
@WebServlet(name = "ListarPedidosServlet", urlPatterns = {"/ListarPedidosServlet"})
public class ListarPedidosServlet extends HttpServlet {

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
            out.println("<title>Servlet ListarPedidosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarPedidosServlet at " + request.getContextPath() + "</h1>");
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

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }

        request.getRequestDispatcher("WEB-INF/Pedido/ListarPedido.jsp").forward(request, response);

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
        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DaoPedido con = new DaoPedido();
        List<Pedido> lista = new ArrayList<Pedido>();

        String dtini = request.getParameter("dtini");
        String dtfim = request.getParameter("dtfim");
        String status = request.getParameter("status");

        java.sql.Date data1 = null;
        java.sql.Date data2 = null;
        try {
            data1 = new java.sql.Date(format.parse(dtini).getTime());
            data2 = new java.sql.Date(format.parse(dtfim).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(CadastroClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            lista = con.listar(Integer.parseInt(status), data1, data2);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarCarrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarCarrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("lista", lista);
        request.getRequestDispatcher("WEB-INF/Pedido/ListarPedido.jsp").forward(request, response);
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
