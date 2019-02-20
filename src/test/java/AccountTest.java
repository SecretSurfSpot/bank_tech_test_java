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

  public void expectedExceptionAmountIsPositive() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Error: amount must be positive.");
  }

  @Test
  public void validatesWithdrawalAmountIsPositive_0() {
    expectedExceptionAmountIsPositive();
    account.makeWithdrawal(0);
  }

  @Test
  public void validatesWithdrawal0AmountIsPositive_1() {
    expectedExceptionAmountIsPositive();
    account.makeWithdrawal(-1);
  }

  @Test
  public void validatesDepositAmountIsPositive_0() {
    expectedExceptionAmountIsPositive();
    account.makeDeposit(0);
  }

  @Test
  public void validatesDepositAmountIsPositive_1() {
    expectedExceptionAmountIsPositive();
    account.makeDeposit(-1);
  }
}
