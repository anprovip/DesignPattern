package Builder;

class SmallHouseBuilder implements HouseBuilder {
    private House house = new House();

    public void buildWalls() { house.setWalls("Tường gạch"); }
    public void buildRoof() { house.setRoof("Mái ngói"); }
    public void buildWindows() { house.setWindows("2 cửa sổ"); }
    public void buildDoors() { house.setDoors("1 cửa gỗ"); }

    public House getHouse() { return house; }
}
