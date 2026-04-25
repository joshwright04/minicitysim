package game;

import game.building.Building;
import game.building.BuildingFactory;
import game.building.Placeable;
import observers.CityObservable;
import observers.CityObserver;

import java.util.ArrayList;
import java.util.List;

public class City implements CityObservable {
    private static final int ROCK_DEMOLITION_COST = 100;
    private static final int BUILDING_DEMOLITION_COST = 150;

    public boolean running;
    private Double money;
    private final CityMap map;
    private final List<CityObserver> observers = new ArrayList<>();
    private final BuildingFactory buildingFactory = new BuildingFactory();

    public City(CityMap map){
        this.map = map;
        this.money = 1000.00;
        this.running = true;
    }

    public boolean place(String buildingName, Position position) {
        Tile tile = map.getTile(position);
        if(!tile.isEmpty() || tile.getTerrainType() != TerrainType.LAND) { return false; }

        Building building = switch (buildingName) {
            case "Cottage" -> buildingFactory.createCottage("Cottage");
            case "House" -> buildingFactory.createHouse("House");
            case "Mansion" -> buildingFactory.createMansion("Mansion");
            case "Farm" -> buildingFactory.createFarm("Farm");
            case "Factory" -> buildingFactory.createFactory("Factory");
            case "Budget Apartment Complex" -> buildingFactory.createBudgetApartmentComplex();
            case "Mid-Tier Apartment Complex" -> buildingFactory.createMidTierApartmentComplex();
            case "Luxury Apartment Complex" -> buildingFactory.createLuxuryApartmentComplex();
            default -> null;
        };

        if(building == null){ return false; }

        return place(building, position);
    }

    public boolean place(Placeable object, Position position) {
        Tile tile = map.getTile(position);
        if(money >= object.getBuildCost()){
            tile.setObject(object);
            deductMoney(object.getBuildCost());
            notifyObservers();
            return true;
        }
        return false;
    }

    public boolean demolish(Position position){
        Tile tile = map.getTile(position);

        if(tile.getTerrainType() == TerrainType.ROCK){
            tile.setTerrain(TerrainType.LAND);
            deductMoney(ROCK_DEMOLITION_COST);
            notifyObservers();
            return true;
        }

        if (tile.isEmpty()){
            return false;
        }

        tile.setObject(null);
        deductMoney(BUILDING_DEMOLITION_COST);
        notifyObservers();
        return true;
    }

    public void addMoney(int amount){
        if(amount < 0) throw new IllegalArgumentException("addMoney cannot accept negative numbers");
        this.money += amount;
    }
    public void deductMoney(int amount){
        if(amount < 0) throw new IllegalArgumentException("deductMoney cannot accept negative numbers");
        this.money -= amount;
    }
    public Double getMoney() { return this.money; }

    public CityMap getMap() { return this.map; }

    public void tick() {
        if(running) {
            for (Tile[] row : map.getGrid()){
                for(Tile tile : row){
                    if(tile.isEmpty()) continue;
                    tile.getObject().onTick(this);
                }
            }
            notifyObservers();
        }
    }

    public void addObserver(CityObserver observer){
        observers.add(observer);
    }
    public void removeObserver(CityObserver observer){
        observers.remove(observer);
    }
    private void notifyObservers(){
        for(CityObserver observer : observers){
            observer.onCityChanged(this);
        }
    }

    public void printGrid() { map.printGrid(); }
}
