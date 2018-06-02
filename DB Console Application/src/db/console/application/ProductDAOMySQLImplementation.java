/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monirulhasan
 */
public class ProductDAOMySQLImplementation implements ProductDAO {

    /*
    H/W #1: implement the remaining methods
    H/W #2: forget about database, write another implementation that saves into 
    a text file and reads from there
    */
    @Override
    public void insertProduct(Product product) {
        try {
            Connection connection = MySQLConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO Product VALUES(%d, '%s', %f);",
                    product.getProductId(), product.getProductName(), product.getUnitPrice());
            statement.executeUpdate(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        
        try {
            Connection connection = MySQLConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                double unitPrice = resultSet.getDouble("unitPrice");
                
                Product product = new Product(productId, productName, unitPrice);
                productList.add(product);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return productList;
    }

    @Override
    public Product getProduct(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
