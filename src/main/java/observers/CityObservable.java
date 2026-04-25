package observers;

import game.City;

public interface CityObservable {
    void addObserver(CityObserver observer);
    void removeObserver(CityObserver observer);
}