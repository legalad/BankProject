package Model.Offices;

import Model.BankLogic.Bank;
import Model.BankLogic.BankAccount;
import Model.Database.QueryExecutor;
import Model.Observer.ListenerOffice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaxOffice implements ListenerOffice {

    private ArrayList<String> rapots;

    public TaxOffice(){this.rapots = new ArrayList<>();}


    public String raport(){
        String raport ="";
        for (String s: rapots) {
            raport += s;
        }
        return raport;
    };

    public String raport(int idx) {return "\n" + rapots.get(idx);}

    @Override
    public void update(BankAccount bankAccount, double amount, Bank.BankingOperationsTypes type) {

        rapots.add(type + "\nAmount:\t" + amount +"\n" + bankAccount + "Znacznik czasu:\t" + (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())) + "\n");
        QueryExecutor.addTransaction(bankAccount, amount, type, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    }

    @Override
    public void update(BankAccount bankAccountFrom, BankAccount bankAccountTo, double amount, Bank.BankingOperationsTypes type) {

    }
}
