/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class GestaoDeFuncionarios
{

    private List<Funcionario> listaDeFuncionarios;

    private Funcionario funcionario;

    Scanner sc = new Scanner(System.in);

    public GestaoDeFuncionarios()
    {
        listaDeFuncionarios = new ArrayList<>();
    }

    /**
     * Método get da Lista de Funcionario.
     *
     * @return listaDeFuncionarios.
     */
    public List<Funcionario> getListaDeFuncionarios()
    {
        return listaDeFuncionarios;
    }

    /**
     * Método para cadastrar um novo funcionario.
     *
     *
     */
    public void cadastroDeFuncionario()
    {
        System.out.println("Qual o nome do funcionario: ");
        String name = sc.nextLine();

        System.out.println("Qual o sobrenome do funcionario: ");
        String sobrenome = sc.nextLine();

        System.out.println("Qual o endereço do funcionario: ");
        String endereco = sc.nextLine();

        System.out.println("Qual o telefone do funcionario: ");
        String telefone = sc.nextLine();

        System.out.println("Qual o cpf do funcionario: ");
        String cpf = sc.nextLine();

        System.out.println("Qual a data de nascimento do funcionario (formato dd/MM/yyyy): ");
        String aniversarioTexto = sc.nextLine();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate aniversario = LocalDate.parse(aniversarioTexto, formatoData);

        System.out.println("Qual vai ser o login do funcionario: ");
        String loginFuncionarioOriginal = sc.nextLine();

        System.out.println("Qual vai ser a senha do funcionario: ");
        String senhaFuncionarioOriginal = sc.nextLine();

        Funcionario novoFuncionario = new Funcionario(name, sobrenome, endereco, telefone, cpf, aniversario,
                loginFuncionarioOriginal, senhaFuncionarioOriginal);

        listaDeFuncionarios.add(novoFuncionario);

        System.out.println("Funcionario cadastrado com sucesso!");
    }

    /**
     * Método para editar o cadastro de um funcionario.
     *
     * @param cliente O funcionario cujas informações serão editadas.
     */
    public void editarCadastrofuncionario(Funcionario funcionario)
    {
        System.out.println("Qual informação vai ser alterada: name, sobrenome, endereco, telefone, cpf, "
                + "senha ou login?");
        String alterada = sc.nextLine();

        if (alterada.equals("name"))
        {
            System.out.println("Qual é o novo nome? ");
            String novoNome = sc.nextLine();
            funcionario.setName(novoNome);
        }
        else if (alterada.equals("sobrenome"))
        {
            System.out.println("Qual é o novo sobrenome? ");
            String novoSobrenome = sc.nextLine();
            funcionario.setSobrenome(novoSobrenome);
        }
        else if (alterada.equals("endereco"))
        {
            System.out.println("Qual é o novo endereco? ");
            String novoEndereco = sc.nextLine();
            funcionario.setEndereco(novoEndereco);
        }
        else if (alterada.equals("telefone"))
        {
            System.out.println("Qual é o novo telefone? ");
            String novoTelefone = sc.nextLine();
            funcionario.setTelefone(novoTelefone);
        }
        else if (alterada.equals("cpf"))
        {
            System.out.println("Qual é o novo cpf? ");
            String novoCpf = sc.nextLine();
            funcionario.setCpf(novoCpf);
        }
        else if (alterada.equals("senha"))
        {
            System.out.println("Qual é a nova senha? ");
            String novaSenha = sc.nextLine();
            funcionario.setSenhaFuncionarioOriginal(novaSenha);
        }
        else if (alterada.equals("login"))
        {
            System.out.println("Qual é o novo login? ");
            String novoLogin = sc.nextLine();
            funcionario.setLoginFuncionarioOriginal(novoLogin);
        }
    }

    public void excluirFuncionario()
    {
        System.out.println("Informe o CPF do funcionario a ser removido: ");
        String cpf = sc.nextLine();

        Funcionario funcionarioParaRemover = null;
        for (Funcionario funcionario : listaDeFuncionarios)
        {
            if (funcionario.getCpf().equals(cpf))
            {
                funcionarioParaRemover = funcionario;
                break;
            }
        }

        if (funcionarioParaRemover != null)
        {
            listaDeFuncionarios.remove(funcionarioParaRemover);
            System.out.println("Funcionario removido com sucesso!");
        }
        else
        {
            System.out.println("Funcionario com CPF " + cpf + " não encontrado.");
        }
    }
}
