/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monirulhasan
 */
public class DBConsoleApplication {

    
    public DBConsoleApplication() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            
            Product product = new Product(46, "Aarong Strawberry Yogurt", 30);
            System.out.println(product);
            
            String query = String.format("INSERT INTO Product VALUES(%d, '%s', %f);",
                    product.getProductId(), product.getProductName(), product.getUnitPrice());
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(query);
        } catch (SQLException sqle) {
            System.err.println("Connection failed");
            sqle.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DBConsoleApplication();
    }
    
}
