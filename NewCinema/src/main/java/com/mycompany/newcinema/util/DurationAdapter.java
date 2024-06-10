package com.mycompany.newcinema.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Duration;

/**
 * Classe responsável pela adaptação da classe Duration para JSON usando Gson.
 * Permite a serialização e desserialização de objetos Duration.
 */
public class DurationAdapter extends TypeAdapter<Duration> {

    /**
     * Escreve o objeto Duration no formato JSON.
     *
     * @param jsonWriter o escritor de JSON
     * @param duration o objeto Duration a ser escrito
     * @throws IOException se ocorrer um erro de I/O
     */
    @Override
    public void write(JsonWriter jsonWriter, Duration duration) throws IOException {
        jsonWriter.value(duration.toString());
    }

    /**
     * Lê o objeto Duration do formato JSON.
     *
     * @param jsonReader o leitor de JSON
     * @return o objeto Duration lido
     * @throws IOException se ocorrer um erro de I/O
     */
    @Override
    public Duration read(JsonReader jsonReader) throws IOException {
        return Duration.parse(jsonReader.nextString());
    }
}
