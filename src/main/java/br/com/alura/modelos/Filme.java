package br.com.alura.modelos;

import br.com.alura.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return String.format("""

                ****************************
                Filme: %s
                Ano de Lançamento: %d
                ****************************
                """, getNome(), getAnoDeLancamento());
    }
}
