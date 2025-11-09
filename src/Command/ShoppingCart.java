package Command;

class ShoppingCart {
    private java.util.Map<String, Integer> items = new java.util.HashMap<>();

    public void addItem(String productId, int quantity) {
        items.put(productId, items.getOrDefault(productId, 0) + quantity);
        System.out.println("Đã thêm " + quantity + " sản phẩm " + productId +
                ". Tổng: " + items.get(productId));
    }

    public void removeItem(String productId) {
        if (items.containsKey(productId)) {
            int removedQuantity = items.remove(productId);
            System.out.println("Đã xóa sản phẩm " + productId +
                    " (số lượng: " + removedQuantity + ")");
        } else {
            System.out.println("Sản phẩm " + productId + " không tồn tại trong giỏ hàng");
        }
    }

    public void updateQuantity(String productId, int newQuantity) {
        if (items.containsKey(productId)) {
            int oldQuantity = items.get(productId);
            items.put(productId, newQuantity);
            System.out.println("Đã cập nhật " + productId +
                    " từ " + oldQuantity + " thành " + newQuantity);
        } else {
            System.out.println("Sản phẩm " + productId + " không tồn tại trong giỏ hàng");
        }
    }

    public void displayCart() {
        System.out.println("\n--- GIỎ HÀNG HIỆN TẠI ---");
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống");
        } else {
            items.forEach((productId, quantity) ->
                    System.out.println("- " + productId + ": " + quantity));
        }
        System.out.println("------------------------\n");
    }
}