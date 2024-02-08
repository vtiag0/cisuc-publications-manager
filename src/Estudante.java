class Estudante extends Investigador {

    private String tituloTese;
    private String dataConclusao;
    private String nomeOrientador;

    public Estudante(String nome, String email, String acronimoGrupo, String tituloTese,
            String dataConclusao, String nomeOrientador) {
        super(nome, email, acronimoGrupo, false);
        this.tituloTese = tituloTese;
        this.dataConclusao = dataConclusao;
        this.nomeOrientador = nomeOrientador;
    }

    public String toString() {
        String[] nome = this.nome.split(" ");
        return this.nome + ", " + "Estudante, " + nome[0].charAt(0) + ". " + nome[nome.length - 1];
    }

}
