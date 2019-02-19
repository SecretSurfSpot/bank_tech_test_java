package main.java;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Transaction {

  public ArrayList transactionLog = new ArrayList();

  public Transaction() {
    ArrayList transactionLog[];
  }

  public ArrayList returnTransactionLog() {
    return transactionLog;
  }

  public void addTransaction(Date date, int flag, double amount, double balance) {
    DecimalFormat formatter = new DecimalFormat("#0.00");
    String strAmount = formatter.format(amount);
    String strBalance = formatter.format(balance);
    String pattern = "dd/MM/yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String strDate = simpleDateFormat.format(date);

    if (flag == 1) {
      transactionLog.add(strDate + " || " + strAmount + " || || " + strBalance + "\n");
        // System.out.println("MMM + TransLog is: " + transactionLog);
    } else {
      transactionLog.add(strDate + " || || " + strAmount + " || " + strBalance + "\n");
      // System.out.println("MMM - TransLog is: " + transactionLog);
    }



  }
}
