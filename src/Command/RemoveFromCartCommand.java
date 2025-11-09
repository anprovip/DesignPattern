package Command;

class RemoveFromCartCommand implements Command {
    private ShoppingCart cart;
    private String productId;
    private int removedQuantity;
    private boolean wasExecuted = false;

    public RemoveFromCartCommand(ShoppingCart cart, String productId) {
        this.cart = cart;
        this.productId = productId;
    }

    @Override
    public void execute() {
        // Trong thực tế, bạn sẽ lưu số lượng trước khi xóa để undo
        // Ở đây đơn giản hóa bằng cách chỉ xóa
        cart.removeItem(productId);
        wasExecuted = true;
    }

    @Override
    public void undo() {
        if (wasExecuted) {
            // Trong thực tế, bạn sẽ khôi phục với số lượng đã lưu
            cart.addItem(productId, 1); // Giả sử mỗi lần xóa là 1 sản phẩm
        }
    }
}
