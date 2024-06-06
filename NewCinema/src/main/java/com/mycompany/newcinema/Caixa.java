/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável pela gestão das operações de caixa do cinema.
 */
public class Caixa
{

    private double valorIngresso;
    private Carrinho carrinho;
    public List<Venda> vendasDiarias;
    private List<Venda> vendasMensais;
    private static final Caixa[] balcoes = new Caixa[5];

    public double getValorIngresso()
    {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso)
    {
        this.valorIngresso = valorIngresso;
    }

    public Carrinho getCarrinho()
    {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho)
    {
        this.carrinho = carrinho;
    }

    public List<Venda> getVendasDiarias()
    {
        return vendasDiarias;
    }

    public void setVendasDiarias(List<Venda> vendasDiarias)
    {
        this.vendasDiarias = vendasDiarias;
    }

    public List<Venda> getVendasMensais()
    {
        return vendasMensais;
    }

    public void setVendasMensais(List<Venda> vendasMensais)
    {
        this.vendasMensais = vendasMensais;
    }

    /**
     * Construtor da classe Caixa.
     *
     * @param carrinho O carrinho associado ao caixa.
     */
    public Caixa(Carrinho carrinho)
    {
        this.carrinho = carrinho;
        this.vendasDiarias = new ArrayList<>();
        this.vendasMensais = new ArrayList<>();
    }

    /**
     * Inicializa os balcões com um estoque compartilhado.
     *
     * @param estoque O estoque compartilhado entre os balcões.
     */
    public static void inicializarBalcoes(Estoque estoque)
    {
        for (int i = 0; i < 5; i++)
        {
            balcoes[i] = new Caixa(new Carrinho(estoque));
        }
    }

    /**
     * Retorna os balcões estáticos.
     *
     * @return Um array de objetos Caixa.
     */
    public static Caixa[] getBalcoes()
    {
        return balcoes;
    }

    /**
     * Informa o valor de cada ingresso.
     *
     * @param valor O valor do ingresso.
     */
    public void informarValorIngresso(double valor)
    {
        this.valorIngresso = valor;
    }

    /**
     * Calcula o valor total dos ingressos no carrinho.
     *
     * @return O valor total dos ingressos.
     */
    public double valorTotalIngressos()
    {
        return valorIngresso * carrinho.getQuantidadeIngressos();
    }

    /**
     * Calcula o valor de um produto específico no carrinho.
     *
     * @param produto O produto cujo valor será calculado.
     * @return O valor do produto.
     */
    public double valorDeCadaProduto(Produto produto)
    {
        return produto.getPreco() * carrinho.getQuantidadeProdutos().get(produto);
    }

    /**
     * Calcula o valor total dos produtos no carrinho.
     *
     * @return O valor total dos produtos.
     */
    public double valorTotalProdutos()
    {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : carrinho.getQuantidadeProdutos().entrySet())
        {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    /**
     * Calcula o valor total da compra (ingressos e produtos).
     *
     * @return O valor total da compra.
     */
    public double valorTotalCompra()
    {
        return valorTotalIngressos() + valorTotalProdutos();
    }

    /**
     * Efetua o pagamento da compra, registrando os espectadores e adicionando a
     * venda às listas diárias e mensais.
     */
    public void efetuarPagamento()
    {
        double totalCompra = valorTotalCompra();
        System.out.println("Pagamento efetuado no valor de: R$" + totalCompra);
        carrinho.getSessao().registrarEspectadores(carrinho.getQuantidadeIngressos());
        vendasDiarias.add(new Venda(LocalDate.now(), totalCompra, valorTotalIngressos(), valorTotalProdutos()));
        vendasMensais.add(new Venda(LocalDate.now(), totalCompra, valorTotalIngressos(), valorTotalProdutos()));
    }

    /**
     * Cancela o pagamento da compra, aplicando uma taxa de cancelamento.
     */
    public void cancelarPagamento()
    {
        double totalCompra = valorTotalCompra();
        double taxaCancelamento = totalCompra * 0.25;
        double valorReembolsado = totalCompra - taxaCancelamento;
        System.out.println("Pagamento cancelado. Valor reembolsado (após taxa de cancelamento de 25%): R$" + valorReembolsado);
    }

    /**
     * Calcula o valor total das vendas diárias.
     *
     * @return O valor total das vendas diárias.
     */
    public double valorTotalVendasDiarias()
    {
        return vendasDiarias.stream().mapToDouble(Venda::getValorTotal).sum();
    }

    /**
     * Calcula o valor total dos ingressos vendidos diariamente.
     *
     * @return O valor total dos ingressos diários.
     */
    public double valorTotalIngressosDiarios()
    {
        return vendasDiarias.stream().mapToDouble(Venda::getValorIngressos).sum();
    }

    /**
     * Calcula o valor total dos produtos vendidos diariamente.
     *
     * @return O valor total dos produtos diários.
     */
    public double valorTotalProdutosDiarios()
    {
        return vendasDiarias.stream().mapToDouble(Venda::getValorProdutos).sum();
    }

    /**
     * Calcula o valor total das vendas mensais.
     *
     * @return O valor total das vendas mensais.
     */
    public double valorTotalVendasMensais()
    {
        return vendasMensais.stream().mapToDouble(Venda::getValorTotal).sum();
    }

    /**
     * Calcula o valor total dos ingressos vendidos mensalmente.
     *
     * @return O valor total dos ingressos mensais.
     */
    public double valorTotalIngressosMensais()
    {
        return vendasMensais.stream().mapToDouble(Venda::getValorIngressos).sum();
    }

    /**
     * Calcula o valor total dos produtos vendidos mensalmente.
     *
     * @return O valor total dos produtos mensais.
     */
    public double valorTotalProdutosMensais()
    {
        return vendasMensais.stream().mapToDouble(Venda::getValorProdutos).sum();
    }

    public String extratoVenda()
    {
        return "Extrato da venda{"
                + ", valorTotalIngressos: " + valorTotalIngressos()
                + ", filme selecionado: " + carrinho.getFilme().getTitulo()
                + ", sessao: " + carrinho.getSessao().getHorarioInicio().format(DateTimeFormatter.ofPattern("HH:mm")) + ", " + carrinho.getSessao().getSalas()
                + ", Poltrona(s) selecionada(s): " + carrinho.getPoltronasSelecionadas()
                + ", valorTotalProdutos: " + valorTotalProdutos()
                + ", Produto selecionado" + (carrinho.getProdutosSelecionados() != null ? carrinho.getProdutosSelecionados() : "Nenhum filme selecionado")
                + ", valorTotalCompra: " + valorTotalCompra()
                + ", Tenho uma'otima experiencia no CineDjamas "
                + '}';
    }

    /**
     * Método ToString sendo sobrescrito. Imprimindo O valor do ingresso, valor
     * total do ingresso, dos produtos e da compra.
     */
    @Override
    public String toString()
    {
        return "Caixa{"
                + "valorIngresso=" + valorIngresso
                + ", valorTotalIngressos: " + valorTotalIngressos()
                + ", valorTotalProdutos: " + valorTotalProdutos()
                + ", valorTotalCompra: " + valorTotalCompra()
                + '}';
    }
}
