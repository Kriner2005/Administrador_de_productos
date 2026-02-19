package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.pojo.Product;

public class Manager implements ModelInterface {
    Node header;

    public Manager() {
        header = null;
    }

    private Node createNode(Product product) {
        return new Node(product);
    }

    @Override
    public void addProduct(Product product) {
        Node newNode = createNode(product);

        if (header == null) {
            header = newNode;
            return;
        }

        Node auxNode = header;

        while (auxNode.nextNode != null) {
            auxNode = auxNode.nextNode;
        }

        auxNode.nextNode = newNode;
    }

    public void printList() {
        Node aux = header;

        while (aux != null) {
            System.out.println(
                    "Nodo: " + aux +
                            " | Producto: " + aux.product.getName() +
                            " | Next: " + aux.nextNode);
            aux = aux.nextNode;
        }
    }

    @Override
    public Product[] getAllProducts() {
        return null;
    }

    @Override
    public void productsSortedByName() {

    }

    @Override
    public void removeProductByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProductByName'");
    }

    public static void main(String[] args) {
        Manager s = new Manager();

        s.addProduct(new Product("1", 0));
        s.addProduct(new Product("2", 0));
        s.addProduct(new Product("3", 0));
        s.addProduct(new Product("4", 0));
    }
}
