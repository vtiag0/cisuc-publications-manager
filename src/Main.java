import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            CISUC cisuc = new CISUC();
            Gestor gestor = new Gestor();
            cisuc = gestor.initApp();
            Scanner sc = new Scanner(System.in);
            Scanner in = new Scanner(System.in);
            int menu = 0;
            String aux;
            while (menu != 6) {
                gestor.printMenu();
                System.out.print("Opcao: ");
                menu = sc.nextInt();
                System.out.println();
                switch (menu) {
                    case 1:
                        System.out.println("> Indicadores Gerais do CISUC <");
                        System.out.println("Total de membros: " + cisuc.getInvestigadores().size());
                        System.out.println("Total de membros efetivos: " + cisuc.nMembrosEfetivos());
                        System.out.println("Total de estudantes: " + cisuc.nEstudantes());
                        System.out.println("Total de publicacoes dos ultimos 5 anos: " + cisuc.nPublicacoes5Anos());
                        System.out.println("Total livros publicados: " + cisuc.nPublicaoTipo("Livro"));
                        System.out.println("Total livros de capitulos publicados: " + cisuc.nPublicaoTipo("Capitulo"));
                        System.out.println("Total livros de artigos publicados: " + cisuc.nPublicaoTipo("Capitulo"));
                        System.out.println("Total artigos de revistas publicados: " + cisuc.nPublicaoTipo("Revista"));
                        System.out
                                .println("Total artigos de conferencias publicados: " + cisuc.nPublicaoTipo("Artigo"));
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Grupo (Acronimo): ");
                        aux = in.nextLine();
                        System.out.println("> Grupo " + aux + " <");
                        try {
                            for (Publicacao pub : cisuc.getPublicacoesGrupo5Anos(aux)) {
                                System.out.println(pub);
                            }
                        } catch (Exception ex) {
                            System.out.println("Nome de grupo invalido.");
                        }
                        System.out.println();
                        break;
                    case 3:
                        try {
                            System.out.print("Grupo (Acronimo): ");
                            aux = in.nextLine();
                            System.out.println("> Grupo " + aux + " <");
                            ArrayList<Investigador> efetivos = cisuc.getEfetivosFromGrupo(aux);
                            ArrayList<Investigador> estudantes = cisuc.getEstudantesFromGrupo(aux);
                            for (Investigador efetivo : efetivos) {
                                System.out.println(efetivo);
                            }
                            for (Investigador estudante : estudantes) {
                                System.out.println(estudante);
                            }
                        } catch (Exception ex) {
                            System.out.println("Nome de grupo invalido.");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Nome do Investigador: ");
                            aux = in.nextLine();
                            System.out.println("> Investigador " + aux + " <");
                            for (Publicacao pub : cisuc
                                    .organizaPublicacoes(cisuc.getInvestigador(aux).getPublicacoes())) {
                                System.out.println(pub);
                            }
                        } catch (Exception ex) {
                            System.out.println("Nome de investigador invalido.");
                        }
                        break;
                    case 5:
                        try {
                            for (GrupoInvestigacao grupo : cisuc.getGrupos()) {
                                aux = grupo.getAcronimo();
                                System.out.println("> Grupo " + aux + " <");
                                System.out.println("Total membros: " + cisuc.getGrupo(aux).getInvestigadores().size());
                                System.out.println("Total efetivos: " + cisuc.getEfetivosFromGrupo(aux).size());
                                System.out.println("Total estudantes: " + cisuc.getEstudantesFromGrupo(aux).size());
                                System.out.println(
                                        "Publicacoes ultimos 5 anos: " + cisuc.getPublicacoesGrupo5Anos(aux).size());
                                System.out.println("Total artigos de conferencia: "
                                        + cisuc.nArtigosConferencias(cisuc.getPublicacoesGrupo5Anos(aux)));
                                System.out.println("Total artigos de revista: "
                                        + cisuc.nArtigosRevista(cisuc.getPublicacoesGrupo5Anos(aux)));
                                System.out
                                        .println("Total livros: " + cisuc.nLivro(cisuc.getPublicacoesGrupo5Anos(aux)));
                                System.out.println(
                                        "Total capitulos: "
                                                + cisuc.nLivroCapitulos(cisuc.getPublicacoesGrupo5Anos(aux)));
                                System.out.println(
                                        "Total livros de artigos: "
                                                + cisuc.nLivroArtigos(cisuc.getPublicacoesGrupo5Anos(aux)));
                            }
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("Nome de investigador invalido.");
                        }
                        break;
                    case 6:
                        gestor.closeApp(cisuc);
                        sc.close();
                        in.close();
                        System.out.println("A sair da aplicacao...");
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Erro na aplicacao. A sair...");
        }
    }
}