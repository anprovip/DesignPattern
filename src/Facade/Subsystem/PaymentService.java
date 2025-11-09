package Facade.Subsystem;

public class PaymentService {
    public boolean processPayment(String orderId, double amount, String paymentMethod) {
        System.out.println("Xử lý thanh toán: Order=" + orderId +
                ", Số tiền=" + amount + ", Phương thức=" + paymentMethod);
        // Giả lập xử lý thanh toán
        boolean success = Math.random() > 0.2; // 80% thành công
        System.out.println("Kết quả thanh toán: " + (success ? "THÀNH CÔNG" : "THẤT BẠI"));
        return success;
    }

    public void refundPayment(String orderId) {
        System.out.println("Hoàn tiền cho order: " + orderId);
    }
}
