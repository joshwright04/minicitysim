package game;

public class Apartment {
    private final String unitName;
    private boolean occupied;
    private int rent;

    public Apartment(String unitName, int rent) {
        this.unitName = unitName;
        this.rent = rent;
        this.occupied = false;
    }

    public String getUnitName() {
        return unitName;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int collectRent() {
        return occupied ? rent : 0;
    }
}