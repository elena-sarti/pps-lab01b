package it.unibo.pps.e1;

public class GoldBankAccount extends BankAccountImpl {

    private static final int FEE = 0;
    private static final int OVERDRAFT = 500;

    GoldBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() + OVERDRAFT < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + getFee(amount));
    }

    public int getFee(int amount){
        return FEE;
    }
}
