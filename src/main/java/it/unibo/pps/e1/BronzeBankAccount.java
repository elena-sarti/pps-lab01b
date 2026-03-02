package it.unibo.pps.e1;

public class BronzeBankAccount extends BankAccountImpl {

    BronzeBankAccount(BankAccount bankAccount) {
        super(bankAccount);
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
