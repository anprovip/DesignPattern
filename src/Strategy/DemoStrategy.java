package Strategy;

public class DemoStrategy {
    public static void main(String[] args) {
        Order order = new Order(1000000); // Đơn hàng 1,000,000 VND
        System.out.println("Tổng tiền: " + order.getTotalAmount());
        // Kịch bản 1: Giảm giá Black Friday (30%)
        order.setDiscountStrategy(new PercentageDiscount(30));
        System.out.println("Giá Black Friday: " + order.getFinalPrice()); // Output: 700000.0

        // Kịch bản 2: Dùng voucher giảm 100k
        order.setDiscountStrategy(new FixedAmountDiscount(100000));
        System.out.println("Giá dùng Voucher 100k: " + order.getFinalPrice()); // Output: 900000.0
    }
}
