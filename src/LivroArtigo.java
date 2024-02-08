import java.io.Serializable;
import java.util.ArrayList;

class LivroArtigo extends Livro implements Serializable {

    private String nomeConferencia;
    private String numeroArtigo;

    public LivroArtigo(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, ArrayList<Investigador> autores, String editora, String isbn,
            String nomeConferencia,
            String numeroArtigo) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, autores, editora, isbn);
        this.nomeConferencia = nomeConferencia;
        this.numeroArtigo = numeroArtigo;
    }

}