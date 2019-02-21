package main.java;

import java.util.ArrayList;

public class Printer {

  public ArrayList bankStatement = new ArrayList();

  public ArrayList printStatement(ArrayList transactionLog) {
    bankStatement.add("date || credit || debit || balance\n");
    for (int i = 0; i < transactionLog.size(); i++) {
      bankStatement.add(transactionLog.get(transactionLog.size() - 1 - i));
    }
    return bankStatement;
  }
}
