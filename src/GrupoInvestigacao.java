import java.io.Serializable;
import java.util.ArrayList;

class GrupoInvestigacao implements Serializable {

    private String nome;
    private String acronimo;
    private String investigadorResponsavel;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Publicacao> publicacoes;

    public GrupoInvestigacao(String nome, String acronimo, String investigadorResponsavel) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.investigadorResponsavel = investigadorResponsavel;
        this.investigadores = new ArrayList<>();
        this.publicacoes = new ArrayList<>();
    }

}
