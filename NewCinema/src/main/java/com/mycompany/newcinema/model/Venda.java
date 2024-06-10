package com.mycompany.newcinema.model;

import java.time.LocalDate;

/**
 * Classe responsável por representar uma venda no sistema de cinema.
 * Contém informações como data da venda, valor total, valor dos ingressos, valor dos produtos e extrato.
 * @autor enzov
 */
public class Venda {

    private LocalDate data;
    private double valorTotal; 
    private double valorIngressos;
    private double valorProdutos;
    private String extrato; 
    // Construtores

    /**
     * Construtor da classe Venda.
     *
     * @param data a data da venda
     * @param valorTotal o valor total da venda
     * @param valorIngressos o valor total dos ingressos na venda
     * @param valorProdutos o valor total dos produtos na venda
     */
    public Venda(LocalDate data, double valorTotal, double valorIngressos, double valorProdutos) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.valorIngressos = valorIngressos;
        this.valorProdutos = valorProdutos;
    }


    /**
     * Retorna a data da venda.
     *
     * @return a data da venda
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Define a data da venda.
     *
     * @param data a nova data da venda
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Retorna o valor total da venda.
     *
     * @return o valor total da venda
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor total da venda.
     *
     * @param valorTotal o novo valor total da venda
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Retorna o valor total dos ingressos na venda.
     *
     * @return o valor total dos ingressos
     */
    public double getValorIngressos() {
        return valorIngressos;
    }

    /**
     * Define o valor total dos ingressos na venda.
     *
     * @param valorIngressos o novo valor total dos ingressos
     */
    public void setValorIngressos(double valorIngressos) {
        this.valorIngressos = valorIngressos;
    }

    /**
     * Retorna o valor total dos produtos na venda.
     *
     * @return o valor total dos produtos
     */
    public double getValorProdutos() {
        return valorProdutos;
    }

    /**
     * Define o valor total dos produtos na venda.
     *
     * @param valorProdutos o novo valor total dos produtos
     */
    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    /**
     * Retorna o extrato da venda.
     *
     * @return o extrato da venda
     */
    public String getExtrato() {
        return extrato;
    }

    /**
     * Define o extrato da venda.
     *
     * @param extrato o novo extrato da venda
     */
    public void setExtrato(String extrato) {
        this.extrato = extrato;
    }

    /**
     * Retorna uma representação em string do objeto Venda.
     *
     * @return uma string representando a venda
     */
    @Override
    public String toString() {
        return "Venda{" +
                "data=" + data +
                ", valorTotal=" + valorTotal +
                ", valorIngressos=" + valorIngressos +
                ", valorProdutos=" + valorProdutos +
                ", extrato='" + extrato + '\'' +
                '}';
    }
}
