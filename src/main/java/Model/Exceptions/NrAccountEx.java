package Model.Exceptions;

public class NrAccountEx extends Throwable{
    public NrAccountEx(String nrAccount)
    {
        super("\nKonto o nr: " + nrAccount + " już istnieje.");
    }
    public NrAccountEx()
    {
        super("\nKonto już istnieje.");
    }

}
