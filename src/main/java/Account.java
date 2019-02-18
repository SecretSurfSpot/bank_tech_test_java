package main.java;

import main.java.Transaction;

import java.util.Date;

public class Account {

  private double balance;
  private Transaction transaction = new Transaction();

  public Account() {
    double balance = 0.00;
    Transaction transaction = new Transaction();
  }

  public Account(double balance) {
    this.balance = balance;
    // this.transaction = transaction;
  }

  public double currentBalance() {
    return balance;
  }

  public void makeDeposit(double amount) {
    balance += amount;
    transaction.addTransaction(new Date(), 1, amount, balance);
  }

  public void makeWithdrawal(double amount) {
    balance -= amount;
    System.out.println("MMM balance is: " + balance);
    transaction.addTransaction(new Date(), 0, -amount, balance);
  }
}
