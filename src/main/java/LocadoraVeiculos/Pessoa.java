/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos;

import java.sql.Date;

/**
 *
 * @author victor.galvao
 */
public class Pessoa {

    private int id;
    private int idcliente;
    private int idfuncionario;
    private String nome;
    private String sobrenome;
    private String rua;
    private int numero;
    private int cep;
    private String estado;
    private String cidade;
    private double cpf;
    private Date dataNasc;
    private String email;
    private int telefone;
    private int tipo;
    private double cnh;
    private double renda;
    private int idnivel;
    private String nivel;
    private String login;
    private String senha;
    private String Cargo;
    private int idcargo;
    
    public Pessoa() {

    }

    public Pessoa(String nome, String sobrenome, String rua, int numero, int cep, String estado, String cidade, int cpf, Date dtnascimento, 
            String email, int telefone, int tipo) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.cpf = cpf;
        this.dataNasc = dtnascimento;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the Sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param Sobrenome the Sobrenome to set
     */
    public void setSobrenome(String Sobrenome) {
        this.sobrenome = Sobrenome;
    }

    /**
     * @return the Rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param Rua the Rua to set
     */
    public void setRua(String Rua) {
        this.rua = Rua;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    /**
     * @return the cpf
     */
    public double getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataNasc
     */
    public Date getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cnh
     */
    public double getCnh() {
        return cnh;
    }

    /**
     * @param cnh the cnh to set
     */
    public void setCnh(double cnh) {
        this.cnh = cnh;
    }

    /**
     * @return the renda
     */
    public double getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(double renda) {
        this.renda = renda;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the Cargo
     */
    public String getCargo() {
        return Cargo;
    }

    /**
     * @param Cargo the Cargo to set
     */
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the idfuncionario
     */
    public int getIdfuncionario() {
        return idfuncionario;
    }

    /**
     * @param idfuncionario the idfuncionario to set
     */
    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idnivel
     */
    public int getIdnivel() {
        return idnivel;
    }

    /**
     * @param idnivel the idnivel to set
     */
    public void setIdnivel(int idnivel) {
        this.idnivel = idnivel;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the idcargo
     */
    public int getIdcargo() {
        return idcargo;
    }

    /**
     * @param idcargo the idcargo to set
     */
    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

   

}
