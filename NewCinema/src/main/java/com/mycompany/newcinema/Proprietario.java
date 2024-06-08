/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe para representar um Proprietário do cinema.
 * <p>
 * Esta classe estende a classe Funcionario e adiciona funcionalidades
 * específicas de um proprietário, como realizar login, registro e compra de
 * estoque.
 * </p>
 *
 * @author Lucas
 * @version 1.0
 */
public class Proprietario extends Funcionario
{

    private String senhaProprietarioOriginal;
    private String loginProprietarioOriginal;
    private Estoque estoque;

    Scanner sc = new Scanner(System.in);

    /**
     * Construtor com informações do proprietário.
     *
     * @param senhaProprietarioOriginal A senha original do proprietário.
     * @param loginProprietarioOriginal O login original do proprietário.
     * @param name O nome do proprietário.
     * @param sobrenome O sobrenome do proprietário.
     * @param endereco O endereço do proprietário.
     * @param telefone O telefone do proprietário.
     * @param cpf O CPF do proprietário.
     * @param aniversario A data de nascimento do proprietário.
     */
    public Proprietario(String name, String sobrenome, String endereco, String telefone, String cpf, LocalDate aniversario, String senhaProprietarioOriginal, String loginProprietarioOriginal)
    {
        super(name, sobrenome, endereco, telefone, cpf, aniversario);
        this.senhaProprietarioOriginal = senhaProprietarioOriginal;
        this.loginProprietarioOriginal = loginProprietarioOriginal;
        setCategoria("Proprietario");
    }

    /**
     * Método para realizar o login do proprietário.
     */
    public void proprietarioRealizarLogin()
    {
        boolean loginValido = false;
        while (!loginValido)
        {
            System.out.println("Informe o seu login: ");
            String loginProprietario = sc.nextLine();
            System.out.println("Informe a sua senha: ");
            String senhaProprietario = sc.nextLine();

            if (loginProprietario.equals(loginProprietarioOriginal) && senhaProprietario.equals(senhaProprietarioOriginal))
            {
                loginValido = true;
                System.out.println("Bem vindo ao CineDjamas proprietario");
            }
            else
            {
                System.out.println("Login ou senha incorretos. Tente novamente");
            }
        }
    }

    /**
     * Método para registrar um novo proprietário.
     */
    public void registroProprietario()
    {
        System.out.println("Qual o seu nome: ");
        String name = sc.nextLine();
        setName(name);

        System.out.println("Qual o seu sobrenome: ");
        String sobrenome = sc.nextLine();
        setSobrenome(sobrenome);

        System.out.println("Qual o seu endereço: ");
        String endereco = sc.nextLine();
        setEndereco(endereco);

        System.out.println("Qual o seu telefone: ");
        String telefone = sc.nextLine();
        setTelefone(telefone);

        System.out.println("Qual o seu cpf: ");
        String cpf = sc.nextLine();
        setCpf(cpf);

        System.out.println("Qual a sua data de nascimento: ");
        String aniversarioTexto = sc.next();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate aniversario = LocalDate.parse(aniversarioTexto, formatoData);
        setAniversario(aniversario);

        System.out.println("Qual vai ser o seu login: ");
        String loginProprietarioOriginal = sc.nextLine();

        System.out.println("Qual vai ser a sua senha: ");
        String senhaProprietarioOriginal = sc.nextLine();
    }

    /**
     * Método para realizar a compra de produtos para o estoque.
     *
     * @param estoque O estoque onde serão adicionados os produtos.
     */
    public void compraDeEstoque(Estoque estoque)
    {
        System.out.println("Qual produto você deseja comprar: pipoca, bebidas ou guloseimas? ");
        String produtoComprado = sc.nextLine();

        System.out.println("Quantos produtos você deseja comprar? ");
        int quantidadeComprado = sc.nextInt();
        sc.nextLine();

        if (produtoComprado.equals("pipoca"))
        {
            int quantidadePipoca = estoque.getQuantidadePipoca();
            quantidadePipoca = quantidadePipoca + quantidadeComprado;
            estoque.setQuantidadePipoca(quantidadePipoca);
            System.out.println("Informe a validade da pipoca: ");
            String entrada = sc.nextLine();
            LocalDate validadePipoca = LocalDate.parse(entrada);
            System.out.println("Informe o valor da pipoca: ");
            int preco = Integer.parseInt(sc.nextLine());
            estoque.cadastrarProduto("Pipoca", validadePipoca, preco);
        }
        else if (produtoComprado.equals("bebidas"))
        {
            int quantidadeBebidas = estoque.getQuantidadeBebidas();
            quantidadeBebidas = quantidadeBebidas + quantidadeComprado;
            estoque.setQuantidadeBebidas(quantidadeBebidas);
            System.out.println("Informe a validade da bebida: ");
            String entrada = sc.nextLine();
            LocalDate validadebebidas = LocalDate.parse(entrada);
            System.out.println("Informe o valor da bebida: ");
            int preco = Integer.parseInt(sc.nextLine());
            estoque.cadastrarProduto("Pipoca", validadebebidas, preco);
        }
        else if (produtoComprado.equals("guloseimas"))
        {
            int quantidadeGuloseimas = estoque.getQuantidadeGuloseimas();
            quantidadeGuloseimas = quantidadeGuloseimas + quantidadeComprado;
            estoque.setQuantidadeGuloseimas(quantidadeGuloseimas);
            System.out.println("Informe a validade da guloseima: ");
            String entrada = sc.nextLine();
            LocalDate validadeguloseima = LocalDate.parse(entrada);
            System.out.println("Informe o valor da guloseima: ");
            int preco = Integer.parseInt(sc.nextLine());
            estoque.cadastrarProduto("Pipoca", validadeguloseima, preco);
        }
    }

    /**
     * Obtém a senha original do proprietário.
     *
     * @return A senha original do proprietário.
     */
    public String getSenhaProprietarioOriginal()
    {
        return senhaProprietarioOriginal;
    }

    /**
     * Obtém o login original do proprietário.
     *
     * @return O login original do proprietário.
     */
    public String getLoginProprietarioOriginal()
    {
        return loginProprietarioOriginal;
    }

    /**
     * Define a senha original do proprietário.
     *
     * @param senhaProprietarioOriginal A senha original do proprietário.
     */
    public void setSenhaProprietarioOriginal(String senhaProprietarioOriginal)
    {
        this.senhaProprietarioOriginal = senhaProprietarioOriginal;
    }

    /**
     * Define o login original do proprietário.
     *
     * @param loginProprietarioOriginal O login original do proprietário.
     */
    public void setLoginProprietarioOriginal(String loginProprietarioOriginal)
    {
        this.loginProprietarioOriginal = loginProprietarioOriginal;
    }

    @Override
    public String toString()
    {
        return "Proprietario{"
                + "nome = " + getName()
                + ", sobrenome = " + getSobrenome()
                + ", endereço = " + getEndereco()
                + ", telefone = " + getTelefone()
                + ", CPF = " + getCpf()
                + ", aniversario = " + getAniversario()
                + ", login = " + getLoginProprietarioOriginal()
                + ", senha = " + getSenhaProprietarioOriginal()
                + '}';
    }

}
