import main.java.Transaction;

import org.junit.Before;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TransactionTest {

  private Transaction transaction;
  private Date date = new Date();
  private String pattern = "dd/MM/yyyy";
  private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
  private String strDate = simpleDateFormat.format(date);
  private ArrayList testTransactionLog = new ArrayList();

  @Before
  public void setup() {
    transaction = new Transaction();
    testTransactionLog.add(strDate + " || 1000.00 || || 1000.00\n");
    testTransactionLog.add(strDate + " || 2000.00 || || 3000.00\n");
    testTransactionLog.add(strDate + " || || -500.00 || 2500.00\n");
  }

  @Test
  public void depostitAddedToTransaction() {
    transaction.addTransaction(date, 1, 10.00, 10.00);
    assertEquals(strDate + " || 10.00 || || 10.00\n", transaction.returnTransactionLog().get(0));
  }

  @Test
  public void withdrawalAddedToTransaction() {
    transaction.addTransaction(date, 0, -10.00, -10.00);
    assertEquals(strDate + " || || -10.00 || -10.00\n", transaction.returnTransactionLog().get(0));
  }

  @Test
  public void depositX2WithdrawalX1AddedToTransaction() {
    transaction.addTransaction(date, 1, 1000.00, 1000.00);
    transaction.addTransaction(date, 1, 2000.00, 3000.00);
    transaction.addTransaction(date, 0, -500.00, 2500.00);
    assertEquals(testTransactionLog, transaction.transactionLog);
  }
}
