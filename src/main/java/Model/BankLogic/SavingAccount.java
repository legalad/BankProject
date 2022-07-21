package Model.BankLogic;

public class SavingAccount extends BankAccount{

    private double interest;

    public SavingAccount(Owner owner)
    {
        super(owner);
        this.interest = 2.0;
    }
    public SavingAccount (Owner owner,double balance, double interest)
    {
        super(owner, balance);
        this.interest = interest;
    }
}
