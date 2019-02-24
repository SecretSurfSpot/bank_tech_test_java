package main.java;
import java.util.ArrayList;

public class Printer {

  public ArrayList bankStatement = new ArrayList();

  public void printStatement(ArrayList transactionLog) {
    createBankStatement(transactionLog);
    for (int i = 0; i < bankStatement.size(); i++) {
      System.out.print(bankStatement.get(i));
    }
  }

  private void createBankStatement(ArrayList transactionLog) {
    bankStatement.clear();
    addHeader();
    for (int i = 0; i < transactionLog.size(); i++) {
      bankStatement.add(transactionLog.get(transactionLog.size() - 1 - i));
    }
  }

  private void addHeader() {
    bankStatement.add("date || credit || debit || balance\n");
  }
}
