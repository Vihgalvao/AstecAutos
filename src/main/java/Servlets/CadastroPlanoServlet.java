/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoFilial;
import Dao.DaoPlano;
import Model.Filial;
import Model.Pessoa;
import Model.Plano;
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
@WebServlet(name = "CadastroPlanoServlet", urlPatterns = {"/cadastro-plano"})
public class CadastroPlanoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }

        request.getRequestDispatcher("WEB-INF/Plano/form-plano-cadastro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String plano = request.getParameter("plano");
        String idclass = request.getParameter("class");
        String valor = request.getParameter("valor");

        DaoPlano con = new DaoPlano();
        Plano plano2 = new Plano();

        plano2.setIdclassificacao(Integer.parseInt(idclass));
        plano2.setPlano(plano);
        plano2.setValor(Double.parseDouble(valor));

        try {
            con.incluir(plano2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroPlanoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPlanoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("pedido", plano2);

        request.getRequestDispatcher("WEB-INF/Plano/resultadoCadastro.jsp").forward(request, response);

    }

}
