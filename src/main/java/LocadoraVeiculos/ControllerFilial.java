/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos;

import LocadoraVeiculos.Filial;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
public class ControllerFilial {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://172.20.0.81:3306/test", "planejamento", "ccash01");
        return conn;
    }

    public List<Filial> listar() throws ClassNotFoundException, SQLException {

        List<Filial> lista = new ArrayList<Filial>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, NomeUnidade, Rua, Numero, Cep, Telefone, Gerente FROM test.Filial");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("NomeUnidade");
                String rua = resultados.getString("Rua");
                int numero = resultados.getInt("Numero");
                int cep = resultados.getInt("Cep");
                int telefone = resultados.getInt("Telefone");
                String gerente = resultados.getString("Gerente");

                Filial p = new Filial();

                p.setId(id);
                p.setNomeUnidade(nome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setTelefone(telefone);
                p.setGerente(gerente);
                lista.add(p);
                //System.out.println(id + ", " + nome + ", " + dtNascimento);
            }
        }
        return lista;
    }

    public void incluir(Filial p) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO test.Filial (NomeUnidade, Rua, Numero, Cep, Telefone, Gerente) VALUES (?,?,?,?,?,?)")) {
                stmt.setString(1, p.getNomeUnidade());
                stmt.setString(2, p.getRua());
                stmt.setInt(3, p.getNumero());
                stmt.setInt(4, p.getCep());
                stmt.setInt(5, p.getTelefone());
                stmt.setString(6, p.getGerente());

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }

    }

    public void atualizar(Filial P) throws ClassNotFoundException, SQLException {
        try {
            System.out.println("Entrou no fim da atz!!");
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Filial SET "
                    + "NomeUnidade = ?, Rua =?, Numero=?, Cep=?, Telefone=?, Gerente=?"
                    + "WHERE id = ?");
            stmt.setString(1, P.getNomeUnidade());
            stmt.setString(2, P.getRua());
            stmt.setInt(3, P.getNumero());
            stmt.setInt(4, P.getCep());
            stmt.setInt(5, P.getTelefone());
            stmt.setString(6, P.getGerente());
            stmt.setInt(7, P.getId());
            stmt.executeUpdate();
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public boolean excluir(int id) throws ClassNotFoundException, SQLException {

        boolean deletado = false;
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM test.Filial WHERE id = ? ")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            deletado = true;
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return deletado;
    }

    public Filial select(int id) throws ClassNotFoundException, SQLException {
        
       

        Filial filial = new Filial();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * FROM test.Filial WHERE id = " + id);
                ResultSet resultados = stmt.executeQuery()) {
            System.out.println("Chegou Aqui");

            while (resultados.next()) {

                String nome = resultados.getString("NomeUnidade");
                String rua = resultados.getString("Rua");
                int numero = resultados.getInt("Numero");
                int cep = resultados.getInt("Cep");
                int telefone = resultados.getInt("Telefone");
                String gerente = resultados.getString("Gerente");

                filial.setId(id);
                filial.setNomeUnidade(nome);
                filial.setRua(rua);
                filial.setNumero(numero);
                filial.setCep(cep);
                filial.setTelefone(telefone);
                filial.setGerente(gerente);
                
                System.out.println("O aluno é:" + filial.getGerente());
            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return filial;
    }

}
