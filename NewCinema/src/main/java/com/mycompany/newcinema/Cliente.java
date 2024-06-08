/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe para representar os clientes utilizada para armazenar características
 * do cliente e realizar suas funções.
 * <p>
 * É usada para armazenar suas características como preferências, login e senha
 * e realizar o seu cadastro e entrar no sistema.
 * </p>
 *
 * @author Lucas
 */
public class Cliente extends Pessoa
{

    //Arrumar pessoa: Pessoa e dois preferenciasDeFilme: String no UML
    /**
     * Nome da preferência por filme.
     */
    private String preferenciaDeFilme;
    /**
     * Nome da preferência por gênero.
     */
    private String preferenciaDeGenero;
    /**
     * Login registrado do cliente.
     */
    private String loginClienteOriginal;
    /**
     * Senha registrada do cliente.
     */
    private String senhaClienteOriginal;
    /**
     * Login usado pelo cliente para entrar no sistema.
     */
    private String loginCliente;
    /**
     * Senha usada pelo cliente para entrar no sistema.
     */
    private String senhaCliente;

    public static int CONTADOR_CLIENTE;

    Scanner sc = new Scanner(System.in);

    /**
     * Construtor com informações do cliente.
     *
     * @param name O nome do cliente.
     * @param sobrenome O sobrenome do cliente.
     * @param endereco O endereço do cliente.
     * @param telefone O telefone do cliente.
     * @param cpf O CPF do cliente.
     * @param aniversario A data de nascimento do cliente.
     * @param preferenciaDeFilme O filme de preferência do cliente.
     * @param preferenciaDeGenero O gênero de filme de preferência do cliente.
     * @param loginClienteOriginal O login registrado do cliente.
     * @param senhaClienteOriginal A senha registrada do cliente.
     */
    public Cliente(String name, String sobrenome, String endereco, String telefone, String cpf, LocalDate aniversario,
            String preferenciaDeFilme, String preferenciaDeGenero, String loginClienteOriginal,
            String senhaClienteOriginal)
    {
        super(name, sobrenome, endereco, telefone, cpf, aniversario);
        this.preferenciaDeFilme = preferenciaDeFilme;
        this.preferenciaDeGenero = preferenciaDeGenero;
        this.loginClienteOriginal = loginClienteOriginal;
        this.senhaClienteOriginal = senhaClienteOriginal;
        setCategoria("Cliente");
        CONTADOR_CLIENTE++;
    }

    /**
     * Construtor com somente as informações herdadas da classe Pessoa.
     *
     * @param name O nome do cliente.
     * @param sobrenome O sobrenome do cliente.
     * @param endereco O endereço do cliente.
     * @param telefone O telefone do cliente.
     * @param cpf O CPF do cliente.
     * @param aniversario A data de nascimento do cliente.
     */
    public Cliente(String name, String sobrenome, String endereco, String telefone, String cpf, LocalDate aniversario)
    {
        super(name, sobrenome, endereco, telefone, cpf, aniversario);
    }

    /**
     * Solicita o login e a senha do cliente para ele entrar no sistema. Se a
     * senha e login forem corretos o cliente entrará no sistema, se não forem
     * vão pedir novamente o login e a senha.
     *
     */
    public void clienteRealizarLogin()
    {
        boolean loginValido = false;
        while (!loginValido)
        {
            System.out.println("Informe o seu login: ");
            loginCliente = sc.nextLine();
            System.out.println("Informe a sua senha: ");
            senhaCliente = sc.nextLine();

            if (loginCliente.equals(loginClienteOriginal) && senhaCliente.equals(senhaClienteOriginal))
            {
                loginValido = true;
                System.out.println("Bem vindo ao CineDjamas");
            }
            else
            {
                System.out.println("Login ou senha incorretos. Tente novamente");
            }
        }
    }

    /**
     * Realiza o cadastro do cliente no sistema, solicitando suas informações.
     */
    public void clienteRealizarCadastro()
    {
        System.out.println("Qual o seu nome: ");
        String name = sc.nextLine();
        setName(name);

        System.out.println("Qual o seu sobrenome: ");
        String sobrenome = sc.nextLine();
        setSobrenome(sobrenome);

        System.out.println("Qual o seu endereço: ");
        String endereco = sc.nextLine();
        setEndereco(endereco);

        System.out.println("Qual o seu telefone: ");
        String telefone = sc.nextLine();
        setTelefone(telefone);

        System.out.println("Qual o seu CPF: ");
        String cpf = sc.nextLine();
        setCpf(cpf);

        System.out.println("Qual a sua data de nascimento (formato dd/MM/yyyy): ");
        String aniversarioTexto = sc.nextLine();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate aniversario = LocalDate.parse(aniversarioTexto, formatoData);
        setAniversario(aniversario);

        System.out.println("Qual vai ser o seu login: ");
        loginClienteOriginal = sc.nextLine();

        System.out.println("Qual vai ser a sua senha: ");
        senhaClienteOriginal = sc.nextLine();
    }

    public String getPreferenciaDeFilme()
    {
        return preferenciaDeFilme;
    }

    public String getPreferenciaDeGenero()
    {
        return preferenciaDeGenero;
    }

    public String getLoginClienteOriginal()
    {
        return loginClienteOriginal;
    }

    public String getSenhaClienteOriginal()
    {
        return senhaClienteOriginal;
    }

    public String getLoginCliente()
    {
        return loginCliente;
    }

    public String getSenhaCliente()
    {
        return senhaCliente;
    }

    public void setPreferenciaDeFilme(String preferenciaDeFilme)
    {
        this.preferenciaDeFilme = preferenciaDeFilme;
    }

    public void setPreferenciaDeGenero(String preferenciaDeGenero)
    {
        this.preferenciaDeGenero = preferenciaDeGenero;
    }

    public void setLoginClienteOriginal(String loginClienteOriginal)
    {
        this.loginClienteOriginal = loginClienteOriginal;
    }

    public void setSenhaClienteOriginal(String senhaClienteOriginal)
    {
        this.senhaClienteOriginal = senhaClienteOriginal;
    }

    public void setLoginCliente(String loginCliente)
    {
        this.loginCliente = loginCliente;
    }

    public void setSenhaCliente(String senhaCliente)
    {
        this.senhaCliente = senhaCliente;
    }

    @Override
    public String toString()
    {
        return "Cliente{"
                + "nome = " + getName()
                + ", sobrenome = " + getSobrenome()
                + ", endereço = " + getEndereco()
                + ", telefone = " + getTelefone()
                + ", CPF = " + getCpf()
                + ", aniversario = " + getAniversario()
                + ", preferencia de filme = " + getPreferenciaDeFilme()
                + ", preferncia de genero = " + getPreferenciaDeGenero()
                + ", login = " + getLoginClienteOriginal()
                + ", senha = " + getSenhaClienteOriginal()
                + '}';
    }

}
