package Model.BankLogic;

import Model.Exceptions.NoAccountEx;
import Model.Exceptions.NoMoneyEx;
import Model.Exceptions.NrAccountEx;

public interface BankingOperations {
    public Boolean deposit(String nrAccount, double amount) throws NoAccountEx;
    public Boolean withdraw (String nrAccount, double amount) throws NoMoneyEx, NoAccountEx;
    public Boolean transfer (String nrAccountFrom, String nrAccountTo, double amount) throws NoAccountEx, NoMoneyEx;
    public Account addAccount(BankAccount account) throws NrAccountEx;
    public void deleteAccount (String nrAccount) throws NoAccountEx;
}
