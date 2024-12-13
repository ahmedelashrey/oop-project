public class HourlyEmployee extends Employee {
  private double hourlyRate;
  private int hoursWorked;

  public HourlyEmployee(int employeeId, String name, PaymentMethod paymentMethod,
                        PaymentDetails paymentDetails, TaxInformation taxInformation,
                        double hourlyRate, int hoursWorked) {
      super(employeeId, name, EmployeeType.HOURLY, paymentMethod, paymentDetails, taxInformation);
      this.hourlyRate = hourlyRate;
      this.hoursWorked = hoursWorked;
  }

  @Override
  public double calculatePay() {
      return hourlyRate * hoursWorked;
  }

  public void setHourlyRate(double hourlyRate) {
      this.hourlyRate = hourlyRate;
  }

  public void setHoursWorked(int hoursWorked) {
      this.hoursWorked = hoursWorked;
  }
}
