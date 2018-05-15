/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos;

import java.util.Date;

/**
 *
 * @author guilherme.rocha
 */
public class Pedido {
    private long Id;
    private long IdPessoa;
    private long IdPlano;
    private long IdCarro;
    private long IdFuncionario;
    private long Idfilial;
    private Date DataLocacao;
    private Date DataDevolucao;
    private int DiasAlugados;
    private String Status;
    private double ValorTotal;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(long IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public long getIdPlano() {
        return IdPlano;
    }

    public void setIdPlano(long IdPlano) {
        this.IdPlano = IdPlano;
    }

    public long getIdCarro() {
        return IdCarro;
    }

    public void setIdCarro(long IdCarro) {
        this.IdCarro = IdCarro;
    }

    public long getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(long IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public long getIdfilial() {
        return Idfilial;
    }

    public void setIdfilial(long Idfilial) {
        this.Idfilial = Idfilial;
    }

    public Date getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(Date DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }
    
    public Date getDataLocacao() {
        return DataLocacao;
    }

    public void setDataLocacao(Date DataLocacao) {
        this.DataLocacao = DataLocacao;
    }

    public int getDiasAlugados() {
        return DiasAlugados;
    }

    public void setDiasAlugados(int DiasAlugados) {
        this.DiasAlugados = DiasAlugados;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
}
