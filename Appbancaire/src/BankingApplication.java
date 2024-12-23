public class BankingApplication {
    public static void main(String[] args) {
        System.out.println("bienvenu dans l'application bancaire !");
        Bank bank = new Bank();
        bank.run();
    }
}