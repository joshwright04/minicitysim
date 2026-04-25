package game.building.apartment;

import game.building.Building;
import game.City;
import game.building.RealEstate;

import java.util.ArrayList;
import java.util.List;

public class ApartmentComplex extends Building implements RealEstate {
    private static final String DEFAULT_APARTMENT_COMPLEX_NAME = "Complex Living";

    public static ApartmentComplexBuilder getNewBuilder(ApartmentFactory apartmentFactory) {
        return new ApartmentComplexBuilder(apartmentFactory);
    }

    public static class ApartmentComplexBuilder {
        private final List<Apartment> apartments = new ArrayList<>();
        private final ApartmentFactory apartmentFactory;

        private ApartmentComplexBuilder(ApartmentFactory apartmentFactory) {
            this.apartmentFactory = apartmentFactory;
        }

        public ApartmentComplexBuilder addLuxuryApartment() {
            apartments.add(apartmentFactory.createLuxuryApartment());
            return this;
        }

        public ApartmentComplexBuilder addStandardApartment() {
            apartments.add(apartmentFactory.createStandardApartment());
            return this;
        }

        public ApartmentComplexBuilder addBudgetApartment() {
            apartments.add(apartmentFactory.createBudgetApartment());
            return this;
        }

        public ApartmentComplex build() {
            if (apartments.isEmpty()) {
                throw new IllegalArgumentException("Cannot create an Apartment Complex with 0 Apartments!");
            }

            int totalBuildCost = 0;
            for (Apartment apartment : apartments) {
                totalBuildCost += apartment.getBuildCost();
            }

            return new ApartmentComplex(
                    DEFAULT_APARTMENT_COMPLEX_NAME,
                    totalBuildCost,
                    apartments
            );
        }
    }

    private final List<Apartment> apartments;

    private ApartmentComplex(String name, int buildCost, List<Apartment> apartments) {
        super(name, buildCost);
        this.apartments = new ArrayList<>(apartments);
    }

    private void addApartment(Apartment apartmentToAdd) {
        apartments.add(apartmentToAdd);
    }

    public int size() {
        return apartments.size();
    }

    @Override
    public int collectRent() {
        int total = 0;

        for (Apartment apartment : apartments) {
            total += apartment.collectRent();
        }

        return total;
    }

    @Override
    public int getIncomeRate() {
        return collectRent();
    }

    @Override
    public void onTick(City city) {
        city.addMoney(collectRent());
    }

    @Override
    public String getImagePath() {
        return "/images/apartment_complex.jpg";
    }
}