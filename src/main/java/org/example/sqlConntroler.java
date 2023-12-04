package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlConntroler {

    private Connection connection;

    public sqlConntroler() {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Replace these with your database connection details
            String dbUrl = "jdbc:mysql://localhost:3306/db";
            String username = "root";
            String password = "";

            // Create the connection
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: Unable to establish a database connection.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
