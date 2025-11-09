package TemplateMethod;

// Concrete class xử lý đơn hàng COD (Cash On Delivery)
public class CODOrderProcessing extends OrderProcessingTemplate {

    @Override
    protected void prepareShipment() {
        // COD: Chỉ reserve stock trước ship (không process payment trước)
        reserveStock();
    }

    @Override
    protected void shipOrder() {
        System.out.println("Order shipped with COD option");
    }

    @Override
    protected void finalizePayment() {
        // COD: Collect payment sau ship
        System.out.println("COD payment collected successfully");
    }
}