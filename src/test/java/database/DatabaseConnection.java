package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //Aceasta clasa are ca scop sa faca conexiunea dintre cod si baza de date

    private final int port = 3306;
    private final String db_Name = "PracticeSoftwareDB";
    private final String user = "root";
    private final String password = "root";
    private Connection connection;

    public DatabaseConnection(){
       String url = "jdbc:mysql://localhost:"+port+"/"+ db_Name;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

        }
    }

    public Connection getConnection() {
        return connection;
    }
}
