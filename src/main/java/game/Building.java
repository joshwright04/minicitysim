package game;

public abstract class Building implements Placeable {

    String name;
    int buildCost;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBuildCost() {
        return this.buildCost;
    }

    @Override
    public abstract void onTick(City city);
}
