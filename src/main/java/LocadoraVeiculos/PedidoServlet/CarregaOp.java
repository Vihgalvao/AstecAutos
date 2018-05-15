/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PedidoServlet;

import LocadoraVeiculos.Carro;
import LocadoraVeiculos.ControllerFilial;
import LocadoraVeiculos.ControllerPlano;
import LocadoraVeiculos.DaoCarro;
import LocadoraVeiculos.Filial;
import LocadoraVeiculos.Plano;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.galvao
 */
@WebServlet(name = "CarregaOp", urlPatterns = {"/CarregaOp"})
public class CarregaOp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarregaOp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarregaOp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idclass = request.getParameter("class");

        int id = Integer.parseInt(idclass.substring(1, 2));

        ControllerFilial daoFilial = new ControllerFilial();

        DaoCarro daoCarro = new DaoCarro();
        ControllerPlano daoPlano = new ControllerPlano();

        List<Carro> listaCarro2 = new ArrayList<Carro>();
        List<Plano> listaPlano2 = new ArrayList<Plano>();
        List<Filial> listaFilial = new ArrayList<Filial>();

        try {
            List<Carro> listaCarro = daoCarro.listar();
            List<Plano> listaPlano = daoPlano.listar();
            listaFilial = daoFilial.listar();
            
            for (Carro car : listaCarro) {
                int idclasOut = car.getIdclassificacao();
                if (idclasOut == id) {
                    listaCarro2.add(car);
                }
            }

            for (Plano plan : listaPlano) {
                int idclasOut = plan.getIdclassificacao();
                if (idclasOut == id) {
                    listaPlano2.add(plan);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Verique o Retorno da Listagem.");
        } catch (SQLException ex) {
            System.out.println("Verique o Retorno da Listagem.");
        }

        request.setAttribute("listaFilial", listaFilial);
        request.setAttribute("listaCarro2", listaCarro2);
        request.setAttribute("listaPlano2", listaPlano2);

        request.getRequestDispatcher("Filial/form-pedido-cadastro.jsp").forward(request, response);
    }
}
