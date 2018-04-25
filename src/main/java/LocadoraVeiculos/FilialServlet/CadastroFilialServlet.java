/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.FilialServlet;

import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.Filial;
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
        
        ControllerFilial p1 = new ControllerFilial();
        List<Filial> resultados = new ArrayList<Filial>();

        try {

            resultados = p1.listar();

            request.setAttribute("filiais", resultados);
            
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("ListarFilial.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println("Verifique o objeto");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String gerente = request.getParameter("gerente");

        Filial p1 = new Filial(nome, rua, Integer.parseInt(numero), Integer.parseInt(cep), Integer.parseInt(telefone), gerente);
        ControllerFilial con = new ControllerFilial();

        try {
            con.incluir(p1);
            System.out.println("Passou aqui");
        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }

        request.setAttribute("pessoaCadastrada", p1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);

    }

}
