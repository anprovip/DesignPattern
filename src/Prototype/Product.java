package Prototype;

public class Product implements Prototype {
    private String id;
    private String name;
    private double price;
    private String description;

    public Product(String id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public Prototype clone() {
        // Clone sâu (deep copy)
        return new Product(id, name, price, description);
    }

    // Getters / Setters
    public String getId() { return id; }
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

