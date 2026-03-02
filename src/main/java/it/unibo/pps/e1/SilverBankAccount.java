package it.unibo.pps.e1;

public class SilverBankAccount extends BankAccountImpl {

    private static final int FEE = 1;

    SilverBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + getFee(amount));
    }

    public int getFee(int amount){ return FEE; }
}
