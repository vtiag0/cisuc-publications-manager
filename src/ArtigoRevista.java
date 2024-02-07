import java.io.Serializable;
import java.util.ArrayList;

class ArtigoRevista extends Publicacao implements Serializable {

    private String nomeRevista;
    private String data;
    private static short nArtigosRevista = 0;

    public ArtigoRevista(String tipo, String titulo, String palavrasChave, String resumo,
            String anoPublicacao, int audiencia, String nomeRevista, String data) {
        super(tipo, titulo, palavrasChave, resumo, anoPublicacao, audiencia);
        this.nomeRevista = nomeRevista;
        this.data = data;
        ++nArtigosRevista;
    }

    public char fatorImpacto() {
        if (audiencia >= 1000) {
            return 'A';
        } else if (500 <= audiencia && audiencia < 1000) {
            return 'B';
        } else {
            return 'C';
        }
    };

    public short getContagem() {
        return nArtigosRevista;
    }

}
