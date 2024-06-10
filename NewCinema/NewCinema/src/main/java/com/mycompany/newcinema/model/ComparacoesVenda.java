/* 
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema.model;

import java.util.Comparator;

/**
 * Classe que fornece comparações para objetos do tipo Venda.
 */
public class ComparacoesVenda
{

    /**
     * Compara dois objetos Venda pelo valor total da venda.
     *
     * @param v1 a primeira venda a ser comparada.
     * @param v2 a segunda venda a ser comparada.
     * @return um valor negativo se v1 tiver um valor total menor que v2, zero
     * se ambos tiverem o mesmo valor total, um valor positivo se v1 tiver um
     * valor total maior que v2.
     */
    public static Comparator<Venda> compararPorValorTotal()
    {
        return (v1, v2) ->
        {
            double valorTotal1 = v1.getValorTotal();
            double valorTotal2 = v2.getValorTotal();
            if (valorTotal1 < valorTotal2)
            {
                return -1;
            }
            else if (valorTotal1 > valorTotal2)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        };
    }

    /**
     * Compara dois objetos Venda pelo valor total dos ingressos.
     *
     * @param v1 a primeira venda a ser comparada.
     * @param v2 a segunda venda a ser comparada.
     * @return um valor negativo se v1 tiver um valor total de ingressos menor
     * que v2, zero se ambos tiverem o mesmo valor total de ingressos, um valor
     * positivo se v1 tiver um valor total de ingressos maior que v2.
     */
    public static Comparator<Venda> compararPorValorIngressos()
    {
        return (v1, v2) ->
        {
            double valorIngressos1 = v1.getValorIngressos();
            double valorIngressos2 = v2.getValorIngressos();
            if (valorIngressos1 < valorIngressos2)
            {
                return -1;
            }
            else if (valorIngressos1 > valorIngressos2)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        };
    }

    /**
     * Compara dois objetos Venda pelo valor total dos produtos.
     *
     * @param v1 a primeira venda a ser comparada.
     * @param v2 a segunda venda a ser comparada.
     * @return um valor negativo se v1 tiver um valor total de produtos menor
     * que v2, zero se ambos tiverem o mesmo valor total de produtos, um valor
     * positivo se v1 tiver um valor total de produtos maior que v2.
     */
    public static Comparator<Venda> compararPorValorProdutos()
    {
        return (v1, v2) ->
        {
            double valorProdutos1 = v1.getValorProdutos();
            double valorProdutos2 = v2.getValorProdutos();
            if (valorProdutos1 < valorProdutos2)
            {
                return -1;
            }
            else if (valorProdutos1 > valorProdutos2)
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
