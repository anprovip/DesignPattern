package Strategy;

// ConcreteStrategy 2: Giảm giá cố định
public class FixedAmountDiscount implements DiscountStrategy {
    private double discountAmount;

    public FixedAmountDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        double discountedPrice = originalPrice - discountAmount;
        return discountedPrice > 0 ? discountedPrice : 0;
    }

    @Override
    public String getDescription() {
        return "Giảm " + discountAmount + "K";
    }
}