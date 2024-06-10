/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema.model;

import java.time.Duration;
import java.util.Scanner;

/**
 * Classe para gerenciar o sistema do cinema.
 * <p>
 * Esta classe contém métodos para interação com diferentes tipos de usuários,
 * como clientes, funcionários e proprietários, fornecendo opções específicas de
 * acordo com o tipo de usuário.
 * </p>
 *
 * @author Lucas
 * @version 1.0
 */
public class Sistema
{

    Scanner sc = new Scanner(System.in);

    /**
     * Método para informar ao sistema se o usuário é cliente, funcionário ou
     * proprietário, e fornecer opções de ação de acordo com o tipo de usuário.
     *
     * @param cliente O cliente que está acessando o sistema.
     * @param sessao A sessão atual do cinema.
     * @param gestaoDeFilmes O gerenciador de filmes do cinema.
     * @param carrinho O carrinho de compras do cliente.
     * @param estoque O estoque de produtos do cinema.
     * @param funcionario O funcionário que está acessando o sistema.
     * @param gestaoDeClientes O gerenciador de clientes do cinema.
     * @param proprietario O proprietário do cinema.
     */
    public void informarClienteOuFuncionarioOuProprietario(Cliente cliente, Sessao sessao, GestaoDeFilmes gestaoDeFilmes,
            Carrinho carrinho, Estoque estoque, Funcionario funcionario,
            GestaoDeClientes gestaoDeClientes, Proprietario proprietario)
    {
        System.out.println("Você é Cliente, Funcionario ou Proprietario? ");
        String funcao = sc.nextLine();
        String loginClienteOriginal = cliente.getLoginClienteOriginal();
        String senhaClienteOriginal = cliente.getSenhaClienteOriginal();
        String loginFuncionarioOriginal = funcionario.getLoginFuncionarioOriginal();
        String senhaFuncionarioOriginal = funcionario.getSenhaFuncionarioOriginal();
        String loginProprietarioOriginal = proprietario.getLoginProprietarioOriginal();
        String senhaProprietarioOriginal = proprietario.getSenhaProprietarioOriginal();

        if (funcao.equals("Cliente"))
        {
            System.out.println("Informe o seu login: ");
            String loginCliente = sc.nextLine();
            System.out.println("Informe a sua senha: ");
            String senhaCliente = sc.nextLine();

            if (loginCliente.equals(loginClienteOriginal) && senhaCliente.equals(senhaClienteOriginal))
            {
                System.out.println("Bem vindo ao CineDjamas!\n Escolha a sua ação: Selecionar Filme, Selecionar Produtos");
                String acaoCliente = sc.nextLine();

                if (acaoCliente.equals("Selecionar sessao"))
                {
                    carrinho.selecionarSessao(Sessao.listarSessoes());
                }
                else if (acaoCliente.equals("Selecionar Produtos"))
                {
                    carrinho.selecionarProdutoEQuant();
                }
                else
                {
                    System.out.println("Função não existente");
                }
            }
            else
            {
                System.out.println("Login ou senha incorretos.");
                informarClienteOuFuncionarioOuProprietario(cliente, sessao, gestaoDeFilmes, carrinho, estoque,
                        funcionario, gestaoDeClientes, proprietario);
            }
        }
        else if (funcao.equals("Funcionario"))
        {
            System.out.println("Informe o seu login: ");
            String loginFuncionario = sc.nextLine();
            System.out.println("Informe a sua senha: ");
            String senhaFuncionario = sc.nextLine();

            if (loginFuncionario.equals(loginFuncionarioOriginal) && senhaFuncionario.equals(senhaFuncionarioOriginal))
            {
                System.out.println("Bem vindo ao CineDjamas!\n Escolha a sua ação: Cadastrar Cliente, "
                        + "Editar Cadastro Cliente, Cadastrar Filmes, Remover Filmes, "
                        + "Remover Produto, Listar Produtos, Selecionar Filme, Selecionar Produto, Cadastrar Funcionario");
                String acaoFuncionario = sc.nextLine();

                if (acaoFuncionario.equals("Cadastrar Cliente"))
                {
                    gestaoDeClientes.cadastroDeCliente();
                }
                else if (acaoFuncionario.equals("Editar Cadastro Cliente"))
                {
                    gestaoDeClientes.editarCadastroCliente(cliente);
                }
                else if (acaoFuncionario.equals("Cadastrar Filme"))
                {
                    System.out.println("informe o nome do filme que deseja cadastrar: ");
                    String nomeFilme = sc.nextLine();
                    System.out.println("informe o nome genero desse filme : ");
                    String generoFilme = sc.nextLine();
                    String duracao = sc.nextLine();
                    Duration duracaoFilme = Duration.parse(duracao);

                    gestaoDeFilmes.cadastraFilme(nomeFilme, generoFilme, duracaoFilme);
                }
                else if (acaoFuncionario.equals("Remover Filmes"))
                {
                    System.out.println("informe o nome do filme que deseja remover: ");
                    String nomeFilme = sc.nextLine();
                    gestaoDeFilmes.removeFilme(nomeFilme);
                }
                else if (acaoFuncionario.equals("Remover Produto"))
                {
                    System.out.println("informe o nome produto que deseja remover: ");
                    String nomeProduto = sc.nextLine();
                    estoque.removerProduto(nomeProduto);
                }
                else if (acaoFuncionario.equals("Listar Produtos"))
                {
                    estoque.listarProdutosDisponiveis();
                }
                else if (acaoFuncionario.equals("Selecionar Filme"))
                {
                    carrinho.selecionarSessao(Sessao.listarSessoes());
                }
                else if (acaoFuncionario.equals("Selecionar Produto"))
                {
                    carrinho.selecionarProdutoEQuant();
                }
                else if (acaoFuncionario.equals("Cadastrar Funcionario"))
                {
                    funcionario.funcionarioRealizarCadastro();
                }
                else
                {
                    System.out.println("Função não existente");
                }
            }
            else
            {
                System.out.println("Login ou senha incorretos.");
                informarClienteOuFuncionarioOuProprietario(cliente, sessao, gestaoDeFilmes, carrinho, estoque,
                        funcionario, gestaoDeClientes, proprietario);
            }
        }
        else if (funcao.equals("Proprietario"))
        {
            System.out.println("Informe o seu login: ");
            String loginProprietario = sc.nextLine();
            System.out.println("Informe a sua senha: ");
            String senhaProprietario = sc.nextLine();

            if (loginProprietario.equals(loginProprietarioOriginal) && senhaProprietario.equals(senhaProprietarioOriginal))
            {
                System.out.println("Bem vindo ao CineDjamas!\n Escolha a sua ação: Registrar Proprietario, Comprar Estoque, Cadastrar Cliente, "
                        + "Editar Cadastro Cliente, Cadastrar Filmes, Remover Filmes, Remover Produto, Listar Produtos, Selecionar Filme, "
                        + "Selecionar Produto, Cadastrar Funcionario");
                String acaoFuncionario = sc.nextLine();

                if (acaoFuncionario.equals("Registrar Proprietario"))
                {
                    proprietario.registroProprietario();
                }
                else if (acaoFuncionario.equals("Comprar Estoque"))
                {
                    proprietario.compraDeEstoque(estoque);
                }
                else if (acaoFuncionario.equals("Cadastrar Cliente"))
                {
                    gestaoDeClientes.cadastroDeCliente();
                }
                else if (acaoFuncionario.equals("Editar Cadastro Cliente"))
                {
                    gestaoDeClientes.editarCadastroCliente(cliente);
                }
                else if (acaoFuncionario.equals("Cadastrar Filme"))
                {
                    System.out.println("informe o nome do filme que deseja cadastrar: ");
                    String nomeFilme = sc.nextLine();
                    System.out.println("informe o nome genero desse filme : ");
                    String generoFilme = sc.nextLine();
                    String duracao = sc.nextLine();
                    Duration duracaoFilme = Duration.parse(duracao);

                    gestaoDeFilmes.cadastraFilme(nomeFilme, generoFilme, duracaoFilme);
                }
                else if (acaoFuncionario.equals("Remover Filmes"))
                {
                    System.out.println("informe o nome filme que deseja remover: ");
                    String nomeFilme = sc.nextLine();
                    estoque.removerProduto(nomeFilme);
                }
                else if (acaoFuncionario.equals("Remover Produto"))
                {
                    System.out.println("informe o nome produto que deseja remover: ");
                    String nomeProduto = sc.nextLine();
                    estoque.removerProduto(nomeProduto);

                }
                else if (acaoFuncionario.equals("Listar Produtos"))
                {
                    estoque.listarProdutosDisponiveis();
                }
                else if (acaoFuncionario.equals("Selecionar Filme"))
                {

                    carrinho.selecionarSessao(Sessao.listarSessoes());
                }
                else if (acaoFuncionario.equals("Selecionar Produto"))
                {
                    carrinho.selecionarProdutoEQuant();
                }
                else if (acaoFuncionario.equals("Cadastrar Funcionario"))
                {
                    funcionario.funcionarioRealizarCadastro();
                }
                else
                {
                    System.out.println("Função não existente");
                }
            }
            else
            {
                System.out.println("Login ou senha incorretos.");
                informarClienteOuFuncionarioOuProprietario(cliente, sessao, gestaoDeFilmes, carrinho, estoque,
                        funcionario, gestaoDeClientes, proprietario);
            }
        }
    }
}