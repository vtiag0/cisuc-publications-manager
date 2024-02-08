import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        System.out.println(" ------------------ MENU ------------------");
        System.out.println("| 1 -> Indicadores gerais do CISUC.        |");
        System.out.println(
                "| 2 -> Publicações de um grupo de          |\n| investigação, dos últimos 5 anos,        |\n| organizadas por ano, por tipo de         |\n| publicação e por fator de impacto.       |");
        System.out.println("| 6 -> Sair.                               |");
        System.out.println(" ------------------------------------------");
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

    public ArrayList<Publicacao> leFicheiroTxtPublicacoes(CISUC cisuc) {

        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        File f = new File(caminhoFicheirosTxt + ficheiroTxtPublicacoes);

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String[] publicacoesInfo;
                ArrayList<Investigador> aux;
                while ((line = br.readLine()) != null) {
                    publicacoesInfo = line.split(",");
                    aux = new ArrayList<>();
                    if (publicacoesInfo[0].equals("Livro")) {
                        for (String nome : publicacoesInfo[8].split("/")) {
                            aux.add(cisuc.getInvestigador(nome));
                        }
                        publicacoes.add(new Livro(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]), aux,
                                publicacoesInfo[6], publicacoesInfo[7]));
                    } else if (publicacoesInfo[0].equals("Capitulo")) {
                        for (String nome : publicacoesInfo[11].split("/")) {
                            aux.add(cisuc.getInvestigador(nome));
                        }
                        publicacoes.add(new LivroCapitulo(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]), aux,
                                publicacoesInfo[6],
                                publicacoesInfo[7], publicacoesInfo[8], Short.parseShort(publicacoesInfo[9]),
                                Short.parseShort(publicacoesInfo[10])));
                    } else if (publicacoesInfo[0].equals("Livro Artigos")) {
                        for (String nome : publicacoesInfo[10].split("/")) {
                            aux.add(cisuc.getInvestigador(nome));
                        }
                        publicacoes.add(new LivroArtigo(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]), aux,
                                publicacoesInfo[6],
                                publicacoesInfo[7], publicacoesInfo[8], publicacoesInfo[9]));
                    } else if (publicacoesInfo[0].equals("Revista")) {
                        for (String nome : publicacoesInfo[8].split("/")) {
                            aux.add(cisuc.getInvestigador(nome));
                        }
                        publicacoes.add(new ArtigoRevista(publicacoesInfo[0], publicacoesInfo[1], publicacoesInfo[2],
                                publicacoesInfo[3], publicacoesInfo[4], Integer.parseInt(publicacoesInfo[5]), aux,
                                publicacoesInfo[6], publicacoesInfo[7]));
                    } else if (publicacoesInfo[0].equals("Artigo")) {
                        for (String nome : publicacoesInfo[9].split("/")) {
                            aux.add(cisuc.getInvestigador(nome));
                        }
                        publicacoes.add(new ArtigoConferencia(publicacoesInfo[0], publicacoesInfo[1],
                                publicacoesInfo[2], publicacoesInfo[3], publicacoesInfo[4],
                                Integer.parseInt(publicacoesInfo[5]), aux, publicacoesInfo[6], publicacoesInfo[7],
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
            System.out.println("A ler do ficheiro de texto...");
            cisuc = new CISUC();
            ArrayList<Investigador> investigadores = leFicheiroTxtInvestigadores();
            cisuc.setInvestigadores(investigadores);
            ArrayList<GrupoInvestigacao> grupos = leFicheiroTxtGupos();
            cisuc.setGrupos(grupos);
            // Set do investigadores de cada grupo
            for (int i = 0; i < cisuc.getGrupos().size(); i++) {
                cisuc.getGrupos().get(i)
                        .setInvestigadores(cisuc.getInvestigadoresGrupo(cisuc.getGrupos().get(i).getAcronimo()));
            }
            ArrayList<Publicacao> publicacoes = leFicheiroTxtPublicacoes(cisuc);
            cisuc.setPublicacoes(publicacoes);
            // Set das publicacoes de cada grupo
            for (int i = 0; i < cisuc.getGrupos().size(); i++) {
                cisuc.getGrupos().get(i)
                        .setPublicacoes(cisuc.getPublicacoesGrupo(cisuc.getGrupos().get(i).getAcronimo()));
            }
        } else {
            System.out.println("A ler do ficheiro de objetos...");
            cisuc = leFicheiroObjCISUC();
        }
        return cisuc;
    }

    public void closeApp(CISUC cisuc) {
        escreveFicheiroObjCISUC(cisuc);
    }

}
