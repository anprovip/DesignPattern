package Facade;

public class OrderRequest {
    // DTO cho yêu cầu đặt hàng
        private String orderId;
        private String productId;
        private int quantity;
        private double amount;
        private String paymentMethod;
        private String shippingAddress;
        private String customerEmail;

        public OrderRequest(String orderId, String productId, int quantity, double amount,
                            String paymentMethod, String shippingAddress, String customerEmail) {
            this.orderId = orderId;
            this.productId = productId;
            this.quantity = quantity;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.shippingAddress = shippingAddress;
            this.customerEmail = customerEmail;
        }

        // Getters
        public String getOrderId() { return orderId; }
        public String getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getAmount() { return amount; }
        public String getPaymentMethod() { return paymentMethod; }
        public String getShippingAddress() { return shippingAddress; }
        public String getCustomerEmail() { return customerEmail; }
    }

