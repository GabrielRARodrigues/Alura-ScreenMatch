package br.com.alura.screenmatch.API;

import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscaTituloOmdb {
    private String apiKey = "5e3471fe";

    public TituloOmdb buscaTitulo(String titulo) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        var endereco = "https://www.omdbapi.com/?t=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8) + "&apikey=" + apiKey;

        URI url = URI.create(endereco);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(url).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), TituloOmdb.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui encontrar esse filme.");
        }

    }

}
