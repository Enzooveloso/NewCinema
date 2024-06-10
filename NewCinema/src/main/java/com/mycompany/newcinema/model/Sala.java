package com.mycompany.newcinema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por representar uma sala de cinema. Contém informações
 * como número da sala, número de assentos e o filme em exibição.
 *
 * @autor enzov
 */
public class Sala
{

    private int numeroSala;
    private static final int NUMERO_ASSENTOS = 64;
    private Filme filme;

    private static List<Sala> salas = new ArrayList<>(); // Lista estática de todas as salas

    /**
     * Retorna o número da sala.
     *
     * @return o número da sala
     */
    public int getNumeroSala()
    {
        return numeroSala;
    }

    /**
     * Define o número da sala.
     *
     * @param numeroSala o novo número da sala
     */
    public void setNumeroSala(int numeroSala)
    {
        this.numeroSala = numeroSala;
    }

    /**
     * Retorna o filme em exibição na sala.
     *
     * @return o filme em exibição
     */
    public Filme getFilme()
    {
        return filme;
    }

    /**
     * Define o filme em exibição na sala.
     *
     * @param filme o novo filme em exibição
     */
    public void setFilme(Filme filme)
    {
        this.filme = filme;
    }

    /**
     * Construtor da classe Sala.
     *
     * @param numeroSala o número da sala
     * @param filme o filme em exibição na sala
     */
    public Sala(int numeroSala, Filme filme)
    {
        this.numeroSala = numeroSala;
        this.filme = filme;
        if (salas.size() < 5)
        {
            salas.add(this);
        }
    }

    /**
     * Retorna a lista de todas as salas.
     *
     * @return a lista de salas
     */
    public static List<Sala> listarSalas()
    {
        return salas;
    }

    /**
     * Retorna uma representação em string do objeto Sala.
     *
     * @return uma string representando a sala
     */
    @Override
    public String toString()
    {
        return "Sala{"
                + "numeroSala=" + numeroSala
                + ", numero assentos=" + NUMERO_ASSENTOS
                + ", filme=" + (filme != null ? filme.getTitulo() : "Nenhum filme em exibição")
                + '}';
    }
}
