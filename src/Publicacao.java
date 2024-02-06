import java.time.LocalDate;
import java.util.ArrayList;

abstract class Publicacao {

    protected ArrayList<Investigador> autores;
    protected String titulo;
    protected ArrayList<String> palavrasChave;
    protected LocalDate anoPublicacao;
    protected int audiencia;

    protected Publicacao(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            LocalDate anoPublicacao, int audiencia) {
        this.autores = autores;
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.anoPublicacao = anoPublicacao;
        this.audiencia = audiencia;
    }

}
