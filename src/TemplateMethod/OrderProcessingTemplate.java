package TemplateMethod;

public abstract class OrderProcessingTemplate {

    public final void processOrder() {
        validateOrder();
        processPayment();
        shipOrder();
        sendNotification();
    }

    /**
     * Bước 1: Validate đơn hàng - CỐ ĐỊNH
     */
    private void validateOrder() {
        System.out.println("Order validation completed");
    }

    /**
     * Bước 2: Xử lý thanh toán - THAY ĐỔI (abstract)
     */
    protected abstract void processPayment();

    /**
     * Bước 3: Vận chuyển đơn hàng - THAY ĐỔI (abstract)
     */
    protected abstract void shipOrder();

    /**
     * Bước 4: Gửi thông báo - CỐ ĐỊNH
     */
    private void sendNotification() {
        System.out.println("Notification sent successfully");
    }
}
