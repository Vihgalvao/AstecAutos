/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Pessoa;
import java.sql.Connection;
import java.sql.Date;
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
public class DaoPessoa {

    public Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://172.20.0.81:3306/test", "planejamento", "ccash01");
        return conn;
    }

    public void incluir(Pessoa p) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            " INSERT INTO test.Pessoa (nome, idsexo, sobrenome, rua, numero, cep, idestado, bairro, cidade, cpf, dtnascimento, email, telefone, tipo, idstatus)"
                            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ")) {

                stmt.setString(1, p.getNome());
                stmt.setInt(2, p.getIdsexo());
                stmt.setString(3, p.getSobrenome());
                stmt.setString(4, p.getRua());
                stmt.setInt(5, p.getNumero());
                stmt.setInt(6, p.getCep());
                stmt.setInt(7, p.getIdestado());
                stmt.setString(8, p.getBairro());
                stmt.setString(9, p.getCidade());
                stmt.setString(10, p.getCpf());
                stmt.setDate(11, p.getDataNasc());
                stmt.setString(12, p.getEmail());
                stmt.setInt(13, p.getTelefone());
                stmt.setInt(14, p.getTipo());
                stmt.setInt(15, 1);

                int status = stmt.executeUpdate();

                conn.commit();

            }

        } catch (SQLException e) {
            throw e;
        }

    }

    public void incluirCliente(Pessoa p) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO test.PessoaCliente (id_pessoa, cnh, renda)"
                            + "VALUES (?,?,?) ")) {

                stmt.setInt(1, p.getId());
                stmt.setDouble(2, p.getCnh());
                stmt.setDouble(3, p.getRenda());
                int status = stmt.executeUpdate();

                conn.commit();
            }

        } catch (SQLException e) {
            throw e;
        }

    }

    public void incluirFuncionario(Pessoa p) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO test.PessoaFuncionario (id_pessoa, idfilial, id_nivel, id_cargo, login, senha, idstatus) "
                            + "VALUES (?,?,?,?,?,?,?) ")) {

                stmt.setInt(1, p.getId());
                stmt.setInt(2, p.getIdfilial());
                stmt.setInt(3, p.getIdnivel());
                stmt.setString(4, p.getCargo());
                stmt.setString(5, p.getLogin());
                stmt.setString(6, p.getSenha());
                stmt.setInt(7, 1);
                int status = stmt.executeUpdate();

                conn.commit();
            }

        } catch (SQLException e) {
            throw e;
        }

    }

    public Pessoa selectCliente(int id) throws ClassNotFoundException, SQLException {
        Pessoa p = new Pessoa();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " SELECT idpessoa, id_cliente, nome, sobrenome, rua, numero, cep, idestado, estado, cidade, cpf, dtnascimento, email, telefone, cnh, renda, bairro, idsexo, sexo  "
                        + " FROM test.Pessoa a inner join test.PessoaCliente b on a.idpessoa = b.id_pessoa "
                        + " inner join Sexo on idsexo = id_sexo "
                        + " inner join Estado on idestado = id_estado "
                        + " WHERE idstatus = 1 and a.idpessoa = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int idpessoa = resultados.getInt("idpessoa");
                int idcliente = resultados.getInt("id_cliente");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                int cep = resultados.getInt("cep");
                int idestado = resultados.getInt("idestado");
                String estado = resultados.getString("estado");
                String cidade = resultados.getString("cidade");
                String cpf = resultados.getString("cpf");
                Date dtnascimento = resultados.getDate("dtnascimento");
                String email = resultados.getString("email");
                String bairro = resultados.getString("bairro");
                int idsexo = resultados.getInt("idsexo");
                String sexo = resultados.getString("sexo");
                int telefone = resultados.getInt("telefone");
                int cnh = resultados.getInt("cnh");
                double renda = resultados.getDouble("renda");

                p.setId(idpessoa);
                p.setIdcliente(idcliente);
                p.setNome(nome);
                p.setSobrenome(sobrenome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setEstado(estado);
                p.setCidade(cidade);
                p.setCpf(cpf);
                p.setDataNasc(dtnascimento);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setCnh(cnh);
                p.setRenda(renda);
                p.setIdsexo(idsexo);
                p.setIdestado(idestado);
                p.setSexo(sexo);
                p.setBairro(bairro);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

    public Pessoa selectFuncionario(int id) throws ClassNotFoundException, SQLException {
        Pessoa p = new Pessoa();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " SELECT idpessoa,  nome, sobrenome, a.rua, a.numero, a.bairro, a.cep, a.idestado, estado, a.cidade, cpf, dtnascimento, email, a.telefone, b.id_nivel, nivel, b.id_cargo, cargo, login, senha, idsexo, sexo, id, NomeUnidade  "
                        + " FROM test.Pessoa a inner join test.PessoaFuncionario b on a.idpessoa = b.id_pessoa "
                        + " inner join test.Nivel c on b.id_nivel = c.id_nivel "
                        + " inner join test.Cargo d on b.id_cargo = d.id_cargo "
                        + " inner join Sexo on idsexo = id_sexo "
                        + " inner join Estado on a.idestado = id_estado "
                        + " inner join Filial f on idfilial = id "
                        + " WHERE a.idstatus = 1 and a.idpessoa = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int idpessoa = resultados.getInt("idpessoa");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                String bairro = resultados.getString("bairro");
                int cep = resultados.getInt("cep");
                String estado = resultados.getString("estado");
                String cidade = resultados.getString("cidade");
                String cpf = resultados.getString("cpf");
                Date dtnascimento = resultados.getDate("dtnascimento");
                String email = resultados.getString("email");
                int telefone = resultados.getInt("telefone");
                int idnivel = resultados.getInt("id_nivel");
                String nivel = resultados.getString("nivel");
                int idcargo = resultados.getInt("id_cargo");
                String cargo = resultados.getString("cargo");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                String sexo = resultados.getString("sexo");
                int idsexo = resultados.getInt("idsexo");
                String filial = resultados.getString("NomeUnidade");
                int idfilial = resultados.getInt("id");
                int idestado = resultados.getInt("idestado");

                p.setId(idpessoa);
                p.setNome(nome);
                p.setSobrenome(sobrenome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setEstado(estado);
                p.setCidade(cidade);
                p.setCpf(cpf);
                p.setDataNasc(dtnascimento);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setIdnivel(idnivel);
                p.setNivel(nivel);
                p.setCargo(cargo);
                p.setIdcargo(idcargo);
                p.setLogin(login);
                p.setSenha(senha);
                p.setIdestado(idestado);
                p.setSexo(sexo);
                p.setIdsexo(idsexo);
                p.setIdfilial(idfilial);
                p.setFilial(filial);
                p.setBairro(bairro);

            }

            System.out.println("Nome é:" + p.getIdsexo());
            System.out.println("Sobrenome é: " + p.getIdestado());
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("DEU MERDAAA ");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

    public Pessoa selectFuncionario(String cpf) throws ClassNotFoundException, SQLException {
        Pessoa p = new Pessoa();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " SELECT idpessoa "
                        + " from Pessoa "
                        + " WHERE cpf = " + cpf);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int idpessoa = resultados.getInt("idpessoa");

                p.setId(idpessoa);

            }

            System.out.println("Nome é:" + p.getIdsexo());
            System.out.println("Sobrenome é: " + p.getIdestado());
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("DEU MERDAAA ");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

    public Pessoa selectId(String cpf) throws ClassNotFoundException, SQLException {

        Pessoa Pessoa = new Pessoa();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " select idpessoa, nome, sobrenome, rua, numero, cep, estado, bairro, cidade, cpf, email, dtnascimento, cnh, renda "
                        + " from test.Pessoa a "
                        + " inner join test.PessoaCliente  b "
                        + " on a.idpessoa = b.id_cliente "
                        + " inner join test.Estado c "
                        + " on a.idestado = c.id_estado"
                        + " WHERE cpf = '" + cpf + "'");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int idP = resultados.getInt("idpessoa");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                int cep = resultados.getInt("cep");
                String estado = resultados.getString("estado");
                String bairro = resultados.getString("bairro");
                String cidade = resultados.getString("cidade");
                String cpf2 = resultados.getString("cpf");
                String email = resultados.getString("email");
                Date dtnascimento = resultados.getDate("dtnascimento");
                int cnh = resultados.getInt("cnh");
                double renda = resultados.getInt("renda");

                Pessoa.setId(idP);
                Pessoa.setNome(nome);
                Pessoa.setSobrenome(sobrenome);
                Pessoa.setRua(rua);
                Pessoa.setNumero(numero);
                Pessoa.setCep(cep);
                Pessoa.setEstado(estado);
                Pessoa.setBairro(bairro);
                Pessoa.setCidade(cidade);
                Pessoa.setCpf(cpf2);
                Pessoa.setEmail(email);
                Pessoa.setDataNasc(dtnascimento);
                Pessoa.setCnh(cnh);
                Pessoa.setRenda(renda);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return Pessoa;
    }

    public List<Pessoa> listarCliente() throws ClassNotFoundException, SQLException {

        List<Pessoa> lista = new ArrayList<Pessoa>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT idpessoa, id_cliente, nome, sobrenome, rua, numero, cep, idestado, estado, cidade, cpf, dtnascimento, email, telefone, cnh, renda, bairro, idsexo, sexo "
                        + " FROM test.Pessoa a inner join test.PessoaCliente b on a.idpessoa = b.id_pessoa "
                        + " inner join Sexo on id_sexo = idsexo "
                        + " inner join Estado on id_estado = idestado "
                        + " where idstatus = 1 and tipo = 1");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int idpessoa = resultados.getInt("idpessoa");
                int idcliente = resultados.getInt("id_cliente");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                int cep = resultados.getInt("cep");
                int idestado = resultados.getInt("idestado");
                int idsexo = resultados.getInt("idsexo");
                String sexo = resultados.getString("sexo");
                String estado = resultados.getString("estado");
                String cidade = resultados.getString("cidade");
                String cpf = resultados.getString("cpf");
                Date dtnascimento = resultados.getDate("dtnascimento");
                String email = resultados.getString("email");
                int telefone = resultados.getInt("telefone");
                int cnh = resultados.getInt("cnh");
                double renda = resultados.getDouble("renda");

                Pessoa p = new Pessoa();

                p.setId(idpessoa);
                p.setIdcliente(idcliente);
                p.setNome(nome);
                p.setSobrenome(sobrenome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setEstado(estado);
                p.setCidade(cidade);
                p.setCpf(cpf);
                p.setDataNasc(dtnascimento);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setCnh(cnh);
                p.setRenda(renda);
                p.setIdsexo(idsexo);
                p.setSexo(sexo);
                p.setIdestado(idestado);

                lista.add(p);

            }
        }
        return lista;
    }

    public List<Pessoa> listarFuncionario() throws ClassNotFoundException, SQLException {

        List<Pessoa> lista = new ArrayList<Pessoa>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " SELECT idpessoa,  nome, sobrenome, a.rua, a.numero, a.cep, f.idestado, estado, a.cidade, cpf, dtnascimento, email, a.telefone, b.id_nivel, b.id_cargo, login, senha, nivel, d.cargo, idsexo, sexo, f.id, f.NomeUnidade   "
                        + " FROM test.Pessoa a inner join test.PessoaFuncionario b on a.idpessoa = b.id_pessoa "
                        + " inner join test.Nivel c on b.id_nivel = c.id_nivel "
                        + " inner join test.Cargo d on b.id_cargo = d.id_cargo "
                        + " inner join Sexo on idsexo = id_sexo "
                        + " inner join Filial f on idfilial = id "
                        + " inner join Estado on f.idestado = id_estado "
                        + " WHERE a.idstatus = 1 and tipo = 2");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int idpessoa = resultados.getInt("idpessoa");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                int cep = resultados.getInt("cep");
                String estado = resultados.getString("estado");
                String cidade = resultados.getString("cidade");
                String cpf = resultados.getString("cpf");
                Date dtnascimento = resultados.getDate("dtnascimento");
                String email = resultados.getString("email");
                int telefone = resultados.getInt("telefone");
                int idnivel = resultados.getInt("id_nivel");
                String nivel = resultados.getString("nivel");
                int idcargo = resultados.getInt("id_cargo");
                String cargo = resultados.getString("cargo");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                String sexo = resultados.getString("sexo");
                int idsexo = resultados.getInt("idsexo");
                String filial = resultados.getString("NomeUnidade");
                int idfilial = resultados.getInt("id");
                int idestado = resultados.getInt("idestado");

                Pessoa p = new Pessoa();

                p.setId(idpessoa);
                p.setNome(nome);
                p.setSobrenome(sobrenome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setEstado(estado);
                p.setCidade(cidade);
                p.setCpf(cpf);
                p.setDataNasc(dtnascimento);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setIdnivel(idnivel);
                p.setNivel(nivel);
                p.setCargo(cargo);
                p.setIdcargo(idcargo);
                p.setLogin(login);
                p.setSenha(senha);
                p.setIdestado(idestado);
                p.setSexo(sexo);
                p.setIdsexo(idsexo);
                p.setIdfilial(idfilial);
                p.setFilial(filial);

                lista.add(p);

            }
        }
        return lista;
    }

    public List<Pessoa> listarFuncionario(int id) throws ClassNotFoundException, SQLException {

        List<Pessoa> lista = new ArrayList<Pessoa>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " SELECT idpessoa,  nome, sobrenome, a.rua, a.numero, a.cep, f.idestado, estado, a.cidade, cpf, dtnascimento, email, a.telefone, b.id_nivel, b.id_cargo, login, senha, nivel, d.cargo, idsexo, sexo, f.id, f.NomeUnidade   "
                        + " FROM test.Pessoa a inner join test.PessoaFuncionario b on a.idpessoa = b.id_pessoa "
                        + " inner join test.Nivel c on b.id_nivel = c.id_nivel "
                        + " inner join test.Cargo d on b.id_cargo = d.id_cargo "
                        + " inner join Sexo on idsexo = id_sexo "
                        + " inner join Filial f on idfilial = id "
                        + " inner join Estado on f.idestado = id_estado "
                        + " WHERE a.idstatus = 1 and tipo = 2 and idfilial = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int idpessoa = resultados.getInt("idpessoa");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                int cep = resultados.getInt("cep");
                String estado = resultados.getString("estado");
                String cidade = resultados.getString("cidade");
                String cpf = resultados.getString("cpf");
                Date dtnascimento = resultados.getDate("dtnascimento");
                String email = resultados.getString("email");
                int telefone = resultados.getInt("telefone");
                int idnivel = resultados.getInt("id_nivel");
                String nivel = resultados.getString("nivel");
                int idcargo = resultados.getInt("id_cargo");
                String cargo = resultados.getString("cargo");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                String sexo = resultados.getString("sexo");
                int idsexo = resultados.getInt("idsexo");
                String filial = resultados.getString("NomeUnidade");
                int idfilial = resultados.getInt("id");
                int idestado = resultados.getInt("idestado");

                Pessoa p = new Pessoa();

                p.setId(idpessoa);
                p.setNome(nome);
                p.setSobrenome(sobrenome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setEstado(estado);
                p.setCidade(cidade);
                p.setCpf(cpf);
                p.setDataNasc(dtnascimento);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setIdnivel(idnivel);
                p.setNivel(nivel);
                p.setCargo(cargo);
                p.setIdcargo(idcargo);
                p.setLogin(login);
                p.setSenha(senha);
                p.setIdestado(idestado);
                p.setSexo(sexo);
                p.setIdsexo(idsexo);
                p.setIdfilial(idfilial);
                p.setFilial(filial);

                lista.add(p);

            }
        }
        return lista;
    }

    public void atualizar(Pessoa P) throws ClassNotFoundException, SQLException {
        try {

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Pessoa SET "
                    + "  nome = ? , sobrenome = ? , rua = ? , numero = ? , cep = ? , idestado = ? , cidade = ? , cpf = ? , dtnascimento = ? , email = ? , telefone = ? , bairro = ?, idsexo = ? "
                    + " WHERE idpessoa = ? ");
            stmt.setString(1, P.getNome());
            stmt.setString(2, P.getSobrenome());
            stmt.setString(3, P.getRua());
            stmt.setInt(4, P.getNumero());
            stmt.setInt(5, P.getCep());
            stmt.setInt(6, P.getIdestado());
            stmt.setString(7, P.getCidade());
            stmt.setString(8, P.getCpf());
            stmt.setDate(9, P.getDataNasc());
            stmt.setString(10, P.getEmail());
            stmt.setInt(11, P.getTelefone());
            stmt.setString(12, P.getBairro());
            stmt.setInt(13, P.getIdsexo());
            stmt.setInt(14, P.getId());

            stmt.executeUpdate();

            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void atualizarCliente(Pessoa P) throws ClassNotFoundException, SQLException {
        try {

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE PessoaCliente SET "
                    + "  cnh = ? , renda = ? "
                    + " WHERE id_pessoa = ? ");
            stmt.setDouble(1, P.getCnh());
            stmt.setDouble(2, P.getRenda());
            stmt.setInt(3, P.getId());
            stmt.executeUpdate();

            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void atualizarFuncionario(Pessoa P) throws ClassNotFoundException, SQLException {
        try {

            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE PessoaFuncionario SET "
                    + "  id_nivel = ? , id_cargo = ?, login = ?,  senha = ?, idfilial = ? "
                    + " WHERE id_pessoa = ? ");
            stmt.setDouble(1, P.getIdnivel());
            stmt.setString(2, P.getCargo());
            stmt.setString(3, P.getLogin());
            stmt.setString(4, P.getSenha());
            stmt.setInt(5, P.getIdfilial());
            stmt.setInt(6, P.getId());
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
                        "update test.Pessoa set idstatus = 0 WHERE idpessoa = ? ")) {
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

    public Pessoa obterFunc(String login, String senha) throws ClassNotFoundException, SQLException {
        Pessoa p = new Pessoa();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        " SELECT idpessoa,  nome, sobrenome, idsexo, sexo, a.rua, a.numero, a.cep, f.idestado, estado, cidade, cpf, dtnascimento, email, a.telefone, b.id_nivel, nivel, b.id_cargo, cargo, login, senha, idsexo, sexo, f.id, f.NomeUnidade, f.idestado  "
                        + " FROM test.Pessoa a inner join test.PessoaFuncionario b on a.idpessoa = b.id_pessoa "
                        + " inner join test.Nivel c on b.id_nivel = c.id_nivel "
                        + " inner join test.Cargo d on b.id_cargo = d.id_cargo "
                        + " inner join Estado on id_estado = idestado "
                        + " inner join Sexo on idsexo = id_sexo "
                        + " inner join Filial f on id = idfilial "
                        + " WHERE a.idstatus = 1 and b.login = '" + login + "' and b.senha = '" + senha + "'");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                int idpessoa = resultados.getInt("idpessoa");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String rua = resultados.getString("rua");
                int numero = resultados.getInt("numero");
                int cep = resultados.getInt("cep");
                String estado = resultados.getString("estado");
                String cidade = resultados.getString("cidade");
                String cpf = resultados.getString("cpf");
                Date dtnascimento = resultados.getDate("dtnascimento");
                String email = resultados.getString("email");
                int telefone = resultados.getInt("telefone");
                int idnivel = resultados.getInt("id_nivel");
                String nivel = resultados.getString("nivel");
                int idcargo = resultados.getInt("id_cargo");
                String cargo = resultados.getString("cargo");
                String login2 = resultados.getString("login");
                String senha2 = resultados.getString("senha");
                int idfilial = resultados.getInt("id");

                p.setId(idpessoa);
                p.setNome(nome);
                p.setSobrenome(sobrenome);
                p.setRua(rua);
                p.setNumero(numero);
                p.setCep(cep);
                p.setEstado(estado);
                p.setCidade(cidade);
                p.setCpf(cpf);
                p.setDataNasc(dtnascimento);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setIdnivel(idnivel);
                p.setNivel(nivel);
                p.setCargo(cargo);
                p.setIdcargo(idcargo);
                p.setLogin(login2);
                p.setSenha(senha2);
                p.setIdfilial(idfilial);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

    public static Pessoa logar(String login, String senha) throws Exception {
        try {
            Pessoa pessoa = new Pessoa();
            DaoPessoa conn = new DaoPessoa();
            pessoa = conn.obterFunc(login, senha);
            if (pessoa.getId() == 0) {
                throw new Exception("CPF e/ou senha incorreto(s)");
            }
            return pessoa;
        } catch (Exception e) {
            throw e;
        }
    }

}
