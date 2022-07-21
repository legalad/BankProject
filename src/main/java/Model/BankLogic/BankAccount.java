package Model.BankLogic;

public abstract class BankAccount implements Account{
    private double balance;
    private Owner owner;
    private String accountNr;

    protected Owner getOwner() {
        return owner;
    }

    public String getAccountNr() {
        return accountNr;
    }

    protected void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    BankAccount(Owner owner)
    {
        this.owner = owner;
        this.balance = 0.0;
    }
    BankAccount (Owner owner, double balance)
    {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount >= 0)
        {
            this.balance += amount;
            return true;
        }
        else return false;
    }

    @Override
    public boolean withdraw(double amount) {
        if (this.balance >= amount && amount > 0)
        {
            this.balance -= amount;
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "BankAccount:\n" +
                "balance=" + balance +
                ",\n" + owner +
                '\n';
    }
}
