package Prototype;

import java.util.HashMap;
import java.util.Map;

public class ProductCache {
    private static final Map<String, Product> productMap = new HashMap<>();

    // Giả lập "load từ database" chỉ 1 lần khi khởi động
    public static void loadCache() {
        Product phone = new Product("1", "Smartphone", 500.0, "High-end Android phone");
        Product laptop = new Product("2", "Laptop", 1200.0, "Lightweight ultrabook");
        Product headphone = new Product("3", "Headphone", 150.0, "Noise-cancelling wireless headphone");

        productMap.put(phone.getId(), phone);
        productMap.put(laptop.getId(), laptop);
        productMap.put(headphone.getId(), headphone);
    }

    // Khi client yêu cầu, trả về bản clone
    public static Product getProduct(String id) {
        Product cachedProduct = productMap.get(id);
        return cachedProduct != null ? (Product) cachedProduct.clone() : null;
    }
}

