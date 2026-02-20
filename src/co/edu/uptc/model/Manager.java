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
            return "";
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
        Node auxA = header;
        Node auxB = header.nextNode;

        if (name.toLowerCase().equals(header.product.getName().toLowerCase())) {
            header = header.nextNode;
            return;
        }

        if (header == null)
            return; // lista vacía

        while (auxB != null) {
            if (name.equalsIgnoreCase(auxB.product.getName())) {
                auxA.nextNode = auxB.nextNode;
                return;
            }
            auxA = auxB;
            auxB = auxB.nextNode;
        }
    }
}
