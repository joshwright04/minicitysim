package observers;

import game.City;

public interface CityObserver {
    void onCityChanged(City city);
}