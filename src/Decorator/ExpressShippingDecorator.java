package Decorator;

// ConcreteDecorator 3 - Vận chuyển nhanh
public class ExpressShippingDecorator extends OrderDecorator {
    private double shippingCost;

    public ExpressShippingDecorator(Order decoratedOrder, double shippingCost) {
        super(decoratedOrder);
        this.shippingCost = shippingCost;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + ", Express Shipping";
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost() + shippingCost;
    }
}
