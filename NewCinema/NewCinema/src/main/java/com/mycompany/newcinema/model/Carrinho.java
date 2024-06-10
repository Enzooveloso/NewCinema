package com.mycompany.newcinema.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe responsável pela gestão do carrinho de compras no cinema. Esta classe
 * permite selecionar sessões, poltronas, produtos e calcular quantidades.
 */
public class Carrinho
{

    private Filme filme;
    private Sessao sessao;
    private List<Integer> poltronasSelecionadas;
    private List<Produto> produtosSelecionados;
    private Map<Produto, Integer> quantidadeProdutos; // Associação direta entre produtos e suas quantidades
    private int quantidadeIngressos;
    private Estoque estoque;
    Scanner scanner = new Scanner(System.in);

    /**
     * Retorna o filme selecionado.
     *
     * @return o filme selecionado
     */
    public Filme getFilme()
    {
        return filme;
    }

    /**
     * Define o filme selecionado.
     *
     * @param filme o novo filme
     */
    public void setFilme(Filme filme)
    {
        this.filme = filme;
    }

    /**
     * Retorna a sessão selecionada.
     *
     * @return a sessão selecionada
     */
    public Sessao getSessao()
    {
        return sessao;
    }

    /**
     * Define a sessão selecionada.
     *
     * @param sessao a nova sessão
     */
    public void setSessao(Sessao sessao)
    {
        this.sessao = sessao;
    }

    /**
     * Retorna a lista de poltronas selecionadas.
     *
     * @return a lista de poltronas selecionadas
     */
    public List<Integer> getPoltronasSelecionadas()
    {
        return poltronasSelecionadas;
    }

    /**
     * Define a lista de poltronas selecionadas.
     *
     * @param poltronasSelecionadas a nova lista de poltronas
     */
    public void setPoltronasSelecionadas(List<Integer> poltronasSelecionadas)
    {
        this.poltronasSelecionadas = poltronasSelecionadas;
    }

    /**
     * Retorna a lista de produtos selecionados.
     *
     * @return a lista de produtos selecionados
     */
    public List<Produto> getProdutosSelecionados()
    {
        return produtosSelecionados;
    }

    /**
     * Define a lista de produtos selecionados.
     *
     * @param produtosSelecionados a nova lista de produtos
     */
    public void setProdutosSelecionados(List<Produto> produtosSelecionados)
    {
        this.produtosSelecionados = produtosSelecionados;
    }

    /**
     * Retorna a associação de produtos e suas quantidades.
     *
     * @return o mapa de produtos e quantidades
     */
    public Map<Produto, Integer> getQuantidadeProdutos()
    {
        return quantidadeProdutos;
    }

    /**
     * Define a associação de produtos e suas quantidades.
     *
     * @param quantidadeProdutos o novo mapa de produtos e quantidades
     */
    public void setQuantidadeProdutos(Map<Produto, Integer> quantidadeProdutos)
    {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    /**
     * Retorna a quantidade de ingressos.
     *
     * @return a quantidade de ingressos
     */
    public int getQuantidadeIngressos()
    {
        return quantidadeIngressos;
    }

    /**
     * Define a quantidade de ingressos.
     *
     * @param quantidadeIngressos a nova quantidade de ingressos
     */
    public void setQuantidadeIngressos(int quantidadeIngressos)
    {
        this.quantidadeIngressos = quantidadeIngressos;
    }

    /**
     * Retorna o estoque disponível.
     *
     * @return o estoque
     */
    public Estoque getEstoque()
    {
        return estoque;
    }

    /**
     * Define o estoque disponível.
     *
     * @param estoque o novo estoque
     */
    public void setEstoque(Estoque estoque)
    {
        this.estoque = estoque;
    }

    /**
     * Retorna o scanner para entrada de dados.
     *
     * @return o scanner
     */
    public Scanner getScanner()
    {
        return scanner;
    }

    /**
     * Define o scanner para entrada de dados.
     *
     * @param scanner o novo scanner
     */
    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }

    
    public Carrinho(Estoque estoque)
    {
        this();
        this.estoque = estoque;
    }
   
    /**
     * Construtor da classe Carrinho com estoque.
     *
     */
    public Carrinho()
    {
        this.poltronasSelecionadas = new ArrayList<>();
        this.produtosSelecionados =  new ArrayList<>();
        this.quantidadeProdutos =  new HashMap<>();
        this.quantidadeIngressos = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Permite selecionar uma sessão a partir de uma lista de sessões
     * disponíveis.
     *
     * @param sessoes a lista de sessões disponíveis
     */
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

    /**
     * Define a quantidade de ingressos.
     *
     * @param quantidade a nova quantidade de ingressos
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

    /**
     * Permite selecionar as poltronas para a sessão escolhida.
     */
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
        String[] selecaoPoltronas = scanner.nextLine().split(" ");
        List<Integer> poltronas = new ArrayList<>();
        for (String poltrona : selecaoPoltronas)
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

    /**
     * Permite selecionar um produto e sua quantidade.
     */
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

    /**
     * Retorna uma representação em string do carrinho.
     *
     * @return uma string representando o carrinho
     */
    @Override
    public String toString()
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        return "Carrinho{"
                + "Filme: " + (filme != null ? filme.getTitulo() : "Nenhum filme selecionado")
                + ", sessao: " + (sessao != null ? sessao.getHorarioInicio().format(formato) : "Nenhuma sessão selecionada")
                + ", quantidade de ingressos: " + quantidadeIngressos
                + ", poltronas selecionadas: " + poltronasSelecionadas
                + ", produtos selecionados: " + getProdutosSelecionados()
                + ", quantidade produtos: " + getQuantidadeProdutos()
                + '}';
    }

    
}
