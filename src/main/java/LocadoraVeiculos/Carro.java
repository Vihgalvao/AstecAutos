/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocadoraVeiculos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author victor.galvao
 */
public class Carro {
    
    private int idcarro;
    
    private String carro; 
    
    private String fabricante;
    
    private String cor;
    
    private int ano;
    
    private double valor;
    
    private String classificacao;
    
    private int idclassificacao;
  
        public Carro() {
      
    }
    
    public Carro(String carro, String fabricante, String cor, int ano, double valor, int idclassificacao) {
      
      this.carro = carro;
      this.fabricante = fabricante;
      this.cor = cor;
      this.ano = ano;
      this.valor = valor;
      this.classificacao = classificacao;
      this.idclassificacao = idclassificacao;
      
    }

    /**
     * @return the idcarro
     */
    public int getIdcarro() {
        return idcarro;
    }

    /**
     * @param idcarro the idcarro to set
     */
    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
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
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the classificacao
     */
    public String getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the idclassificacao
     */
    public int getIdclassificacao() {
        return idclassificacao;
    }

    /**
     * @param idclassificacao the idclassificacao to set
     */
    public void setIdclassificacao(int idclassificacao) {
        this.idclassificacao = idclassificacao;
    }
         
    
    
}
