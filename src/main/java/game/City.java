package game;

import observers.CityObservable;
import observers.CityObserver;

import java.util.ArrayList;
import java.util.List;

public class City implements CityObservable {
    private Double money;
    private int population;
    private CityMap map;
    private List<CityObserver> observers = new ArrayList<>();

    public City(CityMap map){
        this.map = map;
        this.money = 1000.00;
        this.population = 1;
    }

    public boolean place(Placeable object, Position position){
        Tile tile = map.getTile(position);

        if (tile.isEmpty()){
            if(money >= object.getBuildCost()){
                tile.setObject(object);
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
        if(amount <= 0) throw new IllegalArgumentException("addMoney cannot accept negative numbers");
        this.money += amount;
    }
    public void deductMoney(int amount){
        if(amount <= 0) throw new IllegalArgumentException("deductMoney cannot accept negative numbers");
        this.money -= amount;
    }
    public Double getMoney() { return this.money; }

    public CityMap getMap(){ return this.map; }

    public void tick(){
        for (Tile[] row : map.getGrid()){
            for(Tile tile : row){
                if(tile.isEmpty()) continue;
                tile.getObject().onTick(this);
            }
        }
        notifyObservers();
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
