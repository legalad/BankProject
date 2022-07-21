package Model.Observer;

import Model.BankLogic.Bank;
import Model.BankLogic.BankAccount;

public interface ListenerOffice {
        public void update(BankAccount bankAccount, double amount, Bank.BankingOperationsTypes type);
        public void update(BankAccount bankAccountFrom, BankAccount bankAccountTo, double amount, Bank.BankingOperationsTypes type);
}
