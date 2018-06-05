/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Carro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor.galvao
 */
public class DaoCarro {
    
        private Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://172.20.0.81:3306/test", "planejamento", "ccash01");
        return conn;
    }
    
    public void incluir(Carro p) throws ClassNotFoundException, SQLException {

  
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO test.Carro (ds_carro, fabricante, cor, ano, valor, id_classificacao, id_status) VALUES (?,?,?,?,?,?,?)")) {
                stmt.setString(1, p.getCarro());
                stmt.setString(2, p.getFabricante());
                stmt.setString(3, p.getCor());
                stmt.setInt(4, p.getAno());
                 stmt.setDouble(5, p.getValor());
                stmt.setInt(6, p.getIdclassificacao());
                stmt.setInt(7,1);

                int status = stmt.executeUpdate();
              

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }

    }
    
    public Carro select(int id) throws ClassNotFoundException, SQLException {

        Carro carro = new Carro();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * FROM test.Carro WHERE id_carro = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                String nomeCarro = resultados.getString("ds_carro");
                String fabricante = resultados.getString("fabricante");
                String cor = resultados.getString("cor");
                int ano = resultados.getInt("ano");
                double valor = resultados.getDouble("valor");
                int idclass = resultados.getInt("id_classificacao");

                carro.setIdcarro(id);
                carro.setCarro(nomeCarro);
                carro.setFabricante(fabricante);
                carro.setCor(cor);
                carro.setAno(ano);
                carro.setValor(valor);
                carro.setIdclassificacao(idclass);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return carro;
    }
    
     public List<Carro> listar() throws ClassNotFoundException, SQLException {

        List<Carro> lista = new ArrayList<Carro>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id_carro, ds_carro, fabricante, cor, ano, valor, ds_classificacao, b.id_classificacao "
                                + " FROM test.Carro a inner join test.Classificacao b on a.id_classificacao = b.id_classificacao "
                                + " where id_status = 1 "
                                + " order by id_carro asc ");
                ResultSet resultados = stmt.executeQuery()) {
            
            while (resultados.next()) {
                int id = resultados.getInt("id_carro");
                String carro = resultados.getString("ds_carro");
                String fabricante = resultados.getString("fabricante");
                String cor = resultados.getString("cor");
                int ano = resultados.getInt("ano");
                double valor = resultados.getDouble("valor");
                String classificacao = resultados.getString("ds_classificacao");
                int idclassificacao = resultados.getInt("id_classificacao");

                Carro p = new Carro();

                p.setIdcarro(id);
                p.setCarro(carro);
                p.setFabricante(fabricante);
                p.setCor(cor);
                p.setAno(ano);
                p.setValor(valor);
                p.setClassificacao(classificacao);
                p.setIdclassificacao(idclassificacao);

                lista.add(p);
                
            }
        }
        return lista;
    }
     
     public List<Carro> listarCarros(int idclass) throws ClassNotFoundException, SQLException {

        List<Carro> lista = new ArrayList<Carro>();
         System.out.println("CHEGOU NO LISTAR CARROS");
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id_carro, ds_carro, fabricante, cor, ano, valor, ds_classificacao, b.id_classificacao "
                                + " FROM test.Carro a inner join test.Classificacao b on a.id_classificacao = b.id_classificacao "
                                + " where id_status = 1 "
                                + " and b.id_classificacao = " + idclass);
                ResultSet resultados = stmt.executeQuery()) {
            
            while (resultados.next()) {
                int id = resultados.getInt("id_carro");
                String carro = resultados.getString("ds_carro");
                String fabricante = resultados.getString("fabricante");
                String cor = resultados.getString("cor");
                int ano = resultados.getInt("ano");
                double valor = resultados.getDouble("valor");
                String classificacao = resultados.getString("ds_classificacao");
                int idclassificacao = resultados.getInt("id_classificacao");

                Carro p = new Carro();

                p.setIdcarro(id);
                p.setCarro(carro);
                p.setFabricante(fabricante);
                p.setCor(cor);
                p.setAno(ano);
                p.setValor(valor);
                p.setClassificacao(classificacao);
                p.setIdclassificacao(idclassificacao);

                lista.add(p);
                
            }
        }
        return lista;
    }
     
     public void atualizar(Carro P) throws ClassNotFoundException, SQLException {
        try {

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Carro SET "
                    + " ds_carro = ?, fabricante =?, cor=?,  ano=?, valor=?, id_classificacao=? "
                    + " WHERE id_carro = ? ");
            stmt.setString(1, P.getCarro());
            stmt.setString(2, P.getFabricante());
            stmt.setString(3, P.getCor());
            stmt.setInt(4, P.getAno());
            stmt.setDouble(5, P.getValor());
            stmt.setInt(6, P.getIdclassificacao());
            stmt.setInt(7, P.getIdcarro());
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
                        "update test.Carro set id_status = 0 WHERE id_carro = ? ")) {
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
}


