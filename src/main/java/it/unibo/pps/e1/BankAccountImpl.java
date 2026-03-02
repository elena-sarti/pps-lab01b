package it.unibo.pps.e1;

public abstract class BankAccountImpl implements BankAccount{

    protected final BankAccount base;

    BankAccountImpl(BankAccount bankAccount){
        this.base = bankAccount;
    };

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public abstract void withdraw(int amount);

    public abstract int getFee(int amount);

}
