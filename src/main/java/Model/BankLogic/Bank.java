package Model.BankLogic;

import Model.Database.Connector;
import Model.Database.QueryExecutor;
import Model.Exceptions.NoAccountEx;
import Model.Exceptions.NoMoneyEx;
import Model.Exceptions.NrAccountEx;
import Model.Observer.EventManager;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Bank implements BankingOperations{

    public enum BankingOperationsTypes {
        DEPOSIT, WITHDRAW, TRANSFER;

        @Override
        public String toString() {
            return super.toString();
        }
    }

    private HashMap<String, BankAccount> accounts;
    private EventManager events;
    private Connection connection; //nie wiem czy tego użyję

    public EventManager getEvents() {
        return events;
    }

    public Bank() {
        this.accounts = new HashMap<>(){{
            put("1111111111111111", new SavingAccount(new Owner("Admin", "Test"), 1000000, 0.2 ));
            put("2222222222222222", new SavingAccount(new Owner("Admin2", "Test2"), 1000000, 0.2 ));
        }};
        this.events = new EventManager();
        this.connection = Connector.connect();
    }

    @Override
    public Boolean deposit(String nrAccount, double amount) throws NoAccountEx {
        if (accounts.keySet().contains(nrAccount))
        {
            if (accounts.get(nrAccount).deposit(amount))
            {
                if (amount >= 10000) events.notifyObserverOffice(accounts.get(nrAccount), amount, BankingOperationsTypes.DEPOSIT);
                return true;
            }
            else return false;
        }
        else throw new NoAccountEx(nrAccount);
    }

    @Override
    public Boolean withdraw(String nrAccount, double amount) throws NoMoneyEx, NoAccountEx {
        if (accounts.keySet().contains(nrAccount)) {
            if(accounts.get(nrAccount).withdraw(amount))
            {
                if (amount >= 10000) events.notifyObserverOffice(accounts.get(nrAccount), amount, BankingOperationsTypes.WITHDRAW);
                return true;
            }
            else throw new NoMoneyEx(nrAccount, amount);
        }
        else throw new NoAccountEx(nrAccount);
    }

    @Override
    public Boolean transfer(String nrAccountFrom, String nrAccountTo, double amount) throws NoAccountEx, NoMoneyEx {
        Set<String> accountsNr = accounts.keySet();
        if (accountsNr.contains(nrAccountFrom) && accountsNr.contains(nrAccountTo))
        {
            if (accounts.get(nrAccountFrom).withdraw(amount))
            {
                if (amount >= 10000) events.notifyObserverOffice(accounts.get(nrAccountFrom), amount, BankingOperationsTypes.TRANSFER);
                accounts.get(nrAccountTo).deposit(amount);
                if (amount >= 10000) events.notifyObserverOffice(accounts.get(nrAccountTo), amount, BankingOperationsTypes.TRANSFER);
                return true;
            }
            else throw new NoMoneyEx(nrAccountFrom, amount);
        }
        else throw new NoAccountEx(nrAccountFrom + " lub " + nrAccountTo);
    }

    @Override
    public BankAccount addAccount(BankAccount account) throws NrAccountEx {
        //if(!accounts.keySet().contains(nrAccount)) return accounts.put(nrAccount, account);
        if(!accounts.containsValue(account)) {
            String accountNr = generateAccountNr();
            account.setAccountNr(accountNr);
            return accounts.put(accountNr, account);
        }
        else throw new NrAccountEx();
    }

    @Override
    public void deleteAccount(String nrAccount) throws NoAccountEx {
        if(accounts.keySet().contains(nrAccount)) accounts.remove(nrAccount);
        else throw new NoAccountEx(nrAccount);
    }

    public String generateAccountNr()
    {
        Random rnd = new Random();
        String s = "";
        for (int i = 0; i < 16; i++) {
            s += String.valueOf(rnd.nextInt(9));
        }
        if(accounts.containsKey(s)) generateAccountNr();
        return s;
    }
}
