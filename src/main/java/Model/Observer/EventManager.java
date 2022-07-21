package Model.Observer;

import Model.BankLogic.Bank;
import Model.BankLogic.BankAccount;

import java.util.ArrayList;

public class EventManager implements Observable{

    private ArrayList<ListenerOffice> observers;

    public EventManager() {this.observers = new ArrayList<>();}

    @Override
    public void addObserverOffice(ListenerOffice listener) {observers.add(listener);}

    @Override
    public void deleteObserverOffice(ListenerOffice listener) {observers.remove(listener);}

    @Override
    public void notifyObserverOffice(BankAccount account, double amount, Bank.BankingOperationsTypes type) {
        for (ListenerOffice lo: observers) {
            lo.update(account, amount, type);
        }
    }
}
