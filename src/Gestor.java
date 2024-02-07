import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Gestor {

    private String caminhoFicheirosTxt = ".\\db\\";
    private String caminhoFicheirosBin = ".\\bin\\";
    private String ficheiroTxtGrupos = "gruposInvestigacao.txt";
    private String ficheiroTxtInvestigadores = "investigadores.txt";
    private String ficheiroTxtPublicacoes = "publicacoes.txt";
    private String ficheiroObjGrupos = "gruposInvestigacao.obj";
    private String ficheiroObjInvestigadores = "investigadores.obj";
    private String ficheiroObjPublicacoes = "publicacoes.obj";

    public Gestor() {
    }

    public void printMenu() {
        System.out.println("---------- MENU ----------");
        System.out.println("1 -> Indicadores gerais do CISUC.");
        System.out.println("6 -> Sair.");
    }

    public ArrayList<Investigador> leFicheiroTxtInvestigadores() {

        ArrayList<Investigador> investigadores = new ArrayList<>();
        File f = new File(caminhoFicheirosTxt + ficheiroTxtInvestigadores);

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String[] investigadoresInfo;
                while ((line = br.readLine()) != null) {
                    investigadoresInfo = line.split(",");
                    if (investigadoresInfo.length == 5) {
                        investigadores.add(new MembroEfetivo(investigadoresInfo[0], investigadoresInfo[1],
                                investigadoresInfo[2], investigadoresInfo[3], investigadoresInfo[4]));
                    } else {
                        investigadores.add(new Estudante(investigadoresInfo[0], investigadoresInfo[1],
                                investigadoresInfo[2], investigadoresInfo[3], investigadoresInfo[4],
                                investigadoresInfo[5]));
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
                return null;
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
                return null;
            }
        } else {
            System.out.println("Ficheiro não existe.");
            return null;
        }
        return investigadores;
    }

    public ArrayList<GrupoInvestigacao> leFicheiroTxtGupos() {

        ArrayList<GrupoInvestigacao> grupos = new ArrayList<>();
        File f = new File(caminhoFicheirosTxt + ficheiroTxtGrupos);

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String[] gruposInfo;
                while ((line = br.readLine()) != null) {
                    gruposInfo = line.split(",");
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
                return null;
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
                return null;
            }
        } else {
            System.out.println("Ficheiro não existe.");
            return null;
        }
        return grupos;
    }

    public ArrayList<Publicacao> leFicheiroTxtPublicacoes() {

        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        File f = new File(caminhoFicheirosTxt + ficheiroTxtPublicacoes);

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String[] publicacoesInfo;
                while ((line = br.readLine()) != null) {
                    publicacoesInfo = line.split(",");
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
                return null;
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
                return null;
            }
        } else {
            System.out.println("Ficheiro não existe.");
            return null;
        }
        return publicacoes;
    }
}
