import br.com.alura.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();

        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.setIncluidoNoPlano(true);
//----------------------------------------------------------------------------------------------------------------------
        meuFilme.exibeFichaTecnica();
//----------------------------------------------------------------------------------------------------------------------
        meuFilme.avalia(9);
        meuFilme.avalia(8);
        meuFilme.avalia(9);
//----------------------------------------------------------------------------------------------------------------------
        System.out.printf("Média de Avaliações: %.2f\n", meuFilme.pegaMedia());
//----------------------------------------------------------------------------------------------------------------------
        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());
//----------------------------------------------------------------------------------------------------------------------
    }
}