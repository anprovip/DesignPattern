package Prototype;

public class PrototypeCacheDemo {
    public static void main(String[] args) {
        // Giả lập hệ thống khởi động
        ProductCache.loadCache();

        // Khi người dùng xem chi tiết sản phẩm
        Product p1 = ProductCache.getProduct("1");
        Product p2 = ProductCache.getProduct("1");

        System.out.println("Product 1 (clone 1): " + p1);
        System.out.println("Product 1 (clone 2): " + p2);

        // Kiểm tra xem có phải 2 object khác nhau không
        System.out.println("Same reference? " + (p1 == p2));

        // Sửa bản clone mà không ảnh hưởng bản gốc
        p1.setName("Smartphone - Edited");
        p1.setPrice(450.0);

        System.out.println("\nAfter editing clone:");
        System.out.println("Clone: " + p1);
        System.out.println("Cache original: " + ProductCache.getProduct("1"));
    }
}

