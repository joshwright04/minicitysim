package game;

public class House extends Building{
    static final int HOUSE_BUILD_COST = 20;
    static final int INCOME_RATE = 5;
    public House(String name){
        this.name = name;
        this.buildCost = HOUSE_BUILD_COST;
    }

    @Override
    public void onTick(City city) {
        city.addMoney(INCOME_RATE);
    }
}
