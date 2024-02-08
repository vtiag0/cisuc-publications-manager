import java.io.Serializable;
import java.util.ArrayList;

class ArtigoConferencia extends Publicacao implements Serializable {

    private String nomeConferencia;
    private String data;
    private String local;

    public ArtigoConferencia(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, ArrayList<Investigador> autores, String nomeConferencia, String data,
            String local) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, autores);
        this.nomeConferencia = nomeConferencia;
        this.data = data;
        this.local = local;
    }

    public String fatorImpacto() {
        if (audiencia >= 500) {
            return "A";
        } else if (200 <= audiencia && audiencia < 500) {
            return "B";
        } else {
            return "C";
        }
    };

    public String toString() {
        return this.titulo + ", " + this.getAnoPublicacao() + ", " + this.fatorImpacto().toString();
    }

}
