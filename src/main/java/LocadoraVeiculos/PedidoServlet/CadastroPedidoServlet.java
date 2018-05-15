/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.PedidoServlet;

import LocadoraVeiculos.DaoPedido;
import LocadoraVeiculos.Pedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.frocha6
 */
@WebServlet(name = "CadastroPedidoServlet", urlPatterns = {"/cadastro-pedido"})
public class CadastroPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        DaoPedido conn = new DaoPedido();
        
        String idplano = request.getParameter("idplano");
        String idcarro = request.getParameter("idcarro");
        String idfilial = request.getParameter("idfilial");
        String dtlocacao = request.getParameter("dtlocacao");
        String dtdevolucao = request.getParameter("dtdevolucao");

        try {
            Date date1 = myFormat.parse(dtlocacao);
            Date date2 = myFormat.parse(dtdevolucao);
            long diff = date2.getTime() - date1.getTime();
            float days = (diff / (1000*60*60*24));
            
            Pedido p = new Pedido();
            
            

        } catch (ParseException ex) {
            Logger.getLogger(CadastroPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
