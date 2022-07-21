package Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String URL = "jdbc:postgresql://localhost/Bank";
    private static String USER = "postgres";
    private static String PASSWORD = "bd123";

    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Połączono.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
