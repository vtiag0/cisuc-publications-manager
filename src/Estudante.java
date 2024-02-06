import java.time.LocalDate;

class Estudante extends Investigador {

    private String tituloTese;
    private LocalDate dataConclusao;
    private Investigador orientador;

    public Estudante(String nome, String email, GrupoInvestigacao grupo, String tituloTese, LocalDate dataConclusao,
            Investigador orientador) {
        super(nome, email, grupo);
        this.tituloTese = tituloTese;
        this.dataConclusao = dataConclusao;
        this.orientador = orientador;
    }

}
