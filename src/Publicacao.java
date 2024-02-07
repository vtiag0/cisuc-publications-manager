import java.io.Serializable;
import java.util.ArrayList;

abstract class Publicacao implements Serializable {

    protected String tipo;
    protected ArrayList<Investigador> autores;
    protected String titulo;
    protected String palavrasChave;
    protected String resumo;
    protected String anoPublicacao;
    protected int audiencia;
    private static short nPublicacoes = 0;

    protected Publicacao(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia) {
        this.tipo = tipo;
        this.autores = new ArrayList<>();
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.anoPublicacao = anoPublicacao;
        this.audiencia = audiencia;
        ++nPublicacoes;
    }

    public abstract char fatorImpacto();

    public String getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void addAutor(Investigador investigador) {
        this.autores.add(investigador);
    }
}
