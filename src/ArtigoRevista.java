import java.util.ArrayList;

class ArtigoRevista extends Publicacao {

    private String nomeRevista;
    private String data;

    public ArtigoRevista(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, ArrayList<Investigador> autores, String nomeRevista, String data) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, autores);
        this.nomeRevista = nomeRevista;
        this.data = data;
    }

    public String fatorImpacto() {
        if (audiencia >= 1000) {
            return "A";
        } else if (500 <= audiencia && audiencia < 1000) {
            return "B";
        } else {
            return "C";
        }
    };

    public String toString() {
        return this.titulo + ", " + this.getAnoPublicacao() + ", " + this.fatorImpacto().toString();
    }

}
