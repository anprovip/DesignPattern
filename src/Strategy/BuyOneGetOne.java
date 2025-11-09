package Strategy;

// ConcreteStrategy 3: Mua 1 tặng 1
public class BuyOneGetOne implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalPrice) {
        // Giả sử mua 1 tặng 1, chỉ tính tiền 1 sản phẩm
        return originalPrice / 2;
    }

    @Override
    public String getDescription() {
        return "Mua 1 tặng 1";
    }
}
