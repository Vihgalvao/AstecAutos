/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoCarro;
import Dao.DaoFilial;
import Dao.DaoPessoa;
import Dao.DaoPlano;
import Model.Carro;
import Model.Filial;
import Model.Pessoa;
import Model.Plano;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.galvao
 */
@WebServlet(name = "IniciarPedidoServlet", urlPatterns = {"/IniciarPedidoServlet"})
public class IniciarPedidoServlet extends HttpServlet {

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
            out.println("<title>Servlet IniciarPedidoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IniciarPedidoServlet at " + request.getContextPath() + "</h1>");
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
        
        String cpf = request.getParameter("cpf");
        String id_classificao = request.getParameter("class");
        

        
        int id = Integer.parseInt(id_classificao);
        
        DaoFilial conFilial = new DaoFilial();
        List<Filial> filial = new ArrayList<Filial>();
        
        DaoPlano conPlano = new DaoPlano();
        List<Plano> plano = new ArrayList<Plano>();
        
        DaoPessoa conPessoa = new DaoPessoa();
        List<Pessoa> funcionario = new ArrayList<Pessoa>();
        
        DaoCarro conCarro = new DaoCarro();
        List<Carro> carro = new ArrayList<Carro>();
        
        Pessoa cliente = new Pessoa();
        
        try {
            filial = conFilial.listar();
            carro  = conCarro.listarCarros(id);
            plano  = conPlano.listarPlano(id);
            
            cliente = conPessoa.selectId(cpf);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IniciarPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IniciarPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("carro", carro);
        request.setAttribute("plano", plano);
        request.setAttribute("filial", filial);
        
        
        request.setAttribute("cliente", cliente);

        
        request.getRequestDispatcher("WEB-INF/Pedido/form-cadastro-pedido.jsp").forward(request, response);
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
