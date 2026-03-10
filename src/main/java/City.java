public class City {
    private Double money;
    private int population;
    private CityMap map;

    public City(CityMap map){
        this.map = map;
        this.money = 1000.00;
        this.population = 1;
    }

    public void place(Placeable object, Position position){
        Tile tile = map.getTile(position);

        if (tile.isEmpty()){
            if(money >= object.getBuildCost()){
                tile.setObject(object);
            }
        }
    }

    public void addMoney(int amount){
        if(amount <= 0) throw new IllegalArgumentException("addMoney cannot accept negative numbers");
        this.money += amount;
    }
    public void deductMoney(int amount){
        if(amount <= 0) throw new IllegalArgumentException("deductMoney cannot accept negative numbers");
        this.money -= amount;
    }

    public CityMap getMap(){ return this.map; }

}
