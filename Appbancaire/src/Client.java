import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Client {
    static Scanner scanner = new Scanner(System.in);
    private static int lastId = 0;
    private String name;
    private String email;
    private String address;
    private static String Clientname;
    private String phone;
    private  int id;
    static List<Client> clients = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();


    public Client(
                  String name,
                  String email,
                  String address,
                  String phone){
        this.id = ++lastId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;


    }

    public static void displayClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client à afficher.");
        } else {
            System.out.println("\n--- Liste des clients ---");
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }
    public static Client findClientById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
    public static void addClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Ajouter un nouveau client ---");

        String name;
        while (true) {

            System.out.print("Entrez le nom : ");
            name = scanner.nextLine();
            if (isValidName(name)) break;
            System.out.println("Nom invalide. Utilisez uniquement des lettres et des espaces (min. 2 caractères).");
        }
        String email;
        while (true) {

            System.out.print("Entrez l'email : ");
            email = scanner.nextLine();
            if (isValidEmail(email)) break;
            System.out.println("Email invalide. Veuillez utiliser un format valide (ex: exemple@domaine.com).");
        }
        String phone;
        while (true) {

            System.out.print("Entrez le numéro de téléphone : ");
            phone = scanner.nextLine();
            if (isValidPhone(phone)) break;
            System.out.println("Numéro de téléphone invalide. Il doit commencer par 06, 07 ou 05 et contenir exactement 10 chiffres.");
        }

        System.out.print("Entrez l'adresse : ");
        String address = scanner.nextLine();
        Client NewClient = new Client (name,email,phone,address);
        clients.add(NewClient);
        System.out.println("Client ajouté avec succès.");
    }
    public static void modifyClient() {
        try {
            System.out.print("enter client ID: ");
            int clientId = scanner.nextInt();

            Client foundClient = Client.findClientById( clientId );
            if (foundClient == null) {
                System.out.println("Class not found!");
                return;
            }

            System.out.print("Enter the new name for this class: ");
            String newName = scanner.next();
            foundClient.setClientname(newName);
            System.out.println("Client information updated successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while modifying the client: " + e.getMessage());
        }
    }
    public static void deleteClient() {
        try {
            System.out.print("Enter the client ID to delete: ");
            int clientId = scanner.nextInt();
            scanner.nextLine();

            Client foundClient = Client.findClientById( clientId );
            int fountIdx = 0;

            for ( Client client : clients  ) {
                if ( client.id == clientId) {
                    fountIdx = clients.indexOf( client );
                }
            }

            if (foundClient == null) {
                System.out.println("Client not found.");
            } else {
                clients.remove(fountIdx);
                System.out.println("Client deleted successfully.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the client: " + e.getMessage());
        }
    }


    public String getName() {
        return name;
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public static String getClientname() {
        return Clientname;
    }

    public void setClientname(String clientname) {
        Clientname = clientname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]{2,}");
    }


    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }


    public static boolean isValidPhone(String phone) {
        return phone.matches("^(06|07|05)\\d{8}$");
    }

    @Override
    public String toString() {
        return "Client{" +
        ", id=" + id +
        "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
