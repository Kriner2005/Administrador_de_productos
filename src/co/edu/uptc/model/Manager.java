package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.pojo.Product;

public class Manager implements ModelInterface {
    private Node header;

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

    @Override
    public String getAllProducts() {

        if (header == null) {
            return "No hay productos registrados en este momento.";
        }
        String list = "---------Mostrando Producto-----------";
        Node auxNode = header;
        while (auxNode != null) {
            list += "\nNombre: " + auxNode.product.getName()
                    + "\nPrecio: " + auxNode.product.getPrice()
                    + "\nUnidad: " + auxNode.product.getUnit()
                    + "\n----------------------------";
            auxNode = auxNode.nextNode;
        }
        return list;
    }

    @Override
    public void productsSortedByName() {
        header = mergeSort(header);
    }

    private Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.nextNode;

        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow;
    }

    private Node mergeSort(Node head) {
        if (head == null || head.nextNode == null) {
            return head;
        }

        Node middle = getMiddle(head);

        Node rightHead = middle.nextNode;
        middle.nextNode = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return mergeNodes(left, right);
    }

    private Node mergeNodes(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        if (a.product.getName().compareToIgnoreCase(
                b.product.getName()) <= 0) {
            result = a;
            result.nextNode = mergeNodes(a.nextNode, b);
        } else {
            result = b;
            result.nextNode = mergeNodes(a, b.nextNode);
        }
        return result;
    }

    @Override
    public void removeProductByName(String name) {
        if (header == null) return;

        while (header != null
                && header.product.getName().toLowerCase().contains(name.toLowerCase())) {
            header = header.nextNode;
        }

        Node auxA = header;
        Node auxB = (header != null) ? header.nextNode : null;

        while (auxB != null) {
            if (auxB.product.getName().toLowerCase().contains(name.toLowerCase())) {
                auxA.nextNode = auxB.nextNode;
                auxB = auxA.nextNode;
            } else {
                auxA = auxB;
                auxB = auxB.nextNode;
            }
        }
    }
}
