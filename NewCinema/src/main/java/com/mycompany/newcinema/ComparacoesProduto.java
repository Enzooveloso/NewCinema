/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema;

import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author enzov
 */
public class ComparacoesProduto
{

    /**
     * Compara dois objetos Produto pelo nome.
     *
     * @return um Comparator que compara dois produtos pelo nome.
     */
    public static Comparator<Produto> comparaNomes()
    {
        return (p1, p2) ->
        {
            String nome1 = p1.getNome();
            String nome2 = p2.getNome();

            int minLength = Math.min(nome1.length(), nome2.length());
            for (int i = 0; i < minLength; i++)
            {
                char letra1 = nome1.charAt(i);
                char letra2 = nome2.charAt(i);
                if (letra1 != letra2)
                {
                    return letra1 - letra2;
                }
            }
            return nome1.length() - nome2.length();
        };
    }

    /**
     * Compara dois objetos Produto pela validade.
     *
     * @return um Comparator que compara dois produtos pela validade.
     */
    public static Comparator<Produto> compareValidade()
    {
        return (p1, p2) ->
        {
            LocalDate validade1 = p1.getValidade();
            LocalDate validade2 = p2.getValidade();

            int yearDiff = validade1.getYear() - validade2.getYear();
            if (yearDiff != 0)
            {
                return yearDiff;
            }

            int monthDiff = validade1.getMonthValue() - validade2.getMonthValue();
            if (monthDiff != 0)
            {
                return monthDiff;
            }

            return validade1.getDayOfMonth() - validade2.getDayOfMonth();
        };
    }

    /**
     * Compara dois objetos Produto pelo preço.
     *
     * @return um Comparator que compara dois produtos pelo preço.
     */
    public static Comparator<Produto> comparePreco()
    {
        return (p1, p2) ->
        {
            double preco1 = p1.getPreco();
            double preco2 = p2.getPreco();

            if (preco1 < preco2)
            {
                return -1;
            }
            else if (preco1 > preco2)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        };
    }
}
