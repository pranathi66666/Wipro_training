public class BankAccount {
    String accountHolderName;
    int balance;

    public BankAccount(String name, int initialBalance) {
        accountHolderName = name;
        balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println(amount + " deposited.");
        } else {
            System.out.println("Enter a valid amount to deposit.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println(amount + " withdrawn.");
        } else if (amount > balance) {
            System.out.println("Not enough balance to withdraw " + amount + ".");
        } else {
            System.out.println("Enter a valid amount to withdraw.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 2000);

        account.checkBalance();

        account.deposit(1500);
        account.checkBalance();

        account.withdraw(1000);
        account.checkBalance();

    }

}
