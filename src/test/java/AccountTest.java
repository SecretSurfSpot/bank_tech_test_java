import main.java.Account;

import org.junit.Before;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;


public class AccountTest {

  private Account account;

  @Rule
    public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setup() {
    account = new Account();
  }

  @Test
  public void zeroBalanceTest() {
    assertTrue(account.currentBalance() == 0.00);
  }

  @Test
  public void depostiIncreasesBalance() {
    account.makeDeposit(1000.00);
    assertTrue(account.currentBalance() == 1000.00);
  }

  @Test
  public void withdrawalDecreasesBalance() {
    account.makeWithdrawal(1000.00);
    assertTrue(account.currentBalance() == -1000.00);
  }

  @Test
  public void testValidatesAmountNotString() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Error: amount must be a number.");
    account.makeWithdrawal("one hundred");
  }
}
