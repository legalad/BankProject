package Model.Database;

import Model.BankLogic.Bank;
import Model.BankLogic.BankAccount;
import Model.BankLogic.Owner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class QueryExecutor {
    public static ResultSet executeSelect(String selectQuery) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.connect();
            statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.connect();
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void addTransaction(BankAccount bankAccount, double amount, Bank.BankingOperationsTypes type, String dateFormat){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.connect();
            statement = connection.createStatement();
            statement.execute("INSERT INTO office.tax (transaction_type, account_from, account_to, transaction_date, amount) VALUES('"+ type.toString() + "','none','" + bankAccount.getAccountNr() + "','" + dateFormat + "','" + amount + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void addTransaction(BankAccount bankAccountFrom,BankAccount bankAccountTo, double amount, Bank.BankingOperationsTypes type, SimpleDateFormat dateFormat){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.connect();
            statement = connection.createStatement();
            statement.execute("INSERT INTO office.tax (transaction_type, account_from, account_to, transaction_date, amount) VALUES('"+ type.toString() + "','" + bankAccountFrom.getAccountNr() + "','" + bankAccountTo.getAccountNr() + "','" + dateFormat + "','" + amount + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
//    public static void addAccount(Owner owner, String accountNr, double amout){
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = Connector.connect();
//            statement = connection.createStatement();
//            statement.execute("INSERT INTO public.owner(name, surname) VALUES ('"+ owner.getName() +"','"+ owner.getSurname() +"')");
//        } catch (SQLException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
}
