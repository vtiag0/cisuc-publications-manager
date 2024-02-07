import java.io.Serializable;
import java.util.ArrayList;

abstract class Investigador implements Serializable {

    protected String nome;
    protected String email;
    protected String acronimoGrupo;
    protected boolean tipo;

    protected Investigador(String nome, String email, String acronimoGrupo, boolean tipo) {
        this.nome = nome;
        this.email = email;
        this.acronimoGrupo = acronimoGrupo;
        this.tipo = tipo;
    }

    public abstract short getContagem();

    public boolean getTipo() {
        return this.tipo;
    }
}
