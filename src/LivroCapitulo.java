import java.util.ArrayList;

class LivroCapitulo extends Livro {

    private String nomeCapitulo;
    private short paginaInicio;
    private short paginaFinal;

    public LivroCapitulo(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, ArrayList<Investigador> autores, String editora, String isbn,
            String nomeCapitulo,
            short paginaInicio, short paginaFinal) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia, autores, editora, isbn);
        this.nomeCapitulo = nomeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFinal = paginaFinal;
    }

    public String fatorImpacto() {
        if (audiencia >= 7500) {
            return "A";
        } else if (2500 <= audiencia && audiencia < 7500) {
            return "B";
        } else {
            return "C";
        }
    };

    public String toString() {
        return this.titulo + ", " + this.getAnoPublicacao() + ", " + this.fatorImpacto().toString();
    }

}
