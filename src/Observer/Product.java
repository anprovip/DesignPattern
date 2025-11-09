package Observer;

import java.util.ArrayList;
import java.util.List;

// ConcreteSubject - Sản phẩm được theo dõi
public class Product implements Subject {
    private String productName;
    private String status;
    private List<Observer> observers;

    public Product(String productName) {
        this.productName = productName;
        this.status = "Out of Stock";
        this.observers = new ArrayList<>();
    }

    public String getProductName() {
        return productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("Sản phẩm '" + productName + "' thay đổi trạng thái: " + status);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Khách hàng đã đăng ký theo dõi sản phẩm: " + productName);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Khách hàng đã hủy theo dõi sản phẩm: " + productName);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(productName, status);
        }
    }
}
