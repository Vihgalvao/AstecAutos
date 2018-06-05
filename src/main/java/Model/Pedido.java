/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author guilherme.rocha
 */
public class Pedido {
    private long Id;
    private long idpessoa;
    private String nomeCliente;
    private String cpf;
    private long idplano;
    private String plano;
    private long idcarro;
    private String carro;
    private long idfuncionario;
    private long idfilial;
    private String filial;
    private Date dtlocacao;
    private Date dtdevolucao;
    private int DiasAlugados;
    private int Status;
    private String dsStatus;
    private double valortotal;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

  

    public int getDiasAlugados() {
        return DiasAlugados;
    }

    public void setDiasAlugados(int DiasAlugados) {
        this.DiasAlugados = DiasAlugados;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }



    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the plano
     */
    public String getPlano() {
        return plano;
    }

    /**
     * @param plano the plano to set
     */
    public void setPlano(String plano) {
        this.plano = plano;
    }

    /**
     * @return the carro
     */
    public String getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(String carro) {
        this.carro = carro;
    }

    /**
     * @return the filial
     */
    public String getFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(String filial) {
        this.filial = filial;
    }

    /**
     * @return the dsStatus
     */
    public String getDsStatus() {
        return dsStatus;
    }

    /**
     * @param dsStatus the dsStatus to set
     */
    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dtlocacao
     */
    public Date getDtlocacao() {
        return dtlocacao;
    }

    /**
     * @param dtlocacao the dtlocacao to set
     */
    public void setDtlocacao(Date dtlocacao) {
        this.dtlocacao = dtlocacao;
    }

    /**
     * @return the dtdevolucao
     */
    public Date getDtdevolucao() {
        return dtdevolucao;
    }

    /**
     * @param dtdevolucao the dtdevolucao to set
     */
    public void setDtdevolucao(Date dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }

    /**
     * @return the idpessoa
     */
    public long getIdpessoa() {
        return idpessoa;
    }

    /**
     * @param idpessoa the idpessoa to set
     */
    public void setIdpessoa(long idpessoa) {
        this.idpessoa = idpessoa;
    }

    /**
     * @return the idplano
     */
    public long getIdplano() {
        return idplano;
    }

    /**
     * @param idplano the idplano to set
     */
    public void setIdplano(long idplano) {
        this.idplano = idplano;
    }

    /**
     * @return the idcarro
     */
    public long getIdcarro() {
        return idcarro;
    }

    /**
     * @param idcarro the idcarro to set
     */
    public void setIdcarro(long idcarro) {
        this.idcarro = idcarro;
    }

    /**
     * @return the idfuncionario
     */
    public long getIdfuncionario() {
        return idfuncionario;
    }

    /**
     * @param idfuncionario the idfuncionario to set
     */
    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    /**
     * @return the idfilial
     */
    public long getIdfilial() {
        return idfilial;
    }

    /**
     * @param idfilial the idfilial to set
     */
    public void setIdfilial(long idfilial) {
        this.idfilial = idfilial;
    }

    /**
     * @return the valortotal
     */
    public double getValortotal() {
        return valortotal;
    }

    /**
     * @param valortotal the valortotal to set
     */
    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    /**
     * @return the nomeCliente
     */

}
