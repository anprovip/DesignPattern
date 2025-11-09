package Strategy;

// Demo class
public class StrategyPatternDemo {
    public static void main(String[] args) {
        // Tạo giỏ hàng với tổng tiền 500K
        ShoppingCart cart = new ShoppingCart("Đơn hàng #001", 500);

        System.out.println("=== DEMO STRATEGY PATTERN - HỆ THỐNG GIẢM GIÁ ===\n");

        // Sử dụng chiến lược giảm giá 10%
        cart.setDiscountStrategy(new PercentageDiscount(10));
        cart.displayInvoice();

        // Sử dụng chiến lược giảm giá cố định 100K
        cart.setDiscountStrategy(new FixedAmountDiscount(100));
        cart.displayInvoice();

        // Sử dụng chiến lược mua 1 tặng 1
        cart.setDiscountStrategy(new BuyOneGetOne());
        cart.displayInvoice();

        // Không giảm giá
        cart.setDiscountStrategy(new NoDiscount());
        cart.displayInvoice();

//        // Demo với các giỏ hàng khác nhau
//        System.out.println("\n=== DEMO VỚI NHIỀU GIỎ HÀNG ===");
//
//        ShoppingCart cart1 = new ShoppingCart("Đơn hàng #002", 300);
//        cart1.setDiscountStrategy(new PercentageDiscount(15));
//        cart1.displayInvoice();
//
//        ShoppingCart cart2 = new ShoppingCart("Đơn hàng #003", 800);
//        cart2.setDiscountStrategy(new FixedAmountDiscount(200));
//        cart2.displayInvoice();
    }
}
