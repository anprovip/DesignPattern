package Builder;

class Director {
    private HouseBuilder builder;

    public Director(HouseBuilder builder) {
        this.builder = builder;
    }

    public House construct() {
        builder.buildWalls();
        builder.buildRoof();
        builder.buildWindows();
        builder.buildDoors();
        return builder.getHouse();
    }
}

