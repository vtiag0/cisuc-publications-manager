import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

class LivroCapitulo extends Livro implements Serializable {

    private String nomeCapitulo;
    private short paginaInicio;
    private short paginaFinal;
    private static short nLivrosCapitulo;

    public LivroCapitulo(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, String editora, String isbn, String nomeCapitulo,
            short paginaInicio, short paginaFinal) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, editora, isbn);
        this.nomeCapitulo = nomeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFinal = paginaFinal;
        ++nLivrosCapitulo;
    }

    public char fatorImpacto() {
        if (audiencia >= 7500) {
            return 'A';
        } else if (2500 <= audiencia && audiencia < 7500) {
            return 'B';
        } else {
            return 'C';
        }
    };

    public short getContagem() {
        return nLivrosCapitulo;
    }

}
