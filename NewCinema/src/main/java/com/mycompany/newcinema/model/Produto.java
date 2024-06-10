package com.mycompany.newcinema.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Classe responsável por representar um produto no sistema de cinema. Contém
 * informações como nome, validade e preço do produto.
 */
public class Produto implements Comparator<Produto>
{

    private String nome;
    private LocalDate validade;
    private double preco;
    private static int N_INSTANCIAS = 0;

    /**
     * Retorna a quantidade de instâncias de produto.
     *
     * @return o número de instâncias
     */
    public static int getN_INSTANCIAS()
    {
        return N_INSTANCIAS;
    }

    /**
     * Define o número de instâncias.
     *
     * @param N_INSTANCIAS nova quantidade de instâncias
     */
    public static void setN_INSTANCIAS(int N_INSTANCIAS)
    {
        Produto.N_INSTANCIAS = N_INSTANCIAS;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return o nome do produto
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome o novo nome do produto
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * Retorna a data de validade do produto.
     *
     * @return a data de validade
     */
    public LocalDate getValidade()
    {
        return validade;
    }

    /**
     * Define a data de validade do produto.
     *
     * @param validade a nova data de validade
     */
    public void setValidade(LocalDate validade)
    {
        this.validade = validade;
    }

    /**
     * Retorna o preço do produto.
     *
     * @return o preço do produto
     */
    public double getPreco()
    {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco o novo preço do produto
     */
    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    /**
     * Contrutor padrao da classe Produto
     */
    public Produto()
    {
    }

    /**
     * Construtor da classe Produto.
     *
     * @param nome o nome do produto
     * @param validade a data de validade do produto
     * @param preco o preço do produto
     */
    public Produto(String nome, LocalDate validade, double preco)
    {
        this.nome = nome;
        this.validade = validade;
        this.preco = preco;
        N_INSTANCIAS++;
    }

    /**
     * Compara dois objetos Produto pelo nome.
     *
     * @param p1 o primeiro produto a ser comparado
     * @param p2 o segundo produto a ser comparado
     * @return um valor negativo se p1 for anterior a p2 na ordem alfabética,
     * zero se ambos estiverem na mesma posição, um valor positivo se p1 for
     * posterior a p2 na ordem alfabética
     */
    @Override
    public int compare(Produto p1, Produto p2)
    {
        return p1.getNome().compareTo(p2.getNome());
    }

    /**
     * Compara dois objetos Produto pela data de validade.
     *
     * @param p1 o primeiro produto a ser comparado
     * @param p2 o segundo produto a ser comparado
     * @return um valor negativo se p1 tiver uma validade anterior a p2, zero se
     * ambos tiverem a mesma validade, um valor positivo se p1 tiver uma
     * validade posterior a p2
     */
    public int compareValidade(Produto p1, Produto p2)
    {
        return p1.getValidade().compareTo(p2.getValidade());
    }

    /**
     * Compara dois objetos Produto pelo preço.
     *
     * @param p1 o primeiro produto a ser comparado
     * @param p2 o segundo produto a ser comparado
     * @return um valor negativo se p1 for mais barato que p2, zero se ambos
     * tiverem o mesmo preço, um valor positivo se p1 for mais caro que p2
     */
    public int comparePreco(Produto p1, Produto p2)
    {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }

    /**
     * Retorna uma representação em string do objeto Produto.
     *
     * @return uma string representando o produto
     */
    @Override
    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Produto{"
                + "nome='" + nome + '\''
                + ", validade=" + validade.format(formatter)
                + ", preco=" + preco
                + '}';
    }
}
