import main.java.Transaction;

import org.junit.Before;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TransactionTest {

  private Transaction transaction;

  @Before
  public void setup() {
    transaction = new Transaction();
  }

  @Test
  public void depostitAddedToTransaction() {
    Date date = new Date();
    transaction.addTransaction(date, 1, 10.00, 10.00);
    assertEquals("18/02/2019 || 10.00 || || 10.00\n", transaction.transactionLog.get(0));
  }
}
