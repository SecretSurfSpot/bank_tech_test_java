import main.java.Printer;

import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PrinterTest {

  private Printer printer;
  String[] testTransactionLog = { "19/02/2019 || 1000.00 || || 1000.00\n", "19/02/2019 || 2000.00 || || 3000.00\n", "19/02/2019 || || -500.00 || 2500.00\n" };
  private ArrayList testReveseTransactionLog = new ArrayList();

  @Before
  public void setup() {
    printer = new Printer();
    System.out.println("testTransactionLog.length is: " + testTransactionLog.length);
    System.out.println("B4 reverse testTransactionLog is: " + Arrays.toString(testTransactionLog));
    testReveseTransactionLog.add("date || credit || debit || balance\n");
    for (int i = 0; i < testTransactionLog.length; i++) {
      System.out.println("trans log element " + (testTransactionLog.length - 1 - i) + " is: " + testTransactionLog[testTransactionLog.length - 1 - i]);
      testReveseTransactionLog.add(testTransactionLog[testTransactionLog.length - 1 - i]);
    }
    System.out.println("After reverse testTransactionLog is: " + testReveseTransactionLog);
  }

  @Test
  public void atest() {
    printer.printStatement(testTransactionLog);
    assertEquals(testReveseTransactionLog, printer.bankStatement);
  }
}
