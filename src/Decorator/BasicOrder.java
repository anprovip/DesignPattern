package Decorator;

// ConcreteComponent - Đối tượng cơ bản mà chúng ta sẽ trang trí
public class BasicOrder implements Order {
    private String productName;
    private double productPrice;

    public BasicOrder(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String getDescription() {
        return productName;
    }

    @Override
    public double getCost() {
        return productPrice;
    }
}
