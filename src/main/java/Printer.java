package main.java;

import java.util.ArrayList;

public class Printer {

  public ArrayList reveseTransactionLog = new ArrayList();

  public ArrayList printStatement(String[] transactionLog) {
    reveseTransactionLog.add("date || credit || debit || balance\n");
    for (int i = 0; i < transactionLog.length; i++) {
      System.out.println("MMM - trans log element " + (transactionLog.length - 1 - i) + " is: " + transactionLog[transactionLog.length - 1 - i]);
      reveseTransactionLog.add(transactionLog[transactionLog.length - 1 - i]);
    }
      return reveseTransactionLog;
  }
}
