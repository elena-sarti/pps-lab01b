package it.unibo.pps.e1;

import it.unibo.pps.e1.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        int moneyToDeposit = 1000;
        int moneyToWithdraw = 200;
        this.account.deposit(moneyToDeposit);
        this.account.withdraw(moneyToWithdraw);
        assertEquals(moneyToDeposit - moneyToWithdraw - this.account.getFee(moneyToWithdraw), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int moneyToDeposit = 1000;
        int moneyToWithdraw = 1200;
        this.account.deposit(moneyToDeposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(moneyToWithdraw));
    }

}
