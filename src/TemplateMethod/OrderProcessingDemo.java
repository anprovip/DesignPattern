package TemplateMethod;

public class OrderProcessingDemo {
    public static void main(String[] args) {

        OrderProcessingTemplate[] orders = {
                new CODOrderProcessing(),
                new PrepaidOrderProcessing(),
                new CODOrderProcessing()
        };

        for (int i = 0; i < orders.length; i++) {
            System.out.println("\nProcessing Order #" + (i + 1));
            orders[i].processOrder();
        }
    }
}
