package Command;

class AddToCartCommand implements Command {
    private ShoppingCart cart;
    private String productId;
    private int quantity;

    public AddToCartCommand(ShoppingCart cart, String productId, int quantity) {
        this.cart = cart;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        cart.addItem(productId, quantity);
    }

    @Override
    public void undo() {
        cart.removeItem(productId);
    }
}
