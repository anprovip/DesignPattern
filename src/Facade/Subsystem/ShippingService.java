package Facade.Subsystem;

public class ShippingService {
    public String createShippingOrder(String orderId, String address) {
        System.out.println("Tạo đơn vận chuyển: Order=" + orderId + ", Địa chỉ=" + address);
        String trackingNumber = "TRK" + System.currentTimeMillis();
        System.out.println("Mã theo dõi: " + trackingNumber);
        return trackingNumber;
    }

    public void cancelShipping(String trackingNumber) {
        System.out.println("Hủy đơn vận chuyển: " + trackingNumber);
    }
}
