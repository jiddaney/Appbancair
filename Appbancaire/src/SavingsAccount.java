class SavingAccount extends Account {
    double balance;
    Client owner;
    public SavingAccount(double balance, Client owner) {
        super(balance, owner);
    }


    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}