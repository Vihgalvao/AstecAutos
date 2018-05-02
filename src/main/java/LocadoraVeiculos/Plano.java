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
public class Plano {
    
    private int idplano;
    
    private String plano;
    
    private int idclassificacao;
    
    private String classificacao;
    
    private double valor;
      
    public Plano() {
      
    }
    
    public Plano(String ds_plano, int id_classificao, double valor) {

      this.plano = ds_plano;
      this.idclassificacao = id_classificao;
      this.valor = valor;
    
    }

    /**
     * @return the idplano
     */
    public int getIdplano() {
        return idplano;
    }

    /**
     * @param idplano the idplano to set
     */
    public void setIdplano(int idplano) {
        this.idplano = idplano;
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

   

    
}
