import java.time.LocalDate;

class MembroEfetivo extends Investigador {

    private String gabinete;
    private String telefone;

    public MembroEfetivo(String nome, String email, GrupoInvestigacao grupo, String gabinete, String telefone) {
        super(nome, email, grupo);
        this.gabinete = gabinete;
        this.telefone = telefone;
    }
}
