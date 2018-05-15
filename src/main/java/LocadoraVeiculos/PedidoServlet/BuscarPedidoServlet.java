/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PedidoServlet;

import LocadoraVeiculos.DaoPedido;
import LocadoraVeiculos.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.frocha6
 */
@WebServlet(name = "BuscarPedidoServlet", urlPatterns = {"/buscar-pedido"})
public class BuscarPedidoServlet extends HttpServlet {

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
            out.println("<title>Servlet BuscarPedidoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarPedidoServlet at " + request.getContextPath() + "</h1>");
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
        
        
        String idpedido = request.getParameter("id_pedido");
        
        int id = Integer.parseInt(idpedido.substring(1,2));
        
        DaoPedido con = new DaoPedido();

        Pedido pedido = new Pedido();
        
        try {

            pedido = con.select(id);
            
             System.out.println("Chegou aqui");
            
        } catch (Exception e) {
            
        }
        
        request.setAttribute("pessoaAtualizada", pedido);

        request.getRequestDispatcher("Pedido/form-pedido-resultado.jsp").forward(request, response);

    
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

        String idpedido = request.getParameter("id_pedido");

        DaoPedido con = new DaoPedido();

        Pedido pedido = new Pedido();
        
        try {

            pedido = con.select(Integer.parseInt(idpedido));

        } catch (Exception e) {
        }

        request.setAttribute("pessoaAtualizada", pedido);

        request.getRequestDispatcher("WEB-INF/Pedido/form-pedido-resultado.jsp").forward(request, response);
        
        
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
