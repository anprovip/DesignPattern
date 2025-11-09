package Observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO MẪU OBSERVER - PRODUCT NOTIFIER ===\n");

        // Tạo sản phẩm (Subject)
        Product iphone = new Product("iPhone 15 Pro");

        // Tạo các khách hàng (Observers)
        Customer customer1 = new Customer("Nguyễn Văn A", "nguyenvana@email.com");
        Customer customer2 = new Customer("Trần Thị B", "tranthib@email.com");

        // Đăng ký theo dõi sản phẩm
        System.out.println("\n--- ĐĂNG KÝ THEO DÕI ---");
        iphone.registerObserver(customer1);
        iphone.registerObserver(customer2);

        // Thay đổi trạng thái sản phẩm - chưa có hàng
        System.out.println("\n--- THAY ĐỔI TRẠNG THÁI 1 ---");
        iphone.setStatus("Out of Stock");

        // Hủy đăng ký một khách hàng
        System.out.println("\n--- HỦY ĐĂNG KÝ ---");
        iphone.removeObserver(customer2);

        // Sản phẩm có hàng trở lại - thông báo đến các khách hàng đã đăng ký
        System.out.println("\n--- THAY ĐỔI TRẠNG THÁI 2 ---");
        iphone.setStatus("In Stock");

        // Thêm khách hàng mới đăng ký
        System.out.println("\n--- ĐĂNG KÝ MỚI ---");
        Customer customer4 = new Customer("Phạm Thị D", "phamthid@email.com");
        iphone.registerObserver(customer4);

        // Thay đổi trạng thái lần nữa
        System.out.println("\n--- THAY ĐỔI TRẠNG THÁI 3 ---");
        iphone.setStatus("Limited Stock");
    }
}
