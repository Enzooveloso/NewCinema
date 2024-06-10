package com.mycompany.newcinema.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por representar um filme no sistema de cinema. Contém
 * informações como título, gênero, duração, total de espectadores e tempo total
 * de exibição.
 *
 * @author enzov
 */
public class Filme
{

    private String titulo;
    private String genero;
    private Duration duracao;
    private int totalEspectadores;
    private long tempoTotalExibicao;
    private static List<Filme> filmes = new ArrayList<>();

    /**
     * Retorna o título do filme.
     *
     * @return o título do filme
     */
    public String getTitulo()
    {
        return titulo;
    }

    /**
     * Define o título do filme.
     *
     * @param titulo o novo título do filme
     */
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    /**
     * Retorna o gênero do filme.
     *
     * @return o gênero do filme
     */
    public String getGenero()
    {
        return genero;
    }

    /**
     * Define o gênero do filme.
     *
     * @param genero o novo gênero do filme
     */
    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    /**
     * Retorna a duração do filme.
     *
     * @return a duração do filme
     */
    public Duration getDuracao()
    {
        return duracao;
    }

    /**
     * Define a duração do filme.
     *
     * @param duracao a nova duração do filme
     */
    public void setDuracao(Duration duracao)
    {
        this.duracao = duracao;
    }

    /**
     * Retorna o total de espectadores que assistiram ao filme.
     *
     * @return o total de espectadores
     */
    public int getTotalEspectadores()
    {
        return totalEspectadores;
    }

    /**
     * Define o total de espectadores que assistiram ao filme.
     *
     * @param totalEspectadores o novo total de espectadores
     */
    public void setTotalEspectadores(int totalEspectadores)
    {
        this.totalEspectadores = totalEspectadores;
    }

    /**
     * Retorna o tempo total de exibição do filme em minutos.
     *
     * @return o tempo total de exibição
     */
    public long getTempoTotalExibicao()
    {
        return tempoTotalExibicao;
    }

    /**
     * Define o tempo total de exibição do filme em minutos.
     *
     * @param tempoTotalExibicao o novo tempo total de exibição
     */
    public void setTempoTotalExibicao(long tempoTotalExibicao)
    {
        this.tempoTotalExibicao = tempoTotalExibicao;
    }

    /**
     * Construtor padrão da classe Filme.
     */
    public Filme()
    {
    }

    /**
     * Construtor da classe Filme com parâmetros.
     *
     * @param titulo o título do filme
     * @param genero o gênero do filme
     * @param duracao a duração do filme
     */
    public Filme(String titulo, String genero, Duration duracao)
    {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.totalEspectadores = 0;
        this.tempoTotalExibicao = 0;
    }

    /**
     * Adiciona espectadores ao total e atualiza o tempo total de exibição.
     *
     * @param quantidade a quantidade de espectadores a ser adicionada
     */
    public void adicionarEspectadores(int quantidade)
    {
        this.totalEspectadores += quantidade;
        this.tempoTotalExibicao += quantidade * duracao.toMinutes();
    }

    /**
     * Retorna uma representação em string do objeto Filme.
     *
     * @return uma string representando o filme
     */
    @Override
    public String toString()
    {
        return "Filme{"
                + "titulo='" + titulo + '\''
                + ", genero='" + genero + '\''
                + ", duracao=" + duracao
                + '}';
    }
}
