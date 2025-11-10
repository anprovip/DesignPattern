package Decorator;

// Demo class để kiểm tra
public class OrderDemo {
    public static void main(String[] args) {
        // Tạo đơn hàng cơ bản - iPhone 15
        System.out.println("=== ĐƠN HÀNG CƠ BẢN ===");
        Order basicOrder = new BasicOrder("iPhone 15", 999.99);
        printOrderDetails(basicOrder);

        // Thêm gói quà
        System.out.println("\n=== THÊM GÓI QUÀ ===");
        Order giftWrappedOrder = new GiftWrapDecorator(basicOrder, 15.50);
        printOrderDetails(giftWrappedOrder);

        // Thêm bảo hành mở rộng
        System.out.println("\n=== THÊM BẢO HÀNH MỞ RỘNG ===");
        Order warrantyOrder = new ExtendedWarrantyDecorator(basicOrder, 49.99);
        printOrderDetails(warrantyOrder);

        // Kết hợp nhiều trang trí
        System.out.println("\n=== ĐƠN HÀNG ĐẦY ĐỦ ===");
        Order fullOrder = new BasicOrder("MacBook Pro", 1999.99);
        fullOrder = new GiftWrapDecorator(fullOrder, 25.00);      // Gói quà
        fullOrder = new ExtendedWarrantyDecorator(fullOrder, 99.99); // Bảo hành
        fullOrder = new ExpressShippingDecorator(fullOrder, 35.00);  // Vận chuyển nhanh

        printOrderDetails(fullOrder);

        // Demo linh hoạt - có thể kết hợp bất kỳ trang trí nào
        System.out.println("\n=== ĐƠN HÀNG TÙY CHỈNH ===");
        Order customOrder = new BasicOrder("Samsung Galaxy", 799.99);
        customOrder = new ExpressShippingDecorator(customOrder, 20.00);
        customOrder = new GiftWrapDecorator(customOrder, 10.00);

        printOrderDetails(customOrder);
    }

    private static void printOrderDetails(Order order) {
        System.out.println("Mô tả: " + order.getDescription());
        System.out.print("Tổng chi phí: $" + String.format("%.2f", order.getCost()));
    }
}
