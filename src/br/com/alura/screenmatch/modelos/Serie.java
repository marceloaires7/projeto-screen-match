package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo {

    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    /**
     * Construtor para Serie.
     * 
     * @param nome       o nome da série
     * @param ano        o ano em que a série foi lançada
     * @param temporadas o número de temporadas da série
     */
    public Serie(String nome, int ano, int temporadas) {
        super(nome, ano);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    /**
     * Calcula a duração total da série em minutos.
     * Isso é feito multiplicando o número de temporadas, episódios por temporada e
     * minutos por episódio.
     */

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }
}
