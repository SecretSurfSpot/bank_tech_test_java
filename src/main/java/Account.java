package main.java;

import main.java.Transaction;

import java.util.Date;

public class Account {

  private double balance;
  public Transaction transaction = new Transaction();

  public Account() {
    double balance = 0.00;
    Transaction transaction = new Transaction();
  }

  public Account(double balance) {
    this.balance = balance;
    this.transaction = transaction;
  }

  public double currentBalance() {
    return balance;
  }

  public void makeDeposit(double amount) {
    isAmountPositive(amount);
    balance += amount;
    transaction.addTransaction(new Date(), 1, amount, balance);
  }

  public void makeWithdrawal(double amount) {
    isAmountPositive(amount);
    balance -= amount;
    transaction.addTransaction(new Date(), 0, -amount, balance);
  }

  private void isAmountPositive(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Error: amount must be positive.");
    }
  }
}
