package Facade.Subsystem;

public class NotificationService {
    public void sendOrderConfirmation(String orderId, String email) {
        System.out.println("Gửi xác nhận đơn hàng: Order=" + orderId + ", Email=" + email);
    }

    public void sendShippingNotification(String trackingNumber, String email) {
        System.out.println("Gửi thông báo vận chuyển: Mã theo dõi=" + trackingNumber + ", Email=" + email);
    }
}