public class PaySlip {
    private String employeeName;
    private double grossPay;
    private double taxDeduction;
    private double netPay;
    private String payPeriod;

    public PaySlip(String employeeName, double grossPay, double taxDeduction, double netPay, String payPeriod) {
        this.employeeName = employeeName;
        this.grossPay = grossPay;
        this.taxDeduction = taxDeduction;
        this.netPay = netPay;
        this.payPeriod = payPeriod;
    }

    public void printPaySlip() {
        System.out.println("------ Pay Slip ------");
        System.out.println("Employee: " + employeeName);
        System.out.println("Pay Period: " + payPeriod);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Tax Deduction: " + taxDeduction);
        System.out.println("Net Pay: " + netPay);
        System.out.println("----------------------");
    }

    // Getters/Setters omitted for brevity, add if needed
}
