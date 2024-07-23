package main.system.model;

import java.io.Serializable;

public class PayPalMethod implements PaymentMethod, Serializable {
  private String email;

  public PayPalMethod (String email) {
    this.email = email;
  }

  public boolean pay (double amount) {
    return true;
  }
}