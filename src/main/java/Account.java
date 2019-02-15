package main.java;

import java.util.Date;

public class Account {

  private double balance;

  public Account() {
    double balance = 0.00;
  }

  public Account(double balance) {
    this.balance = balance;
  }

  public double currentBalance() {
    System.out.println(new Date());
    return balance;
  }
}
