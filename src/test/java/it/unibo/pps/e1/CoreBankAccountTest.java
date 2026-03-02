package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CoreBankAccountTest {
    protected BankAccount account;

    @Test
    public void testInitiallyEmpty(){
        int initialBalance = 0;
        assertEquals(initialBalance, this.account.getBalance());
    };

    @Test
    public void testCanDeposit(){
        int moneyDeposited = 1000;
        this.account.deposit(moneyDeposited);
        assertEquals(moneyDeposited, this.account.getBalance());
    };
}
