package main;

public class Account {
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int money) {
        balance+=money;
    }

    public void withdraw(int money) {
        balance-=money;
    }
}
