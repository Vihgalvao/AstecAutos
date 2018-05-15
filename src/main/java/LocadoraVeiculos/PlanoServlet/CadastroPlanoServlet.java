/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PlanoServlet;

import LocadoraVeiculos.FilialServlet.*;
import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.ControllerPlano;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Plano;
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
@WebServlet(name = "CadastroPlanoServlet", urlPatterns = {"/cadastro-plano"})
public class CadastroPlanoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    request.getRequestDispatcher("Plano/form-plano-cadastro.jsp").forward(request, response);  

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String plano = request.getParameter("plano");
        String id_classificao = request.getParameter("class");
        String valor = request.getParameter("valor");

        Plano p1 = new Plano(plano, Integer.parseInt(id_classificao), Double.parseDouble(valor));
        ControllerPlano con = new ControllerPlano();

        try {
            con.incluir(p1);

        } catch (Exception e) {

        }

        request.setAttribute("planoCadastrado", p1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("Plano/resultadoCadastro.jsp");
        dispatcher.forward(request, response);

    }

}
