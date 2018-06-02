/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monirulhasan
 */
public class MySQLConnectionSingleton {
    
    private static Connection connection = null;
    private static final MySQLConnectionSingleton INSTANCE = new MySQLConnectionSingleton();
    
    private MySQLConnectionSingleton() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream("resources/db.properties");
            properties.load(inputStream);
            
            String password = properties.get("password").toString();
            String username = properties.get("username").toString();
            String dbname = properties.get("dbname").toString();
            String hostname = properties.get("hostname").toString();
            String dburl = "jdbc:mysql://" + hostname + "/" + dbname;
            
            connection = DriverManager.getConnection(dburl, username, password);
            System.out.println("Connected to the Database");
        } catch (SQLException sqle) {
            System.err.println("Connection failed");
            sqle.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySQLConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MySQLConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
}
