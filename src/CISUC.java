import java.io.Serializable;
import java.util.ArrayList;

class CISUC implements Serializable {

    private ArrayList<Investigador> investigadores;
    private ArrayList<GrupoInvestigacao> grupos;
    private ArrayList<Publicacao> publicacoes;

    public CISUC() {
        grupos = new ArrayList<>();
        investigadores = new ArrayList<>();
        publicacoes = new ArrayList<>();
    }

    public ArrayList<Investigador> getInvestigadores() {
        return this.investigadores;
    }

    public ArrayList<GrupoInvestigacao> getGrupos() {
        return this.grupos;
    }

    public ArrayList<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }

    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public void setGrupos(ArrayList<GrupoInvestigacao> grupos) {
        this.grupos = grupos;
    }

    public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

}
