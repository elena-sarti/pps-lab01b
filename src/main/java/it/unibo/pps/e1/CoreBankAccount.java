package it.unibo.pps.e1;

class CoreBankAccount implements BankAccount {

    private static final int FEE = 0;
    private int balance = 0;

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }

    public int getFee(int amount) { return FEE; }
}
