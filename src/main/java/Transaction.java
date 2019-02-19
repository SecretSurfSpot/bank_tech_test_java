package main.java;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Transaction {

  public ArrayList transactionLog = new ArrayList();
  private DecimalFormat formatter = new DecimalFormat("#0.00");
  private String pattern = "dd/MM/yyyy";
  private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

  public Transaction() {
    ArrayList transactionLog[];
  }

  public ArrayList returnTransactionLog() {
    return transactionLog;
  }

  public void addTransaction(Date date, int flag, double amount, double balance) {
    String strAmount = formatter.format(amount);
    String strBalance = formatter.format(balance);
    String strDate = simpleDateFormat.format(date);

    if (flag == 1) {
      transactionLog.add(strDate + " || " + strAmount + " || || " + strBalance + "\n");
    } else {
      transactionLog.add(strDate + " || || " + strAmount + " || " + strBalance + "\n");
    }
  }
}
