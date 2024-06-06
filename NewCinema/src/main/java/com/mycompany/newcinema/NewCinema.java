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

/**
 *
 * @author enzov
 */
public class NewCinema
{
    public static void main(String[] args) throws IOException
    {
        
        GestaoDeFilmes gestaoDeFilmes = new GestaoDeFilmes();

        gestaoDeFilmes.cadastraFilme("Titanic", "Acao", Duration.ofMinutes(120));
        gestaoDeFilmes.cadastraFilme("Procurando Nemo", "Animacao", Duration.ofMinutes(90));
        gestaoDeFilmes.cadastraFilme("Avatar", "Ficcao Cientifica", Duration.ofMinutes(150));
        gestaoDeFilmes.cadastraFilme("Matrix", "Ficcao Cientifica", Duration.ofMinutes(136));
        gestaoDeFilmes.cadastraFilme("Interestelar", "Ficcao Cientifica", Duration.ofMinutes(169));

        // Acessa os filmes pela posição na lista
        List<Filme> filmes = gestaoDeFilmes.getFilmes();

        // Criar 5 salas
        Sala sala1 = new Sala(1, filmes.get(0));
        Sala sala2 = new Sala(2, filmes.get(1));
        Sala sala3 = new Sala(3, filmes.get(2));
        Sala sala4 = new Sala(4, filmes.get(3));
        Sala sala5 = new Sala(5, filmes.get(4));

        /*
        // Listar todas as salas
        for (Sala sala : Sala.listarSalas())
        {
            System.out.println(sala);
        }*/

        // Cria sessões para os filmes
        Sessao.criarSessao(filmes.get(0), sala1, LocalDateTime.of(2024, 5, 20, 14, 0));
        Sessao.criarSessao(filmes.get(0), sala1, LocalDateTime.of(2024, 5, 20, 17, 0));
        Sessao.criarSessao(filmes.get(0), sala1, LocalDateTime.of(2024, 5, 20, 21, 0));
        Sessao.criarSessao(filmes.get(1), sala2, LocalDateTime.of(2024, 5, 20, 13, 0));
        Sessao.criarSessao(filmes.get(1), sala2, LocalDateTime.of(2024, 5, 20, 16, 0));
        Sessao.criarSessao(filmes.get(2), sala3, LocalDateTime.of(2024, 5, 20, 16, 0));
        Sessao.criarSessao(filmes.get(3), sala4, LocalDateTime.of(2024, 5, 20, 17, 0));
        Sessao.criarSessao(filmes.get(4), sala5, LocalDateTime.of(2024, 5, 20, 18, 0));
        

        // Lista todas as sessões
        /*
        for (Sessao sessao : Sessao.listarSessoes())
        {
            System.out.println(sessao);
        }
        */
        
        Estoque estoque = new Estoque();
        estoque.cadastrarProduto("Pipoca Doce", LocalDate.of(2024, 12, 31),10);
        estoque.cadastrarProduto("Guloseima Chocolate", LocalDate.of(2024, 10, 31),6);
        estoque.cadastrarProduto("Bebida Cola", LocalDate.of(2024, 11, 30),8);

        // Listar produtos disponíveis
        /*
        System.out.println("Produtos disponíveis:");
        for (Produto produto : estoque.listarProdutosDisponiveis())
        {
            System.out.println(produto);
        }
        */
        
        // Verificar validade dos produtos e avisar
        /*
        System.out.println("\nVerificando validade:");
        estoque.verificarValidade();
        */
        
        // Listar produtos disponíveis após verificar validade
        /*
        System.out.println("\nProdutos disponíveis após verificar validade:");
        for (Produto produto : estoque.listarProdutosDisponiveis())
        {
            System.out.println(produto);
        }
        */
        Carrinho carrinho = new Carrinho(estoque);
        carrinho.selecionarSessao(Sessao.listarSessoes());
        carrinho.selecionarPoltronas();
        carrinho.selecionarProdutoEQuant();
        

        System.out.println("\nDetalhes do Carrinho:");
        System.out.println(carrinho);
        
        Caixa caixa = new Caixa(carrinho);
        //caixa.informarValorIngresso(); 

        System.out.println("\nDetalhes do Caixa:");
        System.out.println(caixa);

        caixa.efetuarPagamento();
        
        List<Produto> produtos = new ArrayList<>();
        // Ordena a lista de produtos pelo nome
        Collections.sort(produtos, ComparacoesProduto.comparaNomes());
        
         // Ordena a lista de Filmes pelo nome
        Collections.sort(filmes, ComparacoesFilme.comparaNomes());
        
        
        Repositorys.SalvarFilmes(filmes);
        Repositorys.SalvarProdutos(produtos);
        
    }
}
