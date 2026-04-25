package game;

import game.building.Building;
import game.building.BuildingFactory;
import game.building.Placeable;
import observers.CityObservable;
import observers.CityObserver;

import java.util.ArrayList;
import java.util.List;

public class City implements CityObservable {
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
        Building building = switch (buildingName) {
            case "Cottage" -> buildingFactory.createCottage("Cottage");
            case "House" -> buildingFactory.createHouse("House");
            case "Mansion" -> buildingFactory.createMansion("Mansion");
            case "Farm" -> buildingFactory.createFarm("Farm");
            case "Factory" -> buildingFactory.createFactory("Factory");
            case "Apartment Complex" -> buildingFactory.createMidTierApartmentComplex("Apartments");
            default -> null;
        };

        return place(building, position);
    }

    public boolean place(Placeable object, Position position){
        Tile tile = map.getTile(position);

        if (tile.isEmpty()){
            if(money >= object.getBuildCost()){
                tile.setObject(object);
                deductMoney(object.getBuildCost());
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public boolean demolish(Position position){
        Tile tile = map.getTile(position);

        if (tile.isEmpty()){
            return false;
        }
        tile.setObject(null);
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
