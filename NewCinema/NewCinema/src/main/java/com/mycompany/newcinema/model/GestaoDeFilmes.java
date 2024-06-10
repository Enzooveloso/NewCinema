package com.mycompany.newcinema.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela gestão dos filmes no sistema de cinema.
 * Permite cadastrar, remover e listar filmes.
 * @autor enzov
 */
public class GestaoDeFilmes {

    private List<Filme> filmes; 

    /**
     * Retorna a lista de filmes gerenciados.
     *
     * @return a lista de filmes
     */
    public List<Filme> getFilmes() {
        return filmes;
    }

    /**
     * Define a lista de filmes gerenciados.
     *
     * @param filmes a nova lista de filmes
     */
    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    /**
     * Construtor padrão da classe GestaoDeFilmes.
     */
    public GestaoDeFilmes() {
        this.filmes = new ArrayList<>();
    }

    /**
     * Construtor da classe GestaoDeFilmes com parâmetros.
     *
     * @param filmes a lista inicial de filmes
     */
    public GestaoDeFilmes(List<Filme> filmes) {
        this.filmes = filmes != null ? filmes : new ArrayList<>();
    }
    /**
     * Cadastra um novo filme.
     *
     * @param nome o nome do filme
     * @param genero o gênero do filme
     * @param duracao a duração do filme
     * @return o filme cadastrado
     */
    public Filme cadastraFilme(String nome, String genero, Duration duracao) {
        Filme novoFilme = new Filme(nome, genero, duracao);
        this.filmes.add(novoFilme);
        return novoFilme;
    }

    /**
     * Remove um filme pelo nome.
     *
     * @param nome o nome do filme a ser removido
     * @return true se o filme foi removido, false caso contrário
     */
    public boolean removeFilme(String nome) {
        return filmes.removeIf(x -> x.getTitulo().equals(nome));
    }

    /**
     * Retorna uma lista de todos os filmes gerenciados.
     *
     * @return a lista de filmes
     */
    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    /**
     * Retorna uma representação em string do objeto GestaoDeFilmes.
     *
     * @return uma string representando a gestão de filmes
     */
    @Override
    public String toString() {
        return "GestaoDeFilmes{" +
                "filmes=" + filmes +
                '}';
    }
}
