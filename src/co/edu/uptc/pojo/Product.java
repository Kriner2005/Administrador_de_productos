package co.edu.uptc.pojo;

public class Product {
    private String name;
    private double price;
    private String unit;

    public Product(String name, double value, String unit) {
        this.name = name;
        this.price = value;
        this.unit = unit;
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
    
     public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
