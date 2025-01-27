package br.com.alura.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import br.com.alura.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.modelos.Titulo;
import br.com.alura.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para buscar: ");
            busca = sc.nextLine()
                    .replace(" ", "+");

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {

                HttpClient client = HttpClient.newHttpClient();

                var endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=da9e8d0f", busca);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);

                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro:");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço:");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println("Aconteceu algo, não sei o que é:");
                System.out.println(e.getMessage());
            } catch (JsonSyntaxException | IOException | InterruptedException e) {
                System.out.println("Erro inesperado:");
                System.out.println(e.getMessage());
            }

        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        sc.close();
    }
}
