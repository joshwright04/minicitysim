package game.building;

import game.City;

public interface Placeable {
    public String getName();
    public int getBuildCost();
    public void onTick(City city);
    public String getSymbol();
}
