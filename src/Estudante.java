import java.io.Serializable;
import java.time.LocalDate;

class Estudante extends Investigador implements Serializable {

    private String tituloTese;
    private String dataConclusao;
    private String nomeOrientador;
    private static short nEstudantes = 0;

    public Estudante(String nome, String email, String acronimoGrupo, String tituloTese,
            String dataConclusao, String nomeOrientador) {
        super(nome, email, acronimoGrupo, false);
        this.tituloTese = tituloTese;
        this.dataConclusao = dataConclusao;
        this.nomeOrientador = nomeOrientador;
        ++nEstudantes;
    }

    public short getContagem() {
        return nEstudantes;
    }

}
