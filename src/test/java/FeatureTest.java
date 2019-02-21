import main.java.TestHelper;
import main.java.Account;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FeatureTest {

  private TestHelper testHelper;
  private Account account;

  @Before
  public void setup() {
    testHelper = new TestHelper();
    account = new Account();
  }

  @Test
  public void depostiIncreasesBalance() {
      account.makeDeposit(1000.00);
      assertTrue(account.currentBalance() == 1000.00);
  }

  @Test
  public void withdrawalDecreasesBalance() {
      account.makeDeposit(1000.00);
      account.makeWithdrawal(1000.00);
      assertTrue(account.currentBalance() == 0.00);
  }

  @Test
  public void depositX2WithdrawalX1AddedToTransaction() {
      testHelper.createTestTransactionLog();
      account.makeDeposit(1000.00);
      account.makeDeposit(2000.00);
      account.makeWithdrawal(500.00);
      assertTrue(account.currentBalance() == 2500.00);
      assertEquals(testHelper.testTransactionLog, account.transaction.transactionLog);
  }
}
