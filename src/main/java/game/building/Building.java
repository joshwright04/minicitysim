package game.building;

import game.City;

public abstract class Building implements Placeable {

    String name;
    private final int buildCost;

    public Building(String name, int buildCost){
        this.name = name;
        this.buildCost = buildCost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBuildCost() {
        return buildCost;
    }

    @Override
    public abstract void onTick(City city);

    @Override
    public abstract String getSymbol();

    public abstract int getIncomeRate();
}
