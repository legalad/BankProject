package Model.Exceptions;

public class NoAccountEx extends Throwable {
    public NoAccountEx(String nrAccout)
    {
        super("\nKonto o numerze: " + nrAccout + " nie istnieje.");
    }

}
