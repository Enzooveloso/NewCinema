/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Repositorys
{

    public static String addresFilme = "C:/Users/enzov/OneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposFilme.json";
    public static String addresProduto = "C:/Users/enzov/OneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposProduto.json";
    public static String addresVendas = "C:/Users/nzov/neDrive/Documentos/etBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposVendas.json";

    public Repositorys()
    {
    }

    public static void SalvarFilmes(List<Filme> filmes) throws IOException
    {
        System.out.println("Salvando filmes...");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Duration.class, new DurationAdapter());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(addresFilme))
        {
            gson.toJson(filmes, writer);
            System.out.println("Filmes salvos com sucesso em " + addresFilme);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar filmes: " + e.getMessage());
        }
    }

    public static void SalvarProdutos(List<Produto> produtos) throws IOException
    {
        System.out.println("Salvando produtos...");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Duration.class, new DurationAdapter());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(addresProduto))
        {
            gson.toJson(produtos, writer);
            System.out.println("Produtos salvos com sucesso em " + addresProduto);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public static void SalvarVendas(List<Venda> vendas) throws IOException
    {
        System.out.println("Salvando Venda...");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Duration.class, new DurationAdapter());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(addresVendas))
        {
            gson.toJson(vendas, writer);
            System.out.println("Venda salva com sucesso em " + addresVendas);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar venda: " + e.getMessage());
        }
    }
}
