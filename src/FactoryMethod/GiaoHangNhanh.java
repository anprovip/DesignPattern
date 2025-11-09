package FactoryMethod;

public class GiaoHangNhanh implements ShippingProvider {
    @Override
    public void ship(String orderId) {
        System.out.println("Đơn hàng " + orderId + " được gửi qua Giao Hàng Nhanh.");
    }
}
