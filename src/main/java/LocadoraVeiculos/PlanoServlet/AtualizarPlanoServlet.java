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
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.gsgalvao
 */
@WebServlet(name = "AtualizarPlano", urlPatterns = {"/AtualizarPlano"})
public class AtualizarPlanoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtualizarFilial</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AtualizarFilial at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id_plano = request.getParameter("id_plano");
        String ds_plano  = request.getParameter("nome");
        String id_classificao = request.getParameter("class");
        String valor = request.getParameter("numero");
        String metodo = request.getParameter("metodo");
        
        System.out.println(id_classificao + " esse é o valor");

        Plano p1 = new Plano( ds_plano, Integer.parseInt(id_classificao), Double.parseDouble(valor));
        ControllerPlano con = new ControllerPlano();
        
        p1.setIdplano(Integer.parseInt(id_plano));

        try {
            if(metodo.equals("atualizar")) {
                con.atualizar(p1);  
              
                request.setAttribute("planoUpdate", p1);
                RequestDispatcher dispatcher
                = request.getRequestDispatcher("Plano/resultadoAtualizar.jsp");
                dispatcher.forward(request, response);
                System.out.println("ENTROU NO ATUALIZAR");
                
            } else if (metodo.equals("deletar")) {
              con.excluir(p1.getIdplano());
              
               request.setAttribute("planoUpdate", p1);
               RequestDispatcher dispatcher = request.getRequestDispatcher("Plano/resultadoDelete.jsp");
                dispatcher.forward(request, response);
                System.out.println("ENTROU NO DELETAr");
            }

        } catch (Exception e) {
            System.out.println("Vefique o objeto");
        }


       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
