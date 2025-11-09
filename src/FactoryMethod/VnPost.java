package FactoryMethod;

public class VnPost implements ShippingProvider {
    @Override
    public void ship(String orderId) {
        System.out.println("Đơn hàng " + orderId + " được gửi qua VNPost.");
    }
}
