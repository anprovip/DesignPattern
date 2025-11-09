package Facade;
import Facade.Subsystem.InventoryService;
import Facade.Subsystem.PaymentService;
import Facade.Subsystem.ShippingService;
import Facade.Subsystem.NotificationService;

// Facade: CheckoutFacade
public class CheckoutFacade {
    private static CheckoutFacade instance;
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private NotificationService notificationService;

    // Private constructor để đảm bảo Singleton
    private CheckoutFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    // Singleton pattern
    public static CheckoutFacade getInstance() {
        if (instance == null) {
            instance = new CheckoutFacade();
        }
        return instance;
    }

    // Phương thức chính - đơn giản hóa quy trình phức tạp
    public OrderResult placeOrder(OrderRequest request) {
        System.out.println("=== BẮT ĐẦU QUY TRÌNH ĐẶT HÀNG ===");

        // 1. Kiểm tra tồn kho
        boolean inventoryAvailable = inventoryService.checkInventory(
                request.getProductId(), request.getQuantity());

        if (!inventoryAvailable) {
            System.out.println("Đặt hàng thất bại: Hết hàng");
            return new OrderResult(false, null, "Hết hàng");
        }

        // 2. Xử lý thanh toán
        boolean paymentSuccess = paymentService.processPayment(
                request.getOrderId(), request.getAmount(), request.getPaymentMethod());

        if (!paymentSuccess) {
            System.out.println("Đặt hàng thất bại: Thanh toán thất bại");
            return new OrderResult(false, null, "Thanh toán thất bại");
        }

        // 3. Cập nhật tồn kho
        inventoryService.updateInventory(request.getProductId(), request.getQuantity());

        // 4. Tạo đơn vận chuyển
        String trackingNumber = shippingService.createShippingOrder(
                request.getOrderId(), request.getShippingAddress());

        // 5. Gửi thông báo
        notificationService.sendOrderConfirmation(request.getOrderId(), request.getCustomerEmail());
        notificationService.sendShippingNotification(trackingNumber, request.getCustomerEmail());

        System.out.println("Đặt hàng thành công!");
        return new OrderResult(true, trackingNumber, "Thành công");
    }

    // Phương thức hủy đơn hàng
    public void cancelOrder(String orderId, String trackingNumber) {
        System.out.println("=== HỦY ĐƠN HÀNG ===");
        paymentService.refundPayment(orderId);
        shippingService.cancelShipping(trackingNumber);
        System.out.println("Hủy đơn hàng thành công: " + orderId);
    }
}
