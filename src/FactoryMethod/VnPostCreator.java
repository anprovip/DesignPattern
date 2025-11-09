package FactoryMethod;

public class VnPostCreator extends ShippingCreator {
    @Override
    public ShippingProvider createShippingProvider() {
        return new VnPost();
    }
}
