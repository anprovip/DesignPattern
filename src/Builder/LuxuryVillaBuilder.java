package Builder;

class LuxuryVillaBuilder implements HouseBuilder {
    private House house = new House();

    public void buildWalls() { house.setWalls("Tường đá cẩm thạch"); }
    public void buildRoof() { house.setRoof("Mái kính"); }
    public void buildWindows() { house.setWindows("10 cửa sổ thông minh"); }
    public void buildDoors() { house.setDoors("3 cửa tự động"); }

    public House getHouse() { return house; }
}

