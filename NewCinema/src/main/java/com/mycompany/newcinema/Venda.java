/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;

/**
 *
 * @author enzov
 */
public class Venda
{
    private LocalDate data;
    private double valorTotal;
    private double valorIngressos;
    private double valorProdutos;
    private String extrato;
    

     public Venda(LocalDate data, double valorTotal, double valorIngressos, double valorProdutos) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.valorIngressos = valorIngressos;
        this.valorProdutos = valorProdutos;
    }

    public LocalDate getData()
    {
        return data;
    }

    public void setData(LocalDate data)
    {
        this.data = data;
    }

    public double getValorTotal()
    {
        return valorTotal;
    }

    public void setValorTotal(double valor)
    {
        this.valorTotal = valor;
    }

    public double getValorIngressos()
    {
        return valorIngressos;
    }

    public void setValorIngressos(double valorIngressos)
    {
        this.valorIngressos = valorIngressos;
    }

    public double getValorProdutos()
    {
        return valorProdutos;
    }

    public void setValorProdutos(double valorProdutos)
    {
        this.valorProdutos = valorProdutos;
    }

    public String getExtrato()
    {
        return extrato;
    }

    public void setExtrato(String extrato)
    {
        this.extrato = extrato;
    }

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
