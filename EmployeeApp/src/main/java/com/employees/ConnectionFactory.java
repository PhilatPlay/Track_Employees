package com.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
        	Class.forName("com.mysql.jdbc.Driver");
//            ResourceBundle bundle = ResourceBundle.getBundle("com/employees/dbConfig");
            String url = "jdbc:mysql://localhost:3306/track_employees";
//            String username = bundle.getString("username");
//            String password = bundle.getString("password");
            String username = "root";
            String password = "XXXXXXXXXX";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
