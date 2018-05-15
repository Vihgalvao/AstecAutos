/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.FuncionarioServlet;


import LocadoraVeiculos.DaoPessoa;
import LocadoraVeiculos.Pessoa;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iago.cguimaraes
 */
@WebServlet(name = "AutenticarFuncionario", urlPatterns = {"/Autenticar"})
public class AutenticarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.removeAttribute("msg");
        
        try {

            String cpf = request.getParameter("login");
            String senha = request.getParameter("senha");
            Pessoa funcionario = DaoPessoa.logar(cpf, senha);
            int id = funcionario.getId();
           
            if (id > 0) {

                request.getSession().setAttribute("funcionario", funcionario);
                request.getRequestDispatcher("./HomePage.jsp").forward(request, response);

            } else {
                request.setAttribute("msg", "Usuário e Senha Inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println("Error --> "+ e);
            request.setAttribute("msg", "Algo de Errado Ocorreu: "+ e);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
    }

}
