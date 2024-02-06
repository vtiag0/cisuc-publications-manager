import java.time.LocalDate;
import java.util.ArrayList;

class LivroArtigo extends Livro {

    private String nomeConferencia;
    private String numeroArtigo;

    public LivroArtigo(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            LocalDate anoPublicacao, int audiencia, String editora, String isbn, String nomeConferencia,
            String numeroArtigo) {
        super(autores, titulo, palavrasChave, anoPublicacao, audiencia, editora, isbn);
        this.nomeConferencia = nomeConferencia;
        this.numeroArtigo = numeroArtigo;

    }

}