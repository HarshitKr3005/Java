package oops_simple_codes;

class BankBalance {
    private int balance = 1000;

    public void deposit(int amount) {
        if(amount > 0) balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankBalance b = new BankBalance();
        b.deposit(800);
        System.out.println("Balance : " + b.getBalance());;
    }
}
