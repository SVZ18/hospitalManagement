package dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection getConnection() {
        Connection connection = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "pate9gaV!");
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Unable to connect to database.");
            e.printStackTrace();
        }
        return connection;
    }
}
