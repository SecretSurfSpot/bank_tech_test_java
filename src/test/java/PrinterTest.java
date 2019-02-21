import main.java.Printer;
import main.java.TestHelper;

import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PrinterTest {

  private TestHelper testHelper;
  private Printer printer;
  private ArrayList testReveseTransactionLog = new ArrayList();
  private ArrayList testTransactionLog = new ArrayList();

  @Before
  public void setup() {
    testHelper = new TestHelper();
    testHelper.createTestTransactionLog();
    printer = new Printer();

    testReveseTransactionLog.add("date || credit || debit || balance\n");
    for (int i = 0; i < testHelper.testTransactionLog.size(); i++) {
      System.out.println("trans log element is: " + testHelper.testTransactionLog.get(testHelper.testTransactionLog.size()- 1 - i));
      testReveseTransactionLog.add(testHelper.testTransactionLog.get(testHelper.testTransactionLog.size() - 1 - i));
    }
    System.out.println("After reverse testTransactionLog is: " + testReveseTransactionLog);
  }

  @Test
  public void atest() {
    printer.printStatement(testHelper.testTransactionLog);
    assertEquals(testReveseTransactionLog, printer.bankStatement);
  }
}
