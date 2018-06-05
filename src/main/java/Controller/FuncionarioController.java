/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoPessoa;
import Model.Pessoa;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victor.galvao
 */
public class FuncionarioController {

    public String validar(Pessoa funcionario) throws Exception {
        String erro = null;
        
        try {
            if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
                erro = "Campo Nome vazio";
                throw new Exception("Campo Nome vazio");
            }

            //validarCPF(funcionario.getCpf());
            if (funcionario.getSobrenome() == null || funcionario.getSobrenome().trim().isEmpty()) {
                erro = "Campo Sobrenome vazio";
                throw new Exception("Campo Sobrenome vazio");
            }

            if (funcionario.getRua() == null || funcionario.getRua().trim().isEmpty()) {
                erro = "Campo Rua vazio";
                //JOptionPane.showMessageDialog(null, "Campo Rua Vazio", "Erro", JOptionPane.ERROR_MESSAGE, null);

                //throw new Exception("Campo Rua vazio");
            }

            if (funcionario.getBairro() == null || funcionario.getBairro().trim().isEmpty()) {
                erro = "Campo Bairro vazio";
                throw new Exception("Campo Bairro vazio");
            }

            if (funcionario.getNumero() <= 0) {
                erro = "Numero inválido";
                throw new Exception("Numero inválido");
            }

            if (funcionario.getCep() <= 0) {
                 erro = "CEP inválido";
                throw new Exception("CEP inválido");
            }

            if (funcionario.getCidade() == null || funcionario.getCidade().trim().isEmpty()) {
                erro = "Campo Cidade vazio";
                throw new Exception("Campo Cidade vazio");
            }

//            if (funcionario.getCpf() <= 0 && funcionario.getCpf() < 9 && funcionario.getCpf() > 11) {
//                erro = "CEP inválido";
//                throw new Exception("CEP inválido");
//            }

            if (funcionario.getEmail() == null || funcionario.getEmail().trim().isEmpty()) {
                erro = "Campo Email vazio";
                throw new Exception("Campo Email vazio");
            }


            if (funcionario.getLogin() == null || funcionario.getLogin().trim().isEmpty()) {
                erro = "Campo Login vazio";
                throw new Exception("Campo Login vazio");
            }

            if (funcionario.getSenha() == null || funcionario.getSenha().trim().isEmpty()) {
                erro = "Campo Senha vazio";
                throw new Exception("Campo Senha vazio");
            }
            
            return erro;

        } catch (Exception e) {
            throw e;
        }
    }

//    private static void validarCPF(int CPF) throws Exception {
//        try {
//            if (!(CPF == 11)) {
//                throw new Exception("CPF inválido");
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
}
