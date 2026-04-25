package game;

import java.util.ArrayList;
import java.util.List;

public class ApartmentComplex extends Building {
    private static final String DEFAULT_APARTMENT_COMPLEX_NAME = "Complex Living";

    public static ApartmentComplexBuilder getNewBuilder(ApartmentFactory apartmentFactory) {
        return new ApartmentComplexBuilder(apartmentFactory);
    }

    public static class ApartmentComplexBuilder {
        final ApartmentComplex apartmentComplex = new ApartmentComplex(DEFAULT_APARTMENT_COMPLEX_NAME);
        private final ApartmentFactory apartmentFactory;

        private ApartmentComplexBuilder(ApartmentFactory apartmentFactory) {
            this.apartmentFactory = apartmentFactory;
        }

        public ApartmentComplexBuilder addLuxuryApartment() {
            Apartment newLuxuryApartment = apartmentFactory.createLuxuryApartment();
            apartmentComplex.addApartment(newLuxuryApartment);
            return this;
        }

        public ApartmentComplexBuilder addStandardApartment() {
            Apartment newStandardApartment = apartmentFactory.createStandardApartment();
            apartmentComplex.addApartment(newStandardApartment);
            return this;
        }

        public ApartmentComplexBuilder addBudgetApartment() {
            Apartment newBudgetApartment = apartmentFactory.createBudgetApartment();
            apartmentComplex.addApartment(newBudgetApartment);
            return this;
        }

        public ApartmentComplex build() {
            if (apartmentComplex.size() == 0) {
                throw new IllegalArgumentException("Cannot Create an Apartment Complex with 0 Apartments!");
            }
            return apartmentComplex;
        }

    }

    private final List<Apartment> apartments;

    public ApartmentComplex(String name) {
        super(name, 120);
        apartments = new ArrayList<>();

        apartments.add(new Apartment("Unit 1", 10));
        apartments.add(new Apartment("Unit 2", 10));
        apartments.add(new Apartment("Unit 3", 10));
    }

    private void addApartment(Apartment apartmentToAdd){
        apartments.add(apartmentToAdd);
    }

    public int size(){ return this.apartments.size(); }

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