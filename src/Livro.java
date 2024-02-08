import java.io.Serializable;
import java.util.ArrayList;

class Livro extends Publicacao implements Serializable {

    protected String editora;
    protected String isbn;
    private static short nLivros = 0;

    public Livro(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, ArrayList<Investigador> autores, String editora, String isbn) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, autores);
        this.editora = editora;
        this.isbn = isbn;
        ++nLivros;
    }

    public String fatorImpacto() {
        if (audiencia >= 10000) {
            return "A";
        } else if (5000 <= audiencia && audiencia < 10000) {
            return "B";
        } else {
            return "C";
        }
    };

    public short getContagem() {
        return nLivros;
    }

    public String toString() {
        return this.titulo + ", " + this.getAnoPublicacao() + ", " + this.fatorImpacto().toString();
    }

}
