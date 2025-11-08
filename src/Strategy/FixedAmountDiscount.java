package Strategy;

public class FixedAmountDiscount implements DiscountStrategy {
    private double fixedAmount;

    public FixedAmountDiscount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return Math.max(0, totalAmount - fixedAmount);
    }
}
