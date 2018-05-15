/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.FilialServlet;

import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Pessoa;
import java.io.IOException;
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
 * @author fernando.tsuda
 */
@WebServlet(name = "CadastroFilialServlet", urlPatterns = {"/cadastro-filial"})
public class CadastroFilialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (funcionario.getIdnivel() < 2) {
                response.sendRedirect("HomePage.jsp");
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

        Filial p1 = new Filial(nome, rua, Integer.parseInt(numero), Integer.parseInt(cep), Integer.parseInt(telefone), gerente);
        ControllerFilial con = new ControllerFilial();
        System.out.println("Gerente" + p1.getGerente());
        System.out.println("Unidade:" + p1.getNomeUnidade());
        System.out.println(numero);
        System.out.println(cep);
        System.out.println(telefone);
        System.out.println(gerente);

        try {

            con.incluir(p1);

        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }

        request.setAttribute("pessoaCadastrada", p1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Filial/resultadoCadastro.jsp");
        dispatcher.forward(request, response);

    }

}
