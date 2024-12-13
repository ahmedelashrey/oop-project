public class TaxInformation {
  private String taxId;
  private double taxRate; // e.g. 0.2 for 20%

  public TaxInformation(String taxId, double taxRate) {
      this.taxId = taxId;
      this.taxRate = taxRate;
  }

  public String getTaxId() {
      return taxId;
  }

  public void setTaxId(String taxId) {
      this.taxId = taxId;
  }

  public double getTaxRate() {
      return taxRate;
  }

  public void setTaxRate(double taxRate) {
      this.taxRate = taxRate;
  }

  public double getTaxAmount(double grossPay) {
      return grossPay * taxRate;
  }
}

