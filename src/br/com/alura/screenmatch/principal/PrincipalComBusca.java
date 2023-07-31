package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.API.BuscaTituloOmdb;
import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.GeradorDeArquivo;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        var gerador = new GeradorDeArquivo();
        var buscador = new BuscaTituloOmdb();

        try {
            while (!busca.equalsIgnoreCase("sair")) {
                System.out.println("Digite um filme para busca: ");
                busca = leitura.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }

                TituloOmdb meuTituloOmdb = buscador.buscaTitulo(busca);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            }
            System.out.println(titulos);
            gerador.salvaJson(titulos);
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço");
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possíver ler ou salvar os dados no arquivo filmes.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("O programa finalizou Corretamente");

    }
}


