package com.mycompany.newcinema.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por representar uma sessão de cinema.
 * Contém informações como filme, sala, horário de início, horário de término e espectadores.
 * @autor enzov
 */
public class Sessao {

    private Filme filme; 
    private Sala salas; 
    private LocalDateTime horarioInicio; 
    private LocalDateTime horarioTermino; 
    private int espectadores; 
    private static List<Sessao> sessoes = new ArrayList<>(); // Lista estática de todas as sessões

    /**
     * Retorna o filme em exibição na sessão.
     *
     * @return o filme em exibição
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Define o filme em exibição na sessão.
     *
     * @param filme o novo filme em exibição
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * Retorna a sala onde a sessão está sendo exibida.
     *
     * @return a sala da sessão
     */
    public Sala getSalas() {
        return salas;
    }

    /**
     * Define a sala onde a sessão está sendo exibida.
     *
     * @param salas a nova sala da sessão
     */
    public void setSalas(Sala salas) {
        this.salas = salas;
    }

    /**
     * Retorna a lista de todas as sessões.
     *
     * @return a lista de sessões
     */
    public static List<Sessao> getSessoes() {
        return sessoes;
    }

    /**
     * Define a lista de todas as sessões.
     *
     * @param sessoes a nova lista de sessões
     */
    public static void setSessoes(List<Sessao> sessoes) {
        Sessao.sessoes = sessoes;
    }

    /**
     * Retorna o número de espectadores na sessão.
     *
     * @return o número de espectadores
     */
    public int getEspectadores() {
        return espectadores;
    }

    /**
     * Define o número de espectadores na sessão.
     *
     * @param espectadores o novo número de espectadores
     */
    public void setEspectadores(int espectadores) {
        this.espectadores = espectadores;
    }

    /**
     * Retorna o horário de início da sessão.
     *
     * @return o horário de início da sessão
     */
    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * Retorna o horário de término da sessão.
     *
     * @return o horário de término da sessão
     */
    public LocalDateTime getHorarioTermino() {
        return horarioTermino;
    }

    /**
     * Construtor padrão da classe Sessao.
     */
    public Sessao() {
    }

    /**
     * Construtor da classe Sessao com parâmetros.
     *
     * @param filme o filme em exibição na sessão
     * @param salas a sala onde a sessão está sendo exibida
     * @param horarioInicio o horário de início da sessão
     */
    public Sessao(Filme filme, Sala salas, LocalDateTime horarioInicio) {
        this.filme = filme;
        this.salas = salas;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = calcularHorarioTermino();
        this.espectadores = 0;
    }

 
    /**
     * Calcula o horário de término da sessão com base na duração do filme.
     *
     * @return o horário de término da sessão
     */
    private LocalDateTime calcularHorarioTermino() {
        return horarioInicio.plus(filme.getDuracao());
    }

    /**
     * Cria uma nova sessão e adiciona à lista de sessões.
     *
     * @param filme o filme em exibição
     * @param salas a sala onde a sessão será exibida
     * @param horarioInicio o horário de início da sessão
     */
    public static void criarSessao(Filme filme, Sala salas, LocalDateTime horarioInicio) {
        Sessao sessao = new Sessao(filme, salas, horarioInicio);
        sessoes.add(sessao);
    }

    /**
     * Retorna a lista de todas as sessões.
     *
     * @return a lista de sessões
     */
    public static List<Sessao> listarSessoes() {
        return sessoes;
    }

    /**
     * Registra a quantidade de espectadores na sessão.
     *
     * @param quantidade a quantidade de espectadores a ser registrada
     */
    public void registrarEspectadores(int quantidade) {
        this.espectadores += quantidade;
        filme.adicionarEspectadores(quantidade);
    }

    /**
     * Retorna uma representação em string do objeto Sessao.
     *
     * @return uma string representando a sessão
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Sessao{" +
                "filme=" + filme.getTitulo() +
                ", sala=" + salas.getNumeroSala() +
                ", horarioInicio=" + horarioInicio.format(formatter) +
                ", horarioTermino=" + horarioTermino.format(formatter) +
                '}';
    }
}
