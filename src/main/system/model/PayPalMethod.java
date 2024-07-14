package main.system.model;

public class PayPalMethod implements PaymentMethod {
  private String email;

  public PayPalMethod (String email) {
    this.email = email;
  }

  public boolean pay (double amount) {
    return true;
  }
}