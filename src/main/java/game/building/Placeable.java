package game.building;

import game.MiniCitySim;

public interface Placeable {
    public String getName();
    public int getBuildCost();
    public void onTick(MiniCitySim miniCitySim);
    String getImagePath();
}
