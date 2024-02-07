import java.util.ArrayList;

class GrupoInvestigacao {

    private String nome;
    private String acronimo;
    private MembroEfetivo investigadorResponsavel;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Publicacao> publicacoes;

    public GrupoInvestigacao(String nome, String acronimo, MembroEfetivo investigadorResponsavel) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.investigadorResponsavel = investigadorResponsavel;
        this.investigadores = new ArrayList<>();
        this.publicacoes = new ArrayList<>();
    }

}
