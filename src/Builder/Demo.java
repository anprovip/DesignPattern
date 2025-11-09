package Builder;

public class Demo {
    public static void main(String[] args) {
        Director d1 = new Director(new SmallHouseBuilder());
        Director d2 = new Director(new LuxuryVillaBuilder());

        House house1 = d1.construct();
        House house2 = d2.construct();

        System.out.println("Nhà cấp 4: " + house1);
        System.out.println("Biệt thự: " + house2);
    }
}
