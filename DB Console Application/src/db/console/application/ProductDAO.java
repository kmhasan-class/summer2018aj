/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.util.List;

/**
 *
 * @author monirulhasan
 */
public interface ProductDAO {
    // CRUD operations
    public void insertProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProduct(int productId);
    public void deleteProduct(Product product);
    public void updateProduct(Product product);
}
