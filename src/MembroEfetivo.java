import java.time.LocalDate;

class MembroEfetivo extends Investigador {

    private String gabinete;
    private String telefone;
    private static short nEfetivos = 0;

    public MembroEfetivo(String nome, String email, String acronimoGrupo, String gabinete, String telefone) {
        super(nome, email, acronimoGrupo);
        this.gabinete = gabinete;
        this.telefone = telefone;
        ++nEfetivos;
    }
}
