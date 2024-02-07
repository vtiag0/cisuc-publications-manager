import java.io.Serializable;
import java.util.ArrayList;

class ArtigoConferencia extends Publicacao implements Serializable {

    private String nomeConferencia;
    private String data;
    private String local;
    private static short nArtigosConferencia = 0;

    public ArtigoConferencia(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, String nomeConferencia, String data,
            String local) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia);
        this.nomeConferencia = nomeConferencia;
        this.data = data;
        this.local = local;
        ++nArtigosConferencia;
    }

    public char fatorImpacto() {
        if (audiencia >= 500) {
            return 'A';
        } else if (200 <= audiencia && audiencia < 500) {
            return 'B';
        } else {
            return 'C';
        }
    };

    public short getContagem() {
        return nArtigosConferencia;
    };

}
