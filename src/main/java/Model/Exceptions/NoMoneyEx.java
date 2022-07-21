package Model.Exceptions;

public class NoMoneyEx extends Throwable {
    public NoMoneyEx(String nrAccount, double amount)
    {
        super("\nNa koncie o nr: " + nrAccount + " nie ma wystarczającej ilości środków, żeby wypłacić " + amount);
    }
}
