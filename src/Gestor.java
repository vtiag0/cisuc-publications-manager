import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Gestor {

    private String caminhoFicheirosTxt = ".\\db\\";
    private String caminhoFicheirosBin = ".\\bin\\";
    private String ficheiroTxtGrupos = "gruposInvestigacao.txt";
    private String ficheiroTxtInvestigadores = "investigadores.txt";
    private String ficheiroTxtPublicacoes = "publicacoes.txt";
    private String ficheiroObjCISUC = "cisuc.obj";

    public Gestor() {
    }

    public void printMenu() {
        System.out.println(" --------------- MENU ---------------");
        System.out.println("| 1 -> Indicadores gerais do CISUC.  |");
        System.out.println("| 6 -> Sair.                         |");
        System.out.println(" ------------------------------------");
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
                    grupos.add(new GrupoInvestigacao(gruposInfo[0], gruposInfo[1], gruposInfo[2]));
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
                    if (publicacoesInfo[0].equals("Livro")) {
                        publicacoes.add(new Livro(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]),
                                publicacoesInfo[6], publicacoesInfo[7]));
                    } else if (publicacoesInfo[0].equals("Capitulo")) {
                        publicacoes.add(new LivroCapitulo(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]),
                                publicacoesInfo[6],
                                publicacoesInfo[7], publicacoesInfo[8], Short.parseShort(publicacoesInfo[9]),
                                Short.parseShort(publicacoesInfo[10])));
                    } else if (publicacoesInfo[0].equals("Livro Artigos")) {
                        publicacoes.add(new LivroArtigo(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]),
                                publicacoesInfo[6],
                                publicacoesInfo[7], publicacoesInfo[8], publicacoesInfo[9]));
                    } else if (publicacoesInfo[0].equals("Revista")) {
                        publicacoes.add(new ArtigoRevista(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]),
                                publicacoesInfo[6],
                                publicacoesInfo[7]));
                    } else if (publicacoesInfo[0].equals("Artigo")) {
                        publicacoes.add(new ArtigoConferencia(publicacoesInfo[0], publicacoesInfo[1],
                                publicacoesInfo[2], publicacoesInfo[3], publicacoesInfo[4],
                                Integer.parseInt(publicacoesInfo[5]), publicacoesInfo[6], publicacoesInfo[7],
                                publicacoesInfo[8]));
                    } else {
                        System.out.println("Erro a ler ficheiro de texto das publicacoes.");
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto publicacoes.");
                return null;
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto publicacoes.");
                return null;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Erro ao ler ficheiro de texto publicacoes. Ficheiro mal formatado.");
                return null;
            }
        } else {
            System.out.println("Ficheiro publicacoes.txt não existe.");
            return null;
        }
        return publicacoes;
    }

    public CISUC leFicheiroObjCISUC() {
        File f = new File(caminhoFicheirosBin + ficheiroObjCISUC);
        CISUC cisuc;
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                cisuc = (CISUC) ois.readObject();
                ois.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
                return null;
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro.");
                return null;
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
                return null;
            }
        } else {
            System.out.println("Ficheiro objetos não existe.");
            return null;
        }
        return cisuc;
    }

    public void escreveFicheiroObjCISUC(CISUC cisuc) {
        File d = new File(caminhoFicheirosBin);
        File f = new File(caminhoFicheirosBin + ficheiroObjCISUC);
        try {
            if (!d.exists()) {

                d.mkdir();
            }
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cisuc);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro objetos.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro objetos.");
        }
    }

    public CISUC initApp() {
        CISUC cisuc;
        if (leFicheiroObjCISUC() == null) {
            ArrayList<Investigador> investigadores = leFicheiroTxtInvestigadores();
            ArrayList<GrupoInvestigacao> grupos = leFicheiroTxtGupos();
            ArrayList<Publicacao> publicacoes = leFicheiroTxtPublicacoes();
            cisuc = new CISUC();
            cisuc.setInvestigadores(investigadores);
            cisuc.setGrupos(grupos);
            cisuc.setPublicacoes(publicacoes);
        } else {
            cisuc = leFicheiroObjCISUC();
        }
        return cisuc;
    }

    public void closeApp(CISUC cisuc) {
        escreveFicheiroObjCISUC(cisuc);
    }

    public short nEstudantes(ArrayList<Investigador> investigadores) {
        short n = 0;
        for (Investigador inv : investigadores) {
            if (!inv.getTipo()) {
                n++;
            }
        }
        return n;
    }

    public short nMembrosEfetivos(ArrayList<Investigador> investigadores) {
        short n = 0;
        for (Investigador inv : investigadores) {
            if (inv.getTipo()) {
                n++;
            }
        }
        return n;
    }

    public short nPublicacoes5Anos(ArrayList<Publicacao> publicacoes) {
        short n = 0;
        LocalDate data = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String dataFormatada = data.format(myFormatObj);
        int dataAgora = Integer.parseInt(dataFormatada);
        int dataPublicacao;
        try {
            for (Publicacao pub : publicacoes) {
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

    public short nLivros(ArrayList<Publicacao> publicacoes) {
        short n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Livro")) {
                n++;
            }
        }
        return n;
    }

    public short nLivrosCapitulo(ArrayList<Publicacao> publicacoes) {
        short n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Capitulo")) {
                n++;
            }
        }
        return n;
    }

    public short nLivroArtigo(ArrayList<Publicacao> publicacoes) {
        short n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Livro Artigos")) {
                n++;
            }
        }
        return n;
    }

    public short nArtigosRevista(ArrayList<Publicacao> publicacoes) {
        short n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Revista")) {
                n++;
            }
        }
        return n;
    }

    public short nArtigosConferencia(ArrayList<Publicacao> publicacoes) {
        short n = 0;
        for (Publicacao pub : publicacoes) {
            if (pub.getTipo().equals("Artigo")) {
                n++;
            }
        }
        return n;
    }

}
