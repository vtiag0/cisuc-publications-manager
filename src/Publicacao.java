import java.io.Serializable;
import java.util.ArrayList;

abstract class Publicacao implements Serializable {

    protected String tipo;
    protected String titulo;
    protected String palavrasChave;
    protected String resumo;
    protected String anoPublicacao;
    protected int audiencia;
    protected ArrayList<Investigador> autores;

    protected Publicacao(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, ArrayList<Investigador> autores) {
        this.tipo = tipo;
        this.autores = new ArrayList<>();
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.anoPublicacao = anoPublicacao;
        this.audiencia = audiencia;
        this.autores = autores;
    }

    public abstract String fatorImpacto();

    public String getTitulo() {
        return this.titulo;
    }

    public String getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getAudiencia() {
        return this.audiencia;
    }

    public ArrayList<Investigador> getAutores() {
        return this.autores;
    }

    public void addAutor(Investigador investigador) {
        this.autores.add(investigador);
    }

    public abstract String toString();
}
