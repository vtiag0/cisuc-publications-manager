import java.time.LocalDate;
import java.util.ArrayList;

class Livro extends Publicacao {

    protected String editora;
    protected String isbn;

    public Livro(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            LocalDate anoPublicacao, int audiencia, String editora, String isbn) {
        super(autores, titulo, palavrasChave, anoPublicacao, audiencia);
        this.editora = editora;
        this.isbn = isbn;
    }

}
