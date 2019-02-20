package main.java;

import java.util.ArrayList;

public class Printer {

  public ArrayList bankStatement = new ArrayList();

  public ArrayList printStatement(String[] transactionLog) {
    bankStatement.add("date || credit || debit || balance\n");
    for (int i = 0; i < transactionLog.length; i++) {
      bankStatement.add(transactionLog[transactionLog.length - 1 - i]);
    }
    return bankStatement;
  }
}
