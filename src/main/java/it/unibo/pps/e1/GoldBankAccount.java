package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    private static final int FEE = 0;
    private static final int OVERDRAFT = 500;
    private final BankAccount base;

    GoldBankAccount(BankAccount bankAccount){
        this.base = bankAccount;
    };

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() + OVERDRAFT < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + getFee(amount));
    }

    public int getFee(int amount){ return FEE; }
}
