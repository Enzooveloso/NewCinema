/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema.model;

import java.time.LocalDate;

/**
 * Classe que representa uma pessoa no sistema de cinema.
 * <p>
 * Esta classe armazena informações pessoais como nome, sobrenome, endereço,
 * telefone, CPF e data de aniversário.
 * </p>
 *
 * @author enzov
 */
public abstract class Pessoa
{

    private String name;
    private String sobrenome;
    private String endereco;
    private String telefone;
    private String cpf;
    private LocalDate aniversario;
    private String categoria;

    /**
     * Construtor para inicializar uma nova pessoa com todos os detalhes
     * necessários.
     *
     * @param name Nome da pessoa.
     * @param sobrenome Sobrenome da pessoa.
     * @param endereco Endereço residencial da pessoa.
     * @param telefone Número de telefone da pessoa.
     * @param cpf CPF da pessoa.
     * @param aniversario Data de aniversário da pessoa.
     */
    public Pessoa(String name, String sobrenome, String endereco, String telefone, String cpf, LocalDate aniversario)
    {
        this.name = name;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.aniversario = aniversario;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param name O novo nome da pessoa.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Retorna o sobrenome da pessoa.
     *
     * @return O sobrenome da pessoa.
     */
    public String getSobrenome()
    {
        return sobrenome;
    }

    /**
     * Define o sobrenome da pessoa.
     *
     * @param sobrenome O novo sobrenome da pessoa.
     */
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o endereço da pessoa.
     *
     * @return O endereço da pessoa.
     */
    public String getEndereco()
    {
        return endereco;
    }

    /**
     * Define o endereço da pessoa.
     *
     * @param endereco O novo endereço da pessoa.
     */
    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    /**
     * Retorna o número de telefone da pessoa.
     *
     * @return O telefone da pessoa.
     */
    public String getTelefone()
    {
        return telefone;
    }

    /**
     * Define o número de telefone da pessoa.
     *
     * @param telefone O novo número de telefone da pessoa.
     */
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    /**
     * Retorna o CPF da pessoa.
     *
     * @return O CPF da pessoa.
     */
    public String getCpf()
    {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cpf O novo CPF da pessoa.
     */
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    /**
     * Retorna a data de aniversário da pessoa.
     *
     * @return A data de aniversário da pessoa.
     */
    public LocalDate getAniversario()
    {
        return aniversario;
    }

    /**
     * Define a data de aniversário da pessoa.
     *
     * @param aniversario A nova data de aniversário da pessoa.
     */
    public void setAniversario(LocalDate aniversario)
    {
        this.aniversario = aniversario;
    }

    /**
     * Retorna a categoria da pessoa.
     *
     * @return A categoria da pessoa.
     */
    public String getCategoria()
    {
        return categoria;
    }

    /**
     * Define a categoria da pessoa.
     *
     * @param categoria A nova categoria da pessoa.
     */
    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    @Override
    public String toString()
    {
        return "Pessoa{"
                + "nome = " + getName()
                + ", sobrenome = " + getSobrenome()
                + ", endereço = " + getEndereco()
                + ", telefone = " + getTelefone()
                + ", CPF = " + getCpf()
                + ", aniversario = " + getAniversario()
                + '}';
    }

}
