import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    PayrollSystem payrollSystem = new PayrollSystem();
    java.util.Scanner scanner = new Scanner(System.in);
 
    Menu appMenu = new Menu(payrollSystem, scanner);
    appMenu.displayMenu();

    scanner.close();
  }
}
