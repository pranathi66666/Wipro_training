class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient funds.");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred: " + amount + " to Account " + toAccount.getAccountNumber());
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }

    public void displayBalance() {
        System.out.println("Account: " + accountNumber + " | Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overdraftLimit += newBalance; // Reduce overdraft limit if overdrawn
            }
            super.withdraw(amount);
        } else {
            System.out.println("Invalid withdraw amount or exceeds overdraft limit.");
        }
    }
}

class Customer {
    private String name;
    private String customerId;
    private Account account;

    public Customer(String name, String customerId, Account account) {
        this.name = name;
        this.customerId = customerId;
        this.account = account;
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + customerId);
        account.displayBalance();
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000, 3.5);
        CurrentAccount current = new CurrentAccount("CA456", 2000, 1000);

        Customer customer1 = new Customer("Alice", "C001", savings);
        Customer customer2 = new Customer("Bob", "C002", current);

        customer1.displayCustomerInfo();
        savings.deposit(1500);
        savings.addInterest();
        savings.displayBalance();

        System.out.println();

        customer2.displayCustomerInfo();
        current.withdraw(2500);
        current.displayBalance();

        System.out.println();

        savings.transfer(current, 1000);
        savings.displayBalance();
        current.displayBalance();
    }
}
