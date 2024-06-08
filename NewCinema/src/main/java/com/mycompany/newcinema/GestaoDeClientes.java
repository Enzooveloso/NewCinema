/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para gerenciar clientes do cinema.
 * <p>
 * Esta classe contém métodos para cadastrar clientes, bem como editar
 * informações dos clientes cadastrados.
 * </p>
 *
 * @author Lucas
 * @version 1.0
 */
public class GestaoDeClientes
{

    public List<Cliente> listaDeClientes;

    private Cliente cliente;

    Scanner sc = new Scanner(System.in);

    public GestaoDeClientes()
    {
        listaDeClientes = new ArrayList<>();
    }

    /**
     * Método get da Lista de Clientes.
     *
     * @return listaDeClientes.
     */
    public List<Cliente> getListaDeClientes()
    {
        return listaDeClientes;
    }

    /**
     * Método para cadastrar um novo cliente.
     *
     *
     */
    public void cadastroDeCliente()
    {
        System.out.println("Qual o nome do cliente: ");
        String name = sc.nextLine();

        System.out.println("Qual o sobrenome do cliente: ");
        String sobrenome = sc.nextLine();

        System.out.println("Qual o endereço do cliente: ");
        String endereco = sc.nextLine();

        System.out.println("Qual o telefone do cliente: ");
        String telefone = sc.nextLine();

        System.out.println("Qual o cpf do cliente: ");
        String cpf = sc.nextLine();

        System.out.println("Qual a data de nascimento do cliente (formato dd/MM/yyyy): ");
        String aniversarioTexto = sc.nextLine();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate aniversario = LocalDate.parse(aniversarioTexto, formatoData);

        System.out.println("Qual é a preferência de filme do cliente: ");
        String preferenciaDeFilme = sc.nextLine();

        System.out.println("Qual é a preferência de gênero do cliente: ");
        String preferenciaDeGenero = sc.nextLine();

        System.out.println("Qual vai ser o login do cliente: ");
        String loginClienteOriginal = sc.nextLine();

        System.out.println("Qual vai ser a senha do cliente: ");
        String senhaClienteOriginal = sc.nextLine();

        Cliente novoCliente = new Cliente(name, sobrenome, endereco, telefone, cpf, aniversario,
                preferenciaDeFilme, preferenciaDeGenero, loginClienteOriginal, senhaClienteOriginal);

        listaDeClientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    /**
     * Método para editar o cadastro de um cliente.
     *
     * @param cliente O cliente cujas informações serão editadas.
     */
    public void editarCadastroCliente(Cliente cliente)
    {
        System.out.println("Qual informação vai ser alterada: name, sobrenome, endereco, telefone, cpf, "
                + "preferencia de filme, preferencia de genero, senha ou login?");
        String alterada = sc.nextLine();

        if (alterada.equals("name"))
        {
            System.out.println("Qual é o novo nome? ");
            String novoNome = sc.nextLine();
            cliente.setName(novoNome);
        }
        else if (alterada.equals("sobrenome"))
        {
            System.out.println("Qual é o novo sobrenome? ");
            String novoSobrenome = sc.nextLine();
            cliente.setSobrenome(novoSobrenome);
        }
        else if (alterada.equals("endereco"))
        {
            System.out.println("Qual é o novo endereco? ");
            String novoEndereco = sc.nextLine();
            cliente.setEndereco(novoEndereco);
        }
        else if (alterada.equals("telefone"))
        {
            System.out.println("Qual é o novo telefone? ");
            String novoTelefone = sc.nextLine();
            cliente.setTelefone(novoTelefone);
        }
        else if (alterada.equals("cpf"))
        {
            System.out.println("Qual é o novo cpf? ");
            String novoCpf = sc.nextLine();
            cliente.setCpf(novoCpf);
        }
        else if (alterada.equals("preferencia de filme"))
        {
            System.out.println("Qual é a nova preferencia de filme? ");
            String novaPreferenciaDeFilme = sc.nextLine();
            cliente.setPreferenciaDeFilme(novaPreferenciaDeFilme);
        }
        else if (alterada.equals("preferencia de genero"))
        {
            System.out.println("Qual é a nova preferencia de genero? ");
            String novaPreferenciaDeGenero = sc.nextLine();
            cliente.setPreferenciaDeGenero(novaPreferenciaDeGenero);
        }
        else if (alterada.equals("senha"))
        {
            System.out.println("Qual é a nova senha? ");
            String novaSenha = sc.nextLine();
            cliente.setSenhaClienteOriginal(novaSenha);
        }
        else if (alterada.equals("login"))
        {
            System.out.println("Qual é o novo login? ");
            String novoLogin = sc.nextLine();
            cliente.setLoginClienteOriginal(novoLogin);
        }
    }

    public void excluirCliente()
    {
        System.out.println("Informe o CPF do cliente a ser removido: ");
        String cpf = sc.nextLine();

        Cliente clienteParaRemover = null;
        for (Cliente cliente : listaDeClientes)
        {
            if (cliente.getCpf().equals(cpf))
            {
                clienteParaRemover = cliente;
                break;
            }
        }

        if (clienteParaRemover != null)
        {
            listaDeClientes.remove(clienteParaRemover);
            System.out.println("Cliente removido com sucesso!");
        }
        else
        {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    /**
     * Lista todos os clientes cadastrados.
     */
    public void listarClientes()
    {
        for (Cliente cliente : listaDeClientes)
        {
            System.out.println(cliente);
        }
    }
}
