/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monirulhasan
 */
public class ProductDAOFileImplementation implements ProductDAO {

    @Override
    public void insertProduct(Product product) {
        // Task #2: use a singleton that gives you a file handler

        try (RandomAccessFile productFile = new RandomAccessFile("products.txt", "rw")) {
            productFile.seek(productFile.length());
            productFile.writeBytes("productId=" + product.getProductId() + "\n");
            productFile.writeBytes("productName=" + product.getProductName() + "\n");
            productFile.writeBytes("unitPrice=" + product.getUnitPrice() + "\n");
            productFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductDAOFileImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAOFileImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Task #1: implement the remaining methods
    @Override
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
