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