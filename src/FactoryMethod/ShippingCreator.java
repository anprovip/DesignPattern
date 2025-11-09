package FactoryMethod;

public abstract class ShippingCreator {
    // Factory Method
    public abstract ShippingProvider createShippingProvider();

    // Một hành vi dùng Product
    public void shipOrder(String orderId) {
        ShippingProvider provider = createShippingProvider();
        provider.ship(orderId);
    }
}
