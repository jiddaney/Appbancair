import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Account {
    private static int accountCounter = 1;
    private final String accountNumber;
    private double balance;
    private final Client owner;

    static List<Account> accounts = new ArrayList<>();


    public Account(double balance, Client owner) {
        this.accountNumber = "ACC" + (accountCounter++);
        this.balance = balance;
        this.owner = owner;


    }
    public static void listAccount() {
        System.out.println("\n--- Liste des clients ---");

        if (accounts.isEmpty()) {
            System.out.println("Aucun client trouvé. Veuillez en ajouter avec l'option 1.");
            return;
        }

        for (Account account : accounts) {
            System.out.println(account); // Appelle la méthode toString() de la classe Client
        }
    }
    public static void createAccount() {
        System.out.println("\n--- Créer un compte ---");
        System.out.print("Entrez l'ID du client : ");
        Scanner scanner = null;
        String clientId = scanner.nextLine();


        Client client = Client.findClientById(Integer.parseInt(clientId)); // Cherche le client avec l'ID donné
        if (client == null) {
            System.out.println("Client non trouvé. Essayez encore.");
            return;
        }

        System.out.println("1. Compte courant");
        System.out.println("2. Compte épargne");
        System.out.print("Choisissez le type de compte (1 ou 2) : ");
        int accountType = scanner.nextInt();

        System.out.print("Entrez le solde initial : ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Account account;
        if (accountType == 1) {
            account = new CurrentAccount(balance,client);
        } else {
            account = new SavingAccount(balance,client);
        }

        client.addAccount(account);
        System.out.println("Compte créé avec succès !");
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    public static void setAccountCounter(int accountCounter) {
        Account.accountCounter = accountCounter;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }


}
