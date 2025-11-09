package Observer;

// ConcreteObserver - Khách hàng
public class Customer implements Observer {
    private String customerName;
    private String email;

    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(String productName, String status) {
        // Gửi email thông báo
        sendEmailNotification(productName, status);
    }

    private void sendEmailNotification(String productName, String status) {
        System.out.println("=== EMAIL THÔNG BÁO ===");
        System.out.println("Gửi đến: " + email);
        System.out.println("Xin chào " + customerName + ",");
        System.out.println("Sản phẩm '" + productName + "' đã thay đổi trạng thái: " + status);

        if ("In Stock".equals(status)) {
            System.out.println("Sản phẩm đã có hàng trở lại! Hãy nhanh chóng đặt mua.");
        }
    }
}
