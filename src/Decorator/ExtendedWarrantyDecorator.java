package Decorator;

// ConcreteDecorator 2 - Bảo hành mở rộng
public class ExtendedWarrantyDecorator extends OrderDecorator {
    private double warrantyCost;

    public ExtendedWarrantyDecorator(Order decoratedOrder, double warrantyCost) {
        super(decoratedOrder);
        this.warrantyCost = warrantyCost;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + ", Extended Warranty (2 years)";
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost() + warrantyCost;
    }
}
