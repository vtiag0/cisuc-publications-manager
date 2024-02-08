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

    public String getAcronimo() {
        return this.acronimo;
    }

    public ArrayList<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }

    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public ArrayList<Investigador> getInvestigadores() {
        return this.investigadores;
    }

    public String toString() {
        return this.acronimo + " " + this.investigadores.toString() + " " + this.publicacoes.toString();
    }

}
