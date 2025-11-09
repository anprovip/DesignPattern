package FactoryMethod;

public class Demo {
    public static void main(String[] args) {
        ShippingCreator ghnCreator = new GHNCreator();
        ghnCreator.shipOrder("ORD001");

        ShippingCreator vnpostCreator = new VnPostCreator();
        vnpostCreator.shipOrder("ORD002");
    }
}
