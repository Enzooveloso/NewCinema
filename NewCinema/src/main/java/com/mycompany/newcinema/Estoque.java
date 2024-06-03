/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A classe Estoque gerencia o inventário de produtos em um cinema, incluindo
 * pipoca, guloseimas e bebidas.
 */
public class Estoque
{

    private List<Produto> produtos;
    private int quantidadePipoca;
    private int quantidadeGuloseimas;
    private int quantidadeBebidas;
    private static int N_INSTANCIAS;
            /**
             * Construtor padrão que inicializa o estoque com listas vazias e
             * contadores zerados.
             */

    public Estoque()
    {
        this.produtos = new ArrayList<>();
        this.quantidadePipoca = 0;
        this.quantidadeGuloseimas = 0;
        this.quantidadeBebidas = 0;
    }

    /**
     * Adiciona um produto ao estoque e atualiza os contadores de quantidade com
     * base no tipo do produto.
     *
     * @param nome
     * @param validade
     * @return
     */
    public Produto cadastrarProduto(String nome, LocalDate validade, double preco)
    {
        Produto novoProduto = new Produto(nome, validade, preco);
        this.produtos.add(novoProduto);
        if (novoProduto.getNome().toLowerCase().contains("pipoca"))
        {
            quantidadePipoca++;
        }
        else if (novoProduto.getNome().toLowerCase().contains("guloseima"))
        {
            quantidadeGuloseimas++;
        }
        else if (novoProduto.getNome().toLowerCase().contains("bebida"))
        {
            quantidadeBebidas++;
        }
        return novoProduto;
    }

    /**
     * Remove um produto do estoque pelo nome e atualiza os contadores de
     * quantidade com base no tipo do produto.
     *
     * @param nome O nome do produto a ser removido.
     */
    public void removerProduto(String nome)
    {
        Iterator<Produto> iterator = produtos.iterator();// Cria um iterator p percorrer a lista de produtos
        while (iterator.hasNext()) // continua a percorrer enquanto houver mais um elemnto na lista
        {
            Produto produto = iterator.next(); // chega ao proximo produto da lista
            
            if (produto.getNome().equalsIgnoreCase(nome))
            {
                iterator.remove();
                if (produto.getNome().toLowerCase().contains("pipoca"))
                {
                    quantidadePipoca--;
                }
                else if (produto.getNome().toLowerCase().contains("guloseima"))
                {
                    quantidadeGuloseimas--;
                }
                else if (produto.getNome().toLowerCase().contains("bebida"))
                {
                    quantidadeBebidas--;
                }
            }
        }
    }

    /**
     * Retorna uma lista de todos os produtos disponíveis no estoque.
     *
     * @return Uma lista de produtos.
     */
    public List<Produto> listarProdutosDisponiveis()
    {
        return new ArrayList<>(produtos);
    }

    /**
     * Verifica a validade dos produtos no estoque, avisa sobre quantos dias
     * faltam para o produto vencer e remove os produtos que estão fora da
     * validade.
     */
    public void verificarValidade()
    {
        LocalDate hoje = LocalDate.now();
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext())
        {
            Produto produto = iterator.next();
            LocalDate validade = produto.getValidade();
            if (validade.isBefore(hoje))
            {
                System.out.println("Produto vencido: " + produto.getNome() + " - Removendo do estoque.");
                iterator.remove();
                if (produto.getNome().toLowerCase().contains("pipoca"))
                {
                    quantidadePipoca--;
                }
                else if (produto.getNome().toLowerCase().contains("guloseima"))
                {
                    quantidadeGuloseimas--;
                }
                else if (produto.getNome().toLowerCase().contains("bebida"))
                {
                    quantidadeBebidas--;
                }
            }
            else
            {
                long diasParaVencer = ChronoUnit.DAYS.between(hoje, validade);
                System.out.println("Produto: " + produto.getNome() + " - Dias para vencer: " + diasParaVencer);
            }
        }
    }

    @Override
    public String toString()
    {
        return "Estoque{"
                + "produtos=" + produtos
                + ", quantidadePipoca=" + quantidadePipoca
                + ", quantidadeGuloseimas=" + quantidadeGuloseimas
                + ", quantidadeBebidas=" + quantidadeBebidas
                + '}';
    }
}
