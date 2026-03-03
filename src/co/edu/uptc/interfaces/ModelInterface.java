package co.edu.uptc.interfaces;

import java.util.List;

import co.edu.uptc.pojo.Product;

public interface ModelInterface {
    void addProduct(Product product);
    List<Product> getAllProducts();
    List<Product> productsSortedByName();
    boolean removeProductByName(String name);
    boolean isEmpty();
    
}
