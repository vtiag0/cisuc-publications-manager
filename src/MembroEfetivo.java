class MembroEfetivo extends Investigador {

    private String gabinete;
    private String telefone;

    public MembroEfetivo(String nome, String email, String acronimoGrupo, String gabinete, String telefone) {
        super(nome, email, acronimoGrupo, true);
        this.gabinete = gabinete;
        this.telefone = telefone;
    }

    public String toString() {
        return this.nome + ", " + "Efetivo, " + "Professor " + this.nome;
    }
}
