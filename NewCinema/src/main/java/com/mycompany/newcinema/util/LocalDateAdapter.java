package com.mycompany.newcinema.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsável pela adaptação da classe LocalDate para JSON usando Gson.
 * Permite a serialização e desserialização de objetos LocalDate.
 * @author enzov
 */
public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    private static final DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_DATE; // Formato ISO para LocalDate

    // Métodos

    /**
     * Escreve o objeto LocalDate no formato JSON.
     *
     * @param jsonWriter o escritor de JSON
     * @param localDate o objeto LocalDate a ser escrito
     * @throws IOException se ocorrer um erro de I/O
     */
    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
        jsonWriter.value(localDate.format(formato));
    }

    /**
     * Lê o objeto LocalDate do formato JSON.
     *
     * @param jsonReader o leitor de JSON
     * @return o objeto LocalDate lido
     * @throws IOException se ocorrer um erro de I/O
     */
    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
        return LocalDate.parse(jsonReader.nextString(), formato);
    }
}
