/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema.model;

import java.time.LocalDate;
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

    public List<Produto> getProdutos()
    {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos)
    {
        this.produtos = produtos;
    }

    public int getQuantidadePipoca()
    {
        return quantidadePipoca;
    }

    public void setQuantidadePipoca(int quantidadePipoca)
    {
        this.quantidadePipoca = quantidadePipoca;
    }

    public int getQuantidadeGuloseimas()
    {
        return quantidadeGuloseimas;
    }

    public void setQuantidadeGuloseimas(int quantidadeGuloseimas)
    {
        this.quantidadeGuloseimas = quantidadeGuloseimas;
    }

    public int getQuantidadeBebidas()
    {
        return quantidadeBebidas;
    }

    public void setQuantidadeBebidas(int quantidadeBebidas)
    {
        this.quantidadeBebidas = quantidadeBebidas;
    }
    
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
     * @param preco
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
        Produto.setN_INSTANCIAS(+1);
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
    /**
     * Verifica a validade dos produtos no estoque e remove os que estão vencidos.
     */
    public void verificarValidade() {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getValidade().isBefore(LocalDate.now())) {
                iterator.remove();
                System.out.println("Produto removido por validade vencida: " + produto.getNome());
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
