package observers;

public interface CityObservable {
    void addObserver(CityObserver observer);
    void removeObserver(CityObserver observer);
}