package br.com.alura.screenmatch.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void salvaJson(Titulo titulo) throws IOException {
        escreveArquivo("filme.json", gson.toJson(titulo));
    }

    public void salvaJson(List<Titulo> listaDeTitulos) throws IOException {
        escreveArquivo("filmes.json", gson.toJson(listaDeTitulos));

    }

    private void escreveArquivo(String nomeDoArquivo, String conteudoDoArquivo) throws IOException {
        FileWriter escrita = new FileWriter(nomeDoArquivo);
        escrita.write(conteudoDoArquivo);
        escrita.close();
    }

}

