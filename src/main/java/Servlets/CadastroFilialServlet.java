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
 * @author fernando.tsuda
 */
@WebServlet(name = "CadastroFilialServlet", urlPatterns = {"/cadastro-filial"})
public class CadastroFilialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            if (funcionario.getIdnivel() < 2) {
                request.getRequestDispatcher("WEB-INF/HomePage.jsp").forward(request, response);
            }
        }
      

        request.getRequestDispatcher("WEB-INF/Filial/form-filial-cadastro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (funcionario.getIdnivel() < 2) {
                response.sendRedirect("HomePage.jsp");
            }
        }

        String nome = request.getParameter("nome");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String gerente = request.getParameter("gerente");
        String idestado = request.getParameter("estado");

        Filial p1 = new Filial(nome, rua, Integer.parseInt(numero), Integer.parseInt(cep), Integer.parseInt(telefone), gerente);
        DaoFilial con = new DaoFilial();
        
        p1.setIdestado(Integer.parseInt(idestado));

        try {

            con.incluir(p1);

        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }

        request.setAttribute("filialCadastrada", p1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Filial/resultadoCadastro.jsp");
        dispatcher.forward(request, response);

    }

}
