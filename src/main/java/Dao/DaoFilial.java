/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Filial;
import Model.Filial;
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
public class DaoFilial {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "");
        return conn;
    }

    public List<Filial> listar() throws ClassNotFoundException, SQLException {

        List<Filial> lista = new ArrayList<Filial>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, idestado, estado, NomeUnidade, Rua, Numero, Cep, Telefone, Gerente "
                        + "FROM test.Filial inner join Estado on id_estado = idestado");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String estado = resultados.getString("estado");
                int idestado = resultados.getInt("idestado");
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
                p.setIdestado(idestado);
                p.setEstado(estado);
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
                            "INSERT INTO test.Filial (idestado, NomeUnidade, Rua, Numero, Cep, Telefone, Gerente) VALUES (?,?,?,?,?,?,?)")) {
                stmt.setInt(1, p.getIdestado());
                stmt.setString(2, p.getNomeUnidade());
                stmt.setString(3, p.getRua());
                stmt.setInt(4, p.getNumero());
                stmt.setInt(5, p.getCep());
                stmt.setInt(6, p.getTelefone());
                stmt.setString(7, p.getGerente());

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

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Filial SET "
                    + "idestado = ?, NomeUnidade = ?, Rua =?, Numero=?, Cep=?, Telefone=?, Gerente=?"
                    + "WHERE id = ?");
            stmt.setInt(1, P.getIdestado());
            stmt.setString(2, P.getNomeUnidade());
            stmt.setString(3, P.getRua());
            stmt.setInt(4, P.getNumero());
            stmt.setInt(5, P.getCep());
            stmt.setInt(6, P.getTelefone());
            stmt.setString(7, P.getGerente());
            stmt.setInt(8, P.getId());
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
                        " select Id, idestado, estado, NomeUnidade, Rua, Numero, Cep, Telefone, Gerente "
                        + " FROM test.Filial inner join Estado on id_estado = idestado "
                        + " WHERE id = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                
                String estado = resultados.getString("estado");
                int idestado = resultados.getInt("idestado");
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
                filial.setIdestado(idestado);
                filial.setEstado(estado);

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
