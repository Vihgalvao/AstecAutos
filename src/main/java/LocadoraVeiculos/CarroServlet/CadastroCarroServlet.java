/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.CarroServlet;

import LocadoraVeiculos.Carro;
import LocadoraVeiculos.DaoCarro;
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
@WebServlet(name = "CadastroCarroServlet", urlPatterns = {"/cadastro-carro"})
public class CadastroCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }
        request.getRequestDispatcher("WEB-INF/Carro/form-carro-cadastro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }

        String carro = request.getParameter("carro");
        String fabricante = request.getParameter("fabricante");
        String cor = request.getParameter("cor");
        String ano = request.getParameter("ano");
        String valor = request.getParameter("valor");
        String classe = request.getParameter("class");

        Carro p1 = new Carro(carro, fabricante, cor, Integer.parseInt(ano), Double.parseDouble(valor), Integer.parseInt(classe));
        DaoCarro con = new DaoCarro();

        try {
            con.incluir(p1);
            System.out.println("Carro add " + p1.getCarro());
        } catch (Exception e) {

        }

        request.setAttribute("carroCadastrado", p1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Carro/resultadoCadastro.jsp");
        dispatcher.forward(request, response);

    }

}
