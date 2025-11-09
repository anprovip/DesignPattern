package Facade;

public class Client {
    public static void main(String[] args) {
        // Client chỉ cần tương tác với Facade
        CheckoutFacade checkoutFacade = CheckoutFacade.getInstance();

        // Tạo yêu cầu đặt hàng
        OrderRequest request = new OrderRequest(
                "ORD001",
                "PROD123",
                2,
                1500000,
                "CREDIT_CARD",
                "123 Đường ABC, Quận 1, TP.HCM",
                "customer@example.com"
        );

        // Đặt hàng - chỉ cần gọi 1 phương thức đơn giản
        OrderResult result = checkoutFacade.placeOrder(request);

        // Xử lý kết quả
        if (result.isSuccess()) {
            System.out.println("\n🎉 Đơn hàng thành công!");
            System.out.println("Mã theo dõi: " + result.getTrackingNumber());
        } else {
            System.out.println("\n😞 Đơn hàng thất bại: " + result.getMessage());
        }

        // Demo hủy đơn hàng
        if (result.isSuccess()) {
            System.out.println("\n--- Demo hủy đơn hàng ---");
            checkoutFacade.cancelOrder(request.getOrderId(), result.getTrackingNumber());
        }
    }
}
