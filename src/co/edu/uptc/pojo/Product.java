package co.edu.uptc.pojo;

public class Product {
    private String name;
    private double price;

    public Product(String name, double value) {
        this.name = name;
        this.price = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double value) {
        this.price = value;
    }

}
