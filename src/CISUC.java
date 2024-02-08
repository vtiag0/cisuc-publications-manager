import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class CISUC implements Serializable {

    private ArrayList<Investigador> investigadores;
    private ArrayList<GrupoInvestigacao> grupos;
    private ArrayList<Publicacao> publicacoes;

    public CISUC() {
        grupos = new ArrayList<>();
        investigadores = new ArrayList<>();
        publicacoes = new ArrayList<>();
    }

    public ArrayList<Investigador> getInvestigadores() {
        return this.investigadores;
    }

    public ArrayList<GrupoInvestigacao> getGrupos() {
        return this.grupos;
    }

    public ArrayList<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }

    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public void setGrupos(ArrayList<GrupoInvestigacao> grupos) {
        this.grupos = grupos;
    }

    public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public Investigador getInvestigador(String nome) {
        for (Investigador inv : this.investigadores) {
            if (inv.getNome().equals(nome)) {
                return inv;
            }
        }
        return null;
    }

    public GrupoInvestigacao getGrupo(String acronimo) {
        for (GrupoInvestigacao grupo : this.grupos) {
            if (grupo.getAcronimo().equals(acronimo)) {
                return grupo;
            }
        }
        return null;
    }

    public short nEstudantes() {
        short n = 0;
        for (Investigador inv : this.investigadores) {
            if (!inv.getTipo()) {
                n++;
            }
        }
        return n;
    }

    public short nMembrosEfetivos() {
        short n = 0;
        for (Investigador inv : this.investigadores) {
            if (inv.getTipo()) {
                n++;
            }
        }
        return n;
    }

    public short nPublicacoes5Anos() {
        short n = 0;
        LocalDate data = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String dataFormatada = data.format(myFormatObj);
        int dataAgora = Integer.parseInt(dataFormatada);
        int dataPublicacao;
        try {
            for (Publicacao pub : this.publicacoes) {
                dataPublicacao = Integer.parseInt(pub.getAnoPublicacao().split("/")[2]);
                if (dataAgora - dataPublicacao >= 5) {
                    n++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Erro a formatar data.");
            return -1;
        }
        return n;
    }

    public short nPublicaoTipo(String tipo) {
        short n = 0;
        for (Publicacao pub : this.publicacoes) {
            if (pub.getTipo().equals(tipo)) {
                n++;
            }
        }
        return n;
    }

    public boolean investigadorIsInGrupo(String nome, GrupoInvestigacao grupo) {
        for (Investigador inv : grupo.getInvestigadores()) {
            if (nome.equals(inv.getNome())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Publicacao> getPublicacoesGrupo(String acronimo) {
        GrupoInvestigacao grupo = this.getGrupo(acronimo);
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        for (Publicacao pub : this.publicacoes) {
            for (Investigador inv : pub.getAutores()) {
                if (investigadorIsInGrupo(inv.getNome(), grupo)) {
                    publicacoes.add(pub);
                    break;
                }
            }
        }
        return publicacoes;
    }

    public ArrayList<Publicacao> organizaPublicacoes(ArrayList<Publicacao> publicacoes) {
        ArrayList<Publicacao> organizado = publicacoes;
        Publicacao aux;
        // Por ano publicacao
        for (int i = 0; i < organizado.size(); i++) {
            for (int j = 0; j < organizado.size(); j++) {
                if (Integer.parseInt(organizado.get(i).getAnoPublicacao().split("/")[2]) > Integer
                        .parseInt(organizado.get(j).getAnoPublicacao().split("/")[2])) {
                    aux = organizado.get(i);
                    organizado.set(i, organizado.get(j));
                    organizado.set(j, aux);
                }
                if (Integer.parseInt(organizado.get(i).getAnoPublicacao().split("/")[2]) == Integer
                        .parseInt(organizado.get(j).getAnoPublicacao().split("/")[2])) {
                    // Organiza por tipo
                    if (organizado.get(i).getTipo().length() > organizado.get(j).getTipo().length()) {
                        aux = organizado.get(i);
                        organizado.set(i, organizado.get(j));
                        organizado.set(j, aux);
                    }
                    if (organizado.get(i).getTipo().length() == organizado.get(j).getTipo().length()) {
                        // Organiza por fator impacto
                        if (organizado.get(i).getAudiencia() > organizado.get(j).getAudiencia()) {
                            aux = organizado.get(i);
                            organizado.set(i, organizado.get(j));
                            organizado.set(j, aux);
                        }
                    }
                }
            }
        }
        return organizado;
    }

    public ArrayList<Publicacao> getPublicacoesGrupo5Anos(String acronimo) {
        GrupoInvestigacao grupo = this.getGrupo(acronimo);
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        LocalDate data = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String dataFormatada = data.format(myFormatObj);
        int dataAgora = Integer.parseInt(dataFormatada);
        int dataPublicacao;
        for (int i = 0; i < grupo.getPublicacoes().size(); i++) {
            dataPublicacao = Integer.parseInt(grupo.getPublicacoes().get(i).getAnoPublicacao().split("/")[2]);
            if (dataAgora - dataPublicacao <= 5) {
                publicacoes.add(grupo.getPublicacoes().get(i));
            }
        }
        publicacoes = organizaPublicacoes(publicacoes);
        return publicacoes;
    }

    public ArrayList<Investigador> getInvestigadoresGrupo(String acronimo) {
        ArrayList<Investigador> investigadores = new ArrayList<>();
        for (Investigador inv : this.investigadores) {
            if (inv.getAcronimoGrupo().equals(acronimo)) {
                investigadores.add(inv);
            }
        }
        return investigadores;
    }

    public ArrayList<Investigador> getEstudantesFromGrupo(String acronimo) {
        ArrayList<Investigador> estudantes = new ArrayList<>();
        GrupoInvestigacao grupo = getGrupo(acronimo);
        for (Investigador inv : grupo.getInvestigadores()) {
            if (!inv.getTipo()) {
                estudantes.add(inv);
            }
        }
        return estudantes;
    }

    public ArrayList<Investigador> getEfetivosFromGrupo(String acronimo) {
        ArrayList<Investigador> membrosEfetivos = new ArrayList<>();
        GrupoInvestigacao grupo = getGrupo(acronimo);
        for (Investigador inv : grupo.getInvestigadores()) {
            if (inv.getTipo()) {
                membrosEfetivos.add(inv);
            }
        }
        return membrosEfetivos;
    }

    public boolean isInvestigadorInArray(String nome, ArrayList<Investigador> investigadores) {
        for (Investigador inv : investigadores) {
            if (nome.equals(inv.getNome())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Publicacao> getPublicacoesInvestigador(String nome) {
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        for (Publicacao pub : this.publicacoes) {
            if (isInvestigadorInArray(nome, pub.getAutores())) {
                publicacoes.add(pub);
            }
        }
        return publicacoes;
    }

    public int nArtigosConferencias(ArrayList<Publicacao> publicacoes) {
        int n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Artigo")) {
                ++n;
            }
        }
        return n;
    }

    public int nArtigosRevista(ArrayList<Publicacao> publicacoes) {
        int n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Revista")) {
                ++n;
            }
        }
        return n;
    }

    public int nLivro(ArrayList<Publicacao> publicacoes) {
        int n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Livro")) {
                ++n;
            }
        }
        return n;
    }

    public int nLivroArtigos(ArrayList<Publicacao> publicacoes) {
        int n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Livro Artigos")) {
                ++n;
            }
        }
        return n;
    }

    public int nLivroCapitulos(ArrayList<Publicacao> publicacoes) {
        int n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Capitulo")) {
                ++n;
            }
        }
        return n;
    }

}
