import java.time.LocalDate;
import java.util.ArrayList;

class LivroCapitulo extends Livro {

    private String nomeCapitulo;
    private short paginaInicio;
    private short paginaFinal;

    public LivroCapitulo(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            LocalDate anoPublicacao, int audiencia, String editora, String isbn, String nomeCapitulo,
            short paginaInicio, short paginaFinal) {
        super(autores, titulo, palavrasChave, anoPublicacao, audiencia, editora, isbn);
        this.nomeCapitulo = nomeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFinal = paginaFinal;
    }

}
