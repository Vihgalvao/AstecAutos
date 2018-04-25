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
 * @author fernando.tsuda
 */
public class Filial {
    
    private int id;
    
    private String nomeUnidade;
    
    private String rua;
    
    private int numero;
    
    private int cep;
    
    private int telefone;
   
    private String gerente;
    
    public Filial() {
      
    }
    
    public Filial(String nomeUnidade, String Rua, int numero, int cep, int telefone, String gerente) {
      DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
      this.nomeUnidade = nomeUnidade;
      this.rua = Rua;
      this.numero = numero;
      this.cep = cep;
      this.telefone = telefone;
      this.gerente = gerente;
      
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
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @param nomeUnidade the nomeUnidade to set
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return this.rua;
    }

    /**
     * @param Rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
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
     * @return the gerente
     */
    public String getGerente() {
        return gerente;
    }

    /**
     * @param gerente the gerente to set
     */
    public void setGerente(String gerente) {
        this.gerente = gerente;
    }


    
    
}
