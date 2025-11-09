package Strategy;

// ConcreteStrategy 1: Giảm giá theo phần trăm
public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - percentage / 100);
    }

    @Override
    public String getDescription() {
        return "Giảm " + percentage + "%";
    }
}
