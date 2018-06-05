/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.DaoPedido;
import Dao.DaoPlano;

import Model.Pedido;
import Model.Plano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String idcliente = request.getParameter("id");
        String idplano = request.getParameter("plano");
        String idcarro = request.getParameter("carro");
        String idfun = request.getParameter("funcionario");
        String idfilial = request.getParameter("filial");
        String dtretirada = request.getParameter("dtretirada");
        String dtentrada = request.getParameter("dtentrega");

        System.out.println("Cliente: " + idcliente);
        System.out.println("Plano: " + idplano);
        System.out.println("carro: " + idcarro);
        System.out.println("Funcionario: " + idfun);
        System.out.println("Filial: " + idfilial);

        java.sql.Date dataRetirada2 = null;
        java.sql.Date dataEntrega2 = null;

        try {
            dataRetirada2 = new java.sql.Date(format.parse(dtretirada).getTime());
            dataEntrega2 = new java.sql.Date(format.parse(dtentrada).getTime());

        } catch (ParseException ex) {
            Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Retirada: " + dataRetirada2);
        System.out.println("Entrega: " + dataEntrega2);

        DaoPedido conn = new DaoPedido();
        DaoPlano planocon = new DaoPlano();
        Pedido pedido = new Pedido();
        Plano plano = new Plano();

        pedido.setIdpessoa(Integer.parseInt(idcliente));
        pedido.setIdplano(Integer.parseInt(idplano));
        pedido.setIdcarro(Integer.parseInt(idcarro));
        pedido.setIdfuncionario(Integer.parseInt(idfun));
        pedido.setIdfilial(Integer.parseInt(idfilial));
        pedido.setDtlocacao((java.sql.Date) dataRetirada2);
        pedido.setDtdevolucao((java.sql.Date) dataEntrega2);

        System.out.println("SETOU TUDO!");

        long diff =  dataEntrega2.getTime() - dataRetirada2.getTime();
        int dia = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        try {
            
            plano = planocon.select(Integer.parseInt(idplano));
            double valorTotal = plano.getValor()*dia;
            
            pedido.setValortotal(valorTotal);
            pedido.setDiasAlugados(dia);
            
            conn.incluir(pedido);
            System.out.println("Cadastrou o pedido");
              

        } catch (Exception e) {

        }
        
        request.setAttribute("pedido", pedido);

        request.getRequestDispatcher("WEB-INF/Pedido/ResultadoCadastro.jsp").forward(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
