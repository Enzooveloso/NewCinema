/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enzov
 */
class Sessao
{

    private Filme filme;
    private Sala salas;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioTermino;
    private int espectadores;
    private static List<Sessao> sessoes = new ArrayList<>();

    public Filme getFilme()
    {
        return filme;
    }

    public void setFilme(Filme filme)
    {
        this.filme = filme;
    }

    public Sala getSalas()
    {
        return salas;
    }

    public void setSalas(Sala salas)
    {
        this.salas = salas;
    }

    public static List<Sessao> getSessoes()
    {
        return sessoes;
    }

    public static void setSessoes(List<Sessao> sessoes)
    {
        Sessao.sessoes = sessoes;
    }

    public int getEspectadores()
    {
        return espectadores;
    }

    public void setEspectadores(int espectadores)
    {
        this.espectadores = espectadores;
    }

    public Sessao(Filme filme, Sala salas, LocalDateTime horarioInicio)
    {
        this.filme = filme;
        this.salas = salas;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = calcularHorarioTermino();
        this.espectadores = 0;
    }

    private LocalDateTime calcularHorarioTermino()
    {
        return horarioInicio.plus(filme.getDuracao());
    }

    public LocalDateTime getHorarioInicio()
    {
        return horarioInicio;
    }

    public LocalDateTime getHorarioTermino()
    {
        return horarioTermino;
    }

    public static void criarSessao(Filme filme, Sala salas, LocalDateTime horarioInicio)
    {
        Sessao sessao = new Sessao(filme, salas, horarioInicio);
        sessoes.add(sessao);
    }

    public static List<Sessao> listarSessoes()
    {
        return sessoes;
    }

    public void registrarEspectadores(int quantidade)
    {
        this.espectadores += quantidade ;
        filme.adicionarEspectadores(quantidade);
    }

    @Override
    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Sessao{"
                + "filme=" + filme.getTitulo()
                + ", sala=" + salas.getNumeroSala()
                + ", horarioInicio=" + horarioInicio.format(formatter)
                + ", horarioTermino=" + horarioTermino.format(formatter)
                + '}';
    }
}
