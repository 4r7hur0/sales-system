package main.system.model;

public class BankTransferPayment implements PaymentMethod {
  private String bankAccoumtNumber;
  private String bankRoutingNumber;
  private String accountHolderName;

  public BankTransferPayment (String bankAccoumtNumber, String bankRoutingNumber, String accountHolderName) {
    this.bankAccoumtNumber = bankAccoumtNumber;
    this.bankRoutingNumber = bankRoutingNumber;
    this.accountHolderName = accountHolderName;
  }

  public boolean pay(double amount) {
    return true;
  }
}