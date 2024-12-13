public class CommissionedEmployee extends Employee {
  private double commissionRate;
  private double totalSales;

  public CommissionedEmployee(int employeeId, String name, PaymentMethod paymentMethod,
                              PaymentDetails paymentDetails, TaxInformation taxInformation,
                              double commissionRate, double totalSales) {
      super(employeeId, name, EmployeeType.COMMISSIONED, paymentMethod, paymentDetails, taxInformation);
      this.commissionRate = commissionRate;
      this.totalSales = totalSales;
  }

  @Override
  public double calculatePay() {
      return totalSales * commissionRate;
  }

  public void setCommissionRate(double commissionRate) {
      this.commissionRate = commissionRate;
  }

  public void setTotalSales(double totalSales) {
      this.totalSales = totalSales;
  }
}
