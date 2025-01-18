package br.com.alura.principal;

import java.util.ArrayList;

import br.com.alura.calculos.CalculadoraDeTempo;
import br.com.alura.calculos.FiltroRecomendacao;
import br.com.alura.modelos.Episodio;
import br.com.alura.modelos.Filme;
import br.com.alura.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos());

        System.out.println(meuFilme);
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(String.format("%.2f", meuFilme.pegaMedia()));

        Serie lost = new Serie("Lost", 2000, 6);
        System.out.println(lost);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para Maratonar Lost: " + lost.getDuracaoEmMinutos() + " Minutos ou "
                + lost.getDuracaoEmMinutos() / 60 + " Horas");

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        calculadora.inclui(outroFilme);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("Dogville", 2003);

        filmeDoPaulo.setDuracaoEmMinutos(178);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da Lista: " + listaDeFilmes.size());
        System.out.println("Primeiro Filme da Lista: " + listaDeFilmes.get(0).getNome());

        System.out.println(listaDeFilmes);
    }
}