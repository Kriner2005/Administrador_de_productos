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
        String list;
        while (header != null) {

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
        if (a.product.getName().charAt(0) <= b.product.getName().charAt(0)) {
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

        System.out.println(s.header.product.getName());

        s.productsSortedByName();

        s.printList();
    }
}
