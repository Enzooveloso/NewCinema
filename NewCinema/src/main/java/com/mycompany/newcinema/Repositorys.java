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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorys
{

    public static final String addresFilme = "C:/Users/enzov/OneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposFilme.json";
    public static final String addresProduto = "C:/Users/enzov/OneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposProduto.json";
    public static final String addresVendas = "C:/Users/enzov/oneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposVendas.json";
    public static final String addresClientes = "C:/Users/enzov/oneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposCliente.json";
    public static final String addresClienteVenda = "C:/Users/enzov/oneDrive/Documentos/NetBeansProjects/NewCinema/src/main/java/com/mycompany/newcinema/ReposClienteVendas.json";

    public Repositorys()
    {
    }

    public static void salvarFilmes(List<Filme> filmes) throws IOException
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

    public static void salvarProdutos(List<Produto> produtos) throws IOException
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(produtos);
        try (FileWriter arquivo = new FileWriter(addresProduto))
        {
            arquivo.write(json);
            System.out.println("Produtos salvos com sucesso em " + addresProduto);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public static void salvarVendas(List<Venda> vendas) throws IOException
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(vendas);
        try (FileWriter arquivo = new FileWriter(addresVendas))
        {
            arquivo.write(json);
            System.out.println("Produtos salvos com sucesso em " + addresVendas);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public static void salvarClientes(List<Cliente> clientes) throws IOException
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(clientes);
        try (FileWriter arquivo = new FileWriter(addresClientes))
        {
            arquivo.write(json);
            System.out.println("Produtos salvos com sucesso em " + addresClientes);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public static void salvarClientesComVendas(List<Cliente> clientes, Map<Cliente, List<Venda>> vendasPorCliente) throws IOException
    {
        // Cria um mapa para armazenar os dados do cliente junto com suas vendas
        Map<String, Object> dadosClientesComVendas = new HashMap<>();

        for (Cliente cliente : clientes) {
            Map<String, Object> dadosCliente = new HashMap<>();
            dadosCliente.put("cliente", cliente);
            dadosCliente.put("vendas", vendasPorCliente.get(cliente));
            dadosClientesComVendas.put(cliente.getCpf(), dadosCliente);
        }

        // Configura o Gson para serializar os dados corretamente
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(Duration.class, new DurationAdapter())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(dadosClientesComVendas);
        try (FileWriter arquivo = new FileWriter(addresClienteVenda)) {
            arquivo.write(json);
            System.out.println("Clientes com vendas salvos com sucesso em " + addresClienteVenda);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes com vendas: " + e.getMessage());
            throw e;
        }
    }
}
