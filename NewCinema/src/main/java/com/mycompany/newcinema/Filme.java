/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author enzov
 */
//interface Comparator é parametrizada para comparar objetos do tipo Filme
public class Filme implements Comparator<Filme>
{

    private String titulo;

    private String genero;

    private Duration duracao;
    private int totalEspectadores;
    private long tempoTotalExibicao;

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public Duration getDuracao()
    {
        return duracao;
    }

    public void setDuracao(Duration duracao)
    {
        this.duracao = duracao;
    }

    public int getTotalEspectadores()
    {
        return totalEspectadores;
    }

    public void setTotalEspectadores(int totalEspectadores)
    {
        this.totalEspectadores = totalEspectadores;
    }

    public long getTempoTotalExibicao()
    {
        return tempoTotalExibicao;
    }

    public void setTempoTotalExibicao(long tempoTotalExibicao)
    {
        this.tempoTotalExibicao = tempoTotalExibicao;
    }

    public Filme()
    {
    }

    public Filme(String titulo, String genero, Duration duracao)
    {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.totalEspectadores = 0;
        this.tempoTotalExibicao = 0;
    }

    public void adicionarEspectadores(int quantidade)
    {
        this.totalEspectadores += quantidade;
        this.tempoTotalExibicao += quantidade * duracao.toMinutes();
    }

    @Override
    public String toString()
    {
        return "Filme{"
                + "titulo='" + titulo + '\''
                + ", genero='" + genero + '\''
                + ", duracao=" + duracao
                + '}';
    }

    @Override // está fazendo a comparação entre dois filmes por ordem alfabética
    public int compare(Filme f1, Filme f2)
    {
        return f1.getTitulo().compareTo(f2.getTitulo());
    }
}
