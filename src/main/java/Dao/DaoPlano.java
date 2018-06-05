/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Filial;
import Model.Plano;
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
public class DaoPlano {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://172.20.0.81:3306/test", "planejamento", "ccash01");
        return conn;
    }

    public List<Plano> listar() throws ClassNotFoundException, SQLException {

        List<Plano> lista = new ArrayList<Plano>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT a.id_plano, a.ds_plano, b.id_classificacao, b.ds_classificacao, a.valor "
                                + " FROM test.Plano a "
                                + " inner join test.Classificacao b on a.id_class_carro = b.id_classificacao "
                                + " where a.id_status = 1 ");
                ResultSet resultados = stmt.executeQuery()) {
            
            System.out.println("retornou consulta");
            
            while (resultados.next()) {
                int id_plano = resultados.getInt("id_plano");
                String ds_plano = resultados.getString("ds_plano");
                int id_classificao = resultados.getInt("id_classificacao");
                String ds_classificao = resultados.getString("ds_classificacao");
                double valor = resultados.getDouble("valor");
                
                Plano p = new Plano();

                p.setIdplano(id_plano);
                p.setIdclassificacao(id_classificao);
                p.setPlano(ds_plano);
                p.setClassificacao(ds_classificao);
                p.setValor(valor);
                
                lista.add(p);
                
                System.out.println(id_plano + ", " + ds_plano);
            }
        }
        return lista;
    }
    
     public List<Plano> listarPlano(int idclas) throws ClassNotFoundException, SQLException {

        List<Plano> lista = new ArrayList<Plano>();
         System.out.println("CHEGOU NO LISTAR PLANOS");
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT a.id_plano, a.ds_plano, b.id_classificacao, b.ds_classificacao, a.valor "
                                + " FROM test.Plano a "
                                + " inner join test.Classificacao b on a.id_class_carro = b.id_classificacao "
                                + " where a.id_status = 1 "
                                + " and b.id_classificacao = " + idclas);
                ResultSet resultados = stmt.executeQuery()) {
  
            
            while (resultados.next()) {
                int id_plano = resultados.getInt("id_plano");
                String ds_plano = resultados.getString("ds_plano");
                int id_classificao = resultados.getInt("id_classificacao");
                String ds_classificao = resultados.getString("ds_classificacao");
                double valor = resultados.getDouble("valor");
                
                Plano p = new Plano();

                p.setIdplano(id_plano);
                p.setIdclassificacao(id_classificao);
                p.setPlano(ds_plano);
                p.setClassificacao(ds_classificao);
                p.setValor(valor);
                
                lista.add(p);
                
            }
        }
        return lista;
    }

    public void incluir(Plano p) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            
            System.out.println(p.getIdclassificacao() + " classificao é: ");
            
            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            " INSERT INTO test.Plano (ds_plano, id_class_carro, valor, id_status) VALUES (?,?,?,?) ")) {
                stmt.setString(1, p.getPlano());
                stmt.setInt(2, p.getIdclassificacao());
                stmt.setDouble(3, p.getValor());
                stmt.setInt(4, 1);
                
                
                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }

    }

    public void atualizar(Plano P) throws ClassNotFoundException, SQLException {
        try {

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Plano SET "
                    + " ds_plano = ?, id_class_carro =?, valor=? "
                    + " WHERE id_plano = ? ");
            stmt.setString(1, P.getPlano());
            stmt.setInt(2, P.getIdclassificacao());
            stmt.setDouble(3, P.getValor());
            stmt.setInt(4, P.getIdplano());
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
                        "update test.Plano set id_status = 0 WHERE id_plano = ? ")) {
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

    public Plano select(int id) throws ClassNotFoundException, SQLException {
        
        Plano plano = new Plano();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT a.id_plano, a.ds_plano, b.id_classificacao, b.ds_classificacao, a.valor "
                                + " FROM test.Plano a inner join test.Classificacao b "
                                + " on a.id_class_carro = b.id_classificacao "
                                + " WHERE a.id_status = 1 and a.id_plano = " + id);
                ResultSet resultados = stmt.executeQuery()) {
            
                while (resultados.next()) {

                int idplano = resultados.getInt("id_plano");
                String ds_plano = resultados.getString("ds_plano");
                int idclassificao = resultados.getInt("id_classificacao");
                String ds_classificao = resultados.getString("ds_classificacao");
                double valor = resultados.getInt("valor");
                
                System.out.println("O nome do plano no select é: " + ds_plano);
                
                plano.setIdplano(idplano);
                plano.setPlano(ds_plano);
                plano.setIdclassificacao(idclassificao);
                plano.setClassificacao(ds_classificao);
                plano.setValor(valor);                    
                
                }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return plano;
    }

}
