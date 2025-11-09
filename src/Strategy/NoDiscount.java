package Strategy;

// Strategy mặc định - không giảm giá
public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice;
    }

    @Override
    public String getDescription() {
        return "Không giảm giá";
    }
}
