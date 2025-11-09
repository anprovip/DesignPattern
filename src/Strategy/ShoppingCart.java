package Strategy;

// Context class
public class ShoppingCart {
    private double totalAmount;
    private DiscountStrategy discountStrategy;
    private String cartName;

    public ShoppingCart(String cartName, double totalAmount) {
        this.cartName = cartName;
        this.totalAmount = totalAmount;
        this.discountStrategy = new NoDiscount(); // Mặc định không giảm giá
    }

    // Set strategy tại runtime
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Tính tổng tiền sau khi áp dụng chiến lược giảm giá
    public double calculateTotal() {
        return discountStrategy.applyDiscount(totalAmount);
    }

    // Hiển thị thông tin hóa đơn
    public void displayInvoice() {
        double finalAmount = calculateTotal();
        System.out.println("=== " + cartName + " ===");
        System.out.println("Tổng tiền: " + totalAmount + "K");
        System.out.println("Chiến lược giảm giá: " + discountStrategy.getDescription());
        System.out.println("Tiền sau giảm: " + finalAmount + "K");
        System.out.println("------------------------");
    }

    // Getter cho totalAmount (cho phép Strategy truy cập nếu cần)
    public double getTotalAmount() {
        return totalAmount;
    }
}
