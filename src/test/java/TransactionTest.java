import main.java.Transaction;

import org.junit.Before;
import java.util.Date;
import java.text.SimpleDateFormat;

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
    String pattern = "dd/MM/yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String strDate = simpleDateFormat.format(date);

    transaction.addTransaction(date, 1, 10.00, 10.00);
    assertEquals(strDate + " || 10.00 || || 10.00\n", transaction.transactionLog.get(0));
  }

  @Test
  public void withdrawalAddedToTransaction() {
    Date date = new Date();
    String pattern = "dd/MM/yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String strDate = simpleDateFormat.format(date);

    transaction.addTransaction(date, 0, -10.00, -10.00);
    assertEquals(strDate + " || || -10.00 || -10.00\n", transaction.transactionLog.get(0));
  }
}
