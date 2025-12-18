/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnector1 {
    
    private final String ADDRESS = "jdbc:mysql://localhost:3306/library_system"; // Change this based on your DB name
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
    public Connection createConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
        return conn;
    }
    
    public boolean isConnected() {
        boolean isConnect;
        try (Connection conn = createConnection();) {
            isConnect = true;
        } catch (Exception e) {
            isConnect = false;
            System.out.println(e.toString());
        }
        return isConnect;
    }
    public static void main(String [] args) {
        SqlConnector1 callConnect = new SqlConnector1();
        System.out.println("Is connected to database?:");
        System.out.println(callConnect.isConnected());
    }
}

