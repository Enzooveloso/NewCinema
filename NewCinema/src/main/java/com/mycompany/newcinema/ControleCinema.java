/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author enzov
 */
public class ControleCinema
{

    private List<Caixa> caixas;
    private Estoque estoque;
    private List<Filme> filmes;

    public ControleCinema(List<Caixa> caixas, Estoque estoque, List<Filme> filmes)
    {
        this.caixas = caixas;
        this.estoque = estoque;
        this.filmes = filmes;
    }

    public void balancoMensal()
    {
        double totalVendas = 0;
        for (Caixa caixa : caixas)
        {
            totalVendas += caixa.valorTotalVendasMensais();
        }
        System.out.println("Balanço mensal total: R$" + totalVendas);
    }

    public void relatorioDiarioCaixa(int caixaId)
    {
        if (caixaId >= 0 && caixaId < caixas.size())
        {
            Caixa caixa = caixas.get(caixaId);
            caixa.relatorioDiario();
        }
        else
        {
            System.out.println("Caixa inválido.");
        }
    }

    public void relatorioMensalCaixa(int caixaId)
    {
        if (caixaId >= 0 && caixaId < caixas.size())
        {
            Caixa caixa = caixas.get(caixaId);
            caixa.relatorioMensal();
        }
        else
        {
            System.out.println("Caixa inválido.");
        }
    }

    public void controleEstoque()
    {
        System.out.println("Controle de estoque:");
        estoque.listarProdutosDisponiveis().forEach(System.out::println);
    }

    // método na classe estoque
    /*
    public void controleValidade() {
        System.out.println("Controle de validade:");
        estoque.verificarValidade();
    }
     */
    public void relatorioFilmesMaisAssistidos()
    {
        List<Filme> filmesMaisAssistidos = filmes.stream()
                .sorted(Comparator.comparingInt(Filme::getTotalEspectadores).reversed()) // Ordena os filmes em ordem decrescente pelo número total de espectadores
                .collect(Collectors.toList()); // Coleta os filmes ordenados em uma nova lista.

        System.out.println("Relatório de filmes mais assistidos:");
        for (Filme filme : filmesMaisAssistidos)
        {
            System.out.println(filme);
        }
    }

    public void relatorioGenerosMaisAssistidos()
    {   //Construindo um mapa
        // para cada filme, o mapa atualiza p o total de espectadores daquele genero  
        Map<String, Integer> generoEspectadores = new HashMap<>(); // associa cada genero ao total de espectadores
        for (Filme filme : filmes)
        {                   // merge combina a chave genero com o valor totalEspextadores
            generoEspectadores.merge(filme.getGenero(), filme.getTotalEspectadores(), Integer::sum); //adiciona o número total de espectadores ao gênero correspondente.  
        }

        List<Map.Entry<String, Integer>> generosMaisAssistidos = generoEspectadores.entrySet().stream() //Converte o conjunto de entradas do mapa em um fluxo de dados.
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed()) // Ordena os gêneros em ordem decrescente pelo número total de espectadores.
                .collect(Collectors.toList()); // Coleta os gêneros ordenados em uma nova lista.

        System.out.println("Relatório de gêneros mais assistidos:");
        for (Map.Entry<String, Integer> rankingGeneros : generosMaisAssistidos)
        {
            System.out.println("Gênero: " + rankingGeneros.getKey() + ", Total de Espectadores: " + rankingGeneros.getValue());
        }
    }
}
