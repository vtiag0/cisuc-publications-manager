import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(System.in);
      short menu = 0;
      while (menu != 6) {
        Gestor gestor = new Gestor();
        gestor.printMenu();
        System.out.print("Opcao: ");
        menu = Short.parseShort(sc.nextLine());
        switch (menu) {
          case 1:
            gestor.leFicheiroTxtGupos();
            break;
          case 6:
            System.out.println("A sair da aplicacao...");
            break;
        }
      }
    } catch (Exception ex) {
      System.out.println("Erro na aplicacao. A sair...");
    }
  }
}