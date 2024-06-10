/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.newcinema.main;

import com.mycompany.newcinema.model.Carrinho;
import com.mycompany.newcinema.model.Filme;
import com.mycompany.newcinema.model.GestaoDeFilmes;
import com.mycompany.newcinema.model.GestaoDeClientes;
import com.mycompany.newcinema.model.Estoque;
import com.mycompany.newcinema.model.Caixa;
import com.mycompany.newcinema.controller.ControleCinema;
import com.mycompany.newcinema.model.Cliente;
import com.mycompany.newcinema.model.Sala;
import com.mycompany.newcinema.model.Sessao;
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
         
        //Questão 17
        GestaoDeClientes gestaoDeClientes = new GestaoDeClientes();
        Cliente cliente01 = (new Cliente("Lucas", "Martins", "Rua valmira pires", "11223344", "33333333333", LocalDate.of(2001, 3, 3), "Vingadores", "acao", "lucas_login", "lucas_senha"));
        Cliente cliente02 = (new Cliente("Enzo", "Veloso", "Rua valmira pires", "44332211", "44332211", LocalDate.of(2002, 4, 4), "interestellar", "ficcao", "enzo_login", "enzo_senha"));

        //Ordena a lista de clientes por ordem alfabetica
        Collections.sort(gestaoDeClientes.getListaDeClientes(), (c1, c2) -> gestaoDeClientes.compareClientesPorNome(c1, c2));
        // Teste do método find
        System.out.println("Informe qual nome deseja buscar");
        Scanner sc = new Scanner(System.in);
        String busca = sc.nextLine();
        Cliente fazerBusca = gestaoDeClientes.find(busca);
        if (fazerBusca != null)
        {
            System.out.println("Cliente encontrado: " + fazerBusca);
        }
        else
        {
            System.out.println("Cliente não encontrado");
        }

        // Teste do método binarySearch da classe Collections 
        int index = Collections.binarySearch(gestaoDeClientes.getListaDeClientes(), cliente01, (c1, c2) -> gestaoDeClientes.compareClientesPorNome(c1, c2));
        if (index >= 0)
        {
            System.out.println("Cliente encontrado: " + gestaoDeClientes.getListaDeClientes().get(index));
        }
        else
        {
            System.out.println("Cliente não.");
        }

    }
         */
        
        // Criação e configuração da gestão de clientes, filmes, estoque e controle do cinema
        GestaoDeClientes gestaoDeClientes = new GestaoDeClientes();
        GestaoDeFilmes gestaoDeFilmes = new GestaoDeFilmes();
        Estoque estoque = new Estoque();
        ControleCinema controleCinema = new ControleCinema(estoque, gestaoDeFilmes.getFilmes());
        Scanner scanner = new Scanner(System.in);

        // Adiciona alguns clientes para teste
        Cliente cliente1 = new Cliente("Alice", "Silva", "Rua A", "12345678", "11111111111", LocalDate.of(1990, 1, 1), "acao", "drama", "alice_login", "alice_senha");
        Cliente cliente2 = new Cliente("Bruno", "Costa", "Rua B", "87654321", "22222222222", LocalDate.of(1985, 2, 2), "comedia", "acao", "bruno_login", "bruno_senha");
        Cliente cliente3 = new Cliente("Carla", "Moura", "Rua C", "11223344", "33333333333", LocalDate.of(1978, 3, 3), "drama", "comedia", "carla_login", "carla_senha");
        Cliente cliente4 = new Cliente("Daniel", "Santos", "Rua D", "44332211", "44444444444", LocalDate.of(2000, 4, 4), "acao", "ficcao", "daniel_login", "daniel_senha");

        gestaoDeClientes.getListaDeClientes().add(cliente1);
        gestaoDeClientes.getListaDeClientes().add(cliente2);
        gestaoDeClientes.getListaDeClientes().add(cliente3);
        gestaoDeClientes.getListaDeClientes().add(cliente4);

        // Adiciona alguns filmes para teste
        gestaoDeFilmes.cadastraFilme("Titanic", "Acao", Duration.ofMinutes(120));
        gestaoDeFilmes.cadastraFilme("Procurando Nemo", "Animacao", Duration.ofMinutes(90));
        gestaoDeFilmes.cadastraFilme("Avatar", "Ficcao Cientifica", Duration.ofMinutes(150));
        gestaoDeFilmes.cadastraFilme("Matrix", "Ficcao Cientifica", Duration.ofMinutes(136));
        gestaoDeFilmes.cadastraFilme("Interestelar", "Ficcao Cientifica", Duration.ofMinutes(169));
        
        List<Filme> filmes = gestaoDeFilmes.getFilmes();

        Sala sala1 = new Sala(1, filmes.get(0));
        Sala sala2 = new Sala(2, filmes.get(1));
        Sala sala3 = new Sala(3, filmes.get(2));
        Sala sala4 = new Sala(4, filmes.get(3));
        Sala sala5 = new Sala(5, filmes.get(4));
        
        // Cria sessões para os filmes
        Sessao.criarSessao(gestaoDeFilmes.getFilmes().get(0), sala1, LocalDateTime.of(2024, 6, 15, 14, 0));
        Sessao.criarSessao(gestaoDeFilmes.getFilmes().get(1), sala2, LocalDateTime.of(2024, 6, 15, 16, 0));
        Sessao.criarSessao(gestaoDeFilmes.getFilmes().get(2), sala3, LocalDateTime.of(2024, 6, 15, 18, 0));
        Sessao.criarSessao(gestaoDeFilmes.getFilmes().get(3), sala4, LocalDateTime.of(2024, 6, 15, 20, 0));
        Sessao.criarSessao(gestaoDeFilmes.getFilmes().get(4), sala5, LocalDateTime.of(2024, 6, 15, 22, 0));

        // Adiciona alguns produtos ao estoque para teste
        estoque.cadastrarProduto("Pipoca", LocalDate.of(2024, 7, 1), 10.0);
        estoque.cadastrarProduto("Refrigerante", LocalDate.of(2024, 7, 1), 5.0);
        estoque.cadastrarProduto("Chocolate", LocalDate.of(2024, 7, 1), 7.0);

        // Simulação de uma venda
        System.out.println("Bem-vindo ao sistema do Cinema!");
        System.out.print("Informe seu CPF para login: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = gestaoDeClientes.find(cpfCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        Carrinho carrinho = new Carrinho(estoque);

        // Seleção da sessão
        System.out.println("Selecione a sessão que deseja assistir:");
        List<Sessao> sessoes = Sessao.listarSessoes();
        for (int i = 0; i < sessoes.size(); i++) {
            System.out.println((i + 1) + ": " + sessoes.get(i));
        }
        int sessaoEscolhida = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        carrinho.selecionarSessao((List<Sessao>) sessoes.get(sessaoEscolhida - 1));

        // Seleção de poltronas
        System.out.println("Selecione a(s) poltrona(s) (ex: 1 2 3): ");
        String poltronasInput = scanner.nextLine();
        String[] poltronas = poltronasInput.split(" ");
        for (String poltrona : poltronas) {
            carrinho.selecionarPoltronas();
        }

        // Seleção de produtos
        System.out.println("Deseja comprar produtos? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            boolean comprarMais = true;
            while (comprarMais) {
                carrinho.selecionarProdutoEQuant();
                System.out.println("Deseja comprar mais produtos? (s/n)");
                resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("s")) {
                    comprarMais = false;
                }
            }
        }

        // Criação do caixa e efetuação do pagamento
        Caixa caixa = new Caixa(carrinho);
        System.out.println("Valor total da compra: R$ " + caixa.valorTotalCompra());
        System.out.println("Deseja efetuar o pagamento? (s/n)");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            caixa.efetuarPagamento(cliente1);
            System.out.println("Pagamento realizado com sucesso!");
            System.out.println("Extrato da venda: " + caixa.extratoVenda());
        } else {
            System.out.println("Pagamento cancelado com uma taxa de 25%.");
            caixa.cancelarPagamento();
            System.out.println("Valor a ser pago pela taxa: R$ " + caixa.valorTotalCompra());
        }
    }
}
