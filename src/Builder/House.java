package Builder;

class House {
    private String walls;
    private String roof;
    private String windows;
    private String doors;
    public void setWalls(String walls) { this.walls = walls; }
    public void setRoof(String roof) { this.roof = roof; }
    public void setWindows(String windows) { this.windows = windows; }
    public void setDoors(String doors) { this.doors = doors; }
    @Override
    public String toString() {
        return "House [walls=" + walls + ", roof=" + roof + ", windows=" + windows + ", doors=" + doors + "]";
    }
}

