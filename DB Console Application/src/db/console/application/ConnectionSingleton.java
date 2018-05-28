/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author monirulhasan
 */
public class ConnectionSingleton {

    private static final String USERNAME = "summer2018aj";
    private static final String PASSWORD = "aj";
    private static final String HOSTNAME = "localhost";
    private static final String DBNAME = "productdb";
    private static final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    private static Connection connection = null;
    private static final ConnectionSingleton INSTANCE = new ConnectionSingleton();
    
    private ConnectionSingleton() {
        try {
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connected to the Database");
        } catch (SQLException sqle) {
            System.err.println("Connection failed");
            sqle.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
}
