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
        String list = "--------------------";
        for (Product product : products) {
            list += "\nNombre producto: " + product.getName() + "\nPrecio: " + product.getPrice()
                    + "\n--------------------";
        }
        return list;
    }

    @Override
    public void productsSortedByName() {
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    @Override
    public void removeProductByName(String name) {
        products.removeIf(p -> p.getName().equals(name));
    }

    public static void main(String[] args) {
        Manager s = new Manager();

        s.addProduct(new Product("frijol", 0));
        s.addProduct(new Product("arroz", 0));
        s.addProduct(new Product("garbanzo", 0));
        s.addProduct(new Product("lenteja", 0));
        s.addProduct(new Product("zanahoria", 0));
        s.addProduct(new Product("vedura", 0));
        s.addProduct(new Product("chino", 0));
        s.addProduct(new Product("tornillo", 0));
        s.addProduct(new Product("cebolla", 0));
        s.addProduct(new Product("vino", 0));
        s.addProduct(new Product("uvas", 0));
        s.addProduct(new Product("tomate", 0));
        s.addProduct(new Product("platano", 0));

        s.productsSortedByName();

        System.out.println(s.getAllProducts());
        s.removeProductByName("chino");
        System.out.println(s.getAllProducts());
    }
}
