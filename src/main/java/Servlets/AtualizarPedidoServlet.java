/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoPedido;
import Dao.DaoPlano;
import Model.Pedido;
import Model.Plano;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.frocha6
 */
@WebServlet(name = "AtualizarPedido", urlPatterns = {"/atualizar-pedido"})
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

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String idcliente = request.getParameter("id");
        String idpedido = request.getParameter("idpedido");
        String idplano = request.getParameter("plano2");
        String idcarro = request.getParameter("carro2");
        String idfun = request.getParameter("funcionario2");
        String idfilial = request.getParameter("filial2");
        String dtretirada = request.getParameter("dtretirada");
        String dtentrada = request.getParameter("dtdevolucao");
        String statuspedido = request.getParameter("statuspedido");

        System.out.println("Cliente: " + idcliente);
        System.out.println("Plano: " + idplano);
        System.out.println("carro: " + idcarro);
        System.out.println("Funcionario: " + idfun);
        System.out.println("Filial: " + idfilial);

        java.sql.Date dataRetirada2 = null;
        java.sql.Date dataEntrega2 = null;

        try {
            dataRetirada2 = new java.sql.Date(format.parse(dtretirada).getTime());
            dataEntrega2 = new java.sql.Date(format.parse(dtentrada).getTime());

        } catch (ParseException ex) {
            Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Retirada: " + dataRetirada2);
        System.out.println("Entrega: " + dataEntrega2);

        DaoPedido conn = new DaoPedido();
        DaoPlano planocon = new DaoPlano();
        Pedido pedido = new Pedido();
        Plano plano = new Plano();
        
        pedido.setId(Long.parseLong(idpedido));
        pedido.setIdpessoa(Integer.parseInt(idcliente));
        pedido.setIdplano(Integer.parseInt(idplano));
        pedido.setIdcarro(Integer.parseInt(idcarro));
        pedido.setIdfuncionario(Integer.parseInt(idfun));
        pedido.setIdfilial(Integer.parseInt(idfilial));
        pedido.setDtlocacao((java.sql.Date) dataRetirada2);
        pedido.setDtdevolucao((java.sql.Date) dataEntrega2);
        pedido.setStatus(Integer.parseInt(statuspedido));

        System.out.println("SETOU TUDO!");

        long diff = dataEntrega2.getTime() - dataRetirada2.getTime();
        int dia = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        try {

            plano = planocon.select(Integer.parseInt(idplano));
            double valorTotal = plano.getValor() * dia;

            pedido.setValortotal(valorTotal);
            pedido.setDiasAlugados(dia);

            conn.atualizar(pedido);
            System.out.println("Atualizou o pedido");

        } catch (Exception e) {

        }
        
        request.setAttribute("pedido", pedido);

        request.getRequestDispatcher("WEB-INF/Pedido/resultadoAtualizar.jsp").forward(request, response);

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
