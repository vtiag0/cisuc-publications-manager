abstract class Investigador {

    protected String nome;
    protected String email;
    protected String acronimoGrupo;
    private short nInvestigadores = 0;

    protected Investigador(String nome, String email, String acronimoGrupo) {
        this.nome = nome;
        this.email = email;
        this.acronimoGrupo = acronimoGrupo;
        ++nInvestigadores;
    }

}
