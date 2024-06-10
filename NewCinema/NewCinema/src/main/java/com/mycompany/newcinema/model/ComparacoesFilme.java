package com.mycompany.newcinema.model;

import java.time.Duration;
import java.util.Comparator;

public class ComparacoesFilme {

    /**
     * Compara dois objetos Filme pelo título.
     *
     * @param f1 o primeiro filme a ser comparado.
     * @param f2 o segundo filme a ser comparado.
     * @return um valor negativo se f1 tiver um título que vem antes de f2
     * lexicograficamente, zero se ambos tiverem o mesmo título, um valor
     * positivo se f1 tiver um título que vem depois de f2 lexicograficamente.
     */
    public static Comparator<Filme> comparaNomes() {
        return (f1, f2) -> {
            String titulo1 = f1.getTitulo();
            String titulo2 = f2.getTitulo();

            int minLength = Math.min(titulo1.length(), titulo2.length());
            for (int i = 0; i < minLength; i++) {
                char letra1 = titulo1.charAt(i);
                char letra2 = titulo2.charAt(i);
                if (letra1 != letra2) {
                    return letra1 - letra2;
                }
            }
            return titulo1.length() - titulo2.length();
        };
    }

    /**
     * Compara dois objetos Filme pelo TotalEspectadores.
     *
     * @param f1 o primeiro filme a ser comparado.
     * @param f2 o segundo filme a ser comparado.
     * @return um valor negativo se f1 tiver o numero de espectadores menor que
     * f2, zero se ambos tiverem o mesmo número de espectadores, um valor positivo se f1 tiver o
     * numero de espectadores maior que f2.
     */
    public static Comparator<Filme> compareTotalEspectadores() {
        return (f1, f2) -> Integer.compare(f1.getTotalEspectadores(), f2.getTotalEspectadores());
    }

    /**
     * Compara dois objetos Filme pela Duração.
     *
     * @return um valor negativo se f1 tiver menor duração que f2, zero se ambos
     * tiverem a mesma duração, um valor positivo se f1 tiver maior duração que f2.
     */
    public static Comparator<Filme> compareTotalDuracao() {
        return (f1, f2) -> {
            Duration duracao1 = f1.getDuracao();
            Duration duracao2 = f2.getDuracao();

            long seconds1 = duracao1.getSeconds();
            long seconds2 = duracao2.getSeconds();

            if (seconds1 != seconds2) {
                return Long.compare(seconds1, seconds2);
            }

            int nanos1 = duracao1.getNano();
            int nanos2 = duracao2.getNano();

            return Integer.compare(nanos1, nanos2);
        };
    }
}
