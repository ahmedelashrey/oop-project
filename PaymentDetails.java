public class PaymentDetails {
  private String bankAccount;
  private String bankName;
  private String checkNumber;

  public PaymentDetails(String bankAccount, String bankName, String checkNumber) {
      this.bankAccount = bankAccount;
      this.bankName = bankName;
      this.checkNumber = checkNumber;
  }

  public String getBankAccount() {
      return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
      this.bankAccount = bankAccount;
  }

  public String getBankName() {
      return bankName;
  }

  public void setBankName(String bankName) {
      this.bankName = bankName;
  }

  public String getCheckNumber() {
      return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
      this.checkNumber = checkNumber;
  }
}

