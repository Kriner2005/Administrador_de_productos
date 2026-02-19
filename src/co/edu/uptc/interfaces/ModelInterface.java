package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

public interface ModelInterface {
    void addProduct(Product product);
    Product[] getAllProducts();
    void productsSortedByName();
    void removeProductByName(String name);
}
