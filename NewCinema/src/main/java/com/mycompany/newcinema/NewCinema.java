/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.newcinema;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author enzov
 */
public class NewCinema
{

    public static void main(String[] args) throws IOException
    {
        /*
        //Simulacao completa de uma venda
        GestaoDeClientes gestaoDeClientes = new GestaoDeClientes();
        // Cadastra alguns clientes
        Cliente cliente1 = new Cliente("João", "Silva", "Rua A", "123456789", "11111111111", LocalDate.of(1985, 5, 20));

        GestaoDeFilmes gestaoDeFilmes = new GestaoDeFilmes();
        gestaoDeFilmes.cadastraFilme("Titanic", "Acao", Duration.ofMinutes(120));
        gestaoDeFilmes.cadastraFilme("Procurando Nemo", "Animacao", Duration.ofMinutes(90));
        List<Filme> filmes = gestaoDeFilmes.getFilmes();

        //inicializa sessao
        Sala sala1 = new Sala(1, filmes.get(0));
        Sala sala2 = new Sala(2, filmes.get(1));
        Sessao.criarSessao(filmes.get(0), sala1, LocalDateTime.of(2024, 5, 20, 14, 0));
        Sessao.criarSessao(filmes.get(1), sala2, LocalDateTime.of(2024, 5, 20, 16, 0));

        //inicializa estoque
        Estoque estoque = new Estoque();
        Produto pipoca = estoque.cadastrarProduto("Pipoca Doce", LocalDate.of(2024, 12, 31), 5.00);
        Produto guloseima = estoque.cadastrarProduto("Guloseima Chocolate", LocalDate.of(2024, 10, 31), 3.00);
        Produto bebida = estoque.cadastrarProduto("Bebida Cola", LocalDate.of(2024, 11, 30), 4.00);

        // Inicializa os balcões
        Caixa.inicializarBalcoes(estoque);
        Caixa caixa1 = Caixa.getBalcoes()[0];
        caixa1.informarValorIngresso(10.00);

        // Simulacao de uma venda
        Carrinho carrinho = new Carrinho();
        carrinho.selecionarSessao(Sessao.listarSessoes());
        carrinho.selecionarPoltronas();
        carrinho.selecionarProdutoEQuant();
        caixa1.efetuarPagamento(cliente1);

        Repositorys.salvarClientesComVendas(gestaoDeClientes.getListaDeClientes(), caixa1.getVendasPorCliente());
        */
       
        ///Questão 3
        /*
            //Pessoa
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Pessoa pessoa = new Pessoa("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa);
                System.out.println(pessoa.toString());
            }

            //Cliente
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Cliente cliente = new Cliente("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa, "Batman", "Ação", "lucas", "1234");
                System.out.println(cliente.toString());
            }

            //Funcionario
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Funcionario funcionario = new Funcionario("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa, "lucas", "1234");
                System.out.println(funcionario.toString());
            }

            //Proprietario
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Proprietario proprietario = new Proprietario("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa, "lucas", "1234");
                System.out.println(proprietario.toString());
            }
        }

        ///Questão 4
        {
            //Cliente
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Cliente cliente = new Cliente("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa, "Batman", "Ação", "lucas", "1234");
                System.out.println(cliente.toString());
            }

            //Funcionario
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Funcionario funcionario = new Funcionario("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa, "lucas", "1234");
                System.out.println(funcionario.toString());
            }

            //Proprietario
            {
                LocalDate dataPessoa = LocalDate.of(2001, 11, 07);
                Proprietario proprietario = new Proprietario("Lucas", "Martins", "Diamantina", "(31)98448-9509", "155.150.566-55", dataPessoa, "lucas", "1234");
                System.out.println(proprietario.toString());
            }
        }
        
        //Questão 05
        
        Estoque estoque = new Estoque();
        
        Caixa.inicializarBalcoes(estoque);
        Caixa[] balcoes = Caixa.getBalcoes();

        for (int i = 0; i < balcoes.length; i++)
        {
            System.out.println("Balcao " + (i + 1) + ": " + balcoes[i]);
        }

        ///Questão 6
        {
            GestaoDeFuncionarios gestaoFuncionarios = new GestaoDeFuncionarios();
            gestaoFuncionarios.cadastroDeFuncionario();
            gestaoFuncionarios.cadastroDeFuncionario();

            System.out.println("Funcionarios cadastrados:");
            for (Funcionario funcionario : gestaoFuncionarios.getListaDeFuncionarios())
            {
                System.out.println(funcionario);
            }

            gestaoFuncionarios.excluirFuncionario();

            System.out.println("Funcionarios restantes:");
            for (Funcionario funcionario : gestaoFuncionarios.getListaDeFuncionarios())
            {
                System.out.println(funcionario);
            }
        }

        //Questao 7
        {
            GestaoDeClientes gestaoClientes = new GestaoDeClientes();
            gestaoClientes.cadastroDeCliente();
            gestaoClientes.cadastroDeCliente();

            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : gestaoClientes.getListaDeClientes())
            {
                System.out.println(cliente);
            }

            gestaoClientes.excluirCliente();

            System.out.println("Clientes restantes:");
            for (Cliente cliente : gestaoClientes.getListaDeClientes())
            {
                System.out.println(cliente);
            }
        }
         */
        //Questao 08
        /*
         System.out.println("Dados das vendas diárias:");
        caixa1.listarVendasDiarias();

        System.out.println("\nDados dos clientes:");
        gestaoDeClientes.listarClientes();
         */
 /*
        //Questao 10
            
        caixa1.extratoVenda();
        Repositorys.salvarClientesComVendas(gestaoDeClientes.getListaDeClientes(), caixa1.getVendasPorCliente());
        
        
        //Questao 12

        Produto.getN_INSTANCIAS();
        
        
        //Questao 13
        ComparacoesFilme.comparaNomes();
        ComparacoesFilme.compareTotalDuracao();
        ComparacoesFilme.compareTotalEspectadores();
        
        ComparacoesVenda.compararPorValorTotal();
        ComparacoesVenda.compararPorValorIngressos();
        ComparacoesVenda.compararPorValorProdutos();
        
        GestaoDeFilmes gestaoDeFilmesas = new GestaoDeFilmes();

        gestaoDeFilmes.cadastraFilme("Titanic", "Acao", Duration.ofMinutes(120));
        gestaoDeFilmes.cadastraFilme("Procurando Nemo", "Animacao", Duration.ofMinutes(90));
        gestaoDeFilmes.cadastraFilme("Avatar", "Ficcao Cientifica", Duration.ofMinutes(150));
        gestaoDeFilmes.cadastraFilme("Matrix", "Ficcao Cientifica", Duration.ofMinutes(136));
        gestaoDeFilmes.cadastraFilme("Interestelar", "Ficcao Cientifica", Duration.ofMinutes(169));
        
        //Questao 16
        // Acessa os filmes pela posição na lista
        List<Filme> filmess = gestaoDeFilmes.getFilmes();
        //Ordenacao de Filmes
        
        // Ordena a lista de Filmes pelo nome
        Collections.sort(filmess, ComparacoesFilme.comparaNomes());
        
        for (Filme filme : filmess)
        {
            System.out.println(filme);
        }
       
        // Ordena a lista de Filmes pelo total de expectadores
        Collections.sort(filmes, ComparacoesFilme.compareTotalEspectadores());
        
        // Ordena a lista de Filmes pela duracao
        Collections.sort(filmes, ComparacoesFilme.compareTotalDuracao());
        
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(LocalDate.now(), 200.0, 150.0, 50.0));
        vendas.add(new Venda(LocalDate.now(), 300.0, 200.0, 100.0));
        vendas.add(new Venda(LocalDate.now(), 100.0, 50.0, 50.0));
        // Ordena as vendas pelo valor total
        Collections.sort(vendas, ComparacoesVenda.compararPorValorTotal());
        System.out.println("Vendas ordenadas por valor total:");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }

        // Ordena as vendas pelo valor total dos ingressos
        Collections.sort(vendas, ComparacoesVenda.compararPorValorIngressos());
        System.out.println("Vendas ordenadas por valor total dos ingressos:");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }

        // Ordena as vendas pelo valor total dos produtos
        Collections.sort(vendas, ComparacoesVenda.compararPorValorProdutos());
        System.out.println("Vendas ordenadas por valor total dos produtos:");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
        */
         
    }
}
