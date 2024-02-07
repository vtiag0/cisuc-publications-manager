import java.time.LocalDate;
import java.util.ArrayList;

class Livro extends Publicacao {

    protected String editora;
    protected String isbn;
    private static short nLivros = 0;

    public Livro(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            String anoPublicacao, int audiencia, String editora, String isbn) {
        super(autores, titulo, palavrasChave, anoPublicacao, audiencia);
        this.editora = editora;
        this.isbn = isbn;
        ++nLivros;
    }

}
