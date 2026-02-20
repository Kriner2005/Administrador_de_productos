package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

public interface ModelInterface {
    void addProduct(Product product);
    String getAllProducts();
    void productsSortedByName();
    void removeProductByName(String name);
    boolean isEmpty();
}
