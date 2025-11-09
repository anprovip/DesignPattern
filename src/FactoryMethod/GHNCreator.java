package FactoryMethod;

public class GHNCreator extends ShippingCreator {
    @Override
    public ShippingProvider createShippingProvider() {
        return new GiaoHangNhanh();
    }
}
