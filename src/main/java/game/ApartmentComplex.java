package game;

import java.util.ArrayList;
import java.util.List;

public class ApartmentComplex extends Building {

    private final List<Apartment> apartments;

    public ApartmentComplex(String name) {
        super(name, 120);
        apartments = new ArrayList<>();

        apartments.add(new Apartment("Unit 1", 10));
        apartments.add(new Apartment("Unit 2", 10));
        apartments.add(new Apartment("Unit 3", 10));
    }

    @Override
    public int getIncomeRate() {
        int total = 0;
        for (Apartment a : apartments) {
            total += a.collectRent();
        }
        return total;
    }

    @Override
    public void onTick(City city) {
        city.addMoney(getIncomeRate());
    }

    @Override
    public String getSymbol() {
        return "A";
    }
}