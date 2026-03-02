package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private final BankAccount base;

    BronzeBankAccount(BankAccount bankAccount){
        this.base = bankAccount;
    };

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + getFee(amount));
    }

    public int getFee(int amount){
        return amount < 100 ? 0: 1;
    }
}
