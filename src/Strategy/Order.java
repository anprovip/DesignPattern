package Strategy;

public class Order {
    private double totalAmount;
    private DiscountStrategy discountStrategy; // Giữ tham chiếu đến 1 Strategy

    public Order(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Cho phép thay đổi Strategy lúc runtime
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Tính giá cuối cùng
    public double getFinalPrice() {
        if (discountStrategy != null) {
            return discountStrategy.applyDiscount(totalAmount);
        }
        return totalAmount; // Không có giảm giá
    }
}
