/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoCarro;
import Dao.DaoFilial;
import Dao.DaoPedido;
import Dao.DaoPessoa;
import Dao.DaoPlano;
import Model.Carro;
import Model.Filial;
import Model.Pedido;
import Model.Pessoa;
import Model.Plano;
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

        
        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }


        String idpedido = request.getParameter("idpedido");
        
        idpedido = idpedido.replace("\"", "");

        int id = Integer.parseInt(idpedido);

        DaoPedido con = new DaoPedido();
        Pedido pedido = new Pedido();
        Plano consultaPlan = new Plano();

        DaoFilial conFilial = new DaoFilial();
        List<Filial> filial = new ArrayList<Filial>();

        DaoPlano conPlano = new DaoPlano();
        List<Plano> plano = new ArrayList<Plano>();

        DaoPessoa conPessoa = new DaoPessoa();
        List<Pessoa> funcionario2 = new ArrayList<Pessoa>();

        DaoCarro conCarro = new DaoCarro();
        List<Carro> carro = new ArrayList<Carro>();

        Pessoa cliente = new Pessoa();

        try {
            
            
            pedido = con.select(id);
            consultaPlan = conPlano.select((int) pedido.getIdplano());
            
            filial = conFilial.listar();
            carro = conCarro.listarCarros(consultaPlan.getIdclassificacao());
            plano = conPlano.listarPlano(consultaPlan.getIdclassificacao());
            funcionario2 = conPessoa.listarFuncionario();
            cliente = conPessoa.selectId(pedido.getCpf());


        } catch (Exception e) {

        }

        request.setAttribute("carro", carro);
        request.setAttribute("plano", plano);
        request.setAttribute("filial", filial);
        request.setAttribute("funcionario2", funcionario2);
        request.setAttribute("cliente", cliente);
        request.setAttribute("pedido", pedido);
        


   request.getRequestDispatcher("WEB-INF/Pedido/form-resultado-pedido.jsp").forward(request, response);

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
