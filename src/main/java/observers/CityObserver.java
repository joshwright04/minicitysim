package observers;

import game.MiniCitySim;

public interface CityObserver {
    void onCityChanged(MiniCitySim miniCitySim);
}