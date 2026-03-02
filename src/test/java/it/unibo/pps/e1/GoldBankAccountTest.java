package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 200, 800",
            "1000, 1200, -200"
    })
    public void testCanWithdraw(int moneyToDeposit, int moneyToWithdraw, int expectedBalance) {
        this.account.deposit(moneyToDeposit);
        this.account.withdraw(moneyToWithdraw);
        assertEquals(expectedBalance, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int moneyToDeposit = 1000;
        int moneyToWithdraw = 1600;
        this.account.deposit(moneyToDeposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(moneyToWithdraw));
    }

}
