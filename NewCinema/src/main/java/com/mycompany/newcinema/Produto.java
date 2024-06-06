/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 *
 * @author enzov
 */
public class Produto implements Comparator<Produto>
{

    private String nome;
    private LocalDate validade;
    private double preco;
    private static int N_INSTANCIAS = 0;

    public static int getN_INSTANCIAS()
    {
        return N_INSTANCIAS;
    }

    public static void setN_INSTANCIAS(int N_INSTANCIAS)
    {
        Produto.N_INSTANCIAS = N_INSTANCIAS;
    }

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
        this.N_INSTANCIAS++;
    }

    /**
     * Compara dois objetos Produto pela Nome.
     *
     * @param p1 o primeiro produto a ser comparado.
     * @param p2 o segundo produto a ser comparado.
     * @return um valor negativo se p1 for primeiro que p2, zero se ambos
     * tiverem na mesma posicao alfabetica, um valor positivo se p1 depois que
     * p2 na ordem alfabetica
     */
    @Override
    public int compare(Produto p1, Produto p2)
    {
        return p1.getNome().compareTo(p2.getNome());
    }

    /**
     * Compara dois objetos Produto pela data de validade.
     *
     * @param p1 o primeiro produto a ser comparado.
     * @param p2 o segundo produto a ser comparado.
     * @return um valor negativo se p1 tiver uma validade anterior a p2, zero se
     * ambos tiverem a mesma validade, um valor positivo se p1 tiver uma
     * validade posterior a p2.
     */
    public int compareValidade(Produto p1, Produto p2)
    {
        return p1.getValidade().compareTo(p2.getValidade());
    }

    /**
     * Compara dois objetos Produto pela Nome.
     *
     * @param p1 o primeiro produto a ser comparado.
     * @param p2 o segundo produto a ser comparado.
     * @return um valor negativo se p1 for mais barato p2, zero se ambos tiverem
     * o mesmo preco, um valor positivo se p1 for mais caro que p2.
     */
    public int comparePreco(Produto p1, Produto p2)
    {
        return Double.compare(p1.getPreco(), p2.getPreco());
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
