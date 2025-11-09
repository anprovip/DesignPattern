package Command;

import java.sql.SQLOutput;

public class CommandPatternDemo {
    public static void main(String[] args) {
        // Tạo Receiver
        ShoppingCart cart = new ShoppingCart();

        // Tạo Invoker
        CartManager cartManager = new CartManager();

        // Hiển thị giỏ hàng ban đầu
        cart.displayCart();

        // Thêm sản phẩm vào giỏ hàng
        Command addCommand1 = new AddToCartCommand(cart, "PROD001", 2);
        cartManager.executeCommand(addCommand1);

        Command addCommand2 = new AddToCartCommand(cart, "PROD002", 1);
        cartManager.executeCommand(addCommand2);

        cart.displayCart();

        // Cập nhật số lượng
        Command updateCommand = new UpdateQuantityCommand(cart, "PROD001", 5);
        cartManager.executeCommand(updateCommand);
        cart.displayCart();

        // Hoàn tác hành động cuối cùng (cập nhật số lượng)
        cartManager.undoLastCommand();
        cart.displayCart();

//        // Hoàn tác tiếp (xóa sản phẩm vừa thêm)
//        cartManager.undoLastCommand();
//        cart.displayCart();
//
//        // Thử hoàn tác khi không còn hành động nào
//        cartManager.undoLastCommand();

        // Hiển thị lịch sử
        System.out.println("\n=== LỊCH SỬ COMMANDS ===");
        cartManager.showHistory();
    }
}
