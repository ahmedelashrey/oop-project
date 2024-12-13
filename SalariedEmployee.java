public class SalariedEmployee extends Employee {
    private double salary; // Fixed salary

    public SalariedEmployee(int employeeId, String name, PaymentMethod paymentMethod,
                            PaymentDetails paymentDetails, TaxInformation taxInformation,
                            double salary) {
        super(employeeId, name, EmployeeType.SALARIED, paymentMethod, paymentDetails, taxInformation);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        // For a salaried employee, pay is the fixed salary for the pay period.
        // You might adjust this logic if you have pay periods.
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
