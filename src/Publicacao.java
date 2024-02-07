import java.time.LocalDate;
import java.util.ArrayList;

abstract class Publicacao {

    protected ArrayList<Investigador> autores;
    protected String titulo;
    protected ArrayList<String> palavrasChave;
    protected String anoPublicacao;
    protected int audiencia;
    private static short nPublicacoes = 0;

    protected Publicacao(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            String anoPublicacao, int audiencia) {
        this.autores = autores;
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.anoPublicacao = anoPublicacao;
        this.audiencia = audiencia;
        ++nPublicacoes;
    }

    // public abstract char fatorImpacto();

}
