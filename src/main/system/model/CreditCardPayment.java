package main.system.model;

public class CreditCardPayment implements PaymentMethod {
  private String cardNumber;
  private String cardHolderName;
  private String cvv;

  public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
    this.cardNumber = cardNumber;
    this.cardHolderName = cardHolder;
    this.cvv = cvv;
  }

  public boolean pay(double amount) {
    return true;
}
  
}