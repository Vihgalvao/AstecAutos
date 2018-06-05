/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Pedido;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author guilherme.rocha
 */
public class DaoPedido {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "");
        return conn;
    }

    public Pedido relatorio(int idstatus) throws ClassNotFoundException, SQLException, IOException {
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy HHmmss");
        Calendar cal = Calendar.getInstance();
        
        Pedido p = new Pedido();
        File fArqEx = new File("C:\\tads\\", "AnaliticoPedidos" + df.format(cal.getTime()) +".txt");
        if (fArqEx.exists()) {
            fArqEx.delete();
        }
        
        

        FileWriter fwArq = new FileWriter(fArqEx);

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " select a.id_pedido, a.id_cliente, b.nome, b.cpf, a.id_filial, c.NomeUnidade, a.id_plano, d.ds_plano, a.id_carro, e.ds_carro, a.id_funcionario, a.dtdevolucao, a.dtlocacao, a.dias_alugados, a.vlr_total, a.ped_status, "
                        + " case when ped_status = 1 then 'ATIVO' else 'BAIXADO' end ds_status "
                        + " from Pedido a "
                        + " inner join Pessoa b	on a.id_cliente = b.idpessoa "
                        + " inner join Filial c	on a.id_filial = c.Id "
                        + " inner join Plano d	on a.id_plano = d.id_plano "
                        + " inner join Carro e	on a.id_carro = e.id_carro "
                        + " where ped_status = " + idstatus);
                ResultSet resultados = stmt.executeQuery()) {

            fwArq.write("NOME;");
            fwArq.write("CPF;");
            fwArq.write("ID PEDIDO;");
            fwArq.write("DATA RETIRADA;");
            fwArq.write("DATA ENTREGA;");
            fwArq.write("VALOR TOTAL;");
            fwArq.write("UNIDADE;");
            fwArq.write("CARRO");
            fwArq.write("\r\n");

            

            while (resultados.next()) {

                fwArq.write(resultados.getString("nome") + ";");
                fwArq.write(resultados.getString("cpf") + ";");
                fwArq.write(resultados.getString("id_pedido") + ";");

                String data1 = df.format(resultados.getDate("dtlocacao"));
                String data2 = df.format(resultados.getDate("dtdevolucao"));
                fwArq.write(data1 + ";");
                fwArq.write(data2 + ";");
                fwArq.write(String.valueOf(resultados.getDouble("vlr_total")) + ";");
                fwArq.write(resultados.getString("NomeUnidade") + ";");
                fwArq.write(resultados.getString("ds_carro"));

                fwArq.write("\r\n");

            }
            conn.close();
            fwArq.close();
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

    public List<Pedido> listar() throws ClassNotFoundException, SQLException {

        List<Pedido> lista = new ArrayList<Pedido>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " select a.id_pedido, a.id_cliente, b.nome, b.cpf, a.id_filial, c.NomeUnidade, a.id_plano, d.ds_plano, a.id_carro, e.ds_carro, a.id_funcionario, a.dtdevolucao, a.dtlocacao, a.dias_alugados, a.vlr_total, a.ped_status, "
                        + " case when ped_status = 1 then 'ATIVO' else 'BAIXADO' end ds_status "
                        + " from Pedido a "
                        + " inner join Pessoa b	on a.id_cliente = b.idpessoa "
                        + " inner join Filial c	on a.id_filial = c.Id "
                        + " inner join Plano d	on a.id_plano = d.id_plano "
                        + " inner join Carro e	on a.id_carro = e.id_carro ");
                ResultSet resultados = stmt.executeQuery()) {

            System.out.println("retornou consulta");

            while (resultados.next()) {
                int Idpedido = resultados.getInt("id_pedido");
                int IdPessoa = resultados.getInt("id_cliente");
                String pessoa = resultados.getString("nome");
                String cpf = resultados.getString("cpf");
                int IdPlano = resultados.getInt("id_plano");
                String plano = resultados.getString("ds_plano");
                int IdCarro = resultados.getInt("id_carro");
                String carro = resultados.getString("ds_carro");
                int IdFuncionario = resultados.getInt("id_funcionario");
                int Idfilial = resultados.getInt("id_filial");
                String filial = resultados.getString("NomeUnidade");
                Date Dataretirada = resultados.getDate("dtlocacao");
                Date dtentrega = resultados.getDate("dtdevolucao");
                int DiasAlugados = resultados.getInt("dias_alugados");
                int Status = resultados.getInt("ped_status");
                double ValorTotal = resultados.getDouble("vlr_total");
                String dsStatus = resultados.getString("ds_status");

                Pedido p = new Pedido();

                p.setId(Idpedido);
                p.setIdpessoa(IdPessoa);
                p.setNomeCliente(pessoa);
                p.setCpf(cpf);
                p.setIdplano(IdPlano);
                p.setPlano(plano);
                p.setIdcarro(IdCarro);
                p.setCarro(carro);
                p.setIdfuncionario(IdFuncionario);
                p.setIdfilial(Idfilial);
                p.setFilial(filial);
                p.setDtlocacao(Dataretirada);
                p.setDtdevolucao(dtentrega);
                p.setDiasAlugados(DiasAlugados);
                p.setStatus(Status);
                p.setValortotal(ValorTotal);
                p.setDsStatus(dsStatus);

                lista.add(p);

                System.out.println("Inseriu na lista!!!");
            }
        }
        return lista;
    }

    public void incluir(Pedido p) throws ClassNotFoundException, SQLException {
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            System.out.println(p.getIdpessoa() + " Cliente");
            System.out.println(p.getIdfuncionario() + " Funcionario");
            System.out.println(p.getIdplano() + " Plano");
            System.out.println(p.getIdcarro() + " Carro");
            System.out.println(p.getValortotal() + " Valor");

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            " INSERT INTO test.Pedido ( id_cliente, id_plano, id_carro, id_funcionario, id_filial, "
                            + " dtlocacao, dtdevolucao, dias_alugados, ped_status,  vlr_total) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?) ")) {
                stmt.setLong(1, p.getIdpessoa());
                stmt.setLong(2, p.getIdplano());
                stmt.setLong(3, p.getIdcarro());
                stmt.setLong(4, p.getIdfuncionario());
                stmt.setLong(5, p.getIdfilial());
                stmt.setDate(6, (java.sql.Date) p.getDtlocacao());
                stmt.setDate(7, (java.sql.Date) p.getDtdevolucao());
                stmt.setInt(8, p.getDiasAlugados());
                stmt.setInt(9, 1);
                stmt.setDouble(10, p.getValortotal());

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }
        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }
    }

    public void atualizar(Pedido P) throws ClassNotFoundException, SQLException {
        try {

            System.out.println(P.getIdfilial());
            System.out.println(P.getIdcarro());
            System.out.println(P.getIdplano());
            System.out.println(P.getIdfuncionario());
            System.out.println(P.getDtlocacao());
            System.out.println(P.getDtdevolucao());
            System.out.println(P.getId());

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Pedido SET "
                    + " id_filial = ?, id_carro = ?, id_plano = ?, id_funcionario = ?, dtlocacao = ?, dtdevolucao = ?, dias_alugados = ?, ped_status = ?, vlr_total = ? "
                    + " WHERE id_pedido = ? ");
            stmt.setInt(1, (int) P.getIdfilial());
            stmt.setInt(2, (int) P.getIdcarro());
            stmt.setInt(3, (int) P.getIdplano());
            stmt.setInt(4, (int) P.getIdfuncionario());
            stmt.setDate(5, (java.sql.Date) P.getDtlocacao());
            stmt.setDate(6, (java.sql.Date) P.getDtdevolucao());
            stmt.setInt(7, P.getDiasAlugados());
            stmt.setInt(8, P.getStatus());
            stmt.setDouble(9, P.getValortotal());
            stmt.setDouble(10, P.getId());

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
                        "DELETE test.Pedido  WHERE id_pedido = ? ")) {
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

    public Pedido select(int id) throws ClassNotFoundException, SQLException {

        Pedido p = new Pedido();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT a.id_pedido, b.cpf, a.id_cliente, a.id_filial, a.id_plano, a.id_carro, a.id_funcionario, a.dtdevolucao, a.dtlocacao, a.dias_alugados, a.vlr_total, a.ped_status, "
                        + " case when ped_status = 1 then 'ATIVO' else 'BAIXADO' end ds_status "
                        + " from Pedido a "
                        + " inner join Pessoa b on a.id_cliente = b.idpessoa "
                        + " where a.id_pedido = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int Id = resultados.getInt("id_pedido");
                int IdPessoa = resultados.getInt("id_cliente");
                String cpf = resultados.getString("cpf");
                int IdPlano = resultados.getInt("id_plano");
                int IdCarro = resultados.getInt("id_carro");
                int IdFuncionario = resultados.getInt("id_funcionario");
                int Idfilial = resultados.getInt("id_filial");
                Date DataRetirada = resultados.getDate("dtlocacao");
                Date DataDevolucao = resultados.getDate("dtdevolucao");
                int DiasAlugados = resultados.getInt("dias_alugados");
                int Status = resultados.getInt("ped_status");
                double ValorTotal = resultados.getDouble("vlr_total");
                String dsstatus = resultados.getString("ds_status");

                System.out.println("Id do pedido: " + Id);

                p.setId(Id);
                p.setIdpessoa(IdPessoa);
                p.setIdplano(IdPlano);
                p.setIdcarro(IdCarro);
                p.setIdfuncionario(IdFuncionario);
                p.setIdfilial(Idfilial);
                p.setDtlocacao(DataRetirada);
                p.setDtdevolucao(DataDevolucao);
                p.setDiasAlugados(DiasAlugados);
                p.setStatus(Status);
                p.setValortotal(ValorTotal);
                p.setCpf(cpf);
                p.setDsStatus(dsstatus);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

}
