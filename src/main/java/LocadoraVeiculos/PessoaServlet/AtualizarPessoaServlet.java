/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PessoaServlet;

import LocadoraVeiculos.CarroServlet.*;
import LocadoraVeiculos.Carro;
import LocadoraVeiculos.PlanoServlet.*;
import LocadoraVeiculos.FilialServlet.*;
import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.ControllerPlano;
import LocadoraVeiculos.DaoCarro;
import LocadoraVeiculos.DaoPessoa;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Pessoa;
import LocadoraVeiculos.Plano;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author victor.gsgalvao
 */
@WebServlet(name = "AtualizarPessoa", urlPatterns = {"/AtualizarPessoa"})
public class AtualizarPessoaServlet extends HttpServlet {

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

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String cpf = request.getParameter("cpf");
        String dtnascimento = request.getParameter("dtnascimento");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cnh = request.getParameter("cnh");
        String renda = request.getParameter("renda");
        String metodo = request.getParameter("metodo");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = null;

        try {
            data = new java.sql.Date(format.parse(dtnascimento).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(AtualizarPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        Pessoa p1 = new Pessoa();
        p1.setId(Integer.parseInt(id));
        p1.setNome(nome);
        p1.setSobrenome(sobrenome);
        p1.setRua(rua);
        p1.setNumero(Integer.parseInt(numero));
        p1.setCep(Integer.parseInt(cep));
        p1.setEstado(estado);
        p1.setCidade(cidade);
        p1.setCpf(Double.parseDouble(cpf));
        p1.setDataNasc((java.sql.Date) data);
        p1.setEmail(email);
        p1.setTelefone(Integer.parseInt(telefone));
        p1.setCnh(Double.parseDouble(cnh));
        p1.setRenda(Double.parseDouble(renda));

        DaoPessoa con = new DaoPessoa();

        try {
            if (metodo.equals("atualizar")) {

                con.atualizar(p1);
                con.atualizarCliente(p1);


                request.setAttribute("ClienteUpdate", p1);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("WEB-INF/Pessoa/resultadoAtualizar.jsp");
                dispatcher.forward(request, response);

            } else if (metodo.equals("deletar")) {
                con.excluir(p1.getId());

                request.setAttribute("ClienteUpdate", p1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Pessoa/resultadoDelete.jsp");
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
