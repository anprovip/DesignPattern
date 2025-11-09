package TemplateMethod;

//Concrete class xử lý đơn hàng COD (Cash On Delivery)
public class CODOrderProcessing extends OrderProcessingTemplate {

    @Override
    protected void processPayment() {
        System.out.println("COD payment processed successfully");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Order shipped with COD option");
    }
}
