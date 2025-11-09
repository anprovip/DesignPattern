package TemplateMethod;

public abstract class OrderProcessingTemplate {

    public final void processOrder() {
        validateOrder();
        prepareShipment();
        shipOrder();
        finalizePayment();
        sendNotification();
    }

    /**
     * Bước 1: Validate đơn hàng - CỐ ĐỊNH
     */
    private void validateOrder() {
        System.out.println("Order validation completed");
    }

    /**
     * Bước 2: Chuẩn bị shipment (bao gồm reserve stock, và tùy loại: payment trước hoặc sau) - THAY ĐỔI (abstract)
     */
    protected abstract void prepareShipment();

    /**
     * Bước 3: Vận chuyển đơn hàng - THAY ĐỔI (abstract)
     */
    protected abstract void shipOrder();

    /**
     * Bước 4: Hoàn tất thanh toán (nếu cần) - THAY ĐỔI (abstract)
     */
    protected abstract void finalizePayment();

    /**
     * Helper: Reserve stock - CỐ ĐỊNH (chung cho cả hai loại)
     */
    protected void reserveStock() {
        System.out.println("Stock reserved successfully");
    }

    /**
     * Bước cuối: Gửi thông báo - CỐ ĐỊNH
     */
    private void sendNotification() {
        System.out.println("Notification sent successfully");
    }
}