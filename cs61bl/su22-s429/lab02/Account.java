/**
 * This class represents a bank account whose current balance is a non-negative
 * amount in US dollars.
 */
public class Account {

    private int balance;
    Account parentAccount;

    /**
     * Initialize an account with the given balance.
     */
    public Account(int balance) {

        this.balance = balance;
        this.parentAccount=null;

    }

    public Account(int balance,Account parentAccount) {

        this.balance=balance;
        this.parentAccount = parentAccount;

    }

    /**
     * Returns the balance for the current account.
     */
    public int getBalance() {

        return balance;
    }

    /**
     * Deposits amount into the current account.
     */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {

        if(parentAccount!= null) {
            if (amount < 0) {

                System.out.println("Cannot withdraw negative amount.");

            }
            if ((balance < amount) && (amount >= 0)) {
                if (parentAccount.getBalance() < amount) {

                    System.out.println("Insufficient funds");

                }
                if (parentAccount.getBalance() >= amount) {

                    parentAccount.balance -= (amount-balance);
                    balance=0;
                    return true;

                }
            }
            if ((balance >= amount) && (amount >= 0)) {

                balance -= amount;
                return true;

            }
        }
        if ((balance >= amount) && (amount >= 0)) {

                balance -= amount;
                return true;

            }
        return false;
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {

        balance += other.balance;
        other.balance = 0;

    }

    public static void main(String[] args) {

        Account zephyr = new Account(500);
        Account max = new Account(100, zephyr);
        max.withdraw(50);

    }
}