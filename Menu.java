import java.util.Scanner;

public class Menu {
  private boolean running;
  private User currentUser;

  private PayrollSystem payrollSystem;
  private Scanner scanner;

  public Menu(PayrollSystem payrollSystem, Scanner scanner) {
    this.running = true;
    this.currentUser = null;
    
    this.payrollSystem = payrollSystem;
    this.scanner = scanner;
  }

  public void displayMenu() {
    while (running) {
      if (currentUser == null) {
        loggedOutMenu();
      } else {
        loggedInMenu();
      }
    }
  }

  private void loggedOutMenu() {
    System.out.println("\n1. Login");
    System.out.println("2. Register");
    System.out.println("3. Exit");
    System.out.print("Choose an option: ");

    int choice = scanner.nextInt();
    scanner.nextLine(); // consume newline

    switch (choice) {
      case 1:
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        currentUser = payrollSystem.login(username, password);
        if (currentUser == null) {
          System.out.println("Invalid credentials!");
        } else {
          System.out.println("Login successful!");
        }
        break;

      case 2:
        System.out.print("New username: ");
        username = scanner.nextLine();
        System.out.print("New password: ");
        password = scanner.nextLine();
        currentUser = payrollSystem.registerUser(username, password);
        if (currentUser == null) {
          System.out.println("Username already exists!");
        } else {
          System.out.println("User registered successfully!");
        }
        break;

      case 3:
        running = false;
        break;

      default:
        System.out.println("Invalid option!");
    }
  }

  private void loggedInMenu() {
    System.out.println("\n1. Add Employee");
    System.out.println("2. Remove Employee");
    System.out.println("3. Calculate Total Payroll");
    System.out.println("4. Generate Payslips");
    System.out.println("5. Update Employee Details");
    System.out.println("6. Logout");
    System.out.println("7. Exit");
    System.out.print("Choose an option: ");

    int choice = scanner.nextInt();
    scanner.nextLine(); // consume newline

    switch (choice) {
      case 1:
        System.out.print("Employee name: ");
        String name = scanner.nextLine();
        System.out.println("Employee type:");
        System.out.println("1. Salaried");
        System.out.println("2. Hourly");
        System.out.println("3. Commissioned");
        int empType = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Employee newEmployee;
        switch (empType) {
          case 1:
            System.out.print("Monthly salary: ");
            double salary = scanner.nextDouble();
            newEmployee = new SalariedEmployee(1, name, PaymentMethod.BANK_TRANSFER, new PaymentDetails("1234567890", "Bank of America", "1234567890" ), new TaxInformation("1234567890", 0.1), salary);
            break;
          case 2:
            System.out.print("Hourly rate: ");
            double rate = scanner.nextDouble();
            System.out.print("Hours worked: ");
            int hours = scanner.nextInt();
            newEmployee = new HourlyEmployee(1, name, PaymentMethod.BANK_TRANSFER, new PaymentDetails("1234567890", "Bank of America", "1234567890" ), new TaxInformation("1234567890", 0.1), rate, hours);
            break;
          case 3:
            System.out.print("Commission rate: ");
            double commission = scanner.nextDouble();
            System.out.print("Total sales: ");
            double sales = scanner.nextDouble();
            newEmployee = new CommissionedEmployee(1, name, PaymentMethod.BANK_TRANSFER, new PaymentDetails("1234567890", "Bank of America", "1234567890" ), new TaxInformation("1234567890", 0.1), commission, sales);
            break;
          default:
            System.out.println("Invalid employee type!");
            return;
        }
        payrollSystem.addEmployee(newEmployee);
        System.out.println("Employee added successfully!");
        break;

      case 2:
        System.out.print("Employee ID to remove: ");
        int id = scanner.nextInt();
        payrollSystem.removeEmployee(id);
        System.out.println("Employee removed (if existed)");
        break;

      case 3:
        double total = payrollSystem.calculateTotalPayroll();
        System.out.printf("Total Payroll: $%.2f%n", total);
        break;

      case 4:
        payrollSystem.generatePayslips();
        break;

      case 5:
        System.out.print("Employee ID to update: ");
        id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Attribute to update (name / salary / hourlyrate / hoursworked /commissionrate / totalsales): ");
        String attribute = scanner.nextLine();
        System.out.print("New value: ");
        String value = scanner.nextLine();
        
        Object newValue;
        switch (attribute.toLowerCase()) {
          case "name":
            newValue = value;
            break;
          case "hoursworked":
            newValue = Integer.parseInt(value);
            break;
          default:
            newValue = Double.parseDouble(value);
        }
        
        payrollSystem.updateEmployeeDetails(id, attribute, newValue);
        System.out.println("Employee updated (if existed)");
        break;

      case 6:
        currentUser = null;
        System.out.println("Logged out successfully!");
        break;

      case 7:
        running = false;
        break;

      default:
        System.out.println("Invalid option!");
    }
  }
}
