package com.mycompany.newcinema.controller;

import com.mycompany.newcinema.model.Caixa;
import com.mycompany.newcinema.model.Estoque;
import com.mycompany.newcinema.model.Filme;
import com.mycompany.newcinema.model.Venda;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe responsável pelo controle das operações do cinema.
 * Essa classe gerencia o estoque, os filmes e gera relatórios de vendas e audiência.
 */
public class ControleCinema {

    private Estoque estoque; // Estoque do cinema
    private List<Filme> filmes; // Lista de filmes exibidos no cinema

    // Getters e Setters

    /**
     * Retorna o estoque do cinema.
     *
     * @return o estoque
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * Define o estoque do cinema.
     *
     * @param estoque o novo estoque
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    /**
     * Retorna a lista de filmes exibidos no cinema.
     *
     * @return a lista de filmes
     */
    public List<Filme> getFilmes() {
        return filmes;
    }

    /**
     * Define a lista de filmes exibidos no cinema.
     *
     * @param filmes a nova lista de filmes
     */
    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    // Construtores

    /**
     * Construtor da classe ControleCinema.
     *
     * @param estoque o estoque do cinema
     * @param filmes a lista de filmes exibidos no cinema
     */
    public ControleCinema(Estoque estoque, List<Filme> filmes) {
        this.estoque = estoque;
        this.filmes = filmes;
    }

    // Métodos

    /**
     * Gera o balanço mensal de todas as vendas.
     */
    public void balancoMensal() {
        double totalVendas = 0;
        for (Caixa caixa : Caixa.getBalcoes()) {
            totalVendas += caixa.valorTotalVendasMensais();
        }
        System.out.println("Balanço mensal total: R$" + totalVendas);
    }

    /**
     * Gera o relatório diário de vendas de um caixa específico.
     *
     * @param caixaId o identificador do caixa
     */
    public void relatorioDiarioCaixa(int caixaId) {
        if (caixaId >= 0 && caixaId < Caixa.getBalcoes().length) {
            Caixa caixa = Caixa.getBalcoes()[caixaId];
            System.out.println("Relatório diário do caixa:");
            for (Venda venda : caixa.getVendasDiarias()) {
                System.out.println(venda);
            }
            System.out.println("Valor total de vendas diárias: R$" + caixa.valorTotalVendasDiarias());
            System.out.println("Valor total de vendas de ingressos diárias: R$" + caixa.valorTotalIngressosDiarios());
            System.out.println("Valor total de vendas de produtos diárias: R$" + caixa.valorTotalProdutosDiarios());
        } else {
            System.out.println("Caixa inválido.");
        }
    }

    /**
     * Gera o relatório mensal de vendas de um caixa específico.
     *
     * @param caixaId o identificador do caixa
     */
    public void relatorioMensalCaixa(int caixaId) {
        if (caixaId >= 0 && caixaId < Caixa.getBalcoes().length) {
            Caixa caixa = Caixa.getBalcoes()[caixaId];
            System.out.println("Relatório mensal do caixa:");
            for (Venda venda : caixa.getVendasMensais()) {
                System.out.println(venda);
            }
            System.out.println("Valor total de vendas mensais: R$" + caixa.valorTotalVendasMensais());
            System.out.println("Valor total de vendas de ingressos mensais: R$" + caixa.valorTotalIngressosMensais());
            System.out.println("Valor total de vendas de produtos mensais: R$" + caixa.valorTotalProdutosMensais());
        } else {
            System.out.println("Caixa inválido.");
        }
    }

    /**
     * Exibe o controle de estoque, listando todos os produtos disponíveis.
     */
    public void controleEstoque() {
        System.out.println("Controle de estoque:");
        estoque.listarProdutosDisponiveis().forEach(System.out::println);
    }

    /**
     * Verifica a validade dos produtos no estoque.
     */
    public void controleValidade() {
        System.out.println("Controle de validade:");
        estoque.verificarValidade();
    }

    /**
     * Gera o relatório dos filmes mais assistidos, ordenados por total de espectadores.
     */
    public void relatorioFilmesMaisAssistidos() {
        List<Filme> filmesMaisAssistidos = filmes.stream()
                .sorted(Comparator.comparingInt(Filme::getTotalEspectadores).reversed())// ordenacao utilizando comparator, de numeros inteiros, no total espectadores, o filme e o total de espectadores
                .collect(Collectors.toList());

        System.out.println("Relatório de filmes mais assistidos:");
        for (Filme filme : filmesMaisAssistidos) {
            System.out.println(filme);
        }
    }

    /**
     * Gera o relatório dos gêneros mais assistidos, com base no total de espectadores.
     */
    public void relatorioGenerosMaisAssistidos() {
        Map<String, Integer> generoEspectadores = new HashMap<>();
        for (Filme filme : filmes) {
            generoEspectadores.merge(filme.getGenero(), filme.getTotalEspectadores(), Integer::sum);
        }

        List<Map.Entry<String, Integer>> generosMaisAssistidos = generoEspectadores.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed()) // ordenacao utilizando comparator, de numeros inteiros, no HashMap entre  o genero e o total de espectadores
                .collect(Collectors.toList()); // cria uma nova lista ja ordenada

        System.out.println("Relatório de gêneros mais assistidos:");
        for (Map.Entry<String, Integer> entry : generosMaisAssistidos) {
            System.out.println("Gênero: " + entry.getKey() + ", Total de Espectadores: " + entry.getValue());
        }
    }
}
