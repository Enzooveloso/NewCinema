/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Carrinho
{

    private Filme filme;
    private Sessao sessao;
    private List<Integer> poltronasSelecionadas;
    private List<Produto> produtosSelecionados;
    private Map<Produto, Integer> quantidadeProdutos; // Associação direta entre produtos e suas quantidades.
    private int quantidadeIngressos;
    private Estoque estoque;
    private Scanner scanner;

    public Filme getFilme()
    {
        return filme;
    }

    public void setFilme(Filme filme)
    {
        this.filme = filme;
    }

    public Sessao getSessao()
    {
        return sessao;
    }

    public void setSessao(Sessao sessao)
    {
        this.sessao = sessao;
    }

    public List<Integer> getPoltronasSelecionadas()
    {
        return poltronasSelecionadas;
    }

    public void setPoltronasSelecionadas(List<Integer> poltronasSelecionadas)
    {
        this.poltronasSelecionadas = poltronasSelecionadas;
    }

    public List<Produto> getProdutosSelecionados()
    {
        return produtosSelecionados;
    }

    public void setProdutosSelecionados(List<Produto> produtosSelecionados)
    {
        this.produtosSelecionados = produtosSelecionados;
    }

    public Map<Produto, Integer> getQuantidadeProdutos()
    {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Map<Produto, Integer> quantidadeProdutos)
    {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public int getQuantidadeIngressos()
    {
        return quantidadeIngressos;
    }

    public void setQuantidadeIngressos(int quantidadeIngressos)
    {
        this.quantidadeIngressos = quantidadeIngressos;
    }

    public Estoque getEstoque()
    {
        return estoque;
    }

    public void setEstoque(Estoque estoque)
    {
        this.estoque = estoque;
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public Carrinho()
    {
    }
    

    public Carrinho(Estoque estoque)
    {
        this.poltronasSelecionadas = new ArrayList<>();
        this.produtosSelecionados = new ArrayList<>();
        this.quantidadeProdutos = new HashMap<>();
        this.quantidadeIngressos = 0;
        this.estoque = estoque;
        this.scanner = new Scanner(System.in);
    }

    public void selecionarSessao(List<Sessao> sessoes)
    {
        System.out.println("Selecione uma sessão disponível:");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(" HH:mm dd/MM/yyyy ");
        for (int i = 0; i < sessoes.size(); i++)
        {
            Sessao sessao = sessoes.get(i);

            System.out.println(i + 1 + ". Filme: " + sessao.getFilme().getTitulo() + " - Horário: " + sessao.getHorarioInicio().format(formato));
        }
        int selecao = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha pendente

        if (selecao < 1 || selecao > sessoes.size())
        {
            System.out.println("Seleção inválida.");
            return;
        }

        this.sessao = sessoes.get(selecao - 1);
        this.filme = sessao.getFilme();
        System.out.println("Sessão selecionada: " + sessao.getHorarioInicio().format(formato) + " - Filme: " + filme.getTitulo());
    }

    public void selecionarPoltronas()
    {
        if (this.sessao == null)
        {
            System.out.println("Erro: Selecione uma sessão primeiro.");
            return;
        }

        System.out.println("Quantos ingressos deseja?");
        int quantidadeIngressos = scanner.nextInt();
        this.selecionarQuantIngressos(quantidadeIngressos);

        System.out.println("Selecione as poltronas (1 a 64). Digite os números das poltronas separados por espaço:");
        scanner.nextLine();  // Consumir a linha pendente
        String[] poltronasInput = scanner.nextLine().split(" ");
        List<Integer> poltronas = new ArrayList<>();
        for (String poltrona : poltronasInput)
        {
            poltronas.add(Integer.parseInt(poltrona));
        }

        if (poltronas.size() > this.quantidadeIngressos)
        {
            System.out.println("Erro: O número de poltronas selecionadas excede a quantidade de ingressos.");
            return;
        }
        for (int poltrona : poltronas)
        {
            if (poltrona < 1 || poltrona > 64)
            {
                System.out.println("Erro: Poltrona " + poltrona + " inválida. Escolha um número entre 1 e 64.");
                return;
            }
            if (this.poltronasSelecionadas.contains(poltrona))
            {
                System.out.println("Erro: Poltrona " + poltrona + " já selecionada.");
                return;
            }
            this.poltronasSelecionadas.add(poltrona);
        }
        System.out.println("Poltronas selecionadas: " + this.poltronasSelecionadas);

    }

    public void selecionarProdutoEQuant()
    {
        System.out.println("Produtos disponíveis: ");
        for (Produto produto : estoque.listarProdutosDisponiveis())
        {
            System.out.println(produto.getNome());
        }
        System.out.println("\nInforme o nome do produto que deseja selecionar:");
        String selecionaProduto = scanner.nextLine();

        Produto produtoSelecionado = null;
        for (Produto produto : estoque.listarProdutosDisponiveis())
        {
            if (produto.getNome().equalsIgnoreCase(selecionaProduto))
            {
                produtoSelecionado = produto;
                break;
            }
        }

        if (produtoSelecionado == null)
        {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Você selecionou: " + produtoSelecionado.getNome());
        System.out.println("Informe a quantidade desejada desse produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha pendente

        if (quantidade < 1)
        {
            System.out.println("Erro: Quantidade inválida. Deve ser pelo menos 1.");
            return;
        }
        this.produtosSelecionados.add(produtoSelecionado);
        this.quantidadeProdutos.put(produtoSelecionado, quantidade); // .put() adiciona um par chave-valor em um mapa
        System.out.println("Produto selecionado: " + produtoSelecionado.getNome() + " - Quantidade: " + quantidade);
    }

    /*
    public void selecionarQuantProdutos() {
        if (this.produtosSelecionados.isEmpty()) { // .isEmpty() verifica a lista está vazia
            System.out.println("Erro: Selecione um produto primeiro.");
            return;
        }

        System.out.println("Produtos no carrinho:");
        for (int i = 0; i < produtosSelecionados.size(); i++) {
            Produto produto = produtosSelecionados.get(i);
            System.out.println(i + 1 + ". " + produto.getNome() + " - Quantidade atual: " + quantidadeProdutos.get(produto));
        }
        System.out.println("Informe o número do produto que deseja alterar a quantidade:");
        int selecao = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha pendente

        if (selecao < 1 || selecao > produtosSelecionados.size()) {
            System.out.println("Seleção inválida.");
            return;
        }

        Produto produto = produtosSelecionados.get(selecao - 1);
        System.out.println("Informe a nova quantidade para " + produto.getNome() + ":");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha pendente

        if (quantidade < 1) {
            System.out.println("Erro: Quantidade inválida. Deve ser pelo menos 1.");
            return;
        }
        this.quantidadeProdutos.put(produto, quantidade); // .put() adiciona um par chave-valor em um mapa 
    }
     */
    public void selecionarQuantIngressos(int quantidade)
    {
        if (quantidade < 1)
        {
            System.out.println("Erro: Quantidade inválida. Deve ser pelo menos 1.");
            return;
        }
        this.quantidadeIngressos = quantidade;
        System.out.println("Quantidade de ingressos selecionada: " + quantidade);
    }

    @Override
    public String toString()
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        return "Carrinho{"
                + "Filme: " + (filme != null ? filme.getTitulo() : "Nenhum filme selecionado")
                + ", sessao: " + (sessao != null ? sessao.getHorarioInicio().format(formato) : "Nenhuma sessão selecionada")
                + ", quantida de ingressos: " + quantidadeIngressos
                + ", poltronas selecionadas: " + poltronasSelecionadas
                + ", produtos selecionados: " + getProdutosSelecionados()
                + ", quantidade produtos: " + getQuantidadeProdutos()
                + '}';
    }
}
