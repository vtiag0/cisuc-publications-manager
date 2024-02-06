import java.time.LocalDate;

class ArtigoConferencia {

    private String resumo;
    private String nomeConferencia;
    private LocalDate data;
    private String local;

    public ArtigoConferencia(String resumo, String nomeConferencia, LocalDate data, String local) {
        this.resumo = resumo;
        this.nomeConferencia = nomeConferencia;
        this.data = data;
        this.local = local;
    }

}
