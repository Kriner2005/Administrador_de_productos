package co.edu.uptc.modelV2;

import co.edu.uptc.pojo.Product;

public class Node {
    Product product;
    Node nextNode;

    public Node(Product product) {
        this.product = product;
        this.nextNode = null;
    }
}
