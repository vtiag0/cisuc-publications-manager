import java.io.Serializable;
import java.util.ArrayList;

class LivroArtigo extends Livro implements Serializable {

    private String nomeConferencia;
    private String numeroArtigo;
    private static short nLivrosArtigo = 0;

    public LivroArtigo(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, String editora, String isbn, String nomeConferencia,
            String numeroArtigo) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, editora, isbn);
        this.nomeConferencia = nomeConferencia;
        this.numeroArtigo = numeroArtigo;
        ++nLivrosArtigo;
    }

    public short getContagem() {
        return nLivrosArtigo;
    }
}