import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees;
    private List<User> users;

    public PayrollSystem() {
        employees = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.getEmployeeId() == employeeId);
    }

    public double calculateTotalPayroll() {
        double total = 0.0;
        for (Employee e : employees) {
            total += e.calculatePay();
        }
        return total;
    }

    public void generatePayslips() {
        for (Employee e : employees) {
            PaySlip slip = e.generatePayStub();
            slip.printPaySlip();
        }
    }

    public void updateEmployeeDetails(int employeeId, String attribute, Object newValue) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                // A simple example: handle a few known attributes
                switch (attribute.toLowerCase()) {
                    case "name":
                        e.setName((String) newValue);
                        break;
                    case "salary":
                        if (e instanceof SalariedEmployee) {
                            ((SalariedEmployee) e).setSalary((Double) newValue);
                        }
                        break;
                    case "hourlyrate":
                        if (e instanceof HourlyEmployee) {
                            ((HourlyEmployee) e).setHourlyRate((Double) newValue);
                        }
                        break;
                    case "hoursworked":
                        if (e instanceof HourlyEmployee) {
                            ((HourlyEmployee) e).setHoursWorked((Integer) newValue);
                        }
                        break;
                    case "commissionrate":
                        if (e instanceof CommissionedEmployee) {
                            ((CommissionedEmployee) e).setCommissionRate((Double) newValue);
                        }
                        break;
                    case "totalsales":
                        if (e instanceof CommissionedEmployee) {
                            ((CommissionedEmployee) e).setTotalSales((Double) newValue);
                        }
                        break;
                    default:
                        System.out.println("Unknown attribute: " + attribute);
                }
                break;
            }
        }
    }

    public User registerUser(String username, String password) {
        if (!users.stream().anyMatch(u -> u.getUsername().equals(username))) {
            User newUser = new User(username, password);
            users.add(newUser);
            return newUser;
        } else {
            return null;
        }
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.authenticate(username, password)) {
                return u;
            }
        }

        // failed to login
        return null;
    }
}
