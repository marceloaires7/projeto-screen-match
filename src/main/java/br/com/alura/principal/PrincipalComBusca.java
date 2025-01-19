package br.com.alura.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.modelos.Titulo;
import br.com.alura.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        try {

            HttpClient client = HttpClient.newHttpClient();

            System.out.println("Digite um filme para buscar: ");
            var busca = sc.nextLine()
                    .replace(" ", "+");

            var endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=da9e8d0f", busca);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

            System.out.println(meuTituloOmdb);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);

            System.out.println(meuTitulo);

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço:");
            System.out.println(e.getMessage());
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println("Aconteceu algo, não sei o que é:");
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
