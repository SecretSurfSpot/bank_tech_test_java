import main.java.Transaction;
import main.java.TestHelper;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TransactionTest {

  private TestHelper testHelper;
  private Transaction transaction;

  @Before
  public void setup() {
    testHelper = new TestHelper();
    transaction = new Transaction();
    testHelper.createTestTransactionLog();
  }

  @Test
  public void depostitAddedToTransaction() {
    transaction.addTransaction(testHelper.date, 1, 10.00, 10.00);
    assertEquals(testHelper.strDate + " || 10.00 || || 10.00\n", transaction.returnTransactionLog().get(0));
  }

  @Test
  public void withdrawalAddedToTransaction() {
    transaction.addTransaction(testHelper.date, 0, -10.00, -10.00);
    assertEquals(testHelper.strDate + " || || -10.00 || -10.00\n", transaction.returnTransactionLog().get(0));
  }

  @Test
  public void depositX2WithdrawalX1AddedToTransaction() {
    transaction.addTransaction(testHelper.date, 1, 1000.00, 1000.00);
    transaction.addTransaction(testHelper.date, 1, 2000.00, 3000.00);
    transaction.addTransaction(testHelper.date, 0, -500.00, 2500.00);
    assertEquals(testHelper.testTransactionLog, transaction.transactionLog);
  }
}
