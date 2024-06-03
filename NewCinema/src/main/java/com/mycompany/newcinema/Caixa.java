/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author enzov
 */
public class Caixa
{

    private double valorIngresso;
    private Carrinho carrinho;
    private List<Venda> vendasDiarias;
    private List<Venda> vendasMensais;

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

    public Caixa(Carrinho carrinho) {
        this.carrinho = carrinho;
        this.vendasDiarias = new ArrayList<>();
        this.vendasMensais = new ArrayList<>();
    }


    public void informarValorIngresso()
    {
        this.valorIngresso = 10;
    }

    public double valorTotalIngressos() {
        return valorIngresso * carrinho.getQuantidadeIngressos();
    }

    public double valorDeCadaProduto(Produto produto) {
        return produto.getPreco() * carrinho.getQuantidadeProdutos().get(produto);
    }

    public double valorTotalProdutos() {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : carrinho.getQuantidadeProdutos().entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    public double valorTotalCompra() {
        return valorTotalIngressos() + valorTotalProdutos();
    }

    public void efetuarPagamento() {
        double totalCompra = valorTotalCompra();
        System.out.println("Pagamento efetuado no valor de: R$" + totalCompra);
        carrinho.getSessao().registrarEspectadores(carrinho.getQuantidadeIngressos());
        vendasDiarias.add(new Venda(LocalDate.now(), totalCompra, valorTotalIngressos(), valorTotalProdutos()));
        vendasMensais.add(new Venda(LocalDate.now(), totalCompra, valorTotalIngressos(), valorTotalProdutos()));
    }

    public void cancelarPagamento() {
        double totalCompra = valorTotalCompra();
        double taxaCancelamento = totalCompra * 0.25;
        double valorReembolsado = totalCompra - taxaCancelamento;
        System.out.println("Pagamento cancelado. Valor reembolsado (após taxa de cancelamento de 25%): R$" + valorReembolsado);
    }

    public double valorTotalVendasDiarias() {
        return vendasDiarias.stream().mapToDouble(Venda::getValorTotal).sum();
    }

    public double valorTotalIngressosDiarios() {
        return vendasDiarias.stream().mapToDouble(Venda::getValorIngressos).sum();
    }

    public double valorTotalProdutosDiarios() {
        return vendasDiarias.stream().mapToDouble(Venda::getValorProdutos).sum();
    }

    public double valorTotalVendasMensais() {
        return vendasMensais.stream().mapToDouble(Venda::getValorTotal).sum();
    }

    public double valorTotalIngressosMensais() {
        return vendasMensais.stream().mapToDouble(Venda::getValorIngressos).sum();
    }

    public double valorTotalProdutosMensais() {
        return vendasMensais.stream().mapToDouble(Venda::getValorProdutos).sum();
    }

    public void relatorioDiario() {
        System.out.println("Relatório diário do caixa:");
        for (Venda venda : vendasDiarias) {
            System.out.println(venda);
        }
        System.out.println("Valor total de vendas diárias: R$" + valorTotalVendasDiarias());
        System.out.println("Valor total de vendas de ingressos diárias: R$" + valorTotalIngressosDiarios());
        System.out.println("Valor total de vendas de produtos diárias: R$" + valorTotalProdutosDiarios());
    }

    public void relatorioMensal() {
        System.out.println("Relatório mensal do caixa:");
        for (Venda venda : vendasMensais) {
            System.out.println(venda);
        }
        System.out.println("Valor total de vendas mensais: R$" + valorTotalVendasMensais());
        System.out.println("Valor total de vendas de ingressos mensais: R$" + valorTotalIngressosMensais());
        System.out.println("Valor total de vendas de produtos mensais: R$" + valorTotalProdutosMensais());
    }

    @Override
    public String toString() {
        return "Caixa{" +
                "valorIngresso=" + valorIngresso +
                ", valorTotalIngressos=" + valorTotalIngressos() +
                ", valorTotalProdutos=" + valorTotalProdutos() +
                ", valorTotalCompra=" + valorTotalCompra() +
                '}';
    }
}
