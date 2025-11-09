package Decorator;

// ConcreteDecorator 1 - Gói quà
public class GiftWrapDecorator extends OrderDecorator {
    private double wrapCost;

    public GiftWrapDecorator(Order decoratedOrder, double wrapCost) {
        super(decoratedOrder);
        this.wrapCost = wrapCost;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + ", Gift Wrapped";
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost() + wrapCost;
    }
}



