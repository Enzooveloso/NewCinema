/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enzov
 */
public class Sala
{

    private int numeroSala;
    private static final int NUMERO_ASSENTOS = 64;
    private Filme filme;

    private static List<Sala> salas = new ArrayList<>();

    public int getNumeroSala()
    {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala)
    {
        this.numeroSala = numeroSala;
    }

    public Filme getFilme()
    {
        return filme;
    }

    public void setFilme(Filme filme)
    {
        this.filme = filme;
    }

    public Sala(int numeroSala, Filme filme)
    {
        this.numeroSala = numeroSala;
        this.filme = filme;
        if (salas.size() < 5)
        {
            salas.add(this);
        }
    }

    public static List<Sala> listarSalas()
    {
        return salas;
    }

    // Sobrescrever o método toString()
    @Override
    public String toString()
    {
        return "Sala{"
                + "numeroSala=" + numeroSala
                + ", numero assetnos =" + NUMERO_ASSENTOS
                + ", filme=" + (filme != null ? filme.getTitulo() : "Nenhum filme em exibição")
                + '}';
    }
}
