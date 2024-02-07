import java.time.LocalDate;
import java.util.ArrayList;

class ArtigoConferencia extends Publicacao {

    private String resumo;
    private String nomeConferencia;
    private String data;
    private String local;
    private static short nArtigosConferencia = 0;

    public ArtigoConferencia(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            String anoPublicacao, int audiencia, String resumo, String nomeConferencia, String data,
            String local) {
        super(autores, titulo, palavrasChave, anoPublicacao, audiencia);
        this.resumo = resumo;
        this.nomeConferencia = nomeConferencia;
        this.data = data;
        this.local = local;
        ++nArtigosConferencia;
    }

}
