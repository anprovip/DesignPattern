package Strategy;

// Strategy interface
public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
    String getDescription();
}
