package Facade.Subsystem;

public class InventoryService {
    public boolean checkInventory(String productId, int quantity) {
        System.out.println("Kiểm tra tồn kho cho sản phẩm: " + productId + ", số lượng: " + quantity);
        // Giả lập kiểm tra tồn kho
        boolean available = Math.random() > 0.1; // 90% có hàng
        System.out.println("Kết quả kiểm tra tồn kho: " + (available ? "CÓ HÀNG" : "HẾT HÀNG"));
        return available;
    }

    public void updateInventory(String productId, int quantity) {
        System.out.println("Cập nhật tồn kho: Giảm " + quantity + " sản phẩm " + productId);
    }
}