/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos.FuncionarioServlet;

import LocadoraVeiculos.PessoaServlet.*;
import LocadoraVeiculos.Carro;
import LocadoraVeiculos.DaoCarro;
import LocadoraVeiculos.DaoPessoa;
import LocadoraVeiculos.Pessoa;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "CadastroFuncionarioServlet", urlPatterns = {"/cadastro-funcionario"})
public class CadastroFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }
        request.getRequestDispatcher("WEB-INF/Pessoa/form-funcionario-cadastro.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa funcionario = (Pessoa) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DaoPessoa conn = new DaoPessoa();

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String cpf = request.getParameter("cpf");
        String dtnascimento = request.getParameter("dtnascimento");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String nivel = request.getParameter("nivel");
        String cargo = request.getParameter("cargo");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        java.sql.Date data = null;
        try {
            data = new java.sql.Date(format.parse(dtnascimento).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        Pessoa p1 = new Pessoa();
        p1.setNome(nome);
        p1.setSobrenome(sobrenome);
        p1.setRua(rua);
        p1.setNumero(Integer.parseInt(numero));
        p1.setCep(Integer.parseInt(cep));
        p1.setEstado(estado);
        p1.setCidade(cidade);
        p1.setCpf(Double.parseDouble(cpf));
        p1.setDataNasc((java.sql.Date) data);
        p1.setEmail(email);
        p1.setTelefone(Integer.parseInt(telefone));
        p1.setCargo(cargo);
        p1.setIdnivel(Integer.parseInt(nivel));
        p1.setLogin(login);
        p1.setSenha(senha);

        try {

            conn.incluir(p1);

            int id = conn.selectId(p1.getCpf());
            p1.setId(id);
            conn.incluirFuncionario(p1);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("funcCadastrado", p1);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Pessoa/resultadoCadastroFunc.jsp");
        dispatcher.forward(request, response);

    }

}
