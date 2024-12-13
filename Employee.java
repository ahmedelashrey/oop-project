public abstract class Employee {
    protected int employeeId;
    protected String name;
    protected EmployeeType employeeType;
    protected PaymentMethod paymentMethod;
    protected PaymentDetails paymentDetails;
    protected TaxInformation taxInformation;

    public Employee(int employeeId, String name, EmployeeType employeeType, 
                    PaymentMethod paymentMethod, PaymentDetails paymentDetails, 
                    TaxInformation taxInformation) {
        this.employeeId = employeeId;
        this.name = name;
        this.employeeType = employeeType;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
        this.taxInformation = taxInformation;
    }

    public abstract double calculatePay();

    public PaySlip generatePayStub() {
        double grossPay = calculatePay();
        double tax = taxInformation.getTaxAmount(grossPay);
        double netPay = grossPay - tax;

        // For simplicity, assume a fixed pay period
        String payPeriod = "01/01/2024 - 01/15/2024";

        return new PaySlip(name, grossPay, tax, netPay, payPeriod);
    }

    // Getters and setters omitted for brevity
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public EmployeeType getEmployeeType() { return employeeType; }
    public void setName(String name) { this.name = name; }
    public void setPaymentMethod(PaymentMethod method) { this.paymentMethod = method; }
    public void setPaymentDetails(PaymentDetails details) { this.paymentDetails = details; }
    public void setTaxInformation(TaxInformation info) { this.taxInformation = info; }
}
