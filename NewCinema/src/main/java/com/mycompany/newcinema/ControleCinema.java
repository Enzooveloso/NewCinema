/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.util.*;
import java.util.stream.Collectors;

public class ControleCinema
{

    private Estoque estoque;
    private List<Filme> filmes;

    public Estoque getEstoque()
    {
        return estoque;
    }

    public void setEstoque(Estoque estoque)
    {
        this.estoque = estoque;
    }

    public List<Filme> getFilmes()
    {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes)
    {
        this.filmes = filmes;
    }

    public ControleCinema(Estoque estoque, List<Filme> filmes)
    {
        this.estoque = estoque;
        this.filmes = filmes;
    }

    public void balancoMensal()
    {
        double totalVendas = 0;
        for (Caixa caixa : Caixa.getBalcoes())
        {
            totalVendas += caixa.valorTotalVendasMensais();
        }
        System.out.println("Balanço mensal total: R$" + totalVendas);
    }

    public void relatorioDiarioCaixa(int caixaId)
    {
        if (caixaId >= 0 && caixaId < Caixa.getBalcoes().length)
        {
            Caixa caixa = Caixa.getBalcoes()[caixaId];
            System.out.println("Relatório diário do caixa:");
            for (Venda venda : caixa.getVendasDiarias())
            {
                System.out.println(venda);
            }
            System.out.println("Valor total de vendas diárias: R$" + caixa.valorTotalVendasDiarias());
            System.out.println("Valor total de vendas de ingressos diárias: R$" + caixa.valorTotalIngressosDiarios());
            System.out.println("Valor total de vendas de produtos diárias: R$" + caixa.valorTotalProdutosDiarios());
        }
        else
        {
            System.out.println("Caixa inválido.");
        }
    }

    public void relatorioMensalCaixa(int caixaId)
    {
        if (caixaId >= 0 && caixaId < Caixa.getBalcoes().length)
        {
            Caixa caixa = Caixa.getBalcoes()[caixaId];
            System.out.println("Relatório mensal do caixa:");
            for (Venda venda : caixa.getVendasMensais())
            {
                System.out.println(venda);
            }
            System.out.println("Valor total de vendas mensais: R$" + caixa.valorTotalVendasMensais());
            System.out.println("Valor total de vendas de ingressos mensais: R$" + caixa.valorTotalIngressosMensais());
            System.out.println("Valor total de vendas de ingressos mensais: R$" + caixa.valorTotalIngressosMensais());
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

    public void controleValidade()
    {
        System.out.println("Controle de validade:");
        estoque.verificarValidade();
    }

    public void relatorioFilmesMaisAssistidos()
    {
        List<Filme> filmesMaisAssistidos = filmes.stream()
                .sorted(Comparator.comparingInt(Filme::getTotalEspectadores).reversed())
                .collect(Collectors.toList());

        System.out.println("Relatório de filmes mais assistidos:");
        for (Filme filme : filmesMaisAssistidos)
        {
            System.out.println(filme);
        }
    }

    public void relatorioGenerosMaisAssistidos()
    {
        Map<String, Integer> generoEspectadores = new HashMap<>();
        for (Filme filme : filmes)
        {
            generoEspectadores.merge(filme.getGenero(), filme.getTotalEspectadores(), Integer::sum);
        }

        List<Map.Entry<String, Integer>> generosMaisAssistidos = generoEspectadores.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed())
                .collect(Collectors.toList());

        System.out.println("Relatório de gêneros mais assistidos:");
        for (Map.Entry<String, Integer> entry : generosMaisAssistidos)
        {
            System.out.println("Gênero: " + entry.getKey() + ", Total de Espectadores: " + entry.getValue());
        }
    }
}
