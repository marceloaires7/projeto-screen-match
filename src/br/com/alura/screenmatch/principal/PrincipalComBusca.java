package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        HttpClient client = HttpClient.newHttpClient();

        System.out.println("Digite um filme para busca: ");

        var busca = sc.nextLine()
                .replace(" ", "+");

        var endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=da9e8d0f", busca);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        sc.close();
    }
}
