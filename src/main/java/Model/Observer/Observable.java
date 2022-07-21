package Model.Observer;

import Model.BankLogic.Bank;
import Model.BankLogic.BankAccount;

public interface Observable {
    public void addObserverOffice(ListenerOffice listener);
    public void deleteObserverOffice(ListenerOffice listener);
    public void notifyObserverOffice(BankAccount bankAccount, double amount, Bank.BankingOperationsTypes type);
}
