abstract class Account {
    private static int accountCounter = 1; // Compteur pour attribuer des numéros de compte uniques
    private final String accountNumber;   // Numéro de compte unique
    private double balance;               // Solde du compte
    private final Client owner;           // Propriétaire du compte (un client)

    public Account(double balance, Client owner) {
        this.accountNumber = "ACC" + (accountCounter++);
        this.balance = balance;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount; // Ajoute de l'argent au compte
    }

    public void withdraw(double amount) throws Exception {
        if (balance >= amount) {
            balance -= amount; // Retire de l'argent si le solde est suffisant
        } else {
            throw new Exception("Solde insuffisant.");
        }
    }

    @Override
    public String toString() {
        return "Numéro de compte: " + accountNumber + ", Solde: " + balance;
    }
}