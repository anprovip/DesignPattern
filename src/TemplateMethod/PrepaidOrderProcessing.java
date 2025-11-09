package TemplateMethod;

 // Concrete class xử lý đơn hàng Pre-paid
public class PrepaidOrderProcessing extends OrderProcessingTemplate {

    @Override
    protected void processPayment() {
        System.out.println("Pre-paid payment completed successfully");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Order shipped with expedited delivery");
    }
}
