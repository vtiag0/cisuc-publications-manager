import java.time.LocalDate;
import java.util.ArrayList;

class ArtigoRevista extends Publicacao {

    private String nomeRevista;
    private String data;
    private static short nArtigosConferencia = 0;

    public ArtigoRevista(ArrayList<Investigador> autores, String titulo, ArrayList<String> palavrasChave,
            String anoPublicacao, int audiencia, String nomeRevista, String data) {
        super(autores, titulo, palavrasChave, anoPublicacao, audiencia);
        this.nomeRevista = nomeRevista;
        this.data = data;
        ++nArtigosConferencia;
    }

}
