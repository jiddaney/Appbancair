import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ManagementSystem managementSystem = new ManagementSystem(scanner);
        managementSystem.run();
    }

}
class ManagementSystem {

    private final Scanner scanner;
    private final ArrayList<Client> clients;


    public ManagementSystem(Scanner scanner) {
        this.scanner = scanner;
        this.clients = new ArrayList<>();

    }

    public void run() {
        while (true) {
            try {
                System.out.println("\n--- Menu de l'application bancaire ---");
                System.out.println("1. managment de client");
                System.out.println("2. affichage des clients");
                System.out.println("3. afichage les compte des clients");
                System.out.println("4. managment de compte");
                System.out.println("5. Quitter");
                System.out.print("Entrez votre choix : ");

                int choice = getValidInt();

                switch (choice) {
                    case 1 -> manageClient(); // done
                    case 2 -> Client.displayClients();
                    case 3 -> Account.listAccount();
                    case 4 -> manageAccounts();
                    case 5 -> {
                        System.out.println("Exiting application. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private void manageClient() {
        while (true) {
            try {
                System.out.println("\nClass Management Menu:");
                System.out.println("1. Ajoutez un client");
                System.out.println("2. Modifier un client");
                System.out.println("3. supprimer un client");
                System.out.println("4. Return to Main Menu");
                System.out.print("Choose an option: ");

                int choice = getValidInt();

                switch (choice) {
                    case 1 ->  Client.addClient();
                    case 2 ->  Client.modifyClient();
                    case 3 -> Client.deleteClient();
                    case 4 -> {
                        System.out.println("Returning to main menu...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while managing classes: " + e.getMessage());
            }
        }
    }
    private void manageAccounts() {
        while (true) {
            try {
                System.out.println("\nTrainer Management Menu:");
                System.out.println("1. cree un compte");
                System.out.println("2. afficher les compte");
                System.out.println("3. Return au Main Menu");
                System.out.print("Choisir une option: ");

                int choice = getValidInt();

                switch (choice) {
                    case 1 -> Account.createAccount();
                    case 2 -> Account.listAccount();
                    case 3 -> {
                        System.out.println("Returning to main menu...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while managing accounts: " + e.getMessage());
            }
        }
    }
    private int getValidInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next();
            }
        }
    }
}
