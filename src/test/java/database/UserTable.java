package database;

import models.RequestUserModel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserTable {
    private DatabaseConnection databaseConnection;

    public UserTable() {
        databaseConnection = new DatabaseConnection();
    }

    public void insertUserIntoTable(RequestUserModel requestBody){
        String sql = "insert into user(email, password) values (?, ?)";

        try {
             PreparedStatement stmt = databaseConnection.getConnection().prepareStatement(sql);

            stmt.setString(1, requestBody.getEmail());
            stmt.setString(2, requestBody.getPassword());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
