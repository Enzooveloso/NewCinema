/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author enzov
 */
public class Produto
{

    private String nome;
    private LocalDate validade;
    private double preco;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public LocalDate getValidade()
    {
        return validade;
    }

    public void setValidade(LocalDate validade)
    {
        this.validade = validade;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public Produto(String nome, LocalDate validade, double preco)
    {
        this.nome = nome;
        this.validade = validade;
        this.preco = preco;
    }

    @Override
    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        return "Produto{"
                + "nome='" + nome + '\''
                + ", validade=" + validade.format(formatter)
                + ", preco: " + preco
                + +'}';
    }
}
