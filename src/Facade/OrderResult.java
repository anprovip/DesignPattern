package Facade;

// Kết quả đặt hàng
public class OrderResult {
    private boolean success;
    private String trackingNumber;
    private String message;

    public OrderResult(boolean success, String trackingNumber, String message) {
        this.success = success;
        this.trackingNumber = trackingNumber;
        this.message = message;
    }

    // Getters
    public boolean isSuccess() { return success; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getMessage() { return message; }
}

