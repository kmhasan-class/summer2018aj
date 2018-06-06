/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            // read the sql from a text file
            // use that as a query
            RandomAccessFile input = new RandomAccessFile("query.txt", "r");
            String queryName;
            String query = "";
            // H/W: read the queries from a properties file
            while (true) {
                queryName = input.readLine();
                if (queryName == null)
                    break;
                query = input.readLine();
                if (queryName.equals("INSERT_PRODUCT"))
                    break;
            }
            
            // H/W: look for the proper place for the next statment
            // make sure that they are not executed every single time we insert a
            // product
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getUnitPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductDAOMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAOMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
