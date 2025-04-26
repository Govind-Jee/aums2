package com.aums.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found: " + e.getMessage());
        }
    }

    private static final String URL = "jdbc:mysql://localhost:3306/aums?useSSL=false&serverTimezone=Asia/Kolkata";
    private static final String USER = "root";
    private static final String PASS = "Klc78:go";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to connect to database: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
