package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

public interface ModelInterface {
    void addProduct(Product product);
    String getAllProducts();
    void productsSortedByName();
    boolean removeProductByName(String name);
    boolean isEmpty();
    
}
