package co.edu.uptc.modelV2;

import java.util.LinkedList;
import java.util.List;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.pojo.Product;

public class Manager implements ModelInterface {
    private List<Product> products;

    public Manager() {
        products = new LinkedList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String getAllProducts() {
        String list = "---------Mostrando Producto-----------";
        for (Product product : products) {
            list += "\nNombre producto: " + product.getName() +
            "\nPrecio: " + product.getPrice()+
            "\nUnidad: " + product.getUnit() +
            "\n-----------------------";
        }
        return list;
    }

    @Override
    public void productsSortedByName() {
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    @Override
    public void removeProductByName(String name) {
        products.removeIf(p -> p.getName().toLowerCase().contains(name.toLowerCase()));
    }
}
