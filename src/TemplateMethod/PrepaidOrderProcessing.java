package TemplateMethod;

// Concrete class xử lý đơn hàng Pre-paid
public class PrepaidOrderProcessing extends OrderProcessingTemplate {

    @Override
    protected void prepareShipment() {
        // Prepaid: Process payment trước, rồi reserve stock
        processPayment();
        reserveStock();
    }

    @Override
    protected void shipOrder() {
        System.out.println("Order shipped with expedited delivery");
    }

    @Override
    protected void finalizePayment() {
        // Prepaid: Không cần collect payment (đã trả trước)
        // Có thể để empty hoặc log gì đó nếu cần
    }

    /**
     * Helper: Process payment cho Prepaid - CỐ ĐỊNH trong subclass này
     */
    private void processPayment() {
        System.out.println("Pre-paid payment completed successfully");
    }
}