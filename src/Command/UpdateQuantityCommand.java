package Command;

// ConcreteCommand - Update Quantity
class UpdateQuantityCommand implements Command {
    private ShoppingCart cart;
    private String productId;
    private int newQuantity;
    private int oldQuantity;
    private boolean wasExecuted = false;

    public UpdateQuantityCommand(ShoppingCart cart, String productId, int newQuantity) {
        this.cart = cart;
        this.productId = productId;
        this.newQuantity = newQuantity;
    }

    @Override
    public void execute() {
        // Lưu số lượng cũ trước khi cập nhật
        // Trong thực tế, bạn sẽ truy vấn số lượng hiện tại từ cart
        this.oldQuantity = 1; // Giả sử số lượng cũ là 1
        cart.updateQuantity(productId, newQuantity);
        wasExecuted = true;
    }

    @Override
    public void undo() {
        if (wasExecuted) {
            cart.updateQuantity(productId, oldQuantity);
        }
    }
}
