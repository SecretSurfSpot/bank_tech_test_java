package main.java;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TestHelper {
  public Date date = new Date();
  private String pattern = "dd/MM/yyyy";
  private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
  public String strDate = simpleDateFormat.format(date);
  public ArrayList testTransactionLog = new ArrayList();
  public ArrayList testPrinterStatement = new ArrayList();

  public ArrayList createTestTransactionLog() {
    testTransactionLog.add(strDate + " || 1000.00 || || 1000.00\n");
    testTransactionLog.add(strDate + " || 2000.00 || || 3000.00\n");
    testTransactionLog.add(strDate + " || || -500.00 || 2500.00\n");
    return testTransactionLog;
  }

  public ArrayList createTestPrinterStatement() {
    testPrinterStatement.add("date || credit || debit || balance\n");
    testPrinterStatement.add(strDate + " || || -500.00 || 2500.00\n");
    testPrinterStatement.add(strDate + " || 2000.00 || || 3000.00\n");
    testPrinterStatement.add(strDate + " || 1000.00 || || 1000.00\n");
    return testPrinterStatement;
  }
}
