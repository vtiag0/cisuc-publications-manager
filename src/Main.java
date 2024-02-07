import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      CISUC cisuc = new CISUC();
      Gestor gestor = new Gestor();
      cisuc = gestor.initApp();
      Scanner sc = new Scanner(System.in);
      short menu = 0;
      while (menu != 6) {
        gestor.printMenu();
        System.out.print("Opcao: ");
        menu = Short.parseShort(sc.nextLine());
        System.out.println();
        switch (menu) {
          case 1:
            System.out.println("> Indicadores Gerais do CISUC <");
            System.out.println("Total de membros: " + cisuc.getInvestigadores().size());
            System.out.println("Total de membros efetivos: " + gestor.nMembrosEfetivos(cisuc.getInvestigadores()));
            System.out.println("Total de estudantes: " + gestor.nEstudantes(cisuc.getInvestigadores()));
            System.out.println(
                "Total de publicacoes dos ultimos 5 anos: " + gestor.nPublicacoes5Anos(cisuc.getPublicacoes()));
            System.out.println("Total livros publicados: " + gestor.nLivros(cisuc.getPublicacoes()));
            System.out
                .println("Total livros de capitulos publicados: " + gestor.nLivrosCapitulo(cisuc.getPublicacoes()));
            System.out.println("Total livros de artigos publicados: " + gestor.nLivroArtigo(cisuc.getPublicacoes()));
            System.out
                .println("Total artigos de revistas publicados: " + gestor.nArtigosRevista(cisuc.getPublicacoes()));
            System.out.println(
                "Total artigos de conferencias publicados: " + gestor.nArtigosConferencia(cisuc.getPublicacoes()));
            System.out.println();
            break;
          case 6:
            gestor.closeApp(cisuc);
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