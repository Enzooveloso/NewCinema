/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enzov
 */
public  class GestaoDeFilmes
{

    private List<Filme> filmes;

    public List<Filme> getFilmes()
    {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes)
    {
        this.filmes = filmes;
    }

    public GestaoDeFilmes()
    {
        this.filmes = new ArrayList<>();
    }

    public  GestaoDeFilmes(List<Filme> filmes)
    {
        this.filmes = filmes != null ? filmes : new ArrayList<>();
    }

    public Filme/*void talvez*/ cadastraFilme(String nome, String genero, Duration duracao)
    {
        Filme novoFilme = new Filme(nome, genero, duracao);
        this.filmes.add(novoFilme);
        /*Sendo void, sem o return */
        return novoFilme;
    }

    public boolean removeFilme(String name)
    {
        return filmes.removeIf(x -> x.getTitulo().equals(name));
    }
    
    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }
    @Override
    public String toString()
    {
        return "GestaoDeFilmes{"
                + "filmes=" + filmes
                + '}';
    }
}
